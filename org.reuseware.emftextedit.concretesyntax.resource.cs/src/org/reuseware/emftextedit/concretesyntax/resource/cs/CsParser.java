// $ANTLR 3.0.1 C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g 2008-05-28 18:02:16

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
            ruleMemo = new HashMap[48+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g"; }

    
    	private TokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
    
    	protected EObject doParse() throws RecognitionException {
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		return start();
    	}



    // $ANTLR start start
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:164:1: start returns [ EObject element = null] : c0= concretesyntax ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        ConcreteSyntax c0 = null;


        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:166:1: (c0= concretesyntax )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:167:1: c0= concretesyntax
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:171:1: concretesyntax returns [ConcreteSyntax element = null] : 'SYNTAXDEF' a0= TEXT 'FOR' a1= QUOTED_60_62 'START' a2= TEXT ( ( ',' a3= TEXT ) )* ( ( 'IMPORTS' '{' ( (a4= imporx ) )* '}' ) )? ( ( 'TOKENS' '{' ( (a5= tokendefinition ';' ) )* '}' ) )? 'RULES' '{' ( (a6= rule )+ ) '}' ;
    public final ConcreteSyntax concretesyntax() throws RecognitionException {
        ConcreteSyntax element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Import a4 = null;

        TokenDefinition a5 = null;

        Rule a6 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:175:1: ( 'SYNTAXDEF' a0= TEXT 'FOR' a1= QUOTED_60_62 'START' a2= TEXT ( ( ',' a3= TEXT ) )* ( ( 'IMPORTS' '{' ( (a4= imporx ) )* '}' ) )? ( ( 'TOKENS' '{' ( (a5= tokendefinition ';' ) )* '}' ) )? 'RULES' '{' ( (a6= rule )+ ) '}' )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:176:2: 'SYNTAXDEF' a0= TEXT 'FOR' a1= QUOTED_60_62 'START' a2= TEXT ( ( ',' a3= TEXT ) )* ( ( 'IMPORTS' '{' ( (a4= imporx ) )* '}' ) )? ( ( 'TOKENS' '{' ( (a5= tokendefinition ';' ) )* '}' ) )? 'RULES' '{' ( (a6= rule )+ ) '}'
            {
            match(input,15,FOLLOW_15_in_concretesyntax81); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_concretesyntax88); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
            }
            match(input,16,FOLLOW_16_in_concretesyntax92); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_concretesyntax99); if (failed) return element;
            if ( backtracking==0 ) {
              String resolved = (String) tokenResolverFactory.createTokenResolver("QUOTED_60_62").resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setPackage(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); 
            }
            match(input,17,FOLLOW_17_in_concretesyntax103); if (failed) return element;
            a2=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_concretesyntax110); if (failed) return element;
            if ( backtracking==0 ) {
              String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a2.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); 
            }
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:182:2: ( ( ',' a3= TEXT ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:183:3: ( ',' a3= TEXT )
            	    {
            	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:183:3: ( ',' a3= TEXT )
            	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:184:4: ',' a3= TEXT
            	    {
            	    match(input,18,FOLLOW_18_in_concretesyntax123); if (failed) return element;
            	    a3=(Token)input.LT(1);
            	    match(input,TEXT,FOLLOW_TEXT_in_concretesyntax132); if (failed) return element;
            	    if ( backtracking==0 ) {
            	      String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a3.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(element, a3.getCharPositionInLine()); getResource().setElementLine(element, a3.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(proxy, a3.getCharPositionInLine()); getResource().setElementLine(proxy, a3.getLine()); 
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:188:2: ( ( 'IMPORTS' '{' ( (a4= imporx ) )* '}' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:189:3: ( 'IMPORTS' '{' ( (a4= imporx ) )* '}' )
                    {
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:189:3: ( 'IMPORTS' '{' ( (a4= imporx ) )* '}' )
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:190:4: 'IMPORTS' '{' ( (a4= imporx ) )* '}'
                    {
                    match(input,19,FOLLOW_19_in_concretesyntax153); if (failed) return element;
                    match(input,20,FOLLOW_20_in_concretesyntax158); if (failed) return element;
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:192:4: ( (a4= imporx ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==TEXT) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:193:5: (a4= imporx )
                    	    {
                    	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:193:5: (a4= imporx )
                    	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:194:6: a4= imporx
                    	    {
                    	    pushFollow(FOLLOW_imporx_in_concretesyntax180);
                    	    a4=imporx();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      element.getImports().add(a4); getResource().setElementCharStart(element, getResource().getElementCharStart(a4)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a4)); getResource().setElementColumn(element, getResource().getElementColumn(a4)); getResource().setElementLine(element, getResource().getElementLine(a4));
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match(input,21,FOLLOW_21_in_concretesyntax198); if (failed) return element;

                    }


                    }
                    break;

            }

            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:200:2: ( ( 'TOKENS' '{' ( (a5= tokendefinition ';' ) )* '}' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:201:3: ( 'TOKENS' '{' ( (a5= tokendefinition ';' ) )* '}' )
                    {
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:201:3: ( 'TOKENS' '{' ( (a5= tokendefinition ';' ) )* '}' )
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:202:4: 'TOKENS' '{' ( (a5= tokendefinition ';' ) )* '}'
                    {
                    match(input,22,FOLLOW_22_in_concretesyntax218); if (failed) return element;
                    match(input,20,FOLLOW_20_in_concretesyntax223); if (failed) return element;
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:204:4: ( (a5= tokendefinition ';' ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=37 && LA4_0<=38)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:205:5: (a5= tokendefinition ';' )
                    	    {
                    	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:205:5: (a5= tokendefinition ';' )
                    	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:206:6: a5= tokendefinition ';'
                    	    {
                    	    pushFollow(FOLLOW_tokendefinition_in_concretesyntax245);
                    	    a5=tokendefinition();
                    	    _fsp--;
                    	    if (failed) return element;
                    	    if ( backtracking==0 ) {
                    	      element.getTokens().add(a5); getResource().setElementCharStart(element, getResource().getElementCharStart(a5)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a5)); getResource().setElementColumn(element, getResource().getElementColumn(a5)); getResource().setElementLine(element, getResource().getElementLine(a5));
                    	    }
                    	    match(input,23,FOLLOW_23_in_concretesyntax253); if (failed) return element;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match(input,21,FOLLOW_21_in_concretesyntax270); if (failed) return element;

                    }


                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_concretesyntax281); if (failed) return element;
            match(input,20,FOLLOW_20_in_concretesyntax284); if (failed) return element;
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:215:2: ( (a6= rule )+ )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:216:3: (a6= rule )+
            {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:216:3: (a6= rule )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==TEXT||LA6_0==QNAME) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:217:4: a6= rule
            	    {
            	    pushFollow(FOLLOW_rule_in_concretesyntax300);
            	    a6=rule();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      element.getRules().add(a6); getResource().setElementCharStart(element, getResource().getElementCharStart(a6)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a6)); getResource().setElementColumn(element, getResource().getElementColumn(a6)); getResource().setElementLine(element, getResource().getElementLine(a6));
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (backtracking>0) {failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            match(input,21,FOLLOW_21_in_concretesyntax312); if (failed) return element;

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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:223:1: imporx returns [Import element = null] : a0= TEXT ':' a1= QUOTED_60_62 ( ( 'WITH' 'SYNTAX' a2= TEXT ) )? ;
    public final Import imporx() throws RecognitionException {
        Import element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createImport();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:227:1: (a0= TEXT ':' a1= QUOTED_60_62 ( ( 'WITH' 'SYNTAX' a2= TEXT ) )? )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:228:2: a0= TEXT ':' a1= QUOTED_60_62 ( ( 'WITH' 'SYNTAX' a2= TEXT ) )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_imporx334); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
            }
            match(input,25,FOLLOW_25_in_imporx338); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_imporx345); if (failed) return element;
            if ( backtracking==0 ) {
              String resolved = (String) tokenResolverFactory.createTokenResolver("QUOTED_60_62").resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setPackage(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); 
            }
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:231:2: ( ( 'WITH' 'SYNTAX' a2= TEXT ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==26) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:232:3: ( 'WITH' 'SYNTAX' a2= TEXT )
                    {
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:232:3: ( 'WITH' 'SYNTAX' a2= TEXT )
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:233:4: 'WITH' 'SYNTAX' a2= TEXT
                    {
                    match(input,26,FOLLOW_26_in_imporx358); if (failed) return element;
                    match(input,27,FOLLOW_27_in_imporx363); if (failed) return element;
                    a2=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_imporx372); if (failed) return element;
                    if ( backtracking==0 ) {
                      String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a2.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());ConcreteSyntax proxy = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setConcreteSyntax(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); 
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:240:1: rule returns [Rule element = null] : (a0= TEXT | a1= QNAME ) '::=' a2= choice ';' ;
    public final Rule rule() throws RecognitionException {
        Rule element =  null;

        Token a0=null;
        Token a1=null;
        Choice a2 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createRule();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:244:1: ( (a0= TEXT | a1= QNAME ) '::=' a2= choice ';' )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:245:2: (a0= TEXT | a1= QNAME ) '::=' a2= choice ';'
            {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:245:2: (a0= TEXT | a1= QNAME )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==TEXT) ) {
                alt8=1;
            }
            else if ( (LA8_0==QNAME) ) {
                alt8=2;
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("245:2: (a0= TEXT | a1= QNAME )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:246:3: a0= TEXT
                    {
                    a0=(Token)input.LT(1);
                    match(input,TEXT,FOLLOW_TEXT_in_rule407); if (failed) return element;
                    if ( backtracking==0 ) {
                      String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setMetaclass(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:249:3: a1= QNAME
                    {
                    a1=(Token)input.LT(1);
                    match(input,QNAME,FOLLOW_QNAME_in_rule421); if (failed) return element;
                    if ( backtracking==0 ) {
                      String resolved = (String) tokenResolverFactory.createTokenResolver("QNAME").resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setMetaclass(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); 
                    }

                    }
                    break;

            }

            match(input,28,FOLLOW_28_in_rule428); if (failed) return element;
            pushFollow(FOLLOW_choice_in_rule435);
            a2=choice();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.setDefinition(a2); getResource().setElementCharStart(element, getResource().getElementCharStart(a2)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a2)); getResource().setElementColumn(element, getResource().getElementColumn(a2)); getResource().setElementLine(element, getResource().getElementLine(a2));
            }
            match(input,23,FOLLOW_23_in_rule439); if (failed) return element;

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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:256:1: sequence returns [Sequence element = null] : (a0= definition )+ ;
    public final Sequence sequence() throws RecognitionException {
        Sequence element =  null;

        Definition a0 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createSequence();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:260:1: ( (a0= definition )+ )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:261:2: (a0= definition )+
            {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:261:2: (a0= definition )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==TEXT||LA9_0==QUOTED_34_34||(LA9_0>=TEXT_35_ && LA9_0<=TEXT_33_)||LA9_0==32) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:262:3: a0= definition
            	    {
            	    pushFollow(FOLLOW_definition_in_sequence465);
            	    a0=definition();
            	    _fsp--;
            	    if (failed) return element;
            	    if ( backtracking==0 ) {
            	      element.getParts().add(a0); getResource().setElementCharStart(element, getResource().getElementCharStart(a0)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a0)); getResource().setElementColumn(element, getResource().getElementColumn(a0)); getResource().setElementLine(element, getResource().getElementLine(a0));
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (backtracking>0) {failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:266:1: choice returns [Choice element = null] : a0= sequence ( ( '|' a1= sequence ) )* ;
    public final Choice choice() throws RecognitionException {
        Choice element =  null;

        Sequence a0 = null;

        Sequence a1 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createChoice();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:270:1: (a0= sequence ( ( '|' a1= sequence ) )* )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:271:2: a0= sequence ( ( '|' a1= sequence ) )*
            {
            pushFollow(FOLLOW_sequence_in_choice492);
            a0=sequence();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.getOptions().add(a0); getResource().setElementCharStart(element, getResource().getElementCharStart(a0)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a0)); getResource().setElementColumn(element, getResource().getElementColumn(a0)); getResource().setElementLine(element, getResource().getElementLine(a0));
            }
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:272:2: ( ( '|' a1= sequence ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==29) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:273:3: ( '|' a1= sequence )
            	    {
            	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:273:3: ( '|' a1= sequence )
            	    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:274:4: '|' a1= sequence
            	    {
            	    match(input,29,FOLLOW_29_in_choice505); if (failed) return element;
            	    pushFollow(FOLLOW_sequence_in_choice514);
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
            	    break loop10;
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:280:1: csstring returns [CsString element = null] : a0= QUOTED_34_34 ;
    public final CsString csstring() throws RecognitionException {
        CsString element =  null;

        Token a0=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createCsString();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:284:1: (a0= QUOTED_34_34 )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:285:2: a0= QUOTED_34_34
            {
            a0=(Token)input.LT(1);
            match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_csstring545); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_34_34").resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());element.setValue(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:288:1: definedplaceholder returns [DefinedPlaceholder element = null] : a0= TEXT '[' a1= TEXT ']' (a2= cardinality )? ;
    public final DefinedPlaceholder definedplaceholder() throws RecognitionException {
        DefinedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Cardinality a2 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:292:1: (a0= TEXT '[' a1= TEXT ']' (a2= cardinality )? )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:293:2: a0= TEXT '[' a1= TEXT ']' (a2= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder568); if (failed) return element;
            if ( backtracking==0 ) {
              String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); 
            }
            match(input,30,FOLLOW_30_in_definedplaceholder572); if (failed) return element;
            a1=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_definedplaceholder579); if (failed) return element;
            if ( backtracking==0 ) {
              String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a1.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());NormalToken proxy = ConcretesyntaxFactory.eINSTANCE.createNormalToken();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setToken(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); 
            }
            match(input,31,FOLLOW_31_in_definedplaceholder583); if (failed) return element;
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:297:2: (a2= cardinality )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=34 && LA11_0<=36)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:298:3: a2= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_definedplaceholder594);
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:302:1: derivedplaceholder returns [DerivedPlaceholder element = null] : a0= TEXT '[' ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )? ']' (a3= cardinality )? ;
    public final DerivedPlaceholder derivedplaceholder() throws RecognitionException {
        DerivedPlaceholder element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Cardinality a3 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:306:1: (a0= TEXT '[' ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )? ']' (a3= cardinality )? )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:307:2: a0= TEXT '[' ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )? ']' (a3= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_derivedplaceholder621); if (failed) return element;
            if ( backtracking==0 ) {
              String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); 
            }
            match(input,30,FOLLOW_30_in_derivedplaceholder625); if (failed) return element;
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:309:2: ( (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==QUOTED_39_39) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:310:3: (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? )
                    {
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:310:3: (a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )? )
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:311:4: a1= QUOTED_39_39 ( ( ',' a2= QUOTED_39_39 ) )?
                    {
                    a1=(Token)input.LT(1);
                    match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder641); if (failed) return element;
                    if ( backtracking==0 ) {
                      java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_39_39").resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); 
                    }
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:312:4: ( ( ',' a2= QUOTED_39_39 ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==18) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:313:5: ( ',' a2= QUOTED_39_39 )
                            {
                            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:313:5: ( ',' a2= QUOTED_39_39 )
                            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:314:6: ',' a2= QUOTED_39_39
                            {
                            match(input,18,FOLLOW_18_in_derivedplaceholder660); if (failed) return element;
                            a2=(Token)input.LT(1);
                            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_derivedplaceholder671); if (failed) return element;
                            if ( backtracking==0 ) {
                              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_39_39").resolve(a2.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());element.setSuffix(resolved); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); 
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            match(input,31,FOLLOW_31_in_derivedplaceholder695); if (failed) return element;
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:321:2: (a3= cardinality )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=34 && LA14_0<=36)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:322:3: a3= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_derivedplaceholder706);
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:326:1: containment returns [Containment element = null] : a0= TEXT (a1= cardinality )? ;
    public final Containment containment() throws RecognitionException {
        Containment element =  null;

        Token a0=null;
        Cardinality a1 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createContainment();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:330:1: (a0= TEXT (a1= cardinality )? )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:331:2: a0= TEXT (a1= cardinality )?
            {
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_containment733); if (failed) return element;
            if ( backtracking==0 ) {
              String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); 
            }
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:332:2: (a1= cardinality )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=34 && LA15_0<=36)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:333:3: a1= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_containment745);
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
    // $ANTLR end containment


    // $ANTLR start compounddefinition
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:337:1: compounddefinition returns [CompoundDefinition element = null] : '(' a0= choice ')' (a1= cardinality )? ;
    public final CompoundDefinition compounddefinition() throws RecognitionException {
        CompoundDefinition element =  null;

        Choice a0 = null;

        Cardinality a1 = null;


        
        	element = ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:341:1: ( '(' a0= choice ')' (a1= cardinality )? )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:342:2: '(' a0= choice ')' (a1= cardinality )?
            {
            match(input,32,FOLLOW_32_in_compounddefinition768); if (failed) return element;
            pushFollow(FOLLOW_choice_in_compounddefinition775);
            a0=choice();
            _fsp--;
            if (failed) return element;
            if ( backtracking==0 ) {
              element.setDefinitions(a0); getResource().setElementCharStart(element, getResource().getElementCharStart(a0)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a0)); getResource().setElementColumn(element, getResource().getElementColumn(a0)); getResource().setElementLine(element, getResource().getElementLine(a0));
            }
            match(input,33,FOLLOW_33_in_compounddefinition779); if (failed) return element;
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:345:2: (a1= cardinality )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=34 && LA16_0<=36)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:346:3: a1= cardinality
                    {
                    pushFollow(FOLLOW_cardinality_in_compounddefinition790);
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:350:1: plus returns [PLUS element = null] : '+' ;
    public final PLUS plus() throws RecognitionException {
        PLUS element =  null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createPLUS();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:354:1: ( '+' )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:355:2: '+'
            {
            match(input,34,FOLLOW_34_in_plus813); if (failed) return element;

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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:358:1: star returns [STAR element = null] : '*' ;
    public final STAR star() throws RecognitionException {
        STAR element =  null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createSTAR();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:362:1: ( '*' )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:363:2: '*'
            {
            match(input,35,FOLLOW_35_in_star831); if (failed) return element;

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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:366:1: questionmark returns [QUESTIONMARK element = null] : '?' ;
    public final QUESTIONMARK questionmark() throws RecognitionException {
        QUESTIONMARK element =  null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:370:1: ( '?' )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:371:2: '?'
            {
            match(input,36,FOLLOW_36_in_questionmark849); if (failed) return element;

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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:374:1: whitespaces returns [WhiteSpaces element = null] : a0= TEXT_35_ ;
    public final WhiteSpaces whitespaces() throws RecognitionException {
        WhiteSpaces element =  null;

        Token a0=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:378:1: (a0= TEXT_35_ )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:379:2: a0= TEXT_35_
            {
            a0=(Token)input.LT(1);
            match(input,TEXT_35_,FOLLOW_TEXT_35__in_whitespaces871); if (failed) return element;
            if ( backtracking==0 ) {
              int resolved = (Integer) tokenResolverFactory.createTokenResolver("TEXT_35_").resolve(a0.getText(),element.eClass().getEStructuralFeature("ammount"),element,getResource());element.setAmmount(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:382:1: linebreak returns [LineBreak element = null] : a0= TEXT_33_ ;
    public final LineBreak linebreak() throws RecognitionException {
        LineBreak element =  null;

        Token a0=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createLineBreak();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:386:1: (a0= TEXT_33_ )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:387:2: a0= TEXT_33_
            {
            a0=(Token)input.LT(1);
            match(input,TEXT_33_,FOLLOW_TEXT_33__in_linebreak894); if (failed) return element;
            if ( backtracking==0 ) {
              int resolved = (Integer) tokenResolverFactory.createTokenResolver("TEXT_33_").resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());element.setTab(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:390:1: normaltoken returns [NormalToken element = null] : 'DEFINE' a0= TEXT a1= QUOTED_36_36 ;
    public final NormalToken normaltoken() throws RecognitionException {
        NormalToken element =  null;

        Token a0=null;
        Token a1=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createNormalToken();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:394:1: ( 'DEFINE' a0= TEXT a1= QUOTED_36_36 )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:395:2: 'DEFINE' a0= TEXT a1= QUOTED_36_36
            {
            match(input,37,FOLLOW_37_in_normaltoken913); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_normaltoken920); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
            }
            a1=(Token)input.LT(1);
            match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_normaltoken928); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_36_36").resolve(a1.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());element.setRegex(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); 
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:400:1: decoratedtoken returns [DecoratedToken element = null] : 'DEFINE' a0= TEXT ( '[' (a1= QUOTED_39_39 ) ']' ) a2= QUOTED_36_36 ( '[' (a3= QUOTED_39_39 ) ']' ) ;
    public final DecoratedToken decoratedtoken() throws RecognitionException {
        DecoratedToken element =  null;

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createDecoratedToken();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:404:1: ( 'DEFINE' a0= TEXT ( '[' (a1= QUOTED_39_39 ) ']' ) a2= QUOTED_36_36 ( '[' (a3= QUOTED_39_39 ) ']' ) )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:405:2: 'DEFINE' a0= TEXT ( '[' (a1= QUOTED_39_39 ) ']' ) a2= QUOTED_36_36 ( '[' (a3= QUOTED_39_39 ) ']' )
            {
            match(input,37,FOLLOW_37_in_decoratedtoken947); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_decoratedtoken954); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
            }
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:407:2: ( '[' (a1= QUOTED_39_39 ) ']' )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:408:3: '[' (a1= QUOTED_39_39 ) ']'
            {
            match(input,30,FOLLOW_30_in_decoratedtoken962); if (failed) return element;
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:409:3: (a1= QUOTED_39_39 )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:410:4: a1= QUOTED_39_39
            {
            a1=(Token)input.LT(1);
            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken975); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_39_39").resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); 
            }

            }

            match(input,31,FOLLOW_31_in_decoratedtoken984); if (failed) return element;

            }

            a2=(Token)input.LT(1);
            match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_decoratedtoken994); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_36_36").resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());element.setRegex(resolved); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); 
            }
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:415:2: ( '[' (a3= QUOTED_39_39 ) ']' )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:416:3: '[' (a3= QUOTED_39_39 ) ']'
            {
            match(input,30,FOLLOW_30_in_decoratedtoken1002); if (failed) return element;
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:417:3: (a3= QUOTED_39_39 )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:418:4: a3= QUOTED_39_39
            {
            a3=(Token)input.LT(1);
            match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_decoratedtoken1015); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_39_39").resolve(a3.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());element.setSuffix(resolved); getResource().setElementCharStart(element, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(element, a3.getCharPositionInLine()); getResource().setElementLine(element, a3.getLine()); 
            }

            }

            match(input,31,FOLLOW_31_in_decoratedtoken1024); if (failed) return element;

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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:424:1: predefinedtoken returns [PreDefinedToken element = null] : 'PREDEFINED' a0= TEXT ;
    public final PreDefinedToken predefinedtoken() throws RecognitionException {
        PreDefinedToken element =  null;

        Token a0=null;

        
        	element = ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();

        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:428:1: ( 'PREDEFINED' a0= TEXT )
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:429:2: 'PREDEFINED' a0= TEXT
            {
            match(input,38,FOLLOW_38_in_predefinedtoken1045); if (failed) return element;
            a0=(Token)input.LT(1);
            match(input,TEXT,FOLLOW_TEXT_in_predefinedtoken1052); if (failed) return element;
            if ( backtracking==0 ) {
              java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); 
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


    // $ANTLR start cardinality
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:433:1: cardinality returns [Cardinality element = null] : (c0= plus | c1= questionmark | c2= star );
    public final Cardinality cardinality() throws RecognitionException {
        Cardinality element =  null;

        PLUS c0 = null;

        QUESTIONMARK c1 = null;

        STAR c2 = null;


        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:435:1: (c0= plus | c1= questionmark | c2= star )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt17=1;
                }
                break;
            case 36:
                {
                alt17=2;
                }
                break;
            case 35:
                {
                alt17=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("433:1: cardinality returns [Cardinality element = null] : (c0= plus | c1= questionmark | c2= star );", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:436:2: c0= plus
                    {
                    pushFollow(FOLLOW_plus_in_cardinality1071);
                    c0=plus();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:437:2: c1= questionmark
                    {
                    pushFollow(FOLLOW_questionmark_in_cardinality1081);
                    c1=questionmark();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:438:2: c2= star
                    {
                    pushFollow(FOLLOW_star_in_cardinality1091);
                    c2=star();
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


    // $ANTLR start definition
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:441:1: definition returns [Definition element = null] : (c0= whitespaces | c1= containment | c2= derivedplaceholder | c3= csstring | c4= linebreak | c5= compounddefinition | c6= definedplaceholder );
    public final Definition definition() throws RecognitionException {
        Definition element =  null;

        WhiteSpaces c0 = null;

        Containment c1 = null;

        DerivedPlaceholder c2 = null;

        CsString c3 = null;

        LineBreak c4 = null;

        CompoundDefinition c5 = null;

        DefinedPlaceholder c6 = null;


        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:443:1: (c0= whitespaces | c1= containment | c2= derivedplaceholder | c3= csstring | c4= linebreak | c5= compounddefinition | c6= definedplaceholder )
            int alt18=7;
            switch ( input.LA(1) ) {
            case TEXT_35_:
                {
                alt18=1;
                }
                break;
            case TEXT:
                {
                int LA18_2 = input.LA(2);

                if ( (LA18_2==30) ) {
                    int LA18_6 = input.LA(3);

                    if ( (LA18_6==TEXT) ) {
                        alt18=7;
                    }
                    else if ( (LA18_6==QUOTED_39_39||LA18_6==31) ) {
                        alt18=3;
                    }
                    else {
                        if (backtracking>0) {failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("441:1: definition returns [Definition element = null] : (c0= whitespaces | c1= containment | c2= derivedplaceholder | c3= csstring | c4= linebreak | c5= compounddefinition | c6= definedplaceholder );", 18, 6, input);

                        throw nvae;
                    }
                }
                else if ( (LA18_2==EOF||LA18_2==TEXT||LA18_2==QUOTED_34_34||(LA18_2>=TEXT_35_ && LA18_2<=TEXT_33_)||LA18_2==23||LA18_2==29||(LA18_2>=32 && LA18_2<=36)) ) {
                    alt18=2;
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("441:1: definition returns [Definition element = null] : (c0= whitespaces | c1= containment | c2= derivedplaceholder | c3= csstring | c4= linebreak | c5= compounddefinition | c6= definedplaceholder );", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case QUOTED_34_34:
                {
                alt18=4;
                }
                break;
            case TEXT_33_:
                {
                alt18=5;
                }
                break;
            case 32:
                {
                alt18=6;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("441:1: definition returns [Definition element = null] : (c0= whitespaces | c1= containment | c2= derivedplaceholder | c3= csstring | c4= linebreak | c5= compounddefinition | c6= definedplaceholder );", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:444:2: c0= whitespaces
                    {
                    pushFollow(FOLLOW_whitespaces_in_definition1110);
                    c0=whitespaces();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:445:2: c1= containment
                    {
                    pushFollow(FOLLOW_containment_in_definition1120);
                    c1=containment();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:446:2: c2= derivedplaceholder
                    {
                    pushFollow(FOLLOW_derivedplaceholder_in_definition1130);
                    c2=derivedplaceholder();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:447:2: c3= csstring
                    {
                    pushFollow(FOLLOW_csstring_in_definition1140);
                    c3=csstring();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:448:2: c4= linebreak
                    {
                    pushFollow(FOLLOW_linebreak_in_definition1150);
                    c4=linebreak();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:449:2: c5= compounddefinition
                    {
                    pushFollow(FOLLOW_compounddefinition_in_definition1160);
                    c5=compounddefinition();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:450:2: c6= definedplaceholder
                    {
                    pushFollow(FOLLOW_definedplaceholder_in_definition1170);
                    c6=definedplaceholder();
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
    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:453:1: tokendefinition returns [TokenDefinition element = null] : (c0= predefinedtoken | c1= decoratedtoken | c2= normaltoken );
    public final TokenDefinition tokendefinition() throws RecognitionException {
        TokenDefinition element =  null;

        PreDefinedToken c0 = null;

        DecoratedToken c1 = null;

        NormalToken c2 = null;


        try {
            // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:455:1: (c0= predefinedtoken | c1= decoratedtoken | c2= normaltoken )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==38) ) {
                alt19=1;
            }
            else if ( (LA19_0==37) ) {
                int LA19_2 = input.LA(2);

                if ( (LA19_2==TEXT) ) {
                    int LA19_3 = input.LA(3);

                    if ( (LA19_3==QUOTED_36_36) ) {
                        alt19=3;
                    }
                    else if ( (LA19_3==30) ) {
                        alt19=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("453:1: tokendefinition returns [TokenDefinition element = null] : (c0= predefinedtoken | c1= decoratedtoken | c2= normaltoken );", 19, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("453:1: tokendefinition returns [TokenDefinition element = null] : (c0= predefinedtoken | c1= decoratedtoken | c2= normaltoken );", 19, 2, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("453:1: tokendefinition returns [TokenDefinition element = null] : (c0= predefinedtoken | c1= decoratedtoken | c2= normaltoken );", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:456:2: c0= predefinedtoken
                    {
                    pushFollow(FOLLOW_predefinedtoken_in_tokendefinition1189);
                    c0=predefinedtoken();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:457:2: c1= decoratedtoken
                    {
                    pushFollow(FOLLOW_decoratedtoken_in_tokendefinition1199);
                    c1=decoratedtoken();
                    _fsp--;
                    if (failed) return element;
                    if ( backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Dokumente und Einstellungen\\skarol\\runtime-New_configuration\\org.reuseware.emftextedit.concretesyntax.resource.cs\\src\\org\\reuseware\\emftextedit\\concretesyntax\\resource\\cs\\Cs.g:458:2: c2= normaltoken
                    {
                    pushFollow(FOLLOW_normaltoken_in_tokendefinition1209);
                    c2=normaltoken();
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


 

    public static final BitSet FOLLOW_concretesyntax_in_start61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_concretesyntax81 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax88 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_concretesyntax92 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_concretesyntax99 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_concretesyntax103 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax110 = new BitSet(new long[]{0x00000000014C0000L});
    public static final BitSet FOLLOW_18_in_concretesyntax123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_concretesyntax132 = new BitSet(new long[]{0x00000000014C0000L});
    public static final BitSet FOLLOW_19_in_concretesyntax153 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax158 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_imporx_in_concretesyntax180 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_concretesyntax198 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_22_in_concretesyntax218 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax223 = new BitSet(new long[]{0x0000006000200000L});
    public static final BitSet FOLLOW_tokendefinition_in_concretesyntax245 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_concretesyntax253 = new BitSet(new long[]{0x0000006000200000L});
    public static final BitSet FOLLOW_21_in_concretesyntax270 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_concretesyntax281 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_concretesyntax284 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule_in_concretesyntax300 = new BitSet(new long[]{0x0000000000200050L});
    public static final BitSet FOLLOW_21_in_concretesyntax312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_imporx334 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_imporx338 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_imporx345 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_imporx358 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_imporx363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_imporx372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_rule407 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_QNAME_in_rule421 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rule428 = new BitSet(new long[]{0x0000000100000690L});
    public static final BitSet FOLLOW_choice_in_rule435 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rule439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_sequence465 = new BitSet(new long[]{0x0000000100000692L});
    public static final BitSet FOLLOW_sequence_in_choice492 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_choice505 = new BitSet(new long[]{0x0000000100000690L});
    public static final BitSet FOLLOW_sequence_in_choice514 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_csstring545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder568 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_definedplaceholder572 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_definedplaceholder579 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_definedplaceholder583 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_definedplaceholder594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_derivedplaceholder621 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_derivedplaceholder625 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder641 = new BitSet(new long[]{0x0000000080040000L});
    public static final BitSet FOLLOW_18_in_derivedplaceholder660 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_derivedplaceholder671 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_derivedplaceholder695 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_derivedplaceholder706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_containment733 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_containment745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_compounddefinition768 = new BitSet(new long[]{0x0000000100000690L});
    public static final BitSet FOLLOW_choice_in_compounddefinition775 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_compounddefinition779 = new BitSet(new long[]{0x0000001C00000002L});
    public static final BitSet FOLLOW_cardinality_in_compounddefinition790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_plus813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_star831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_questionmark849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_35__in_whitespaces871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_33__in_linebreak894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_normaltoken913 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_normaltoken920 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_normaltoken928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_decoratedtoken947 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_decoratedtoken954 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken962 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken975 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken984 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_decoratedtoken994 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_decoratedtoken1002 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_decoratedtoken1015 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_decoratedtoken1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_predefinedtoken1045 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_TEXT_in_predefinedtoken1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_cardinality1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_questionmark_in_cardinality1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_star_in_cardinality1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whitespaces_in_definition1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_containment_in_definition1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_derivedplaceholder_in_definition1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_csstring_in_definition1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_linebreak_in_definition1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compounddefinition_in_definition1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedplaceholder_in_definition1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedtoken_in_tokendefinition1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decoratedtoken_in_tokendefinition1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normaltoken_in_tokendefinition1209 = new BitSet(new long[]{0x0000000000000002L});

}