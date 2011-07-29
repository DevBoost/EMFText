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
	public java.util.List<org.antlr.runtime3_3_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_3_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_3_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_3_0.ANTLRStringStream) input).index());
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
	protected java.util.List<org.antlr.runtime3_3_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_3_0.RecognitionException>());
	
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
	protected java.util.Stack<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
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
	
	public void addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
		if (!this.rememberExpectedElements) {
			return;
		}
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedElement = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
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
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_3_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
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
				return new CsParser(new org.antlr.runtime3_3_0.CommonTokenStream(new CsLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new CsParser(new org.antlr.runtime3_3_0.CommonTokenStream(new CsLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream, encoding))));
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
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_3_0.RecognitionException {
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
	
	public Object getMissingSymbol(org.antlr.runtime3_3_0.IntStream arg0, org.antlr.runtime3_3_0.RecognitionException arg1, int arg2, org.antlr.runtime3_3_0.BitSet arg3) {
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
		} catch (org.antlr.runtime3_3_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_3_0.RecognitionException re : lexerExceptions) {
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
		final org.antlr.runtime3_3_0.CommonTokenStream tokenStream = (org.antlr.runtime3_3_0.CommonTokenStream) getTokenStream();
		org.emftext.sdk.concretesyntax.resource.cs.ICsParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_3_0.Lexer lexer = (org.antlr.runtime3_3_0.Lexer) tokenStream.getTokenSource();
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
			org.antlr.runtime3_3_0.CommonToken nextToken = (org.antlr.runtime3_3_0.CommonToken) tokenStream.get(i);
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
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_3_0.CommonToken tokenAtIndex = (org.antlr.runtime3_3_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_3_0.IntStream input, int ttype, org.antlr.runtime3_3_0.BitSet follow) throws org.antlr.runtime3_3_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_3_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_3_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_3_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_3_0.CommonToken) {
			final org.antlr.runtime3_3_0.CommonToken ct = (org.antlr.runtime3_3_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_3_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
			org.antlr.runtime3_3_0.EarlyExitException eee = (org.antlr.runtime3_3_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedRangeException) {
			org.antlr.runtime3_3_0.MismatchedRangeException mre = (org.antlr.runtime3_3_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	protected void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			this.incompleteObjects.pop();
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 0);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 0);
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
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 1);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 2, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 2);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 2);
	}
	
	(
		(
			a1 = 'ABSTRACT' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_1, true, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 3);
	}
	
	a4 = 'SYNTAXDEF' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_3, 4);
	}
	
	(
		a5 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a5).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_4, 5);
	}
	
	a6 = 'FOR' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_5, 6);
	}
	
	(
		a7 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a7).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a7, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a7, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_6, 7);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_7, 7);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 7);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 7);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 7);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 7);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 7);
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
						incompleteObjects.push(element);
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
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a8).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_9_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_7, 8);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 8);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 8);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 8);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 8);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 8);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_7, 9);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 9);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 9);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 9);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 9);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 9);
	}
	
	(
		(
			a9 = 'START' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_13, 10);
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
							incompleteObjects.push(element);
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
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a10).getStopIndex());
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
							copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a10, element);
							copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a10, proxy);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 11);
					addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 11);
					addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 11);
					addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 11);
					addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 11);
					addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 11);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 12);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 12);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 12);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 12);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 12);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 12);
			}
			
			(
				(
					a11 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							incompleteObjects.push(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
							}
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_3_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_15, 13);
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
									incompleteObjects.push(element);
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
										addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a12).getStopIndex());
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
									copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a12, element);
									copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a12, proxy);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 14);
							addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 14);
							addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 14);
							addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 14);
							addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 14);
							addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 14);
						}
						
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 15);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 15);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 15);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 15);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 15);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 15);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 16);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 16);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 16);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 16);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 16);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 16);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 17);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 17);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 17);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 17);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 17);
	}
	
	(
		(
			a13 = 'IMPORTS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a13, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_16, 18);
			}
			
			a14 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a14, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 19, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 19, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 19);
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
								incompleteObjects.push(element);
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
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 20, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 20, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 20);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 21, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 21, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 21);
			}
			
			a16 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a16, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 22);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 22);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 22);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 22);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 23);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 23);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 23);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 23);
	}
	
	(
		(
			a17 = 'OPTIONS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a17, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_19, 24);
			}
			
			a18 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a18, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_20, 25, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_21, 25);
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
								incompleteObjects.push(element);
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
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_22, 26);
					}
					
					a20 = ';' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							incompleteObjects.push(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
							}
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_5_0_0_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a20, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_20, 27, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_21, 27);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_20, 28, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_21, 28);
			}
			
			a21 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a21, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 29);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 29);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 29);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 30);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 30);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 30);
	}
	
	(
		(
			a22 = 'TOKENS' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a22, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_23, 31);
			}
			
			a23 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a23, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 32, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 32, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 32, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_26, 32, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_27, 32, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 32);
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
								incompleteObjects.push(element);
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
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 33);
					}
					
					a25 = ';' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							incompleteObjects.push(element);
							// initialize boolean attribute
							{
								Object value = false;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
							}
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_5_0_0_2, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a25, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 34, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 34, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 34, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_26, 34, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_27, 34, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 34);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_26, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_27, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 35);
			}
			
			a26 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a26, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 36);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 36);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 37);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 37);
	}
	
	(
		(
			a27 = 'TOKENSTYLES' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a27, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_30, 38);
			}
			
			a28 = '{' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a28, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 39, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_32, 39);
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
								incompleteObjects.push(element);
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
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 40, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_32, 40);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 41, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_32, 41);
			}
			
			a30 = '}' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					incompleteObjects.push(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a30, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 42);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 43);
	}
	
	a31 = 'RULES' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_18, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a31, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 44);
	}
	
	a32 = '{' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_20, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a32, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 45, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 45, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_35, 45);
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
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 46, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 46, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_35, 46);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 47, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 47, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_35, 47);
	}
	
	a34 = '}' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			incompleteObjects.push(element);
			// initialize boolean attribute
			{
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
			}
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_23, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a34, element);
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
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 49, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 49);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 50, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 50);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_36, 51);
	}
	
	a2 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_37, 52);
	}
	
	(
		a3 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a3).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_38, 53);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_39, 53);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 53, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 53, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 53);
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
						incompleteObjects.push(element);
					}
					if (a4 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_39, 54);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 54, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 54, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 54);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_39, 55);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 55, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 55, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 55);
	}
	
	(
		(
			a5 = 'WITH' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_40, 56);
			}
			
			a6 = 'SYNTAX' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_41, 57);
			}
			
			(
				a7 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
						incompleteObjects.push(element);
					}
					if (a7 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a7).getStopIndex());
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
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a7, element);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a7, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_42, 58);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 58, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 58, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 58);
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
								incompleteObjects.push(element);
							}
							if (a8 != null) {
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
								tokenResolver.setOptions(getOptions());
								org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a8).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_6_0_0_1, resolved, true);
								copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a8, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 59, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 59, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 59);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 60, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 60, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 60);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 61, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 61, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 61);
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
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.OptionTypes resolved = (org.emftext.sdk.concretesyntax.OptionTypes) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_43, 62);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_44, 63);
	}
	
	(
		a2 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_22, 64);
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
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 65, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 65);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 66, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 66);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 67);
	}
	
	a2 = '::=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 68, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
				incompleteObjects.push(element);
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
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 69);
	}
	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 70, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_35, 70);
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
				incompleteObjects.push(element);
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
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 71, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 71);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 71);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 71);
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
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 72, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 72);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 72);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 72);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 73, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 73);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 73);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 73);
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
				incompleteObjects.push(element);
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
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 74);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 74);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 74);
	}
	
	(
		(
			a1 = '|' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 75, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
			}
			
			(
				a2_0 = parse_org_emftext_sdk_concretesyntax_Sequence				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 76);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 76);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 76);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 77);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 77);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 77);
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
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_6_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 78, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 78);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 78);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 78);
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
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_59, 79);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_60, 80);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_61, 81);
	}
	
	a3 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_62, 82);
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a5 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a6 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 83, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 83);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 83);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 83);
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
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_63, 84);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_64, 85);
	}
	
	a2 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_65, 86);
	}
	
	(
		(
			a3 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a4 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a5 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 87, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 87);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 87);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 87);
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
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_66, 88);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_67, 89);
	}
	
	(
		a2 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_68, 90);
	}
	
	a3 = ',' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_69, 91);
	}
	
	(
		a4 = QUOTED_39_39_92		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_70, 92);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_71, 92);
	}
	
	(
		(
			a5 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_72, 93);
			}
			
			(
				a6 = QUOTED_39_39_92				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
						incompleteObjects.push(element);
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
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_71, 94);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_71, 95);
	}
	
	a7 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_73, 96);
	}
	
	(
		(
			a8 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a8, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a9 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a10 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a10, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 97, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 97);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 97);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 97);
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
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_74, 98);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_75, 99);
	}
	
	(
		a2 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_76, 100);
	}
	
	a3 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_77, 101);
	}
	
	(
		a4 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_6, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 102);
	}
	
	a5 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 103);
	}
	
	(
		(
			a6 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_8, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a7 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_8, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a8 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createBooleanTerminal();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_8, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a8, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 104, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 104);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 104);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 104);
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
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_80, 105);
	}
	
	a1 = '[' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_81, 106, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7);
	}
	
	(
		a2_0 = parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
				incompleteObjects.push(element);
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
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_82, 107);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_83, 107);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_81, 108, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7);
			}
			
			(
				a4_0 = parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_82, 109);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_83, 109);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_82, 110);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_83, 110);
	}
	
	a5 = ']' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_84, 111);
	}
	
	(
		(
			a6 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_5, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a7 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_5, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a8 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumTerminal();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_5, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a8, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 112);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 112);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 112);
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
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__LITERAL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_85, 113);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumLiteralTerminal();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_86, 114);
	}
	
	(
		a2 = STRING		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumLiteralTerminal();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__TEXT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__TEXT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_82, 115);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_83, 115);
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
				incompleteObjects.push(element);
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
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_87, 116);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_88, 116);
	}
	
	(
		(
			a1 = ':' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_89, 117);
			}
			
			(
				a2 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
						incompleteObjects.push(element);
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
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
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
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_90, 118);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_88, 118);
			}
			
			(
				(
					a3 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
							incompleteObjects.push(element);
							// initialize enumeration attribute
							Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_91, 119);
					}
					
					(
						a4 = QUALIFIED_NAME						
						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
								incompleteObjects.push(element);
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
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
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
								copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
								copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_90, 120);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_88, 120);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_90, 121);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_88, 121);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_88, 122);
	}
	
	(
		(
			a5 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a6 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a7 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 123);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 123);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 123);
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
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 124, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
	}
	
	(
		a1_0 = parse_org_emftext_sdk_concretesyntax_Choice		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
				incompleteObjects.push(element);
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
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 125);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
			incompleteObjects.push(element);
			// initialize enumeration attribute
			Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_92, 126);
	}
	
	(
		(
			a3 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a4 = '*' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				completedElement(value, false);
			}
			|			a5 = '?' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
					incompleteObjects.push(element);
					// initialize enumeration attribute
					Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.NONE_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 127, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 127);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 127);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 127);
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
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 128, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 128);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 128);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 128);
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
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TABNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_16_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 129, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 129);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 129);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 129);
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
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 130, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 130);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 131, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 131);
	}
	
	a1 = 'REDEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_93, 132);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_94, 133);
	}
	
	a3 = 'AS' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 134);
	}
	
	(
		a4 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
				incompleteObjects.push(element);
			}
			if (a4 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_5, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_97, 135, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
	}
	
	(
		a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
				incompleteObjects.push(element);
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
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_98, 136);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 136);
	}
	
	(
		(
			a6 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_8_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 137, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_97, 137, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
			}
			
			(
				a7_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_98, 138);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 138);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_98, 139);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 139);
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
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 140, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 140);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 141, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 141);
	}
	
	a1 = 'DEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_99, 142);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 143, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_97, 143, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				incompleteObjects.push(element);
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
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_100, 144);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_101, 144);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 144);
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_6_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 145, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_97, 145, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
			}
			
			(
				a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_100, 146);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_101, 146);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 146);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_100, 147);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_101, 147);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 147);
	}
	
	(
		(
			a6 = 'COLLECT' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_102, 148);
			}
			
			a7 = 'IN' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_103, 149);
			}
			
			(
				a8 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
						incompleteObjects.push(element);
					}
					if (a8 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a8).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_5, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 150);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 151);
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
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_104, 152);
	}
	
	a1 = 'FRAGMENT' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_105, 153);
	}
	
	(
		a2 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 154, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_97, 154, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
	}
	
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_RegexPart		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				incompleteObjects.push(element);
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
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_106, 155);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 155);
	}
	
	(
		(
			a4 = '+' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_7_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 156, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_97, 156, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_8);
			}
			
			(
				a5_0 = parse_org_emftext_sdk_concretesyntax_RegexPart				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_106, 157);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 157);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_106, 158);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 158);
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
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_107, 159);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 160);
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
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_21_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_98, 161);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 161);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_100, 161);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_101, 161);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_106, 161);
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
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
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
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_98, 162);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 162);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_100, 162);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_101, 162);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_106, 162);
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
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES, value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_108, 163);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_109, 163);
	}
	
	(
		(
			a1 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_110, 164);
			}
			
			(
				a2 = STRING				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
						incompleteObjects.push(element);
					}
					if (a2 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_1_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_108, 165);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_109, 165);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_108, 166);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_109, 166);
	}
	
	a3 = 'COLOR' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_111, 167);
	}
	
	(
		a4 = HEXNUMBER		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
				incompleteObjects.push(element);
			}
			if (a4 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_5, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_112, 168);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_113, 168);
	}
	
	(
		(
			a5 = ',' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_114, 169);
			}
			
			(
				a6 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
						incompleteObjects.push(element);
					}
					if (a6 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a6).getStopIndex());
						}
						org.emftext.sdk.concretesyntax.FontStyle resolved = (org.emftext.sdk.concretesyntax.FontStyle) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_112, 170);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_113, 170);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_112, 171);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_113, 171);
	}
	
	a7 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 172, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_32, 172);
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
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_115, 173);
	}
	
	(
		a1 = QUALIFIED_NAME		
		{
			if (terminateParsing) {
				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.AnnotationType resolved = (org.emftext.sdk.concretesyntax.AnnotationType) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_116, 174);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 174, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 174);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 174);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 174);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 174);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 174);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 174);
	}
	
	(
		(
			a2 = '(' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_117, 175, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9);
			}
			
			(
				a3_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
						incompleteObjects.push(element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_118, 176);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_119, 176);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_117, 177, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9);
					}
					
					(
						a5_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair						{
							if (terminateParsing) {
								throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
								incompleteObjects.push(element);
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
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_118, 178);
						addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_119, 178);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_118, 179);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_119, 179);
			}
			
			a6 = ')' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 180, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 180);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 180);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 180);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 180);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 180);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 180);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 181, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 181);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 181);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 181);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 181);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 181);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 181);
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
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_120, 182);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_118, 182);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_119, 182);
	}
	
	(
		(
			a1 = '=' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_121, 183);
			}
			
			(
				a2 = STRING				
				{
					if (terminateParsing) {
						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
						incompleteObjects.push(element);
					}
					if (a2 != null) {
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING");
						tokenResolver.setOptions(getOptions());
						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_118, 184);
				addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_119, 184);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_118, 185);
		addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_119, 185);
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

