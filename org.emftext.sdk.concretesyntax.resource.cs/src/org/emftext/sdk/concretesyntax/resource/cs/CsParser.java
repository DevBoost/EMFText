// $ANTLR 3.0.1 C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2008-12-09 13:00:02

package org.emftext.sdk.concretesyntax.resource.cs;

//+++++++++++++++++++++++imports for org.emftext.sdk.concretesyntax begin++++++++++++++++++++++
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
//Implementation: org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl
import org.emftext.sdk.concretesyntax.Import;
//Implementation: org.emftext.sdk.concretesyntax.impl.ImportImpl
import org.emftext.sdk.concretesyntax.Rule;
//Implementation: org.emftext.sdk.concretesyntax.impl.RuleImpl
import org.emftext.sdk.concretesyntax.Choice;
//Implementation: org.emftext.sdk.concretesyntax.impl.ChoiceImpl
import org.emftext.sdk.concretesyntax.Sequence;
//Implementation: org.emftext.sdk.concretesyntax.impl.SequenceImpl
import org.emftext.sdk.concretesyntax.Definition;
//Implementation: org.emftext.sdk.concretesyntax.impl.DefinitionImpl
import org.emftext.sdk.concretesyntax.Terminal;
//Implementation: org.emftext.sdk.concretesyntax.impl.TerminalImpl
import org.emftext.sdk.concretesyntax.CsString;
//Implementation: org.emftext.sdk.concretesyntax.impl.CsStringImpl
import org.emftext.sdk.concretesyntax.WhiteSpaces;
//Implementation: org.emftext.sdk.concretesyntax.impl.WhiteSpacesImpl
import org.emftext.sdk.concretesyntax.LineBreak;
//Implementation: org.emftext.sdk.concretesyntax.impl.LineBreakImpl
import org.emftext.sdk.concretesyntax.Cardinality;
//Implementation: org.emftext.sdk.concretesyntax.impl.CardinalityImpl
import org.emftext.sdk.concretesyntax.PLUS;
//Implementation: org.emftext.sdk.concretesyntax.impl.PLUSImpl
import org.emftext.sdk.concretesyntax.STAR;
//Implementation: org.emftext.sdk.concretesyntax.impl.STARImpl
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
//Implementation: org.emftext.sdk.concretesyntax.impl.QUESTIONMARKImpl
import org.emftext.sdk.concretesyntax.CompoundDefinition;
//Implementation: org.emftext.sdk.concretesyntax.impl.CompoundDefinitionImpl
import org.emftext.sdk.concretesyntax.TokenDefinition;
//Implementation: org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl
import org.emftext.sdk.concretesyntax.NormalToken;
//Implementation: org.emftext.sdk.concretesyntax.impl.NormalTokenImpl
import org.emftext.sdk.concretesyntax.DecoratedToken;
//Implementation: org.emftext.sdk.concretesyntax.impl.DecoratedTokenImpl
import org.emftext.sdk.concretesyntax.NewDefinedToken;
//Implementation: org.emftext.sdk.concretesyntax.impl.NewDefinedTokenImpl
import org.emftext.sdk.concretesyntax.PreDefinedToken;
//Implementation: org.emftext.sdk.concretesyntax.impl.PreDefinedTokenImpl
import org.emftext.sdk.concretesyntax.Containment;
//Implementation: org.emftext.sdk.concretesyntax.impl.ContainmentImpl
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
//Implementation: org.emftext.sdk.concretesyntax.impl.DefinedPlaceholderImpl
import org.emftext.sdk.concretesyntax.DerivedPlaceholder;
//Implementation: org.emftext.sdk.concretesyntax.impl.DerivedPlaceholderImpl
import org.emftext.sdk.concretesyntax.Placeholder;
//Implementation: org.emftext.sdk.concretesyntax.impl.PlaceholderImpl
import org.emftext.sdk.concretesyntax.Option;
//Implementation: org.emftext.sdk.concretesyntax.impl.OptionImpl
import org.emftext.sdk.concretesyntax.*;
//+++++++++++++++++++++++imports for org.eclipse.emf.ecore begin++++++++++++++++++++++
import org.eclipse.emf.ecore.EAttribute;
//Implementation: org.eclipse.emf.ecore.impl.EAttributeImpl
import org.eclipse.emf.ecore.EAnnotation;
//Implementation: org.eclipse.emf.ecore.impl.EAnnotationImpl
import org.eclipse.emf.ecore.EClass;
//Implementation: org.eclipse.emf.ecore.impl.EClassImpl
import org.eclipse.emf.ecore.EClassifier;
//Implementation: org.eclipse.emf.ecore.impl.EClassifierImpl
import org.eclipse.emf.ecore.EDataType;
//Implementation: org.eclipse.emf.ecore.impl.EDataTypeImpl
import org.eclipse.emf.ecore.EEnum;
//Implementation: org.eclipse.emf.ecore.impl.EEnumImpl
import org.eclipse.emf.ecore.EEnumLiteral;
//Implementation: org.eclipse.emf.ecore.impl.EEnumLiteralImpl
import org.eclipse.emf.ecore.EFactory;
//Implementation: org.eclipse.emf.ecore.impl.EFactoryImpl
import org.eclipse.emf.ecore.EModelElement;
//Implementation: org.eclipse.emf.ecore.impl.EModelElementImpl
import org.eclipse.emf.ecore.ENamedElement;
//Implementation: org.eclipse.emf.ecore.impl.ENamedElementImpl
import org.eclipse.emf.ecore.EObject;
//Implementation: org.eclipse.emf.ecore.impl.EObjectImpl
import org.eclipse.emf.ecore.EOperation;
//Implementation: org.eclipse.emf.ecore.impl.EOperationImpl
import org.eclipse.emf.ecore.EPackage;
//Implementation: org.eclipse.emf.ecore.impl.EPackageImpl
import org.eclipse.emf.ecore.EParameter;
//Implementation: org.eclipse.emf.ecore.impl.EParameterImpl
import org.eclipse.emf.ecore.EReference;
//Implementation: org.eclipse.emf.ecore.impl.EReferenceImpl
import org.eclipse.emf.ecore.EStructuralFeature;
//Implementation: org.eclipse.emf.ecore.impl.EStructuralFeatureImpl
import org.eclipse.emf.ecore.ETypedElement;
//Implementation: org.eclipse.emf.ecore.impl.ETypedElementImpl
import java.util.Map.Entry;
//Implementation: org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecore.EGenericType;
//Implementation: org.eclipse.emf.ecore.impl.EGenericTypeImpl
import org.eclipse.emf.ecore.ETypeParameter;
//Implementation: org.eclipse.emf.ecore.impl.ETypeParameterImpl
import org.eclipse.emf.ecore.*;
//+++++++++++++++++++++++imports for org.eclipse.emf.codegen.ecore.genmodel begin++++++++++++++++++++++
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenClassImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenFeatureImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenBaseImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenEnumImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenEnumLiteralImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenClassifierImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenDataTypeImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenOperationImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenParameterImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenTypedElementImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenAnnotationImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;
//Implementation: org.eclipse.emf.codegen.ecore.genmodel.impl.GenTypeParameterImpl
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.impl.EMFTextParserImpl;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class CsParser extends EMFTextParserImpl {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "QUOTED_60_62", "QNAME", "QUOTED_34_34", "QUOTED_39_39", "TEXT_35_", "TEXT_33_", "QUOTED_36_36", "COMMENTS", "LB", "WS", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'+'", "'*'", "'?'", "'DEFINE'", "'PREDEFINED'"
    };
    public static final int TEXT_33_=10;
    public static final int WS=14;
    public static final int QNAME=6;
    public static final int COMMENTS=12;
    public static final int QUOTED_39_39=8;
    public static final int QUOTED_36_36=11;
    public static final int LB=13;
    public static final int TEXT_35_=9;
    public static final int QUOTED_60_62=5;
    public static final int TEXT=4;
    public static final int EOF=-1;
    public static final int QUOTED_34_34=7;

        public CsParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[53+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g"; }


    	private org.emftext.runtime.resource.TokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();

    	protected EObject doParse() throws RecognitionException {
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:162:1: start returns [ EObject element = null] : c0= concretesyntax ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        ConcreteSyntax c0 = null;


        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:164:1: (c0= concretesyntax )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:165:1: c0= concretesyntax
            {
            pushFollow(FOLLOW_concretesyntax_in_start61);
            c0=concretesyntax();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
               element = c0; 
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
    // $ANTLR end start


    // $ANTLR start concretesyntax
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:169:1: concretesyntax returns [ConcreteSyntax element = null] : a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}' ;
    public final ConcreteSyntax concretesyntax() throws RecognitionException {
        ConcreteSyntax element =  null;

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
        Import a12 = null;

        Option a16 = null;

        TokenDefinition a21 = null;

        Rule a26 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:173:1: (a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:174:2: a0= 'SYNTAXDEF' a1= TEXT a2= 'FOR' a3= QUOTED_60_62 a4= 'START' (a5= TEXT | a6= QNAME ) ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )* ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )? ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )? ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )? a24= 'RULES' a25= '{' ( (a26= rule )+ ) a27= '}'
            {
            a0=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_concretesyntax85); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_concretesyntax93); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,16,FOLLOW_16_in_concretesyntax101); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a2, element); 
            }
            a3=(Token)input.LT(1);
            match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax109); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); copyLocalizationInfos((CommonToken) a3, element); copyLocalizationInfos((CommonToken) a3, proxy); 
            }
            a4=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_concretesyntax117); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a4, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:179:2: (a5= TEXT | a6= QNAME )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==TEXT) ) {
                alt1=1;
            }
            else if ( (LA1_0==QNAME) ) {
                alt1=2;
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("179:2: (a5= TEXT | a6= QNAME )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:180:3: a5= TEXT
                    {
                    a5=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_concretesyntax129); if (failed) return element;
                    if ( backtracking==0 ) {
                      org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:183:3: a6= QNAME
                    {
                    a6=(Token)input.LT(1);
                    match(input,QNAME,FOLLOW_QNAME_in_concretesyntax143); if (failed) return element;
                    if ( backtracking==0 ) {
                      org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a6.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a6,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a6, element); copyLocalizationInfos((CommonToken) a6, proxy); 
                    }

                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:185:2: ( (a7= ',' (a8= TEXT | a9= QNAME ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:186:3: (a7= ',' (a8= TEXT | a9= QNAME ) )
            	    {
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:186:3: (a7= ',' (a8= TEXT | a9= QNAME ) )
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:187:4: a7= ',' (a8= TEXT | a9= QNAME )
            	    {
            	    a7=(Token)input.LT(1);
            	    match(input,18,FOLLOW_18_in_concretesyntax163); if (failed) return element;
            	    if ( backtracking==0 ) {
            	      copyLocalizationInfos((CommonToken)a7, element); 
            	    }
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:188:4: (a8= TEXT | a9= QNAME )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==TEXT) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==QNAME) ) {
            	        alt2=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("188:4: (a8= TEXT | a9= QNAME )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:189:5: a8= TEXT
            	            {
            	            a8=(Token)input.LT(1);
            	            match(input,TEXT,FOLLOW_TEXT_in_concretesyntax179); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a8.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a8,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a8, element); copyLocalizationInfos((CommonToken) a8, proxy); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:192:5: a9= QNAME
            	            {
            	            a9=(Token)input.LT(1);
            	            match(input,QNAME,FOLLOW_QNAME_in_concretesyntax197); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a9.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a9,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a9, element); copyLocalizationInfos((CommonToken) a9, proxy); 
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

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:196:2: ( (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:197:3: (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:197:3: (a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}' )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:198:4: a10= 'IMPORTS' a11= '{' ( (a12= keywordimport ) )* a13= '}'
                    {
                    a10=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_concretesyntax227); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a10, element); 
                    }
                    a11=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_concretesyntax237); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a11, element); 
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:200:4: ( (a12= keywordimport ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==TEXT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:201:5: (a12= keywordimport )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:201:5: (a12= keywordimport )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:202:6: a12= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax260);
                    	    a12=keywordimport();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("imports"))).add(a12); copyLocalizationInfos(a12, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    a13=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_concretesyntax282); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a13, element); 
                    }

                    }


                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:208:2: ( (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:209:3: (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:209:3: (a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}' )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:210:4: a14= 'OPTIONS' a15= '{' ( (a16= option a17= ';' ) )* a18= '}'
                    {
                    a14=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_concretesyntax307); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a14, element); 
                    }
                    a15=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_concretesyntax317); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a15, element); 
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:212:4: ( (a16= option a17= ';' ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==TEXT) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:213:5: (a16= option a17= ';' )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:213:5: (a16= option a17= ';' )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:214:6: a16= option a17= ';'
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax340);
                    	    a16=option();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a16); copyLocalizationInfos(a16, element); 
                    	    }
                    	    a17=(Token)input.LT(1);
                    	    match(input,23,FOLLOW_23_in_concretesyntax352); if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      copyLocalizationInfos((CommonToken)a17, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    a18=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_concretesyntax374); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a18, element); 
                    }

                    }


                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:221:2: ( (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:3: (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:3: (a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}' )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:223:4: a19= 'TOKENS' a20= '{' ( (a21= tokendefinition a22= ';' ) )* a23= '}'
                    {
                    a19=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_concretesyntax399); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a19, element); 
                    }
                    a20=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_concretesyntax409); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a20, element); 
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:225:4: ( (a21= tokendefinition a22= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=39 && LA8_0<=40)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:226:5: (a21= tokendefinition a22= ';' )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:226:5: (a21= tokendefinition a22= ';' )
                    	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:227:6: a21= tokendefinition a22= ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax432);
                    	    a21=tokendefinition();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("tokens"))).add(a21); copyLocalizationInfos(a21, element); 
                    	    }
                    	    a22=(Token)input.LT(1);
                    	    match(input,23,FOLLOW_23_in_concretesyntax444); if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      copyLocalizationInfos((CommonToken)a22, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    a23=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_concretesyntax466); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a23, element); 
                    }

                    }


                    }
                    break;

            }

            a24=(Token)input.LT(1);
            match(input,25,FOLLOW_25_in_concretesyntax482); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a24, element); 
            }
            a25=(Token)input.LT(1);
            match(input,20,FOLLOW_20_in_concretesyntax490); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a25, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:236:2: ( (a26= rule )+ )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:237:3: (a26= rule )+
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:237:3: (a26= rule )+
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
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:238:4: a26= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax507);
            	    a26=rule();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      ((List) element.eGet(element.eClass().getEStructuralFeature("rules"))).add(a26); copyLocalizationInfos(a26, element); 
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (backtracking>0) {failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            a27=(Token)input.LT(1);
            match(input,21,FOLLOW_21_in_concretesyntax523); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a27, element); 
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
    // $ANTLR end concretesyntax


    // $ANTLR start keywordimport
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:244:1: keywordimport returns [Import element = null] : a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )? ;
    public final Import keywordimport() throws RecognitionException {
        Import element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createImport();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:248:1: (a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:249:2: a0= TEXT a1= ':' a2= QUOTED_60_62 ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_keywordimport546); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,26,FOLLOW_26_in_keywordimport554); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport562); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:252:2: ( (a3= 'WITH' a4= 'SYNTAX' a5= TEXT ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:253:3: (a3= 'WITH' a4= 'SYNTAX' a5= TEXT )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:253:3: (a3= 'WITH' a4= 'SYNTAX' a5= TEXT )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:254:4: a3= 'WITH' a4= 'SYNTAX' a5= TEXT
                    {
                    a3=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_keywordimport579); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a3, element); 
                    }
                    a4=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_keywordimport589); if (failed) return element;
                    if ( backtracking==0 ) {
                      copyLocalizationInfos((CommonToken)a4, element); 
                    }
                    a5=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_keywordimport599); if (failed) return element;
                    if ( backtracking==0 ) {
                      org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;ConcreteSyntax proxy = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("concreteSyntax"), proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
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
    // $ANTLR end keywordimport


    // $ANTLR start option
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:261:1: option returns [Option element = null] : a0= TEXT a1= '=' a2= TEXT ;
    public final Option option() throws RecognitionException {
        Option element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createOption();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:265:1: (a0= TEXT a1= '=' a2= TEXT )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:266:2: a0= TEXT a1= '=' a2= TEXT
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_option630); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,29,FOLLOW_29_in_option638); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_option646); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
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
    // $ANTLR end option


    // $ANTLR start rule
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:271:1: rule returns [Rule element = null] : (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';' ;
    public final Rule rule() throws RecognitionException {
        Rule element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Choice a3 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createRule();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:275:1: ( (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:276:2: (a0= TEXT | a1= QNAME ) a2= '::=' a3= choice a4= ';'
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:276:2: (a0= TEXT | a1= QNAME )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==TEXT) ) {
                alt12=1;
            }
            else if ( (LA12_0==QNAME) ) {
                alt12=2;
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("276:2: (a0= TEXT | a1= QNAME )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:277:3: a0= TEXT
                    {
                    a0=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_rule673); if (failed) return element;
                    if ( backtracking==0 ) {
                      org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:280:3: a1= QNAME
                    {
                    a1=(Token)input.LT(1);
                    match(input,QNAME,FOLLOW_QNAME_in_rule687); if (failed) return element;
                    if ( backtracking==0 ) {
                      org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
                    }

                    }
                    break;

            }

            a2=(Token)input.LT(1);
            match(input,30,FOLLOW_30_in_rule698); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a2, element); 
            }
            pushFollow(FOLLOW_choice_in_rule706);
            a3=choice();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.eSet(element.eClass().getEStructuralFeature("definition"), a3); copyLocalizationInfos(a3, element); 
            }
            a4=(Token)input.LT(1);
            match(input,23,FOLLOW_23_in_rule714); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a4, element); 
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
    // $ANTLR end rule


    // $ANTLR start sequence
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:287:1: sequence returns [Sequence element = null] : (a0= definition )+ ;
    public final Sequence sequence() throws RecognitionException {
        Sequence element =  null;

        Definition a0 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createSequence();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:291:1: ( (a0= definition )+ )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:292:2: (a0= definition )+
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:292:2: (a0= definition )+
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
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:293:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence741);
            	    a0=definition();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      ((List) element.eGet(element.eClass().getEStructuralFeature("parts"))).add(a0); copyLocalizationInfos(a0, element); 
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (backtracking>0) {failed=true; return element;}
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
    // $ANTLR end sequence


    // $ANTLR start choice
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:297:1: choice returns [Choice element = null] : a0= sequence ( (a1= '|' a2= sequence ) )* ;
    public final Choice choice() throws RecognitionException {
        Choice element =  null;

        Token a1=null;
        Sequence a0 = null;

        Sequence a2 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createChoice();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:301:1: (a0= sequence ( (a1= '|' a2= sequence ) )* )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:302:2: a0= sequence ( (a1= '|' a2= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice768);
            a0=sequence();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              ((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a0); copyLocalizationInfos(a0, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:303:2: ( (a1= '|' a2= sequence ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:304:3: (a1= '|' a2= sequence )
            	    {
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:304:3: (a1= '|' a2= sequence )
            	    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:305:4: a1= '|' a2= sequence
            	    {
            	    a1=(Token)input.LT(1);
            	    match(input,31,FOLLOW_31_in_choice785); if (failed) return element;
            	    if ( backtracking==0 ) {
            	      copyLocalizationInfos((CommonToken)a1, element); 
            	    }
            	    pushFollow(FOLLOW_sequence_in_choice795);
            	    a2=sequence();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      ((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a2); copyLocalizationInfos(a2, element); 
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
    // $ANTLR end choice


    // $ANTLR start csstring
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:311:1: csstring returns [CsString element = null] : a0= QUOTED_34_34 ;
    public final CsString csstring() throws RecognitionException {
        CsString element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createCsString();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:315:1: (a0= QUOTED_34_34 )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:316:2: a0= QUOTED_34_34
            {
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring826); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // $ANTLR end csstring


    // $ANTLR start definedplaceholder
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:319:1: definedplaceholder returns [DefinedPlaceholder element = null] : a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )? ;
    public final DefinedPlaceholder definedplaceholder() throws RecognitionException {
        DefinedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Cardinality a4 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:323:1: (a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:324:2: a0= TEXT a1= '[' a2= TEXT a3= ']' (a4= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder849); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)input.LT(1);
            match(input,32,FOLLOW_32_in_definedplaceholder857); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder865); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;NormalToken proxy = ConcretesyntaxFactory.eINSTANCE.createNormalToken();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("token"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
            }
            a3=(Token)input.LT(1);
            match(input,33,FOLLOW_33_in_definedplaceholder873); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a3, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:328:2: (a4= cardinality )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=36 && LA15_0<=38)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:329:3: a4= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder885);
                    a4=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("cardinality"), a4); copyLocalizationInfos(a4, element); 
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
    // $ANTLR end definedplaceholder


    // $ANTLR start derivedplaceholder
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:333:1: derivedplaceholder returns [DerivedPlaceholder element = null] : a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? ;
    public final DerivedPlaceholder derivedplaceholder() throws RecognitionException {
        DerivedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Cardinality a6 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:337:1: (a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:338:2: a0= TEXT a1= '[' ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )? a5= ']' (a6= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_derivedplaceholder912); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            a1=(Token)input.LT(1);
            match(input,32,FOLLOW_32_in_derivedplaceholder920); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a1, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:340:2: ( (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==QUOTED_39_39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:341:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    {
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:341:3: (a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )? )
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:342:4: a2= QUOTED_39_39 ( (a3= ',' a4= QUOTED_39_39 ) )?
                    {
                    a2=(Token)input.LT(1);
                    match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder937); if (failed) return element;
                    if ( backtracking==0 ) {
                      org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
                    }
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:343:4: ( (a3= ',' a4= QUOTED_39_39 ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==18) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:344:5: (a3= ',' a4= QUOTED_39_39 )
                            {
                            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:344:5: (a3= ',' a4= QUOTED_39_39 )
                            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:345:6: a3= ',' a4= QUOTED_39_39
                            {
                            a3=(Token)input.LT(1);
                            match(input,18,FOLLOW_18_in_derivedplaceholder960); if (failed) return element;
                            if ( backtracking==0 ) {
                              copyLocalizationInfos((CommonToken)a3, element); 
                            }
                            a4=(Token)input.LT(1);
                            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder972); if (failed) return element;
                            if ( backtracking==0 ) {
                              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a4,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); copyLocalizationInfos((CommonToken) a4, element); 
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            a5=(Token)input.LT(1);
            match(input,33,FOLLOW_33_in_derivedplaceholder1000); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a5, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:352:2: (a6= cardinality )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=36 && LA18_0<=38)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:353:3: a6= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder1012);
                    a6=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("cardinality"), a6); copyLocalizationInfos(a6, element); 
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
    // $ANTLR end derivedplaceholder


    // $ANTLR start containment
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:357:1: containment returns [Containment element = null] : (a0= TEXT a1= cardinality | a2= TEXT ) ;
    public final Containment containment() throws RecognitionException {
        Containment element =  null;

        Token a0=null;
        Token a2=null;
        Cardinality a1 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createContainment();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:361:1: ( (a0= TEXT a1= cardinality | a2= TEXT ) )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:362:2: (a0= TEXT a1= cardinality | a2= TEXT )
            {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:362:2: (a0= TEXT a1= cardinality | a2= TEXT )
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
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("362:2: (a0= TEXT a1= cardinality | a2= TEXT )", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("362:2: (a0= TEXT a1= cardinality | a2= TEXT )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:363:3: a0= TEXT a1= cardinality
                    {
                    a0=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_containment1043); if (failed) return element;
                    if ( backtracking==0 ) {
                      org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }
                    pushFollow(FOLLOW_cardinality_in_containment1052);
                    a1=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("cardinality"), a1); copyLocalizationInfos(a1, element); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:367:3: a2= TEXT
                    {
                    a2=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_containment1066); if (failed) return element;
                    if ( backtracking==0 ) {
                      org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
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
    // $ANTLR end containment


    // $ANTLR start compounddefinition
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:371:1: compounddefinition returns [CompoundDefinition element = null] : a0= '(' a1= choice a2= ')' (a3= cardinality )? ;
    public final CompoundDefinition compounddefinition() throws RecognitionException {
        CompoundDefinition element =  null;

        Token a0=null;
        Token a2=null;
        Choice a1 = null;

        Cardinality a3 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:375:1: (a0= '(' a1= choice a2= ')' (a3= cardinality )? )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:376:2: a0= '(' a1= choice a2= ')' (a3= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,34,FOLLOW_34_in_compounddefinition1092); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            pushFollow(FOLLOW_choice_in_compounddefinition1100);
            a1=choice();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.eSet(element.eClass().getEStructuralFeature("definitions"), a1); copyLocalizationInfos(a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,35,FOLLOW_35_in_compounddefinition1108); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a2, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:379:2: (a3= cardinality )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=36 && LA20_0<=38)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:380:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition1120);
                    a3=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("cardinality"), a3); copyLocalizationInfos(a3, element); 
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
    // $ANTLR end compounddefinition


    // $ANTLR start plus
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:384:1: plus returns [PLUS element = null] : a0= '+' ;
    public final PLUS plus() throws RecognitionException {
        PLUS element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createPLUS();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:388:1: (a0= '+' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:389:2: a0= '+'
            {
            a0=(Token)input.LT(1);
            match(input,36,FOLLOW_36_in_plus1147); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
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
    // $ANTLR end plus


    // $ANTLR start star
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:392:1: star returns [STAR element = null] : a0= '*' ;
    public final STAR star() throws RecognitionException {
        STAR element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createSTAR();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:396:1: (a0= '*' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:397:2: a0= '*'
            {
            a0=(Token)input.LT(1);
            match(input,37,FOLLOW_37_in_star1170); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
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
    // $ANTLR end star


    // $ANTLR start questionmark
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:400:1: questionmark returns [QUESTIONMARK element = null] : a0= '?' ;
    public final QUESTIONMARK questionmark() throws RecognitionException {
        QUESTIONMARK element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:404:1: (a0= '?' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:405:2: a0= '?'
            {
            a0=(Token)input.LT(1);
            match(input,38,FOLLOW_38_in_questionmark1193); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
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
    // $ANTLR end questionmark


    // $ANTLR start whitespaces
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:408:1: whitespaces returns [WhiteSpaces element = null] : a0= TEXT_35_ ;
    public final WhiteSpaces whitespaces() throws RecognitionException {
        WhiteSpaces element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:412:1: (a0= TEXT_35_ )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:413:2: a0= TEXT_35_
            {
            a0=(Token)input.LT(1);
            match(input,TEXT_35_,FOLLOW_TEXT_35__in_whitespaces1216); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_35_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("amount"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("amount"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // $ANTLR end whitespaces


    // $ANTLR start linebreak
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:416:1: linebreak returns [LineBreak element = null] : a0= TEXT_33_ ;
    public final LineBreak linebreak() throws RecognitionException {
        LineBreak element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createLineBreak();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:420:1: (a0= TEXT_33_ )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:421:2: a0= TEXT_33_
            {
            a0=(Token)input.LT(1);
            match(input,TEXT_33_,FOLLOW_TEXT_33__in_linebreak1239); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_33_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("tab"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // $ANTLR end linebreak


    // $ANTLR start normaltoken
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:424:1: normaltoken returns [NormalToken element = null] : a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 ;
    public final NormalToken normaltoken() throws RecognitionException {
        NormalToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createNormalToken();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:428:1: (a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36 )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:429:2: a0= 'DEFINE' a1= TEXT a2= QUOTED_36_36
            {
            a0=(Token)input.LT(1);
            match(input,39,FOLLOW_39_in_normaltoken1262); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_normaltoken1270); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            a2=(Token)input.LT(1);
            match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken1278); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
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
    // $ANTLR end normaltoken


    // $ANTLR start decoratedtoken
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:434:1: decoratedtoken returns [DecoratedToken element = null] : a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) ;
    public final DecoratedToken decoratedtoken() throws RecognitionException {
        DecoratedToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createDecoratedToken();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:1: (a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' ) )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:439:2: a0= 'DEFINE' a1= TEXT (a2= '[' (a3= QUOTED_39_39 ) a4= ']' ) a5= QUOTED_36_36 (a6= '[' (a7= QUOTED_39_39 ) a8= ']' )
            {
            a0=(Token)input.LT(1);
            match(input,39,FOLLOW_39_in_decoratedtoken1301); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken1309); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:441:2: (a2= '[' (a3= QUOTED_39_39 ) a4= ']' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:3: a2= '[' (a3= QUOTED_39_39 ) a4= ']'
            {
            a2=(Token)input.LT(1);
            match(input,32,FOLLOW_32_in_decoratedtoken1321); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a2, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:443:3: (a3= QUOTED_39_39 )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:444:4: a3= QUOTED_39_39
            {
            a3=(Token)input.LT(1);
            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1335); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a3, element); 
            }

            }

            a4=(Token)input.LT(1);
            match(input,33,FOLLOW_33_in_decoratedtoken1348); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a4, element); 
            }

            }

            a5=(Token)input.LT(1);
            match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1359); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a5,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); copyLocalizationInfos((CommonToken) a5, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:449:2: (a6= '[' (a7= QUOTED_39_39 ) a8= ']' )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:450:3: a6= '[' (a7= QUOTED_39_39 ) a8= ']'
            {
            a6=(Token)input.LT(1);
            match(input,32,FOLLOW_32_in_decoratedtoken1371); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a6, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:451:3: (a7= QUOTED_39_39 )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:452:4: a7= QUOTED_39_39
            {
            a7=(Token)input.LT(1);
            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1385); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a7.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a7,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); copyLocalizationInfos((CommonToken) a7, element); 
            }

            }

            a8=(Token)input.LT(1);
            match(input,33,FOLLOW_33_in_decoratedtoken1398); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a8, element); 
            }

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
    // $ANTLR end decoratedtoken


    // $ANTLR start predefinedtoken
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:458:1: predefinedtoken returns [PreDefinedToken element = null] : a0= 'PREDEFINED' a1= TEXT ;
    public final PreDefinedToken predefinedtoken() throws RecognitionException {
        PreDefinedToken element =  null;

        Token a0=null;
        Token a1=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();

        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:462:1: (a0= 'PREDEFINED' a1= TEXT )
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:463:2: a0= 'PREDEFINED' a1= TEXT
            {
            a0=(Token)input.LT(1);
            match(input,40,FOLLOW_40_in_predefinedtoken1424); if (failed) return element;
            if ( backtracking==0 ) {
              copyLocalizationInfos((CommonToken)a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1432); if (failed) return element;
            if ( backtracking==0 ) {
              org.emftext.runtime.resource.TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null) throw new org.emftext.runtime.resource.TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
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
    // $ANTLR end predefinedtoken


    // $ANTLR start tokendefinition
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:467:1: tokendefinition returns [TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );
    public final TokenDefinition tokendefinition() throws RecognitionException {
        TokenDefinition element =  null;

        NormalToken c0 = null;

        DecoratedToken c1 = null;

        PreDefinedToken c2 = null;


        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:469:1: (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==39) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==TEXT) ) {
                    int LA21_3 = input.LA(3);

                    if ( (LA21_3==QUOTED_36_36) ) {
                        alt21=1;
                    }
                    else if ( (LA21_3==32) ) {
                        alt21=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("467:1: tokendefinition returns [TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );", 21, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("467:1: tokendefinition returns [TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );", 21, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA21_0==40) ) {
                alt21=3;
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("467:1: tokendefinition returns [TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:470:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1451);
                    c0=normaltoken();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:471:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1461);
                    c1=decoratedtoken();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:472:2: c2= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1471);
                    c2=predefinedtoken();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
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
    // $ANTLR end tokendefinition


    // $ANTLR start definition
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:475:1: definition returns [Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
    public final Definition definition() throws RecognitionException {
        Definition element =  null;

        CsString c0 = null;

        DefinedPlaceholder c1 = null;

        DerivedPlaceholder c2 = null;

        Containment c3 = null;

        CompoundDefinition c4 = null;

        WhiteSpaces c5 = null;

        LineBreak c6 = null;


        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:477:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
            int alt22=7;
            switch ( input.LA(1) ) {
            case QUOTED_34_34:
                {
                alt22=1;
                }
                break;
            case TEXT:
                {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==32) ) {
                    int LA22_6 = input.LA(3);

                    if ( (LA22_6==TEXT) ) {
                        alt22=2;
                    }
                    else if ( (LA22_6==QUOTED_39_39||LA22_6==33) ) {
                        alt22=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("475:1: definition returns [Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );", 22, 6, input);

                        throw nvae;
                    }
                }
                else if ( (LA22_2==EOF||LA22_2==TEXT||LA22_2==QUOTED_34_34||(LA22_2>=TEXT_35_ && LA22_2<=TEXT_33_)||LA22_2==23||LA22_2==31||(LA22_2>=34 && LA22_2<=38)) ) {
                    alt22=4;
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("475:1: definition returns [Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );", 22, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                alt22=5;
                }
                break;
            case TEXT_35_:
                {
                alt22=6;
                }
                break;
            case TEXT_33_:
                {
                alt22=7;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("475:1: definition returns [Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:478:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1490);
                    c0=csstring();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:479:2: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1500);
                    c1=definedplaceholder();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:480:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1510);
                    c2=derivedplaceholder();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:481:2: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1520);
                    c3=containment();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:482:2: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1530);
                    c4=compounddefinition();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:483:2: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1540);
                    c5=whitespaces();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:484:2: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1550);
                    c6=linebreak();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
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
    // $ANTLR end definition


    // $ANTLR start cardinality
    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:487:1: cardinality returns [Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final Cardinality cardinality() throws RecognitionException {
        Cardinality element =  null;

        PLUS c0 = null;

        STAR c1 = null;

        QUESTIONMARK c2 = null;


        try {
            // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:489:1: (c0= plus | c1= star | c2= questionmark )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt23=1;
                }
                break;
            case 37:
                {
                alt23=2;
                }
                break;
            case 38:
                {
                alt23=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("487:1: cardinality returns [Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:490:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1569);
                    c0=plus();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:491:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1579);
                    c1=star();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\svenhart\\workspaces\\runtime-EclipseApplication(1)\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:492:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1589);
                    c2=questionmark();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
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
    // $ANTLR end cardinality


 

    public static final BitSet FOLLOW_concretesyntax_in_start61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_concretesyntax85 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax93 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_concretesyntax101 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax109 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_concretesyntax117 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax129 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax143 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_18_in_concretesyntax163 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax179 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax197 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_19_in_concretesyntax227 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax237 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_keywordimport_in_concretesyntax260 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax282 = new BitSet(new long[]{0x0000000003400000L});
    public static final BitSet FOLLOW_22_in_concretesyntax307 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax317 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_option_in_concretesyntax340 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax352 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax374 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_concretesyntax399 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax409 = new BitSet(new long[]{0x0000018000200000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax432 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax444 = new BitSet(new long[]{0x0000018000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax466 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_concretesyntax482 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax490 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule_in_concretesyntax507 = new BitSet(new long[]{0x0000000000200050L});
    public static final BitSet FOLLOW_21_in_concretesyntax523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_keywordimport546 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_keywordimport554 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport562 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_keywordimport579 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_keywordimport589 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_keywordimport599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_option630 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_option638 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_option646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_rule673 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_QNAME_in_rule687 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rule698 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_choice_in_rule706 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rule714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence741 = new BitSet(new long[]{0x0000000400000692L});
    public static final BitSet FOLLOW_sequence_in_choice768 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_choice785 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_sequence_in_choice795 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder849 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_definedplaceholder857 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder865 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_definedplaceholder873 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_derivedplaceholder912 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_derivedplaceholder920 = new BitSet(new long[]{0x0000000200000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder937 = new BitSet(new long[]{0x0000000200040000L});
    public static final BitSet FOLLOW_18_in_derivedplaceholder960 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder972 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_derivedplaceholder1000 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment1043 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_cardinality_in_containment1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_compounddefinition1092 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_choice_in_compounddefinition1100 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_compounddefinition1108 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_plus1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_star1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_questionmark1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_35__in_whitespaces1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_33__in_linebreak1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_normaltoken1262 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken1270 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_decoratedtoken1301 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken1309 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1321 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1335 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1348 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1359 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1371 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1385 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_predefinedtoken1424 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1589 = new BitSet(new long[]{0x0000000000000002L});

}