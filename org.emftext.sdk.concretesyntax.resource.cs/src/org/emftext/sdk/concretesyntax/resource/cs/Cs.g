grammar Cs;
options {
	superClass = AbstractEMFTextParser; 
	backtrack = true;
	memoize = true;
}
@lexer::header{
package org.emftext.sdk.concretesyntax.resource.cs;

}

@lexer::members{
	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();

	public void reportError(org.antlr.runtime.RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream)input).index());
	}
}
@header{
package org.emftext.sdk.concretesyntax.resource.cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
}

@members{
	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
	private int lastPosition;
	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();

	protected EObject doParse() throws RecognitionException {
	lastPosition = 0;
		((CsLexer)getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((CsLexer)getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		return start();
	}

	@SuppressWarnings("unchecked")
	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
	}

	private org.emftext.runtime.resource.impl.TokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}

	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element, Object o) {
	}
}

start
returns [ EObject element = null]
:  
	(
c0 = concretesyntax{ element = c0; }
	)
	EOF

;

concretesyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null]
@init{
}
:
	a0 = 'SYNTAXDEF'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
	a1 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
	java.lang.String resolved = (java.lang.String)resolvedObject;

if (resolved != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), resolved); 
}
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a1, element); 
}

	a2 = 'FOR'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); }
	a3 = QUOTED_60_62{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
}
String resolved = (String) resolvedObject;
org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);

if (proxy != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a3, element); 
copyLocalizationInfos((CommonToken) a3, proxy); 
}

	(
		(
			a4 = QUOTED_60_62{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
}
	java.lang.String resolved = (java.lang.String)resolvedObject;

if (resolved != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), resolved); 
}
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a4, element); 
}

		)
	)?
	(
		(
			a5 = 'START'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); }
			(
				a6 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
}
String resolved = (String) resolvedObject;
org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);

if (proxy != null) {
addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a6, element); 
copyLocalizationInfos((CommonToken) a6, proxy); 
}

			)
			(
				(
					a7 = ','{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a7);copyLocalizationInfos((CommonToken)a7, element); }
					(
						a8 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
}
String resolved = (String) resolvedObject;
org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);

if (proxy != null) {
addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a8, element); 
copyLocalizationInfos((CommonToken) a8, proxy); 
}

					)
				)
			)*
		)
	)?
	(
		(
			a9 = 'IMPORTS'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); }
			a10 = '{'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); }
			(
				(
					a11 = keywordimport{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
}

if (a11 != null) {
addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS, a11); 
}
collectHiddenTokens(element, a11);
copyLocalizationInfos(a11, element); 
}

				)
			)*
			a12 = '}'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a12);copyLocalizationInfos((CommonToken)a12, element); }
		)
	)?
	(
		(
			a13 = 'OPTIONS'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a13);copyLocalizationInfos((CommonToken)a13, element); }
			a14 = '{'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a14);copyLocalizationInfos((CommonToken)a14, element); }
			(
				(
					a15 = option{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
}

if (a15 != null) {
addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS, a15); 
}
collectHiddenTokens(element, a15);
copyLocalizationInfos(a15, element); 
}

					a16 = ';'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a16);copyLocalizationInfos((CommonToken)a16, element); }
				)
			)*
			a17 = '}'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a17);copyLocalizationInfos((CommonToken)a17, element); }
		)
	)?
	(
		(
			a18 = 'TOKENS'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a18);copyLocalizationInfos((CommonToken)a18, element); }
			a19 = '{'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a19);copyLocalizationInfos((CommonToken)a19, element); }
			(
				(
					a20 = tokendefinition{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
}

if (a20 != null) {
addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS, a20); 
}
collectHiddenTokens(element, a20);
copyLocalizationInfos(a20, element); 
}

					a21 = ';'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a21);copyLocalizationInfos((CommonToken)a21, element); }
				)
			)*
			a22 = '}'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a22);copyLocalizationInfos((CommonToken)a22, element); }
		)
	)?
	a23 = 'RULES'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a23);copyLocalizationInfos((CommonToken)a23, element); }
	a24 = '{'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a24);copyLocalizationInfos((CommonToken)a24, element); }
	(
		(
			a25 = rule{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax(); 
}

if (a25 != null) {
addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, a25); 
}
collectHiddenTokens(element, a25);
copyLocalizationInfos(a25, element); 
}

		)+
	)
	a26 = '}'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();} collectHiddenTokens(element, (CommonToken)a26);copyLocalizationInfos((CommonToken)a26, element); }
;

keywordimport returns [org.emftext.sdk.concretesyntax.Import element = null]
@init{
}
:
	a0 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a0, element); 
}

	a1 = ':'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); }
	a2 = QUOTED_60_62{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
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
org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenPackage();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);

if (proxy != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a2, element); 
copyLocalizationInfos((CommonToken) a2, proxy); 
}

	(
		(
			a3 = QUOTED_60_62{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a3, element); 
}

		)
	)?
	(
		(
			a4 = 'WITH'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); }
			a5 = 'SYNTAX'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); }
			a6 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
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
org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createConcreteSyntax();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);

if (proxy != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a6, element); 
copyLocalizationInfos((CommonToken) a6, proxy); 
}

			(
				(
					a7 = QUOTED_60_62{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createImport(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a7, element); 
}

				)
			)?
		)
	)?
;

option returns [org.emftext.sdk.concretesyntax.Option element = null]
@init{
}
:
	a0 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a0, element); 
}

	a1 = '='{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); }
	a2 = QUOTED_34_34{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createOption(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a2, element); 
}

;

rule returns [org.emftext.sdk.concretesyntax.Rule element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); 
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
org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);

if (proxy != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a0, element); 
copyLocalizationInfos((CommonToken) a0, proxy); 
}

	)
	a1 = '::='{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); }
	a2 = choice{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule(); 
}

if (a2 != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), a2); 
}
collectHiddenTokens(element, a2);
copyLocalizationInfos(a2, element); 
}

	a3 = ';'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createRule();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); }
;

sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null]
@init{
}
:
	(
		a0 = definition{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSequence(); 
}

if (a0 != null) {
addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS, a0); 
}
collectHiddenTokens(element, a0);
copyLocalizationInfos(a0, element); 
}

	)+
;

choice returns [org.emftext.sdk.concretesyntax.Choice element = null]
@init{
}
:
	a0 = sequence{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); 
}

if (a0 != null) {
addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a0); 
}
collectHiddenTokens(element, a0);
copyLocalizationInfos(a0, element); 
}

	(
		(
			a1 = '|'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); }
			a2 = sequence{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createChoice(); 
}

if (a2 != null) {
addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a2); 
}
collectHiddenTokens(element, a2);
copyLocalizationInfos(a2, element); 
}

		)
	)*
;

csstring returns [org.emftext.sdk.concretesyntax.CsString element = null]
@init{
}
:
	a0 = QUOTED_34_34{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCsString(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a0, element); 
}

;

definedplaceholder returns [org.emftext.sdk.concretesyntax.DefinedPlaceholder element = null]
@init{
}
:
	a0 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); 
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
org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE), resolved, proxy);

if (proxy != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__FEATURE), proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a0, element); 
copyLocalizationInfos((CommonToken) a0, proxy); 
}

	a1 = '['{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); }
	a2 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); 
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
org.emftext.sdk.concretesyntax.PreDefinedToken proxy = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN), resolved, proxy);

if (proxy != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__TOKEN), proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a2, element); 
copyLocalizationInfos((CommonToken) a2, proxy); 
}

	a3 = ']'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); }
	(
		a4 = cardinality{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDefinedPlaceholder(); 
}

if (a4 != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DEFINED_PLACEHOLDER__CARDINALITY), a4); 
}
collectHiddenTokens(element, a4);
copyLocalizationInfos(a4, element); 
}

	)?
;

derivedplaceholder returns [org.emftext.sdk.concretesyntax.DerivedPlaceholder element = null]
@init{
}
:
	a0 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); 
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
org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE), resolved, proxy);

if (proxy != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__FEATURE), proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a0, element); 
copyLocalizationInfos((CommonToken) a0, proxy); 
}

	a1 = '['{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); }
	(
		(
			a2 = QUOTED_39_39{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a2, element); 
}

			(
				(
					a3 = ','{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); }
					a4 = QUOTED_39_39{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a4, element); 
}

				)
			)?
		)
	)?
	a5 = ']'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder();} collectHiddenTokens(element, (CommonToken)a5);copyLocalizationInfos((CommonToken)a5, element); }
	(
		a6 = cardinality{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDerivedPlaceholder(); 
}

if (a6 != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DERIVED_PLACEHOLDER__CARDINALITY), a6); 
}
collectHiddenTokens(element, a6);
copyLocalizationInfos(a6, element); 
}

	)?
;

containment returns [org.emftext.sdk.concretesyntax.Containment element = null]
@init{
}
:
	a0 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
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
org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenFeature();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);

if (proxy != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a0, element); 
copyLocalizationInfos((CommonToken) a0, proxy); 
}

	(
		(
			a1 = ':'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment();} collectHiddenTokens(element, (CommonToken)a1);copyLocalizationInfos((CommonToken)a1, element); }
			a2 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
}
String resolved = (String) resolvedObject;
org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelFactoryImpl.eINSTANCE.createGenClass();
collectHiddenTokens(element, proxy);
getResource().registerContextDependentProxy(element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPE), resolved, proxy);

if (proxy != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPE), proxy); 
}
collectHiddenTokens(element, proxy);
copyLocalizationInfos((CommonToken) a2, element); 
copyLocalizationInfos((CommonToken) a2, proxy); 
}

		)
	)?
	(
		a3 = cardinality{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createContainment(); 
}

if (a3 != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), a3); 
}
collectHiddenTokens(element, a3);
copyLocalizationInfos(a3, element); 
}

	)?
;

compounddefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null]
@init{
}
:
	a0 = '('{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
	a1 = choice{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); 
}

if (a1 != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), a1); 
}
collectHiddenTokens(element, a1);
copyLocalizationInfos(a1, element); 
}

	a2 = ')'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); }
	(
		a3 = cardinality{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createCompoundDefinition(); 
}

if (a3 != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), a3); 
}
collectHiddenTokens(element, a3);
copyLocalizationInfos(a3, element); 
}

	)?
;

plus returns [org.emftext.sdk.concretesyntax.PLUS element = null]
@init{
}
:
	a0 = '+'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPLUS();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
;

star returns [org.emftext.sdk.concretesyntax.STAR element = null]
@init{
}
:
	a0 = '*'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createSTAR();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
;

questionmark returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null]
@init{
}
:
	a0 = '?'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createQUESTIONMARK();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
;

whitespaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null]
@init{
}
:
	a0 = '#'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
	a1 = NUMBER{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createWhiteSpaces(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a1, element); 
}

;

linebreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null]
@init{
}
:
	a0 = '!'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
	a1 = NUMBER{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createLineBreak(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a1, element); 
}

;

normaltoken returns [org.emftext.sdk.concretesyntax.NormalToken element = null]
@init{
}
:
	a0 = 'DEFINE'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
	a1 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a1, element); 
}

	a2 = QUOTED_36_36{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a2, element); 
}

	(
		(
			a3 = 'COLLECT'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); }
			a4 = 'IN'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); }
			a5 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createNormalToken(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a5, element); 
}

		)
	)?
;

decoratedtoken returns [org.emftext.sdk.concretesyntax.DecoratedToken element = null]
@init{
}
:
	a0 = 'DEFINE'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
	a1 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__NAME), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
}
	java.lang.String resolved = (java.lang.String)resolvedObject;

if (resolved != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__NAME), resolved); 
}
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a1, element); 
}

	(
		a2 = '['{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); }
		(
			a3 = QUOTED_39_39{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__PREFIX), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
}
	java.lang.String resolved = (java.lang.String)resolvedObject;

if (resolved != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__PREFIX), resolved); 
}
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a3, element); 
}

		)
		a4 = ']'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a4);copyLocalizationInfos((CommonToken)a4, element); }
	)
	a5 = QUOTED_36_36{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__REGEX), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
}
	java.lang.String resolved = (java.lang.String)resolvedObject;

if (resolved != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__REGEX), resolved); 
}
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a5, element); 
}

	(
		a6 = '['{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a6);copyLocalizationInfos((CommonToken)a6, element); }
		(
			a7 = QUOTED_39_39{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__SUFFIX), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
}
	java.lang.String resolved = (java.lang.String)resolvedObject;

if (resolved != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__SUFFIX), resolved); 
}
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a7, element); 
}

		)
		a8 = ']'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a8);copyLocalizationInfos((CommonToken)a8, element); }
	)
	(
		(
			a9 = 'COLLECT'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a9);copyLocalizationInfos((CommonToken)a9, element); }
			a10 = 'IN'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken();} collectHiddenTokens(element, (CommonToken)a10);copyLocalizationInfos((CommonToken)a10, element); }
			a11 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createDecoratedToken(); 
}
org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
tokenResolver.setOptions(getOptions());
org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__ATTRIBUTE_NAME), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
	getResource().addError(result.getErrorMessage(), ((CommonToken) a11).getLine(), ((CommonToken) a11).getCharPositionInLine(), ((CommonToken) a11).getStartIndex(), ((CommonToken) a11).getStopIndex());
}
	java.lang.String resolved = (java.lang.String)resolvedObject;

if (resolved != null) {
element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.DECORATED_TOKEN__ATTRIBUTE_NAME), resolved); 
}
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a11, element); 
}

		)
	)?
;

predefinedtoken returns [org.emftext.sdk.concretesyntax.PreDefinedToken element = null]
@init{
}
:
	a0 = 'PREDEFINED'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a0);copyLocalizationInfos((CommonToken)a0, element); }
	a1 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a1, element); 
}

	(
		(
			a2 = 'COLLECT'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a2);copyLocalizationInfos((CommonToken)a2, element); }
			a3 = 'IN'{ if (element == null) {element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken();} collectHiddenTokens(element, (CommonToken)a3);copyLocalizationInfos((CommonToken)a3, element); }
			a4 = QUALIFIED_NAME{if (element == null) {
	element = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.eINSTANCE.createPreDefinedToken(); 
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
collectHiddenTokens(element, resolved);
copyLocalizationInfos((CommonToken) a4, element); 
}

		)
	)?
;

tokendefinition
returns [org.emftext.sdk.concretesyntax.TokenDefinition element = null]
:
	c0 = normaltoken{ element = c0; }	|
	c1 = decoratedtoken{ element = c1; }	|
	c2 = predefinedtoken{ element = c2; }
;

definition
returns [org.emftext.sdk.concretesyntax.Definition element = null]
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
returns [org.emftext.sdk.concretesyntax.Cardinality element = null]
:
	c0 = plus{ element = c0; }	|
	c1 = star{ element = c1; }	|
	c2 = questionmark{ element = c2; }
;

COMMENTS
:
	'//'(~('\n'|'\r'))*{ _channel = 99; }
;
QUALIFIED_NAME
:
	('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')*('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)*
;
NUMBER
:
	('0'..'9')+
;
WHITESPACE
:
	(' '|'\t'|'\f'){ _channel = 99; }
;
LINEBREAK
:
	('\r\n'|'\r'|'\n'){ _channel = 99; }
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
