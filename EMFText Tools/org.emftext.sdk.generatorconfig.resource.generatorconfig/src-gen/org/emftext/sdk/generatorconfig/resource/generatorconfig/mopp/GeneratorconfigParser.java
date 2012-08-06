/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
public class GeneratorconfigParser extends GeneratorconfigANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUALIFIED_NAME", "QUOTED_60_62", "QUOTED_34_34_92", "QUOTED_39_39_92", "HEXNUMBER", "NUMBER", "QUOTED_36_36", "COMMENTS", "WHITESPACE", "LINEBREAK", "'::='", "';'", "'ClassRule'", "'FeatureRule'", "'FEATURE'", "'('", "')'", "'CLASSNAME'", "'FEATURES'", "'FEATURENAME'", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "'TOKENS'", "'TOKENSTYLES'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'|'", "'['", "']'", "'!'", "'DEFINE'", "'+'", "'COLLECT'", "'IN'", "'FRAGMENT'", "'PRIORITIZE'", "'*'", "'?'", "'ABSTRACT'", "'COLOR'", "'@'"
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
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int COMMENTS=11;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int QUOTED_36_36=10;
    public static final int QUOTED_39_39_92=7;
    public static final int T__50=50;
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
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int NUMBER=9;
    public static final int WHITESPACE=12;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int QUOTED_34_34_92=6;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int QUOTED_60_62=5;

    // delegates
    // delegators


        public GeneratorconfigParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public GeneratorconfigParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[101+1];
             
             
        }
        

    public String[] getTokenNames() { return GeneratorconfigParser.tokenNames; }
    public String getGrammarFileName() { return "Generatorconfig.g"; }


    	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolverFactory tokenResolverFactory = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenResolverFactory();
    	@SuppressWarnings("unused")
    	
    	private int lastPosition;
    	private org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenResolveResult tokenResolveResult = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenResolveResult();
    	private boolean rememberExpectedElements = false;
    	private java.lang.Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	private java.util.List<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal>();
    	private int mismatchedTokenRecoveryTries = 0;
    	private java.util.Map<?, ?> options;
    	//helper lists to allow a lexer to pass errors to its parser
    	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
    	protected java.util.List<java.lang.Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<java.lang.Integer>());
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>> postParseCommands;
    	private boolean terminateParsing;
    	private int tokenIndexOfLastCompleteElement;
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	protected void addErrorToResource(final java.lang.String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>() {
    			public boolean execute(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for
    					// code completion
    					return true;
    				}
    				resource.addProblem(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigProblem() {
    					public org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType getType() {
    						return org.emftext.sdk.generatorconfig.resource.generatorconfig.GeneratorconfigEProblemType.ERROR;
    					}
    					public java.lang.String getMessage() {
    						return errorMessage;
    					}
    				}, line, charPositionInLine, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal expectedElement) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		setPosition(expectedElement, input.index());
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigDummyEObject dummy) {
    		java.lang.Object value = element.eGet(structuralFeature);
    		java.lang.Object mapKey = dummy.getValueByName("key");
    		java.lang.Object mapValue = dummy.getValueByName("value");
    		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
    			org.eclipse.emf.common.util.EMap<java.lang.Object, java.lang.Object> valueMap = org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigMapUtil.castToEMap(value);
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
    			assert(object instanceof org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigDummyEObject);
    			org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigDummyEObject dummy = (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigDummyEObject) object;
    			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
    			currentTarget = newEObject;
    		}
    		return currentTarget;
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    		postParseCommands.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>() {
    			public boolean execute(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource resource) {
    				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigLocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>() {
    			public boolean execute(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource resource) {
    				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigLocationMap locationMap = resource.getLocationMap();
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
    	
    	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextParser createInstance(java.io.InputStream actualInputStream, java.lang.String encoding) {
    		try {
    			if (encoding == null) {
    				return new GeneratorconfigParser(new org.antlr.runtime3_2_0.CommonTokenStream(new GeneratorconfigLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new GeneratorconfigParser(new org.antlr.runtime3_2_0.CommonTokenStream(new GeneratorconfigLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigPlugin.logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	// This default constructor is only used to call createInstance() on it
    	public GeneratorconfigParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((GeneratorconfigLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((GeneratorconfigLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		java.lang.Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.GeneratorConfig.class) {
    				return parse_org_emftext_sdk_generatorconfig_GeneratorConfig();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.GeneratorRule.class) {
    				return parse_org_emftext_sdk_generatorconfig_GeneratorRule();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.ClassRule.class) {
    				return parse_org_emftext_sdk_generatorconfig_ClassRule();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.FeatureRule.class) {
    				return parse_org_emftext_sdk_generatorconfig_FeatureRule();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.FeatureReference.class) {
    				return parse_org_emftext_sdk_generatorconfig_FeatureReference();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.ClassName.class) {
    				return parse_org_emftext_sdk_generatorconfig_ClassName();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.Features.class) {
    				return parse_org_emftext_sdk_generatorconfig_Features();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.ClassRuleReference.class) {
    				return parse_org_emftext_sdk_generatorconfig_ClassRuleReference();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.FeatureRuleReference.class) {
    				return parse_org_emftext_sdk_generatorconfig_FeatureRuleReference();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.FeatureName.class) {
    				return parse_org_emftext_sdk_generatorconfig_FeatureName();
    			}
    			if (type.getInstanceClass() == org.emftext.sdk.generatorconfig.Feature.class) {
    				return parse_org_emftext_sdk_generatorconfig_Feature();
    			}
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
    		throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigUnexpectedContentTypeException(typeObject);
    	}
    	
    	private org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTokenResolveResult getFreshTokenResolveResult() {
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
    	
    	public org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation getMetaInformation() {
    		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigMetaInformation();
    	}
    	
    	public java.lang.Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigReferenceResolverSwitch getReferenceResolverSwitch() {
    		return (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
    	}
    	
    	protected java.lang.Object getTypeObject() {
    		java.lang.Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	// Implementation that calls {@link #doParse()}  and handles the thrown
    	// RecognitionExceptions.
    	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>>();
    		org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigParseResult parseResult = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigParseResult();
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
    	
    	public java.util.List<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource dummyResource) {
    		rememberExpectedElements = true;
    		parseToIndexTypeObject = type;
    		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
    		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigParseResult result = parse();
    		if (result != null) {
    			org.eclipse.emf.ecore.EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContents().add(root);
    			}
    			for (org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal>();
    		java.util.List<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				System.out.println("FOLLOW ELEMENT " + expectedElementI);
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 184;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
    			System.out.println("REMAINING TOKEN: " + nextToken);
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected terminals
    				// can be set
    				for (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are kept
    				for (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal nextFollow : currentFollowSet) {
    					System.out.println("CHECKING : " + nextFollow);
    					if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						System.out.println("MATCH! " + nextFollow);
    						java.util.Collection<org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigPair<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigPair<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
    							org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement newFollower = newFollowerPair.getLeft();
    							org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal newFollowTerminal = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
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
    		for (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal expectedElement, int tokenIndex) {
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
    	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
    		postParseCommands.add(new org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigCommand<org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource>() {
    			public boolean execute(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource resource) {
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
    				tokenName = org.emftext.sdk.generatorconfig.resource.generatorconfig.util.GeneratorconfigStringUtil.formatTokenName(tokenName);
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
    	
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_0 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule(), "ClassRule");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_1 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule(), "FeatureRule");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_2 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_3 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule(), "::=");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_4 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference(), "FEATURE");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_5 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassName(), "CLASSNAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_6 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatures(), "FEATURES");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_7 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRuleReference(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRuleReference().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE_REFERENCE__RULE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_8 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRuleReference(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRuleReference().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE_REFERENCE__RULE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_9 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureName(), "FEATURENAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_10 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeature(), "FEATURE");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_11 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), "QUOTED_34_34_92");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_12 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_13 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_14 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_15 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_16 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), "(");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_17 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), "HEXNUMBER");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_18 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), "!");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_19 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule(), ";");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_20 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE__NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_21 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule(), "::=");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_22 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getClassRule(), ";");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_23 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE__NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_24 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule(), "::=");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_25 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureRule(), ";");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_26 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference(), "(");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_27 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference(), org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_REFERENCE__FEATURE_NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_28 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getFeatureReference(), ")");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_29 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), "|");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_30 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), ";");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_31 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), ")");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_32 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), "@");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_33 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAbstract(), "ABSTRACT");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_34 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "SYNTAXDEF");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_35 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_36 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "FOR");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_37 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), "QUOTED_60_62");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_38 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), "QUOTED_60_62");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_39 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "START");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_40 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "IMPORTS");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_41 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "OPTIONS");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_42 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "TOKENS");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_43 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "TOKENSTYLES");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_44 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "RULES");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_45 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_46 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), ",");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_47 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_48 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_49 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_50 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_51 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_52 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_53 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_54 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), ";");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_55 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_56 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), "DEFINE");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_57 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), "DEFINE");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_58 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(), "PRIORITIZE");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_59 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_60 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), ";");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_61 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_62 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), "QUOTED_34_34_92");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_63 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_64 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "{");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_65 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_66 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), "}");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_67 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), ":");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_68 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), "QUOTED_60_62");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_69 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), "QUOTED_60_62");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_70 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), "WITH");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_71 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), "SYNTAX");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_72 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_73 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), "QUOTED_60_62");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_74 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), "=");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_75 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), "QUOTED_34_34_92");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_76 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), "::=");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_77 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), "[");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_78 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_79 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), "]");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_80 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPLUS(), "+");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_81 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSTAR(), "*");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_82 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getQUESTIONMARK(), "?");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_83 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), "[");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_84 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), "]");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_85 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), "[");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_86 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), "QUOTED_39_39_92");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_87 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), ",");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_88 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), "QUOTED_39_39_92");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_89 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), ",");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_90 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), "]");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_91 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), "QUOTED_39_39_92");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_92 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), ":");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_93 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_94 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), ",");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_95 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_96 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), "NUMBER");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_97 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_98 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), "QUOTED_36_36");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_99 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_100 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), "+");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_101 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), "COLLECT");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_102 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), "IN");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_103 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_104 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), "FRAGMENT");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_105 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_106 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), "+");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_107 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_108 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), "COLOR");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_109 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), "HEXNUMBER");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_110 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), ",");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_111 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), ";");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_112 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_113 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_114 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), "(");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_115 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), "QUALIFIED_NAME");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_116 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), ",");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_117 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), ")");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_118 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedCsString(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), "=");
    	private final static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement TERMINAL_119 = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), "QUOTED_34_34_92");
    	
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_0 = org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorConfig().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_1 = org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorConfig().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_2 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__PARTS);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_3 = org.emftext.sdk.generatorconfig.GeneratorconfigPackage.eINSTANCE.getGeneratorRule().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__DEFINITION);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_4 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotable().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTABLE__ANNOTATIONS);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_5 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__MODIFIER);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_6 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_7 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_8 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_9 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_10 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_11 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__OPTIONS);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_12 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__DEFINITION);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_13 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCardinalityDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CARDINALITY_DEFINITION__CARDINALITY);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_14 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__DEFINITIONS);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_15 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexComposite().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS);
    	private final static org.eclipse.emf.ecore.EStructuralFeature FEATURE_16 = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS);
    	
    	private final static org.eclipse.emf.ecore.EStructuralFeature[] EMPTY_FEATURE_ARRAY = new org.eclipse.emf.ecore.EStructuralFeature[0];
    	
    	public static void wire0() {
    		TERMINAL_2.addFollower(TERMINAL_3, EMPTY_FEATURE_ARRAY);
    		TERMINAL_3.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_3.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_0.addFollower(TERMINAL_20, EMPTY_FEATURE_ARRAY);
    		TERMINAL_20.addFollower(TERMINAL_21, EMPTY_FEATURE_ARRAY);
    		TERMINAL_21.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_21.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_22.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
    		TERMINAL_22.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_1.addFollower(TERMINAL_23, EMPTY_FEATURE_ARRAY);
    		TERMINAL_23.addFollower(TERMINAL_24, EMPTY_FEATURE_ARRAY);
    		TERMINAL_24.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_24.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_3, });
    		TERMINAL_25.addFollower(TERMINAL_0, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_0, });
    		TERMINAL_25.addFollower(TERMINAL_1, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_1, });
    		TERMINAL_4.addFollower(TERMINAL_26, EMPTY_FEATURE_ARRAY);
    		TERMINAL_26.addFollower(TERMINAL_27, EMPTY_FEATURE_ARRAY);
    		TERMINAL_27.addFollower(TERMINAL_28, EMPTY_FEATURE_ARRAY);
    		TERMINAL_28.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_28.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_28.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_28.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_28.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_28.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_28.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_5.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_5.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_5.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_5.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_5.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_5.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_5.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_6.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_6.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_6.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_6.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_6.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_6.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_6.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_7.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_7.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_7.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_7.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_7.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_7.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_7.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_8.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_8.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_8.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_8.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_8.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_8.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_8.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_9.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_9.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_9.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_9.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_9.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_9.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_9.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_10.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_10.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_10.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_10.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_10.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_10.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_10.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_34.addFollower(TERMINAL_35, EMPTY_FEATURE_ARRAY);
    		TERMINAL_35.addFollower(TERMINAL_36, EMPTY_FEATURE_ARRAY);
    		TERMINAL_36.addFollower(TERMINAL_37, EMPTY_FEATURE_ARRAY);
    		TERMINAL_37.addFollower(TERMINAL_38, EMPTY_FEATURE_ARRAY);
    		TERMINAL_37.addFollower(TERMINAL_39, EMPTY_FEATURE_ARRAY);
    		TERMINAL_37.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
    		TERMINAL_37.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
    		TERMINAL_37.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
    		TERMINAL_37.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
    		TERMINAL_37.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
    		TERMINAL_38.addFollower(TERMINAL_39, EMPTY_FEATURE_ARRAY);
    		TERMINAL_38.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
    		TERMINAL_38.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
    		TERMINAL_38.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
    		TERMINAL_38.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
    		TERMINAL_38.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
    		TERMINAL_39.addFollower(TERMINAL_45, EMPTY_FEATURE_ARRAY);
    		TERMINAL_45.addFollower(TERMINAL_46, EMPTY_FEATURE_ARRAY);
    		TERMINAL_45.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
    		TERMINAL_45.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
    		TERMINAL_45.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
    		TERMINAL_45.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
    		TERMINAL_45.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
    		TERMINAL_46.addFollower(TERMINAL_47, EMPTY_FEATURE_ARRAY);
    		TERMINAL_47.addFollower(TERMINAL_46, EMPTY_FEATURE_ARRAY);
    		TERMINAL_47.addFollower(TERMINAL_40, EMPTY_FEATURE_ARRAY);
    		TERMINAL_47.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
    		TERMINAL_47.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
    		TERMINAL_47.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
    		TERMINAL_47.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
    		TERMINAL_40.addFollower(TERMINAL_48, EMPTY_FEATURE_ARRAY);
    		TERMINAL_48.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
    		TERMINAL_48.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
    		TERMINAL_50.addFollower(TERMINAL_41, EMPTY_FEATURE_ARRAY);
    		TERMINAL_50.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
    		TERMINAL_50.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
    		TERMINAL_50.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
    		TERMINAL_41.addFollower(TERMINAL_51, EMPTY_FEATURE_ARRAY);
    		TERMINAL_51.addFollower(TERMINAL_52, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_7, });
    		TERMINAL_51.addFollower(TERMINAL_53, EMPTY_FEATURE_ARRAY);
    		TERMINAL_54.addFollower(TERMINAL_52, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_7, });
    		TERMINAL_54.addFollower(TERMINAL_53, EMPTY_FEATURE_ARRAY);
    		TERMINAL_53.addFollower(TERMINAL_42, EMPTY_FEATURE_ARRAY);
    		TERMINAL_53.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
    		TERMINAL_53.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
    		TERMINAL_42.addFollower(TERMINAL_55, EMPTY_FEATURE_ARRAY);
    		TERMINAL_55.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, FEATURE_8, });
    		TERMINAL_55.addFollower(TERMINAL_56, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
    		TERMINAL_55.addFollower(TERMINAL_57, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
    		TERMINAL_55.addFollower(TERMINAL_58, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
    		TERMINAL_55.addFollower(TERMINAL_59, EMPTY_FEATURE_ARRAY);
    		TERMINAL_60.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, FEATURE_8, });
    		TERMINAL_60.addFollower(TERMINAL_56, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
    		TERMINAL_60.addFollower(TERMINAL_57, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
    		TERMINAL_60.addFollower(TERMINAL_58, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_8, });
    		TERMINAL_60.addFollower(TERMINAL_59, EMPTY_FEATURE_ARRAY);
    		TERMINAL_59.addFollower(TERMINAL_43, EMPTY_FEATURE_ARRAY);
    		TERMINAL_59.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
    		TERMINAL_43.addFollower(TERMINAL_61, EMPTY_FEATURE_ARRAY);
    		TERMINAL_61.addFollower(TERMINAL_62, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_9, });
    		TERMINAL_61.addFollower(TERMINAL_63, EMPTY_FEATURE_ARRAY);
    		TERMINAL_63.addFollower(TERMINAL_44, EMPTY_FEATURE_ARRAY);
    		TERMINAL_44.addFollower(TERMINAL_64, EMPTY_FEATURE_ARRAY);
    		TERMINAL_64.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, FEATURE_10, });
    		TERMINAL_64.addFollower(TERMINAL_65, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_10, });
    		TERMINAL_64.addFollower(TERMINAL_66, EMPTY_FEATURE_ARRAY);
    		TERMINAL_49.addFollower(TERMINAL_67, EMPTY_FEATURE_ARRAY);
    		TERMINAL_67.addFollower(TERMINAL_68, EMPTY_FEATURE_ARRAY);
    		TERMINAL_68.addFollower(TERMINAL_69, EMPTY_FEATURE_ARRAY);
    		TERMINAL_68.addFollower(TERMINAL_70, EMPTY_FEATURE_ARRAY);
    		TERMINAL_68.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
    		TERMINAL_68.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
    		TERMINAL_69.addFollower(TERMINAL_70, EMPTY_FEATURE_ARRAY);
    		TERMINAL_69.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
    		TERMINAL_69.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
    		TERMINAL_70.addFollower(TERMINAL_71, EMPTY_FEATURE_ARRAY);
    		TERMINAL_71.addFollower(TERMINAL_72, EMPTY_FEATURE_ARRAY);
    		TERMINAL_72.addFollower(TERMINAL_73, EMPTY_FEATURE_ARRAY);
    		TERMINAL_72.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
    		TERMINAL_72.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
    		TERMINAL_73.addFollower(TERMINAL_49, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_6, });
    		TERMINAL_73.addFollower(TERMINAL_50, EMPTY_FEATURE_ARRAY);
    		TERMINAL_52.addFollower(TERMINAL_74, EMPTY_FEATURE_ARRAY);
    		TERMINAL_74.addFollower(TERMINAL_75, EMPTY_FEATURE_ARRAY);
    		TERMINAL_75.addFollower(TERMINAL_54, EMPTY_FEATURE_ARRAY);
    		TERMINAL_65.addFollower(TERMINAL_76, EMPTY_FEATURE_ARRAY);
    		TERMINAL_76.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_76.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_12, });
    		TERMINAL_30.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, FEATURE_10, });
    		TERMINAL_30.addFollower(TERMINAL_65, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_10, });
    		TERMINAL_30.addFollower(TERMINAL_66, EMPTY_FEATURE_ARRAY);
    		TERMINAL_29.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_29.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, });
    		TERMINAL_11.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_11.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_11.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_11.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_11.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_11.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_11.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_12.addFollower(TERMINAL_77, EMPTY_FEATURE_ARRAY);
    		TERMINAL_77.addFollower(TERMINAL_78, EMPTY_FEATURE_ARRAY);
    		TERMINAL_78.addFollower(TERMINAL_79, EMPTY_FEATURE_ARRAY);
    		TERMINAL_79.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_79.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_79.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_79.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_79.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_79.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_79.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_79.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_79.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_79.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_13.addFollower(TERMINAL_83, EMPTY_FEATURE_ARRAY);
    		TERMINAL_83.addFollower(TERMINAL_84, EMPTY_FEATURE_ARRAY);
    		TERMINAL_84.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_84.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_84.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_84.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_84.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_84.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_84.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_84.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_84.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_84.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_14.addFollower(TERMINAL_85, EMPTY_FEATURE_ARRAY);
    		TERMINAL_85.addFollower(TERMINAL_86, EMPTY_FEATURE_ARRAY);
    		TERMINAL_86.addFollower(TERMINAL_87, EMPTY_FEATURE_ARRAY);
    		TERMINAL_87.addFollower(TERMINAL_88, EMPTY_FEATURE_ARRAY);
    		TERMINAL_88.addFollower(TERMINAL_89, EMPTY_FEATURE_ARRAY);
    		TERMINAL_88.addFollower(TERMINAL_90, EMPTY_FEATURE_ARRAY);
    		TERMINAL_89.addFollower(TERMINAL_91, EMPTY_FEATURE_ARRAY);
    		TERMINAL_91.addFollower(TERMINAL_90, EMPTY_FEATURE_ARRAY);
    		TERMINAL_90.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_90.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_90.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_90.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_90.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_90.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_90.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_90.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_90.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_90.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_15.addFollower(TERMINAL_92, EMPTY_FEATURE_ARRAY);
    		TERMINAL_15.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_15.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_15.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_15.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_15.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_15.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_15.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_15.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_15.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_15.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_92.addFollower(TERMINAL_93, EMPTY_FEATURE_ARRAY);
    		TERMINAL_93.addFollower(TERMINAL_94, EMPTY_FEATURE_ARRAY);
    		TERMINAL_93.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_93.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_93.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_93.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_93.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_93.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_93.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_93.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_93.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_93.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_94.addFollower(TERMINAL_95, EMPTY_FEATURE_ARRAY);
    		TERMINAL_95.addFollower(TERMINAL_94, EMPTY_FEATURE_ARRAY);
    		TERMINAL_95.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_95.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_95.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_95.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_95.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_95.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_95.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_95.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_95.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_95.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_16.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_16.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, FEATURE_11, FEATURE_14, });
    		TERMINAL_31.addFollower(TERMINAL_80, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_31.addFollower(TERMINAL_81, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_31.addFollower(TERMINAL_82, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_13, });
    		TERMINAL_31.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_31.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_31.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_31.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_31.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_31.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_31.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_17.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_17.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_17.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_17.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_17.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_17.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_17.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_18.addFollower(TERMINAL_96, EMPTY_FEATURE_ARRAY);
    		TERMINAL_96.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_96.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_96.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_96.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_96.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_96.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_96.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_56.addFollower(TERMINAL_97, EMPTY_FEATURE_ARRAY);
    		TERMINAL_97.addFollower(TERMINAL_98, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
    		TERMINAL_97.addFollower(TERMINAL_99, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
    		TERMINAL_100.addFollower(TERMINAL_98, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
    		TERMINAL_100.addFollower(TERMINAL_99, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
    		TERMINAL_101.addFollower(TERMINAL_102, EMPTY_FEATURE_ARRAY);
    		TERMINAL_102.addFollower(TERMINAL_103, EMPTY_FEATURE_ARRAY);
    		TERMINAL_103.addFollower(TERMINAL_60, EMPTY_FEATURE_ARRAY);
    		TERMINAL_57.addFollower(TERMINAL_104, EMPTY_FEATURE_ARRAY);
    		TERMINAL_104.addFollower(TERMINAL_105, EMPTY_FEATURE_ARRAY);
    		TERMINAL_105.addFollower(TERMINAL_98, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
    		TERMINAL_105.addFollower(TERMINAL_99, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
    		TERMINAL_106.addFollower(TERMINAL_98, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
    		TERMINAL_106.addFollower(TERMINAL_99, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_15, });
    		TERMINAL_58.addFollower(TERMINAL_107, EMPTY_FEATURE_ARRAY);
    		TERMINAL_107.addFollower(TERMINAL_60, EMPTY_FEATURE_ARRAY);
    		TERMINAL_98.addFollower(TERMINAL_100, EMPTY_FEATURE_ARRAY);
    		TERMINAL_98.addFollower(TERMINAL_101, EMPTY_FEATURE_ARRAY);
    		TERMINAL_98.addFollower(TERMINAL_60, EMPTY_FEATURE_ARRAY);
    		TERMINAL_98.addFollower(TERMINAL_106, EMPTY_FEATURE_ARRAY);
    		TERMINAL_99.addFollower(TERMINAL_100, EMPTY_FEATURE_ARRAY);
    		TERMINAL_99.addFollower(TERMINAL_101, EMPTY_FEATURE_ARRAY);
    		TERMINAL_99.addFollower(TERMINAL_60, EMPTY_FEATURE_ARRAY);
    		TERMINAL_99.addFollower(TERMINAL_106, EMPTY_FEATURE_ARRAY);
    		TERMINAL_80.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_80.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_80.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_80.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_80.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_80.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_80.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_81.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_81.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_81.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_81.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_81.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_81.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_81.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_82.addFollower(TERMINAL_4, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_5, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_6, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_7, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_8, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_9, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_10, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_11, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_12, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_13, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_14, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_15, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_16, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_17, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_18, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_2, });
    		TERMINAL_82.addFollower(TERMINAL_19, EMPTY_FEATURE_ARRAY);
    		TERMINAL_82.addFollower(TERMINAL_22, EMPTY_FEATURE_ARRAY);
    		TERMINAL_82.addFollower(TERMINAL_25, EMPTY_FEATURE_ARRAY);
    		TERMINAL_82.addFollower(TERMINAL_29, EMPTY_FEATURE_ARRAY);
    		TERMINAL_82.addFollower(TERMINAL_30, EMPTY_FEATURE_ARRAY);
    		TERMINAL_82.addFollower(TERMINAL_31, EMPTY_FEATURE_ARRAY);
    		TERMINAL_33.addFollower(TERMINAL_34, EMPTY_FEATURE_ARRAY);
    		TERMINAL_62.addFollower(TERMINAL_108, EMPTY_FEATURE_ARRAY);
    		TERMINAL_108.addFollower(TERMINAL_109, EMPTY_FEATURE_ARRAY);
    		TERMINAL_109.addFollower(TERMINAL_110, EMPTY_FEATURE_ARRAY);
    		TERMINAL_109.addFollower(TERMINAL_111, EMPTY_FEATURE_ARRAY);
    		TERMINAL_110.addFollower(TERMINAL_112, EMPTY_FEATURE_ARRAY);
    		TERMINAL_112.addFollower(TERMINAL_110, EMPTY_FEATURE_ARRAY);
    		TERMINAL_112.addFollower(TERMINAL_111, EMPTY_FEATURE_ARRAY);
    		TERMINAL_111.addFollower(TERMINAL_62, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_9, });
    		TERMINAL_111.addFollower(TERMINAL_63, EMPTY_FEATURE_ARRAY);
    		TERMINAL_32.addFollower(TERMINAL_113, EMPTY_FEATURE_ARRAY);
    		TERMINAL_113.addFollower(TERMINAL_114, EMPTY_FEATURE_ARRAY);
    		TERMINAL_113.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, });
    		TERMINAL_113.addFollower(TERMINAL_33, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_5, });
    		TERMINAL_113.addFollower(TERMINAL_34, EMPTY_FEATURE_ARRAY);
    		TERMINAL_113.addFollower(TERMINAL_65, EMPTY_FEATURE_ARRAY);
    		TERMINAL_113.addFollower(TERMINAL_56, EMPTY_FEATURE_ARRAY);
    		TERMINAL_114.addFollower(TERMINAL_115, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_16, });
    		TERMINAL_116.addFollower(TERMINAL_115, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_16, });
    		TERMINAL_117.addFollower(TERMINAL_32, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_4, });
    		TERMINAL_117.addFollower(TERMINAL_33, new org.eclipse.emf.ecore.EStructuralFeature[] {FEATURE_5, });
    		TERMINAL_117.addFollower(TERMINAL_34, EMPTY_FEATURE_ARRAY);
    		TERMINAL_117.addFollower(TERMINAL_65, EMPTY_FEATURE_ARRAY);
    		TERMINAL_117.addFollower(TERMINAL_56, EMPTY_FEATURE_ARRAY);
    		TERMINAL_115.addFollower(TERMINAL_118, EMPTY_FEATURE_ARRAY);
    		TERMINAL_115.addFollower(TERMINAL_116, EMPTY_FEATURE_ARRAY);
    		TERMINAL_115.addFollower(TERMINAL_117, EMPTY_FEATURE_ARRAY);
    		TERMINAL_118.addFollower(TERMINAL_119, EMPTY_FEATURE_ARRAY);
    		TERMINAL_119.addFollower(TERMINAL_116, EMPTY_FEATURE_ARRAY);
    		TERMINAL_119.addFollower(TERMINAL_117, EMPTY_FEATURE_ARRAY);
    	}
    	// wire the terminals
    	static {
    		wire0();
    	}



    // $ANTLR start "start"
    // Generatorconfig.g:1412:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_sdk_generatorconfig_GeneratorConfig ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.sdk.generatorconfig.GeneratorConfig c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Generatorconfig.g:1413:1: ( (c0= parse_org_emftext_sdk_generatorconfig_GeneratorConfig ) EOF )
            // Generatorconfig.g:1414:2: (c0= parse_org_emftext_sdk_generatorconfig_GeneratorConfig ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 0, FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 0, FEATURE_1));
              		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
              	
            }
            // Generatorconfig.g:1420:2: (c0= parse_org_emftext_sdk_generatorconfig_GeneratorConfig )
            // Generatorconfig.g:1421:3: c0= parse_org_emftext_sdk_generatorconfig_GeneratorConfig
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_GeneratorConfig_in_start82);
            c0=parse_org_emftext_sdk_generatorconfig_GeneratorConfig();

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


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_GeneratorConfig"
    // Generatorconfig.g:1426:1: parse_org_emftext_sdk_generatorconfig_GeneratorConfig returns [org.emftext.sdk.generatorconfig.GeneratorConfig element = null] : ( ( (a0_0= parse_org_emftext_sdk_generatorconfig_ClassRule ) | (a1_0= parse_org_emftext_sdk_generatorconfig_FeatureRule ) ) )* ;
    public final org.emftext.sdk.generatorconfig.GeneratorConfig parse_org_emftext_sdk_generatorconfig_GeneratorConfig() throws RecognitionException {
        org.emftext.sdk.generatorconfig.GeneratorConfig element =  null;
        int parse_org_emftext_sdk_generatorconfig_GeneratorConfig_StartIndex = input.index();
        org.emftext.sdk.generatorconfig.ClassRule a0_0 = null;

        org.emftext.sdk.generatorconfig.FeatureRule a1_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // Generatorconfig.g:1429:1: ( ( ( (a0_0= parse_org_emftext_sdk_generatorconfig_ClassRule ) | (a1_0= parse_org_emftext_sdk_generatorconfig_FeatureRule ) ) )* )
            // Generatorconfig.g:1430:2: ( ( (a0_0= parse_org_emftext_sdk_generatorconfig_ClassRule ) | (a1_0= parse_org_emftext_sdk_generatorconfig_FeatureRule ) ) )*
            {
            // Generatorconfig.g:1430:2: ( ( (a0_0= parse_org_emftext_sdk_generatorconfig_ClassRule ) | (a1_0= parse_org_emftext_sdk_generatorconfig_FeatureRule ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=16 && LA2_0<=17)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Generatorconfig.g:1431:3: ( (a0_0= parse_org_emftext_sdk_generatorconfig_ClassRule ) | (a1_0= parse_org_emftext_sdk_generatorconfig_FeatureRule ) )
            	    {
            	    // Generatorconfig.g:1431:3: ( (a0_0= parse_org_emftext_sdk_generatorconfig_ClassRule ) | (a1_0= parse_org_emftext_sdk_generatorconfig_FeatureRule ) )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==16) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==17) ) {
            	        alt1=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // Generatorconfig.g:1432:4: (a0_0= parse_org_emftext_sdk_generatorconfig_ClassRule )
            	            {
            	            // Generatorconfig.g:1432:4: (a0_0= parse_org_emftext_sdk_generatorconfig_ClassRule )
            	            // Generatorconfig.g:1433:5: a0_0= parse_org_emftext_sdk_generatorconfig_ClassRule
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassRule_in_parse_org_emftext_sdk_generatorconfig_GeneratorConfig127);
            	            a0_0=parse_org_emftext_sdk_generatorconfig_ClassRule();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (terminateParsing) {
            	              						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
            	              					}
            	              					if (element == null) {
            	              						element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorConfig();
            	              					}
            	              					if (a0_0 != null) {
            	              						if (a0_0 != null) {
            	              							addObjectToList(element, org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES, a0_0);
            	              							completedElement(a0_0);
            	              						}
            	              						collectHiddenTokens(element);
            	              						copyLocalizationInfos(a0_0, element); 					}
            	              				
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              				// expected elements (follow set)
            	              				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 1, FEATURE_0));
            	              				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 1, FEATURE_1));
            	              			
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Generatorconfig.g:1456:8: (a1_0= parse_org_emftext_sdk_generatorconfig_FeatureRule )
            	            {
            	            // Generatorconfig.g:1456:8: (a1_0= parse_org_emftext_sdk_generatorconfig_FeatureRule )
            	            // Generatorconfig.g:1457:5: a1_0= parse_org_emftext_sdk_generatorconfig_FeatureRule
            	            {
            	            pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureRule_in_parse_org_emftext_sdk_generatorconfig_GeneratorConfig169);
            	            a1_0=parse_org_emftext_sdk_generatorconfig_FeatureRule();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (terminateParsing) {
            	              						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
            	              					}
            	              					if (element == null) {
            	              						element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorConfig();
            	              					}
            	              					if (a1_0 != null) {
            	              						if (a1_0 != null) {
            	              							addObjectToList(element, org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES, a1_0);
            	              							completedElement(a1_0);
            	              						}
            	              						collectHiddenTokens(element);
            	              						copyLocalizationInfos(a1_0, element); 					}
            	              				
            	            }

            	            }

            	            if ( state.backtracking==0 ) {

            	              				// expected elements (follow set)
            	              				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 2, FEATURE_0));
            	              				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 2, FEATURE_1));
            	              			
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 3, FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 3, FEATURE_1));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_sdk_generatorconfig_GeneratorConfig_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_GeneratorConfig"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_GeneratorRule"
    // Generatorconfig.g:1489:1: parse_org_emftext_sdk_generatorconfig_GeneratorRule returns [org.emftext.sdk.generatorconfig.GeneratorRule element = null] : ( (a0= QUALIFIED_NAME ) a1= '::=' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) a3= ';' | c0= parse_org_emftext_sdk_generatorconfig_ClassRule | c1= parse_org_emftext_sdk_generatorconfig_FeatureRule );
    public final org.emftext.sdk.generatorconfig.GeneratorRule parse_org_emftext_sdk_generatorconfig_GeneratorRule() throws RecognitionException {
        org.emftext.sdk.generatorconfig.GeneratorRule element =  null;
        int parse_org_emftext_sdk_generatorconfig_GeneratorRule_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Sequence a2_0 = null;

        org.emftext.sdk.generatorconfig.ClassRule c0 = null;

        org.emftext.sdk.generatorconfig.FeatureRule c1 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Generatorconfig.g:1492:1: ( (a0= QUALIFIED_NAME ) a1= '::=' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) a3= ';' | c0= parse_org_emftext_sdk_generatorconfig_ClassRule | c1= parse_org_emftext_sdk_generatorconfig_FeatureRule )
            int alt3=3;
            switch ( input.LA(1) ) {
            case QUALIFIED_NAME:
                {
                alt3=1;
                }
                break;
            case 16:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // Generatorconfig.g:1493:2: (a0= QUALIFIED_NAME ) a1= '::=' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) a3= ';'
                    {
                    // Generatorconfig.g:1493:2: (a0= QUALIFIED_NAME )
                    // Generatorconfig.g:1494:3: a0= QUALIFIED_NAME
                    {
                    a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule229); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
                      			}
                      			if (a0 != null) {
                      				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      				tokenResolver.setOptions(getOptions());
                      				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
                      				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__NAME), result);
                      				java.lang.Object resolvedObject = result.getResolvedToken();
                      				if (resolvedObject == null) {
                      					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
                      				}
                      				java.lang.String resolved = (java.lang.String)resolvedObject;
                      				if (resolved != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__NAME), resolved);
                      					completedElement(resolved);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
                      			}
                      		
                    }

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_3, 4));
                      	
                    }
                    a1=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule250); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
                      		}
                      		collectHiddenTokens(element);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 5, FEATURE_2, FEATURE_3));
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 5, FEATURE_2, FEATURE_3));
                      	
                    }
                    // Generatorconfig.g:1552:2: (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
                    // Generatorconfig.g:1553:3: a2_0= parse_org_emftext_sdk_concretesyntax_Sequence
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule268);
                    a2_0=parse_org_emftext_sdk_concretesyntax_Sequence();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      			if (terminateParsing) {
                      				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      			}
                      			if (element == null) {
                      				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
                      			}
                      			if (a2_0 != null) {
                      				if (a2_0 != null) {
                      					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.GENERATOR_RULE__DEFINITION), a2_0);
                      					completedElement(a2_0);
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos(a2_0, element); 			}
                      		
                    }

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 6));
                      	
                    }
                    a3=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule286); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
                      		}
                      		collectHiddenTokens(element);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      	
                    }

                    }
                    break;
                case 2 :
                    // Generatorconfig.g:1587:2: c0= parse_org_emftext_sdk_generatorconfig_ClassRule
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassRule_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule305);
                    c0=parse_org_emftext_sdk_generatorconfig_ClassRule();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Generatorconfig.g:1588:4: c1= parse_org_emftext_sdk_generatorconfig_FeatureRule
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureRule_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule315);
                    c1=parse_org_emftext_sdk_generatorconfig_FeatureRule();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_sdk_generatorconfig_GeneratorRule_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_GeneratorRule"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_ClassRule"
    // Generatorconfig.g:1592:1: parse_org_emftext_sdk_generatorconfig_ClassRule returns [org.emftext.sdk.generatorconfig.ClassRule element = null] : a0= 'ClassRule' (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Sequence ) a4= ';' ;
    public final org.emftext.sdk.generatorconfig.ClassRule parse_org_emftext_sdk_generatorconfig_ClassRule() throws RecognitionException {
        org.emftext.sdk.generatorconfig.ClassRule element =  null;
        int parse_org_emftext_sdk_generatorconfig_ClassRule_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Sequence a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Generatorconfig.g:1595:1: (a0= 'ClassRule' (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Sequence ) a4= ';' )
            // Generatorconfig.g:1596:2: a0= 'ClassRule' (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Sequence ) a4= ';'
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_generatorconfig_ClassRule340); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_20, 8));
              	
            }
            // Generatorconfig.g:1608:2: (a1= QUALIFIED_NAME )
            // Generatorconfig.g:1609:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_ClassRule358); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
              			}
              			if (a1 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE__NAME), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE__NAME), resolved);
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_21, 9));
              	
            }
            a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_sdk_generatorconfig_ClassRule379); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 10, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 10, FEATURE_2, FEATURE_3));
              	
            }
            // Generatorconfig.g:1667:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            // Generatorconfig.g:1668:3: a3_0= parse_org_emftext_sdk_concretesyntax_Sequence
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_generatorconfig_ClassRule397);
            a3_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
              			}
              			if (a3_0 != null) {
              				if (a3_0 != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE__DEFINITION), a3_0);
              					completedElement(a3_0);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos(a3_0, element); 			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 11));
              	
            }
            a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_generatorconfig_ClassRule415); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 12, FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 12, FEATURE_1));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_sdk_generatorconfig_ClassRule_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_ClassRule"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_FeatureRule"
    // Generatorconfig.g:1704:1: parse_org_emftext_sdk_generatorconfig_FeatureRule returns [org.emftext.sdk.generatorconfig.FeatureRule element = null] : a0= 'FeatureRule' (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Sequence ) a4= ';' ;
    public final org.emftext.sdk.generatorconfig.FeatureRule parse_org_emftext_sdk_generatorconfig_FeatureRule() throws RecognitionException {
        org.emftext.sdk.generatorconfig.FeatureRule element =  null;
        int parse_org_emftext_sdk_generatorconfig_FeatureRule_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Sequence a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Generatorconfig.g:1707:1: (a0= 'FeatureRule' (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Sequence ) a4= ';' )
            // Generatorconfig.g:1708:2: a0= 'FeatureRule' (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Sequence ) a4= ';'
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_generatorconfig_FeatureRule444); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_23, 13));
              	
            }
            // Generatorconfig.g:1720:2: (a1= QUALIFIED_NAME )
            // Generatorconfig.g:1721:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_FeatureRule462); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
              			}
              			if (a1 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE__NAME), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE__NAME), resolved);
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_24, 14));
              	
            }
            a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_sdk_generatorconfig_FeatureRule483); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 15, FEATURE_2, FEATURE_3));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 15, FEATURE_2, FEATURE_3));
              	
            }
            // Generatorconfig.g:1779:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            // Generatorconfig.g:1780:3: a3_0= parse_org_emftext_sdk_concretesyntax_Sequence
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_generatorconfig_FeatureRule501);
            a3_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
              			}
              			if (a3_0 != null) {
              				if (a3_0 != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE__DEFINITION), a3_0);
              					completedElement(a3_0);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos(a3_0, element); 			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 16));
              	
            }
            a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_generatorconfig_FeatureRule519); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_0, 17, FEATURE_0));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_1, 17, FEATURE_1));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_sdk_generatorconfig_FeatureRule_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_FeatureRule"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_FeatureReference"
    // Generatorconfig.g:1816:1: parse_org_emftext_sdk_generatorconfig_FeatureReference returns [org.emftext.sdk.generatorconfig.FeatureReference element = null] : a0= 'FEATURE' a1= '(' (a2= QUALIFIED_NAME ) a3= ')' ;
    public final org.emftext.sdk.generatorconfig.FeatureReference parse_org_emftext_sdk_generatorconfig_FeatureReference() throws RecognitionException {
        org.emftext.sdk.generatorconfig.FeatureReference element =  null;
        int parse_org_emftext_sdk_generatorconfig_FeatureReference_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Generatorconfig.g:1819:1: (a0= 'FEATURE' a1= '(' (a2= QUALIFIED_NAME ) a3= ')' )
            // Generatorconfig.g:1820:2: a0= 'FEATURE' a1= '(' (a2= QUALIFIED_NAME ) a3= ')'
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_generatorconfig_FeatureReference548); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureReference();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_26, 18));
              	
            }
            a1=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_generatorconfig_FeatureReference562); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureReference();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_27, 19));
              	
            }
            // Generatorconfig.g:1844:2: (a2= QUALIFIED_NAME )
            // Generatorconfig.g:1845:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_FeatureReference580); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureReference();
              			}
              			if (a2 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_REFERENCE__FEATURE_NAME), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_REFERENCE__FEATURE_NAME), resolved);
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_28, 20));
              	
            }
            a3=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_generatorconfig_FeatureReference601); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureReference();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 21, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 21));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 21));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 21));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 21));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 21));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 21));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_sdk_generatorconfig_FeatureReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_FeatureReference"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_ClassName"
    // Generatorconfig.g:1911:1: parse_org_emftext_sdk_generatorconfig_ClassName returns [org.emftext.sdk.generatorconfig.ClassName element = null] : a0= 'CLASSNAME' ;
    public final org.emftext.sdk.generatorconfig.ClassName parse_org_emftext_sdk_generatorconfig_ClassName() throws RecognitionException {
        org.emftext.sdk.generatorconfig.ClassName element =  null;
        int parse_org_emftext_sdk_generatorconfig_ClassName_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Generatorconfig.g:1914:1: (a0= 'CLASSNAME' )
            // Generatorconfig.g:1915:2: a0= 'CLASSNAME'
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_generatorconfig_ClassName630); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassName();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 22, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 22));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 22));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 22));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 22));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 22));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 22));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_sdk_generatorconfig_ClassName_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_ClassName"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_Features"
    // Generatorconfig.g:1949:1: parse_org_emftext_sdk_generatorconfig_Features returns [org.emftext.sdk.generatorconfig.Features element = null] : a0= 'FEATURES' ;
    public final org.emftext.sdk.generatorconfig.Features parse_org_emftext_sdk_generatorconfig_Features() throws RecognitionException {
        org.emftext.sdk.generatorconfig.Features element =  null;
        int parse_org_emftext_sdk_generatorconfig_Features_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Generatorconfig.g:1952:1: (a0= 'FEATURES' )
            // Generatorconfig.g:1953:2: a0= 'FEATURES'
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_generatorconfig_Features659); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatures();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 23, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 23));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 23));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 23));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 23));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 23));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 23));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_sdk_generatorconfig_Features_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_Features"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_ClassRuleReference"
    // Generatorconfig.g:1987:1: parse_org_emftext_sdk_generatorconfig_ClassRuleReference returns [org.emftext.sdk.generatorconfig.ClassRuleReference element = null] : (a0= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.generatorconfig.ClassRuleReference parse_org_emftext_sdk_generatorconfig_ClassRuleReference() throws RecognitionException {
        org.emftext.sdk.generatorconfig.ClassRuleReference element =  null;
        int parse_org_emftext_sdk_generatorconfig_ClassRuleReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Generatorconfig.g:1990:1: ( (a0= QUALIFIED_NAME ) )
            // Generatorconfig.g:1991:2: (a0= QUALIFIED_NAME )
            {
            // Generatorconfig.g:1991:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:1992:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_ClassRuleReference692); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createClassRuleReference();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE_REFERENCE__RULE), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.emftext.sdk.generatorconfig.GeneratorRule proxy = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.generatorconfig.ClassRuleReference, org.emftext.sdk.generatorconfig.GeneratorRule>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassRuleReferenceRuleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE_REFERENCE__RULE), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.CLASS_RULE_REFERENCE__RULE), proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 24, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 24));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 24));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 24));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 24));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 24));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 24));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_sdk_generatorconfig_ClassRuleReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_ClassRuleReference"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_FeatureRuleReference"
    // Generatorconfig.g:2050:1: parse_org_emftext_sdk_generatorconfig_FeatureRuleReference returns [org.emftext.sdk.generatorconfig.FeatureRuleReference element = null] : (a0= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.generatorconfig.FeatureRuleReference parse_org_emftext_sdk_generatorconfig_FeatureRuleReference() throws RecognitionException {
        org.emftext.sdk.generatorconfig.FeatureRuleReference element =  null;
        int parse_org_emftext_sdk_generatorconfig_FeatureRuleReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // Generatorconfig.g:2053:1: ( (a0= QUALIFIED_NAME ) )
            // Generatorconfig.g:2054:2: (a0= QUALIFIED_NAME )
            {
            // Generatorconfig.g:2054:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:2055:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_FeatureRuleReference732); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureRuleReference();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE_REFERENCE__RULE), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.emftext.sdk.generatorconfig.GeneratorRule proxy = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createGeneratorRule();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.generatorconfig.FeatureRuleReference, org.emftext.sdk.generatorconfig.GeneratorRule>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureRuleReferenceRuleReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE_REFERENCE__RULE), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.generatorconfig.GeneratorconfigPackage.FEATURE_RULE_REFERENCE__RULE), proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 25, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 25));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 25));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 25));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 25));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 25));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 25));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_sdk_generatorconfig_FeatureRuleReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_FeatureRuleReference"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_FeatureName"
    // Generatorconfig.g:2113:1: parse_org_emftext_sdk_generatorconfig_FeatureName returns [org.emftext.sdk.generatorconfig.FeatureName element = null] : a0= 'FEATURENAME' ;
    public final org.emftext.sdk.generatorconfig.FeatureName parse_org_emftext_sdk_generatorconfig_FeatureName() throws RecognitionException {
        org.emftext.sdk.generatorconfig.FeatureName element =  null;
        int parse_org_emftext_sdk_generatorconfig_FeatureName_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // Generatorconfig.g:2116:1: (a0= 'FEATURENAME' )
            // Generatorconfig.g:2117:2: a0= 'FEATURENAME'
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_generatorconfig_FeatureName768); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeatureName();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 26, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 26));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 26));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 26));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 26));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 26));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 26));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_sdk_generatorconfig_FeatureName_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_FeatureName"


    // $ANTLR start "parse_org_emftext_sdk_generatorconfig_Feature"
    // Generatorconfig.g:2151:1: parse_org_emftext_sdk_generatorconfig_Feature returns [org.emftext.sdk.generatorconfig.Feature element = null] : a0= 'FEATURE' ;
    public final org.emftext.sdk.generatorconfig.Feature parse_org_emftext_sdk_generatorconfig_Feature() throws RecognitionException {
        org.emftext.sdk.generatorconfig.Feature element =  null;
        int parse_org_emftext_sdk_generatorconfig_Feature_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // Generatorconfig.g:2154:1: (a0= 'FEATURE' )
            // Generatorconfig.g:2155:2: a0= 'FEATURE'
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_generatorconfig_Feature797); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.generatorconfig.GeneratorconfigFactory.eINSTANCE.createFeature();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 27, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 27));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 27));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 27));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 27));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 27));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 27));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_sdk_generatorconfig_Feature_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_generatorconfig_Feature"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_ConcreteSyntax"
    // Generatorconfig.g:2189:1: parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* ) a32= '}' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // Generatorconfig.g:2192:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* ) a32= '}' )
            // Generatorconfig.g:2193:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* ) a32= '}'
            {
            // Generatorconfig.g:2193:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==53) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Generatorconfig.g:2194:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Generatorconfig.g:2194:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Generatorconfig.g:2195:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Generatorconfig.g:2195:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Generatorconfig.g:2196:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax841);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 28, FEATURE_4));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 28, FEATURE_5));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 28));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 29, FEATURE_4));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 29, FEATURE_5));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 29));
              	
            }
            // Generatorconfig.g:2228:2: ( ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==51) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Generatorconfig.g:2229:3: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )
                    {
                    // Generatorconfig.g:2229:3: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )
                    // Generatorconfig.g:2230:4: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    {
                    // Generatorconfig.g:2230:4: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    // Generatorconfig.g:2231:5: a1_0= parse_org_emftext_sdk_concretesyntax_Abstract
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax897);
                    a1_0=parse_org_emftext_sdk_concretesyntax_Abstract();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
                      						copyLocalizationInfos(a1_0, element); 					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 30));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 31));
              	
            }
            a2=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax938); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_35, 32));
              	
            }
            // Generatorconfig.g:2271:2: (a3= QUALIFIED_NAME )
            // Generatorconfig.g:2272:3: a3= QUALIFIED_NAME
            {
            a3=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax956); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              			}
              			if (a3 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_36, 33));
              	
            }
            a4=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax977); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_37, 34));
              	
            }
            // Generatorconfig.g:2316:2: (a5= QUOTED_60_62 )
            // Generatorconfig.g:2317:3: a5= QUOTED_60_62
            {
            a5=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax995); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              			}
              			if (a5 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a5).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_38, 35));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_39, 35));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 35));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 35));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 35));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 35));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 35));
              	
            }
            // Generatorconfig.g:2359:2: ( ( (a6= QUOTED_60_62 ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==QUOTED_60_62) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Generatorconfig.g:2360:3: ( (a6= QUOTED_60_62 ) )
                    {
                    // Generatorconfig.g:2360:3: ( (a6= QUOTED_60_62 ) )
                    // Generatorconfig.g:2361:4: (a6= QUOTED_60_62 )
                    {
                    // Generatorconfig.g:2361:4: (a6= QUOTED_60_62 )
                    // Generatorconfig.g:2362:5: a6= QUOTED_60_62
                    {
                    a6=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1031); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      					}
                      					if (a6 != null) {
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
                      						tokenResolver.setOptions(getOptions());
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_39, 36));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 36));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 36));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 36));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 36));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 36));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_39, 37));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 37));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 37));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 37));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 37));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 37));
              	
            }
            // Generatorconfig.g:2411:2: ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Generatorconfig.g:2412:3: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    {
                    // Generatorconfig.g:2412:3: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    // Generatorconfig.g:2413:4: a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    {
                    a7=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1086); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_45, 38));
                      			
                    }
                    // Generatorconfig.g:2425:4: ( (a8= QUALIFIED_NAME ) )
                    // Generatorconfig.g:2426:5: (a8= QUALIFIED_NAME )
                    {
                    // Generatorconfig.g:2426:5: (a8= QUALIFIED_NAME )
                    // Generatorconfig.g:2427:6: a8= QUALIFIED_NAME
                    {
                    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1119); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      						if (terminateParsing) {
                      							throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      						}
                      						if (element == null) {
                      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      						}
                      						if (a8 != null) {
                      							org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      							tokenResolver.setOptions(getOptions());
                      							org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
                      							tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
                      							java.lang.Object resolvedObject = result.getResolvedToken();
                      							if (resolvedObject == null) {
                      								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
                      							}
                      							String resolved = (String) resolvedObject;
                      							org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                      							collectHiddenTokens(element);
                      							registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
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
                      					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 39));
                      					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 39));
                      					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 39));
                      					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 39));
                      					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 39));
                      					addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 39));
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 40));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 40));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 40));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 40));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 40));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 40));
                      			
                    }
                    // Generatorconfig.g:2479:4: ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==27) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Generatorconfig.g:2480:5: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    {
                    	    // Generatorconfig.g:2480:5: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    // Generatorconfig.g:2481:6: a9= ',' ( (a10= QUALIFIED_NAME ) )
                    	    {
                    	    a9=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1184); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_47, 41));
                    	      					
                    	    }
                    	    // Generatorconfig.g:2493:6: ( (a10= QUALIFIED_NAME ) )
                    	    // Generatorconfig.g:2494:7: (a10= QUALIFIED_NAME )
                    	    {
                    	    // Generatorconfig.g:2494:7: (a10= QUALIFIED_NAME )
                    	    // Generatorconfig.g:2495:8: a10= QUALIFIED_NAME
                    	    {
                    	    a10=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1227); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      								if (terminateParsing) {
                    	      									throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                    	      								}
                    	      								if (element == null) {
                    	      									element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      								}
                    	      								if (a10 != null) {
                    	      									org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                    	      									tokenResolver.setOptions(getOptions());
                    	      									org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
                    	      									tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), result);
                    	      									java.lang.Object resolvedObject = result.getResolvedToken();
                    	      									if (resolvedObject == null) {
                    	      										addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStopIndex());
                    	      									}
                    	      									String resolved = (String) resolvedObject;
                    	      									org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                    	      									collectHiddenTokens(element);
                    	      									registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
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
                    	      							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 42));
                    	      							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 42));
                    	      							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 42));
                    	      							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 42));
                    	      							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 42));
                    	      							addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 42));
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 43));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 43));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 43));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 43));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 43));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 43));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_46, 44));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 44));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 44));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 44));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 44));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 44));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_40, 45));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 45));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 45));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 45));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 45));
              	
            }
            // Generatorconfig.g:2570:2: ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Generatorconfig.g:2571:3: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    {
                    // Generatorconfig.g:2571:3: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    // Generatorconfig.g:2572:4: a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}'
                    {
                    a11=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1342); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_48, 46));
                      			
                    }
                    a12=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1362); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 47, FEATURE_6));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 47));
                      			
                    }
                    // Generatorconfig.g:2597:4: ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==QUALIFIED_NAME) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Generatorconfig.g:2598:5: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    {
                    	    // Generatorconfig.g:2598:5: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    // Generatorconfig.g:2599:6: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    {
                    	    // Generatorconfig.g:2599:6: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    // Generatorconfig.g:2600:7: a13_0= parse_org_emftext_sdk_concretesyntax_Import
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1403);
                    	    a13_0=parse_org_emftext_sdk_concretesyntax_Import();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (terminateParsing) {
                    	      								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 48, FEATURE_6));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 48));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 49, FEATURE_6));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 49));
                      			
                    }
                    a14=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1464); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 50));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 50));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 50));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 50));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_41, 51));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 51));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 51));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 51));
              	
            }
            // Generatorconfig.g:2655:2: ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==31) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Generatorconfig.g:2656:3: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    {
                    // Generatorconfig.g:2656:3: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    // Generatorconfig.g:2657:4: a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}'
                    {
                    a15=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1506); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a15, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_51, 52));
                      			
                    }
                    a16=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1526); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_52, 53, FEATURE_7));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_53, 53));
                      			
                    }
                    // Generatorconfig.g:2682:4: ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==QUALIFIED_NAME) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Generatorconfig.g:2683:5: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    {
                    	    // Generatorconfig.g:2683:5: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    // Generatorconfig.g:2684:6: (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';'
                    	    {
                    	    // Generatorconfig.g:2684:6: (a17_0= parse_org_emftext_sdk_concretesyntax_Option )
                    	    // Generatorconfig.g:2685:7: a17_0= parse_org_emftext_sdk_concretesyntax_Option
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1567);
                    	    a17_0=parse_org_emftext_sdk_concretesyntax_Option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (terminateParsing) {
                    	      								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_54, 54));
                    	      					
                    	    }
                    	    a18=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1605); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a18, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_52, 55, FEATURE_7));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_53, 55));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_52, 56, FEATURE_7));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_53, 56));
                      			
                    }
                    a19=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1654); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a19, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 57));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 57));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 57));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_42, 58));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 58));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 58));
              	
            }
            // Generatorconfig.g:2750:2: ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Generatorconfig.g:2751:3: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    {
                    // Generatorconfig.g:2751:3: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    // Generatorconfig.g:2752:4: a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}'
                    {
                    a20=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1696); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a20, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_55, 59));
                      			
                    }
                    a21=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1716); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a21, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 60, FEATURE_4, FEATURE_8));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 60, FEATURE_8));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_57, 60, FEATURE_8));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_58, 60, FEATURE_8));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_59, 60));
                      			
                    }
                    // Generatorconfig.g:2780:4: ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==43||LA13_0==48||LA13_0==53) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // Generatorconfig.g:2781:5: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    {
                    	    // Generatorconfig.g:2781:5: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    // Generatorconfig.g:2782:6: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';'
                    	    {
                    	    // Generatorconfig.g:2782:6: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective )
                    	    // Generatorconfig.g:2783:7: a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1757);
                    	    a22_0=parse_org_emftext_sdk_concretesyntax_TokenDirective();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (terminateParsing) {
                    	      								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 61));
                    	      					
                    	    }
                    	    a23=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1795); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a23, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 62, FEATURE_4, FEATURE_8));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 62, FEATURE_8));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_57, 62, FEATURE_8));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_58, 62, FEATURE_8));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_59, 62));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 63, FEATURE_4, FEATURE_8));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 63, FEATURE_8));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_57, 63, FEATURE_8));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_58, 63, FEATURE_8));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_59, 63));
                      			
                    }
                    a24=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1844); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a24, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 64));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 64));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_43, 65));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 65));
              	
            }
            // Generatorconfig.g:2852:2: ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==33) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Generatorconfig.g:2853:3: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    {
                    // Generatorconfig.g:2853:3: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    // Generatorconfig.g:2854:4: a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}'
                    {
                    a25=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1886); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a25, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_61, 66));
                      			
                    }
                    a26=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1906); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a26, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_62, 67, FEATURE_9));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_63, 67));
                      			
                    }
                    // Generatorconfig.g:2879:4: ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==QUOTED_34_34_92) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // Generatorconfig.g:2880:5: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    {
                    	    // Generatorconfig.g:2880:5: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    // Generatorconfig.g:2881:6: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    {
                    	    // Generatorconfig.g:2881:6: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    // Generatorconfig.g:2882:7: a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1947);
                    	    a27_0=parse_org_emftext_sdk_concretesyntax_TokenStyle();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (terminateParsing) {
                    	      								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_62, 68, FEATURE_9));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_63, 68));
                    	      					
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
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_62, 69, FEATURE_9));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_63, 69));
                      			
                    }
                    a28=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2008); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a28, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 70));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_44, 71));
              	
            }
            a29=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2041); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a29, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_64, 72));
              	
            }
            a30=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2055); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a30, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 73, FEATURE_4, FEATURE_10));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 73, FEATURE_10));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_66, 73));
              	
            }
            // Generatorconfig.g:2957:2: ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )* )
            // Generatorconfig.g:2958:3: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )*
            {
            // Generatorconfig.g:2958:3: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUALIFIED_NAME||LA17_0==53) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Generatorconfig.g:2959:4: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    {
            	    // Generatorconfig.g:2959:4: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    // Generatorconfig.g:2960:5: a31_0= parse_org_emftext_sdk_concretesyntax_Rule
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2084);
            	    a31_0=parse_org_emftext_sdk_concretesyntax_Rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			// expected elements (follow set)
              			addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 74, FEATURE_4, FEATURE_10));
              			addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 74, FEATURE_10));
              			addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_66, 74));
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_66, 75));
              	
            }
            a32=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2124); if (state.failed) return element;
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
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_ConcreteSyntax"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Import"
    // Generatorconfig.g:3003:1: parse_org_emftext_sdk_concretesyntax_Import returns [org.emftext.sdk.concretesyntax.Import element = null] : (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // Generatorconfig.g:3006:1: ( (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? )
            // Generatorconfig.g:3007:2: (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            {
            // Generatorconfig.g:3007:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:3008:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import2157); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_67, 77));
              	
            }
            a1=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Import2178); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_68, 78));
              	
            }
            // Generatorconfig.g:3052:2: (a2= QUOTED_60_62 )
            // Generatorconfig.g:3053:3: a2= QUOTED_60_62
            {
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import2196); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
              			}
              			if (a2 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.eclipse.emf.codegen.ecore.genmodel.GenPackage proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenPackage();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_69, 79));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_70, 79));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 79, FEATURE_6));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 79));
              	
            }
            // Generatorconfig.g:3092:2: ( ( (a3= QUOTED_60_62 ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==QUOTED_60_62) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Generatorconfig.g:3093:3: ( (a3= QUOTED_60_62 ) )
                    {
                    // Generatorconfig.g:3093:3: ( (a3= QUOTED_60_62 ) )
                    // Generatorconfig.g:3094:4: (a3= QUOTED_60_62 )
                    {
                    // Generatorconfig.g:3094:4: (a3= QUOTED_60_62 )
                    // Generatorconfig.g:3095:5: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import2232); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      					}
                      					if (a3 != null) {
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
                      						tokenResolver.setOptions(getOptions());
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_70, 80));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 80, FEATURE_6));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 80));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_70, 81));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 81, FEATURE_6));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 81));
              	
            }
            // Generatorconfig.g:3138:2: ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==36) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // Generatorconfig.g:3139:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    {
                    // Generatorconfig.g:3139:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    // Generatorconfig.g:3140:4: a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )?
                    {
                    a4=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_Import2287); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_71, 82));
                      			
                    }
                    a5=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_Import2307); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_72, 83));
                      			
                    }
                    // Generatorconfig.g:3164:4: (a6= QUALIFIED_NAME )
                    // Generatorconfig.g:3165:5: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import2333); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      					}
                      					if (a6 != null) {
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      						tokenResolver.setOptions(getOptions());
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
                      						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), result);
                      						java.lang.Object resolvedObject = result.getResolvedToken();
                      						if (resolvedObject == null) {
                      							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
                      						}
                      						String resolved = (String) resolvedObject;
                      						org.emftext.sdk.concretesyntax.ConcreteSyntax proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      						collectHiddenTokens(element);
                      						registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getImportConcreteSyntaxReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
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
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_73, 84));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 84, FEATURE_6));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 84));
                      			
                    }
                    // Generatorconfig.g:3203:4: ( ( (a7= QUOTED_60_62 ) ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==QUOTED_60_62) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // Generatorconfig.g:3204:5: ( (a7= QUOTED_60_62 ) )
                            {
                            // Generatorconfig.g:3204:5: ( (a7= QUOTED_60_62 ) )
                            // Generatorconfig.g:3205:6: (a7= QUOTED_60_62 )
                            {
                            // Generatorconfig.g:3205:6: (a7= QUOTED_60_62 )
                            // Generatorconfig.g:3206:7: a7= QUOTED_60_62
                            {
                            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import2387); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              							if (terminateParsing) {
                              								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                              							}
                              							if (element == null) {
                              								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                              							}
                              							if (a7 != null) {
                              								org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
                              								tokenResolver.setOptions(getOptions());
                              								org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
                              						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 85, FEATURE_6));
                              						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 85));
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 86, FEATURE_6));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 86));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_49, 87, FEATURE_6));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_50, 87));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_sdk_concretesyntax_Import_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Import"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Option"
    // Generatorconfig.g:3257:1: parse_org_emftext_sdk_concretesyntax_Option returns [org.emftext.sdk.concretesyntax.Option element = null] : (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34_92 ) ;
    public final org.emftext.sdk.concretesyntax.Option parse_org_emftext_sdk_concretesyntax_Option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;
        int parse_org_emftext_sdk_concretesyntax_Option_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // Generatorconfig.g:3260:1: ( (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34_92 ) )
            // Generatorconfig.g:3261:2: (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34_92 )
            {
            // Generatorconfig.g:3261:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:3262:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option2487); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_74, 88));
              	
            }
            a1=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_Option2508); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_75, 89));
              	
            }
            // Generatorconfig.g:3306:2: (a2= QUOTED_34_34_92 )
            // Generatorconfig.g:3307:3: a2= QUOTED_34_34_92
            {
            a2=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_Option2526); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
              			}
              			if (a2 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_54, 90));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_sdk_concretesyntax_Option_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Option"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Rule"
    // Generatorconfig.g:3341:1: parse_org_emftext_sdk_concretesyntax_Rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' ;
    public final org.emftext.sdk.concretesyntax.Rule parse_org_emftext_sdk_concretesyntax_Rule() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Rule element =  null;
        int parse_org_emftext_sdk_concretesyntax_Rule_StartIndex = input.index();
        Token a1=null;
        Token a2=null;
        Token a4=null;
        org.emftext.sdk.concretesyntax.Annotation a0_0 = null;

        org.emftext.sdk.concretesyntax.Choice a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // Generatorconfig.g:3344:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' )
            // Generatorconfig.g:3345:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';'
            {
            // Generatorconfig.g:3345:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==53) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Generatorconfig.g:3346:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Generatorconfig.g:3346:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Generatorconfig.g:3347:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Generatorconfig.g:3347:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Generatorconfig.g:3348:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule2577);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 91, FEATURE_4));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 91));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 92, FEATURE_4));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 92));
              	
            }
            // Generatorconfig.g:3378:2: (a1= QUALIFIED_NAME )
            // Generatorconfig.g:3379:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule2622); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              			}
              			if (a1 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleMetaclassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_76, 93));
              	
            }
            a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_Rule2643); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 94, FEATURE_2, FEATURE_11, FEATURE_12));
              	
            }
            // Generatorconfig.g:3441:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // Generatorconfig.g:3442:3: a3_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule2661);
            a3_0=parse_org_emftext_sdk_concretesyntax_Choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 95));
              	
            }
            a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_Rule2679); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 96, FEATURE_4, FEATURE_10));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 96, FEATURE_10));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_66, 96));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_sdk_concretesyntax_Rule_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Rule"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Sequence"
    // Generatorconfig.g:3479:1: parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence parse_org_emftext_sdk_concretesyntax_Sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;
        int parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.Definition a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // Generatorconfig.g:3482:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ )
            // Generatorconfig.g:3483:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
            {
            // Generatorconfig.g:3483:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==QUALIFIED_NAME||LA22_0==QUOTED_34_34_92||LA22_0==HEXNUMBER||(LA22_0>=18 && LA22_0<=19)||(LA22_0>=21 && LA22_0<=23)||LA22_0==42) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // Generatorconfig.g:3484:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    {
            	    // Generatorconfig.g:3484:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    // Generatorconfig.g:3485:4: a0_0= parse_org_emftext_sdk_concretesyntax_Definition
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence2717);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (terminateParsing) {
            	      					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 97, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 97));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 97));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 97));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 97));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 97));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 97));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Sequence"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Choice"
    // Generatorconfig.g:3529:1: parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice parse_org_emftext_sdk_concretesyntax_Choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;
        int parse_org_emftext_sdk_concretesyntax_Choice_StartIndex = input.index();
        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0_0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // Generatorconfig.g:3532:1: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* )
            // Generatorconfig.g:3533:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            {
            // Generatorconfig.g:3533:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            // Generatorconfig.g:3534:3: a0_0= parse_org_emftext_sdk_concretesyntax_Sequence
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2762);
            a0_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 98));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 98));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 98));
              	
            }
            // Generatorconfig.g:3557:2: ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==39) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // Generatorconfig.g:3558:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    {
            	    // Generatorconfig.g:3558:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    // Generatorconfig.g:3559:4: a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    {
            	    a1=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_Choice2789); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 99, FEATURE_2, FEATURE_11));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 99, FEATURE_2, FEATURE_11));
            	      			
            	    }
            	    // Generatorconfig.g:3585:4: (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    // Generatorconfig.g:3586:5: a2_0= parse_org_emftext_sdk_concretesyntax_Sequence
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2815);
            	    a2_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 100));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 100));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 100));
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 101));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 101));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 101));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_sdk_concretesyntax_Choice_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Choice"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_CsString"
    // Generatorconfig.g:3620:1: parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null] : (a0= QUOTED_34_34_92 ) ;
    public final org.emftext.sdk.concretesyntax.CsString parse_org_emftext_sdk_concretesyntax_CsString() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;
        int parse_org_emftext_sdk_concretesyntax_CsString_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // Generatorconfig.g:3623:1: ( (a0= QUOTED_34_34_92 ) )
            // Generatorconfig.g:3624:2: (a0= QUOTED_34_34_92 )
            {
            // Generatorconfig.g:3624:2: (a0= QUOTED_34_34_92 )
            // Generatorconfig.g:3625:3: a0= QUOTED_34_34_92
            {
            a0=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_CsString2875); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCsString();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 102, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 102));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 102));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 102));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 102));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 102));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 102));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_sdk_concretesyntax_CsString_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_CsString"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken"
    // Generatorconfig.g:3679:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element =  null;
        int parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        org.emftext.sdk.concretesyntax.Cardinality a4_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // Generatorconfig.g:3682:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Generatorconfig.g:3683:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // Generatorconfig.g:3683:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:3684:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2915); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_77, 103));
              	
            }
            a1=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2936); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_78, 104));
              	
            }
            // Generatorconfig.g:3732:2: (a2= QUALIFIED_NAME )
            // Generatorconfig.g:3733:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2954); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              			}
              			if (a2 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.emftext.sdk.concretesyntax.NormalTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_79, 105));
              	
            }
            a3=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2975); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 106, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 106, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 106, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 106, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 106));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 106));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 106));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 106));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 106));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 106));
              	
            }
            // Generatorconfig.g:3804:2: ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==44||(LA24_0>=49 && LA24_0<=50)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Generatorconfig.g:3805:3: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Generatorconfig.g:3805:3: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Generatorconfig.g:3806:4: a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2998);
                    a4_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 107, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 107));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 107));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 107));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 107));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 107));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 107));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken"
    // Generatorconfig.g:3850:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element =  null;
        int parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // Generatorconfig.g:3853:1: ( (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Generatorconfig.g:3854:2: (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // Generatorconfig.g:3854:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:3855:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken3043); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_83, 108));
              	
            }
            a1=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken3064); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_84, 109));
              	
            }
            a2=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken3078); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 110, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 110, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 110, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 110, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 110));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 110));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 110));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 110));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 110));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 110));
              	
            }
            // Generatorconfig.g:3938:2: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==44||(LA25_0>=49 && LA25_0<=50)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // Generatorconfig.g:3939:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Generatorconfig.g:3939:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Generatorconfig.g:3940:4: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken3101);
                    a3_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 111, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 111));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 111));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 111));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 111));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 111));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 111));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes"
    // Generatorconfig.g:3984:1: parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // Generatorconfig.g:3987:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Generatorconfig.g:3988:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39_92 ) a3= ',' (a4= QUOTED_39_39_92 ) ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )? a7= ']' ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // Generatorconfig.g:3988:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:3989:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3146); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_85, 112));
              	
            }
            a1=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3167); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_86, 113));
              	
            }
            // Generatorconfig.g:4037:2: (a2= QUOTED_39_39_92 )
            // Generatorconfig.g:4038:3: a2= QUOTED_39_39_92
            {
            a2=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3185); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              			}
              			if (a2 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_87, 114));
              	
            }
            a3=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3206); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_88, 115));
              	
            }
            // Generatorconfig.g:4082:2: (a4= QUOTED_39_39_92 )
            // Generatorconfig.g:4083:3: a4= QUOTED_39_39_92
            {
            a4=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3224); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              			}
              			if (a4 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_89, 116));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_90, 116));
              	
            }
            // Generatorconfig.g:4116:2: ( (a5= ',' (a6= QUOTED_39_39_92 ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==27) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // Generatorconfig.g:4117:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    {
                    // Generatorconfig.g:4117:3: (a5= ',' (a6= QUOTED_39_39_92 ) )
                    // Generatorconfig.g:4118:4: a5= ',' (a6= QUOTED_39_39_92 )
                    {
                    a5=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3254); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_91, 117));
                      			
                    }
                    // Generatorconfig.g:4130:4: (a6= QUOTED_39_39_92 )
                    // Generatorconfig.g:4131:5: a6= QUOTED_39_39_92
                    {
                    a6=(Token)match(input,QUOTED_39_39_92,FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3280); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
                      					}
                      					if (a6 != null) {
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39_92");
                      						tokenResolver.setOptions(getOptions());
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_90, 118));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_90, 119));
              	
            }
            a7=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3326); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 120, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 120, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 120, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 120, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 120));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 120));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 120));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 120));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 120));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 120));
              	
            }
            // Generatorconfig.g:4205:2: ( (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==44||(LA27_0>=49 && LA27_0<=50)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // Generatorconfig.g:4206:3: (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Generatorconfig.g:4206:3: (a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Generatorconfig.g:4207:4: a8_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3349);
                    a8_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 121, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 121));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 121));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 121));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 121));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 121));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 121));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Containment"
    // Generatorconfig.g:4251:1: parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // Generatorconfig.g:4254:1: ( (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Generatorconfig.g:4255:2: (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // Generatorconfig.g:4255:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:4256:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3394); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.eclipse.emf.codegen.ecore.genmodel.GenFeature proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenFeature();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_92, 122));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 122, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 122, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 122, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 122, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 122));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 122));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 122));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 122));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 122));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 122));
              	
            }
            // Generatorconfig.g:4316:2: ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==35) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // Generatorconfig.g:4317:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    {
                    // Generatorconfig.g:4317:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    // Generatorconfig.g:4318:4: a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    {
                    a1=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Containment3424); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_93, 123));
                      			
                    }
                    // Generatorconfig.g:4330:4: (a2= QUALIFIED_NAME )
                    // Generatorconfig.g:4331:5: a2= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3450); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                      					}
                      					if (a2 != null) {
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      						tokenResolver.setOptions(getOptions());
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
                      						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
                      						java.lang.Object resolvedObject = result.getResolvedToken();
                      						if (resolvedObject == null) {
                      							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
                      						}
                      						String resolved = (String) resolvedObject;
                      						org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                      						collectHiddenTokens(element);
                      						registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
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
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_94, 124));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 124, FEATURE_13));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 124, FEATURE_13));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 124, FEATURE_13));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 124, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 124));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 124));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 124));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 124));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 124));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 124));
                      			
                    }
                    // Generatorconfig.g:4391:4: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==27) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // Generatorconfig.g:4392:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    {
                    	    // Generatorconfig.g:4392:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    // Generatorconfig.g:4393:6: a3= ',' (a4= QUALIFIED_NAME )
                    	    {
                    	    a3=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Containment3496); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_95, 125));
                    	      					
                    	    }
                    	    // Generatorconfig.g:4405:6: (a4= QUALIFIED_NAME )
                    	    // Generatorconfig.g:4406:7: a4= QUALIFIED_NAME
                    	    {
                    	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3530); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (terminateParsing) {
                    	      								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                    	      							}
                    	      							if (element == null) {
                    	      								element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                    	      							}
                    	      							if (a4 != null) {
                    	      								org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                    	      								tokenResolver.setOptions(getOptions());
                    	      								org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
                    	      								tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), result);
                    	      								java.lang.Object resolvedObject = result.getResolvedToken();
                    	      								if (resolvedObject == null) {
                    	      									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
                    	      								}
                    	      								String resolved = (String) resolvedObject;
                    	      								org.eclipse.emf.codegen.ecore.genmodel.GenClass proxy = org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory.eINSTANCE.createGenClass();
                    	      								collectHiddenTokens(element);
                    	      								registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
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
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_94, 126));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 126, FEATURE_13));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 126, FEATURE_13));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 126, FEATURE_13));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 126, FEATURE_2));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 126));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 126));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 126));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 126));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 126));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 126));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_94, 127));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 127, FEATURE_13));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 127, FEATURE_13));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 127, FEATURE_13));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 127, FEATURE_2));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 127));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 127));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 127));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 127));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 127));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 127));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 128, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 128, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 128, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 128, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 128));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 128));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 128));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 128));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 128));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 128));
              	
            }
            // Generatorconfig.g:4527:2: ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==44||(LA30_0>=49 && LA30_0<=50)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Generatorconfig.g:4528:3: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Generatorconfig.g:4528:3: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Generatorconfig.g:4529:4: a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment3620);
                    a5_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 129, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 129));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 129));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 129));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 129));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 129));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 129));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, parse_org_emftext_sdk_concretesyntax_Containment_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Containment"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_CompoundDefinition"
    // Generatorconfig.g:4573:1: parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition parse_org_emftext_sdk_concretesyntax_CompoundDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;
        int parse_org_emftext_sdk_concretesyntax_CompoundDefinition_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1_0 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // Generatorconfig.g:4576:1: (a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // Generatorconfig.g:4577:2: a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            a0=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3661); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 130, FEATURE_2, FEATURE_11, FEATURE_14));
              	
            }
            // Generatorconfig.g:4603:2: (a1_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // Generatorconfig.g:4604:3: a1_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3679);
            a1_0=parse_org_emftext_sdk_concretesyntax_Choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 131));
              	
            }
            a2=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3697); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_80, 132, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_81, 132, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_82, 132, FEATURE_13));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 132, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 132));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 132));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 132));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 132));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 132));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 132));
              	
            }
            // Generatorconfig.g:4660:2: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==44||(LA31_0>=49 && LA31_0<=50)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Generatorconfig.g:4661:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // Generatorconfig.g:4661:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // Generatorconfig.g:4662:4: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3720);
                    a3_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (terminateParsing) {
                      					throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 133, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 133));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 133));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 133));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 133));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 133));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 133));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, parse_org_emftext_sdk_concretesyntax_CompoundDefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_CompoundDefinition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_WhiteSpaces"
    // Generatorconfig.g:4706:1: parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : (a0= HEXNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces parse_org_emftext_sdk_concretesyntax_WhiteSpaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;
        int parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }
            // Generatorconfig.g:4709:1: ( (a0= HEXNUMBER ) )
            // Generatorconfig.g:4710:2: (a0= HEXNUMBER )
            {
            // Generatorconfig.g:4710:2: (a0= HEXNUMBER )
            // Generatorconfig.g:4711:3: a0= HEXNUMBER
            {
            a0=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces3765); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createWhiteSpaces();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 134, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 134));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 134));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 134));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 134));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 134));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 134));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_WhiteSpaces"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_LineBreak"
    // Generatorconfig.g:4765:1: parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= '!' (a1= NUMBER ) ;
    public final org.emftext.sdk.concretesyntax.LineBreak parse_org_emftext_sdk_concretesyntax_LineBreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;
        int parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }
            // Generatorconfig.g:4768:1: (a0= '!' (a1= NUMBER ) )
            // Generatorconfig.g:4769:2: a0= '!' (a1= NUMBER )
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_LineBreak3801); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_96, 135));
              	
            }
            // Generatorconfig.g:4781:2: (a1= NUMBER )
            // Generatorconfig.g:4782:3: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak3819); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
              			}
              			if (a1 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NUMBER");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 136, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 136));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 136));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 136));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 136));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 136));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 136));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_LineBreak"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition"
    // Generatorconfig.g:4836:1: parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition returns [org.emftext.sdk.concretesyntax.NormalTokenDefinition element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }
            // Generatorconfig.g:4839:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )? )
            // Generatorconfig.g:4840:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            {
            // Generatorconfig.g:4840:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==53) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // Generatorconfig.g:4841:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // Generatorconfig.g:4841:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // Generatorconfig.g:4842:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // Generatorconfig.g:4842:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // Generatorconfig.g:4843:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3870);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
            	      					}
            	      					if (element == null) {
            	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
            	      					}
            	      					if (a0_0 != null) {
            	      						if (a0_0 != null) {
            	      							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ANNOTATIONS, a0_0);
            	      							completedElement(a0_0);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos(a0_0, element); 					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 137, FEATURE_4));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 137));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 138, FEATURE_4));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 138));
              	
            }
            a1=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3911); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_97, 139));
              	
            }
            // Generatorconfig.g:4885:2: (a2= QUALIFIED_NAME )
            // Generatorconfig.g:4886:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3929); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
              			}
              			if (a2 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String)resolvedObject;
              				if (resolved != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), resolved);
              					completedElement(resolved);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_98, 140, FEATURE_15));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_99, 140, FEATURE_15));
              	
            }
            // Generatorconfig.g:4919:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Generatorconfig.g:4920:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3954);
            a3_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
              			}
              			if (a3_0 != null) {
              				if (a3_0 != null) {
              					addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS, a3_0);
              					completedElement(a3_0);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos(a3_0, element); 			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 141));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 141));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 141));
              	
            }
            // Generatorconfig.g:4943:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==44) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // Generatorconfig.g:4944:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Generatorconfig.g:4944:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Generatorconfig.g:4945:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    {
            	    a4=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3981); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_98, 142, FEATURE_15));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_99, 142, FEATURE_15));
            	      			
            	    }
            	    // Generatorconfig.g:4958:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Generatorconfig.g:4959:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4007);
            	    a5_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
            	      					}
            	      					if (element == null) {
            	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
            	      					}
            	      					if (a5_0 != null) {
            	      						if (a5_0 != null) {
            	      							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS, a5_0);
            	      							completedElement(a5_0);
            	      						}
            	      						collectHiddenTokens(element);
            	      						copyLocalizationInfos(a5_0, element); 					}
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 143));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 143));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 143));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 144));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 144));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 144));
              	
            }
            // Generatorconfig.g:4991:2: ( (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==45) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // Generatorconfig.g:4992:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    {
                    // Generatorconfig.g:4992:3: (a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME ) )
                    // Generatorconfig.g:4993:4: a6= 'COLLECT' a7= 'IN' (a8= QUALIFIED_NAME )
                    {
                    a6=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4057); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_102, 145));
                      			
                    }
                    a7=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4077); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_103, 146));
                      			
                    }
                    // Generatorconfig.g:5017:4: (a8= QUALIFIED_NAME )
                    // Generatorconfig.g:5018:5: a8= QUALIFIED_NAME
                    {
                    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4103); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
                      					}
                      					if (a8 != null) {
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
                      						tokenResolver.setOptions(getOptions());
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
                      						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), result);
                      						java.lang.Object resolvedObject = result.getResolvedToken();
                      						if (resolvedObject == null) {
                      							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
                      						}
                      						java.lang.String resolved = (java.lang.String)resolvedObject;
                      						if (resolved != null) {
                      							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), resolved);
                      							completedElement(resolved);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
                      					}
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 147));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 148));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition"
    // Generatorconfig.g:5059:1: parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition returns [org.emftext.sdk.concretesyntax.PartialTokenDefinition element = null] : a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }
            // Generatorconfig.g:5062:1: (a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )* )
            // Generatorconfig.g:5063:2: a0= 'DEFINE' a1= 'FRAGMENT' (a2= QUALIFIED_NAME ) (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4164); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_104, 149));
              	
            }
            a1=(Token)match(input,47,FOLLOW_47_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4178); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_105, 150));
              	
            }
            // Generatorconfig.g:5087:2: (a2= QUALIFIED_NAME )
            // Generatorconfig.g:5088:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4196); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
              			}
              			if (a2 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_98, 151, FEATURE_15));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_99, 151, FEATURE_15));
              	
            }
            // Generatorconfig.g:5121:2: (a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            // Generatorconfig.g:5122:3: a3_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4221);
            a3_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 152));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 152));
              	
            }
            // Generatorconfig.g:5144:2: ( (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==44) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // Generatorconfig.g:5145:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    {
            	    // Generatorconfig.g:5145:3: (a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart ) )
            	    // Generatorconfig.g:5146:4: a4= '+' (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    {
            	    a4=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4248); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_98, 153, FEATURE_15));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_99, 153, FEATURE_15));
            	      			
            	    }
            	    // Generatorconfig.g:5159:4: (a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart )
            	    // Generatorconfig.g:5160:5: a5_0= parse_org_emftext_sdk_concretesyntax_RegexPart
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4274);
            	    a5_0=parse_org_emftext_sdk_concretesyntax_RegexPart();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 154));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 154));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 155));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 155));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective"
    // Generatorconfig.g:5192:1: parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null] : a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.TokenPriorityDirective parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenPriorityDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }
            // Generatorconfig.g:5195:1: (a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) )
            // Generatorconfig.g:5196:2: a0= 'PRIORITIZE' (a1= QUALIFIED_NAME )
            {
            a0=(Token)match(input,48,FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective4330); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_107, 156));
              	
            }
            // Generatorconfig.g:5208:2: (a1= QUALIFIED_NAME )
            // Generatorconfig.g:5209:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective4348); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
              			}
              			if (a1 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.emftext.sdk.concretesyntax.NormalTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.CompleteTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 157));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_AtomicRegex"
    // Generatorconfig.g:5247:1: parse_org_emftext_sdk_concretesyntax_AtomicRegex returns [org.emftext.sdk.concretesyntax.AtomicRegex element = null] : (a0= QUOTED_36_36 ) ;
    public final org.emftext.sdk.concretesyntax.AtomicRegex parse_org_emftext_sdk_concretesyntax_AtomicRegex() throws RecognitionException {
        org.emftext.sdk.concretesyntax.AtomicRegex element =  null;
        int parse_org_emftext_sdk_concretesyntax_AtomicRegex_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }
            // Generatorconfig.g:5250:1: ( (a0= QUOTED_36_36 ) )
            // Generatorconfig.g:5251:2: (a0= QUOTED_36_36 )
            {
            // Generatorconfig.g:5251:2: (a0= QUOTED_36_36 )
            // Generatorconfig.g:5252:3: a0= QUOTED_36_36
            {
            a0=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_AtomicRegex4388); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAtomicRegex();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_36_36");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 158));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 158));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 158));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 158));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, parse_org_emftext_sdk_concretesyntax_AtomicRegex_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_AtomicRegex"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_RegexReference"
    // Generatorconfig.g:5289:1: parse_org_emftext_sdk_concretesyntax_RegexReference returns [org.emftext.sdk.concretesyntax.RegexReference element = null] : (a0= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.RegexReference parse_org_emftext_sdk_concretesyntax_RegexReference() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexReference element =  null;
        int parse_org_emftext_sdk_concretesyntax_RegexReference_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }
            // Generatorconfig.g:5292:1: ( (a0= QUALIFIED_NAME ) )
            // Generatorconfig.g:5293:2: (a0= QUALIFIED_NAME )
            {
            // Generatorconfig.g:5293:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:5294:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_RegexReference4428); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRegexReference();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), result);
              				java.lang.Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
              				}
              				String resolved = (String) resolvedObject;
              				org.emftext.sdk.concretesyntax.PartialTokenDefinition proxy = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPartialTokenDefinition();
              				collectHiddenTokens(element);
              				registerContextDependentProxy(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.RegexReference, org.emftext.sdk.concretesyntax.AbstractTokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRegexReferenceTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), resolved, proxy);
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_100, 159));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_101, 159));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_60, 159));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_106, 159));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, parse_org_emftext_sdk_concretesyntax_RegexReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_RegexReference"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_PLUS"
    // Generatorconfig.g:5335:1: parse_org_emftext_sdk_concretesyntax_PLUS returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS parse_org_emftext_sdk_concretesyntax_PLUS() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;
        int parse_org_emftext_sdk_concretesyntax_PLUS_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }
            // Generatorconfig.g:5338:1: (a0= '+' )
            // Generatorconfig.g:5339:2: a0= '+'
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PLUS4464); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPLUS();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 160, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 160));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 160));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 160));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 160));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 160));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 160));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, parse_org_emftext_sdk_concretesyntax_PLUS_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_PLUS"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_STAR"
    // Generatorconfig.g:5373:1: parse_org_emftext_sdk_concretesyntax_STAR returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR parse_org_emftext_sdk_concretesyntax_STAR() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;
        int parse_org_emftext_sdk_concretesyntax_STAR_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }
            // Generatorconfig.g:5376:1: (a0= '*' )
            // Generatorconfig.g:5377:2: a0= '*'
            {
            a0=(Token)match(input,49,FOLLOW_49_in_parse_org_emftext_sdk_concretesyntax_STAR4493); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createSTAR();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 161, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 161));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 161));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 161));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 161));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 161));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 161));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, parse_org_emftext_sdk_concretesyntax_STAR_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_STAR"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_QUESTIONMARK"
    // Generatorconfig.g:5411:1: parse_org_emftext_sdk_concretesyntax_QUESTIONMARK returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK parse_org_emftext_sdk_concretesyntax_QUESTIONMARK() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;
        int parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }
            // Generatorconfig.g:5414:1: (a0= '?' )
            // Generatorconfig.g:5415:2: a0= '?'
            {
            a0=(Token)match(input,50,FOLLOW_50_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK4522); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createQUESTIONMARK();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_4, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_5, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_6, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_7, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_8, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_9, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_10, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_11, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_12, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_13, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_14, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_15, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_16, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_17, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_18, 162, FEATURE_2));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_19, 162));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_22, 162));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_25, 162));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_29, 162));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_30, 162));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_31, 162));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_QUESTIONMARK"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Abstract"
    // Generatorconfig.g:5449:1: parse_org_emftext_sdk_concretesyntax_Abstract returns [org.emftext.sdk.concretesyntax.Abstract element = null] : a0= 'ABSTRACT' ;
    public final org.emftext.sdk.concretesyntax.Abstract parse_org_emftext_sdk_concretesyntax_Abstract() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Abstract element =  null;
        int parse_org_emftext_sdk_concretesyntax_Abstract_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }
            // Generatorconfig.g:5452:1: (a0= 'ABSTRACT' )
            // Generatorconfig.g:5453:2: a0= 'ABSTRACT'
            {
            a0=(Token)match(input,51,FOLLOW_51_in_parse_org_emftext_sdk_concretesyntax_Abstract4551); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAbstract();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 163));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, parse_org_emftext_sdk_concretesyntax_Abstract_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Abstract"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenStyle"
    // Generatorconfig.g:5467:1: parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null] : (a0= QUOTED_34_34_92 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }
            // Generatorconfig.g:5470:1: ( (a0= QUOTED_34_34_92 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' )
            // Generatorconfig.g:5471:2: (a0= QUOTED_34_34_92 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';'
            {
            // Generatorconfig.g:5471:2: (a0= QUOTED_34_34_92 )
            // Generatorconfig.g:5472:3: a0= QUOTED_34_34_92
            {
            a0=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4584); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_108, 164));
              	
            }
            a1=(Token)match(input,52,FOLLOW_52_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4605); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_109, 165));
              	
            }
            // Generatorconfig.g:5516:2: (a2= HEXNUMBER )
            // Generatorconfig.g:5517:3: a2= HEXNUMBER
            {
            a2=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4623); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              			}
              			if (a2 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("HEXNUMBER");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_110, 166));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_111, 166));
              	
            }
            // Generatorconfig.g:5550:2: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==27) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Generatorconfig.g:5551:3: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    {
            	    // Generatorconfig.g:5551:3: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    // Generatorconfig.g:5552:4: a3= ',' (a4= QUALIFIED_NAME )
            	    {
            	    a3=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4653); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_112, 167));
            	      			
            	    }
            	    // Generatorconfig.g:5564:4: (a4= QUALIFIED_NAME )
            	    // Generatorconfig.g:5565:5: a4= QUALIFIED_NAME
            	    {
            	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4679); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
            	      					}
            	      					if (element == null) {
            	      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            	      					}
            	      					if (a4 != null) {
            	      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
            	      						tokenResolver.setOptions(getOptions());
            	      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_110, 168));
            	      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_111, 168));
            	      			
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_110, 169));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_111, 169));
              	
            }
            a5=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4725); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_62, 170, FEATURE_9));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_63, 170));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, parse_org_emftext_sdk_concretesyntax_TokenStyle_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenStyle"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Annotation"
    // Generatorconfig.g:5621:1: parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null] : a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return element; }
            // Generatorconfig.g:5624:1: (a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? )
            // Generatorconfig.g:5625:2: a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            {
            a0=(Token)match(input,53,FOLLOW_53_in_parse_org_emftext_sdk_concretesyntax_Annotation4754); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_113, 171));
              	
            }
            // Generatorconfig.g:5637:2: (a1= QUALIFIED_NAME )
            // Generatorconfig.g:5638:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation4772); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
              			}
              			if (a1 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_114, 172));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 172, FEATURE_4));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 172, FEATURE_5));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 172));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 172));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 172));
              	
            }
            // Generatorconfig.g:5675:2: ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==19) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // Generatorconfig.g:5676:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    {
                    // Generatorconfig.g:5676:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    // Generatorconfig.g:5677:4: a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')'
                    {
                    a2=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_Annotation4802); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_115, 173, FEATURE_16));
                      			
                    }
                    // Generatorconfig.g:5689:4: (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    // Generatorconfig.g:5690:5: a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4828);
                    a3_0=parse_org_emftext_sdk_concretesyntax_KeyValuePair();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 174));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 174));
                      			
                    }
                    // Generatorconfig.g:5712:4: ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==27) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // Generatorconfig.g:5713:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    {
                    	    // Generatorconfig.g:5713:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    // Generatorconfig.g:5714:6: a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    {
                    	    a4=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Annotation4869); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_115, 175, FEATURE_16));
                    	      					
                    	    }
                    	    // Generatorconfig.g:5726:6: (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    // Generatorconfig.g:5727:7: a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4903);
                    	    a5_0=parse_org_emftext_sdk_concretesyntax_KeyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (terminateParsing) {
                    	      								throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
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
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 176));
                    	      						addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 176));
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 177));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 177));
                      			
                    }
                    a6=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_Annotation4964); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 178, FEATURE_4));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 178, FEATURE_5));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 178));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 178));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 178));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_32, 179, FEATURE_4));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_33, 179, FEATURE_5));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_34, 179));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_65, 179));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_56, 179));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, parse_org_emftext_sdk_concretesyntax_Annotation_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Annotation"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_KeyValuePair"
    // Generatorconfig.g:5786:1: parse_org_emftext_sdk_concretesyntax_KeyValuePair returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null] : (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )? ;
    public final org.emftext.sdk.concretesyntax.KeyValuePair parse_org_emftext_sdk_concretesyntax_KeyValuePair() throws RecognitionException {
        org.emftext.sdk.concretesyntax.KeyValuePair element =  null;
        int parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return element; }
            // Generatorconfig.g:5789:1: ( (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )? )
            // Generatorconfig.g:5790:2: (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )?
            {
            // Generatorconfig.g:5790:2: (a0= QUALIFIED_NAME )
            // Generatorconfig.g:5791:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5016); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
              			}
              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
              			}
              			if (a0 != null) {
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUALIFIED_NAME");
              				tokenResolver.setOptions(getOptions());
              				org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_118, 180));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 180));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 180));
              	
            }
            // Generatorconfig.g:5825:2: ( (a1= '=' (a2= QUOTED_34_34_92 ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==38) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // Generatorconfig.g:5826:3: (a1= '=' (a2= QUOTED_34_34_92 ) )
                    {
                    // Generatorconfig.g:5826:3: (a1= '=' (a2= QUOTED_34_34_92 ) )
                    // Generatorconfig.g:5827:4: a1= '=' (a2= QUOTED_34_34_92 )
                    {
                    a1=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5046); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_119, 181));
                      			
                    }
                    // Generatorconfig.g:5839:4: (a2= QUOTED_34_34_92 )
                    // Generatorconfig.g:5840:5: a2= QUOTED_34_34_92
                    {
                    a2=(Token)match(input,QUOTED_34_34_92,FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5072); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
                      					}
                      					if (a2 != null) {
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34_92");
                      						tokenResolver.setOptions(getOptions());
                      						org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolveResult result = getFreshTokenResolveResult();
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
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 182));
                      				addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 182));
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_116, 183));
              		addExpectedElement(new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigExpectedTerminal(TERMINAL_117, 183));
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_KeyValuePair"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_TokenDirective"
    // Generatorconfig.g:5883:1: parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null] : (c0= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition | c1= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition | c2= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective );
    public final org.emftext.sdk.concretesyntax.TokenDirective parse_org_emftext_sdk_concretesyntax_TokenDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.NormalTokenDefinition c0 = null;

        org.emftext.sdk.concretesyntax.PartialTokenDefinition c1 = null;

        org.emftext.sdk.concretesyntax.TokenPriorityDirective c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return element; }
            // Generatorconfig.g:5884:1: (c0= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition | c1= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition | c2= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt40=1;
                }
                break;
            case 43:
                {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==QUALIFIED_NAME) ) {
                    alt40=1;
                }
                else if ( (LA40_2==47) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;
                }
                }
                break;
            case 48:
                {
                alt40=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // Generatorconfig.g:5885:2: c0= parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5129);
                    c0=parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Generatorconfig.g:5886:4: c1= parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5139);
                    c1=parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Generatorconfig.g:5887:4: c2= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5149);
                    c2=parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 39, parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_TokenDirective"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Definition"
    // Generatorconfig.g:5891:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_generatorconfig_FeatureReference | c1= parse_org_emftext_sdk_generatorconfig_ClassName | c2= parse_org_emftext_sdk_generatorconfig_Features | c3= parse_org_emftext_sdk_generatorconfig_ClassRuleReference | c4= parse_org_emftext_sdk_generatorconfig_FeatureRuleReference | c5= parse_org_emftext_sdk_generatorconfig_FeatureName | c6= parse_org_emftext_sdk_generatorconfig_Feature | c7= parse_org_emftext_sdk_concretesyntax_CsString | c8= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c9= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c10= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c11= parse_org_emftext_sdk_concretesyntax_Containment | c12= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c13= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c14= parse_org_emftext_sdk_concretesyntax_LineBreak );
    public final org.emftext.sdk.concretesyntax.Definition parse_org_emftext_sdk_concretesyntax_Definition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Definition element =  null;
        int parse_org_emftext_sdk_concretesyntax_Definition_StartIndex = input.index();
        org.emftext.sdk.generatorconfig.FeatureReference c0 = null;

        org.emftext.sdk.generatorconfig.ClassName c1 = null;

        org.emftext.sdk.generatorconfig.Features c2 = null;

        org.emftext.sdk.generatorconfig.ClassRuleReference c3 = null;

        org.emftext.sdk.generatorconfig.FeatureRuleReference c4 = null;

        org.emftext.sdk.generatorconfig.FeatureName c5 = null;

        org.emftext.sdk.generatorconfig.Feature c6 = null;

        org.emftext.sdk.concretesyntax.CsString c7 = null;

        org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken c8 = null;

        org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken c9 = null;

        org.emftext.sdk.concretesyntax.PlaceholderInQuotes c10 = null;

        org.emftext.sdk.concretesyntax.Containment c11 = null;

        org.emftext.sdk.concretesyntax.CompoundDefinition c12 = null;

        org.emftext.sdk.concretesyntax.WhiteSpaces c13 = null;

        org.emftext.sdk.concretesyntax.LineBreak c14 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return element; }
            // Generatorconfig.g:5892:1: (c0= parse_org_emftext_sdk_generatorconfig_FeatureReference | c1= parse_org_emftext_sdk_generatorconfig_ClassName | c2= parse_org_emftext_sdk_generatorconfig_Features | c3= parse_org_emftext_sdk_generatorconfig_ClassRuleReference | c4= parse_org_emftext_sdk_generatorconfig_FeatureRuleReference | c5= parse_org_emftext_sdk_generatorconfig_FeatureName | c6= parse_org_emftext_sdk_generatorconfig_Feature | c7= parse_org_emftext_sdk_concretesyntax_CsString | c8= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c9= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c10= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c11= parse_org_emftext_sdk_concretesyntax_Containment | c12= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c13= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c14= parse_org_emftext_sdk_concretesyntax_LineBreak )
            int alt41=15;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // Generatorconfig.g:5893:2: c0= parse_org_emftext_sdk_generatorconfig_FeatureReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureReference_in_parse_org_emftext_sdk_concretesyntax_Definition5170);
                    c0=parse_org_emftext_sdk_generatorconfig_FeatureReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Generatorconfig.g:5894:4: c1= parse_org_emftext_sdk_generatorconfig_ClassName
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassName_in_parse_org_emftext_sdk_concretesyntax_Definition5180);
                    c1=parse_org_emftext_sdk_generatorconfig_ClassName();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Generatorconfig.g:5895:4: c2= parse_org_emftext_sdk_generatorconfig_Features
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_Features_in_parse_org_emftext_sdk_concretesyntax_Definition5190);
                    c2=parse_org_emftext_sdk_generatorconfig_Features();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 4 :
                    // Generatorconfig.g:5896:4: c3= parse_org_emftext_sdk_generatorconfig_ClassRuleReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassRuleReference_in_parse_org_emftext_sdk_concretesyntax_Definition5200);
                    c3=parse_org_emftext_sdk_generatorconfig_ClassRuleReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 5 :
                    // Generatorconfig.g:5897:4: c4= parse_org_emftext_sdk_generatorconfig_FeatureRuleReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureRuleReference_in_parse_org_emftext_sdk_concretesyntax_Definition5210);
                    c4=parse_org_emftext_sdk_generatorconfig_FeatureRuleReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 6 :
                    // Generatorconfig.g:5898:4: c5= parse_org_emftext_sdk_generatorconfig_FeatureName
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureName_in_parse_org_emftext_sdk_concretesyntax_Definition5220);
                    c5=parse_org_emftext_sdk_generatorconfig_FeatureName();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 7 :
                    // Generatorconfig.g:5899:4: c6= parse_org_emftext_sdk_generatorconfig_Feature
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_Feature_in_parse_org_emftext_sdk_concretesyntax_Definition5230);
                    c6=parse_org_emftext_sdk_generatorconfig_Feature();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c6; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 8 :
                    // Generatorconfig.g:5900:4: c7= parse_org_emftext_sdk_concretesyntax_CsString
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition5240);
                    c7=parse_org_emftext_sdk_concretesyntax_CsString();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c7; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 9 :
                    // Generatorconfig.g:5901:4: c8= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition5250);
                    c8=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c8; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 10 :
                    // Generatorconfig.g:5902:4: c9= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition5260);
                    c9=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c9; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 11 :
                    // Generatorconfig.g:5903:4: c10= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition5270);
                    c10=parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c10; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 12 :
                    // Generatorconfig.g:5904:4: c11= parse_org_emftext_sdk_concretesyntax_Containment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition5280);
                    c11=parse_org_emftext_sdk_concretesyntax_Containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c11; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 13 :
                    // Generatorconfig.g:5905:4: c12= parse_org_emftext_sdk_concretesyntax_CompoundDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition5290);
                    c12=parse_org_emftext_sdk_concretesyntax_CompoundDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c12; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 14 :
                    // Generatorconfig.g:5906:4: c13= parse_org_emftext_sdk_concretesyntax_WhiteSpaces
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition5300);
                    c13=parse_org_emftext_sdk_concretesyntax_WhiteSpaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c13; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 15 :
                    // Generatorconfig.g:5907:4: c14= parse_org_emftext_sdk_concretesyntax_LineBreak
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition5310);
                    c14=parse_org_emftext_sdk_concretesyntax_LineBreak();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c14; /* this is a subclass or expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 40, parse_org_emftext_sdk_concretesyntax_Definition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Definition"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_Cardinality"
    // Generatorconfig.g:5911:1: parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK );
    public final org.emftext.sdk.concretesyntax.Cardinality parse_org_emftext_sdk_concretesyntax_Cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;
        int parse_org_emftext_sdk_concretesyntax_Cardinality_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return element; }
            // Generatorconfig.g:5912:1: (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK )
            int alt42=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt42=1;
                }
                break;
            case 49:
                {
                alt42=2;
                }
                break;
            case 50:
                {
                alt42=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // Generatorconfig.g:5913:2: c0= parse_org_emftext_sdk_concretesyntax_PLUS
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality5331);
                    c0=parse_org_emftext_sdk_concretesyntax_PLUS();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Generatorconfig.g:5914:4: c1= parse_org_emftext_sdk_concretesyntax_STAR
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality5341);
                    c1=parse_org_emftext_sdk_concretesyntax_STAR();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Generatorconfig.g:5915:4: c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality5351);
                    c2=parse_org_emftext_sdk_concretesyntax_QUESTIONMARK();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 41, parse_org_emftext_sdk_concretesyntax_Cardinality_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_Cardinality"


    // $ANTLR start "parse_org_emftext_sdk_concretesyntax_RegexPart"
    // Generatorconfig.g:5919:1: parse_org_emftext_sdk_concretesyntax_RegexPart returns [org.emftext.sdk.concretesyntax.RegexPart element = null] : (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex | c1= parse_org_emftext_sdk_concretesyntax_RegexReference );
    public final org.emftext.sdk.concretesyntax.RegexPart parse_org_emftext_sdk_concretesyntax_RegexPart() throws RecognitionException {
        org.emftext.sdk.concretesyntax.RegexPart element =  null;
        int parse_org_emftext_sdk_concretesyntax_RegexPart_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.AtomicRegex c0 = null;

        org.emftext.sdk.concretesyntax.RegexReference c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return element; }
            // Generatorconfig.g:5920:1: (c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex | c1= parse_org_emftext_sdk_concretesyntax_RegexReference )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==QUOTED_36_36) ) {
                alt43=1;
            }
            else if ( (LA43_0==QUALIFIED_NAME) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // Generatorconfig.g:5921:2: c0= parse_org_emftext_sdk_concretesyntax_AtomicRegex
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_AtomicRegex_in_parse_org_emftext_sdk_concretesyntax_RegexPart5372);
                    c0=parse_org_emftext_sdk_concretesyntax_AtomicRegex();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Generatorconfig.g:5922:4: c1= parse_org_emftext_sdk_concretesyntax_RegexReference
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexReference_in_parse_org_emftext_sdk_concretesyntax_RegexPart5382);
                    c1=parse_org_emftext_sdk_concretesyntax_RegexReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or expression choice */ 
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
            if ( state.backtracking>0 ) { memoize(input, 42, parse_org_emftext_sdk_concretesyntax_RegexPart_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_sdk_concretesyntax_RegexPart"

    // $ANTLR start synpred43_Generatorconfig
    public final void synpred43_Generatorconfig_fragment() throws RecognitionException {   
        org.emftext.sdk.generatorconfig.FeatureReference c0 = null;


        // Generatorconfig.g:5893:2: (c0= parse_org_emftext_sdk_generatorconfig_FeatureReference )
        // Generatorconfig.g:5893:2: c0= parse_org_emftext_sdk_generatorconfig_FeatureReference
        {
        pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureReference_in_synpred43_Generatorconfig5170);
        c0=parse_org_emftext_sdk_generatorconfig_FeatureReference();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_Generatorconfig

    // $ANTLR start synpred46_Generatorconfig
    public final void synpred46_Generatorconfig_fragment() throws RecognitionException {   
        org.emftext.sdk.generatorconfig.ClassRuleReference c3 = null;


        // Generatorconfig.g:5896:4: (c3= parse_org_emftext_sdk_generatorconfig_ClassRuleReference )
        // Generatorconfig.g:5896:4: c3= parse_org_emftext_sdk_generatorconfig_ClassRuleReference
        {
        pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassRuleReference_in_synpred46_Generatorconfig5200);
        c3=parse_org_emftext_sdk_generatorconfig_ClassRuleReference();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_Generatorconfig

    // $ANTLR start synpred47_Generatorconfig
    public final void synpred47_Generatorconfig_fragment() throws RecognitionException {   
        org.emftext.sdk.generatorconfig.FeatureRuleReference c4 = null;


        // Generatorconfig.g:5897:4: (c4= parse_org_emftext_sdk_generatorconfig_FeatureRuleReference )
        // Generatorconfig.g:5897:4: c4= parse_org_emftext_sdk_generatorconfig_FeatureRuleReference
        {
        pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureRuleReference_in_synpred47_Generatorconfig5210);
        c4=parse_org_emftext_sdk_generatorconfig_FeatureRuleReference();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_Generatorconfig

    // $ANTLR start synpred49_Generatorconfig
    public final void synpred49_Generatorconfig_fragment() throws RecognitionException {   
        org.emftext.sdk.generatorconfig.Feature c6 = null;


        // Generatorconfig.g:5899:4: (c6= parse_org_emftext_sdk_generatorconfig_Feature )
        // Generatorconfig.g:5899:4: c6= parse_org_emftext_sdk_generatorconfig_Feature
        {
        pushFollow(FOLLOW_parse_org_emftext_sdk_generatorconfig_Feature_in_synpred49_Generatorconfig5230);
        c6=parse_org_emftext_sdk_generatorconfig_Feature();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_Generatorconfig

    // $ANTLR start synpred54_Generatorconfig
    public final void synpred54_Generatorconfig_fragment() throws RecognitionException {   
        org.emftext.sdk.concretesyntax.Containment c11 = null;


        // Generatorconfig.g:5904:4: (c11= parse_org_emftext_sdk_concretesyntax_Containment )
        // Generatorconfig.g:5904:4: c11= parse_org_emftext_sdk_concretesyntax_Containment
        {
        pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_synpred54_Generatorconfig5280);
        c11=parse_org_emftext_sdk_concretesyntax_Containment();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_Generatorconfig

    // Delegated rules

    public final boolean synpred49_Generatorconfig() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Generatorconfig_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_Generatorconfig() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_Generatorconfig_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_Generatorconfig() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_Generatorconfig_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_Generatorconfig() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_Generatorconfig_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_Generatorconfig() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_Generatorconfig_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA41 dfa41 = new DFA41(this);
    static final String DFA41_eotS =
        "\26\uffff";
    static final String DFA41_eofS =
        "\1\uffff\1\12\24\uffff";
    static final String DFA41_minS =
        "\2\4\2\uffff\1\50\6\uffff\2\4\3\uffff\1\4\3\uffff\1\0\1\uffff";
    static final String DFA41_maxS =
        "\2\52\2\uffff\1\50\6\uffff\1\52\1\51\3\uffff\1\62\3\uffff\1\0\1"+
        "\uffff";
    static final String DFA41_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\6\1\10\1\15\1\16\1\17\1\7\2\uffff\1"+
        "\4\1\5\1\14\1\uffff\1\11\1\12\1\13\1\uffff\1\1";
    static final String DFA41_specialS =
        "\4\uffff\1\0\17\uffff\1\1\1\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\4\1\uffff\1\6\1\uffff\1\10\11\uffff\1\1\1\7\1\uffff\1\2"+
            "\1\3\1\5\22\uffff\1\11",
            "\1\12\1\uffff\1\12\1\uffff\1\12\6\uffff\1\12\2\uffff\1\12"+
            "\1\13\4\12\17\uffff\1\12\2\uffff\1\12",
            "",
            "",
            "\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20\1\uffff\1\12\1\uffff\1\12\11\uffff\2\12\1\uffff\3\12"+
            "\22\uffff\1\12",
            "\1\21\2\uffff\1\23\41\uffff\1\22",
            "",
            "",
            "",
            "\1\12\1\uffff\1\12\1\uffff\1\12\11\uffff\2\12\1\24\3\12\13"+
            "\uffff\1\12\3\uffff\2\12\1\uffff\1\12\1\uffff\1\12\4\uffff\2"+
            "\12",
            "",
            "",
            "",
            "\1\uffff",
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "5891:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_generatorconfig_FeatureReference | c1= parse_org_emftext_sdk_generatorconfig_ClassName | c2= parse_org_emftext_sdk_generatorconfig_Features | c3= parse_org_emftext_sdk_generatorconfig_ClassRuleReference | c4= parse_org_emftext_sdk_generatorconfig_FeatureRuleReference | c5= parse_org_emftext_sdk_generatorconfig_FeatureName | c6= parse_org_emftext_sdk_generatorconfig_Feature | c7= parse_org_emftext_sdk_concretesyntax_CsString | c8= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c9= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c10= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c11= parse_org_emftext_sdk_concretesyntax_Containment | c12= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c13= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c14= parse_org_emftext_sdk_concretesyntax_LineBreak );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_4 = input.LA(1);

                         
                        int index41_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA41_4==40) ) {s = 12;}

                        else if ( (synpred46_Generatorconfig()) ) {s = 13;}

                        else if ( (synpred47_Generatorconfig()) ) {s = 14;}

                        else if ( (synpred54_Generatorconfig()) ) {s = 15;}

                         
                        input.seek(index41_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA41_20 = input.LA(1);

                         
                        int index41_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_Generatorconfig()) ) {s = 21;}

                        else if ( (synpred49_Generatorconfig()) ) {s = 10;}

                         
                        input.seek(index41_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_GeneratorConfig_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassRule_in_parse_org_emftext_sdk_generatorconfig_GeneratorConfig127 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureRule_in_parse_org_emftext_sdk_generatorconfig_GeneratorConfig169 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule229 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule250 = new BitSet(new long[]{0x0000040000EC0150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule268 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassRule_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureRule_in_parse_org_emftext_sdk_generatorconfig_GeneratorRule315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_generatorconfig_ClassRule340 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_ClassRule358 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_sdk_generatorconfig_ClassRule379 = new BitSet(new long[]{0x0000040000EC0150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_generatorconfig_ClassRule397 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_generatorconfig_ClassRule415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_generatorconfig_FeatureRule444 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_FeatureRule462 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_sdk_generatorconfig_FeatureRule483 = new BitSet(new long[]{0x0000040000EC0150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_generatorconfig_FeatureRule501 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_generatorconfig_FeatureRule519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_generatorconfig_FeatureReference548 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_generatorconfig_FeatureReference562 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_FeatureReference580 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_generatorconfig_FeatureReference601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_generatorconfig_ClassName630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_generatorconfig_Features659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_ClassRuleReference692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_generatorconfig_FeatureRuleReference732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_generatorconfig_FeatureName768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_generatorconfig_Feature797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax841 = new BitSet(new long[]{0x0028000001000000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax897 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax938 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax956 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax977 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax995 = new BitSet(new long[]{0x0000000794000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1031 = new BitSet(new long[]{0x0000000794000000L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1086 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1119 = new BitSet(new long[]{0x0000000798000000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1184 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1227 = new BitSet(new long[]{0x0000000798000000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1342 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1362 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1403 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1464 = new BitSet(new long[]{0x0000000780000000L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1506 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1526 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1567 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1605 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1654 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1696 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1716 = new BitSet(new long[]{0x0029080041000000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1757 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1795 = new BitSet(new long[]{0x0029080041000000L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1844 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1886 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1906 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1947 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2008 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2041 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2055 = new BitSet(new long[]{0x0028000041000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2084 = new BitSet(new long[]{0x0028000041000010L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax2124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import2157 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Import2178 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import2196 = new BitSet(new long[]{0x0000001000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import2232 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_Import2287 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_Import2307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import2333 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option2487 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_Option2508 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_Option2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule2577 = new BitSet(new long[]{0x0028000001000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule2622 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_Rule2643 = new BitSet(new long[]{0x0000040000EC0150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule2661 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_Rule2679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence2717 = new BitSet(new long[]{0x0000040000EC0152L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2762 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_Choice2789 = new BitSet(new long[]{0x0000040000EC0150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice2815 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_CsString2875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2915 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2936 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2954 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2975 = new BitSet(new long[]{0x0006100000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken2998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken3043 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken3064 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken3078 = new BitSet(new long[]{0x0006100000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken3101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3146 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3167 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3185 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3206 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3224 = new BitSet(new long[]{0x0000020008000000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3254 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_92_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3280 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3326 = new BitSet(new long[]{0x0006100000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3394 = new BitSet(new long[]{0x0006100800000002L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Containment3424 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3450 = new BitSet(new long[]{0x0006100008000002L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Containment3496 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment3530 = new BitSet(new long[]{0x0006100008000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment3620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3661 = new BitSet(new long[]{0x0000040000EC0150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3679 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3697 = new BitSet(new long[]{0x0006100000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_LineBreak3801 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3870 = new BitSet(new long[]{0x0028080001000000L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3911 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3929 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3954 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition3981 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4007 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4057 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4077 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition4103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4164 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4178 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4196 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4221 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4248 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexPart_in_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition4274 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_48_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective4330 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective4348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_AtomicRegex4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_RegexReference4428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_PLUS4464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_parse_org_emftext_sdk_concretesyntax_STAR4493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK4522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_parse_org_emftext_sdk_concretesyntax_Abstract4551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4584 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4605 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4623 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4653 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4679 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_TokenStyle4725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_parse_org_emftext_sdk_concretesyntax_Annotation4754 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation4772 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_Annotation4802 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4828 = new BitSet(new long[]{0x0000000008100000L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Annotation4869 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation4903 = new BitSet(new long[]{0x0000000008100000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_Annotation4964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5016 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5046 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_92_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair5072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PartialTokenDefinition_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective5149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureReference_in_parse_org_emftext_sdk_concretesyntax_Definition5170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassName_in_parse_org_emftext_sdk_concretesyntax_Definition5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_Features_in_parse_org_emftext_sdk_concretesyntax_Definition5190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassRuleReference_in_parse_org_emftext_sdk_concretesyntax_Definition5200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureRuleReference_in_parse_org_emftext_sdk_concretesyntax_Definition5210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureName_in_parse_org_emftext_sdk_concretesyntax_Definition5220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_Feature_in_parse_org_emftext_sdk_concretesyntax_Definition5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition5240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition5250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition5260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition5270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition5280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition5290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition5300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition5310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality5331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality5341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality5351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_AtomicRegex_in_parse_org_emftext_sdk_concretesyntax_RegexPart5372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_RegexReference_in_parse_org_emftext_sdk_concretesyntax_RegexPart5382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureReference_in_synpred43_Generatorconfig5170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_ClassRuleReference_in_synpred46_Generatorconfig5200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_FeatureRuleReference_in_synpred47_Generatorconfig5210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_generatorconfig_Feature_in_synpred49_Generatorconfig5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_synpred54_Generatorconfig5280 = new BitSet(new long[]{0x0000000000000002L});

}
