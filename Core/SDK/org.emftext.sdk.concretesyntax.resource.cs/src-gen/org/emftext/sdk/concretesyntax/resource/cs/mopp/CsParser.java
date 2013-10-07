// $ANTLR 3.4

	package org.emftext.sdk.concretesyntax.resource.cs.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CsParser extends CsANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENTS", "HEXNUMBER", "LINEBREAK", "QUALIFIED_NAME", "QUOTED_36_36", "QUOTED_39_39_92", "QUOTED_60_62", "STRING", "TABNUMBER", "WHITESPACE", "'('", "')'", "'*'", "'+'", "','", "':'", "'::='", "';'", "'='", "'?'", "'@'", "'ABSTRACT'", "'AS'", "'COLLECT'", "'COLOR'", "'DEFINE'", "'FOR'", "'FRAGMENT'", "'IMPORTS'", "'IN'", "'OPTIONS'", "'PRIORITIZE'", "'REDEFINE'", "'RULES'", "'START'", "'SYNTAX'", "'SYNTAXDEF'", "'TOKENS'", "'TOKENSTYLES'", "'WITH'", "'['", "']'", "'{'", "'|'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int COMMENTS=4;
    public static final int HEXNUMBER=5;
    public static final int LINEBREAK=6;
    public static final int QUALIFIED_NAME=7;
    public static final int QUOTED_36_36=8;
    public static final int QUOTED_39_39_92=9;
    public static final int QUOTED_60_62=10;
    public static final int STRING=11;
    public static final int TABNUMBER=12;
    public static final int WHITESPACE=13;

    // delegates
    public CsANTLRParserBase[] getDelegates() {
        return new CsANTLRParserBase[] {};
    }

    // delegators


    public CsParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CsParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(100 + 1);
         

    }

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "Cs.g"; }


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
    	protected java.util.List<Integer> lexerExceptionPositions = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
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
    	
    	private org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap;
    	
    	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxErrorMessageConverter syntaxErrorMessageConverter = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsSyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException re) {
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
    					public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> getQuickFixes() {
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
    	
    	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
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
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
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
    	protected void setLocalizationEnd(java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
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
    	
    	public org.emftext.sdk.concretesyntax.resource.cs.ICsTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new CsParser(new org.antlr.runtime3_4_0.CommonTokenStream(new CsLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new CsParser(new org.antlr.runtime3_4_0.CommonTokenStream(new CsLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
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
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((CsLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CsLexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
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
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>>();
    		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParseResult parseResult = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsParseResult();
    		if (disableLocationMap) {
    			locationMap = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsDevNullLocationMap();
    		} else {
    			locationMap = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsLocationMap();
    		}
    		// Run parser
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    				parseResult.setLocationMap(locationMap);
    			}
    		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
    			addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
    			addErrorToResource(syntaxErrorMessageConverter.translateLexicalError(re, lexerExceptions, lexerExceptionPositions));
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
    	



    // $ANTLR start "start"
    // Cs.g:531:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Cs.g:532:2: ( (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF )
            // Cs.g:533:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[2]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Cs.g:540:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax )
            // Cs.g:541:3: c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_in_start82);
            c0=parse_org_emftext_sdk_concretesyntax_ConcreteSyntax();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_ConcreteSyntax"
    // Cs.g:549:1: parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1= 'ABSTRACT' )? ) a4= 'SYNTAXDEF' (a5= QUALIFIED_NAME ) a6= 'FOR' (a7= QUOTED_60_62 ) ( ( (a8= QUOTED_60_62 ) ) )? ( (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* ) )? ( (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' ) )? ( (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' ) )? ( (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' ) )? ( (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' ) )? a31= 'RULES' a32= '{' ( ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )* a34= '}' ;
    public final org.emftext.sdk.concretesyntax.ConcreteSyntax parse_org_emftext_sdk_concretesyntax_ConcreteSyntax() throws RecognitionException {
        org.emftext.sdk.concretesyntax.ConcreteSyntax element =  null;

        int parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_StartIndex = input.index();

        Token a1=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;
        Token a20=null;
        Token a21=null;
        Token a22=null;
        Token a23=null;
        Token a25=null;
        Token a26=null;
        Token a27=null;
        Token a28=null;
        Token a30=null;
        Token a31=null;
        Token a32=null;
        Token a34=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 =null;

        org.emftext.sdk.concretesyntax.Import a15_0 =null;

        org.emftext.sdk.concretesyntax.Option a19_0 =null;

        org.emftext.sdk.concretesyntax.TokenDirective a24_0 =null;

        org.emftext.sdk.concretesyntax.TokenStyle a29_0 =null;

        org.emftext.sdk.concretesyntax.Rule a33_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Cs.g:552:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1= 'ABSTRACT' )? ) a4= 'SYNTAXDEF' (a5= QUALIFIED_NAME ) a6= 'FOR' (a7= QUOTED_60_62 ) ( ( (a8= QUOTED_60_62 ) ) )? ( (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* ) )? ( (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' ) )? ( (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' ) )? ( (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' ) )? ( (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' ) )? a31= 'RULES' a32= '{' ( ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )* a34= '}' )
            // Cs.g:553:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1= 'ABSTRACT' )? ) a4= 'SYNTAXDEF' (a5= QUALIFIED_NAME ) a6= 'FOR' (a7= QUOTED_60_62 ) ( ( (a8= QUOTED_60_62 ) ) )? ( (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* ) )? ( (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' ) )? ( (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' ) )? ( (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' ) )? ( (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' ) )? a31= 'RULES' a32= '{' ( ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )* a34= '}'
            {
            // Cs.g:553:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==24) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Cs.g:554:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:554:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:555:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:555:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:556:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax130);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[3]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[4]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[5]);
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
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[8]);
            	}

            // Cs.g:597:2: ( (a1= 'ABSTRACT' )? )
            // Cs.g:598:3: (a1= 'ABSTRACT' )?
            {
            // Cs.g:598:3: (a1= 'ABSTRACT' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Cs.g:599:4: a1= 'ABSTRACT'
                    {
                    a1=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax180); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[9]);
            	}

            a4=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax201); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[10]);
            	}

            // Cs.g:642:2: (a5= QUALIFIED_NAME )
            // Cs.g:643:3: a5= QUALIFIED_NAME
            {
            a5=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax219); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[11]);
            	}

            a6=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax240); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[12]);
            	}

            // Cs.g:702:2: (a7= QUOTED_60_62 )
            // Cs.g:703:3: a7= QUOTED_60_62
            {
            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax258); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[15]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[16]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[19]);
            	}

            // Cs.g:753:2: ( ( (a8= QUOTED_60_62 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QUOTED_60_62) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Cs.g:754:3: ( (a8= QUOTED_60_62 ) )
                    {
                    // Cs.g:754:3: ( (a8= QUOTED_60_62 ) )
                    // Cs.g:755:4: (a8= QUOTED_60_62 )
                    {
                    // Cs.g:755:4: (a8= QUOTED_60_62 )
                    // Cs.g:756:5: a8= QUOTED_60_62
                    {
                    a8=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax294); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[20]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[21]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[22]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[23]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[24]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[25]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[30]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[31]);
            	}

            // Cs.g:813:2: ( (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==38) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Cs.g:814:3: (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* )
                    {
                    // Cs.g:814:3: (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* )
                    // Cs.g:815:4: a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )*
                    {
                    a9=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax349); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[32]);
                    			}

                    // Cs.g:834:4: ( (a10= QUALIFIED_NAME ) )
                    // Cs.g:835:5: (a10= QUALIFIED_NAME )
                    {
                    // Cs.g:835:5: (a10= QUALIFIED_NAME )
                    // Cs.g:836:6: a10= QUALIFIED_NAME
                    {
                    a10=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax382); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    					// expected elements (follow set)
                    					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[33]);
                    					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[34]);
                    					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[35]);
                    					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[36]);
                    					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[37]);
                    					addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[38]);
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[39]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[40]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[41]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[42]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[43]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[44]);
                    			}

                    // Cs.g:896:4: ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==18) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Cs.g:897:5: (a11= ',' ( (a12= QUALIFIED_NAME ) ) )
                    	    {
                    	    // Cs.g:897:5: (a11= ',' ( (a12= QUALIFIED_NAME ) ) )
                    	    // Cs.g:898:6: a11= ',' ( (a12= QUALIFIED_NAME ) )
                    	    {
                    	    a11=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax447); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[45]);
                    	    					}

                    	    // Cs.g:917:6: ( (a12= QUALIFIED_NAME ) )
                    	    // Cs.g:918:7: (a12= QUALIFIED_NAME )
                    	    {
                    	    // Cs.g:918:7: (a12= QUALIFIED_NAME )
                    	    // Cs.g:919:8: a12= QUALIFIED_NAME
                    	    {
                    	    a12=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax490); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    							// expected elements (follow set)
                    	    							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[46]);
                    	    							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[47]);
                    	    							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[48]);
                    	    							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[49]);
                    	    							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[50]);
                    	    							addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[51]);
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[52]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[53]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[54]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[55]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[56]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[57]);
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
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[58]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[59]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[60]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[61]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[62]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[63]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[68]);
            	}

            // Cs.g:1002:2: ( (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==32) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Cs.g:1003:3: (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' )
                    {
                    // Cs.g:1003:3: (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' )
                    // Cs.g:1004:4: a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}'
                    {
                    a13=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax605); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[69]);
                    			}

                    a14=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax625); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[70]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[71]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[72]);
                    			}

                    // Cs.g:1044:4: ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==QUALIFIED_NAME||LA6_0==24) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Cs.g:1045:5: ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    {
                    	    // Cs.g:1045:5: ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    // Cs.g:1046:6: (a15_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    {
                    	    // Cs.g:1046:6: (a15_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    // Cs.g:1047:7: a15_0= parse_org_emftext_sdk_concretesyntax_Import
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax666);
                    	    a15_0=parse_org_emftext_sdk_concretesyntax_Import();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[73]);
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[74]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[75]);
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
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[76]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[77]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[78]);
                    			}

                    a16=(Token)match(input,48,FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax727); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[79]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[80]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[81]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[82]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[83]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[84]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[86]);
            	}

            // Cs.g:1120:2: ( (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==34) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Cs.g:1121:3: (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' )
                    {
                    // Cs.g:1121:3: (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' )
                    // Cs.g:1122:4: a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}'
                    {
                    a17=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax769); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[87]);
                    			}

                    a18=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax789); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[88]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[89]);
                    			}

                    // Cs.g:1161:4: ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==QUALIFIED_NAME) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Cs.g:1162:5: ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' )
                    	    {
                    	    // Cs.g:1162:5: ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' )
                    	    // Cs.g:1163:6: (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';'
                    	    {
                    	    // Cs.g:1163:6: (a19_0= parse_org_emftext_sdk_concretesyntax_Option )
                    	    // Cs.g:1164:7: a19_0= parse_org_emftext_sdk_concretesyntax_Option
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax830);
                    	    a19_0=parse_org_emftext_sdk_concretesyntax_Option();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[90]);
                    	    					}

                    	    a20=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax868); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[91]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[92]);
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
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[93]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[94]);
                    			}

                    a21=(Token)match(input,48,FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax917); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[95]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[96]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[97]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[99]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[100]);
            	}

            // Cs.g:1252:2: ( (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==41) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Cs.g:1253:3: (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' )
                    {
                    // Cs.g:1253:3: (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' )
                    // Cs.g:1254:4: a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}'
                    {
                    a22=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax959); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[101]);
                    			}

                    a23=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax979); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[102]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[103]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[104]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[105]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[106]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[107]);
                    			}

                    // Cs.g:1297:4: ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==24||LA10_0==29||(LA10_0 >= 35 && LA10_0 <= 36)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // Cs.g:1298:5: ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' )
                    	    {
                    	    // Cs.g:1298:5: ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' )
                    	    // Cs.g:1299:6: (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';'
                    	    {
                    	    // Cs.g:1299:6: (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective )
                    	    // Cs.g:1300:7: a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1020);
                    	    a24_0=parse_org_emftext_sdk_concretesyntax_TokenDirective();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[108]);
                    	    					}

                    	    a25=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1058); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[109]);
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[110]);
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[111]);
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[112]);
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[113]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[114]);
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
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[115]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[116]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[117]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[118]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[119]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[120]);
                    			}

                    a26=(Token)match(input,48,FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1107); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[121]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[122]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[124]);
            	}

            // Cs.g:1394:2: ( (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==42) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Cs.g:1395:3: (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' )
                    {
                    // Cs.g:1395:3: (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' )
                    // Cs.g:1396:4: a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}'
                    {
                    a27=(Token)match(input,42,FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1149); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[125]);
                    			}

                    a28=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1169); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[126]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[127]);
                    			}

                    // Cs.g:1435:4: ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==STRING) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Cs.g:1436:5: ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    {
                    	    // Cs.g:1436:5: ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    // Cs.g:1437:6: (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    {
                    	    // Cs.g:1437:6: (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    // Cs.g:1438:7: a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1210);
                    	    a29_0=parse_org_emftext_sdk_concretesyntax_TokenStyle();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[128]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[129]);
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
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[130]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[131]);
                    			}

                    a30=(Token)match(input,48,FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1271); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[132]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[133]);
            	}

            a31=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1304); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[134]);
            	}

            a32=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1318); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[137]);
            	}

            // Cs.g:1543:2: ( ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==QUALIFIED_NAME||LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Cs.g:1544:3: ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) )
            	    {
            	    // Cs.g:1544:3: ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) )
            	    // Cs.g:1545:4: (a33_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    {
            	    // Cs.g:1545:4: (a33_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    // Cs.g:1546:5: a33_0= parse_org_emftext_sdk_concretesyntax_Rule
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1347);
            	    a33_0=parse_org_emftext_sdk_concretesyntax_Rule();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[138]);
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[139]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[140]);
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
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[143]);
            	}

            a34=(Token)match(input,48,FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1388); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_ConcreteSyntax"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Import"
    // Cs.g:1607:1: parse_org_emftext_sdk_concretesyntax_Import returns [org.emftext.sdk.concretesyntax.Import element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= ':' (a3= QUOTED_60_62 ) ( ( (a4= QUOTED_60_62 ) ) )? ( (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? ) )? ;
    public final org.emftext.sdk.concretesyntax.Import parse_org_emftext_sdk_concretesyntax_Import() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Import element =  null;

        int parse_org_emftext_sdk_concretesyntax_Import_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Cs.g:1610:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= ':' (a3= QUOTED_60_62 ) ( ( (a4= QUOTED_60_62 ) ) )? ( (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? ) )? )
            // Cs.g:1611:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= ':' (a3= QUOTED_60_62 ) ( ( (a4= QUOTED_60_62 ) ) )? ( (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? ) )?
            {
            // Cs.g:1611:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Cs.g:1612:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:1612:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:1613:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:1613:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:1614:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Import1432);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[144]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[145]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[146]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[147]);
            	}

            // Cs.g:1648:2: (a1= QUALIFIED_NAME )
            // Cs.g:1649:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1477); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[148]);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_Import1498); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[149]);
            	}

            // Cs.g:1698:2: (a3= QUOTED_60_62 )
            // Cs.g:1699:3: a3= QUOTED_60_62
            {
            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1516); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[153]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[154]);
            	}

            // Cs.g:1742:2: ( ( (a4= QUOTED_60_62 ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==QUOTED_60_62) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Cs.g:1743:3: ( (a4= QUOTED_60_62 ) )
                    {
                    // Cs.g:1743:3: ( (a4= QUOTED_60_62 ) )
                    // Cs.g:1744:4: (a4= QUOTED_60_62 )
                    {
                    // Cs.g:1744:4: (a4= QUOTED_60_62 )
                    // Cs.g:1745:5: a4= QUOTED_60_62
                    {
                    a4=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1552); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[155]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[156]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[157]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[158]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[159]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[160]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[161]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[162]);
            	}

            // Cs.g:1793:2: ( (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==43) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Cs.g:1794:3: (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? )
                    {
                    // Cs.g:1794:3: (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? )
                    // Cs.g:1795:4: a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )?
                    {
                    a5=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_Import1607); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[163]);
                    			}

                    a6=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_Import1627); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_3, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[164]);
                    			}

                    // Cs.g:1823:4: (a7= QUALIFIED_NAME )
                    // Cs.g:1824:5: a7= QUALIFIED_NAME
                    {
                    a7=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1653); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[165]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[166]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[167]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[168]);
                    			}

                    // Cs.g:1866:4: ( ( (a8= QUOTED_60_62 ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==QUOTED_60_62) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // Cs.g:1867:5: ( (a8= QUOTED_60_62 ) )
                            {
                            // Cs.g:1867:5: ( (a8= QUOTED_60_62 ) )
                            // Cs.g:1868:6: (a8= QUOTED_60_62 )
                            {
                            // Cs.g:1868:6: (a8= QUOTED_60_62 )
                            // Cs.g:1869:7: a8= QUOTED_60_62
                            {
                            a8=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1707); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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

                            }


                            if ( state.backtracking==0 ) {
                            						// expected elements (follow set)
                            						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[169]);
                            						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[170]);
                            						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[171]);
                            					}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[172]);
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[173]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[174]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[175]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[177]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_sdk_concretesyntax_Import_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Import"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Option"
    // Cs.g:1926:1: parse_org_emftext_sdk_concretesyntax_Option returns [org.emftext.sdk.concretesyntax.Option element = null] : (a0= QUALIFIED_NAME ) a1= '=' (a2= STRING ) ;
    public final org.emftext.sdk.concretesyntax.Option parse_org_emftext_sdk_concretesyntax_Option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;

        int parse_org_emftext_sdk_concretesyntax_Option_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Cs.g:1929:2: ( (a0= QUALIFIED_NAME ) a1= '=' (a2= STRING ) )
            // Cs.g:1930:2: (a0= QUALIFIED_NAME ) a1= '=' (a2= STRING )
            {
            // Cs.g:1930:2: (a0= QUALIFIED_NAME )
            // Cs.g:1931:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1807); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[178]);
            	}

            a1=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_Option1828); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[179]);
            	}

            // Cs.g:1980:2: (a2= STRING )
            // Cs.g:1981:3: a2= STRING
            {
            a2=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_Option1846); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[180]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_sdk_concretesyntax_Option_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Option"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Rule"
    // Cs.g:2018:1: parse_org_emftext_sdk_concretesyntax_Rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule parse_org_emftext_sdk_concretesyntax_Rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;

        int parse_org_emftext_sdk_concretesyntax_Rule_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 =null;

        org.emftext.sdk.concretesyntax.Choice a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Cs.g:2021:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' )
            // Cs.g:2022:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';'
            {
            // Cs.g:2022:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==24) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Cs.g:2023:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:2023:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:2024:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:2024:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:2025:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1897);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[181]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[182]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[183]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[184]);
            	}

            // Cs.g:2059:2: (a1= QUALIFIED_NAME )
            // Cs.g:2060:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1942); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[185]);
            	}

            a2=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_Rule1963); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
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

            // Cs.g:2122:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // Cs.g:2123:3: a3_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1981);
            a3_0=parse_org_emftext_sdk_concretesyntax_Choice();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[196]);
            	}

            a4=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_Rule1999); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[197]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[198]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[199]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_sdk_concretesyntax_Rule_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Rule"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Sequence"
    // Cs.g:2166:1: parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Sequence parse_org_emftext_sdk_concretesyntax_Sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;

        int parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex = input.index();

        org.emftext.sdk.concretesyntax.Definition a0_0 =null;

        org.emftext.sdk.concretesyntax.Definition a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Cs.g:2169:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) ) )* )
            // Cs.g:2170:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) ) )*
            {
            // Cs.g:2170:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            // Cs.g:2171:3: a0_0= parse_org_emftext_sdk_concretesyntax_Definition
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence2032);
            a0_0=parse_org_emftext_sdk_concretesyntax_Definition();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
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

            // Cs.g:2208:2: ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==HEXNUMBER||LA20_0==QUALIFIED_NAME||(LA20_0 >= STRING && LA20_0 <= TABNUMBER)||LA20_0==14) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Cs.g:2209:3: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) )
            	    {
            	    // Cs.g:2209:3: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) )
            	    // Cs.g:2210:4: (a1_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    {
            	    // Cs.g:2210:4: (a1_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    // Cs.g:2211:5: a1_0= parse_org_emftext_sdk_concretesyntax_Definition
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence2065);
            	    a1_0=parse_org_emftext_sdk_concretesyntax_Definition();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
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

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Sequence"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Choice"
    // Cs.g:2269:1: parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice parse_org_emftext_sdk_concretesyntax_Choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;

        int parse_org_emftext_sdk_concretesyntax_Choice_StartIndex = input.index();

        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0_0 =null;

        org.emftext.sdk.concretesyntax.Sequence a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Cs.g:2272:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* )
            // Cs.g:2273:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            {
            // Cs.g:2273:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            // Cs.g:2274:3: a0_0= parse_org_emftext_sdk_concretesyntax_Sequence
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2125);
            a0_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[241]);
            	}

            // Cs.g:2301:2: ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==47) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Cs.g:2302:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    {
            	    // Cs.g:2302:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    // Cs.g:2303:4: a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    {
            	    a1=(Token)match(input,47,FOLLOW_47_in_parse_org_emftext_sdk_concretesyntax_Choice2152); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_1_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
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

            	    // Cs.g:2326:4: (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    // Cs.g:2327:5: a2_0= parse_org_emftext_sdk_concretesyntax_Sequence
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2178);
            	    a2_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[252]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[253]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[254]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[255]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[256]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[257]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_sdk_concretesyntax_Choice_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Choice"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_CsString"
    // Cs.g:2365:1: parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null] : (a0= STRING ) ;
    public final org.emftext.sdk.concretesyntax.CsString parse_org_emftext_sdk_concretesyntax_CsString() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;

        int parse_org_emftext_sdk_concretesyntax_CsString_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Cs.g:2368:2: ( (a0= STRING ) )
            // Cs.g:2369:2: (a0= STRING )
            {
            // Cs.g:2369:2: (a0= STRING )
            // Cs.g:2370:3: a0= STRING
            {
            a0=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_CsString2238); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_sdk_concretesyntax_CsString_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_CsString"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken"
    // Cs.g:2419:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4= '+' |a5= '*' |a6= '?' )? ) ;
    public final org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element =  null;

        int parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Cs.g:2422:2: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4= '+' |a5= '*' |a6= '?' )? ) )
            // Cs.g:2423:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4= '+' |a5= '*' |a6= '?' )? )
            {
            // Cs.g:2423:2: (a0= QUALIFIED_NAME )
            // Cs.g:2424:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2278); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[271]);
            	}

            a1=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2299); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[272]);
            	}

            // Cs.g:2483:2: (a2= QUALIFIED_NAME )
            // Cs.g:2484:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2317); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[273]);
            	}

            a3=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2338); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[274]);
            	}

            // Cs.g:2543:2: ( (a4= '+' |a5= '*' |a6= '?' )? )
            // Cs.g:2544:3: (a4= '+' |a5= '*' |a6= '?' )?
            {
            // Cs.g:2544:3: (a4= '+' |a5= '*' |a6= '?' )?
            int alt22=4;
            switch ( input.LA(1) ) {
                case 17:
                    {
                    alt22=1;
                    }
                    break;
                case 16:
                    {
                    alt22=2;
                    }
                    break;
                case 23:
                    {
                    alt22=3;
                    }
                    break;
            }

            switch (alt22) {
                case 1 :
                    // Cs.g:2545:4: a4= '+'
                    {
                    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2361); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Cs.g:2561:8: a5= '*'
                    {
                    a5=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2376); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Cs.g:2577:8: a6= '?'
                    {
                    a6=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2391); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken"
    // Cs.g:2613:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3= '+' |a4= '*' |a5= '?' )? ) ;
    public final org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element =  null;

        int parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Cs.g:2616:2: ( (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3= '+' |a4= '*' |a5= '?' )? ) )
            // Cs.g:2617:2: (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3= '+' |a4= '*' |a5= '?' )? )
            {
            // Cs.g:2617:2: (a0= QUALIFIED_NAME )
            // Cs.g:2618:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2431); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[288]);
            	}

            a1=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2452); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[289]);
            	}

            a2=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2466); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[290]);
            	}

            // Cs.g:2694:2: ( (a3= '+' |a4= '*' |a5= '?' )? )
            // Cs.g:2695:3: (a3= '+' |a4= '*' |a5= '?' )?
            {
            // Cs.g:2695:3: (a3= '+' |a4= '*' |a5= '?' )?
            int alt23=4;
            switch ( input.LA(1) ) {
                case 17:
                    {
                    alt23=1;
                    }
                    break;
                case 16:
                    {
                    alt23=2;
                    }
                    break;
                case 23:
                    {
                    alt23=3;
                    }
                    break;
            }

            switch (alt23) {
                case 1 :
                    // Cs.g:2696:4: a3= '+'
                    {
                    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2489); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Cs.g:2712:8: a4= '*'
                    {
                    a4=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2504); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Cs.g:2728:8: a5= '?'
                    {
                    a5=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2519); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes"
    // Cs.g:2764:1: parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8= '+' |a9= '*' |a10= '?' )? ) ;
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
        Token a8=null;
        Token a9=null;
        Token a10=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Cs.g:2767:2: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8= '+' |a9= '*' |a10= '?' )? ) )
            // Cs.g:2768:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8= '+' |a9= '*' |a10= '?' )? )
            {
            // Cs.g:2768:2: (a0= QUALIFIED_NAME )
            // Cs.g:2769:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2559); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[304]);
            	}

            a1=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2580); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[305]);
            	}

            // Cs.g:2828:2: (a2= QUOTED_39_39_92 )
            // Cs.g:2829:3: a2= QUOTED_39_39_92
            {
            a2=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2598); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[306]);
            	}

            a3=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2619); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[307]);
            	}

            // Cs.g:2884:2: (a4= QUOTED_39_39_92 )
            // Cs.g:2885:3: a4= QUOTED_39_39_92
            {
            a4=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2637); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[308]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[309]);
            	}

            // Cs.g:2924:2: ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==18) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Cs.g:2925:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    {
                    // Cs.g:2925:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    // Cs.g:2926:4: a5= ',' (a6= QUOTED_39_39_92 )
                    {
                    a5=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2667); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[310]);
                    			}

                    // Cs.g:2943:4: (a6= QUOTED_39_39_92 )
                    // Cs.g:2944:5: a6= QUOTED_39_39_92
                    {
                    a6=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2693); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[311]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[312]);
            	}

            a7=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2739); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[313]);
            	}

            // Cs.g:3006:2: ( (a8= '+' |a9= '*' |a10= '?' )? )
            // Cs.g:3007:3: (a8= '+' |a9= '*' |a10= '?' )?
            {
            // Cs.g:3007:3: (a8= '+' |a9= '*' |a10= '?' )?
            int alt25=4;
            switch ( input.LA(1) ) {
                case 17:
                    {
                    alt25=1;
                    }
                    break;
                case 16:
                    {
                    alt25=2;
                    }
                    break;
                case 23:
                    {
                    alt25=3;
                    }
                    break;
            }

            switch (alt25) {
                case 1 :
                    // Cs.g:3008:4: a8= '+'
                    {
                    a8=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2762); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Cs.g:3024:8: a9= '*'
                    {
                    a9=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2777); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Cs.g:3040:8: a10= '?'
                    {
                    a10=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2792); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_BooleanTerminal"
    // Cs.g:3076:1: parse_org_emftext_sdk_concretesyntax_BooleanTerminal returns [org.emftext.sdk.concretesyntax.BooleanTerminal element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= STRING ) a3= ':' (a4= STRING ) a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? ) ;
    public final org.emftext.sdk.concretesyntax.BooleanTerminal parse_org_emftext_sdk_concretesyntax_BooleanTerminal() throws RecognitionException {
        org.emftext.sdk.concretesyntax.BooleanTerminal element =  null;

        int parse_org_emftext_sdk_concretesyntax_BooleanTerminal_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Cs.g:3079:2: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= STRING ) a3= ':' (a4= STRING ) a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? ) )
            // Cs.g:3080:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= STRING ) a3= ':' (a4= STRING ) a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? )
            {
            // Cs.g:3080:2: (a0= QUALIFIED_NAME )
            // Cs.g:3081:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2832); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[327]);
            	}

            a1=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2853); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[328]);
            	}

            // Cs.g:3140:2: (a2= STRING )
            // Cs.g:3141:3: a2= STRING
            {
            a2=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2871); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[329]);
            	}

            a3=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2892); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[330]);
            	}

            // Cs.g:3196:2: (a4= STRING )
            // Cs.g:3197:3: a4= STRING
            {
            a4=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2910); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[331]);
            	}

            a5=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2931); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[332]);
            	}

            // Cs.g:3252:2: ( (a6= '+' |a7= '*' |a8= '?' )? )
            // Cs.g:3253:3: (a6= '+' |a7= '*' |a8= '?' )?
            {
            // Cs.g:3253:3: (a6= '+' |a7= '*' |a8= '?' )?
            int alt26=4;
            switch ( input.LA(1) ) {
                case 17:
                    {
                    alt26=1;
                    }
                    break;
                case 16:
                    {
                    alt26=2;
                    }
                    break;
                case 23:
                    {
                    alt26=3;
                    }
                    break;
            }

            switch (alt26) {
                case 1 :
                    // Cs.g:3254:4: a6= '+'
                    {
                    a6=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2954); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Cs.g:3270:8: a7= '*'
                    {
                    a7=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2969); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Cs.g:3286:8: a8= '?'
                    {
                    a8=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2984); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_sdk_concretesyntax_BooleanTerminal_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_BooleanTerminal"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_EnumTerminal"
    // Cs.g:3322:1: parse_org_emftext_sdk_concretesyntax_EnumTerminal returns [org.emftext.sdk.concretesyntax.EnumTerminal element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ( (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ) )* a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? ) ;
    public final org.emftext.sdk.concretesyntax.EnumTerminal parse_org_emftext_sdk_concretesyntax_EnumTerminal() throws RecognitionException {
        org.emftext.sdk.concretesyntax.EnumTerminal element =  null;

        int parse_org_emftext_sdk_concretesyntax_EnumTerminal_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        org.emftext.sdk.concretesyntax.EnumLiteralTerminal a2_0 =null;

        org.emftext.sdk.concretesyntax.EnumLiteralTerminal a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Cs.g:3325:2: ( (a0= QUALIFIED_NAME ) a1= '[' (a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ( (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ) )* a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? ) )
            // Cs.g:3326:2: (a0= QUALIFIED_NAME ) a1= '[' (a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ( (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ) )* a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? )
            {
            // Cs.g:3326:2: (a0= QUALIFIED_NAME )
            // Cs.g:3327:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3024); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[346]);
            	}

            a1=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3045); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[347]);
            	}

            // Cs.g:3386:2: (a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal )
            // Cs.g:3387:3: a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3063);
            a2_0=parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[348]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[349]);
            	}

            // Cs.g:3416:2: ( (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==18) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // Cs.g:3417:3: (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) )
            	    {
            	    // Cs.g:3417:3: (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) )
            	    // Cs.g:3418:4: a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal )
            	    {
            	    a3=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3090); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[350]);
            	    			}

            	    // Cs.g:3435:4: (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal )
            	    // Cs.g:3436:5: a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3116);
            	    a4_0=parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[351]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[352]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[353]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[354]);
            	}

            a5=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3157); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[355]);
            	}

            // Cs.g:3490:2: ( (a6= '+' |a7= '*' |a8= '?' )? )
            // Cs.g:3491:3: (a6= '+' |a7= '*' |a8= '?' )?
            {
            // Cs.g:3491:3: (a6= '+' |a7= '*' |a8= '?' )?
            int alt28=4;
            switch ( input.LA(1) ) {
                case 17:
                    {
                    alt28=1;
                    }
                    break;
                case 16:
                    {
                    alt28=2;
                    }
                    break;
                case 23:
                    {
                    alt28=3;
                    }
                    break;
            }

            switch (alt28) {
                case 1 :
                    // Cs.g:3492:4: a6= '+'
                    {
                    a6=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3180); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Cs.g:3508:8: a7= '*'
                    {
                    a7=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3195); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Cs.g:3524:8: a8= '?'
                    {
                    a8=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3210); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_sdk_concretesyntax_EnumTerminal_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_EnumTerminal"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal"
    // Cs.g:3560:1: parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal returns [org.emftext.sdk.concretesyntax.EnumLiteralTerminal element = null] : (a0= QUALIFIED_NAME ) a1= ':' (a2= STRING ) ;
    public final org.emftext.sdk.concretesyntax.EnumLiteralTerminal parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal() throws RecognitionException {
        org.emftext.sdk.concretesyntax.EnumLiteralTerminal element =  null;

        int parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Cs.g:3563:2: ( (a0= QUALIFIED_NAME ) a1= ':' (a2= STRING ) )
            // Cs.g:3564:2: (a0= QUALIFIED_NAME ) a1= ':' (a2= STRING )
            {
            // Cs.g:3564:2: (a0= QUALIFIED_NAME )
            // Cs.g:3565:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal3250); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[369]);
            	}

            a1=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal3271); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createEnumLiteralTerminal();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[370]);
            	}

            // Cs.g:3618:2: (a2= STRING )
            // Cs.g:3619:3: a2= STRING
            {
            a2=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal3289); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[371]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[372]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Containment"
    // Cs.g:3657:1: parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5= '+' |a6= '*' |a7= '?' )? ) ;
    public final org.emftext.sdk.concretesyntax.Containment parse_org_emftext_sdk_concretesyntax_Containment() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Containment element =  null;

        int parse_org_emftext_sdk_concretesyntax_Containment_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Cs.g:3660:2: ( (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5= '+' |a6= '*' |a7= '?' )? ) )
            // Cs.g:3661:2: (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5= '+' |a6= '*' |a7= '?' )? )
            {
            // Cs.g:3661:2: (a0= QUALIFIED_NAME )
            // Cs.g:3662:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3329); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[373]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[374]);
            	}

            // Cs.g:3705:2: ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==19) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Cs.g:3706:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    {
                    // Cs.g:3706:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    // Cs.g:3707:4: a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    {
                    a1=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_Containment3359); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[375]);
                    			}

                    // Cs.g:3724:4: (a2= QUALIFIED_NAME )
                    // Cs.g:3725:5: a2= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3385); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[376]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[377]);
                    			}

                    // Cs.g:3768:4: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==18) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // Cs.g:3769:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    {
                    	    // Cs.g:3769:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    // Cs.g:3770:6: a3= ',' (a4= QUALIFIED_NAME )
                    	    {
                    	    a3=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_Containment3431); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[378]);
                    	    					}

                    	    // Cs.g:3787:6: (a4= QUALIFIED_NAME )
                    	    // Cs.g:3788:7: a4= QUALIFIED_NAME
                    	    {
                    	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3465); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[379]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[380]);
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
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[381]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[382]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[383]);
            	}

            // Cs.g:3846:2: ( (a5= '+' |a6= '*' |a7= '?' )? )
            // Cs.g:3847:3: (a5= '+' |a6= '*' |a7= '?' )?
            {
            // Cs.g:3847:3: (a5= '+' |a6= '*' |a7= '?' )?
            int alt31=4;
            switch ( input.LA(1) ) {
                case 17:
                    {
                    alt31=1;
                    }
                    break;
                case 16:
                    {
                    alt31=2;
                    }
                    break;
                case 23:
                    {
                    alt31=3;
                    }
                    break;
            }

            switch (alt31) {
                case 1 :
                    // Cs.g:3848:4: a5= '+'
                    {
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Containment3555); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Cs.g:3864:8: a6= '*'
                    {
                    a6=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_Containment3570); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Cs.g:3880:8: a7= '?'
                    {
                    a7=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_Containment3585); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_sdk_concretesyntax_Containment_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Containment"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_CompoundDefinition"
    // Cs.g:3916:1: parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3= '+' |a4= '*' |a5= '?' )? ) ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition parse_org_emftext_sdk_concretesyntax_CompoundDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;

        int parse_org_emftext_sdk_concretesyntax_CompoundDefinition_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        org.emftext.sdk.concretesyntax.Choice a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Cs.g:3919:2: (a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3= '+' |a4= '*' |a5= '?' )? ) )
            // Cs.g:3920:2: a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3= '+' |a4= '*' |a5= '?' )? )
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3621); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
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

            // Cs.g:3946:2: (a1_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // Cs.g:3947:3: a1_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3639);
            a1_0=parse_org_emftext_sdk_concretesyntax_Choice();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[407]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3657); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[408]);
            	}

            // Cs.g:3992:2: ( (a3= '+' |a4= '*' |a5= '?' )? )
            // Cs.g:3993:3: (a3= '+' |a4= '*' |a5= '?' )?
            {
            // Cs.g:3993:3: (a3= '+' |a4= '*' |a5= '?' )?
            int alt32=4;
            switch ( input.LA(1) ) {
                case 17:
                    {
                    alt32=1;
                    }
                    break;
                case 16:
                    {
                    alt32=2;
                    }
                    break;
                case 23:
                    {
                    alt32=3;
                    }
                    break;
            }

            switch (alt32) {
                case 1 :
                    // Cs.g:3994:4: a3= '+'
                    {
                    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3680); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Cs.g:4010:8: a4= '*'
                    {
                    a4=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3695); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 3 :
                    // Cs.g:4026:8: a5= '?'
                    {
                    a5=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3710); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_sdk_concretesyntax_CompoundDefinition_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_CompoundDefinition"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_WhiteSpaces"
    // Cs.g:4062:1: parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : (a0= HEXNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces parse_org_emftext_sdk_concretesyntax_WhiteSpaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;

        int parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Cs.g:4065:2: ( (a0= HEXNUMBER ) )
            // Cs.g:4066:2: (a0= HEXNUMBER )
            {
            // Cs.g:4066:2: (a0= HEXNUMBER )
            // Cs.g:4067:3: a0= HEXNUMBER
            {
            a0=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces3750); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_WhiteSpaces"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_LineBreak"
    // Cs.g:4116:1: parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : (a0= TABNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.LineBreak parse_org_emftext_sdk_concretesyntax_LineBreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;

        int parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Cs.g:4119:2: ( (a0= TABNUMBER ) )
            // Cs.g:4120:2: (a0= TABNUMBER )
            {
            // Cs.g:4120:2: (a0= TABNUMBER )
            // Cs.g:4121:3: a0= TABNUMBER
            {
            a0=(Token)match(input,TABNUMBER,FOLLOW_TABNUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak3790); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_LineBreak"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenRedefinition"
    // Cs.g:4170:1: parse_org_emftext_sdk_concretesyntax_TokenRedefinition returns [org.emftext.sdk.concretesyntax.TokenRedefinition element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'REDEFINE' (a2= QUALIFIED_NAME ) a3= 'AS' (a4= QUALIFIED_NAME ) (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ;
    public final org.emftext.sdk.concretesyntax.TokenRedefinition parse_org_emftext_sdk_concretesyntax_TokenRedefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenRedefinition element =  null;

        int parse_org_emftext_sdk_concretesyntax_TokenRedefinition_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 =null;

        org.emftext.sdk.concretesyntax.RegexPart a5_0 =null;

        org.emftext.sdk.concretesyntax.RegexPart a7_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Cs.g:4173:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'REDEFINE' (a2= QUALIFIED_NAME ) a3= 'AS' (a4= QUALIFIED_NAME ) (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* )
            // Cs.g:4174:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'REDEFINE' (a2= QUALIFIED_NAME ) a3= 'AS' (a4= QUALIFIED_NAME ) (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            {
            // Cs.g:4174:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==24) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Cs.g:4175:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:4175:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:4176:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:4176:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:4177:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3841);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[448]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[449]);
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
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[450]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[451]);
            	}

            a1=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3882); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[452]);
            	}

            // Cs.g:4225:2: (a2= QUALIFIED_NAME )
            // Cs.g:4226:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3900); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[453]);
            	}

            a3=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3921); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[454]);
            	}

            // Cs.g:4279:2: (a4= QUALIFIED_NAME )
            // Cs.g:4280:3: a4= QUALIFIED_NAME
            {
            a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3939); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[455]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[456]);
            	}

            // Cs.g:4316:2: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Cs.g:4317:3: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3964);
            a5_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[457]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[458]);
            	}

            // Cs.g:4343:2: ( (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==17) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Cs.g:4344:3: (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Cs.g:4344:3: (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Cs.g:4345:4: a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    {
            	    a6=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3991); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenRedefinition();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_8_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[459]);
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[460]);
            	    			}

            	    // Cs.g:4360:4: (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Cs.g:4361:5: a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition4017);
            	    a7_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[461]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[462]);
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
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[463]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[464]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_sdk_concretesyntax_TokenRedefinition_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenRedefinition"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition"
    // Cs.g:4397:1: parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition returns [org.emftext.sdk.concretesyntax.NormalTokenDefinition element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? ;
    public final org.emftext.sdk.concretesyntax.NormalTokenDefinition parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.NormalTokenDefinition element =  null;

        int parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_StartIndex = input.index();

        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 =null;

        org.emftext.sdk.concretesyntax.RegexPart a3_0 =null;

        org.emftext.sdk.concretesyntax.RegexPart a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Cs.g:4400:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? )
            // Cs.g:4401:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            {
            // Cs.g:4401:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==24) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // Cs.g:4402:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:4402:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:4403:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:4403:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:4404:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4088);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[465]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[466]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[467]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[468]);
            	}

            a1=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[469]);
            	}

            // Cs.g:4452:2: (a2= QUALIFIED_NAME )
            // Cs.g:4453:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4147); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[470]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[471]);
            	}

            // Cs.g:4489:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Cs.g:4490:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4172);
            a3_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[472]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[473]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[474]);
            	}

            // Cs.g:4517:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==17) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Cs.g:4518:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Cs.g:4518:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Cs.g:4519:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    {
            	    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4199); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_6_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[475]);
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[476]);
            	    			}

            	    // Cs.g:4534:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Cs.g:4535:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4225);
            	    a5_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[477]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[478]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[479]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[480]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[481]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[482]);
            	}

            // Cs.g:4571:2: ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==27) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // Cs.g:4572:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    {
                    // Cs.g:4572:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    // Cs.g:4573:4: a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME )
                    {
                    a6=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4275); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[483]);
                    			}

                    a7=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4295); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_3, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[484]);
                    			}

                    // Cs.g:4601:4: (a8= QUALIFIED_NAME )
                    // Cs.g:4602:5: a8= QUALIFIED_NAME
                    {
                    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4321); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[485]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[486]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition"
    // Cs.g:4646:1: parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition returns [org.emftext.sdk.concretesyntax.PartialTokenDefinition element = null] : a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ;
    public final org.emftext.sdk.concretesyntax.PartialTokenDefinition parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PartialTokenDefinition element =  null;

        int parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.RegexPart a3_0 =null;

        org.emftext.sdk.concretesyntax.RegexPart a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Cs.g:4649:2: (a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* )
            // Cs.g:4650:2: a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            {
            a0=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4382); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[487]);
            	}

            a1=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4396); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[488]);
            	}

            // Cs.g:4678:2: (a2= QUALIFIED_NAME )
            // Cs.g:4679:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4414); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[489]);
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[490]);
            	}

            // Cs.g:4715:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Cs.g:4716:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4439);
            a3_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[491]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[492]);
            	}

            // Cs.g:4742:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==17) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // Cs.g:4743:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Cs.g:4743:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Cs.g:4744:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    {
            	    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4466); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_7_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[493]);
            	    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[494]);
            	    			}

            	    // Cs.g:4759:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Cs.g:4760:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4492);
            	    a5_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[495]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[496]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[497]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[498]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective"
    // Cs.g:4796:1: parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null] : a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.TokenPriorityDirective parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenPriorityDirective element =  null;

        int parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Cs.g:4799:2: (a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) )
            // Cs.g:4800:2: a0= 'PRIORITIZE' (a1= QUALIFIED_NAME )
            {
            a0=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective4548); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[499]);
            	}

            // Cs.g:4814:2: (a1= QUALIFIED_NAME )
            // Cs.g:4815:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective4566); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[500]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_AtomicRegex"
    // Cs.g:4856:1: parse_org_emftext_sdk_concretesyntax_AtomicRegex returns [org.emftext.sdk.concretesyntax.AtomicRegex element = null] : (a0= QUOTED_36_36 ) ;
    public final org.emftext.sdk.concretesyntax.AtomicRegex parse_org_emftext_sdk_concretesyntax_AtomicRegex() throws RecognitionException {
        org.emftext.sdk.concretesyntax.AtomicRegex element =  null;

        int parse_org_emftext_sdk_concretesyntax_AtomicRegex_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Cs.g:4859:2: ( (a0= QUOTED_36_36 ) )
            // Cs.g:4860:2: (a0= QUOTED_36_36 )
            {
            // Cs.g:4860:2: (a0= QUOTED_36_36 )
            // Cs.g:4861:3: a0= QUOTED_36_36
            {
            a0=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_AtomicRegex4606); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[501]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[502]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[503]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[504]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[505]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_org_emftext_sdk_concretesyntax_AtomicRegex_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_AtomicRegex"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_RegexReference"
    // Cs.g:4902:1: parse_org_emftext_sdk_concretesyntax_RegexReference returns [org.emftext.sdk.concretesyntax.RegexReference element = null] : (a0= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.RegexReference parse_org_emftext_sdk_concretesyntax_RegexReference() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexReference element =  null;

        int parse_org_emftext_sdk_concretesyntax_RegexReference_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Cs.g:4905:2: ( (a0= QUALIFIED_NAME ) )
            // Cs.g:4906:2: (a0= QUALIFIED_NAME )
            {
            // Cs.g:4906:2: (a0= QUALIFIED_NAME )
            // Cs.g:4907:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_RegexReference4646); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[506]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[507]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[508]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[509]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[510]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_org_emftext_sdk_concretesyntax_RegexReference_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_RegexReference"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenStyle"
    // Cs.g:4952:1: parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null] : (a0= STRING ) ( (a1= ',' (a2= STRING ) ) )* a3= 'COLOR' (a4= HEXNUMBER ) ( (a5= ',' (a6= QUALIFIED_NAME ) ) )* a7= ';' ;
    public final org.emftext.sdk.concretesyntax.TokenStyle parse_org_emftext_sdk_concretesyntax_TokenStyle() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenStyle element =  null;

        int parse_org_emftext_sdk_concretesyntax_TokenStyle_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Cs.g:4955:2: ( (a0= STRING ) ( (a1= ',' (a2= STRING ) ) )* a3= 'COLOR' (a4= HEXNUMBER ) ( (a5= ',' (a6= QUALIFIED_NAME ) ) )* a7= ';' )
            // Cs.g:4956:2: (a0= STRING ) ( (a1= ',' (a2= STRING ) ) )* a3= 'COLOR' (a4= HEXNUMBER ) ( (a5= ',' (a6= QUALIFIED_NAME ) ) )* a7= ';'
            {
            // Cs.g:4956:2: (a0= STRING )
            // Cs.g:4957:3: a0= STRING
            {
            a0=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4686); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[511]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[512]);
            	}

            // Cs.g:4993:2: ( (a1= ',' (a2= STRING ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==18) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // Cs.g:4994:3: (a1= ',' (a2= STRING ) )
            	    {
            	    // Cs.g:4994:3: (a1= ',' (a2= STRING ) )
            	    // Cs.g:4995:4: a1= ',' (a2= STRING )
            	    {
            	    a1=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4716); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[513]);
            	    			}

            	    // Cs.g:5009:4: (a2= STRING )
            	    // Cs.g:5010:5: a2= STRING
            	    {
            	    a2=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4742); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[514]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[515]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[516]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[517]);
            	}

            a3=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4788); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[518]);
            	}

            // Cs.g:5068:2: (a4= HEXNUMBER )
            // Cs.g:5069:3: a4= HEXNUMBER
            {
            a4=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4806); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[519]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[520]);
            	}

            // Cs.g:5105:2: ( (a5= ',' (a6= QUALIFIED_NAME ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==18) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // Cs.g:5106:3: (a5= ',' (a6= QUALIFIED_NAME ) )
            	    {
            	    // Cs.g:5106:3: (a5= ',' (a6= QUALIFIED_NAME ) )
            	    // Cs.g:5107:4: a5= ',' (a6= QUALIFIED_NAME )
            	    {
            	    a5=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4836); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[521]);
            	    			}

            	    // Cs.g:5121:4: (a6= QUALIFIED_NAME )
            	    // Cs.g:5122:5: a6= QUALIFIED_NAME
            	    {
            	    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4862); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[522]);
            	    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[523]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[524]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[525]);
            	}

            a7=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4908); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[526]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[527]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_org_emftext_sdk_concretesyntax_TokenStyle_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenStyle"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Annotation"
    // Cs.g:5183:1: parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null] : a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? ;
    public final org.emftext.sdk.concretesyntax.Annotation parse_org_emftext_sdk_concretesyntax_Annotation() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Annotation element =  null;

        int parse_org_emftext_sdk_concretesyntax_Annotation_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        org.emftext.sdk.concretesyntax.KeyValuePair a3_0 =null;

        org.emftext.sdk.concretesyntax.KeyValuePair a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Cs.g:5186:2: (a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? )
            // Cs.g:5187:2: a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            {
            a0=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_Annotation4937); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[528]);
            	}

            // Cs.g:5201:2: (a1= QUALIFIED_NAME )
            // Cs.g:5202:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation4955); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
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

            // Cs.g:5244:2: ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==14) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // Cs.g:5245:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    {
                    // Cs.g:5245:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    // Cs.g:5246:4: a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')'
                    {
                    a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_Annotation4985); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[537]);
                    			}

                    // Cs.g:5260:4: (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    // Cs.g:5261:5: a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation5011);
                    a3_0=parse_org_emftext_sdk_concretesyntax_KeyValuePair();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[538]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[539]);
                    			}

                    // Cs.g:5287:4: ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==18) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // Cs.g:5288:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    {
                    	    // Cs.g:5288:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    // Cs.g:5289:6: a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    {
                    	    a4=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_Annotation5052); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[540]);
                    	    					}

                    	    // Cs.g:5303:6: (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    // Cs.g:5304:7: a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation5086);
                    	    a5_0=parse_org_emftext_sdk_concretesyntax_KeyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[541]);
                    	    						addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[542]);
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[543]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[544]);
                    			}

                    a6=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_Annotation5147); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_3, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[545]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[546]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[547]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[548]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[549]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[550]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[551]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[552]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[553]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[554]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[555]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[556]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[557]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[558]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_org_emftext_sdk_concretesyntax_Annotation_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Annotation"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_KeyValuePair"
    // Cs.g:5373:1: parse_org_emftext_sdk_concretesyntax_KeyValuePair returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null] : (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= STRING ) ) )? ;
    public final org.emftext.sdk.concretesyntax.KeyValuePair parse_org_emftext_sdk_concretesyntax_KeyValuePair() throws RecognitionException {
        org.emftext.sdk.concretesyntax.KeyValuePair element =  null;

        int parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Cs.g:5376:2: ( (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= STRING ) ) )? )
            // Cs.g:5377:2: (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= STRING ) ) )?
            {
            // Cs.g:5377:2: (a0= QUALIFIED_NAME )
            // Cs.g:5378:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5199); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[559]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[560]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[561]);
            	}

            // Cs.g:5415:2: ( (a1= '=' (a2= STRING ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==22) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // Cs.g:5416:3: (a1= '=' (a2= STRING ) )
                    {
                    // Cs.g:5416:3: (a1= '=' (a2= STRING ) )
                    // Cs.g:5417:4: a1= '=' (a2= STRING )
                    {
                    a1=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5229); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[562]);
                    			}

                    // Cs.g:5431:4: (a2= STRING )
                    // Cs.g:5432:5: a2= STRING
                    {
                    a2=(Token)match(input,STRING,FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5255); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[563]);
                    				addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[564]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[565]);
            		addExpectedElement(null, org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectationConstants.EXPECTATIONS[566]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_KeyValuePair"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenDirective"
    // Cs.g:5478:1: parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null] : (c0= parse_org_emftext_sdk_concretesyntax_TokenRedefinition |c1= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition |c2= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition |c3= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective );
    public final org.emftext.sdk.concretesyntax.TokenDirective parse_org_emftext_sdk_concretesyntax_TokenDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDirective element =  null;

        int parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex = input.index();

        org.emftext.sdk.concretesyntax.TokenRedefinition c0 =null;

        org.emftext.sdk.concretesyntax.NormalTokenDefinition c1 =null;

        org.emftext.sdk.concretesyntax.PartialTokenDefinition c2 =null;

        org.emftext.sdk.concretesyntax.TokenPriorityDirective c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Cs.g:5479:2: (c0= parse_org_emftext_sdk_concretesyntax_TokenRedefinition |c1= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition |c2= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition |c3= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective )
            int alt44=4;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // Cs.g:5480:2: c0= parse_org_emftext_sdk_concretesyntax_TokenRedefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenRedefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5312);
                    c0=parse_org_emftext_sdk_concretesyntax_TokenRedefinition();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Cs.g:5481:4: c1= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5322);
                    c1=parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Cs.g:5482:4: c2= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5332);
                    c2=parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Cs.g:5483:4: c3= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5342);
                    c3=parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenDirective"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Definition"
    // Cs.g:5487:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString |c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken |c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken |c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes |c4= parse_org_emftext_sdk_concretesyntax_BooleanTerminal |c5= parse_org_emftext_sdk_concretesyntax_EnumTerminal |c6= parse_org_emftext_sdk_concretesyntax_Containment |c7= parse_org_emftext_sdk_concretesyntax_CompoundDefinition |c8= parse_org_emftext_sdk_concretesyntax_WhiteSpaces |c9= parse_org_emftext_sdk_concretesyntax_LineBreak );
    public final org.emftext.sdk.concretesyntax.Definition parse_org_emftext_sdk_concretesyntax_Definition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Definition element =  null;

        int parse_org_emftext_sdk_concretesyntax_Definition_StartIndex = input.index();

        org.emftext.sdk.concretesyntax.CsString c0 =null;

        org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken c1 =null;

        org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken c2 =null;

        org.emftext.sdk.concretesyntax.PlaceholderInQuotes c3 =null;

        org.emftext.sdk.concretesyntax.BooleanTerminal c4 =null;

        org.emftext.sdk.concretesyntax.EnumTerminal c5 =null;

        org.emftext.sdk.concretesyntax.Containment c6 =null;

        org.emftext.sdk.concretesyntax.CompoundDefinition c7 =null;

        org.emftext.sdk.concretesyntax.WhiteSpaces c8 =null;

        org.emftext.sdk.concretesyntax.LineBreak c9 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Cs.g:5488:2: (c0= parse_org_emftext_sdk_concretesyntax_CsString |c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken |c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken |c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes |c4= parse_org_emftext_sdk_concretesyntax_BooleanTerminal |c5= parse_org_emftext_sdk_concretesyntax_EnumTerminal |c6= parse_org_emftext_sdk_concretesyntax_Containment |c7= parse_org_emftext_sdk_concretesyntax_CompoundDefinition |c8= parse_org_emftext_sdk_concretesyntax_WhiteSpaces |c9= parse_org_emftext_sdk_concretesyntax_LineBreak )
            int alt45=10;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt45=1;
                }
                break;
            case QUALIFIED_NAME:
                {
                int LA45_2 = input.LA(2);

                if ( (LA45_2==44) ) {
                    switch ( input.LA(3) ) {
                    case QUALIFIED_NAME:
                        {
                        int LA45_8 = input.LA(4);

                        if ( (LA45_8==45) ) {
                            alt45=2;
                        }
                        else if ( (LA45_8==19) ) {
                            alt45=6;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return element;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 45, 8, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 45:
                        {
                        alt45=3;
                        }
                        break;
                    case QUOTED_39_39_92:
                        {
                        alt45=4;
                        }
                        break;
                    case STRING:
                        {
                        alt45=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 6, input);

                        throw nvae;

                    }

                }
                else if ( (LA45_2==EOF||LA45_2==HEXNUMBER||LA45_2==QUALIFIED_NAME||(LA45_2 >= STRING && LA45_2 <= TABNUMBER)||(LA45_2 >= 14 && LA45_2 <= 17)||LA45_2==19||LA45_2==21||LA45_2==23||LA45_2==47) ) {
                    alt45=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 2, input);

                    throw nvae;

                }
                }
                break;
            case 14:
                {
                alt45=8;
                }
                break;
            case HEXNUMBER:
                {
                alt45=9;
                }
                break;
            case TABNUMBER:
                {
                alt45=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // Cs.g:5489:2: c0= parse_org_emftext_sdk_concretesyntax_CsString
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition5363);
                    c0=parse_org_emftext_sdk_concretesyntax_CsString();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Cs.g:5490:4: c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition5373);
                    c1=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Cs.g:5491:4: c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition5383);
                    c2=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Cs.g:5492:4: c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition5393);
                    c3=parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Cs.g:5493:4: c4= parse_org_emftext_sdk_concretesyntax_BooleanTerminal
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_BooleanTerminal_in_parse_org_emftext_sdk_concretesyntax_Definition5403);
                    c4=parse_org_emftext_sdk_concretesyntax_BooleanTerminal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Cs.g:5494:4: c5= parse_org_emftext_sdk_concretesyntax_EnumTerminal
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_EnumTerminal_in_parse_org_emftext_sdk_concretesyntax_Definition5413);
                    c5=parse_org_emftext_sdk_concretesyntax_EnumTerminal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Cs.g:5495:4: c6= parse_org_emftext_sdk_concretesyntax_Containment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition5423);
                    c6=parse_org_emftext_sdk_concretesyntax_Containment();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Cs.g:5496:4: c7= parse_org_emftext_sdk_concretesyntax_CompoundDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition5433);
                    c7=parse_org_emftext_sdk_concretesyntax_CompoundDefinition();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Cs.g:5497:4: c8= parse_org_emftext_sdk_concretesyntax_WhiteSpaces
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition5443);
                    c8=parse_org_emftext_sdk_concretesyntax_WhiteSpaces();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Cs.g:5498:4: c9= parse_org_emftext_sdk_concretesyntax_LineBreak
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition5453);
                    c9=parse_org_emftext_sdk_concretesyntax_LineBreak();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_org_emftext_sdk_concretesyntax_Definition_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Definition"



    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_RegexPart"
    // Cs.g:5502:1: parse_org_emftext_sdk_concretesyntax_RegexPart returns [org.emftext.sdk.concretesyntax.RegexPart element = null] : (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex |c1= parse_org_emftext_sdk_concretesyntax_RegexReference );
    public final org.emftext.sdk.concretesyntax.RegexPart parse_org_emftext_sdk_concretesyntax_RegexPart() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexPart element =  null;

        int parse_org_emftext_sdk_concretesyntax_RegexPart_StartIndex = input.index();

        org.emftext.sdk.concretesyntax.AtomicRegex c0 =null;

        org.emftext.sdk.concretesyntax.RegexReference c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Cs.g:5503:2: (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex |c1= parse_org_emftext_sdk_concretesyntax_RegexReference )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==QUOTED_36_36) ) {
                alt46=1;
            }
            else if ( (LA46_0==QUALIFIED_NAME) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // Cs.g:5504:2: c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_AtomicRegex_in_parse_org_emftext_sdk_concretesyntax_RegexPart5474);
                    c0=parse_org_emftext_sdk_concretesyntax_AtomicRegex();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Cs.g:5505:4: c1= parse_org_emftext_sdk_concretesyntax_RegexReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexReference_in_parse_org_emftext_sdk_concretesyntax_RegexPart5484);
                    c1=parse_org_emftext_sdk_concretesyntax_RegexReference();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_org_emftext_sdk_concretesyntax_RegexPart_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_RegexPart"

    // Delegated rules


    protected DFA44 dfa44 = new DFA44(this);
    static final String DFA44_eotS =
        "\21\uffff";
    static final String DFA44_eofS =
        "\21\uffff";
    static final String DFA44_minS =
        "\1\30\1\7\1\uffff\1\7\1\uffff\1\16\2\uffff\1\7\1\17\1\13\1\7\1\30"+
        "\2\17\1\13\1\17";
    static final String DFA44_maxS =
        "\1\44\1\7\1\uffff\1\37\1\uffff\1\44\2\uffff\1\7\1\26\1\13\1\7\1"+
        "\44\1\22\1\26\1\13\1\22";
    static final String DFA44_acceptS =
        "\2\uffff\1\1\1\uffff\1\4\1\uffff\1\2\1\3\11\uffff";
    static final String DFA44_specialS =
        "\21\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\1\4\uffff\1\3\5\uffff\1\4\1\2",
            "\1\5",
            "",
            "\1\6\27\uffff\1\7",
            "",
            "\1\10\11\uffff\1\1\4\uffff\1\6\6\uffff\1\2",
            "",
            "",
            "\1\11",
            "\1\14\2\uffff\1\13\3\uffff\1\12",
            "\1\15",
            "\1\16",
            "\1\1\4\uffff\1\6\6\uffff\1\2",
            "\1\14\2\uffff\1\13",
            "\1\14\2\uffff\1\13\3\uffff\1\17",
            "\1\20",
            "\1\14\2\uffff\1\13"
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "5478:1: parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null] : (c0= parse_org_emftext_sdk_concretesyntax_TokenRedefinition |c1= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition |c2= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition |c3= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective );";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax130 = new BitSet(new long[]{0x0000010003000000L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax180 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax201 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax219 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax240 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax258 = new BitSet(new long[]{0x0000066500000400L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax294 = new BitSet(new long[]{0x0000066500000000L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax349 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax382 = new BitSet(new long[]{0x0000062500040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax447 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax490 = new BitSet(new long[]{0x0000062500040000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax605 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax625 = new BitSet(new long[]{0x0001000001000080L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax666 = new BitSet(new long[]{0x0001000001000080L});
    public static final BitSet FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax727 = new BitSet(new long[]{0x0000062400000000L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax769 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax789 = new BitSet(new long[]{0x0001000000000080L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax830 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax868 = new BitSet(new long[]{0x0001000000000080L});
    public static final BitSet FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax917 = new BitSet(new long[]{0x0000062000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax959 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax979 = new BitSet(new long[]{0x0001001821000000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1020 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1058 = new BitSet(new long[]{0x0001001821000000L});
    public static final BitSet FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1107 = new BitSet(new long[]{0x0000042000000000L});
    public static final BitSet FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1149 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1169 = new BitSet(new long[]{0x0001000000000800L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1210 = new BitSet(new long[]{0x0001000000000800L});
    public static final BitSet FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1271 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1304 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1318 = new BitSet(new long[]{0x0001000001000080L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1347 = new BitSet(new long[]{0x0001000001000080L});
    public static final BitSet FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Import1432 = new BitSet(new long[]{0x0000000001000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1477 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_Import1498 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1516 = new BitSet(new long[]{0x0000080000000402L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1552 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_Import1607 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_Import1627 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1653 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1807 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_Option1828 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_Option1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1897 = new BitSet(new long[]{0x0000000001000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1942 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_Rule1963 = new BitSet(new long[]{0x00000000000058A0L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1981 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_Rule1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence2032 = new BitSet(new long[]{0x00000000000058A2L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence2065 = new BitSet(new long[]{0x00000000000058A2L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2125 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_parse_org_emftext_sdk_concretesyntax_Choice2152 = new BitSet(new long[]{0x00000000000058A0L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2178 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_CsString2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2278 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2299 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2317 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2338 = new BitSet(new long[]{0x0000000000830002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2431 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2452 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2466 = new BitSet(new long[]{0x0000000000830002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2559 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2580 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2598 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2619 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2637 = new BitSet(new long[]{0x0000200000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2667 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2693 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2739 = new BitSet(new long[]{0x0000000000830002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2832 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2853 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2871 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2892 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2910 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2931 = new BitSet(new long[]{0x0000000000830002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_BooleanTerminal2984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3024 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3045 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3063 = new BitSet(new long[]{0x0000200000040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3090 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3116 = new BitSet(new long[]{0x0000200000040000L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3157 = new BitSet(new long[]{0x0000000000830002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_EnumTerminal3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal3250 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal3271 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3329 = new BitSet(new long[]{0x00000000008B0002L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_Containment3359 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3385 = new BitSet(new long[]{0x0000000000870002L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_Containment3431 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3465 = new BitSet(new long[]{0x0000000000870002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Containment3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_Containment3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_Containment3585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3621 = new BitSet(new long[]{0x00000000000058A0L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3639 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3657 = new BitSet(new long[]{0x0000000000830002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces3750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABNUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak3790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3841 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3882 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3900 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3921 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3939 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3964 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition3991 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_TokenRedefinition4017 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4088 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4129 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4147 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4172 = new BitSet(new long[]{0x0000000008020002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4199 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4225 = new BitSet(new long[]{0x0000000008020002L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4275 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4295 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4382 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4396 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4414 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4439 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4466 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4492 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective4548 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective4566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_AtomicRegex4606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_RegexReference4646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4686 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4716 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4742 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4788 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4806 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4836 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4862 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_Annotation4937 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation4955 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_Annotation4985 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation5011 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_Annotation5052 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation5086 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_Annotation5147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5199 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5229 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenRedefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition5363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition5373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition5383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition5393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_BooleanTerminal_in_parse_org_emftext_sdk_concretesyntax_Definition5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_EnumTerminal_in_parse_org_emftext_sdk_concretesyntax_Definition5413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition5423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition5453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_AtomicRegex_in_parse_org_emftext_sdk_concretesyntax_RegexPart5474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexReference_in_parse_org_emftext_sdk_concretesyntax_RegexPart5484 = new BitSet(new long[]{0x0000000000000002L});

}