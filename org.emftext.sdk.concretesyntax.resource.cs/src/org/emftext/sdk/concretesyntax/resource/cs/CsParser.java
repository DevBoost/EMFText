// $ANTLR 3.1.1 C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g 2009-06-26 18:02:53

	package org.emftext.sdk.concretesyntax.resource.cs;
	
	import java.util.HashMap;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
public class CsParser extends AbstractEMFTextParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUALIFIED_NAME", "QUOTED_60_62", "QUOTED_34_34", "QUOTED_39_39", "HEXNUMBER", "NUMBER", "QUOTED_36_36", "COMMENTS", "WHITESPACE", "LINEBREAK", "'SYNTAXDEF'", "'FOR'", "'START'", "','", "'IMPORTS'", "'{'", "'}'", "'OPTIONS'", "';'", "'TOKENS'", "'TOKENSTYLES'", "'RULES'", "':'", "'WITH'", "'SYNTAX'", "'='", "'::='", "'|'", "'['", "']'", "'('", "')'", "'!'", "'DEFINE'", "'COLLECT'", "'IN'", "'PRIORITIZE'", "'+'", "'*'", "'?'", "'ABSTRACT'", "'COLOR'", "'@'"
    };
    public static final int T__42=42;
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
    public static final int QUOTED_39_39=7;
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
    public static final int QUOTED_34_34=6;

    // delegates
    // delegators


        public CsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[70+1];
             
             
        }
        

    public String[] getTokenNames() { return CsParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g"; }


    	private org.emftext.runtime.resource.ITokenResolverFactory tokenResolverFactory = new CsTokenResolverFactory();
    	private org.emftext.runtime.resource.impl.TokenResolveResult tokenResolveResult = new org.emftext.runtime.resource.impl.TokenResolveResult();
    	private boolean rememberExpectedElements = false;
    	private java.lang.Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	private boolean reachedIndex = false;
    	private java.util.List<org.emftext.runtime.resource.IExpectedElement> expectedElements = new java.util.ArrayList<org.emftext.runtime.resource.IExpectedElement>();
    	private int lastIndex = -1;
    	
    	// This default constructor is only used to call createInstance() on it
    	public CsParser() {
    		super();
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
    	
    	protected org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch getReferenceResolverSwitch() {
    		org.emftext.runtime.resource.ITextResource resource = getResource();
    		if (resource == null) {
    			return null;
    		}
    		return (org.emftext.sdk.concretesyntax.resource.cs.CsReferenceResolverSwitch) resource.getMetaInformation().getReferenceResolverSwitch();
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
    	
    	@SuppressWarnings("unchecked")
    	private boolean addObjectToList(org.eclipse.emf.ecore.EObject element, int featureID, java.lang.Object proxy) {
    		return ((java.util.List<java.lang.Object>) element.eGet(element.eClass().getEStructuralFeature(featureID))).add(proxy);
    	}
    	
    	public java.lang.Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	private org.emftext.runtime.resource.impl.TokenResolveResult getFreshTokenResolveResult() {
    		tokenResolveResult.clear();
    		return tokenResolveResult;
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
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
    	
    	public java.util.List<org.emftext.runtime.resource.IExpectedElement> parseToExpectedElements(org.eclipse.emf.ecore.EClass type) {
    		rememberExpectedElements = true;
    		parseToIndexTypeObject = type;
    		parse();
    		return this.expectedElements;
    	}
    	
    	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory,ContainerType element, org.eclipse.emf.ecore.EReference reference, String id,org.eclipse.emf.ecore.EObject proxy) {
    				org.emftext.runtime.resource.ITextResource resource = getResource();
    		if (resource == null) {
    			// the resource can be null if the parser is used for
    			// code completion
    			return;
    		}
    		resource.registerContextDependentProxy(factory, element, reference, id, proxy);
    	}
    	
    	protected void addErrorToResource(final java.lang.String errorMessage, int line,
    	int charPositionInLine, int startIndex, int stopIndex) {
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
    		
    	public java.lang.Object recoverFromMismatchedToken(org.antlr.runtime.IntStream input, int ttype, org.antlr.runtime.BitSet follow) throws org.antlr.runtime.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}



    // $ANTLR start "start"
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:277:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.ConcreteSyntax c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:278:1: ( (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:279:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax ) EOF
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:279:2: (c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:280:3: c0= parse_org_emftext_sdk_concretesyntax_ConcreteSyntax
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_in_start79);
            c0=parse_org_emftext_sdk_concretesyntax_ConcreteSyntax();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start86); if (state.failed) return element;

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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:285:1: parse_org_emftext_sdk_concretesyntax_ConcreteSyntax returns [org.emftext.sdk.concretesyntax.ConcreteSyntax element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )+ ) a32= '}' ;
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:288:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )+ ) a32= '}' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:289:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )? a2= 'SYNTAXDEF' (a3= QUALIFIED_NAME ) a4= 'FOR' (a5= QUOTED_60_62 ) ( ( (a6= QUOTED_60_62 ) ) )? ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )? ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )? ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )? ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )? ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )? a29= 'RULES' a30= '{' ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )+ ) a32= '}'
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:289:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==46) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:290:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:290:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:291:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:291:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:292:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax124);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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
            	      						copyLocalizationInfos(a0_0, element); 					}
            	      				
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:310:2: ( (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==44) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:311:3: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:311:3: (a1_0= parse_org_emftext_sdk_concretesyntax_Abstract )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:312:4: a1_0= parse_org_emftext_sdk_concretesyntax_Abstract
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax166);
                    a1_0=parse_org_emftext_sdk_concretesyntax_Abstract();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      					copyLocalizationInfos(a1_0, element); 				}
                      			
                    }

                    }


                    }
                    break;

            }

            a2=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax189); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("SYNTAXDEF"), a2);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a2, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:337:2: (a3= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:338:3: a3= QUALIFIED_NAME
            {
            a3=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax204); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            a4=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax222); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("FOR"), a4);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a4, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:373:2: (a5= QUOTED_60_62 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:374:3: a5= QUOTED_60_62
            {
            a5=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax237); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((CommonToken) a5, element);
              				copyLocalizationInfos((CommonToken) a5, proxy);
              			}
              		
            }

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:404:2: ( ( (a6= QUOTED_60_62 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==QUOTED_60_62) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:405:3: ( (a6= QUOTED_60_62 ) )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:405:3: ( (a6= QUOTED_60_62 ) )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:406:4: (a6= QUOTED_60_62 )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:406:4: (a6= QUOTED_60_62 )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:407:5: a6= QUOTED_60_62
                    {
                    a6=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax270); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }


                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:436:2: ( (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:437:3: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:437:3: (a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )* )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:438:4: a7= 'START' ( (a8= QUALIFIED_NAME ) ) ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    {
                    a7=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax317); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("START"), a7);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a7, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:447:4: ( (a8= QUALIFIED_NAME ) )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:448:5: (a8= QUALIFIED_NAME )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:448:5: (a8= QUALIFIED_NAME )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:449:6: a8= QUALIFIED_NAME
                    {
                    a8=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax345); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      							registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
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

                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:481:4: ( (a9= ',' ( (a10= QUALIFIED_NAME ) ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:482:5: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:482:5: (a9= ',' ( (a10= QUALIFIED_NAME ) ) )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:483:6: a9= ',' ( (a10= QUALIFIED_NAME ) )
                    	    {
                    	    a9=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax399); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a9);
                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((CommonToken)a9, element);
                    	      					
                    	    }
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:492:6: ( (a10= QUALIFIED_NAME ) )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:493:7: (a10= QUALIFIED_NAME )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:493:7: (a10= QUALIFIED_NAME )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:494:8: a10= QUALIFIED_NAME
                    	    {
                    	    a10=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax435); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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
                    	      									registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.ConcreteSyntax, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConcreteSyntaxStartSymbolsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), resolved, proxy);
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


                    }


                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:532:2: ( (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:533:3: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:533:3: (a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:534:4: a11= 'IMPORTS' a12= '{' ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )* a14= '}'
                    {
                    a11=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax527); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("IMPORTS"), a11);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a11, element);
                      			
                    }
                    a12=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax542); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a12);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a12, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:552:4: ( ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==QUALIFIED_NAME) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:553:5: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:553:5: ( (a13_0= parse_org_emftext_sdk_concretesyntax_Import ) )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:554:6: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:554:6: (a13_0= parse_org_emftext_sdk_concretesyntax_Import )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:555:7: a13_0= parse_org_emftext_sdk_concretesyntax_Import
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax578);
                    	    a13_0=parse_org_emftext_sdk_concretesyntax_Import();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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
                    	      								copyLocalizationInfos(a13_0, element); 							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    a14=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax627); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a14);
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

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:585:2: ( (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:586:3: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:586:3: (a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:587:4: a15= 'OPTIONS' a16= '{' ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )* a19= '}'
                    {
                    a15=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax661); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("OPTIONS"), a15);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a15, element);
                      			
                    }
                    a16=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax676); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a16);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a16, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:605:4: ( ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==QUALIFIED_NAME) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:606:5: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:606:5: ( (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';' )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:607:6: (a17_0= parse_org_emftext_sdk_concretesyntax_Option ) a18= ';'
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:607:6: (a17_0= parse_org_emftext_sdk_concretesyntax_Option )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:608:7: a17_0= parse_org_emftext_sdk_concretesyntax_Option
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax712);
                    	    a17_0=parse_org_emftext_sdk_concretesyntax_Option();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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
                    	      								copyLocalizationInfos(a17_0, element); 							}
                    	      						
                    	    }

                    	    }

                    	    a18=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax743); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(";"), a18);
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

                    a19=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax780); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a19);
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

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:647:2: ( (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:648:3: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:648:3: (a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:649:4: a20= 'TOKENS' a21= '{' ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )* a24= '}'
                    {
                    a20=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax814); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("TOKENS"), a20);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a20, element);
                      			
                    }
                    a21=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax829); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a21);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a21, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:667:4: ( ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==37||LA10_0==40||LA10_0==46) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:668:5: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:668:5: ( (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';' )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:669:6: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective ) a23= ';'
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:669:6: (a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:670:7: a22_0= parse_org_emftext_sdk_concretesyntax_TokenDirective
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax865);
                    	    a22_0=parse_org_emftext_sdk_concretesyntax_TokenDirective();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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
                    	      								copyLocalizationInfos(a22_0, element); 							}
                    	      						
                    	    }

                    	    }

                    	    a23=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax896); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(";"), a23);
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

                    a24=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax933); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a24);
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

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:709:2: ( (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:710:3: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:710:3: (a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:711:4: a25= 'TOKENSTYLES' a26= '{' ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )* a28= '}'
                    {
                    a25=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax967); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("TOKENSTYLES"), a25);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a25, element);
                      			
                    }
                    a26=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax982); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a26);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a26, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:729:4: ( ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==QUOTED_34_34) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:730:5: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:730:5: ( (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle ) )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:731:6: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:731:6: (a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:732:7: a27_0= parse_org_emftext_sdk_concretesyntax_TokenStyle
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1018);
                    	    a27_0=parse_org_emftext_sdk_concretesyntax_TokenStyle();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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
                    	      								copyLocalizationInfos(a27_0, element); 							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    a28=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1067); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a28);
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

            a29=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1092); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("RULES"), a29);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a29, element);
              	
            }
            a30=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1103); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("{"), a30);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a30, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:780:2: ( ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )+ )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:781:3: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )+
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:781:3: ( (a31_0= parse_org_emftext_sdk_concretesyntax_Rule ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==QUALIFIED_NAME||LA14_0==46) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:782:4: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:782:4: (a31_0= parse_org_emftext_sdk_concretesyntax_Rule )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:783:5: a31_0= parse_org_emftext_sdk_concretesyntax_Rule
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1129);
            	    a31_0=parse_org_emftext_sdk_concretesyntax_Rule();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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
            	      						copyLocalizationInfos(a31_0, element); 					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            a32=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1162); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("}"), a32);
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:812:1: parse_org_emftext_sdk_concretesyntax_Import returns [org.emftext.sdk.concretesyntax.Import element = null] : (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? ;
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:815:1: ( (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:816:2: (a0= QUALIFIED_NAME ) a1= ':' (a2= QUOTED_60_62 ) ( ( (a3= QUOTED_60_62 ) ) )? ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:816:2: (a0= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:817:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1192); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            a1=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Import1210); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(":"), a1);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:852:2: (a2= QUOTED_60_62 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:853:3: a2= QUOTED_60_62
            {
            a2=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1225); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.GenPackageDependentElement, org.eclipse.emf.codegen.ecore.genmodel.GenPackage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGenPackageDependentElementPackageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((CommonToken) a2, element);
              				copyLocalizationInfos((CommonToken) a2, proxy);
              			}
              		
            }

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:883:2: ( ( (a3= QUOTED_60_62 ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==QUOTED_60_62) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:884:3: ( (a3= QUOTED_60_62 ) )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:884:3: ( (a3= QUOTED_60_62 ) )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:885:4: (a3= QUOTED_60_62 )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:885:4: (a3= QUOTED_60_62 )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:886:5: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1258); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }


                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:915:2: ( (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:916:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:916:3: (a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )? )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:917:4: a4= 'WITH' a5= 'SYNTAX' (a6= QUALIFIED_NAME ) ( ( (a7= QUOTED_60_62 ) ) )?
                    {
                    a4=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Import1305); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("WITH"), a4);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a4, element);
                      			
                    }
                    a5=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_Import1320); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("SYNTAX"), a5);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createImport();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a5, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:935:4: (a6= QUALIFIED_NAME )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:936:5: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1341); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      						registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Import, org.emftext.sdk.concretesyntax.ConcreteSyntax>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getImportConcreteSyntaxReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), resolved, proxy);
                      						if (proxy != null) {
                      							element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), proxy);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((CommonToken) a6, element);
                      						copyLocalizationInfos((CommonToken) a6, proxy);
                      					}
                      				
                    }

                    }

                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:966:4: ( ( (a7= QUOTED_60_62 ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==QUOTED_60_62) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:967:5: ( (a7= QUOTED_60_62 ) )
                            {
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:967:5: ( (a7= QUOTED_60_62 ) )
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:968:6: (a7= QUOTED_60_62 )
                            {
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:968:6: (a7= QUOTED_60_62 )
                            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:969:7: a7= QUOTED_60_62
                            {
                            a7=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1390); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1003:1: parse_org_emftext_sdk_concretesyntax_Option returns [org.emftext.sdk.concretesyntax.Option element = null] : (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34 ) ;
    public final org.emftext.sdk.concretesyntax.Option parse_org_emftext_sdk_concretesyntax_Option() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Option element =  null;
        int parse_org_emftext_sdk_concretesyntax_Option_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1006:1: ( (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34 ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1007:2: (a0= QUALIFIED_NAME ) a1= '=' (a2= QUOTED_34_34 )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1007:2: (a0= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1008:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1475); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            a1=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_Option1493); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("="), a1);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1043:2: (a2= QUOTED_34_34 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1044:3: a2= QUOTED_34_34
            {
            a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_sdk_concretesyntax_Option1508); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createOption();
              			}
              			String tokenName = "QUOTED_34_34";
              			addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), element, tokenName), a2);
              			if (a2 != null) {
              				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1072:1: parse_org_emftext_sdk_concretesyntax_Rule returns [org.emftext.sdk.concretesyntax.Rule element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' ;
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1075:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1076:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* (a1= QUALIFIED_NAME ) a2= '::=' (a3_0= parse_org_emftext_sdk_concretesyntax_Choice ) a4= ';'
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1076:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==46) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1077:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1077:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1078:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1078:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1079:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1556);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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
            	      						copyLocalizationInfos(a0_0, element); 					}
            	      				
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1097:2: (a1= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1098:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1593); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Rule, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRuleMetaclassReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((CommonToken) a1, element);
              				copyLocalizationInfos((CommonToken) a1, proxy);
              			}
              		
            }

            }

            a2=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_Rule1611); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("::="), a2);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createRule();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a2, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1137:2: (a3_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1138:3: a3_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1626);
            a3_0=parse_org_emftext_sdk_concretesyntax_Choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				copyLocalizationInfos(a3_0, element); 			}
              		
            }

            }

            a4=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_Rule1641); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(";"), a4);
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1164:1: parse_org_emftext_sdk_concretesyntax_Sequence returns [org.emftext.sdk.concretesyntax.Sequence element = null] : ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ ;
    public final org.emftext.sdk.concretesyntax.Sequence parse_org_emftext_sdk_concretesyntax_Sequence() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Sequence element =  null;
        int parse_org_emftext_sdk_concretesyntax_Sequence_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.Definition a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1167:1: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+ )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1168:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1168:2: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Definition ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==QUALIFIED_NAME||LA19_0==QUOTED_34_34||LA19_0==HEXNUMBER||LA19_0==34||LA19_0==36) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1169:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1169:3: (a0_0= parse_org_emftext_sdk_concretesyntax_Definition )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1170:4: a0_0= parse_org_emftext_sdk_concretesyntax_Definition
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence1676);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Definition();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1188:1: parse_org_emftext_sdk_concretesyntax_Choice returns [org.emftext.sdk.concretesyntax.Choice element = null] : (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* ;
    public final org.emftext.sdk.concretesyntax.Choice parse_org_emftext_sdk_concretesyntax_Choice() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Choice element =  null;
        int parse_org_emftext_sdk_concretesyntax_Choice_StartIndex = input.index();
        Token a1=null;
        org.emftext.sdk.concretesyntax.Sequence a0_0 = null;

        org.emftext.sdk.concretesyntax.Sequence a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1191:1: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )* )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1192:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1192:2: (a0_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1193:3: a0_0= parse_org_emftext_sdk_concretesyntax_Sequence
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice1718);
            a0_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				copyLocalizationInfos(a0_0, element); 			}
              		
            }

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1208:2: ( (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1209:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1209:3: (a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence ) )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1210:4: a1= '|' (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    {
            	    a1=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_Choice1742); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("|"), a1);
            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createChoice();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((CommonToken)a1, element);
            	      			
            	    }
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1219:4: (a2_0= parse_org_emftext_sdk_concretesyntax_Sequence )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1220:5: a2_0= parse_org_emftext_sdk_concretesyntax_Sequence
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice1763);
            	    a2_0=parse_org_emftext_sdk_concretesyntax_Sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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
            	      						copyLocalizationInfos(a2_0, element); 					}
            	      				
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1240:1: parse_org_emftext_sdk_concretesyntax_CsString returns [org.emftext.sdk.concretesyntax.CsString element = null] : (a0= QUOTED_34_34 ) ;
    public final org.emftext.sdk.concretesyntax.CsString parse_org_emftext_sdk_concretesyntax_CsString() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CsString element =  null;
        int parse_org_emftext_sdk_concretesyntax_CsString_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1243:1: ( (a0= QUOTED_34_34 ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1244:2: (a0= QUOTED_34_34 )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1244:2: (a0= QUOTED_34_34 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1245:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_sdk_concretesyntax_CsString1815); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCsString();
              			}
              			String tokenName = "QUOTED_34_34";
              			addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), element, tokenName), a0);
              			if (a0 != null) {
              				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1273:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1276:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1277:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUALIFIED_NAME ) a3= ']' ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1277:2: (a0= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1278:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1852); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((CommonToken) a0, element);
              				copyLocalizationInfos((CommonToken) a0, proxy);
              			}
              		
            }

            }

            a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1870); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("["), a1);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1317:2: (a2= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1318:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1885); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.TokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPlaceholderTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((CommonToken) a2, element);
              				copyLocalizationInfos((CommonToken) a2, proxy);
              			}
              		
            }

            }

            a3=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1903); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("]"), a3);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingSpecifiedToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a3, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1357:2: ( (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=41 && LA21_0<=43)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1358:3: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1358:3: (a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1359:4: a4_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1923);
                    a4_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      					copyLocalizationInfos(a4_0, element); 				}
                      			
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1377:1: parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken returns [org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element = null] : (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken element =  null;
        int parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1380:1: ( (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1381:2: (a0= QUALIFIED_NAME ) a1= '[' a2= ']' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1381:2: (a0= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1382:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken1965); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((CommonToken) a0, element);
              				copyLocalizationInfos((CommonToken) a0, proxy);
              			}
              		
            }

            }

            a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken1983); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("["), a1);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            a2=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken1994); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("]"), a2);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderUsingDefaultToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a2, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1430:2: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=41 && LA22_0<=43)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1431:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1431:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1432:4: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2014);
                    a3_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      					copyLocalizationInfos(a3_0, element); 				}
                      			
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1450:1: parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes returns [org.emftext.sdk.concretesyntax.PlaceholderInQuotes element = null] : (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 ) a5= ']' ( (a6_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.PlaceholderInQuotes parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PlaceholderInQuotes element =  null;
        int parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        org.emftext.sdk.concretesyntax.Cardinality a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1453:1: ( (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 ) a5= ']' ( (a6_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1454:2: (a0= QUALIFIED_NAME ) a1= '[' (a2= QUOTED_39_39 ) a3= ',' (a4= QUOTED_39_39 ) a5= ']' ( (a6_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1454:2: (a0= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1455:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2056); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((CommonToken) a0, element);
              				copyLocalizationInfos((CommonToken) a0, proxy);
              			}
              		
            }

            }

            a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2074); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("["), a1);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1494:2: (a2= QUOTED_39_39 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1495:3: a2= QUOTED_39_39
            {
            a2=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2089); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              			}
              			String tokenName = "QUOTED_39_39";
              			addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), element, tokenName), a2);
              			if (a2 != null) {
              				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
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

            }

            a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2107); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a3);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a3, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1530:2: (a4= QUOTED_39_39 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1531:3: a4= QUOTED_39_39
            {
            a4=(Token)match(input,QUOTED_39_39,FOLLOW_QUOTED_39_39_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2122); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              			}
              			String tokenName = "QUOTED_39_39";
              			addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), element, tokenName), a4);
              			if (a4 != null) {
              				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_39_39");
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

            }

            a5=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2140); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("]"), a5);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a5, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1566:2: ( (a6_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=41 && LA23_0<=43)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1567:3: (a6_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1567:3: (a6_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1568:4: a6_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2160);
                    a6_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
                      				}
                      				String tokenName = "null";
                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), element, tokenName), a6_0);
                      				if (a6_0 != null) {
                      					if (a6_0 != null) {
                      						element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), a6_0);
                      					}
                      					collectHiddenTokens(element);
                      					copyLocalizationInfos(a6_0, element); 				}
                      			
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1586:1: parse_org_emftext_sdk_concretesyntax_Containment returns [org.emftext.sdk.concretesyntax.Containment element = null] : (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1589:1: ( (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1590:2: (a0= QUALIFIED_NAME ) ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )? ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1590:2: (a0= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1591:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2202); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Terminal, org.eclipse.emf.codegen.ecore.genmodel.GenFeature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), resolved, proxy);
              				if (proxy != null) {
              					element.eSet(element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), proxy);
              				}
              				collectHiddenTokens(element);
              				copyLocalizationInfos((CommonToken) a0, element);
              				copyLocalizationInfos((CommonToken) a0, proxy);
              			}
              		
            }

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1621:2: ( (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==26) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1622:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1622:3: (a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1623:4: a1= ':' (a2= QUALIFIED_NAME ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    {
                    a1=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Containment2229); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(":"), a1);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a1, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1632:4: (a2= QUALIFIED_NAME )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1633:5: a2= QUALIFIED_NAME
                    {
                    a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2250); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      						registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
                      						if (proxy != null) {
                      							addObjectToList(element, org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES, proxy);
                      						}
                      						collectHiddenTokens(element);
                      						copyLocalizationInfos((CommonToken) a2, element);
                      						copyLocalizationInfos((CommonToken) a2, proxy);
                      					}
                      				
                    }

                    }

                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1663:4: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==17) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1664:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1664:5: (a3= ',' (a4= QUALIFIED_NAME ) )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1665:6: a3= ',' (a4= QUALIFIED_NAME )
                    	    {
                    	    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Containment2291); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a3);
                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createContainment();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((CommonToken)a3, element);
                    	      					
                    	    }
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1674:6: (a4= QUALIFIED_NAME )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1675:7: a4= QUALIFIED_NAME
                    	    {
                    	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2318); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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
                    	      								registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.Containment, org.eclipse.emf.codegen.ecore.genmodel.GenClass>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getContainmentTypesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), resolved, proxy);
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
                    	    break loop24;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1711:2: ( (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=41 && LA26_0<=43)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1712:3: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1712:3: (a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1713:4: a5_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment2393);
                    a5_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      					copyLocalizationInfos(a5_0, element); 				}
                      			
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1731:1: parse_org_emftext_sdk_concretesyntax_CompoundDefinition returns [org.emftext.sdk.concretesyntax.CompoundDefinition element = null] : a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? ;
    public final org.emftext.sdk.concretesyntax.CompoundDefinition parse_org_emftext_sdk_concretesyntax_CompoundDefinition() throws RecognitionException {
        org.emftext.sdk.concretesyntax.CompoundDefinition element =  null;
        int parse_org_emftext_sdk_concretesyntax_CompoundDefinition_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        org.emftext.sdk.concretesyntax.Choice a1_0 = null;

        org.emftext.sdk.concretesyntax.Cardinality a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1734:1: (a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1735:2: a0= '(' (a1_0= parse_org_emftext_sdk_concretesyntax_Choice ) a2= ')' ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            {
            a0=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2431); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("("), a0);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1744:2: (a1_0= parse_org_emftext_sdk_concretesyntax_Choice )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1745:3: a1_0= parse_org_emftext_sdk_concretesyntax_Choice
            {
            pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2446);
            a1_0=parse_org_emftext_sdk_concretesyntax_Choice();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				copyLocalizationInfos(a1_0, element); 			}
              		
            }

            }

            a2=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2461); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(")"), a2);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createCompoundDefinition();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a2, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1769:2: ( (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=41 && LA27_0<=43)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1770:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1770:3: (a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1771:4: a3_0= parse_org_emftext_sdk_concretesyntax_Cardinality
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2481);
                    a3_0=parse_org_emftext_sdk_concretesyntax_Cardinality();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      					copyLocalizationInfos(a3_0, element); 				}
                      			
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1789:1: parse_org_emftext_sdk_concretesyntax_WhiteSpaces returns [org.emftext.sdk.concretesyntax.WhiteSpaces element = null] : (a0= HEXNUMBER ) ;
    public final org.emftext.sdk.concretesyntax.WhiteSpaces parse_org_emftext_sdk_concretesyntax_WhiteSpaces() throws RecognitionException {
        org.emftext.sdk.concretesyntax.WhiteSpaces element =  null;
        int parse_org_emftext_sdk_concretesyntax_WhiteSpaces_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1792:1: ( (a0= HEXNUMBER ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1793:2: (a0= HEXNUMBER )
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1793:2: (a0= HEXNUMBER )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1794:3: a0= HEXNUMBER
            {
            a0=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces2523); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1822:1: parse_org_emftext_sdk_concretesyntax_LineBreak returns [org.emftext.sdk.concretesyntax.LineBreak element = null] : a0= '!' (a1= NUMBER ) ;
    public final org.emftext.sdk.concretesyntax.LineBreak parse_org_emftext_sdk_concretesyntax_LineBreak() throws RecognitionException {
        org.emftext.sdk.concretesyntax.LineBreak element =  null;
        int parse_org_emftext_sdk_concretesyntax_LineBreak_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1825:1: (a0= '!' (a1= NUMBER ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1826:2: a0= '!' (a1= NUMBER )
            {
            a0=(Token)match(input,36,FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_LineBreak2556); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("!"), a0);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createLineBreak();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1835:2: (a1= NUMBER )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1836:3: a1= NUMBER
            {
            a1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak2571); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1864:1: parse_org_emftext_sdk_concretesyntax_NormalToken returns [org.emftext.sdk.concretesyntax.NormalToken element = null] : ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3= QUOTED_36_36 ) ( (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) ) )? ;
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1867:1: ( ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3= QUOTED_36_36 ) ( (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1868:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )* a1= 'DEFINE' (a2= QUALIFIED_NAME ) (a3= QUOTED_36_36 ) ( (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) ) )?
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1868:2: ( ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==46) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1869:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1869:3: ( (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation ) )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1870:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1870:4: (a0_0= parse_org_emftext_sdk_concretesyntax_Annotation )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1871:5: a0_0= parse_org_emftext_sdk_concretesyntax_Annotation
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalToken2619);
            	    a0_0=parse_org_emftext_sdk_concretesyntax_Annotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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
            	      						copyLocalizationInfos(a0_0, element); 					}
            	      				
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            a1=(Token)match(input,37,FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_NormalToken2652); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("DEFINE"), a1);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1898:2: (a2= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1899:3: a2= QUALIFIED_NAME
            {
            a2=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken2667); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1925:2: (a3= QUOTED_36_36 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1926:3: a3= QUOTED_36_36
            {
            a3=(Token)match(input,QUOTED_36_36,FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_NormalToken2689); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1952:2: ( (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==38) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1953:3: (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1953:3: (a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME ) )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1954:4: a4= 'COLLECT' a5= 'IN' (a6= QUALIFIED_NAME )
                    {
                    a4=(Token)match(input,38,FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_NormalToken2716); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("COLLECT"), a4);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a4, element);
                      			
                    }
                    a5=(Token)match(input,39,FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_NormalToken2731); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("IN"), a5);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createNormalToken();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a5, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1972:4: (a6= QUALIFIED_NAME )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:1973:5: a6= QUALIFIED_NAME
                    {
                    a6=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken2752); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2004:1: parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective returns [org.emftext.sdk.concretesyntax.TokenPriorityDirective element = null] : a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) ;
    public final org.emftext.sdk.concretesyntax.TokenPriorityDirective parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenPriorityDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2007:1: (a0= 'PRIORITIZE' (a1= QUALIFIED_NAME ) )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2008:2: a0= 'PRIORITIZE' (a1= QUALIFIED_NAME )
            {
            a0=(Token)match(input,40,FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective2805); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("PRIORITIZE"), a0);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenPriorityDirective();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2017:2: (a1= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2018:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective2820); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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
              				registerContextDependentProxy(new org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory<org.emftext.sdk.concretesyntax.TokenPriorityDirective, org.emftext.sdk.concretesyntax.TokenDefinition>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTokenPriorityDirectiveTokenReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), resolved, proxy);
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2050:1: parse_org_emftext_sdk_concretesyntax_PLUS returns [org.emftext.sdk.concretesyntax.PLUS element = null] : a0= '+' ;
    public final org.emftext.sdk.concretesyntax.PLUS parse_org_emftext_sdk_concretesyntax_PLUS() throws RecognitionException {
        org.emftext.sdk.concretesyntax.PLUS element =  null;
        int parse_org_emftext_sdk_concretesyntax_PLUS_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2053:1: (a0= '+' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2054:2: a0= '+'
            {
            a0=(Token)match(input,41,FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PLUS2853); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("+"), a0);
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2065:1: parse_org_emftext_sdk_concretesyntax_STAR returns [org.emftext.sdk.concretesyntax.STAR element = null] : a0= '*' ;
    public final org.emftext.sdk.concretesyntax.STAR parse_org_emftext_sdk_concretesyntax_STAR() throws RecognitionException {
        org.emftext.sdk.concretesyntax.STAR element =  null;
        int parse_org_emftext_sdk_concretesyntax_STAR_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2068:1: (a0= '*' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2069:2: a0= '*'
            {
            a0=(Token)match(input,42,FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_STAR2879); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("*"), a0);
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2080:1: parse_org_emftext_sdk_concretesyntax_QUESTIONMARK returns [org.emftext.sdk.concretesyntax.QUESTIONMARK element = null] : a0= '?' ;
    public final org.emftext.sdk.concretesyntax.QUESTIONMARK parse_org_emftext_sdk_concretesyntax_QUESTIONMARK() throws RecognitionException {
        org.emftext.sdk.concretesyntax.QUESTIONMARK element =  null;
        int parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2083:1: (a0= '?' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2084:2: a0= '?'
            {
            a0=(Token)match(input,43,FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK2905); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("?"), a0);
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2095:1: parse_org_emftext_sdk_concretesyntax_Abstract returns [org.emftext.sdk.concretesyntax.Abstract element = null] : a0= 'ABSTRACT' ;
    public final org.emftext.sdk.concretesyntax.Abstract parse_org_emftext_sdk_concretesyntax_Abstract() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Abstract element =  null;
        int parse_org_emftext_sdk_concretesyntax_Abstract_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2098:1: (a0= 'ABSTRACT' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2099:2: a0= 'ABSTRACT'
            {
            a0=(Token)match(input,44,FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_Abstract2931); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("ABSTRACT"), a0);
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2110:1: parse_org_emftext_sdk_concretesyntax_TokenStyle returns [org.emftext.sdk.concretesyntax.TokenStyle element = null] : (a0= QUOTED_34_34 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' ;
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2113:1: ( (a0= QUOTED_34_34 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';' )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2114:2: (a0= QUOTED_34_34 ) a1= 'COLOR' (a2= HEXNUMBER ) ( (a3= ',' (a4= QUALIFIED_NAME ) ) )* a5= ';'
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2114:2: (a0= QUOTED_34_34 )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2115:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_sdk_concretesyntax_TokenStyle2961); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (element == null) {
              				element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              			}
              			String tokenName = "QUOTED_34_34";
              			addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAME), element, tokenName), a0);
              			if (a0 != null) {
              				org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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

            }

            a1=(Token)match(input,45,FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_TokenStyle2979); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("COLOR"), a1);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a1, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2150:2: (a2= HEXNUMBER )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2151:3: a2= HEXNUMBER
            {
            a2=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle2994); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2177:2: ( (a3= ',' (a4= QUALIFIED_NAME ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==17) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2178:3: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    {
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2178:3: (a3= ',' (a4= QUALIFIED_NAME ) )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2179:4: a3= ',' (a4= QUALIFIED_NAME )
            	    {
            	    a3=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3021); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a3);
            	      				if (element == null) {
            	      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
            	      				}
            	      				collectHiddenTokens(element);
            	      				copyLocalizationInfos((CommonToken)a3, element);
            	      			
            	    }
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2188:4: (a4= QUALIFIED_NAME )
            	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2189:5: a4= QUALIFIED_NAME
            	    {
            	    a4=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3042); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            a5=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3080); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(";"), a5);
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2229:1: parse_org_emftext_sdk_concretesyntax_Annotation returns [org.emftext.sdk.concretesyntax.Annotation element = null] : a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? ;
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2232:1: (a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2233:2: a0= '@' (a1= QUALIFIED_NAME ) ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            {
            a0=(Token)match(input,46,FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_Annotation3106); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("@"), a0);
              		if (element == null) {
              			element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
              		}
              		collectHiddenTokens(element);
              		copyLocalizationInfos((CommonToken)a0, element);
              	
            }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2242:2: (a1= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2243:3: a1= QUALIFIED_NAME
            {
            a1=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation3121); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2269:2: ( (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==34) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2270:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2270:3: (a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')' )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2271:4: a2= '(' (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )* a6= ')'
                    {
                    a2=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_Annotation3148); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("("), a2);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a2, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2280:4: (a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2281:5: a3_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation3169);
                    a3_0=parse_org_emftext_sdk_concretesyntax_KeyValuePair();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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
                      						copyLocalizationInfos(a3_0, element); 					}
                      				
                    }

                    }

                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2296:4: ( (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==17) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2297:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    {
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2297:5: (a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair ) )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2298:6: a4= ',' (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    {
                    	    a4=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Annotation3205); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(","), a4);
                    	      						if (element == null) {
                    	      							element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createAnnotation();
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						copyLocalizationInfos((CommonToken)a4, element);
                    	      					
                    	    }
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2307:6: (a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair )
                    	    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2308:7: a5_0= parse_org_emftext_sdk_concretesyntax_KeyValuePair
                    	    {
                    	    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation3232);
                    	    a5_0=parse_org_emftext_sdk_concretesyntax_KeyValuePair();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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
                    	      								copyLocalizationInfos(a5_0, element); 							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    a6=(Token)match(input,35,FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Annotation3281); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString(")"), a6);
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2340:1: parse_org_emftext_sdk_concretesyntax_KeyValuePair returns [org.emftext.sdk.concretesyntax.KeyValuePair element = null] : (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34 ) ) )? ;
    public final org.emftext.sdk.concretesyntax.KeyValuePair parse_org_emftext_sdk_concretesyntax_KeyValuePair() throws RecognitionException {
        org.emftext.sdk.concretesyntax.KeyValuePair element =  null;
        int parse_org_emftext_sdk_concretesyntax_KeyValuePair_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2343:1: ( (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34 ) ) )? )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2344:2: (a0= QUALIFIED_NAME ) ( (a1= '=' (a2= QUOTED_34_34 ) ) )?
            {
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2344:2: (a0= QUALIFIED_NAME )
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2345:3: a0= QUALIFIED_NAME
            {
            a0=(Token)match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3325); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2371:2: ( (a1= '=' (a2= QUOTED_34_34 ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==29) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2372:3: (a1= '=' (a2= QUOTED_34_34 ) )
                    {
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2372:3: (a1= '=' (a2= QUOTED_34_34 ) )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2373:4: a1= '=' (a2= QUOTED_34_34 )
                    {
                    a1=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3352); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedCsString("="), a1);
                      				if (element == null) {
                      					element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
                      				}
                      				collectHiddenTokens(element);
                      				copyLocalizationInfos((CommonToken)a1, element);
                      			
                    }
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2382:4: (a2= QUOTED_34_34 )
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2383:5: a2= QUOTED_34_34
                    {
                    a2=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3373); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (element == null) {
                      						element = org.emftext.sdk.concretesyntax.ConcretesyntaxFactory.eINSTANCE.createKeyValuePair();
                      					}
                      					String tokenName = "QUOTED_34_34";
                      					addExpectedElement(new org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), element, tokenName), a2);
                      					if (a2 != null) {
                      						org.emftext.runtime.resource.ITokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2414:1: parse_org_emftext_sdk_concretesyntax_TokenDirective returns [org.emftext.sdk.concretesyntax.TokenDirective element = null] : (c0= parse_org_emftext_sdk_concretesyntax_NormalToken | c1= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective );
    public final org.emftext.sdk.concretesyntax.TokenDirective parse_org_emftext_sdk_concretesyntax_TokenDirective() throws RecognitionException {
        org.emftext.sdk.concretesyntax.TokenDirective element =  null;
        int parse_org_emftext_sdk_concretesyntax_TokenDirective_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.NormalToken c0 = null;

        org.emftext.sdk.concretesyntax.TokenPriorityDirective c1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2415:1: (c0= parse_org_emftext_sdk_concretesyntax_NormalToken | c1= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==37||LA34_0==46) ) {
                alt34=1;
            }
            else if ( (LA34_0==40) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2416:2: c0= parse_org_emftext_sdk_concretesyntax_NormalToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalToken_in_parse_org_emftext_sdk_concretesyntax_TokenDirective3422);
                    c0=parse_org_emftext_sdk_concretesyntax_NormalToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2417:4: c1= parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective3432);
                    c1=parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2421:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak );
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
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2422:1: (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak )
            int alt35=8;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2423:2: c0= parse_org_emftext_sdk_concretesyntax_CsString
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition3453);
                    c0=parse_org_emftext_sdk_concretesyntax_CsString();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2424:4: c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition3463);
                    c1=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2425:4: c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition3473);
                    c2=parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
                    }

                    }
                    break;
                case 4 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2426:4: c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition3483);
                    c3=parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; 
                    }

                    }
                    break;
                case 5 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2427:4: c4= parse_org_emftext_sdk_concretesyntax_Containment
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition3493);
                    c4=parse_org_emftext_sdk_concretesyntax_Containment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; 
                    }

                    }
                    break;
                case 6 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2428:4: c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition3503);
                    c5=parse_org_emftext_sdk_concretesyntax_CompoundDefinition();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; 
                    }

                    }
                    break;
                case 7 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2429:4: c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition3513);
                    c6=parse_org_emftext_sdk_concretesyntax_WhiteSpaces();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c6; 
                    }

                    }
                    break;
                case 8 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2430:4: c7= parse_org_emftext_sdk_concretesyntax_LineBreak
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition3523);
                    c7=parse_org_emftext_sdk_concretesyntax_LineBreak();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c7; 
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
    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2434:1: parse_org_emftext_sdk_concretesyntax_Cardinality returns [org.emftext.sdk.concretesyntax.Cardinality element = null] : (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK );
    public final org.emftext.sdk.concretesyntax.Cardinality parse_org_emftext_sdk_concretesyntax_Cardinality() throws RecognitionException {
        org.emftext.sdk.concretesyntax.Cardinality element =  null;
        int parse_org_emftext_sdk_concretesyntax_Cardinality_StartIndex = input.index();
        org.emftext.sdk.concretesyntax.PLUS c0 = null;

        org.emftext.sdk.concretesyntax.STAR c1 = null;

        org.emftext.sdk.concretesyntax.QUESTIONMARK c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }
            // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2435:1: (c0= parse_org_emftext_sdk_concretesyntax_PLUS | c1= parse_org_emftext_sdk_concretesyntax_STAR | c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt36=1;
                }
                break;
            case 42:
                {
                alt36=2;
                }
                break;
            case 43:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2436:2: c0= parse_org_emftext_sdk_concretesyntax_PLUS
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality3544);
                    c0=parse_org_emftext_sdk_concretesyntax_PLUS();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; 
                    }

                    }
                    break;
                case 2 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2437:4: c1= parse_org_emftext_sdk_concretesyntax_STAR
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality3554);
                    c1=parse_org_emftext_sdk_concretesyntax_STAR();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; 
                    }

                    }
                    break;
                case 3 :
                    // C:\\Projekte\\Eclipse-Workspaces\\EMFText-Languages-DEV\\org.emftext.sdk.concretesyntax.resource.cs\\src\\org\\emftext\\sdk\\concretesyntax\\resource\\cs\\Cs.g:2438:4: c2= parse_org_emftext_sdk_concretesyntax_QUESTIONMARK
                    {
                    pushFollow(FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality3564);
                    c2=parse_org_emftext_sdk_concretesyntax_QUESTIONMARK();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; 
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


    protected DFA35 dfa35 = new DFA35(this);
    static final String DFA35_eotS =
        "\13\uffff";
    static final String DFA35_eofS =
        "\2\uffff\1\6\10\uffff";
    static final String DFA35_minS =
        "\1\4\1\uffff\1\4\4\uffff\1\4\3\uffff";
    static final String DFA35_maxS =
        "\1\44\1\uffff\1\53\4\uffff\1\41\3\uffff";
    static final String DFA35_acceptS =
        "\1\uffff\1\1\1\uffff\1\6\1\7\1\10\1\5\1\uffff\1\4\1\3\1\2";
    static final String DFA35_specialS =
        "\13\uffff}>";
    static final String[] DFA35_transitionS = {
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

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "2421:1: parse_org_emftext_sdk_concretesyntax_Definition returns [org.emftext.sdk.concretesyntax.Definition element = null] : (c0= parse_org_emftext_sdk_concretesyntax_CsString | c1= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken | c2= parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken | c3= parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes | c4= parse_org_emftext_sdk_concretesyntax_Containment | c5= parse_org_emftext_sdk_concretesyntax_CompoundDefinition | c6= parse_org_emftext_sdk_concretesyntax_WhiteSpaces | c7= parse_org_emftext_sdk_concretesyntax_LineBreak );";
        }
    }
 

    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax_in_start79 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax124 = new BitSet(new long[]{0x0000500000004000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Abstract_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax166 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax189 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax204 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax222 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax237 = new BitSet(new long[]{0x0000000003A50020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax270 = new BitSet(new long[]{0x0000000003A50000L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax317 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax345 = new BitSet(new long[]{0x0000000003A60000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax399 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax435 = new BitSet(new long[]{0x0000000003A60000L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax527 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax542 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Import_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax578 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax627 = new BitSet(new long[]{0x0000000003A00000L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax661 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax676 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Option_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax712 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax743 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax780 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax814 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax829 = new BitSet(new long[]{0x0000512000104000L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenDirective_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax865 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax896 = new BitSet(new long[]{0x0000512000104000L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax933 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax967 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax982 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenStyle_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1018 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1067 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1092 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1103 = new BitSet(new long[]{0x0000500000004010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Rule_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1129 = new BitSet(new long[]{0x0000500000104010L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_sdk_concretesyntax_ConcreteSyntax1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1192 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Import1210 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1225 = new BitSet(new long[]{0x0000000008000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1258 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_sdk_concretesyntax_Import1305 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_sdk_concretesyntax_Import1320 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Import1341 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_emftext_sdk_concretesyntax_Import1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Option1475 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_Option1493 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_sdk_concretesyntax_Option1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_Rule1556 = new BitSet(new long[]{0x0000500000004010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Rule1593 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_sdk_concretesyntax_Rule1611 = new BitSet(new long[]{0x0000001400000150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_Rule1626 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_Rule1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Definition_in_parse_org_emftext_sdk_concretesyntax_Sequence1676 = new BitSet(new long[]{0x0000001400000152L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice1718 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_sdk_concretesyntax_Choice1742 = new BitSet(new long[]{0x0000001400000150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Sequence_in_parse_org_emftext_sdk_concretesyntax_Choice1763 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_sdk_concretesyntax_CsString1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1852 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1870 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1885 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1903 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken1965 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken1983 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken1994 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2056 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2074 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2089 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2107 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_39_39_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2122 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2140 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2202 = new BitSet(new long[]{0x00000E0004000002L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_sdk_concretesyntax_Containment2229 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2250 = new BitSet(new long[]{0x00000E0000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Containment2291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Containment2318 = new BitSet(new long[]{0x00000E0000020002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_Containment2393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2431 = new BitSet(new long[]{0x0000001400000150L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Choice_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2446 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2461 = new BitSet(new long[]{0x00000E0000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Cardinality_in_parse_org_emftext_sdk_concretesyntax_CompoundDefinition2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_WhiteSpaces2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_parse_org_emftext_sdk_concretesyntax_LineBreak2556 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NUMBER_in_parse_org_emftext_sdk_concretesyntax_LineBreak2571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Annotation_in_parse_org_emftext_sdk_concretesyntax_NormalToken2619 = new BitSet(new long[]{0x0000502000004000L});
    public static final BitSet FOLLOW_37_in_parse_org_emftext_sdk_concretesyntax_NormalToken2652 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken2667 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_QUOTED_36_36_in_parse_org_emftext_sdk_concretesyntax_NormalToken2689 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_parse_org_emftext_sdk_concretesyntax_NormalToken2716 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_parse_org_emftext_sdk_concretesyntax_NormalToken2731 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_NormalToken2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective2805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_parse_org_emftext_sdk_concretesyntax_PLUS2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_parse_org_emftext_sdk_concretesyntax_STAR2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK2905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_parse_org_emftext_sdk_concretesyntax_Abstract2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_sdk_concretesyntax_TokenStyle2961 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_org_emftext_sdk_concretesyntax_TokenStyle2979 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_HEXNUMBER_in_parse_org_emftext_sdk_concretesyntax_TokenStyle2994 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3021 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3042 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_sdk_concretesyntax_TokenStyle3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_parse_org_emftext_sdk_concretesyntax_Annotation3106 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_Annotation3121 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_sdk_concretesyntax_Annotation3148 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation3169 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_sdk_concretesyntax_Annotation3205 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_KeyValuePair_in_parse_org_emftext_sdk_concretesyntax_Annotation3232 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_35_in_parse_org_emftext_sdk_concretesyntax_Annotation3281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3325 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3352 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_emftext_sdk_concretesyntax_KeyValuePair3373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_NormalToken_in_parse_org_emftext_sdk_concretesyntax_TokenDirective3422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_TokenPriorityDirective_in_parse_org_emftext_sdk_concretesyntax_TokenDirective3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CsString_in_parse_org_emftext_sdk_concretesyntax_Definition3453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingSpecifiedToken_in_parse_org_emftext_sdk_concretesyntax_Definition3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderUsingDefaultToken_in_parse_org_emftext_sdk_concretesyntax_Definition3473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PlaceholderInQuotes_in_parse_org_emftext_sdk_concretesyntax_Definition3483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_Containment_in_parse_org_emftext_sdk_concretesyntax_Definition3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_CompoundDefinition_in_parse_org_emftext_sdk_concretesyntax_Definition3503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_WhiteSpaces_in_parse_org_emftext_sdk_concretesyntax_Definition3513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_LineBreak_in_parse_org_emftext_sdk_concretesyntax_Definition3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_PLUS_in_parse_org_emftext_sdk_concretesyntax_Cardinality3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_STAR_in_parse_org_emftext_sdk_concretesyntax_Cardinality3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_sdk_concretesyntax_QUESTIONMARK_in_parse_org_emftext_sdk_concretesyntax_Cardinality3564 = new BitSet(new long[]{0x0000000000000002L});

}