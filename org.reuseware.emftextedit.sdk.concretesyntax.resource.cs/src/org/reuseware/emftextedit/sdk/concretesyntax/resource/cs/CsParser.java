// $ANTLR 3.0.1 C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2008-12-05 16:25:02

package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs;

//+++++++++++++++++++++++imports for org.reuseware.emftextedit.sdk.concretesyntax begin++++++++++++++++++++++
import org.reuseware.emftextedit.sdk.concretesyntax.ConcreteSyntax;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.ConcreteSyntaxImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Import;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.ImportImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Rule;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.RuleImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Choice;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.ChoiceImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Sequence;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.SequenceImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Definition;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.DefinitionImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Terminal;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.TerminalImpl
import org.reuseware.emftextedit.sdk.concretesyntax.CsString;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.CsStringImpl
import org.reuseware.emftextedit.sdk.concretesyntax.WhiteSpaces;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.WhiteSpacesImpl
import org.reuseware.emftextedit.sdk.concretesyntax.LineBreak;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.LineBreakImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Cardinality;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.CardinalityImpl
import org.reuseware.emftextedit.sdk.concretesyntax.PLUS;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.PLUSImpl
import org.reuseware.emftextedit.sdk.concretesyntax.STAR;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.STARImpl
import org.reuseware.emftextedit.sdk.concretesyntax.QUESTIONMARK;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.QUESTIONMARKImpl
import org.reuseware.emftextedit.sdk.concretesyntax.CompoundDefinition;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.CompoundDefinitionImpl
import org.reuseware.emftextedit.sdk.concretesyntax.TokenDefinition;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.TokenDefinitionImpl
import org.reuseware.emftextedit.sdk.concretesyntax.NormalToken;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.NormalTokenImpl
import org.reuseware.emftextedit.sdk.concretesyntax.DecoratedToken;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.DecoratedTokenImpl
import org.reuseware.emftextedit.sdk.concretesyntax.NewDefinedToken;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.NewDefinedTokenImpl
import org.reuseware.emftextedit.sdk.concretesyntax.PreDefinedToken;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.PreDefinedTokenImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Containment;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.ContainmentImpl
import org.reuseware.emftextedit.sdk.concretesyntax.DefinedPlaceholder;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.DefinedPlaceholderImpl
import org.reuseware.emftextedit.sdk.concretesyntax.DerivedPlaceholder;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.DerivedPlaceholderImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Placeholder;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.PlaceholderImpl
import org.reuseware.emftextedit.sdk.concretesyntax.Option;
//Implementation: org.reuseware.emftextedit.sdk.concretesyntax.impl.OptionImpl
import org.reuseware.emftextedit.sdk.concretesyntax.*;
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
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;


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
    public String getGrammarFileName() { return "C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g"; }


    	private TokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();

    	protected EObject doParse() throws RecognitionException {
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:163:1: start returns [ EObject element = null] : c0= concretesyntax ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        ConcreteSyntax c0 = null;


        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:165:1: (c0= concretesyntax )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:166:1: c0= concretesyntax
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:170:1: concretesyntax returns [ConcreteSyntax element = null] : 'SYNTAXDEF' a0= TEXT 'FOR' a1= QUOTED_60_62 'START' (a2= TEXT | a3= QNAME ) ( ( ',' (a4= TEXT | a5= QNAME ) ) )* ( ( 'IMPORTS' '{' ( (a6= keywordimport ) )* '}' ) )? ( ( 'OPTIONS' '{' ( (a7= option ';' ) )* '}' ) )? ( ( 'TOKENS' '{' ( (a8= tokendefinition ';' ) )* '}' ) )? 'RULES' '{' ( (a9= rule )+ ) '}' ;
    public final ConcreteSyntax concretesyntax() throws RecognitionException {
        ConcreteSyntax element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Import a6 = null;

        Option a7 = null;

        TokenDefinition a8 = null;

        Rule a9 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:174:1: ( 'SYNTAXDEF' a0= TEXT 'FOR' a1= QUOTED_60_62 'START' (a2= TEXT | a3= QNAME ) ( ( ',' (a4= TEXT | a5= QNAME ) ) )* ( ( 'IMPORTS' '{' ( (a6= keywordimport ) )* '}' ) )? ( ( 'OPTIONS' '{' ( (a7= option ';' ) )* '}' ) )? ( ( 'TOKENS' '{' ( (a8= tokendefinition ';' ) )* '}' ) )? 'RULES' '{' ( (a9= rule )+ ) '}' )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:175:2: 'SYNTAXDEF' a0= TEXT 'FOR' a1= QUOTED_60_62 'START' (a2= TEXT | a3= QNAME ) ( ( ',' (a4= TEXT | a5= QNAME ) ) )* ( ( 'IMPORTS' '{' ( (a6= keywordimport ) )* '}' ) )? ( ( 'OPTIONS' '{' ( (a7= option ';' ) )* '}' ) )? ( ( 'TOKENS' '{' ( (a8= tokendefinition ';' ) )* '}' ) )? 'RULES' '{' ( (a9= rule )+ ) '}'
            {
            match(input,15,FOLLOW_15_in_concretesyntax81); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_concretesyntax88); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            match(input,16,FOLLOW_16_in_concretesyntax92); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax99); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
            }
            match(input,17,FOLLOW_17_in_concretesyntax103); if (failed) return element;
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:180:2: (a2= TEXT | a3= QNAME )
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
                    new NoViableAltException("180:2: (a2= TEXT | a3= QNAME )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:181:3: a2= TEXT
                    {
                    a2=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_concretesyntax114); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:184:3: a3= QNAME
                    {
                    a3=(Token)input.LT(1);
                    match(input,QNAME,FOLLOW_QNAME_in_concretesyntax128); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a3, element); copyLocalizationInfos((CommonToken) a3, proxy); 
                    }

                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:186:2: ( ( ',' (a4= TEXT | a5= QNAME ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:187:3: ( ',' (a4= TEXT | a5= QNAME ) )
            	    {
            	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:187:3: ( ',' (a4= TEXT | a5= QNAME ) )
            	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:188:4: ',' (a4= TEXT | a5= QNAME )
            	    {
            	    match(input,18,FOLLOW_18_in_concretesyntax144); if (failed) return element;
            	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:189:4: (a4= TEXT | a5= QNAME )
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
            	            new NoViableAltException("189:4: (a4= TEXT | a5= QNAME )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:190:5: a4= TEXT
            	            {
            	            a4=(Token)input.LT(1);
            	            match(input,TEXT,FOLLOW_TEXT_in_concretesyntax159); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:193:5: a5= QNAME
            	            {
            	            a5=(Token)input.LT(1);
            	            match(input,QNAME,FOLLOW_QNAME_in_concretesyntax177); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); 
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

            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:197:2: ( ( 'IMPORTS' '{' ( (a6= keywordimport ) )* '}' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:198:3: ( 'IMPORTS' '{' ( (a6= keywordimport ) )* '}' )
                    {
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:198:3: ( 'IMPORTS' '{' ( (a6= keywordimport ) )* '}' )
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:199:4: 'IMPORTS' '{' ( (a6= keywordimport ) )* '}'
                    {
                    match(input,19,FOLLOW_19_in_concretesyntax203); if (failed) return element;
                    match(input,20,FOLLOW_20_in_concretesyntax208); if (failed) return element;
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:201:4: ( (a6= keywordimport ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==TEXT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:202:5: (a6= keywordimport )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:202:5: (a6= keywordimport )
                    	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:203:6: a6= keywordimport
                    	    {
                    	    pushFollow(FOLLOW_keywordimport_in_concretesyntax230);
                    	    a6=keywordimport();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("imports"))).add(a6); copyLocalizationInfos(a6, element); 
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match(input,21,FOLLOW_21_in_concretesyntax248); if (failed) return element;

                    }


                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:209:2: ( ( 'OPTIONS' '{' ( (a7= option ';' ) )* '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:210:3: ( 'OPTIONS' '{' ( (a7= option ';' ) )* '}' )
                    {
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:210:3: ( 'OPTIONS' '{' ( (a7= option ';' ) )* '}' )
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:211:4: 'OPTIONS' '{' ( (a7= option ';' ) )* '}'
                    {
                    match(input,22,FOLLOW_22_in_concretesyntax268); if (failed) return element;
                    match(input,20,FOLLOW_20_in_concretesyntax273); if (failed) return element;
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:213:4: ( (a7= option ';' ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==TEXT) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:214:5: (a7= option ';' )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:214:5: (a7= option ';' )
                    	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:215:6: a7= option ';'
                    	    {
                    	    pushFollow(FOLLOW_option_in_concretesyntax295);
                    	    a7=option();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a7); copyLocalizationInfos(a7, element); 
                    	    }
                    	    match(input,23,FOLLOW_23_in_concretesyntax303); if (failed) return element;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match(input,21,FOLLOW_21_in_concretesyntax320); if (failed) return element;

                    }


                    }
                    break;

            }

            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:222:2: ( ( 'TOKENS' '{' ( (a8= tokendefinition ';' ) )* '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:223:3: ( 'TOKENS' '{' ( (a8= tokendefinition ';' ) )* '}' )
                    {
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:223:3: ( 'TOKENS' '{' ( (a8= tokendefinition ';' ) )* '}' )
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:224:4: 'TOKENS' '{' ( (a8= tokendefinition ';' ) )* '}'
                    {
                    match(input,24,FOLLOW_24_in_concretesyntax340); if (failed) return element;
                    match(input,20,FOLLOW_20_in_concretesyntax345); if (failed) return element;
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:226:4: ( (a8= tokendefinition ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=39 && LA8_0<=40)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:227:5: (a8= tokendefinition ';' )
                    	    {
                    	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:227:5: (a8= tokendefinition ';' )
                    	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:228:6: a8= tokendefinition ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax367);
                    	    a8=tokendefinition();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      ((List) element.eGet(element.eClass().getEStructuralFeature("tokens"))).add(a8); copyLocalizationInfos(a8, element); 
                    	    }
                    	    match(input,23,FOLLOW_23_in_concretesyntax375); if (failed) return element;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match(input,21,FOLLOW_21_in_concretesyntax392); if (failed) return element;

                    }


                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_concretesyntax403); if (failed) return element;
            match(input,20,FOLLOW_20_in_concretesyntax406); if (failed) return element;
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:237:2: ( (a9= rule )+ )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:238:3: (a9= rule )+
            {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:238:3: (a9= rule )+
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
            	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:239:4: a9= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax422);
            	    a9=rule();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      ((List) element.eGet(element.eClass().getEStructuralFeature("rules"))).add(a9); copyLocalizationInfos(a9, element); 
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

            match(input,21,FOLLOW_21_in_concretesyntax434); if (failed) return element;

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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:245:1: keywordimport returns [Import element = null] : a0= TEXT ':' a1= QUOTED_60_62 ( ( 'WITH' 'SYNTAX' a2= TEXT ) )? ;
    public final Import keywordimport() throws RecognitionException {
        Import element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createImport();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:249:1: (a0= TEXT ':' a1= QUOTED_60_62 ( ( 'WITH' 'SYNTAX' a2= TEXT ) )? )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:250:2: a0= TEXT ':' a1= QUOTED_60_62 ( ( 'WITH' 'SYNTAX' a2= TEXT ) )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_keywordimport456); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            match(input,26,FOLLOW_26_in_keywordimport460); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_keywordimport467); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
            }
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:253:2: ( ( 'WITH' 'SYNTAX' a2= TEXT ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:254:3: ( 'WITH' 'SYNTAX' a2= TEXT )
                    {
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:254:3: ( 'WITH' 'SYNTAX' a2= TEXT )
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:255:4: 'WITH' 'SYNTAX' a2= TEXT
                    {
                    match(input,27,FOLLOW_27_in_keywordimport480); if (failed) return element;
                    match(input,28,FOLLOW_28_in_keywordimport485); if (failed) return element;
                    a2=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_keywordimport494); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;ConcreteSyntax proxy = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("concreteSyntax"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:262:1: option returns [Option element = null] : a0= TEXT '=' a1= TEXT ;
    public final Option option() throws RecognitionException {
        Option element =  null;

        Token a0=null;
        Token a1=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createOption();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:266:1: (a0= TEXT '=' a1= TEXT )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:267:2: a0= TEXT '=' a1= TEXT
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_option525); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            match(input,29,FOLLOW_29_in_option529); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_option536); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:272:1: rule returns [Rule element = null] : (a0= TEXT | a1= QNAME ) '::=' a2= choice ';' ;
    public final Rule rule() throws RecognitionException {
        Rule element =  null;

        Token a0=null;
        Token a1=null;
        Choice a2 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createRule();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:276:1: ( (a0= TEXT | a1= QNAME ) '::=' a2= choice ';' )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:277:2: (a0= TEXT | a1= QNAME ) '::=' a2= choice ';'
            {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:277:2: (a0= TEXT | a1= QNAME )
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
                    new NoViableAltException("277:2: (a0= TEXT | a1= QNAME )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:278:3: a0= TEXT
                    {
                    a0=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_rule563); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:281:3: a1= QNAME
                    {
                    a1=(Token)input.LT(1);
                    match(input,QNAME,FOLLOW_QNAME_in_rule577); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
                    }

                    }
                    break;

            }

            match(input,30,FOLLOW_30_in_rule584); if (failed) return element;
            pushFollow(FOLLOW_choice_in_rule591);
            a2=choice();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.eSet(element.eClass().getEStructuralFeature("definition"), a2); copyLocalizationInfos(a2, element); 
            }
            match(input,23,FOLLOW_23_in_rule595); if (failed) return element;

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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:288:1: sequence returns [Sequence element = null] : (a0= definition )+ ;
    public final Sequence sequence() throws RecognitionException {
        Sequence element =  null;

        Definition a0 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createSequence();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:292:1: ( (a0= definition )+ )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:293:2: (a0= definition )+
            {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:293:2: (a0= definition )+
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
            	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:294:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence621);
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:298:1: choice returns [Choice element = null] : a0= sequence ( ( '|' a1= sequence ) )* ;
    public final Choice choice() throws RecognitionException {
        Choice element =  null;

        Sequence a0 = null;

        Sequence a1 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createChoice();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:302:1: (a0= sequence ( ( '|' a1= sequence ) )* )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:303:2: a0= sequence ( ( '|' a1= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice648);
            a0=sequence();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              ((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a0); copyLocalizationInfos(a0, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:304:2: ( ( '|' a1= sequence ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:305:3: ( '|' a1= sequence )
            	    {
            	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:305:3: ( '|' a1= sequence )
            	    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:306:4: '|' a1= sequence
            	    {
            	    match(input,31,FOLLOW_31_in_choice661); if (failed) return element;
            	    pushFollow(FOLLOW_sequence_in_choice670);
            	    a1=sequence();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      ((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a1); copyLocalizationInfos(a1, element); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:312:1: csstring returns [CsString element = null] : a0= QUOTED_34_34 ;
    public final CsString csstring() throws RecognitionException {
        CsString element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createCsString();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:316:1: (a0= QUOTED_34_34 )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:317:2: a0= QUOTED_34_34
            {
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring701); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:320:1: definedplaceholder returns [DefinedPlaceholder element = null] : a0= TEXT '[' a1= TEXT ']' (a2= cardinality )? ;
    public final DefinedPlaceholder definedplaceholder() throws RecognitionException {
        DefinedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Cardinality a2 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:324:1: (a0= TEXT '[' a1= TEXT ']' (a2= cardinality )? )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:325:2: a0= TEXT '[' a1= TEXT ']' (a2= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder724); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            match(input,32,FOLLOW_32_in_definedplaceholder728); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder735); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;NormalToken proxy = ConcretesyntaxFactory.eINSTANCE.createNormalToken();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("token"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); 
            }
            match(input,33,FOLLOW_33_in_definedplaceholder739); if (failed) return element;
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:329:2: (a2= cardinality )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=36 && LA15_0<=38)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:330:3: a2= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder750);
                    a2=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("cardinality"), a2); copyLocalizationInfos(a2, element); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:334:1: derivedplaceholder returns [DerivedPlaceholder element = null] : a0= TEXT '[' ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )? ']' (a3= cardinality )? ;
    public final DerivedPlaceholder derivedplaceholder() throws RecognitionException {
        DerivedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Cardinality a3 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:338:1: (a0= TEXT '[' ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )? ']' (a3= cardinality )? )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:339:2: a0= TEXT '[' ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )? ']' (a3= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_derivedplaceholder777); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
            }
            match(input,32,FOLLOW_32_in_derivedplaceholder781); if (failed) return element;
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:341:2: ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==QUOTED_39_39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:342:3: (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? )
                    {
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:342:3: (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? )
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:343:4: a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )?
                    {
                    a1=(Token)input.LT(1);
                    match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder797); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
                    }
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:344:4: ( ( ',' a2= QUOTED_39_39 ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==18) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:345:5: ( ',' a2= QUOTED_39_39 )
                            {
                            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:345:5: ( ',' a2= QUOTED_39_39 )
                            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:346:6: ',' a2= QUOTED_39_39
                            {
                            match(input,18,FOLLOW_18_in_derivedplaceholder816); if (failed) return element;
                            a2=(Token)input.LT(1);
                            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder827); if (failed) return element;
                            if ( backtracking==0 ) {
                              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            match(input,33,FOLLOW_33_in_derivedplaceholder851); if (failed) return element;
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:353:2: (a3= cardinality )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=36 && LA18_0<=38)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:354:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder862);
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
    // $ANTLR end derivedplaceholder


    // $ANTLR start containment
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:358:1: containment returns [Containment element = null] : (a0= TEXT a1= cardinality | a2= TEXT ) ;
    public final Containment containment() throws RecognitionException {
        Containment element =  null;

        Token a0=null;
        Token a2=null;
        Cardinality a1 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createContainment();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:362:1: ( (a0= TEXT a1= cardinality | a2= TEXT ) )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:363:2: (a0= TEXT a1= cardinality | a2= TEXT )
            {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:363:2: (a0= TEXT a1= cardinality | a2= TEXT )
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
                        new NoViableAltException("363:2: (a0= TEXT a1= cardinality | a2= TEXT )", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("363:2: (a0= TEXT a1= cardinality | a2= TEXT )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:364:3: a0= TEXT a1= cardinality
                    {
                    a0=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_containment893); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); 
                    }
                    pushFollow(FOLLOW_cardinality_in_containment902);
                    a1=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("cardinality"), a1); copyLocalizationInfos(a1, element); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:368:3: a2= TEXT
                    {
                    a2=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_containment916); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:372:1: compounddefinition returns [CompoundDefinition element = null] : '(' a0= choice ')' (a1= cardinality )? ;
    public final CompoundDefinition compounddefinition() throws RecognitionException {
        CompoundDefinition element =  null;

        Choice a0 = null;

        Cardinality a1 = null;



        	element = ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:376:1: ( '(' a0= choice ')' (a1= cardinality )? )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:377:2: '(' a0= choice ')' (a1= cardinality )?
            {
            match(input,34,FOLLOW_34_in_compounddefinition938); if (failed) return element;
            pushFollow(FOLLOW_choice_in_compounddefinition945);
            a0=choice();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.eSet(element.eClass().getEStructuralFeature("definitions"), a0); copyLocalizationInfos(a0, element); 
            }
            match(input,35,FOLLOW_35_in_compounddefinition949); if (failed) return element;
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:380:2: (a1= cardinality )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=36 && LA20_0<=38)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:381:3: a1= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition960);
                    a1=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.eSet(element.eClass().getEStructuralFeature("cardinality"), a1); copyLocalizationInfos(a1, element); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:385:1: plus returns [PLUS element = null] : '+' ;
    public final PLUS plus() throws RecognitionException {
        PLUS element =  null;


        	element = ConcretesyntaxFactory.eINSTANCE.createPLUS();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:389:1: ( '+' )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:390:2: '+'
            {
            match(input,36,FOLLOW_36_in_plus983); if (failed) return element;

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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:393:1: star returns [STAR element = null] : '*' ;
    public final STAR star() throws RecognitionException {
        STAR element =  null;


        	element = ConcretesyntaxFactory.eINSTANCE.createSTAR();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:397:1: ( '*' )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:398:2: '*'
            {
            match(input,37,FOLLOW_37_in_star1001); if (failed) return element;

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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:401:1: questionmark returns [QUESTIONMARK element = null] : '?' ;
    public final QUESTIONMARK questionmark() throws RecognitionException {
        QUESTIONMARK element =  null;


        	element = ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:405:1: ( '?' )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:406:2: '?'
            {
            match(input,38,FOLLOW_38_in_questionmark1019); if (failed) return element;

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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:409:1: whitespaces returns [WhiteSpaces element = null] : a0= TEXT_35_ ;
    public final WhiteSpaces whitespaces() throws RecognitionException {
        WhiteSpaces element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:413:1: (a0= TEXT_35_ )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:414:2: a0= TEXT_35_
            {
            a0=(Token)input.LT(1);
            match(input,TEXT_35_,FOLLOW_TEXT_35__in_whitespaces1041); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_35_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("amount"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("amount"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:417:1: linebreak returns [LineBreak element = null] : a0= TEXT_33_ ;
    public final LineBreak linebreak() throws RecognitionException {
        LineBreak element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createLineBreak();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:421:1: (a0= TEXT_33_ )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:422:2: a0= TEXT_33_
            {
            a0=(Token)input.LT(1);
            match(input,TEXT_33_,FOLLOW_TEXT_33__in_linebreak1064); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_33_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("tab"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:425:1: normaltoken returns [NormalToken element = null] : 'DEFINE' a0= TEXT a1= QUOTED_36_36 ;
    public final NormalToken normaltoken() throws RecognitionException {
        NormalToken element =  null;

        Token a0=null;
        Token a1=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createNormalToken();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:429:1: ( 'DEFINE' a0= TEXT a1= QUOTED_36_36 )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:430:2: 'DEFINE' a0= TEXT a1= QUOTED_36_36
            {
            match(input,39,FOLLOW_39_in_normaltoken1083); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_normaltoken1090); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            a1=(Token)input.LT(1);
            match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken1098); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:435:1: decoratedtoken returns [DecoratedToken element = null] : 'DEFINE' a0= TEXT ( '[' (a1= QUOTED_39_39 ) ']' ) a2= QUOTED_36_36 ( '[' (a3= QUOTED_39_39 ) ']' ) ;
    public final DecoratedToken decoratedtoken() throws RecognitionException {
        DecoratedToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createDecoratedToken();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:439:1: ( 'DEFINE' a0= TEXT ( '[' (a1= QUOTED_39_39 ) ']' ) a2= QUOTED_36_36 ( '[' (a3= QUOTED_39_39 ) ']' ) )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:440:2: 'DEFINE' a0= TEXT ( '[' (a1= QUOTED_39_39 ) ']' ) a2= QUOTED_36_36 ( '[' (a3= QUOTED_39_39 ) ']' )
            {
            match(input,39,FOLLOW_39_in_decoratedtoken1117); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken1124); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:442:2: ( '[' (a1= QUOTED_39_39 ) ']' )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:443:3: '[' (a1= QUOTED_39_39 ) ']'
            {
            match(input,32,FOLLOW_32_in_decoratedtoken1132); if (failed) return element;
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:444:3: (a1= QUOTED_39_39 )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:445:4: a1= QUOTED_39_39
            {
            a1=(Token)input.LT(1);
            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1145); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a1, element); 
            }

            }

            match(input,33,FOLLOW_33_in_decoratedtoken1154); if (failed) return element;

            }

            a2=(Token)input.LT(1);
            match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1164); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); copyLocalizationInfos((CommonToken) a2, element); 
            }
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:450:2: ( '[' (a3= QUOTED_39_39 ) ']' )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:451:3: '[' (a3= QUOTED_39_39 ) ']'
            {
            match(input,32,FOLLOW_32_in_decoratedtoken1172); if (failed) return element;
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:452:3: (a3= QUOTED_39_39 )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:453:4: a3= QUOTED_39_39
            {
            a3=(Token)input.LT(1);
            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1185); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); copyLocalizationInfos((CommonToken) a3, element); 
            }

            }

            match(input,33,FOLLOW_33_in_decoratedtoken1194); if (failed) return element;

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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:459:1: predefinedtoken returns [PreDefinedToken element = null] : 'PREDEFINED' a0= TEXT ;
    public final PreDefinedToken predefinedtoken() throws RecognitionException {
        PreDefinedToken element =  null;

        Token a0=null;


        	element = ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();

        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:463:1: ( 'PREDEFINED' a0= TEXT )
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:464:2: 'PREDEFINED' a0= TEXT
            {
            match(input,40,FOLLOW_40_in_predefinedtoken1215); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1222); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); 
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:468:1: tokendefinition returns [TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );
    public final TokenDefinition tokendefinition() throws RecognitionException {
        TokenDefinition element =  null;

        NormalToken c0 = null;

        DecoratedToken c1 = null;

        PreDefinedToken c2 = null;


        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:470:1: (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken )
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
                            new NoViableAltException("468:1: tokendefinition returns [TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );", 21, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("468:1: tokendefinition returns [TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );", 21, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA21_0==40) ) {
                alt21=3;
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("468:1: tokendefinition returns [TokenDefinition element = null] : (c0= normaltoken | c1= decoratedtoken | c2= predefinedtoken );", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:471:2: c0= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1241);
                    c0=normaltoken();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:472:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1251);
                    c1=decoratedtoken();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:473:2: c2= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1261);
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:476:1: definition returns [Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );
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
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:478:1: (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak )
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
                            new NoViableAltException("476:1: definition returns [Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );", 22, 6, input);

                        throw nvae;
                    }
                }
                else if ( (LA22_2==EOF||LA22_2==TEXT||LA22_2==QUOTED_34_34||(LA22_2>=TEXT_35_ && LA22_2<=TEXT_33_)||LA22_2==23||LA22_2==31||(LA22_2>=34 && LA22_2<=38)) ) {
                    alt22=4;
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("476:1: definition returns [Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );", 22, 2, input);

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
                    new NoViableAltException("476:1: definition returns [Definition element = null] : (c0= csstring | c1= definedplaceholder | c2= derivedplaceholder | c3= containment | c4= compounddefinition | c5= whitespaces | c6= linebreak );", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:479:2: c0= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1280);
                    c0=csstring();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:480:2: c1= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1290);
                    c1=definedplaceholder();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:481:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1300);
                    c2=derivedplaceholder();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:482:2: c3= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1310);
                    c3=containment();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:483:2: c4= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1320);
                    c4=compounddefinition();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:484:2: c5= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1330);
                    c5=whitespaces();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:485:2: c6= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1340);
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
    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:488:1: cardinality returns [Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final Cardinality cardinality() throws RecognitionException {
        Cardinality element =  null;

        PLUS c0 = null;

        STAR c1 = null;

        QUESTIONMARK c2 = null;


        try {
            // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:490:1: (c0= plus | c1= star | c2= questionmark )
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
                    new NoViableAltException("488:1: cardinality returns [Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:491:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1359);
                    c0=plus();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:492:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1369);
                    c1=star();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\svenhart\\workspaces\\reuseware-development-st3\\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\sdk\\concretesyntax\\resource\\cs\\Cs.g:493:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1379);
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
    public static final BitSet FOLLOW_15_in_concretesyntax81 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax88 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_concretesyntax92 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax99 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_concretesyntax103 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax114 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax128 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_18_in_concretesyntax144 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax159 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax177 = new BitSet(new long[]{0x00000000034C0000L});
    public static final BitSet FOLLOW_19_in_concretesyntax203 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax208 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_keywordimport_in_concretesyntax230 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax248 = new BitSet(new long[]{0x0000000003400000L});
    public static final BitSet FOLLOW_22_in_concretesyntax268 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax273 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_option_in_concretesyntax295 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax303 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax320 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_concretesyntax340 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax345 = new BitSet(new long[]{0x0000018000200000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax367 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax375 = new BitSet(new long[]{0x0000018000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax392 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_concretesyntax403 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax406 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule_in_concretesyntax422 = new BitSet(new long[]{0x0000000000200050L});
    public static final BitSet FOLLOW_21_in_concretesyntax434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_keywordimport456 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_keywordimport460 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_keywordimport467 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_keywordimport480 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_keywordimport485 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_keywordimport494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_option525 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_option529 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_option536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_rule563 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_QNAME_in_rule577 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rule584 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_choice_in_rule591 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rule595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence621 = new BitSet(new long[]{0x0000000400000692L});
    public static final BitSet FOLLOW_sequence_in_choice648 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_choice661 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_sequence_in_choice670 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder724 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_definedplaceholder728 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder735 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_definedplaceholder739 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_derivedplaceholder777 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_derivedplaceholder781 = new BitSet(new long[]{0x0000000200000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder797 = new BitSet(new long[]{0x0000000200040000L});
    public static final BitSet FOLLOW_18_in_derivedplaceholder816 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder827 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_derivedplaceholder851 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment893 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_cardinality_in_containment902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_compounddefinition938 = new BitSet(new long[]{0x0000000400000690L});
    public static final BitSet FOLLOW_choice_in_compounddefinition945 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_compounddefinition949 = new BitSet(new long[]{0x0000007000000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_plus983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_star1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_questionmark1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_35__in_whitespaces1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_33__in_linebreak1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_normaltoken1083 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken1090 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_decoratedtoken1117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken1124 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1132 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1145 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1154 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1164 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_decoratedtoken1172 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1185 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_decoratedtoken1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_predefinedtoken1215 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1379 = new BitSet(new long[]{0x0000000000000002L});

}