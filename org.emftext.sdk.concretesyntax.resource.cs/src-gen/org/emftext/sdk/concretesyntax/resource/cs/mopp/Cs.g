grammar Cs;

options {
	superClass = CsANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.sdk.concretesyntax.resource.cs.mopp;
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
	package org.emftext.sdk.concretesyntax.resource.cs.mopp;
}

@members{
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolverFactory tokenResolverFactory = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolverFactory();
	@SuppressWarnings("unused")
	
	private int lastPosition;
	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult tokenResolveResult = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult();
	private boolean rememberExpectedElements = false;
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal>();
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	//helper lists to allow a lexer to pass errors to its parser
	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> postParseCommands;
	private boolean terminateParsing;
	private int tokenIndexOfLastCompleteElement;
	private int expectedElementsIndexOfLastCompleteElement;
	
	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for
					// code completion
					return true;
				}
				resource.addProblem(new org.emftext.sdk.concretesyntax.resource.cs.ICsProblem() {
					public org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType getType() {
						return org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.ERROR;
					}
					public java.lang.String getMessage() {
						return errorMessage;
					}
				}, line, charPositionInLine, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedElement) {
		if (!this.rememberExpectedElements) {
			return;
		}
		setPosition(expectedElement, input.index());
		this.expectedElements.add(expectedElement);
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDummyEObject dummy) {
		java.lang.Object value = element.eGet(structuralFeature);
		java.lang.Object mapKey = dummy.getValueByName("key");
		java.lang.Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.sdk.concretesyntax.resource.cs.util.CsMapUtil.castToEMap(value);
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
			assert(object instanceof org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDummyEObject);
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDummyEObject dummy = (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDummyEObject) object;
			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = resource.getLocationMap();
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
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
		try {
			if (encoding == null) {
				return new CsParser(new org.antlr.runtime3_2_0.CommonTokenStream(new CsLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new CsParser(new org.antlr.runtime3_2_0.CommonTokenStream(new CsLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	// This default constructor is only used to call createInstance() on it
	public CsParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
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
		throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsUnexpectedContentTypeException(typeObject);
	}
	
	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult getFreshTokenResolveResult() {
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
	
	public org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation getMetaInformation() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation();
	}
	
	public java.lang.Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected org.emftext.sdk.concretesyntax.resource.cs.mopp.CsReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected java.lang.Object getTypeObject() {
		java.lang.Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.sdk.concretesyntax.resource.cs.ICsOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	// Implementation that calls {@link #doParse()}  and handles the thrown
	// RecognitionExceptions.
	public org.emftext.sdk.concretesyntax.resource.cs.ICsParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>>();
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParseResult parseResult = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParseResult();
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
	
	public java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource dummyResource) {
		rememberExpectedElements = true;
		parseToIndexTypeObject = type;
		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
		org.emftext.sdk.concretesyntax.resource.cs.ICsParseResult result = parse();
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContents().add(root);
			}
			for (org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal>();
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				System.out.println("FOLLOW ELEMENT " + expectedElementI);
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 156;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
			System.out.println("REMAINING TOKEN: " + nextToken);
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected terminals
				// can be set
				for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are kept
				for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal nextFollow : currentFollowSet) {
					System.out.println("CHECKING : " + nextFollow);
					if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						System.out.println("MATCH! " + nextFollow);
						java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement newFollower : newFollowers) {
							org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal newFollowTerminal = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(newFollower, followSetID);
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
		for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedElement, int tokenIndex) {
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
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
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
				tokenName = org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil.formatTokenName(tokenName);
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
	
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_0 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("@");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_1 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("ABSTRACT");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_2 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("SYNTAXDEF");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_3 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_4 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("FOR");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_5 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), "QUOTED_60_62");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_6 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), "QUOTED_60_62");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_7 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("START");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_8 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("IMPORTS");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_9 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("OPTIONS");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_10 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("TOKENS");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_11 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("TOKENSTYLES");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_12 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("RULES");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_13 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_14 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_15 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_16 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_17 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_18 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_19 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_20 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_21 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_22 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(";");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_23 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_24 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("DEFINE");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_25 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("DEFINE");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_26 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("PRIORITIZE");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_27 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_28 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(";");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_29 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_30 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), "QUOTED_34_34_92");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_31 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_32 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_33 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_34 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_35 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(":");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_36 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), "QUOTED_60_62");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_37 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), "QUOTED_60_62");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_38 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("WITH");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_39 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("SYNTAX");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_40 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_41 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), "QUOTED_60_62");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_42 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("=");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_43 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), "QUOTED_34_34_92");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_44 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("::=");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_45 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), "QUOTED_34_34_92");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_46 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_47 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_48 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_49 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_50 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("(");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_51 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), "HEXNUMBER");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_52 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("!");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_53 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(";");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_54 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("|");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_55 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(")");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_56 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("[");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_57 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_58 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("]");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_59 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("+");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_60 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("*");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_61 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("?");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_62 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("[");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_63 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("]");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_64 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("[");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_65 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), "QUOTED_39_39_92");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_66 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_67 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), "QUOTED_39_39_92");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_68 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_69 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("]");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_70 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), "QUOTED_39_39_92");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_71 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(":");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_72 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_73 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_74 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_75 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), "NUMBER");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_76 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_77 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), "QUOTED_36_36");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_78 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_79 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("+");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_80 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("COLLECT");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_81 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("IN");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_82 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_83 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("PARTIAL");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_84 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_85 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("+");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_86 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_87 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("COLOR");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_88 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), "HEXNUMBER");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_89 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_90 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(";");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_91 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_92 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_93 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("(");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_94 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), "QUALIFIED_NAME");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_95 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_96 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(")");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_97 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("=");
	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_98 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), "QUOTED_34_34_92");
	
	public static void wire0() {
		TERMINAL_2.addFollower(TERMINAL_3);
		TERMINAL_3.addFollower(TERMINAL_4);
		TERMINAL_4.addFollower(TERMINAL_5);
		TERMINAL_5.addFollower(TERMINAL_6);
		TERMINAL_5.addFollower(TERMINAL_7);
		TERMINAL_5.addFollower(TERMINAL_8);
		TERMINAL_5.addFollower(TERMINAL_9);
		TERMINAL_5.addFollower(TERMINAL_10);
		TERMINAL_5.addFollower(TERMINAL_11);
		TERMINAL_5.addFollower(TERMINAL_12);
		TERMINAL_6.addFollower(TERMINAL_7);
		TERMINAL_6.addFollower(TERMINAL_8);
		TERMINAL_6.addFollower(TERMINAL_9);
		TERMINAL_6.addFollower(TERMINAL_10);
		TERMINAL_6.addFollower(TERMINAL_11);
		TERMINAL_6.addFollower(TERMINAL_12);
		TERMINAL_7.addFollower(TERMINAL_13);
		TERMINAL_13.addFollower(TERMINAL_14);
		TERMINAL_13.addFollower(TERMINAL_8);
		TERMINAL_13.addFollower(TERMINAL_9);
		TERMINAL_13.addFollower(TERMINAL_10);
		TERMINAL_13.addFollower(TERMINAL_11);
		TERMINAL_13.addFollower(TERMINAL_12);
		TERMINAL_14.addFollower(TERMINAL_15);
		TERMINAL_15.addFollower(TERMINAL_14);
		TERMINAL_15.addFollower(TERMINAL_8);
		TERMINAL_15.addFollower(TERMINAL_9);
		TERMINAL_15.addFollower(TERMINAL_10);
		TERMINAL_15.addFollower(TERMINAL_11);
		TERMINAL_15.addFollower(TERMINAL_12);
		TERMINAL_8.addFollower(TERMINAL_16);
		TERMINAL_16.addFollower(TERMINAL_17);
		TERMINAL_16.addFollower(TERMINAL_18);
		TERMINAL_18.addFollower(TERMINAL_9);
		TERMINAL_18.addFollower(TERMINAL_10);
		TERMINAL_18.addFollower(TERMINAL_11);
		TERMINAL_18.addFollower(TERMINAL_12);
		TERMINAL_9.addFollower(TERMINAL_19);
		TERMINAL_19.addFollower(TERMINAL_20);
		TERMINAL_19.addFollower(TERMINAL_21);
		TERMINAL_22.addFollower(TERMINAL_20);
		TERMINAL_22.addFollower(TERMINAL_21);
		TERMINAL_21.addFollower(TERMINAL_10);
		TERMINAL_21.addFollower(TERMINAL_11);
		TERMINAL_21.addFollower(TERMINAL_12);
		TERMINAL_10.addFollower(TERMINAL_23);
		TERMINAL_23.addFollower(TERMINAL_0);
		TERMINAL_23.addFollower(TERMINAL_24);
		TERMINAL_23.addFollower(TERMINAL_25);
		TERMINAL_23.addFollower(TERMINAL_26);
		TERMINAL_23.addFollower(TERMINAL_27);
		TERMINAL_28.addFollower(TERMINAL_0);
		TERMINAL_28.addFollower(TERMINAL_24);
		TERMINAL_28.addFollower(TERMINAL_25);
		TERMINAL_28.addFollower(TERMINAL_26);
		TERMINAL_28.addFollower(TERMINAL_27);
		TERMINAL_27.addFollower(TERMINAL_11);
		TERMINAL_27.addFollower(TERMINAL_12);
		TERMINAL_11.addFollower(TERMINAL_29);
		TERMINAL_29.addFollower(TERMINAL_30);
		TERMINAL_29.addFollower(TERMINAL_31);
		TERMINAL_31.addFollower(TERMINAL_12);
		TERMINAL_12.addFollower(TERMINAL_32);
		TERMINAL_32.addFollower(TERMINAL_0);
		TERMINAL_32.addFollower(TERMINAL_33);
		TERMINAL_32.addFollower(TERMINAL_34);
		TERMINAL_17.addFollower(TERMINAL_35);
		TERMINAL_35.addFollower(TERMINAL_36);
		TERMINAL_36.addFollower(TERMINAL_37);
		TERMINAL_36.addFollower(TERMINAL_38);
		TERMINAL_36.addFollower(TERMINAL_17);
		TERMINAL_36.addFollower(TERMINAL_18);
		TERMINAL_37.addFollower(TERMINAL_38);
		TERMINAL_37.addFollower(TERMINAL_17);
		TERMINAL_37.addFollower(TERMINAL_18);
		TERMINAL_38.addFollower(TERMINAL_39);
		TERMINAL_39.addFollower(TERMINAL_40);
		TERMINAL_40.addFollower(TERMINAL_41);
		TERMINAL_40.addFollower(TERMINAL_17);
		TERMINAL_40.addFollower(TERMINAL_18);
		TERMINAL_41.addFollower(TERMINAL_17);
		TERMINAL_41.addFollower(TERMINAL_18);
		TERMINAL_20.addFollower(TERMINAL_42);
		TERMINAL_42.addFollower(TERMINAL_43);
		TERMINAL_43.addFollower(TERMINAL_22);
		TERMINAL_33.addFollower(TERMINAL_44);
		TERMINAL_44.addFollower(TERMINAL_45);
		TERMINAL_44.addFollower(TERMINAL_46);
		TERMINAL_44.addFollower(TERMINAL_47);
		TERMINAL_44.addFollower(TERMINAL_48);
		TERMINAL_44.addFollower(TERMINAL_49);
		TERMINAL_44.addFollower(TERMINAL_50);
		TERMINAL_44.addFollower(TERMINAL_51);
		TERMINAL_44.addFollower(TERMINAL_52);
		TERMINAL_53.addFollower(TERMINAL_0);
		TERMINAL_53.addFollower(TERMINAL_33);
		TERMINAL_53.addFollower(TERMINAL_34);
		TERMINAL_54.addFollower(TERMINAL_45);
		TERMINAL_54.addFollower(TERMINAL_46);
		TERMINAL_54.addFollower(TERMINAL_47);
		TERMINAL_54.addFollower(TERMINAL_48);
		TERMINAL_54.addFollower(TERMINAL_49);
		TERMINAL_54.addFollower(TERMINAL_50);
		TERMINAL_54.addFollower(TERMINAL_51);
		TERMINAL_54.addFollower(TERMINAL_52);
		TERMINAL_45.addFollower(TERMINAL_45);
		TERMINAL_45.addFollower(TERMINAL_46);
		TERMINAL_45.addFollower(TERMINAL_47);
		TERMINAL_45.addFollower(TERMINAL_48);
		TERMINAL_45.addFollower(TERMINAL_49);
		TERMINAL_45.addFollower(TERMINAL_50);
		TERMINAL_45.addFollower(TERMINAL_51);
		TERMINAL_45.addFollower(TERMINAL_52);
		TERMINAL_45.addFollower(TERMINAL_54);
		TERMINAL_45.addFollower(TERMINAL_53);
		TERMINAL_45.addFollower(TERMINAL_55);
		TERMINAL_46.addFollower(TERMINAL_56);
		TERMINAL_56.addFollower(TERMINAL_57);
		TERMINAL_57.addFollower(TERMINAL_58);
		TERMINAL_58.addFollower(TERMINAL_59);
		TERMINAL_58.addFollower(TERMINAL_60);
		TERMINAL_58.addFollower(TERMINAL_61);
		TERMINAL_58.addFollower(TERMINAL_45);
		TERMINAL_58.addFollower(TERMINAL_46);
		TERMINAL_58.addFollower(TERMINAL_47);
		TERMINAL_58.addFollower(TERMINAL_48);
		TERMINAL_58.addFollower(TERMINAL_49);
		TERMINAL_58.addFollower(TERMINAL_50);
		TERMINAL_58.addFollower(TERMINAL_51);
		TERMINAL_58.addFollower(TERMINAL_52);
		TERMINAL_58.addFollower(TERMINAL_54);
		TERMINAL_58.addFollower(TERMINAL_53);
		TERMINAL_58.addFollower(TERMINAL_55);
		TERMINAL_47.addFollower(TERMINAL_62);
		TERMINAL_62.addFollower(TERMINAL_63);
		TERMINAL_63.addFollower(TERMINAL_59);
		TERMINAL_63.addFollower(TERMINAL_60);
		TERMINAL_63.addFollower(TERMINAL_61);
		TERMINAL_63.addFollower(TERMINAL_45);
		TERMINAL_63.addFollower(TERMINAL_46);
		TERMINAL_63.addFollower(TERMINAL_47);
		TERMINAL_63.addFollower(TERMINAL_48);
		TERMINAL_63.addFollower(TERMINAL_49);
		TERMINAL_63.addFollower(TERMINAL_50);
		TERMINAL_63.addFollower(TERMINAL_51);
		TERMINAL_63.addFollower(TERMINAL_52);
		TERMINAL_63.addFollower(TERMINAL_54);
		TERMINAL_63.addFollower(TERMINAL_53);
		TERMINAL_63.addFollower(TERMINAL_55);
		TERMINAL_48.addFollower(TERMINAL_64);
		TERMINAL_64.addFollower(TERMINAL_65);
		TERMINAL_65.addFollower(TERMINAL_66);
		TERMINAL_66.addFollower(TERMINAL_67);
		TERMINAL_67.addFollower(TERMINAL_68);
		TERMINAL_67.addFollower(TERMINAL_69);
		TERMINAL_68.addFollower(TERMINAL_70);
		TERMINAL_70.addFollower(TERMINAL_69);
		TERMINAL_69.addFollower(TERMINAL_59);
		TERMINAL_69.addFollower(TERMINAL_60);
		TERMINAL_69.addFollower(TERMINAL_61);
		TERMINAL_69.addFollower(TERMINAL_45);
		TERMINAL_69.addFollower(TERMINAL_46);
		TERMINAL_69.addFollower(TERMINAL_47);
		TERMINAL_69.addFollower(TERMINAL_48);
		TERMINAL_69.addFollower(TERMINAL_49);
		TERMINAL_69.addFollower(TERMINAL_50);
		TERMINAL_69.addFollower(TERMINAL_51);
		TERMINAL_69.addFollower(TERMINAL_52);
		TERMINAL_69.addFollower(TERMINAL_54);
		TERMINAL_69.addFollower(TERMINAL_53);
		TERMINAL_69.addFollower(TERMINAL_55);
		TERMINAL_49.addFollower(TERMINAL_71);
		TERMINAL_49.addFollower(TERMINAL_59);
		TERMINAL_49.addFollower(TERMINAL_60);
		TERMINAL_49.addFollower(TERMINAL_61);
		TERMINAL_49.addFollower(TERMINAL_45);
		TERMINAL_49.addFollower(TERMINAL_46);
		TERMINAL_49.addFollower(TERMINAL_47);
		TERMINAL_49.addFollower(TERMINAL_48);
		TERMINAL_49.addFollower(TERMINAL_49);
		TERMINAL_49.addFollower(TERMINAL_50);
		TERMINAL_49.addFollower(TERMINAL_51);
		TERMINAL_49.addFollower(TERMINAL_52);
		TERMINAL_49.addFollower(TERMINAL_54);
		TERMINAL_49.addFollower(TERMINAL_53);
		TERMINAL_49.addFollower(TERMINAL_55);
		TERMINAL_71.addFollower(TERMINAL_72);
		TERMINAL_72.addFollower(TERMINAL_73);
		TERMINAL_72.addFollower(TERMINAL_59);
		TERMINAL_72.addFollower(TERMINAL_60);
		TERMINAL_72.addFollower(TERMINAL_61);
		TERMINAL_72.addFollower(TERMINAL_45);
		TERMINAL_72.addFollower(TERMINAL_46);
		TERMINAL_72.addFollower(TERMINAL_47);
		TERMINAL_72.addFollower(TERMINAL_48);
		TERMINAL_72.addFollower(TERMINAL_49);
		TERMINAL_72.addFollower(TERMINAL_50);
		TERMINAL_72.addFollower(TERMINAL_51);
		TERMINAL_72.addFollower(TERMINAL_52);
		TERMINAL_72.addFollower(TERMINAL_54);
		TERMINAL_72.addFollower(TERMINAL_53);
		TERMINAL_72.addFollower(TERMINAL_55);
		TERMINAL_73.addFollower(TERMINAL_74);
		TERMINAL_74.addFollower(TERMINAL_73);
		TERMINAL_74.addFollower(TERMINAL_59);
		TERMINAL_74.addFollower(TERMINAL_60);
		TERMINAL_74.addFollower(TERMINAL_61);
		TERMINAL_74.addFollower(TERMINAL_45);
		TERMINAL_74.addFollower(TERMINAL_46);
		TERMINAL_74.addFollower(TERMINAL_47);
		TERMINAL_74.addFollower(TERMINAL_48);
		TERMINAL_74.addFollower(TERMINAL_49);
		TERMINAL_74.addFollower(TERMINAL_50);
		TERMINAL_74.addFollower(TERMINAL_51);
		TERMINAL_74.addFollower(TERMINAL_52);
		TERMINAL_74.addFollower(TERMINAL_54);
		TERMINAL_74.addFollower(TERMINAL_53);
		TERMINAL_74.addFollower(TERMINAL_55);
		TERMINAL_50.addFollower(TERMINAL_45);
		TERMINAL_50.addFollower(TERMINAL_46);
		TERMINAL_50.addFollower(TERMINAL_47);
		TERMINAL_50.addFollower(TERMINAL_48);
		TERMINAL_50.addFollower(TERMINAL_49);
		TERMINAL_50.addFollower(TERMINAL_50);
		TERMINAL_50.addFollower(TERMINAL_51);
		TERMINAL_50.addFollower(TERMINAL_52);
		TERMINAL_55.addFollower(TERMINAL_59);
		TERMINAL_55.addFollower(TERMINAL_60);
		TERMINAL_55.addFollower(TERMINAL_61);
		TERMINAL_55.addFollower(TERMINAL_45);
		TERMINAL_55.addFollower(TERMINAL_46);
		TERMINAL_55.addFollower(TERMINAL_47);
		TERMINAL_55.addFollower(TERMINAL_48);
		TERMINAL_55.addFollower(TERMINAL_49);
		TERMINAL_55.addFollower(TERMINAL_50);
		TERMINAL_55.addFollower(TERMINAL_51);
		TERMINAL_55.addFollower(TERMINAL_52);
		TERMINAL_55.addFollower(TERMINAL_54);
		TERMINAL_55.addFollower(TERMINAL_53);
		TERMINAL_55.addFollower(TERMINAL_55);
		TERMINAL_51.addFollower(TERMINAL_45);
		TERMINAL_51.addFollower(TERMINAL_46);
		TERMINAL_51.addFollower(TERMINAL_47);
		TERMINAL_51.addFollower(TERMINAL_48);
		TERMINAL_51.addFollower(TERMINAL_49);
		TERMINAL_51.addFollower(TERMINAL_50);
		TERMINAL_51.addFollower(TERMINAL_51);
		TERMINAL_51.addFollower(TERMINAL_52);
		TERMINAL_51.addFollower(TERMINAL_54);
		TERMINAL_51.addFollower(TERMINAL_53);
		TERMINAL_51.addFollower(TERMINAL_55);
		TERMINAL_52.addFollower(TERMINAL_75);
		TERMINAL_75.addFollower(TERMINAL_45);
		TERMINAL_75.addFollower(TERMINAL_46);
		TERMINAL_75.addFollower(TERMINAL_47);
		TERMINAL_75.addFollower(TERMINAL_48);
		TERMINAL_75.addFollower(TERMINAL_49);
		TERMINAL_75.addFollower(TERMINAL_50);
		TERMINAL_75.addFollower(TERMINAL_51);
		TERMINAL_75.addFollower(TERMINAL_52);
		TERMINAL_75.addFollower(TERMINAL_54);
		TERMINAL_75.addFollower(TERMINAL_53);
		TERMINAL_75.addFollower(TERMINAL_55);
		TERMINAL_24.addFollower(TERMINAL_76);
		TERMINAL_76.addFollower(TERMINAL_77);
		TERMINAL_76.addFollower(TERMINAL_78);
		TERMINAL_79.addFollower(TERMINAL_77);
		TERMINAL_79.addFollower(TERMINAL_78);
		TERMINAL_80.addFollower(TERMINAL_81);
		TERMINAL_81.addFollower(TERMINAL_82);
		TERMINAL_82.addFollower(TERMINAL_28);
		TERMINAL_25.addFollower(TERMINAL_83);
		TERMINAL_83.addFollower(TERMINAL_84);
		TERMINAL_84.addFollower(TERMINAL_77);
		TERMINAL_84.addFollower(TERMINAL_78);
		TERMINAL_85.addFollower(TERMINAL_77);
		TERMINAL_85.addFollower(TERMINAL_78);
		TERMINAL_26.addFollower(TERMINAL_86);
		TERMINAL_86.addFollower(TERMINAL_28);
		TERMINAL_77.addFollower(TERMINAL_79);
		TERMINAL_77.addFollower(TERMINAL_80);
		TERMINAL_77.addFollower(TERMINAL_28);
		TERMINAL_77.addFollower(TERMINAL_85);
		TERMINAL_78.addFollower(TERMINAL_79);
		TERMINAL_78.addFollower(TERMINAL_80);
		TERMINAL_78.addFollower(TERMINAL_28);
		TERMINAL_78.addFollower(TERMINAL_85);
		TERMINAL_59.addFollower(TERMINAL_45);
		TERMINAL_59.addFollower(TERMINAL_46);
		TERMINAL_59.addFollower(TERMINAL_47);
		TERMINAL_59.addFollower(TERMINAL_48);
		TERMINAL_59.addFollower(TERMINAL_49);
		TERMINAL_59.addFollower(TERMINAL_50);
		TERMINAL_59.addFollower(TERMINAL_51);
		TERMINAL_59.addFollower(TERMINAL_52);
		TERMINAL_59.addFollower(TERMINAL_54);
		TERMINAL_59.addFollower(TERMINAL_53);
		TERMINAL_59.addFollower(TERMINAL_55);
		TERMINAL_60.addFollower(TERMINAL_45);
		TERMINAL_60.addFollower(TERMINAL_46);
		TERMINAL_60.addFollower(TERMINAL_47);
		TERMINAL_60.addFollower(TERMINAL_48);
		TERMINAL_60.addFollower(TERMINAL_49);
		TERMINAL_60.addFollower(TERMINAL_50);
		TERMINAL_60.addFollower(TERMINAL_51);
		TERMINAL_60.addFollower(TERMINAL_52);
		TERMINAL_60.addFollower(TERMINAL_54);
		TERMINAL_60.addFollower(TERMINAL_53);
		TERMINAL_60.addFollower(TERMINAL_55);
		TERMINAL_61.addFollower(TERMINAL_45);
		TERMINAL_61.addFollower(TERMINAL_46);
		TERMINAL_61.addFollower(TERMINAL_47);
		TERMINAL_61.addFollower(TERMINAL_48);
		TERMINAL_61.addFollower(TERMINAL_49);
		TERMINAL_61.addFollower(TERMINAL_50);
		TERMINAL_61.addFollower(TERMINAL_51);
		TERMINAL_61.addFollower(TERMINAL_52);
		TERMINAL_61.addFollower(TERMINAL_54);
		TERMINAL_61.addFollower(TERMINAL_53);
		TERMINAL_61.addFollower(TERMINAL_55);
		TERMINAL_1.addFollower(TERMINAL_2);
		TERMINAL_30.addFollower(TERMINAL_87);
		TERMINAL_87.addFollower(TERMINAL_88);
		TERMINAL_88.addFollower(TERMINAL_89);
		TERMINAL_88.addFollower(TERMINAL_90);
		TERMINAL_89.addFollower(TERMINAL_91);
		TERMINAL_91.addFollower(TERMINAL_89);
		TERMINAL_91.addFollower(TERMINAL_90);
		TERMINAL_90.addFollower(TERMINAL_30);
		TERMINAL_90.addFollower(TERMINAL_31);
		TERMINAL_0.addFollower(TERMINAL_92);
		TERMINAL_92.addFollower(TERMINAL_93);
		TERMINAL_92.addFollower(TERMINAL_0);
		TERMINAL_92.addFollower(TERMINAL_1);
		TERMINAL_92.addFollower(TERMINAL_2);
		TERMINAL_92.addFollower(TERMINAL_33);
		TERMINAL_92.addFollower(TERMINAL_24);
		TERMINAL_93.addFollower(TERMINAL_94);
		TERMINAL_95.addFollower(TERMINAL_94);
		TERMINAL_96.addFollower(TERMINAL_0);
		TERMINAL_96.addFollower(TERMINAL_1);
		TERMINAL_96.addFollower(TERMINAL_2);
		TERMINAL_96.addFollower(TERMINAL_33);
		TERMINAL_96.addFollower(TERMINAL_24);
		TERMINAL_94.addFollower(TERMINAL_97);
		TERMINAL_94.addFollower(TERMINAL_95);
		TERMINAL_94.addFollower(TERMINAL_96);
		TERMINAL_97.addFollower(TERMINAL_98);
		TERMINAL_98.addFollower(TERMINAL_95);
		TERMINAL_98.addFollower(TERMINAL_96);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 0));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 0));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 0));
		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
	}
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
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 1));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 1));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 1));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 2));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 2));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 2));
	}
	
	(
		(
			a1_0 = parse_org_emftext_sdk_concretesyntax_Abstract			{
				if (terminateParsing) {
					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
					copyLocalizationInfos(a1_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 3));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_3, 4));
	}
	
	(
		a3 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			if (a3 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_4, 5));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_5, 6));
	}
	
	(
		a5 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			if (a5 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_6, 7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_7, 7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 7));
	}
	
	(
		(
			(
				a6 = QUOTED_60_62				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					if (a6 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_7, 8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 8));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_7, 9));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 9));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 9));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 9));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 9));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 9));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_13, 10));
			}
			
			(
				(
					a8 = QUALIFIED_NAME					
					{
						if (terminateParsing) {
							throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						if (a8 != null) {
							org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
							tokenResolver.setOptions(getOptions());
							org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
							java.lang.Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
							}
							String resolved = (String) resolvedObject;
							org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
							collectHiddenTokens(element);
							registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
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
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 11));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 11));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 11));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 11));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 11));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 11));
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 12));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 12));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 12));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 12));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 12));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 12));
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_15, 13));
					}
					
					(
						(
							a10 = QUALIFIED_NAME							
							{
								if (terminateParsing) {
									throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								}
								if (a10 != null) {
									org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
									tokenResolver.setOptions(getOptions());
									org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
									tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
									java.lang.Object resolvedObject = result.getResolvedToken();
									if (resolvedObject == null) {
										addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStopIndex());
									}
									String resolved = (String) resolvedObject;
									org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
									collectHiddenTokens(element);
									registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
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
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 14));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 14));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 14));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 14));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 14));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 14));
						}
						
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 15));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 15));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 15));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 15));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 15));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 15));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 16));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 16));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 16));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 16));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 16));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 16));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 17));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 17));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 17));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 17));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 17));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_16, 18));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 19));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 19));
			}
			
			(
				(
					(
						a13_0 = parse_org_emftext_sdk_concretesyntax_Import						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 20));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 20));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 21));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 21));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 22));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 22));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 22));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 22));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 23));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 23));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 23));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 23));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_19, 24));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_20, 25));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_21, 25));
			}
			
			(
				(
					(
						a17_0 = parse_org_emftext_sdk_concretesyntax_Option						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_22, 26));
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_20, 27));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_21, 27));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_20, 28));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_21, 28));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 29));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 29));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 29));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 30));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 30));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 30));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_23, 31));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 32));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 32));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_25, 32));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_26, 32));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_27, 32));
			}
			
			(
				(
					(
						a22_0 = parse_org_emftext_sdk_concretesyntax_TokenDirective						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 33));
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 34));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 34));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_25, 34));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_26, 34));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_27, 34));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 35));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 35));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_25, 35));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_26, 35));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_27, 35));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 36));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 36));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 37));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 37));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_29, 38));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_30, 39));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_31, 39));
			}
			
			(
				(
					(
						a27_0 = parse_org_emftext_sdk_concretesyntax_TokenStyle						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_30, 40));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_31, 40));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_30, 41));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_31, 41));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 42));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 43));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_32, 44));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 45));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 45));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_34, 45));
	}
	
	(
		(
			(
				a31_0 = parse_org_emftext_sdk_concretesyntax_Rule				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
			addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 46));
			addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 46));
			addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_34, 46));
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_34, 47));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_35, 49));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_36, 50));
	}
	
	(
		a2 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_37, 51));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_38, 51));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 51));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 51));
	}
	
	(
		(
			(
				a3 = QUOTED_60_62				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					}
					if (a3 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_38, 52));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 52));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 52));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_38, 53));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 53));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 53));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_39, 54));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_40, 55));
			}
			
			(
				a6 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					}
					if (a6 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getImportConcreteSyntaxReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_41, 56));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 56));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 56));
			}
			
			(
				(
					(
						a7 = QUOTED_60_62						
						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
							}
							if (a7 != null) {
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
								tokenResolver.setOptions(getOptions());
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 57));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 57));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 58));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 58));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 59));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 59));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_42, 60));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_43, 61));
	}
	
	(
		a2 = QUOTED_34_34_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_22, 62));
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
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 63));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 63));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 64));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 64));
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleMetaclassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_44, 65));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 66));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 66));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 66));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 66));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 66));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 66));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 66));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 66));
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 67));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 68));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 68));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_34, 68));
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
					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 69));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 69));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_sdk_concretesyntax_Sequence		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 70));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 70));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 70));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 71));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 71));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 71));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 71));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 71));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 71));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 71));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 71));
			}
			
			(
				a2_0 = parse_org_emftext_sdk_concretesyntax_Sequence				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 72));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 72));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 72));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 73));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 73));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 73));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCsString();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 74));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_56, 75));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_57, 76));
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_58, 77));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 78));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 78));
	}
	
	(
		(
			a4_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 79));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_62, 80));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_63, 81));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 82));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 82));
	}
	
	(
		(
			a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 83));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_64, 84));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_65, 85));
	}
	
	(
		a2 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_66, 86));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_67, 87));
	}
	
	(
		a4 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			if (a4 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_68, 88));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_69, 88));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_70, 89));
			}
			
			(
				a6 = QUOTED_39_39_92				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					}
					if (a6 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_69, 90));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_69, 91));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 92));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 92));
	}
	
	(
		(
			a8_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 93));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_71, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 94));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_72, 95));
			}
			
			(
				a2 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					}
					if (a2 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_73, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 96));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 96));
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_74, 97));
					}
					
					(
						a4 = QUALIFIED_NAME						
						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
							}
							if (a4 != null) {
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
								tokenResolver.setOptions(getOptions());
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
								java.lang.Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
								collectHiddenTokens(element);
								registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_73, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 98));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 98));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_73, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 99));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 99));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 100));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 100));
	}
	
	(
		(
			a5_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 101));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 102));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 102));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 102));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 102));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 102));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 102));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 102));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 102));
	}
	
	(
		a1_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 103));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 104));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 104));
	}
	
	(
		(
			a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality			{
				if (terminateParsing) {
					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 105));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 106));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_75, 107));
	}
	
	(
		a1 = NUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 108));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 108));
	}
	
;

parse_org_emftext_sdk_concretesyntax_NormalToken returns [org.emftext.sdk.concretesyntax.NormalToken element = null]
@init{
}
:
	(
		(
			(
				a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS, a0_0);
							completedElement(a0_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 109));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 109));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 110));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 110));
	}
	
	a1 = 'DEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_76, 111));
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), resolved);
					completedElement(resolved);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_77, 112));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_78, 112));
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS, a3_0);
					completedElement(a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 113));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 113));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 113));
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_77, 114));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_78, 114));
			}
			
			(
				a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS, a5_0);
							completedElement(a5_0);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos(a5_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 115));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 115));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 115));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 116));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 116));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 116));
	}
	
	(
		(
			a6 = 'COLLECT' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_81, 117));
			}
			
			a7 = 'IN' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				}
				collectHiddenTokens(element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_82, 118));
			}
			
			(
				a8 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
					}
					if (a8 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), resolved);
							completedElement(resolved);
						}
						collectHiddenTokens(element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 119));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 120));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_83, 121));
	}
	
	a1 = 'PARTIAL' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
		}
		collectHiddenTokens(element);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_84, 122));
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_77, 123));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_78, 123));
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 124));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 124));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_77, 125));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_78, 125));
			}
			
			(
				a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 126));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 126));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 127));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 127));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_86, 128));
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 129));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAtomicRegex();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 130));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 130));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 130));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 130));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexReference();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.PartialTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.RegexReference, org.emftext.sdk.concretesyntax.AbstractTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRegexReferenceTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), resolved, proxy);
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 131));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 131));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 131));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 131));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 132));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 133));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 134));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 135));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_87, 136));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_88, 137));
	}
	
	(
		a2 = HEXNUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_89, 138));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_90, 138));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_91, 139));
			}
			
			(
				a4 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					}
					if (a4 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_89, 140));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_90, 140));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_89, 141));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_90, 141));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_30, 142));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_31, 142));
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_92, 143));
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_93, 144));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 144));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 144));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 144));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 144));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 144));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_94, 145));
			}
			
			(
				a3_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 146));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 146));
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_94, 147));
					}
					
					(
						a5_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 148));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 148));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 149));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 149));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 150));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 150));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 150));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 150));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 150));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 151));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 151));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 151));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 151));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 151));
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
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_97, 152));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 152));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 152));
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_98, 153));
			}
			
			(
				a2 = QUOTED_34_34_92				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
					}
					if (a2 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 154));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 154));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 155));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 155));
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_NormalToken{ element = c0; /* this is a subclass choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition{ element = c1; /* this is a subclass choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective{ element = c2; /* this is a subclass choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_CsString{ element = c0; /* this is a subclass choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken{ element = c1; /* this is a subclass choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken{ element = c2; /* this is a subclass choice */ }
	|	c3 = parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes{ element = c3; /* this is a subclass choice */ }
	|	c4 = parse_org_emftext_sdk_concretesyntax_Containment{ element = c4; /* this is a subclass choice */ }
	|	c5 = parse_org_emftext_sdk_concretesyntax_CompoundDefinition{ element = c5; /* this is a subclass choice */ }
	|	c6 = parse_org_emftext_sdk_concretesyntax_WhiteSpaces{ element = c6; /* this is a subclass choice */ }
	|	c7 = parse_org_emftext_sdk_concretesyntax_LineBreak{ element = c7; /* this is a subclass choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_PLUS{ element = c0; /* this is a subclass choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_STAR{ element = c1; /* this is a subclass choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_QUESTIONMARK{ element = c2; /* this is a subclass choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_RegexPart returns [org.emftext.sdk.concretesyntax.RegexPart element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_AtomicRegex{ element = c0; /* this is a subclass choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_RegexReference{ element = c1; /* this is a subclass choice */ }
	
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

