// $ANTLR 3.0.1 C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g 2008-06-12 14:06:41

package org.reuseware.emftextedit.concretesyntax.resource.cs;

//+++++++++++++++++++++++imports for org.reuseware.emftextedit.concretesyntax begin++++++++++++++++++++++
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.ConcreteSyntaxImpl
import org.reuseware.emftextedit.concretesyntax.Import;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.ImportImpl
import org.reuseware.emftextedit.concretesyntax.Rule;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.RuleImpl
import org.reuseware.emftextedit.concretesyntax.Choice;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.ChoiceImpl
import org.reuseware.emftextedit.concretesyntax.Sequence;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.SequenceImpl
import org.reuseware.emftextedit.concretesyntax.Definition;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.DefinitionImpl
import org.reuseware.emftextedit.concretesyntax.Terminal;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.TerminalImpl
import org.reuseware.emftextedit.concretesyntax.CsString;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.CsStringImpl
import org.reuseware.emftextedit.concretesyntax.WhiteSpaces;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.WhiteSpacesImpl
import org.reuseware.emftextedit.concretesyntax.LineBreak;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.LineBreakImpl
import org.reuseware.emftextedit.concretesyntax.Cardinality;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.CardinalityImpl
import org.reuseware.emftextedit.concretesyntax.PLUS;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.PLUSImpl
import org.reuseware.emftextedit.concretesyntax.STAR;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.STARImpl
import org.reuseware.emftextedit.concretesyntax.QUESTIONMARK;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.QUESTIONMARKImpl
import org.reuseware.emftextedit.concretesyntax.CompoundDefinition;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.CompoundDefinitionImpl
import org.reuseware.emftextedit.concretesyntax.TokenDefinition;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.TokenDefinitionImpl
import org.reuseware.emftextedit.concretesyntax.NormalToken;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.NormalTokenImpl
import org.reuseware.emftextedit.concretesyntax.DecoratedToken;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.DecoratedTokenImpl
import org.reuseware.emftextedit.concretesyntax.NewDefinedToken;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.NewDefinedTokenImpl
import org.reuseware.emftextedit.concretesyntax.PreDefinedToken;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.PreDefinedTokenImpl
import org.reuseware.emftextedit.concretesyntax.Containment;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.ContainmentImpl
import org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.DefinedPlaceholderImpl
import org.reuseware.emftextedit.concretesyntax.DerivedPlaceholder;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.DerivedPlaceholderImpl
import org.reuseware.emftextedit.concretesyntax.Placeholder;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.PlaceholderImpl
import org.reuseware.emftextedit.concretesyntax.*;
import org.reuseware.emftextedit.concretesyntax.impl.*;
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
import org.eclipse.emf.ecore.impl.*;
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
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
//+++++++++++++++++++++++imports for org.reuseware.emftextedit.concretesyntax begin++++++++++++++++++++++
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.ConcreteSyntaxImpl
import org.reuseware.emftextedit.concretesyntax.Import;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.ImportImpl
import org.reuseware.emftextedit.concretesyntax.Rule;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.RuleImpl
import org.reuseware.emftextedit.concretesyntax.Choice;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.ChoiceImpl
import org.reuseware.emftextedit.concretesyntax.Sequence;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.SequenceImpl
import org.reuseware.emftextedit.concretesyntax.Definition;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.DefinitionImpl
import org.reuseware.emftextedit.concretesyntax.Terminal;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.TerminalImpl
import org.reuseware.emftextedit.concretesyntax.CsString;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.CsStringImpl
import org.reuseware.emftextedit.concretesyntax.WhiteSpaces;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.WhiteSpacesImpl
import org.reuseware.emftextedit.concretesyntax.LineBreak;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.LineBreakImpl
import org.reuseware.emftextedit.concretesyntax.Cardinality;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.CardinalityImpl
import org.reuseware.emftextedit.concretesyntax.PLUS;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.PLUSImpl
import org.reuseware.emftextedit.concretesyntax.STAR;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.STARImpl
import org.reuseware.emftextedit.concretesyntax.QUESTIONMARK;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.QUESTIONMARKImpl
import org.reuseware.emftextedit.concretesyntax.CompoundDefinition;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.CompoundDefinitionImpl
import org.reuseware.emftextedit.concretesyntax.TokenDefinition;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.TokenDefinitionImpl
import org.reuseware.emftextedit.concretesyntax.NormalToken;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.NormalTokenImpl
import org.reuseware.emftextedit.concretesyntax.DecoratedToken;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.DecoratedTokenImpl
import org.reuseware.emftextedit.concretesyntax.NewDefinedToken;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.NewDefinedTokenImpl
import org.reuseware.emftextedit.concretesyntax.PreDefinedToken;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.PreDefinedTokenImpl
import org.reuseware.emftextedit.concretesyntax.Containment;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.ContainmentImpl
import org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.DefinedPlaceholderImpl
import org.reuseware.emftextedit.concretesyntax.DerivedPlaceholder;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.DerivedPlaceholderImpl
import org.reuseware.emftextedit.concretesyntax.Placeholder;
//Implementation: org.reuseware.emftextedit.concretesyntax.impl.PlaceholderImpl
import org.reuseware.emftextedit.concretesyntax.*;
import org.reuseware.emftextedit.concretesyntax.impl.*;
import org.reuseware.emftextedit.resource.*;
import org.reuseware.emftextedit.resource.impl.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "TEXT", "QUOTED_60_62", "QNAME", "QUOTED_34_34", "QUOTED_39_39", "TEXT_35_", "TEXT_33_", "QUOTED_36_36", "COMMENTS", "LB", "WS", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'TOKENS'", "';'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'::='", "'|'", "'['", "']'", "'('", "')'", "'+'", "'*'", "'?'", "'DEFINE'", "'PREDEFINED'"
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
            ruleMemo = new HashMap[50+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g"; }

    
    	private TokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
    
    	protected EObject doParse() throws RecognitionException {
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:215:1: start returns [ EObject element = null] : c0= concretesyntax ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        ConcreteSyntax c0 = null;


        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:217:1: (c0= concretesyntax )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:218:1: c0= concretesyntax
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:222:1: concretesyntax returns [ConcreteSyntax element = null] : 'SYNTAXDEF' a0= TEXT 'FOR' a1= QUOTED_60_62 'START' (a2= TEXT | a3= QNAME ) ( ( ',' (a4= TEXT | a5= QNAME ) ) )* ( ( 'IMPORTS' '{' ( (a6= imporx ) )* '}' ) )? ( ( 'TOKENS' '{' ( (a7= tokendefinition ';' ) )* '}' ) )? 'RULES' '{' ( (a8= rule )+ ) '}' ;
    public final ConcreteSyntax concretesyntax() throws RecognitionException {
        ConcreteSyntax element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Import a6 = null;

        TokenDefinition a7 = null;

        Rule a8 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:226:1: ( 'SYNTAXDEF' a0= TEXT 'FOR' a1= QUOTED_60_62 'START' (a2= TEXT | a3= QNAME ) ( ( ',' (a4= TEXT | a5= QNAME ) ) )* ( ( 'IMPORTS' '{' ( (a6= imporx ) )* '}' ) )? ( ( 'TOKENS' '{' ( (a7= tokendefinition ';' ) )* '}' ) )? 'RULES' '{' ( (a8= rule )+ ) '}' )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:227:2: 'SYNTAXDEF' a0= TEXT 'FOR' a1= QUOTED_60_62 'START' (a2= TEXT | a3= QNAME ) ( ( ',' (a4= TEXT | a5= QNAME ) ) )* ( ( 'IMPORTS' '{' ( (a6= imporx ) )* '}' ) )? ( ( 'TOKENS' '{' ( (a7= tokendefinition ';' ) )* '}' ) )? 'RULES' '{' ( (a8= rule )+ ) '}'
            {
            match(input,15,FOLLOW_15_in_concretesyntax81); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_concretesyntax88); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
            }
            match(input,16,FOLLOW_16_in_concretesyntax92); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax99); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setPackage(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); 
            }
            match(input,17,FOLLOW_17_in_concretesyntax103); if (failed) return element;
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:232:2: (a2= TEXT | a3= QNAME )
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
                    new NoViableAltException("232:2: (a2= TEXT | a3= QNAME )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:233:3: a2= TEXT
                    {
                    a2=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_concretesyntax114); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:236:3: a3= QNAME
                    {
                    a3=(Token)input.LT(1);
                    match(input,QNAME,FOLLOW_QNAME_in_concretesyntax128); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(element, a3.getCharPositionInLine()); getResource().setElementLine(element, a3.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(proxy, a3.getCharPositionInLine()); getResource().setElementLine(proxy, a3.getLine()); 
                    }

                    }
                    break;

            }

            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:238:2: ( ( ',' (a4= TEXT | a5= QNAME ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:239:3: ( ',' (a4= TEXT | a5= QNAME ) )
            	    {
            	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:239:3: ( ',' (a4= TEXT | a5= QNAME ) )
            	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:240:4: ',' (a4= TEXT | a5= QNAME )
            	    {
            	    match(input,18,FOLLOW_18_in_concretesyntax144); if (failed) return element;
            	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:241:4: (a4= TEXT | a5= QNAME )
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
            	            new NoViableAltException("241:4: (a4= TEXT | a5= QNAME )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:242:5: a4= TEXT
            	            {
            	            a4=(Token)input.LT(1);
            	            match(input,TEXT,FOLLOW_TEXT_in_concretesyntax159); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a4).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a4).getStopIndex()); getResource().setElementColumn(element, a4.getCharPositionInLine()); getResource().setElementLine(element, a4.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a4).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a4).getStopIndex()); getResource().setElementColumn(proxy, a4.getCharPositionInLine()); getResource().setElementLine(proxy, a4.getLine()); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:245:5: a5= QNAME
            	            {
            	            a5=(Token)input.LT(1);
            	            match(input,QNAME,FOLLOW_QNAME_in_concretesyntax177); if (failed) return element;
            	            if ( backtracking==0 ) {
            	              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a5).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a5).getStopIndex()); getResource().setElementColumn(element, a5.getCharPositionInLine()); getResource().setElementLine(element, a5.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a5).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a5).getStopIndex()); getResource().setElementColumn(proxy, a5.getCharPositionInLine()); getResource().setElementLine(proxy, a5.getLine()); 
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

            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:249:2: ( ( 'IMPORTS' '{' ( (a6= imporx ) )* '}' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:250:3: ( 'IMPORTS' '{' ( (a6= imporx ) )* '}' )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:250:3: ( 'IMPORTS' '{' ( (a6= imporx ) )* '}' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:251:4: 'IMPORTS' '{' ( (a6= imporx ) )* '}'
                    {
                    match(input,19,FOLLOW_19_in_concretesyntax203); if (failed) return element;
                    match(input,20,FOLLOW_20_in_concretesyntax208); if (failed) return element;
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:253:4: ( (a6= imporx ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==TEXT) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:254:5: (a6= imporx )
                    	    {
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:254:5: (a6= imporx )
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:255:6: a6= imporx
                    	    {
                    	    pushFollow(FOLLOW_imporx_in_concretesyntax230);
                    	    a6=imporx();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      element.getImports().add(a6); getResource().setElementCharStart(element, getResource().getElementCharStart(a6)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a6)); getResource().setElementColumn(element, getResource().getElementColumn(a6)); getResource().setElementLine(element, getResource().getElementLine(a6));
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

            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:261:2: ( ( 'TOKENS' '{' ( (a7= tokendefinition ';' ) )* '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:262:3: ( 'TOKENS' '{' ( (a7= tokendefinition ';' ) )* '}' )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:262:3: ( 'TOKENS' '{' ( (a7= tokendefinition ';' ) )* '}' )
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:263:4: 'TOKENS' '{' ( (a7= tokendefinition ';' ) )* '}'
                    {
                    match(input,22,FOLLOW_22_in_concretesyntax268); if (failed) return element;
                    match(input,20,FOLLOW_20_in_concretesyntax273); if (failed) return element;
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:265:4: ( (a7= tokendefinition ';' ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=37 && LA6_0<=38)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:266:5: (a7= tokendefinition ';' )
                    	    {
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:266:5: (a7= tokendefinition ';' )
                    	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:267:6: a7= tokendefinition ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax295);
                    	    a7=tokendefinition();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      element.getTokens().add(a7); getResource().setElementCharStart(element, getResource().getElementCharStart(a7)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a7)); getResource().setElementColumn(element, getResource().getElementColumn(a7)); getResource().setElementLine(element, getResource().getElementLine(a7));
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

            match(input,24,FOLLOW_24_in_concretesyntax331); if (failed) return element;
            match(input,20,FOLLOW_20_in_concretesyntax334); if (failed) return element;
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:276:2: ( (a8= rule )+ )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:277:3: (a8= rule )+
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:277:3: (a8= rule )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==TEXT||LA8_0==QNAME) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:278:4: a8= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax350);
            	    a8=rule();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      element.getRules().add(a8); getResource().setElementCharStart(element, getResource().getElementCharStart(a8)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a8)); getResource().setElementColumn(element, getResource().getElementColumn(a8)); getResource().setElementLine(element, getResource().getElementLine(a8));
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (backtracking>0) {failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            match(input,21,FOLLOW_21_in_concretesyntax362); if (failed) return element;

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


    // $ANTLR start imporx
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:284:1: imporx returns [Import element = null] : a0= TEXT ':' a1= QUOTED_60_62 ( ( 'WITH' 'SYNTAX' a2= TEXT ) )? ;
    public final Import imporx() throws RecognitionException {
        Import element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createImport();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:288:1: (a0= TEXT ':' a1= QUOTED_60_62 ( ( 'WITH' 'SYNTAX' a2= TEXT ) )? )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:289:2: a0= TEXT ':' a1= QUOTED_60_62 ( ( 'WITH' 'SYNTAX' a2= TEXT ) )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_imporx384); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
            }
            match(input,25,FOLLOW_25_in_imporx388); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_imporx395); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setPackage(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); 
            }
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:292:2: ( ( 'WITH' 'SYNTAX' a2= TEXT ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:293:3: ( 'WITH' 'SYNTAX' a2= TEXT )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:293:3: ( 'WITH' 'SYNTAX' a2= TEXT )
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:294:4: 'WITH' 'SYNTAX' a2= TEXT
                    {
                    match(input,26,FOLLOW_26_in_imporx408); if (failed) return element;
                    match(input,27,FOLLOW_27_in_imporx413); if (failed) return element;
                    a2=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_imporx422); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;ConcreteSyntax proxy = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setConcreteSyntax(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); 
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
    // $ANTLR end imporx


    // $ANTLR start rule
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:301:1: rule returns [Rule element = null] : (a0= TEXT | a1= QNAME ) '::=' a2= choice ';' ;
    public final Rule rule() throws RecognitionException {
        Rule element =  null;

        Token a0=null;
        Token a1=null;
        Choice a2 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createRule();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:305:1: ( (a0= TEXT | a1= QNAME ) '::=' a2= choice ';' )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:306:2: (a0= TEXT | a1= QNAME ) '::=' a2= choice ';'
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:306:2: (a0= TEXT | a1= QNAME )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==TEXT) ) {
                alt10=1;
            }
            else if ( (LA10_0==QNAME) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("306:2: (a0= TEXT | a1= QNAME )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:307:3: a0= TEXT
                    {
                    a0=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_rule457); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setMetaclass(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:310:3: a1= QNAME
                    {
                    a1=(Token)input.LT(1);
                    match(input,QNAME,FOLLOW_QNAME_in_rule471); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setMetaclass(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); 
                    }

                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_rule478); if (failed) return element;
            pushFollow(FOLLOW_choice_in_rule485);
            a2=choice();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.setDefinition(a2); getResource().setElementCharStart(element, getResource().getElementCharStart(a2)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a2)); getResource().setElementColumn(element, getResource().getElementColumn(a2)); getResource().setElementLine(element, getResource().getElementLine(a2));
            }
            match(input,23,FOLLOW_23_in_rule489); if (failed) return element;

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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:317:1: sequence returns [Sequence element = null] : (a0= definition )+ ;
    public final Sequence sequence() throws RecognitionException {
        Sequence element =  null;

        Definition a0 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createSequence();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:321:1: ( (a0= definition )+ )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:322:2: (a0= definition )+
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:322:2: (a0= definition )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==TEXT||LA11_0==QUOTED_34_34||(LA11_0>=TEXT_35_ && LA11_0<=TEXT_33_)||LA11_0==32) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:323:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence515);
            	    a0=definition();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      element.getParts().add(a0); getResource().setElementCharStart(element, getResource().getElementCharStart(a0)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a0)); getResource().setElementColumn(element, getResource().getElementColumn(a0)); getResource().setElementLine(element, getResource().getElementLine(a0));
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (backtracking>0) {failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:327:1: choice returns [Choice element = null] : a0= sequence ( ( '|' a1= sequence ) )* ;
    public final Choice choice() throws RecognitionException {
        Choice element =  null;

        Sequence a0 = null;

        Sequence a1 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createChoice();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:331:1: (a0= sequence ( ( '|' a1= sequence ) )* )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:332:2: a0= sequence ( ( '|' a1= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice542);
            a0=sequence();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.getOptions().add(a0); getResource().setElementCharStart(element, getResource().getElementCharStart(a0)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a0)); getResource().setElementColumn(element, getResource().getElementColumn(a0)); getResource().setElementLine(element, getResource().getElementLine(a0));
            }
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:333:2: ( ( '|' a1= sequence ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==29) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:334:3: ( '|' a1= sequence )
            	    {
            	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:334:3: ( '|' a1= sequence )
            	    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:335:4: '|' a1= sequence
            	    {
            	    match(input,29,FOLLOW_29_in_choice555); if (failed) return element;
            	    pushFollow(FOLLOW_sequence_in_choice564);
            	    a1=sequence();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      element.getOptions().add(a1); getResource().setElementCharStart(element, getResource().getElementCharStart(a1)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a1)); getResource().setElementColumn(element, getResource().getElementColumn(a1)); getResource().setElementLine(element, getResource().getElementLine(a1));
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:341:1: csstring returns [CsString element = null] : a0= QUOTED_34_34 ;
    public final CsString csstring() throws RecognitionException {
        CsString element =  null;

        Token a0=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createCsString();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:345:1: (a0= QUOTED_34_34 )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:346:2: a0= QUOTED_34_34
            {
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring595); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setValue(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:349:1: definedplaceholder returns [DefinedPlaceholder element = null] : a0= TEXT '[' a1= TEXT ']' (a2= cardinality )? ;
    public final DefinedPlaceholder definedplaceholder() throws RecognitionException {
        DefinedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Cardinality a2 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:353:1: (a0= TEXT '[' a1= TEXT ']' (a2= cardinality )? )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:354:2: a0= TEXT '[' a1= TEXT ']' (a2= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder618); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); 
            }
            match(input,30,FOLLOW_30_in_definedplaceholder622); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder629); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;NormalToken proxy = ConcretesyntaxFactory.eINSTANCE.createNormalToken();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setToken(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); 
            }
            match(input,31,FOLLOW_31_in_definedplaceholder633); if (failed) return element;
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:358:2: (a2= cardinality )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=34 && LA13_0<=36)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:359:3: a2= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder644);
                    a2=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.setCardinality(a2); getResource().setElementCharStart(element, getResource().getElementCharStart(a2)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a2)); getResource().setElementColumn(element, getResource().getElementColumn(a2)); getResource().setElementLine(element, getResource().getElementLine(a2));
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:363:1: derivedplaceholder returns [DerivedPlaceholder element = null] : a0= TEXT '[' ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )? ']' (a3= cardinality )? ;
    public final DerivedPlaceholder derivedplaceholder() throws RecognitionException {
        DerivedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Cardinality a3 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:367:1: (a0= TEXT '[' ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )? ']' (a3= cardinality )? )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:368:2: a0= TEXT '[' ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )? ']' (a3= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_derivedplaceholder671); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); 
            }
            match(input,30,FOLLOW_30_in_derivedplaceholder675); if (failed) return element;
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:370:2: ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==QUOTED_39_39) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:371:3: (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? )
                    {
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:371:3: (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? )
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:372:4: a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )?
                    {
                    a1=(Token)input.LT(1);
                    match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder691); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); 
                    }
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:373:4: ( ( ',' a2= QUOTED_39_39 ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==18) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:374:5: ( ',' a2= QUOTED_39_39 )
                            {
                            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:374:5: ( ',' a2= QUOTED_39_39 )
                            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:375:6: ',' a2= QUOTED_39_39
                            {
                            match(input,18,FOLLOW_18_in_derivedplaceholder710); if (failed) return element;
                            a2=(Token)input.LT(1);
                            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder721); if (failed) return element;
                            if ( backtracking==0 ) {
                              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setSuffix(resolved); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); 
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_derivedplaceholder745); if (failed) return element;
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:382:2: (a3= cardinality )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=34 && LA16_0<=36)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:383:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder756);
                    a3=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.setCardinality(a3); getResource().setElementCharStart(element, getResource().getElementCharStart(a3)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a3)); getResource().setElementColumn(element, getResource().getElementColumn(a3)); getResource().setElementLine(element, getResource().getElementLine(a3));
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:387:1: containment returns [Containment element = null] : (a0= TEXT a1= cardinality | a2= TEXT ) ;
    public final Containment containment() throws RecognitionException {
        Containment element =  null;

        Token a0=null;
        Token a2=null;
        Cardinality a1 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createContainment();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:391:1: ( (a0= TEXT a1= cardinality | a2= TEXT ) )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:392:2: (a0= TEXT a1= cardinality | a2= TEXT )
            {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:392:2: (a0= TEXT a1= cardinality | a2= TEXT )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==TEXT) ) {
                int LA17_1 = input.LA(2);

                if ( ((LA17_1>=34 && LA17_1<=36)) ) {
                    alt17=1;
                }
                else if ( (LA17_1==EOF||LA17_1==TEXT||LA17_1==QUOTED_34_34||(LA17_1>=TEXT_35_ && LA17_1<=TEXT_33_)||LA17_1==23||LA17_1==29||(LA17_1>=32 && LA17_1<=33)) ) {
                    alt17=2;
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("392:2: (a0= TEXT a1= cardinality | a2= TEXT )", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("392:2: (a0= TEXT a1= cardinality | a2= TEXT )", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:393:3: a0= TEXT a1= cardinality
                    {
                    a0=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_containment787); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); 
                    }
                    pushFollow(FOLLOW_cardinality_in_containment796);
                    a1=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.setCardinality(a1); getResource().setElementCharStart(element, getResource().getElementCharStart(a1)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a1)); getResource().setElementColumn(element, getResource().getElementColumn(a1)); getResource().setElementLine(element, getResource().getElementLine(a1));
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:397:3: a2= TEXT
                    {
                    a2=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_containment810); if (failed) return element;
                    if ( backtracking==0 ) {
                      TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); 
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:401:1: compounddefinition returns [CompoundDefinition element = null] : '(' a0= choice ')' (a1= cardinality )? ;
    public final CompoundDefinition compounddefinition() throws RecognitionException {
        CompoundDefinition element =  null;

        Choice a0 = null;

        Cardinality a1 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:405:1: ( '(' a0= choice ')' (a1= cardinality )? )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:406:2: '(' a0= choice ')' (a1= cardinality )?
            {
            match(input,32,FOLLOW_32_in_compounddefinition832); if (failed) return element;
            pushFollow(FOLLOW_choice_in_compounddefinition839);
            a0=choice();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.setDefinitions(a0); getResource().setElementCharStart(element, getResource().getElementCharStart(a0)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a0)); getResource().setElementColumn(element, getResource().getElementColumn(a0)); getResource().setElementLine(element, getResource().getElementLine(a0));
            }
            match(input,33,FOLLOW_33_in_compounddefinition843); if (failed) return element;
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:409:2: (a1= cardinality )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=34 && LA18_0<=36)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:410:3: a1= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition854);
                    a1=cardinality();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                      element.setCardinality(a1); getResource().setElementCharStart(element, getResource().getElementCharStart(a1)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a1)); getResource().setElementColumn(element, getResource().getElementColumn(a1)); getResource().setElementLine(element, getResource().getElementLine(a1));
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:414:1: plus returns [PLUS element = null] : '+' ;
    public final PLUS plus() throws RecognitionException {
        PLUS element =  null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createPLUS();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:418:1: ( '+' )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:419:2: '+'
            {
            match(input,34,FOLLOW_34_in_plus877); if (failed) return element;

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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:422:1: star returns [STAR element = null] : '*' ;
    public final STAR star() throws RecognitionException {
        STAR element =  null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createSTAR();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:426:1: ( '*' )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:427:2: '*'
            {
            match(input,35,FOLLOW_35_in_star895); if (failed) return element;

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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:430:1: questionmark returns [QUESTIONMARK element = null] : '?' ;
    public final QUESTIONMARK questionmark() throws RecognitionException {
        QUESTIONMARK element =  null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:434:1: ( '?' )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:435:2: '?'
            {
            match(input,36,FOLLOW_36_in_questionmark913); if (failed) return element;

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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:438:1: whitespaces returns [WhiteSpaces element = null] : a0= TEXT_35_ ;
    public final WhiteSpaces whitespaces() throws RecognitionException {
        WhiteSpaces element =  null;

        Token a0=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:442:1: (a0= TEXT_35_ )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:443:2: a0= TEXT_35_
            {
            a0=(Token)input.LT(1);
            match(input,TEXT_35_,FOLLOW_TEXT_35__in_whitespaces935); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_35_");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("ammount"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (Integer)resolvedObject;element.setAmmount(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:446:1: linebreak returns [LineBreak element = null] : a0= TEXT_33_ ;
    public final LineBreak linebreak() throws RecognitionException {
        LineBreak element =  null;

        Token a0=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createLineBreak();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:450:1: (a0= TEXT_33_ )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:451:2: a0= TEXT_33_
            {
            a0=(Token)input.LT(1);
            match(input,TEXT_33_,FOLLOW_TEXT_33__in_linebreak958); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_33_");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (Integer)resolvedObject;element.setTab(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:454:1: normaltoken returns [NormalToken element = null] : 'DEFINE' a0= TEXT a1= QUOTED_36_36 ;
    public final NormalToken normaltoken() throws RecognitionException {
        NormalToken element =  null;

        Token a0=null;
        Token a1=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createNormalToken();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:458:1: ( 'DEFINE' a0= TEXT a1= QUOTED_36_36 )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:459:2: 'DEFINE' a0= TEXT a1= QUOTED_36_36
            {
            match(input,37,FOLLOW_37_in_normaltoken977); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_normaltoken984); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
            }
            a1=(Token)input.LT(1);
            match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken992); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setRegex(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); 
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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:464:1: decoratedtoken returns [DecoratedToken element = null] : 'DEFINE' a0= TEXT ( '[' (a1= QUOTED_39_39 ) ']' ) a2= QUOTED_36_36 ( '[' (a3= QUOTED_39_39 ) ']' ) ;
    public final DecoratedToken decoratedtoken() throws RecognitionException {
        DecoratedToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createDecoratedToken();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:468:1: ( 'DEFINE' a0= TEXT ( '[' (a1= QUOTED_39_39 ) ']' ) a2= QUOTED_36_36 ( '[' (a3= QUOTED_39_39 ) ']' ) )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:469:2: 'DEFINE' a0= TEXT ( '[' (a1= QUOTED_39_39 ) ']' ) a2= QUOTED_36_36 ( '[' (a3= QUOTED_39_39 ) ']' )
            {
            match(input,37,FOLLOW_37_in_decoratedtoken1011); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken1018); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
            }
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:471:2: ( '[' (a1= QUOTED_39_39 ) ']' )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:472:3: '[' (a1= QUOTED_39_39 ) ']'
            {
            match(input,30,FOLLOW_30_in_decoratedtoken1026); if (failed) return element;
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:473:3: (a1= QUOTED_39_39 )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:474:4: a1= QUOTED_39_39
            {
            a1=(Token)input.LT(1);
            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1039); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); 
            }

            }

            match(input,31,FOLLOW_31_in_decoratedtoken1048); if (failed) return element;

            }

            a2=(Token)input.LT(1);
            match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken1058); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setRegex(resolved); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); 
            }
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:479:2: ( '[' (a3= QUOTED_39_39 ) ']' )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:480:3: '[' (a3= QUOTED_39_39 ) ']'
            {
            match(input,30,FOLLOW_30_in_decoratedtoken1066); if (failed) return element;
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:481:3: (a3= QUOTED_39_39 )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:482:4: a3= QUOTED_39_39
            {
            a3=(Token)input.LT(1);
            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1079); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setSuffix(resolved); getResource().setElementCharStart(element, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(element, a3.getCharPositionInLine()); getResource().setElementLine(element, a3.getLine()); 
            }

            }

            match(input,31,FOLLOW_31_in_decoratedtoken1088); if (failed) return element;

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
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:488:1: predefinedtoken returns [PreDefinedToken element = null] : 'PREDEFINED' a0= TEXT ;
    public final PreDefinedToken predefinedtoken() throws RecognitionException {
        PreDefinedToken element =  null;

        Token a0=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();

        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:492:1: ( 'PREDEFINED' a0= TEXT )
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:493:2: 'PREDEFINED' a0= TEXT
            {
            match(input,38,FOLLOW_38_in_predefinedtoken1109); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1116); if (failed) return element;
            if ( backtracking==0 ) {
              TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
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


    // $ANTLR start definition
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:497:1: definition returns [Definition element = null] : (c0= linebreak | c1= derivedplaceholder | c2= compounddefinition | c3= csstring | c4= whitespaces | c5= definedplaceholder | c6= containment );
    public final Definition definition() throws RecognitionException {
        Definition element =  null;

        LineBreak c0 = null;

        DerivedPlaceholder c1 = null;

        CompoundDefinition c2 = null;

        CsString c3 = null;

        WhiteSpaces c4 = null;

        DefinedPlaceholder c5 = null;

        Containment c6 = null;


        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:499:1: (c0= linebreak | c1= derivedplaceholder | c2= compounddefinition | c3= csstring | c4= whitespaces | c5= definedplaceholder | c6= containment )
            int alt19=7;
            switch ( input.LA(1) ) {
            case TEXT_33_:
                {
                alt19=1;
                }
                break;
            case TEXT:
                {
                int LA19_2 = input.LA(2);

                if ( (LA19_2==30) ) {
                    int LA19_6 = input.LA(3);

                    if ( (LA19_6==TEXT) ) {
                        alt19=6;
                    }
                    else if ( (LA19_6==QUOTED_39_39||LA19_6==31) ) {
                        alt19=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("497:1: definition returns [Definition element = null] : (c0= linebreak | c1= derivedplaceholder | c2= compounddefinition | c3= csstring | c4= whitespaces | c5= definedplaceholder | c6= containment );", 19, 6, input);

                        throw nvae;
                    }
                }
                else if ( (LA19_2==EOF||LA19_2==TEXT||LA19_2==QUOTED_34_34||(LA19_2>=TEXT_35_ && LA19_2<=TEXT_33_)||LA19_2==23||LA19_2==29||(LA19_2>=32 && LA19_2<=36)) ) {
                    alt19=7;
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("497:1: definition returns [Definition element = null] : (c0= linebreak | c1= derivedplaceholder | c2= compounddefinition | c3= csstring | c4= whitespaces | c5= definedplaceholder | c6= containment );", 19, 2, input);

                    throw nvae;
                }
                }
                break;
            case 32:
                {
                alt19=3;
                }
                break;
            case QUOTED_34_34:
                {
                alt19=4;
                }
                break;
            case TEXT_35_:
                {
                alt19=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("497:1: definition returns [Definition element = null] : (c0= linebreak | c1= derivedplaceholder | c2= compounddefinition | c3= csstring | c4= whitespaces | c5= definedplaceholder | c6= containment );", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:500:2: c0= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1135);
                    c0=linebreak();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:501:2: c1= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1145);
                    c1=derivedplaceholder();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:502:2: c2= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1155);
                    c2=compounddefinition();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:503:2: c3= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1165);
                    c3=csstring();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:504:2: c4= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1175);
                    c4=whitespaces();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:505:2: c5= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1185);
                    c5=definedplaceholder();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:506:2: c6= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1195);
                    c6=containment();
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


    // $ANTLR start tokendefinition
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:509:1: tokendefinition returns [TokenDefinition element = null] : (c0= predefinedtoken | c1= normaltoken | c2= decoratedtoken );
    public final TokenDefinition tokendefinition() throws RecognitionException {
        TokenDefinition element =  null;

        PreDefinedToken c0 = null;

        NormalToken c1 = null;

        DecoratedToken c2 = null;


        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:511:1: (c0= predefinedtoken | c1= normaltoken | c2= decoratedtoken )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==38) ) {
                alt20=1;
            }
            else if ( (LA20_0==37) ) {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==TEXT) ) {
                    int LA20_3 = input.LA(3);

                    if ( (LA20_3==QUOTED_36_36) ) {
                        alt20=2;
                    }
                    else if ( (LA20_3==30) ) {
                        alt20=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("509:1: tokendefinition returns [TokenDefinition element = null] : (c0= predefinedtoken | c1= normaltoken | c2= decoratedtoken );", 20, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("509:1: tokendefinition returns [TokenDefinition element = null] : (c0= predefinedtoken | c1= normaltoken | c2= decoratedtoken );", 20, 2, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("509:1: tokendefinition returns [TokenDefinition element = null] : (c0= predefinedtoken | c1= normaltoken | c2= decoratedtoken );", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:512:2: c0= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1214);
                    c0=predefinedtoken();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:513:2: c1= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1224);
                    c1=normaltoken();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:514:2: c2= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1234);
                    c2=decoratedtoken();
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


    // $ANTLR start cardinality
    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:517:1: cardinality returns [Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );
    public final Cardinality cardinality() throws RecognitionException {
        Cardinality element =  null;

        PLUS c0 = null;

        STAR c1 = null;

        QUESTIONMARK c2 = null;


        try {
            // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:519:1: (c0= plus | c1= star | c2= questionmark )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt21=1;
                }
                break;
            case 35:
                {
                alt21=2;
                }
                break;
            case 36:
                {
                alt21=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("517:1: cardinality returns [Cardinality element = null] : (c0= plus | c1= star | c2= questionmark );", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:520:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1253);
                    c0=plus();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:521:2: c1= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1263);
                    c1=star();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\work\\reusewareSvn\\EMFTextEdit\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:522:2: c2= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1273);
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
    public static final BitSet FOLLOW_TEXT_in_concretesyntax114 = new BitSet(new long[]{0x00000000014C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax128 = new BitSet(new long[]{0x00000000014C0000L});
    public static final BitSet FOLLOW_18_in_concretesyntax144 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax159 = new BitSet(new long[]{0x00000000014C0000L});
    public static final BitSet FOLLOW_QNAME_in_concretesyntax177 = new BitSet(new long[]{0x00000000014C0000L});
    public static final BitSet FOLLOW_19_in_concretesyntax203 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax208 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_imporx_in_concretesyntax230 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax248 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_22_in_concretesyntax268 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax273 = new BitSet(new long[]{0x0000006000200000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax295 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax303 = new BitSet(new long[]{0x0000006000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax320 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_concretesyntax331 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax334 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule_in_concretesyntax350 = new BitSet(new long[]{0x0000000000200050L});
    public static final BitSet FOLLOW_21_in_concretesyntax362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_imporx384 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_imporx388 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_imporx395 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_imporx408 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_imporx413 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_imporx422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_rule457 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_QNAME_in_rule471 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule478 = new BitSet(new long[]{0x0000000100000690L});
    public static final BitSet FOLLOW_choice_in_rule485 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rule489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence515 = new BitSet(new long[]{0x0000000100000692L});
    public static final BitSet FOLLOW_sequence_in_choice542 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_choice555 = new BitSet(new long[]{0x0000000100000690L});
    public static final BitSet FOLLOW_sequence_in_choice564 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder618 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_definedplaceholder622 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder629 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_definedplaceholder633 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_derivedplaceholder671 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_derivedplaceholder675 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder691 = new BitSet(new long[]{0x0000000080040000L});
    public static final BitSet FOLLOW_18_in_derivedplaceholder710 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder721 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_derivedplaceholder745 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment787 = new BitSet(new long[]{0x0000001C00000000L});
    public static final BitSet FOLLOW_cardinality_in_containment796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_compounddefinition832 = new BitSet(new long[]{0x0000000100000690L});
    public static final BitSet FOLLOW_choice_in_compounddefinition839 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_compounddefinition843 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_plus877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_star895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_questionmark913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_35__in_whitespaces935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_33__in_linebreak958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_normaltoken977 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken984 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_decoratedtoken1011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken1018 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1026 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1039 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1048 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken1058 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1066 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1079 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_predefinedtoken1109 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1273 = new BitSet(new long[]{0x0000000000000002L});

}