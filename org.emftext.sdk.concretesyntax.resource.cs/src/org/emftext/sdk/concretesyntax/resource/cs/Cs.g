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
	private org.emftext.sdk.concretesyntax.resource.cs.CsTokenResolveResult tokenResolveResult = new org.emftext.sdk.concretesyntax.resource.cs.CsTokenResolveResult();
	private boolean rememberExpectedElements = false;
	private java.lang.Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	private boolean reachedIndex = false;
	private java.util.List<org.emftext.runtime.resource.IExpectedElement> expectedElements = new java.util.ArrayList<org.emftext.runtime.resource.IExpectedElement>();
	private int lastIndex = -1;
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	private org.emftext.runtime.resource.ITextResource resource;
	//helper lists to allow a lexer to pass errors to its parser
	protected java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime.RecognitionException>());
	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
	
	protected void addErrorToResource(final java.lang.String errorMessage, int line, int charPositionInLine, int startIndex, int stopIndex) {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the parser is used for
			// code completion
			return;
		}
		resource.addProblem(new org.emftext.runtime.resource.impl.AbstractProblem() {
			public org.emftext.runtime.resource.EProblemType getType() {
				return org.emftext.runtime.resource.EProblemType.ERROR;
			}
			public java.lang.String getMessage() {
				return errorMessage;
			}
		}, line, charPositionInLine, startIndex, stopIndex);
	}
	
	public void addExpectedElement(org.emftext.runtime.resource.IExpectedElement expectedElement, java.lang.Object match) {
		if (!this.rememberExpectedElements) {
			return;
		}
		if (this.reachedIndex) {
			return;
		}
		int currentTokenIndex = java.lang.Math.max(0, input.index());
		int currentIndex = lastIndex == java.lang.Integer.MAX_VALUE ? java.lang.Integer.MAX_VALUE : (lastIndex + 1);
		int startIncludingHidden = -1;
		int startExcludingHidden = -1;
		int endIncludingHidden = java.lang.Integer.MAX_VALUE;
		int endExcludingHidden = java.lang.Integer.MAX_VALUE;
		for (int index = lastTokenIndex; index < currentTokenIndex; index++) {
			org.antlr.runtime.CommonToken tokenAtIndex = (org.antlr.runtime.CommonToken) input.get(index);
			if (tokenAtIndex.getChannel() == 99) {
				startIncludingHidden = tokenAtIndex.getStartIndex();
				endIncludingHidden = tokenAtIndex.getStopIndex();
			} else {
				startExcludingHidden = tokenAtIndex.getStartIndex();
				endExcludingHidden = tokenAtIndex.getStopIndex();
			}
		}
		startIncludingHidden = java.lang.Math.max(startIncludingHidden, currentIndex);
		startExcludingHidden = java.lang.Math.max(startExcludingHidden, currentIndex);
		lastTokenIndex = java.lang.Math.max(0, currentTokenIndex);
		expectedElement.setPosition(startIncludingHidden,  startExcludingHidden, endIncludingHidden, endExcludingHidden);
		this.lastIndex = endIncludingHidden;
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
	
	protected void copyLocalizationInfos(org.eclipse.emf.ecore.EObject source, org.eclipse.emf.ecore.EObject target) {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the parser is used for
			// code completion
			return;
		}
		final org.emftext.runtime.resource.ILocationMap locationMap = resource.getLocationMap();
		locationMap.setCharStart(target, locationMap.getCharStart(source));
		locationMap.setCharEnd(target, locationMap.getCharEnd(source));
		locationMap.setColumn(target, locationMap.getColumn(source));
		locationMap.setLine(target, locationMap.getLine(source));
	}
	
	protected void copyLocalizationInfos(org.antlr.runtime.CommonToken source, org.eclipse.emf.ecore.EObject target) {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the parser is used for
			// code completion
			return;
		}
		final org.emftext.runtime.resource.ILocationMap locationMap = resource.getLocationMap();
		locationMap.setCharStart(target, source.getStartIndex());
		locationMap.setCharEnd(target, source.getStopIndex());
		locationMap.setColumn(target, source.getCharPositionInLine());
		locationMap.setLine(target, source.getLine());
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
	
	public java.lang.Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch getReferenceResolverSwitch() {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			return null;
		}
		return (org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch) resource.getMetaInformation().getReferenceResolverSwitch();
	}
	
	public org.emftext.runtime.resource.ITextResource getResource() {
		return resource;
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
	public org.eclipse.emf.ecore.EObject parse() {
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				return result;
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
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.emftext.sdk.concretesyntax.resource.cs.CsContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory,ContainerType element, org.eclipse.emf.ecore.EReference reference, String id,org.eclipse.emf.ecore.EObject proxy) {
		org.emftext.runtime.resource.ITextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the parser is used for
			// code completion
			return;
		}
		resource.registerContextDependentProxy(factory, element, reference, id, proxy);
	}
	
	// Translates errors thrown by the parser into human readable messages.
	public void reportError(org.antlr.runtime.RecognitionException e)  {
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
		if (resource != null) {
			if (e.token instanceof org.antlr.runtime.CommonToken) {
				org.antlr.runtime.CommonToken ct = (org.antlr.runtime.CommonToken) e.token;
				resource.addProblem(
					new org.emftext.runtime.resource.impl.AbstractProblem() {
						public org.emftext.runtime.resource.EProblemType getType() {
							return org.emftext.runtime.resource.EProblemType.ERROR;
						}
						public java.lang.String getMessage() {
							return finalMessage;
						}
					}, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
				} else {
					resource.addProblem(
						new org.emftext.runtime.resource.impl.AbstractProblem() {
							public org.emftext.runtime.resource.EProblemType getType() {
								return org.emftext.runtime.resource.EProblemType.ERROR;
							}
							public java.lang.String getMessage() {
								return finalMessage;
							}
						},
						e.token.getCharPositionInLine(), e.token.getLine(), 1, 5); // TODO what the heck is this 5?
					}
				}
			}
			
			// Translates errors thrown by the lexer into human readable messages.
			public void reportLexicalError(org.antlr.runtime.RecognitionException e)  {
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
				final java.lang.String finalMessage = message;
				resource.addProblem(
					new org.emftext.runtime.resource.impl.AbstractProblem() {
												public org.emftext.runtime.resource.EProblemType getType() {
							return org.emftext.runtime.resource.EProblemType.ERROR;
						}
												public java.lang.String getMessage() {
							return finalMessage;
						}
					}, e.index,e.line,lexerExceptionsPosition.get(lexerExceptions.indexOf(e)),lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
				}
				
				public void setOptions(java.util.Map<?,?> options) {
					this.options = options;
				}
				
				public void setResource(org.emftext.runtime.resource.ITextResource resource) {
					this.resource = resource;
				}
				
			}
			
			start 			returns [ org.eclipse.emf.ecore.EObject element = null]
			:
				(
					c0 = parse_org_emftext_sdk_concretesyntax_ConcreteSyntax{ element = c0; }
				)
				EOF				
			;
			
			parse_org_emftext_sdk_concretesyntax_ConcreteSyntax			 returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null]
			@init{
			}
			:
				(
					(
						(
							a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								}
								String tokenName = "null";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS), element, tokenName), a0_0);
								if (a0_0 != null) {
									if (a0_0 != null) {
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS, a0_0);
									}
									collectHiddenTokens(element);
									copyLocalizationInfos(a0_0, element); 								}
							}
						)
						
					)
					
				)*				
				(
					(
						a1_0 = parse_org_emftext_sdk_concretesyntax_Abstract						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							String tokenName = "null";
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER), element, tokenName), a1_0);
							if (a1_0 != null) {
								if (a1_0 != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER), a1_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a1_0, element); 							}
						}
					)
					
				)?				
				a2 = 'SYNTAXDEF' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("SYNTAXDEF"), a2);
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
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), element, tokenName), a3);
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
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("FOR"), a4);
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
						String tokenName = "QUOTED_60_62";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), element, tokenName), a5);
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
				
				(
					(
						(
							a6 = QUOTED_60_62							
							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								}
								String tokenName = "QUOTED_60_62";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), element, tokenName), a6);
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
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("START"), a7);
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
									String tokenName = "QUALIFIED_NAME";
									addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), element, tokenName), a8);
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
						
						(
							(
								a9 = ',' {
									addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a9);
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
											String tokenName = "QUALIFIED_NAME";
											addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), element, tokenName), a10);
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
							
						)*						
					)
					
				)?				
				(
					(
						a11 = 'IMPORTS' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("IMPORTS"), a11);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a11, element);
						}
						
						a12 = '{' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a12);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a12, element);
						}
						
						(
							(
								(
									a13_0 = parse_org_emftext_sdk_concretesyntax_Import									{
										if (element == null) {
											element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
										}
										String tokenName = "null";
										addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS), element, tokenName), a13_0);
										if (a13_0 != null) {
											if (a13_0 != null) {
												addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS, a13_0);
											}
											collectHiddenTokens(element);
											copyLocalizationInfos(a13_0, element); 										}
									}
								)
								
							)
							
						)*						
						a14 = '}' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a14);
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
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("OPTIONS"), a15);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a15, element);
						}
						
						a16 = '{' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a16);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a16, element);
						}
						
						(
							(
								(
									a17_0 = parse_org_emftext_sdk_concretesyntax_Option									{
										if (element == null) {
											element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
										}
										String tokenName = "null";
										addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS), element, tokenName), a17_0);
										if (a17_0 != null) {
											if (a17_0 != null) {
												addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS, a17_0);
											}
											collectHiddenTokens(element);
											copyLocalizationInfos(a17_0, element); 										}
									}
								)
								
								a18 = ';' {
									addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(";"), a18);
									if (element == null) {
										element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
									}
									collectHiddenTokens(element);
									copyLocalizationInfos((CommonToken)a18, element);
								}
								
							)
							
						)*						
						a19 = '}' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a19);
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
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("TOKENS"), a20);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a20, element);
						}
						
						a21 = '{' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a21);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a21, element);
						}
						
						(
							(
								(
									a22_0 = parse_org_emftext_sdk_concretesyntax_TokenDirective									{
										if (element == null) {
											element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
										}
										String tokenName = "null";
										addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS), element, tokenName), a22_0);
										if (a22_0 != null) {
											if (a22_0 != null) {
												addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS, a22_0);
											}
											collectHiddenTokens(element);
											copyLocalizationInfos(a22_0, element); 										}
									}
								)
								
								a23 = ';' {
									addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(";"), a23);
									if (element == null) {
										element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
									}
									collectHiddenTokens(element);
									copyLocalizationInfos((CommonToken)a23, element);
								}
								
							)
							
						)*						
						a24 = '}' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a24);
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
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("TOKENSTYLES"), a25);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a25, element);
						}
						
						a26 = '{' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a26);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a26, element);
						}
						
						(
							(
								(
									a27_0 = parse_org_emftext_sdk_concretesyntax_TokenStyle									{
										if (element == null) {
											element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
										}
										String tokenName = "null";
										addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES), element, tokenName), a27_0);
										if (a27_0 != null) {
											if (a27_0 != null) {
												addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES, a27_0);
											}
											collectHiddenTokens(element);
											copyLocalizationInfos(a27_0, element); 										}
									}
								)
								
							)
							
						)*						
						a28 = '}' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a28);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a28, element);
						}
						
					)
					
				)?				
				a29 = 'RULES' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("RULES"), a29);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a29, element);
				}
				
				a30 = '{' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a30);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a30, element);
				}
				
				(
					(
						(
							a31_0 = parse_org_emftext_sdk_concretesyntax_Rule							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
								}
								String tokenName = "null";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES), element, tokenName), a31_0);
								if (a31_0 != null) {
									if (a31_0 != null) {
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES, a31_0);
									}
									collectHiddenTokens(element);
									copyLocalizationInfos(a31_0, element); 								}
							}
						)
						
					)*					
				)
				
				a32 = '}' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a32);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a32, element);
				}
				
			;
			
			parse_org_emftext_sdk_concretesyntax_Import			 returns [org.emftext.sdk.concretesyntax.Import element = null]
			@init{
			}
			:
				(
					a0 = QUALIFIED_NAME					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
						}
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), element, tokenName), a0);
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
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(":"), a1);
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
						String tokenName = "QUOTED_60_62";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), element, tokenName), a2);
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
				
				(
					(
						(
							a3 = QUOTED_60_62							
							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
								}
								String tokenName = "QUOTED_60_62";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), element, tokenName), a3);
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
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("WITH"), a4);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a4, element);
						}
						
						a5 = 'SYNTAX' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("SYNTAX"), a5);
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
								String tokenName = "QUALIFIED_NAME";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), element, tokenName), a6);
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
						
						(
							(
								(
									a7 = QUOTED_60_62									
									{
										if (element == null) {
											element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
										}
										String tokenName = "QUOTED_60_62";
										addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), element, tokenName), a7);
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
			
			parse_org_emftext_sdk_concretesyntax_Option			 returns [org.emftext.sdk.concretesyntax.Option element = null]
			@init{
			}
			:
				(
					a0 = QUALIFIED_NAME					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
						}
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), element, tokenName), a0);
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
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("="), a1);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a1, element);
				}
				
				(
					a2 = QUOTED_34_34_92					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
						}
						String tokenName = "QUOTED_34_34_92";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), element, tokenName), a2);
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
			
			parse_org_emftext_sdk_concretesyntax_Rule			 returns [org.emftext.sdk.concretesyntax.Rule element = null]
			@init{
			}
			:
				(
					(
						(
							a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
								}
								String tokenName = "null";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__ANNOTATIONS), element, tokenName), a0_0);
								if (a0_0 != null) {
									if (a0_0 != null) {
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__ANNOTATIONS, a0_0);
									}
									collectHiddenTokens(element);
									copyLocalizationInfos(a0_0, element); 								}
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
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), element, tokenName), a1);
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
				
				a2 = '::=' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("::="), a2);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a2, element);
				}
				
				(
					a3_0 = parse_org_emftext_sdk_concretesyntax_Choice					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
						}
						String tokenName = "null";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), element, tokenName), a3_0);
						if (a3_0 != null) {
							if (a3_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION), a3_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a3_0, element); 						}
					}
				)
				
				a4 = ';' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(";"), a4);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a4, element);
				}
				
			;
			
			parse_org_emftext_sdk_concretesyntax_Sequence			 returns [org.emftext.sdk.concretesyntax.Sequence element = null]
			@init{
			}
			:
				(
					(
						a0_0 = parse_org_emftext_sdk_concretesyntax_Definition						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSequence();
							}
							String tokenName = "null";
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS), element, tokenName), a0_0);
							if (a0_0 != null) {
								if (a0_0 != null) {
									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS, a0_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a0_0, element); 							}
						}
					)
					
				)+				
			;
			
			parse_org_emftext_sdk_concretesyntax_Choice			 returns [org.emftext.sdk.concretesyntax.Choice element = null]
			@init{
			}
			:
				(
					a0_0 = parse_org_emftext_sdk_concretesyntax_Sequence					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
						}
						String tokenName = "null";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS), element, tokenName), a0_0);
						if (a0_0 != null) {
							if (a0_0 != null) {
								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a0_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a0_0, element); 						}
					}
				)
				
				(
					(
						a1 = '|' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("|"), a1);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a1, element);
						}
						
						(
							a2_0 = parse_org_emftext_sdk_concretesyntax_Sequence							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
								}
								String tokenName = "null";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS), element, tokenName), a2_0);
								if (a2_0 != null) {
									if (a2_0 != null) {
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS, a2_0);
									}
									collectHiddenTokens(element);
									copyLocalizationInfos(a2_0, element); 								}
							}
						)
						
					)
					
				)*				
			;
			
			parse_org_emftext_sdk_concretesyntax_CsString			 returns [org.emftext.sdk.concretesyntax.CsString element = null]
			@init{
			}
			:
				(
					a0 = QUOTED_34_34_92					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCsString();
						}
						String tokenName = "QUOTED_34_34_92";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), element, tokenName), a0);
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
			
			parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken			 returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null]
			@init{
			}
			:
				(
					a0 = QUALIFIED_NAME					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
						}
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), element, tokenName), a0);
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
				
				a1 = '[' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("["), a1);
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
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), element, tokenName), a2);
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
				
				a3 = ']' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("]"), a3);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a3, element);
				}
				
				(
					(
						a4_0 = parse_org_emftext_sdk_concretesyntax_Cardinality						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
							}
							String tokenName = "null";
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), element, tokenName), a4_0);
							if (a4_0 != null) {
								if (a4_0 != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), a4_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a4_0, element); 							}
						}
					)
					
				)?				
			;
			
			parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken			 returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null]
			@init{
			}
			:
				(
					a0 = QUALIFIED_NAME					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
						}
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), element, tokenName), a0);
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
				
				a1 = '[' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("["), a1);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a1, element);
				}
				
				a2 = ']' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("]"), a2);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a2, element);
				}
				
				(
					(
						a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
							}
							String tokenName = "null";
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), element, tokenName), a3_0);
							if (a3_0 != null) {
								if (a3_0 != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), a3_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a3_0, element); 							}
						}
					)
					
				)?				
			;
			
			parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes			 returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null]
			@init{
			}
			:
				(
					a0 = QUALIFIED_NAME					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
						}
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), element, tokenName), a0);
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
				
				a1 = '[' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("["), a1);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a1, element);
				}
				
				(
					a2 = QUOTED_39_39_92					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
						}
						String tokenName = "QUOTED_39_39_92";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), element, tokenName), a2);
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
				
				a3 = ',' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a3);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a3, element);
				}
				
				(
					a4 = QUOTED_39_39_92					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
						}
						String tokenName = "QUOTED_39_39_92";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), element, tokenName), a4);
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
				
				(
					(
						a5 = ',' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a5);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a5, element);
						}
						
						(
							a6 = QUOTED_39_39_92							
							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
								}
								String tokenName = "QUOTED_39_39_92";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), element, tokenName), a6);
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
				a7 = ']' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("]"), a7);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a7, element);
				}
				
				(
					(
						a8_0 = parse_org_emftext_sdk_concretesyntax_Cardinality						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
							}
							String tokenName = "null";
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), element, tokenName), a8_0);
							if (a8_0 != null) {
								if (a8_0 != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), a8_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a8_0, element); 							}
						}
					)
					
				)?				
			;
			
			parse_org_emftext_sdk_concretesyntax_Containment			 returns [org.emftext.sdk.concretesyntax.Containment element = null]
			@init{
			}
			:
				(
					a0 = QUALIFIED_NAME					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
						}
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), element, tokenName), a0);
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
				
				(
					(
						a1 = ':' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(":"), a1);
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
								String tokenName = "QUALIFIED_NAME";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), element, tokenName), a2);
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
						
						(
							(
								a3 = ',' {
									addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a3);
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
										String tokenName = "QUALIFIED_NAME";
										addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), element, tokenName), a4);
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
							
						)*						
					)
					
				)?				
				(
					(
						a5_0 = parse_org_emftext_sdk_concretesyntax_Cardinality						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
							}
							String tokenName = "null";
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), element, tokenName), a5_0);
							if (a5_0 != null) {
								if (a5_0 != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), a5_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a5_0, element); 							}
						}
					)
					
				)?				
			;
			
			parse_org_emftext_sdk_concretesyntax_CompoundDefinition			 returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null]
			@init{
			}
			:
				a0 = '(' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("("), a0);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a0, element);
				}
				
				(
					a1_0 = parse_org_emftext_sdk_concretesyntax_Choice					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
						}
						String tokenName = "null";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), element, tokenName), a1_0);
						if (a1_0 != null) {
							if (a1_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS), a1_0);
							}
							collectHiddenTokens(element);
							copyLocalizationInfos(a1_0, element); 						}
					}
				)
				
				a2 = ')' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(")"), a2);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a2, element);
				}
				
				(
					(
						a3_0 = parse_org_emftext_sdk_concretesyntax_Cardinality						{
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
							}
							String tokenName = "null";
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), element, tokenName), a3_0);
							if (a3_0 != null) {
								if (a3_0 != null) {
									element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), a3_0);
								}
								collectHiddenTokens(element);
								copyLocalizationInfos(a3_0, element); 							}
						}
					)
					
				)?				
			;
			
			parse_org_emftext_sdk_concretesyntax_WhiteSpaces			 returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null]
			@init{
			}
			:
				(
					a0 = HEXNUMBER					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();
						}
						String tokenName = "HEXNUMBER";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), element, tokenName), a0);
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
			
			parse_org_emftext_sdk_concretesyntax_LineBreak			 returns [org.emftext.sdk.concretesyntax.LineBreak element = null]
			@init{
			}
			:
				a0 = '!' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("!"), a0);
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
						String tokenName = "NUMBER";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), element, tokenName), a1);
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
			
			parse_org_emftext_sdk_concretesyntax_NormalToken			 returns [org.emftext.sdk.concretesyntax.NormalToken element = null]
			@init{
			}
			:
				(
					(
						(
							a0_0 = parse_org_emftext_sdk_concretesyntax_Annotation							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
								}
								String tokenName = "null";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS), element, tokenName), a0_0);
								if (a0_0 != null) {
									if (a0_0 != null) {
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ANNOTATIONS, a0_0);
									}
									collectHiddenTokens(element);
									copyLocalizationInfos(a0_0, element); 								}
							}
						)
						
					)
					
				)*				
				a1 = 'DEFINE' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("DEFINE"), a1);
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
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), element, tokenName), a2);
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
						String tokenName = "QUOTED_36_36";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX), element, tokenName), a3);
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
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("COLLECT"), a4);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a4, element);
						}
						
						a5 = 'IN' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("IN"), a5);
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
								String tokenName = "QUALIFIED_NAME";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), element, tokenName), a6);
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
			
			parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective			 returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null]
			@init{
			}
			:
				a0 = 'PRIORITIZE' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("PRIORITIZE"), a0);
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
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), element, tokenName), a1);
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
			
			parse_org_emftext_sdk_concretesyntax_PLUS			 returns [org.emftext.sdk.concretesyntax.PLUS element = null]
			@init{
			}
			:
				a0 = '+' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("+"), a0);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPLUS();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a0, element);
				}
				
			;
			
			parse_org_emftext_sdk_concretesyntax_STAR			 returns [org.emftext.sdk.concretesyntax.STAR element = null]
			@init{
			}
			:
				a0 = '*' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("*"), a0);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSTAR();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a0, element);
				}
				
			;
			
			parse_org_emftext_sdk_concretesyntax_QUESTIONMARK			 returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null]
			@init{
			}
			:
				a0 = '?' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("?"), a0);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a0, element);
				}
				
			;
			
			parse_org_emftext_sdk_concretesyntax_Abstract			 returns [org.emftext.sdk.concretesyntax.Abstract element = null]
			@init{
			}
			:
				a0 = 'ABSTRACT' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("ABSTRACT"), a0);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAbstract();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a0, element);
				}
				
			;
			
			parse_org_emftext_sdk_concretesyntax_TokenStyle			 returns [org.emftext.sdk.concretesyntax.TokenStyle element = null]
			@init{
			}
			:
				(
					a0 = QUOTED_34_34_92					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
						}
						String tokenName = "QUOTED_34_34_92";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), element, tokenName), a0);
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
				
				a1 = 'COLOR' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("COLOR"), a1);
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
						String tokenName = "HEXNUMBER";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), element, tokenName), a2);
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
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a3);
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
								String tokenName = "QUALIFIED_NAME";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), element, tokenName), a4);
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
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(";"), a5);
					if (element == null) {
						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					}
					collectHiddenTokens(element);
					copyLocalizationInfos((CommonToken)a5, element);
				}
				
			;
			
			parse_org_emftext_sdk_concretesyntax_Annotation			 returns [org.emftext.sdk.concretesyntax.Annotation element = null]
			@init{
			}
			:
				a0 = '@' {
					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("@"), a0);
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
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), element, tokenName), a1);
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
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("("), a2);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a2, element);
						}
						
						(
							a3_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
								}
								String tokenName = "null";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS), element, tokenName), a3_0);
								if (a3_0 != null) {
									if (a3_0 != null) {
										addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, a3_0);
									}
									collectHiddenTokens(element);
									copyLocalizationInfos(a3_0, element); 								}
							}
						)
						
						(
							(
								a4 = ',' {
									addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a4);
									if (element == null) {
										element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
									}
									collectHiddenTokens(element);
									copyLocalizationInfos((CommonToken)a4, element);
								}
								
								(
									a5_0 = parse_org_emftext_sdk_concretesyntax_KeyValuePair									{
										if (element == null) {
											element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
										}
										String tokenName = "null";
										addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS), element, tokenName), a5_0);
										if (a5_0 != null) {
											if (a5_0 != null) {
												addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS, a5_0);
											}
											collectHiddenTokens(element);
											copyLocalizationInfos(a5_0, element); 										}
									}
								)
								
							)
							
						)*						
						a6 = ')' {
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(")"), a6);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a6, element);
						}
						
					)
					
				)?				
			;
			
			parse_org_emftext_sdk_concretesyntax_KeyValuePair			 returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null]
			@init{
			}
			:
				(
					a0 = QUALIFIED_NAME					
					{
						if (element == null) {
							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
						}
						String tokenName = "QUALIFIED_NAME";
						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), element, tokenName), a0);
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
							addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("="), a1);
							if (element == null) {
								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
							}
							collectHiddenTokens(element);
							copyLocalizationInfos((CommonToken)a1, element);
						}
						
						(
							a2 = QUOTED_34_34_92							
							{
								if (element == null) {
									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
								}
								String tokenName = "QUOTED_34_34_92";
								addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), element, tokenName), a2);
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
			
			parse_org_emftext_sdk_concretesyntax_TokenDirective			 returns [org.emftext.sdk.concretesyntax.TokenDirective element = null]
			:
				c0 = parse_org_emftext_sdk_concretesyntax_NormalToken{ element = c0; }
				|				c1 = parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective{ element = c1; }
				
			;
			
			parse_org_emftext_sdk_concretesyntax_Definition			 returns [org.emftext.sdk.concretesyntax.Definition element = null]
			:
				c0 = parse_org_emftext_sdk_concretesyntax_CsString{ element = c0; }
				|				c1 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken{ element = c1; }
				|				c2 = parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken{ element = c2; }
				|				c3 = parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes{ element = c3; }
				|				c4 = parse_org_emftext_sdk_concretesyntax_Containment{ element = c4; }
				|				c5 = parse_org_emftext_sdk_concretesyntax_CompoundDefinition{ element = c5; }
				|				c6 = parse_org_emftext_sdk_concretesyntax_WhiteSpaces{ element = c6; }
				|				c7 = parse_org_emftext_sdk_concretesyntax_LineBreak{ element = c7; }
				
			;
			
			parse_org_emftext_sdk_concretesyntax_Cardinality			 returns [org.emftext.sdk.concretesyntax.Cardinality element = null]
			:
				c0 = parse_org_emftext_sdk_concretesyntax_PLUS{ element = c0; }
				|				c1 = parse_org_emftext_sdk_concretesyntax_STAR{ element = c1; }
				|				c2 = parse_org_emftext_sdk_concretesyntax_QUESTIONMARK{ element = c2; }
				
			;
			
			COMMENTS			:
				'//'(~('\n'|'\r'))*
				{ _channel = 99; }
			;
			QUALIFIED_NAME			:
				('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')*('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)*			;
			NUMBER			:
				('0'..'9')+			;
			HEXNUMBER			:
				'#'('0'..'9'|'A'..'F'|'a'..'f')+			;
			WHITESPACE			:
				(' '|'\t'|'\f')
				{ _channel = 99; }
			;
			LINEBREAK			:
				('\r\n'|'\r'|'\n')
				{ _channel = 99; }
			;
			QUOTED_60_62			:
				('<')(~('>'))*('>')
			;
			QUOTED_34_34_92			:
				('"')(('\\''"')|('\\''\\')|~('"'|'\\'))*('"')
			;
			QUOTED_39_39_92			:
				('\'')(('\\''\'')|('\\''\\')|~('\''|'\\'))*('\'')
			;
			QUOTED_36_36			:
				('$')(~('$'))*('$')
			;
