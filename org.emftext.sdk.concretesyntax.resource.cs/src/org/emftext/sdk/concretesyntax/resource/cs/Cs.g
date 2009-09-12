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
	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new org.emftext.sdk.concretesyntax.resource.cs.CsTokenResolverFactory();
	private int lastPosition;
	private org.emftext.sdk.concretesyntax.resource.cs.CsTokenResolveResult tokenResolveResult = new org.emftext.sdk.concretesyntax.resource.cs.CsTokenResolveResult();
	private boolean rememberExpectedElements = false;
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	private boolean reachedIndex = false;
	private java.util.List<org.emftext.runtime.resource.IExpectedElement> expectedElements = new java.util.ArrayList<org.emftext.runtime.resource.IExpectedElement>();
	private int lastIndex = -1;
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	//helper lists to allow a lexer to pass errors to its parser
	protected java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime.RecognitionException>());
	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private java.util.Collection<org.emftext.runtime.resource.ICommand<org.emftext.runtime.resource.ITextResource>> postParseCommands;
	private boolean terminateParsing;
	
	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.runtime.resource.ICommand<org.emftext.runtime.resource.ITextResource>() {
			public boolean execute(org.emftext.runtime.resource.ITextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for
					// code completion
					return true;
				}
				resource.addProblem(new org.emftext.runtime.resource.impl.AbstractProblem() {
					public org.emftext.runtime.resource.EProblemType getType() {
						return org.emftext.runtime.resource.EProblemType.ERROR;
					}
					public java.lang.String getMessage() {
						return errorMessage;
					}
				}, line, charPositionInLine, startIndex, stopIndex);
				return true;
			}
		}
	);
}

public void addExpectedElement(org.emftext.runtime.resource.IExpectedElement expectedElement, java.lang.String message) {
	if (!this.rememberExpectedElements) {
		return;
	}
	if (this.reachedIndex) {
		return;
	}
	int currentIndex = java.lang.Math.max(0, input.index());
	//System.out.println("addExpectedElement() currentIndex = " + currentIndex);
	for (int index = lastTokenIndex; index < currentIndex; index++) {
		//System.out.println("addExpectedElement() index = " + index);
		if (index >= input.size()) {
			break;
		}
		org.antlr.runtime.CommonToken tokenAtIndex = (org.antlr.runtime.CommonToken) input.get(index);
		//System.out.println("addExpectedElement() tokenAtIndex = " + tokenAtIndex);
		stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
		if (tokenAtIndex.getChannel() != 99) {
			stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
		}
	}
	lastTokenIndex = java.lang.Math.max(0, currentIndex);
	expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	System.out.println("Adding expected element (" + message + "): " + expectedElement + "");
	this.expectedElements.add(expectedElement);
}

protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.sdk.concretesyntax.resource.cs.CsDummyEObject dummy) {
	java.lang.Object value = element.eGet(structuralFeature);
	java.lang.Object mapKey = dummy.getValueByName("key");
	java.lang.Object mapValue = dummy.getValueByName("value");
	if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
		org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.runtime.util.MapUtil.castToEMap(value);
		if (mapKey != null && mapValue != null) {
			valueMap.put(mapKey, mapValue);
		}
	}
}

private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
	return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
}

protected org.eclipse.emf.ecore.EObject apply(org.eclipse.emf.ecore.EObject target, java.util.List<org.eclipse.emf.ecore.EObject> dummyEObjects) {
	org.eclipse.emf.ecore.EObject currentTarget = target;
	for (org.eclipse.emf.ecore.EObject object : dummyEObjects) {
		assert(object instanceof org.emftext.sdk.concretesyntax.resource.cs.CsDummyEObject);
		org.emftext.sdk.concretesyntax.resource.cs.CsDummyEObject dummy = (org.emftext.sdk.concretesyntax.resource.cs.CsDummyEObject) object;
		org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
		currentTarget = newEObject;
	}
	return currentTarget;
}
protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
}

protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
	postParseCommands.add(new org.emftext.runtime.resource.ICommand<org.emftext.runtime.resource.ITextResource>() {
		public boolean execute(org.emftext.runtime.resource.ITextResource resource) {
			if (resource == null) {
				// the resource can be null if the parser is used for
				// code completion
				return true;
			}
			org.emftext.runtime.resource.ILocationMap locationMap = resource.getLocationMap();
			locationMap.setCharStart(target, locationMap.getCharStart(source));
			locationMap.setCharEnd(target, locationMap.getCharEnd(source));
			locationMap.setColumn(target, locationMap.getColumn(source));
			locationMap.setLine(target, locationMap.getLine(source));
			return true;
		}
	});
}

protected void copyLocalizationInfos(final org.antlr.runtime.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
	postParseCommands.add(new org.emftext.runtime.resource.ICommand<org.emftext.runtime.resource.ITextResource>() {
		public boolean execute(org.emftext.runtime.resource.ITextResource resource) {
			if (resource == null) {
				// the resource can be null if the parser is used for
				// code completion
				return true;
			}
			org.emftext.runtime.resource.ILocationMap locationMap = resource.getLocationMap();
			locationMap.setCharStart(target, source.getStartIndex());
			locationMap.setCharEnd(target, source.getStopIndex());
			locationMap.setColumn(target, source.getCharPositionInLine());
			locationMap.setLine(target, source.getLine());
			return true;
		}
	});
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

// This default constructor is only used to call createInstance() on it
public CsParser() {
	super(null);
}

protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime.RecognitionException {
	lastPosition = 0;
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

private org.emftext.sdk.concretesyntax.resource.cs.CsTokenResolveResult getFreshTokenResolveResult() {
	tokenResolveResult.clear();
	return tokenResolveResult;
}

public int getMismatchedTokenRecoveryTries() {
	return mismatchedTokenRecoveryTries;
}

public java.lang.Object getMissingSymbol(org.antlr.runtime.IntStream arg0, org.antlr.runtime.RecognitionException arg1, int arg2, org.antlr.runtime.BitSet arg3) {
	mismatchedTokenRecoveryTries++;
	return super.getMissingSymbol(arg0, arg1, arg2, arg3);
}

protected java.util.Map<?,?> getOptions() {
	return options;
}

public org.emftext.runtime.resource.ITextResourcePluginMetaInformation getMetaInformation() {
	return new org.emftext.sdk.concretesyntax.resource.cs.CsMetaInformation();
}
public java.lang.Object getParseToIndexTypeObject() {
	return parseToIndexTypeObject;
}

protected org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch getReferenceResolverSwitch() {
	return (org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
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

// Implementation that calls {@link #doParse()}  and handles the thrown
// RecognitionExceptions.
public org.emftext.runtime.resource.IParseResult parse() {
	terminateParsing = false;
	postParseCommands = new java.util.ArrayList<org.emftext.runtime.resource.ICommand<org.emftext.runtime.resource.ITextResource>>();
	try {
		org.emftext.sdk.concretesyntax.resource.cs.CsParseResult parseResult = new org.emftext.sdk.concretesyntax.resource.cs.CsParseResult();
		org.eclipse.emf.ecore.EObject result =  doParse();
		if (lexerExceptions.isEmpty()) {
			parseResult.setRoot(result);
			parseResult.getPostParseCommands().addAll(postParseCommands);
			return parseResult;
		}
	} catch (org.antlr.runtime.RecognitionException re) {
		reportError(re);
	} catch (java.lang.IllegalArgumentException iae) {
		if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
			//? can be caused if a null is set on EMF models where not allowed;
			//? this will just happen if other errors occurred before
		} else {
			iae.printStackTrace();
		}
	}
	for (org.antlr.runtime.RecognitionException re : lexerExceptions) {
		reportLexicalError(re);
	}
	return null;
}

public java.util.List<org.emftext.runtime.resource.IExpectedElement> parseToExpectedElements(org.eclipse.emf.ecore.EClass type) {
	rememberExpectedElements = true;
	parseToIndexTypeObject = type;
	parse();
	return this.expectedElements;
}

public java.lang.Object recoverFromMismatchedToken(org.antlr.runtime.IntStream input, int ttype, org.antlr.runtime.BitSet follow) throws org.antlr.runtime.RecognitionException {
	if (!rememberExpectedElements) {
		return super.recoverFromMismatchedToken(input, ttype, follow);
	} else {
		return null;
	}
}
protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
	postParseCommands.add(new org.emftext.runtime.resource.ICommand<org.emftext.runtime.resource.ITextResource>() {
		public boolean execute(org.emftext.runtime.resource.ITextResource resource) {
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
public void reportError(final org.antlr.runtime.RecognitionException e)  {
	java.lang.String message = e.getMessage();
	if (e instanceof org.antlr.runtime.MismatchedTokenException) {
		org.antlr.runtime.MismatchedTokenException mte = (org.antlr.runtime.MismatchedTokenException) e;
		java.lang.String tokenName = "<unknown>";
		if (mte.expecting == Token.EOF) {
			tokenName = "EOF";
		} else {
			tokenName = getTokenNames()[mte.expecting];
			tokenName = org.emftext.runtime.util.StringUtil.formatTokenName(tokenName);
		}
		message = "Syntax error on token \"" + e.token.getText() + "\", \"" + tokenName + "\" expected";
	} else if (e instanceof org.antlr.runtime.MismatchedTreeNodeException) {
		org.antlr.runtime.MismatchedTreeNodeException mtne = (org.antlr.runtime.MismatchedTreeNodeException) e;
		java.lang.String tokenName = "<unknown>";
		if (mtne.expecting == Token.EOF) {
			tokenName = "EOF";
		} else {
			tokenName = getTokenNames()[mtne.expecting];
		}
		message = "mismatched tree node: "+"xxx" +"; expecting " + tokenName;
	} else if (e instanceof org.antlr.runtime.NoViableAltException) {
		message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
	} else if (e instanceof org.antlr.runtime.EarlyExitException) {
		message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
	} else if (e instanceof org.antlr.runtime.MismatchedSetException) {
		org.antlr.runtime.MismatchedSetException mse = (org.antlr.runtime.MismatchedSetException) e;
		message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
	} else if (e instanceof org.antlr.runtime.MismatchedNotSetException) {
		org.antlr.runtime.MismatchedNotSetException mse = (org.antlr.runtime.MismatchedNotSetException) e;
		message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
	} else if (e instanceof org.antlr.runtime.FailedPredicateException) {
		org.antlr.runtime.FailedPredicateException fpe = (org.antlr.runtime.FailedPredicateException) e;
		message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText+"}?";
	}
	// the resource may be null if the parse is used for code completion
	final java.lang.String finalMessage = message;
	if (e.token instanceof org.antlr.runtime.CommonToken) {
		final org.antlr.runtime.CommonToken ct = (org.antlr.runtime.CommonToken) e.token;
		addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
	} else {
		addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5); // TODO what the heck is this 5?
	}
}

// Translates errors thrown by the lexer into human readable messages.
public void reportLexicalError(final org.antlr.runtime.RecognitionException e)  {
	java.lang.String message = "";
	if (e instanceof org.antlr.runtime.MismatchedTokenException) {
		org.antlr.runtime.MismatchedTokenException mte = (org.antlr.runtime.MismatchedTokenException) e;
		message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
	} else if (e instanceof org.antlr.runtime.NoViableAltException) {
		message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
	} else if (e instanceof org.antlr.runtime.EarlyExitException) {
		org.antlr.runtime.EarlyExitException eee = (org.antlr.runtime.EarlyExitException) e;
		message ="required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
	} else if (e instanceof org.antlr.runtime.MismatchedSetException) {
		org.antlr.runtime.MismatchedSetException mse = (org.antlr.runtime.MismatchedSetException) e;
		message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
	} else if (e instanceof org.antlr.runtime.MismatchedNotSetException) {
		org.antlr.runtime.MismatchedNotSetException mse = (org.antlr.runtime.MismatchedNotSetException) e;
		message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
	} else if (e instanceof org.antlr.runtime.MismatchedRangeException) {
		org.antlr.runtime.MismatchedRangeException mre = (org.antlr.runtime.MismatchedRangeException) e;
		message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
	} else if (e instanceof org.antlr.runtime.FailedPredicateException) {
		org.antlr.runtime.FailedPredicateException fpe = (org.antlr.runtime.FailedPredicateException) e;
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
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
{
}
(
	{
	}
	c0 = parse_org_emftext_sdk_concretesyntax_ConcreteSyntax{ element = c0; }
)
EOF
;

parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null]
@init{
}
:
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a Terminal
		}
		(
			a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				if (a0_0 != null) {
					if (a0_0 != null) {
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS, a0_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a0_0, element); 				}
			}
		)
		
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a1_0 = parse_org_emftext_sdk_concretesyntax_Abstract		{
			if (terminateParsing) {
				throw new org.emftext.runtime.resource.impl.TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER), a1_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a1_0, element); 			}
		}
	)
	
)?
{
	// expected element is a CsString
}
a2 = 'SYNTAXDEF' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a2, element);
}

{
	// expected element is a Terminal
}
(
	a3 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
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

{
	// expected element is a CsString
}
a4 = 'FOR' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a4, element);
}

{
	// expected element is a Terminal
}
(
	a5 = QUOTED_60_62	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
		}
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
			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a5, element);
			copyLocalizationInfos((CommonToken) a5, proxy);
		}
	}
)

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a Terminal
		}
		(
			a6 = QUOTED_60_62			
			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
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
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a7 = 'START' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a7, element);
		}
		
		{
			// expected element is a Compound
		}
		(
			{
				// expected element is a Terminal
			}
			(
				a8 = QUALIFIED_NAME				
				{
					if (terminateParsing) {
						throw new org.emftext.runtime.resource.impl.TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
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
						registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
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
		
		{
			// expected element before STAR or QUESTIONMARK or PLUS
		}
		(
			{
				// expected element is a Compound
			}
			(
				{
					// expected element is a CsString
				}
				a9 = ',' {
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a9, element);
				}
				
				{
					// expected element is a Compound
				}
				(
					{
						// expected element is a Terminal
					}
					(
						a10 = QUALIFIED_NAME						
						{
							if (terminateParsing) {
								throw new org.emftext.runtime.resource.impl.TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
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
								registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
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
			
		)*		{
			// expected element after STAR or PLUS
		}
		
	)
	
)?
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a11 = 'IMPORTS' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a11, element);
		}
		
		{
			// expected element is a CsString
		}
		a12 = '{' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a12, element);
		}
		
		{
			// expected element before STAR or QUESTIONMARK or PLUS
		}
		(
			{
				// expected element is a Compound
			}
			(
				{
					// expected element is a Terminal
				}
				(
					a13_0 = parse_org_emftext_sdk_concretesyntax_Import					{
						if (terminateParsing) {
							throw new org.emftext.runtime.resource.impl.TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						if (a13_0 != null) {
							if (a13_0 != null) {
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS, a13_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a13_0, element); 						}
					}
				)
				
			)
			
		)*		{
			// expected element after STAR or PLUS
		}
		
		{
			// expected element is a CsString
		}
		a14 = '}' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a14, element);
		}
		
	)
	
)?
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a15 = 'OPTIONS' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a15, element);
		}
		
		{
			// expected element is a CsString
		}
		a16 = '{' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a16, element);
		}
		
		{
			// expected element before STAR or QUESTIONMARK or PLUS
		}
		(
			{
				// expected element is a Compound
			}
			(
				{
					// expected element is a Terminal
				}
				(
					a17_0 = parse_org_emftext_sdk_concretesyntax_Option					{
						if (terminateParsing) {
							throw new org.emftext.runtime.resource.impl.TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						if (a17_0 != null) {
							if (a17_0 != null) {
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS, a17_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a17_0, element); 						}
					}
				)
				
				{
					// expected element is a CsString
				}
				a18 = ';' {
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a18, element);
				}
				
			)
			
		)*		{
			// expected element after STAR or PLUS
		}
		
		{
			// expected element is a CsString
		}
		a19 = '}' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a19, element);
		}
		
	)
	
)?
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a20 = 'TOKENS' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a20, element);
		}
		
		{
			// expected element is a CsString
		}
		a21 = '{' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a21, element);
		}
		
		{
			// expected element before STAR or QUESTIONMARK or PLUS
		}
		(
			{
				// expected element is a Compound
			}
			(
				{
					// expected element is a Terminal
				}
				(
					a22_0 = parse_org_emftext_sdk_concretesyntax_TokenDirective					{
						if (terminateParsing) {
							throw new org.emftext.runtime.resource.impl.TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						if (a22_0 != null) {
							if (a22_0 != null) {
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS, a22_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a22_0, element); 						}
					}
				)
				
				{
					// expected element is a CsString
				}
				a23 = ';' {
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a23, element);
				}
				
			)
			
		)*		{
			// expected element after STAR or PLUS
		}
		
		{
			// expected element is a CsString
		}
		a24 = '}' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a24, element);
		}
		
	)
	
)?
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a25 = 'TOKENSTYLES' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a25, element);
		}
		
		{
			// expected element is a CsString
		}
		a26 = '{' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a26, element);
		}
		
		{
			// expected element before STAR or QUESTIONMARK or PLUS
		}
		(
			{
				// expected element is a Compound
			}
			(
				{
					// expected element is a Terminal
				}
				(
					a27_0 = parse_org_emftext_sdk_concretesyntax_TokenStyle					{
						if (terminateParsing) {
							throw new org.emftext.runtime.resource.impl.TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
						}
						if (a27_0 != null) {
							if (a27_0 != null) {
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES, a27_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a27_0, element); 						}
					}
				)
				
			)
			
		)*		{
			// expected element after STAR or PLUS
		}
		
		{
			// expected element is a CsString
		}
		a28 = '}' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a28, element);
		}
		
	)
	
)?
{
	// expected element is a CsString
}
a29 = 'RULES' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a29, element);
}

{
	// expected element is a CsString
}
a30 = '{' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a30, element);
}

{
	// expected element is a Compound
}
(
	{
		// expected element before STAR or QUESTIONMARK or PLUS
	}
	(
		{
			// expected element is a Terminal
		}
		(
			a31_0 = parse_org_emftext_sdk_concretesyntax_Rule			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
				}
				if (a31_0 != null) {
					if (a31_0 != null) {
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, a31_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a31_0, element); 				}
			}
		)
		
	)*	{
		// expected element after STAR or PLUS
	}
	
)

{
	// expected element is a CsString
}
a32 = '}' {
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
{
	// expected element is a Terminal
}
(
	a0 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
		}
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

{
	// expected element is a CsString
}
a1 = ':' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a1, element);
}

{
	// expected element is a Terminal
}
(
	a2 = QUOTED_60_62	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
		}
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
			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a2, element);
			copyLocalizationInfos((CommonToken) a2, proxy);
		}
	}
)

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a Terminal
		}
		(
			a3 = QUOTED_60_62			
			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				}
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
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a4 = 'WITH' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a4, element);
		}
		
		{
			// expected element is a CsString
		}
		a5 = 'SYNTAX' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a5, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a6 = QUALIFIED_NAME			
			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
				}
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
					registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getImportConcreteSyntaxReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
					if (proxy != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), proxy);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a6, element);
					copyLocalizationInfos((CommonToken) a6, proxy);
				}
			}
		)
		
		{
			// expected element before STAR or QUESTIONMARK or PLUS
		}
		(
			{
				// expected element is a Compound
			}
			(
				{
					// expected element is a Terminal
				}
				(
					a7 = QUOTED_60_62					
					{
						if (terminateParsing) {
							throw new org.emftext.runtime.resource.impl.TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
						}
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
{
	// expected element is a Terminal
}
(
	a0 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
		}
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

{
	// expected element is a CsString
}
a1 = '=' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a1, element);
}

{
	// expected element is a Terminal
}
(
	a2 = QUOTED_34_34_92	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
		}
		if (a2 != null) {
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
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
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a Terminal
		}
		(
			a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
				}
				if (a0_0 != null) {
					if (a0_0 != null) {
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__ANNOTATIONS, a0_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a0_0, element); 				}
			}
		)
		
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element is a Terminal
}
(
	a1 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
		}
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
			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleMetaclassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a1, element);
			copyLocalizationInfos((CommonToken) a1, proxy);
		}
	}
)

{
	// expected element is a CsString
}
a2 = '::=' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a2, element);
}

{
	// expected element is a Terminal
}
(
	a3_0 = parse_org_emftext_sdk_concretesyntax_Choice	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
		}
		if (a3_0 != null) {
			if (a3_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), a3_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a3_0, element); 		}
	}
)

{
	// expected element is a CsString
}
a4 = ';' {
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
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a0_0 = parse_org_emftext_sdk_concretesyntax_Definition		{
			if (terminateParsing) {
				throw new org.emftext.runtime.resource.impl.TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSequence();
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS, a0_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a0_0, element); 			}
		}
	)
	
)+{
	// expected element after STAR or PLUS
}

;

parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0_0 = parse_org_emftext_sdk_concretesyntax_Sequence	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
		}
		if (a0_0 != null) {
			if (a0_0 != null) {
				addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a0_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a0_0, element); 		}
	}
)

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a1 = '|' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a1, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a2_0 = parse_org_emftext_sdk_concretesyntax_Sequence			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a2_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a2_0, element); 				}
			}
		)
		
	)
	
)*{
	// expected element after STAR or PLUS
}

;

parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0 = QUOTED_34_34_92	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCsString();
		}
		if (a0 != null) {
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
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
{
	// expected element is a Terminal
}
(
	a0 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
		}
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
			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
			copyLocalizationInfos((CommonToken) a0, proxy);
		}
	}
)

{
	// expected element is a CsString
}
a1 = '[' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a1, element);
}

{
	// expected element is a Terminal
}
(
	a2 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
		}
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
			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.TokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a2, element);
			copyLocalizationInfos((CommonToken) a2, proxy);
		}
	}
)

{
	// expected element is a CsString
}
a3 = ']' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a3, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a4_0 = parse_org_emftext_sdk_concretesyntax_Cardinality		{
			if (terminateParsing) {
				throw new org.emftext.runtime.resource.impl.TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), a4_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a4_0, element); 			}
		}
	)
	
)?
;

parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
		}
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
			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
			copyLocalizationInfos((CommonToken) a0, proxy);
		}
	}
)

{
	// expected element is a CsString
}
a1 = '[' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a1, element);
}

{
	// expected element is a CsString
}
a2 = ']' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a2, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality		{
			if (terminateParsing) {
				throw new org.emftext.runtime.resource.impl.TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	
)?
;

parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		}
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
			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
			copyLocalizationInfos((CommonToken) a0, proxy);
		}
	}
)

{
	// expected element is a CsString
}
a1 = '[' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a1, element);
}

{
	// expected element is a Terminal
}
(
	a2 = QUOTED_39_39_92	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		}
		if (a2 != null) {
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
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

{
	// expected element is a CsString
}
a3 = ',' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a3, element);
}

{
	// expected element is a Terminal
}
(
	a4 = QUOTED_39_39_92	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		}
		if (a4 != null) {
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
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

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a5 = ',' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a5, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a6 = QUOTED_39_39_92			
			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
				}
				if (a6 != null) {
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
					tokenResolver.setOptions(getOptions());
					org.emftext.runtime.resource.ITokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), result);
					java.lang.Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a6).getLine(), ((org.antlr.runtime.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a6).getStartIndex(), ((org.antlr.runtime.CommonToken) a6).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), resolved);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a6, element);
				}
			}
		)
		
	)
	
)?
{
	// expected element is a CsString
}
a7 = ']' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a7, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a8_0 = parse_org_emftext_sdk_concretesyntax_Cardinality		{
			if (terminateParsing) {
				throw new org.emftext.runtime.resource.impl.TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
			}
			if (a8_0 != null) {
				if (a8_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), a8_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a8_0, element); 			}
		}
	)
	
)?
;

parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
		}
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
			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
			if (proxy != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), proxy);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken) a0, element);
			copyLocalizationInfos((CommonToken) a0, proxy);
		}
	}
)

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a1 = ':' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a1, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a2 = QUALIFIED_NAME			
			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
				}
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
					registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
					if (proxy != null) {
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken) a2, element);
					copyLocalizationInfos((CommonToken) a2, proxy);
				}
			}
		)
		
		{
			// expected element before STAR or QUESTIONMARK or PLUS
		}
		(
			{
				// expected element is a Compound
			}
			(
				{
					// expected element is a CsString
				}
				a3 = ',' {
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a3, element);
				}
				
				{
					// expected element is a Terminal
				}
				(
					a4 = QUALIFIED_NAME					
					{
						if (terminateParsing) {
							throw new org.emftext.runtime.resource.impl.TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
						}
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
							registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
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
			
		)*		{
			// expected element after STAR or PLUS
		}
		
	)
	
)?
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a5_0 = parse_org_emftext_sdk_concretesyntax_Cardinality		{
			if (terminateParsing) {
				throw new org.emftext.runtime.resource.impl.TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), a5_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a5_0, element); 			}
		}
	)
	
)?
;

parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null]
@init{
}
:
{
	// expected element is a CsString
}
a0 = '(' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1_0 = parse_org_emftext_sdk_concretesyntax_Choice	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
		}
		if (a1_0 != null) {
			if (a1_0 != null) {
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), a1_0);
			}
			collectHiddenTokens(element);
			copyLocalizationInfos(a1_0, element); 		}
	}
)

{
	// expected element is a CsString
}
a2 = ')' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a2, element);
}

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Terminal
	}
	(
		a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality		{
			if (terminateParsing) {
				throw new org.emftext.runtime.resource.impl.TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), a3_0);
				}
				collectHiddenTokens(element);
				copyLocalizationInfos(a3_0, element); 			}
		}
	)
	
)?
;

parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null]
@init{
}
:
{
	// expected element is a Terminal
}
(
	a0 = HEXNUMBER	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();
		}
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
{
	// expected element is a CsString
}
a0 = '!' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1 = NUMBER	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
		}
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
{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a Terminal
		}
		(
			a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				}
				if (a0_0 != null) {
					if (a0_0 != null) {
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS, a0_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a0_0, element); 				}
			}
		)
		
	)
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element is a CsString
}
a1 = 'DEFINE' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a1, element);
}

{
	// expected element is a Terminal
}
(
	a2 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
		}
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

{
	// expected element is a Terminal
}
(
	a3 = QUOTED_36_36	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
		}
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

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a4 = 'COLLECT' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a4, element);
		}
		
		{
			// expected element is a CsString
		}
		a5 = 'IN' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a5, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a6 = QUALIFIED_NAME			
			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
				}
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
{
	// expected element is a CsString
}
a0 = 'PRIORITIZE' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
		}
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
			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.TokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
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
{
	// expected element is a CsString
}
a0 = '+' {
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
{
	// expected element is a CsString
}
a0 = '*' {
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
{
	// expected element is a CsString
}
a0 = '?' {
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
{
	// expected element is a CsString
}
a0 = 'ABSTRACT' {
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
{
	// expected element is a Terminal
}
(
	a0 = QUOTED_34_34_92	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
		}
		if (a0 != null) {
			org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
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

{
	// expected element is a CsString
}
a1 = 'COLOR' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a1, element);
}

{
	// expected element is a Terminal
}
(
	a2 = HEXNUMBER	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
		}
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

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a3 = ',' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a3, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a4 = QUALIFIED_NAME			
			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
				}
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
	
)*{
	// expected element after STAR or PLUS
}

{
	// expected element is a CsString
}
a5 = ';' {
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
{
	// expected element is a CsString
}
a0 = '@' {
	if (element == null) {
		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
	}
	collectHiddenTokens(element);
	copyLocalizationInfos((CommonToken)a0, element);
}

{
	// expected element is a Terminal
}
(
	a1 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
		}
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

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a2 = '(' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a2, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a3_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
				}
				if (a3_0 != null) {
					if (a3_0 != null) {
						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, a3_0);
					}
					collectHiddenTokens(element);
					copyLocalizationInfos(a3_0, element); 				}
			}
		)
		
		{
			// expected element before STAR or QUESTIONMARK or PLUS
		}
		(
			{
				// expected element is a Compound
			}
			(
				{
					// expected element is a CsString
				}
				a4 = ',' {
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a4, element);
				}
				
				{
					// expected element is a Terminal
				}
				(
					a5_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair					{
						if (terminateParsing) {
							throw new org.emftext.runtime.resource.impl.TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
						}
						if (a5_0 != null) {
							if (a5_0 != null) {
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, a5_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a5_0, element); 						}
					}
				)
				
			)
			
		)*		{
			// expected element after STAR or PLUS
		}
		
		{
			// expected element is a CsString
		}
		a6 = ')' {
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
{
	// expected element is a Terminal
}
(
	a0 = QUALIFIED_NAME	
	{
		if (terminateParsing) {
			throw new org.emftext.runtime.resource.impl.TerminateParsingException();
		}
		if (element == null) {
			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
		}
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

{
	// expected element before STAR or QUESTIONMARK or PLUS
}
(
	{
		// expected element is a Compound
	}
	(
		{
			// expected element is a CsString
		}
		a1 = '=' {
			if (element == null) {
				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
			}
			collectHiddenTokens(element);
			copyLocalizationInfos((CommonToken)a1, element);
		}
		
		{
			// expected element is a Terminal
		}
		(
			a2 = QUOTED_34_34_92			
			{
				if (terminateParsing) {
					throw new org.emftext.runtime.resource.impl.TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
				}
				if (a2 != null) {
					org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
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
c0 = parse_org_emftext_sdk_concretesyntax_NormalToken{ element = c0; /* this is a subclass choice */ }
|c1 = parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective{ element = c1; /* this is a subclass choice */ }

;

parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null]
:
c0 = parse_org_emftext_sdk_concretesyntax_CsString{ element = c0; /* this is a subclass choice */ }
|c1 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken{ element = c1; /* this is a subclass choice */ }
|c2 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken{ element = c2; /* this is a subclass choice */ }
|c3 = parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes{ element = c3; /* this is a subclass choice */ }
|c4 = parse_org_emftext_sdk_concretesyntax_Containment{ element = c4; /* this is a subclass choice */ }
|c5 = parse_org_emftext_sdk_concretesyntax_CompoundDefinition{ element = c5; /* this is a subclass choice */ }
|c6 = parse_org_emftext_sdk_concretesyntax_WhiteSpaces{ element = c6; /* this is a subclass choice */ }
|c7 = parse_org_emftext_sdk_concretesyntax_LineBreak{ element = c7; /* this is a subclass choice */ }

;

parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null]
:
c0 = parse_org_emftext_sdk_concretesyntax_PLUS{ element = c0; /* this is a subclass choice */ }
|c1 = parse_org_emftext_sdk_concretesyntax_STAR{ element = c1; /* this is a subclass choice */ }
|c2 = parse_org_emftext_sdk_concretesyntax_QUESTIONMARK{ element = c2; /* this is a subclass choice */ }

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
