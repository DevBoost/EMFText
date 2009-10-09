// $ANTLR 3.1.1

	package org.emftext.sdk.concretesyntax.resource.cs.mopp;


import org.antlr.runtime.*;
import java.util.HashMap;
public class CsParser extends CsANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUALIFIED_NAME", "QUOTED_60_62", "QUOTED_34_34_92", "QUOTED_39_39_92", "HEXNUMBER", "NUMBER", "QUOTED_36_36", "COMMENTS", "WHITESPACE", "LINEBREAK", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'TOKENSTYLES'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'!'", "'DEFINE'", "'COLLECT'", "'IN'", "'PRIORITIZE'", "'+'", "'*'", "'?'", "'ABSTRACT'", "'COLOR'", "'@'"
    };
    public static final int T__42=42;
    public static final int QUOTED_34_34_92=6;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int NUMBER=9;
    public static final int T__21=21;
    public static final int HEXNUMBER=8;
    public static final int T__19=19;
    public static final int COMMENTS=11;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__46=46;
    public static final int T__17=17;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int QUALIFIED_NAME=4;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int QUOTED_36_36=10;
    public static final int T__20=20;
    public static final int T__44=44;
    public static final int T__14=14;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int QUOTED_60_62=5;
    public static final int WHITESPACE=12;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int T__43=43;
    public static final int QUOTED_39_39_92=7;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int LINEBREAK=13;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators


        public CsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[71+1];
             
             
        }
        

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g"; }


    	private org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolverFactory tokenResolverFactory = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolverFactory();
    	private int lastPosition;
    	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult tokenResolveResult = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult();
    	private boolean rememberExpectedElements = false;
    	private java.lang.Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	private boolean reachedIndex = false;
    	private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement> expectedElements = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement>();
    	private int lastIndex = -1;
    	private int mismatchedTokenRecoveryTries = 0;
    	private java.util.Map<?, ?> options;
    	//helper lists to allow a lexer to pass errors to its parser
    	protected java.util.List<org.antlr.runtime.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime.RecognitionException>());
    	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> postParseCommands;
    	private boolean terminateParsing;
    	
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
    		}
    	);
    }

    public void addExpectedElement(org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement expectedElement, java.lang.String message) {
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
    			if (resource == null) {
    				// the resource can be null if the parser is used for
    				// code completion
    				return true;
    			}
    			org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = resource.getLocationMap();
    			locationMap.setCharStart(target, locationMap.getCharStart(source));
    			locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    			locationMap.setColumn(target, locationMap.getColumn(source));
    			locationMap.setLine(target, locationMap.getLine(source));
    			return true;
    		}
    	});
    }

    protected void copyLocalizationInfos(final org.antlr.runtime.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    	postParseCommands.add(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>() {
    		public boolean execute(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource resource) {
    			if (resource == null) {
    				// the resource can be null if the parser is used for
    				// code completion
    				return true;
    			}
    			org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = resource.getLocationMap();
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
    			return new CsParser(new org.antlr.runtime.CommonTokenStream(new CsLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream))));
    		} else {
    			return new CsParser(new org.antlr.runtime.CommonTokenStream(new CsLexer(new org.antlr.runtime.ANTLRInputStream(actualInputStream, encoding))));
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
    	throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsUnexpectedContentTypeException(typeObject);
    }

    private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult getFreshTokenResolveResult() {
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
    	parseResult.getPostParseCommands().addAll(postParseCommands);
    	return parseResult;
    }

    public java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement> parseToExpectedElements(org.eclipse.emf.ecore.EClass type) {
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
    public void reportError(final org.antlr.runtime.RecognitionException e)  {
    	java.lang.String message = e.getMessage();
    	if (e instanceof org.antlr.runtime.MismatchedTokenException) {
    		org.antlr.runtime.MismatchedTokenException mte = (org.antlr.runtime.MismatchedTokenException) e;
    		java.lang.String tokenName = "<unknown>";
    		if (mte.expecting == Token.EOF) {
    			tokenName = "EOF";
    		} else {
    			tokenName = getTokenNames()[mte.expecting];
    			tokenName = org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil.formatTokenName(tokenName);
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



    // $ANTLR start "start"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:441:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:442:1: ( (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:443:1: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF
            {
            if ( state.backtracking==0 ) {


            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:445:1: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:446:2: c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax
            {
            if ( state.backtracking==0 ) {

              	
            }
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_in_start82);
            c0=parse_org_emftext_sdk_concretesyntax_ConcreteSyntax();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start87); if (state.failed) return element;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "start"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_ConcreteSyntax"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:453:1: parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* ) a32= '}' ;
    public final org.emftext.sdk.concretesyntax.ConcreteSyntax parse_org_emftext_sdk_concretesyntax_ConcreteSyntax() throws RecognitionException {
        org.emftext.sdk.concretesyntax.ConcreteSyntax element =  null;
        int parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_StartIndex = input.index();
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a18=null;
        Token a19=null;
        Token a20=null;
        Token a21=null;
        Token a23=null;
        Token a24=null;
        Token a25=null;
        Token a26=null;
        Token a28=null;
        Token a29=null;
        Token a30=null;
        Token a32=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 = null;

        org.emftext.sdk.concretesyntax.Abstract a1_0 = null;

        org.emftext.sdk.concretesyntax.Import a13_0 = null;

        org.emftext.sdk.concretesyntax.Option a17_0 = null;

        org.emftext.sdk.concretesyntax.TokenDirective a22_0 = null;

        org.emftext.sdk.concretesyntax.TokenStyle a27_0 = null;

        org.emftext.sdk.concretesyntax.Rule a31_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:456:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* ) a32= '}' )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:457:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* ) a32= '}'
            {
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:460:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==46) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:461:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Compound
            	      	
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:464:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:465:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a Terminal
            	      		
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:468:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:469:4: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax129);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (terminateParsing) {
            	      					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:494:1: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==44) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:495:2: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:498:2: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:499:3: a1_0= parse_org_emftext_sdk_concretesyntax_Abstract
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax168);
                    a1_0=parse_org_emftext_sdk_concretesyntax_Abstract();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax187); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a2, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:530:1: (a3= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:531:2: a3= QUALIFIED_NAME
            {
            a3=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax201); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax216); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a4, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:572:1: (a5= QUOTED_60_62 )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:573:2: a5= QUOTED_60_62
            {
            a5=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax230); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a5).getLine(), ((org.antlr.runtime.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a5).getStartIndex(), ((org.antlr.runtime.CommonToken) a5).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
              			collectHiddenTokens(element);
              			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a5, element);
              			copyLocalizationInfos((CommonToken) a5, proxy);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:607:1: ( ( (a6= QUOTED_60_62 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QUOTED_60_62) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:608:2: ( (a6= QUOTED_60_62 ) )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:611:2: ( (a6= QUOTED_60_62 ) )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:612:3: (a6= QUOTED_60_62 )
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:615:3: (a6= QUOTED_60_62 )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:616:4: a6= QUOTED_60_62
                    {
                    a6=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax264); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:649:1: ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:650:2: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:653:2: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:654:3: a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a7=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax309); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a7, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Compound
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:668:3: ( (a8= QUALIFIED_NAME ) )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:669:4: (a8= QUALIFIED_NAME )
                    {
                    if ( state.backtracking==0 ) {

                      				// expected element is a Terminal
                      			
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:672:4: (a8= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:673:5: a8= QUALIFIED_NAME
                    {
                    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax342); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a8).getLine(), ((org.antlr.runtime.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a8).getStartIndex(), ((org.antlr.runtime.CommonToken) a8).getStopIndex());
                      						}
                      						String resolved = (String) resolvedObject;
                      						org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                      						collectHiddenTokens(element);
                      						registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
                      						if (proxy != null) {
                      							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((CommonToken) a8, element);
                      						copyLocalizationInfos((CommonToken) a8, proxy);
                      					}
                      				
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      			// expected element before STAR or QUESTIONMARK or PLUS
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:709:3: ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:710:4: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      				// expected element is a Compound
                    	      			
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:713:4: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:714:5: a9= ',' ( (a10= QUALIFIED_NAME ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a CsString
                    	      				
                    	    }
                    	    a9=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax402); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      					if (element == null) {
                    	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      					}
                    	      					collectHiddenTokens(element);
                    	      					copyLocalizationInfos((CommonToken)a9, element);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a Compound
                    	      				
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:728:5: ( (a10= QUALIFIED_NAME ) )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:729:6: (a10= QUALIFIED_NAME )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						// expected element is a Terminal
                    	      					
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:732:6: (a10= QUALIFIED_NAME )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:733:7: a10= QUALIFIED_NAME
                    	    {
                    	    a10=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax447); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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
                    	      									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a10).getLine(), ((org.antlr.runtime.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a10).getStartIndex(), ((org.antlr.runtime.CommonToken) a10).getStopIndex());
                    	      								}
                    	      								String resolved = (String) resolvedObject;
                    	      								org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                    	      								collectHiddenTokens(element);
                    	      								registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
                    	      								if (proxy != null) {
                    	      									addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS, proxy);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								copyLocalizationInfos((CommonToken) a10, element);
                    	      								copyLocalizationInfos((CommonToken) a10, proxy);
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected element after STAR or PLUS
                      		
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:778:1: ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:779:2: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:782:2: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:783:3: a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}'
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a11=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax535); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a11, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a12=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax552); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a12, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element before STAR or QUESTIONMARK or PLUS
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:808:3: ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==QUALIFIED_NAME) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:809:4: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      				// expected element is a Compound
                    	      			
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:812:4: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:813:5: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a Terminal
                    	      				
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:816:5: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:817:6: a13_0= parse_org_emftext_sdk_concretesyntax_Import
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax598);
                    	    a13_0=parse_org_emftext_sdk_concretesyntax_Import();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected element after STAR or PLUS
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a14=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax647); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a14, element);
                      		
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:856:1: ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:857:2: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:860:2: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:861:3: a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}'
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a15=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax682); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a15, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a16=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax699); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a16, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element before STAR or QUESTIONMARK or PLUS
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:886:3: ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==QUALIFIED_NAME) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:887:4: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      				// expected element is a Compound
                    	      			
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:890:4: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:891:5: (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a Terminal
                    	      				
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:894:5: (a17_0= parse_org_emftext_sdk_concretesyntax_Option )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:895:6: a17_0= parse_org_emftext_sdk_concretesyntax_Option
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax745);
                    	    a17_0=parse_org_emftext_sdk_concretesyntax_Option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a CsString
                    	      				
                    	    }
                    	    a18=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax778); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      					if (element == null) {
                    	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      					}
                    	      					collectHiddenTokens(element);
                    	      					copyLocalizationInfos((CommonToken)a18, element);
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected element after STAR or PLUS
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a19=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax817); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a19, element);
                      		
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:945:1: ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:946:2: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:949:2: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:950:3: a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}'
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a20=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax852); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a20, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a21=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax869); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a21, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element before STAR or QUESTIONMARK or PLUS
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:975:3: ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==37||LA10_0==40||LA10_0==46) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:976:4: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      				// expected element is a Compound
                    	      			
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:979:4: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:980:5: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a Terminal
                    	      				
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:983:5: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:984:6: a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax915);
                    	    a22_0=parse_org_emftext_sdk_concretesyntax_TokenDirective();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a CsString
                    	      				
                    	    }
                    	    a23=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax948); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      					if (element == null) {
                    	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      					}
                    	      					collectHiddenTokens(element);
                    	      					copyLocalizationInfos((CommonToken)a23, element);
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected element after STAR or PLUS
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a24=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax987); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a24, element);
                      		
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1034:1: ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1035:2: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1038:2: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1039:3: a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}'
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a25=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1022); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a25, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a26=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1039); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a26, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element before STAR or QUESTIONMARK or PLUS
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1064:3: ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==QUOTED_34_34_92) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1065:4: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      				// expected element is a Compound
                    	      			
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1068:4: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1069:5: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a Terminal
                    	      				
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1072:5: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1073:6: a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1085);
                    	    a27_0=parse_org_emftext_sdk_concretesyntax_TokenStyle();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected element after STAR or PLUS
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a28=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1134); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a28, element);
                      		
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a29=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1155); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a29, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a30=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1166); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a30, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Compound

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1134:1: ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1135:2: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )*
            {
            if ( state.backtracking==0 ) {

              		// expected element before STAR or QUESTIONMARK or PLUS
              	
            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1138:2: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==QUALIFIED_NAME||LA14_0==46) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1139:3: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    {
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a Terminal
            	      		
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1142:3: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1143:4: a31_0= parse_org_emftext_sdk_concretesyntax_Rule
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1196);
            	    a31_0=parse_org_emftext_sdk_concretesyntax_Rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (terminateParsing) {
            	      					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected element after STAR or PLUS
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a32=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1226); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a32, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_ConcreteSyntax"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Import"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1178:1: parse_org_emftext_sdk_concretesyntax_Import returns [org.emftext.sdk.concretesyntax.Import element = null] : (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? ;
    public final org.emftext.sdk.concretesyntax.Import parse_org_emftext_sdk_concretesyntax_Import() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Import element =  null;
        int parse_org_emftext_sdk_concretesyntax_Import_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1181:1: ( (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1182:1: (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1185:1: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1186:2: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1255); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a1=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Import1270); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a1, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1227:1: (a2= QUOTED_60_62 )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1228:2: a2= QUOTED_60_62
            {
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1284); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
              			collectHiddenTokens(element);
              			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a2, element);
              			copyLocalizationInfos((CommonToken) a2, proxy);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1262:1: ( ( (a3= QUOTED_60_62 ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==QUOTED_60_62) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1263:2: ( (a3= QUOTED_60_62 ) )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1266:2: ( (a3= QUOTED_60_62 ) )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1267:3: (a3= QUOTED_60_62 )
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1270:3: (a3= QUOTED_60_62 )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1271:4: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1318); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1304:1: ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1305:2: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1308:2: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1309:3: a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a4=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Import1363); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a4, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a5=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_Import1380); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1334:3: (a6= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1335:4: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1402); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a6).getLine(), ((org.antlr.runtime.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a6).getStartIndex(), ((org.antlr.runtime.CommonToken) a6).getStopIndex());
                      					}
                      					String resolved = (String) resolvedObject;
                      					org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					collectHiddenTokens(element);
                      					registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getImportConcreteSyntaxReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
                      					if (proxy != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), proxy);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a6, element);
                      					copyLocalizationInfos((CommonToken) a6, proxy);
                      				}
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected element before STAR or QUESTIONMARK or PLUS
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1369:3: ( ( (a7= QUOTED_60_62 ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==QUOTED_60_62) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1370:4: ( (a7= QUOTED_60_62 ) )
                            {
                            if ( state.backtracking==0 ) {

                              				// expected element is a Compound
                              			
                            }
                            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1373:4: ( (a7= QUOTED_60_62 ) )
                            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1374:5: (a7= QUOTED_60_62 )
                            {
                            if ( state.backtracking==0 ) {

                              					// expected element is a Terminal
                              				
                            }
                            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1377:5: (a7= QUOTED_60_62 )
                            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1378:6: a7= QUOTED_60_62
                            {
                            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1458); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_sdk_concretesyntax_Import_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Import"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Option"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1413:1: parse_org_emftext_sdk_concretesyntax_Option returns [org.emftext.sdk.concretesyntax.Option element = null] : (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34_92 ) ;
    public final org.emftext.sdk.concretesyntax.Option parse_org_emftext_sdk_concretesyntax_Option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;
        int parse_org_emftext_sdk_concretesyntax_Option_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1416:1: ( (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34_92 ) )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1417:1: (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34_92 )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1420:1: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1421:2: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1531); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a1=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_Option1546); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a1, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1462:1: (a2= QUOTED_34_34_92 )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1463:2: a2= QUOTED_34_34_92
            {
            a2=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_Option1560); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_sdk_concretesyntax_Option_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Option"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Rule"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1492:1: parse_org_emftext_sdk_concretesyntax_Rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule parse_org_emftext_sdk_concretesyntax_Rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;
        int parse_org_emftext_sdk_concretesyntax_Rule_StartIndex = input.index();
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 = null;

        org.emftext.sdk.concretesyntax.Choice a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1495:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1496:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';'
            {
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1499:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==46) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1500:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Compound
            	      	
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1503:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1504:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a Terminal
            	      		
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1507:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1508:4: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1609);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (terminateParsing) {
            	      					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1533:1: (a1= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1534:2: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1641); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
              			collectHiddenTokens(element);
              			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleMetaclassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              			copyLocalizationInfos((CommonToken) a1, proxy);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a2=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_Rule1656); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a2, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1579:1: (a3_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1580:2: a3_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1670);
            a3_0=parse_org_emftext_sdk_concretesyntax_Choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a4=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_Rule1683); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a4, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_sdk_concretesyntax_Rule_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Rule"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Sequence"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1609:1: parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence parse_org_emftext_sdk_concretesyntax_Sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;
        int parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.Definition a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1612:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1613:1: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
            {
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1616:1: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==QUALIFIED_NAME||LA19_0==QUOTED_34_34_92||LA19_0==HEXNUMBER||LA19_0==34||LA19_0==36) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1617:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Terminal
            	      	
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1620:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1621:3: a0_0= parse_org_emftext_sdk_concretesyntax_Definition
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence1719);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (terminateParsing) {
            	      				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Sequence"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Choice"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1643:1: parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice parse_org_emftext_sdk_concretesyntax_Choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;
        int parse_org_emftext_sdk_concretesyntax_Choice_StartIndex = input.index();
        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0_0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1646:1: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1647:1: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1650:1: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1651:2: a0_0= parse_org_emftext_sdk_concretesyntax_Sequence
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice1758);
            a0_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1670:1: ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1671:2: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Compound
            	      	
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1674:2: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1675:3: a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    {
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a CsString
            	      		
            	    }
            	    a1=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_Choice1785); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (element == null) {
            	      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
            	      			}
            	      			collectHiddenTokens(element);
            	      			copyLocalizationInfos((CommonToken)a1, element);
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a Terminal
            	      		
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1689:3: (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1690:4: a2_0= parse_org_emftext_sdk_concretesyntax_Sequence
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice1807);
            	    a2_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (terminateParsing) {
            	      					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_sdk_concretesyntax_Choice_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Choice"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_CsString"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1714:1: parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null] : (a0= QUOTED_34_34_92 ) ;
    public final org.emftext.sdk.concretesyntax.CsString parse_org_emftext_sdk_concretesyntax_CsString() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;
        int parse_org_emftext_sdk_concretesyntax_CsString_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1717:1: ( (a0= QUOTED_34_34_92 ) )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1718:1: (a0= QUOTED_34_34_92 )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1721:1: (a0= QUOTED_34_34_92 )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1722:2: a0= QUOTED_34_34_92
            {
            a0=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_CsString1854); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_sdk_concretesyntax_CsString_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_CsString"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1751:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element =  null;
        int parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Cardinality a4_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1754:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1755:1: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1758:1: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1759:2: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1887); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              			collectHiddenTokens(element);
              			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              			copyLocalizationInfos((CommonToken) a0, proxy);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1902); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a1, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1804:1: (a2= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1805:2: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1916); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              			collectHiddenTokens(element);
              			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.TokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a2, element);
              			copyLocalizationInfos((CommonToken) a2, proxy);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a3=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1931); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a3, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1850:1: ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=41 && LA21_0<=43)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1851:2: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1854:2: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1855:3: a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1952);
                    a4_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1874:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element =  null;
        int parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1877:1: ( (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1878:1: (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1881:1: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1882:2: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken1989); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              			collectHiddenTokens(element);
              			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              			copyLocalizationInfos((CommonToken) a0, proxy);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2004); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a1, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a2=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2015); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a2, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1938:1: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=41 && LA22_0<=43)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1939:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1942:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1943:3: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2036);
                    a3_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1962:1: parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.PlaceholderInQuotes parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderInQuotes element =  null;
        int parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        org.emftext.sdk.concretesyntax.Cardinality a8_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1965:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1966:1: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1969:1: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:1970:2: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2073); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              			collectHiddenTokens(element);
              			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              			copyLocalizationInfos((CommonToken) a0, proxy);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2088); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a1, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2015:1: (a2= QUOTED_39_39_92 )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2016:2: a2= QUOTED_39_39_92
            {
            a2=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2102); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2117); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a3, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2057:1: (a4= QUOTED_39_39_92 )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2058:2: a4= QUOTED_39_39_92
            {
            a4=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2131); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2088:1: ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2089:2: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2092:2: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2093:3: a5= ',' (a6= QUOTED_39_39_92 )
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2160); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2107:3: (a6= QUOTED_39_39_92 )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2108:4: a6= QUOTED_39_39_92
                    {
                    a6=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2182); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a7=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2213); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a7, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2152:1: ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=41 && LA24_0<=43)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2153:2: (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2156:2: (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2157:3: a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2234);
                    a8_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Containment"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2176:1: parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.Containment parse_org_emftext_sdk_concretesyntax_Containment() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Containment element =  null;
        int parse_org_emftext_sdk_concretesyntax_Containment_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Cardinality a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2179:1: ( (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2180:1: (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2183:1: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2184:2: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2271); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a0).getLine(), ((org.antlr.runtime.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a0).getStartIndex(), ((org.antlr.runtime.CommonToken) a0).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              			collectHiddenTokens(element);
              			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a0, element);
              			copyLocalizationInfos((CommonToken) a0, proxy);
              		}
              	
            }

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2218:1: ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==26) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2219:2: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2222:2: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2223:3: a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a1=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Containment2300); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2237:3: (a2= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2238:4: a2= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2322); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a2).getLine(), ((org.antlr.runtime.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a2).getStartIndex(), ((org.antlr.runtime.CommonToken) a2).getStopIndex());
                      					}
                      					String resolved = (String) resolvedObject;
                      					org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                      					collectHiddenTokens(element);
                      					registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
                      					if (proxy != null) {
                      						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos((CommonToken) a2, element);
                      					copyLocalizationInfos((CommonToken) a2, proxy);
                      				}
                      			
                    }

                    }

                    if ( state.backtracking==0 ) {

                      			// expected element before STAR or QUESTIONMARK or PLUS
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2272:3: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==17) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2273:4: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      				// expected element is a Compound
                    	      			
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2276:4: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2277:5: a3= ',' (a4= QUALIFIED_NAME )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a CsString
                    	      				
                    	    }
                    	    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Containment2371); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      					if (element == null) {
                    	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                    	      					}
                    	      					collectHiddenTokens(element);
                    	      					copyLocalizationInfos((CommonToken)a3, element);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a Terminal
                    	      				
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2291:5: (a4= QUALIFIED_NAME )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2292:6: a4= QUALIFIED_NAME
                    	    {
                    	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2401); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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
                    	      								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a4).getLine(), ((org.antlr.runtime.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a4).getStartIndex(), ((org.antlr.runtime.CommonToken) a4).getStopIndex());
                    	      							}
                    	      							String resolved = (String) resolvedObject;
                    	      							org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                    	      							collectHiddenTokens(element);
                    	      							registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
                    	      							if (proxy != null) {
                    	      								addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
                    	      							}
                    	      							collectHiddenTokens(element);
                    	      							copyLocalizationInfos((CommonToken) a4, element);
                    	      							copyLocalizationInfos((CommonToken) a4, proxy);
                    	      						}
                    	      					
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected element after STAR or PLUS
                      		
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2335:1: ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=41 && LA27_0<=43)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2336:2: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2339:2: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2340:3: a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment2470);
                    a5_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_sdk_concretesyntax_Containment_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Containment"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_CompoundDefinition"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2359:1: parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition parse_org_emftext_sdk_concretesyntax_CompoundDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;
        int parse_org_emftext_sdk_concretesyntax_CompoundDefinition_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1_0 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2362:1: (a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2363:1: a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2504); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2377:1: (a1_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2378:2: a1_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2518);
            a1_0=parse_org_emftext_sdk_concretesyntax_Choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a2=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2531); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a2, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2408:1: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=41 && LA28_0<=43)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2409:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Terminal
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2412:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2413:3: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2552);
                    a3_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_sdk_concretesyntax_CompoundDefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_CompoundDefinition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_WhiteSpaces"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2432:1: parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : (a0= HEXNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces parse_org_emftext_sdk_concretesyntax_WhiteSpaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;
        int parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2435:1: ( (a0= HEXNUMBER ) )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2436:1: (a0= HEXNUMBER )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2439:1: (a0= HEXNUMBER )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2440:2: a0= HEXNUMBER
            {
            a0=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces2589); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_WhiteSpaces"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_LineBreak"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2469:1: parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= '!' (a1= NUMBER ) ;
    public final org.emftext.sdk.concretesyntax.LineBreak parse_org_emftext_sdk_concretesyntax_LineBreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;
        int parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2472:1: (a0= '!' (a1= NUMBER ) )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2473:1: a0= '!' (a1= NUMBER )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_LineBreak2619); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2487:1: (a1= NUMBER )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2488:2: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak2633); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_LineBreak"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_NormalToken"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2517:1: parse_org_emftext_sdk_concretesyntax_NormalToken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3= QUOTED_36_36 ) ( (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) ) )? ;
    public final org.emftext.sdk.concretesyntax.NormalToken parse_org_emftext_sdk_concretesyntax_NormalToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.NormalToken element =  null;
        int parse_org_emftext_sdk_concretesyntax_NormalToken_StartIndex = input.index();
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2520:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3= QUOTED_36_36 ) ( (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) ) )? )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2521:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3= QUOTED_36_36 ) ( (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2524:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==46) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2525:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Compound
            	      	
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2528:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2529:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a Terminal
            	      		
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2532:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2533:4: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalToken2682);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (terminateParsing) {
            	      					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a1=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_NormalToken2711); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a1, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2569:1: (a2= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2570:2: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken2725); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2600:1: (a3= QUOTED_36_36 )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2601:2: a3= QUOTED_36_36
            {
            a3=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_NormalToken2743); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (terminateParsing) {
              			throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
              		}
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              		}
              		if (a3 != null) {
              			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
              			tokenResolver.setOptions(getOptions());
              			org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2631:1: ( (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==38) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2632:2: (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2635:2: (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2636:3: a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME )
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a4=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_NormalToken2772); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a4, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a5=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_NormalToken2789); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a5, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2661:3: (a6= QUALIFIED_NAME )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2662:4: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken2811); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
                      				}
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      				}
                      				if (a6 != null) {
                      					org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      					tokenResolver.setOptions(getOptions());
                      					org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
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

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_sdk_concretesyntax_NormalToken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_NormalToken"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2694:1: parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null] : a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.TokenPriorityDirective parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenPriorityDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2697:1: (a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2698:1: a0= 'PRIORITIZE' (a1= QUALIFIED_NAME )
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective2857); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2712:1: (a1= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2713:2: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective2871); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime.CommonToken) a1).getLine(), ((org.antlr.runtime.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime.CommonToken) a1).getStartIndex(), ((org.antlr.runtime.CommonToken) a1).getStopIndex());
              			}
              			String resolved = (String) resolvedObject;
              			org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              			collectHiddenTokens(element);
              			registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.TokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
              			if (proxy != null) {
              				element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), proxy);
              			}
              			collectHiddenTokens(element);
              			copyLocalizationInfos((CommonToken) a1, element);
              			copyLocalizationInfos((CommonToken) a1, proxy);
              		}
              	
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PLUS"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2746:1: parse_org_emftext_sdk_concretesyntax_PLUS returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS parse_org_emftext_sdk_concretesyntax_PLUS() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;
        int parse_org_emftext_sdk_concretesyntax_PLUS_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2749:1: (a0= '+' )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2750:1: a0= '+'
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PLUS2901); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPLUS();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_sdk_concretesyntax_PLUS_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PLUS"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_STAR"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2763:1: parse_org_emftext_sdk_concretesyntax_STAR returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR parse_org_emftext_sdk_concretesyntax_STAR() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;
        int parse_org_emftext_sdk_concretesyntax_STAR_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2766:1: (a0= '*' )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2767:1: a0= '*'
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,42,FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_STAR2927); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSTAR();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_sdk_concretesyntax_STAR_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_STAR"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_QUESTIONMARK"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2780:1: parse_org_emftext_sdk_concretesyntax_QUESTIONMARK returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK parse_org_emftext_sdk_concretesyntax_QUESTIONMARK() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;
        int parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2783:1: (a0= '?' )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2784:1: a0= '?'
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK2953); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_QUESTIONMARK"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Abstract"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2797:1: parse_org_emftext_sdk_concretesyntax_Abstract returns [org.emftext.sdk.concretesyntax.Abstract element = null] : a0= 'ABSTRACT' ;
    public final org.emftext.sdk.concretesyntax.Abstract parse_org_emftext_sdk_concretesyntax_Abstract() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Abstract element =  null;
        int parse_org_emftext_sdk_concretesyntax_Abstract_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2800:1: (a0= 'ABSTRACT' )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2801:1: a0= 'ABSTRACT'
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_Abstract2979); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAbstract();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, parse_org_emftext_sdk_concretesyntax_Abstract_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Abstract"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenStyle"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2814:1: parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null] : (a0= QUOTED_34_34_92 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' ;
    public final org.emftext.sdk.concretesyntax.TokenStyle parse_org_emftext_sdk_concretesyntax_TokenStyle() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenStyle element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenStyle_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2817:1: ( (a0= QUOTED_34_34_92 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2818:1: (a0= QUOTED_34_34_92 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';'
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2821:1: (a0= QUOTED_34_34_92 )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2822:2: a0= QUOTED_34_34_92
            {
            a0=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3008); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a1=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3023); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a1, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2863:1: (a2= HEXNUMBER )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2864:2: a2= HEXNUMBER
            {
            a2=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3037); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2894:1: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==17) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2895:2: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      		// expected element is a Compound
            	      	
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2898:2: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2899:3: a3= ',' (a4= QUALIFIED_NAME )
            	    {
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a CsString
            	      		
            	    }
            	    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3066); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      			if (element == null) {
            	      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            	      			}
            	      			collectHiddenTokens(element);
            	      			copyLocalizationInfos((CommonToken)a3, element);
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			// expected element is a Terminal
            	      		
            	    }
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2913:3: (a4= QUALIFIED_NAME )
            	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2914:4: a4= QUALIFIED_NAME
            	    {
            	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3088); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              	// expected element after STAR or PLUS

            }
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a5=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3121); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a5, element);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, parse_org_emftext_sdk_concretesyntax_TokenStyle_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenStyle"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Annotation"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2960:1: parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null] : a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? ;
    public final org.emftext.sdk.concretesyntax.Annotation parse_org_emftext_sdk_concretesyntax_Annotation() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Annotation element =  null;
        int parse_org_emftext_sdk_concretesyntax_Annotation_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        org.emftext.sdk.concretesyntax.KeyValuePair a3_0 = null;

        org.emftext.sdk.concretesyntax.KeyValuePair a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2963:1: (a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2964:1: a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a CsString

            }
            a0=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_Annotation3147); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              	if (element == null) {
              		element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
              	}
              	collectHiddenTokens(element);
              	copyLocalizationInfos((CommonToken)a0, element);

            }
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2978:1: (a1= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:2979:2: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation3161); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3009:1: ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==34) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3010:2: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3013:2: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3014:3: a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')'
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a2=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_Annotation3190); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a2, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3028:3: (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3029:4: a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation3212);
                    a3_0=parse_org_emftext_sdk_concretesyntax_KeyValuePair();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    }

                    if ( state.backtracking==0 ) {

                      			// expected element before STAR or QUESTIONMARK or PLUS
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3048:3: ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==17) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3049:4: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      				// expected element is a Compound
                    	      			
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3052:4: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3053:5: a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a CsString
                    	      				
                    	    }
                    	    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Annotation3257); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      					if (element == null) {
                    	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                    	      					}
                    	      					collectHiddenTokens(element);
                    	      					copyLocalizationInfos((CommonToken)a4, element);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					// expected element is a Terminal
                    	      				
                    	    }
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3067:5: (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3068:6: a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation3287);
                    	    a5_0=parse_org_emftext_sdk_concretesyntax_KeyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (terminateParsing) {
                    	      							throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
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

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      			// expected element after STAR or PLUS
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a6=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Annotation3336); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a6, element);
                      		
                    }

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, parse_org_emftext_sdk_concretesyntax_Annotation_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Annotation"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_KeyValuePair"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3106:1: parse_org_emftext_sdk_concretesyntax_KeyValuePair returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null] : (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )? ;
    public final org.emftext.sdk.concretesyntax.KeyValuePair parse_org_emftext_sdk_concretesyntax_KeyValuePair() throws RecognitionException {
        org.emftext.sdk.concretesyntax.KeyValuePair element =  null;
        int parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3109:1: ( (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )? )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3110:1: (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )?
            {
            if ( state.backtracking==0 ) {

              	// expected element is a Terminal

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3113:1: (a0= QUALIFIED_NAME )
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3114:2: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3375); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              	// expected element before STAR or QUESTIONMARK or PLUS

            }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3144:1: ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==29) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3145:2: (a1= '=' (a2= QUOTED_34_34_92 ) )
                    {
                    if ( state.backtracking==0 ) {

                      		// expected element is a Compound
                      	
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3148:2: (a1= '=' (a2= QUOTED_34_34_92 ) )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3149:3: a1= '=' (a2= QUOTED_34_34_92 )
                    {
                    if ( state.backtracking==0 ) {

                      			// expected element is a CsString
                      		
                    }
                    a1=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3404); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (element == null) {
                      				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
                      			}
                      			collectHiddenTokens(element);
                      			copyLocalizationInfos((CommonToken)a1, element);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			// expected element is a Terminal
                      		
                    }
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3163:3: (a2= QUOTED_34_34_92 )
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3164:4: a2= QUOTED_34_34_92
                    {
                    a2=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3426); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_KeyValuePair"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenDirective"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3196:1: parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null] : (c0= parse_org_emftext_sdk_concretesyntax_NormalToken | c1= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective );
    public final org.emftext.sdk.concretesyntax.TokenDirective parse_org_emftext_sdk_concretesyntax_TokenDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.TokenPriorityDirective c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3197:1: (c0= parse_org_emftext_sdk_concretesyntax_NormalToken | c1= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==37||LA35_0==46) ) {
                alt35=1;
            }
            else if ( (LA35_0==40) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3198:1: c0= parse_org_emftext_sdk_concretesyntax_NormalToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalToken_in_parse_org_emftext_sdk_concretesyntax_TokenDirective3466);
                    c0=parse_org_emftext_sdk_concretesyntax_NormalToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3199:2: c1= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective3474);
                    c1=parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenDirective"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Definition"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3203:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak );
    public final org.emftext.sdk.concretesyntax.Definition parse_org_emftext_sdk_concretesyntax_Definition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Definition element =  null;
        int parse_org_emftext_sdk_concretesyntax_Definition_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.CsString c0 = null;

        org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken c1 = null;

        org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken c2 = null;

        org.emftext.sdk.concretesyntax.PlaceholderInQuotes c3 = null;

        org.emftext.sdk.concretesyntax.Containment c4 = null;

        org.emftext.sdk.concretesyntax.CompoundDefinition c5 = null;

        org.emftext.sdk.concretesyntax.WhiteSpaces c6 = null;

        org.emftext.sdk.concretesyntax.LineBreak c7 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3204:1: (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak )
            int alt36=8;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3205:1: c0= parse_org_emftext_sdk_concretesyntax_CsString
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition3493);
                    c0=parse_org_emftext_sdk_concretesyntax_CsString();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3206:2: c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition3501);
                    c1=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3207:2: c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition3509);
                    c2=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 4 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3208:2: c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition3517);
                    c3=parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 5 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3209:2: c4= parse_org_emftext_sdk_concretesyntax_Containment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition3525);
                    c4=parse_org_emftext_sdk_concretesyntax_Containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 6 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3210:2: c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition3533);
                    c5=parse_org_emftext_sdk_concretesyntax_CompoundDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 7 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3211:2: c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition3541);
                    c6=parse_org_emftext_sdk_concretesyntax_WhiteSpaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c6; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 8 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3212:2: c7= parse_org_emftext_sdk_concretesyntax_LineBreak
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition3549);
                    c7=parse_org_emftext_sdk_concretesyntax_LineBreak();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c7; /* this is a subclass choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, parse_org_emftext_sdk_concretesyntax_Definition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Definition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Cardinality"
    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3216:1: parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK );
    public final org.emftext.sdk.concretesyntax.Cardinality parse_org_emftext_sdk_concretesyntax_Cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;
        int parse_org_emftext_sdk_concretesyntax_Cardinality_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }
            // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3217:1: (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK )
            int alt37=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt37=1;
                }
                break;
            case 42:
                {
                alt37=2;
                }
                break;
            case 43:
                {
                alt37=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3218:1: c0= parse_org_emftext_sdk_concretesyntax_PLUS
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality3568);
                    c0=parse_org_emftext_sdk_concretesyntax_PLUS();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3219:2: c1= parse_org_emftext_sdk_concretesyntax_STAR
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality3576);
                    c1=parse_org_emftext_sdk_concretesyntax_STAR();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // D:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src-gen\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\mopp\\Cs.g:3220:2: c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality3584);
                    c2=parse_org_emftext_sdk_concretesyntax_QUESTIONMARK();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, parse_org_emftext_sdk_concretesyntax_Cardinality_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Cardinality"

    // Delegated rules


    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA36_eotS =
        "\13\uffff";
    static final String DFA36_eofS =
        "\2\uffff\1\6\10\uffff";
    static final String DFA36_minS =
        "\1\4\1\uffff\1\4\4\uffff\1\4\3\uffff";
    static final String DFA36_maxS =
        "\1\44\1\uffff\1\53\4\uffff\1\41\3\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\1\1\uffff\1\6\1\7\1\10\1\5\1\uffff\1\4\1\3\1\2";
    static final String DFA36_specialS =
        "\13\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\2\1\uffff\1\1\1\uffff\1\4\31\uffff\1\3\1\uffff\1\5",
            "",
            "\1\6\1\uffff\1\6\1\uffff\1\6\15\uffff\1\6\3\uffff\1\6\4\uffff"+
            "\1\6\1\7\1\uffff\3\6\4\uffff\3\6",
            "",
            "",
            "",
            "",
            "\1\12\2\uffff\1\10\31\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "3203:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak );";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax129 = new BitSet(new long[]{0x0000500000004000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax168 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax187 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax201 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax216 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax230 = new BitSet(new long[]{0x0000000003A50020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax264 = new BitSet(new long[]{0x0000000003A50000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax309 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax342 = new BitSet(new long[]{0x0000000003A60000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax402 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax447 = new BitSet(new long[]{0x0000000003A60000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax535 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax552 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax598 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax647 = new BitSet(new long[]{0x0000000003A00000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax682 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax699 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax745 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax778 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax817 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax852 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax869 = new BitSet(new long[]{0x0000512000104000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax915 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax948 = new BitSet(new long[]{0x0000512000104000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax987 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1022 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1039 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1085 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1134 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1155 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1166 = new BitSet(new long[]{0x0000500000104010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1196 = new BitSet(new long[]{0x0000500000104010L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1255 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Import1270 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1284 = new BitSet(new long[]{0x0000000008000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1318 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Import1363 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_Import1380 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1402 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1531 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_Option1546 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_Option1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1609 = new BitSet(new long[]{0x0000500000004010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1641 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_Rule1656 = new BitSet(new long[]{0x0000001400000150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1670 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_Rule1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence1719 = new BitSet(new long[]{0x0000001400000152L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice1758 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_Choice1785 = new BitSet(new long[]{0x0000001400000150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice1807 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_CsString1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1887 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1902 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1916 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1931 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken1989 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2004 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2015 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2073 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2088 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2102 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2117 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2131 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2160 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2182 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2213 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2271 = new BitSet(new long[]{0x00000E0004000002L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Containment2300 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2322 = new BitSet(new long[]{0x00000E0000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Containment2371 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2401 = new BitSet(new long[]{0x00000E0000020002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment2470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2504 = new BitSet(new long[]{0x0000001400000150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2518 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2531 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_LineBreak2619 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalToken2682 = new BitSet(new long[]{0x0000502000004000L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_NormalToken2711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken2725 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_NormalToken2743 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_NormalToken2772 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_NormalToken2789 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken2811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective2857 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective2871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PLUS2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_STAR2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_Abstract2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3008 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3023 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3037 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3066 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3088 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_Annotation3147 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation3161 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_Annotation3190 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation3212 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Annotation3257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation3287 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Annotation3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3375 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3404 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalToken_in_parse_org_emftext_sdk_concretesyntax_TokenDirective3466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition3501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition3517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition3541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition3549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality3584 = new BitSet(new long[]{0x0000000000000002L});

}