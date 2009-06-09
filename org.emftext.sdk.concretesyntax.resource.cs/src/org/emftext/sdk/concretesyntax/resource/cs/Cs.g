grammar Cs;

options {
	superClass = AbstractEMFTextParser;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.sdk.concretesyntax.resource.cs;
}

@lexer::members {
	public java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime.RecognitionException>();
	public java.util.List<java.lang.Integer> lexerExceptionsPosition       = new java.util.ArrayList<java.lang.Integer>();
	
	public void reportError(org.antlr.runtime.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.sdk.concretesyntax.resource.cs;
	
	import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
}

@members{
	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();
	private int stopIndex = -1;
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	private boolean reachedIndex = false;
	private org.emftext.runtime.resource.impl.IExpectedElement expectedElement;
	
	// This default constructor is only used to call createInstance() on it
	public CsParser() {
		super();
	}
	
	protected java.lang.Object getTypeObject() {
		java.lang.Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.runtime.IOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	protected org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch getReferenceResolverSwitch() {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			return null;
		}
		return (org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch) resource.getReferenceResolverSwitch();
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime.RecognitionException {
		((CsLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((CsLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		java.lang.Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.ConcreteSyntax.class) {
				return parse_org_emftext_sdk_concretesyntax_ConcreteSyntax();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.Import.class) {
				return parse_org_emftext_sdk_concretesyntax_Import();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.Option.class) {
				return parse_org_emftext_sdk_concretesyntax_Option();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.Rule.class) {
				return parse_org_emftext_sdk_concretesyntax_Rule();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.Sequence.class) {
				return parse_org_emftext_sdk_concretesyntax_Sequence();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.Choice.class) {
				return parse_org_emftext_sdk_concretesyntax_Choice();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.CsString.class) {
				return parse_org_emftext_sdk_concretesyntax_CsString();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken.class) {
				return parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken.class) {
				return parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.PlaceholderInQuotes.class) {
				return parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.Containment.class) {
				return parse_org_emftext_sdk_concretesyntax_Containment();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.CompoundDefinition.class) {
				return parse_org_emftext_sdk_concretesyntax_CompoundDefinition();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.WhiteSpaces.class) {
				return parse_org_emftext_sdk_concretesyntax_WhiteSpaces();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.LineBreak.class) {
				return parse_org_emftext_sdk_concretesyntax_LineBreak();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.NormalToken.class) {
				return parse_org_emftext_sdk_concretesyntax_NormalToken();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.TokenPriorityDirective.class) {
				return parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.PLUS.class) {
				return parse_org_emftext_sdk_concretesyntax_PLUS();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.STAR.class) {
				return parse_org_emftext_sdk_concretesyntax_STAR();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.QUESTIONMARK.class) {
				return parse_org_emftext_sdk_concretesyntax_QUESTIONMARK();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.Abstract.class) {
				return parse_org_emftext_sdk_concretesyntax_Abstract();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.TokenStyle.class) {
				return parse_org_emftext_sdk_concretesyntax_TokenStyle();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.Annotation.class) {
				return parse_org_emftext_sdk_concretesyntax_Annotation();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.KeyValuePair.class) {
				return parse_org_emftext_sdk_concretesyntax_KeyValuePair();
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
	
	public org.emftext.runtime.resource.ITextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
		try {
			if (encoding == null) {
				return new CsParser(new org.antlr.runtime.CommonTokenStream(new CsLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
			} else {
				return new CsParser(new org.antlr.runtime.CommonTokenStream(new CsLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.runtime.EMFTextRuntimePlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	public org.emftext.runtime.resource.impl.IExpectedElement parseToIndex(int index, org.eclipse.emf.ecore.EClass type) {
		stopIndex = index;
		parseToIndexTypeObject = type;
		parse();
		return this.expectedElement;
	}
	
	public java.lang.Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory,ContainerType element, org.eclipse.emf.ecore.EReference reference, String id,org.eclipse.emf.ecore.EObject proxy) {
				org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the parser is used for
			// code completion
			return;
		}
		resource.registerContextDependentProxy(factory, element, reference, id, proxy);
	}
	
	protected void addErrorToResource(java.lang.String errorMessage, int line,
	int charPositionInLine, int startIndex, int stopIndex) {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the parser is used for
			// code completion
			return;
		}
		resource.addError(errorMessage, line, charPositionInLine, startIndex, stopIndex);
	}
	
	protected void copyLocalizationInfos(org.eclipse.emf.ecore.EObject source, org.eclipse.emf.ecore.EObject target) {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the parser is used for
			// code completion
			return;
		}
		final org.emftext.runtime.resource.ILocationMap locationsMap = resource.getLocationMap();
		locationsMap.setCharStart(target, locationsMap.getCharStart(source)); 		locationsMap.setCharEnd(target, locationsMap.getCharEnd(source)); 		locationsMap.setColumn(target, locationsMap.getColumn(source)); 		locationsMap.setLine(target, locationsMap.getLine(source));
	}
	
	protected void copyLocalizationInfos(org.antlr.runtime.CommonToken source, org.eclipse.emf.ecore.EObject target) {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the parser is used for
			// code completion
			return;
		}
		final org.emftext.runtime.resource.ILocationMap locationsMap = resource.getLocationMap();
		locationsMap.setCharStart(target, source.getStartIndex()); 		locationsMap.setCharEnd(target, source.getStopIndex());			locationsMap.setColumn(target, source.getCharPositionInLine());			locationsMap.setLine(target, source.getLine());
	}
	
	public void terminateParsingIfCursorIndexReached(org.emftext.runtime.resource.impl.IExpectedElement expectedElement) {
		if (this.stopIndex < 0) {
			return;
		}
		if (this.reachedIndex) {
			return;
		}
		if (lastTokenIndex >= input.size()) {
			this.expectedElement = expectedElement;
			this.reachedIndex = true;
			return;
		}
		final org.antlr.runtime.CommonToken lastToken = (org.antlr.runtime.CommonToken) input.get(lastTokenIndex);
		org.antlr.runtime.CommonToken currentToken = null;
				final int currentTokenIndex = java.lang.Math.max(0, Math.min(input.size() - 1, input.index()));
		for (int index = lastTokenIndex; index < currentTokenIndex; index++) {
			final org.antlr.runtime.CommonToken tokenAtIndex = (org.antlr.runtime.CommonToken) input.get(index);
			currentToken = tokenAtIndex;
			java.lang.System.out.println("TOKEN: " + tokenAtIndex);
		}
		lastTokenIndex = java.lang.Math.max(0, currentTokenIndex);
		if (currentToken != null) {
			final int start = lastToken.getStartIndex();
			final int end = currentToken.getStopIndex();
			java.lang.System.out.println("At " + start + "-" + end + ": " + expectedElement);
			boolean reachedStopIndex = end >= this.stopIndex;
			if (reachedStopIndex) {
				this.expectedElement = expectedElement;
				this.reachedIndex = true;
				return;
			}
		} else {
			java.lang.System.out.println("At ?-?: " + expectedElement);
			this.expectedElement = expectedElement;
			this.reachedIndex = true;
			return;
		}
	}
	
	public java.lang.Object recoverFromMismatchedToken(org.antlr.runtime.IntStream input, int ttype, org.antlr.runtime.BitSet follow) throws org.antlr.runtime.RecognitionException {
		if (stopIndex < 0) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	(
		c0 = parse_org_emftext_sdk_concretesyntax_ConcreteSyntax{ element = c0; }
	)
	EOF	
;

parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS), element));
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS, a0_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			
		)
		
	)*	
	(
		(
			a1_0 = parse_org_emftext_sdk_concretesyntax_Abstract			{
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER), element));
				if (a1_0 != null) {
					if (a1_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER), a1_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a1_0, element); 				}
			}
		)
		
	)?	
	a2 = 'SYNTAXDEF' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("SYNTAXDEF"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		a3 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), element));
			if (a3 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a3).getLine(), ((org.antlr.runtime.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a3).getStartIndex(), ((org.antlr.runtime.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a3, element);
			}
		}
	)
	
	a4 = 'FOR' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("FOR"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
	(
		a5 = QUOTED_60_62		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), element));
			if (a5 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a5).getLine(), ((org.antlr.runtime.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a5).getStartIndex(), ((org.antlr.runtime.CommonToken) a5).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a5, element);
				copyLocalizationInfos((CommonToken) a5, proxy);
			}
		}
	)
	
	(
		(
			(
				a6 = QUOTED_60_62				
				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), element));
					if (a6 != null) {
						org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a6).getLine(), ((org.antlr.runtime.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a6).getStartIndex(), ((org.antlr.runtime.CommonToken) a6).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken) a6, element);
					}
				}
			)
			
		)
		
	)?	
	(
		(
			a7 = 'START' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("START"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			
			(
				(
					a8 = QUALIFIED_NAME					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), element));
						if (a8 != null) {
							org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
							tokenResolver.setOptions(getOptions());
							org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
							java.lang.Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a8).getLine(), ((org.antlr.runtime.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a8).getStartIndex(), ((org.antlr.runtime.CommonToken) a8).getStopIndex());
							}
							String resolved = (String) resolvedObject;
							org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
							collectHiddenTokens(element);
							registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
							if (proxy != null) {
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken) a8, element);
							copyLocalizationInfos((CommonToken) a8, proxy);
						}
					}
				)
				
			)
			
			(
				(
					a9 = ',' {
						terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(","));
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a9, element);
					}
					
					(
						(
							a10 = QUALIFIED_NAME							
							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								}
								terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), element));
								if (a10 != null) {
									org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
									tokenResolver.setOptions(getOptions());
									org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
									tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
									java.lang.Object resolvedObject = result.getResolvedToken();
									if (resolvedObject == null) {
										addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a10).getLine(), ((org.antlr.runtime.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a10).getStartIndex(), ((org.antlr.runtime.CommonToken) a10).getStopIndex());
									}
									String resolved = (String) resolvedObject;
									org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
									collectHiddenTokens(element);
									registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
									if (proxy != null) {
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy);
									}
									collectHiddenTokens(element);
									copyLocalizationInfos((CommonToken) a10, element);
									copyLocalizationInfos((CommonToken) a10, proxy);
								}
							}
						)
						
					)
					
				)
				
			)*			
		)
		
	)?	
	(
		(
			a11 = 'IMPORTS' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("IMPORTS"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a11, element);
			}
			
			a12 = '{' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("{"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a12, element);
			}
			
			(
				(
					(
						a13_0 = parse_org_emftext_sdk_concretesyntax_Import						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS), element));
							if (a13_0 != null) {
								if (a13_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS, a13_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a13_0, element); 							}
						}
					)
					
				)
				
			)*			
			a14 = '}' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("}"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a14, element);
			}
			
		)
		
	)?	
	(
		(
			a15 = 'OPTIONS' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("OPTIONS"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a15, element);
			}
			
			a16 = '{' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("{"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a16, element);
			}
			
			(
				(
					(
						a17_0 = parse_org_emftext_sdk_concretesyntax_Option						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS), element));
							if (a17_0 != null) {
								if (a17_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS, a17_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a17_0, element); 							}
						}
					)
					
					a18 = ';' {
						terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(";"));
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a18, element);
					}
					
				)
				
			)*			
			a19 = '}' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("}"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a19, element);
			}
			
		)
		
	)?	
	(
		(
			a20 = 'TOKENS' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("TOKENS"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a20, element);
			}
			
			a21 = '{' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("{"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a21, element);
			}
			
			(
				(
					(
						a22_0 = parse_org_emftext_sdk_concretesyntax_TokenDirective						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS), element));
							if (a22_0 != null) {
								if (a22_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS, a22_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a22_0, element); 							}
						}
					)
					
					a23 = ';' {
						terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(";"));
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a23, element);
					}
					
				)
				
			)*			
			a24 = '}' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("}"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a24, element);
			}
			
		)
		
	)?	
	(
		(
			a25 = 'TOKENSTYLES' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("TOKENSTYLES"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a25, element);
			}
			
			a26 = '{' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("{"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a26, element);
			}
			
			(
				(
					(
						a27_0 = parse_org_emftext_sdk_concretesyntax_TokenStyle						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES), element));
							if (a27_0 != null) {
								if (a27_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES, a27_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a27_0, element); 							}
						}
					)
					
				)
				
			)*			
			a28 = '}' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("}"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a28, element);
			}
			
		)
		
	)?	
	a29 = 'RULES' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("RULES"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a29, element);
	}
	
	a30 = '{' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("{"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a30, element);
	}
	
	(
		(
			(
				a31_0 = parse_org_emftext_sdk_concretesyntax_Rule				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES), element));
					if (a31_0 != null) {
						if (a31_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, a31_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a31_0, element); 					}
				}
			)
			
		)+		
	)
	
	a32 = '}' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("}"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a32, element);
	}
	
;

parse_org_emftext_sdk_concretesyntax_Import returns [org.emftext.sdk.concretesyntax.Import element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	
	a1 = ':' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(":"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = QUOTED_60_62		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), element));
			if (a2 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a2, element);
				copyLocalizationInfos((CommonToken) a2, proxy);
			}
		}
	)
	
	(
		(
			(
				a3 = QUOTED_60_62				
				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), element));
					if (a3 != null) {
						org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a3).getLine(), ((org.antlr.runtime.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a3).getStartIndex(), ((org.antlr.runtime.CommonToken) a3).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken) a3, element);
					}
				}
			)
			
		)
		
	)?	
	(
		(
			a4 = 'WITH' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("WITH"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
			a5 = 'SYNTAX' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("SYNTAX"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
			(
				a6 = QUALIFIED_NAME				
				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), element));
					if (a6 != null) {
						org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a6).getLine(), ((org.antlr.runtime.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a6).getStartIndex(), ((org.antlr.runtime.CommonToken) a6).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getImportConcreteSyntaxReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
						if (proxy != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), proxy);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken) a6, element);
						copyLocalizationInfos((CommonToken) a6, proxy);
					}
				}
			)
			
			(
				(
					(
						a7 = QUOTED_60_62						
						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
							}
							terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), element));
							if (a7 != null) {
								org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
								tokenResolver.setOptions(getOptions());
								org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a7).getLine(), ((org.antlr.runtime.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a7).getStartIndex(), ((org.antlr.runtime.CommonToken) a7).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((CommonToken) a7, element);
							}
						}
					)
					
				)
				
			)?			
		)
		
	)?	
;

parse_org_emftext_sdk_concretesyntax_Option returns [org.emftext.sdk.concretesyntax.Option element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.OptionTypes resolved = (org.emftext.sdk.concretesyntax.OptionTypes)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	
	a1 = '=' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("="));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = QUOTED_34_34		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), element));
			if (a2 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	
;

parse_org_emftext_sdk_concretesyntax_Rule returns [org.emftext.sdk.concretesyntax.Rule element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__ANNOTATIONS), element));
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__ANNOTATIONS, a0_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			
		)
		
	)*	
	(
		a1 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), element));
			if (a1 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleMetaclassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a1, element);
				copyLocalizationInfos((CommonToken) a1, proxy);
			}
		}
	)
	
	a2 = '::=' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("::="));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), element));
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	
	a4 = ';' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(";"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	
;

parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null]
@init{
}
:
	(
		(
			a0_0 = parse_org_emftext_sdk_concretesyntax_Definition			{
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSequence();
				}
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS), element));
				if (a0_0 != null) {
					if (a0_0 != null) {
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS, a0_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a0_0, element); 				}
			}
		)
		
	)+	
;

parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_sdk_concretesyntax_Sequence		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS), element));
			if (a0_0 != null) {
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		}
	)
	
	(
		(
			a1 = '|' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("|"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2_0 = parse_org_emftext_sdk_concretesyntax_Sequence				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS), element));
					if (a2_0 != null) {
						if (a2_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a2_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a2_0, element); 					}
				}
			)
			
		)
		
	)*	
;

parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCsString();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	
;

parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	
	a1 = '[' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("["));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), element));
			if (a2 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.TokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a2, element);
				copyLocalizationInfos((CommonToken) a2, proxy);
			}
		}
	)
	
	a3 = ']' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("]"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		(
			a4_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
				}
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), element));
				if (a4_0 != null) {
					if (a4_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			}
		)
		
	)?	
;

parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	
	a1 = '[' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("["));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	a2 = ']' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("]"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		(
			a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
				}
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), element));
				if (a3_0 != null) {
					if (a3_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			}
		)
		
	)?	
;

parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	
	a1 = '[' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("["));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = QUOTED_39_39		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), element));
			if (a2 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	
	a3 = ',' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(","));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	
	(
		a4 = QUOTED_39_39		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), element));
			if (a4 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a4).getLine(), ((org.antlr.runtime.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a4).getStartIndex(), ((org.antlr.runtime.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a4, element);
			}
		}
	)
	
	a5 = ']' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("]"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	
	(
		(
			a6_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
				}
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), element));
				if (a6_0 != null) {
					if (a6_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), a6_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a6_0, element); 				}
			}
		)
		
	)?	
;

parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	
	(
		(
			a1 = ':' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(":"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2 = QUALIFIED_NAME				
				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), element));
					if (a2 != null) {
						org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
						if (proxy != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken) a2, element);
						copyLocalizationInfos((CommonToken) a2, proxy);
					}
				}
			)
			
			(
				(
					a3 = ',' {
						terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(","));
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a3, element);
					}
					
					(
						a4 = QUALIFIED_NAME						
						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
							}
							terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), element));
							if (a4 != null) {
								org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
								tokenResolver.setOptions(getOptions());
								org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a4).getLine(), ((org.antlr.runtime.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a4).getStartIndex(), ((org.antlr.runtime.CommonToken) a4).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
								collectHiddenTokens(element);
								registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
								if (proxy != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((CommonToken) a4, element);
								copyLocalizationInfos((CommonToken) a4, proxy);
							}
						}
					)
					
				)
				
			)*			
		)
		
	)?	
	(
		(
			a5_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
				}
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), element));
				if (a5_0 != null) {
					if (a5_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), a5_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a5_0, element); 				}
			}
		)
		
	)?	
;

parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null]
@init{
}
:
	a0 = '(' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("("));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), element));
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	
	a2 = ')' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(")"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	
	(
		(
			a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
				}
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), element));
				if (a3_0 != null) {
					if (a3_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			}
		)
		
	)?	
;

parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null]
@init{
}
:
	(
		a0 = HEXNUMBER		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	
;

parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null]
@init{
}
:
	a0 = '!' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("!"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1 = NUMBER		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), element));
			if (a1 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	
;

parse_org_emftext_sdk_concretesyntax_NormalToken returns [org.emftext.sdk.concretesyntax.NormalToken element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS), element));
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS, a0_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			
		)
		
	)*	
	a1 = 'DEFINE' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("DEFINE"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), element));
			if (a2 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	
	(
		a3 = QUOTED_36_36		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX), element));
			if (a3 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a3).getLine(), ((org.antlr.runtime.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a3).getStartIndex(), ((org.antlr.runtime.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a3, element);
			}
		}
	)
	
	(
		(
			a4 = 'COLLECT' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("COLLECT"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			
			a5 = 'IN' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("IN"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			
			(
				a6 = QUALIFIED_NAME				
				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), element));
					if (a6 != null) {
						org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a6).getLine(), ((org.antlr.runtime.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a6).getStartIndex(), ((org.antlr.runtime.CommonToken) a6).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken) a6, element);
					}
				}
			)
			
		)
		
	)?	
;

parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null]
@init{
}
:
	a0 = 'PRIORITIZE' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("PRIORITIZE"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), element));
			if (a1 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.TokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a1, element);
				copyLocalizationInfos((CommonToken) a1, proxy);
			}
		}
	)
	
;

parse_org_emftext_sdk_concretesyntax_PLUS returns [org.emftext.sdk.concretesyntax.PLUS element = null]
@init{
}
:
	a0 = '+' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("+"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPLUS();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

parse_org_emftext_sdk_concretesyntax_STAR returns [org.emftext.sdk.concretesyntax.STAR element = null]
@init{
}
:
	a0 = '*' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("*"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSTAR();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

parse_org_emftext_sdk_concretesyntax_QUESTIONMARK returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null]
@init{
}
:
	a0 = '?' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("?"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

parse_org_emftext_sdk_concretesyntax_Abstract returns [org.emftext.sdk.concretesyntax.Abstract element = null]
@init{
}
:
	a0 = 'ABSTRACT' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("ABSTRACT"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAbstract();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	
	a1 = 'COLOR' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("COLOR"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	
	(
		a2 = HEXNUMBER		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), element));
			if (a2 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	
	(
		(
			a3 = ',' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(","));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			
			(
				a4 = QUALIFIED_NAME				
				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), element));
					if (a4 != null) {
						org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a4).getLine(), ((org.antlr.runtime.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a4).getStartIndex(), ((org.antlr.runtime.CommonToken) a4).getStopIndex());
						}
						org.emftext.sdk.concretesyntax.FontStyle resolved = (org.emftext.sdk.concretesyntax.FontStyle)resolvedObject;
						if (resolved != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES, resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken) a4, element);
					}
				}
			)
			
		)
		
	)*	
	a5 = ';' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(";"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	
;

parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null]
@init{
}
:
	a0 = '@' {
		terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("@"));
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), element));
			if (a1 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.AnnotationType resolved = (org.emftext.sdk.concretesyntax.AnnotationType)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	
	(
		(
			a2 = '(' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("("));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			
			(
				a3_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS), element));
					if (a3_0 != null) {
						if (a3_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, a3_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a3_0, element); 					}
				}
			)
			
			(
				(
					a4 = ',' {
						terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(","));
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					
					(
						a5_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
							}
							terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS), element));
							if (a5_0 != null) {
								if (a5_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, a5_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a5_0, element); 							}
						}
					)
					
				)
				
			)*			
			a6 = ')' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString(")"));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			
		)
		
	)?	
;

parse_org_emftext_sdk_concretesyntax_KeyValuePair returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
			}
			terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), element));
			if (a0 != null) {
				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	
	(
		(
			a1 = '=' {
				terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedCsString("="));
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			
			(
				a2 = QUOTED_34_34				
				{
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
					}
					terminateParsingIfCursorIndexReached(new org.emftext.runtime.resource.impl.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), element));
					if (a2 != null) {
						org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((CommonToken) a2, element);
					}
				}
			)
			
		)
		
	)?	
;

parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_NormalToken{ element = c0; }
	|	c1 = parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective{ element = c1; }
	
;

parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_CsString{ element = c0; }
	|	c1 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken{ element = c1; }
	|	c2 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken{ element = c2; }
	|	c3 = parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes{ element = c3; }
	|	c4 = parse_org_emftext_sdk_concretesyntax_Containment{ element = c4; }
	|	c5 = parse_org_emftext_sdk_concretesyntax_CompoundDefinition{ element = c5; }
	|	c6 = parse_org_emftext_sdk_concretesyntax_WhiteSpaces{ element = c6; }
	|	c7 = parse_org_emftext_sdk_concretesyntax_LineBreak{ element = c7; }
	
;

parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_PLUS{ element = c0; }
	|	c1 = parse_org_emftext_sdk_concretesyntax_STAR{ element = c1; }
	|	c2 = parse_org_emftext_sdk_concretesyntax_QUESTIONMARK{ element = c2; }
	
;

COMMENTS:
	'//'(~('\n'|'\r'))*
	{ _channel = 99; }
;
QUALIFIED_NAME:
	('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')*('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)*;
NUMBER:
	('0'..'9')+;
HEXNUMBER:
	'#'('0'..'9'|'A'..'F'|'a'..'f')+;
WHITESPACE:
	(' '|'\t'|'\f')
	{ _channel = 99; }
;
LINEBREAK:
	('\r\n'|'\r'|'\n')
	{ _channel = 99; }
;
QUOTED_60_62:
	('<')(~('>')|('\\''>'))*('>')
;
QUOTED_34_34:
	('"')(~('"')|('\\''"'))*('"')
;
QUOTED_39_39:
	('\'')(~('\'')|('\\''\''))*('\'')
;
QUOTED_36_36:
	('$')(~('$')|('\\''$'))*('$')
;
