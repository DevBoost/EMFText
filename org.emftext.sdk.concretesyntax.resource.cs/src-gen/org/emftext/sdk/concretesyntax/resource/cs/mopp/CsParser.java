// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.sdk.concretesyntax.resource.cs.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
public class CsParser extends CsANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUALIFIED_NAME", "QUOTED_60_62", "STRING", "QUOTED_39_39_92", "HEXNUMBER", "TABNUMBER", "QUOTED_36_36", "COMMENTS", "NUMBER", "WHITESPACE", "LINEBREAK", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'TOKENSTYLES'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'DEFINE'", "'+'", "'COLLECT'", "'IN'", "'FRAGMENT'", "'PRIORITIZE'", "'*'", "'?'", "'ABSTRACT'", "'COLOR'", "'@'"
    };
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int NUMBER=12;
    public static final int T__47=47;
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
    public static final int TABNUMBER=9;
    public static final int STRING=6;
    public static final int T__44=44;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int QUOTED_60_62=5;
    public static final int WHITESPACE=13;
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
    public static final int LINEBREAK=14;
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
            this.state.ruleMemo = new HashMap[79+1];
             
             
        }
        

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "Cs.g"; }


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
    	
    	/**
    	 * a collection to store all anonymous tokens
    	 */
    	private java.util.List<org.antlr.runtime3_2_0.CommonToken> anonymousTokens = new java.util.ArrayList<org.antlr.runtime3_2_0.CommonToken>();
    	
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
    		int followSetID = 156;
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
    		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(element);
    		for (org.antlr.runtime3_2_0.CommonToken anonymousToken : anonymousTokens) {
    			layoutInformationAdapter.addLayoutInformation(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLayoutInformation(syntaxElement, object, anonymousToken.getStartIndex(), anonymousToken.getText(), ""));
    		}
    		anonymousTokens.clear();
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
    		org.antlr.runtime3_2_0.CommonToken firstToken = null;
    		for (int pos = this.lastPosition2; pos <= endPos; pos++) {
    			org.antlr.runtime3_2_0.Token token = getTokenStream().get(pos);
    			if (firstToken == null) {
    				firstToken = (org.antlr.runtime3_2_0.CommonToken) token;
    			}
    			int _channel = token.getChannel();
    			if (_channel == 99) {
    				hiddenTokenText.append(token.getText());
    			} else {
    				visibleTokenText.append(token.getText());
    			}
    		}
    		int offset = -1;
    		if (firstToken != null) {
    			offset = firstToken.getStartIndex();
    		}
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
    	



    // $ANTLR start "start"
    // Cs.g:713:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Cs.g:714:1: ( (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF )
            // Cs.g:715:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 0));
              		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
              	
            }
            // Cs.g:722:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax )
            // Cs.g:723:3: c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_in_start82);
            c0=parse_org_emftext_sdk_concretesyntax_ConcreteSyntax();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

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
    // Cs.g:728:1: parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )* a32= '}' ;
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
            // Cs.g:731:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )* a32= '}' )
            // Cs.g:732:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )* a32= '}'
            {
            // Cs.g:732:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==47) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Cs.g:733:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:733:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:734:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:734:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:735:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax127);
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
            	      							completedElement(a0_0, true);
            	      						}
            	      						collectHiddenTokens(element);
            	      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_0_0_0_0, a0_0);
            	      						copyLocalizationInfos(a0_0, element);
            	      					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 1));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 2, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 2, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 2));
              	
            }
            // Cs.g:769:2: ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==45) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Cs.g:770:3: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )
                    {
                    // Cs.g:770:3: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )
                    // Cs.g:771:4: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    {
                    // Cs.g:771:4: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    // Cs.g:772:5: a1_0= parse_org_emftext_sdk_concretesyntax_Abstract
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax183);
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
                      							completedElement(a1_0, true);
                      						}
                      						collectHiddenTokens(element);
                      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_1_0_0_0, a1_0);
                      						copyLocalizationInfos(a1_0, element);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 3));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 4));
              	
            }
            a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax224); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_2, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_3, 5));
              	
            }
            // Cs.g:816:2: (a3= QUALIFIED_NAME )
            // Cs.g:817:3: a3= QUALIFIED_NAME
            {
            a3=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax242); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_4, 6));
              	
            }
            a4=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax263); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_6, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_5, 7));
              	
            }
            // Cs.g:864:2: (a5= QUOTED_60_62 )
            // Cs.g:865:3: a5= QUOTED_60_62
            {
            a5=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax281); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_6, 8));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_7, 8));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 8));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 8));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 8));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 8));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 8));
              	
            }
            // Cs.g:908:2: ( ( (a6= QUOTED_60_62 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QUOTED_60_62) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Cs.g:909:3: ( (a6= QUOTED_60_62 ) )
                    {
                    // Cs.g:909:3: ( (a6= QUOTED_60_62 ) )
                    // Cs.g:910:4: (a6= QUOTED_60_62 )
                    {
                    // Cs.g:910:4: (a6= QUOTED_60_62 )
                    // Cs.g:911:5: a6= QUOTED_60_62
                    {
                    a6=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax317); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_7, 9));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 9));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 9));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 9));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 9));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 9));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_7, 10));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 10));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 10));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 10));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 10));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 10));
              	
            }
            // Cs.g:961:2: ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Cs.g:962:3: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    {
                    // Cs.g:962:3: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    // Cs.g:963:4: a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    {
                    a7=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax372); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_0, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_13, 11));
                      			
                    }
                    // Cs.g:977:4: ( (a8= QUALIFIED_NAME ) )
                    // Cs.g:978:5: (a8= QUALIFIED_NAME )
                    {
                    // Cs.g:978:5: (a8= QUALIFIED_NAME )
                    // Cs.g:979:6: a8= QUALIFIED_NAME
                    {
                    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax405); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      					// expected elements (follow set)
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 12));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 12));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 12));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 12));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 12));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 12));
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 13));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 13));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 13));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 13));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 13));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 13));
                      			
                    }
                    // Cs.g:1032:4: ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==18) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Cs.g:1033:5: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    {
                    	    // Cs.g:1033:5: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    // Cs.g:1034:6: a9= ',' ( (a10= QUALIFIED_NAME ) )
                    	    {
                    	    a9=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax470); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_3_0_0_0, null);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_15, 14));
                    	      					
                    	    }
                    	    // Cs.g:1048:6: ( (a10= QUALIFIED_NAME ) )
                    	    // Cs.g:1049:7: (a10= QUALIFIED_NAME )
                    	    {
                    	    // Cs.g:1049:7: (a10= QUALIFIED_NAME )
                    	    // Cs.g:1050:8: a10= QUALIFIED_NAME
                    	    {
                    	    a10=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax513); if (state.failed) return element;
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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      							// expected elements (follow set)
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 15));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 15));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 15));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 15));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 15));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 15));
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 16));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 16));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 16));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 16));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 16));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 16));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_14, 17));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 17));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 17));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 17));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 17));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 17));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_8, 18));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 18));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 18));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 18));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 18));
              	
            }
            // Cs.g:1126:2: ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Cs.g:1127:3: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    {
                    // Cs.g:1127:3: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    // Cs.g:1128:4: a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}'
                    {
                    a11=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax628); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_2, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_16, 19));
                      			
                    }
                    a12=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax648); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_4, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 20, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 20));
                      			
                    }
                    // Cs.g:1157:4: ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==QUALIFIED_NAME) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Cs.g:1158:5: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    {
                    	    // Cs.g:1158:5: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    // Cs.g:1159:6: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    {
                    	    // Cs.g:1159:6: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    // Cs.g:1160:7: a13_0= parse_org_emftext_sdk_concretesyntax_Import
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax689);
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
                    	      									completedElement(a13_0, true);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_5_0_0_1, a13_0);
                    	      								copyLocalizationInfos(a13_0, element);
                    	      							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 21, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 21));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 22, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 22));
                      			
                    }
                    a14=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax750); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_7, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 23));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 23));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 23));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 23));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_9, 24));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 24));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 24));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 24));
              	
            }
            // Cs.g:1219:2: ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Cs.g:1220:3: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    {
                    // Cs.g:1220:3: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    // Cs.g:1221:4: a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}'
                    {
                    a15=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax792); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_2, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a15, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_19, 25));
                      			
                    }
                    a16=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax812); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_4, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_20, 26, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_21, 26));
                      			
                    }
                    // Cs.g:1250:4: ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==QUALIFIED_NAME) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Cs.g:1251:5: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    {
                    	    // Cs.g:1251:5: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    // Cs.g:1252:6: (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';'
                    	    {
                    	    // Cs.g:1252:6: (a17_0= parse_org_emftext_sdk_concretesyntax_Option )
                    	    // Cs.g:1253:7: a17_0= parse_org_emftext_sdk_concretesyntax_Option
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax853);
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
                    	      									completedElement(a17_0, true);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_5_0_0_1, a17_0);
                    	      								copyLocalizationInfos(a17_0, element);
                    	      							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_22, 27));
                    	      					
                    	    }
                    	    a18=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax891); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_5_0_0_2, null);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a18, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_20, 28, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_21, 28));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_20, 29, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_3));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_21, 29));
                      			
                    }
                    a19=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax940); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_7, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a19, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 30));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 30));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 30));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_10, 31));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 31));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 31));
              	
            }
            // Cs.g:1324:2: ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Cs.g:1325:3: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    {
                    // Cs.g:1325:3: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    // Cs.g:1326:4: a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}'
                    {
                    a20=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax982); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_2, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a20, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_23, 32));
                      			
                    }
                    a21=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1002); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_4, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a21, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 33, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 33, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 33, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_26, 33, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_27, 33));
                      			
                    }
                    // Cs.g:1358:4: ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==37||LA10_0==42||LA10_0==47) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // Cs.g:1359:5: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    {
                    	    // Cs.g:1359:5: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    // Cs.g:1360:6: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';'
                    	    {
                    	    // Cs.g:1360:6: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective )
                    	    // Cs.g:1361:7: a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1043);
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
                    	      									completedElement(a22_0, true);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_5_0_0_1, a22_0);
                    	      								copyLocalizationInfos(a22_0, element);
                    	      							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 34));
                    	      					
                    	    }
                    	    a23=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1081); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_5_0_0_2, null);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a23, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_26, 35, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_27, 35));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 36, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 36, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_25, 36, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_26, 36, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_4));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_27, 36));
                      			
                    }
                    a24=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1130); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_7, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a24, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 37));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 37));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_11, 38));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 38));
              	
            }
            // Cs.g:1436:2: ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Cs.g:1437:3: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    {
                    // Cs.g:1437:3: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    // Cs.g:1438:4: a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}'
                    {
                    a25=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1172); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_2, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a25, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_29, 39));
                      			
                    }
                    a26=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1192); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_4, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a26, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_30, 40, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 40));
                      			
                    }
                    // Cs.g:1467:4: ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==STRING) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Cs.g:1468:5: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    {
                    	    // Cs.g:1468:5: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    // Cs.g:1469:6: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    {
                    	    // Cs.g:1469:6: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    // Cs.g:1470:7: a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1233);
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
                    	      									completedElement(a27_0, true);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_5_0_0_1, a27_0);
                    	      								copyLocalizationInfos(a27_0, element);
                    	      							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_30, 41, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 41));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_30, 42, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 42));
                      			
                    }
                    a28=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1294); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_7, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a28, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 43));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_12, 44));
              	
            }
            a29=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1327); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_18, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a29, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_32, 45));
              	
            }
            a30=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1341); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_20, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a30, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 46, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 46, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 46));
              	
            }
            // Cs.g:1553:2: ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==QUALIFIED_NAME||LA14_0==47) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Cs.g:1554:3: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )
            	    {
            	    // Cs.g:1554:3: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )
            	    // Cs.g:1555:4: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    {
            	    // Cs.g:1555:4: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    // Cs.g:1556:5: a31_0= parse_org_emftext_sdk_concretesyntax_Rule
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1370);
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
            	      							completedElement(a31_0, true);
            	      						}
            	      						collectHiddenTokens(element);
            	      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_21_0_0_1, a31_0);
            	      						copyLocalizationInfos(a31_0, element);
            	      					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 47, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 47, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 47));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 48, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 48, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 48));
              	
            }
            a32=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1411); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_23, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a32, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              	
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
    // Cs.g:1605:1: parse_org_emftext_sdk_concretesyntax_Import returns [org.emftext.sdk.concretesyntax.Import element = null] : (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? ;
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
            // Cs.g:1608:1: ( (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? )
            // Cs.g:1609:2: (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            {
            // Cs.g:1609:2: (a0= QUALIFIED_NAME )
            // Cs.g:1610:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1444); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_35, 50));
              	
            }
            a1=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Import1465); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_36, 51));
              	
            }
            // Cs.g:1657:2: (a2= QUOTED_60_62 )
            // Cs.g:1658:3: a2= QUOTED_60_62
            {
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1483); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_37, 52));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_38, 52));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 52, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 52));
              	
            }
            // Cs.g:1698:2: ( ( (a3= QUOTED_60_62 ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==QUOTED_60_62) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // Cs.g:1699:3: ( (a3= QUOTED_60_62 ) )
                    {
                    // Cs.g:1699:3: ( (a3= QUOTED_60_62 ) )
                    // Cs.g:1700:4: (a3= QUOTED_60_62 )
                    {
                    // Cs.g:1700:4: (a3= QUOTED_60_62 )
                    // Cs.g:1701:5: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1519); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_38, 53));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 53, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 53));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_38, 54));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 54, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 54));
              	
            }
            // Cs.g:1745:2: ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Cs.g:1746:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    {
                    // Cs.g:1746:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    // Cs.g:1747:4: a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )?
                    {
                    a4=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_Import1574); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_1, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_39, 55));
                      			
                    }
                    a5=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_Import1594); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_3, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_40, 56));
                      			
                    }
                    // Cs.g:1775:4: (a6= QUALIFIED_NAME )
                    // Cs.g:1776:5: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1620); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_41, 57));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 57, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 57));
                      			
                    }
                    // Cs.g:1815:4: ( ( (a7= QUOTED_60_62 ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==QUOTED_60_62) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // Cs.g:1816:5: ( (a7= QUOTED_60_62 ) )
                            {
                            // Cs.g:1816:5: ( (a7= QUOTED_60_62 ) )
                            // Cs.g:1817:6: (a7= QUOTED_60_62 )
                            {
                            // Cs.g:1817:6: (a7= QUOTED_60_62 )
                            // Cs.g:1818:7: a7= QUOTED_60_62
                            {
                            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1674); if (state.failed) return element;
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

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 58, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
                              						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 58));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 59, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 59));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_17, 60, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_18, 60));
              	
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
    // Cs.g:1870:1: parse_org_emftext_sdk_concretesyntax_Option returns [org.emftext.sdk.concretesyntax.Option element = null] : (a0= QUALIFIED_NAME ) a1= '=' (a2= STRING ) ;
    public final org.emftext.sdk.concretesyntax.Option parse_org_emftext_sdk_concretesyntax_Option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;
        int parse_org_emftext_sdk_concretesyntax_Option_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Cs.g:1873:1: ( (a0= QUALIFIED_NAME ) a1= '=' (a2= STRING ) )
            // Cs.g:1874:2: (a0= QUALIFIED_NAME ) a1= '=' (a2= STRING )
            {
            // Cs.g:1874:2: (a0= QUALIFIED_NAME )
            // Cs.g:1875:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1774); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_42, 61));
              	
            }
            a1=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_Option1795); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_43, 62));
              	
            }
            // Cs.g:1922:2: (a2= STRING )
            // Cs.g:1923:3: a2= STRING
            {
            a2=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_Option1813); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_22, 63));
              	
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
    // Cs.g:1958:1: parse_org_emftext_sdk_concretesyntax_Rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' ;
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
            // Cs.g:1961:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' )
            // Cs.g:1962:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';'
            {
            // Cs.g:1962:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==47) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Cs.g:1963:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:1963:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:1964:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:1964:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:1965:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1864);
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
            	      							completedElement(a0_0, true);
            	      						}
            	      						collectHiddenTokens(element);
            	      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_0_0_0_0, a0_0);
            	      						copyLocalizationInfos(a0_0, element);
            	      					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 64, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 64));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 65, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 65));
              	
            }
            // Cs.g:1997:2: (a1= QUALIFIED_NAME )
            // Cs.g:1998:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1909); if (state.failed) return element;
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
              				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_1, proxy);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_44, 66));
              	
            }
            a2=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_Rule1930); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Cs.g:2056:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // Cs.g:2057:3: a3_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1948);
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
              					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__CHILDREN, a3_0);
              					completedElement(a3_0, true);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_4, a3_0);
              				copyLocalizationInfos(a3_0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 68));
              	
            }
            a4=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_Rule1966); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 69, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 69, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_6));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_34, 69));
              	
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
    // Cs.g:2098:1: parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence parse_org_emftext_sdk_concretesyntax_Sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;
        int parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.Definition a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Cs.g:2101:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ )
            // Cs.g:2102:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
            {
            // Cs.g:2102:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==QUALIFIED_NAME||LA19_0==STRING||(LA19_0>=HEXNUMBER && LA19_0<=TABNUMBER)||LA19_0==35) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Cs.g:2103:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    {
            	    // Cs.g:2103:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    // Cs.g:2104:4: a0_0= parse_org_emftext_sdk_concretesyntax_Definition
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence2004);
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
            	      						addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__CHILDREN, a0_0);
            	      						completedElement(a0_0, true);
            	      					}
            	      					collectHiddenTokens(element);
            	      					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_4_0_0_0, a0_0);
            	      					copyLocalizationInfos(a0_0, element);
            	      				}
            	      			
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
    // Cs.g:2140:1: parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice parse_org_emftext_sdk_concretesyntax_Choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;
        int parse_org_emftext_sdk_concretesyntax_Choice_StartIndex = input.index();
        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0_0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Cs.g:2143:1: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* )
            // Cs.g:2144:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            {
            // Cs.g:2144:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            // Cs.g:2145:3: a0_0= parse_org_emftext_sdk_concretesyntax_Sequence
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2049);
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
              					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__CHILDREN, a0_0);
              					completedElement(a0_0, true);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_0, a0_0);
              				copyLocalizationInfos(a0_0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 71));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 71));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 71));
              	
            }
            // Cs.g:2170:2: ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==32) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Cs.g:2171:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    {
            	    // Cs.g:2171:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    // Cs.g:2172:4: a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    {
            	    a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_Choice2076); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_1_0_0_0, null);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

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
            	    // Cs.g:2193:4: (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    // Cs.g:2194:5: a2_0= parse_org_emftext_sdk_concretesyntax_Sequence
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2102);
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
            	      							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__CHILDREN, a2_0);
            	      							completedElement(a2_0, true);
            	      						}
            	      						collectHiddenTokens(element);
            	      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_1_0_0_1, a2_0);
            	      						copyLocalizationInfos(a2_0, element);
            	      					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 73));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 73));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 73));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 74));
              	
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
    // Cs.g:2230:1: parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null] : (a0= STRING ) ;
    public final org.emftext.sdk.concretesyntax.CsString parse_org_emftext_sdk_concretesyntax_CsString() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;
        int parse_org_emftext_sdk_concretesyntax_CsString_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Cs.g:2233:1: ( (a0= STRING ) )
            // Cs.g:2234:2: (a0= STRING )
            {
            // Cs.g:2234:2: (a0= STRING )
            // Cs.g:2235:3: a0= STRING
            {
            a0=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_CsString2162); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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
    // Cs.g:2280:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            // Cs.g:2283:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Cs.g:2284:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // Cs.g:2284:2: (a0= QUALIFIED_NAME )
            // Cs.g:2285:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2202); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_56, 76));
              	
            }
            a1=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2223); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_57, 77));
              	
            }
            // Cs.g:2336:2: (a2= QUALIFIED_NAME )
            // Cs.g:2337:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2241); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_58, 78));
              	
            }
            a3=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2262); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Cs.g:2401:2: ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38||(LA21_0>=43 && LA21_0<=44)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Cs.g:2402:3: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Cs.g:2402:3: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Cs.g:2403:4: a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2285);
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
                      						completedElement(a4_0, true);
                      					}
                      					collectHiddenTokens(element);
                      					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_4, a4_0);
                      					copyLocalizationInfos(a4_0, element);
                      				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
    // Cs.g:2439:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element =  null;
        int parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // Cs.g:2442:1: ( (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Cs.g:2443:2: (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // Cs.g:2443:2: (a0= QUALIFIED_NAME )
            // Cs.g:2444:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2330); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_62, 81));
              	
            }
            a1=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2351); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_63, 82));
              	
            }
            a2=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2365); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_2, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Cs.g:2522:2: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==38||(LA22_0>=43 && LA22_0<=44)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // Cs.g:2523:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Cs.g:2523:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Cs.g:2524:4: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2388);
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
                      						completedElement(a3_0, true);
                      					}
                      					collectHiddenTokens(element);
                      					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_3, a3_0);
                      					copyLocalizationInfos(a3_0, element);
                      				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
    // Cs.g:2560:1: parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            // Cs.g:2563:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Cs.g:2564:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // Cs.g:2564:2: (a0= QUALIFIED_NAME )
            // Cs.g:2565:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2433); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_64, 85));
              	
            }
            a1=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2454); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_65, 86));
              	
            }
            // Cs.g:2616:2: (a2= QUOTED_39_39_92 )
            // Cs.g:2617:3: a2= QUOTED_39_39_92
            {
            a2=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2472); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_66, 87));
              	
            }
            a3=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2493); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_67, 88));
              	
            }
            // Cs.g:2664:2: (a4= QUOTED_39_39_92 )
            // Cs.g:2665:3: a4= QUOTED_39_39_92
            {
            a4=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2511); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_68, 89));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_69, 89));
              	
            }
            // Cs.g:2699:2: ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==18) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Cs.g:2700:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    {
                    // Cs.g:2700:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    // Cs.g:2701:4: a5= ',' (a6= QUOTED_39_39_92 )
                    {
                    a5=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2541); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_0, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_70, 90));
                      			
                    }
                    // Cs.g:2715:4: (a6= QUOTED_39_39_92 )
                    // Cs.g:2716:5: a6= QUOTED_39_39_92
                    {
                    a6=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2567); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_69, 91));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_69, 92));
              	
            }
            a7=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2613); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_6, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Cs.g:2783:2: ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38||(LA24_0>=43 && LA24_0<=44)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Cs.g:2784:3: (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Cs.g:2784:3: (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Cs.g:2785:4: a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2636);
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
                      						completedElement(a8_0, true);
                      					}
                      					collectHiddenTokens(element);
                      					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_8, a8_0);
                      					copyLocalizationInfos(a8_0, element);
                      				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
    // Cs.g:2821:1: parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            // Cs.g:2824:1: ( (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Cs.g:2825:2: (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // Cs.g:2825:2: (a0= QUALIFIED_NAME )
            // Cs.g:2826:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2681); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

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
            // Cs.g:2877:2: ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==27) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // Cs.g:2878:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    {
                    // Cs.g:2878:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    // Cs.g:2879:4: a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    {
                    a1=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Containment2711); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_1_0_0_0, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_72, 96));
                      			
                    }
                    // Cs.g:2893:4: (a2= QUALIFIED_NAME )
                    // Cs.g:2894:5: a2= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2737); if (state.failed) return element;
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

                    }

                    if ( state.backtracking==0 ) {

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
                    // Cs.g:2945:4: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==18) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // Cs.g:2946:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    {
                    	    // Cs.g:2946:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    // Cs.g:2947:6: a3= ',' (a4= QUALIFIED_NAME )
                    	    {
                    	    a3=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_Containment2783); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_1_0_0_2_0_0_0, null);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_74, 98));
                    	      					
                    	    }
                    	    // Cs.g:2961:6: (a4= QUALIFIED_NAME )
                    	    // Cs.g:2962:7: a4= QUALIFIED_NAME
                    	    {
                    	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2817); if (state.failed) return element;
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

                    	    }

                    	    if ( state.backtracking==0 ) {

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

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
            // Cs.g:3054:2: ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==38||(LA27_0>=43 && LA27_0<=44)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // Cs.g:3055:3: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Cs.g:3055:3: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Cs.g:3056:4: a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment2907);
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
                      						completedElement(a5_0, true);
                      					}
                      					collectHiddenTokens(element);
                      					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_2, a5_0);
                      					copyLocalizationInfos(a5_0, element);
                      				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
    // Cs.g:3092:1: parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition parse_org_emftext_sdk_concretesyntax_CompoundDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;
        int parse_org_emftext_sdk_concretesyntax_CompoundDefinition_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1_0 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // Cs.g:3095:1: (a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Cs.g:3096:2: a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            a0=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2948); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Cs.g:3117:2: (a1_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // Cs.g:3118:3: a1_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2966);
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
              					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CHILDREN, a1_0);
              					completedElement(a1_0, true);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_1, a1_0);
              				copyLocalizationInfos(a1_0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 104));
              	
            }
            a2=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2984); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_2, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Cs.g:3168:2: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==38||(LA28_0>=43 && LA28_0<=44)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // Cs.g:3169:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Cs.g:3169:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Cs.g:3170:4: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3007);
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
                      						completedElement(a3_0, true);
                      					}
                      					collectHiddenTokens(element);
                      					retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_3, a3_0);
                      					copyLocalizationInfos(a3_0, element);
                      				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
    // Cs.g:3206:1: parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : (a0= HEXNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces parse_org_emftext_sdk_concretesyntax_WhiteSpaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;
        int parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // Cs.g:3209:1: ( (a0= HEXNUMBER ) )
            // Cs.g:3210:2: (a0= HEXNUMBER )
            {
            // Cs.g:3210:2: (a0= HEXNUMBER )
            // Cs.g:3211:3: a0= HEXNUMBER
            {
            a0=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces3052); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

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
    // Cs.g:3256:1: parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : (a0= TABNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.LineBreak parse_org_emftext_sdk_concretesyntax_LineBreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;
        int parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // Cs.g:3259:1: ( (a0= TABNUMBER ) )
            // Cs.g:3260:2: (a0= TABNUMBER )
            {
            // Cs.g:3260:2: (a0= TABNUMBER )
            // Cs.g:3261:3: a0= TABNUMBER
            {
            a0=(Token)match(input,TABNUMBER,FOLLOW_TABNUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak3092); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TABNUMBER");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), resolved);
              					completedElement(resolved, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_0, resolved);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 108, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 108, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 108, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 108, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 108, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 108, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 108, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 108, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 108));
              	
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


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition"
    // Cs.g:3306:1: parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition returns [org.emftext.sdk.concretesyntax.NormalTokenDefinition element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? ;
    public final org.emftext.sdk.concretesyntax.NormalTokenDefinition parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.NormalTokenDefinition element =  null;
        int parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_StartIndex = input.index();
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 = null;

        org.emftext.sdk.concretesyntax.RegexPart a3_0 = null;

        org.emftext.sdk.concretesyntax.RegexPart a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // Cs.g:3309:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? )
            // Cs.g:3310:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            {
            // Cs.g:3310:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==47) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // Cs.g:3311:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:3311:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:3312:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:3312:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:3313:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3143);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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
            	      						copyLocalizationInfos(a0_0, element);
            	      					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 109, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 109));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 110, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 110));
              	
            }
            a1=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3184); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_75, 111));
              	
            }
            // Cs.g:3359:2: (a2= QUALIFIED_NAME )
            // Cs.g:3360:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3202); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_76, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_77, 112, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
              	
            }
            // Cs.g:3394:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Cs.g:3395:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3227);
            a3_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				copyLocalizationInfos(a3_0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 113));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 113));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 113));
              	
            }
            // Cs.g:3420:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==38) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // Cs.g:3421:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Cs.g:3421:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Cs.g:3422:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    {
            	    a4=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3254); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_6_0_0_1, null);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_76, 114, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_77, 114, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
            	      			
            	    }
            	    // Cs.g:3437:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Cs.g:3438:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3280);
            	    a5_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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
            	      						copyLocalizationInfos(a5_0, element);
            	      					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 115));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 115));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 115));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 116));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 116));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 116));
              	
            }
            // Cs.g:3472:2: ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Cs.g:3473:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    {
                    // Cs.g:3473:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    // Cs.g:3474:4: a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME )
                    {
                    a6=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3330); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_7_0_0_1, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_80, 117));
                      			
                    }
                    a7=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3350); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_7_0_0_3, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_81, 118));
                      			
                    }
                    // Cs.g:3502:4: (a8= QUALIFIED_NAME )
                    // Cs.g:3503:5: a8= QUALIFIED_NAME
                    {
                    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3376); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 119));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 120));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition"
    // Cs.g:3545:1: parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition returns [org.emftext.sdk.concretesyntax.PartialTokenDefinition element = null] : a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ;
    public final org.emftext.sdk.concretesyntax.PartialTokenDefinition parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PartialTokenDefinition element =  null;
        int parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.RegexPart a3_0 = null;

        org.emftext.sdk.concretesyntax.RegexPart a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // Cs.g:3548:1: (a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* )
            // Cs.g:3549:2: a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            {
            a0=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3437); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_82, 121));
              	
            }
            a1=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3451); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_2, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_83, 122));
              	
            }
            // Cs.g:3577:2: (a2= QUALIFIED_NAME )
            // Cs.g:3578:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3469); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_76, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_77, 123, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
              	
            }
            // Cs.g:3612:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Cs.g:3613:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3494);
            a3_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				copyLocalizationInfos(a3_0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_84, 124));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 124));
              	
            }
            // Cs.g:3637:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==38) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // Cs.g:3638:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Cs.g:3638:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Cs.g:3639:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    {
            	    a4=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3521); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_7_0_0_1, null);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_76, 125, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_77, 125, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_9));
            	      			
            	    }
            	    // Cs.g:3654:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Cs.g:3655:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3547);
            	    a5_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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
            	      						copyLocalizationInfos(a5_0, element);
            	      					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_84, 126));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 126));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_84, 127));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 127));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective"
    // Cs.g:3689:1: parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null] : a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.TokenPriorityDirective parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenPriorityDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // Cs.g:3692:1: (a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) )
            // Cs.g:3693:2: a0= 'PRIORITIZE' (a1= QUALIFIED_NAME )
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective3603); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_16_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_85, 128));
              	
            }
            // Cs.g:3707:2: (a1= QUALIFIED_NAME )
            // Cs.g:3708:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective3621); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 129));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_AtomicRegex"
    // Cs.g:3747:1: parse_org_emftext_sdk_concretesyntax_AtomicRegex returns [org.emftext.sdk.concretesyntax.AtomicRegex element = null] : (a0= QUOTED_36_36 ) ;
    public final org.emftext.sdk.concretesyntax.AtomicRegex parse_org_emftext_sdk_concretesyntax_AtomicRegex() throws RecognitionException {
        org.emftext.sdk.concretesyntax.AtomicRegex element =  null;
        int parse_org_emftext_sdk_concretesyntax_AtomicRegex_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // Cs.g:3750:1: ( (a0= QUOTED_36_36 ) )
            // Cs.g:3751:2: (a0= QUOTED_36_36 )
            {
            // Cs.g:3751:2: (a0= QUOTED_36_36 )
            // Cs.g:3752:3: a0= QUOTED_36_36
            {
            a0=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_AtomicRegex3661); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 130));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 130));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 130));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_84, 130));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_sdk_concretesyntax_AtomicRegex_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_AtomicRegex"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_RegexReference"
    // Cs.g:3790:1: parse_org_emftext_sdk_concretesyntax_RegexReference returns [org.emftext.sdk.concretesyntax.RegexReference element = null] : (a0= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.RegexReference parse_org_emftext_sdk_concretesyntax_RegexReference() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexReference element =  null;
        int parse_org_emftext_sdk_concretesyntax_RegexReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // Cs.g:3793:1: ( (a0= QUALIFIED_NAME ) )
            // Cs.g:3794:2: (a0= QUALIFIED_NAME )
            {
            // Cs.g:3794:2: (a0= QUALIFIED_NAME )
            // Cs.g:3795:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_RegexReference3701); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_78, 131));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_79, 131));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_28, 131));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_84, 131));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_sdk_concretesyntax_RegexReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_RegexReference"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PLUS"
    // Cs.g:3837:1: parse_org_emftext_sdk_concretesyntax_PLUS returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS parse_org_emftext_sdk_concretesyntax_PLUS() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;
        int parse_org_emftext_sdk_concretesyntax_PLUS_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // Cs.g:3840:1: (a0= '+' )
            // Cs.g:3841:2: a0= '+'
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_PLUS3737); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPLUS();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_45, 132, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_46, 132, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_47, 132, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_48, 132, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_49, 132, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_50, 132, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_51, 132, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_52, 132, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_54, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_53, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_55, 132));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, parse_org_emftext_sdk_concretesyntax_PLUS_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PLUS"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_STAR"
    // Cs.g:3867:1: parse_org_emftext_sdk_concretesyntax_STAR returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR parse_org_emftext_sdk_concretesyntax_STAR() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;
        int parse_org_emftext_sdk_concretesyntax_STAR_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // Cs.g:3870:1: (a0= '*' )
            // Cs.g:3871:2: a0= '*'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_STAR3766); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSTAR();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, parse_org_emftext_sdk_concretesyntax_STAR_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_STAR"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_QUESTIONMARK"
    // Cs.g:3897:1: parse_org_emftext_sdk_concretesyntax_QUESTIONMARK returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK parse_org_emftext_sdk_concretesyntax_QUESTIONMARK() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;
        int parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // Cs.g:3900:1: (a0= '?' )
            // Cs.g:3901:2: a0= '?'
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK3795); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_21_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_QUESTIONMARK"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Abstract"
    // Cs.g:3927:1: parse_org_emftext_sdk_concretesyntax_Abstract returns [org.emftext.sdk.concretesyntax.Abstract element = null] : a0= 'ABSTRACT' ;
    public final org.emftext.sdk.concretesyntax.Abstract parse_org_emftext_sdk_concretesyntax_Abstract() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Abstract element =  null;
        int parse_org_emftext_sdk_concretesyntax_Abstract_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // Cs.g:3930:1: (a0= 'ABSTRACT' )
            // Cs.g:3931:2: a0= 'ABSTRACT'
            {
            a0=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_Abstract3824); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAbstract();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_22_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 135));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, parse_org_emftext_sdk_concretesyntax_Abstract_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Abstract"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenStyle"
    // Cs.g:3947:1: parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null] : (a0= STRING ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }
            // Cs.g:3950:1: ( (a0= STRING ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' )
            // Cs.g:3951:2: (a0= STRING ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';'
            {
            // Cs.g:3951:2: (a0= STRING )
            // Cs.g:3952:3: a0= STRING
            {
            a0=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3857); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_86, 136));
              	
            }
            a1=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3878); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_2, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_87, 137));
              	
            }
            // Cs.g:3999:2: (a2= HEXNUMBER )
            // Cs.g:4000:3: a2= HEXNUMBER
            {
            a2=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3896); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_88, 138));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_89, 138));
              	
            }
            // Cs.g:4034:2: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==18) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Cs.g:4035:3: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    {
            	    // Cs.g:4035:3: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    // Cs.g:4036:4: a3= ',' (a4= QUALIFIED_NAME )
            	    {
            	    a3=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3926); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_5_0_0_0, null);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_90, 139));
            	      			
            	    }
            	    // Cs.g:4050:4: (a4= QUALIFIED_NAME )
            	    // Cs.g:4051:5: a4= QUALIFIED_NAME
            	    {
            	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3952); if (state.failed) return element;
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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_88, 140));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_89, 140));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_88, 141));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_89, 141));
              	
            }
            a5=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3998); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_30, 142, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_5));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_31, 142));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, parse_org_emftext_sdk_concretesyntax_TokenStyle_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenStyle"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Annotation"
    // Cs.g:4110:1: parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null] : a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }
            // Cs.g:4113:1: (a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? )
            // Cs.g:4114:2: a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            {
            a0=(Token)match(input,47,FOLLOW_47_in_parse_org_emftext_sdk_concretesyntax_Annotation4027); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_91, 143));
              	
            }
            // Cs.g:4128:2: (a1= QUALIFIED_NAME )
            // Cs.g:4129:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation4045); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_92, 144));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 144, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 144, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 144));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 144));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 144));
              	
            }
            // Cs.g:4167:2: ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==35) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // Cs.g:4168:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    {
                    // Cs.g:4168:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    // Cs.g:4169:4: a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')'
                    {
                    a2=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Annotation4075); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_0, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_93, 145, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_10));
                      			
                    }
                    // Cs.g:4183:4: (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    // Cs.g:4184:5: a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4101);
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
                      							completedElement(a3_0, true);
                      						}
                      						collectHiddenTokens(element);
                      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_1, a3_0);
                      						copyLocalizationInfos(a3_0, element);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_94, 146));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 146));
                      			
                    }
                    // Cs.g:4208:4: ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==18) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // Cs.g:4209:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    {
                    	    // Cs.g:4209:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    // Cs.g:4210:6: a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    {
                    	    a4=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_Annotation4142); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_2_0_0_0, null);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_93, 147, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_10));
                    	      					
                    	    }
                    	    // Cs.g:4224:6: (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    // Cs.g:4225:7: a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4176);
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
                    	      									completedElement(a5_0, true);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_2_0_0_1, a5_0);
                    	      								copyLocalizationInfos(a5_0, element);
                    	      							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_94, 148));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 148));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_94, 149));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 149));
                      			
                    }
                    a6=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_Annotation4237); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_3, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 150, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 150, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 150));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 150));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 150));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_0, 151, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_1, 151, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.FEATURE_1));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_2, 151));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_33, 151));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_24, 151));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, parse_org_emftext_sdk_concretesyntax_Annotation_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Annotation"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_KeyValuePair"
    // Cs.g:4288:1: parse_org_emftext_sdk_concretesyntax_KeyValuePair returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null] : (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= STRING ) ) )? ;
    public final org.emftext.sdk.concretesyntax.KeyValuePair parse_org_emftext_sdk_concretesyntax_KeyValuePair() throws RecognitionException {
        org.emftext.sdk.concretesyntax.KeyValuePair element =  null;
        int parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }
            // Cs.g:4291:1: ( (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= STRING ) ) )? )
            // Cs.g:4292:2: (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= STRING ) ) )?
            {
            // Cs.g:4292:2: (a0= QUALIFIED_NAME )
            // Cs.g:4293:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4289); if (state.failed) return element;
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_96, 152));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_94, 152));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 152));
              	
            }
            // Cs.g:4328:2: ( (a1= '=' (a2= STRING ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==30) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // Cs.g:4329:3: (a1= '=' (a2= STRING ) )
                    {
                    // Cs.g:4329:3: (a1= '=' (a2= STRING ) )
                    // Cs.g:4330:4: a1= '=' (a2= STRING )
                    {
                    a1=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4319); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_0, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_97, 153));
                      			
                    }
                    // Cs.g:4344:4: (a2= STRING )
                    // Cs.g:4345:5: a2= STRING
                    {
                    a2=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4345); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_94, 154));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 154));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_94, 155));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsFollowSetProvider.TERMINAL_95, 155));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_KeyValuePair"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenDirective"
    // Cs.g:4389:1: parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null] : (c0= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition | c1= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition | c2= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective );
    public final org.emftext.sdk.concretesyntax.TokenDirective parse_org_emftext_sdk_concretesyntax_TokenDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.NormalTokenDefinition c0 = null;

        org.emftext.sdk.concretesyntax.PartialTokenDefinition c1 = null;

        org.emftext.sdk.concretesyntax.TokenPriorityDirective c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }
            // Cs.g:4390:1: (c0= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition | c1= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition | c2= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective )
            int alt37=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt37=1;
                }
                break;
            case 37:
                {
                int LA37_2 = input.LA(2);

                if ( (LA37_2==41) ) {
                    alt37=2;
                }
                else if ( (LA37_2==QUALIFIED_NAME) ) {
                    alt37=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 2, input);

                    throw nvae;
                }
                }
                break;
            case 42:
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
                    // Cs.g:4391:2: c0= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4402);
                    c0=parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Cs.g:4392:4: c1= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4412);
                    c1=parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Cs.g:4393:4: c2= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4422);
                    c2=parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 28, parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenDirective"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Definition"
    // Cs.g:4397:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }
            // Cs.g:4398:1: (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak )
            int alt38=8;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // Cs.g:4399:2: c0= parse_org_emftext_sdk_concretesyntax_CsString
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition4443);
                    c0=parse_org_emftext_sdk_concretesyntax_CsString();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Cs.g:4400:4: c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition4453);
                    c1=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Cs.g:4401:4: c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition4463);
                    c2=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 4 :
                    // Cs.g:4402:4: c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition4473);
                    c3=parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 5 :
                    // Cs.g:4403:4: c4= parse_org_emftext_sdk_concretesyntax_Containment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition4483);
                    c4=parse_org_emftext_sdk_concretesyntax_Containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 6 :
                    // Cs.g:4404:4: c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition4493);
                    c5=parse_org_emftext_sdk_concretesyntax_CompoundDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 7 :
                    // Cs.g:4405:4: c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition4503);
                    c6=parse_org_emftext_sdk_concretesyntax_WhiteSpaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c6; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 8 :
                    // Cs.g:4406:4: c7= parse_org_emftext_sdk_concretesyntax_LineBreak
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition4513);
                    c7=parse_org_emftext_sdk_concretesyntax_LineBreak();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c7; /* this is a subclass or primitive expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 29, parse_org_emftext_sdk_concretesyntax_Definition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Definition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Cardinality"
    // Cs.g:4410:1: parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK );
    public final org.emftext.sdk.concretesyntax.Cardinality parse_org_emftext_sdk_concretesyntax_Cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;
        int parse_org_emftext_sdk_concretesyntax_Cardinality_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }
            // Cs.g:4411:1: (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt39=1;
                }
                break;
            case 43:
                {
                alt39=2;
                }
                break;
            case 44:
                {
                alt39=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // Cs.g:4412:2: c0= parse_org_emftext_sdk_concretesyntax_PLUS
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality4534);
                    c0=parse_org_emftext_sdk_concretesyntax_PLUS();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Cs.g:4413:4: c1= parse_org_emftext_sdk_concretesyntax_STAR
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality4544);
                    c1=parse_org_emftext_sdk_concretesyntax_STAR();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Cs.g:4414:4: c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality4554);
                    c2=parse_org_emftext_sdk_concretesyntax_QUESTIONMARK();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 30, parse_org_emftext_sdk_concretesyntax_Cardinality_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Cardinality"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_RegexPart"
    // Cs.g:4418:1: parse_org_emftext_sdk_concretesyntax_RegexPart returns [org.emftext.sdk.concretesyntax.RegexPart element = null] : (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex | c1= parse_org_emftext_sdk_concretesyntax_RegexReference );
    public final org.emftext.sdk.concretesyntax.RegexPart parse_org_emftext_sdk_concretesyntax_RegexPart() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexPart element =  null;
        int parse_org_emftext_sdk_concretesyntax_RegexPart_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.AtomicRegex c0 = null;

        org.emftext.sdk.concretesyntax.RegexReference c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }
            // Cs.g:4419:1: (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex | c1= parse_org_emftext_sdk_concretesyntax_RegexReference )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==QUOTED_36_36) ) {
                alt40=1;
            }
            else if ( (LA40_0==QUALIFIED_NAME) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // Cs.g:4420:2: c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_AtomicRegex_in_parse_org_emftext_sdk_concretesyntax_RegexPart4575);
                    c0=parse_org_emftext_sdk_concretesyntax_AtomicRegex();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Cs.g:4421:4: c1= parse_org_emftext_sdk_concretesyntax_RegexReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexReference_in_parse_org_emftext_sdk_concretesyntax_RegexPart4585);
                    c1=parse_org_emftext_sdk_concretesyntax_RegexReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 31, parse_org_emftext_sdk_concretesyntax_RegexPart_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_RegexPart"

    // Delegated rules


    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA38_eotS =
        "\13\uffff";
    static final String DFA38_eofS =
        "\2\uffff\1\6\10\uffff";
    static final String DFA38_minS =
        "\1\4\1\uffff\1\4\4\uffff\1\4\3\uffff";
    static final String DFA38_maxS =
        "\1\43\1\uffff\1\54\4\uffff\1\42\3\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\1\1\uffff\1\6\1\7\1\10\1\5\1\uffff\1\3\1\4\1\2";
    static final String DFA38_specialS =
        "\13\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\2\1\uffff\1\1\1\uffff\1\4\1\5\31\uffff\1\3",
            "",
            "\1\6\1\uffff\1\6\1\uffff\2\6\15\uffff\1\6\3\uffff\1\6\4\uffff"+
            "\1\6\1\7\1\uffff\2\6\1\uffff\1\6\4\uffff\2\6",
            "",
            "",
            "",
            "",
            "\1\12\2\uffff\1\11\32\uffff\1\10",
            "",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "4397:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak );";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax127 = new BitSet(new long[]{0x0000A00000008000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax183 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax242 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax263 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax281 = new BitSet(new long[]{0x00000000074A0020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax317 = new BitSet(new long[]{0x00000000074A0000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax405 = new BitSet(new long[]{0x00000000074C0000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax470 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax513 = new BitSet(new long[]{0x00000000074C0000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax628 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax648 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax689 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax750 = new BitSet(new long[]{0x0000000007400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax792 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax812 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax853 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax891 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax940 = new BitSet(new long[]{0x0000000007000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax982 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1002 = new BitSet(new long[]{0x0000A42000208000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1043 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1081 = new BitSet(new long[]{0x0000A42000208000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1130 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1172 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1192 = new BitSet(new long[]{0x0000000000200040L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1233 = new BitSet(new long[]{0x0000000000200040L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1294 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1327 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1341 = new BitSet(new long[]{0x0000A00000208010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1370 = new BitSet(new long[]{0x0000A00000208010L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1444 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Import1465 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1483 = new BitSet(new long[]{0x0000000010000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1519 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_Import1574 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_Import1594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1620 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1774 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_Option1795 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_Option1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1864 = new BitSet(new long[]{0x0000A00000008010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1909 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_Rule1930 = new BitSet(new long[]{0x0000000800000350L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1948 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_Rule1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence2004 = new BitSet(new long[]{0x0000000800000352L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2049 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_Choice2076 = new BitSet(new long[]{0x0000000800000350L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2102 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_CsString2162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2202 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2241 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2262 = new BitSet(new long[]{0x0000184000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2330 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2351 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2365 = new BitSet(new long[]{0x0000184000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2433 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2454 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2472 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2493 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2511 = new BitSet(new long[]{0x0000000400040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2541 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2567 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2613 = new BitSet(new long[]{0x0000184000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2681 = new BitSet(new long[]{0x0000184008000002L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Containment2711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2737 = new BitSet(new long[]{0x0000184000040002L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_Containment2783 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2817 = new BitSet(new long[]{0x0000184000040002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2948 = new BitSet(new long[]{0x0000000800000350L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2966 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2984 = new BitSet(new long[]{0x0000184000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces3052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABNUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3143 = new BitSet(new long[]{0x0000A02000008000L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3184 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3202 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3227 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3254 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3280 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3330 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3350 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3437 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3451 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3469 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3494 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3521 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3547 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective3603 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective3621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_AtomicRegex3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_RegexReference3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_PLUS3737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_STAR3766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_Abstract3824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3857 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3878 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3896 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3926 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3952 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_parse_org_emftext_sdk_concretesyntax_Annotation4027 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation4045 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Annotation4075 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4101 = new BitSet(new long[]{0x0000001000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_Annotation4142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4176 = new BitSet(new long[]{0x0000001000040000L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_Annotation4237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4289 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4319 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition4443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition4453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition4483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition4493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition4503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition4513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality4534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality4544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality4554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_AtomicRegex_in_parse_org_emftext_sdk_concretesyntax_RegexPart4575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexReference_in_parse_org_emftext_sdk_concretesyntax_RegexPart4585 = new BitSet(new long[]{0x0000000000000002L});

}