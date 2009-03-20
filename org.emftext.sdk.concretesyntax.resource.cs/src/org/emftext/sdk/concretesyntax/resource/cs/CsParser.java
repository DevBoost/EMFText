// $ANTLR 3.1.1 C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2009-03-20 18:43:01

	package org.emftext.sdk.concretesyntax.resource.cs;
	
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.emf.ecore.InternalEObject;
	import org.eclipse.emf.common.util.URI;
	import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
	import org.emftext.runtime.IOptions;
	import org.emftext.runtime.resource.impl.UnexpectedContentTypeException;
	import org.eclipse.emf.ecore.EClass;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class CsParser extends AbstractEMFTextParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUALIFIED_NAME", "QUOTED_60_62", "QUOTED_34_34", "QUOTED_39_39", "NUMBER", "QUOTED_36_36", "COMMENTS", "WHITESPACE", "LINEBREAK", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'#'", "'!'", "'DEFINE'", "'COLLECT'", "'IN'", "'PREDEFINED'", "'+'", "'*'", "'?'", "'ABSTRACT'"
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
            this.state.ruleMemo = new HashMap[57+1];
             
             
        }
        

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
    	private int lastPosition;
    	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();
    	private org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch referenceResolverSwitch;
    	
    	protected EObject doParse() throws RecognitionException {
    		lastPosition = 0;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = null;
    		if(this.getOptions()!=null)
    		typeObject = this.getOptions().get(IOptions.RESOURCE_CONTENT_TYPE);
    		if(typeObject==null)
    		return start();
    		else if(typeObject instanceof EClass){
    			EClass type = (EClass)typeObject;
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.ConcreteSyntax.class){
    				return concretesyntax();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.Import.class){
    				return keywordimport();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.Option.class){
    				return option();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.Rule.class){
    				return rule();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.Sequence.class){
    				return sequence();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.Choice.class){
    				return choice();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.CsString.class){
    				return csstring();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.DefinedPlaceholder.class){
    				return definedplaceholder();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.DerivedPlaceholder.class){
    				return derivedplaceholder();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.Containment.class){
    				return containment();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.CompoundDefinition.class){
    				return compounddefinition();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.WhiteSpaces.class){
    				return whitespaces();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.LineBreak.class){
    				return linebreak();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.NormalToken.class){
    				return normaltoken();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.PreDefinedToken.class){
    				return predefinedtoken();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.PLUS.class){
    				return plus();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.STAR.class){
    				return star();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.QUESTIONMARK.class){
    				return questionmark();
    			}
    			if(type.getInstanceClass()==org.emftext.sdk.concretesyntax.Abstract.class){
    				return keywordabstract();
    			}
    		}
    		throw new org.emftext.runtime.resource.impl.UnexpectedContentTypeException(typeObject);
    	}
    	
    	@SuppressWarnings("unchecked")
    	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
    		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
    	}
    	
    	private org.emftext.runtime.resource.impl.TokenResolveResult getFreshTokenResolveResult() {
    		tokenResolveResult.clear();
    		return tokenResolveResult;
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	public void setReferenceResolverSwitch(org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch referenceResolverSwitch) {
    		this.referenceResolverSwitch = referenceResolverSwitch;
    	}



    // $ANTLR start "start"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:129:1: start returns [ EObject element = null] : (c0= concretesyntax ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:130:1: ( (c0= concretesyntax ) EOF )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:131:2: (c0= concretesyntax ) EOF
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:131:2: (c0= concretesyntax )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:132:3: c0= concretesyntax
            {
            pushFollow(FOLLOW_concretesyntax_in_start79);
            c0=concretesyntax();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start86); if (state.failed) return element;

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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:137:1: concretesyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : ( (a0_0= keywordabstract ) )? a1= 'SYNTAXDEF' (a2= QUALIFIED_NAME ) a3= 'FOR' (a4= QUOTED_60_62 ) ( ( (a5= QUOTED_60_62 ) ) )? ( (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* ) )? ( (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( ( (a26_0= rule ) )+ ) a27= '}' ;
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
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:140:1: ( ( (a0_0= keywordabstract ) )? a1= 'SYNTAXDEF' (a2= QUALIFIED_NAME ) a3= 'FOR' (a4= QUOTED_60_62 ) ( ( (a5= QUOTED_60_62 ) ) )? ( (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* ) )? ( (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( ( (a26_0= rule ) )+ ) a27= '}' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:141:2: ( (a0_0= keywordabstract ) )? a1= 'SYNTAXDEF' (a2= QUALIFIED_NAME ) a3= 'FOR' (a4= QUOTED_60_62 ) ( ( (a5= QUOTED_60_62 ) ) )? ( (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* ) )? ( (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( ( (a26_0= rule ) )+ ) a27= '}'
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:141:2: ( (a0_0= keywordabstract ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==43) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:142:3: (a0_0= keywordabstract )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:142:3: (a0_0= keywordabstract )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:143:4: a0_0= keywordabstract
                    {
                    pushFollow(FOLLOW_keywordabstract_in_concretesyntax118);
                    a0_0=keywordabstract();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				if (a0_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER), a0_0);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos(a0_0, element); 			
                    }

                    }


                    }
                    break;

            }

            a1=(Token)match(input,13,FOLLOW_13_in_concretesyntax141); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:163:2: (a2= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:164:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax156); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
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
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a2, element);
              		
            }

            }

            a3=(Token)match(input,14,FOLLOW_14_in_concretesyntax174); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a3, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:194:2: (a4= QUOTED_60_62 )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:195:3: a4= QUOTED_60_62
            {
            a4=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax189); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
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
              			org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
              			collectHiddenTokens(element);
              			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(referenceResolverSwitch.getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a4, element);
              			copyLocalizationInfos((CommonToken) a4, proxy);
              		
            }

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:221:2: ( ( (a5= QUOTED_60_62 ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==QUOTED_60_62) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:3: ( (a5= QUOTED_60_62 ) )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:3: ( (a5= QUOTED_60_62 ) )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:223:4: (a5= QUOTED_60_62 )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:223:4: (a5= QUOTED_60_62 )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:224:5: a5= QUOTED_60_62
                    {
                    a5=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax222); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
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
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a5, element);
                      				
                    }

                    }


                    }


                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:249:2: ( (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:250:3: (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:250:3: (a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )* )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:251:4: a6= 'START' ( (a7= QUALIFIED_NAME ) ) ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )*
                    {
                    a6=(Token)match(input,15,FOLLOW_15_in_concretesyntax269); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a6, element);
                      			
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:259:4: ( (a7= QUALIFIED_NAME ) )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:260:5: (a7= QUALIFIED_NAME )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:260:5: (a7= QUALIFIED_NAME )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:261:6: a7= QUALIFIED_NAME
                    {
                    a7=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax297); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      						if (element == null) {
                      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
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
                      						org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                      						collectHiddenTokens(element);
                      						getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(referenceResolverSwitch.getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
                      						if (proxy != null) {
                      							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((CommonToken) a7, element);
                      						copyLocalizationInfos((CommonToken) a7, proxy);
                      					
                    }

                    }


                    }

                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:289:4: ( (a8= ',' ( (a9= QUALIFIED_NAME ) ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==16) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:290:5: (a8= ',' ( (a9= QUALIFIED_NAME ) ) )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:290:5: (a8= ',' ( (a9= QUALIFIED_NAME ) ) )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:291:6: a8= ',' ( (a9= QUALIFIED_NAME ) )
                    	    {
                    	    a8=(Token)match(input,16,FOLLOW_16_in_concretesyntax351); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((CommonToken)a8, element);
                    	      					
                    	    }
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:299:6: ( (a9= QUALIFIED_NAME ) )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:300:7: (a9= QUALIFIED_NAME )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:300:7: (a9= QUALIFIED_NAME )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:301:8: a9= QUALIFIED_NAME
                    	    {
                    	    a9=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_concretesyntax387); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      								if (element == null) {
                    	      									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
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
                    	      								org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                    	      								collectHiddenTokens(element);
                    	      								getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(referenceResolverSwitch.getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
                    	      								if (proxy != null) {
                    	      									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy);
                    	      								}
                    	      								collectHiddenTokens(element);
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

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:335:2: ( (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:336:3: (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:336:3: (a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}' )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:337:4: a10= 'IMPORTS' a11= '{' ( ( (a12_0= keywordimport ) ) )* a13= '}'
                    {
                    a10=(Token)match(input,17,FOLLOW_17_in_concretesyntax479); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a10, element);
                      			
                    }
                    a11=(Token)match(input,18,FOLLOW_18_in_concretesyntax494); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a11, element);
                      			
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:353:4: ( ( (a12_0= keywordimport ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==QUALIFIED_NAME) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:354:5: ( (a12_0= keywordimport ) )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:354:5: ( (a12_0= keywordimport ) )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:355:6: (a12_0= keywordimport )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:355:6: (a12_0= keywordimport )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:356:7: a12_0= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax530);
                    	    a12_0=keywordimport();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (element == null) {
                    	      								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      							}
                    	      							if (a12_0 != null) {
                    	      								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS, a12_0);
                    	      							}
                    	      							collectHiddenTokens(element);
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

                    a13=(Token)match(input,19,FOLLOW_19_in_concretesyntax579); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a13, element);
                      			
                    }

                    }


                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:381:2: ( (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:382:3: (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:382:3: (a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}' )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:383:4: a14= 'OPTIONS' a15= '{' ( ( (a16_0= option ) a17= ';' ) )* a18= '}'
                    {
                    a14=(Token)match(input,20,FOLLOW_20_in_concretesyntax613); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a14, element);
                      			
                    }
                    a15=(Token)match(input,18,FOLLOW_18_in_concretesyntax628); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a15, element);
                      			
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:399:4: ( ( (a16_0= option ) a17= ';' ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==QUALIFIED_NAME) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:400:5: ( (a16_0= option ) a17= ';' )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:400:5: ( (a16_0= option ) a17= ';' )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:401:6: (a16_0= option ) a17= ';'
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:401:6: (a16_0= option )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:402:7: a16_0= option
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax664);
                    	    a16_0=option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (element == null) {
                    	      								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      							}
                    	      							if (a16_0 != null) {
                    	      								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS, a16_0);
                    	      							}
                    	      							collectHiddenTokens(element);
                    	      							copyLocalizationInfos(a16_0, element); 						
                    	    }

                    	    }

                    	    a17=(Token)match(input,21,FOLLOW_21_in_concretesyntax695); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((CommonToken)a17, element);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    a18=(Token)match(input,19,FOLLOW_19_in_concretesyntax732); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a18, element);
                      			
                    }

                    }


                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:435:2: ( (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:436:3: (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:436:3: (a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}' )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:437:4: a19= 'TOKENS' a20= '{' ( ( (a21_0= tokendefinition ) a22= ';' ) )* a23= '}'
                    {
                    a19=(Token)match(input,22,FOLLOW_22_in_concretesyntax766); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a19, element);
                      			
                    }
                    a20=(Token)match(input,18,FOLLOW_18_in_concretesyntax781); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a20, element);
                      			
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:453:4: ( ( (a21_0= tokendefinition ) a22= ';' ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==36||LA9_0==39) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:454:5: ( (a21_0= tokendefinition ) a22= ';' )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:454:5: ( (a21_0= tokendefinition ) a22= ';' )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:455:6: (a21_0= tokendefinition ) a22= ';'
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:455:6: (a21_0= tokendefinition )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:456:7: a21_0= tokendefinition
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax817);
                    	    a21_0=tokendefinition();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (element == null) {
                    	      								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      							}
                    	      							if (a21_0 != null) {
                    	      								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS, a21_0);
                    	      							}
                    	      							collectHiddenTokens(element);
                    	      							copyLocalizationInfos(a21_0, element); 						
                    	    }

                    	    }

                    	    a22=(Token)match(input,21,FOLLOW_21_in_concretesyntax848); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((CommonToken)a22, element);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    a23=(Token)match(input,19,FOLLOW_19_in_concretesyntax885); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a23, element);
                      			
                    }

                    }


                    }
                    break;

            }

            a24=(Token)match(input,23,FOLLOW_23_in_concretesyntax910); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a24, element);
              	
            }
            a25=(Token)match(input,18,FOLLOW_18_in_concretesyntax921); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a25, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:505:2: ( ( (a26_0= rule ) )+ )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:506:3: ( (a26_0= rule ) )+
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:506:3: ( (a26_0= rule ) )+
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
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:507:4: (a26_0= rule )
            	    {
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:507:4: (a26_0= rule )
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:508:5: a26_0= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax947);
            	    a26_0=rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (element == null) {
            	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
            	      					}
            	      					if (a26_0 != null) {
            	      						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, a26_0);
            	      					}
            	      					collectHiddenTokens(element);
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

            a27=(Token)match(input,19,FOLLOW_19_in_concretesyntax980); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a27, element);
              	
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:532:1: keywordimport returns [org.emftext.sdk.concretesyntax.Import element = null] : (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? ;
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
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:535:1: ( (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:536:2: (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:536:2: (a0= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:537:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport1010); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
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
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              		
            }

            }

            a1=(Token)match(input,24,FOLLOW_24_in_keywordimport1028); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:567:2: (a2= QUOTED_60_62 )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:568:3: a2= QUOTED_60_62
            {
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport1043); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
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
              			org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
              			collectHiddenTokens(element);
              			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(referenceResolverSwitch.getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a2, element);
              			copyLocalizationInfos((CommonToken) a2, proxy);
              		
            }

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:594:2: ( ( (a3= QUOTED_60_62 ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==QUOTED_60_62) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:595:3: ( (a3= QUOTED_60_62 ) )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:595:3: ( (a3= QUOTED_60_62 ) )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:596:4: (a3= QUOTED_60_62 )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:596:4: (a3= QUOTED_60_62 )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:597:5: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport1076); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
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
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a3, element);
                      				
                    }

                    }


                    }


                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:622:2: ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==25) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:623:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:623:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:624:4: a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )?
                    {
                    a4=(Token)match(input,25,FOLLOW_25_in_keywordimport1123); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a4, element);
                      			
                    }
                    a5=(Token)match(input,26,FOLLOW_26_in_keywordimport1138); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a5, element);
                      			
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:640:4: (a6= QUALIFIED_NAME )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:641:5: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_keywordimport1159); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
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
                      					org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					collectHiddenTokens(element);
                      					getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(referenceResolverSwitch.getImportConcreteSyntaxReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
                      					if (proxy != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), proxy);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a6, element);
                      					copyLocalizationInfos((CommonToken) a6, proxy);
                      				
                    }

                    }

                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:667:4: ( ( (a7= QUOTED_60_62 ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==QUOTED_60_62) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:668:5: ( (a7= QUOTED_60_62 ) )
                            {
                            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:668:5: ( (a7= QUOTED_60_62 ) )
                            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:669:6: (a7= QUOTED_60_62 )
                            {
                            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:669:6: (a7= QUOTED_60_62 )
                            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:670:7: a7= QUOTED_60_62
                            {
                            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport1208); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (element == null) {
                              								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
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
                              							collectHiddenTokens(element);
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:700:1: option returns [org.emftext.sdk.concretesyntax.Option element = null] : (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34 ) ;
    public final org.emftext.sdk.concretesyntax.Option option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;
        int option_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:703:1: ( (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34 ) )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:704:2: (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34 )
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:704:2: (a0= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:705:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_option1293); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
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
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              		
            }

            }

            a1=(Token)match(input,27,FOLLOW_27_in_option1311); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:735:2: (a2= QUOTED_34_34 )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:736:3: a2= QUOTED_34_34
            {
            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_option1326); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
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
              			collectHiddenTokens(element);
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:760:1: rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : (a0= QUALIFIED_NAME ) a1= '::=' (a2_0= choice ) a3= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;
        int rule_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Choice a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:763:1: ( (a0= QUALIFIED_NAME ) a1= '::=' (a2_0= choice ) a3= ';' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:764:2: (a0= QUALIFIED_NAME ) a1= '::=' (a2_0= choice ) a3= ';'
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:764:2: (a0= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:765:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_rule1363); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
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
              			org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
              			collectHiddenTokens(element);
              			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(referenceResolverSwitch.getRuleMetaclassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              			copyLocalizationInfos((CommonToken) a0, proxy);
              		
            }

            }

            a1=(Token)match(input,28,FOLLOW_28_in_rule1381); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:799:2: (a2_0= choice )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:800:3: a2_0= choice
            {
            pushFollow(FOLLOW_choice_in_rule1396);
            a2_0=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              			}
              			if (a2_0 != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), a2_0);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos(a2_0, element); 		
            }

            }

            a3=(Token)match(input,21,FOLLOW_21_in_rule1411); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a3, element);
              	
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:821:1: sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : ( (a0_0= definition ) )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;
        int sequence_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.Definition a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:824:1: ( ( (a0_0= definition ) )+ )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:825:2: ( (a0_0= definition ) )+
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:825:2: ( (a0_0= definition ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUALIFIED_NAME||LA15_0==QUOTED_34_34||LA15_0==32||(LA15_0>=34 && LA15_0<=35)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:826:3: (a0_0= definition )
            	    {
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:826:3: (a0_0= definition )
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:827:4: a0_0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence1446);
            	    a0_0=definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSequence();
            	      				}
            	      				if (a0_0 != null) {
            	      					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS, a0_0);
            	      				}
            	      				collectHiddenTokens(element);
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:841:1: choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : (a0_0= sequence ) ( (a1= '|' (a2_0= sequence ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;
        int choice_StartIndex = input.index();
        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0_0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:844:1: ( (a0_0= sequence ) ( (a1= '|' (a2_0= sequence ) ) )* )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:845:2: (a0_0= sequence ) ( (a1= '|' (a2_0= sequence ) ) )*
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:845:2: (a0_0= sequence )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:846:3: a0_0= sequence
            {
            pushFollow(FOLLOW_sequence_in_choice1488);
            a0_0=sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
              			}
              			if (a0_0 != null) {
              				addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a0_0);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos(a0_0, element); 		
            }

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:857:2: ( (a1= '|' (a2_0= sequence ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==29) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:858:3: (a1= '|' (a2_0= sequence ) )
            	    {
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:858:3: (a1= '|' (a2_0= sequence ) )
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:859:4: a1= '|' (a2_0= sequence )
            	    {
            	    a1=(Token)match(input,29,FOLLOW_29_in_choice1512); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((CommonToken)a1, element);
            	      			
            	    }
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:867:4: (a2_0= sequence )
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:868:5: a2_0= sequence
            	    {
            	    pushFollow(FOLLOW_sequence_in_choice1533);
            	    a2_0=sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (element == null) {
            	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
            	      					}
            	      					if (a2_0 != null) {
            	      						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a2_0);
            	      					}
            	      					collectHiddenTokens(element);
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:884:1: csstring returns [org.emftext.sdk.concretesyntax.CsString element = null] : (a0= QUOTED_34_34 ) ;
    public final org.emftext.sdk.concretesyntax.CsString csstring() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;
        int csstring_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:887:1: ( (a0= QUOTED_34_34 ) )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:888:2: (a0= QUOTED_34_34 )
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:888:2: (a0= QUOTED_34_34 )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:889:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring1585); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCsString();
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
              			collectHiddenTokens(element);
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:913:1: definedplaceholder returns [org.emftext.sdk.concretesyntax.DefinedPlaceholder element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= cardinality ) )? ;
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
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:916:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= cardinality ) )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:917:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= cardinality ) )?
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:917:2: (a0= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:918:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder1622); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();
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
              			org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              			collectHiddenTokens(element);
              			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(referenceResolverSwitch.getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              			copyLocalizationInfos((CommonToken) a0, proxy);
              		
            }

            }

            a1=(Token)match(input,30,FOLLOW_30_in_definedplaceholder1640); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:952:2: (a2= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:953:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_definedplaceholder1655); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();
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
              			org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              			collectHiddenTokens(element);
              			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.TokenDefinition>(referenceResolverSwitch.getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a2, element);
              			copyLocalizationInfos((CommonToken) a2, proxy);
              		
            }

            }

            a3=(Token)match(input,31,FOLLOW_31_in_definedplaceholder1673); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a3, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:987:2: ( (a4_0= cardinality ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=40 && LA17_0<=42)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:988:3: (a4_0= cardinality )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:988:3: (a4_0= cardinality )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:989:4: a4_0= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder1693);
                    a4_0=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();
                      				}
                      				if (a4_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__CARDINALITY), a4_0);
                      				}
                      				collectHiddenTokens(element);
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1003:1: derivedplaceholder returns [org.emftext.sdk.concretesyntax.DerivedPlaceholder element = null] : (a0= QUALIFIED_NAME ) a1= '[' ( ( (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 ) ) )? a5= ']' ( (a6_0= cardinality ) )? ;
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
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1006:1: ( (a0= QUALIFIED_NAME ) a1= '[' ( ( (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 ) ) )? a5= ']' ( (a6_0= cardinality ) )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1007:2: (a0= QUALIFIED_NAME ) a1= '[' ( ( (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 ) ) )? a5= ']' ( (a6_0= cardinality ) )?
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1007:2: (a0= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1008:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_derivedplaceholder1735); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();
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
              			org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              			collectHiddenTokens(element);
              			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(referenceResolverSwitch.getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              			copyLocalizationInfos((CommonToken) a0, proxy);
              		
            }

            }

            a1=(Token)match(input,30,FOLLOW_30_in_derivedplaceholder1753); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1042:2: ( ( (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==QUOTED_39_39) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1043:3: ( (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 ) )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1043:3: ( (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 ) )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1044:4: (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1044:4: (a2= QUOTED_39_39 )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1045:5: a2= QUOTED_39_39
                    {
                    a2=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder1779); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();
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
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a2, element);
                      				
                    }

                    }

                    a3=(Token)match(input,16,FOLLOW_16_in_derivedplaceholder1807); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a3, element);
                      			
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1075:4: (a4= QUOTED_39_39 )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1076:5: a4= QUOTED_39_39
                    {
                    a4=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder1828); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();
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
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a4, element);
                      				
                    }

                    }


                    }


                    }
                    break;

            }

            a5=(Token)match(input,31,FOLLOW_31_in_derivedplaceholder1866); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a5, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1109:2: ( (a6_0= cardinality ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=40 && LA19_0<=42)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1110:3: (a6_0= cardinality )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1110:3: (a6_0= cardinality )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1111:4: a6_0= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder1886);
                    a6_0=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();
                      				}
                      				if (a6_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__CARDINALITY), a6_0);
                      				}
                      				collectHiddenTokens(element);
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1125:1: containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= cardinality ) )? ;
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
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1128:1: ( (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= cardinality ) )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1129:2: (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= cardinality ) )?
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1129:2: (a0= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1130:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1928); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
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
              			org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              			collectHiddenTokens(element);
              			getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(referenceResolverSwitch.getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              			copyLocalizationInfos((CommonToken) a0, proxy);
              		
            }

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1156:2: ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==24) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1157:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1157:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1158:4: a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    {
                    a1=(Token)match(input,24,FOLLOW_24_in_containment1955); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a1, element);
                      			
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1166:4: (a2= QUALIFIED_NAME )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1167:5: a2= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment1976); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
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
                      					org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                      					collectHiddenTokens(element);
                      					getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(referenceResolverSwitch.getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
                      					if (proxy != null) {
                      						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a2, element);
                      					copyLocalizationInfos((CommonToken) a2, proxy);
                      				
                    }

                    }

                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1193:4: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==16) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1194:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1194:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1195:6: a3= ',' (a4= QUALIFIED_NAME )
                    	    {
                    	    a3=(Token)match(input,16,FOLLOW_16_in_containment2017); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((CommonToken)a3, element);
                    	      					
                    	    }
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1203:6: (a4= QUALIFIED_NAME )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1204:7: a4= QUALIFIED_NAME
                    	    {
                    	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_containment2044); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (element == null) {
                    	      								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
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
                    	      							org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                    	      							collectHiddenTokens(element);
                    	      							getResource().registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(referenceResolverSwitch.getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
                    	      							if (proxy != null) {
                    	      								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
                    	      							}
                    	      							collectHiddenTokens(element);
                    	      							copyLocalizationInfos((CommonToken) a4, element);
                    	      							copyLocalizationInfos((CommonToken) a4, proxy);
                    	      						
                    	    }

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

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1236:2: ( (a5_0= cardinality ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=40 && LA22_0<=42)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1237:3: (a5_0= cardinality )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1237:3: (a5_0= cardinality )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1238:4: a5_0= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_containment2119);
                    a5_0=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                      				}
                      				if (a5_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), a5_0);
                      				}
                      				collectHiddenTokens(element);
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1252:1: compounddefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' (a1_0= choice ) a2= ')' ( (a3_0= cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition compounddefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;
        int compounddefinition_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1_0 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1255:1: (a0= '(' (a1_0= choice ) a2= ')' ( (a3_0= cardinality ) )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1256:2: a0= '(' (a1_0= choice ) a2= ')' ( (a3_0= cardinality ) )?
            {
            a0=(Token)match(input,32,FOLLOW_32_in_compounddefinition2157); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1264:2: (a1_0= choice )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1265:3: a1_0= choice
            {
            pushFollow(FOLLOW_choice_in_compounddefinition2172);
            a1_0=choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              			}
              			if (a1_0 != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), a1_0);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos(a1_0, element); 		
            }

            }

            a2=(Token)match(input,33,FOLLOW_33_in_compounddefinition2187); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a2, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1284:2: ( (a3_0= cardinality ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=40 && LA23_0<=42)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1285:3: (a3_0= cardinality )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1285:3: (a3_0= cardinality )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1286:4: a3_0= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition2207);
                    a3_0=cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
                      				}
                      				if (a3_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), a3_0);
                      				}
                      				collectHiddenTokens(element);
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


    // $ANTLR start "whitespaces"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1300:1: whitespaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : a0= '#' (a1= NUMBER ) ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces whitespaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;
        int whitespaces_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1303:1: (a0= '#' (a1= NUMBER ) )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1304:2: a0= '#' (a1= NUMBER )
            {
            a0=(Token)match(input,34,FOLLOW_34_in_whitespaces2245); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1312:2: (a1= NUMBER )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1313:3: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_whitespaces2260); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();
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
              			collectHiddenTokens(element);
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
            if ( state.backtracking>0 ) { memoize(input, 13, whitespaces_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "whitespaces"


    // $ANTLR start "linebreak"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1337:1: linebreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= '!' (a1= NUMBER ) ;
    public final org.emftext.sdk.concretesyntax.LineBreak linebreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;
        int linebreak_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1340:1: (a0= '!' (a1= NUMBER ) )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1341:2: a0= '!' (a1= NUMBER )
            {
            a0=(Token)match(input,35,FOLLOW_35_in_linebreak2293); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1349:2: (a1= NUMBER )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1350:3: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_linebreak2308); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
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
              			collectHiddenTokens(element);
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
            if ( state.backtracking>0 ) { memoize(input, 14, linebreak_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "linebreak"


    // $ANTLR start "normaltoken"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1374:1: normaltoken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : a0= 'DEFINE' (a1= QUALIFIED_NAME ) (a2= QUOTED_36_36 ) ( (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1377:1: (a0= 'DEFINE' (a1= QUALIFIED_NAME ) (a2= QUOTED_36_36 ) ( (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) ) )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1378:2: a0= 'DEFINE' (a1= QUALIFIED_NAME ) (a2= QUOTED_36_36 ) ( (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) ) )?
            {
            a0=(Token)match(input,36,FOLLOW_36_in_normaltoken2341); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1386:2: (a1= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1387:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken2356); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
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
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		
            }

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1409:2: (a2= QUOTED_36_36 )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1410:3: a2= QUOTED_36_36
            {
            a2=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken2378); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
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
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a2, element);
              		
            }

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1432:2: ( (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==37) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1433:3: (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1433:3: (a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME ) )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1434:4: a3= 'COLLECT' a4= 'IN' (a5= QUALIFIED_NAME )
                    {
                    a3=(Token)match(input,37,FOLLOW_37_in_normaltoken2405); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a3, element);
                      			
                    }
                    a4=(Token)match(input,38,FOLLOW_38_in_normaltoken2420); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a4, element);
                      			
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1450:4: (a5= QUALIFIED_NAME )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1451:5: a5= QUALIFIED_NAME
                    {
                    a5=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_normaltoken2441); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
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
                      					collectHiddenTokens(element);
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
            if ( state.backtracking>0 ) { memoize(input, 15, normaltoken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "normaltoken"


    // $ANTLR start "predefinedtoken"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1478:1: predefinedtoken returns [org.emftext.sdk.concretesyntax.PreDefinedToken element = null] : a0= 'PREDEFINED' (a1= QUALIFIED_NAME ) ( (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) ) )? ;
    public final org.emftext.sdk.concretesyntax.PreDefinedToken predefinedtoken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PreDefinedToken element =  null;
        int predefinedtoken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1481:1: (a0= 'PREDEFINED' (a1= QUALIFIED_NAME ) ( (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) ) )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1482:2: a0= 'PREDEFINED' (a1= QUALIFIED_NAME ) ( (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) ) )?
            {
            a0=(Token)match(input,39,FOLLOW_39_in_predefinedtoken2494); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1490:2: (a1= QUALIFIED_NAME )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1491:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken2509); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();
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
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              		
            }

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1513:2: ( (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==37) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1514:3: (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1514:3: (a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME ) )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1515:4: a2= 'COLLECT' a3= 'IN' (a4= QUALIFIED_NAME )
                    {
                    a2=(Token)match(input,37,FOLLOW_37_in_predefinedtoken2536); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a2, element);
                      			
                    }
                    a3=(Token)match(input,38,FOLLOW_38_in_predefinedtoken2551); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a3, element);
                      			
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1531:4: (a4= QUALIFIED_NAME )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1532:5: a4= QUALIFIED_NAME
                    {
                    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_predefinedtoken2572); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();
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
                      					collectHiddenTokens(element);
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
            if ( state.backtracking>0 ) { memoize(input, 16, predefinedtoken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "predefinedtoken"


    // $ANTLR start "plus"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1559:1: plus returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS plus() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;
        int plus_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1562:1: (a0= '+' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1563:2: a0= '+'
            {
            a0=(Token)match(input,40,FOLLOW_40_in_plus2625); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPLUS();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, plus_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "plus"


    // $ANTLR start "star"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1573:1: star returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR star() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;
        int star_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1576:1: (a0= '*' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1577:2: a0= '*'
            {
            a0=(Token)match(input,41,FOLLOW_41_in_star2651); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSTAR();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, star_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "star"


    // $ANTLR start "questionmark"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1587:1: questionmark returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK questionmark() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;
        int questionmark_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1590:1: (a0= '?' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1591:2: a0= '?'
            {
            a0=(Token)match(input,42,FOLLOW_42_in_questionmark2677); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, questionmark_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "questionmark"


    // $ANTLR start "keywordabstract"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1601:1: keywordabstract returns [org.emftext.sdk.concretesyntax.Abstract element = null] : a0= 'ABSTRACT' ;
    public final org.emftext.sdk.concretesyntax.Abstract keywordabstract() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Abstract element =  null;
        int keywordabstract_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1604:1: (a0= 'ABSTRACT' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1605:2: a0= 'ABSTRACT'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_keywordabstract2703); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAbstract();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, keywordabstract_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "keywordabstract"


    // $ANTLR start "tokendefinition"
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1615:1: tokendefinition returns [org.emftext.sdk.concretesyntax.TokenDefinition element = null] : (c0= normaltoken | c1= predefinedtoken );
    public final org.emftext.sdk.concretesyntax.TokenDefinition tokendefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDefinition element =  null;
        int tokendefinition_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.PreDefinedToken c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1616:1: (c0= normaltoken | c1= predefinedtoken )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==36) ) {
                alt26=1;
            }
            else if ( (LA26_0==39) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1617:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition2725);
                    c0=normaltoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1618:4: c1= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition2735);
                    c1=predefinedtoken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1622:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
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
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1623:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
            int alt27=7;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1624:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition2756);
                    c0=csstring();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1625:4: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition2766);
                    c1=definedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1626:4: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition2776);
                    c2=derivedplaceholder();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1627:4: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition2786);
                    c3=containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1628:4: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition2796);
                    c4=compounddefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1629:4: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition2806);
                    c5=whitespaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1630:4: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition2816);
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
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1634:1: cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final org.emftext.sdk.concretesyntax.Cardinality cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;
        int cardinality_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1635:1: (c0= plus | c1= star | c2= questionmark )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt28=1;
                }
                break;
            case 41:
                {
                alt28=2;
                }
                break;
            case 42:
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
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1636:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality2837);
                    c0=plus();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1637:4: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality2847);
                    c1=star();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1638:4: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality2857);
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


    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA27_eotS =
        "\12\uffff";
    static final String DFA27_eofS =
        "\2\uffff\1\7\7\uffff";
    static final String DFA27_minS =
        "\1\4\1\uffff\1\4\3\uffff\1\4\3\uffff";
    static final String DFA27_maxS =
        "\1\43\1\uffff\1\52\3\uffff\1\37\3\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\1\uffff\1\5\1\6\1\7\1\uffff\1\4\1\2\1\3";
    static final String DFA27_specialS =
        "\12\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\2\1\uffff\1\1\31\uffff\1\3\1\uffff\1\4\1\5",
            "",
            "\1\7\1\uffff\1\7\16\uffff\1\7\2\uffff\1\7\4\uffff\1\7\1\6"+
            "\1\uffff\4\7\4\uffff\3\7",
            "",
            "",
            "",
            "\1\10\2\uffff\1\11\27\uffff\1\11",
            "",
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
            return "1622:1: definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );";
        }
    }
 

    public static final BitSet FOLLOW_concretesyntax_in_start79 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keywordabstract_in_concretesyntax118 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_concretesyntax141 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax156 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_concretesyntax174 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax189 = new BitSet(new long[]{0x0000000000D28020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax222 = new BitSet(new long[]{0x0000000000D28000L});
    public static final BitSet FOLLOW_15_in_concretesyntax269 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax297 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_16_in_concretesyntax351 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_concretesyntax387 = new BitSet(new long[]{0x0000000000D30000L});
    public static final BitSet FOLLOW_17_in_concretesyntax479 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax494 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_keywordimport_in_concretesyntax530 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax579 = new BitSet(new long[]{0x0000000000D00000L});
    public static final BitSet FOLLOW_20_in_concretesyntax613 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax628 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_option_in_concretesyntax664 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax695 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax732 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_concretesyntax766 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax781 = new BitSet(new long[]{0x0000009000080000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax817 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax848 = new BitSet(new long[]{0x0000009000080000L});
    public static final BitSet FOLLOW_19_in_concretesyntax885 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax910 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_concretesyntax921 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule_in_concretesyntax947 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_concretesyntax980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport1010 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_keywordimport1028 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport1043 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport1076 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_keywordimport1123 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_keywordimport1138 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_keywordimport1159 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_option1293 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_option1311 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_option1326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_rule1363 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule1381 = new BitSet(new long[]{0x0000000D00000050L});
    public static final BitSet FOLLOW_choice_in_rule1396 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence1446 = new BitSet(new long[]{0x0000000D00000052L});
    public static final BitSet FOLLOW_sequence_in_choice1488 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_choice1512 = new BitSet(new long[]{0x0000000D00000050L});
    public static final BitSet FOLLOW_sequence_in_choice1533 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder1622 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_definedplaceholder1640 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_definedplaceholder1655 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_definedplaceholder1673 = new BitSet(new long[]{0x0000070000000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_derivedplaceholder1735 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_derivedplaceholder1753 = new BitSet(new long[]{0x0000000080000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder1779 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_derivedplaceholder1807 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder1828 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_derivedplaceholder1866 = new BitSet(new long[]{0x0000070000000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1928 = new BitSet(new long[]{0x0000070001000002L});
    public static final BitSet FOLLOW_24_in_containment1955 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment1976 = new BitSet(new long[]{0x0000070000010002L});
    public static final BitSet FOLLOW_16_in_containment2017 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_containment2044 = new BitSet(new long[]{0x0000070000010002L});
    public static final BitSet FOLLOW_cardinality_in_containment2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_compounddefinition2157 = new BitSet(new long[]{0x0000000D00000050L});
    public static final BitSet FOLLOW_choice_in_compounddefinition2172 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_compounddefinition2187 = new BitSet(new long[]{0x0000070000000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_whitespaces2245 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_whitespaces2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_linebreak2293 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NUMBER_in_linebreak2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_normaltoken2341 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken2356 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken2378 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_normaltoken2405 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_normaltoken2420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_normaltoken2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_predefinedtoken2494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken2509 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_predefinedtoken2536 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_predefinedtoken2551 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_predefinedtoken2572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_plus2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_star2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_questionmark2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_keywordabstract2703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition2725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition2735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition2796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality2857 = new BitSet(new long[]{0x0000000000000002L});

}