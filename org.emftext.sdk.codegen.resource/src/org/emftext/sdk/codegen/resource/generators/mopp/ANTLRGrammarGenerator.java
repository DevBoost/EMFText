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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ANTLR_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ANTLR_STRING_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BIT_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COMMON_TOKEN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COMMON_TOKEN_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.EARLY_EXIT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT_IMPL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FAILED_PREDICATE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INVOCATION_HANDLER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LEXER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MATH;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.METHOD;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_NOT_SET_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_RANGE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_SET_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_TOKEN_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_TREE_NODE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.NO_VIABLE_ALT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PROXY;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RECOGNITION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STACK;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING_BUILDER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.THROWABLE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.TOKEN;

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.sdk.LeftRecursionDetector;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.composites.ANTLRGrammarComposite;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComponent;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.ResourceBaseGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.Expectation;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.ExpectationComputer;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.OperatorAnnotationProperty;
import org.emftext.sdk.concretesyntax.OperatorAnnotationType;
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
 * To enable code completion the grammar is augmented with additional code. For
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
public class ANTLRGrammarGenerator extends ResourceBaseGenerator<Object> {
	
	/**
	 * The name of the EOF token which can be printed to force end of file after
	 * a parse from the root.
	 */
	public static final String EOF_TOKEN_NAME = "EOF";

	private static final GenClassUtil genClassUtil = new GenClassUtil();

	private ConcreteSyntax concreteSyntax;

	/**
	 * A map that projects the fully qualified name of generator classes to the
	 * set of fully qualified names of all their super classes.
	 */
	private Map<String, Collection<String>> genClassNames2superClassNames;
	private Collection<GenClass> allGenClasses;
	private Set<String> keywords;

	private GenClassFinder genClassFinder = new GenClassFinder();
	private GenClassCache genClassCache;
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

	public ANTLRGrammarGenerator() {
		super();
	}

	private ANTLRGrammarGenerator(GenerationContext context) {
		super(context, null, TextResourceArtifacts.ANTLR_GRAMMAR);
		concreteSyntax = context.getConcreteSyntax();
		genClassCache = concreteSyntax.getGenClassCache();
	}

	private void initOptions() {
		forceEOFToken = OptionManager.INSTANCE.getBooleanOptionValue(
				concreteSyntax, OptionTypes.FORCE_EOF);
	}

	private void initCaches() {
		allGenClasses = genClassFinder.findAllGenClasses(concreteSyntax, true, true);
		genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses, genClassCache);
		
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
		String lexerName = getLexerName();
		String parserName = getParserName();
		boolean backtracking = OptionManager.INSTANCE.getBooleanOptionValue(
				concreteSyntax, OptionTypes.ANTLR_BACKTRACKING);
		boolean memoize = OptionManager.INSTANCE.getBooleanOptionValue(
				concreteSyntax, OptionTypes.ANTLR_MEMOIZE);

		ANTLRGrammarComposite sc = new ANTLRGrammarComposite();

		sc.add("grammar " + csName + ";");
		sc.addLineBreak();

		sc.add("options {");
		sc.add("superClass = " + getContext().getClassName(TextResourceArtifacts.ANTLR_PARSER_BASE) + ";");
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

		ANTLRGrammarComposite grammarCore = new ANTLRGrammarComposite();
		addRules(grammarCore);
		addTokenDefinitions(grammarCore);

		sc.add("@members{");
		addFields(sc);
		addMethods(lexerName, parserName, sc);
		sc.add("}");
		sc.addLineBreak();
		
		sc.add(grammarCore.toString());

		writer.print(sc.toString());
		return getCollectedErrors().isEmpty();
	}

	private void addRules(ANTLRGrammarComposite sc) {
		printStartRule(sc);

		EList<GenClass> eClassesWithSyntax = new BasicEList<GenClass>();
		Map<GenClass, Collection<Terminal>> eClassesReferenced = new LinkedHashMap<GenClass, Collection<Terminal>>();
		
		printGrammarRules(sc, eClassesWithSyntax, eClassesReferenced);		
		printImplicitChoiceRules(sc, eClassesWithSyntax, eClassesReferenced);
	}

	private void addMethods(String lexerName, String parserName,
			ANTLRGrammarComposite sc) {
		generatorUtil.addAddErrorToResourceMethod(sc, getContext());
		addAddExpectedElementMethod(sc);
		generatorUtil.addAddMapEntryMethod(sc, dummyEObjectClassName, getContext());
		generatorUtil.addAddObjectToListMethod(sc);
		addApplyMethod(sc);
		addCollectHiddenTokensMethod(lexerName, sc);
		addCopyLocalizationInfosMethod1(sc);
		addCopyLocalizationInfosMethod2(sc);
		addSetLocalizationEndMethod(sc);
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
				contextDependentUriFragmentFactoryClassName, true, getContext());
		addReportErrorMethod(sc);
		addReportLexicalErrorsMethod(sc);
		addSetOptionsMethod(sc);
		addTerminateMethod(sc);
		addCompletedElementMethod(sc);
		addCreateDynamicProxyMethod(sc);
		addRetrieveLayoutInformationMethod(sc);
		generatorUtil.addGetLayoutAdapterMethod(sc, layoutInformationAdapterClassName);
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

	private void addReportLexicalErrorsMethod(JavaComposite sc) {
		sc.addJavadoc("Translates errors thrown by the lexer into human readable messages.");
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

	private void addReportErrorMethod(ANTLRGrammarComposite sc) {
		sc.addJavadoc("Translates errors thrown by the parser into human readable messages.");
		sc.add("public void reportError(final " + RECOGNITION_EXCEPTION + " e)  {");
		sc.add(STRING + " message = e.getMessage();");
		sc.add("if (e instanceof " + MISMATCHED_TOKEN_EXCEPTION + ") {");
		sc.add(MISMATCHED_TOKEN_EXCEPTION + " mte = (" + MISMATCHED_TOKEN_EXCEPTION + ") e;");
		sc.add(STRING + " tokenName = \"<unknown>\";");
		sc.add("if (mte.expecting == Token.EOF) {");
		sc.add("tokenName = \"EOF\";");
		sc.add("} else {");
		sc.add("tokenName = getTokenNames()[mte.expecting];");
		sc.add("tokenName = " + stringUtilClassName + ".formatTokenName(tokenName);");
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
		
		sc.addComment("the resource may be null if the parse is used for code completion");
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

	private void addParseMethod(ANTLRGrammarComposite sc) {
		sc.addJavadoc("Implementation that calls {@link #doParse()} and handles the thrown RecognitionExceptions.");
		sc.add("public " + iParseResultClassName + " parse() {");
		sc.add("terminateParsing = false;");
		sc.add("postParseCommands = new " + ARRAY_LIST + "<" + iCommandClassName + "<" + iTextResourceClassName + ">>();");
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
		sc.addComment(
			"can be caused if a null is set on EMF models where not allowed. " +
			"this will just happen if other errors occurred before"
		);
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
		// TODO mseifert: instead of passing isContainment, we can call this method only
		// for contained objects
		sc.add("protected void completedElement(" + OBJECT + " object, boolean isContainment) {");
		sc.add("if (isContainment && !this.incompleteObjects.isEmpty()) {");
		sc.add("this.incompleteObjects.pop();");
		sc.add("}");
		sc.add("if (object instanceof " + E_OBJECT + ") {");
		sc.add("this.tokenIndexOfLastCompleteElement = getTokenStream().index();");
		sc.add("this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;");
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

	private void addDefaultConstructor(String parserName, ANTLRGrammarComposite sc) {
		sc.addJavadoc("This default constructor is only used to call createInstance() on it.");
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
		sc.add("typeObject = options.get(" + iOptionsClassName + ".RESOURCE_CONTENT_TYPE);");
		sc.add("}");
		sc.add("return typeObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoParseMethod(String lexerName, ANTLRGrammarComposite sc) {
		sc.add("protected " + E_OBJECT + " doParse() throws " + RECOGNITION_EXCEPTION + " {");
		sc.add("this.lastPosition = 0;");
		sc.addComment("required because the lexer class can not be subclassed");
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
				String qualifiedClassName = genClassCache.getQualifiedInterfaceName(rule.getMetaclass());
				String ruleName = getRuleName(rule.getMetaclass());
				sc.add("if (type.getInstanceClass() == " + qualifiedClassName + ".class) {");
				sc.add("return " + ruleName + "();");
				sc.add("}");
			}
		}
		sc.add("}");
		sc.add("throw new " + unexpectedContentTypeExceptionClassName + "(typeObject);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCollectHiddenTokensMethod(String lexerName, ANTLRGrammarComposite sc) {
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
				sc.addComment("call token resolver");

				String identifierPrefix = "resolved";
				String resolverIdentifier = identifierPrefix + "Resolver";
				String resolvedObjectIdentifier = identifierPrefix + "Object";
				String resolveResultIdentifier = identifierPrefix + "Result";

				sc
						.add(iTokenResolverClassName
								+ " "
								+ resolverIdentifier
								+ " = tokenResolverFactory.createCollectInTokenResolver(\""
								+ attributeName + "\");");
				sc.add(resolverIdentifier + ".setOptions(getOptions());");
				sc.add(iTokenResolveResultClassName + " "
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
						+ ") token).getStopIndex());");
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

	private void addRetrieveLayoutInformationMethod(StringComposite sc) {
		sc.add("protected void retrieveLayoutInformation(" + E_OBJECT + " element, " + syntaxElementClassName + " syntaxElement, " + OBJECT + " object) {");
		sc.add("if (!(syntaxElement instanceof " + placeholderClassName + ") && !(syntaxElement instanceof " + keywordClassName + ")) {");
		sc.add("return;");
		sc.add("}");
		sc.add("int currentPos = getTokenStream().index();");
		sc.add("if (currentPos == 0) {");
		sc.add("return;");
		sc.add("}");
		sc.add("int endPos = currentPos - 1;");
		sc.add("for (; endPos >= this.lastPosition2; endPos--) {");
		sc.add(TOKEN + " token = getTokenStream().get(endPos);");
		sc.add("int _channel = token.getChannel();");
		sc.add("if (_channel != 99) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add(STRING_BUILDER + " hiddenTokenText = new " + STRING_BUILDER + "();");
		sc.add(STRING_BUILDER + " visibleTokenText = new " + STRING_BUILDER + "();");
		sc.add("for (int pos = this.lastPosition2; pos <= endPos; pos++) {");
		sc.add(TOKEN + " token = getTokenStream().get(pos);");
		sc.add("int _channel = token.getChannel();");
		sc.add("if (_channel == 99) {");
		sc.add("hiddenTokenText.append(token.getText());");
		sc.add("} else {");
		sc.add("visibleTokenText.append(token.getText());");
		sc.add("}");
		sc.add("}");
		sc.add(layoutInformationAdapterClassName + " layoutInformationAdapter = getLayoutInformationAdapter(element);");
		sc.add("layoutInformationAdapter.addLayoutInformation(new " + layoutInformationClassName + "(syntaxElement, object, hiddenTokenText.toString(), visibleTokenText.toString()));");
		sc.add("this.lastPosition2 = (endPos < 0 ? 0 : endPos + 1);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addCreateInstanceMethod(String lexerName, String parserName,
			StringComposite sc) {
		sc.add("public " + iTextParserClassName + " createInstance("
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
		sc.add(pluginActivatorClassName + ".logError(\"Error while creating parser.\", e);");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addCreateDynamicProxyMethod(ANTLRGrammarComposite sc) {
		sc.addJavadoc("Creates a dynamic Java proxy that mimics the interface of the given class.");
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public <T> T createDynamicProxy(" + CLASS + "<T> clazz) {");
		sc.add(OBJECT + " proxy = " + PROXY + ".newProxyInstance(this.getClass().getClassLoader(), new " + CLASS + "<?>[]{clazz, " + E_OBJECT + ".class, " + INTERNAL_E_OBJECT + ".class}, new " + INVOCATION_HANDLER + "() {");
		sc.addLineBreak();
		sc.add("private " + E_OBJECT + " dummyObject = new " + E_OBJECT_IMPL + "() {};");
		sc.addLineBreak();
		sc.add("public " + OBJECT + " invoke(" + OBJECT + " object, " + METHOD + " method, " + OBJECT + "[] args) throws " + THROWABLE + " {");
		sc.addComment("search in dummyObject for the requested method");
		sc.add(METHOD + "[] methodsInDummy = dummyObject.getClass().getMethods();");
		sc.add("for (" + METHOD + " methodInDummy : methodsInDummy) {");
		sc.add("boolean matches = true;");
		sc.add("if (methodInDummy.getName().equals(method.getName())) {");
		sc.add(CLASS + "<?>[] parameterTypes = method.getParameterTypes();");
		sc.add(CLASS + "<?>[] parameterTypesInDummy = methodInDummy.getParameterTypes();");
		sc.add("if (parameterTypes.length == parameterTypesInDummy.length) {");
		sc.add("for (int p = 0; p < parameterTypes.length; p++) {");
		sc.add(CLASS + "<?> parameterType = parameterTypes[p];");
		sc.add(CLASS + "<?> parameterTypeInDummy = parameterTypesInDummy[p];");
		sc.add("if (!parameterType.equals(parameterTypeInDummy)) {");
		sc.add("matches = false;");
		sc.add("}");
		sc.add("}");
		sc.add("} else {");
		sc.add("matches = false;");
		sc.add("}");
		sc.add("} else {");
		sc.add("matches = false;");
		sc.add("}");
		sc.add("if (matches) {");
		sc.add("return methodInDummy.invoke(dummyObject, args);");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.add("");
		sc.add("});");
		sc.add("return (T) proxy;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(ANTLRGrammarComposite sc) {
		sc.add("private " + iTokenResolverFactoryClassName
				+ " tokenResolverFactory = new "
				+ tokenResolverFactoryClassName + "();");
		sc.addLineBreak();
		
		sc.addJavadoc("the index of the last token that was handled by collectHiddenTokens()");
		sc.add("@SuppressWarnings(\"unused\")");
		sc.add("private int lastPosition;");
		sc.addLineBreak();
		
		sc.addJavadoc("the index of the last token that was handled by retrieveLayoutInformation()");
		sc.add("private int lastPosition2;");
		sc.addLineBreak();
		
		sc.add("private " + tokenResolveResultClassName
				+ " tokenResolveResult = new "
				+ tokenResolveResultClassName + "();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A flag that indicateds whether the parser should remember all expected elements. " +
			"This flag is set to true when using the parse for code completion. Otherwise it is " +
			"set to false."
		);
		sc.add("private boolean rememberExpectedElements = false;");
		sc.addLineBreak();
		
		sc.add("private " + OBJECT + " parseToIndexTypeObject;");
		sc.add("private int lastTokenIndex = 0;");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A list of expected elements the were collected while parsing the input stream. " +
			"This list is only filled if <code>rememberExpectedElements</code> is set to true."
		);
		sc.add("private " + LIST + "<" + expectedTerminalClassName
				+ "> expectedElements = new " + ARRAY_LIST + "<"
				+ expectedTerminalClassName + ">();");
		sc.addLineBreak();

		sc.add("private int mismatchedTokenRecoveryTries = 0;");
		sc.add("private " + MAP + "<?, ?> options;");
		
		sc.addJavadoc("A helper list to allow a lexer to pass errors to its parser");
		sc.add("protected " + LIST + "<" + RECOGNITION_EXCEPTION
				+ "> lexerExceptions = " + COLLECTIONS
				+ ".synchronizedList(new " + ARRAY_LIST + "<"
				+ RECOGNITION_EXCEPTION + ">());");
		sc.addLineBreak();
		
		sc.addJavadoc("Another helper list to allow a lexer to pass positions of errors to its parser");
		sc.add("protected " + LIST + "<" + INTEGER
				+ "> lexerExceptionsPosition = " + COLLECTIONS
				+ ".synchronizedList(new " + ARRAY_LIST + "<" + INTEGER
				+ ">());");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A stack for incomplete objects. This stack is used only when the parser is used " +
			"for code completion. Whenever the parser starts to read an object it is pushed on " +
			"the stack. Once the element was parser completely it is popped for the stack."
		);
		sc.add("protected " + STACK + "<" + E_OBJECT
				+ "> incompleteObjects = new " + STACK + "<" + E_OBJECT
				+ ">();");
		sc.addLineBreak();

		sc.add("private int stopIncludingHiddenTokens;");
		sc.add("private int stopExcludingHiddenTokens;");
		
		sc.addJavadoc(
			"A collection that is filled with commands to be exectued after parsing. " +
			"This collection is cleared before parsing starts and returned as part of " +
			"the parse result object."
		);
		sc.add("private " + COLLECTION + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> postParseCommands;");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A flag to indicate that the parser should stop parsing as soon as possible. " +
			"The flag is set to false before parsing starts. It can be set to true by invoking " +
			"the terminateParsing() method from another thread. This feature is used, when documents " +
			"are parsed in the background (i.e., while editing them). In order to cancel running " +
			"parsers, the parsing process can be terminated. This is done whenever a document " +
			"changes, because the previous content of the document is not valid anymore and parsing " +
			"the old content is not necessary any longer."
		);
		sc.add("private boolean terminateParsing;");
		sc.addLineBreak();
		
		sc.add("private int tokenIndexOfLastCompleteElement;");
		sc.addLineBreak();
		
		sc.add("private int expectedElementsIndexOfLastCompleteElement;");
		sc.addLineBreak();
	}

	private void addParseToExpectedElementsMethod(ANTLRGrammarComposite sc) {
		sc.add("public " + LIST + "<" + expectedTerminalClassName
				+ "> parseToExpectedElements(" + E_CLASS + " type, " + iTextResourceClassName + " dummyResource) {");
		sc.add("rememberExpectedElements = true;");
		sc.add("parseToIndexTypeObject = type;");
		sc.add("final " + COMMON_TOKEN_STREAM + " tokenStream = (" + COMMON_TOKEN_STREAM + ") getTokenStream();");
		sc.add(iParseResultClassName + " result = parse();");
		sc.add("for (" + E_OBJECT + " incompleteObject : incompleteObjects) {");
		sc.add(LEXER + " lexer = (" + LEXER + ") tokenStream.getTokenSource();");
		sc.add("int endChar = lexer.getCharIndex();");
		sc.add("int endLine = lexer.getLine();");
		sc.add("setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);");
		sc.add("}");
		sc.add("if (result != null) {");
		sc.add(E_OBJECT + " root = result.getRoot();");
		sc.add("if (root != null) {");
		sc.add("dummyResource.getContents().add(root);");
		sc.add("}");
		sc.add("for (" + iCommandClassName + "<" + iTextResourceClassName + "> command : result.getPostParseCommands()) {");
		sc.add("command.execute(dummyResource);");
		sc.add("}");
		sc.add("}");
		sc.addComment("remove all expected elements that were added after the last complete element");
		sc.add("expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);");
		sc.add("int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();");
		sc.add(SET + "<" + expectedTerminalClassName + "> currentFollowSet = new " + LINKED_HASH_SET +"<" + expectedTerminalClassName + ">();");
		sc.add(LIST + "<" + expectedTerminalClassName + "> newFollowSet = new " + ARRAY_LIST +"<" + expectedTerminalClassName + ">();");
		sc.add("for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {");
		sc.add(expectedTerminalClassName + " expectedElementI = expectedElements.get(i);");
		sc.add("if (expectedElementI.getFollowSetID() == lastFollowSetID) {");
		//sc.add("System.out.println(\"FOLLOW ELEMENT \" + expectedElementI);");
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
		//sc.add("System.out.println(\"REMAINING TOKEN: \" + nextToken);");
		sc.add("if (nextToken.getChannel() == 99) {");
		sc.addComment("hidden tokens do not reduce the follow set");
		sc.add("} else {");
		sc.addComment(
			"now that we have found the next visible token the position for that expected terminals " +
			"can be set"
		);
		sc.add("for (" + expectedTerminalClassName + " nextFollow : newFollowSet) {");
		// TODO this is somewhat inefficient since the token stream is searched from
		// the beginning
		sc.add("lastTokenIndex = 0;");
		sc.add("setPosition(nextFollow, i);");
		sc.add("}");
		sc.add("newFollowSet.clear();");
		sc.addComment("normal tokens do reduce the follow set - only elements that match the token are kept");
		sc.add("for (" + expectedTerminalClassName + " nextFollow : currentFollowSet) {");
		//sc.add("System.out.println(\"CHECKING : \" + nextFollow);");
		sc.add("if (nextFollow.getTerminal().getTokenName().equals(getTokenNames()[nextToken.getType()])) {");
		sc.addComment("keep this one - it matches");
		//sc.add("System.out.println(\"MATCH! \" + nextFollow);");
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
		sc.addComment(
			"after the last token in the stream we must set the position for the elements that were " +
			"added during the last iteration of the loop"
		);
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

	private void addCopyLocalizationInfosMethod1(ANTLRGrammarComposite sc) {
		sc.add("protected void copyLocalizationInfos(final " + E_OBJECT + " source, final "
				+ E_OBJECT + " target) {");
		sc.add("postParseCommands.add(new " + iCommandClassName + "<" + iTextResourceClassName + ">() {");
		sc.add("public boolean execute(" + iTextResourceClassName + " resource) {");
		sc.add(iLocationMapClassName + " locationMap = resource.getLocationMap();");
		sc.add("if (locationMap == null) {");
		sc.addComment("the locationMap can be null if the parser is used for code completion");
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

	private void addSetLocalizationEndMethod(ANTLRGrammarComposite sc) {
		sc.addJavadoc("Sets the end character index and the last line for the given object in the location map.");
		sc.add("protected void setLocalizationEnd(" + COLLECTION + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> postParseCommands , final " + E_OBJECT + " object, final int endChar, final int endLine) {");
		sc.add("postParseCommands.add(new " + iCommandClassName + "<" + iTextResourceClassName + ">() {");
		sc.add("public boolean execute(" + iTextResourceClassName + " resource) {");
		sc.add(iLocationMapClassName + " locationMap = resource.getLocationMap();");
		sc.add("if (locationMap == null) {");
		sc.addComment("the locationMap can be null if the parser is used for code completion");
		sc.add("return true;");
		sc.add("}");
		sc.add("locationMap.setCharEnd(object, endChar);");
		sc.add("locationMap.setLine(object, endLine);");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCopyLocalizationInfosMethod2(ANTLRGrammarComposite sc) {
		sc.add("protected void copyLocalizationInfos(final " + COMMON_TOKEN
				+ " source, final " + E_OBJECT + " target) {");
		sc.add("postParseCommands.add(new " + iCommandClassName + "<" + iTextResourceClassName + ">() {");
		sc.add("public boolean execute(" + iTextResourceClassName + " resource) {");
		sc.add(iLocationMapClassName + " locationMap = resource.getLocationMap();");
		sc.add("if (locationMap == null) {");
		sc.addComment("the locationMap can be null if the parser is used for code completion");
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
		// potential memory consumption improvement:
		//
		// we can throw away expected elements that are not important
		// for the current parse run. the concrete set of elements that
		// can be thrown away is determined by the cursor index where
		// code completion is requested.
		//
		// however, unless there is no serious performance problems I'd
		// stick with keeping all the expected elements. they will be 
		// garbage collected right afterwards anyway
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

	private void printStartRule(ANTLRGrammarComposite sc) {
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
		sc.addComment("follow set for start rule(s)");
		addExpectationsCode(sc, expectations);
		sc.add("expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;");
		sc.add("}");
		sc.add("(");
		int count = 0;
		for (GenClass startSymbol : concreteSyntax.getActiveStartSymbols()) {
			// there may also be rules for subclasses of the start symbol class
			// thus, we create an alternative for each rule
			
			List<String> ruleNames = new LinkedList<String>();		
			//first check if this startsymbol is a common expression metaclass, if so
			//only add a reference to it but not to its supclasses
			//TODO skarol: we should also check for genclass prefixes or use full qualified names
			if(!syntax.getOperatorRuleSubset(startSymbol.getName()).isEmpty()){
				ruleNames.add(getRuleName(startSymbol));
			}
			else{
				Collection<Rule> startRules = csUtil.getRules(concreteSyntax, startSymbol);
				for(Rule startRule:startRules){
					ruleNames.add(getRuleName(startRule.getMetaclass()));
				}
			}
			for (String ruleName : ruleNames) {
				if (count > 0) {
					sc.add("|  ");
				}
				sc.add("c" + count + " = " + ruleName  + "{ element = c" + count + "; }");
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

	private void printRightRecursion(ANTLRGrammarComposite sc, Rule rule,
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
					+ genClassCache.getQualifiedInterfaceName(recursiveType)
					+ " element = null]");
			sc.add("@init{");
			sc.add("element = "
					+ genClassUtil.getCreateObjectCall(recursiveType,
							dummyEObjectClassName) + ";");
			sc.add("collectHiddenTokens(element);");
			sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + csUtil.getFieldName(rule) + ", null);");
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
			compound.getChildren().clear();
			compound.getChildren().add(reducedChoice);
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

			ruleCopy.getChildren().clear();
			ruleCopy.getChildren().add(choice);

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
												genClassCache
														.getQualifiedInterfaceName(featureType))
										.contains(
												genClassCache
														.getQualifiedInterfaceName(recursiveType))
								|| genClassNames2superClassNames
										.get(
												genClassCache
														.getQualifiedInterfaceName(recursiveType))
										.contains(
												genClassCache
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
			sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + csUtil.getFieldName(rule) + ", null);");
			sc.add("}");
			sc.add(":");

			printChoice(tailCopy.getDefinition(), tailCopy, sc, 0,
					classesReferenced, "0");

			sc.add(";");
			sc.addLineBreak();
		}
		eClassesWithSyntax.add(rule.getMetaclass());

	}

	private void printGrammarRules(ANTLRGrammarComposite sc,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass, Collection<Terminal>> eClassesReferenced) {

		for (Rule rule : concreteSyntax.getAllRules()) {
			// operator rules must be handled separately
			if (concreteSyntax.getOperatorRules().contains(rule)) {
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
										concreteSyntax,true);
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
		if (!concreteSyntax.getOperatorRules().isEmpty()) {
			for (String expressionIdent : concreteSyntax.getOperatorRuleSubsets()) {
				EList<Rule> expressionSubset = concreteSyntax.getOperatorRuleSubset(expressionIdent);
				printGrammarExpressionSlice(sc, expressionSubset, eClassesWithSyntax, eClassesReferenced);
			}
		}
	}

	
	private void printGrammarRulePrefix(GenClass genClass, String ruleName, StringComposite sc) {
		String qualifiedClassName = genClassCache
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
	
	private void printGrammarRule(Rule rule, ANTLRGrammarComposite sc,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass, Collection<Terminal>> eClassesReferenced) {
		GenClass genClass = rule.getMetaclass();
		String ruleName = getRuleName(genClass);

		printGrammarRulePrefix(genClass,ruleName,sc);
		
		printChoice(rule.getDefinition(), rule, sc, 0, eClassesReferenced, "0");

		Collection<GenClass> subClasses = csUtil
				.getSubClassesWithSyntax(genClass, concreteSyntax, true);
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
	private void printGrammarExpressionSlice(
			ANTLRGrammarComposite sc,
			List<Rule> slice, 
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass, 
			Collection<Terminal>> eClassesReferenced) {
		
		ListIterator<Rule> sliceIterator = slice.listIterator();
		
		while (sliceIterator.hasNext()) {
			// TODO skarol: add a check that all equal weight rules are equally structured
			Rule firstRule = sliceIterator.next();
			int weight = firstRule.getOperatorWeight();
			List<Rule> rulesWithEqualWeight = new LinkedList<Rule>();
			rulesWithEqualWeight.add(firstRule);
			// find next next with the same weight
			while (sliceIterator.hasNext()) {
				Rule currentRule = sliceIterator.next();
				int currentWeight = currentRule.getOperatorWeight();
				if (currentWeight == weight) {
					rulesWithEqualWeight.add(currentRule);
				} else {
					sliceIterator.previous();
					break;
				}
			}
			
			boolean isLast = !sliceIterator.hasNext();
			
			Sequence firstSequence = firstRule.getDefinition().getOptions().get(0);
			OperatorAnnotationType operatorType = ConcreteSyntaxUtil.getOperatorAnnotationType(firstRule.getOperatorAnnotation());
			
			String ruleName = getExpressionSliceRuleName(firstRule);

			GenClass returnGenClass = firstRule.getMetaclass();
			for (GenClass metaClass : allGenClasses) {
				if (metaClass.getName().equals(firstRule.getOperatorAnnotation().getValue(OperatorAnnotationProperty.IDENTIFIER.toString()))) {
					returnGenClass = metaClass;
				}
			}
		
			printGrammarRulePrefix(returnGenClass, ruleName, sc);
			
			if (!isLast) { 
				//we assume all arguments to be typed by the same class
				final String nextRuleName = getExpressionSliceRuleName(sliceIterator.next());
				sliceIterator.previous();
				//we do unary operators first
				if (operatorType == OperatorAnnotationType.UNARY_PREFIX) {
			    //1st case: unary operator starts with keyword (prefix)
					printUnaryPrefixOperatorRule(sc, eClassesReferenced,
								firstRule, rulesWithEqualWeight, nextRuleName);	
				}
				//2nd case: unary operator starts with argument (postfix, this means left recursion)
				else if (operatorType == OperatorAnnotationType.UNARY_POSTFIX) {
						printUnaryPostfixOperatorRule(sc, eClassesReferenced,
								rulesWithEqualWeight, firstSequence, nextRuleName);		
				}
				// now we do binary infix operators
				else if (operatorType == OperatorAnnotationType.BINARY_LEFT_ASSOCIATIVE) {
					//1st case left associative operators, e.g., -,+,*,/ etc.
					printBinaryLeftAssociativeRule(sc, eClassesReferenced,
							rulesWithEqualWeight, nextRuleName);
				} else if (operatorType == OperatorAnnotationType.BINARY_RIGHT_ASSOCIATIVE) {
					//2nd case right associative operators , e.g., ^
					printBinaryRightAssociativeRule(sc, eClassesReferenced,
							rulesWithEqualWeight, ruleName, nextRuleName);
				}
			}
			
			boolean wasPrimitiveOperatorRule = false;

			if (operatorType == OperatorAnnotationType.PRIMITIVE) {
				printPrimitiveOperatorRule(sc, eClassesWithSyntax,
						eClassesReferenced, rulesWithEqualWeight);
				wasPrimitiveOperatorRule = true;
			}
			
			// primitive operator rules add the suffix on their own,
			// because they need to add more rules
			if (!isLast && !wasPrimitiveOperatorRule) {
				printGrammarRuleSuffix(sc);
			}
		}
	}

	private void printPrimitiveOperatorRule(ANTLRGrammarComposite sc,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass, Collection<Terminal>> eClassesReferenced,
			List<Rule> rulesWithEqualWeight) {
		List<GenClass> choiceClasses = new LinkedList<GenClass>();
		for (Rule rule : rulesWithEqualWeight) {
			choiceClasses.add(rule.getMetaclass());
		}
		printSubClassChoices(sc, choiceClasses);
		printGrammarRuleSuffix(sc);
		
		for (Rule rule : rulesWithEqualWeight) {
			printGrammarRule(rule, sc, eClassesWithSyntax, eClassesReferenced);	
		}
	}
	
	private void printUnaryPrefixOperatorRule(ANTLRGrammarComposite sc,
			Map<GenClass, Collection<Terminal>> eClassesReferenced,
			Rule firstRule, List<Rule> equalWeightOPs, final String nextRuleName) {
		for (Rule rule : equalWeightOPs) {
			List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
			assert definitions.size() > 2;
			
			Definition right = definitions.remove(definitions.size()-1);
			
			assert right instanceof Containment;
			
			printDefinitions(definitions, rule, sc, 0, eClassesReferenced, "0");
			
			sc.add("arg = " + nextRuleName);
			Containment containment = (Containment) right;
			printTerminalAction(containment, firstRule, sc, "arg", "", "arg", null, "null", true);
			sc.add("|");
			sc.addLineBreak();
		}
		sc.addLineBreak();
		sc.add("arg = " + nextRuleName + "{ element = arg; }");
	}

	private void printUnaryPostfixOperatorRule(ANTLRGrammarComposite sc,
			Map<GenClass, Collection<Terminal>> eClassesReferenced,
			List<Rule> equalWeightOPs, Sequence firstSequence,
			final String nextRuleName) {
		sc.add("arg = "+ nextRuleName);
		sc.add("(");
		for (Rule rule : equalWeightOPs) {
			List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
			assert definitions.size() > 2;
			
			Definition left = definitions.remove(0);
			assert left instanceof Containment;
						
			printDefinitions(definitions, rule, sc, 0, eClassesReferenced, "0");
			
			Containment containment = (Containment) left;
			printTerminalAction(containment, rule, sc, "arg", "", "arg", null, "null", true);
			sc.add("|");
			sc.addLineBreak();
		}
		
		sc.add("/* epsilon */ { element = arg; } ");
		sc.addLineBreak();
		sc.add(")");
	}

	private void printBinaryLeftAssociativeRule(ANTLRGrammarComposite sc,
			Map<GenClass, Collection<Terminal>> eClassesReferenced,
			List<Rule> equalWeightOPs, final String nextRuleName) {
		sc.add("leftArg = " + nextRuleName);
		sc.add("((");
		Iterator<Rule> ruleIterator = equalWeightOPs.iterator();
		while (ruleIterator.hasNext()) {
			Rule rule = ruleIterator.next();
			List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
			assert definitions.size() >= 2;
			
			Definition left = definitions.get(0);
			definitions.remove(0);
			Definition right = definitions.get(definitions.size()-1);
			definitions.remove(definitions.size()-1);
		
			assert left instanceof Containment;
			assert right instanceof Containment;
			
			Containment leftContainment = (Containment) left;
			Containment rightContainment = (Containment) right;
			sc.add("{ element = null; }");
			
			printDefinitions(definitions, rule, sc, 0, eClassesReferenced, "0");
			
			sc.add("rightArg = " + nextRuleName);
			printTerminalAction(leftContainment, rule, sc, "leftArg", "", "leftArg", null, "null", true);
			printTerminalAction(rightContainment, rule, sc, "rightArg", "", "rightArg", null, "null", true);
			sc.add("{ leftArg = element; /* this may become an argument in the next iteration */ }");
			if (ruleIterator.hasNext()) {
				sc.add("|");
				sc.addLineBreak();
			}
		}

		sc.add(")+ | /* epsilon */ { element = leftArg; }");
		sc.addLineBreak();
		sc.add(")");
	}

	private void printBinaryRightAssociativeRule(ANTLRGrammarComposite sc,
			Map<GenClass, Collection<Terminal>> eClassesReferenced,
			List<Rule> equalWeightOPs, String ruleName,
			final String nextRuleName) {
		sc.add("leftArg = " + nextRuleName);
		sc.add("((");
		Iterator<Rule> ruleIterator = equalWeightOPs.iterator();
		while (ruleIterator.hasNext()) {
			Rule rule = ruleIterator.next();
			List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
			assert definitions.size() >= 2;
			
			Definition left = definitions.get(0);
			definitions.remove(0);
			Definition right = definitions.get(definitions.size()-1);
			definitions.remove(definitions.size()-1);
			
			assert left instanceof Containment;
			assert right instanceof Containment;
			
			Containment leftContainment = (Containment) left;
			Containment rightContainment = (Containment) right;
			
			printDefinitions(definitions, rule, sc, 0, eClassesReferenced, "0");		
			
			//if (operator instanceof CsString) {
			//	CsString csString = (CsString) operator;
			//	printCsString(csString, rule, sc, 0, eClassesReferenced);									
			//} else {
			//	assert operator instanceof Placeholder;
			//	Placeholder placeholder = (Placeholder) operator;
			//	printTerminal(placeholder, rule, sc, 0, eClassesReferenced);									
			//}
			
			sc.add("rightArg = " + ruleName);
			printTerminalAction(leftContainment, rule, sc, "leftArg", "", "leftArg", null, "null", true);
			printTerminalAction(rightContainment, rule, sc, "rightArg", "", "rightArg", null, "null", true);
			if (ruleIterator.hasNext()) {
				sc.add("|");
				sc.addLineBreak();	
			}
		}
		sc.add(") | /* epsilon */ { element = leftArg; }");
		sc.addLineBreak();
		sc.add(")");
	}
	
	private String getExpressionSliceRuleName(Rule rule){
		Annotation operatorAnnotation = rule.getOperatorAnnotation();
		String ruleName = operatorAnnotation.getValue(OperatorAnnotationProperty.IDENTIFIER.toString()) + "_level_";
		String weight = operatorAnnotation.getValue(OperatorAnnotationProperty.WEIGHT.toString()).replace('-','_');
		ruleName += weight;
		return "parseop_" + ruleName;
	}

	private String getRuleName(GenClass genClass) {
		String ruleName = genClassCache.getEscapedTypeName(genClass);
		return "parse_" + ruleName;
	}

	private int printChoice(Choice choice, Rule rule, ANTLRGrammarComposite sc,
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

	private int printSequence(Sequence sequence, Rule rule, ANTLRGrammarComposite sc,
			int count, Map<GenClass, Collection<Terminal>> eClassesReferenced, String scopeID) {
		return printDefinitions(sequence.getParts(),rule,sc,count,eClassesReferenced,scopeID);
	}
	
	private int printDefinitions(List<Definition> definitions, Rule rule, ANTLRGrammarComposite sc,
			int count, Map<GenClass, Collection<Terminal>> eClassesReferenced, String scopeID){
		int i = 0;
		for (Definition definition : definitions) {
			if (definition instanceof LineBreak || definition instanceof WhiteSpaces) {
				continue;
			}
			ConcreteSyntax syntax = getContext().getConcreteSyntax();
			Set<Expectation> expectations = computer.computeFollowSet(syntax, definition);
			context.addToFollowSetMap(definition, expectations);
			String cardinality = csUtil.computeCardinalityString(definition);
			if (!"".equals(cardinality)) {
				sc.add("(");
			}
			if (definition instanceof CompoundDefinition) {
				String subScopeID = scopeID + "." + i;

				CompoundDefinition compoundDef = (CompoundDefinition) definition;
				sc.add("(");
				count = printChoice(compoundDef.getDefinition(), rule, sc,
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
			sc.addComment("expected elements (follow set)");
			addExpectationsCode(sc, expectations);
			sc.add("}");

			sc.addLineBreak();
		}
		return count;
	}

	private void addExpectationsCode(StringComposite sc, Set<Expectation> expectations) {
		for (Expectation expectation : expectations) {
			EObject expectedElement = expectation.getExpectedElement();
			String terminalID = followSetProviderClassName + "." + context.getID(expectedElement);
			// here the containment trace is used
			// TODO mseifert: figure out whether this is really needed
			StringBuilder traceArguments = new StringBuilder();
			List<GenFeature> containmentTrace = expectation.getContainmentTrace();
			for (GenFeature genFeature : containmentTrace) {
				traceArguments.append(", ");
				traceArguments.append(followSetProviderClassName + "." + context.getFeatureConstantFieldName(genFeature));
			}
			sc.add("addExpectedElement(new "
					+ expectedTerminalClassName + 
					"(" + terminalID + ", " + followSetID + traceArguments + "));");
		}
		followSetID++;
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
		sc.add("incompleteObjects.push(element);");
		sc.add("}");
		sc.add("collectHiddenTokens(element);");
		sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + csUtil.getFieldName(csString) + ", null);");
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
						resolvements, null, true);

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
				resolvements.add(iTokenResolverClassName + " "
						+ resolverIdent
						+ " = tokenResolverFactory.createTokenResolver(\""
						+ tokenName + "\");");
				resolvements.add(resolverIdent + ".setOptions(getOptions());");
				resolvements.add(iTokenResolveResultClassName
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
	
					String typeInterfaceName = genClassCache
							.getQualifiedInterfaceName(instanceType);
					if (genClassUtil.isNotConcrete(instanceType)) {
						// TODO mseifert: replace this code with a call to class
						// GenClassFinder
						// a slightly more elegant version of this code can also be
						// found in the ScannerlessParserGenerator
						for (GenClass instanceCand : allGenClasses) {
							Collection<String> supertypes = genClassNames2superClassNames
									.get(genClassCache
											.getQualifiedInterfaceName(instanceCand));
							if (genClassUtil.isConcrete(instanceCand)
									&& supertypes
											.contains(typeInterfaceName)) {
								proxyType = instanceCand;
								break;
							}
						}
					} else {
						proxyType = instanceType;
					}
					resolvements.add(targetTypeName + " " + resolvedIdent + " = ("
							+ targetTypeName + ") " + preResolved + ";");
					
					String declaration = typeInterfaceName
							+ " "
							+ expressionToBeSet
							+ " = ";

					if (proxyType != null) {
						resolvements.add(declaration + genClassUtil.getCreateObjectCall(proxyType,
										dummyEObjectClassName) + ";");
					} else {
						// the type of the reference is abstract and no
						// suitable (i.e., no concrete) sub class was found.
						// therefore a dynamic object must be created and is
						// used as proxy
						resolvements.add(declaration + "createDynamicProxy(" + typeInterfaceName + ".class);");
					}
					
					resolvements.add("collectHiddenTokens(element);");
					resolvements
							.add("registerContextDependentProxy(new "
									+ contextDependentUriFragmentFactoryClassName
									+ "<"
									+ genClassCache
											.getQualifiedInterfaceName(genFeature
													.getGenClass())
									+ ", "
									+ genClassCache
											.getQualifiedInterfaceName(genFeature
													.getTypeGenClass())
									+ ">("
									+ getContext()
											.getReferenceResolverAccessor(genFeature)
									+ "), element, (" + E_REFERENCE + ") element.eClass().getEStructuralFeature("
									+ generatorUtil.getFeatureConstant(genClass,
											genFeature) + "), " + resolvedIdent
									+ ", " + proxyIdent + ");");
				} else {
					// the feature is an EAttribute
					targetTypeName = genFeature.getQualifiedListItemType(null);
					resolvements.add(targetTypeName + " " + resolvedIdent + " = ("
							+ getObjectTypeName(targetTypeName) + ")" + preResolved
							+ ";");
					expressionToBeSet = "resolved";
				}

				printTerminalAction(placeholder, rule, sc, ident, proxyIdent, expressionToBeSet,
						resolvements, tokenName, false);
			}
		}

		sc.add(")");
		return ++count;
	}

	private void printTerminalAction(Terminal terminal, Rule rule,
			StringComposite sc,
			String ident, 
			String proxyIdent,
			String expressionToBeSet, 
			StringComposite resolvements,
			String tokenName,
			boolean isContainment) {
		
		final GenFeature genFeature = terminal.getFeature();
		final GenClass genClass = rule.getMetaclass();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
	
		sc.add("{");
		sc.add("if (terminateParsing) {");
		sc.add("throw new " + terminateParsingExceptionClassName + "();");
		sc.add("}");
		sc.add("if (element == null) {");
		sc.add("element = "
				+ genClassUtil.getCreateObjectCall(rule.getMetaclass(),
						dummyEObjectClassName) + ";");
		sc.add("}");
		sc.add(new StringComponent(STRING + " tokenName = \"" + StringUtil.escapeToJavaString(tokenName) + "\";", "tokenName"));
		sc.add("if (" + ident + " != null) {");
		if (resolvements != null) {
			sc.add(resolvements);
		}
		sc.add("if (" + expressionToBeSet + " != null) {");
		final String featureConstant = generatorUtil.getFeatureConstant(genClass, genFeature);
		generatorUtil.addCodeToSetFeature(sc, genClass, featureConstant, eFeature, expressionToBeSet, isContainment);
		sc.add("}");
		sc.add("collectHiddenTokens(element);");
		sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + csUtil.getFieldName(terminal) + ", " + expressionToBeSet + ");");
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
			if (!genClassCache.containsEqualByName(eClassesWithSyntax, referencedClass)) {
				// rule not explicitly defined in CS: most likely a choice rule
				// in the AS
				//Expression slices are formed over a common abstract superclass
				//TODO handle genClass prefixes too
				boolean isCommonExpressionMetaClass = !concreteSyntax.getOperatorRuleSubset(referencedClass.getName()).isEmpty(); 
				if(printImplicitChoiceRule(sc,referencedClass, isCommonExpressionMetaClass))
					eClassesWithSyntax.add(referencedClass);
			}
		}
		
		//We check if there are start symbols referencing an expression meta class which has not 
		//a grammar rule yet
		for (GenClass referencedClass : concreteSyntax.getStartSymbols()){
			boolean isCommonExpressionMetaClass = !concreteSyntax.getOperatorRuleSubset(referencedClass.getName()).isEmpty(); 
			//TODO handle genClass prefixes too
			if(isCommonExpressionMetaClass&&!genClassCache.containsEqualByName(eClassesWithSyntax, referencedClass)){
				if(printImplicitChoiceRule(sc,referencedClass, isCommonExpressionMetaClass))
					eClassesWithSyntax.add(referencedClass);
			}
		}
	}
	
	private boolean printImplicitChoiceRule(StringComposite sc,
			GenClass referencedClass, boolean isCommonExpressionMetaClass) {
		Collection<GenClass> subClasses = csUtil
				.getSubClassesWithSyntax(referencedClass,
						concreteSyntax,true);

		if (!subClasses.isEmpty()||isCommonExpressionMetaClass) {
			sc.add(getRuleName(referencedClass));
			sc.add(" returns ["
					+ genClassCache
							.getQualifiedInterfaceName(referencedClass)
					+ " element = null]");
			sc.add(":");
			if (!isCommonExpressionMetaClass) {
				printSubClassChoices(sc, subClasses);
			} else {
				List<Rule> slice = concreteSyntax.getOperatorRuleSubset(referencedClass.getName());
				sc.add("c = " + getExpressionSliceRuleName(slice.get(0))+"{ element = c; /* this rule is an expression root */ }");
			}
				
			sc.addLineBreak();
			sc.add(";");
			sc.addLineBreak();

			return true;
		}
		return false;
	}

	private void printSubClassChoices(StringComposite sc,
			Collection<GenClass> subClasses) {
		int count = 0;
		for (Iterator<GenClass> subClassIterator = subClasses.iterator(); subClassIterator.hasNext();) {
			GenClass subRef = subClassIterator.next();
			String identifier = "c" + count;
			sc.add(identifier + " = " + getRuleName(subRef) + "{ element = " + identifier + "; /* this is a subclass or primitive expression choice */ }");
			if (subClassIterator.hasNext()) {
				sc.add("|");
			}
			count++;
		}
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

	private String getLexerName() {
		return getContext().getCapitalizedConcreteSyntaxName() + "Lexer";
	}

	private String getParserName() {
		return getContext().getCapitalizedConcreteSyntaxName() + "Parser";
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new ANTLRGrammarGenerator(context);
	}
}
