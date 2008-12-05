grammar Cs;
options {superClass = EMFTextParserImpl; backtrack = true;}

@lexer::header{
package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs;

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
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	'FOR'
	a1 = QUOTED_60_62{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); }
	'START'
	(
		a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); }

		|
		a3 = QNAME{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a3, element); copyLocalizationInfos((CommonToken) a3, proxy); }
	)
	(
		(
			','
			(
				a4 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a4.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a4,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a4, element); copyLocalizationInfos((CommonToken) a4, proxy); }

				|
				a5 = QNAME{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a5.getText(),element.eClass().getEStructuralFeature("startSymbols"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a5,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); ((List) element.eGet(element.eClass().getEStructuralFeature("startSymbols"))).add(proxy); copyLocalizationInfos((CommonToken) a5, element); copyLocalizationInfos((CommonToken) a5, proxy); }
			)
		)
	)*
	(
		(
			'IMPORTS'
			'{'
			(
				(
					a6 = keywordimport{((List) element.eGet(element.eClass().getEStructuralFeature("imports"))).add(a6); copyLocalizationInfos(a6, element); }
				)
			)*
			'}'
		)
	)?
	(
		(
			'OPTIONS'
			'{'
			(
				(
					a7 = option{((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a7); copyLocalizationInfos(a7, element); }
					';'
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
					a8 = tokendefinition{((List) element.eGet(element.eClass().getEStructuralFeature("tokens"))).add(a8); copyLocalizationInfos(a8, element); }
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
			a9 = rule{((List) element.eGet(element.eClass().getEStructuralFeature("rules"))).add(a9); copyLocalizationInfos(a9, element); }
		)+
	)
	'}'
;

keywordimport returns [Import element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createImport();
}
:
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	':'
	a1 = QUOTED_60_62{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("package"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenPackage proxy = GenModelFactory.eINSTANCE.createGenPackage();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("package"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); }
	(
		(
			'WITH'
			'SYNTAX'
			a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("concreteSyntax"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;ConcreteSyntax proxy = ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("concreteSyntax"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); }
		)
	)?
;

option returns [Option element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createOption();
}
:
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	'='
	a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
;

rule returns [Rule element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createRule();
}
:
	(
		a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }

		|
		a1 = QNAME{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QNAME");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("metaclass"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenClass proxy = GenModelFactory.eINSTANCE.createGenClass();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("metaclass"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); }
	)
	'::='
	a2 = choice{element.eSet(element.eClass().getEStructuralFeature("definition"), a2); copyLocalizationInfos(a2, element); }
	';'
;

sequence returns [Sequence element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createSequence();
}
:
	(
		a0 = definition{((List) element.eGet(element.eClass().getEStructuralFeature("parts"))).add(a0); copyLocalizationInfos(a0, element); }
	)+
;

choice returns [Choice element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createChoice();
}
:
	a0 = sequence{((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a0); copyLocalizationInfos(a0, element); }
	(
		(
			'|'
			a1 = sequence{((List) element.eGet(element.eClass().getEStructuralFeature("options"))).add(a1); copyLocalizationInfos(a1, element); }
		)
	)*
;

csstring returns [CsString element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createCsString();
}
:
	a0 = QUOTED_34_34{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("value"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("value"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

definedplaceholder returns [DefinedPlaceholder element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createDefinedPlaceholder();
}
:
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }
	'['
	a1 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("token"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;NormalToken proxy = ConcretesyntaxFactory.eINSTANCE.createNormalToken();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("token"), proxy); copyLocalizationInfos((CommonToken) a1, element); copyLocalizationInfos((CommonToken) a1, proxy); }
	']'
	(
		a2 = cardinality{element.eSet(element.eClass().getEStructuralFeature("cardinality"), a2); copyLocalizationInfos(a2, element); }
	)?
;

derivedplaceholder returns [DerivedPlaceholder element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createDerivedPlaceholder();
}
:
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }
	'['
	(
		(
			a1 = QUOTED_39_39{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
			(
				(
					','
					a2 = QUOTED_39_39{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
				)
			)?
		)
	)?
	']'
	(
		a3 = cardinality{element.eSet(element.eClass().getEStructuralFeature("cardinality"), a3); copyLocalizationInfos(a3, element); }
	)?
;

containment returns [Containment element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createContainment();
}
:
	(
		a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a0, element); copyLocalizationInfos((CommonToken) a0, proxy); }
		a1 = cardinality{element.eSet(element.eClass().getEStructuralFeature("cardinality"), a1); copyLocalizationInfos(a1, element); }

		|
		a2 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("feature"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());String resolved = (String) resolvedObject;GenFeature proxy = GenModelFactory.eINSTANCE.createGenFeature();((InternalEObject)proxy).eSetProxyURI((resource.getURI()==null?URI.createURI("dummy"):resource.getURI()).appendFragment(resolved)); element.eSet(element.eClass().getEStructuralFeature("feature"), proxy); copyLocalizationInfos((CommonToken) a2, element); copyLocalizationInfos((CommonToken) a2, proxy); }
	)
;

compounddefinition returns [CompoundDefinition element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
}
:
	'('
	a0 = choice{element.eSet(element.eClass().getEStructuralFeature("definitions"), a0); copyLocalizationInfos(a0, element); }
	')'
	(
		a1 = cardinality{element.eSet(element.eClass().getEStructuralFeature("cardinality"), a1); copyLocalizationInfos(a1, element); }
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
	a0 = TEXT_35_{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_35_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("amount"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("amount"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

linebreak returns [LineBreak element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createLineBreak();
}
:
	a0 = TEXT_33_{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT_33_");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("tab"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());int resolved = (java.lang.Integer)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("tab"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

normaltoken returns [NormalToken element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createNormalToken();
}
:
	'DEFINE'
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	a1 = QUOTED_36_36{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
;

decoratedtoken returns [DecoratedToken element = null]
@init{
	element = ConcretesyntaxFactory.eINSTANCE.createDecoratedToken();
}
:
	'DEFINE'
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
	(
		'['
		(
			a1 = QUOTED_39_39{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a1.getText(),element.eClass().getEStructuralFeature("prefix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a1,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("prefix"), resolved); copyLocalizationInfos((CommonToken) a1, element); }
		)
		']'
	)
	a2 = QUOTED_36_36{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a2.getText(),element.eClass().getEStructuralFeature("regex"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a2,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("regex"), resolved); copyLocalizationInfos((CommonToken) a2, element); }
	(
		'['
		(
			a3 = QUOTED_39_39{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a3.getText(),element.eClass().getEStructuralFeature("suffix"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a3,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("suffix"), resolved); copyLocalizationInfos((CommonToken) a3, element); }
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
	a0 = TEXT{TokenResolver resolvedResolver = tokenResolverFactory.createTokenResolver("TEXT");resolvedResolver.setOptions(getOptions());Object resolvedObject =resolvedResolver.resolve(a0.getText(),element.eClass().getEStructuralFeature("name"),element,getResource());if(resolvedObject==null)throw new TokenConversionException(a0,resolvedResolver.getErrorMessage());java.lang.String resolved = (java.lang.String)resolvedObject;element.eSet(element.eClass().getEStructuralFeature("name"), resolved); copyLocalizationInfos((CommonToken) a0, element); }
;

tokendefinition
returns [TokenDefinition element = null]
:
	c0 = normaltoken{ element = c0; }	|
	c1 = decoratedtoken{ element = c1; }	|
	c2 = predefinedtoken{ element = c2; }
;

definition
returns [Definition element = null]
:
	c0 = csstring{ element = c0; }	|
	c1 = definedplaceholder{ element = c1; }	|
	c2 = derivedplaceholder{ element = c2; }	|
	c3 = containment{ element = c3; }	|
	c4 = compounddefinition{ element = c4; }	|
	c5 = whitespaces{ element = c5; }	|
	c6 = linebreak{ element = c6; }
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
