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
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
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
	private int lastPosition;
	
	/**
	 * A flag that indicates whether the parser should remember all expected elements.
	 * This flag is set to true when using the parse for code completion. Otherwise it
	 * is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	/**
	 * The offset indicating the cursor position when the parser is used for code
	 * completion by calling parseToExpectedElements().
	 */
	private int cursorOffset;
	
	/**
	 * The offset of the first hidden token of the last expected element. This offset
	 * is used to discard expected elements, which are not needed for code completion.
	 */
	private int lastStartIncludingHidden;
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.emftext.sdk.concretesyntax.resource.cs.ICsProblem() {
					public org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity getSeverity() {
						return org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity.ERROR;
					}
					public org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType getType() {
						return org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(int terminalID, int followSetID, int... containmentTraceIDs) {
		if (!this.rememberExpectedElements) {
			return;
		}
		org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement terminal = org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINALS[terminalID];
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] containmentTrace = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[containmentTraceIDs.length];
		for (int i = 0; i < containmentTraceIDs.length; i++) {
			containmentTrace[i] = org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.LINKS[containmentTraceIDs[i]];
		}
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedElement = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(container, terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
			this.expectedElementsIndexOfLastCompleteElement = 0;
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
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
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
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
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new CsParser(new org.antlr.runtime3_4_0.CommonTokenStream(new CsLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new CsParser(new org.antlr.runtime3_4_0.CommonTokenStream(new CsLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
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
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((CsLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((CsLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
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
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.BooleanTerminal.class) {
				return parse_org_emftext_sdk_concretesyntax_BooleanTerminal();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.EnumTerminal.class) {
				return parse_org_emftext_sdk_concretesyntax_EnumTerminal();
			}
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.EnumLiteralTerminal.class) {
				return parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal();
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
			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.TokenRedefinition.class) {
				return parse_org_emftext_sdk_concretesyntax_TokenRedefinition();
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
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
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
		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.emftext.sdk.concretesyntax.resource.cs.ICsParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
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
		int followSetID = 186;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
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
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.util.CsPair<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.sdk.concretesyntax.resource.cs.util.CsPair<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[]> newFollowerPair : newFollowers) {
							org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal newFollowTerminal = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(container, newFollower, followSetID, newFollowerPair.getRight());
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
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	private void startIncompleteElement(Object object) {
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
		}
	}
	
	private void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			boolean exists = this.incompleteObjects.remove(object);
			if (!exists) {
			}
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
		if (incompleteObjects.isEmpty()) {
			return null;
		}
		return incompleteObjects.get(incompleteObjects.size() - 1);
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(0, 0, 0);
		addExpectedElement(1, 0);
		addExpectedElement(2, 0);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_emftext_sdk_concretesyntax_ConcreteSyntax{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
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
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
						}
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							Object value = a0_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_0_0_0_0, a0_0, true);
						copyLocalizationInfos(a0_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(0, 1, 1);
				addExpectedElement(1, 1);
				addExpectedElement(2, 1);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(0, 2, 2);
		addExpectedElement(1, 2);
		addExpectedElement(2, 2);
	}
	
	(
		(
			a1 = 'ABSTRACT' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_1, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(2, 3);
	}
	
	a4 = 'SYNTAXDEF' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(3, 4);
	}
	
	(
		a5 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
				}
			}
			if (a5 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(4, 5);
	}
	
	a6 = 'FOR' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(5, 6);
	}
	
	(
		a7 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
				}
			}
			if (a7 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_8, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(6, 7);
		addExpectedElement(7, 7);
		addExpectedElement(8, 7);
		addExpectedElement(9, 7);
		addExpectedElement(10, 7);
		addExpectedElement(11, 7);
		addExpectedElement(12, 7);
	}
	
	(
		(
			(
				a8 = QUOTED_60_62				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
						}
					}
					if (a8 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_9_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(7, 8);
				addExpectedElement(8, 8);
				addExpectedElement(9, 8);
				addExpectedElement(10, 8);
				addExpectedElement(11, 8);
				addExpectedElement(12, 8);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(7, 9);
		addExpectedElement(8, 9);
		addExpectedElement(9, 9);
		addExpectedElement(10, 9);
		addExpectedElement(11, 9);
		addExpectedElement(12, 9);
	}
	
	(
		(
			a9 = 'START' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(13, 10);
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
							startIncompleteElement(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
							}
						}
						if (a10 != null) {
							org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
							tokenResolver.setOptions(getOptions());
							org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
							}
							String resolved = (String) resolvedObject;
							org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
							collectHiddenTokens(element);
							registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
							if (proxy != null) {
								Object value = proxy;
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_2_0_0_0, proxy, true);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, proxy);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(14, 11);
					addExpectedElement(8, 11);
					addExpectedElement(9, 11);
					addExpectedElement(10, 11);
					addExpectedElement(11, 11);
					addExpectedElement(12, 11);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(14, 12);
				addExpectedElement(8, 12);
				addExpectedElement(9, 12);
				addExpectedElement(10, 12);
				addExpectedElement(11, 12);
				addExpectedElement(12, 12);
			}
			
			(
				(
					a11 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							startIncompleteElement(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
							}
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_3_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(15, 13);
					}
					
					(
						(
							a12 = QUALIFIED_NAME							
							{
								if (terminateParsing) {
									throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
								}
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
									startIncompleteElement(element);
									// initialize boolean attribute
									{
										Object value = false;
										element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
									}
								}
								if (a12 != null) {
									org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
									tokenResolver.setOptions(getOptions());
									org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
									tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
									Object resolvedObject = result.getResolvedToken();
									if (resolvedObject == null) {
										addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
									}
									String resolved = (String) resolvedObject;
									org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
									collectHiddenTokens(element);
									registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
									if (proxy != null) {
										Object value = proxy;
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, value);
										completedElement(value, false);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_3_0_0_1_0_0_0, proxy, true);
									copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
									copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, proxy);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(14, 14);
							addExpectedElement(8, 14);
							addExpectedElement(9, 14);
							addExpectedElement(10, 14);
							addExpectedElement(11, 14);
							addExpectedElement(12, 14);
						}
						
					)
					{
						// expected elements (follow set)
						addExpectedElement(14, 15);
						addExpectedElement(8, 15);
						addExpectedElement(9, 15);
						addExpectedElement(10, 15);
						addExpectedElement(11, 15);
						addExpectedElement(12, 15);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(14, 16);
				addExpectedElement(8, 16);
				addExpectedElement(9, 16);
				addExpectedElement(10, 16);
				addExpectedElement(11, 16);
				addExpectedElement(12, 16);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(8, 17);
		addExpectedElement(9, 17);
		addExpectedElement(10, 17);
		addExpectedElement(11, 17);
		addExpectedElement(12, 17);
	}
	
	(
		(
			a13 = 'IMPORTS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(16, 18);
			}
			
			a14 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(0, 19, 3, 4);
				addExpectedElement(17, 19, 5);
				addExpectedElement(18, 19);
			}
			
			(
				(
					(
						a15_0 = parse_org_emftext_sdk_concretesyntax_Import						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								startIncompleteElement(element);
								// initialize boolean attribute
								{
									Object value = false;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
								}
							}
							if (a15_0 != null) {
								if (a15_0 != null) {
									Object value = a15_0;
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_5_0_0_1, a15_0, true);
								copyLocalizationInfos(a15_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(0, 20, 6, 7);
						addExpectedElement(17, 20, 8);
						addExpectedElement(18, 20);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(0, 21, 9, 10);
				addExpectedElement(17, 21, 11);
				addExpectedElement(18, 21);
			}
			
			a16 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(9, 22);
				addExpectedElement(10, 22);
				addExpectedElement(11, 22);
				addExpectedElement(12, 22);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(9, 23);
		addExpectedElement(10, 23);
		addExpectedElement(11, 23);
		addExpectedElement(12, 23);
	}
	
	(
		(
			a17 = 'OPTIONS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(19, 24);
			}
			
			a18 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a18, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(20, 25, 12);
				addExpectedElement(21, 25);
			}
			
			(
				(
					(
						a19_0 = parse_org_emftext_sdk_concretesyntax_Option						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								startIncompleteElement(element);
								// initialize boolean attribute
								{
									Object value = false;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
								}
							}
							if (a19_0 != null) {
								if (a19_0 != null) {
									Object value = a19_0;
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_5_0_0_1, a19_0, true);
								copyLocalizationInfos(a19_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(22, 26);
					}
					
					a20 = ';' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							startIncompleteElement(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
							}
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_5_0_0_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(20, 27, 13);
						addExpectedElement(21, 27);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(20, 28, 14);
				addExpectedElement(21, 28);
			}
			
			a21 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a21, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(10, 29);
				addExpectedElement(11, 29);
				addExpectedElement(12, 29);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(10, 30);
		addExpectedElement(11, 30);
		addExpectedElement(12, 30);
	}
	
	(
		(
			a22 = 'TOKENS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a22, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(23, 31);
			}
			
			a23 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a23, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(0, 32, 15, 16);
				addExpectedElement(24, 32, 17);
				addExpectedElement(25, 32, 18);
				addExpectedElement(26, 32, 19);
				addExpectedElement(27, 32, 20);
				addExpectedElement(28, 32);
			}
			
			(
				(
					(
						a24_0 = parse_org_emftext_sdk_concretesyntax_TokenDirective						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								startIncompleteElement(element);
								// initialize boolean attribute
								{
									Object value = false;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
								}
							}
							if (a24_0 != null) {
								if (a24_0 != null) {
									Object value = a24_0;
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_5_0_0_1, a24_0, true);
								copyLocalizationInfos(a24_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(29, 33);
					}
					
					a25 = ';' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							startIncompleteElement(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
							}
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_5_0_0_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a25, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(0, 34, 21, 22);
						addExpectedElement(24, 34, 23);
						addExpectedElement(25, 34, 24);
						addExpectedElement(26, 34, 25);
						addExpectedElement(27, 34, 26);
						addExpectedElement(28, 34);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(0, 35, 27, 28);
				addExpectedElement(24, 35, 29);
				addExpectedElement(25, 35, 30);
				addExpectedElement(26, 35, 31);
				addExpectedElement(27, 35, 32);
				addExpectedElement(28, 35);
			}
			
			a26 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a26, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(11, 36);
				addExpectedElement(12, 36);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(11, 37);
		addExpectedElement(12, 37);
	}
	
	(
		(
			a27 = 'TOKENSTYLES' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a27, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(30, 38);
			}
			
			a28 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a28, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(31, 39, 33);
				addExpectedElement(32, 39);
			}
			
			(
				(
					(
						a29_0 = parse_org_emftext_sdk_concretesyntax_TokenStyle						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								startIncompleteElement(element);
								// initialize boolean attribute
								{
									Object value = false;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
								}
							}
							if (a29_0 != null) {
								if (a29_0 != null) {
									Object value = a29_0;
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_5_0_0_1, a29_0, true);
								copyLocalizationInfos(a29_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(31, 40, 34);
						addExpectedElement(32, 40);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(31, 41, 35);
				addExpectedElement(32, 41);
			}
			
			a30 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a30, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(12, 42);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(12, 43);
	}
	
	a31 = 'RULES' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_18, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a31, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(33, 44);
	}
	
	a32 = '{' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_20, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a32, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(0, 45, 36, 37);
		addExpectedElement(34, 45, 38);
		addExpectedElement(35, 45);
	}
	
	(
		(
			(
				a33_0 = parse_org_emftext_sdk_concretesyntax_Rule				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						startIncompleteElement(element);
						// initialize boolean attribute
						{
							Object value = false;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
						}
					}
					if (a33_0 != null) {
						if (a33_0 != null) {
							Object value = a33_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_21_0_0_1, a33_0, true);
						copyLocalizationInfos(a33_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(0, 46, 39, 40);
				addExpectedElement(34, 46, 41);
				addExpectedElement(35, 46);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(0, 47, 42, 43);
		addExpectedElement(34, 47, 44);
		addExpectedElement(35, 47);
	}
	
	a34 = '}' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			startIncompleteElement(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_23, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a34, element);
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
		(
			(
				a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
						startIncompleteElement(element);
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							Object value = a0_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_0_0_0_0, a0_0, true);
						copyLocalizationInfos(a0_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(0, 49, 45);
				addExpectedElement(17, 49);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(0, 50, 46);
		addExpectedElement(17, 50);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(36, 51);
	}
	
	a2 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(37, 52);
	}
	
	(
		a3 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_3, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(38, 53);
		addExpectedElement(39, 53);
		addExpectedElement(0, 53, 47, 48);
		addExpectedElement(17, 53, 49);
		addExpectedElement(18, 53);
	}
	
	(
		(
			(
				a4 = QUOTED_60_62				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
						startIncompleteElement(element);
					}
					if (a4 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(39, 54);
				addExpectedElement(0, 54, 50, 51);
				addExpectedElement(17, 54, 52);
				addExpectedElement(18, 54);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(39, 55);
		addExpectedElement(0, 55, 53, 54);
		addExpectedElement(17, 55, 55);
		addExpectedElement(18, 55);
	}
	
	(
		(
			a5 = 'WITH' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(40, 56);
			}
			
			a6 = 'SYNTAX' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(41, 57);
			}
			
			(
				a7 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
						startIncompleteElement(element);
					}
					if (a7 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getImportConcreteSyntaxReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_5, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(42, 58);
				addExpectedElement(0, 58, 56, 57);
				addExpectedElement(17, 58, 58);
				addExpectedElement(18, 58);
			}
			
			(
				(
					(
						a8 = QUOTED_60_62						
						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
								startIncompleteElement(element);
							}
							if (a8 != null) {
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
								tokenResolver.setOptions(getOptions());
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_6_0_0_1, resolved, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(0, 59, 59, 60);
						addExpectedElement(17, 59, 61);
						addExpectedElement(18, 59);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(0, 60, 62, 63);
				addExpectedElement(17, 60, 64);
				addExpectedElement(18, 60);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(0, 61, 65, 66);
		addExpectedElement(17, 61, 67);
		addExpectedElement(18, 61);
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
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.OptionTypes resolved = (org.emftext.sdk.concretesyntax.OptionTypes) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(43, 62);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(44, 63);
	}
	
	(
		a2 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(22, 64);
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
						startIncompleteElement(element);
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							Object value = a0_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_0_0_0_0, a0_0, true);
						copyLocalizationInfos(a0_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(0, 65, 68);
				addExpectedElement(34, 65);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(0, 66, 69);
		addExpectedElement(34, 66);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleMetaclassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_1, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(45, 67);
	}
	
	a2 = '::=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(46, 68, 70, 71, 72);
		addExpectedElement(47, 68, 73, 74, 75);
		addExpectedElement(48, 68, 76, 77, 78);
		addExpectedElement(49, 68, 79, 80, 81);
		addExpectedElement(50, 68, 82, 83, 84);
		addExpectedElement(51, 68, 85, 86, 87);
		addExpectedElement(52, 68, 88, 89, 90);
		addExpectedElement(53, 68, 91, 92, 93);
		addExpectedElement(54, 68, 94, 95, 96);
		addExpectedElement(55, 68, 97, 98, 99);
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__CHILDREN, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_5, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(56, 69);
	}
	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(0, 70, 100, 101);
		addExpectedElement(34, 70, 102);
		addExpectedElement(35, 70);
	}
	
;

parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_sdk_concretesyntax_Definition		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSequence();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__CHILDREN, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_4_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 71, 103);
		addExpectedElement(47, 71, 104);
		addExpectedElement(48, 71, 105);
		addExpectedElement(49, 71, 106);
		addExpectedElement(50, 71, 107);
		addExpectedElement(51, 71, 108);
		addExpectedElement(52, 71, 109);
		addExpectedElement(53, 71, 110);
		addExpectedElement(54, 71, 111);
		addExpectedElement(55, 71, 112);
		addExpectedElement(57, 71);
		addExpectedElement(56, 71);
		addExpectedElement(58, 71);
	}
	
	(
		(
			(
				a1_0 = parse_org_emftext_sdk_concretesyntax_Definition				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSequence();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__CHILDREN, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_4_0_0_1_0_0_1, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(46, 72, 113);
				addExpectedElement(47, 72, 114);
				addExpectedElement(48, 72, 115);
				addExpectedElement(49, 72, 116);
				addExpectedElement(50, 72, 117);
				addExpectedElement(51, 72, 118);
				addExpectedElement(52, 72, 119);
				addExpectedElement(53, 72, 120);
				addExpectedElement(54, 72, 121);
				addExpectedElement(55, 72, 122);
				addExpectedElement(57, 72);
				addExpectedElement(56, 72);
				addExpectedElement(58, 72);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(46, 73, 123);
		addExpectedElement(47, 73, 124);
		addExpectedElement(48, 73, 125);
		addExpectedElement(49, 73, 126);
		addExpectedElement(50, 73, 127);
		addExpectedElement(51, 73, 128);
		addExpectedElement(52, 73, 129);
		addExpectedElement(53, 73, 130);
		addExpectedElement(54, 73, 131);
		addExpectedElement(55, 73, 132);
		addExpectedElement(57, 73);
		addExpectedElement(56, 73);
		addExpectedElement(58, 73);
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
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__CHILDREN, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(57, 74);
		addExpectedElement(56, 74);
		addExpectedElement(58, 74);
	}
	
	(
		(
			a1 = '|' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(46, 75, 133, 134);
				addExpectedElement(47, 75, 135, 136);
				addExpectedElement(48, 75, 137, 138);
				addExpectedElement(49, 75, 139, 140);
				addExpectedElement(50, 75, 141, 142);
				addExpectedElement(51, 75, 143, 144);
				addExpectedElement(52, 75, 145, 146);
				addExpectedElement(53, 75, 147, 148);
				addExpectedElement(54, 75, 149, 150);
				addExpectedElement(55, 75, 151, 152);
			}
			
			(
				a2_0 = parse_org_emftext_sdk_concretesyntax_Sequence				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__CHILDREN, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_1_0_0_3, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(57, 76);
				addExpectedElement(56, 76);
				addExpectedElement(58, 76);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(57, 77);
		addExpectedElement(56, 77);
		addExpectedElement(58, 77);
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
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_6_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 78, 153);
		addExpectedElement(47, 78, 154);
		addExpectedElement(48, 78, 155);
		addExpectedElement(49, 78, 156);
		addExpectedElement(50, 78, 157);
		addExpectedElement(51, 78, 158);
		addExpectedElement(52, 78, 159);
		addExpectedElement(53, 78, 160);
		addExpectedElement(54, 78, 161);
		addExpectedElement(55, 78, 162);
		addExpectedElement(57, 78);
		addExpectedElement(56, 78);
		addExpectedElement(58, 78);
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
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(59, 79);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(60, 80);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.ReferencableTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.ReferencableTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(61, 81);
	}
	
	a3 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(62, 82);
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a5 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a6 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 83, 163);
		addExpectedElement(47, 83, 164);
		addExpectedElement(48, 83, 165);
		addExpectedElement(49, 83, 166);
		addExpectedElement(50, 83, 167);
		addExpectedElement(51, 83, 168);
		addExpectedElement(52, 83, 169);
		addExpectedElement(53, 83, 170);
		addExpectedElement(54, 83, 171);
		addExpectedElement(55, 83, 172);
		addExpectedElement(57, 83);
		addExpectedElement(56, 83);
		addExpectedElement(58, 83);
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
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(63, 84);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(64, 85);
	}
	
	a2 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(65, 86);
	}
	
	(
		(
			a3 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a4 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a5 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 87, 173);
		addExpectedElement(47, 87, 174);
		addExpectedElement(48, 87, 175);
		addExpectedElement(49, 87, 176);
		addExpectedElement(50, 87, 177);
		addExpectedElement(51, 87, 178);
		addExpectedElement(52, 87, 179);
		addExpectedElement(53, 87, 180);
		addExpectedElement(54, 87, 181);
		addExpectedElement(55, 87, 182);
		addExpectedElement(57, 87);
		addExpectedElement(56, 87);
		addExpectedElement(58, 87);
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
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(66, 88);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(67, 89);
	}
	
	(
		a2 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(68, 90);
	}
	
	a3 = ',' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(69, 91);
	}
	
	(
		a4 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
			}
			if (a4 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(70, 92);
		addExpectedElement(71, 92);
	}
	
	(
		(
			a5 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(72, 93);
			}
			
			(
				a6 = QUOTED_39_39_92				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
					}
					if (a6 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(71, 94);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(71, 95);
	}
	
	a7 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(73, 96);
	}
	
	(
		(
			a8 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a9 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a10 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 97, 183);
		addExpectedElement(47, 97, 184);
		addExpectedElement(48, 97, 185);
		addExpectedElement(49, 97, 186);
		addExpectedElement(50, 97, 187);
		addExpectedElement(51, 97, 188);
		addExpectedElement(52, 97, 189);
		addExpectedElement(53, 97, 190);
		addExpectedElement(54, 97, 191);
		addExpectedElement(55, 97, 192);
		addExpectedElement(57, 97);
		addExpectedElement(56, 97);
		addExpectedElement(58, 97);
	}
	
;

parse_org_emftext_sdk_concretesyntax_BooleanTerminal returns [org.emftext.sdk.concretesyntax.BooleanTerminal element = null]
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
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(74, 98);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(75, 99);
	}
	
	(
		a2 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(76, 100);
	}
	
	a3 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(77, 101);
	}
	
	(
		a4 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
			}
			if (a4 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_6, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(78, 102);
	}
	
	a5 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(79, 103);
	}
	
	(
		(
			a6 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_8, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a7 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_8, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a8 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_8, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 104, 193);
		addExpectedElement(47, 104, 194);
		addExpectedElement(48, 104, 195);
		addExpectedElement(49, 104, 196);
		addExpectedElement(50, 104, 197);
		addExpectedElement(51, 104, 198);
		addExpectedElement(52, 104, 199);
		addExpectedElement(53, 104, 200);
		addExpectedElement(54, 104, 201);
		addExpectedElement(55, 104, 202);
		addExpectedElement(57, 104);
		addExpectedElement(56, 104);
		addExpectedElement(58, 104);
	}
	
;

parse_org_emftext_sdk_concretesyntax_EnumTerminal returns [org.emftext.sdk.concretesyntax.EnumTerminal element = null]
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
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(80, 105);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(81, 106, 203);
	}
	
	(
		a2_0 = parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_2, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(82, 107);
		addExpectedElement(83, 107);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(81, 108, 204);
			}
			
			(
				a4_0 = parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_3_0_0_2, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(82, 109);
				addExpectedElement(83, 109);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(82, 110);
		addExpectedElement(83, 110);
	}
	
	a5 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(84, 111);
	}
	
	(
		(
			a6 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_5, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a7 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_5, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a8 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_5, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 112, 205);
		addExpectedElement(47, 112, 206);
		addExpectedElement(48, 112, 207);
		addExpectedElement(49, 112, 208);
		addExpectedElement(50, 112, 209);
		addExpectedElement(51, 112, 210);
		addExpectedElement(52, 112, 211);
		addExpectedElement(53, 112, 212);
		addExpectedElement(54, 112, 213);
		addExpectedElement(55, 112, 214);
		addExpectedElement(57, 112);
		addExpectedElement(56, 112);
		addExpectedElement(58, 112);
	}
	
;

parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal returns [org.emftext.sdk.concretesyntax.EnumLiteralTerminal element = null]
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
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumLiteralTerminal();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__LITERAL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EEnumLiteral proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEEnumLiteral();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.EnumLiteralTerminal, org.eclipse.emf.ecore.EEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralTerminalLiteralReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__LITERAL), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(85, 113);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumLiteralTerminal();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(86, 114);
	}
	
	(
		a2 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumLiteralTerminal();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__TEXT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__TEXT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(82, 115);
		addExpectedElement(83, 115);
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
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(87, 116);
		addExpectedElement(88, 116);
	}
	
	(
		(
			a1 = ':' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(89, 117);
			}
			
			(
				a2 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
						startIncompleteElement(element);
						// initialize enumeration attribute
						Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
					}
					if (a2 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_1, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(90, 118);
				addExpectedElement(88, 118);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(91, 119);
					}
					
					(
						a4 = QUALIFIED_NAME						
						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
								startIncompleteElement(element);
								// initialize enumeration attribute
								Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
							}
							if (a4 != null) {
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
								tokenResolver.setOptions(getOptions());
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
								collectHiddenTokens(element);
								registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_2_0_0_1, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(90, 120);
						addExpectedElement(88, 120);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(90, 121);
				addExpectedElement(88, 121);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(88, 122);
	}
	
	(
		(
			a5 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a6 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a7 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 123, 215);
		addExpectedElement(47, 123, 216);
		addExpectedElement(48, 123, 217);
		addExpectedElement(49, 123, 218);
		addExpectedElement(50, 123, 219);
		addExpectedElement(51, 123, 220);
		addExpectedElement(52, 123, 221);
		addExpectedElement(53, 123, 222);
		addExpectedElement(54, 123, 223);
		addExpectedElement(55, 123, 224);
		addExpectedElement(57, 123);
		addExpectedElement(56, 123);
		addExpectedElement(58, 123);
	}
	
;

parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(46, 124, 225, 226, 227);
		addExpectedElement(47, 124, 228, 229, 230);
		addExpectedElement(48, 124, 231, 232, 233);
		addExpectedElement(49, 124, 234, 235, 236);
		addExpectedElement(50, 124, 237, 238, 239);
		addExpectedElement(51, 124, 240, 241, 242);
		addExpectedElement(52, 124, 243, 244, 245);
		addExpectedElement(53, 124, 246, 247, 248);
		addExpectedElement(54, 124, 249, 250, 251);
		addExpectedElement(55, 124, 252, 253, 254);
	}
	
	(
		a1_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CHILDREN, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(58, 125);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(92, 126);
	}
	
	(
		(
			a3 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a4 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a5 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 127, 255);
		addExpectedElement(47, 127, 256);
		addExpectedElement(48, 127, 257);
		addExpectedElement(49, 127, 258);
		addExpectedElement(50, 127, 259);
		addExpectedElement(51, 127, 260);
		addExpectedElement(52, 127, 261);
		addExpectedElement(53, 127, 262);
		addExpectedElement(54, 127, 263);
		addExpectedElement(55, 127, 264);
		addExpectedElement(57, 127);
		addExpectedElement(56, 127);
		addExpectedElement(58, 127);
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
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 128, 265);
		addExpectedElement(47, 128, 266);
		addExpectedElement(48, 128, 267);
		addExpectedElement(49, 128, 268);
		addExpectedElement(50, 128, 269);
		addExpectedElement(51, 128, 270);
		addExpectedElement(52, 128, 271);
		addExpectedElement(53, 128, 272);
		addExpectedElement(54, 128, 273);
		addExpectedElement(55, 128, 274);
		addExpectedElement(57, 128);
		addExpectedElement(56, 128);
		addExpectedElement(58, 128);
	}
	
;

parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null]
@init{
}
:
	(
		a0 = TABNUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TABNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_16_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(46, 129, 275);
		addExpectedElement(47, 129, 276);
		addExpectedElement(48, 129, 277);
		addExpectedElement(49, 129, 278);
		addExpectedElement(50, 129, 279);
		addExpectedElement(51, 129, 280);
		addExpectedElement(52, 129, 281);
		addExpectedElement(53, 129, 282);
		addExpectedElement(54, 129, 283);
		addExpectedElement(55, 129, 284);
		addExpectedElement(57, 129);
		addExpectedElement(56, 129);
		addExpectedElement(58, 129);
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenRedefinition returns [org.emftext.sdk.concretesyntax.TokenRedefinition element = null]
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
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
						startIncompleteElement(element);
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							Object value = a0_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_0_0_0_0, a0_0, true);
						copyLocalizationInfos(a0_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(0, 130, 285);
				addExpectedElement(24, 130);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(0, 131, 286);
		addExpectedElement(24, 131);
	}
	
	a1 = 'REDEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(93, 132);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.CompleteTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenRedefinition, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenRedefinitionRedefinedTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_3, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(94, 133);
	}
	
	a3 = 'AS' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(95, 134);
	}
	
	(
		a4 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_5, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(96, 135, 287);
		addExpectedElement(97, 135, 288);
	}
	
	(
		a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_7, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(98, 136);
		addExpectedElement(29, 136);
	}
	
	(
		(
			a6 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_8_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(96, 137, 289);
				addExpectedElement(97, 137, 290);
			}
			
			(
				a7_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
						startIncompleteElement(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_8_0_0_3, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(98, 138);
				addExpectedElement(29, 138);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(98, 139);
		addExpectedElement(29, 139);
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
						startIncompleteElement(element);
					}
					if (a0_0 != null) {
						if (a0_0 != null) {
							Object value = a0_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_0_0_0_0, a0_0, true);
						copyLocalizationInfos(a0_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(0, 140, 291);
				addExpectedElement(25, 140);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(0, 141, 292);
		addExpectedElement(25, 141);
	}
	
	a1 = 'DEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(99, 142);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(96, 143, 293);
		addExpectedElement(97, 143, 294);
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_5, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(100, 144);
		addExpectedElement(101, 144);
		addExpectedElement(29, 144);
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_6_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(96, 145, 295);
				addExpectedElement(97, 145, 296);
			}
			
			(
				a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_6_0_0_3, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(100, 146);
				addExpectedElement(101, 146);
				addExpectedElement(29, 146);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(100, 147);
		addExpectedElement(101, 147);
		addExpectedElement(29, 147);
	}
	
	(
		(
			a6 = 'COLLECT' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(102, 148);
			}
			
			a7 = 'IN' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(103, 149);
			}
			
			(
				a8 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
						startIncompleteElement(element);
					}
					if (a8 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_5, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(29, 150);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(29, 151);
	}
	
;

parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition returns [org.emftext.sdk.concretesyntax.PartialTokenDefinition element = null]
@init{
}
:
	a0 = 'DEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(104, 152);
	}
	
	a1 = 'FRAGMENT' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(105, 153);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(96, 154, 297);
		addExpectedElement(97, 154, 298);
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__REGEX_PARTS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_6, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(106, 155);
		addExpectedElement(29, 155);
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_7_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(96, 156, 299);
				addExpectedElement(97, 156, 300);
			}
			
			(
				a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__REGEX_PARTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_7_0_0_3, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(106, 157);
				addExpectedElement(29, 157);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(106, 158);
		addExpectedElement(29, 158);
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null]
@init{
}
:
	a0 = 'PRIORITIZE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(107, 159);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.CompleteTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(29, 160);
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
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_21_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(98, 161);
		addExpectedElement(29, 161);
		addExpectedElement(100, 161);
		addExpectedElement(101, 161);
		addExpectedElement(106, 161);
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
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.NamedTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.RegexReference, org.emftext.sdk.concretesyntax.NamedTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRegexReferenceTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_22_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(98, 162);
		addExpectedElement(29, 162);
		addExpectedElement(100, 162);
		addExpectedElement(101, 162);
		addExpectedElement(106, 162);
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
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES, value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(108, 163);
		addExpectedElement(109, 163);
	}
	
	(
		(
			a1 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(110, 164);
			}
			
			(
				a2 = STRING				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
						startIncompleteElement(element);
					}
					if (a2 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_1_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(108, 165);
				addExpectedElement(109, 165);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(108, 166);
		addExpectedElement(109, 166);
	}
	
	a3 = 'COLOR' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(111, 167);
	}
	
	(
		a4 = HEXNUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_5, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(112, 168);
		addExpectedElement(113, 168);
	}
	
	(
		(
			a5 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(114, 169);
			}
			
			(
				a6 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
						startIncompleteElement(element);
					}
					if (a6 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
						}
						org.emftext.sdk.concretesyntax.FontStyle resolved = (org.emftext.sdk.concretesyntax.FontStyle) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(112, 170);
				addExpectedElement(113, 170);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(112, 171);
		addExpectedElement(113, 171);
	}
	
	a7 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(31, 172, 301);
		addExpectedElement(32, 172);
	}
	
;

parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null]
@init{
}
:
	a0 = '@' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(115, 173);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.AnnotationType resolved = (org.emftext.sdk.concretesyntax.AnnotationType) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(116, 174);
		addExpectedElement(0, 174, 302);
		addExpectedElement(1, 174);
		addExpectedElement(2, 174);
		addExpectedElement(17, 174);
		addExpectedElement(34, 174);
		addExpectedElement(24, 174);
		addExpectedElement(25, 174);
	}
	
	(
		(
			a2 = '(' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(117, 175, 303);
			}
			
			(
				a3_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_1, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(118, 176);
				addExpectedElement(119, 176);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(117, 177, 304);
					}
					
					(
						a5_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_2_0_0_1, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(118, 178);
						addExpectedElement(119, 178);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(118, 179);
				addExpectedElement(119, 179);
			}
			
			a6 = ')' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(0, 180, 305);
				addExpectedElement(1, 180);
				addExpectedElement(2, 180);
				addExpectedElement(17, 180);
				addExpectedElement(34, 180);
				addExpectedElement(24, 180);
				addExpectedElement(25, 180);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(0, 181, 306);
		addExpectedElement(1, 181);
		addExpectedElement(2, 181);
		addExpectedElement(17, 181);
		addExpectedElement(34, 181);
		addExpectedElement(24, 181);
		addExpectedElement(25, 181);
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
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(120, 182);
		addExpectedElement(118, 182);
		addExpectedElement(119, 182);
	}
	
	(
		(
			a1 = '=' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(121, 183);
			}
			
			(
				a2 = STRING				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
						startIncompleteElement(element);
					}
					if (a2 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(118, 184);
				addExpectedElement(119, 184);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(118, 185);
		addExpectedElement(119, 185);
	}
	
;

parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_TokenRedefinition{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_CsString{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_sdk_concretesyntax_BooleanTerminal{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_sdk_concretesyntax_EnumTerminal{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_sdk_concretesyntax_Containment{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_sdk_concretesyntax_CompoundDefinition{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_sdk_concretesyntax_WhiteSpaces{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_sdk_concretesyntax_LineBreak{ element = c9; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_sdk_concretesyntax_RegexPart returns [org.emftext.sdk.concretesyntax.RegexPart element = null]
:
	c0 = parse_org_emftext_sdk_concretesyntax_AtomicRegex{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_sdk_concretesyntax_RegexReference{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

COMMENTS:
	('//'(~('\n'|'\r'))*)
	{ _channel = 99; }
;
QUALIFIED_NAME:
	(('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')*('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)*)
;
HEXNUMBER:
	('#'('0'..'9'|'A'..'F'|'a'..'f')+)
;
TABNUMBER:
	('!'('0'..'9')+)
;
STRING:
	('"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"')
;
WHITESPACE:
	((' '|'\t'|'\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n'|'\r'|'\n'))
	{ _channel = 99; }
;
QUOTED_60_62:
	(('<')(~('>'))*('>'))
;
QUOTED_39_39_92:
	(('\'')(('\\''\'')|('\\''\\')|~('\''|'\\'))*('\''))
;
QUOTED_36_36:
	(('$')(~('$'))*('$'))
;

