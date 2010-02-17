/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ANTLR_INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ANTLR_STRING_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BIT_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMMON_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMMON_TOKEN_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EARLY_EXIT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.FAILED_PREDICATE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MATH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MISMATCHED_NOT_SET_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MISMATCHED_RANGE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MISMATCHED_SET_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MISMATCHED_TOKEN_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MISMATCHED_TREE_NODE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.NO_VIABLE_ALT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RECOGNITION_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TOKEN;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.sdk.LeftRecursionDetector;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.composites.ANTLRGrammarComposite;
import org.emftext.sdk.codegen.composites.StringComponent;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.code_completion.helpers.Expectation;
import org.emftext.sdk.codegen.generators.code_completion.helpers.ExpectationComputer;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.util.EObjectUtil;
import org.emftext.sdk.util.StringUtil;

/**
 * The text parser generator maps from one or more concrete syntaxes (*.cs) and
 * one or more Ecore generator models to an ANTLR parser specification. If the
 * derived specification does not contain syntactical conflicts which could
 * break the ANTLR generation algorithm or the ANTLR parsing algorithm (e.g.
 * ambiguities in the configuration or in token definitions which are not
 * checked by this generator) it can be used to generate a text parser which
 * allows to create model instances from plain text files.
 * 
 * To enable code completion the grammar is augmented with addition code. For
 * example, for each terminal a field is created and all terminals are connected
 * to their follow set. During code completion the parser runs in a special mode
 * (rememberExpectations=true). To derive the set of elements that can potentially
 * occur after the cursor, the last follow set that was added before the last 
 * complete element is needing. Whenever an element (EObject) is complete during
 * parsing, the current token index (getTokenStream().index()) and the last follow 
 * set is stored. To compute the completion proposals, this preliminary follow set 
 * must be reduced using the token at the stored index. The remaining subset is 
 * then queried for its follows, where the same procedure is applied again 
 * (reduction using the next token). this is performed until the cursor position 
 * (end of the document) is reached.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class ANTLRGrammarGenerator extends BaseGenerator {
	
	/**
	 * The name of the EOF token which can be printed to force end of file after
	 * a parse from the root.
	 */
	public static final String EOF_TOKEN_NAME = "EOF";

	private static final GenClassUtil genClassUtil = new GenClassUtil();

	private ConcreteSyntax concreteSyntax;
	
	// some fully qualified names of classes that are repeatedly used
	private String tokenResolverFactoryClassName;
	private String dummyEObjectClassName;
	private String tokenResolveResultClassName;
	private String contextDependentURIFragmentFactoryClassName;
	private String expectedCsStringClassName;
	private String expectedStructuralFeatureClassName;
	private String iTextResourceClassName;
	private String iCommandClassName;
	private String iParseResultClassName;
	private String expectedTerminalClassName;
	private String iExpectedElementClassName;
	private String parseResultClassName;
	private String pairClassName;

	/**
	 * A map that projects the fully qualified name of generator classes to the
	 * set of fully qualified names of all their super classes.
	 */
	private Map<String, Collection<String>> genClassNames2superClassNames;
	private Collection<GenClass> allGenClasses;
	private Set<String> keywords;

	private GenClassFinder genClassFinder = new GenClassFinder();
	private GeneratorUtil generatorUtil = new GeneratorUtil();
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	private boolean forceEOFToken;

	/**
	 * A unique ID that is assigned to each follow set while generating
	 * the grammar. This ID is reset to zero when the grammar generation
	 * starts and incremented by one after each follow set.
	 */
	private int followSetID;

	private ExpectationComputer computer = new ExpectationComputer();

	/**
	 * A map that contains the terminal elements of the syntax specification
	 * (keywords and placeholders) to the name of the field that represents
	 * them.
	 */
	private Map<EObject, String> idMap = new LinkedHashMap<EObject, String>();
	
	/**
	 * A counter that is used to indicate the next free id in 'idMap'.
	 */
	private int idCounter = 0;

	private int featureCounter = 0;
	private Map<GenFeature, String> eFeatureToConstantNameMap = new LinkedHashMap<GenFeature, String>();
	
	/**
	 * A map that contains names of fields representing terminals and their
	 * follow set. This map is used to create the code that links terminals
	 * and the potential next elements (i.e., their follow set).
	 */
	private Map<String, Set<Expectation>> followSetMap = new LinkedHashMap<String, Set<Expectation>>();

	public ANTLRGrammarGenerator() {
		super();
	}

	private ANTLRGrammarGenerator(GenerationContext context) {
		super(context, EArtifact.ANTLR_GRAMMAR);
		concreteSyntax = context.getConcreteSyntax();
		// initialize class names
		tokenResolverFactoryClassName = context.getQualifiedClassName(EArtifact.TOKEN_RESOLVER_FACTORY);
		dummyEObjectClassName = context.getQualifiedClassName(EArtifact.DUMMY_E_OBJECT);
		tokenResolveResultClassName = context.getQualifiedClassName(EArtifact.TOKEN_RESOLVE_RESULT);
		contextDependentURIFragmentFactoryClassName = context.getQualifiedClassName(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		expectedCsStringClassName = context.getQualifiedClassName(EArtifact.EXPECTED_CS_STRING);
		expectedStructuralFeatureClassName = context.getQualifiedClassName(EArtifact.EXPECTED_STRUCTURAL_FEATURE);
		iTextResourceClassName = context.getQualifiedClassName(EArtifact.I_TEXT_RESOURCE);
		iCommandClassName = context.getQualifiedClassName(EArtifact.I_COMMAND);
		iParseResultClassName = context.getQualifiedClassName(EArtifact.I_PARSE_RESULT);
		expectedTerminalClassName = context.getQualifiedClassName(EArtifact.EXPECTED_TERMINAL);
		iExpectedElementClassName = context.getQualifiedClassName(EArtifact.I_EXPECTED_ELEMENT);
		parseResultClassName = getContext().getQualifiedClassName(EArtifact.PARSE_RESULT);
		pairClassName = getContext().getQualifiedClassName(EArtifact.PAIR);
	}

	private void initOptions() {
		forceEOFToken = OptionManager.INSTANCE.getBooleanOptionValue(
				concreteSyntax, OptionTypes.FORCE_EOF);
	}

	private void initCaches() {
		allGenClasses = genClassFinder.findAllGenClasses(concreteSyntax, true, true);
		genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses);
		
		keywords = new LinkedHashSet<String>();
		
		List<Rule> allRules = concreteSyntax.getAllRules();
		for (Rule rule : allRules) {
			Collection<CsString> keywordsInRule = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
			for (CsString nextKeyword : keywordsInRule) {
				keywords.add(nextKeyword.getValue());
			}
		}
	}

	public boolean generate(PrintWriter writer) {
		followSetID = 0;
		initOptions();
		initCaches();

		String csName = getResourceClassName();
		String lexerName = getLexerName(csName);
		String parserName = getParserName(csName);
		boolean backtracking = OptionManager.INSTANCE.getBooleanOptionValue(
				concreteSyntax, OptionTypes.ANTLR_BACKTRACKING);
		boolean memoize = OptionManager.INSTANCE.getBooleanOptionValue(
				concreteSyntax, OptionTypes.ANTLR_MEMOIZE);

		StringComposite sc = new ANTLRGrammarComposite();

		sc.add("grammar " + csName + ";");
		sc.addLineBreak();

		sc.add("options {");
		sc.add("superClass = " + getContext().getClassName(EArtifact.ANTLR_PARSER_BASE) + ";");
		sc.add("backtrack = " + backtracking + ";");
		sc.add("memoize = " + memoize + ";");
		sc.add("}");
		sc.addLineBreak();

		// the lexer: package definition and error handling
		sc.add("@lexer::header {");
		sc.add("package " + getResourcePackageName() + ";");
		sc.add("}");
		sc.addLineBreak();

		sc.add("@lexer::members {");
		sc.add("public " + LIST + "<" + RECOGNITION_EXCEPTION + "> lexerExceptions  = new " + ARRAY_LIST + "<" + RECOGNITION_EXCEPTION + ">();");
		sc.add("public " + LIST + "<" + INTEGER + "> lexerExceptionsPosition = new " + ARRAY_LIST + "<" + INTEGER + ">();");
		sc.addLineBreak();
		sc.add("public void reportError(" + RECOGNITION_EXCEPTION + " e) {");
		sc.add("lexerExceptions.add(e);");
		sc.add("lexerExceptionsPosition.add(((" + ANTLR_STRING_STREAM + ") input).index());");
		sc.add("}");
		sc.add("}");

		// the parser: package definition and entry (doParse) method
		sc.add("@header{");
		sc.add("package " + getResourcePackageName() + ";");
		sc.add("}");
		sc.addLineBreak();

		StringComposite grammarCore = new ANTLRGrammarComposite();
		addRules(grammarCore);
		addTokenDefinitions(grammarCore);

		sc.add("@members{");
		addFields(sc);
		addMethods(lexerName, parserName, sc);
		addTerminalConstants(sc);
		sc.add("}");
		sc.addLineBreak();
		
		sc.add(grammarCore.toString());

		writer.print(sc.toString());
		return getCollectedErrors().isEmpty();
	}

	private void addRules(StringComposite sc) {
		printStartRule(sc);

		EList<GenClass> eClassesWithSyntax = new BasicEList<GenClass>();
		Map<GenClass, Collection<Terminal>> eClassesReferenced = new LinkedHashMap<GenClass, Collection<Terminal>>();

		printGrammarRules(sc, eClassesWithSyntax, eClassesReferenced);
		printImplicitChoiceRules(sc, eClassesWithSyntax, eClassesReferenced);
	}

	private void addMethods(String lexerName, String parserName,
			StringComposite sc) {
		generatorUtil.addAddErrorToResourceMethod(sc, getClassNameHelper());
		addAddExpectedElementMethod(sc);
		generatorUtil.addAddMapEntryMethod(sc, dummyEObjectClassName, getClassNameHelper());
		generatorUtil.addAddObjectToListMethod(sc);
		addApplyMethod(sc);
		addCollectHiddenTokensMethod(lexerName, sc);
		addCopyLocalizationInfosMethod1(sc);
		addCopyLocalizationInfosMethod2(sc);
		addCreateInstanceMethod(lexerName, parserName, sc);
		addDefaultConstructor(parserName, sc);
		addDoParseMethod(lexerName, sc);
		generatorUtil.addGetFreshTokenResolveResultMethod(sc, tokenResolveResultClassName);
		addGetMismatchedTokenRecoveryTriesMethod(sc);
		addGetMissingSymbolMethod(sc);
		addGetOptionsMethod(sc);
    	getContext().addGetMetaInformationMethod(sc);
		addGetParseToIndexTypeObjectMethod(sc);
		generatorUtil.addGetReferenceResolverSwitchMethod(getContext(), sc);
		addGetTypeObjectMethod(sc);
		addParseMethod(sc);
		addParseToExpectedElementsMethod(sc);
		addSetPositionMethod(sc);
		addRecoverFromMismatchedTokenMethod(sc);
		generatorUtil.addRegisterContextDependentProxyMethod(sc,
				contextDependentURIFragmentFactoryClassName, true, getClassNameHelper());
		addReportErrorMethod(sc);
		addReportLexicalErrorsMethod(sc);
		addSetOptionsMethod(sc);
		addTerminateMethod(sc);
		addCompletedElementMethod(sc);
	}

	private void addGetMissingSymbolMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " getMissingSymbol(" + INT_STREAM
				+ " arg0, " + RECOGNITION_EXCEPTION + " arg1, int arg2, "
				+ BIT_SET + " arg3) {");
		sc.add("mismatchedTokenRecoveryTries++;");
		sc.add("return super.getMissingSymbol(arg0, arg1, arg2, arg3);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMismatchedTokenRecoveryTriesMethod(StringComposite sc) {
		sc.add("public int getMismatchedTokenRecoveryTries() {");
		sc.add("return mismatchedTokenRecoveryTries;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReportLexicalErrorsMethod(StringComposite sc) {
		sc.add("// Translates errors thrown by the lexer into human readable messages.");
		sc.add("public void reportLexicalError(final " + RECOGNITION_EXCEPTION + " e)  {");
		sc.add(STRING + " message = \"\";");
		sc.add("if (e instanceof " + MISMATCHED_TOKEN_EXCEPTION + ") {");
		sc.add(MISMATCHED_TOKEN_EXCEPTION + " mte = (" + MISMATCHED_TOKEN_EXCEPTION + ") e;");
		sc.add("message = \"Syntax error on token \\\"\" + ((char) e.c) + \"\\\", \\\"\" + (char) mte.expecting + \"\\\" expected\";");
		sc.add("} else if (e instanceof " + NO_VIABLE_ALT_EXCEPTION + ") {");
		sc.add("message = \"Syntax error on token \\\"\" + ((char) e.c) + \"\\\", delete this token\";");
		sc.add("} else if (e instanceof " + EARLY_EXIT_EXCEPTION + ") {");
		sc.add(EARLY_EXIT_EXCEPTION + " eee = (" + EARLY_EXIT_EXCEPTION + ") e;");
		sc.add("message =\"required (...)+ loop (decision=\" + eee.decisionNumber + \") did not match anything; on line \" + e.line + \":\" + e.charPositionInLine + \" char=\" + ((char) e.c) + \"'\";");
		sc.add("} else if (e instanceof " + MISMATCHED_SET_EXCEPTION + ") {");
		sc.add(MISMATCHED_SET_EXCEPTION + " mse = (" + MISMATCHED_SET_EXCEPTION + ") e;");
		sc.add("message =\"mismatched char: '\" + ((char) e.c) + \"' on line \" + e.line + \":\" + e.charPositionInLine + \"; expecting set \" + mse.expecting;");
		sc.add("} else if (e instanceof " + MISMATCHED_NOT_SET_EXCEPTION + ") {");
		sc.add(MISMATCHED_NOT_SET_EXCEPTION + " mse = (" + MISMATCHED_NOT_SET_EXCEPTION + ") e;");
		sc.add("message =\"mismatched char: '\" + ((char) e.c) + \"' on line \" + e.line + \":\" + e.charPositionInLine + \"; expecting set \" + mse.expecting;");
		sc.add("} else if (e instanceof " + MISMATCHED_RANGE_EXCEPTION + ") {");
		sc.add(MISMATCHED_RANGE_EXCEPTION + " mre = (" + MISMATCHED_RANGE_EXCEPTION + ") e;");
		sc.add("message =\"mismatched char: '\" + ((char) e.c) + \"' on line \" + e.line + \":\" + e.charPositionInLine + \"; expecting set '\" + (char) mre.a + \"'..'\" + (char) mre.b + \"'\";");
		sc.add("} else if (e instanceof " + FAILED_PREDICATE_EXCEPTION + ") {");
		sc.add(FAILED_PREDICATE_EXCEPTION + " fpe = (" + FAILED_PREDICATE_EXCEPTION + ") e;");
		sc.add("message =\"rule \" + fpe.ruleName + \" failed predicate: {\" + fpe.predicateText + \"}?\";");
		sc.add("}");
		sc.add("addErrorToResource(message, e.index, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReportErrorMethod(StringComposite sc) {
		sc.add("// Translates errors thrown by the parser into human readable messages.");
		sc.add("public void reportError(final " + RECOGNITION_EXCEPTION + " e)  {");
		sc.add(STRING + " message = e.getMessage();");
		sc.add("if (e instanceof " + MISMATCHED_TOKEN_EXCEPTION + ") {");
		sc.add(MISMATCHED_TOKEN_EXCEPTION + " mte = (" + MISMATCHED_TOKEN_EXCEPTION + ") e;");
		sc.add(STRING + " tokenName = \"<unknown>\";");
		sc.add("if (mte.expecting == Token.EOF) {");
		sc.add("tokenName = \"EOF\";");
		sc.add("} else {");
		sc.add("tokenName = getTokenNames()[mte.expecting];");
		sc.add("tokenName = " + getClassNameHelper().getSTRING_UTIL() + ".formatTokenName(tokenName);");
		sc.add("}");
		sc.add("message = \"Syntax error on token \\\"\" + e.token.getText() + \"\\\", \\\"\" + tokenName + \"\\\" expected\";");
		sc.add("} else if (e instanceof " + MISMATCHED_TREE_NODE_EXCEPTION + ") {");
		sc.add(MISMATCHED_TREE_NODE_EXCEPTION + " mtne = (" + MISMATCHED_TREE_NODE_EXCEPTION + ") e;");
		sc.add(STRING + " tokenName = \"<unknown>\";");
		sc.add("if (mtne.expecting == Token.EOF) {");
		sc.add("tokenName = \"EOF\";");
		sc.add("} else {");
		sc.add("tokenName = getTokenNames()[mtne.expecting];");
		sc.add("}");
		sc.add("message = \"mismatched tree node: \"+\"xxx\" +\"; expecting \" + tokenName;");
		sc.add("} else if (e instanceof " + NO_VIABLE_ALT_EXCEPTION + ") {");
		sc.add("message = \"Syntax error on token \\\"\" + e.token.getText() + \"\\\", check following tokens\";");
		sc.add("} else if (e instanceof " + EARLY_EXIT_EXCEPTION + ") {");
		sc.add("message = \"Syntax error on token \\\"\" + e.token.getText() + \"\\\", delete this token\";");
		sc.add("} else if (e instanceof " + MISMATCHED_SET_EXCEPTION + ") {");
		sc.add(MISMATCHED_SET_EXCEPTION + " mse = (" + MISMATCHED_SET_EXCEPTION + ") e;");
		sc.add("message = \"mismatched token: \" + e.token + \"; expecting set \" + mse.expecting;");
		sc.add("} else if (e instanceof " + MISMATCHED_NOT_SET_EXCEPTION + ") {");
		sc.add(MISMATCHED_NOT_SET_EXCEPTION + " mse = (" + MISMATCHED_NOT_SET_EXCEPTION + ") e;");
		sc.add("message = \"mismatched token: \" +  e.token + \"; expecting set \" + mse.expecting;");
		sc.add("} else if (e instanceof " + FAILED_PREDICATE_EXCEPTION + ") {");
		sc.add(FAILED_PREDICATE_EXCEPTION + " fpe = (" + FAILED_PREDICATE_EXCEPTION + ") e;");
		sc.add("message = \"rule \" + fpe.ruleName + \" failed predicate: {\" +  fpe.predicateText+\"}?\";");
		sc.add("}");
		
		sc.add("// the resource may be null if the parse is used for code completion");
		sc.add("final " + STRING + " finalMessage = message;");
		
		sc.add("if (e.token instanceof " + COMMON_TOKEN + ") {");
		sc.add("final " + COMMON_TOKEN + " ct = (" + COMMON_TOKEN + ") e.token;");
		sc.add("addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());");
		sc.add("} else {");
		// TODO what the heck is this 5?
		sc.add("addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTerminateMethod(StringComposite sc) {
		sc.add("public void terminate() {");
		sc.add("terminateParsing = true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseMethod(StringComposite sc) {
		sc.add("// Implementation that calls {@link #doParse()}  and handles the thrown");
		sc.add("// RecognitionExceptions.");
		sc.add("public " + getClassNameHelper().getI_PARSE_RESULT() + " parse() {");
		sc.add("terminateParsing = false;");
		sc.add("postParseCommands = new " + ARRAY_LIST + "<" + getClassNameHelper().getI_COMMAND() + "<" + getClassNameHelper().getI_TEXT_RESOURCE() + ">>();");
		sc.add(parseResultClassName + " parseResult = new " + parseResultClassName + "();");
		sc.add("try {");
		sc.add(E_OBJECT + " result =  doParse();");
		sc.add("if (lexerExceptions.isEmpty()) {");
		sc.add("parseResult.setRoot(result);");
		sc.add("}");
		sc.add("} catch (" + RECOGNITION_EXCEPTION + " re) {");
		sc.add("reportError(re);");
		sc.add("} catch (" + ILLEGAL_ARGUMENT_EXCEPTION + " iae) {");
		sc.add("if (\"The 'no null' constraint is violated\".equals(iae.getMessage())) {");
		sc.add("//? can be caused if a null is set on EMF models where not allowed;");
		sc.add("//? this will just happen if other errors occurred before");
		sc.add("} else {");
		sc.add("iae.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + RECOGNITION_EXCEPTION + " re : lexerExceptions) {");
		sc.add("reportLexicalError(re);");
		sc.add("}");
		sc.add("parseResult.getPostParseCommands().addAll(postParseCommands);");
		sc.add("return parseResult;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addApplyMethod(StringComposite sc) {
		sc.add("protected " + E_OBJECT + " apply(" + E_OBJECT + " target, " + LIST + "<" + E_OBJECT + "> dummyEObjects) {");
		sc.add(E_OBJECT + " currentTarget = target;");
		sc.add("for (" + E_OBJECT + " object : dummyEObjects) {");
		sc.add("assert(object instanceof " + dummyEObjectClassName + ");");
		sc.add(dummyEObjectClassName + " dummy = (" + dummyEObjectClassName + ") object;");
		sc.add(E_OBJECT + " newEObject = dummy.applyTo(currentTarget);");
		sc.add("currentTarget = newEObject;");
		sc.add("}");
		sc.add("return currentTarget;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCompletedElementMethod(StringComposite sc) {
		sc.add("protected void completedElement(Object element) {");
		sc.add("if (element instanceof " + E_OBJECT + ") {");
		sc.add("this.tokenIndexOfLastCompleteElement = getTokenStream().index();");
		sc.add("this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;");
		// TODO mseifert: remove this debug output
		//sc.add("System.out.println(\"COMPLETED : \" + element + \" TOKEN INDEX = \" + tokenIndexOfLastCompleteElement + \" EXP INDEX = \" + expectedElementsIndexOfLastCompleteElement);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetOptionsMethod(StringComposite sc) {
		sc.add("protected " + MAP + "<?,?> getOptions() {");
		sc.add("return options;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + MAP + "<?,?> options) {");
		sc.add("this.options = options;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDefaultConstructor(String parserName, StringComposite sc) {
		sc.add("// This default constructor is only used to call createInstance() on it");
		sc.add("public " + parserName + "() {");
		sc.add("super(null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTypeObjectMethod(StringComposite sc) {
		sc.add("protected " + OBJECT + " getTypeObject() {");
		sc.add(OBJECT + " typeObject = getParseToIndexTypeObject();");
		sc.add("if (typeObject != null) {");
		sc.add("return typeObject;");
		sc.add("}");
		sc.add(MAP + "<?,?> options = getOptions();");
		sc.add("if (options != null) {");
		sc.add("typeObject = options.get(" + getClassNameHelper().getI_OPTIONS() + ".RESOURCE_CONTENT_TYPE);");
		sc.add("}");
		sc.add("return typeObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoParseMethod(String lexerName, StringComposite sc) {
		sc.add("protected " + E_OBJECT + " doParse() throws " + RECOGNITION_EXCEPTION + " {");
		sc.add("this.lastPosition = 0;");
		sc.add("// required because the lexer class can not be subclassed");
		sc.add("((" + lexerName + ") getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;");
		sc.add("((" + lexerName + ") getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;");
		sc.add(OBJECT + " typeObject = getTypeObject();");
		sc.add("if (typeObject == null) {");
		sc.add("return start();");
		sc.add("} else if (typeObject instanceof " + E_CLASS + ") {");
		sc.add(E_CLASS + " type = (" + E_CLASS + ") typeObject;");
		for (Rule rule : concreteSyntax.getAllRules()) {
			// operator rules cannot be used as start symbol
			// TODO mseifert: check whether this is checked by a post processor
			if (rule.getOperatorAnnotation() == null) {
				String qualifiedClassName = genClassFinder.getQualifiedInterfaceName(rule.getMetaclass());
				String ruleName = getRuleName(rule.getMetaclass());
				sc.add("if (type.getInstanceClass() == " + qualifiedClassName + ".class) {");
				sc.add("return " + ruleName + "();");
				sc.add("}");
			}
		}
		sc.add("}");
		sc.add("throw new " + getClassNameHelper().getUNEXPECTED_CONTENT_TYPE_EXCEPTION() + "(typeObject);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCollectHiddenTokensMethod(String lexerName, StringComposite sc) {
		List<CompleteTokenDefinition> collectTokenDefinitions = collectCollectTokenDefinitions(concreteSyntax.getActiveTokens());
		sc.add("protected void collectHiddenTokens(" + E_OBJECT + " element) {");
		if (!collectTokenDefinitions.isEmpty()) {
			// sc.add("System.out.println(\"collectHiddenTokens(\" + element.getClass().getSimpleName() + \", \" + o + \") \");");
			sc.add("int currentPos = getTokenStream().index();");
			sc.add("if (currentPos == 0) {");
			sc.add("return;");
			sc.add("}");
			sc.add("int endPos = currentPos - 1;");
			sc.add("for (; endPos >= this.lastPosition; endPos--) {");
			sc.add(TOKEN + " token = getTokenStream().get(endPos);");
			sc.add("int _channel = token.getChannel();");
			sc.add("if (_channel != 99) {");
			sc.add("break;");
			sc.add("}");
			sc.add("}");
			sc.add("for (int pos = this.lastPosition; pos < endPos; pos++) {");
			sc.add(TOKEN + " token = getTokenStream().get(pos);");
			sc.add("int _channel = token.getChannel();");
			sc.add("if (_channel == 99) {");
			// sc.add("System.out.println(\"\t\" + token);");

			for (CompleteTokenDefinition tokenDefinition : collectTokenDefinitions) {
				String attributeName = tokenDefinition.getAttributeName();
				// figure out which feature the token belongs to
				sc.add("if (token.getType() == " + lexerName + "."
						+ tokenDefinition.getName() + ") {");
				// Unfortunately, we must use the feature name instead of the
				// constant here,
				// because collect-in tokens can be stored in arbitrary classes.
				// Therefore,
				// we do not know the EClass of the element at generation time.
				sc.add(E_STRUCTURAL_FEATURE + " feature = element.eClass().getEStructuralFeature(\"" + attributeName + "\");");
				sc.add("if (feature != null) {");
				sc.add("// call token resolver");

				String identifierPrefix = "resolved";
				String resolverIdentifier = identifierPrefix + "Resolver";
				String resolvedObjectIdentifier = identifierPrefix + "Object";
				String resolveResultIdentifier = identifierPrefix + "Result";

				sc
						.add(getClassNameHelper().getI_TOKEN_RESOLVER()
								+ " "
								+ resolverIdentifier
								+ " = tokenResolverFactory.createCollectInTokenResolver(\""
								+ attributeName + "\");");
				sc.add(resolverIdentifier + ".setOptions(getOptions());");
				sc.add(getClassNameHelper().getI_TOKEN_RESOLVE_RESULT() + " "
						+ resolveResultIdentifier
						+ " = getFreshTokenResolveResult();");
				sc.add(resolverIdentifier
						+ ".resolve(token.getText(), feature, "
						+ resolveResultIdentifier + ");");
				sc.add(OBJECT + " " + resolvedObjectIdentifier + " = "
						+ resolveResultIdentifier + ".getResolvedToken();");
				sc.add("if (" + resolvedObjectIdentifier + " == null) {");
				sc.add("addErrorToResource(" + resolveResultIdentifier
						+ ".getErrorMessage(), ((" + COMMON_TOKEN
						+ ") token).getLine(), ((" + COMMON_TOKEN
						+ ") token).getCharPositionInLine(), ((" + COMMON_TOKEN
						+ ") token).getStartIndex(), ((" + COMMON_TOKEN
						+ ") token).getStopIndex());\n");
				sc.add("}");
				sc.add("if (java.lang.String.class.isInstance("
						+ resolvedObjectIdentifier + ")) {");
				sc.add("((" + LIST
						+ ") element.eGet(feature)).add((java.lang.String) "
						+ resolvedObjectIdentifier + ");");
				sc.add("} else {");
				sc
						.add("System.out.println(\"WARNING: Attribute "
								+ attributeName
								+ " for token \" + token + \" has wrong type in element \" + element + \" (expected java.lang.String).\");");
				sc.add("}");
				sc.add("} else {");
				sc
						.add("System.out.println(\"WARNING: Attribute "
								+ attributeName
								+ " for token \" + token + \" was not found in element \" + element + \".\");");
				sc.add("}");
				sc.add("}");
			}

			sc.add("}");
			sc.add("}");
			sc.add("this.lastPosition = (endPos < 0 ? 0 : endPos);");
		}
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateInstanceMethod(String lexerName, String parserName,
			StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_TEXT_PARSER() + " createInstance("
				+ INPUT_STREAM + " actualInputStream, "
				+ STRING + " encoding) {");
		sc.add("try {");
		sc.add("if (encoding == null) {");
		sc.add("return new " + parserName + "(new "
				+ COMMON_TOKEN_STREAM + "(new " + lexerName
				+ "(new " + ANTLR_INPUT_STREAM
				+ "(actualInputStream))));");
		sc.add("} else {");
		sc.add("return new " + parserName + "(new "
				+ COMMON_TOKEN_STREAM + "(new " + lexerName
				+ "(new " + ANTLR_INPUT_STREAM
				+ "(actualInputStream, encoding))));");
		sc.add("}");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"Error while creating parser.\", e);");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + getClassNameHelper().getI_TOKEN_RESOLVER_FACTORY()
				+ " tokenResolverFactory = new "
				+ tokenResolverFactoryClassName + "();");
		sc.add("@SuppressWarnings(\"unused\")");
		sc.addLineBreak();
		sc.add("private int lastPosition;");
		sc.add("private " + tokenResolveResultClassName
				+ " tokenResolveResult = new "
				+ tokenResolveResultClassName + "();");
		sc.add("private boolean rememberExpectedElements = false;");
		sc.add("private " + OBJECT + " parseToIndexTypeObject;");
		sc.add("private int lastTokenIndex = 0;");
		sc.add("private " + LIST + "<" + expectedTerminalClassName
				+ "> expectedElements = new " + ARRAY_LIST + "<"
				+ expectedTerminalClassName + ">();");
		sc.add("private int mismatchedTokenRecoveryTries = 0;");
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("//helper lists to allow a lexer to pass errors to its parser");
		sc.add("protected " + LIST + "<" + RECOGNITION_EXCEPTION
				+ "> lexerExceptions = " + COLLECTIONS
				+ ".synchronizedList(new " + ARRAY_LIST + "<"
				+ RECOGNITION_EXCEPTION + ">());");
		sc.add("protected " + LIST + "<" + INTEGER
				+ "> lexerExceptionsPosition = " + COLLECTIONS
				+ ".synchronizedList(new " + ARRAY_LIST + "<" + INTEGER
				+ ">());");
		sc.add("private int stopIncludingHiddenTokens;");
		sc.add("private int stopExcludingHiddenTokens;");
		sc.add("private " + COLLECTION + "<" + getClassNameHelper().getI_COMMAND() + "<" + getClassNameHelper().getI_TEXT_RESOURCE() + ">> postParseCommands;");
		sc.add("private boolean terminateParsing;");
		sc.add("private int tokenIndexOfLastCompleteElement;");
		sc.add("private int expectedElementsIndexOfLastCompleteElement;");
		sc.addLineBreak();
	}

	private void addParseToExpectedElementsMethod(StringComposite sc) {
		sc.add("public " + LIST + "<" + expectedTerminalClassName
				+ "> parseToExpectedElements(" + E_CLASS + " type, " + iTextResourceClassName + " dummyResource) {");
		sc.add("rememberExpectedElements = true;");
		sc.add("parseToIndexTypeObject = type;");
		sc.add("final " + COMMON_TOKEN_STREAM + " tokenStream = (" + COMMON_TOKEN_STREAM + ") getTokenStream();");
		sc.add(iParseResultClassName + " result = parse();");
		sc.add("if (result != null) {");
		sc.add(E_OBJECT + " root = result.getRoot();");
		sc.add("if (root != null) {");
		sc.add("dummyResource.getContents().add(root);");
		sc.add("}");
		sc.add("for (" + iCommandClassName + "<" + iTextResourceClassName + "> command : result.getPostParseCommands()) {");
		sc.add("command.execute(dummyResource);");
		sc.add("}");
		sc.add("}");
		sc.add("// remove all expected elements that were added after the last complete element");
		sc.add("expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);");
		sc.add("int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();");
		sc.add(SET + "<" + expectedTerminalClassName + "> currentFollowSet = new " + LINKED_HASH_SET +"<" + expectedTerminalClassName + ">();");
		sc.add(LIST + "<" + expectedTerminalClassName + "> newFollowSet = new " + ARRAY_LIST +"<" + expectedTerminalClassName + ">();");
		sc.add("for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {");
		sc.add(expectedTerminalClassName + " expectedElementI = expectedElements.get(i);");
		sc.add("if (expectedElementI.getFollowSetID() == lastFollowSetID) {");
		sc.add("System.out.println(\"FOLLOW ELEMENT \" + expectedElementI);");
		sc.add("currentFollowSet.add(expectedElementI);");
		sc.add("} else {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		// now the follow set IDs must be calculated dynamically
		sc.add("int followSetID = " + followSetID + ";");
		sc.add("int i;");
		sc.add("for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {");
		sc.add(COMMON_TOKEN + " nextToken = (" + COMMON_TOKEN + ") tokenStream.get(i);");
		sc.add("System.out.println(\"REMAINING TOKEN: \" + nextToken);");
		sc.add("if (nextToken.getChannel() == 99) {");
		sc.add("// hidden tokens do not reduce the follow set");
		sc.add("} else {");
		sc.add("// now that we have found the next visible token the position for that expected terminals");
		sc.add("// can be set");
		sc.add("for (" + expectedTerminalClassName + " nextFollow : newFollowSet) {");
		// TODO this is somewhat inefficient since the token stream is searched from
		// the beginning
		sc.add("lastTokenIndex = 0;");
		sc.add("setPosition(nextFollow, i);");
		sc.add("}");
		sc.add("newFollowSet.clear();");
		sc.add("// normal tokens do reduce the follow set - only elements that match the token are kept");
		sc.add("for (" + expectedTerminalClassName + " nextFollow : currentFollowSet) {");
		sc.add("System.out.println(\"CHECKING : \" + nextFollow);");
		sc.add("if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {");
		sc.add("// keep this one - it matches");
		sc.add("System.out.println(\"MATCH! \" + nextFollow);");
		sc.add(COLLECTION + "<" + pairClassName + "<" + iExpectedElementClassName + ", " + E_STRUCTURAL_FEATURE + "[]>> newFollowers = nextFollow.getTerminal().getFollowers();");
		sc.add("for (" + pairClassName + "<" + iExpectedElementClassName + ", " + E_STRUCTURAL_FEATURE + "[]> newFollowerPair : newFollowers) {");
		sc.add(iExpectedElementClassName + " newFollower = newFollowerPair.getLeft();");
		sc.add(expectedTerminalClassName + " newFollowTerminal = new " + expectedTerminalClassName + "(newFollower, followSetID, newFollowerPair.getRight());");
		sc.add("newFollowSet.add(newFollowTerminal);");
		sc.add("expectedElements.add(newFollowTerminal);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("currentFollowSet.clear();");
		sc.add("currentFollowSet.addAll(newFollowSet);");
		sc.add("}");
		sc.add("followSetID++;");
		sc.add("}");
		sc.add("// after the last token in the stream we must set the position for the elements that were");
		sc.add("// added during the last iteration of the loop");
		sc.add("for (" + expectedTerminalClassName + " nextFollow : newFollowSet) {");
		// TODO this is somewhat inefficient since the token stream is searched from
		// the beginning
		sc.add("lastTokenIndex = 0;");
		sc.add("setPosition(nextFollow, i);");
		sc.add("}");
		sc.add("return this.expectedElements;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCopyLocalizationInfosMethod1(StringComposite sc) {
		sc.add("protected void copyLocalizationInfos(final " + E_OBJECT + " source, final "
				+ E_OBJECT + " target) {");
		sc.add("postParseCommands.add(new " + getClassNameHelper().getI_COMMAND() + "<" + getClassNameHelper().getI_TEXT_RESOURCE() + ">() {");
		sc.add("public boolean execute(" + getClassNameHelper().getI_TEXT_RESOURCE() + " resource) {");
		sc.add(getClassNameHelper().getI_LOCATION_MAP() + " locationMap = resource.getLocationMap();");
		sc.add("if (locationMap == null) {");
		sc.add("// the locationMap can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return true;");
		sc.add("}");
		sc.add("locationMap.setCharStart(target, locationMap.getCharStart(source));");
		sc.add("locationMap.setCharEnd(target, locationMap.getCharEnd(source));");
		sc.add("locationMap.setColumn(target, locationMap.getColumn(source));");
		sc.add("locationMap.setLine(target, locationMap.getLine(source));");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCopyLocalizationInfosMethod2(StringComposite sc) {
		sc.add("protected void copyLocalizationInfos(final " + COMMON_TOKEN
				+ " source, final " + E_OBJECT + " target) {");
		sc.add("postParseCommands.add(new " + getClassNameHelper().getI_COMMAND() + "<" + getClassNameHelper().getI_TEXT_RESOURCE() + ">() {");
		sc.add("public boolean execute(" + getClassNameHelper().getI_TEXT_RESOURCE() + " resource) {");
		sc.add(getClassNameHelper().getI_LOCATION_MAP() + " locationMap = resource.getLocationMap();");
		sc.add("if (locationMap == null) {");
		sc.add("// the locationMap can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return true;");
		sc.add("}");
		sc.add("if (source == null) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("locationMap.setCharStart(target, source.getStartIndex());");
		sc.add("locationMap.setCharEnd(target, source.getStopIndex());");
		sc.add("locationMap.setColumn(target, source.getCharPositionInLine());");
		sc.add("locationMap.setLine(target, source.getLine());");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddExpectedElementMethod(StringComposite sc) {
		// TODO potential memory consumption improvement:
		// we can throw away expected elements that are not important
		// for the current parse run. the concrete set of element that
		// can be thrown away is determined by the cursor index where
		// code completion is requested
		sc.add("public void addExpectedElement(" + expectedTerminalClassName
				+ " expectedElement) {");
		sc.add("if (!this.rememberExpectedElements) {");
		sc.add("return;");
		sc.add("}");
		sc.add("setPosition(expectedElement, input.index());");
		//sc.add("System.out.println(\"Adding expected element (\" + message + \"): \" + expectedElement + \"\");");
		sc.add("this.expectedElements.add(expectedElement);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetPositionMethod(StringComposite sc) {
		sc.add("public void setPosition(" + expectedTerminalClassName
				+ " expectedElement, int tokenIndex) {");
		sc.add("int currentIndex = " + MATH + ".max(0, tokenIndex);");
		sc.add("for (int index = lastTokenIndex; index < currentIndex; index++) {");
		sc.add("if (index >= input.size()) {");
		sc.add("break;");
		sc.add("}");
		sc.add(COMMON_TOKEN + " tokenAtIndex = (" + COMMON_TOKEN + ") input.get(index);");
		sc.add("stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;");
		sc.add("if (tokenAtIndex.getChannel() != 99) {");
		sc.add("stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;");
		sc.add("}");
		sc.add("}");
		sc.add("lastTokenIndex = " + MATH + ".max(0, currentIndex);");
		sc.add("expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetParseToIndexTypeObjectMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " getParseToIndexTypeObject() {");
		sc.add("return parseToIndexTypeObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRecoverFromMismatchedTokenMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " recoverFromMismatchedToken(" + INT_STREAM
				+ " input, int ttype, " + BIT_SET + " follow) throws "
				+ RECOGNITION_EXCEPTION + " {");
		sc.add("if (!rememberExpectedElements) {");
		sc.add("return super.recoverFromMismatchedToken(input, ttype, follow);");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
	}

	private List<CompleteTokenDefinition> collectCollectTokenDefinitions(
			List<CompleteTokenDefinition> tokenDefinitions) {
		List<CompleteTokenDefinition> collectList = new LinkedList<CompleteTokenDefinition>();
		for (CompleteTokenDefinition tokenDefinition : tokenDefinitions) {
			String attributeName = tokenDefinition.getAttributeName();
			if (attributeName != null) {
				collectList.add(tokenDefinition);
			}
		}
		return collectList;
	}

	private String getLexerName(String csName) {
		return csName + "Lexer";
	}

	private String getParserName(String csName) {
		return csName + "Parser";
	}

	private void printStartRule(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		// do the start symbol rule
		sc.add("start ");
		sc.add("returns [ " + E_OBJECT + " element = null]");
		sc.add(":");
		sc.add("{");
		Set<Expectation> expectations = new LinkedHashSet<Expectation>();
		for (GenClass startSymbol : concreteSyntax.getActiveStartSymbols()) {
			Collection<Rule> startRules = csUtil.getRules(concreteSyntax, startSymbol);
			for (Rule startRule : startRules) {
				Set<Expectation> firstSet = computer.computeFirstSet(syntax, startRule);
				firstSet.remove(ExpectationComputer.EPSILON);
				expectations.addAll(firstSet);
			}
		}
		sc.add("// follow set for start rule(s)");
		addExpectationsCode(sc, expectations);
		sc.add("expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;");
		sc.add("}");
		sc.add("(");
		int count = 0;
		int i = 0;
		for (GenClass startSymbol : concreteSyntax.getActiveStartSymbols()) {
			// there may also be rules for subclasses of the start symbol class
			// thus, we create an alternative for each rule
			Collection<Rule> startRules = csUtil.getRules(concreteSyntax, startSymbol);
			for (Rule startRule : startRules) {
				if (count > 0) {
					sc.add("|  ");
				}
				i++;
				sc.add("c" + count + " = " + getRuleName(startRule.getMetaclass()) + "{ element = c" + count + "; }");
				count++;
			}
		}
		sc.add(")");
		if (forceEOFToken) {
			sc.add(EOF_TOKEN_NAME);
		}
		sc.addLineBreak();
		sc.add(";");
		sc.addLineBreak();
	}

	private void printRightRecursion(StringComposite sc, Rule rule,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass, Collection<Terminal>> classesReferenced) {

		String ruleName = getRuleName(rule.getMetaclass());
		GenClass recursiveType = rule.getMetaclass();

		{
			Copier copier = new Copier(true, true);
			Rule ruleCopy = (Rule) copier.copy(rule);
			copier.copyReferences();

			sc.add(ruleName);
			sc.add(" returns ["
					+ genClassFinder.getQualifiedInterfaceName(recursiveType)
					+ " element = null]");
			sc.add("@init{");
			sc.add("element = "
					+ genClassUtil.getCreateObjectCall(recursiveType,
							dummyEObjectClassName) + ";");
			sc.add("collectHiddenTokens(element);");
			sc.add(LIST + "<" + E_OBJECT + "> dummyEObjects  = new "
					+ ARRAY_LIST + "<" + E_OBJECT + ">();");
			sc.add("}");
			sc.add(":");

			Choice choice = ConcretesyntaxPackage.eINSTANCE
					.getConcretesyntaxFactory().createChoice();

			Sequence newSequence = ConcretesyntaxPackage.eINSTANCE
					.getConcretesyntaxFactory().createSequence();
			Choice reducedChoice = ConcretesyntaxPackage.eINSTANCE
					.getConcretesyntaxFactory().createChoice();

			CompoundDefinition compound = ConcretesyntaxPackage.eINSTANCE
					.getConcretesyntaxFactory().createCompoundDefinition();
			compound.setDefinitions(reducedChoice);
			newSequence.getParts().add(compound);

			choice.getOptions().add(newSequence);
			List<Sequence> recursionFreeSequences = new ArrayList<Sequence>();

			LeftRecursionDetector lrd = new LeftRecursionDetector(
					genClassNames2superClassNames, concreteSyntax);

			for (Sequence sequence : ruleCopy.getDefinition().getOptions()) {
				Rule leftProducingRule = lrd.findLeftProducingRule(rule
						.getMetaclass(), sequence, rule);
				if (leftProducingRule == null) {
					recursionFreeSequences.add(sequence);
				}
			}
			reducedChoice.getOptions().addAll(recursionFreeSequences);

			ruleCopy.setDefinition(choice);

			printChoice(ruleCopy.getDefinition(), ruleCopy, sc, 0,
					classesReferenced, "0");

			sc.add(" ( dummyEObject = " + ruleName
					+ "_tail { dummyEObjects.add(dummyEObject);} )*");
			sc.add("{");
			sc.add("element = (" + ruleName
					+ ") apply(element, dummyEObjects);");
			sc.add("}");
			sc.add(";");
			sc.addLineBreak();
		}

		{
			Rule tailCopy = rule;

			EList<Sequence> options = tailCopy.getDefinition().getOptions();

			String recurseName = "";
			List<Sequence> sequencesToRemove = new ArrayList<Sequence>();

			for (Sequence sequence : options) {
				int indexRecurse = 0;

				EList<Definition> parts = sequence.getParts();
				for (Definition definition : parts) {
					if (definition instanceof Containment) {
						Containment containment = (Containment) definition;
						GenFeature feature = containment.getFeature();
						GenClass featureType = feature.getTypeGenClass();
						if (recursiveType.equals(featureType)
								|| genClassNames2superClassNames
										.get(
												genClassFinder
														.getQualifiedInterfaceName(featureType))
										.contains(
												genClassFinder
														.getQualifiedInterfaceName(recursiveType))
								|| genClassNames2superClassNames
										.get(
												genClassFinder
														.getQualifiedInterfaceName(recursiveType))
										.contains(
												genClassFinder
														.getQualifiedInterfaceName(featureType))) {
							indexRecurse = parts.indexOf(definition);
							recurseName = feature.getName();
							break;
						}
					}
				}
				if (parts.size() - 1 == indexRecurse) {
					sequencesToRemove.add(sequence);
				} else {

					for (int i = 0; i <= indexRecurse; i++) {
						parts.remove(i);
					}
				}

			}
			for (Sequence sequence : sequencesToRemove) {
				tailCopy.getDefinition().getOptions().remove(sequence);
			}

			sc.add(ruleName + "_tail");
			sc.add(" returns [" + dummyEObjectClassName
					+ " element = null]");
			sc.add("@init{");
			sc.add("element = new "
					+ dummyEObjectClassName
					+ "("
					+ genClassUtil.getCreateObjectCall(rule.getMetaclass(),
							dummyEObjectClassName) + "()" + ", \""
					+ recurseName + "\");");
			sc.add("collectHiddenTokens(element);");
			sc.add("}");
			sc.add(":");

			printChoice(tailCopy.getDefinition(), tailCopy, sc, 0,
					classesReferenced, "0");

			sc.add(";");
			sc.addLineBreak();
		}
		eClassesWithSyntax.add(rule.getMetaclass());

	}

	private void printGrammarRules(StringComposite sc,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass, Collection<Terminal>> eClassesReferenced) {

		for (Rule rule : concreteSyntax.getAllRules()) {
			// operator rules must be handled separately
			if (concreteSyntax.getExpressionRules().contains(rule)) {
				continue;
			}
			LeftRecursionDetector lrd = new LeftRecursionDetector(
					genClassNames2superClassNames, concreteSyntax);
			Rule recursionRule = lrd.findLeftRecursion(rule);
			if (recursionRule != null) {
				boolean autofix = OptionManager.INSTANCE.getBooleanOptionValue(
						concreteSyntax,
						OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);
				if (lrd.isDirectLeftRecursive(rule)) {// direct left recursion
					if (autofix) {
						printRightRecursion(sc, rule, eClassesWithSyntax,
								eClassesReferenced);

						Collection<GenClass> subClasses = csUtil
								.getSubClassesWithSyntax(rule.getMetaclass(),
										concreteSyntax);
						if (!subClasses.isEmpty()) {
							sc.add("|//derived choice rules for sub-classes: ");
							printSubClassChoices(sc, subClasses);
							sc.addLineBreak();
						}

						String message = "Applied experimental autofix: Rule \""
								+ rule.getMetaclass().getName()
								+ "\" is direct left recursive by rule \""
								+ recursionRule.getMetaclass().getName()
								+ "\".";
						GenerationProblem generationWarning = new GenerationProblem(
								message, rule, Severity.WARNING);
						addProblem(generationWarning);
						continue;
					} else {
						String message = "Warning: Rule \""
								+ rule.getMetaclass().getName()
								+ "\" is direct left recursive by rule \""
								+ recursionRule.getMetaclass().getName()
								+ "\".";
						GenerationProblem generationWarning = new GenerationProblem(
								message, rule, Severity.WARNING);
						addProblem(generationWarning);
						printGrammarRule(rule, sc, eClassesWithSyntax,
								eClassesReferenced);
					}
				} else {
					String message = "Rule \"" + rule.getMetaclass().getName()
							+ "\" is mutual left recursive by rule \""
							+ recursionRule.getMetaclass().getName()
							+ "\"! Please restructure the grammar.";
					GenerationProblem generationWarning = new GenerationProblem(
							message, rule, Severity.WARNING);
					addProblem(generationWarning);
					printGrammarRule(rule, sc, eClassesWithSyntax,
							eClassesReferenced);
				}

			} else {
				printGrammarRule(rule, sc, eClassesWithSyntax,
						eClassesReferenced);
			}
		}
		// handle operator rules
		if (!concreteSyntax.getExpressionRules().isEmpty()) {
			for (String expressionIdent : concreteSyntax.getExpressionSubsets()) {
				EList<Rule> expressionSubset = concreteSyntax.getExpressionSubset(expressionIdent);
				printGrammarExpressionSlice(expressionSubset, sc, eClassesWithSyntax, eClassesReferenced);
			}
		}
	}

	
	private void printGrammarRulePrefix(GenClass genClass, String ruleName, StringComposite sc) {
		String qualifiedClassName = genClassFinder
				.getQualifiedInterfaceName(genClass);

		sc.add(ruleName);
		if (Map.Entry.class.getName().equals(
				genClass.getEcoreClass().getInstanceClassName())) {
			sc.add(" returns [" + dummyEObjectClassName
					+ " element = null]");
		} else {
			sc.add(" returns [" + qualifiedClassName + " element = null]");
		}

		sc.add("@init{");
		sc.add("}");
		sc.add(":");	
	}
	
	private void printGrammarRuleSuffix(StringComposite sc) {
		sc.add(";");
		sc.addLineBreak();
	}
	
	private void printGrammarRule(Rule rule, StringComposite sc,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass, Collection<Terminal>> eClassesReferenced) {
		GenClass genClass = rule.getMetaclass();
		String ruleName = getRuleName(genClass);

		printGrammarRulePrefix(genClass,ruleName,sc);
		
		printChoice(rule.getDefinition(), rule, sc, 0, eClassesReferenced, "0");

		Collection<GenClass> subClasses = csUtil
				.getSubClassesWithSyntax(genClass, concreteSyntax);
		if (!subClasses.isEmpty()) {
			sc.add("|//derived choice rules for sub-classes: ");
			sc.addLineBreak();
			printSubClassChoices(sc, subClasses);
			sc.addLineBreak();
		}
		
		printGrammarRuleSuffix(sc);

		eClassesWithSyntax.add(genClass);
	}

	// TODO mseifert: split this method into smaller ones	
	private void printGrammarExpressionSlice(List<Rule> slice, StringComposite sc,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass, Collection<Terminal>> eClassesReferenced) {
		ListIterator<Rule> it = slice.listIterator();
		
		while (it.hasNext()) {
			//TODO: Add a check that all equal weight rules are equally structured
			Rule firstRule = it.next();
			int weight = firstRule.getOperatorWeight();
			List<Rule> equalWeightOPs = new LinkedList<Rule>();
			equalWeightOPs.add(firstRule);
			while (it.hasNext()) {
				Rule currentRule = it.next();
				int currentWeight = currentRule.getOperatorWeight();
				if (currentWeight == weight) {
					equalWeightOPs.add(currentRule);
				} else {
					it.previous();
					break;
				}
			}
			
			boolean isLast = !it.hasNext();
			
			Sequence firstSequence = firstRule.getDefinition().getOptions().get(0);
			AnnotationType operatorType = firstRule.getOperatorAnnotation().getType();
			
			String ruleName = getExpressionSliceRuleName(firstRule);	

			GenClass returnGenClass = firstRule.getMetaclass();
			for (GenClass metaClass : allGenClasses) {
				// TODO mseifert: use constant here
				if (metaClass.getName().equals(firstRule.getOperatorAnnotation().getValue("identifier"))) {
					returnGenClass = metaClass;
				}
			}
		
			printGrammarRulePrefix(returnGenClass,ruleName,sc);
			
			if (!isLast) {
			
				//we assume all arguments to be typed by the same class
				final String nextRuleName = getExpressionSliceRuleName(it.next());
				it.previous();
				//we do unary operators first
				if (operatorType == AnnotationType.OP_UNARY) {
					 //1st case: unary operator starts with keyword
					if (firstSequence.getParts().get(0) instanceof CsString) {
						for (Rule rule : equalWeightOPs) {
							List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
							assert definitions.size() == 2;
							assert definitions.get(0) instanceof CsString;
							assert definitions.get(1) instanceof Containment;
							CsString csString = (CsString) definitions.get(0);
							Containment containment = (Containment) definitions.get(1);
							printCsString(csString, rule, sc, 0, eClassesReferenced);									
							sc.add("arg = " + nextRuleName);
							printTerminalAction(containment, firstRule, sc, "arg", "", "arg", null, "null");
							sc.add("|");
							sc.addLineBreak();
						}
						sc.addLineBreak();
						sc.add("arg = " + nextRuleName + "{ element = arg; }");	
					}
					//2nd case: unary operator starts with argument (this means left recursion)
					else { 	
						sc.add("arg = "+ nextRuleName);
						sc.add("(");
						for (Rule rule : equalWeightOPs) {
							List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
							assert definitions.size() == 2;
							assert definitions.get(0) instanceof Containment;
							assert definitions.get(1) instanceof CsString;
							CsString csString = (CsString) firstSequence.getParts().get(1);
							Containment containment = (Containment) definitions.get(1);
							printCsString(csString, rule, sc, 0, eClassesReferenced);	
							printTerminalAction(containment, rule, sc, "arg", "", "arg", null, "null");
							sc.add("|");
							sc.addLineBreak();
						}
						
						sc.add("/* epsilon */ { element = arg; } ");
						sc.addLineBreak();
						sc.add(")");
					}
				}
				// now we do binary infix operators
				else {
					//1st case left associative operators, e.g., -,+,*,/ etc.
					if (operatorType == AnnotationType.OP_LEFTASSOC) {
						sc.add("leftArg = " + nextRuleName);
						sc.add("((");
						for (Iterator<Rule> ruleIt = equalWeightOPs.iterator(); ruleIt.hasNext();) {
							Rule rule = ruleIt.next();
							List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
							assert definitions.size() == 3;
							assert definitions.get(0) instanceof Containment;
							assert definitions.get(1) instanceof CsString;
							assert definitions.get(2) instanceof Containment;
							Containment leftContainment = (Containment) definitions.get(0);
							CsString csString = (CsString) definitions.get(1);
							Containment rightContainment = (Containment) definitions.get(2);
							sc.add("{ element = null; }");
							printCsString(csString, rule, sc, 0, eClassesReferenced);									
							sc.add("rightArg = " + nextRuleName);
							printTerminalAction(leftContainment, rule, sc, "leftArg", "", "leftArg", null, "null");
							printTerminalAction(rightContainment, rule, sc, "rightArg", "", "rightArg", null, "null");
							sc.add("{ leftArg = element; /* this may become an argument in the next iteration */ }");
							if (ruleIt.hasNext()) {
								sc.add("|");
								sc.addLineBreak();
							}
						}
				
						sc.add(")+ | /* epsilon */ { element = leftArg; }");
						sc.addLineBreak();
						sc.add(")");
					}
					//2nd case right associative operators , e.g., ^
					else {
						assert operatorType == AnnotationType.OP_RIGHTASSOC;
						//final String thisRuleName = getRuleName(rule.getMetaclass());
						sc.add("leftArg = " + nextRuleName);
						sc.add("((");
						for (Iterator<Rule> ruleIt = equalWeightOPs.iterator(); ruleIt.hasNext();) {
							Rule rule = ruleIt.next();
							List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
							assert definitions.size() == 3;
							assert definitions.get(0) instanceof Containment;
							assert definitions.get(1) instanceof CsString;
							assert definitions.get(2) instanceof Containment;
							Containment leftContainment = (Containment) definitions.get(0);
							CsString csString = (CsString) definitions.get(1);
							Containment rightContainment = (Containment) definitions.get(2);
							printCsString(csString, rule, sc, 0, eClassesReferenced);	
							sc.add("rightArg = " + ruleName);
							printTerminalAction(leftContainment, rule, sc, "leftArg", "", "leftArg", null, "null");
							printTerminalAction(rightContainment, rule, sc, "rightArg", "", "rightArg", null, "null");
							if (ruleIt.hasNext()) {
								sc.add("|");
								sc.addLineBreak();	
							}
						}
						sc.add(") | /* epsilon */ { element = leftArg; }");
						sc.addLineBreak();
						sc.add(")");
					}
					
				}
				printGrammarRuleSuffix(sc);
			}
			else {
				assert operatorType == AnnotationType.OP_PRIMITIVE;
				List<GenClass> choiceClasses = new LinkedList<GenClass>();
				for (Rule rule : equalWeightOPs) {
					choiceClasses.add(rule.getMetaclass());
				}
				printSubClassChoices(sc, choiceClasses);
				printGrammarRuleSuffix(sc);
				
				for (Rule rule : equalWeightOPs) {
					printGrammarRule(rule, sc, eClassesWithSyntax, eClassesReferenced);	
				}
			}
		}
	}
	
	private String getExpressionSliceRuleName(Rule rule){
		// TODO mseifert: make sure the names generated by this method do not
		// overlap with names for normal rules
		// TODO mseifert: use constants here
		String ruleName = rule.getOperatorAnnotation().getValue("identifier") + "_level_";
		String weight = rule.getOperatorAnnotation().getValue("weight").replace('-','_');
		ruleName += weight;
		return "parse_" + ruleName;
	}

	private String getRuleName(GenClass genClass) {
		String ruleName = genClassFinder.getEscapedTypeName(genClass);
		return "parse_" + ruleName;
	}

	private int printChoice(Choice choice, Rule rule, StringComposite sc,
			int count, Map<GenClass, Collection<Terminal>> eClassesReferenced, String scopeID) {
		Iterator<Sequence> it = choice.getOptions().iterator();
		while (it.hasNext()) {
			Sequence seq = it.next();
			count = printSequence(seq, rule, sc, count, eClassesReferenced, scopeID);
			if (it.hasNext()) {
				sc.addLineBreak();
				sc.add("|");
			}
		}
		return count;
	}

	private int printSequence(Sequence sequence, Rule rule, StringComposite sc,
			int count, Map<GenClass, Collection<Terminal>> eClassesReferenced, String scopeID) {

		int i = 0;
		for (Definition definition : sequence.getParts()) {
			if (definition instanceof LineBreak || definition instanceof WhiteSpaces) {
				continue;
			}
			ConcreteSyntax syntax = getContext().getConcreteSyntax();
			Set<Expectation> expectations = computer.computeFollowSet(syntax, definition);
			addToFollowSetMap(definition, expectations);
			String cardinality = csUtil.computeCardinalityString(definition);
			if (!"".equals(cardinality)) {
				sc.add("(");
			}
			if (definition instanceof CompoundDefinition) {
				String subScopeID = scopeID + "." + i;

				CompoundDefinition compoundDef = (CompoundDefinition) definition;
				sc.add("(");
				count = printChoice(compoundDef.getDefinitions(), rule, sc,
						count, eClassesReferenced, subScopeID);
				sc.add(")");
				i++;
			} else if (definition instanceof CsString) {
				final CsString csString = (CsString) definition;
				count = printCsString(csString, rule, sc, count,
						eClassesReferenced);
			} else {
				assert definition instanceof Terminal;
				final Terminal terminal = (Terminal) definition;
				count = printTerminal(terminal, rule, sc, count,
						eClassesReferenced);
			}
			if (!"".equals(cardinality)) {
				sc.addLineBreak();
				sc.add(")" + cardinality);
			}
			sc.add("{");
			sc.add("// expected elements (follow set)");
			addExpectationsCode(sc, expectations);
			sc.add("}");

			sc.addLineBreak();
		}
		return count;
	}

	private void addToFollowSetMap(Definition definition, Set<Expectation> expectations) {
		// only terminals are important here
		if (definition instanceof Placeholder) {
			GenFeature feature = ((Placeholder) definition).getFeature();
			if (feature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
				return;
			}
			followSetMap.put(getID(definition), expectations);
		} else if (definition instanceof CsString) {
			followSetMap.put(getID(definition), expectations);
		}
	}

	private void addExpectationsCode(StringComposite sc, Set<Expectation> expectations) {
		for (Expectation expectation : expectations) {
			EObject expectedElement = expectation.getExpectedElement();
			String terminalID = getID(expectedElement);
			// here the containment trace is used
			// TODO mseifert: figure out whether this is really needed
			StringBuilder traceArguments = new StringBuilder();
			List<GenFeature> containmentTrace = expectation.getContainmentTrace();
			for (GenFeature genFeature : containmentTrace) {
				traceArguments.append(", ");
				traceArguments.append(getFeatureConstantFieldName(genFeature));
			}
			sc.add("addExpectedElement(new "
					+ expectedTerminalClassName + 
					"(" + terminalID + ", " + followSetID + traceArguments + "));");
		}
		followSetID++;
	}
	
	// TODO mseifert: put this constants into a separate class
	private void addTerminalConstants(StringComposite sc) {
		for (EObject expectedElement : idMap.keySet()) {
			String terminalID = idMap.get(expectedElement);
			
			GenClass genClass = csUtil.findContainingRule(expectedElement).getMetaclass();
			String eClassConstantAccessor = generatorUtil.getClassAccessor(genClass);
			if (expectedElement instanceof Placeholder) {
				Placeholder placeholder = (Placeholder) expectedElement;
				GenFeature genFeature = placeholder.getFeature();
				// ignore the anonymous features
				if (genFeature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
					continue;
				}

				String featureConstantAccessor = generatorUtil.getFeatureAccessor(genClass, genFeature);
				sc.add("private final static " + iExpectedElementClassName + " " + terminalID + " = new " + expectedStructuralFeatureClassName + "("
						+ eClassConstantAccessor + ", " + featureConstantAccessor + ", \"" + placeholder.getToken().getName() + "\");");
			} else if (expectedElement instanceof CsString) {
				CsString expectedKeyword = (CsString) expectedElement;
				String escapedCsString = StringUtil.escapeToJavaStringInANTLRGrammar(expectedKeyword.getValue());
				sc.add("private final static " + iExpectedElementClassName + " " + terminalID + " = new " + expectedCsStringClassName 
						+ "(" + eClassConstantAccessor + ", \"" + escapedCsString + "\");");
			} else {
				throw new RuntimeException("Unknown expected element type: " + expectedElement);
			}
		}
		sc.addLineBreak();
		
		// ask for all features to make sure respective fields are generated
		for (String firstID : followSetMap.keySet()) {
			for (Expectation expectation : followSetMap.get(firstID)) {
				List<GenFeature> containmentTrace = expectation.getContainmentTrace();
				for (GenFeature genFeature : containmentTrace) {
					getFeatureConstantFieldName(genFeature);
				}
			}
		}
		
		// generate fields for all used features
		for (GenFeature genFeature : eFeatureToConstantNameMap.keySet()) {
			String fieldName = getFeatureConstantFieldName(genFeature);
			String featureAccessor = generatorUtil.getFeatureAccessor(genFeature.getGenClass(), genFeature);
			sc.add("private final static " + E_STRUCTURAL_FEATURE + " " + fieldName + " = " + featureAccessor + ";");
		}
		sc.addLineBreak();
		
		sc.add("private final static " + E_STRUCTURAL_FEATURE + "[] EMPTY_FEATURE_ARRAY = new " + E_STRUCTURAL_FEATURE + "[0];");
		sc.addLineBreak();
		
		// we need to split the code to wire the terminals with their
		// followers, because the code does exceed the 64KB limit for
		// methods if the grammar is big
		int bytesUsedInCurrentMethod = 0;
		boolean methodIsFull = true;
		int i = 0;
		int numberOfMethods = 0;
		// create multiple wireX() methods
		for (String firstID : followSetMap.keySet()) {
			if (methodIsFull) {
				sc.add("public static void wire" + numberOfMethods + "() {");
				numberOfMethods++;
				methodIsFull = false;
			}
			for (Expectation expectation : followSetMap.get(firstID)) {
				EObject follower = expectation.getExpectedElement();
				List<GenFeature> containmentTrace = expectation.getContainmentTrace();
				StringBuilder trace = new StringBuilder();
				if (containmentTrace.isEmpty()) {
					trace.append(", EMPTY_FEATURE_ARRAY");
				} else {
					trace.append(", new " + E_STRUCTURAL_FEATURE + "[] {");
					for (GenFeature genFeature : containmentTrace) {
						trace.append(getFeatureConstantFieldName(genFeature) + ", ");
						// another 16 bytes for each access to a constant
						bytesUsedInCurrentMethod += 16;
					}
					trace.append("}");
				}
				sc.add(firstID + ".addFollower(" + getID(follower) + trace + ");");
				// the method call takes 19 bytes
				bytesUsedInCurrentMethod += 19;
			}
			if (bytesUsedInCurrentMethod >= 63 * 1024) {
				methodIsFull = true;
				bytesUsedInCurrentMethod = 0;
			}
			if (methodIsFull || i == followSetMap.keySet().size() - 1) {
				sc.add("}");
			}
			i++;
		}
		// call all wireX() methods from the static constructor
		sc.add("// wire the terminals");
		sc.add("static {");
		for (int c = 0; c < numberOfMethods; c++) {
			sc.add("wire" + c + "();");
		}
		sc.add("}");
	}

	private String getFeatureConstantFieldName(GenFeature genFeature) {
		if (!eFeatureToConstantNameMap.keySet().contains(genFeature)) {
			String featureConstantName = "FEATURE_" + featureCounter;
			featureCounter++;
			eFeatureToConstantNameMap.put(genFeature, featureConstantName);
		}
		return eFeatureToConstantNameMap.get(genFeature);
	}

	private String getID(EObject expectedElement) {
		if (!idMap.containsKey(expectedElement)) {
			idMap.put(expectedElement, "TERMINAL_" + idCounter);
			idCounter++;
		}
		return idMap.get(expectedElement);
	}

	private int printCsString(CsString csString, Rule rule, StringComposite sc,
			int count, Map<GenClass, Collection<Terminal>> eClassesReferenced) {
		String identifier = "a" + count;
		String escapedCsString = StringUtil.escapeToANTLRKeyword(csString.getValue());
		sc.add(identifier + " = '" + escapedCsString + "' {");
		sc.add("if (element == null) {");
		sc.add("element = "
				+ genClassUtil.getCreateObjectCall(rule.getMetaclass(),
						dummyEObjectClassName) + ";");
		sc.add("}");
		sc.add("collectHiddenTokens(element);");
		sc.add("copyLocalizationInfos((" + COMMON_TOKEN + ")" + identifier
				+ ", element);");
		sc.add("}");
		return ++count;
	}

	private int printTerminal(Terminal terminal, Rule rule, StringComposite sc,
			int count, Map<GenClass, Collection<Terminal>> eClassesReferenced) {
		final GenClass genClass = rule.getMetaclass();
		final GenFeature genFeature = terminal.getFeature();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
		final String ident = "a" + count;
		final String proxyIdent = "proxy";

		StringComposite resolvements = new ANTLRGrammarComposite();

		sc.add("(");

		if (terminal instanceof Containment) {
			assert ((EReference) eFeature).isContainment();
			Containment containment = (Containment) terminal;

			EList<GenClass> types = csUtil.getAllowedSubTypes(containment);

			int internalCount = 0;
			for (GenClass type : types) {
				if (internalCount != 0) {
					sc.add("|");
				}

				String internalIdent = ident + "_" + internalCount;
				sc.add(internalIdent + " = " + getRuleName(type));

				if (!(genFeature.getEcoreFeature() instanceof EAttribute)) {
					// remember which classes are referenced to add choice rules
					// for these classes later
					if (!eClassesReferenced.keySet().contains(type)) {
						eClassesReferenced.put(type, new LinkedHashSet<Terminal>());
					}

					eClassesReferenced.get(type).add(terminal);
				}

				printTerminalAction(terminal, rule, sc, internalIdent, proxyIdent, internalIdent,
						resolvements, null);

				internalCount++;
			}
		} else {
			assert terminal instanceof Placeholder;
			Placeholder placeholder = (Placeholder) terminal;
			CompleteTokenDefinition token = placeholder.getToken();
			String tokenName = token.getName();

			sc.add(ident + " = " + tokenName);
			sc.addLineBreak();

			// ignore the anonymous features
			if (genFeature != ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
				String targetTypeName = null;
				String resolvedIdent = "resolved";
				String preResolved = resolvedIdent + "Object";
				String resolverIdent = "tokenResolver";
				resolvements.add(getClassNameHelper().getI_TOKEN_RESOLVER() + " "
						+ resolverIdent
						+ " = tokenResolverFactory.createTokenResolver(\""
						+ tokenName + "\");");
				resolvements.add(resolverIdent + ".setOptions(getOptions());");
				resolvements.add(getClassNameHelper().getI_TOKEN_RESOLVE_RESULT()
						+ " result = getFreshTokenResolveResult();");
				resolvements.add(resolverIdent + ".resolve(" + ident
						+ ".getText(), element.eClass().getEStructuralFeature("
						+ generatorUtil.getFeatureConstant(genClass, genFeature)
						+ "), result);");
				resolvements.add(OBJECT + " " + preResolved
						+ " = result.getResolvedToken();");
				resolvements.add("if (" + preResolved + " == null) {");
				resolvements.add("addErrorToResource(result.getErrorMessage(), (("
						+ COMMON_TOKEN + ") " + ident + ").getLine(), (("
						+ COMMON_TOKEN + ") " + ident
						+ ").getCharPositionInLine(), ((" + COMMON_TOKEN + ") "
						+ ident + ").getStartIndex(), ((" + COMMON_TOKEN + ") "
						+ ident + ").getStopIndex());");
				resolvements.add("}");
	
				String expressionToBeSet = null;
				
				if (eFeature instanceof EReference) {
					targetTypeName = "String";
					expressionToBeSet = proxyIdent;
	
					// a sub type that can be instantiated as a proxy
					GenClass instanceType = genFeature.getTypeGenClass();
					GenClass proxyType = null;
	
					if (genClassUtil.isNotConcrete(instanceType)) {
						// TODO mseifert: replace this code with a call to class
						// GenClassFinder
						// a slightly more elegant version of this code can also be
						// found in the ScannerlessParserGenerator
						for (GenClass instanceCand : allGenClasses) {
							Collection<String> supertypes = genClassNames2superClassNames
									.get(genClassFinder
											.getQualifiedInterfaceName(instanceCand));
							if (genClassUtil.isConcrete(instanceCand)
									&& supertypes
											.contains(genClassFinder
													.getQualifiedInterfaceName(instanceType))) {
								proxyType = instanceCand;
								break;
							}
						}
					} else {
						proxyType = instanceType;
					}
					resolvements.add(targetTypeName + " " + resolvedIdent + " = ("
							+ targetTypeName + ") " + preResolved + ";");
					resolvements.add(genClassFinder
							.getQualifiedInterfaceName(proxyType)
							+ " "
							+ expressionToBeSet
							+ " = "
							+ genClassUtil.getCreateObjectCall(proxyType,
									dummyEObjectClassName) + ";");
					resolvements.add("collectHiddenTokens(element);");
					resolvements
							.add("registerContextDependentProxy(new "
									+ contextDependentURIFragmentFactoryClassName
									+ "<"
									+ genClassFinder
											.getQualifiedInterfaceName(genFeature
													.getGenClass())
									+ ", "
									+ genClassFinder
											.getQualifiedInterfaceName(genFeature
													.getTypeGenClass())
									+ ">("
									+ getContext()
											.getReferenceResolverAccessor(genFeature)
									+ "), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature("
									+ generatorUtil.getFeatureConstant(genClass,
											genFeature) + "), " + resolvedIdent
									+ ", " + proxyIdent + ");");
					// remember that we must resolve proxy objects for this feature
					getContext().addNonContainmentReference(genFeature);
				} else {
					// the feature is an EAttribute
					targetTypeName = genFeature.getQualifiedListItemType(null);
					resolvements.add(targetTypeName + " " + resolvedIdent + " = ("
							+ getObjectTypeName(targetTypeName) + ")" + preResolved
							+ ";");
					expressionToBeSet = "resolved";
				}

				printTerminalAction(placeholder, rule, sc, ident, proxyIdent, expressionToBeSet,
						resolvements, tokenName);
			}
		}

		sc.add(")");
		return ++count;
	}

	private void printTerminalAction(Terminal terminal, Rule rule,
			StringComposite sc,
			final String ident, final String proxyIdent,
			String expressionToBeSet, StringComposite resolvements,
			String tokenName) {
		final GenFeature genFeature = terminal.getFeature();
		final GenClass genClass = genFeature.getGenClass();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
	
		sc.add("{");
		sc.add("if (terminateParsing) {");
		sc.add("throw new " + getClassNameHelper().getTERMINATE_PARSING_EXCEPTION() + "();");
		sc.add("}");
		sc.add("if (element == null) {");
		sc.add("element = "
				+ genClassUtil.getCreateObjectCall(rule.getMetaclass(),
						dummyEObjectClassName) + ";");
		sc.add("}");
		// TODO mseifert: escape tokeName correctly
		sc.add(new StringComponent(STRING + " tokenName = \"" + tokenName + "\";", "tokenName"));
		sc.add("if (" + ident + " != null) {");
		if (resolvements != null) {
			sc.add(resolvements);
		}
		sc.add("if (" + expressionToBeSet + " != null) {");
		final String featureConstant = generatorUtil.getFeatureConstant(genClass, genFeature);
		generatorUtil.addCodeToSetFeature(sc, genClass, featureConstant, eFeature, expressionToBeSet);
		sc.add("}");
		sc.add("collectHiddenTokens(element);");
		if (terminal instanceof Containment) {
			sc.add("copyLocalizationInfos(" + ident + ", element); ");
		} else {
			sc.add("copyLocalizationInfos((" + COMMON_TOKEN + ") " + ident + ", element);");
			if (eFeature instanceof EReference) {
				// additionally set position information for the proxy instance
				sc.add("copyLocalizationInfos((" + COMMON_TOKEN + ") " + ident + ", " + proxyIdent + ");");
			}
		}

		sc.add("}");
		sc.add("}");
	}

	private void printImplicitChoiceRules(StringComposite sc,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass, Collection<Terminal>> eClassesReferenced) {

		for (GenClass referencedClass : eClassesReferenced.keySet()) {
			if (!containsEqualByName(eClassesWithSyntax, referencedClass)) {
				// rule not explicitly defined in CS: most likely a choice rule
				// in the AS
				Collection<GenClass> subClasses = csUtil
						.getSubClassesWithSyntax(referencedClass,
								concreteSyntax);

				if (!subClasses.isEmpty()) {
					sc.add(getRuleName(referencedClass));
					sc.add(" returns ["
							+ genClassFinder
									.getQualifiedInterfaceName(referencedClass)
							+ " element = null]");
					sc.add(":");
					//Expression slices are formed over a common abstract superclass
					if (concreteSyntax.getExpressionSubset(referencedClass.getName()).isEmpty()) {
						printSubClassChoices(sc, subClasses);
					} else {
						List<Rule> slice = concreteSyntax.getExpressionSubset(referencedClass.getName());
						sc.add("c = " + getExpressionSliceRuleName(slice.get(0))+"{ element = c; /* this rule is an expression root */ }");
					}
						
					sc.addLineBreak();
					sc.add(";");
					sc.addLineBreak();

					eClassesWithSyntax.add(referencedClass);
				}
			}
		}
	}

	private void printSubClassChoices(StringComposite sc,
			Collection<GenClass> subClasses) {
		int count = 0;
		for (Iterator<GenClass> subClassIterator = subClasses.iterator(); subClassIterator.hasNext();) {
			GenClass subRef = subClassIterator.next();
			String identifier = "c" + count;
			sc.add(identifier + " = " + getRuleName(subRef) + "{ element = " + identifier + "; /* this is a subclass or expression choice */ }");
			if (subClassIterator.hasNext()) {
				sc.add("|");
			}
			count++;
		}
	}

	// TODO this method does not belong here
	private boolean containsEqualByName(EList<GenClass> list, GenClass o) {
		for (GenClass entry : list) {
			EClass entryClass = entry.getEcoreClass();
			EClass oClass = o.getEcoreClass();
			if (entryClass.getName().equals(oClass.getName())
					&& entryClass.getEPackage().getNsURI().equals(
							oClass.getEPackage().getNsURI())) {
				return true;
			}
		}
		return false;
	}

	private void addTokenDefinitions(StringComposite sc) {
		for (CompleteTokenDefinition tokenDefinition : concreteSyntax.getActiveTokens()) {
			printToken(tokenDefinition, sc);
		}
	}

	private void printToken(CompleteTokenDefinition definition, StringComposite sc) {
		sc.add(definition.getName());
		sc.add(":");

		sc.add(definition.getRegex());
		// keyword tokens do never go to channel 99, because they
		// are contained in the grammar. if they are sent to channel
		// 99 rules containing the keywords will never be matched
		if (definition.isHidden() && !isKeyword(definition)) {
			sc.add("{ _channel = 99; }");
		}
		sc.add(";");
	}

	private boolean isKeyword(CompleteTokenDefinition definition) {
		// this comparison of the regular expression should in theory be
		// replaced by a comparison of the two automata. however, ANTLR
		// does not compare the in-line tokens (keywords) and the defined
		// tokens using automata, but uses a string comparison of the 
		// regular expressions. if we compare the tokens using the automata
		// the resulting ANTLR grammars will not work.
		String assumeKeyword = definition.getRegex().substring(1, definition.getRegex().length() - 1);
		boolean contains = keywords.contains(assumeKeyword);
		return contains;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ANTLRGrammarGenerator(context);
	}
}
