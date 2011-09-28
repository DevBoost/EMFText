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
        this.state.ruleMemo = new HashMap[100+1];
         

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
    	



    // $ANTLR start "start"
    // Cs.g:561:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Cs.g:562:2: ( (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF )
            // Cs.g:563:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(0, 0, 0);
            		addExpectedElement(1, 0);
            		addExpectedElement(2, 0);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Cs.g:570:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax )
            // Cs.g:571:3: c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax
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
    // Cs.g:579:1: parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1= 'ABSTRACT' )? ) a4= 'SYNTAXDEF' (a5= QUALIFIED_NAME ) a6= 'FOR' (a7= QUOTED_60_62 ) ( ( (a8= QUOTED_60_62 ) ) )? ( (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* ) )? ( (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' ) )? ( (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' ) )? ( (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' ) )? ( (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' ) )? a31= 'RULES' a32= '{' ( ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )* a34= '}' ;
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

            // Cs.g:582:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1= 'ABSTRACT' )? ) a4= 'SYNTAXDEF' (a5= QUALIFIED_NAME ) a6= 'FOR' (a7= QUOTED_60_62 ) ( ( (a8= QUOTED_60_62 ) ) )? ( (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* ) )? ( (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' ) )? ( (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' ) )? ( (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' ) )? ( (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' ) )? a31= 'RULES' a32= '{' ( ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )* a34= '}' )
            // Cs.g:583:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1= 'ABSTRACT' )? ) a4= 'SYNTAXDEF' (a5= QUALIFIED_NAME ) a6= 'FOR' (a7= QUOTED_60_62 ) ( ( (a8= QUOTED_60_62 ) ) )? ( (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* ) )? ( (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' ) )? ( (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' ) )? ( (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' ) )? ( (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' ) )? a31= 'RULES' a32= '{' ( ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )* a34= '}'
            {
            // Cs.g:583:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==24) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Cs.g:584:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:584:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:585:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:585:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:586:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
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
            	    				addExpectedElement(0, 1, 1);
            	    				addExpectedElement(1, 1);
            	    				addExpectedElement(2, 1);
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
            		addExpectedElement(0, 2, 2);
            		addExpectedElement(1, 2);
            		addExpectedElement(2, 2);
            	}

            // Cs.g:627:2: ( (a1= 'ABSTRACT' )? )
            // Cs.g:628:3: (a1= 'ABSTRACT' )?
            {
            // Cs.g:628:3: (a1= 'ABSTRACT' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Cs.g:629:4: a1= 'ABSTRACT'
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
            		addExpectedElement(2, 3);
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
            		addExpectedElement(3, 4);
            	}

            // Cs.g:672:2: (a5= QUALIFIED_NAME )
            // Cs.g:673:3: a5= QUALIFIED_NAME
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
            		addExpectedElement(4, 5);
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
            		addExpectedElement(5, 6);
            	}

            // Cs.g:732:2: (a7= QUOTED_60_62 )
            // Cs.g:733:3: a7= QUOTED_60_62
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
            		addExpectedElement(6, 7);
            		addExpectedElement(7, 7);
            		addExpectedElement(8, 7);
            		addExpectedElement(9, 7);
            		addExpectedElement(10, 7);
            		addExpectedElement(11, 7);
            		addExpectedElement(12, 7);
            	}

            // Cs.g:783:2: ( ( (a8= QUOTED_60_62 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QUOTED_60_62) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Cs.g:784:3: ( (a8= QUOTED_60_62 ) )
                    {
                    // Cs.g:784:3: ( (a8= QUOTED_60_62 ) )
                    // Cs.g:785:4: (a8= QUOTED_60_62 )
                    {
                    // Cs.g:785:4: (a8= QUOTED_60_62 )
                    // Cs.g:786:5: a8= QUOTED_60_62
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
                    				addExpectedElement(7, 8);
                    				addExpectedElement(8, 8);
                    				addExpectedElement(9, 8);
                    				addExpectedElement(10, 8);
                    				addExpectedElement(11, 8);
                    				addExpectedElement(12, 8);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(7, 9);
            		addExpectedElement(8, 9);
            		addExpectedElement(9, 9);
            		addExpectedElement(10, 9);
            		addExpectedElement(11, 9);
            		addExpectedElement(12, 9);
            	}

            // Cs.g:843:2: ( (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==38) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Cs.g:844:3: (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* )
                    {
                    // Cs.g:844:3: (a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )* )
                    // Cs.g:845:4: a9= 'START' ( (a10= QUALIFIED_NAME ) ) ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )*
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
                    				addExpectedElement(13, 10);
                    			}

                    // Cs.g:864:4: ( (a10= QUALIFIED_NAME ) )
                    // Cs.g:865:5: (a10= QUALIFIED_NAME )
                    {
                    // Cs.g:865:5: (a10= QUALIFIED_NAME )
                    // Cs.g:866:6: a10= QUALIFIED_NAME
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
                    					addExpectedElement(14, 11);
                    					addExpectedElement(8, 11);
                    					addExpectedElement(9, 11);
                    					addExpectedElement(10, 11);
                    					addExpectedElement(11, 11);
                    					addExpectedElement(12, 11);
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(14, 12);
                    				addExpectedElement(8, 12);
                    				addExpectedElement(9, 12);
                    				addExpectedElement(10, 12);
                    				addExpectedElement(11, 12);
                    				addExpectedElement(12, 12);
                    			}

                    // Cs.g:926:4: ( (a11= ',' ( (a12= QUALIFIED_NAME ) ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==18) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Cs.g:927:5: (a11= ',' ( (a12= QUALIFIED_NAME ) ) )
                    	    {
                    	    // Cs.g:927:5: (a11= ',' ( (a12= QUALIFIED_NAME ) ) )
                    	    // Cs.g:928:6: a11= ',' ( (a12= QUALIFIED_NAME ) )
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
                    	    						addExpectedElement(15, 13);
                    	    					}

                    	    // Cs.g:947:6: ( (a12= QUALIFIED_NAME ) )
                    	    // Cs.g:948:7: (a12= QUALIFIED_NAME )
                    	    {
                    	    // Cs.g:948:7: (a12= QUALIFIED_NAME )
                    	    // Cs.g:949:8: a12= QUALIFIED_NAME
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
                    	    							addExpectedElement(14, 14);
                    	    							addExpectedElement(8, 14);
                    	    							addExpectedElement(9, 14);
                    	    							addExpectedElement(10, 14);
                    	    							addExpectedElement(11, 14);
                    	    							addExpectedElement(12, 14);
                    	    						}

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(14, 15);
                    	    						addExpectedElement(8, 15);
                    	    						addExpectedElement(9, 15);
                    	    						addExpectedElement(10, 15);
                    	    						addExpectedElement(11, 15);
                    	    						addExpectedElement(12, 15);
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
                    				addExpectedElement(14, 16);
                    				addExpectedElement(8, 16);
                    				addExpectedElement(9, 16);
                    				addExpectedElement(10, 16);
                    				addExpectedElement(11, 16);
                    				addExpectedElement(12, 16);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(8, 17);
            		addExpectedElement(9, 17);
            		addExpectedElement(10, 17);
            		addExpectedElement(11, 17);
            		addExpectedElement(12, 17);
            	}

            // Cs.g:1032:2: ( (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==32) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Cs.g:1033:3: (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' )
                    {
                    // Cs.g:1033:3: (a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}' )
                    // Cs.g:1034:4: a13= 'IMPORTS' a14= '{' ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a16= '}'
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
                    				addExpectedElement(16, 18);
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
                    				addExpectedElement(0, 19, 3, 4);
                    				addExpectedElement(17, 19, 5);
                    				addExpectedElement(18, 19);
                    			}

                    // Cs.g:1074:4: ( ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==QUALIFIED_NAME||LA6_0==24) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Cs.g:1075:5: ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    {
                    	    // Cs.g:1075:5: ( (a15_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    // Cs.g:1076:6: (a15_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    {
                    	    // Cs.g:1076:6: (a15_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    // Cs.g:1077:7: a15_0= parse_org_emftext_sdk_concretesyntax_Import
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
                    	    						addExpectedElement(0, 20, 6, 7);
                    	    						addExpectedElement(17, 20, 8);
                    	    						addExpectedElement(18, 20);
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
                    				addExpectedElement(0, 21, 9, 10);
                    				addExpectedElement(17, 21, 11);
                    				addExpectedElement(18, 21);
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
                    				addExpectedElement(9, 22);
                    				addExpectedElement(10, 22);
                    				addExpectedElement(11, 22);
                    				addExpectedElement(12, 22);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(9, 23);
            		addExpectedElement(10, 23);
            		addExpectedElement(11, 23);
            		addExpectedElement(12, 23);
            	}

            // Cs.g:1150:2: ( (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==34) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Cs.g:1151:3: (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' )
                    {
                    // Cs.g:1151:3: (a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}' )
                    // Cs.g:1152:4: a17= 'OPTIONS' a18= '{' ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )* a21= '}'
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
                    				addExpectedElement(19, 24);
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
                    				addExpectedElement(20, 25, 12);
                    				addExpectedElement(21, 25);
                    			}

                    // Cs.g:1191:4: ( ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==QUALIFIED_NAME) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Cs.g:1192:5: ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' )
                    	    {
                    	    // Cs.g:1192:5: ( (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';' )
                    	    // Cs.g:1193:6: (a19_0= parse_org_emftext_sdk_concretesyntax_Option ) a20= ';'
                    	    {
                    	    // Cs.g:1193:6: (a19_0= parse_org_emftext_sdk_concretesyntax_Option )
                    	    // Cs.g:1194:7: a19_0= parse_org_emftext_sdk_concretesyntax_Option
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
                    	    						addExpectedElement(22, 26);
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
                    	    						addExpectedElement(20, 27, 13);
                    	    						addExpectedElement(21, 27);
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
                    				addExpectedElement(20, 28, 14);
                    				addExpectedElement(21, 28);
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
                    				addExpectedElement(10, 29);
                    				addExpectedElement(11, 29);
                    				addExpectedElement(12, 29);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(10, 30);
            		addExpectedElement(11, 30);
            		addExpectedElement(12, 30);
            	}

            // Cs.g:1282:2: ( (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==41) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Cs.g:1283:3: (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' )
                    {
                    // Cs.g:1283:3: (a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}' )
                    // Cs.g:1284:4: a22= 'TOKENS' a23= '{' ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )* a26= '}'
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
                    				addExpectedElement(23, 31);
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
                    				addExpectedElement(0, 32, 15, 16);
                    				addExpectedElement(24, 32, 17);
                    				addExpectedElement(25, 32, 18);
                    				addExpectedElement(26, 32, 19);
                    				addExpectedElement(27, 32, 20);
                    				addExpectedElement(28, 32);
                    			}

                    // Cs.g:1327:4: ( ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==24||LA10_0==29||(LA10_0 >= 35 && LA10_0 <= 36)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // Cs.g:1328:5: ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' )
                    	    {
                    	    // Cs.g:1328:5: ( (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';' )
                    	    // Cs.g:1329:6: (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a25= ';'
                    	    {
                    	    // Cs.g:1329:6: (a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective )
                    	    // Cs.g:1330:7: a24_0= parse_org_emftext_sdk_concretesyntax_TokenDirective
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
                    	    						addExpectedElement(29, 33);
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
                    	    						addExpectedElement(0, 34, 21, 22);
                    	    						addExpectedElement(24, 34, 23);
                    	    						addExpectedElement(25, 34, 24);
                    	    						addExpectedElement(26, 34, 25);
                    	    						addExpectedElement(27, 34, 26);
                    	    						addExpectedElement(28, 34);
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
                    				addExpectedElement(0, 35, 27, 28);
                    				addExpectedElement(24, 35, 29);
                    				addExpectedElement(25, 35, 30);
                    				addExpectedElement(26, 35, 31);
                    				addExpectedElement(27, 35, 32);
                    				addExpectedElement(28, 35);
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
                    				addExpectedElement(11, 36);
                    				addExpectedElement(12, 36);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(11, 37);
            		addExpectedElement(12, 37);
            	}

            // Cs.g:1424:2: ( (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==42) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Cs.g:1425:3: (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' )
                    {
                    // Cs.g:1425:3: (a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}' )
                    // Cs.g:1426:4: a27= 'TOKENSTYLES' a28= '{' ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a30= '}'
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
                    				addExpectedElement(30, 38);
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
                    				addExpectedElement(31, 39, 33);
                    				addExpectedElement(32, 39);
                    			}

                    // Cs.g:1465:4: ( ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==STRING) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Cs.g:1466:5: ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    {
                    	    // Cs.g:1466:5: ( (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    // Cs.g:1467:6: (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    {
                    	    // Cs.g:1467:6: (a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    // Cs.g:1468:7: a29_0= parse_org_emftext_sdk_concretesyntax_TokenStyle
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
                    	    						addExpectedElement(31, 40, 34);
                    	    						addExpectedElement(32, 40);
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
                    				addExpectedElement(31, 41, 35);
                    				addExpectedElement(32, 41);
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
                    				addExpectedElement(12, 42);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(12, 43);
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
            		addExpectedElement(33, 44);
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
            		addExpectedElement(0, 45, 36, 37);
            		addExpectedElement(34, 45, 38);
            		addExpectedElement(35, 45);
            	}

            // Cs.g:1573:2: ( ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==QUALIFIED_NAME||LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Cs.g:1574:3: ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) )
            	    {
            	    // Cs.g:1574:3: ( (a33_0= parse_org_emftext_sdk_concretesyntax_Rule ) )
            	    // Cs.g:1575:4: (a33_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    {
            	    // Cs.g:1575:4: (a33_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    // Cs.g:1576:5: a33_0= parse_org_emftext_sdk_concretesyntax_Rule
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
            	    				addExpectedElement(0, 46, 39, 40);
            	    				addExpectedElement(34, 46, 41);
            	    				addExpectedElement(35, 46);
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
            		addExpectedElement(0, 47, 42, 43);
            		addExpectedElement(34, 47, 44);
            		addExpectedElement(35, 47);
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
    // Cs.g:1637:1: parse_org_emftext_sdk_concretesyntax_Import returns [org.emftext.sdk.concretesyntax.Import element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= ':' (a3= QUOTED_60_62 ) ( ( (a4= QUOTED_60_62 ) ) )? ( (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? ) )? ;
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

            // Cs.g:1640:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= ':' (a3= QUOTED_60_62 ) ( ( (a4= QUOTED_60_62 ) ) )? ( (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? ) )? )
            // Cs.g:1641:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= ':' (a3= QUOTED_60_62 ) ( ( (a4= QUOTED_60_62 ) ) )? ( (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? ) )?
            {
            // Cs.g:1641:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Cs.g:1642:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:1642:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:1643:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:1643:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:1644:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
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
            	    				addExpectedElement(0, 49, 45);
            	    				addExpectedElement(17, 49);
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
            		addExpectedElement(0, 50, 46);
            		addExpectedElement(17, 50);
            	}

            // Cs.g:1678:2: (a1= QUALIFIED_NAME )
            // Cs.g:1679:3: a1= QUALIFIED_NAME
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
            		addExpectedElement(36, 51);
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
            		addExpectedElement(37, 52);
            	}

            // Cs.g:1728:2: (a3= QUOTED_60_62 )
            // Cs.g:1729:3: a3= QUOTED_60_62
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
            		addExpectedElement(38, 53);
            		addExpectedElement(39, 53);
            		addExpectedElement(0, 53, 47, 48);
            		addExpectedElement(17, 53, 49);
            		addExpectedElement(18, 53);
            	}

            // Cs.g:1772:2: ( ( (a4= QUOTED_60_62 ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==QUOTED_60_62) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Cs.g:1773:3: ( (a4= QUOTED_60_62 ) )
                    {
                    // Cs.g:1773:3: ( (a4= QUOTED_60_62 ) )
                    // Cs.g:1774:4: (a4= QUOTED_60_62 )
                    {
                    // Cs.g:1774:4: (a4= QUOTED_60_62 )
                    // Cs.g:1775:5: a4= QUOTED_60_62
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
                    				addExpectedElement(39, 54);
                    				addExpectedElement(0, 54, 50, 51);
                    				addExpectedElement(17, 54, 52);
                    				addExpectedElement(18, 54);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(39, 55);
            		addExpectedElement(0, 55, 53, 54);
            		addExpectedElement(17, 55, 55);
            		addExpectedElement(18, 55);
            	}

            // Cs.g:1823:2: ( (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==43) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Cs.g:1824:3: (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? )
                    {
                    // Cs.g:1824:3: (a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )? )
                    // Cs.g:1825:4: a5= 'WITH' a6= 'SYNTAX' (a7= QUALIFIED_NAME ) ( ( (a8= QUOTED_60_62 ) ) )?
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
                    				addExpectedElement(40, 56);
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
                    				addExpectedElement(41, 57);
                    			}

                    // Cs.g:1853:4: (a7= QUALIFIED_NAME )
                    // Cs.g:1854:5: a7= QUALIFIED_NAME
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
                    				addExpectedElement(42, 58);
                    				addExpectedElement(0, 58, 56, 57);
                    				addExpectedElement(17, 58, 58);
                    				addExpectedElement(18, 58);
                    			}

                    // Cs.g:1896:4: ( ( (a8= QUOTED_60_62 ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==QUOTED_60_62) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // Cs.g:1897:5: ( (a8= QUOTED_60_62 ) )
                            {
                            // Cs.g:1897:5: ( (a8= QUOTED_60_62 ) )
                            // Cs.g:1898:6: (a8= QUOTED_60_62 )
                            {
                            // Cs.g:1898:6: (a8= QUOTED_60_62 )
                            // Cs.g:1899:7: a8= QUOTED_60_62
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
                            						addExpectedElement(0, 59, 59, 60);
                            						addExpectedElement(17, 59, 61);
                            						addExpectedElement(18, 59);
                            					}

                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(0, 60, 62, 63);
                    				addExpectedElement(17, 60, 64);
                    				addExpectedElement(18, 60);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(0, 61, 65, 66);
            		addExpectedElement(17, 61, 67);
            		addExpectedElement(18, 61);
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
    // Cs.g:1956:1: parse_org_emftext_sdk_concretesyntax_Option returns [org.emftext.sdk.concretesyntax.Option element = null] : (a0= QUALIFIED_NAME ) a1= '=' (a2= STRING ) ;
    public final org.emftext.sdk.concretesyntax.Option parse_org_emftext_sdk_concretesyntax_Option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;

        int parse_org_emftext_sdk_concretesyntax_Option_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Cs.g:1959:2: ( (a0= QUALIFIED_NAME ) a1= '=' (a2= STRING ) )
            // Cs.g:1960:2: (a0= QUALIFIED_NAME ) a1= '=' (a2= STRING )
            {
            // Cs.g:1960:2: (a0= QUALIFIED_NAME )
            // Cs.g:1961:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(43, 62);
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
            		addExpectedElement(44, 63);
            	}

            // Cs.g:2010:2: (a2= STRING )
            // Cs.g:2011:3: a2= STRING
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
            		addExpectedElement(22, 64);
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
    // Cs.g:2048:1: parse_org_emftext_sdk_concretesyntax_Rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' ;
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

            // Cs.g:2051:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' )
            // Cs.g:2052:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';'
            {
            // Cs.g:2052:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==24) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Cs.g:2053:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:2053:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:2054:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:2054:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:2055:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
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
            	    				addExpectedElement(0, 65, 68);
            	    				addExpectedElement(34, 65);
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
            		addExpectedElement(0, 66, 69);
            		addExpectedElement(34, 66);
            	}

            // Cs.g:2089:2: (a1= QUALIFIED_NAME )
            // Cs.g:2090:3: a1= QUALIFIED_NAME
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
            		addExpectedElement(45, 67);
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

            // Cs.g:2152:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // Cs.g:2153:3: a3_0= parse_org_emftext_sdk_concretesyntax_Choice
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
            		addExpectedElement(56, 69);
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
            		addExpectedElement(0, 70, 100, 101);
            		addExpectedElement(34, 70, 102);
            		addExpectedElement(35, 70);
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
    // Cs.g:2196:1: parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Sequence parse_org_emftext_sdk_concretesyntax_Sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;

        int parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex = input.index();

        org.emftext.sdk.concretesyntax.Definition a0_0 =null;

        org.emftext.sdk.concretesyntax.Definition a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Cs.g:2199:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) ) )* )
            // Cs.g:2200:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) ) )*
            {
            // Cs.g:2200:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            // Cs.g:2201:3: a0_0= parse_org_emftext_sdk_concretesyntax_Definition
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

            // Cs.g:2238:2: ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==HEXNUMBER||LA20_0==QUALIFIED_NAME||(LA20_0 >= STRING && LA20_0 <= TABNUMBER)||LA20_0==14) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Cs.g:2239:3: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) )
            	    {
            	    // Cs.g:2239:3: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Definition ) )
            	    // Cs.g:2240:4: (a1_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    {
            	    // Cs.g:2240:4: (a1_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    // Cs.g:2241:5: a1_0= parse_org_emftext_sdk_concretesyntax_Definition
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

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            if ( state.backtracking==0 ) {
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
    // Cs.g:2299:1: parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice parse_org_emftext_sdk_concretesyntax_Choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;

        int parse_org_emftext_sdk_concretesyntax_Choice_StartIndex = input.index();

        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0_0 =null;

        org.emftext.sdk.concretesyntax.Sequence a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Cs.g:2302:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* )
            // Cs.g:2303:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            {
            // Cs.g:2303:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            // Cs.g:2304:3: a0_0= parse_org_emftext_sdk_concretesyntax_Sequence
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
            		addExpectedElement(57, 74);
            		addExpectedElement(56, 74);
            		addExpectedElement(58, 74);
            	}

            // Cs.g:2331:2: ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==47) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Cs.g:2332:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    {
            	    // Cs.g:2332:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    // Cs.g:2333:4: a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
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

            	    // Cs.g:2356:4: (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    // Cs.g:2357:5: a2_0= parse_org_emftext_sdk_concretesyntax_Sequence
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
            	    				addExpectedElement(57, 76);
            	    				addExpectedElement(56, 76);
            	    				addExpectedElement(58, 76);
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
            		addExpectedElement(57, 77);
            		addExpectedElement(56, 77);
            		addExpectedElement(58, 77);
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
    // Cs.g:2395:1: parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null] : (a0= STRING ) ;
    public final org.emftext.sdk.concretesyntax.CsString parse_org_emftext_sdk_concretesyntax_CsString() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;

        int parse_org_emftext_sdk_concretesyntax_CsString_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Cs.g:2398:2: ( (a0= STRING ) )
            // Cs.g:2399:2: (a0= STRING )
            {
            // Cs.g:2399:2: (a0= STRING )
            // Cs.g:2400:3: a0= STRING
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
    // Cs.g:2449:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4= '+' |a5= '*' |a6= '?' )? ) ;
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

            // Cs.g:2452:2: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4= '+' |a5= '*' |a6= '?' )? ) )
            // Cs.g:2453:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4= '+' |a5= '*' |a6= '?' )? )
            {
            // Cs.g:2453:2: (a0= QUALIFIED_NAME )
            // Cs.g:2454:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(59, 79);
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
            		addExpectedElement(60, 80);
            	}

            // Cs.g:2513:2: (a2= QUALIFIED_NAME )
            // Cs.g:2514:3: a2= QUALIFIED_NAME
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
            		addExpectedElement(61, 81);
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
            		addExpectedElement(62, 82);
            	}

            // Cs.g:2573:2: ( (a4= '+' |a5= '*' |a6= '?' )? )
            // Cs.g:2574:3: (a4= '+' |a5= '*' |a6= '?' )?
            {
            // Cs.g:2574:3: (a4= '+' |a5= '*' |a6= '?' )?
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
                    // Cs.g:2575:4: a4= '+'
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
                    // Cs.g:2591:8: a5= '*'
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
                    // Cs.g:2607:8: a6= '?'
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
    // Cs.g:2643:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3= '+' |a4= '*' |a5= '?' )? ) ;
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

            // Cs.g:2646:2: ( (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3= '+' |a4= '*' |a5= '?' )? ) )
            // Cs.g:2647:2: (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3= '+' |a4= '*' |a5= '?' )? )
            {
            // Cs.g:2647:2: (a0= QUALIFIED_NAME )
            // Cs.g:2648:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(63, 84);
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
            		addExpectedElement(64, 85);
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
            		addExpectedElement(65, 86);
            	}

            // Cs.g:2724:2: ( (a3= '+' |a4= '*' |a5= '?' )? )
            // Cs.g:2725:3: (a3= '+' |a4= '*' |a5= '?' )?
            {
            // Cs.g:2725:3: (a3= '+' |a4= '*' |a5= '?' )?
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
                    // Cs.g:2726:4: a3= '+'
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
                    // Cs.g:2742:8: a4= '*'
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
                    // Cs.g:2758:8: a5= '?'
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
    // Cs.g:2794:1: parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8= '+' |a9= '*' |a10= '?' )? ) ;
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

            // Cs.g:2797:2: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8= '+' |a9= '*' |a10= '?' )? ) )
            // Cs.g:2798:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8= '+' |a9= '*' |a10= '?' )? )
            {
            // Cs.g:2798:2: (a0= QUALIFIED_NAME )
            // Cs.g:2799:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(66, 88);
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
            		addExpectedElement(67, 89);
            	}

            // Cs.g:2858:2: (a2= QUOTED_39_39_92 )
            // Cs.g:2859:3: a2= QUOTED_39_39_92
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
            		addExpectedElement(68, 90);
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
            		addExpectedElement(69, 91);
            	}

            // Cs.g:2914:2: (a4= QUOTED_39_39_92 )
            // Cs.g:2915:3: a4= QUOTED_39_39_92
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
            		addExpectedElement(70, 92);
            		addExpectedElement(71, 92);
            	}

            // Cs.g:2954:2: ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==18) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Cs.g:2955:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    {
                    // Cs.g:2955:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    // Cs.g:2956:4: a5= ',' (a6= QUOTED_39_39_92 )
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
                    				addExpectedElement(72, 93);
                    			}

                    // Cs.g:2973:4: (a6= QUOTED_39_39_92 )
                    // Cs.g:2974:5: a6= QUOTED_39_39_92
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
                    				addExpectedElement(71, 94);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(71, 95);
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
            		addExpectedElement(73, 96);
            	}

            // Cs.g:3036:2: ( (a8= '+' |a9= '*' |a10= '?' )? )
            // Cs.g:3037:3: (a8= '+' |a9= '*' |a10= '?' )?
            {
            // Cs.g:3037:3: (a8= '+' |a9= '*' |a10= '?' )?
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
                    // Cs.g:3038:4: a8= '+'
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
                    // Cs.g:3054:8: a9= '*'
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
                    // Cs.g:3070:8: a10= '?'
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
    // Cs.g:3106:1: parse_org_emftext_sdk_concretesyntax_BooleanTerminal returns [org.emftext.sdk.concretesyntax.BooleanTerminal element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= STRING ) a3= ':' (a4= STRING ) a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? ) ;
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

            // Cs.g:3109:2: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= STRING ) a3= ':' (a4= STRING ) a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? ) )
            // Cs.g:3110:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= STRING ) a3= ':' (a4= STRING ) a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? )
            {
            // Cs.g:3110:2: (a0= QUALIFIED_NAME )
            // Cs.g:3111:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(74, 98);
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
            		addExpectedElement(75, 99);
            	}

            // Cs.g:3170:2: (a2= STRING )
            // Cs.g:3171:3: a2= STRING
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
            		addExpectedElement(76, 100);
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
            		addExpectedElement(77, 101);
            	}

            // Cs.g:3226:2: (a4= STRING )
            // Cs.g:3227:3: a4= STRING
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
            		addExpectedElement(78, 102);
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
            		addExpectedElement(79, 103);
            	}

            // Cs.g:3282:2: ( (a6= '+' |a7= '*' |a8= '?' )? )
            // Cs.g:3283:3: (a6= '+' |a7= '*' |a8= '?' )?
            {
            // Cs.g:3283:3: (a6= '+' |a7= '*' |a8= '?' )?
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
                    // Cs.g:3284:4: a6= '+'
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
                    // Cs.g:3300:8: a7= '*'
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
                    // Cs.g:3316:8: a8= '?'
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
    // Cs.g:3352:1: parse_org_emftext_sdk_concretesyntax_EnumTerminal returns [org.emftext.sdk.concretesyntax.EnumTerminal element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ( (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ) )* a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? ) ;
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

            // Cs.g:3355:2: ( (a0= QUALIFIED_NAME ) a1= '[' (a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ( (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ) )* a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? ) )
            // Cs.g:3356:2: (a0= QUALIFIED_NAME ) a1= '[' (a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ( (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ) )* a5= ']' ( (a6= '+' |a7= '*' |a8= '?' )? )
            {
            // Cs.g:3356:2: (a0= QUALIFIED_NAME )
            // Cs.g:3357:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(80, 105);
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
            		addExpectedElement(81, 106, 203);
            	}

            // Cs.g:3416:2: (a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal )
            // Cs.g:3417:3: a2_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal
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
            		addExpectedElement(82, 107);
            		addExpectedElement(83, 107);
            	}

            // Cs.g:3446:2: ( (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==18) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // Cs.g:3447:3: (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) )
            	    {
            	    // Cs.g:3447:3: (a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal ) )
            	    // Cs.g:3448:4: a3= ',' (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal )
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
            	    				addExpectedElement(81, 108, 204);
            	    			}

            	    // Cs.g:3465:4: (a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal )
            	    // Cs.g:3466:5: a4_0= parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal
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
            	    				addExpectedElement(82, 109);
            	    				addExpectedElement(83, 109);
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
            		addExpectedElement(82, 110);
            		addExpectedElement(83, 110);
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
            		addExpectedElement(84, 111);
            	}

            // Cs.g:3520:2: ( (a6= '+' |a7= '*' |a8= '?' )? )
            // Cs.g:3521:3: (a6= '+' |a7= '*' |a8= '?' )?
            {
            // Cs.g:3521:3: (a6= '+' |a7= '*' |a8= '?' )?
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
                    // Cs.g:3522:4: a6= '+'
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
                    // Cs.g:3538:8: a7= '*'
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
                    // Cs.g:3554:8: a8= '?'
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
    // Cs.g:3590:1: parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal returns [org.emftext.sdk.concretesyntax.EnumLiteralTerminal element = null] : (a0= QUALIFIED_NAME ) a1= ':' (a2= STRING ) ;
    public final org.emftext.sdk.concretesyntax.EnumLiteralTerminal parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal() throws RecognitionException {
        org.emftext.sdk.concretesyntax.EnumLiteralTerminal element =  null;

        int parse_org_emftext_sdk_concretesyntax_EnumLiteralTerminal_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Cs.g:3593:2: ( (a0= QUALIFIED_NAME ) a1= ':' (a2= STRING ) )
            // Cs.g:3594:2: (a0= QUALIFIED_NAME ) a1= ':' (a2= STRING )
            {
            // Cs.g:3594:2: (a0= QUALIFIED_NAME )
            // Cs.g:3595:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(85, 113);
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
            		addExpectedElement(86, 114);
            	}

            // Cs.g:3648:2: (a2= STRING )
            // Cs.g:3649:3: a2= STRING
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
            		addExpectedElement(82, 115);
            		addExpectedElement(83, 115);
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
    // Cs.g:3687:1: parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5= '+' |a6= '*' |a7= '?' )? ) ;
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

            // Cs.g:3690:2: ( (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5= '+' |a6= '*' |a7= '?' )? ) )
            // Cs.g:3691:2: (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5= '+' |a6= '*' |a7= '?' )? )
            {
            // Cs.g:3691:2: (a0= QUALIFIED_NAME )
            // Cs.g:3692:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(87, 116);
            		addExpectedElement(88, 116);
            	}

            // Cs.g:3735:2: ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==19) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Cs.g:3736:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    {
                    // Cs.g:3736:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    // Cs.g:3737:4: a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
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
                    				addExpectedElement(89, 117);
                    			}

                    // Cs.g:3754:4: (a2= QUALIFIED_NAME )
                    // Cs.g:3755:5: a2= QUALIFIED_NAME
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
                    				addExpectedElement(90, 118);
                    				addExpectedElement(88, 118);
                    			}

                    // Cs.g:3798:4: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==18) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // Cs.g:3799:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    {
                    	    // Cs.g:3799:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    // Cs.g:3800:6: a3= ',' (a4= QUALIFIED_NAME )
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
                    	    						addExpectedElement(91, 119);
                    	    					}

                    	    // Cs.g:3817:6: (a4= QUALIFIED_NAME )
                    	    // Cs.g:3818:7: a4= QUALIFIED_NAME
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
                    	    						addExpectedElement(90, 120);
                    	    						addExpectedElement(88, 120);
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
                    				addExpectedElement(90, 121);
                    				addExpectedElement(88, 121);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(88, 122);
            	}

            // Cs.g:3876:2: ( (a5= '+' |a6= '*' |a7= '?' )? )
            // Cs.g:3877:3: (a5= '+' |a6= '*' |a7= '?' )?
            {
            // Cs.g:3877:3: (a5= '+' |a6= '*' |a7= '?' )?
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
                    // Cs.g:3878:4: a5= '+'
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
                    // Cs.g:3894:8: a6= '*'
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
                    // Cs.g:3910:8: a7= '?'
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
    // Cs.g:3946:1: parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3= '+' |a4= '*' |a5= '?' )? ) ;
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

            // Cs.g:3949:2: (a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3= '+' |a4= '*' |a5= '?' )? ) )
            // Cs.g:3950:2: a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3= '+' |a4= '*' |a5= '?' )? )
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

            // Cs.g:3976:2: (a1_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // Cs.g:3977:3: a1_0= parse_org_emftext_sdk_concretesyntax_Choice
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
            		addExpectedElement(58, 125);
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
            		addExpectedElement(92, 126);
            	}

            // Cs.g:4022:2: ( (a3= '+' |a4= '*' |a5= '?' )? )
            // Cs.g:4023:3: (a3= '+' |a4= '*' |a5= '?' )?
            {
            // Cs.g:4023:3: (a3= '+' |a4= '*' |a5= '?' )?
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
                    // Cs.g:4024:4: a3= '+'
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
                    // Cs.g:4040:8: a4= '*'
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
                    // Cs.g:4056:8: a5= '?'
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
    // Cs.g:4092:1: parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : (a0= HEXNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces parse_org_emftext_sdk_concretesyntax_WhiteSpaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;

        int parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Cs.g:4095:2: ( (a0= HEXNUMBER ) )
            // Cs.g:4096:2: (a0= HEXNUMBER )
            {
            // Cs.g:4096:2: (a0= HEXNUMBER )
            // Cs.g:4097:3: a0= HEXNUMBER
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
    // Cs.g:4146:1: parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : (a0= TABNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.LineBreak parse_org_emftext_sdk_concretesyntax_LineBreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;

        int parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Cs.g:4149:2: ( (a0= TABNUMBER ) )
            // Cs.g:4150:2: (a0= TABNUMBER )
            {
            // Cs.g:4150:2: (a0= TABNUMBER )
            // Cs.g:4151:3: a0= TABNUMBER
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
    // Cs.g:4200:1: parse_org_emftext_sdk_concretesyntax_TokenRedefinition returns [org.emftext.sdk.concretesyntax.TokenRedefinition element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'REDEFINE' (a2= QUALIFIED_NAME ) a3= 'AS' (a4= QUALIFIED_NAME ) (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ;
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

            // Cs.g:4203:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'REDEFINE' (a2= QUALIFIED_NAME ) a3= 'AS' (a4= QUALIFIED_NAME ) (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* )
            // Cs.g:4204:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'REDEFINE' (a2= QUALIFIED_NAME ) a3= 'AS' (a4= QUALIFIED_NAME ) (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            {
            // Cs.g:4204:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==24) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Cs.g:4205:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:4205:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:4206:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:4206:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:4207:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
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
            	    				addExpectedElement(0, 130, 285);
            	    				addExpectedElement(24, 130);
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
            		addExpectedElement(0, 131, 286);
            		addExpectedElement(24, 131);
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
            		addExpectedElement(93, 132);
            	}

            // Cs.g:4255:2: (a2= QUALIFIED_NAME )
            // Cs.g:4256:3: a2= QUALIFIED_NAME
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
            		addExpectedElement(94, 133);
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
            		addExpectedElement(95, 134);
            	}

            // Cs.g:4309:2: (a4= QUALIFIED_NAME )
            // Cs.g:4310:3: a4= QUALIFIED_NAME
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
            		addExpectedElement(96, 135, 287);
            		addExpectedElement(97, 135, 288);
            	}

            // Cs.g:4346:2: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Cs.g:4347:3: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
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
            		addExpectedElement(98, 136);
            		addExpectedElement(29, 136);
            	}

            // Cs.g:4373:2: ( (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==17) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Cs.g:4374:3: (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Cs.g:4374:3: (a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Cs.g:4375:4: a6= '+' (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
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
            	    				addExpectedElement(96, 137, 289);
            	    				addExpectedElement(97, 137, 290);
            	    			}

            	    // Cs.g:4390:4: (a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Cs.g:4391:5: a7_0= parse_org_emftext_sdk_concretesyntax_RegexPart
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
            	    				addExpectedElement(98, 138);
            	    				addExpectedElement(29, 138);
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
            		addExpectedElement(98, 139);
            		addExpectedElement(29, 139);
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
    // Cs.g:4427:1: parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition returns [org.emftext.sdk.concretesyntax.NormalTokenDefinition element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? ;
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

            // Cs.g:4430:2: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? )
            // Cs.g:4431:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            {
            // Cs.g:4431:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==24) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // Cs.g:4432:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Cs.g:4432:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Cs.g:4433:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Cs.g:4433:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Cs.g:4434:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
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
            	    				addExpectedElement(0, 140, 291);
            	    				addExpectedElement(25, 140);
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
            		addExpectedElement(0, 141, 292);
            		addExpectedElement(25, 141);
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
            		addExpectedElement(99, 142);
            	}

            // Cs.g:4482:2: (a2= QUALIFIED_NAME )
            // Cs.g:4483:3: a2= QUALIFIED_NAME
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
            		addExpectedElement(96, 143, 293);
            		addExpectedElement(97, 143, 294);
            	}

            // Cs.g:4519:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Cs.g:4520:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
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
            		addExpectedElement(100, 144);
            		addExpectedElement(101, 144);
            		addExpectedElement(29, 144);
            	}

            // Cs.g:4547:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==17) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Cs.g:4548:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Cs.g:4548:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Cs.g:4549:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
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
            	    				addExpectedElement(96, 145, 295);
            	    				addExpectedElement(97, 145, 296);
            	    			}

            	    // Cs.g:4564:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Cs.g:4565:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
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
            	    				addExpectedElement(100, 146);
            	    				addExpectedElement(101, 146);
            	    				addExpectedElement(29, 146);
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
            		addExpectedElement(100, 147);
            		addExpectedElement(101, 147);
            		addExpectedElement(29, 147);
            	}

            // Cs.g:4601:2: ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==27) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // Cs.g:4602:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    {
                    // Cs.g:4602:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    // Cs.g:4603:4: a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME )
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
                    				addExpectedElement(102, 148);
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
                    				addExpectedElement(103, 149);
                    			}

                    // Cs.g:4631:4: (a8= QUALIFIED_NAME )
                    // Cs.g:4632:5: a8= QUALIFIED_NAME
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
                    				addExpectedElement(29, 150);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(29, 151);
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
    // Cs.g:4676:1: parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition returns [org.emftext.sdk.concretesyntax.PartialTokenDefinition element = null] : a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ;
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

            // Cs.g:4679:2: (a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* )
            // Cs.g:4680:2: a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
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
            		addExpectedElement(104, 152);
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
            		addExpectedElement(105, 153);
            	}

            // Cs.g:4708:2: (a2= QUALIFIED_NAME )
            // Cs.g:4709:3: a2= QUALIFIED_NAME
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
            		addExpectedElement(96, 154, 297);
            		addExpectedElement(97, 154, 298);
            	}

            // Cs.g:4745:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Cs.g:4746:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
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
            		addExpectedElement(106, 155);
            		addExpectedElement(29, 155);
            	}

            // Cs.g:4772:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==17) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // Cs.g:4773:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Cs.g:4773:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Cs.g:4774:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
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
            	    				addExpectedElement(96, 156, 299);
            	    				addExpectedElement(97, 156, 300);
            	    			}

            	    // Cs.g:4789:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Cs.g:4790:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
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
            	    				addExpectedElement(106, 157);
            	    				addExpectedElement(29, 157);
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
            		addExpectedElement(106, 158);
            		addExpectedElement(29, 158);
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
    // Cs.g:4826:1: parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null] : a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.TokenPriorityDirective parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenPriorityDirective element =  null;

        int parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Cs.g:4829:2: (a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) )
            // Cs.g:4830:2: a0= 'PRIORITIZE' (a1= QUALIFIED_NAME )
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
            		addExpectedElement(107, 159);
            	}

            // Cs.g:4844:2: (a1= QUALIFIED_NAME )
            // Cs.g:4845:3: a1= QUALIFIED_NAME
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
            		addExpectedElement(29, 160);
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
    // Cs.g:4886:1: parse_org_emftext_sdk_concretesyntax_AtomicRegex returns [org.emftext.sdk.concretesyntax.AtomicRegex element = null] : (a0= QUOTED_36_36 ) ;
    public final org.emftext.sdk.concretesyntax.AtomicRegex parse_org_emftext_sdk_concretesyntax_AtomicRegex() throws RecognitionException {
        org.emftext.sdk.concretesyntax.AtomicRegex element =  null;

        int parse_org_emftext_sdk_concretesyntax_AtomicRegex_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Cs.g:4889:2: ( (a0= QUOTED_36_36 ) )
            // Cs.g:4890:2: (a0= QUOTED_36_36 )
            {
            // Cs.g:4890:2: (a0= QUOTED_36_36 )
            // Cs.g:4891:3: a0= QUOTED_36_36
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
            		addExpectedElement(98, 161);
            		addExpectedElement(29, 161);
            		addExpectedElement(100, 161);
            		addExpectedElement(101, 161);
            		addExpectedElement(106, 161);
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
    // Cs.g:4932:1: parse_org_emftext_sdk_concretesyntax_RegexReference returns [org.emftext.sdk.concretesyntax.RegexReference element = null] : (a0= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.RegexReference parse_org_emftext_sdk_concretesyntax_RegexReference() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexReference element =  null;

        int parse_org_emftext_sdk_concretesyntax_RegexReference_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Cs.g:4935:2: ( (a0= QUALIFIED_NAME ) )
            // Cs.g:4936:2: (a0= QUALIFIED_NAME )
            {
            // Cs.g:4936:2: (a0= QUALIFIED_NAME )
            // Cs.g:4937:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(98, 162);
            		addExpectedElement(29, 162);
            		addExpectedElement(100, 162);
            		addExpectedElement(101, 162);
            		addExpectedElement(106, 162);
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
    // Cs.g:4982:1: parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null] : (a0= STRING ) ( (a1= ',' (a2= STRING ) ) )* a3= 'COLOR' (a4= HEXNUMBER ) ( (a5= ',' (a6= QUALIFIED_NAME ) ) )* a7= ';' ;
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

            // Cs.g:4985:2: ( (a0= STRING ) ( (a1= ',' (a2= STRING ) ) )* a3= 'COLOR' (a4= HEXNUMBER ) ( (a5= ',' (a6= QUALIFIED_NAME ) ) )* a7= ';' )
            // Cs.g:4986:2: (a0= STRING ) ( (a1= ',' (a2= STRING ) ) )* a3= 'COLOR' (a4= HEXNUMBER ) ( (a5= ',' (a6= QUALIFIED_NAME ) ) )* a7= ';'
            {
            // Cs.g:4986:2: (a0= STRING )
            // Cs.g:4987:3: a0= STRING
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
            		addExpectedElement(108, 163);
            		addExpectedElement(109, 163);
            	}

            // Cs.g:5023:2: ( (a1= ',' (a2= STRING ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==18) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // Cs.g:5024:3: (a1= ',' (a2= STRING ) )
            	    {
            	    // Cs.g:5024:3: (a1= ',' (a2= STRING ) )
            	    // Cs.g:5025:4: a1= ',' (a2= STRING )
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
            	    				addExpectedElement(110, 164);
            	    			}

            	    // Cs.g:5039:4: (a2= STRING )
            	    // Cs.g:5040:5: a2= STRING
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
            	    				addExpectedElement(108, 165);
            	    				addExpectedElement(109, 165);
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
            		addExpectedElement(108, 166);
            		addExpectedElement(109, 166);
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
            		addExpectedElement(111, 167);
            	}

            // Cs.g:5098:2: (a4= HEXNUMBER )
            // Cs.g:5099:3: a4= HEXNUMBER
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
            		addExpectedElement(112, 168);
            		addExpectedElement(113, 168);
            	}

            // Cs.g:5135:2: ( (a5= ',' (a6= QUALIFIED_NAME ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==18) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // Cs.g:5136:3: (a5= ',' (a6= QUALIFIED_NAME ) )
            	    {
            	    // Cs.g:5136:3: (a5= ',' (a6= QUALIFIED_NAME ) )
            	    // Cs.g:5137:4: a5= ',' (a6= QUALIFIED_NAME )
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
            	    				addExpectedElement(114, 169);
            	    			}

            	    // Cs.g:5151:4: (a6= QUALIFIED_NAME )
            	    // Cs.g:5152:5: a6= QUALIFIED_NAME
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
            	    				addExpectedElement(112, 170);
            	    				addExpectedElement(113, 170);
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
            		addExpectedElement(112, 171);
            		addExpectedElement(113, 171);
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
            		addExpectedElement(31, 172, 301);
            		addExpectedElement(32, 172);
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
    // Cs.g:5213:1: parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null] : a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? ;
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

            // Cs.g:5216:2: (a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? )
            // Cs.g:5217:2: a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
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
            		addExpectedElement(115, 173);
            	}

            // Cs.g:5231:2: (a1= QUALIFIED_NAME )
            // Cs.g:5232:3: a1= QUALIFIED_NAME
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
            		addExpectedElement(116, 174);
            		addExpectedElement(0, 174, 302);
            		addExpectedElement(1, 174);
            		addExpectedElement(2, 174);
            		addExpectedElement(17, 174);
            		addExpectedElement(34, 174);
            		addExpectedElement(24, 174);
            		addExpectedElement(25, 174);
            	}

            // Cs.g:5274:2: ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==14) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // Cs.g:5275:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    {
                    // Cs.g:5275:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    // Cs.g:5276:4: a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')'
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
                    				addExpectedElement(117, 175, 303);
                    			}

                    // Cs.g:5290:4: (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    // Cs.g:5291:5: a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
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
                    				addExpectedElement(118, 176);
                    				addExpectedElement(119, 176);
                    			}

                    // Cs.g:5317:4: ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==18) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // Cs.g:5318:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    {
                    	    // Cs.g:5318:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    // Cs.g:5319:6: a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
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
                    	    						addExpectedElement(117, 177, 304);
                    	    					}

                    	    // Cs.g:5333:6: (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    // Cs.g:5334:7: a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
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
                    	    						addExpectedElement(118, 178);
                    	    						addExpectedElement(119, 178);
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
                    				addExpectedElement(118, 179);
                    				addExpectedElement(119, 179);
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
                    				addExpectedElement(0, 180, 305);
                    				addExpectedElement(1, 180);
                    				addExpectedElement(2, 180);
                    				addExpectedElement(17, 180);
                    				addExpectedElement(34, 180);
                    				addExpectedElement(24, 180);
                    				addExpectedElement(25, 180);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(0, 181, 306);
            		addExpectedElement(1, 181);
            		addExpectedElement(2, 181);
            		addExpectedElement(17, 181);
            		addExpectedElement(34, 181);
            		addExpectedElement(24, 181);
            		addExpectedElement(25, 181);
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
    // Cs.g:5403:1: parse_org_emftext_sdk_concretesyntax_KeyValuePair returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null] : (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= STRING ) ) )? ;
    public final org.emftext.sdk.concretesyntax.KeyValuePair parse_org_emftext_sdk_concretesyntax_KeyValuePair() throws RecognitionException {
        org.emftext.sdk.concretesyntax.KeyValuePair element =  null;

        int parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Cs.g:5406:2: ( (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= STRING ) ) )? )
            // Cs.g:5407:2: (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= STRING ) ) )?
            {
            // Cs.g:5407:2: (a0= QUALIFIED_NAME )
            // Cs.g:5408:3: a0= QUALIFIED_NAME
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
            		addExpectedElement(120, 182);
            		addExpectedElement(118, 182);
            		addExpectedElement(119, 182);
            	}

            // Cs.g:5445:2: ( (a1= '=' (a2= STRING ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==22) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // Cs.g:5446:3: (a1= '=' (a2= STRING ) )
                    {
                    // Cs.g:5446:3: (a1= '=' (a2= STRING ) )
                    // Cs.g:5447:4: a1= '=' (a2= STRING )
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
                    				addExpectedElement(121, 183);
                    			}

                    // Cs.g:5461:4: (a2= STRING )
                    // Cs.g:5462:5: a2= STRING
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
                    				addExpectedElement(118, 184);
                    				addExpectedElement(119, 184);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(118, 185);
            		addExpectedElement(119, 185);
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
    // Cs.g:5508:1: parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null] : (c0= parse_org_emftext_sdk_concretesyntax_TokenRedefinition |c1= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition |c2= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition |c3= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective );
    public final org.emftext.sdk.concretesyntax.TokenDirective parse_org_emftext_sdk_concretesyntax_TokenDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDirective element =  null;

        int parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex = input.index();

        org.emftext.sdk.concretesyntax.TokenRedefinition c0 =null;

        org.emftext.sdk.concretesyntax.NormalTokenDefinition c1 =null;

        org.emftext.sdk.concretesyntax.PartialTokenDefinition c2 =null;

        org.emftext.sdk.concretesyntax.TokenPriorityDirective c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Cs.g:5509:2: (c0= parse_org_emftext_sdk_concretesyntax_TokenRedefinition |c1= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition |c2= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition |c3= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective )
            int alt44=4;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // Cs.g:5510:2: c0= parse_org_emftext_sdk_concretesyntax_TokenRedefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenRedefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5312);
                    c0=parse_org_emftext_sdk_concretesyntax_TokenRedefinition();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Cs.g:5511:4: c1= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5322);
                    c1=parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Cs.g:5512:4: c2= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5332);
                    c2=parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Cs.g:5513:4: c3= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective
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
    // Cs.g:5517:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString |c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken |c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken |c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes |c4= parse_org_emftext_sdk_concretesyntax_BooleanTerminal |c5= parse_org_emftext_sdk_concretesyntax_EnumTerminal |c6= parse_org_emftext_sdk_concretesyntax_Containment |c7= parse_org_emftext_sdk_concretesyntax_CompoundDefinition |c8= parse_org_emftext_sdk_concretesyntax_WhiteSpaces |c9= parse_org_emftext_sdk_concretesyntax_LineBreak );
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

            // Cs.g:5518:2: (c0= parse_org_emftext_sdk_concretesyntax_CsString |c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken |c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken |c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes |c4= parse_org_emftext_sdk_concretesyntax_BooleanTerminal |c5= parse_org_emftext_sdk_concretesyntax_EnumTerminal |c6= parse_org_emftext_sdk_concretesyntax_Containment |c7= parse_org_emftext_sdk_concretesyntax_CompoundDefinition |c8= parse_org_emftext_sdk_concretesyntax_WhiteSpaces |c9= parse_org_emftext_sdk_concretesyntax_LineBreak )
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
                    // Cs.g:5519:2: c0= parse_org_emftext_sdk_concretesyntax_CsString
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition5363);
                    c0=parse_org_emftext_sdk_concretesyntax_CsString();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Cs.g:5520:4: c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition5373);
                    c1=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Cs.g:5521:4: c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition5383);
                    c2=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Cs.g:5522:4: c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition5393);
                    c3=parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Cs.g:5523:4: c4= parse_org_emftext_sdk_concretesyntax_BooleanTerminal
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_BooleanTerminal_in_parse_org_emftext_sdk_concretesyntax_Definition5403);
                    c4=parse_org_emftext_sdk_concretesyntax_BooleanTerminal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Cs.g:5524:4: c5= parse_org_emftext_sdk_concretesyntax_EnumTerminal
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_EnumTerminal_in_parse_org_emftext_sdk_concretesyntax_Definition5413);
                    c5=parse_org_emftext_sdk_concretesyntax_EnumTerminal();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Cs.g:5525:4: c6= parse_org_emftext_sdk_concretesyntax_Containment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition5423);
                    c6=parse_org_emftext_sdk_concretesyntax_Containment();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Cs.g:5526:4: c7= parse_org_emftext_sdk_concretesyntax_CompoundDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition5433);
                    c7=parse_org_emftext_sdk_concretesyntax_CompoundDefinition();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Cs.g:5527:4: c8= parse_org_emftext_sdk_concretesyntax_WhiteSpaces
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition5443);
                    c8=parse_org_emftext_sdk_concretesyntax_WhiteSpaces();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Cs.g:5528:4: c9= parse_org_emftext_sdk_concretesyntax_LineBreak
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
    // Cs.g:5532:1: parse_org_emftext_sdk_concretesyntax_RegexPart returns [org.emftext.sdk.concretesyntax.RegexPart element = null] : (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex |c1= parse_org_emftext_sdk_concretesyntax_RegexReference );
    public final org.emftext.sdk.concretesyntax.RegexPart parse_org_emftext_sdk_concretesyntax_RegexPart() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexPart element =  null;

        int parse_org_emftext_sdk_concretesyntax_RegexPart_StartIndex = input.index();

        org.emftext.sdk.concretesyntax.AtomicRegex c0 =null;

        org.emftext.sdk.concretesyntax.RegexReference c1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Cs.g:5533:2: (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex |c1= parse_org_emftext_sdk_concretesyntax_RegexReference )
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
                    // Cs.g:5534:2: c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_AtomicRegex_in_parse_org_emftext_sdk_concretesyntax_RegexPart5474);
                    c0=parse_org_emftext_sdk_concretesyntax_AtomicRegex();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Cs.g:5535:4: c1= parse_org_emftext_sdk_concretesyntax_RegexReference
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
            return "5508:1: parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null] : (c0= parse_org_emftext_sdk_concretesyntax_TokenRedefinition |c1= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition |c2= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition |c3= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective );";
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