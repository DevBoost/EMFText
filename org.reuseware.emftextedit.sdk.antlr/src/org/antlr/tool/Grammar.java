/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.tool;

import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStreamRewriteEngine;
import antlr.TokenWithIndex;
import antlr.collections.AST;
import org.antlr.Tool;
import org.antlr.analysis.*;
import org.antlr.codegen.CodeGenerator;
import org.antlr.misc.Barrier;
import org.antlr.misc.IntSet;
import org.antlr.misc.IntervalSet;
import org.antlr.misc.Utils;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;

import java.io.*;
import java.util.*;

/** Represents a grammar in memory. */
public class Grammar {
	public static final String SYNPRED_RULE_PREFIX = "synpred";

	public static final String GRAMMAR_FILE_EXTENSION = ".g";

	/** used for generating lexer temp files */
	public static final String LEXER_GRAMMAR_FILE_EXTENSION = ".g";

	public static final int INITIAL_DECISION_LIST_SIZE = 300;
	public static final int INVALID_RULE_INDEX = -1;

	// the various kinds of labels. t=type, id=ID, types+=type ids+=ID
	public static final int RULE_LABEL = 1;
	public static final int TOKEN_LABEL = 2;
	public static final int RULE_LIST_LABEL = 3;
	public static final int TOKEN_LIST_LABEL = 4;
	public static final int CHAR_LABEL = 5; // used in lexer for x='a'

	public static String[] LabelTypeToString =
		{"<invalid>", "rule", "token", "rule-list", "token-list"};

    public static final String ARTIFICIAL_TOKENS_RULENAME = "Tokens";
	public static final String FRAGMENT_RULE_MODIFIER = "fragment";

	public static final String SYNPREDGATE_ACTION_NAME = "synpredgate";

	/** When converting ANTLR char and string literals, here is the
	 *  value set of escape chars.
	 */
	public static int ANTLRLiteralEscapedCharValue[] = new int[255];

	/** Given a char, we need to be able to show as an ANTLR literal.
	 */
	public static String ANTLRLiteralCharValueEscape[] = new String[255];

	static {
		ANTLRLiteralEscapedCharValue['n'] = '\n';
		ANTLRLiteralEscapedCharValue['r'] = '\r';
		ANTLRLiteralEscapedCharValue['t'] = '\t';
		ANTLRLiteralEscapedCharValue['b'] = '\b';
		ANTLRLiteralEscapedCharValue['f'] = '\f';
		ANTLRLiteralEscapedCharValue['\\'] = '\\';
		ANTLRLiteralEscapedCharValue['\''] = '\'';
		ANTLRLiteralEscapedCharValue['"'] = '"';
		ANTLRLiteralCharValueEscape['\n'] = "\\n";
		ANTLRLiteralCharValueEscape['\r'] = "\\r";
		ANTLRLiteralCharValueEscape['\t'] = "\\t";
		ANTLRLiteralCharValueEscape['\b'] = "\\b";
		ANTLRLiteralCharValueEscape['\f'] = "\\f";
		ANTLRLiteralCharValueEscape['\\'] = "\\\\";
		ANTLRLiteralCharValueEscape['\''] = "\\'";
	}

    public static final int LEXER = 1;
    public static final int PARSER = 2;
	public static final int TREE_PARSER = 3;
	public static final int COMBINED = 4;
	public static final String[] grammarTypeToString = new String[] {
		"<invalid>",
		"lexer",
		"parser",
		"tree",
		"combined"
	};

	public static final String[] grammarTypeToFileNameSuffix = new String[] {
		"<invalid>",
		"Lexer",
		"Parser",
		"", // no suffix for tree grammars
		"Parser" // if combined grammar, gen Parser and Lexer will be done later
	};

	/** This is the buffer of *all* tokens found in the grammar file
	 *  including whitespace tokens etc...  I use this to extract
	 *  lexer rules from combined grammars.
	 */
	protected TokenStreamRewriteEngine tokenBuffer;
	public static final String IGNORE_STRING_IN_GRAMMAR_FILE_NAME = "__";

	public static class Decision {
		public int decision;
		public NFAState startState;
		public GrammarAST blockAST;
		public DFA dfa;
	}

	public class LabelElementPair {
		public antlr.Token label;
		public GrammarAST elementRef;
		public String referencedRuleName;
		/** Has an action referenced the label?  Set by ActionAnalysis.g
		 *  Currently only set for rule labels.
		 */
		public boolean actionReferencesLabel;
		public int type; // in {RULE_LABEL,TOKEN_LABEL,RULE_LIST_LABEL,TOKEN_LIST_LABEL}
		public LabelElementPair(antlr.Token label, GrammarAST elementRef) {
			this.label = label;
			this.elementRef = elementRef;
			this.referencedRuleName = elementRef.getText();
		}
		public Rule getReferencedRule() {
			return getRule(referencedRuleName);
		}
		public String toString() {
			return elementRef.toString();
		}
	}

	/** What name did the user provide for this grammar? */
	public String name;

    /** What type of grammar is this: lexer, parser, tree walker */
    public int type;

    /** A list of options specified at the grammar level such as language=Java.
     *  The value can be an AST for complicated values such as character sets.
     *  There may be code generator specific options in here.  I do no
     *  interpretation of the key/value pairs...they are simply available for
     *  who wants them.
     */
    protected Map options;

	public static final Set legalOptions =
			new HashSet() {
				{
				add("language"); add("tokenVocab");
				add("output"); add("rewrite"); add("ASTLabelType");
				add("TokenLabelType");
				add("superClass");
				add("filter");
				add("k");
				add("backtrack");
				add("memoize");
				}
			};

	public static final Set doNotCopyOptionsToLexer =
		new HashSet() {
			{
				add("output"); add("ASTLabelType"); add("superClass");
			 	add("k"); add("backtrack"); add("memoize"); add("rewrite");
			}
		};

	public static final Map defaultOptions =
			new HashMap() {
				{
					put("language","Java");
				}
			};

	/** Is there a global fixed lookahead set for this grammar?
	 *  If 0, nothing specified.  -1 implies we have not looked at
	 *  the options table yet to set k.
	 */
	protected int global_k = -1;

	/** Map a scope to a map of name:action pairs.
	 *  Map<String, Map<String,GrammarAST>>
	 *  The code generator will use this to fill holes in the output files.
	 *  I track the AST node for the action in case I need the line number
	 *  for errors.
	 */
	protected Map actions = new HashMap();

	/** The NFA that represents the grammar with edges labelled with tokens
     *  or epsilon.  It is more suitable to analysis than an AST representation.
     */
    protected NFA nfa;

    /** Token names and literal tokens like "void" are uniquely indexed.
     *  with -1 implying EOF.  Characters are different; they go from
     *  -1 (EOF) to \uFFFE.  For example, 0 could be a binary byte you
     *  want to lexer.  Labels of DFA/NFA transitions can be both tokens
     *  and characters.  I use negative numbers for bookkeeping labels
     *  like EPSILON. Char/String literals and token types overlap in the same
	 *  space, however.
     */
    protected int maxTokenType = Label.MIN_TOKEN_TYPE-1;

	/** TODO: hook this to the charVocabulary option */
	protected IntSet charVocabulary = null;

    /** Map token like ID (but not literals like "while") to its token type */
    protected Map tokenIDToTypeMap = new HashMap();

    /** Map token literals like "while" to its token type.  It may be that
     *  WHILE="while"=35, in which case both tokenNameToTypeMap and this
     *  field will have entries both mapped to 35.
     */
    protected Map stringLiteralToTypeMap = new HashMap();

    /** Map a token type to its token name.
	 *  Must subtract MIN_TOKEN_TYPE from index.
	 */
    protected Vector typeToTokenList = new Vector();

	/** For interpreting and testing, you sometimes want to import token
	 *  definitions from another grammar (instead of reading token defs from
	 *  a file).
	 */
	protected Grammar importTokenVocabularyFromGrammar;

	/** For ANTLRWorks, we want to be able to map a line:col to a specific
	 *  decision DFA so it can display DFA.
	 */
	Map lineColumnToLookaheadDFAMap = new HashMap();

	public Tool tool;

	/** The unique set of all rule references in any rule; set of Token
	 *  objects so two refs to same rule can exist but at different line/position.
	 */
	protected Set<antlr.Token> ruleRefs = new HashSet<antlr.Token>();

	/** The unique set of all token ID references in any rule */
	protected Set<antlr.Token> tokenIDRefs = new HashSet<antlr.Token>();

	/** If combined or lexer grammar, track the rules; Set<String>.
	 * 	Track lexer rules so we can warn about undefined tokens.
 	 */
	protected Set<String> lexerRules = new HashSet<String>();

    /** Be able to assign a number to every decision in grammar;
     *  decisions in 1..n
     */
    protected int decisionNumber = 0;

    /** Rules are uniquely labeled from 1..n */
    protected int ruleIndex = 1;

	/** A list of all rules that are in any left-recursive cycle.  There
	 *  could be multiple cycles, but this is a flat list of all problematic
	 *  rules.
	 */
	protected Set leftRecursiveRules;

	/** An external tool requests that DFA analysis abort prematurely.  Stops
	 *  at DFA granularity, which are limited to a DFA size and time computation
	 *  as failsafe.
	 */
	protected boolean externalAnalysisAbort;

	/** When we read in a grammar, we track the list of syntactic predicates
	 *  and build faux rules for them later.  See my blog entry Dec 2, 2005:
	 *  http://www.antlr.org/blog/antlr3/lookahead.tml
	 *  This maps the name (we make up) for a pred to the AST grammar fragment.
	 */
	protected LinkedHashMap nameToSynpredASTMap;

	/** Map a rule to it's Rule object
	 */
	protected LinkedHashMap nameToRuleMap = new LinkedHashMap();

	/** Track the scopes defined outside of rules and the scopes associated
	 *  with all rules (even if empty).
	 */
	protected Map scopes = new HashMap();

	/** Map a rule index to its name; use a Vector on purpose as new
	 *  collections stuff won't let me setSize and make it grow.  :(
	 *  I need a specific guaranteed index, which the Collections stuff
	 *  won't let me have.
	 */
	protected Vector ruleIndexToRuleList = new Vector();

    /** An AST that records entire input grammar with all rules.  A simple
     *  grammar with one rule, "grammar t; a : A | B ;", looks like:
     * ( grammar t ( rule a ( BLOCK ( ALT A ) ( ALT B ) ) <end-of-rule> ) )
     */
    protected GrammarAST grammarTree = null;

    /** Each subrule/rule is a decision point and we must track them so we
     *  can go back later and build DFA predictors for them.  This includes
     *  all the rules, subrules, optional blocks, ()+, ()* etc...  The
     *  elements in this list are NFAState objects.
     */
	protected Vector indexToDecision = new Vector(INITIAL_DECISION_LIST_SIZE);

    /** If non-null, this is the code generator we will use to generate
     *  recognizers in the target language.
     */
    protected CodeGenerator generator;

	NameSpaceChecker nameSpaceChecker = new NameSpaceChecker(this);

	/** Used during LOOK to detect computation cycles */
	protected Set lookBusy = new HashSet();

	/** The checkForLeftRecursion method needs to track what rules it has
	 *  visited to track infinite recursion.
	 */
	protected Set visitedDuringRecursionCheck = null;

	protected boolean watchNFAConversion = false;

	/** For merged lexer/parsers, we must construct a separate lexer spec.
	 *  This is the template for lexer; put the literals first then the
	 *  regular rules.  We don't need to specify a token vocab import as
	 *  I make the new grammar import from the old all in memory; don't want
	 *  to force it to read from the disk.  Lexer grammar will have same
	 *  name as original grammar but will be in different filename.  Foo.g
	 *  with combined grammar will have FooParser.java generated and
	 *  Foo__.g with again Foo inside.  It will however generate FooLexer.java
	 *  as it's a lexer grammar.  A bit odd, but autogenerated.  Can tweak
	 *  later if we want.
	 */
	protected StringTemplate lexerGrammarST =
		new StringTemplate(
			"lexer grammar <name>;\n" +
			"<if(options)>" +
			"options {\n" +
			"  <options:{<it.name>=<it.value>;<\\n>}>\n" +
			"}<\\n>\n" +
			"<endif>\n" +
			"<actionNames,actions:{n,a|@<n> {<a>}\n}>\n" +
			"<literals:{<it.ruleName> : <it.literal> ;\n}>\n" +
			"<rules>",
			AngleBracketTemplateLexer.class
		);

	/** What file name holds this grammar? */
	protected String fileName;

	/** How long in ms did it take to build DFAs for this grammar?
	 *  If this grammar is a combined grammar, it only records time for
	 *  the parser grammar component.  This only records the time to
	 *  do the LL(*) work; NFA->DFA conversion.
	 */
	public long DFACreationWallClockTimeInMS;

	public int numberOfSemanticPredicates = 0;
	public int numberOfManualLookaheadOptions = 0;
	public Set setOfNondeterministicDecisionNumbers = new HashSet();
	public Set setOfNondeterministicDecisionNumbersResolvedWithPredicates = new HashSet();
	public Set setOfDFAWhoseConversionTerminatedEarly = new HashSet();

	/** Track decisions with syn preds specified for reporting.
	 *  This is the a set of BLOCK type AST nodes.
	 */
	public Set<GrammarAST> blocksWithSynPreds = new HashSet();

	/** Track decisions that actually use the syn preds in the DFA.
	 *  Computed during NFA to DFA conversion.
	 */
	public Set<DFA> decisionsWhoseDFAsUsesSynPreds = new HashSet();

	/** Track names of preds so we can avoid generating preds that aren't used
	 *  Computed during NFA to DFA conversion.  Just walk accept states
	 *  and look for synpreds because that is the only state target whose
	 *  incident edges can have synpreds.  Same is try for
	 *  decisionsWhoseDFAsUsesSynPreds.
	 */
	public Set<String> synPredNamesUsedInDFA = new HashSet();

	/** Track decisions with syn preds specified for reporting.
	 *  This is the a set of BLOCK type AST nodes.
	 */
	public Set<GrammarAST> blocksWithSemPreds = new HashSet();

	/** Track decisions that actually use the syn preds in the DFA. Set<DFA> */
	public Set decisionsWhoseDFAsUsesSemPreds = new HashSet();

	protected boolean allDecisionDFACreated = false;

	/** We need a way to detect when a lexer grammar is autogenerated from
	 *  another grammar or we are just sending in a string representing a
	 *  grammar.  We don't want to generate a .tokens file, for example,
	 *  in such cases.
	 */
	protected boolean builtFromString = false;

	/** Factored out the sanity checking code; delegate to it. */
	GrammarSanity sanity = new GrammarSanity(this);

	public Grammar() {
		initTokenSymbolTables();
		builtFromString = true;
	}

	public Grammar(String grammarString)
			throws antlr.RecognitionException, antlr.TokenStreamException
	{
		builtFromString = true;
		initTokenSymbolTables();
		setFileName("<string>");
		setGrammarContent(new StringReader(grammarString));
	}

	public Grammar(String fileName, String grammarString)
			throws antlr.RecognitionException, antlr.TokenStreamException
	{
		this(null, fileName, new StringReader(grammarString));
	}

    /** Create a grammar from a Reader.  Parse the grammar, building a tree
     *  and loading a symbol table of sorts here in Grammar.  Then create
     *  an NFA and associated factory.  Walk the AST representing the grammar,
     *  building the state clusters of the NFA.
     */
    public Grammar(Tool tool, String fileName, Reader r)
            throws antlr.RecognitionException, antlr.TokenStreamException
    {
		initTokenSymbolTables();
		setTool(tool);
		setFileName(fileName);
		setGrammarContent(r);
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setName(String name) {
		if ( name==null ) {
			return;
		}
		// don't error check autogenerated files (those with '__' in them)
		String saneFile = fileName.replace('\\', '/');
		int lastSlash = saneFile.lastIndexOf('/');
		String onlyFileName = saneFile.substring(lastSlash+1, fileName.length());
		if ( !builtFromString ) {
			int lastDot = onlyFileName.lastIndexOf('.');
			String onlyFileNameNoSuffix = null;
			if ( lastDot < 0 ) {
				ErrorManager.error(ErrorManager.MSG_FILENAME_EXTENSION_ERROR, fileName);
				onlyFileNameNoSuffix = onlyFileName+GRAMMAR_FILE_EXTENSION;
			}
			else {
				onlyFileNameNoSuffix = onlyFileName.substring(0,lastDot);
			}
			if ( !name.equals(onlyFileNameNoSuffix) ) {
				ErrorManager.error(ErrorManager.MSG_FILE_AND_GRAMMAR_NAME_DIFFER,
								   name,
								   fileName);
			}
		}
		this.name = name;
	}

	public void setGrammarContent(String grammarString)
		throws antlr.RecognitionException, antlr.TokenStreamException
	{
		setGrammarContent(new StringReader(grammarString));
	}

	public void setGrammarContent(Reader r)
		throws antlr.RecognitionException, antlr.TokenStreamException
	{
		ErrorManager.resetErrorState(); // reset in case > 1 grammar in same thread

		// BUILD AST FROM GRAMMAR
		ANTLRLexer lexer = new ANTLRLexer(r);
		lexer.setFilename(this.getFileName());
		// use the rewrite engine because we want to buffer up all tokens
		// in case they have a merged lexer/parser, send lexer rules to
		// new grammar.
		lexer.setTokenObjectClass("antlr.TokenWithIndex");
		tokenBuffer = new TokenStreamRewriteEngine(lexer);
		tokenBuffer.discard(ANTLRParser.WS);
		tokenBuffer.discard(ANTLRParser.ML_COMMENT);
		tokenBuffer.discard(ANTLRParser.COMMENT);
		tokenBuffer.discard(ANTLRParser.SL_COMMENT);
		ANTLRParser parser = new ANTLRParser(tokenBuffer);
		parser.getASTFactory().setASTNodeClass(GrammarAST.class);
		parser.setFilename(this.getFileName());
		parser.setASTNodeClass("org.antlr.tool.GrammarAST");
		parser.grammar(this);
		grammarTree = (GrammarAST)parser.getAST();
		setFileName(lexer.getFilename()); // the lexer #src might change name
		if ( grammarTree.findFirstType(ANTLRParser.RULE)==null ) {
			ErrorManager.error(ErrorManager.MSG_NO_RULES, getFileName());
			return;
		}

		// Get syn pred rules and add to existing tree
		List synpredRules =
			getArtificialRulesForSyntacticPredicates(parser,
												 	 nameToSynpredASTMap);
		for (int i = 0; i < synpredRules.size(); i++) {
			GrammarAST rAST = (GrammarAST) synpredRules.get(i);
			grammarTree.addChild(rAST);
		}

		if ( Tool.internalOption_PrintGrammarTree ) {
			System.out.println(grammarTree.toStringList());
		}

		// ASSIGN TOKEN TYPES
		//System.out.println("### assign types");
		AssignTokenTypesWalker ttypesWalker = new AssignTokenTypesWalker();
		ttypesWalker.setASTNodeClass("org.antlr.tool.GrammarAST");
		try {
			ttypesWalker.grammar(grammarTree, this);
		}
		catch (RecognitionException re) {
			ErrorManager.error(ErrorManager.MSG_BAD_AST_STRUCTURE,
							   re);
		}

		// DEFINE RULES
		//System.out.println("### define rules");
		DefineGrammarItemsWalker defineItemsWalker = new DefineGrammarItemsWalker();
		defineItemsWalker.setASTNodeClass("org.antlr.tool.GrammarAST");
		try {
			defineItemsWalker.grammar(grammarTree, this);
		}
		catch (RecognitionException re) {
			ErrorManager.error(ErrorManager.MSG_BAD_AST_STRUCTURE,
							   re);
		}

		// ANALYZE ACTIONS, LOOKING FOR LABEL AND ATTR REFS
		examineAllExecutableActions();
		checkAllRulesForUselessLabels();

		nameSpaceChecker.checkConflicts();
	}

	/** If the grammar is a merged grammar, return the text of the implicit
	 *  lexer grammar.
	 */
	public String getLexerGrammar() {
		if ( lexerGrammarST.getAttribute("literals")==null &&
			 lexerGrammarST.getAttribute("rules")==null )
		{
			// if no rules, return nothing
			return null;
		}
		lexerGrammarST.setAttribute("name", name);
		// if there are any actions set for lexer, pass them in
		if ( actions.get("lexer")!=null ) {
			lexerGrammarST.setAttribute("actionNames",
										((Map)actions.get("lexer")).keySet());
			lexerGrammarST.setAttribute("actions",
										((Map)actions.get("lexer")).values());
		}
		// make sure generated grammar has the same options
		if ( options!=null ) {
			Iterator optionNames = options.keySet().iterator();
			while (optionNames.hasNext()) {
				String optionName = (String) optionNames.next();
				if ( !doNotCopyOptionsToLexer.contains(optionName) ) {
					Object value = options.get(optionName);
					lexerGrammarST.setAttribute("options.{name,value}", optionName, value);
				}
			}
		}
		return lexerGrammarST.toString();
	}

	public String getImplicitlyGeneratedLexerFileName() {
		return name+
			IGNORE_STRING_IN_GRAMMAR_FILE_NAME +
			LEXER_GRAMMAR_FILE_EXTENSION;
	}

	public File getImportedVocabFileName(String vocabName) {
		return new File(tool.getLibraryDirectory(),
						File.separator+
							vocabName+
							CodeGenerator.VOCAB_FILE_EXTENSION);
	}

	/** Parse a rule we add artificially that is a list of the other lexer
     *  rules like this: "Tokens : ID | INT | SEMI ;"  nextToken() will invoke
     *  this to set the current token.  Add char literals before
     *  the rule references.
	 *
	 *  If in filter mode, we want every alt to backtrack and we need to
	 *  do k=1 to force the "first token def wins" rule.  Otherwise, the
	 *  longest-match rule comes into play with LL(*).
	 *
	 *  The ANTLRParser antlr.g file now invokes this when parsing a lexer
	 *  grammar, which I think is proper even though it peeks at the info
	 *  that later phases will compute.  It gets a list of lexer rules
	 *  and builds a string representing the rule; then it creates a parser
	 *  and adds the resulting tree to the grammar's tree.
     */
    public GrammarAST addArtificialMatchTokensRule(GrammarAST grammarAST,
												   List ruleNames,
												   boolean filterMode) {
		StringTemplate matchTokenRuleST = null;
		if ( filterMode ) {
			matchTokenRuleST = new StringTemplate(
					ARTIFICIAL_TOKENS_RULENAME+
						" options {k=1; backtrack=true;} : <rules; separator=\"|\">;",
					AngleBracketTemplateLexer.class);
		}
		else {
			matchTokenRuleST = new StringTemplate(
					ARTIFICIAL_TOKENS_RULENAME+" : <rules; separator=\"|\">;",
					AngleBracketTemplateLexer.class);
		}

		// Now add token rule references
		for (int i = 0; i < ruleNames.size(); i++) {
			String rname = (String) ruleNames.get(i);
			matchTokenRuleST.setAttribute("rules", rname);
		}
		//System.out.println("tokens rule: "+matchTokenRuleST.toString());

        ANTLRLexer lexer = new ANTLRLexer(new StringReader(matchTokenRuleST.toString()));
		lexer.setTokenObjectClass("antlr.TokenWithIndex");
		TokenStreamRewriteEngine tokbuf =
			new TokenStreamRewriteEngine(lexer);
		tokbuf.discard(ANTLRParser.WS);
		tokbuf.discard(ANTLRParser.ML_COMMENT);
		tokbuf.discard(ANTLRParser.COMMENT);
		tokbuf.discard(ANTLRParser.SL_COMMENT);
        ANTLRParser parser = new ANTLRParser(tokbuf);
		parser.grammar = this;
		parser.gtype = ANTLRParser.LEXER_GRAMMAR;
        parser.setASTNodeClass("org.antlr.tool.GrammarAST");
        try {
            parser.rule();
			if ( Tool.internalOption_PrintGrammarTree ) {
				System.out.println("Tokens rule: "+parser.getAST().toStringTree());
			}
			GrammarAST p = grammarAST;
			while ( p.getType()!=ANTLRParser.LEXER_GRAMMAR ) {
				p = (GrammarAST)p.getNextSibling();
			}
			p.addChild(parser.getAST());
        }
        catch (Exception e) {
			ErrorManager.error(ErrorManager.MSG_ERROR_CREATING_ARTIFICIAL_RULE,
							   e);
        }
		return (GrammarAST)parser.getAST();
	}

	/** for any syntactic predicates, we need to define rules for them; they will get
	 *  defined automatically like any other rule. :)
	 */
	protected List getArtificialRulesForSyntacticPredicates(ANTLRParser parser,
															LinkedHashMap nameToSynpredASTMap)
	{
		List rules = new ArrayList();
		if ( nameToSynpredASTMap==null ) {
			return rules;
		}
		Set predNames = nameToSynpredASTMap.keySet();
		boolean isLexer = grammarTree.getType()==ANTLRParser.LEXER_GRAMMAR;
		for (Iterator it = predNames.iterator(); it.hasNext();) {
			String synpredName = (String)it.next();
			GrammarAST fragmentAST =
				(GrammarAST) nameToSynpredASTMap.get(synpredName);
			GrammarAST ruleAST =
				parser.createSimpleRuleAST(synpredName,
										   fragmentAST,
										   isLexer);
			rules.add(ruleAST);
		}
		return rules;
	}

	protected void initTokenSymbolTables() {
        // the faux token types take first NUM_FAUX_LABELS positions
		// then we must have room for the predefined runtime token types
		// like DOWN/UP used for tree parsing.
        typeToTokenList.setSize(Label.NUM_FAUX_LABELS+Label.MIN_TOKEN_TYPE-1);
        typeToTokenList.set(Label.NUM_FAUX_LABELS+Label.INVALID, "<INVALID>");
        typeToTokenList.set(Label.NUM_FAUX_LABELS+Label.EOT, "<EOT>");
        typeToTokenList.set(Label.NUM_FAUX_LABELS+Label.SEMPRED, "<SEMPRED>");
        typeToTokenList.set(Label.NUM_FAUX_LABELS+Label.SET, "<SET>");
        typeToTokenList.set(Label.NUM_FAUX_LABELS+Label.EPSILON, Label.EPSILON_STR);
		typeToTokenList.set(Label.NUM_FAUX_LABELS+Label.EOF, "EOF");
		typeToTokenList.set(Label.NUM_FAUX_LABELS+Label.EOR_TOKEN_TYPE-1, "<EOR>");
		typeToTokenList.set(Label.NUM_FAUX_LABELS+Label.DOWN-1, "DOWN");
		typeToTokenList.set(Label.NUM_FAUX_LABELS+Label.UP-1, "UP");
        tokenIDToTypeMap.put("<INVALID>", Utils.integer(Label.INVALID));
        tokenIDToTypeMap.put("<EOT>", Utils.integer(Label.EOT));
        tokenIDToTypeMap.put("<SEMPRED>", Utils.integer(Label.SEMPRED));
        tokenIDToTypeMap.put("<SET>", Utils.integer(Label.SET));
        tokenIDToTypeMap.put("<EPSILON>", Utils.integer(Label.EPSILON));
		tokenIDToTypeMap.put("EOF", Utils.integer(Label.EOF));
		tokenIDToTypeMap.put("<EOR>", Utils.integer(Label.EOR_TOKEN_TYPE));
		tokenIDToTypeMap.put("DOWN", Utils.integer(Label.DOWN));
		tokenIDToTypeMap.put("UP", Utils.integer(Label.UP));
    }

    /** Walk the list of options, altering this Grammar object according
     *  to any I recognize.
    protected void processOptions() {
        Iterator optionNames = options.keySet().iterator();
        while (optionNames.hasNext()) {
            String optionName = (String) optionNames.next();
            Object value = options.get(optionName);
            if ( optionName.equals("tokenVocab") ) {

            }
        }
    }
     */

    public void createNFAs() {
		//System.out.println("### create NFAs");
		if ( nfa!=null ) {
			// don't let it create more than once; has side-effects
			return;
		}
		if ( getRules().size()==0 ) {
			return;
		}
		nfa = new NFA(this); // create NFA that TreeToNFAConverter'll fill in
		NFAFactory factory = new NFAFactory(nfa);
		TreeToNFAConverter nfaBuilder = new TreeToNFAConverter(this, nfa, factory);
		try {
			nfaBuilder.grammar(grammarTree);
		}
		catch (RecognitionException re) {
			ErrorManager.error(ErrorManager.MSG_BAD_AST_STRUCTURE,
							   name,
							   re);
		}
		//System.out.println("NFA has "+factory.getNumberOfStates()+" states");
	}

	/** For each decision in this grammar, compute a single DFA using the
     *  NFA states associated with the decision.  The DFA construction
     *  determines whether or not the alternatives in the decision are
     *  separable using a regular lookahead language.
     *
     *  Store the lookahead DFAs in the AST created from the user's grammar
     *  so the code generator or whoever can easily access it.
     *
     *  This is a separate method because you might want to create a
     *  Grammar without doing the expensive analysis.
     */
    public void createLookaheadDFAs() {
		if ( nfa==null ) {
			createNFAs();
		}

		long start = System.currentTimeMillis();

		//System.out.println("### create DFAs");
		int numDecisions = getNumberOfDecisions();
		if ( NFAToDFAConverter.SINGLE_THREADED_NFA_CONVERSION ) {
			for (int decision=1; decision<=numDecisions; decision++) {
				NFAState decisionStartState = getDecisionNFAStartState(decision);
				if ( !externalAnalysisAbort && decisionStartState.getNumberOfTransitions()>1 ) {
					createLookaheadDFA(decision);
				}
			}
		}
		else {
			ErrorManager.info("two-threaded DFA conversion");
			// create a barrier expecting n DFA and this main creation thread
			Barrier barrier = new Barrier(3);
			// assume 2 CPU for now
			int midpoint = numDecisions/2;
			NFAConversionThread t1 =
				new NFAConversionThread(this, barrier, 1, midpoint);
			new Thread(t1).start();
			if ( midpoint == (numDecisions/2) ) {
				midpoint++;
			}
			NFAConversionThread t2 =
				new NFAConversionThread(this, barrier, midpoint, numDecisions);
			new Thread(t2).start();
			// wait for these two threads to finish
			try {
				barrier.waitForRelease();
			}
			catch(InterruptedException e) {
				ErrorManager.internalError("what the hell? DFA interruptus", e);
			}
		}

		long stop = System.currentTimeMillis();
		DFACreationWallClockTimeInMS = stop - start;

		// indicate that we've finished building DFA (even if #decisions==0)
		allDecisionDFACreated = true;
	}

	public void createLookaheadDFA(int decision) {
		Decision d = getDecision(decision);
		String enclosingRule = d.startState.getEnclosingRule();
		Rule r = getRule(enclosingRule);

		//System.out.println("createLookaheadDFA(): "+enclosingRule+" dec "+decision+"; synprednames prev used "+synPredNamesUsedInDFA);
		if ( r.isSynPred && !synPredNamesUsedInDFA.contains(enclosingRule) ) {
			return;
		}
		NFAState decisionStartState = getDecisionNFAStartState(decision);
		long startDFA=0,stopDFA=0;
		if ( watchNFAConversion ) {
			System.out.println("--------------------\nbuilding lookahead DFA (d="
							   +decisionStartState.getDecisionNumber()+") for "+
							   decisionStartState.getDescription());
			startDFA = System.currentTimeMillis();
		}
		DFA lookaheadDFA = new DFA(decision, decisionStartState);
		if ( (lookaheadDFA.analysisAborted() && // did analysis bug out?
			 lookaheadDFA.getUserMaxLookahead()!=1) || // either k=* or k>1
			 (lookaheadDFA.probe.isNonLLStarDecision() && // >1 alt recurses, k=*
		      lookaheadDFA.getAutoBacktrackMode()) )
		{
			// set k=1 option if not already k=1 and try again
			// clean up tracking stuff
			decisionsWhoseDFAsUsesSynPreds.remove(lookaheadDFA);
			// TODO: clean up synPredNamesUsedInDFA also (harder)
			lookaheadDFA = null; // make sure other memory is "free" before redoing
			d.blockAST.setOption(this, "k", Utils.integer(1));
			//System.out.println("trying decision "+decision+" again with k=1");
			lookaheadDFA = new DFA(decision, decisionStartState);
			if ( lookaheadDFA.analysisAborted() ) { // did analysis bug out?
				ErrorManager.internalError("could not even do k=1 for decision "+decision);
			}
		}

		setLookaheadDFA(decision, lookaheadDFA);

		// create map from line:col to decision DFA (for ANTLRWorks)
		GrammarAST decisionAST = nfa.grammar.getDecisionBlockAST(lookaheadDFA.decisionNumber);
		int line = decisionAST.getLine();
		int col = decisionAST.getColumn();
		lineColumnToLookaheadDFAMap.put(new StringBuffer().append(line + ":")
										.append(col).toString(), lookaheadDFA);

		if ( watchNFAConversion ) {
			stopDFA = System.currentTimeMillis();
			System.out.println("cost: "+lookaheadDFA.getNumberOfStates()+
							   " states, "+(int)(stopDFA-startDFA)+" ms");
		}
		//System.out.println("after create DFA; synPredNamesUsedInDFA="+synPredNamesUsedInDFA);
	}

	/** Terminate DFA creation (grammar analysis).
	 */
	public void externallyAbortNFAToDFAConversion() {
		externalAnalysisAbort = true;
	}

	public boolean NFAToDFAConversionExternallyAborted() {
		return externalAnalysisAbort;
	}

	/** Return a new unique integer in the token type space */
	public int getNewTokenType() {
		maxTokenType++;
		return maxTokenType;
	}

	/** Define a token at a particular token type value.  Blast an
	 *  old value with a new one.  This is called directly during import vocab
     *  operation to set up tokens with specific values.
     */
    public void defineToken(String text, int tokenType) {
		if ( tokenIDToTypeMap.get(text)!=null ) {
			// already defined?  Must be predefined one like EOF;
			// do nothing
			return;
		}
		// the index in the typeToTokenList table is actually shifted to
		// hold faux labels as you cannot have negative indices.
        if ( text.charAt(0)=='\'' ) {
            stringLiteralToTypeMap.put(text, Utils.integer(tokenType));
        }
        else { // must be a label like ID
            tokenIDToTypeMap.put(text, Utils.integer(tokenType));
        }
		int index = Label.NUM_FAUX_LABELS+tokenType-1;
		//System.out.println("defining "+name+" token "+text+" at type="+tokenType+", index="+index);
		this.maxTokenType = Math.max(this.maxTokenType, tokenType);
        if ( index>=typeToTokenList.size() ) {
			typeToTokenList.setSize(index+1);
		}
		String prevToken = (String)typeToTokenList.get(index);
		if ( prevToken==null || prevToken.charAt(0)=='\'' ) {
			// only record if nothing there before or if thing before was a literal
			typeToTokenList.set(index, text);
		}
    }

	/** Define a new rule.  A new rule index is created by incrementing
     *  ruleIndex.
     */
	public void defineRule(antlr.Token ruleToken,
						   String modifier,
						   Map options,
						   GrammarAST tree,
						   GrammarAST argActionAST,
						   int numAlts)
	{
		String ruleName = ruleToken.getText();
		/*
		System.out.println("defineRule("+ruleName+",modifier="+modifier+
						   "): index="+ruleIndex);
		*/
		if ( getRule(ruleName)!=null ) {
			ErrorManager.grammarError(ErrorManager.MSG_RULE_REDEFINITION,
									  this, ruleToken, ruleName);
        }

		Rule r = new Rule(this, ruleName, ruleIndex, numAlts);
		r.modifier = modifier;
        nameToRuleMap.put(ruleName, r);
		setRuleAST(ruleName, tree);
		r.setOptions(options, ruleToken);
		r.argActionAST = argActionAST;
        ruleIndexToRuleList.setSize(ruleIndex+1);
        ruleIndexToRuleList.set(ruleIndex, ruleName);
        ruleIndex++;
		if ( ruleName.startsWith(SYNPRED_RULE_PREFIX) ) {
			r.isSynPred = true;
		}
	}

	/** Define a new predicate and get back its name for use in building
	 *  a semantic predicate reference to the syn pred.
	 */
	public String defineSyntacticPredicate(GrammarAST blockAST,
										   String currentRuleName)
	{
		if ( nameToSynpredASTMap==null ) {
			nameToSynpredASTMap = new LinkedHashMap();
		}
		String predName = null;
		predName = SYNPRED_RULE_PREFIX+(nameToSynpredASTMap.size() + 1);
		nameToSynpredASTMap.put(predName, blockAST);
		return predName;
	}

	public LinkedHashMap getSyntacticPredicates() {
		return nameToSynpredASTMap;
	}

	public GrammarAST getSyntacticPredicate(String name) {
		if ( nameToSynpredASTMap==null ) {
			return null;
		}
		return (GrammarAST)nameToSynpredASTMap.get(name);
	}

	public void synPredUsedInDFA(DFA dfa, SemanticContext semCtx) {
		decisionsWhoseDFAsUsesSynPreds.add(dfa);
		semCtx.trackUseOfSyntacticPredicates(this); // walk ctx looking for preds
		//System.out.println("after tracking use for dec "+dfa.decisionNumber+": "+synPredNamesUsedInDFA);
	}

	/** Given @scope::name {action} define it for this grammar.  Later,
	 *  the code generator will ask for the actions table.
	 */
	public void defineNamedAction(GrammarAST ampersandAST,
								  String scope,
								  GrammarAST nameAST,
								  GrammarAST actionAST)
	{
		if ( scope==null ) {
			scope = getDefaultActionScope(type);
		}
		//System.out.println("@"+scope+"::"+nameAST.getText()+"{"+actionAST.getText()+"}");
		String actionName = nameAST.getText();
		Map scopeActions = (Map)actions.get(scope);
		if ( scopeActions==null ) {
			scopeActions = new HashMap();
			actions.put(scope, scopeActions);
		}
		GrammarAST a = (GrammarAST)scopeActions.get(actionName);
		if ( a!=null ) {
			ErrorManager.grammarError(
				ErrorManager.MSG_ACTION_REDEFINITION,this,
				nameAST.getToken(),nameAST.getText());
		}
		else {
			scopeActions.put(actionName,actionAST);
		}
	}

	public Map getActions() {
		return actions;
	}

	/** Given a grammar type, what should be the default action scope?
	 *  If I say @members in a COMBINED grammar, for example, the
	 *  default scope should be "parser".
	 */
	public String getDefaultActionScope(int grammarType) {
		switch (grammarType) {
			case Grammar.LEXER :
				return "lexer";
			case Grammar.PARSER :
			case Grammar.COMBINED :
				return "parser";
			case Grammar.TREE_PARSER :
				return "treeparser";
		}
		return null;
	}

	public void defineLexerRuleFoundInParser(antlr.Token ruleToken,
											 GrammarAST ruleAST)
	{
		//System.out.println("rule tree is:\n"+ruleAST.toStringTree());
		/*
		String ruleText = tokenBuffer.toOriginalString(ruleAST.ruleStartTokenIndex,
											   ruleAST.ruleStopTokenIndex);
		*/
		// first, create the text of the rule
		StringBuffer buf = new StringBuffer();
		buf.append("// $ANTLR src \"");
		buf.append(getFileName());
		buf.append("\" ");
		buf.append(ruleAST.getLine());
		buf.append("\n");
		for (int i=ruleAST.ruleStartTokenIndex;
			 i<=ruleAST.ruleStopTokenIndex && i<tokenBuffer.size();
			 i++)
		{
			TokenWithIndex t = (TokenWithIndex)tokenBuffer.getToken(i);
			// undo the text deletions done by the lexer (ugh)
			if ( t.getType()==ANTLRParser.BLOCK ) {
				buf.append("(");
			}
			else if ( t.getType()==ANTLRParser.ACTION ) {
				buf.append("{");
				buf.append(t.getText());
				buf.append("}");
			}
			else if ( t.getType()==ANTLRParser.SEMPRED ||
				t.getType()==ANTLRParser.SYN_SEMPRED ||
				t.getType()==ANTLRParser.GATED_SEMPRED ||
				t.getType()==ANTLRParser.BACKTRACK_SEMPRED )
			{
				buf.append("{");
				buf.append(t.getText());
				buf.append("}?");
			}
			else if ( t.getType()==ANTLRParser.ARG_ACTION ) {
				buf.append("[");
				buf.append(t.getText());
				buf.append("]");
			}
			else {
				buf.append(t.getText());
			}
		}
		String ruleText = buf.toString();
		//System.out.println("[["+ruleText+"]]");
		// now put the rule into the lexer grammar template
		lexerGrammarST.setAttribute("rules", ruleText);
		// track this lexer rule's name
		lexerRules.add(ruleToken.getText());
	}

	/** If someone does PLUS='+' in the parser, must make sure we get
	 *  "PLUS : '+' ;" in lexer not "T73 : '+';"
	 */
	public void defineLexerRuleForAliasedStringLiteral(String tokenID,
													   String literal,
													   int tokenType)
	{
		//System.out.println("defineLexerRuleForAliasedStringLiteral: "+literal+" "+tokenType);
		lexerGrammarST.setAttribute("literals.{ruleName,type,literal}",
									tokenID,
									Utils.integer(tokenType),
									literal);
		// track this lexer rule's name
		lexerRules.add(tokenID);
	}

	public void defineLexerRuleForStringLiteral(String literal, int tokenType) {
		//System.out.println("defineLexerRuleForStringLiteral: "+literal+" "+tokenType);
		lexerGrammarST.setAttribute("literals.{ruleName,type,literal}",
									computeTokenNameFromLiteral(tokenType,literal),
									Utils.integer(tokenType),
									literal);
	}

	public Rule getRule(String ruleName) {
		Rule r = (Rule)nameToRuleMap.get(ruleName);
		return r;
	}

    public int getRuleIndex(String ruleName) {
		Rule r = getRule(ruleName);
		if ( r!=null ) {
			return r.index;
		}
        return INVALID_RULE_INDEX;
    }

    public String getRuleName(int ruleIndex) {
        return (String)ruleIndexToRuleList.get(ruleIndex);
    }

	public AttributeScope defineGlobalScope(String name, Token scopeAction) {
		AttributeScope scope = new AttributeScope(this, name, scopeAction);
		scopes.put(name,scope);
		return scope;
	}

	public AttributeScope createReturnScope(String ruleName, Token retAction) {
		AttributeScope scope = new AttributeScope(this, ruleName, retAction);
		scope.isReturnScope = true;
		return scope;
	}

	public AttributeScope createRuleScope(String ruleName, Token scopeAction) {
		AttributeScope scope = new AttributeScope(this, ruleName, scopeAction);
		scope.isDynamicRuleScope = true;
		return scope;
	}

	public AttributeScope createParameterScope(String ruleName, Token argAction) {
		AttributeScope scope = new AttributeScope(this, ruleName, argAction);
		scope.isParameterScope = true;
		return scope;
	}

	/** Get a global scope */
	public AttributeScope getGlobalScope(String name) {
		return (AttributeScope)scopes.get(name);
	}

	public Map getGlobalScopes() {
		return scopes;
	}

	/** Define a label defined in a rule r; check the validity then ask the
	 *  Rule object to actually define it.
	 */
	protected void defineLabel(Rule r, antlr.Token label, GrammarAST element, int type) {
        boolean err = nameSpaceChecker.checkForLabelTypeMismatch(r, label, type);
		if ( err ) {
			return;
		}
		r.defineLabel(label, element, type);
	}

	public void defineTokenRefLabel(String ruleName,
									antlr.Token label,
									GrammarAST tokenRef)
	{
        Rule r = getRule(ruleName);
		if ( r!=null ) {
			if ( type==LEXER &&
				 (tokenRef.getType()==ANTLRParser.CHAR_LITERAL||
				 tokenRef.getType()==ANTLRParser.BLOCK||
				 tokenRef.getType()==ANTLRParser.NOT||
				 tokenRef.getType()==ANTLRParser.CHAR_RANGE||
				 tokenRef.getType()==ANTLRParser.WILDCARD))
			{
				defineLabel(r, label, tokenRef, CHAR_LABEL);				
			}
			else {
				defineLabel(r, label, tokenRef, TOKEN_LABEL);
			}
		}
	}

	public void defineRuleRefLabel(String ruleName,
								   antlr.Token label,
								   GrammarAST ruleRef)
	{
		Rule r = getRule(ruleName);
		if ( r!=null ) {
			defineLabel(r, label, ruleRef, RULE_LABEL);
		}
	}

	public void defineTokenListLabel(String ruleName,
									 antlr.Token label,
									 GrammarAST element)
	{
		Rule r = getRule(ruleName);
		if ( r!=null ) {
			defineLabel(r, label, element, TOKEN_LIST_LABEL);
		}
	}

	public void defineRuleListLabel(String ruleName,
									antlr.Token label,
									GrammarAST element)
	{
		Rule r = getRule(ruleName);
		if ( r!=null ) {
			if ( !r.getHasMultipleReturnValues() ) {
				ErrorManager.grammarError(
					ErrorManager.MSG_LIST_LABEL_INVALID_UNLESS_RETVAL_STRUCT,this,
					label,label.getText());
			}
			defineLabel(r, label, element, RULE_LIST_LABEL);
		}
	}

	/** Given a set of all rewrite elements on right of ->, filter for
	 *  label types such as Grammar.TOKEN_LABEL, Grammar.TOKEN_LIST_LABEL, ...
	 *  Return a displayable token type name computed from the GrammarAST.
	 */
	public Set<String> getLabels(Set<GrammarAST> rewriteElements, int labelType) {
		Set<String> labels = new HashSet<String>();
		for (Iterator it = rewriteElements.iterator(); it.hasNext();) {
			GrammarAST el = (GrammarAST) it.next();
			if ( el.getType()==ANTLRParser.LABEL ) {
				Rule r = getRule(el.enclosingRule);
				String labelName = el.getText();
				LabelElementPair pair = r.getLabel(labelName);
				// if valid label and type is what we're looking for
				// and not ref to old value val $rule, add to list
				if ( pair!=null && pair.type==labelType &&
					 !labelName.equals(el.enclosingRule) )
				{
					labels.add(labelName);
				}
			}
		}
		return labels;
	}

	/** Before generating code, we examine all actions that can have
	 *  $x.y and $y stuff in them because some code generation depends on
	 *  Rule.referencedPredefinedRuleAttributes.  I need to remove unused
	 *  rule labels for example.
	 */
	protected void examineAllExecutableActions() {
		Collection rules = getRules();
		for (Iterator it = rules.iterator(); it.hasNext();) {
			Rule r = (Rule) it.next();
			// walk all actions within the rule elements, args, and exceptions
			List<GrammarAST> actions = r.getInlineActions();
			for (int i = 0; i < actions.size(); i++) {
				GrammarAST actionAST = (GrammarAST) actions.get(i);
				ActionAnalysisLexer sniffer =
					new ActionAnalysisLexer(this, r.name, actionAST);
				sniffer.analyze();
			}
			// walk any named actions like @init, @after
			Collection<GrammarAST> namedActions = r.getActions().values();
			for (Iterator it2 = namedActions.iterator(); it2.hasNext();) {
				GrammarAST actionAST = (GrammarAST) it2.next();
				ActionAnalysisLexer sniffer =
					new ActionAnalysisLexer(this, r.name, actionAST);
				sniffer.analyze();
			}
		}
	}

	/** Remove all labels on rule refs whose target rules have no return value.
	 *  Do this for all rules in grammar.
	 */
	public void checkAllRulesForUselessLabels() {
		if ( type==LEXER ) {
			return;
		}
		Set rules = nameToRuleMap.keySet();
		for (Iterator it = rules.iterator(); it.hasNext();) {
			String ruleName = (String) it.next();
			Rule r = getRule(ruleName);
			removeUselessLabels(r.getRuleLabels());
			removeUselessLabels(r.getRuleListLabels());
		}
	}

    /** A label on a rule is useless if the rule has no return value, no
     *  tree or template output, and it is not referenced in an action.
     */
    protected void removeUselessLabels(Map ruleToElementLabelPairMap) {
		if ( ruleToElementLabelPairMap==null ) {
			return;
		}
		Collection labels = ruleToElementLabelPairMap.values();
		List kill = new ArrayList();
		for (Iterator labelit = labels.iterator(); labelit.hasNext();) {
			LabelElementPair pair = (LabelElementPair) labelit.next();
			Rule refdRule = getRule(pair.elementRef.getText());
			if ( refdRule!=null && !refdRule.getHasReturnValue() && !pair.actionReferencesLabel ) {
				//System.out.println(pair.label.getText()+" is useless");
				kill.add(pair.label.getText());
			}
		}
		for (int i = 0; i < kill.size(); i++) {
			String labelToKill = (String) kill.get(i);
			// System.out.println("kill "+labelToKill);
			ruleToElementLabelPairMap.remove(labelToKill);
		}
	}

	/** Track a rule reference within an outermost alt of a rule.  Used
	 *  at the moment to decide if $ruleref refers to a unique rule ref in
	 *  the alt.  Rewrite rules force tracking of all rule AST results.
	 *
	 *  This data is also used to verify that all rules have been defined.
	 */
	public void altReferencesRule(String ruleName, GrammarAST refAST, int outerAltNum) {
		Rule r = getRule(ruleName);
		if ( r==null ) {
			return;
		}
		r.trackRuleReferenceInAlt(refAST, outerAltNum);
		antlr.Token refToken = refAST.getToken();
		if ( !ruleRefs.contains(refToken) ) {
			ruleRefs.add(refToken);
		}
	}

	/** Track a token reference within an outermost alt of a rule.  Used
	 *  to decide if $tokenref refers to a unique token ref in
	 *  the alt. Does not track literals!
	 *
	 *  Rewrite rules force tracking of all tokens.
	 */
	public void altReferencesTokenID(String ruleName, GrammarAST refAST, int outerAltNum) {
		Rule r = getRule(ruleName);
		if ( r==null ) {
			return;
		}
		r.trackTokenReferenceInAlt(refAST, outerAltNum);
		if ( !tokenIDRefs.contains(refAST.getToken()) ) {
			tokenIDRefs.add(refAST.getToken());
		}
	}

	/** To yield smaller, more readable code, track which rules have their
	 *  predefined attributes accessed.  If the rule has no user-defined
	 *  return values, then don't generate the return value scope classes
	 *  etc...  Make the rule have void return value.  Don't track for lexer
	 *  rules.
	 */
	public void referenceRuleLabelPredefinedAttribute(String ruleName) {
		Rule r = getRule(ruleName);
		if ( r!=null && type!=LEXER ) {
			// indicate that an action ref'd an attr unless it's in a lexer
			// so that $ID.text refs don't force lexer rules to define
			// return values...Token objects are created by the caller instead.
			r.referencedPredefinedRuleAttributes = true;
		}
	}

	public List checkAllRulesForLeftRecursion() {
		return sanity.checkAllRulesForLeftRecursion();
	}

	/** Return a list of left-recursive rules; no analysis can be done
	 *  successfully on these.  Useful to skip these rules then and also
	 *  for ANTLRWorks to highlight them.
	 */
	public Set getLeftRecursiveRules() {
		if ( nfa==null ) {
			createNFAs();
		}
		if ( leftRecursiveRules!=null ) {
			return leftRecursiveRules;
		}
		sanity.checkAllRulesForLeftRecursion();
		return leftRecursiveRules;
	}

	public void checkRuleReference(GrammarAST refAST,
								   GrammarAST argsAST,
								   String currentRuleName)
	{
		sanity.checkRuleReference(refAST, argsAST, currentRuleName);
	}

	/** Rules like "a : ;" and "a : {...} ;" should not generate
	 *  try/catch blocks for RecognitionException.  To detect this
	 *  it's probably ok to just look for any reference to an atom
	 *  that can match some input.  W/o that, the rule is unlikey to have
	 *  any else.
	 */
	public boolean isEmptyRule(GrammarAST block) {
		GrammarAST aTokenRefNode =
			block.findFirstType(ANTLRParser.TOKEN_REF);
		GrammarAST aStringLiteralRefNode =
			block.findFirstType(ANTLRParser.STRING_LITERAL);
		GrammarAST aCharLiteralRefNode =
			block.findFirstType(ANTLRParser.CHAR_LITERAL);
		GrammarAST aWildcardRefNode =
			block.findFirstType(ANTLRParser.WILDCARD);
		GrammarAST aRuleRefNode =
			block.findFirstType(ANTLRParser.RULE_REF);
		if ( aTokenRefNode==null&&
			aStringLiteralRefNode==null&&
			aCharLiteralRefNode==null&&
			aWildcardRefNode==null&&
			aRuleRefNode==null )
		{
			return true;
		}
		return false;
	}

    public int getTokenType(String tokenName) {
        Integer I = null;
        if ( tokenName.charAt(0)=='\'') {
            I = (Integer)stringLiteralToTypeMap.get(tokenName);
        }
        else { // must be a label like ID
            I = (Integer)tokenIDToTypeMap.get(tokenName);
        }
        int i = (I!=null)?I.intValue():Label.INVALID;
		//System.out.println("grammar type "+type+" "+tokenName+"->"+i);
        return i;
    }

	/** Get the list of tokens that are IDs like BLOCK and LPAREN */
	public Set getTokenIDs() {
		return tokenIDToTypeMap.keySet();
	}

	/** Return an ordered integer list of token types that have no
	 *  corresponding token ID like INT or KEYWORD_BEGIN; for stuff
	 *  like 'begin'.
	 */
	public Collection getTokenTypesWithoutID() {
		List types = new ArrayList();
		for (int t =Label.MIN_TOKEN_TYPE; t<=getMaxTokenType(); t++) {
			String name = getTokenDisplayName(t);
			if ( name.charAt(0)=='\'' ) {
				types.add(Utils.integer(t));
			}
		}
		return types;
	}

	/** Get a list of all token IDs and literals that have an associated
	 *  token type.
	 */
	public Set getTokenDisplayNames() {
		Set names = new HashSet();
		for (int t =Label.MIN_TOKEN_TYPE; t <=getMaxTokenType(); t++) {
			names.add(getTokenDisplayName(t));
		}
		return names;
	}

	/** Given a literal like (the 3 char sequence with single quotes) 'a',
	 *  return the int value of 'a'. Convert escape sequences here also.
	 *  ANTLR's antlr.g parser does not convert escape sequences.
	 *
	 *  11/26/2005: I changed literals to always be '...' even for strings.
	 *  This routine still works though.
     */
    public static int getCharValueFromGrammarCharLiteral(String literal) {
        if ( literal.length()==3 ) {
			// 'x'
            return literal.charAt(1); // no escape char
        }
        else if ( literal.length() == 4 )
        {
			// '\x'  (antlr lexer will catch invalid char)
			int escChar = literal.charAt(2);
			int charVal = ANTLRLiteralEscapedCharValue[escChar];
			if ( charVal==0 ) {
				// Unnecessary escapes like '\{' should just yield {
				return escChar;
			}
			return charVal;
        }
        else if( literal.length() == 8 )
        {
        	// '\u1234'
        	String unicodeChars = literal.substring(3,literal.length()-1);
    		return Integer.parseInt(unicodeChars, 16);
         }
		ErrorManager.assertTrue(false, "invalid char literal: "+literal);
		return -1;
    }

	/** ANTLR does not convert escape sequences during the parse phase because
	 *  it could not know how to print String/char literals back out when
	 *  printing grammars etc...  Someone in China might use the real unicode
	 *  char in a literal as it will display on their screen; when printing
	 *  back out, I could not know whether to display or use a unicode escape.
	 *
	 *  This routine converts a string literal with possible escape sequences
	 *  into a pure string of 16-bit char values.  Escapes and unicode \u0000
	 *  specs are converted to pure chars.  return in a buffer; people may
	 *  want to walk/manipulate further.
	 *
	 *  The NFA construction routine must know the actual char values.
	 */
	public static StringBuffer getUnescapedStringFromGrammarStringLiteral(String literal) {
		//System.out.println("escape: ["+literal+"]");
		StringBuffer buf = new StringBuffer();
		int last = literal.length()-1; // skip quotes on outside
		for (int i=1; i<last; i++) {
			char c = literal.charAt(i);
			if ( c=='\\' ) {
				i++;
				c = literal.charAt(i);
				if ( Character.toUpperCase(c)=='U' ) {
					// \u0000
					i++;
					String unicodeChars = literal.substring(i,i+4);
					// parse the unicode 16 bit hex value
					int val = Integer.parseInt(unicodeChars, 16);
					i+=4-1; // loop will inc by 1; only jump 3 then
					buf.append((char)val);
				}
				else {
					buf.append((char)ANTLRLiteralEscapedCharValue[c]); // normal \x escape
				}
			}
			else {
				buf.append(c); // simple char x
			}
		}
		//System.out.println("string: ["+buf.toString()+"]");
		return buf;
	}

	/** Pull your token definitions from an existing grammar in memory.
	 *  You must use Grammar() ctor then this method then setGrammarContent()
	 *  to make this work.  This is useful primarily for testing and
	 *  interpreting grammars.  Return the max token type found.
	 */
	public int importTokenVocabulary(Grammar importFromGr) {
		Set importedTokenIDs = importFromGr.getTokenIDs();
		for (Iterator it = importedTokenIDs.iterator(); it.hasNext();) {
			String tokenID = (String) it.next();
			int tokenType = importFromGr.getTokenType(tokenID);
			maxTokenType = Math.max(maxTokenType,tokenType);
			if ( tokenType>=Label.MIN_TOKEN_TYPE ) {
				//System.out.println("import token from grammar "+tokenID+"="+tokenType);
				defineToken(tokenID, tokenType);
			}
		}
		return maxTokenType; // return max found
	}

	/** Load a vocab file <vocabName>.tokens and return max token type found. */
	public int importTokenVocabulary(String vocabName) {
		File fullFile = getImportedVocabFileName(vocabName);
		try {
			FileReader fr = new FileReader(fullFile);
			BufferedReader br = new BufferedReader(fr);
			StreamTokenizer tokenizer = new StreamTokenizer(br);
			tokenizer.parseNumbers();
			tokenizer.wordChars('_', '_');
			tokenizer.eolIsSignificant(true);
			tokenizer.slashSlashComments(true);
			tokenizer.slashStarComments(true);
			tokenizer.ordinaryChar('=');
			tokenizer.quoteChar('\'');
			tokenizer.whitespaceChars(' ',' ');
			tokenizer.whitespaceChars('\t','\t');
			int lineNum = 1;
			int token = tokenizer.nextToken();
			while (token != StreamTokenizer.TT_EOF) {
				String tokenID;
				if ( token == StreamTokenizer.TT_WORD ) {
					tokenID = tokenizer.sval;
				}
				else if ( token == '\'' ) {
					tokenID = "'"+tokenizer.sval+"'";
				}
				else {
					ErrorManager.error(ErrorManager.MSG_TOKENS_FILE_SYNTAX_ERROR,
									   vocabName+CodeGenerator.VOCAB_FILE_EXTENSION,
									   Utils.integer(lineNum));
					while ( tokenizer.nextToken() != StreamTokenizer.TT_EOL ) {;}
					token = tokenizer.nextToken();
					continue;
				}
				token = tokenizer.nextToken();
				if ( token != '=' ) {
					ErrorManager.error(ErrorManager.MSG_TOKENS_FILE_SYNTAX_ERROR,
									   vocabName+CodeGenerator.VOCAB_FILE_EXTENSION,
									   Utils.integer(lineNum));
					while ( tokenizer.nextToken() != StreamTokenizer.TT_EOL ) {;}
					token = tokenizer.nextToken();
					continue;
				}
				token = tokenizer.nextToken(); // skip '='
				if ( token != StreamTokenizer.TT_NUMBER ) {
					ErrorManager.error(ErrorManager.MSG_TOKENS_FILE_SYNTAX_ERROR,
									   vocabName+CodeGenerator.VOCAB_FILE_EXTENSION,
									   Utils.integer(lineNum));
					while ( tokenizer.nextToken() != StreamTokenizer.TT_EOL ) {;}
					token = tokenizer.nextToken();
					continue;
				}
				int tokenType = (int)tokenizer.nval;
				token = tokenizer.nextToken();
				//System.out.println("import "+tokenID+"="+tokenType);
				maxTokenType = Math.max(maxTokenType,tokenType);
				defineToken(tokenID, tokenType);
				lineNum++;
				if ( token != StreamTokenizer.TT_EOL ) {
					ErrorManager.error(ErrorManager.MSG_TOKENS_FILE_SYNTAX_ERROR,
									   vocabName+CodeGenerator.VOCAB_FILE_EXTENSION,
									   Utils.integer(lineNum));
					while ( tokenizer.nextToken() != StreamTokenizer.TT_EOL ) {;}
					token = tokenizer.nextToken();
					continue;
				}
				token = tokenizer.nextToken(); // skip newline
			}
			br.close();
		}
		catch (FileNotFoundException fnfe) {
			ErrorManager.error(ErrorManager.MSG_CANNOT_FIND_TOKENS_FILE,
							   fullFile);
		}
		catch (IOException ioe) {
			ErrorManager.error(ErrorManager.MSG_ERROR_READING_TOKENS_FILE,
							   fullFile,
							   ioe);
		}
		catch (Exception e) {
			ErrorManager.error(ErrorManager.MSG_ERROR_READING_TOKENS_FILE,
							   fullFile,
							   e);
		}
		return maxTokenType;
	}

	/** Given a token type, get a meaningful name for it such as the ID
	 *  or string literal.  If this is a lexer and the ttype is in the
	 *  char vocabulary, compute an ANTLR-valid (possibly escaped) char literal.
	 */
	public String getTokenDisplayName(int ttype) {
		String tokenName = null;
		int index=0;
		// inside any target's char range and is lexer grammar?
		if ( this.type==LEXER &&
			 ttype >= Label.MIN_CHAR_VALUE && ttype <= Label.MAX_CHAR_VALUE )
		{
			return getANTLRCharLiteralForChar(ttype);
		}
		// faux label?
		else if ( ttype<0 ) {
			tokenName = (String)typeToTokenList.get(Label.NUM_FAUX_LABELS+ttype);
		}
		else {
			// compute index in typeToTokenList for ttype
			index = ttype-1; // normalize to 0..n-1
			index += Label.NUM_FAUX_LABELS;     // jump over faux tokens

			if ( index<typeToTokenList.size() ) {
				tokenName = (String)typeToTokenList.get(index);
			}
			else {
				tokenName = String.valueOf(ttype);
			}
		}
		//System.out.println("getTokenDisplaYanme ttype="+ttype+", index="+index+", name="+tokenName);
		return tokenName;
	}

	/** Get the list of ANTLR String literals */
	public Set getStringLiterals() {
		return stringLiteralToTypeMap.keySet();
	}

	public int getGrammarMaxLookahead() {
		if ( global_k>=0 ) {
			return global_k;
		}
		/*
		Integer kI = (Integer)getOption("k");
		if ( kI!=null ) {
			global_k = kI.intValue();
		}
		else {
			global_k = 0;
		}
		*/
		Object k = getOption("k");
		if ( k==null ) {
			global_k = 0;
		}
		else if (k instanceof Integer) {
			Integer kI = (Integer)k;
			global_k = kI.intValue();
		}
		else {
			// must be String "*"
			if ( k.equals("*") ) {  // this the default anyway
				global_k = 0;
			}
		}
		return global_k;
	}

	/** Save the option key/value pair and process it; return the key
	 *  or null if invalid option.
	 */
    public String setOption(String key, Object value, antlr.Token optionsStartToken) {
		if ( !legalOptions.contains(key) ) {
			ErrorManager.grammarError(ErrorManager.MSG_ILLEGAL_OPTION,
									  this,
									  optionsStartToken,
									  key);
			return null;
		}
		if ( !optionIsValid(key, value) ) {
			return null;
		}
		if ( options==null ) {
			options = new HashMap();
		}
		options.put(key, value);
		return key;
    }

    public void setOptions(Map options, antlr.Token optionsStartToken) {
		if ( options==null ) {
			this.options = null;
			return;
		}
        Set keys = options.keySet();
        for (Iterator it = keys.iterator(); it.hasNext();) {
            String optionName = (String) it.next();
            Object optionValue = options.get(optionName);
            String stored=setOption(optionName, optionValue, optionsStartToken);
			if ( stored==null ) {
				it.remove();
			}
        }
    }

    public Object getOption(String key) {
		Object value = null;
		if ( options!=null ) {
			value = options.get(key);
		}
		if ( value==null ) {
			value = defaultOptions.get(key);
		}
		return value;
    }

	public boolean optionIsValid(String key, Object value) {
		return true;
	}

	public boolean buildAST() {
		String outputType = (String)getOption("output");
		if ( outputType!=null ) {
			return outputType.equals("AST");
		}
		return false;
	}

	public boolean isBuiltFromString() {
		return builtFromString;
	}

	public boolean buildTemplate() {
		String outputType = (String)getOption("output");
		if ( outputType!=null ) {
			return outputType.equals("template");
		}
		return false;
	}

    public Collection getRules() {
        return nameToRuleMap.values();
    }

	public void setRuleAST(String ruleName, GrammarAST t) {
		Rule r = (Rule)nameToRuleMap.get(ruleName);
		if ( r!=null ) {
			r.tree = t;
			r.EORNode = t.getLastChild();
		}
	}

    public void setRuleStartState(String ruleName, NFAState startState) {
		Rule r = (Rule)nameToRuleMap.get(ruleName);
		if ( r!=null ) {
	        r.startState = startState;
		}
    }

    public void setRuleStopState(String ruleName, NFAState stopState) {
		Rule r = (Rule)nameToRuleMap.get(ruleName);
		if ( r!=null ) {
	        r.stopState = stopState;
		}
    }

	public NFAState getRuleStartState(String ruleName) {
		Rule r = (Rule)nameToRuleMap.get(ruleName);
		if ( r!=null ) {
			return r.startState;
		}
		return null;
	}

	public String getRuleModifier(String ruleName) {
		Rule r = (Rule)nameToRuleMap.get(ruleName);
		if ( r!=null ) {
			return r.modifier;
		}
		return null;
	}

    public NFAState getRuleStopState(String ruleName) {
		Rule r = (Rule)nameToRuleMap.get(ruleName);
		if ( r!=null ) {
			return r.stopState;
		}
		return null;
    }

    public int assignDecisionNumber(NFAState state) {
        decisionNumber++;
        state.setDecisionNumber(decisionNumber);
        return decisionNumber;
    }

	protected Decision getDecision(int decision) {
		int index = decision-1;
		if ( index >= indexToDecision.size() ) {
			return null;
		}
		Decision d = (Decision)indexToDecision.get(index);
		return d;
	}

	protected Decision createDecision(int decision) {
		int index = decision-1;
		if ( index < indexToDecision.size() ) {
			return getDecision(decision); // don't recreate
		}
		Decision d = new Decision();
		d.decision = decision;
        indexToDecision.setSize(getNumberOfDecisions());
        indexToDecision.set(index, d);
		return d;
	}

    public List getDecisionNFAStartStateList() {
		List states = new ArrayList(100);
		for (int d = 0; d < indexToDecision.size(); d++) {
			Decision dec = (Decision) indexToDecision.elementAt(d);
			states.add(dec.startState);
		}
        return states;
    }

    public NFAState getDecisionNFAStartState(int decision) {
        Decision d = getDecision(decision);
		if ( d==null ) {
			return null;
		}
		return d.startState;
    }

	public DFA getLookaheadDFA(int decision) {
		Decision d = getDecision(decision);
		if ( d==null ) {
			return null;
		}
		return d.dfa;
	}

	public GrammarAST getDecisionBlockAST(int decision) {
		Decision d = getDecision(decision);
		if ( d==null ) {
			return null;
		}
		return d.blockAST;
	}

	/** returns a list of column numbers for all decisions
	 *  on a particular line so ANTLRWorks choose the decision
	 *  depending on the location of the cursor (otherwise,
	 *  ANTLRWorks has to give the *exact* location which
	 *  is not easy from the user point of view).
	 *
	 *  This is not particularly fast as it walks entire line:col->DFA map
	 *  looking for a prefix of "line:".
	 */
	public List getLookaheadDFAColumnsForLineInFile(int line) {
		String prefix = line+":";
		List columns = new ArrayList();
		for(Iterator iter = lineColumnToLookaheadDFAMap.keySet().iterator();
			iter.hasNext(); ) {
			String key = (String)iter.next();
			if(key.startsWith(prefix)) {
				columns.add(Integer.valueOf(key.substring(prefix.length())));
			}
		}
		return columns;
	}

	/** Useful for ANTLRWorks to map position in file to the DFA for display */
	public DFA getLookaheadDFAFromPositionInFile(int line, int col) {
		return (DFA)lineColumnToLookaheadDFAMap.get(
			new StringBuffer().append(line + ":").append(col).toString());
	}

	public Map getLineColumnToLookaheadDFAMap() {
		return lineColumnToLookaheadDFAMap;
	}

	/*
	public void setDecisionOptions(int decision, Map options) {
		Decision d = createDecision(decision);
		d.options = options;
	}

	public void setDecisionOption(int decision, String name, Object value) {
		Decision d = getDecision(decision);
		if ( d!=null ) {
			if ( d.options==null ) {
				d.options = new HashMap();
			}
			d.options.put(name,value);
		}
	}

	public Map getDecisionOptions(int decision) {
		Decision d = getDecision(decision);
		if ( d==null ) {
			return null;
		}
		return d.options;
    }
    */

	public int getNumberOfDecisions() {
		return decisionNumber;
	}

	public int getNumberOfCyclicDecisions() {
		int n = 0;
		for (int i=1; i<=getNumberOfDecisions(); i++) {
			Decision d = getDecision(i);
			if ( d.dfa!=null && d.dfa.isCyclic() ) {
				n++;
			}
		}
		return n;
	}

	/** Set the lookahead DFA for a particular decision.  This means
	 *  that the appropriate AST node must updated to have the new lookahead
	 *  DFA.  This method could be used to properly set the DFAs without
	 *  using the createLookaheadDFAs() method.  You could do this
	 *
	 *    Grammar g = new Grammar("...");
	 *    g.setLookahead(1, dfa1);
	 *    g.setLookahead(2, dfa2);
	 *    ...
	 */
	public void setLookaheadDFA(int decision, DFA lookaheadDFA) {
		Decision d = createDecision(decision);
		d.dfa = lookaheadDFA;
		GrammarAST ast = d.startState.getAssociatedASTNode();
		ast.setLookaheadDFA(lookaheadDFA);
	}

	public void setDecisionNFA(int decision, NFAState state) {
		Decision d = createDecision(decision);
		d.startState = state;
	}

	public void setDecisionBlockAST(int decision, GrammarAST blockAST) {
		//System.out.println("setDecisionBlockAST("+decision+", "+blockAST.token);
		Decision d = createDecision(decision);
		d.blockAST = blockAST;
	}

	public boolean allDecisionDFAHaveBeenCreated() {
		return allDecisionDFACreated;
	}

	/** How many token types have been allocated so far? */
    public int getMaxTokenType() {
        return maxTokenType;
    }

	/** What is the max char value possible for this grammar's target?  Use
	 *  unicode max if no target defined.
	 */
	public int getMaxCharValue() {
		if ( generator!=null ) {
			return generator.target.getMaxCharValue(generator);
		}
		else {
			return Label.MAX_CHAR_VALUE;
		}
	}

	/** Return a set of all possible token or char types for this grammar */
	public IntSet getTokenTypes() {
		if ( type==LEXER ) {
			return getAllCharValues();
		}
		return IntervalSet.of(Label.MIN_TOKEN_TYPE, getMaxTokenType());
	}

	/** If there is a char vocabulary, use it; else return min to max char
	 *  as defined by the target.  If no target, use max unicode char value.
	 */
	public IntSet getAllCharValues() {
		if ( charVocabulary!=null ) {
			return charVocabulary;
		}
		IntSet allChar = IntervalSet.of(Label.MIN_CHAR_VALUE, getMaxCharValue());
		return allChar;
	}

	/** Return a string representing the escaped char for code c.  E.g., If c
	 *  has value 0x100, you will get "\u0100".  ASCII gets the usual
	 *  char (non-hex) representation.  Control characters are spit out
	 *  as unicode.  While this is specially set up for returning Java strings,
	 *  it can be used by any language target that has the same syntax. :)
	 *
	 *  11/26/2005: I changed this to use double quotes, consistent with antlr.g
	 *  12/09/2005: I changed so everything is single quotes
	 */
	public static String getANTLRCharLiteralForChar(int c) {
		if ( c<Label.MIN_CHAR_VALUE ) {
			ErrorManager.internalError("invalid char value "+c);
			return "'<INVALID>'";
		}
		if ( c<ANTLRLiteralCharValueEscape.length && ANTLRLiteralCharValueEscape[c]!=null ) {
			return '\''+ANTLRLiteralCharValueEscape[c]+'\'';
		}
		if ( Character.UnicodeBlock.of((char)c)==Character.UnicodeBlock.BASIC_LATIN &&
			!Character.isISOControl((char)c) ) {
			if ( c=='\\' ) {
				return "'\\\\'";
			}
			if ( c=='\'') {
				return "'\\''";
			}
			return '\''+Character.toString((char)c)+'\'';
		}
		// turn on the bit above max "\uFFFF" value so that we pad with zeros
		// then only take last 4 digits
		String hex = Integer.toHexString(c|0x10000).toUpperCase().substring(1,5);
		String unicodeStr = "'\\u"+hex+"'";
		return unicodeStr;
	}

    /** For lexer grammars, return everything in unicode not in set.
     *  For parser and tree grammars, return everything in token space
     *  from MIN_TOKEN_TYPE to last valid token type or char value.
     */
    public IntSet complement(IntSet set) {
        //System.out.println("complement "+set.toString(this));
        //System.out.println("vocabulary "+getTokenTypes().toString(this));
        IntSet c = set.complement(getTokenTypes());
        //System.out.println("result="+c.toString(this));
        return c;
    }

    public IntSet complement(int atom) {
        return complement(IntervalSet.of(atom));
    }

	/** Given set tree like ( SET A B ) in lexer, check that A and B
	 *  are both valid sets themselves, else we must tree like a BLOCK
	 */
	public boolean isValidSet(TreeToNFAConverter nfabuilder, GrammarAST t) {
		boolean valid = true;
		try {
			//System.out.println("parse BLOCK as set tree: "+t.toStringTree());
			nfabuilder.testBlockAsSet(t);
		}
		catch (RecognitionException re) {
			// The rule did not parse as a set, return null; ignore exception
			valid = false;
		}
		//System.out.println("valid? "+valid);
		return valid;
	}

	/** Get the set equivalent (if any) of the indicated rule from this
	 *  grammar.  Mostly used in the lexer to do ~T for some fragment rule
	 *  T.  If the rule AST has a SET use that.  If the rule is a single char
	 *  convert it to a set and return.  If rule is not a simple set (w/o actions)
	 *  then return null.
	 *  Rules have AST form:
	 *
	 *		^( RULE ID modifier ARG RET SCOPE block EOR )
	 */
	public IntSet getSetFromRule(TreeToNFAConverter nfabuilder, String ruleName)
		throws RecognitionException
	{
		Rule r = getRule(ruleName);
		if ( r==null ) {
			return null;
		}
		IntSet elements = null;
		//System.out.println("parsed tree: "+r.tree.toStringTree());
	    elements = nfabuilder.setRule(r.tree);
		//System.out.println("elements="+elements);
		return elements;
	}

	/** Decisions are linked together with transition(1).  Count how
     *  many there are.  This is here rather than in NFAState because
     *  a grammar decides how NFAs are put together to form a decision.
     */
    public int getNumberOfAltsForDecisionNFA(NFAState decisionState) {
        if ( decisionState==null ) {
            return 0;
        }
        int n = 1;
        NFAState p = decisionState;
        while ( p.transition(1)!=null ) {
            n++;
            p = (NFAState)p.transition(1).target;
        }
        return n;
    }

    /** Get the ith alternative (1..n) from a decision; return null when
     *  an invalid alt is requested.  I must count in to find the right
     *  alternative number.  For (A|B), you get NFA structure (roughly):
	 *
	 *  o->o-A->o
	 *  |
	 *  o->o-B->o
	 *
	 *  This routine returns the leftmost state for each alt.  So alt=1, returns
	 *  the upperleft most state in this structure.
     */
    public NFAState getNFAStateForAltOfDecision(NFAState decisionState, int alt) {
        if ( decisionState==null || alt<=0 ) {
            return null;
        }
        int n = 1;
        NFAState p = decisionState;
        while ( p!=null ) {
            if ( n==alt ) {
                return p;
            }
            n++;
            Transition next = p.transition(1);
            p = null;
            if ( next!=null ) {
                p = (NFAState)next.target;
            }
        }
        return null;
    }

	/** From an NFA state, s, find the set of all labels reachable from s.
	 *  This computes FIRST, FOLLOW and any other lookahead computation
	 *  depending on where s is.
	 *
	 *  Record, with EOR_TOKEN_TYPE, if you hit the end of a rule so we can
	 *  know at runtime (when these sets are used) to start walking up the
	 *  follow chain to compute the real, correct follow set.
	 *
	 *  This routine will only be used on parser and tree parser grammars.
	 *
	 *  TODO: it does properly handle a : b A ; where b is nullable
	 *  Actually it stops at end of rules, returning EOR.  Hmm...
	 *  should check for that and keep going.
	 */
	public LookaheadSet LOOK(NFAState s) {
		lookBusy.clear();
		return _LOOK(s);
	}

	protected LookaheadSet _LOOK(NFAState s) {
		if ( s.isAcceptState() ) {
			return new LookaheadSet(Label.EOR_TOKEN_TYPE);
		}

		if ( lookBusy.contains(s) ) {
			// return a copy of an empty set; we may modify set inline
			return new LookaheadSet();
		}
		lookBusy.add(s);
		Transition transition0 = s.transition(0);
		if ( transition0==null ) {
			return null;
		}

		if ( transition0.label.isAtom() ) {
			int atom = transition0.label.getAtom();
			if ( atom==Label.EOF ) {
				return LookaheadSet.EOF();
			}
			return new LookaheadSet(atom);
		}
		if ( transition0.label.isSet() ) {
			IntSet sl = transition0.label.getSet();
			LookaheadSet laSet = new LookaheadSet(sl);
			if ( laSet.member(Label.EOF) ) {
				laSet.remove(Label.EOF);
				laSet.hasEOF = true;
			}
			return laSet;
		}
        LookaheadSet tset = _LOOK((NFAState)transition0.target);
		if ( tset.member(Label.EOR_TOKEN_TYPE) ) {
			if ( transition0 instanceof RuleClosureTransition ) {
				// we called a rule that found the end of the rule.
				// That means the rule is nullable and we need to
				// keep looking at what follows the rule ref.  E.g.,
				// a : b A ; where b is nullable means that LOOK(a)
				// should include A.
				RuleClosureTransition ruleInvocationTrans =
					(RuleClosureTransition)transition0;
				// remove the EOR and get what follows
				tset.remove(Label.EOR_TOKEN_TYPE);
				LookaheadSet fset =
					_LOOK((NFAState)ruleInvocationTrans.getFollowState());
				tset.orInPlace(fset);
			}
		}

		Transition transition1 = s.transition(1);
		if ( transition1!=null ) {
			LookaheadSet tset1 = _LOOK((NFAState)transition1.target);
			tset.orInPlace(tset1);
		}
		return tset;
	}

    public void setCodeGenerator(CodeGenerator generator) {
        this.generator = generator;
    }

    public CodeGenerator getCodeGenerator() {
        return generator;
    }

    public GrammarAST getGrammarTree() {
        return grammarTree;
    }

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	/** given a token type and the text of the literal, come up with a
	 *  decent token type label.  For now it's just T<type>.  Actually,
	 *  if there is an aliased name from tokens like PLUS='+', use it.
	 */
	public String computeTokenNameFromLiteral(int tokenType, String literal) {
		return "T"+tokenType;
	}

    public String toString() {
        return grammarTreeToString(grammarTree);
    }

	public String grammarTreeToString(GrammarAST t) {
		return grammarTreeToString(t, true);
	}

	public String grammarTreeToString(GrammarAST t, boolean showActions) {
        String s = null;
        try {
            s = t.getLine()+":"+t.getColumn()+": ";
            s += new ANTLRTreePrinter().toString((AST)t, this, showActions);
        }
        catch (Exception e) {
            ErrorManager.error(ErrorManager.MSG_BAD_AST_STRUCTURE,
							   t,
							   e);
        }
        return s;
    }

	public void setWatchNFAConversion(boolean watchNFAConversion) {
		this.watchNFAConversion = watchNFAConversion;
	}

	public boolean getWatchNFAConversion() {
		return watchNFAConversion;
	}

	public void printGrammar(PrintStream output) {
		ANTLRTreePrinter printer = new ANTLRTreePrinter();
		printer.setASTNodeClass("org.antlr.tool.GrammarAST");
		try {
			String g = printer.toString(grammarTree, this, false);
			output.println(g);
		}
		catch (RecognitionException re) {
			ErrorManager.error(ErrorManager.MSG_SYNTAX_ERROR,re);
		}
	}

}
