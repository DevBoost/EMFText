// $ANTLR 3.4

	package org.emftext.test.cct5.resource.cct5.mopp;
	
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


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Cct5Parser extends Cct5ANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINEBREAK", "QUOTED_34_34", "TEXT", "WHITESPACE", "':'", "'BEGIN_ANIMAL'", "'BEGIN_FARMER'", "'Diet'", "'END_ANIMAL'", "'END_FARMER'", "'Farm'", "'FeedingInstruction'", "'favored'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int LINEBREAK=4;
    public static final int QUOTED_34_34=5;
    public static final int TEXT=6;
    public static final int WHITESPACE=7;

    // delegates
    public Cct5ANTLRParserBase[] getDelegates() {
        return new Cct5ANTLRParserBase[] {};
    }

    // delegators


    public Cct5Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public Cct5Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(8 + 1);
         

    }

    public String[] getTokenNames() { return Cct5Parser.tokenNames; }
    public String getGrammarFileName() { return "Cct5.g"; }


    	private org.emftext.test.cct5.resource.cct5.ICct5TokenResolverFactory tokenResolverFactory = new org.emftext.test.cct5.resource.cct5.mopp.Cct5TokenResolverFactory();
    	
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
    	private List<org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal> expectedElements = new ArrayList<org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal>();
    	
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
    	List<EObject> incompleteObjects = new ArrayList<EObject>();
    	
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
    	
    	private org.emftext.test.cct5.resource.cct5.ICct5LocationMap locationMap;
    	
    	private org.emftext.test.cct5.resource.cct5.mopp.Cct5SyntaxErrorMessageConverter syntaxErrorMessageConverter = new org.emftext.test.cct5.resource.cct5.mopp.Cct5SyntaxErrorMessageConverter(tokenNames);
    	
    	@Override
    	public void reportError(RecognitionException re) {
    		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
    	}
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>() {
    			public boolean execute(org.emftext.test.cct5.resource.cct5.ICct5TextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.emftext.test.cct5.resource.cct5.ICct5Problem() {
    					public org.emftext.test.cct5.resource.cct5.Cct5EProblemSeverity getSeverity() {
    						return org.emftext.test.cct5.resource.cct5.Cct5EProblemSeverity.ERROR;
    					}
    					public org.emftext.test.cct5.resource.cct5.Cct5EProblemType getType() {
    						return org.emftext.test.cct5.resource.cct5.Cct5EProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public Collection<org.emftext.test.cct5.resource.cct5.ICct5QuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	protected void addErrorToResource(org.emftext.test.cct5.resource.cct5.mopp.Cct5LocalizedMessage message) {
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
    		org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement terminal = org.emftext.test.cct5.resource.cct5.grammar.Cct5FollowSetProvider.TERMINALS[terminalID];
    		org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] containmentFeatures = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = org.emftext.test.cct5.resource.cct5.grammar.Cct5FollowSetProvider.LINKS[ids[i]];
    		}
    		org.emftext.test.cct5.resource.cct5.grammar.Cct5ContainmentTrace containmentTrace = new org.emftext.test.cct5.resource.cct5.grammar.Cct5ContainmentTrace(eClass, containmentFeatures);
    		EObject container = getLastIncompleteElement();
    		org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal expectedElement = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		final org.emftext.test.cct5.resource.cct5.ICct5LocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>() {
    			public boolean execute(org.emftext.test.cct5.resource.cct5.ICct5TextResource resource) {
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
    		final org.emftext.test.cct5.resource.cct5.ICct5LocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>() {
    			public boolean execute(org.emftext.test.cct5.resource.cct5.ICct5TextResource resource) {
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
    	protected void setLocalizationEnd(Collection<org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		final org.emftext.test.cct5.resource.cct5.ICct5LocationMap locationMap = this.locationMap;
    		if (locationMap == null) {
    			// the locationMap can be null if the parser is used for code completion
    			return;
    		}
    		postParseCommands.add(new org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>() {
    			public boolean execute(org.emftext.test.cct5.resource.cct5.ICct5TextResource resource) {
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.emftext.test.cct5.resource.cct5.ICct5TextParser createInstance(InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new Cct5Parser(new CommonTokenStream(new Cct5Lexer(new ANTLRInputStream(actualInputStream))));
    			} else {
    				return new Cct5Parser(new CommonTokenStream(new Cct5Lexer(new ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (IOException e) {
    			new org.emftext.test.cct5.resource.cct5.util.Cct5RuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public Cct5Parser() {
    		super(null);
    	}
    	
    	protected EObject doParse() throws RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((Cct5Lexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((Cct5Lexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof EClass) {
    			EClass type = (EClass) typeObject;
    			if (type.getInstanceClass() == org.emftext.test.cct5.Farm.class) {
    				return parse_org_emftext_test_cct5_Farm();
    			}
    			if (type.getInstanceClass() == org.emftext.test.cct5.Farmer.class) {
    				return parse_org_emftext_test_cct5_Farmer();
    			}
    			if (type.getInstanceClass() == org.emftext.test.cct5.Animal.class) {
    				return parse_org_emftext_test_cct5_Animal();
    			}
    			if (type.getInstanceClass() == org.emftext.test.cct5.Diet.class) {
    				return parse_org_emftext_test_cct5_Diet();
    			}
    		}
    		throw new org.emftext.test.cct5.resource.cct5.mopp.Cct5UnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(org.emftext.test.cct5.resource.cct5.ICct5Options.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.emftext.test.cct5.resource.cct5.ICct5ParseResult parse() {
    		// Reset parser state
    		terminateParsing = false;
    		postParseCommands = new ArrayList<org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource>>();
    		org.emftext.test.cct5.resource.cct5.mopp.Cct5ParseResult parseResult = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ParseResult();
    		if (disableLocationMap) {
    			locationMap = new org.emftext.test.cct5.resource.cct5.mopp.Cct5DevNullLocationMap();
    		} else {
    			locationMap = new org.emftext.test.cct5.resource.cct5.mopp.Cct5LocationMap();
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
    	
    	public List<org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal> parseToExpectedElements(EClass type, org.emftext.test.cct5.resource.cct5.ICct5TextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
    		org.emftext.test.cct5.resource.cct5.ICct5ParseResult result = parse();
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
    			for (org.emftext.test.cct5.resource.cct5.ICct5Command<org.emftext.test.cct5.resource.cct5.ICct5TextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		Set<org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal> currentFollowSet = new LinkedHashSet<org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal>();
    		List<org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal> newFollowSet = new ArrayList<org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 24;
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
    				for (org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						Collection<org.emftext.test.cct5.resource.cct5.util.Cct5Pair<org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.emftext.test.cct5.resource.cct5.util.Cct5Pair<org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[]> newFollowerPair : newFollowers) {
    							org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement newFollower = newFollowerPair.getLeft();
    							EObject container = getLastIncompleteElement();
    							org.emftext.test.cct5.resource.cct5.grammar.Cct5ContainmentTrace containmentTrace = new org.emftext.test.cct5.resource.cct5.grammar.Cct5ContainmentTrace(null, newFollowerPair.getRight());
    							org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal newFollowTerminal = new org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal expectedElement, int tokenIndex) {
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
    	



    // $ANTLR start "start"
    // Cct5.g:489:1: start returns [ EObject element = null] : (c0= parse_org_emftext_test_cct5_Farm ) EOF ;
    public final EObject start() throws RecognitionException {
        EObject element =  null;

        int start_StartIndex = input.index();

        org.emftext.test.cct5.Farm c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Cct5.g:490:2: ( (c0= parse_org_emftext_test_cct5_Farm ) EOF )
            // Cct5.g:491:2: (c0= parse_org_emftext_test_cct5_Farm ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Cct5.g:496:2: (c0= parse_org_emftext_test_cct5_Farm )
            // Cct5.g:497:3: c0= parse_org_emftext_test_cct5_Farm
            {
            pushFollow(FOLLOW_parse_org_emftext_test_cct5_Farm_in_start82);
            c0=parse_org_emftext_test_cct5_Farm();

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



    // $ANTLR start "parse_org_emftext_test_cct5_Farm"
    // Cct5.g:505:1: parse_org_emftext_test_cct5_Farm returns [org.emftext.test.cct5.Farm element = null] : a0= 'Farm' a1= '{' ( ( (a2_0= parse_org_emftext_test_cct5_Farmer ) ) )+ ( ( (a3_0= parse_org_emftext_test_cct5_Animal ) ) )* a4= '}' ;
    public final org.emftext.test.cct5.Farm parse_org_emftext_test_cct5_Farm() throws RecognitionException {
        org.emftext.test.cct5.Farm element =  null;

        int parse_org_emftext_test_cct5_Farm_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a4=null;
        org.emftext.test.cct5.Farmer a2_0 =null;

        org.emftext.test.cct5.Animal a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Cct5.g:508:2: (a0= 'Farm' a1= '{' ( ( (a2_0= parse_org_emftext_test_cct5_Farmer ) ) )+ ( ( (a3_0= parse_org_emftext_test_cct5_Animal ) ) )* a4= '}' )
            // Cct5.g:509:2: a0= 'Farm' a1= '{' ( ( (a2_0= parse_org_emftext_test_cct5_Farmer ) ) )+ ( ( (a3_0= parse_org_emftext_test_cct5_Animal ) ) )* a4= '}'
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_test_cct5_Farm115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarm();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_0_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_test_cct5_Farm129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarm();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_0_0_0_1, null, true);
            		copyLocalizationInfos((CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[2]);
            	}

            // Cct5.g:537:2: ( ( (a2_0= parse_org_emftext_test_cct5_Farmer ) ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Cct5.g:538:3: ( (a2_0= parse_org_emftext_test_cct5_Farmer ) )
            	    {
            	    // Cct5.g:538:3: ( (a2_0= parse_org_emftext_test_cct5_Farmer ) )
            	    // Cct5.g:539:4: (a2_0= parse_org_emftext_test_cct5_Farmer )
            	    {
            	    // Cct5.g:539:4: (a2_0= parse_org_emftext_test_cct5_Farmer )
            	    // Cct5.g:540:5: a2_0= parse_org_emftext_test_cct5_Farmer
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_test_cct5_Farmer_in_parse_org_emftext_test_cct5_Farm158);
            	    a2_0=parse_org_emftext_test_cct5_Farmer();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.test.cct5.resource.cct5.mopp.Cct5TerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarm();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.test.cct5.Cct5Package.FARM__FARMER, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_0_0_0_2_0_0_0, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[3]);
            	    				addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[4]);
            	    				addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[5]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[7]);
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[8]);
            	}

            // Cct5.g:576:2: ( ( (a3_0= parse_org_emftext_test_cct5_Animal ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==9) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Cct5.g:577:3: ( (a3_0= parse_org_emftext_test_cct5_Animal ) )
            	    {
            	    // Cct5.g:577:3: ( (a3_0= parse_org_emftext_test_cct5_Animal ) )
            	    // Cct5.g:578:4: (a3_0= parse_org_emftext_test_cct5_Animal )
            	    {
            	    // Cct5.g:578:4: (a3_0= parse_org_emftext_test_cct5_Animal )
            	    // Cct5.g:579:5: a3_0= parse_org_emftext_test_cct5_Animal
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_test_cct5_Animal_in_parse_org_emftext_test_cct5_Farm214);
            	    a3_0=parse_org_emftext_test_cct5_Animal();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.test.cct5.resource.cct5.mopp.Cct5TerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarm();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a3_0 != null) {
            	    						if (a3_0 != null) {
            	    							Object value = a3_0;
            	    							addObjectToList(element, org.emftext.test.cct5.Cct5Package.FARM__ANIMAL, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_0_0_0_3_0_0_0, a3_0, true);
            	    						copyLocalizationInfos(a3_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[9]);
            	    				addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[10]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[11]);
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[12]);
            	}

            a4=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_test_cct5_Farm255); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarm();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_0_0_0_4, null, true);
            		copyLocalizationInfos((CommonToken)a4, element);
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
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_test_cct5_Farm_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_test_cct5_Farm"



    // $ANTLR start "parse_org_emftext_test_cct5_Farmer"
    // Cct5.g:628:1: parse_org_emftext_test_cct5_Farmer returns [org.emftext.test.cct5.Farmer element = null] : a0= 'BEGIN_FARMER' (a1= TEXT ) a2= 'Diet' a3= ':' (a4_0= parse_org_emftext_test_cct5_Diet ) a5= 'END_FARMER' ;
    public final org.emftext.test.cct5.Farmer parse_org_emftext_test_cct5_Farmer() throws RecognitionException {
        org.emftext.test.cct5.Farmer element =  null;

        int parse_org_emftext_test_cct5_Farmer_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        org.emftext.test.cct5.Diet a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Cct5.g:631:2: (a0= 'BEGIN_FARMER' (a1= TEXT ) a2= 'Diet' a3= ':' (a4_0= parse_org_emftext_test_cct5_Diet ) a5= 'END_FARMER' )
            // Cct5.g:632:2: a0= 'BEGIN_FARMER' (a1= TEXT ) a2= 'Diet' a3= ':' (a4_0= parse_org_emftext_test_cct5_Diet ) a5= 'END_FARMER'
            {
            a0=(Token)match(input,10,FOLLOW_10_in_parse_org_emftext_test_cct5_Farmer284); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarmer();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[13]);
            	}

            // Cct5.g:646:2: (a1= TEXT )
            // Cct5.g:647:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_test_cct5_Farmer302); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.test.cct5.resource.cct5.mopp.Cct5TerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarmer();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.test.cct5.resource.cct5.ICct5TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.test.cct5.resource.cct5.ICct5TokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[14]);
            	}

            a2=(Token)match(input,11,FOLLOW_11_in_parse_org_emftext_test_cct5_Farmer323); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarmer();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[15]);
            	}

            a3=(Token)match(input,8,FOLLOW_8_in_parse_org_emftext_test_cct5_Farmer337); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarmer();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarmer(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[16]);
            	}

            // Cct5.g:710:2: (a4_0= parse_org_emftext_test_cct5_Diet )
            // Cct5.g:711:3: a4_0= parse_org_emftext_test_cct5_Diet
            {
            pushFollow(FOLLOW_parse_org_emftext_test_cct5_Diet_in_parse_org_emftext_test_cct5_Farmer355);
            a4_0=parse_org_emftext_test_cct5_Diet();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.test.cct5.resource.cct5.mopp.Cct5TerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarmer();
            				startIncompleteElement(element);
            			}
            			if (a4_0 != null) {
            				if (a4_0 != null) {
            					Object value = a4_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.FARMER__DIET), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_4, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[17]);
            	}

            a5=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_test_cct5_Farmer373); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createFarmer();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_1_0_0_5, null, true);
            		copyLocalizationInfos((CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[20]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_test_cct5_Farmer_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_test_cct5_Farmer"



    // $ANTLR start "parse_org_emftext_test_cct5_Animal"
    // Cct5.g:754:1: parse_org_emftext_test_cct5_Animal returns [org.emftext.test.cct5.Animal element = null] : a0= 'BEGIN_ANIMAL' (a1= TEXT ) a2= 'FeedingInstruction' a3= ':' (a4_0= parse_org_emftext_test_cct5_Diet ) a5= 'END_ANIMAL' ;
    public final org.emftext.test.cct5.Animal parse_org_emftext_test_cct5_Animal() throws RecognitionException {
        org.emftext.test.cct5.Animal element =  null;

        int parse_org_emftext_test_cct5_Animal_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        org.emftext.test.cct5.Diet a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Cct5.g:757:2: (a0= 'BEGIN_ANIMAL' (a1= TEXT ) a2= 'FeedingInstruction' a3= ':' (a4_0= parse_org_emftext_test_cct5_Diet ) a5= 'END_ANIMAL' )
            // Cct5.g:758:2: a0= 'BEGIN_ANIMAL' (a1= TEXT ) a2= 'FeedingInstruction' a3= ':' (a4_0= parse_org_emftext_test_cct5_Diet ) a5= 'END_ANIMAL'
            {
            a0=(Token)match(input,9,FOLLOW_9_in_parse_org_emftext_test_cct5_Animal402); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createAnimal();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_0, null, true);
            		copyLocalizationInfos((CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[21]);
            	}

            // Cct5.g:772:2: (a1= TEXT )
            // Cct5.g:773:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_test_cct5_Animal420); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.test.cct5.resource.cct5.mopp.Cct5TerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createAnimal();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.emftext.test.cct5.resource.cct5.ICct5TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.test.cct5.resource.cct5.ICct5TokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_1, resolved, true);
            				copyLocalizationInfos((CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[22]);
            	}

            a2=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_test_cct5_Animal441); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createAnimal();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_2, null, true);
            		copyLocalizationInfos((CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[23]);
            	}

            a3=(Token)match(input,8,FOLLOW_8_in_parse_org_emftext_test_cct5_Animal455); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createAnimal();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_3, null, true);
            		copyLocalizationInfos((CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getAnimal(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[24]);
            	}

            // Cct5.g:836:2: (a4_0= parse_org_emftext_test_cct5_Diet )
            // Cct5.g:837:3: a4_0= parse_org_emftext_test_cct5_Diet
            {
            pushFollow(FOLLOW_parse_org_emftext_test_cct5_Diet_in_parse_org_emftext_test_cct5_Animal473);
            a4_0=parse_org_emftext_test_cct5_Diet();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.test.cct5.resource.cct5.mopp.Cct5TerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createAnimal();
            				startIncompleteElement(element);
            			}
            			if (a4_0 != null) {
            				if (a4_0 != null) {
            					Object value = a4_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.ANIMAL__FEEDING_INSTRUCTION), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_4, a4_0, true);
            				copyLocalizationInfos(a4_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[25]);
            	}

            a5=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_test_cct5_Animal491); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createAnimal();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_2_0_0_5, null, true);
            		copyLocalizationInfos((CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.emftext.test.cct5.Cct5Package.eINSTANCE.getFarm(), org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[26]);
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[27]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_test_cct5_Animal_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_test_cct5_Animal"



    // $ANTLR start "parse_org_emftext_test_cct5_Diet"
    // Cct5.g:879:1: parse_org_emftext_test_cct5_Diet returns [org.emftext.test.cct5.Diet element = null] : (a0= TEXT ) ( (a1= 'favored' (a2= QUOTED_34_34 ) ) )? ;
    public final org.emftext.test.cct5.Diet parse_org_emftext_test_cct5_Diet() throws RecognitionException {
        org.emftext.test.cct5.Diet element =  null;

        int parse_org_emftext_test_cct5_Diet_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Cct5.g:882:2: ( (a0= TEXT ) ( (a1= 'favored' (a2= QUOTED_34_34 ) ) )? )
            // Cct5.g:883:2: (a0= TEXT ) ( (a1= 'favored' (a2= QUOTED_34_34 ) ) )?
            {
            // Cct5.g:883:2: (a0= TEXT )
            // Cct5.g:884:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_test_cct5_Diet524); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.test.cct5.resource.cct5.mopp.Cct5TerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createDiet();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.test.cct5.resource.cct5.ICct5TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.test.cct5.resource.cct5.ICct5TokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__TYPE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
            				}
            				org.emftext.test.cct5.DietType resolved = (org.emftext.test.cct5.DietType) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__TYPE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_3_0_0_0, resolved, true);
            				copyLocalizationInfos((CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[30]);
            	}

            // Cct5.g:921:2: ( (a1= 'favored' (a2= QUOTED_34_34 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Cct5.g:922:3: (a1= 'favored' (a2= QUOTED_34_34 ) )
                    {
                    // Cct5.g:922:3: (a1= 'favored' (a2= QUOTED_34_34 ) )
                    // Cct5.g:923:4: a1= 'favored' (a2= QUOTED_34_34 )
                    {
                    a1=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_test_cct5_Diet554); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createDiet();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_3_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[31]);
                    			}

                    // Cct5.g:937:4: (a2= QUOTED_34_34 )
                    // Cct5.g:938:5: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_test_cct5_Diet580); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.emftext.test.cct5.resource.cct5.mopp.Cct5TerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.emftext.test.cct5.Cct5Factory.eINSTANCE.createDiet();
                    						startIncompleteElement(element);
                    					}
                    					if (a2 != null) {
                    						org.emftext.test.cct5.resource.cct5.ICct5TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                    						tokenResolver.setOptions(getOptions());
                    						org.emftext.test.cct5.resource.cct5.ICct5TokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__FAVORITE_DISH), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
                    						}
                    						java.lang.String resolved = (java.lang.String) resolvedObject;
                    						if (resolved != null) {
                    							Object value = resolved;
                    							element.eSet(element.eClass().getEStructuralFeature(org.emftext.test.cct5.Cct5Package.DIET__FAVORITE_DISH), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.emftext.test.cct5.resource.cct5.grammar.Cct5GrammarInformationProvider.CCT5_3_0_0_1_0_0_1, resolved, true);
                    						copyLocalizationInfos((CommonToken) a2, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[32]);
                    				addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[33]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(null, org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectationConstants.EXPECTATIONS[35]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_test_cct5_Diet_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_test_cct5_Diet"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_emftext_test_cct5_Farm_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_test_cct5_Farm115 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_test_cct5_Farm129 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_parse_org_emftext_test_cct5_Farmer_in_parse_org_emftext_test_cct5_Farm158 = new BitSet(new long[]{0x0000000000040600L});
    public static final BitSet FOLLOW_parse_org_emftext_test_cct5_Animal_in_parse_org_emftext_test_cct5_Farm214 = new BitSet(new long[]{0x0000000000040200L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_test_cct5_Farm255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_parse_org_emftext_test_cct5_Farmer284 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_test_cct5_Farmer302 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_org_emftext_test_cct5_Farmer323 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_org_emftext_test_cct5_Farmer337 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_test_cct5_Diet_in_parse_org_emftext_test_cct5_Farmer355 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_test_cct5_Farmer373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_parse_org_emftext_test_cct5_Animal402 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_test_cct5_Animal420 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_test_cct5_Animal441 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_org_emftext_test_cct5_Animal455 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_org_emftext_test_cct5_Diet_in_parse_org_emftext_test_cct5_Animal473 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_test_cct5_Animal491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_test_cct5_Diet524 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_test_cct5_Diet554 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_test_cct5_Diet580 = new BitSet(new long[]{0x0000000000000002L});

}