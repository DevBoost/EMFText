grammar Generatorconfig;

options {
	superClass = GeneratorconfigANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
	public java.util.List<java.lang.Integer> lexerExceptionsPosition = new java.util.ArrayList<java.lang.Integer>();
	
	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;
}

@members{
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolverFactory tokenResolverFactory = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenResolverFactory();
	@SuppressWarnings("unused")
	
	private int lastPosition;
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenResolveResult tokenResolveResult = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenResolveResult();
	private boolean rememberExpectedElements = false;
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	private java.util.List<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal>();
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	//helper lists to allow a lexer to pass errors to its parser
	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>> postParseCommands;
	private boolean terminateParsing;
	private int tokenIndexOfLastCompleteElement;
	private int expectedElementsIndexOfLastCompleteElement;
	
	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>() {
			public boolean execute(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for
					// code completion
					return true;
				}
				resource.addProblem(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem() {
					public org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType getType() {
						return org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType.ERROR;
					}
					public java.lang.String getMessage() {
						return errorMessage;
					}
				}, line, charPositionInLine, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal expectedElement) {
		if (!this.rememberExpectedElements) {
			return;
		}
		setPosition(expectedElement, input.index());
		this.expectedElements.add(expectedElement);
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigDummyEObject dummy) {
		java.lang.Object value = element.eGet(structuralFeature);
		java.lang.Object mapKey = dummy.getValueByName("key");
		java.lang.Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigMapUtil.castToEMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	
	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
	}
	
	protected org.eclipse.emf.ecore.EObject apply(org.eclipse.emf.ecore.EObject target, java.util.List<org.eclipse.emf.ecore.EObject> dummyEObjects) {
		org.eclipse.emf.ecore.EObject currentTarget = target;
		for (org.eclipse.emf.ecore.EObject object : dummyEObjects) {
			assert(object instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigDummyEObject);
			org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigDummyEObject dummy = (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigDummyEObject) object;
			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>() {
			public boolean execute(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource resource) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for
					// code completion
					return true;
				}
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_2_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>() {
			public boolean execute(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource resource) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for
					// code completion
					return true;
				}
				if (source == null) {
					return true;
				}
				locationMap.setCharStart(target, source.getStartIndex());
				locationMap.setCharEnd(target, source.getStopIndex());
				locationMap.setColumn(target, source.getCharPositionInLine());
				locationMap.setLine(target, source.getLine());
				return true;
			}
		});
	}
	
	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
		try {
			if (encoding == null) {
				return new GeneratorconfigParser(new org.antlr.runtime3_2_0.CommonTokenStream(new GeneratorconfigLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new GeneratorconfigParser(new org.antlr.runtime3_2_0.CommonTokenStream(new GeneratorconfigLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	// This default constructor is only used to call createInstance() on it
	public GeneratorconfigParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((GeneratorconfigLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((GeneratorconfigLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		java.lang.Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.GeneratorConfig.class) {
				return parse_org_emftext_sdk_generatorconfig_GeneratorConfig();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.GeneratorRule.class) {
				return parse_org_emftext_sdk_generatorconfig_GeneratorRule();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.ClassRule.class) {
				return parse_org_emftext_sdk_generatorconfig_ClassRule();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.FeatureRule.class) {
				return parse_org_emftext_sdk_generatorconfig_FeatureRule();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.FeatureReference.class) {
				return parse_org_emftext_sdk_generatorconfig_FeatureReference();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.ClassName.class) {
				return parse_org_emftext_sdk_generatorconfig_ClassName();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.Features.class) {
				return parse_org_emftext_sdk_generatorconfig_Features();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.ClassRuleReference.class) {
				return parse_org_emftext_sdk_generatorconfig_ClassRuleReference();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.FeatureRuleReference.class) {
				return parse_org_emftext_sdk_generatorconfig_FeatureRuleReference();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.FeatureName.class) {
				return parse_org_emftext_sdk_generatorconfig_FeatureName();
			}
			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.Feature.class) {
				return parse_org_emftext_sdk_generatorconfig_Feature();
			}
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
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.NormalTokenDefinition.class) {
				return parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.PartialTokenDefinition.class) {
				return parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.TokenPriorityDirective.class) {
				return parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.AtomicRegex.class) {
				return parse_org_emftext_sdk_concretesyntax_AtomicRegex();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.RegexReference.class) {
				return parse_org_emftext_sdk_concretesyntax_RegexReference();
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
		throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigUnexpectedContentTypeException(typeObject);
	}
	
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public java.lang.Object getMissingSymbol(org.antlr.runtime3_2_0.IntStream arg0, org.antlr.runtime3_2_0.RecognitionException arg1, int arg2, org.antlr.runtime3_2_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	protected java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation getMetaInformation() {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation();
	}
	
	public java.lang.Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected java.lang.Object getTypeObject() {
		java.lang.Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	// Implementation that calls {@link #doParse()}  and handles the thrown
	// RecognitionExceptions.
	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>>();
		org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigParseResult parseResult = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_2_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				//? can be caused if a null is set on EMF models where not allowed;
				//? this will just happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_2_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource dummyResource) {
		rememberExpectedElements = true;
		parseToIndexTypeObject = type;
		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigParseResult result = parse();
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContents().add(root);
			}
			for (org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal>();
		java.util.List<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				System.out.println("FOLLOW ELEMENT " + expectedElementI);
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 184;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
			System.out.println("REMAINING TOKEN: " + nextToken);
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected terminals
				// can be set
				for (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are kept
				for (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal nextFollow : currentFollowSet) {
					System.out.println("CHECKING : " + nextFollow);
					if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						System.out.println("MATCH! " + nextFollow);
						java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigPair<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigPair<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
							org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement newFollower = newFollowerPair.getLeft();
							org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal newFollowTerminal = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
							newFollowSet.add(newFollowTerminal);
							expectedElements.add(newFollowTerminal);
						}
					}
				}
				currentFollowSet.clear();
				currentFollowSet.addAll(newFollowSet);
			}
			followSetID++;
		}
		// after the last token in the stream we must set the position for the elements that were
		// added during the last iteration of the loop
		for (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = java.lang.Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_2_0.CommonToken tokenAtIndex = (org.antlr.runtime3_2_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = java.lang.Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public java.lang.Object recoverFromMismatchedToken(org.antlr.runtime3_2_0.IntStream input, int ttype, org.antlr.runtime3_2_0.BitSet follow) throws org.antlr.runtime3_2_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
		postParseCommands.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>() {
			public boolean execute(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for
					// code completion
					return true;
				}
				resource.registerContextDependentProxy(factory, element, reference, id, proxy);
				return true;
			}
		});
	}
	
	// Translates errors thrown by the parser into human readable messages.
	public void reportError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		java.lang.String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			java.lang.String tokenName = "<unknown>";
			if (mte.expecting == Token.EOF) {
				tokenName = "EOF";
			} else {
				tokenName = getTokenNames()[mte.expecting];
				tokenName = org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigStringUtil.formatTokenName(tokenName);
			}
			message = "Syntax error on token \"" + e.token.getText() + "\", \"" + tokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_2_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_2_0.MismatchedTreeNodeException) e;
			java.lang.String tokenName = "<unknown>";
			if (mtne.expecting == Token.EOF) {
				tokenName = "EOF";
			} else {
				tokenName = getTokenNames()[mtne.expecting];
			}
			message = "mismatched tree node: "+"xxx" +"; expecting " + tokenName;
		} else if (e instanceof org.antlr.runtime3_2_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_2_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText+"}?";
		}
		// the resource may be null if the parse is used for code completion
		final java.lang.String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_2_0.CommonToken) {
			final org.antlr.runtime3_2_0.CommonToken ct = (org.antlr.runtime3_2_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	// Translates errors thrown by the lexer into human readable messages.
	public void reportLexicalError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		java.lang.String message = "";
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_2_0.EarlyExitException) {
			org.antlr.runtime3_2_0.EarlyExitException eee = (org.antlr.runtime3_2_0.EarlyExitException) e;
			message ="required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedRangeException) {
			org.antlr.runtime3_2_0.MismatchedRangeException mre = (org.antlr.runtime3_2_0.MismatchedRangeException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message ="rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.index, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public void terminate() {
		terminateParsing = true;
	}
	
	protected void completedElement(Object element) {
		if (element instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_0 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule(), "ClassRule");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_1 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule(), "FeatureRule");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_2 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_3 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule(), "::=");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_4 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference(), "FEATURE");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_5 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassName(), "CLASSNAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_6 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatures(), "FEATURES");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_7 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRuleReference(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRuleReference().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE_REFERENCE__RULE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_8 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRuleReference(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRuleReference().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE_REFERENCE__RULE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_9 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureName(), "FEATURENAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_10 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeature(), "FEATURE");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_11 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), "QUOTED_34_34_92");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_12 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_13 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_14 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_15 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_16 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), "(");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_17 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), "HEXNUMBER");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_18 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), "!");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_19 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule(), ";");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_20 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE__NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_21 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule(), "::=");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_22 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule(), ";");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_23 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE__NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_24 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule(), "::=");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_25 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule(), ";");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_26 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference(), "(");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_27 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_REFERENCE__FEATURE_NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_28 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference(), ")");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_29 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), "|");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_30 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), ";");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_31 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), ")");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_32 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), "@");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_33 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAbstract(), "ABSTRACT");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_34 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "SYNTAXDEF");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_35 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_36 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "FOR");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_37 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), "QUOTED_60_62");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_38 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), "QUOTED_60_62");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_39 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "START");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_40 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "IMPORTS");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_41 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "OPTIONS");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_42 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "TOKENS");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_43 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "TOKENSTYLES");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_44 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "RULES");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_45 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_46 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), ",");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_47 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_48 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_49 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_50 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_51 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_52 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_53 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_54 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), ";");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_55 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_56 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), "DEFINE");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_57 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), "DEFINE");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_58 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(), "PRIORITIZE");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_59 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_60 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), ";");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_61 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_62 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), "QUOTED_34_34_92");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_63 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_64 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_65 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_66 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_67 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), ":");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_68 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), "QUOTED_60_62");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_69 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), "QUOTED_60_62");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_70 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), "WITH");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_71 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), "SYNTAX");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_72 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_73 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), "QUOTED_60_62");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_74 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), "=");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_75 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), "QUOTED_34_34_92");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_76 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), "::=");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_77 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), "[");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_78 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_79 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), "]");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_80 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPLUS(), "+");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_81 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSTAR(), "*");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_82 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getQUESTIONMARK(), "?");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_83 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), "[");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_84 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), "]");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_85 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), "[");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_86 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), "QUOTED_39_39_92");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_87 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), ",");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_88 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), "QUOTED_39_39_92");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_89 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), ",");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_90 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), "]");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_91 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), "QUOTED_39_39_92");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_92 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), ":");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_93 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_94 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), ",");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_95 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_96 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), "NUMBER");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_97 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_98 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), "QUOTED_36_36");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_99 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_100 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), "+");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_101 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), "COLLECT");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_102 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), "IN");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_103 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_104 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), "FRAGMENT");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_105 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_106 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), "+");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_107 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_108 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), "COLOR");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_109 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), "HEXNUMBER");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_110 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), ",");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_111 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), ";");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_112 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_113 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_114 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), "(");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_115 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), "QUALIFIED_NAME");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_116 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), ",");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_117 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), ")");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_118 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), "=");
	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_119 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), "QUOTED_34_34_92");
	
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_0 = org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorConfig().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_1 = org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorConfig().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_2 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_3 = org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__DEFINITION);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_4 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotable().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTABLE__ANNOTATIONS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_5 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_6 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_7 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_8 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_9 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_10 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_11 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_12 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_13 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinalityDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_14 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_15 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexComposite().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS);
	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_16 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS);
	
	private final static org.eclipse.emf.ecore.EStructuralFeature[] EMPTY_FEATURE_ARRAY = new org.eclipse.emf.ecore.EStructuralFeature[0];
	
	public static void wire0() {
		TERMINAL_2.addFollower(TERMINAL_3, EMPTY_FEATURE_ARRAY);
		TERMINAL_3.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_3.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_0.addFollower(TERMINAL_20, EMPTY_FEATURE_ARRAY);
		TERMINAL_20.addFollower(TERMINAL_21, EMPTY_FEATURE_ARRAY);
		TERMINAL_21.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_21.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_22.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_22.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_1.addFollower(TERMINAL_23, EMPTY_FEATURE_ARRAY);
		TERMINAL_23.addFollower(TERMINAL_24, EMPTY_FEATURE_ARRAY);
		TERMINAL_24.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_24.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
		TERMINAL_25.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
		TERMINAL_25.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
		TERMINAL_4.addFollower(TERMINAL_26, EMPTY_FEATURE_ARRAY);
		TERMINAL_26.addFollower(TERMINAL_27, EMPTY_FEATURE_ARRAY);
		TERMINAL_27.addFollower(TERMINAL_28, EMPTY_FEATURE_ARRAY);
		TERMINAL_28.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_28.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_28.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_28.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_28.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_28.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_28.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_5.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_5.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_6.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_6.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_6.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_6.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_6.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_6.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_6.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_7.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_7.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_7.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_7.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_7.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_7.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_7.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_8.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_8.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_8.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_8.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_8.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_8.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_8.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_9.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_9.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_9.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_9.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_9.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_9.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_9.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_10.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_10.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_10.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_10.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_10.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_10.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_10.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_34.addFollower(TERMINAL_35, EMPTY_FEATURE_ARRAY);
		TERMINAL_35.addFollower(TERMINAL_36, EMPTY_FEATURE_ARRAY);
		TERMINAL_36.addFollower(TERMINAL_37, EMPTY_FEATURE_ARRAY);
		TERMINAL_37.addFollower(TERMINAL_38, EMPTY_FEATURE_ARRAY);
		TERMINAL_37.addFollower(TERMINAL_39, EMPTY_FEATURE_ARRAY);
		TERMINAL_37.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
		TERMINAL_37.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
		TERMINAL_37.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
		TERMINAL_37.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
		TERMINAL_37.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_38.addFollower(TERMINAL_39, EMPTY_FEATURE_ARRAY);
		TERMINAL_38.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
		TERMINAL_38.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
		TERMINAL_38.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
		TERMINAL_38.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
		TERMINAL_38.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_39.addFollower(TERMINAL_45, EMPTY_FEATURE_ARRAY);
		TERMINAL_45.addFollower(TERMINAL_46, EMPTY_FEATURE_ARRAY);
		TERMINAL_45.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
		TERMINAL_45.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
		TERMINAL_45.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
		TERMINAL_45.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
		TERMINAL_45.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_46.addFollower(TERMINAL_47, EMPTY_FEATURE_ARRAY);
		TERMINAL_47.addFollower(TERMINAL_46, EMPTY_FEATURE_ARRAY);
		TERMINAL_47.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
		TERMINAL_47.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
		TERMINAL_47.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
		TERMINAL_47.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
		TERMINAL_47.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_40.addFollower(TERMINAL_48, EMPTY_FEATURE_ARRAY);
		TERMINAL_48.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
		TERMINAL_48.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
		TERMINAL_50.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
		TERMINAL_50.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
		TERMINAL_50.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
		TERMINAL_50.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_41.addFollower(TERMINAL_51, EMPTY_FEATURE_ARRAY);
		TERMINAL_51.addFollower(TERMINAL_52, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_7, });
		TERMINAL_51.addFollower(TERMINAL_53, EMPTY_FEATURE_ARRAY);
		TERMINAL_54.addFollower(TERMINAL_52, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_7, });
		TERMINAL_54.addFollower(TERMINAL_53, EMPTY_FEATURE_ARRAY);
		TERMINAL_53.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
		TERMINAL_53.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
		TERMINAL_53.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_42.addFollower(TERMINAL_55, EMPTY_FEATURE_ARRAY);
		TERMINAL_55.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, FEATURE_8, });
		TERMINAL_55.addFollower(TERMINAL_56, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
		TERMINAL_55.addFollower(TERMINAL_57, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
		TERMINAL_55.addFollower(TERMINAL_58, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
		TERMINAL_55.addFollower(TERMINAL_59, EMPTY_FEATURE_ARRAY);
		TERMINAL_60.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, FEATURE_8, });
		TERMINAL_60.addFollower(TERMINAL_56, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
		TERMINAL_60.addFollower(TERMINAL_57, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
		TERMINAL_60.addFollower(TERMINAL_58, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
		TERMINAL_60.addFollower(TERMINAL_59, EMPTY_FEATURE_ARRAY);
		TERMINAL_59.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
		TERMINAL_59.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_43.addFollower(TERMINAL_61, EMPTY_FEATURE_ARRAY);
		TERMINAL_61.addFollower(TERMINAL_62, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_9, });
		TERMINAL_61.addFollower(TERMINAL_63, EMPTY_FEATURE_ARRAY);
		TERMINAL_63.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
		TERMINAL_44.addFollower(TERMINAL_64, EMPTY_FEATURE_ARRAY);
		TERMINAL_64.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, FEATURE_10, });
		TERMINAL_64.addFollower(TERMINAL_65, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_10, });
		TERMINAL_64.addFollower(TERMINAL_66, EMPTY_FEATURE_ARRAY);
		TERMINAL_49.addFollower(TERMINAL_67, EMPTY_FEATURE_ARRAY);
		TERMINAL_67.addFollower(TERMINAL_68, EMPTY_FEATURE_ARRAY);
		TERMINAL_68.addFollower(TERMINAL_69, EMPTY_FEATURE_ARRAY);
		TERMINAL_68.addFollower(TERMINAL_70, EMPTY_FEATURE_ARRAY);
		TERMINAL_68.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
		TERMINAL_68.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
		TERMINAL_69.addFollower(TERMINAL_70, EMPTY_FEATURE_ARRAY);
		TERMINAL_69.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
		TERMINAL_69.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
		TERMINAL_70.addFollower(TERMINAL_71, EMPTY_FEATURE_ARRAY);
		TERMINAL_71.addFollower(TERMINAL_72, EMPTY_FEATURE_ARRAY);
		TERMINAL_72.addFollower(TERMINAL_73, EMPTY_FEATURE_ARRAY);
		TERMINAL_72.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
		TERMINAL_72.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
		TERMINAL_73.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
		TERMINAL_73.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
		TERMINAL_52.addFollower(TERMINAL_74, EMPTY_FEATURE_ARRAY);
		TERMINAL_74.addFollower(TERMINAL_75, EMPTY_FEATURE_ARRAY);
		TERMINAL_75.addFollower(TERMINAL_54, EMPTY_FEATURE_ARRAY);
		TERMINAL_65.addFollower(TERMINAL_76, EMPTY_FEATURE_ARRAY);
		TERMINAL_76.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_76.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
		TERMINAL_30.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, FEATURE_10, });
		TERMINAL_30.addFollower(TERMINAL_65, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_10, });
		TERMINAL_30.addFollower(TERMINAL_66, EMPTY_FEATURE_ARRAY);
		TERMINAL_29.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_29.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
		TERMINAL_11.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_11.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_11.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_11.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_11.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_11.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_11.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_12.addFollower(TERMINAL_77, EMPTY_FEATURE_ARRAY);
		TERMINAL_77.addFollower(TERMINAL_78, EMPTY_FEATURE_ARRAY);
		TERMINAL_78.addFollower(TERMINAL_79, EMPTY_FEATURE_ARRAY);
		TERMINAL_79.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_79.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_79.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_79.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_79.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_79.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_79.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_79.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_79.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_79.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_13.addFollower(TERMINAL_83, EMPTY_FEATURE_ARRAY);
		TERMINAL_83.addFollower(TERMINAL_84, EMPTY_FEATURE_ARRAY);
		TERMINAL_84.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_84.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_84.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_84.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_84.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_84.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_84.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_84.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_84.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_84.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_14.addFollower(TERMINAL_85, EMPTY_FEATURE_ARRAY);
		TERMINAL_85.addFollower(TERMINAL_86, EMPTY_FEATURE_ARRAY);
		TERMINAL_86.addFollower(TERMINAL_87, EMPTY_FEATURE_ARRAY);
		TERMINAL_87.addFollower(TERMINAL_88, EMPTY_FEATURE_ARRAY);
		TERMINAL_88.addFollower(TERMINAL_89, EMPTY_FEATURE_ARRAY);
		TERMINAL_88.addFollower(TERMINAL_90, EMPTY_FEATURE_ARRAY);
		TERMINAL_89.addFollower(TERMINAL_91, EMPTY_FEATURE_ARRAY);
		TERMINAL_91.addFollower(TERMINAL_90, EMPTY_FEATURE_ARRAY);
		TERMINAL_90.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_90.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_90.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_90.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_90.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_90.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_90.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_90.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_90.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_90.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_15.addFollower(TERMINAL_92, EMPTY_FEATURE_ARRAY);
		TERMINAL_15.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_15.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_15.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_15.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_15.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_15.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_15.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_15.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_15.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_15.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_92.addFollower(TERMINAL_93, EMPTY_FEATURE_ARRAY);
		TERMINAL_93.addFollower(TERMINAL_94, EMPTY_FEATURE_ARRAY);
		TERMINAL_93.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_93.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_93.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_93.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_93.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_93.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_93.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_93.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_93.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_93.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_94.addFollower(TERMINAL_95, EMPTY_FEATURE_ARRAY);
		TERMINAL_95.addFollower(TERMINAL_94, EMPTY_FEATURE_ARRAY);
		TERMINAL_95.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_95.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_95.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_95.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_95.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_95.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_95.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_95.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_95.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_95.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_16.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_16.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
		TERMINAL_31.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_31.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_31.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
		TERMINAL_31.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_31.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_31.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_31.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_31.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_31.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_31.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_17.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_17.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_17.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_17.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_17.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_17.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_17.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_18.addFollower(TERMINAL_96, EMPTY_FEATURE_ARRAY);
		TERMINAL_96.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_96.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_96.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_96.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_96.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_96.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_96.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_56.addFollower(TERMINAL_97, EMPTY_FEATURE_ARRAY);
		TERMINAL_97.addFollower(TERMINAL_98, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
		TERMINAL_97.addFollower(TERMINAL_99, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
		TERMINAL_100.addFollower(TERMINAL_98, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
		TERMINAL_100.addFollower(TERMINAL_99, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
		TERMINAL_101.addFollower(TERMINAL_102, EMPTY_FEATURE_ARRAY);
		TERMINAL_102.addFollower(TERMINAL_103, EMPTY_FEATURE_ARRAY);
		TERMINAL_103.addFollower(TERMINAL_60, EMPTY_FEATURE_ARRAY);
		TERMINAL_57.addFollower(TERMINAL_104, EMPTY_FEATURE_ARRAY);
		TERMINAL_104.addFollower(TERMINAL_105, EMPTY_FEATURE_ARRAY);
		TERMINAL_105.addFollower(TERMINAL_98, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
		TERMINAL_105.addFollower(TERMINAL_99, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
		TERMINAL_106.addFollower(TERMINAL_98, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
		TERMINAL_106.addFollower(TERMINAL_99, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
		TERMINAL_58.addFollower(TERMINAL_107, EMPTY_FEATURE_ARRAY);
		TERMINAL_107.addFollower(TERMINAL_60, EMPTY_FEATURE_ARRAY);
		TERMINAL_98.addFollower(TERMINAL_100, EMPTY_FEATURE_ARRAY);
		TERMINAL_98.addFollower(TERMINAL_101, EMPTY_FEATURE_ARRAY);
		TERMINAL_98.addFollower(TERMINAL_60, EMPTY_FEATURE_ARRAY);
		TERMINAL_98.addFollower(TERMINAL_106, EMPTY_FEATURE_ARRAY);
		TERMINAL_99.addFollower(TERMINAL_100, EMPTY_FEATURE_ARRAY);
		TERMINAL_99.addFollower(TERMINAL_101, EMPTY_FEATURE_ARRAY);
		TERMINAL_99.addFollower(TERMINAL_60, EMPTY_FEATURE_ARRAY);
		TERMINAL_99.addFollower(TERMINAL_106, EMPTY_FEATURE_ARRAY);
		TERMINAL_80.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_80.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_80.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_80.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_80.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_80.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_80.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_81.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_81.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_81.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_81.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_81.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_81.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_81.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_82.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
		TERMINAL_82.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
		TERMINAL_82.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
		TERMINAL_82.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
		TERMINAL_82.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
		TERMINAL_82.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
		TERMINAL_82.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
		TERMINAL_33.addFollower(TERMINAL_34, EMPTY_FEATURE_ARRAY);
		TERMINAL_62.addFollower(TERMINAL_108, EMPTY_FEATURE_ARRAY);
		TERMINAL_108.addFollower(TERMINAL_109, EMPTY_FEATURE_ARRAY);
		TERMINAL_109.addFollower(TERMINAL_110, EMPTY_FEATURE_ARRAY);
		TERMINAL_109.addFollower(TERMINAL_111, EMPTY_FEATURE_ARRAY);
		TERMINAL_110.addFollower(TERMINAL_112, EMPTY_FEATURE_ARRAY);
		TERMINAL_112.addFollower(TERMINAL_110, EMPTY_FEATURE_ARRAY);
		TERMINAL_112.addFollower(TERMINAL_111, EMPTY_FEATURE_ARRAY);
		TERMINAL_111.addFollower(TERMINAL_62, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_9, });
		TERMINAL_111.addFollower(TERMINAL_63, EMPTY_FEATURE_ARRAY);
		TERMINAL_32.addFollower(TERMINAL_113, EMPTY_FEATURE_ARRAY);
		TERMINAL_113.addFollower(TERMINAL_114, EMPTY_FEATURE_ARRAY);
		TERMINAL_113.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, });
		TERMINAL_113.addFollower(TERMINAL_33, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_5, });
		TERMINAL_113.addFollower(TERMINAL_34, EMPTY_FEATURE_ARRAY);
		TERMINAL_113.addFollower(TERMINAL_65, EMPTY_FEATURE_ARRAY);
		TERMINAL_113.addFollower(TERMINAL_56, EMPTY_FEATURE_ARRAY);
		TERMINAL_114.addFollower(TERMINAL_115, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_16, });
		TERMINAL_116.addFollower(TERMINAL_115, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_16, });
		TERMINAL_117.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, });
		TERMINAL_117.addFollower(TERMINAL_33, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_5, });
		TERMINAL_117.addFollower(TERMINAL_34, EMPTY_FEATURE_ARRAY);
		TERMINAL_117.addFollower(TERMINAL_65, EMPTY_FEATURE_ARRAY);
		TERMINAL_117.addFollower(TERMINAL_56, EMPTY_FEATURE_ARRAY);
		TERMINAL_115.addFollower(TERMINAL_118, EMPTY_FEATURE_ARRAY);
		TERMINAL_115.addFollower(TERMINAL_116, EMPTY_FEATURE_ARRAY);
		TERMINAL_115.addFollower(TERMINAL_117, EMPTY_FEATURE_ARRAY);
		TERMINAL_118.addFollower(TERMINAL_119, EMPTY_FEATURE_ARRAY);
		TERMINAL_119.addFollower(TERMINAL_116, EMPTY_FEATURE_ARRAY);
		TERMINAL_119.addFollower(TERMINAL_117, EMPTY_FEATURE_ARRAY);
	}
	// wire the terminals
	static {
		wire0();
	}
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 0, FEATURE_0));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 0, FEATURE_1));
		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
	}
	(
		c0 = parse_org_emftext_sdk_generatorconfig_GeneratorConfig{ element = c0; }
	)
	EOF	
;

parse_org_emftext_sdk_generatorconfig_GeneratorConfig returns [org.emftext.sdk.generatorconfig.GeneratorConfig element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_sdk_generatorconfig_ClassRule				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorConfig();
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES, a0_0);
							completedElement(a0_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 1, FEATURE_0));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 1, FEATURE_1));
			}
			
			
			|			(
				a1_0 = parse_org_emftext_sdk_generatorconfig_FeatureRule				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorConfig();
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							addObjectToList(element, org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES, a1_0);
							completedElement(a1_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a1_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 2, FEATURE_0));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 2, FEATURE_1));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 3, FEATURE_0));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 3, FEATURE_1));
	}
	
;

parse_org_emftext_sdk_generatorconfig_GeneratorRule returns [org.emftext.sdk.generatorconfig.GeneratorRule element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_3, 4));
	}
	
	a1 = '::=' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 5, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 5, FEATURE_2, FEATURE_3));
	}
	
	(
		a2_0 = parse_org_emftext_sdk_concretesyntax_Sequence		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__DEFINITION), a2_0);
					completedElement(a2_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a2_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 6));
	}
	
	a3 = ';' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_org_emftext_sdk_generatorconfig_ClassRule{ element = c0; /* this is a subclass or expression choice */ }
	|	c1 = parse_org_emftext_sdk_generatorconfig_FeatureRule{ element = c1; /* this is a subclass or expression choice */ }
	
;

parse_org_emftext_sdk_generatorconfig_ClassRule returns [org.emftext.sdk.generatorconfig.ClassRule element = null]
@init{
}
:
	a0 = 'ClassRule' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_20, 8));
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
			}
			if (a1 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_21, 9));
	}
	
	a2 = '::=' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 10, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 10, FEATURE_2, FEATURE_3));
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_Sequence		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE__DEFINITION), a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 11));
	}
	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 12, FEATURE_0));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 12, FEATURE_1));
	}
	
;

parse_org_emftext_sdk_generatorconfig_FeatureRule returns [org.emftext.sdk.generatorconfig.FeatureRule element = null]
@init{
}
:
	a0 = 'FeatureRule' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_23, 13));
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
			}
			if (a1 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_24, 14));
	}
	
	a2 = '::=' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 15, FEATURE_2, FEATURE_3));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 15, FEATURE_2, FEATURE_3));
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_Sequence		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE__DEFINITION), a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 16));
	}
	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 17, FEATURE_0));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 17, FEATURE_1));
	}
	
;

parse_org_emftext_sdk_generatorconfig_FeatureReference returns [org.emftext.sdk.generatorconfig.FeatureReference element = null]
@init{
}
:
	a0 = 'FEATURE' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureReference();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_26, 18));
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureReference();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_27, 19));
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureReference();
			}
			if (a2 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_REFERENCE__FEATURE_NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_REFERENCE__FEATURE_NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_28, 20));
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureReference();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 21, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 21));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 21));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 21));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 21));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 21));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 21));
	}
	
;

parse_org_emftext_sdk_generatorconfig_ClassName returns [org.emftext.sdk.generatorconfig.ClassName element = null]
@init{
}
:
	a0 = 'CLASSNAME' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassName();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 22, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 22));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 22));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 22));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 22));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 22));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 22));
	}
	
;

parse_org_emftext_sdk_generatorconfig_Features returns [org.emftext.sdk.generatorconfig.Features element = null]
@init{
}
:
	a0 = 'FEATURES' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatures();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 23, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 23));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 23));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 23));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 23));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 23));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 23));
	}
	
;

parse_org_emftext_sdk_generatorconfig_ClassRuleReference returns [org.emftext.sdk.generatorconfig.ClassRuleReference element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRuleReference();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE_REFERENCE__RULE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.generatorconfig.GeneratorRule proxy = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.generatorconfig.ClassRuleReference, org.emftext.sdk.generatorconfig.GeneratorRule>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassRuleReferenceRuleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE_REFERENCE__RULE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE_REFERENCE__RULE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 24, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 24));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 24));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 24));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 24));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 24));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 24));
	}
	
;

parse_org_emftext_sdk_generatorconfig_FeatureRuleReference returns [org.emftext.sdk.generatorconfig.FeatureRuleReference element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRuleReference();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE_REFERENCE__RULE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.generatorconfig.GeneratorRule proxy = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.generatorconfig.FeatureRuleReference, org.emftext.sdk.generatorconfig.GeneratorRule>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureRuleReferenceRuleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE_REFERENCE__RULE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE_REFERENCE__RULE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 25, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 25));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 25));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 25));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 25));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 25));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 25));
	}
	
;

parse_org_emftext_sdk_generatorconfig_FeatureName returns [org.emftext.sdk.generatorconfig.FeatureName element = null]
@init{
}
:
	a0 = 'FEATURENAME' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureName();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 26, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 26));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 26));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 26));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 26));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 26));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 26));
	}
	
;

parse_org_emftext_sdk_generatorconfig_Feature returns [org.emftext.sdk.generatorconfig.Feature element = null]
@init{
}
:
	a0 = 'FEATURE' {
		if (element == null) {
			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeature();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 27, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 27));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 27));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 27));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 27));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 27));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 27));
	}
	
;

parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS, a0_0);
							completedElement(a0_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 28, FEATURE_4));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 28, FEATURE_5));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 28));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 29, FEATURE_4));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 29, FEATURE_5));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 29));
	}
	
	(
		(
			(
				a1_0 = parse_org_emftext_sdk_concretesyntax_Abstract				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER), a1_0);
							completedElement(a1_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a1_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 30));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 31));
	}
	
	a2 = 'SYNTAXDEF' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_35, 32));
	}
	
	(
		a3 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			if (a3 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_36, 33));
	}
	
	a4 = 'FOR' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_37, 34));
	}
	
	(
		a5 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			if (a5 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_38, 35));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_39, 35));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 35));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 35));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 35));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 35));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 35));
	}
	
	(
		(
			(
				a6 = QUOTED_60_62				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					if (a6 != null) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), resolved);
							completedElement(resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_39, 36));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 36));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 36));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 36));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 36));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 36));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_39, 37));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 37));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 37));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 37));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 37));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 37));
	}
	
	(
		(
			a7 = 'START' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_45, 38));
			}
			
			(
				(
					a8 = QUALIFIED_NAME					
					{
						if (terminateParsing) {
							throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						if (a8 != null) {
							org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
							tokenResolver.setOptions(getOptions());
							org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
							java.lang.Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
							}
							String resolved = (String) resolvedObject;
							org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
							collectHiddenTokens(element);
							registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
							if (proxy != null) {
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy);
								completedElement(proxy);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
							copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, proxy);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 39));
					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 39));
					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 39));
					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 39));
					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 39));
					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 39));
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 40));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 40));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 40));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 40));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 40));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 40));
			}
			
			(
				(
					a9 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_47, 41));
					}
					
					(
						(
							a10 = QUALIFIED_NAME							
							{
								if (terminateParsing) {
									throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								}
								if (a10 != null) {
									org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
									tokenResolver.setOptions(getOptions());
									org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
									tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
									java.lang.Object resolvedObject = result.getResolvedToken();
									if (resolvedObject == null) {
										addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStopIndex());
									}
									String resolved = (String) resolvedObject;
									org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
									collectHiddenTokens(element);
									registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
									if (proxy != null) {
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy);
										completedElement(proxy);
									}
									collectHiddenTokens(element);
									copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, element);
									copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, proxy);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 42));
							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 42));
							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 42));
							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 42));
							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 42));
							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 42));
						}
						
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 43));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 43));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 43));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 43));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 43));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 43));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 44));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 44));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 44));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 44));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 44));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 44));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 45));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 45));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 45));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 45));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 45));
	}
	
	(
		(
			a11 = 'IMPORTS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_48, 46));
			}
			
			a12 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 47, FEATURE_6));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 47));
			}
			
			(
				(
					(
						a13_0 = parse_org_emftext_sdk_concretesyntax_Import						{
							if (terminateParsing) {
								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							if (a13_0 != null) {
								if (a13_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS, a13_0);
									completedElement(a13_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a13_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 48, FEATURE_6));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 48));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 49, FEATURE_6));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 49));
			}
			
			a14 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 50));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 50));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 50));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 50));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 51));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 51));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 51));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 51));
	}
	
	(
		(
			a15 = 'OPTIONS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_51, 52));
			}
			
			a16 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_52, 53, FEATURE_7));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_53, 53));
			}
			
			(
				(
					(
						a17_0 = parse_org_emftext_sdk_concretesyntax_Option						{
							if (terminateParsing) {
								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							if (a17_0 != null) {
								if (a17_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS, a17_0);
									completedElement(a17_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a17_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_54, 54));
					}
					
					a18 = ';' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a18, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_52, 55, FEATURE_7));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_53, 55));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_52, 56, FEATURE_7));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_53, 56));
			}
			
			a19 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a19, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 57));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 57));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 57));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 58));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 58));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 58));
	}
	
	(
		(
			a20 = 'TOKENS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a20, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_55, 59));
			}
			
			a21 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a21, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 60, FEATURE_4, FEATURE_8));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 60, FEATURE_8));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_57, 60, FEATURE_8));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_58, 60, FEATURE_8));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_59, 60));
			}
			
			(
				(
					(
						a22_0 = parse_org_emftext_sdk_concretesyntax_TokenDirective						{
							if (terminateParsing) {
								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							if (a22_0 != null) {
								if (a22_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS, a22_0);
									completedElement(a22_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a22_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 61));
					}
					
					a23 = ';' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a23, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 62, FEATURE_4, FEATURE_8));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 62, FEATURE_8));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_57, 62, FEATURE_8));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_58, 62, FEATURE_8));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_59, 62));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 63, FEATURE_4, FEATURE_8));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 63, FEATURE_8));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_57, 63, FEATURE_8));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_58, 63, FEATURE_8));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_59, 63));
			}
			
			a24 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a24, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 64));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 64));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 65));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 65));
	}
	
	(
		(
			a25 = 'TOKENSTYLES' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a25, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_61, 66));
			}
			
			a26 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a26, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_62, 67, FEATURE_9));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_63, 67));
			}
			
			(
				(
					(
						a27_0 = parse_org_emftext_sdk_concretesyntax_TokenStyle						{
							if (terminateParsing) {
								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							if (a27_0 != null) {
								if (a27_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES, a27_0);
									completedElement(a27_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a27_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_62, 68, FEATURE_9));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_63, 68));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_62, 69, FEATURE_9));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_63, 69));
			}
			
			a28 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a28, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 70));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 71));
	}
	
	a29 = 'RULES' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a29, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_64, 72));
	}
	
	a30 = '{' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a30, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 73, FEATURE_4, FEATURE_10));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 73, FEATURE_10));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_66, 73));
	}
	
	(
		(
			(
				a31_0 = parse_org_emftext_sdk_concretesyntax_Rule				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					if (a31_0 != null) {
						if (a31_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, a31_0);
							completedElement(a31_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a31_0, element); 					}
				}
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 74, FEATURE_4, FEATURE_10));
			addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 74, FEATURE_10));
			addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_66, 74));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_66, 75));
	}
	
	a32 = '}' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a32, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_org_emftext_sdk_concretesyntax_Import returns [org.emftext.sdk.concretesyntax.Import element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_67, 77));
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_68, 78));
	}
	
	(
		a2 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			}
			if (a2 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_69, 79));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_70, 79));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 79, FEATURE_6));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 79));
	}
	
	(
		(
			(
				a3 = QUOTED_60_62				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					}
					if (a3 != null) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), resolved);
							completedElement(resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_70, 80));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 80, FEATURE_6));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 80));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_70, 81));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 81, FEATURE_6));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 81));
	}
	
	(
		(
			a4 = 'WITH' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_71, 82));
			}
			
			a5 = 'SYNTAX' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_72, 83));
			}
			
			(
				a6 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					}
					if (a6 != null) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getImportConcreteSyntaxReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
						if (proxy != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), proxy);
							completedElement(proxy);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_73, 84));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 84, FEATURE_6));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 84));
			}
			
			(
				(
					(
						a7 = QUOTED_60_62						
						{
							if (terminateParsing) {
								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
							}
							if (a7 != null) {
								org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
								tokenResolver.setOptions(getOptions());
								org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a7).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String)resolvedObject;
								if (resolved != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), resolved);
									completedElement(resolved);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a7, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 85, FEATURE_6));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 85));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 86, FEATURE_6));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 86));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 87, FEATURE_6));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 87));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Option returns [org.emftext.sdk.concretesyntax.Option element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.OptionTypes resolved = (org.emftext.sdk.concretesyntax.OptionTypes)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_74, 88));
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_75, 89));
	}
	
	(
		a2 = QUOTED_34_34_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			}
			if (a2 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_54, 90));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Rule returns [org.emftext.sdk.concretesyntax.Rule element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__ANNOTATIONS, a0_0);
							completedElement(a0_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 91, FEATURE_4));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 91));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 92, FEATURE_4));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 92));
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			}
			if (a1 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleMetaclassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_76, 93));
	}
	
	a2 = '::=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 94, FEATURE_2, FEATURE_11, FEATURE_12));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 94, FEATURE_2, FEATURE_11, FEATURE_12));
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 95));
	}
	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 96, FEATURE_4, FEATURE_10));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 96, FEATURE_10));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_66, 96));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null]
@init{
}
:
	(
		(
			a0_0 = parse_org_emftext_sdk_concretesyntax_Definition			{
				if (terminateParsing) {
					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSequence();
				}
				if (a0_0 != null) {
					if (a0_0 != null) {
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS, a0_0);
						completedElement(a0_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a0_0, element); 				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 97, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 97));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 97));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 97));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 97));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 97));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 97));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_sdk_concretesyntax_Sequence		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a0_0);
					completedElement(a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 98));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 98));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 98));
	}
	
	(
		(
			a1 = '|' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 99, FEATURE_2, FEATURE_11));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 99, FEATURE_2, FEATURE_11));
			}
			
			(
				a2_0 = parse_org_emftext_sdk_concretesyntax_Sequence				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a2_0);
							completedElement(a2_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a2_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 100));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 100));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 100));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 101));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 101));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 101));
	}
	
;

parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCsString();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 102, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 102));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 102));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 102));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 102));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 102));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 102));
	}
	
;

parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_77, 103));
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_78, 104));
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			}
			if (a2 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.NormalTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_79, 105));
	}
	
	a3 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 106, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 106, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 106, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 106, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 106));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 106));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 106));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 106));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 106));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 106));
	}
	
	(
		(
			a4_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
				}
				if (a4_0 != null) {
					if (a4_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), a4_0);
						completedElement(a4_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a4_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 107, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 107));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 107));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 107));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 107));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 107));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 107));
	}
	
;

parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_83, 108));
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_84, 109));
	}
	
	a2 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 110, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 110, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 110, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 110, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 110));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 110));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 110));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 110));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 110));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 110));
	}
	
	(
		(
			a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
				}
				if (a3_0 != null) {
					if (a3_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), a3_0);
						completedElement(a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 111, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 111));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 111));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 111));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 111));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 111));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 111));
	}
	
;

parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_85, 112));
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_86, 113));
	}
	
	(
		a2 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			if (a2 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_87, 114));
	}
	
	a3 = ',' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_88, 115));
	}
	
	(
		a4 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			if (a4 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_89, 116));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_90, 116));
	}
	
	(
		(
			a5 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_91, 117));
			}
			
			(
				a6 = QUOTED_39_39_92				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					}
					if (a6 != null) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), resolved);
							completedElement(resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_90, 118));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_90, 119));
	}
	
	a7 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 120, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 120, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 120, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 120, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 120));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 120));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 120));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 120));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 120));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 120));
	}
	
	(
		(
			a8_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
				}
				if (a8_0 != null) {
					if (a8_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), a8_0);
						completedElement(a8_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a8_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 121, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 121));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 121));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 121));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 121));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 121));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 121));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_92, 122));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 122, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 122, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 122, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 122, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 122));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 122));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 122));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 122));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 122));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 122));
	}
	
	(
		(
			a1 = ':' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_93, 123));
			}
			
			(
				a2 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					}
					if (a2 != null) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
						if (proxy != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
							completedElement(proxy);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_94, 124));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 124, FEATURE_13));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 124, FEATURE_13));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 124, FEATURE_13));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 124, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 124));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 124));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 124));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 124));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 124));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 124));
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_95, 125));
					}
					
					(
						a4 = QUALIFIED_NAME						
						{
							if (terminateParsing) {
								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
							}
							if (a4 != null) {
								org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
								tokenResolver.setOptions(getOptions());
								org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
								collectHiddenTokens(element);
								registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
								if (proxy != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
									completedElement(proxy);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_94, 126));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 126, FEATURE_13));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 126, FEATURE_13));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 126, FEATURE_13));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 126, FEATURE_2));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 126));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 126));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 126));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 126));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 126));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 126));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_94, 127));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 127, FEATURE_13));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 127, FEATURE_13));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 127, FEATURE_13));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 127, FEATURE_2));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 127));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 127));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 127));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 127));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 127));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 127));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 128, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 128, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 128, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 128, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 128));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 128));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 128));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 128));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 128));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 128));
	}
	
	(
		(
			a5_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
				}
				if (a5_0 != null) {
					if (a5_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), a5_0);
						completedElement(a5_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a5_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 129, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 129));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 129));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 129));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 129));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 129));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 129));
	}
	
;

parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 130, FEATURE_2, FEATURE_11, FEATURE_14));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 130, FEATURE_2, FEATURE_11, FEATURE_14));
	}
	
	(
		a1_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), a1_0);
					completedElement(a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 131));
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 132, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 132, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 132, FEATURE_13));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 132, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 132));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 132));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 132));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 132));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 132));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 132));
	}
	
	(
		(
			a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
				}
				if (a3_0 != null) {
					if (a3_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), a3_0);
						completedElement(a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 133, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 133));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 133));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 133));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 133));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 133));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 133));
	}
	
;

parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null]
@init{
}
:
	(
		a0 = HEXNUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 134, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 134));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 134));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 134));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 134));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 134));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 134));
	}
	
;

parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null]
@init{
}
:
	a0 = '!' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_96, 135));
	}
	
	(
		a1 = NUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
			}
			if (a1 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 136, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 136));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 136));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 136));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 136));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 136));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 136));
	}
	
;

parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition returns [org.emftext.sdk.concretesyntax.NormalTokenDefinition element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ANNOTATIONS, a0_0);
							completedElement(a0_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 137, FEATURE_4));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 137));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 138, FEATURE_4));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 138));
	}
	
	a1 = 'DEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_97, 139));
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
			}
			if (a2 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_98, 140, FEATURE_15));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_99, 140, FEATURE_15));
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS, a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 141));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 141));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 141));
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_98, 142, FEATURE_15));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_99, 142, FEATURE_15));
			}
			
			(
				a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS, a5_0);
							completedElement(a5_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a5_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 143));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 143));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 143));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 144));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 144));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 144));
	}
	
	(
		(
			a6 = 'COLLECT' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_102, 145));
			}
			
			a7 = 'IN' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_103, 146));
			}
			
			(
				a8 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					}
					if (a8 != null) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), resolved);
							completedElement(resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 147));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 148));
	}
	
;

parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition returns [org.emftext.sdk.concretesyntax.PartialTokenDefinition element = null]
@init{
}
:
	a0 = 'DEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_104, 149));
	}
	
	a1 = 'FRAGMENT' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_105, 150));
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
			}
			if (a2 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_98, 151, FEATURE_15));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_99, 151, FEATURE_15));
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__REGEX_PARTS, a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 152));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 152));
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_98, 153, FEATURE_15));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_99, 153, FEATURE_15));
			}
			
			(
				a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__REGEX_PARTS, a5_0);
							completedElement(a5_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a5_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 154));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 154));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 155));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 155));
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null]
@init{
}
:
	a0 = 'PRIORITIZE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_107, 156));
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
			}
			if (a1 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.NormalTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 157));
	}
	
;

parse_org_emftext_sdk_concretesyntax_AtomicRegex returns [org.emftext.sdk.concretesyntax.AtomicRegex element = null]
@init{
}
:
	(
		a0 = QUOTED_36_36		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAtomicRegex();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 158));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 158));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 158));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 158));
	}
	
;

parse_org_emftext_sdk_concretesyntax_RegexReference returns [org.emftext.sdk.concretesyntax.RegexReference element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexReference();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.PartialTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.RegexReference, org.emftext.sdk.concretesyntax.AbstractTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRegexReferenceTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), proxy);
					completedElement(proxy);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 159));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 159));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 159));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 159));
	}
	
;

parse_org_emftext_sdk_concretesyntax_PLUS returns [org.emftext.sdk.concretesyntax.PLUS element = null]
@init{
}
:
	a0 = '+' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPLUS();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 160, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 160));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 160));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 160));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 160));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 160));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 160));
	}
	
;

parse_org_emftext_sdk_concretesyntax_STAR returns [org.emftext.sdk.concretesyntax.STAR element = null]
@init{
}
:
	a0 = '*' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSTAR();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 161, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 161));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 161));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 161));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 161));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 161));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 161));
	}
	
;

parse_org_emftext_sdk_concretesyntax_QUESTIONMARK returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null]
@init{
}
:
	a0 = '?' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 162, FEATURE_2));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 162));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 162));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 162));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 162));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 162));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 162));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Abstract returns [org.emftext.sdk.concretesyntax.Abstract element = null]
@init{
}
:
	a0 = 'ABSTRACT' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAbstract();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 163));
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_108, 164));
	}
	
	a1 = 'COLOR' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_109, 165));
	}
	
	(
		a2 = HEXNUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			}
			if (a2 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_110, 166));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_111, 166));
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_112, 167));
			}
			
			(
				a4 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					}
					if (a4 != null) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
						}
						org.emftext.sdk.concretesyntax.FontStyle resolved = (org.emftext.sdk.concretesyntax.FontStyle)resolvedObject;
						if (resolved != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES, resolved);
							completedElement(resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_110, 168));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_111, 168));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_110, 169));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_111, 169));
	}
	
	a5 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_62, 170, FEATURE_9));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_63, 170));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null]
@init{
}
:
	a0 = '@' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_113, 171));
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
			}
			if (a1 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.AnnotationType resolved = (org.emftext.sdk.concretesyntax.AnnotationType)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_114, 172));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 172, FEATURE_4));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 172, FEATURE_5));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 172));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 172));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 172));
	}
	
	(
		(
			a2 = '(' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_115, 173, FEATURE_16));
			}
			
			(
				a3_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, a3_0);
							completedElement(a3_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a3_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 174));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 174));
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_115, 175, FEATURE_16));
					}
					
					(
						a5_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair						{
							if (terminateParsing) {
								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, a5_0);
									completedElement(a5_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a5_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 176));
						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 176));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 177));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 177));
			}
			
			a6 = ')' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 178, FEATURE_4));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 178, FEATURE_5));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 178));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 178));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 178));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 179, FEATURE_4));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 179, FEATURE_5));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 179));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 179));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 179));
	}
	
;

parse_org_emftext_sdk_concretesyntax_KeyValuePair returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null]
@init{
}
:
	(
		a0 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
			}
			if (a0 != null) {
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_118, 180));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 180));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 180));
	}
	
	(
		(
			a1 = '=' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_119, 181));
			}
			
			(
				a2 = QUOTED_34_34_92				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
					}
					if (a2 != null) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), resolved);
							completedElement(resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 182));
				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 182));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 183));
		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 183));
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition{ element = c0; /* this is a subclass or expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition{ element = c1; /* this is a subclass or expression choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective{ element = c2; /* this is a subclass or expression choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null]
:
	c0 = parse_org_emftext_sdk_generatorconfig_FeatureReference{ element = c0; /* this is a subclass or expression choice */ }
	|	c1 = parse_org_emftext_sdk_generatorconfig_ClassName{ element = c1; /* this is a subclass or expression choice */ }
	|	c2 = parse_org_emftext_sdk_generatorconfig_Features{ element = c2; /* this is a subclass or expression choice */ }
	|	c3 = parse_org_emftext_sdk_generatorconfig_ClassRuleReference{ element = c3; /* this is a subclass or expression choice */ }
	|	c4 = parse_org_emftext_sdk_generatorconfig_FeatureRuleReference{ element = c4; /* this is a subclass or expression choice */ }
	|	c5 = parse_org_emftext_sdk_generatorconfig_FeatureName{ element = c5; /* this is a subclass or expression choice */ }
	|	c6 = parse_org_emftext_sdk_generatorconfig_Feature{ element = c6; /* this is a subclass or expression choice */ }
	|	c7 = parse_org_emftext_sdk_concretesyntax_CsString{ element = c7; /* this is a subclass or expression choice */ }
	|	c8 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken{ element = c8; /* this is a subclass or expression choice */ }
	|	c9 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken{ element = c9; /* this is a subclass or expression choice */ }
	|	c10 = parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes{ element = c10; /* this is a subclass or expression choice */ }
	|	c11 = parse_org_emftext_sdk_concretesyntax_Containment{ element = c11; /* this is a subclass or expression choice */ }
	|	c12 = parse_org_emftext_sdk_concretesyntax_CompoundDefinition{ element = c12; /* this is a subclass or expression choice */ }
	|	c13 = parse_org_emftext_sdk_concretesyntax_WhiteSpaces{ element = c13; /* this is a subclass or expression choice */ }
	|	c14 = parse_org_emftext_sdk_concretesyntax_LineBreak{ element = c14; /* this is a subclass or expression choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_PLUS{ element = c0; /* this is a subclass or expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_STAR{ element = c1; /* this is a subclass or expression choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_QUESTIONMARK{ element = c2; /* this is a subclass or expression choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_RegexPart returns [org.emftext.sdk.concretesyntax.RegexPart element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_AtomicRegex{ element = c0; /* this is a subclass or expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_RegexReference{ element = c1; /* this is a subclass or expression choice */ }
	
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
	('<')(~('>'))*('>')
;
QUOTED_34_34_92:
	('"')(('\\''"')|('\\''\\')|~('"'|'\\'))*('"')
;
QUOTED_39_39_92:
	('\'')(('\\''\'')|('\\''\\')|~('\''|'\\'))*('\'')
;
QUOTED_36_36:
	('$')(~('$'))*('$')
;

