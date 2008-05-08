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

import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.Import;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.concretesyntax.Choice;
import org.reuseware.emftextedit.concretesyntax.Sequence;
import org.reuseware.emftextedit.concretesyntax.Definition;
import org.reuseware.emftextedit.concretesyntax.Terminal;
import org.reuseware.emftextedit.concretesyntax.CsString;
import org.reuseware.emftextedit.concretesyntax.WhiteSpaces;
import org.reuseware.emftextedit.concretesyntax.LineBreak;
import org.reuseware.emftextedit.concretesyntax.Cardinality;
import org.reuseware.emftextedit.concretesyntax.PLUS;
import org.reuseware.emftextedit.concretesyntax.STAR;
import org.reuseware.emftextedit.concretesyntax.QUESTIONMARK;
import org.reuseware.emftextedit.concretesyntax.CompoundDefinition;
import org.reuseware.emftextedit.concretesyntax.TokenDefinition;
import org.reuseware.emftextedit.concretesyntax.NormalToken;
import org.reuseware.emftextedit.concretesyntax.DecoratedToken;
import org.reuseware.emftextedit.concretesyntax.NewDefinedToken;
import org.reuseware.emftextedit.concretesyntax.PreDefinedToken;
import org.reuseware.emftextedit.concretesyntax.Containment;
import org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder;
import org.reuseware.emftextedit.concretesyntax.DerivedPlaceholder;
import org.reuseware.emftextedit.concretesyntax.Placeholder;
import org.reuseware.emftextedit.concretesyntax.*;
import org.reuseware.emftextedit.concretesyntax.impl.*;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import java.util.Map.Entry;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenParameter;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement;
import org.eclipse.emf.codegen.ecore.genmodel.GenAnnotation;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
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
	a0 = TEXT{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
	'FOR'
	a1 = QUOTED_60_62{String resolved = (String) tokenResolverFactory.createTokenResolver("QUOTED_60_62").resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setPackage(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); }
	'START'
	a2 = TEXT{String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a2.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); }
	(
		(
			','
			a3 = TEXT{String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a3.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.getStartSymbols().add(proxy); getResource().setElementCharStart(element, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(element, a3.getCharPositionInLine()); getResource().setElementLine(element, a3.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(proxy, a3.getCharPositionInLine()); getResource().setElementLine(proxy, a3.getLine()); }
		)
	)*
	(
		(
			'IMPORTS'
			'{'
			(
				(
					a4 = imporx{element.getImports().add(a4); getResource().setElementCharStart(element, getResource().getElementCharStart(a4)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a4)); getResource().setElementColumn(element, getResource().getElementColumn(a4)); getResource().setElementLine(element, getResource().getElementLine(a4));}
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
					a5 = tokendefinition{element.getTokens().add(a5); getResource().setElementCharStart(element, getResource().getElementCharStart(a5)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a5)); getResource().setElementColumn(element, getResource().getElementColumn(a5)); getResource().setElementLine(element, getResource().getElementLine(a5));}
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
			a6 = rule{element.getRules().add(a6); getResource().setElementCharStart(element, getResource().getElementCharStart(a6)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a6)); getResource().setElementColumn(element, getResource().getElementColumn(a6)); getResource().setElementLine(element, getResource().getElementLine(a6));}
		)+
	)
	'}'
;

imporx returns [Import element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createImport();
}
:
	a0 = TEXT{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
	':'
	a1 = QUOTED_60_62{String resolved = (String) tokenResolverFactory.createTokenResolver("QUOTED_60_62").resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setPackage(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); }
	(
		(
			'WITH'
			'SYNTAX'
			a2 = TEXT{String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a2.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());ConcreteSyntax proxy = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setConcreteSyntax(proxy); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(proxy, a2.getCharPositionInLine()); getResource().setElementLine(proxy, a2.getLine()); }
		)
	)?
;

rule returns [Rule element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createRule();
}
:
	(
		a0 = TEXT{String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setMetaclass(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); }

		|
		a1 = QNAME{String resolved = (String) tokenResolverFactory.createTokenResolver("QNAME").resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setMetaclass(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); }
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
	a0 = QUOTED_34_34{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_34_34").resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());element.setValue(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
;

definedplaceholder returns [DefinedPlaceholder element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();
}
:
	a0 = TEXT{String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); }
	'['
	a1 = TEXT{String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a1.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());NormalToken proxy = ConcretesyntaxFactory.eINSTANCE.createNormalToken();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setToken(proxy); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(proxy, a1.getCharPositionInLine()); getResource().setElementLine(proxy, a1.getLine()); }
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
	a0 = TEXT{String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); }
	'['
	(
		(
			a1 = QUOTED_39_39{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_39_39").resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); }
			(
				(
					','
					a2 = QUOTED_39_39{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_39_39").resolve(a2.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());element.setSuffix(resolved); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); }
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
	a0 = TEXT{String resolved = (String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI(resource.getURI().appendFragment(resolved)); element.setFeature(proxy); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); getResource().setElementCharStart(proxy, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(proxy, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(proxy, a0.getCharPositionInLine()); getResource().setElementLine(proxy, a0.getLine()); }
	(
		a1 = cardinality{element.setCardinality(a1); getResource().setElementCharStart(element, getResource().getElementCharStart(a1)); getResource().setElementCharEnd(element, getResource().getElementCharEnd(a1)); getResource().setElementColumn(element, getResource().getElementColumn(a1)); getResource().setElementLine(element, getResource().getElementLine(a1));}
	)?
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
	a0 = TEXT_35_{int resolved = (Integer) tokenResolverFactory.createTokenResolver("TEXT_35_").resolve(a0.getText(),element.eClass().getEStructuralFeature("ammount"),element,getResource());element.setAmmount(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
;

linebreak returns [LineBreak element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createLineBreak();
}
:
	a0 = TEXT_33_{int resolved = (Integer) tokenResolverFactory.createTokenResolver("TEXT_33_").resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());element.setTab(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
;

normaltoken returns [NormalToken element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createNormalToken();
}
:
	'DEFINE'
	a0 = TEXT{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
	a1 = QUOTED_36_36{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_36_36").resolve(a1.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());element.setRegex(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); }
;

decoratedtoken returns [DecoratedToken element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createDecoratedToken();
}
:
	'DEFINE'
	a0 = TEXT{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
	(
		'['
		(
			a1 = QUOTED_39_39{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_39_39").resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());element.setPrefix(resolved); getResource().setElementCharStart(element, ((CommonToken)a1).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a1).getStopIndex()); getResource().setElementColumn(element, a1.getCharPositionInLine()); getResource().setElementLine(element, a1.getLine()); }
		)
		']'
	)
	a2 = QUOTED_36_36{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_36_36").resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());element.setRegex(resolved); getResource().setElementCharStart(element, ((CommonToken)a2).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a2).getStopIndex()); getResource().setElementColumn(element, a2.getCharPositionInLine()); getResource().setElementLine(element, a2.getLine()); }
	(
		'['
		(
			a3 = QUOTED_39_39{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("QUOTED_39_39").resolve(a3.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());element.setSuffix(resolved); getResource().setElementCharStart(element, ((CommonToken)a3).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a3).getStopIndex()); getResource().setElementColumn(element, a3.getCharPositionInLine()); getResource().setElementLine(element, a3.getLine()); }
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
	a0 = TEXT{java.lang.String resolved = (java.lang.String) tokenResolverFactory.createTokenResolver("TEXT").resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());element.setName(resolved); getResource().setElementCharStart(element, ((CommonToken)a0).getStartIndex()); getResource().setElementCharEnd(element, ((CommonToken)a0).getStopIndex()); getResource().setElementColumn(element, a0.getCharPositionInLine()); getResource().setElementLine(element, a0.getLine()); }
;

definition
returns [Definition element = null]
:
	c0 = linebreak{ element = c0; }	|
	c1 = compounddefinition{ element = c1; }	|
	c2 = containment{ element = c2; }	|
	c3 = whitespaces{ element = c3; }	|
	c4 = csstring{ element = c4; }	|
	c5 = definedplaceholder{ element = c5; }	|
	c6 = derivedplaceholder{ element = c6; }
;

cardinality
returns [Cardinality element = null]
:
	c0 = star{ element = c0; }	|
	c1 = plus{ element = c1; }	|
	c2 = questionmark{ element = c2; }
;

tokendefinition
returns [TokenDefinition element = null]
:
	c0 = normaltoken{ element = c0; }	|
	c1 = predefinedtoken{ element = c1; }	|
	c2 = decoratedtoken{ element = c2; }
;

COMMENTS
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
QNAME
:
	('A'..'Z'|'a'..'z'|'_')+('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)+
;
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
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
