grammar Cs;
options {superClass = EMFTextParserImpl; backtrack = true;}

@lexer::header{
package org.reuseware.emftextedit.concretesyntax.resource.cs;

}

@lexer::members{
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header{
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
}

@members{
	private TokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();

	protected EObject doParse() throws RecognitionException {
		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		return start();
	}
}

start
returns [ EObject element = null]
:  
c0 = concretesyntax{ element = c0; }

;

concretesyntax returns [ConcreteSyntax element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
}
:
	'SYNTAXDEF'
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
	'FOR'
	a1 = QUOTED_60_62{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setPackage(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); }
	'START'
	(
		a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); }

		|
		a3 = QNAME{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(element, a3.getCharPositionInLine()); getResource().setElementLine(element, a3.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(proxy, a3.getCharPositionInLine()); getResource().setElementLine(proxy, a3.getLine()); }
	)
	(
		(
			','
			(
				a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a4).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a4).getStopIndex()); getResource().setElementColumn(element, a4.getCharPositionInLine()); getResource().setElementLine(element, a4.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a4).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a4).getStopIndex()); getResource().setElementColumn(proxy, a4.getCharPositionInLine()); getResource().setElementLine(proxy, a4.getLine()); }

				|
				a5 = QNAME{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a5).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a5).getStopIndex()); getResource().setElementColumn(element, a5.getCharPositionInLine()); getResource().setElementLine(element, a5.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a5).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a5).getStopIndex()); getResource().setElementColumn(proxy, a5.getCharPositionInLine()); getResource().setElementLine(proxy, a5.getLine()); }
			)
		)
	)*
	(
		(
			'IMPORTS'
			'{'
			(
				(
					a6 = imporx{element.getImports().add(a6); getResource().setElementCharStart(element, getResource().getElementCharStart(a6)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a6)); getResource().setElementColumn(element, getResource().getElementColumn(a6)); getResource().setElementLine(element, getResource().getElementLine(a6));}
				)
			)*
			'}'
		)
	)?
	(
		(
			'TOKENS'
			'{'
			(
				(
					a7 = tokendefinition{element.getTokens().add(a7); getResource().setElementCharStart(element, getResource().getElementCharStart(a7)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a7)); getResource().setElementColumn(element, getResource().getElementColumn(a7)); getResource().setElementLine(element, getResource().getElementLine(a7));}
					';'
				)
			)*
			'}'
		)
	)?
	'RULES'
	'{'
	(
		(
			a8 = rule{element.getRules().add(a8); getResource().setElementCharStart(element, getResource().getElementCharStart(a8)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a8)); getResource().setElementColumn(element, getResource().getElementColumn(a8)); getResource().setElementLine(element, getResource().getElementLine(a8));}
		)+
	)
	'}'
;

imporx returns [Import element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createImport();
}
:
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
	':'
	a1 = QUOTED_60_62{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setPackage(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); }
	(
		(
			'WITH'
			'SYNTAX'
			a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;ConcreteSyntax proxy = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setConcreteSyntax(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); }
		)
	)?
;

rule returns [Rule element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createRule();
}
:
	(
		a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setMetaclass(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); }

		|
		a1 = QNAME{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setMetaclass(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); }
	)
	'::='
	a2 = choice{element.setDefinition(a2); getResource().setElementCharStart(element, getResource().getElementCharStart(a2)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a2)); getResource().setElementColumn(element, getResource().getElementColumn(a2)); getResource().setElementLine(element, getResource().getElementLine(a2));}
	';'
;

sequence returns [Sequence element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createSequence();
}
:
	(
		a0 = definition{element.getParts().add(a0); getResource().setElementCharStart(element, getResource().getElementCharStart(a0)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a0)); getResource().setElementColumn(element, getResource().getElementColumn(a0)); getResource().setElementLine(element, getResource().getElementLine(a0));}
	)+
;

choice returns [Choice element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createChoice();
}
:
	a0 = sequence{element.getOptions().add(a0); getResource().setElementCharStart(element, getResource().getElementCharStart(a0)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a0)); getResource().setElementColumn(element, getResource().getElementColumn(a0)); getResource().setElementLine(element, getResource().getElementLine(a0));}
	(
		(
			'|'
			a1 = sequence{element.getOptions().add(a1); getResource().setElementCharStart(element, getResource().getElementCharStart(a1)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a1)); getResource().setElementColumn(element, getResource().getElementColumn(a1)); getResource().setElementLine(element, getResource().getElementLine(a1));}
		)
	)*
;

csstring returns [CsString element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createCsString();
}
:
	a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setValue(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
;

definedplaceholder returns [DefinedPlaceholder element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();
}
:
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); }
	'['
	a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;NormalToken proxy = ConcretesyntaxFactory.eINSTANCE.createNormalToken();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setToken(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); }
	']'
	(
		a2 = cardinality{element.setCardinality(a2); getResource().setElementCharStart(element, getResource().getElementCharStart(a2)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a2)); getResource().setElementColumn(element, getResource().getElementColumn(a2)); getResource().setElementLine(element, getResource().getElementLine(a2));}
	)?
;

derivedplaceholder returns [DerivedPlaceholder element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();
}
:
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); }
	'['
	(
		(
			a1 = QUOTED_39_39{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); }
			(
				(
					','
					a2 = QUOTED_39_39{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setSuffix(resolved); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); }
				)
			)?
		)
	)?
	']'
	(
		a3 = cardinality{element.setCardinality(a3); getResource().setElementCharStart(element, getResource().getElementCharStart(a3)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a3)); getResource().setElementColumn(element, getResource().getElementColumn(a3)); getResource().setElementLine(element, getResource().getElementLine(a3));}
	)?
;

containment returns [Containment element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createContainment();
}
:
	(
		a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); }
		a1 = cardinality{element.setCardinality(a1); getResource().setElementCharStart(element, getResource().getElementCharStart(a1)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a1)); getResource().setElementColumn(element, getResource().getElementColumn(a1)); getResource().setElementLine(element, getResource().getElementLine(a1));}

		|
		a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); }
	)
;

compounddefinition returns [CompoundDefinition element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
}
:
	'('
	a0 = choice{element.setDefinitions(a0); getResource().setElementCharStart(element, getResource().getElementCharStart(a0)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a0)); getResource().setElementColumn(element, getResource().getElementColumn(a0)); getResource().setElementLine(element, getResource().getElementLine(a0));}
	')'
	(
		a1 = cardinality{element.setCardinality(a1); getResource().setElementCharStart(element, getResource().getElementCharStart(a1)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a1)); getResource().setElementColumn(element, getResource().getElementColumn(a1)); getResource().setElementLine(element, getResource().getElementLine(a1));}
	)?
;

plus returns [PLUS element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createPLUS();
}
:
	'+'
;

star returns [STAR element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createSTAR();
}
:
	'*'
;

questionmark returns [QUESTIONMARK element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
}
:
	'?'
;

whitespaces returns [WhiteSpaces element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();
}
:
	a0 = TEXT_35_{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_35_");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("ammount"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (Integer)resolvedObject;element.setAmmount(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
;

linebreak returns [LineBreak element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createLineBreak();
}
:
	a0 = TEXT_33_{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_33_");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (Integer)resolvedObject;element.setTab(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
;

normaltoken returns [NormalToken element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createNormalToken();
}
:
	'DEFINE'
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
	a1 = QUOTED_36_36{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setRegex(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); }
;

decoratedtoken returns [DecoratedToken element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createDecoratedToken();
}
:
	'DEFINE'
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
	(
		'['
		(
			a1 = QUOTED_39_39{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); }
		)
		']'
	)
	a2 = QUOTED_36_36{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setRegex(resolved); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); }
	(
		'['
		(
			a3 = QUOTED_39_39{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setSuffix(resolved); getResource().setElementCharStart(element, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(element, a3.getCharPositionInLine()); getResource().setElementLine(element, a3.getLine()); }
		)
		']'
	)
;

predefinedtoken returns [PreDefinedToken element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createPreDefinedToken();
}
:
	'PREDEFINED'
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
;

definition
returns [Definition element = null]
:
	c0 = linebreak{ element = c0; }	|
	c1 = derivedplaceholder{ element = c1; }	|
	c2 = compounddefinition{ element = c2; }	|
	c3 = csstring{ element = c3; }	|
	c4 = whitespaces{ element = c4; }	|
	c5 = definedplaceholder{ element = c5; }	|
	c6 = containment{ element = c6; }
;

tokendefinition
returns [TokenDefinition element = null]
:
	c0 = predefinedtoken{ element = c0; }	|
	c1 = normaltoken{ element = c1; }	|
	c2 = decoratedtoken{ element = c2; }
;

cardinality
returns [Cardinality element = null]
:
	c0 = plus{ element = c0; }	|
	c1 = star{ element = c1; }	|
	c2 = questionmark{ element = c2; }
;

COMMENTS
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
QNAME
:
	('A'..'Z'|'a'..'z'|'_')+('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)+
;
TEXT_33_
:
	('!')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
TEXT_35_
:
	('#')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
QUOTED_60_62
:
	('<')(~('>')|('\\''>'))*('>')
;
QUOTED_39_39
:
	('\'')(~('\'')|('\\''\''))*('\'')
;
QUOTED_36_36
:
	('$')(~('$')|('\\''$'))*('$')
;
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
