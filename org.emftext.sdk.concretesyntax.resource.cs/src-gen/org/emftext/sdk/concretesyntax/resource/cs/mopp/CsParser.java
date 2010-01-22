// $ANTLR ${project.version} ${buildNumber} /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g 2010-01-22 13:01:26

	package org.emftext.sdk.concretesyntax.resource.cs.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
public class CsParser extends CsANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUALIFIED_NAME", "QUOTED_60_62", "QUOTED_34_34_92", "QUOTED_39_39_92", "HEXNUMBER", "NUMBER", "QUOTED_36_36", "COMMENTS", "WHITESPACE", "LINEBREAK", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'TOKENSTYLES'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'!'", "'DEFINE'", "'+'", "'COLLECT'", "'IN'", "'PARTIAL'", "'PRIORITIZE'", "'*'", "'?'", "'ABSTRACT'", "'COLOR'", "'@'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int COMMENTS=11;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int QUOTED_36_36=10;
    public static final int QUOTED_39_39_92=7;
    public static final int LINEBREAK=13;
    public static final int HEXNUMBER=8;
    public static final int QUALIFIED_NAME=4;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int NUMBER=9;
    public static final int WHITESPACE=12;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int QUOTED_34_34_92=6;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int QUOTED_60_62=5;

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
    public String getGrammarFileName() { return "/Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g"; }


    	private org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolverFactory tokenResolverFactory = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolverFactory();
    	@SuppressWarnings("unused")
    	
    	private int lastPosition;
    	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult tokenResolveResult = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult();
    	private boolean rememberExpectedElements = false;
    	private java.lang.Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal>();
    	private int mismatchedTokenRecoveryTries = 0;
    	private java.util.Map<?, ?> options;
    	//helper lists to allow a lexer to pass errors to its parser
    	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
    	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource>> postParseCommands;
    	private boolean terminateParsing;
    	private int tokenIndexOfLastCompleteElement;
    	private int expectedElementsIndexOfLastCompleteElement;
    	
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
    				org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for
    					// code completion
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
    					// the locationMap can be null if the parser is used for
    					// code completion
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
    	
    	// This default constructor is only used to call createInstance() on it
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
    			if (type.getInstanceClass() == org.emftext.sdk.concretesyntax.NormalToken.class) {
    				return parse_org_emftext_sdk_concretesyntax_NormalToken();
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
    		} catch (org.antlr.runtime3_2_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				//? can be caused if a null is set on EMF models where not allowed;
    				//? this will just happen if other errors occurred before
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
    				System.out.println("FOLLOW ELEMENT " + expectedElementI);
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 156;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
    			System.out.println("REMAINING TOKEN: " + nextToken);
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected terminals
    				// can be set
    				for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are kept
    				for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal nextFollow : currentFollowSet) {
    					System.out.println("CHECKING : " + nextFollow);
    					if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						System.out.println("MATCH! " + nextFollow);
    						java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement newFollower : newFollowers) {
    							org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal newFollowTerminal = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(newFollower, followSetID);
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
    		// after the last token in the stream we must set the position for the elements that were
    		// added during the last iteration of the loop
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
    			message = "mismatched tree node: "+"xxx" +"; expecting " + tokenName;
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
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText+"}?";
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
    	
    	// Translates errors thrown by the lexer into human readable messages.
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
    	
    	protected void completedElement(Object element) {
    		if (element instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_0 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("@");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_1 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("ABSTRACT");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_2 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("SYNTAXDEF");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_3 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_4 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("FOR");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_5 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), "QUOTED_60_62");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_6 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), "QUOTED_60_62");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_7 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("START");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_8 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("IMPORTS");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_9 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("OPTIONS");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_10 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("TOKENS");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_11 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("TOKENSTYLES");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_12 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("RULES");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_13 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_14 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_15 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_16 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_17 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_18 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_19 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_20 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_21 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_22 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(";");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_23 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_24 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("DEFINE");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_25 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("DEFINE");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_26 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("PRIORITIZE");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_27 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_28 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(";");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_29 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_30 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), "QUOTED_34_34_92");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_31 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_32 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("{");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_33 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_34 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("}");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_35 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(":");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_36 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), "QUOTED_60_62");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_37 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), "QUOTED_60_62");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_38 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("WITH");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_39 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("SYNTAX");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_40 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_41 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), "QUOTED_60_62");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_42 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("=");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_43 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), "QUOTED_34_34_92");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_44 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("::=");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_45 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), "QUOTED_34_34_92");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_46 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_47 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_48 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_49 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_50 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("(");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_51 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), "HEXNUMBER");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_52 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("!");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_53 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(";");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_54 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("|");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_55 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(")");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_56 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("[");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_57 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_58 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("]");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_59 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("+");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_60 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("*");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_61 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("?");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_62 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("[");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_63 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("]");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_64 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("[");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_65 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), "QUOTED_39_39_92");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_66 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_67 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), "QUOTED_39_39_92");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_68 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_69 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("]");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_70 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), "QUOTED_39_39_92");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_71 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(":");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_72 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_73 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_74 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_75 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), "NUMBER");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_76 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_77 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), "QUOTED_36_36");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_78 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_79 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("+");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_80 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("COLLECT");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_81 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("IN");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_82 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_83 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("PARTIAL");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_84 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_85 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("+");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_86 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_87 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("COLOR");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_88 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), "HEXNUMBER");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_89 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_90 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(";");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_91 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_92 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_93 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("(");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_94 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_95 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(",");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_96 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(")");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_97 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString("=");
    	private final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINAL_98 = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), "QUOTED_34_34_92");
    	
    	public static void wire0() {
    		TERMINAL_2.addFollower(TERMINAL_3);
    		TERMINAL_3.addFollower(TERMINAL_4);
    		TERMINAL_4.addFollower(TERMINAL_5);
    		TERMINAL_5.addFollower(TERMINAL_6);
    		TERMINAL_5.addFollower(TERMINAL_7);
    		TERMINAL_5.addFollower(TERMINAL_8);
    		TERMINAL_5.addFollower(TERMINAL_9);
    		TERMINAL_5.addFollower(TERMINAL_10);
    		TERMINAL_5.addFollower(TERMINAL_11);
    		TERMINAL_5.addFollower(TERMINAL_12);
    		TERMINAL_6.addFollower(TERMINAL_7);
    		TERMINAL_6.addFollower(TERMINAL_8);
    		TERMINAL_6.addFollower(TERMINAL_9);
    		TERMINAL_6.addFollower(TERMINAL_10);
    		TERMINAL_6.addFollower(TERMINAL_11);
    		TERMINAL_6.addFollower(TERMINAL_12);
    		TERMINAL_7.addFollower(TERMINAL_13);
    		TERMINAL_13.addFollower(TERMINAL_14);
    		TERMINAL_13.addFollower(TERMINAL_8);
    		TERMINAL_13.addFollower(TERMINAL_9);
    		TERMINAL_13.addFollower(TERMINAL_10);
    		TERMINAL_13.addFollower(TERMINAL_11);
    		TERMINAL_13.addFollower(TERMINAL_12);
    		TERMINAL_14.addFollower(TERMINAL_15);
    		TERMINAL_15.addFollower(TERMINAL_14);
    		TERMINAL_15.addFollower(TERMINAL_8);
    		TERMINAL_15.addFollower(TERMINAL_9);
    		TERMINAL_15.addFollower(TERMINAL_10);
    		TERMINAL_15.addFollower(TERMINAL_11);
    		TERMINAL_15.addFollower(TERMINAL_12);
    		TERMINAL_8.addFollower(TERMINAL_16);
    		TERMINAL_16.addFollower(TERMINAL_17);
    		TERMINAL_16.addFollower(TERMINAL_18);
    		TERMINAL_18.addFollower(TERMINAL_9);
    		TERMINAL_18.addFollower(TERMINAL_10);
    		TERMINAL_18.addFollower(TERMINAL_11);
    		TERMINAL_18.addFollower(TERMINAL_12);
    		TERMINAL_9.addFollower(TERMINAL_19);
    		TERMINAL_19.addFollower(TERMINAL_20);
    		TERMINAL_19.addFollower(TERMINAL_21);
    		TERMINAL_22.addFollower(TERMINAL_20);
    		TERMINAL_22.addFollower(TERMINAL_21);
    		TERMINAL_21.addFollower(TERMINAL_10);
    		TERMINAL_21.addFollower(TERMINAL_11);
    		TERMINAL_21.addFollower(TERMINAL_12);
    		TERMINAL_10.addFollower(TERMINAL_23);
    		TERMINAL_23.addFollower(TERMINAL_0);
    		TERMINAL_23.addFollower(TERMINAL_24);
    		TERMINAL_23.addFollower(TERMINAL_25);
    		TERMINAL_23.addFollower(TERMINAL_26);
    		TERMINAL_23.addFollower(TERMINAL_27);
    		TERMINAL_28.addFollower(TERMINAL_0);
    		TERMINAL_28.addFollower(TERMINAL_24);
    		TERMINAL_28.addFollower(TERMINAL_25);
    		TERMINAL_28.addFollower(TERMINAL_26);
    		TERMINAL_28.addFollower(TERMINAL_27);
    		TERMINAL_27.addFollower(TERMINAL_11);
    		TERMINAL_27.addFollower(TERMINAL_12);
    		TERMINAL_11.addFollower(TERMINAL_29);
    		TERMINAL_29.addFollower(TERMINAL_30);
    		TERMINAL_29.addFollower(TERMINAL_31);
    		TERMINAL_31.addFollower(TERMINAL_12);
    		TERMINAL_12.addFollower(TERMINAL_32);
    		TERMINAL_32.addFollower(TERMINAL_0);
    		TERMINAL_32.addFollower(TERMINAL_33);
    		TERMINAL_32.addFollower(TERMINAL_34);
    		TERMINAL_17.addFollower(TERMINAL_35);
    		TERMINAL_35.addFollower(TERMINAL_36);
    		TERMINAL_36.addFollower(TERMINAL_37);
    		TERMINAL_36.addFollower(TERMINAL_38);
    		TERMINAL_36.addFollower(TERMINAL_17);
    		TERMINAL_36.addFollower(TERMINAL_18);
    		TERMINAL_37.addFollower(TERMINAL_38);
    		TERMINAL_37.addFollower(TERMINAL_17);
    		TERMINAL_37.addFollower(TERMINAL_18);
    		TERMINAL_38.addFollower(TERMINAL_39);
    		TERMINAL_39.addFollower(TERMINAL_40);
    		TERMINAL_40.addFollower(TERMINAL_41);
    		TERMINAL_40.addFollower(TERMINAL_17);
    		TERMINAL_40.addFollower(TERMINAL_18);
    		TERMINAL_41.addFollower(TERMINAL_17);
    		TERMINAL_41.addFollower(TERMINAL_18);
    		TERMINAL_20.addFollower(TERMINAL_42);
    		TERMINAL_42.addFollower(TERMINAL_43);
    		TERMINAL_43.addFollower(TERMINAL_22);
    		TERMINAL_33.addFollower(TERMINAL_44);
    		TERMINAL_44.addFollower(TERMINAL_45);
    		TERMINAL_44.addFollower(TERMINAL_46);
    		TERMINAL_44.addFollower(TERMINAL_47);
    		TERMINAL_44.addFollower(TERMINAL_48);
    		TERMINAL_44.addFollower(TERMINAL_49);
    		TERMINAL_44.addFollower(TERMINAL_50);
    		TERMINAL_44.addFollower(TERMINAL_51);
    		TERMINAL_44.addFollower(TERMINAL_52);
    		TERMINAL_53.addFollower(TERMINAL_0);
    		TERMINAL_53.addFollower(TERMINAL_33);
    		TERMINAL_53.addFollower(TERMINAL_34);
    		TERMINAL_54.addFollower(TERMINAL_45);
    		TERMINAL_54.addFollower(TERMINAL_46);
    		TERMINAL_54.addFollower(TERMINAL_47);
    		TERMINAL_54.addFollower(TERMINAL_48);
    		TERMINAL_54.addFollower(TERMINAL_49);
    		TERMINAL_54.addFollower(TERMINAL_50);
    		TERMINAL_54.addFollower(TERMINAL_51);
    		TERMINAL_54.addFollower(TERMINAL_52);
    		TERMINAL_45.addFollower(TERMINAL_45);
    		TERMINAL_45.addFollower(TERMINAL_46);
    		TERMINAL_45.addFollower(TERMINAL_47);
    		TERMINAL_45.addFollower(TERMINAL_48);
    		TERMINAL_45.addFollower(TERMINAL_49);
    		TERMINAL_45.addFollower(TERMINAL_50);
    		TERMINAL_45.addFollower(TERMINAL_51);
    		TERMINAL_45.addFollower(TERMINAL_52);
    		TERMINAL_45.addFollower(TERMINAL_54);
    		TERMINAL_45.addFollower(TERMINAL_53);
    		TERMINAL_45.addFollower(TERMINAL_55);
    		TERMINAL_46.addFollower(TERMINAL_56);
    		TERMINAL_56.addFollower(TERMINAL_57);
    		TERMINAL_57.addFollower(TERMINAL_58);
    		TERMINAL_58.addFollower(TERMINAL_59);
    		TERMINAL_58.addFollower(TERMINAL_60);
    		TERMINAL_58.addFollower(TERMINAL_61);
    		TERMINAL_58.addFollower(TERMINAL_45);
    		TERMINAL_58.addFollower(TERMINAL_46);
    		TERMINAL_58.addFollower(TERMINAL_47);
    		TERMINAL_58.addFollower(TERMINAL_48);
    		TERMINAL_58.addFollower(TERMINAL_49);
    		TERMINAL_58.addFollower(TERMINAL_50);
    		TERMINAL_58.addFollower(TERMINAL_51);
    		TERMINAL_58.addFollower(TERMINAL_52);
    		TERMINAL_58.addFollower(TERMINAL_54);
    		TERMINAL_58.addFollower(TERMINAL_53);
    		TERMINAL_58.addFollower(TERMINAL_55);
    		TERMINAL_47.addFollower(TERMINAL_62);
    		TERMINAL_62.addFollower(TERMINAL_63);
    		TERMINAL_63.addFollower(TERMINAL_59);
    		TERMINAL_63.addFollower(TERMINAL_60);
    		TERMINAL_63.addFollower(TERMINAL_61);
    		TERMINAL_63.addFollower(TERMINAL_45);
    		TERMINAL_63.addFollower(TERMINAL_46);
    		TERMINAL_63.addFollower(TERMINAL_47);
    		TERMINAL_63.addFollower(TERMINAL_48);
    		TERMINAL_63.addFollower(TERMINAL_49);
    		TERMINAL_63.addFollower(TERMINAL_50);
    		TERMINAL_63.addFollower(TERMINAL_51);
    		TERMINAL_63.addFollower(TERMINAL_52);
    		TERMINAL_63.addFollower(TERMINAL_54);
    		TERMINAL_63.addFollower(TERMINAL_53);
    		TERMINAL_63.addFollower(TERMINAL_55);
    		TERMINAL_48.addFollower(TERMINAL_64);
    		TERMINAL_64.addFollower(TERMINAL_65);
    		TERMINAL_65.addFollower(TERMINAL_66);
    		TERMINAL_66.addFollower(TERMINAL_67);
    		TERMINAL_67.addFollower(TERMINAL_68);
    		TERMINAL_67.addFollower(TERMINAL_69);
    		TERMINAL_68.addFollower(TERMINAL_70);
    		TERMINAL_70.addFollower(TERMINAL_69);
    		TERMINAL_69.addFollower(TERMINAL_59);
    		TERMINAL_69.addFollower(TERMINAL_60);
    		TERMINAL_69.addFollower(TERMINAL_61);
    		TERMINAL_69.addFollower(TERMINAL_45);
    		TERMINAL_69.addFollower(TERMINAL_46);
    		TERMINAL_69.addFollower(TERMINAL_47);
    		TERMINAL_69.addFollower(TERMINAL_48);
    		TERMINAL_69.addFollower(TERMINAL_49);
    		TERMINAL_69.addFollower(TERMINAL_50);
    		TERMINAL_69.addFollower(TERMINAL_51);
    		TERMINAL_69.addFollower(TERMINAL_52);
    		TERMINAL_69.addFollower(TERMINAL_54);
    		TERMINAL_69.addFollower(TERMINAL_53);
    		TERMINAL_69.addFollower(TERMINAL_55);
    		TERMINAL_49.addFollower(TERMINAL_71);
    		TERMINAL_49.addFollower(TERMINAL_59);
    		TERMINAL_49.addFollower(TERMINAL_60);
    		TERMINAL_49.addFollower(TERMINAL_61);
    		TERMINAL_49.addFollower(TERMINAL_45);
    		TERMINAL_49.addFollower(TERMINAL_46);
    		TERMINAL_49.addFollower(TERMINAL_47);
    		TERMINAL_49.addFollower(TERMINAL_48);
    		TERMINAL_49.addFollower(TERMINAL_49);
    		TERMINAL_49.addFollower(TERMINAL_50);
    		TERMINAL_49.addFollower(TERMINAL_51);
    		TERMINAL_49.addFollower(TERMINAL_52);
    		TERMINAL_49.addFollower(TERMINAL_54);
    		TERMINAL_49.addFollower(TERMINAL_53);
    		TERMINAL_49.addFollower(TERMINAL_55);
    		TERMINAL_71.addFollower(TERMINAL_72);
    		TERMINAL_72.addFollower(TERMINAL_73);
    		TERMINAL_72.addFollower(TERMINAL_59);
    		TERMINAL_72.addFollower(TERMINAL_60);
    		TERMINAL_72.addFollower(TERMINAL_61);
    		TERMINAL_72.addFollower(TERMINAL_45);
    		TERMINAL_72.addFollower(TERMINAL_46);
    		TERMINAL_72.addFollower(TERMINAL_47);
    		TERMINAL_72.addFollower(TERMINAL_48);
    		TERMINAL_72.addFollower(TERMINAL_49);
    		TERMINAL_72.addFollower(TERMINAL_50);
    		TERMINAL_72.addFollower(TERMINAL_51);
    		TERMINAL_72.addFollower(TERMINAL_52);
    		TERMINAL_72.addFollower(TERMINAL_54);
    		TERMINAL_72.addFollower(TERMINAL_53);
    		TERMINAL_72.addFollower(TERMINAL_55);
    		TERMINAL_73.addFollower(TERMINAL_74);
    		TERMINAL_74.addFollower(TERMINAL_73);
    		TERMINAL_74.addFollower(TERMINAL_59);
    		TERMINAL_74.addFollower(TERMINAL_60);
    		TERMINAL_74.addFollower(TERMINAL_61);
    		TERMINAL_74.addFollower(TERMINAL_45);
    		TERMINAL_74.addFollower(TERMINAL_46);
    		TERMINAL_74.addFollower(TERMINAL_47);
    		TERMINAL_74.addFollower(TERMINAL_48);
    		TERMINAL_74.addFollower(TERMINAL_49);
    		TERMINAL_74.addFollower(TERMINAL_50);
    		TERMINAL_74.addFollower(TERMINAL_51);
    		TERMINAL_74.addFollower(TERMINAL_52);
    		TERMINAL_74.addFollower(TERMINAL_54);
    		TERMINAL_74.addFollower(TERMINAL_53);
    		TERMINAL_74.addFollower(TERMINAL_55);
    		TERMINAL_50.addFollower(TERMINAL_45);
    		TERMINAL_50.addFollower(TERMINAL_46);
    		TERMINAL_50.addFollower(TERMINAL_47);
    		TERMINAL_50.addFollower(TERMINAL_48);
    		TERMINAL_50.addFollower(TERMINAL_49);
    		TERMINAL_50.addFollower(TERMINAL_50);
    		TERMINAL_50.addFollower(TERMINAL_51);
    		TERMINAL_50.addFollower(TERMINAL_52);
    		TERMINAL_55.addFollower(TERMINAL_59);
    		TERMINAL_55.addFollower(TERMINAL_60);
    		TERMINAL_55.addFollower(TERMINAL_61);
    		TERMINAL_55.addFollower(TERMINAL_45);
    		TERMINAL_55.addFollower(TERMINAL_46);
    		TERMINAL_55.addFollower(TERMINAL_47);
    		TERMINAL_55.addFollower(TERMINAL_48);
    		TERMINAL_55.addFollower(TERMINAL_49);
    		TERMINAL_55.addFollower(TERMINAL_50);
    		TERMINAL_55.addFollower(TERMINAL_51);
    		TERMINAL_55.addFollower(TERMINAL_52);
    		TERMINAL_55.addFollower(TERMINAL_54);
    		TERMINAL_55.addFollower(TERMINAL_53);
    		TERMINAL_55.addFollower(TERMINAL_55);
    		TERMINAL_51.addFollower(TERMINAL_45);
    		TERMINAL_51.addFollower(TERMINAL_46);
    		TERMINAL_51.addFollower(TERMINAL_47);
    		TERMINAL_51.addFollower(TERMINAL_48);
    		TERMINAL_51.addFollower(TERMINAL_49);
    		TERMINAL_51.addFollower(TERMINAL_50);
    		TERMINAL_51.addFollower(TERMINAL_51);
    		TERMINAL_51.addFollower(TERMINAL_52);
    		TERMINAL_51.addFollower(TERMINAL_54);
    		TERMINAL_51.addFollower(TERMINAL_53);
    		TERMINAL_51.addFollower(TERMINAL_55);
    		TERMINAL_52.addFollower(TERMINAL_75);
    		TERMINAL_75.addFollower(TERMINAL_45);
    		TERMINAL_75.addFollower(TERMINAL_46);
    		TERMINAL_75.addFollower(TERMINAL_47);
    		TERMINAL_75.addFollower(TERMINAL_48);
    		TERMINAL_75.addFollower(TERMINAL_49);
    		TERMINAL_75.addFollower(TERMINAL_50);
    		TERMINAL_75.addFollower(TERMINAL_51);
    		TERMINAL_75.addFollower(TERMINAL_52);
    		TERMINAL_75.addFollower(TERMINAL_54);
    		TERMINAL_75.addFollower(TERMINAL_53);
    		TERMINAL_75.addFollower(TERMINAL_55);
    		TERMINAL_24.addFollower(TERMINAL_76);
    		TERMINAL_76.addFollower(TERMINAL_77);
    		TERMINAL_76.addFollower(TERMINAL_78);
    		TERMINAL_79.addFollower(TERMINAL_77);
    		TERMINAL_79.addFollower(TERMINAL_78);
    		TERMINAL_80.addFollower(TERMINAL_81);
    		TERMINAL_81.addFollower(TERMINAL_82);
    		TERMINAL_82.addFollower(TERMINAL_28);
    		TERMINAL_25.addFollower(TERMINAL_83);
    		TERMINAL_83.addFollower(TERMINAL_84);
    		TERMINAL_84.addFollower(TERMINAL_77);
    		TERMINAL_84.addFollower(TERMINAL_78);
    		TERMINAL_85.addFollower(TERMINAL_77);
    		TERMINAL_85.addFollower(TERMINAL_78);
    		TERMINAL_26.addFollower(TERMINAL_86);
    		TERMINAL_86.addFollower(TERMINAL_28);
    		TERMINAL_77.addFollower(TERMINAL_79);
    		TERMINAL_77.addFollower(TERMINAL_80);
    		TERMINAL_77.addFollower(TERMINAL_28);
    		TERMINAL_77.addFollower(TERMINAL_85);
    		TERMINAL_78.addFollower(TERMINAL_79);
    		TERMINAL_78.addFollower(TERMINAL_80);
    		TERMINAL_78.addFollower(TERMINAL_28);
    		TERMINAL_78.addFollower(TERMINAL_85);
    		TERMINAL_59.addFollower(TERMINAL_45);
    		TERMINAL_59.addFollower(TERMINAL_46);
    		TERMINAL_59.addFollower(TERMINAL_47);
    		TERMINAL_59.addFollower(TERMINAL_48);
    		TERMINAL_59.addFollower(TERMINAL_49);
    		TERMINAL_59.addFollower(TERMINAL_50);
    		TERMINAL_59.addFollower(TERMINAL_51);
    		TERMINAL_59.addFollower(TERMINAL_52);
    		TERMINAL_59.addFollower(TERMINAL_54);
    		TERMINAL_59.addFollower(TERMINAL_53);
    		TERMINAL_59.addFollower(TERMINAL_55);
    		TERMINAL_60.addFollower(TERMINAL_45);
    		TERMINAL_60.addFollower(TERMINAL_46);
    		TERMINAL_60.addFollower(TERMINAL_47);
    		TERMINAL_60.addFollower(TERMINAL_48);
    		TERMINAL_60.addFollower(TERMINAL_49);
    		TERMINAL_60.addFollower(TERMINAL_50);
    		TERMINAL_60.addFollower(TERMINAL_51);
    		TERMINAL_60.addFollower(TERMINAL_52);
    		TERMINAL_60.addFollower(TERMINAL_54);
    		TERMINAL_60.addFollower(TERMINAL_53);
    		TERMINAL_60.addFollower(TERMINAL_55);
    		TERMINAL_61.addFollower(TERMINAL_45);
    		TERMINAL_61.addFollower(TERMINAL_46);
    		TERMINAL_61.addFollower(TERMINAL_47);
    		TERMINAL_61.addFollower(TERMINAL_48);
    		TERMINAL_61.addFollower(TERMINAL_49);
    		TERMINAL_61.addFollower(TERMINAL_50);
    		TERMINAL_61.addFollower(TERMINAL_51);
    		TERMINAL_61.addFollower(TERMINAL_52);
    		TERMINAL_61.addFollower(TERMINAL_54);
    		TERMINAL_61.addFollower(TERMINAL_53);
    		TERMINAL_61.addFollower(TERMINAL_55);
    		TERMINAL_1.addFollower(TERMINAL_2);
    		TERMINAL_30.addFollower(TERMINAL_87);
    		TERMINAL_87.addFollower(TERMINAL_88);
    		TERMINAL_88.addFollower(TERMINAL_89);
    		TERMINAL_88.addFollower(TERMINAL_90);
    		TERMINAL_89.addFollower(TERMINAL_91);
    		TERMINAL_91.addFollower(TERMINAL_89);
    		TERMINAL_91.addFollower(TERMINAL_90);
    		TERMINAL_90.addFollower(TERMINAL_30);
    		TERMINAL_90.addFollower(TERMINAL_31);
    		TERMINAL_0.addFollower(TERMINAL_92);
    		TERMINAL_92.addFollower(TERMINAL_93);
    		TERMINAL_92.addFollower(TERMINAL_0);
    		TERMINAL_92.addFollower(TERMINAL_1);
    		TERMINAL_92.addFollower(TERMINAL_2);
    		TERMINAL_92.addFollower(TERMINAL_33);
    		TERMINAL_92.addFollower(TERMINAL_24);
    		TERMINAL_93.addFollower(TERMINAL_94);
    		TERMINAL_95.addFollower(TERMINAL_94);
    		TERMINAL_96.addFollower(TERMINAL_0);
    		TERMINAL_96.addFollower(TERMINAL_1);
    		TERMINAL_96.addFollower(TERMINAL_2);
    		TERMINAL_96.addFollower(TERMINAL_33);
    		TERMINAL_96.addFollower(TERMINAL_24);
    		TERMINAL_94.addFollower(TERMINAL_97);
    		TERMINAL_94.addFollower(TERMINAL_95);
    		TERMINAL_94.addFollower(TERMINAL_96);
    		TERMINAL_97.addFollower(TERMINAL_98);
    		TERMINAL_98.addFollower(TERMINAL_95);
    		TERMINAL_98.addFollower(TERMINAL_96);
    	}
    	// wire the terminals
    	static {
    		wire0();
    	}



    // $ANTLR start "start"
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:982:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:983:1: ( (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:984:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 0));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 0));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 0));
              		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:991:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:992:3: c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:997:1: parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* ) a32= '}' ;
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1000:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* ) a32= '}' )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1001:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* ) a32= '}'
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1001:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==47) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1002:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1002:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1003:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1003:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1004:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
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
            	      							completedElement(a0_0);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos(a0_0, element); 					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 1));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 1));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 1));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 2));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 2));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 2));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1036:2: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==45) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1037:3: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1037:3: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1038:4: a1_0= parse_org_emftext_sdk_concretesyntax_Abstract
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax177);
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
                      						completedElement(a1_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a1_0, element); 				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 3));
              	
            }
            a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax203); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_3, 4));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1072:2: (a3= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1073:3: a3= QUALIFIED_NAME
            {
            a3=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax221); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_4, 5));
              	
            }
            a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax242); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_5, 6));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1117:2: (a5= QUOTED_60_62 )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1118:3: a5= QUOTED_60_62
            {
            a5=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax260); if (state.failed) return element;
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
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a5, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_6, 7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_7, 7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 7));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 7));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1160:2: ( ( (a6= QUOTED_60_62 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QUOTED_60_62) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1161:3: ( (a6= QUOTED_60_62 ) )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1161:3: ( (a6= QUOTED_60_62 ) )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1162:4: (a6= QUOTED_60_62 )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1162:4: (a6= QUOTED_60_62 )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1163:5: a6= QUOTED_60_62
                    {
                    a6=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax296); if (state.failed) return element;
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
                      							completedElement(resolved);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_7, 8));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 8));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 8));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 8));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 8));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 8));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_7, 9));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 9));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 9));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 9));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 9));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 9));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1212:2: ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1213:3: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1213:3: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1214:4: a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    {
                    a7=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax351); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_13, 10));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1226:4: ( (a8= QUALIFIED_NAME ) )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1227:5: (a8= QUALIFIED_NAME )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1227:5: (a8= QUALIFIED_NAME )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1228:6: a8= QUALIFIED_NAME
                    {
                    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax384); if (state.failed) return element;
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
                      								completedElement(proxy);
                      							}
                      							collectHiddenTokens(element);
                      							copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
                      							copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, proxy);
                      						}
                      					
                    }

                    }

                    if ( state.backtracking==0 ) {

                      					// expected elements (follow set)
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 11));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 11));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 11));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 11));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 11));
                      					addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 11));
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 12));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 12));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 12));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 12));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 12));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 12));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1280:4: ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1281:5: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1281:5: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1282:6: a9= ',' ( (a10= QUALIFIED_NAME ) )
                    	    {
                    	    a9=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax449); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_15, 13));
                    	      					
                    	    }
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1294:6: ( (a10= QUALIFIED_NAME ) )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1295:7: (a10= QUALIFIED_NAME )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1295:7: (a10= QUALIFIED_NAME )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1296:8: a10= QUALIFIED_NAME
                    	    {
                    	    a10=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax492); if (state.failed) return element;
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
                    	      										completedElement(proxy);
                    	      									}
                    	      									collectHiddenTokens(element);
                    	      									copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, element);
                    	      									copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, proxy);
                    	      								}
                    	      							
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      							// expected elements (follow set)
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 14));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 14));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 14));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 14));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 14));
                    	      							addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 14));
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 15));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 15));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 15));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 15));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 15));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 15));
                    	      					
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
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_14, 16));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 16));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 16));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 16));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 16));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 16));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_8, 17));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 17));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 17));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 17));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 17));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1371:2: ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1372:3: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1372:3: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1373:4: a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}'
                    {
                    a11=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax607); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_16, 18));
                      			
                    }
                    a12=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax627); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 19));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 19));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1398:4: ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==QUALIFIED_NAME) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1399:5: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1399:5: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1400:6: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1400:6: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1401:7: a13_0= parse_org_emftext_sdk_concretesyntax_Import
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax668);
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
                    	      									completedElement(a13_0);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								copyLocalizationInfos(a13_0, element); 							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 20));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 20));
                    	      					
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
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 21));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 21));
                      			
                    }
                    a14=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax729); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 22));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 22));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 22));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 22));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_9, 23));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 23));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 23));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 23));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1456:2: ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1457:3: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1457:3: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1458:4: a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}'
                    {
                    a15=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax771); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a15, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_19, 24));
                      			
                    }
                    a16=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax791); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_20, 25));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_21, 25));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1483:4: ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==QUALIFIED_NAME) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1484:5: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1484:5: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1485:6: (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';'
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1485:6: (a17_0= parse_org_emftext_sdk_concretesyntax_Option )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1486:7: a17_0= parse_org_emftext_sdk_concretesyntax_Option
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax832);
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
                    	      									completedElement(a17_0);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								copyLocalizationInfos(a17_0, element); 							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_22, 26));
                    	      					
                    	    }
                    	    a18=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax870); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a18, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_20, 27));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_21, 27));
                    	      					
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
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_20, 28));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_21, 28));
                      			
                    }
                    a19=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax919); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a19, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 29));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 29));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 29));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_10, 30));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 30));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 30));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1551:2: ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1552:3: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1552:3: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1553:4: a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}'
                    {
                    a20=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax961); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a20, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_23, 31));
                      			
                    }
                    a21=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax981); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a21, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 32));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 32));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_25, 32));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_26, 32));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_27, 32));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1581:4: ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==37||LA10_0==42||LA10_0==47) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1582:5: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1582:5: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1583:6: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';'
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1583:6: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1584:7: a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1022);
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
                    	      									completedElement(a22_0);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								copyLocalizationInfos(a22_0, element); 							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 33));
                    	      					
                    	    }
                    	    a23=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1060); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a23, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 34));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 34));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_25, 34));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_26, 34));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_27, 34));
                    	      					
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
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 35));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 35));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_25, 35));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_26, 35));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_27, 35));
                      			
                    }
                    a24=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1109); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a24, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 36));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 36));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_11, 37));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 37));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1653:2: ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1654:3: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1654:3: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1655:4: a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}'
                    {
                    a25=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1151); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a25, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_29, 38));
                      			
                    }
                    a26=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1171); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a26, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_30, 39));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_31, 39));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1680:4: ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==QUOTED_34_34_92) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1681:5: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1681:5: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1682:6: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1682:6: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1683:7: a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1212);
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
                    	      									completedElement(a27_0);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								copyLocalizationInfos(a27_0, element); 							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_30, 40));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_31, 40));
                    	      					
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
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_30, 41));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_31, 41));
                      			
                    }
                    a28=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1273); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a28, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 42));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_12, 43));
              	
            }
            a29=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1306); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a29, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_32, 44));
              	
            }
            a30=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1320); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a30, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 45));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 45));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_34, 45));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1758:2: ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1759:3: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )*
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1759:3: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==QUALIFIED_NAME||LA14_0==47) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1760:4: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1760:4: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1761:5: a31_0= parse_org_emftext_sdk_concretesyntax_Rule
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1349);
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
            	      							completedElement(a31_0);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos(a31_0, element); 					}
            	      				
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
              			addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 46));
              			addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 46));
              			addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_34, 46));
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_34, 47));
              	
            }
            a32=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1389); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1804:1: parse_org_emftext_sdk_concretesyntax_Import returns [org.emftext.sdk.concretesyntax.Import element = null] : (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? ;
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1807:1: ( (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1808:2: (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1808:2: (a0= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1809:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1422); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_35, 49));
              	
            }
            a1=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Import1443); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_36, 50));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1853:2: (a2= QUOTED_60_62 )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1854:3: a2= QUOTED_60_62
            {
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1461); if (state.failed) return element;
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
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_37, 51));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_38, 51));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 51));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 51));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1893:2: ( ( (a3= QUOTED_60_62 ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==QUOTED_60_62) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1894:3: ( (a3= QUOTED_60_62 ) )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1894:3: ( (a3= QUOTED_60_62 ) )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1895:4: (a3= QUOTED_60_62 )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1895:4: (a3= QUOTED_60_62 )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1896:5: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1497); if (state.failed) return element;
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
                      							completedElement(resolved);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_38, 52));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 52));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 52));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_38, 53));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 53));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 53));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1939:2: ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1940:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1940:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1941:4: a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )?
                    {
                    a4=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Import1552); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_39, 54));
                      			
                    }
                    a5=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_Import1572); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_40, 55));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1965:4: (a6= QUALIFIED_NAME )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:1966:5: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1598); if (state.failed) return element;
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
                      							completedElement(proxy);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, proxy);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_41, 56));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 56));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 56));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2004:4: ( ( (a7= QUOTED_60_62 ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==QUOTED_60_62) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2005:5: ( (a7= QUOTED_60_62 ) )
                            {
                            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2005:5: ( (a7= QUOTED_60_62 ) )
                            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2006:6: (a7= QUOTED_60_62 )
                            {
                            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2006:6: (a7= QUOTED_60_62 )
                            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2007:7: a7= QUOTED_60_62
                            {
                            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1652); if (state.failed) return element;
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
                              									completedElement(resolved);
                              								}
                              								collectHiddenTokens(element);
                              								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a7, element);
                              							}
                              						
                            }

                            }

                            if ( state.backtracking==0 ) {

                              						// expected elements (follow set)
                              						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 57));
                              						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 57));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 58));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 58));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_17, 59));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_18, 59));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2058:1: parse_org_emftext_sdk_concretesyntax_Option returns [org.emftext.sdk.concretesyntax.Option element = null] : (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34_92 ) ;
    public final org.emftext.sdk.concretesyntax.Option parse_org_emftext_sdk_concretesyntax_Option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;
        int parse_org_emftext_sdk_concretesyntax_Option_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2061:1: ( (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34_92 ) )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2062:2: (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34_92 )
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2062:2: (a0= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2063:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1752); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_42, 60));
              	
            }
            a1=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_Option1773); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_43, 61));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2107:2: (a2= QUOTED_34_34_92 )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2108:3: a2= QUOTED_34_34_92
            {
            a2=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_Option1791); if (state.failed) return element;
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
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), resolved);
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_22, 62));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2142:1: parse_org_emftext_sdk_concretesyntax_Rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' ;
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2145:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2146:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';'
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2146:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==47) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2147:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2147:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2148:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2148:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2149:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1842);
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
            	      							completedElement(a0_0);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos(a0_0, element); 					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 63));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 63));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 64));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 64));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2179:2: (a1= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2180:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1887); if (state.failed) return element;
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
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_44, 65));
              	
            }
            a2=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_Rule1908); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 66));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 66));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 66));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 66));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 66));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 66));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 66));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 66));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2235:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2236:3: a3_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1926);
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
              					completedElement(a3_0);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos(a3_0, element); 			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 67));
              	
            }
            a4=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_Rule1944); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 68));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 68));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_34, 68));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2273:1: parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence parse_org_emftext_sdk_concretesyntax_Sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;
        int parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.Definition a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2276:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2277:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2277:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
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
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2278:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2278:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2279:4: a0_0= parse_org_emftext_sdk_concretesyntax_Definition
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence1982);
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
            	      						completedElement(a0_0);
            	      					}
            	      					collectHiddenTokens(element);
            	      					copyLocalizationInfos(a0_0, element); 				}
            	      			
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
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 69));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 69));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2313:1: parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice parse_org_emftext_sdk_concretesyntax_Choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;
        int parse_org_emftext_sdk_concretesyntax_Choice_StartIndex = input.index();
        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0_0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2316:1: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2317:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2317:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2318:3: a0_0= parse_org_emftext_sdk_concretesyntax_Sequence
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2027);
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
              					completedElement(a0_0);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos(a0_0, element); 			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 70));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 70));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 70));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2341:2: ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2342:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2342:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2343:4: a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    {
            	    a1=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_Choice2054); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 71));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 71));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 71));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 71));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 71));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 71));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 71));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 71));
            	      			
            	    }
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2362:4: (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2363:5: a2_0= parse_org_emftext_sdk_concretesyntax_Sequence
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2080);
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
            	      							completedElement(a2_0);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos(a2_0, element); 					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 72));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 72));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 72));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 73));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 73));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 73));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2397:1: parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null] : (a0= QUOTED_34_34_92 ) ;
    public final org.emftext.sdk.concretesyntax.CsString parse_org_emftext_sdk_concretesyntax_CsString() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;
        int parse_org_emftext_sdk_concretesyntax_CsString_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2400:1: ( (a0= QUOTED_34_34_92 ) )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2401:2: (a0= QUOTED_34_34_92 )
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2401:2: (a0= QUOTED_34_34_92 )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2402:3: a0= QUOTED_34_34_92
            {
            a0=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_CsString2140); if (state.failed) return element;
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
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), resolved);
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 74));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 74));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2446:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2449:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2450:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2450:2: (a0= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2451:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2180); if (state.failed) return element;
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
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_56, 75));
              	
            }
            a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2201); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_57, 76));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2499:2: (a2= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2500:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2219); if (state.failed) return element;
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
              				org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), proxy);
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_58, 77));
              	
            }
            a3=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2240); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 78));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 78));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2561:2: ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38||(LA21_0>=43 && LA21_0<=44)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2562:3: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2562:3: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2563:4: a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2263);
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
                      						completedElement(a4_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a4_0, element); 				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 79));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 79));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2597:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element =  null;
        int parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2600:1: ( (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2601:2: (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2601:2: (a0= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2602:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2308); if (state.failed) return element;
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
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_62, 80));
              	
            }
            a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2329); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_63, 81));
              	
            }
            a2=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2343); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 82));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 82));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2675:2: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==38||(LA22_0>=43 && LA22_0<=44)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2676:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2676:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2677:4: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2366);
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
                      						completedElement(a3_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a3_0, element); 				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 83));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 83));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2711:1: parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2714:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2715:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2715:2: (a0= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2716:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2411); if (state.failed) return element;
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
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_64, 84));
              	
            }
            a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2432); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_65, 85));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2764:2: (a2= QUOTED_39_39_92 )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2765:3: a2= QUOTED_39_39_92
            {
            a2=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2450); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_66, 86));
              	
            }
            a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2471); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_67, 87));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2809:2: (a4= QUOTED_39_39_92 )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2810:3: a4= QUOTED_39_39_92
            {
            a4=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2489); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_68, 88));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_69, 88));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2843:2: ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2844:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2844:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2845:4: a5= ',' (a6= QUOTED_39_39_92 )
                    {
                    a5=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2519); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_70, 89));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2857:4: (a6= QUOTED_39_39_92 )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2858:5: a6= QUOTED_39_39_92
                    {
                    a6=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2545); if (state.failed) return element;
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
                      							completedElement(resolved);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_69, 90));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_69, 91));
              	
            }
            a7=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2591); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 92));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 92));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2922:2: ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38||(LA24_0>=43 && LA24_0<=44)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2923:3: (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2923:3: (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2924:4: a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2614);
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
                      						completedElement(a8_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a8_0, element); 				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 93));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 93));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2958:1: parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2961:1: ( (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2962:2: (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2962:2: (a0= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:2963:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2659); if (state.failed) return element;
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
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_71, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 94));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 94));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3013:2: ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==26) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3014:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3014:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3015:4: a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    {
                    a1=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Containment2689); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_72, 95));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3027:4: (a2= QUALIFIED_NAME )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3028:5: a2= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2715); if (state.failed) return element;
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
                      							completedElement(proxy);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_73, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 96));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 96));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3078:4: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==17) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3079:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3079:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3080:6: a3= ',' (a4= QUALIFIED_NAME )
                    	    {
                    	    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Containment2761); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_74, 97));
                    	      					
                    	    }
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3092:6: (a4= QUALIFIED_NAME )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3093:7: a4= QUALIFIED_NAME
                    	    {
                    	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2795); if (state.failed) return element;
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
                    	      									completedElement(proxy);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
                    	      								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
                    	      							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_73, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 98));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 98));
                    	      					
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
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_73, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 99));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 99));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 100));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 100));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3184:2: ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==38||(LA27_0>=43 && LA27_0<=44)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3185:3: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3185:3: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3186:4: a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment2885);
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
                      						completedElement(a5_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a5_0, element); 				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 101));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 101));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3220:1: parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition parse_org_emftext_sdk_concretesyntax_CompoundDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;
        int parse_org_emftext_sdk_concretesyntax_CompoundDefinition_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1_0 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3223:1: (a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3224:2: a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2926); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 102));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 102));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 102));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 102));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 102));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 102));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 102));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 102));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3243:2: (a1_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3244:3: a1_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2944);
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
              					completedElement(a1_0);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos(a1_0, element); 			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 103));
              	
            }
            a2=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2962); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_59, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_60, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_61, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 104));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 104));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3290:2: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==38||(LA28_0>=43 && LA28_0<=44)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3291:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3291:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3292:4: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2985);
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
                      						completedElement(a3_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a3_0, element); 				}
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 105));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 105));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3326:1: parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : (a0= HEXNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces parse_org_emftext_sdk_concretesyntax_WhiteSpaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;
        int parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3329:1: ( (a0= HEXNUMBER ) )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3330:2: (a0= HEXNUMBER )
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3330:2: (a0= HEXNUMBER )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3331:3: a0= HEXNUMBER
            {
            a0=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces3030); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 106));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 106));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3375:1: parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= '!' (a1= NUMBER ) ;
    public final org.emftext.sdk.concretesyntax.LineBreak parse_org_emftext_sdk_concretesyntax_LineBreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;
        int parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3378:1: (a0= '!' (a1= NUMBER ) )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3379:2: a0= '!' (a1= NUMBER )
            {
            a0=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_LineBreak3066); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_75, 107));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3391:2: (a1= NUMBER )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3392:3: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak3084); if (state.failed) return element;
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
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), resolved);
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 108));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 108));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3436:1: parse_org_emftext_sdk_concretesyntax_NormalToken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? ;
    public final org.emftext.sdk.concretesyntax.NormalToken parse_org_emftext_sdk_concretesyntax_NormalToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.NormalToken element =  null;
        int parse_org_emftext_sdk_concretesyntax_NormalToken_StartIndex = input.index();
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3439:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3440:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3440:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==47) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3441:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3441:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3442:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3442:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3443:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalToken3135);
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
            	      							completedElement(a0_0);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos(a0_0, element); 					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 109));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 109));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 110));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 110));
              	
            }
            a1=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_NormalToken3176); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_76, 111));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3485:2: (a2= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3486:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken3194); if (state.failed) return element;
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
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__NAME), resolved);
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_77, 112));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_78, 112));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3519:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3520:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalToken3219);
            a3_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              			}
              			if (a3_0 != null) {
              				if (a3_0 != null) {
              					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS, a3_0);
              					completedElement(a3_0);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos(a3_0, element); 			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 113));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 113));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 113));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3543:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==38) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3544:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3544:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3545:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    {
            	    a4=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_NormalToken3246); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_77, 114));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_78, 114));
            	      			
            	    }
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3558:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3559:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalToken3272);
            	    a5_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
            	      					}
            	      					if (element == null) {
            	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
            	      					}
            	      					if (a5_0 != null) {
            	      						if (a5_0 != null) {
            	      							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__REGEX_PARTS, a5_0);
            	      							completedElement(a5_0);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos(a5_0, element); 					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 115));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 115));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 115));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 116));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 116));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 116));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3591:2: ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3592:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3592:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3593:4: a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME )
                    {
                    a6=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_NormalToken3322); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_81, 117));
                      			
                    }
                    a7=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_NormalToken3342); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_82, 118));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3617:4: (a8= QUALIFIED_NAME )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3618:5: a8= QUALIFIED_NAME
                    {
                    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken3368); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      					}
                      					if (a8 != null) {
                      						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      						tokenResolver.setOptions(getOptions());
                      						org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolveResult result = getFreshTokenResolveResult();
                      						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), result);
                      						java.lang.Object resolvedObject = result.getResolvedToken();
                      						if (resolvedObject == null) {
                      							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
                      						}
                      						java.lang.String resolved = (java.lang.String)resolvedObject;
                      						if (resolved != null) {
                      							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN__ATTRIBUTE_NAME), resolved);
                      							completedElement(resolved);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 119));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 120));
              	
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


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition"
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3659:1: parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition returns [org.emftext.sdk.concretesyntax.PartialTokenDefinition element = null] : a0= 'DEFINE' a1= 'PARTIAL' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ;
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3662:1: (a0= 'DEFINE' a1= 'PARTIAL' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3663:2: a0= 'DEFINE' a1= 'PARTIAL' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            {
            a0=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3429); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_83, 121));
              	
            }
            a1=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3443); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_84, 122));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3687:2: (a2= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3688:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3461); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_77, 123));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_78, 123));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3721:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3722:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3486);
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
              					completedElement(a3_0);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos(a3_0, element); 			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 124));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 124));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3744:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==38) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3745:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3745:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3746:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    {
            	    a4=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3513); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_77, 125));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_78, 125));
            	      			
            	    }
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3759:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3760:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3539);
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
            	      							completedElement(a5_0);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos(a5_0, element); 					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 126));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 126));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 127));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 127));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3792:1: parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null] : a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.TokenPriorityDirective parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenPriorityDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3795:1: (a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3796:2: a0= 'PRIORITIZE' (a1= QUALIFIED_NAME )
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective3595); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_86, 128));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3808:2: (a1= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3809:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective3613); if (state.failed) return element;
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
              				org.emftext.sdk.concretesyntax.NormalToken proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), proxy);
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 129));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3847:1: parse_org_emftext_sdk_concretesyntax_AtomicRegex returns [org.emftext.sdk.concretesyntax.AtomicRegex element = null] : (a0= QUOTED_36_36 ) ;
    public final org.emftext.sdk.concretesyntax.AtomicRegex parse_org_emftext_sdk_concretesyntax_AtomicRegex() throws RecognitionException {
        org.emftext.sdk.concretesyntax.AtomicRegex element =  null;
        int parse_org_emftext_sdk_concretesyntax_AtomicRegex_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3850:1: ( (a0= QUOTED_36_36 ) )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3851:2: (a0= QUOTED_36_36 )
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3851:2: (a0= QUOTED_36_36 )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3852:3: a0= QUOTED_36_36
            {
            a0=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_AtomicRegex3653); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 130));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 130));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 130));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 130));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3889:1: parse_org_emftext_sdk_concretesyntax_RegexReference returns [org.emftext.sdk.concretesyntax.RegexReference element = null] : (a0= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.RegexReference parse_org_emftext_sdk_concretesyntax_RegexReference() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexReference element =  null;
        int parse_org_emftext_sdk_concretesyntax_RegexReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3892:1: ( (a0= QUALIFIED_NAME ) )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3893:2: (a0= QUALIFIED_NAME )
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3893:2: (a0= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3894:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_RegexReference3693); if (state.failed) return element;
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
              				org.emftext.sdk.concretesyntax.PartialTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.RegexReference, org.emftext.sdk.concretesyntax.AbstractTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRegexReferenceTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), proxy);
              					completedElement(proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_79, 131));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_80, 131));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_28, 131));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_85, 131));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3935:1: parse_org_emftext_sdk_concretesyntax_PLUS returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS parse_org_emftext_sdk_concretesyntax_PLUS() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;
        int parse_org_emftext_sdk_concretesyntax_PLUS_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3938:1: (a0= '+' )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3939:2: a0= '+'
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_PLUS3729); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPLUS();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 132));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 132));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3963:1: parse_org_emftext_sdk_concretesyntax_STAR returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR parse_org_emftext_sdk_concretesyntax_STAR() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;
        int parse_org_emftext_sdk_concretesyntax_STAR_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3966:1: (a0= '*' )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3967:2: a0= '*'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_STAR3758); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSTAR();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 133));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 133));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3991:1: parse_org_emftext_sdk_concretesyntax_QUESTIONMARK returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK parse_org_emftext_sdk_concretesyntax_QUESTIONMARK() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;
        int parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3994:1: (a0= '?' )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:3995:2: a0= '?'
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK3787); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_45, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_46, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_47, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_48, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_49, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_50, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_51, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_52, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_54, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_53, 134));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_55, 134));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4019:1: parse_org_emftext_sdk_concretesyntax_Abstract returns [org.emftext.sdk.concretesyntax.Abstract element = null] : a0= 'ABSTRACT' ;
    public final org.emftext.sdk.concretesyntax.Abstract parse_org_emftext_sdk_concretesyntax_Abstract() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Abstract element =  null;
        int parse_org_emftext_sdk_concretesyntax_Abstract_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4022:1: (a0= 'ABSTRACT' )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4023:2: a0= 'ABSTRACT'
            {
            a0=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_Abstract3816); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAbstract();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 135));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4037:1: parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null] : (a0= QUOTED_34_34_92 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' ;
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4040:1: ( (a0= QUOTED_34_34_92 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4041:2: (a0= QUOTED_34_34_92 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';'
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4041:2: (a0= QUOTED_34_34_92 )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4042:3: a0= QUOTED_34_34_92
            {
            a0=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3849); if (state.failed) return element;
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
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), resolved);
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_87, 136));
              	
            }
            a1=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3870); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_88, 137));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4086:2: (a2= HEXNUMBER )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4087:3: a2= HEXNUMBER
            {
            a2=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3888); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_89, 138));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_90, 138));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4120:2: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==17) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4121:3: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    {
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4121:3: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4122:4: a3= ',' (a4= QUALIFIED_NAME )
            	    {
            	    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3918); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_91, 139));
            	      			
            	    }
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4134:4: (a4= QUALIFIED_NAME )
            	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4135:5: a4= QUALIFIED_NAME
            	    {
            	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3944); if (state.failed) return element;
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
            	      							completedElement(resolved);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
            	      					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_89, 140));
            	      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_90, 140));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_89, 141));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_90, 141));
              	
            }
            a5=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3990); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_30, 142));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_31, 142));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4191:1: parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null] : a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? ;
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4194:1: (a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4195:2: a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            {
            a0=(Token)match(input,47,FOLLOW_47_in_parse_org_emftext_sdk_concretesyntax_Annotation4019); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_92, 143));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4207:2: (a1= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4208:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation4037); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_93, 144));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 144));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 144));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 144));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 144));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 144));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4245:2: ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==34) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4246:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4246:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4247:4: a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')'
                    {
                    a2=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_Annotation4067); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_94, 145));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4259:4: (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4260:5: a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4093);
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
                      							completedElement(a3_0);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos(a3_0, element); 					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 146));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 146));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4282:4: ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==17) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4283:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    {
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4283:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4284:6: a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    {
                    	    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Annotation4134); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_94, 147));
                    	      					
                    	    }
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4296:6: (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4297:7: a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4168);
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
                    	      									completedElement(a5_0);
                    	      								}
                    	      								collectHiddenTokens(element);
                    	      								copyLocalizationInfos(a5_0, element); 							}
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 148));
                    	      						addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 148));
                    	      					
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
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 149));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 149));
                      			
                    }
                    a6=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Annotation4229); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 150));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 150));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 150));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 150));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 150));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_0, 151));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_1, 151));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_2, 151));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_33, 151));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_24, 151));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4356:1: parse_org_emftext_sdk_concretesyntax_KeyValuePair returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null] : (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )? ;
    public final org.emftext.sdk.concretesyntax.KeyValuePair parse_org_emftext_sdk_concretesyntax_KeyValuePair() throws RecognitionException {
        org.emftext.sdk.concretesyntax.KeyValuePair element =  null;
        int parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4359:1: ( (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )? )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4360:2: (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )?
            {
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4360:2: (a0= QUALIFIED_NAME )
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4361:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4281); if (state.failed) return element;
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
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_97, 152));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 152));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 152));
              	
            }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4395:2: ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==29) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4396:3: (a1= '=' (a2= QUOTED_34_34_92 ) )
                    {
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4396:3: (a1= '=' (a2= QUOTED_34_34_92 ) )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4397:4: a1= '=' (a2= QUOTED_34_34_92 )
                    {
                    a1=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4311); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_98, 153));
                      			
                    }
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4409:4: (a2= QUOTED_34_34_92 )
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4410:5: a2= QUOTED_34_34_92
                    {
                    a2=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4337); if (state.failed) return element;
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
                      							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
                      						}
                      						java.lang.String resolved = (java.lang.String)resolvedObject;
                      						if (resolved != null) {
                      							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), resolved);
                      							completedElement(resolved);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 154));
                      				addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 154));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_95, 155));
              		addExpectedElement(new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal(TERMINAL_96, 155));
              	
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
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4453:1: parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null] : (c0= parse_org_emftext_sdk_concretesyntax_NormalToken | c1= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition | c2= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective );
    public final org.emftext.sdk.concretesyntax.TokenDirective parse_org_emftext_sdk_concretesyntax_TokenDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.PartialTokenDefinition c1 = null;

        org.emftext.sdk.concretesyntax.TokenPriorityDirective c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4454:1: (c0= parse_org_emftext_sdk_concretesyntax_NormalToken | c1= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition | c2= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective )
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

                if ( (LA37_2==QUALIFIED_NAME) ) {
                    alt37=1;
                }
                else if ( (LA37_2==41) ) {
                    alt37=2;
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
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4455:2: c0= parse_org_emftext_sdk_concretesyntax_NormalToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalToken_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4394);
                    c0=parse_org_emftext_sdk_concretesyntax_NormalToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4456:4: c1= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4404);
                    c1=parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4457:4: c2= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4414);
                    c2=parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective();

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
            if ( state.backtracking>0 ) { memoize(input, 28, parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenDirective"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Definition"
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4461:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak );
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
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4462:1: (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak )
            int alt38=8;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4463:2: c0= parse_org_emftext_sdk_concretesyntax_CsString
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition4435);
                    c0=parse_org_emftext_sdk_concretesyntax_CsString();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4464:4: c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition4445);
                    c1=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4465:4: c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition4455);
                    c2=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 4 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4466:4: c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition4465);
                    c3=parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 5 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4467:4: c4= parse_org_emftext_sdk_concretesyntax_Containment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition4475);
                    c4=parse_org_emftext_sdk_concretesyntax_Containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 6 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4468:4: c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition4485);
                    c5=parse_org_emftext_sdk_concretesyntax_CompoundDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 7 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4469:4: c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition4495);
                    c6=parse_org_emftext_sdk_concretesyntax_WhiteSpaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c6; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 8 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4470:4: c7= parse_org_emftext_sdk_concretesyntax_LineBreak
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition4505);
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
            if ( state.backtracking>0 ) { memoize(input, 29, parse_org_emftext_sdk_concretesyntax_Definition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Definition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Cardinality"
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4474:1: parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK );
    public final org.emftext.sdk.concretesyntax.Cardinality parse_org_emftext_sdk_concretesyntax_Cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;
        int parse_org_emftext_sdk_concretesyntax_Cardinality_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4475:1: (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK )
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
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4476:2: c0= parse_org_emftext_sdk_concretesyntax_PLUS
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality4526);
                    c0=parse_org_emftext_sdk_concretesyntax_PLUS();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4477:4: c1= parse_org_emftext_sdk_concretesyntax_STAR
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality4536);
                    c1=parse_org_emftext_sdk_concretesyntax_STAR();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 3 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4478:4: c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality4546);
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
            if ( state.backtracking>0 ) { memoize(input, 30, parse_org_emftext_sdk_concretesyntax_Cardinality_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Cardinality"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_RegexPart"
    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4482:1: parse_org_emftext_sdk_concretesyntax_RegexPart returns [org.emftext.sdk.concretesyntax.RegexPart element = null] : (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex | c1= parse_org_emftext_sdk_concretesyntax_RegexReference );
    public final org.emftext.sdk.concretesyntax.RegexPart parse_org_emftext_sdk_concretesyntax_RegexPart() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexPart element =  null;
        int parse_org_emftext_sdk_concretesyntax_RegexPart_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.AtomicRegex c0 = null;

        org.emftext.sdk.concretesyntax.RegexReference c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }
            // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4483:1: (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex | c1= parse_org_emftext_sdk_concretesyntax_RegexReference )
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
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4484:2: c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_AtomicRegex_in_parse_org_emftext_sdk_concretesyntax_RegexPart4567);
                    c0=parse_org_emftext_sdk_concretesyntax_AtomicRegex();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass choice */ 
                    }

                    }
                    break;
                case 2 :
                    // /Users/Florian/Documents/Work/reuseware/EMFText/org.emftext.sdk.concretesyntax.resource.cs/src-gen/org/emftext/sdk/concretesyntax/resource/cs/mopp/Cs.g:4485:4: c1= parse_org_emftext_sdk_concretesyntax_RegexReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexReference_in_parse_org_emftext_sdk_concretesyntax_RegexPart4577);
                    c1=parse_org_emftext_sdk_concretesyntax_RegexReference();

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
        "\2\uffff\1\7\10\uffff";
    static final String DFA38_minS =
        "\1\4\1\uffff\1\4\3\uffff\1\4\4\uffff";
    static final String DFA38_maxS =
        "\1\44\1\uffff\1\54\3\uffff\1\41\4\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\1\1\uffff\1\6\1\7\1\10\1\uffff\1\5\1\2\1\3\1\4";
    static final String DFA38_specialS =
        "\13\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\2\1\uffff\1\1\1\uffff\1\4\31\uffff\1\3\1\uffff\1\5",
            "",
            "\1\7\1\uffff\1\7\1\uffff\1\7\15\uffff\1\7\3\uffff\1\7\4\uffff"+
            "\1\7\1\6\1\uffff\3\7\1\uffff\1\7\4\uffff\2\7",
            "",
            "",
            "",
            "\1\10\2\uffff\1\12\31\uffff\1\11",
            "",
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
            return "4461:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak );";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax127 = new BitSet(new long[]{0x0000A00000004000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax177 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax221 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax242 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax260 = new BitSet(new long[]{0x0000000003A50020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax296 = new BitSet(new long[]{0x0000000003A50000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax351 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax384 = new BitSet(new long[]{0x0000000003A60000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax449 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax492 = new BitSet(new long[]{0x0000000003A60000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax607 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax627 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax668 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax729 = new BitSet(new long[]{0x0000000003A00000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax771 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax791 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax832 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax870 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax919 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax961 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax981 = new BitSet(new long[]{0x0000A42000104000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1022 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1060 = new BitSet(new long[]{0x0000A42000104000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1109 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1151 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1171 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1212 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1273 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1306 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1320 = new BitSet(new long[]{0x0000A00000104010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1349 = new BitSet(new long[]{0x0000A00000104010L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1422 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Import1443 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1461 = new BitSet(new long[]{0x0000000008000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1497 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Import1552 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_Import1572 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1598 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1752 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_Option1773 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_Option1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1842 = new BitSet(new long[]{0x0000A00000004010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1887 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_Rule1908 = new BitSet(new long[]{0x0000001400000150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1926 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_Rule1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence1982 = new BitSet(new long[]{0x0000001400000152L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2027 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_Choice2054 = new BitSet(new long[]{0x0000001400000150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2080 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_CsString2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2180 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2201 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2219 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2240 = new BitSet(new long[]{0x0000184000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2308 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2329 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2343 = new BitSet(new long[]{0x0000184000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2411 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2432 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2450 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2471 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2489 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2519 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2545 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2591 = new BitSet(new long[]{0x0000184000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2659 = new BitSet(new long[]{0x0000184004000002L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Containment2689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2715 = new BitSet(new long[]{0x0000184000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Containment2761 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2795 = new BitSet(new long[]{0x0000184000020002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment2885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2926 = new BitSet(new long[]{0x0000001400000150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2944 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2962 = new BitSet(new long[]{0x0000184000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_LineBreak3066 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak3084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalToken3135 = new BitSet(new long[]{0x0000A02000004000L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_NormalToken3176 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken3194 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalToken3219 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_NormalToken3246 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalToken3272 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_NormalToken3322 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_NormalToken3342 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken3368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3429 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3443 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3461 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3486 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3513 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition3539 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective3595 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective3613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_AtomicRegex3653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_RegexReference3693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_PLUS3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_STAR3758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_Abstract3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3849 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3870 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3888 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3918 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3944 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_parse_org_emftext_sdk_concretesyntax_Annotation4019 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation4037 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_Annotation4067 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4093 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Annotation4134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4168 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Annotation4229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4281 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4311 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair4337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalToken_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective4414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition4435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition4445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition4455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition4475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition4495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition4505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality4526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality4536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality4546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_AtomicRegex_in_parse_org_emftext_sdk_concretesyntax_RegexPart4567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexReference_in_parse_org_emftext_sdk_concretesyntax_RegexPart4577 = new BitSet(new long[]{0x0000000000000002L});

}