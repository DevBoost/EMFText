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
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	@SuppressWarnings("unused")
	private int lastPosition;
	
	/**
	 * the index of the last token that was handled by retrieveLayoutInformation()
	 */
	private int lastPosition2;
	
	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult tokenResolveResult = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult();
	
	/**
	 * A flag that indicateds whether the parser should remember all expected
	 * elements. This flag is set to true when using the parse for code completion.
	 * Otherwise it is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used only when the parser is used
	 * for code completion. Whenever the parser starts to read an object it is pushed
	 * on the stack. Once the element was parser completely it is popped for the stack.
	 */
	protected java.util.Stack<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	/**
	 * A collection that is filled with commands to be exectued after parsing. This
	 * collection is cleared before parsing starts and returned as part of the parse
	 * result object.
	 */
	private java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> postParseCommands;
	
	/**
	 * A flag to indicate that the parser should stop parsing as soon as possible. The
	 * flag is set to false before parsing starts. It can be set to true by invoking
	 * the terminateParsing() method from another thread. This feature is used, when
	 * documents are parsed in the background (i.e., while editing them). In order to
	 * cancel running parsers, the parsing process can be terminated. This is done
	 * whenever a document changes, because the previous content of the document is
	 * not valid anymore and parsing the old content is not necessary any longer.
	 */
	private boolean terminateParsing;
	
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
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
	
	public boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
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
					// the locationMap can be null if the parser is used for code completion
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
					// the locationMap can be null if the parser is used for code completion
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
	
	/**
	 * Sets the end character index and the last line for the given object in the
	 * location map.
	 */
	protected void setLocalizationEnd(java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
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
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
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
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
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
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
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
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_2_0.Lexer lexer = (org.antlr.runtime3_2_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
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
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 157;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.util.CsPair<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.sdk.concretesyntax.resource.cs.util.CsPair<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
							org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement newFollower = newFollowerPair.getLeft();
							org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal newFollowTerminal = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
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
		// after the last token in the stream we must set the position for the elements
		// that were added during the last iteration of the loop
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
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.registerContextDependentProxy(factory, element, reference, id, proxy);
				return true;
			}
		});
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
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
			message = "mismatched tree node: " + "xxx" + "; expecting " + tokenName;
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
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
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
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
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
	
	protected void completedElement(java.lang.Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			this.incompleteObjects.pop();
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	/**
	 * Creates a dynamic Java proxy that mimics the interface of the given class.
	 */
	@SuppressWarnings("unchecked")
	
	public <T> T createDynamicProxy(java.lang.Class<T> clazz) {
		java.lang.Object proxy = java.lang.reflect.Proxy.newProxyInstance(this.getClass().getClassLoader(), new java.lang.Class<?>[]{clazz, org.eclipse.emf.ecore.EObject.class, org.eclipse.emf.ecore.InternalEObject.class}, new java.lang.reflect.InvocationHandler() {
			
			private org.eclipse.emf.ecore.EObject dummyObject = new org.eclipse.emf.ecore.impl.EObjectImpl() {};
			
			public java.lang.Object invoke(java.lang.Object object, java.lang.reflect.Method method, java.lang.Object[] args) throws java.lang.Throwable {
				// search in dummyObject for the requested method
				java.lang.reflect.Method[] methodsInDummy = dummyObject.getClass().getMethods();
				for (java.lang.reflect.Method methodInDummy : methodsInDummy) {
					boolean matches = true;
					if (methodInDummy.getName().equals(method.getName())) {
						java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
						java.lang.Class<?>[] parameterTypesInDummy = methodInDummy.getParameterTypes();
						if (parameterTypes.length == parameterTypesInDummy.length) {
							for (int p = 0; p < parameterTypes.length; p++) {
								java.lang.Class<?> parameterType = parameterTypes[p];
								java.lang.Class<?> parameterTypeInDummy = parameterTypesInDummy[p];
								if (!parameterType.equals(parameterTypeInDummy)) {
									matches = false;
								}
							}
						} else {
							matches = false;
						}
					} else {
						matches = false;
					}
					if (matches) {
						return methodInDummy.invoke(dummyObject, args);
					}
				}
				return null;
			}
					});
		return (T) proxy;
	}
	
	protected void retrieveLayoutInformation(org.eclipse.emf.ecore.EObject element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement syntaxElement, java.lang.Object object) {
		if (!(syntaxElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder) && !(syntaxElement instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword)) {
			return;
		}
		int currentPos = getTokenStream().index();
		if (currentPos == 0) {
			return;
		}
		int endPos = currentPos - 1;
		for (; endPos >= this.lastPosition2; endPos--) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(endPos);
			int _channel = token.getChannel();
			if (_channel != 99) {
				break;
			}
		}
		java.lang.StringBuilder hiddenTokenText = new java.lang.StringBuilder();
		java.lang.StringBuilder visibleTokenText = new java.lang.StringBuilder();
		for (int pos = this.lastPosition2; pos <= endPos; pos++) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(pos);
			int _channel = token.getChannel();
			if (_channel == 99) {
				hiddenTokenText.append(token.getText());
			} else {
				visibleTokenText.append(token.getText());
			}
		}
		org.antlr.runtime3_2_0.CommonToken firstToken = (org.antlr.runtime3_2_0.CommonToken) getTokenStream().get(this.lastPosition2);
		int offset = firstToken.getStartIndex();
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(element);
		layoutInformationAdapter.addLayoutInformation(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation(syntaxElement, object, offset, hiddenTokenText.toString(), visibleTokenText.toString()));
		this.lastPosition2 = (endPos < 0 ? 0 : endPos + 1);
	}
	
	protected org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter getLayoutInformationAdapter(org.eclipse.emf.ecore.EObject element) {
		for (org.eclipse.emf.common.notify.Adapter adapter : element.eAdapters()) {
			if (adapter instanceof org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter) {
				return (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter) adapter;
			}
		}
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter newAdapter = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 0));
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
							completedElement(a0_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_0_0_0_0, a0_0);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 1));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 2, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 2, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 2));
	}
	
	(
		(
			(
				a1_0 = parse_org_emftext_sdk_concretesyntax_Abstract				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER), a1_0);
							completedElement(a1_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_1_0_0_0, a1_0);
						copyLocalizationInfos(a1_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 3));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 4));
	}
	
	a2 = 'SYNTAXDEF' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_3, 5));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_4, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_4, 6));
	}
	
	a4 = 'FOR' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_6, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_5, 7));
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
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_8, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_6, 8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_7, 8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 8));
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
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_9_0_0_1, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_7, 9));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 9));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 9));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 9));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 9));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 9));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_7, 10));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 10));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 10));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 10));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 10));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 10));
	}
	
	(
		(
			a7 = 'START' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_13, 11));
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
								completedElement(proxy, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_2_0_0_0, proxy);
							copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
							copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, proxy);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 12));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 12));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 12));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 12));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 12));
					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 12));
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 13));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 13));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 13));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 13));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 13));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 13));
			}
			
			(
				(
					a9 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_3_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_15, 14));
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
										completedElement(proxy, false);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_3_0_0_1_0_0_0, proxy);
									copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, element);
									copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, proxy);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 15));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 15));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 15));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 15));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 15));
							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 15));
						}
						
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 16));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 16));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 16));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 16));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 16));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 16));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 17));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 17));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 17));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 17));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 17));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 17));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 18));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 18));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 18));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 18));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 18));
	}
	
	(
		(
			a11 = 'IMPORTS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_2, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_16, 19));
			}
			
			a12 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_4, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 20, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 20));
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
									completedElement(a13_0, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_5_0_0_1, a13_0);
								copyLocalizationInfos(a13_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 21, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 21));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 22, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 22));
			}
			
			a14 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_7, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 23));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 23));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 23));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 23));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 24));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 24));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 24));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 24));
	}
	
	(
		(
			a15 = 'OPTIONS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_2, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a15, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_19, 25));
			}
			
			a16 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_4, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_20, 26, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_21, 26));
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
									completedElement(a17_0, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_5_0_0_1, a17_0);
								copyLocalizationInfos(a17_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_22, 27));
					}
					
					a18 = ';' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_5_0_0_2, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a18, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_20, 28, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_21, 28));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_20, 29, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_21, 29));
			}
			
			a19 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_7, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a19, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 30));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 30));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 30));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 31));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 31));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 31));
	}
	
	(
		(
			a20 = 'TOKENS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_2, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a20, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_23, 32));
			}
			
			a21 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_4, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a21, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 33, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 33, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 33, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_26, 33, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_27, 33));
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
									completedElement(a22_0, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_5_0_0_1, a22_0);
								copyLocalizationInfos(a22_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 34));
					}
					
					a23 = ';' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_5_0_0_2, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a23, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_26, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_27, 35));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 36, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 36, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 36, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_26, 36, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_27, 36));
			}
			
			a24 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_7, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a24, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 37));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 37));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 38));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 38));
	}
	
	(
		(
			a25 = 'TOKENSTYLES' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_2, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a25, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 39));
			}
			
			a26 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_4, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a26, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_30, 40, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 40));
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
									completedElement(a27_0, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_5_0_0_1, a27_0);
								copyLocalizationInfos(a27_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_30, 41, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 41));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_30, 42, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 42));
			}
			
			a28 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_7, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a28, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 43));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 44));
	}
	
	a29 = 'RULES' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_18, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a29, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_32, 45));
	}
	
	a30 = '{' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_20, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a30, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 46, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 46, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 46));
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
							completedElement(a31_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_21_0_0_1, a31_0);
						copyLocalizationInfos(a31_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 47, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 47, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 47));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 48, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 48, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 48));
	}
	
	a32 = '}' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_23, null);
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_35, 50));
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_36, 51));
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
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_37, 52));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_38, 52));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 52, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 52));
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
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_3_0_0_1, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_38, 53));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 53, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 53));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_38, 54));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 54, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 54));
	}
	
	(
		(
			a4 = 'WITH' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_39, 55));
			}
			
			a5 = 'SYNTAX' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_3, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_40, 56));
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
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_5, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_41, 57));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 57, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 57));
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
									completedElement(resolved, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_6_0_0_1, resolved);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a7, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 58, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 58));
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 59, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 59));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 60, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 60));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_42, 61));
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_43, 62));
	}
	
	(
		a2 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_2, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_22, 63));
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
							completedElement(a0_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_0_0_0_1, a0_0);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 64, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 64));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 65, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 65));
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
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_44, 66));
	}
	
	a2 = '::=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 67, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 67, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 67, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 67, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 67, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 67, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 67, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 67, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
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
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__CHILDREN, a3_0);
					completedElement(a3_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_4, a3_0);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 68));
	}
	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 69, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 69, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 69));
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
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__CHILDREN, a0_0);
						completedElement(a0_0, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_4_0_0_0, a0_0);
					copyLocalizationInfos(a0_0, element); 				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 70));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 70));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 70));
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
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__CHILDREN, a0_0);
					completedElement(a0_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_0, a0_0);
				copyLocalizationInfos(a0_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 71));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 71));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 71));
	}
	
	(
		(
			a1 = '|' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_1_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
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
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__CHILDREN, a2_0);
							completedElement(a2_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_1_0_0_1, a2_0);
						copyLocalizationInfos(a2_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 73));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 73));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 73));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 74));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 74));
	}
	
;

parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null]
@init{
}
:
	(
		a0 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCsString();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_6_0_0_1, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 75));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 75));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 75));
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
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_0, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 76));
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 77));
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
				org.emftext.sdk.concretesyntax.CompleteTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 78));
	}
	
	a3 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 79, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 79));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 79));
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
						completedElement(a4_0, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_4, a4_0);
					copyLocalizationInfos(a4_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 80, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 80, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 80, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 80, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 80, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 80, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 80, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 80, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 80));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 80));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 80));
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
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_0, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_62, 81));
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_63, 82));
	}
	
	a2 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 83));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 83));
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
						completedElement(a3_0, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_3, a3_0);
					copyLocalizationInfos(a3_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 84, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 84, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 84, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 84, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 84, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 84, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 84, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 84, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 84));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 84));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 84));
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
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_0, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_64, 85));
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_65, 86));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_2, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_66, 87));
	}
	
	a3 = ',' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_67, 88));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_4, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_68, 89));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_69, 89));
	}
	
	(
		(
			a5 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_70, 90));
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
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_1, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_69, 91));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_69, 92));
	}
	
	a7 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_6, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 93, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 93));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 93));
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
						completedElement(a8_0, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_8, a8_0);
					copyLocalizationInfos(a8_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 94, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 94, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 94, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 94, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 94, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 94, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 94, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 94, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 94));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 94));
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
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_0, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_71, 95));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 95, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 95));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 95));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 95));
	}
	
	(
		(
			a1 = ':' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_1_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_72, 96));
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
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_1_0_0_1, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_73, 97));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 97));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 97));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 97));
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_1_0_0_2_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_74, 98));
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
									completedElement(proxy, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_1_0_0_2_0_0_1, proxy);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_73, 99));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 99, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 99));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 99));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 99));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_73, 100));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 100, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 100));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 100));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 100));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 101, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 101));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 101));
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
						completedElement(a5_0, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_2, a5_0);
					copyLocalizationInfos(a5_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 102, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 102, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 102, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 102, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 102, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 102, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 102, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 102, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 102));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 102));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 102));
	}
	
;

parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 103, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 103, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 103, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 103, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 103, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 103, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 103, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 103, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
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
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CHILDREN, a1_0);
					completedElement(a1_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_1, a1_0);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 104));
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 105, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 105));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 105));
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
						completedElement(a3_0, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_3, a3_0);
					copyLocalizationInfos(a3_0, element); 				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 106, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 106, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 106, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 106, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 106, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 106, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 106, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 106, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 106));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 106));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 107, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 107, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 107, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 107, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 107, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 107, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 107, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 107, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 107));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 107));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 107));
	}
	
;

parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null]
@init{
}
:
	a0 = '!' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_75, 108));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 109, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 109, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 109, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 109, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 109, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 109, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 109, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 109, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 109));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 109));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 109));
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
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ANNOTATIONS, a0_0);
							completedElement(a0_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_0_0_0_0, a0_0);
						copyLocalizationInfos(a0_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 110, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 110));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 111, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 111));
	}
	
	a1 = 'DEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_76, 112));
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), result);
				java.lang.Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_3, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_77, 113, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 113, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS, a3_0);
					completedElement(a3_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_5, a3_0);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 114));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_80, 114));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 114));
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_6_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_77, 115, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 115, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
			}
			
			(
				a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS, a5_0);
							completedElement(a5_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_6_0_0_3, a5_0);
						copyLocalizationInfos(a5_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 116));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_80, 116));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 116));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 117));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_80, 117));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 117));
	}
	
	(
		(
			a6 = 'COLLECT' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_7_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_81, 118));
			}
			
			a7 = 'IN' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_7_0_0_3, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_82, 119));
			}
			
			(
				a8 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					}
					if (a8 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), result);
						java.lang.Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_7_0_0_5, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 120));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 121));
	}
	
;

parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition returns [org.emftext.sdk.concretesyntax.PartialTokenDefinition element = null]
@init{
}
:
	a0 = 'DEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_83, 122));
	}
	
	a1 = 'FRAGMENT' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_84, 123));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_4, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_77, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
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
					completedElement(a3_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_6, a3_0);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_85, 125));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 125));
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_7_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_77, 126, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 126, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
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
							completedElement(a5_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_7_0_0_3, a5_0);
						copyLocalizationInfos(a5_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_85, 127));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 127));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_85, 128));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 128));
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null]
@init{
}
:
	a0 = 'PRIORITIZE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_16_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_86, 129));
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
				org.emftext.sdk.concretesyntax.CompleteTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_16_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 130));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 131));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_80, 131));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 131));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_85, 131));
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
				org.emftext.sdk.concretesyntax.AbstractTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.RegexReference, org.emftext.sdk.concretesyntax.AbstractTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRegexReferenceTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_0, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_80, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 132));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_85, 132));
	}
	
;

parse_org_emftext_sdk_concretesyntax_PLUS returns [org.emftext.sdk.concretesyntax.PLUS element = null]
@init{
}
:
	a0 = '+' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPLUS();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 133, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 133, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 133, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 133, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 133, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 133, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 133, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 133, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 133));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 133));
	}
	
;

parse_org_emftext_sdk_concretesyntax_STAR returns [org.emftext.sdk.concretesyntax.STAR element = null]
@init{
}
:
	a0 = '*' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSTAR();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 134, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 134, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 134, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 134, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 134, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 134, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 134, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 134, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 134));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 134));
	}
	
;

parse_org_emftext_sdk_concretesyntax_QUESTIONMARK returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null]
@init{
}
:
	a0 = '?' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_21_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 135));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 135));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 135));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Abstract returns [org.emftext.sdk.concretesyntax.Abstract element = null]
@init{
}
:
	a0 = 'ABSTRACT' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAbstract();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_22_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 136));
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null]
@init{
}
:
	(
		a0 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_87, 137));
	}
	
	a1 = 'COLOR' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_88, 138));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_4, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_89, 139));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_90, 139));
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_5_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_91, 140));
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
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_5_0_0_2, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_89, 141));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_90, 141));
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_89, 142));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_90, 142));
	}
	
	a5 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_30, 143, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 143));
	}
	
;

parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null]
@init{
}
:
	a0 = '@' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_92, 144));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_1, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_93, 145));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 145, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 145, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 145));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 145));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 145));
	}
	
	(
		(
			a2 = '(' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_94, 146, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_10));
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
							completedElement(a3_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_1, a3_0);
						copyLocalizationInfos(a3_0, element); 					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 147));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 147));
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_2_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_94, 148, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_10));
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
									completedElement(a5_0, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_2_0_0_1, a5_0);
								copyLocalizationInfos(a5_0, element); 							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 149));
						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 149));
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 150));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 150));
			}
			
			a6 = ')' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_3, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 151, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 151, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 151));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 151));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 151));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 152, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 152, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 152));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 152));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 152));
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
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_97, 153));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 153));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 153));
	}
	
	(
		(
			a1 = '=' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_98, 154));
			}
			
			(
				a2 = STRING				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
					}
					if (a2 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
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
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_1, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 155));
				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 155));
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 156));
		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 156));
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_CsString{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_sdk_concretesyntax_Containment{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_sdk_concretesyntax_CompoundDefinition{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_sdk_concretesyntax_WhiteSpaces{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_sdk_concretesyntax_LineBreak{ element = c7; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_PLUS{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_STAR{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_QUESTIONMARK{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_RegexPart returns [org.emftext.sdk.concretesyntax.RegexPart element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_AtomicRegex{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_RegexReference{ element = c1; /* this is a subclass or primitive expression choice */ }
	
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
STRING:
	'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"';
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
QUOTED_39_39_92:
	('\'')(('\\''\'')|('\\''\\')|~('\''|'\\'))*('\'')
;
QUOTED_36_36:
	('$')(~('$'))*('$')
;

