grammar Cs;

options {
	superClass = CsANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.sdk.concretesyntax.resource.cs.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;
}

@lexer::members {
	public List<RecognitionException> lexerExceptions  = new ArrayList<RecognitionException>();
	public List<Integer> lexerExceptionPositions = new ArrayList<Integer>();
	
	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionPositions.add(((ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.sdk.concretesyntax.resource.cs.mopp;
	
	import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.antlr.runtime3_4_0.ANTLRInputStream;
import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.CommonTokenStream;
import org.antlr.runtime3_4_0.IntStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.RecognitionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
	private List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> expectedElements = new ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected List<RecognitionException> lexerExceptions = Collections.synchronizedList(new ArrayList<RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected List<Integer> lexerExceptionPositions = Collections.synchronizedList(new ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	java.util.List<EObject> incompleteObjects = new java.util.ArrayList<EObject>();
	
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
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap;
	
	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxErrorMessageConverter syntaxErrorMessageConverter = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxErrorMessageConverter(tokenNames);
	
	@Override
	public void reportError(RecognitionException re) {
		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
	}
	
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
					public Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	protected void addErrorToResource(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocalizedMessage message) {
		if (message == null) {
			return;
		}
		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
	}
	
	public void addExpectedElement(EClass eClass, int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement terminal = org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINALS[terminalID];
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] containmentFeatures = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.LINKS[ids[i]];
		}
		org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainmentTrace containmentTrace = new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainmentTrace(eClass, containmentFeatures);
		EObject container = getLastIncompleteElement();
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
	
	protected void collectHiddenTokens(EObject element) {
	}
	
	protected void copyLocalizationInfos(final EObject source, final EObject target) {
		if (disableLocationMap) {
			return;
		}
		final org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final CommonToken source, final EObject target) {
		if (disableLocationMap) {
			return;
		}
		final org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
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
	protected void setLocalizationEnd(Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		final org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
			public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextParser createInstance(InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new CsParser(new CommonTokenStream(new CsLexer(new ANTLRInputStream(actualInputStream))));
			} else {
				return new CsParser(new CommonTokenStream(new CsLexer(new ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (IOException e) {
			new org.emftext.sdk.concretesyntax.resource.cs.util.CsRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public CsParser() {
		super(null);
	}
	
	protected EObject doParse() throws RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((CsLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((CsLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass) typeObject;
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
	
	public Object getMissingSymbol(IntStream arg0, RecognitionException arg1, int arg2, BitSet arg3) {
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
		Map<?,?> options = getOptions();
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
		// Reset parser state
		terminateParsing = false;
		postParseCommands = new ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>>();
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParseResult parseResult = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParseResult();
		if (disableLocationMap) {
			locationMap = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDevNullLocationMap();
		} else {
			locationMap = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocationMap();
		}
		// Run parser
		try {
			EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
				parseResult.setLocationMap(locationMap);
			}
		} catch (RecognitionException re) {
			addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
		} catch (IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (RecognitionException re : lexerExceptions) {
			addErrorToResource(syntaxErrorMessageConverter.translateLexicalError(re, lexerExceptions, lexerExceptionPositions));
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> parseToExpectedElements(EClass type, org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
		org.emftext.sdk.concretesyntax.resource.cs.ICsParseResult result = parse();
		for (EObject incompleteObject : incompleteObjects) {
			Lexer lexer = (Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			EObject root = result.getRoot();
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
		Set<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> currentFollowSet = new LinkedHashSet<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal>();
		List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> newFollowSet = new ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal>();
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
			CommonToken nextToken = (CommonToken) tokenStream.get(i);
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
						Collection<org.emftext.sdk.concretesyntax.resource.cs.util.CsPair<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.sdk.concretesyntax.resource.cs.util.CsPair<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[]> newFollowerPair : newFollowers) {
							org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement newFollower = newFollowerPair.getLeft();
							EObject container = getLastIncompleteElement();
							org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainmentTrace containmentTrace = new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainmentTrace(null, newFollowerPair.getRight());
							org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal newFollowTerminal = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
			CommonToken tokenAtIndex = (CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	private void startIncompleteElement(Object object) {
		if (object instanceof EObject) {
			this.incompleteObjects.add((EObject) object);
		}
	}
	
	private void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			boolean exists = this.incompleteObjects.remove(object);
			if (!exists) {
			}
		}
		if (object instanceof EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private EObject getLastIncompleteElement() {
		if (incompleteObjects.isEmpty()) {
			return null;
		}
		return incompleteObjects.get(incompleteObjects.size() - 1);
	}
	
}

start returns [ EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[1]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[2]);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[3]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[4]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[5]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[8]);
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
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[9]);
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
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[10]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_4, resolved, true);
				copyLocalizationInfos((CommonToken) a5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[11]);
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
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[12]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_8, proxy, true);
				copyLocalizationInfos((CommonToken) a7, element);
				copyLocalizationInfos((CommonToken) a7, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[15]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[16]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[19]);
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
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_9_0_0_1, resolved, true);
						copyLocalizationInfos((CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[20]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[21]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[22]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[23]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[24]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[25]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[31]);
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
				copyLocalizationInfos((CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[32]);
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
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a10).getLine(), ((CommonToken) a10).getCharPositionInLine(), ((CommonToken) a10).getStartIndex(), ((CommonToken) a10).getStopIndex());
							}
							String resolved = (String) resolvedObject;
							org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
							collectHiddenTokens(element);
							registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
							if (proxy != null) {
								Object value = proxy;
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_2_0_0_0, proxy, true);
							copyLocalizationInfos((CommonToken) a10, element);
							copyLocalizationInfos((CommonToken) a10, proxy);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[33]);
					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[34]);
					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[35]);
					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[36]);
					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[37]);
					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[38]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[39]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[40]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[41]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[42]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[43]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[44]);
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
						copyLocalizationInfos((CommonToken)a11, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[45]);
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
										addErrorToResource(result.getErrorMessage(), ((CommonToken) a12).getLine(), ((CommonToken) a12).getCharPositionInLine(), ((CommonToken) a12).getStartIndex(), ((CommonToken) a12).getStopIndex());
									}
									String resolved = (String) resolvedObject;
									org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
									collectHiddenTokens(element);
									registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
									if (proxy != null) {
										Object value = proxy;
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, value);
										completedElement(value, false);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_3_0_0_1_0_0_0, proxy, true);
									copyLocalizationInfos((CommonToken) a12, element);
									copyLocalizationInfos((CommonToken) a12, proxy);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[46]);
							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[47]);
							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[48]);
							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[49]);
							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[50]);
							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[51]);
						}
						
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[52]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[53]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[54]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[55]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[56]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[57]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[58]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[59]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[60]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[61]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[62]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[63]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[68]);
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
				copyLocalizationInfos((CommonToken)a13, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[69]);
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
				copyLocalizationInfos((CommonToken)a14, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[70]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[71]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[72]);
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
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[73]);
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[74]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[75]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[76]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[77]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[78]);
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
				copyLocalizationInfos((CommonToken)a16, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[79]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[80]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[81]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[82]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[83]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[84]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[86]);
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
				copyLocalizationInfos((CommonToken)a17, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[87]);
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
				copyLocalizationInfos((CommonToken)a18, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[88]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[89]);
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
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[90]);
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
						copyLocalizationInfos((CommonToken)a20, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[91]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[92]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[93]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[94]);
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
				copyLocalizationInfos((CommonToken)a21, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[95]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[96]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[97]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[98]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[99]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[100]);
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
				copyLocalizationInfos((CommonToken)a22, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[101]);
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
				copyLocalizationInfos((CommonToken)a23, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[102]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[103]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[104]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[105]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[106]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[107]);
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
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[108]);
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
						copyLocalizationInfos((CommonToken)a25, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[109]);
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[110]);
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[111]);
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[112]);
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[113]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[114]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[115]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[116]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[117]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[118]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[119]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[120]);
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
				copyLocalizationInfos((CommonToken)a26, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[121]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[122]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[124]);
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
				copyLocalizationInfos((CommonToken)a27, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[125]);
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
				copyLocalizationInfos((CommonToken)a28, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[126]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[127]);
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
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[128]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[129]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[130]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[131]);
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
				copyLocalizationInfos((CommonToken)a30, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[132]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[133]);
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
		copyLocalizationInfos((CommonToken)a31, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[134]);
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
		copyLocalizationInfos((CommonToken)a32, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[135]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[136]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[137]);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[138]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[139]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[140]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[143]);
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
		copyLocalizationInfos((CommonToken)a34, element);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[144]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[145]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[146]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[147]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[148]);
	}
	
	a2 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[149]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_3, proxy, true);
				copyLocalizationInfos((CommonToken) a3, element);
				copyLocalizationInfos((CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[151]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[152]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[153]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[154]);
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
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_1, resolved, true);
						copyLocalizationInfos((CommonToken) a4, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[155]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[156]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[157]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[158]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[159]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[160]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[161]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[162]);
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
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[163]);
			}
			
			a6 = 'SYNTAX' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_3, null, true);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[164]);
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
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a7).getLine(), ((CommonToken) a7).getCharPositionInLine(), ((CommonToken) a7).getStartIndex(), ((CommonToken) a7).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getImportConcreteSyntaxReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_5, proxy, true);
						copyLocalizationInfos((CommonToken) a7, element);
						copyLocalizationInfos((CommonToken) a7, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[165]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[166]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[167]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[168]);
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
									addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_6_0_0_1, resolved, true);
								copyLocalizationInfos((CommonToken) a8, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[169]);
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[170]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[171]);
					}
					
				)
				
			)?			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[172]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[173]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[174]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[175]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[177]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.OptionTypes resolved = (org.emftext.sdk.concretesyntax.OptionTypes) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[178]);
	}
	
	a1 = '=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[179]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_4, resolved, true);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[180]);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[181]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[182]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[183]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[184]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleMetaclassReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_1, proxy, true);
				copyLocalizationInfos((CommonToken) a1, element);
				copyLocalizationInfos((CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[185]);
	}
	
	a2 = '::=' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[187]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[192]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[194]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[195]);
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
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[196]);
	}
	
	a4 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[197]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[198]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[199]);
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
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[200]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[201]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[202]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[203]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[204]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[205]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[206]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[207]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[208]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[209]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[210]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[211]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[212]);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[213]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[214]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[215]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[216]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[217]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[218]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[219]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[220]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[221]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[222]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[223]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[224]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[225]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[226]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[227]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[228]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[229]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[230]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[231]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[232]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[233]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[234]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[235]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[236]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[237]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[238]);
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
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[239]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[240]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[241]);
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
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[242]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[243]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[244]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[245]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[246]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[247]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[248]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[249]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[250]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[251]);
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
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[252]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[253]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[254]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[255]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[256]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[257]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_6_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[258]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[259]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[260]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[261]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[262]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[263]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[264]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[265]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[266]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[267]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[268]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[269]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[270]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_0, proxy, true);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[271]);
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
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[272]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.ReferencableTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.ReferencableTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a2, element);
				copyLocalizationInfos((CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[273]);
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
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[274]);
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
				copyLocalizationInfos((CommonToken)a4, element);
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
				copyLocalizationInfos((CommonToken)a5, element);
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
				copyLocalizationInfos((CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[275]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[276]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[277]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[278]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[279]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[280]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[281]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[282]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[283]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[284]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[285]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[286]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[287]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_0, proxy, true);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[288]);
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
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[289]);
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
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[290]);
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
				copyLocalizationInfos((CommonToken)a3, element);
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
				copyLocalizationInfos((CommonToken)a4, element);
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
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[291]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[292]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[293]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[294]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[295]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[296]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[297]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[298]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[299]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[300]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[301]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[302]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[303]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_0, proxy, true);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[304]);
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
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[305]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_2, resolved, true);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[306]);
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
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[307]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_4, resolved, true);
				copyLocalizationInfos((CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[308]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[309]);
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
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[310]);
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
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_1, resolved, true);
						copyLocalizationInfos((CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[311]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[312]);
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
		copyLocalizationInfos((CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[313]);
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
				copyLocalizationInfos((CommonToken)a8, element);
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
				copyLocalizationInfos((CommonToken)a9, element);
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
				copyLocalizationInfos((CommonToken)a10, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[314]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[315]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[316]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[317]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[318]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[319]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[320]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[321]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[322]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[323]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[324]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[325]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[326]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_0, proxy, true);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[327]);
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
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[328]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_2, resolved, true);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[329]);
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
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[330]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_6, resolved, true);
				copyLocalizationInfos((CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[331]);
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
		copyLocalizationInfos((CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[332]);
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
				copyLocalizationInfos((CommonToken)a6, element);
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
				copyLocalizationInfos((CommonToken)a7, element);
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
				copyLocalizationInfos((CommonToken)a8, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[333]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[334]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[335]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[336]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[337]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[338]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[339]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[340]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[341]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[342]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[343]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[344]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[345]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_0, proxy, true);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[346]);
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
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[347]);
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
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[348]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[349]);
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
				copyLocalizationInfos((CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[350]);
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
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[351]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[352]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[353]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[354]);
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
		copyLocalizationInfos((CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[355]);
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
				copyLocalizationInfos((CommonToken)a6, element);
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
				copyLocalizationInfos((CommonToken)a7, element);
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
				copyLocalizationInfos((CommonToken)a8, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[356]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[357]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[358]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[359]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[360]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[361]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[362]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[363]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[364]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[365]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[366]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[367]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[368]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.ecore.EEnumLiteral proxy = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEEnumLiteral();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.EnumLiteralTerminal, org.eclipse.emf.ecore.EEnumLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEnumLiteralTerminalLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__LITERAL), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_0, proxy, true);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[369]);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumLiteralTerminal();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[370]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__TEXT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_2, resolved, true);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[371]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[372]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_0, proxy, true);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[373]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[374]);
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
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[375]);
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
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_1, proxy, true);
						copyLocalizationInfos((CommonToken) a2, element);
						copyLocalizationInfos((CommonToken) a2, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[376]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[377]);
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
						copyLocalizationInfos((CommonToken)a3, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[378]);
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
									addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
								collectHiddenTokens(element);
								registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_2_0_0_1, proxy, true);
								copyLocalizationInfos((CommonToken) a4, element);
								copyLocalizationInfos((CommonToken) a4, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[379]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[380]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[381]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[382]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[383]);
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
				copyLocalizationInfos((CommonToken)a5, element);
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
				copyLocalizationInfos((CommonToken)a6, element);
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
				copyLocalizationInfos((CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[384]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[385]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[386]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[387]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[388]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[389]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[390]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[391]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[392]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[393]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[394]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[395]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[396]);
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
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[397]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[398]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[399]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[400]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[401]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[402]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[403]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[404]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[405]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[406]);
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
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[407]);
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
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[408]);
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
				copyLocalizationInfos((CommonToken)a3, element);
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
				copyLocalizationInfos((CommonToken)a4, element);
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
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinality().getEEnumLiteral(org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[409]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[410]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[411]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[412]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[413]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[414]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[415]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[416]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[417]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[418]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[419]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[420]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[421]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[422]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[423]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[424]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[425]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[426]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[427]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[428]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[429]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[430]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[431]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[432]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[433]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[434]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_16_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[435]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[436]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[437]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[438]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[439]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[440]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[441]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[442]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[443]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[444]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[445]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[446]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[447]);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[448]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[449]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[450]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[451]);
	}
	
	a1 = 'REDEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[452]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.CompleteTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenRedefinition, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenRedefinitionRedefinedTokenReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_3, proxy, true);
				copyLocalizationInfos((CommonToken) a2, element);
				copyLocalizationInfos((CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[453]);
	}
	
	a3 = 'AS' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[454]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_5, resolved, true);
				copyLocalizationInfos((CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[455]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[456]);
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
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[457]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[458]);
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
				copyLocalizationInfos((CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[459]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[460]);
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
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[461]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[462]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[463]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[464]);
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
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[465]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[466]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[467]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[468]);
	}
	
	a1 = 'DEFINE' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[469]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_3, resolved, true);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[470]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[471]);
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
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[472]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[473]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[474]);
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
				copyLocalizationInfos((CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[475]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[476]);
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
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[477]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[478]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[479]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[480]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[481]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[482]);
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
				copyLocalizationInfos((CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[483]);
			}
			
			a7 = 'IN' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_3, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[484]);
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
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a8).getLine(), ((CommonToken) a8).getCharPositionInLine(), ((CommonToken) a8).getStartIndex(), ((CommonToken) a8).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_5, resolved, true);
						copyLocalizationInfos((CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[485]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[486]);
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
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[487]);
	}
	
	a1 = 'FRAGMENT' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[488]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_4, resolved, true);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[489]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[490]);
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
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[491]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[492]);
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
				copyLocalizationInfos((CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[493]);
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[494]);
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
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[495]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[496]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[497]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[498]);
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
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[499]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.CompleteTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a1, element);
				copyLocalizationInfos((CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[500]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_21_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[501]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[502]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[503]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[504]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[505]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.sdk.concretesyntax.NamedTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.RegexReference, org.emftext.sdk.concretesyntax.NamedTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRegexReferenceTargetReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_22_0_0_0, proxy, true);
				copyLocalizationInfos((CommonToken) a0, element);
				copyLocalizationInfos((CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[506]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[507]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[508]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[509]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[510]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES, value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[511]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[512]);
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
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[513]);
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
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_1_0_0_2, resolved, true);
						copyLocalizationInfos((CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[514]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[515]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[516]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[517]);
	}
	
	a3 = 'COLOR' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[518]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_5, resolved, true);
				copyLocalizationInfos((CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[519]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[520]);
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
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[521]);
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
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
						}
						org.emftext.sdk.concretesyntax.FontStyle resolved = (org.emftext.sdk.concretesyntax.FontStyle) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6_0_0_2, resolved, true);
						copyLocalizationInfos((CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[522]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[523]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[524]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[525]);
	}
	
	a7 = ';' {
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_7, null, true);
		copyLocalizationInfos((CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[526]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[527]);
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
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[528]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
				}
				org.emftext.sdk.concretesyntax.AnnotationType resolved = (org.emftext.sdk.concretesyntax.AnnotationType) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_1, resolved, true);
				copyLocalizationInfos((CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[529]);
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[530]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[531]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[532]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[533]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[534]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[535]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[536]);
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
				copyLocalizationInfos((CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[537]);
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
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[538]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[539]);
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
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[540]);
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
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[541]);
						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[542]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[543]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[544]);
			}
			
			a6 = ')' {
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_3, null, true);
				copyLocalizationInfos((CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[545]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[546]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[547]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[548]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[549]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[550]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[551]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[552]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[553]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[554]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[555]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[556]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[557]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[558]);
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
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[559]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[560]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[561]);
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
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[562]);
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
							addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_1, resolved, true);
						copyLocalizationInfos((CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[563]);
				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[564]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[565]);
		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[566]);
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

SL_COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
ML_COMMENT:
	('/*'.*'*/')
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
	(('\'')(('\\''\'')|('\\''\\')|(~('\''|'\\')))*('\''))
;
QUOTED_36_36:
	(('$')(~('$'))*('$'))
;

