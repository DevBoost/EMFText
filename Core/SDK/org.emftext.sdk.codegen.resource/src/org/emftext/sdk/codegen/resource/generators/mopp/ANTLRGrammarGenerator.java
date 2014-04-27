/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.LINKED_HASH_SET;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static de.devboost.codecomposers.java.ClassNameConstants.SET;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.ANTLR_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.ANTLR_STRING_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.BIT_SET;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COMMON_TOKEN;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COMMON_TOKEN_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.INT_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.LEXER;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RECOGNITION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.TOKEN;

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
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
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
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.ConstantsPool;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.ResourceBaseGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.ContainmentLink;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.Expectation;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.ExpectationComputer;
import org.emftext.sdk.codegen.util.Counter;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.OperatorAnnotationProperty;
import org.emftext.sdk.concretesyntax.OperatorAnnotationType;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.EObjectUtil;
import org.emftext.sdk.util.GenClassUtil;

import de.devboost.codecomposers.StringComponent;
import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.antlr.ANTLRGrammarComposite;
import de.devboost.codecomposers.java.JavaComposite;
import de.devboost.codecomposers.util.StringUtil;

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
 * (reduction using the next token). This is performed until the cursor position 
 * (end of the document) is reached.
 * 
 * TODO mseifert: Wrap all fields which are used for code completion only in a 
 * dedicated class 'ExpectationCollector'.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
@SyntaxDependent
public class ANTLRGrammarGenerator extends ResourceBaseGenerator<ArtifactParameter<GenerationContext>> {
	
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
	private Map<String,Collection<String>> genClassNames2superClassNames;
	private Collection<GenClass> allGenClasses;
	private Set<String> keywords;

	private GenClassFinder genClassFinder = new GenClassFinder();
	private GenClassCache genClassCache;
	private GeneratorUtil generatorUtil = new GeneratorUtil();
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private NameUtil nameUtil = new NameUtil();

	private boolean forceEOFToken;

	/**
	 * A unique ID that is assigned to each follow set while generating
	 * the grammar. This ID is reset to zero when the grammar generation
	 * starts and incremented by one after each follow set.
	 */
	private int followSetID;

	private ExpectationComputer computer = new ExpectationComputer();

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

	@Override
	public void doGenerate(PrintWriter writer) {
		super.doGenerate(writer);
		concreteSyntax = getContext().getConcreteSyntax();
		genClassCache = concreteSyntax.getGenClassCache();

		followSetID = 0;
		initOptions();
		initCaches();
		String csName = getContext().getCapitalizedConcreteSyntaxName();
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
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.add("}");
		sc.addLineBreak();

		sc.add("@lexer::members {");
		sc.add("public " + LIST(sc) + "<" + RECOGNITION_EXCEPTION(sc) + "> lexerExceptions  = new " + ARRAY_LIST(sc) + "<" + RECOGNITION_EXCEPTION(sc) + ">();");
		sc.add("public " + LIST(sc) + "<Integer> lexerExceptionPositions = new " + ARRAY_LIST(sc) + "<Integer>();");
		sc.addLineBreak();
		sc.add("public void reportError(" + RECOGNITION_EXCEPTION(sc) + " e) {");
		sc.add("lexerExceptions.add(e);");
		sc.add("lexerExceptionPositions.add(((" + ANTLR_STRING_STREAM(sc) + ") input).index());");
		sc.add("}");
		sc.add("}");
		ANTLRGrammarComposite lexerComposite = sc;
		
		sc = new ANTLRGrammarComposite();
		// the parser: package definition and entry (doParse) method
		sc.add("@header{");
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.add("}");
		sc.addLineBreak();

		ANTLRGrammarComposite grammarCore = new ANTLRGrammarComposite();
		grammarCore.setImportsPlaceholder(sc.getImportsPlaceholder());
		addRules(grammarCore);
		addTokenDefinitions(grammarCore);

		sc.add("@members{");
		addFields(sc);
		addMethods(lexerName, parserName, sc);
		sc.add("}");
		sc.addLineBreak();
		
		sc.add(grammarCore.toString());

		writer.print(lexerComposite.toString());
		writer.print(sc.toString());
	}

	private void addRules(ANTLRGrammarComposite sc) {
		printStartRule(sc);

		EList<GenClass> eClassesWithSyntax = new BasicEList<GenClass>();
		Map<GenClass,Collection<Terminal>> eClassesReferenced = new LinkedHashMap<GenClass,Collection<Terminal>>();
		
		printGrammarRules(sc, eClassesWithSyntax, eClassesReferenced);		
		printImplicitChoiceRules(sc, eClassesWithSyntax, eClassesReferenced);
	}

	private void addMethods(String lexerName, String parserName,
			ANTLRGrammarComposite sc) {
		GenerationContext context = getContext();
		addReportErrorMethod(sc);
		generatorUtil.addAddErrorToResourceMethod(sc, context);
		addAddErrorToResourceMethod(sc);
		addAddExpectedElementMethod(sc);
		addCollectHiddenTokensMethod(lexerName, sc);
		addCopyLocalizationInfosMethod1(sc);
		addCopyLocalizationInfosMethod2(sc);
		addSetLocalizationEndMethod(sc);
		addCreateInstanceMethod(lexerName, parserName, sc);
		addDefaultConstructor(parserName, sc);
		addDoParseMethod(lexerName, sc);
		addGetMismatchedTokenRecoveryTriesMethod(sc);
		addGetMissingSymbolMethod(sc);
		addGetParseToIndexTypeObjectMethod(sc);
		addGetTypeObjectMethod(sc);
		addParseMethod(sc);
		addParseToExpectedElementsMethod(sc);
		addSetPositionMethod(sc);
		addRecoverFromMismatchedTokenMethod(sc);
		addStartIncompleteElementMethod(sc);
		addCompletedElementMethod(sc);
		addGetLastIncompleteElementMethod(sc);
	}

	private void addReportErrorMethod(ANTLRGrammarComposite sc) {
		sc.add("@Override");
		sc.add("public void reportError(" + RECOGNITION_EXCEPTION(sc) + " re) {");
		sc.add("addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddErrorToResourceMethod(ANTLRGrammarComposite sc) {
		sc.add("protected void addErrorToResource(" + localizedMessageClassName + " message) {");
		sc.add("if (message == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMissingSymbolMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public Object getMissingSymbol(" + INT_STREAM(sc)
				+ " arg0, " + RECOGNITION_EXCEPTION(sc) + " arg1, int arg2, "
				+ BIT_SET(sc) + " arg3) {");
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

	private void addParseMethod(ANTLRGrammarComposite sc) {
		sc.addJavadoc("Implementation that calls {@link #doParse()} and handles the thrown RecognitionExceptions.");
		sc.add("public " + iParseResultClassName + " parse() {");
		sc.addComment("Reset parser state");
		sc.add("terminateParsing = false;");
		sc.add("postParseCommands = new " + ARRAY_LIST(sc) + "<" + iCommandClassName + "<" + iTextResourceClassName + ">>();");
		sc.add(parseResultClassName + " parseResult = new " + parseResultClassName + "();");
		sc.add("if (disableLocationMap) {");
		sc.add("locationMap = new " + devNullLocationMapClassName + "();");
		sc.add("} else {");
		sc.add("locationMap = new " + locationMapClassName + "();");
		sc.add("}");
		sc.addComment("Run parser");
		sc.add("try {");
		sc.add(E_OBJECT(sc) + " result =  doParse();");
		sc.add("if (lexerExceptions.isEmpty()) {");
		sc.add("parseResult.setRoot(result);");
		sc.add("parseResult.setLocationMap(locationMap);");
		sc.add("}");
		sc.add("} catch (" + RECOGNITION_EXCEPTION(sc) + " re) {");
		sc.add("addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));");
		sc.add("} catch (" + ILLEGAL_ARGUMENT_EXCEPTION(sc) + " iae) {");
		sc.add("if (\"The 'no null' constraint is violated\".equals(iae.getMessage())) {");
		sc.addComment(
			"can be caused if a null is set on EMF models where not allowed. " +
			"this will just happen if other errors occurred before"
		);
		sc.add("} else {");
		sc.add("iae.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + RECOGNITION_EXCEPTION(sc) + " re : lexerExceptions) {");
		sc.add("addErrorToResource(syntaxErrorMessageConverter.translateLexicalError(re, lexerExceptions, lexerExceptionPositions));");
		sc.add("}");
		sc.add("parseResult.getPostParseCommands().addAll(postParseCommands);");
		sc.add("return parseResult;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCompletedElementMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		// TODO mseifert: instead of passing isContainment, we can call this method only
		// for contained objects
		sc.add("private void completedElement(Object object, boolean isContainment) {");
		sc.add("if (isContainment && !this.incompleteObjects.isEmpty()) {");
		//sc.add("System.out.println(" + stringUtilClassName + ".getRepeatingString(incompleteObjects.size(), ' ') + \"endofIncompleteElement(\" + object + \")\");");
		sc.add("boolean exists = this.incompleteObjects.remove(object);");
		sc.add("if (!exists) {");
		//sc.add("System.out.println(\"ERROR: Inconsistent set of objects (Can't find \" + object + \")\");");
		sc.add("}");
		sc.add("}");
		sc.add("if (object instanceof " + E_OBJECT(sc) + ") {");
		sc.add("this.tokenIndexOfLastCompleteElement = getTokenStream().index();");
		sc.add("this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStartIncompleteElementMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		// TODO mseifert: instead of passing isContainment, we can call this method only
		// for contained objects
		sc.add("private void startIncompleteElement(Object object) {");
		sc.add("if (object instanceof " + E_OBJECT(sc) + ") {");
		//sc.add("System.out.println(" + stringUtilClassName + ".getRepeatingString(incompleteObjects.size(), ' ') + \"startIncompleteElement(\" + object + \")\");");
		sc.add("this.incompleteObjects.add((" + E_OBJECT(sc) + ") object);");
		sc.add("}");
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

	private void addGetTypeObjectMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("protected Object getTypeObject() {");
		sc.add("Object typeObject = getParseToIndexTypeObject();");
		sc.add("if (typeObject != null) {");
		sc.add("return typeObject;");
		sc.add("}");
		sc.add(MAP(sc) + "<?,?> options = getOptions();");
		sc.add("if (options != null) {");
		sc.add("typeObject = options.get(" + iOptionsClassName + ".RESOURCE_CONTENT_TYPE);");
		sc.add("}");
		sc.add("return typeObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoParseMethod(String lexerName, ANTLRGrammarComposite sc) {
		sc.add("protected " + E_OBJECT(sc) + " doParse() throws " + RECOGNITION_EXCEPTION(sc) + " {");
		sc.add("this.lastPosition = 0;");
		sc.addComment("required because the lexer class can not be subclassed");
		sc.add("((" + lexerName + ") getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;");
		sc.add("((" + lexerName + ") getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;");
		sc.add("Object typeObject = getTypeObject();");
		sc.add("if (typeObject == null) {");
		sc.add("return start();");
		sc.add("} else if (typeObject instanceof " + E_CLASS(sc) + ") {");
		boolean isFirst = true;
		for (Rule rule : concreteSyntax.getAllRules()) {
			// operator rules cannot be used as start symbol
			// TODO mseifert: check whether this is checked by a post processor
			if (rule.getOperatorAnnotation() == null) {
				if (isFirst) {
					// this code is only needed if non-operator rules are found
					sc.add(E_CLASS(sc) + " type = (" + E_CLASS(sc) + ") typeObject;");
					isFirst = false;
				}
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
		sc.add("protected void collectHiddenTokens(" + E_OBJECT(sc) + " element) {");
		if (!collectTokenDefinitions.isEmpty()) {
			// sc.add("System.out.println(\"collectHiddenTokens(\" + element.getClass().getSimpleName() + \", \" + o + \") \");");
			sc.add("int currentPos = getTokenStream().index();");
			sc.add("if (currentPos == 0) {");
			sc.add("return;");
			sc.add("}");
			sc.add("int endPos = currentPos - 1;");
			sc.add("for (; endPos >= this.lastPosition; endPos--) {");
			sc.add(TOKEN(sc) + " token = getTokenStream().get(endPos);");
			sc.add("int _channel = token.getChannel();");
			sc.add("if (_channel != 99) {");
			sc.add("break;");
			sc.add("}");
			sc.add("}");
			sc.add("for (int pos = this.lastPosition; pos < endPos; pos++) {");
			sc.add(TOKEN(sc) + " token = getTokenStream().get(pos);");
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
				sc.add(E_STRUCTURAL_FEATURE(sc) + " feature = element.eClass().getEStructuralFeature(\"" + attributeName + "\");");
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
				sc.add("Object " + resolvedObjectIdentifier + " = "
						+ resolveResultIdentifier + ".getResolvedToken();");
				sc.add("if (" + resolvedObjectIdentifier + " == null) {");
				sc.add("addErrorToResource(" + resolveResultIdentifier
						+ ".getErrorMessage(), ((" + COMMON_TOKEN(sc)
						+ ") token).getLine(), ((" + COMMON_TOKEN(sc)
						+ ") token).getCharPositionInLine(), ((" + COMMON_TOKEN(sc)
						+ ") token).getStartIndex(), ((" + COMMON_TOKEN(sc)
						+ ") token).getStopIndex());");
				sc.add("}");
				sc.add("if (java.lang.String.class.isInstance("
						+ resolvedObjectIdentifier + ")) {");
				sc.add("addObjectToList(element, feature, " + resolvedObjectIdentifier + ");");
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

	private void addCreateInstanceMethod(String lexerName, String parserName,de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + iTextParserClassName + " createInstance("
				+ INPUT_STREAM(sc) + " actualInputStream, "
				+ "String encoding) {");
		sc.add("try {");
		sc.add("if (encoding == null) {");
		sc.add("return new " + parserName + "(new "
				+ COMMON_TOKEN_STREAM(sc) + "(new " + lexerName
				+ "(new " + ANTLR_INPUT_STREAM(sc)
				+ "(actualInputStream))));");
		sc.add("} else {");
		sc.add("return new " + parserName + "(new "
				+ COMMON_TOKEN_STREAM(sc) + "(new " + lexerName
				+ "(new " + ANTLR_INPUT_STREAM(sc)
				+ "(actualInputStream, encoding))));");
		sc.add("}");
		sc.add("} catch (" + IO_EXCEPTION(sc) + " e) {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Error while creating parser.\", e);");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addFields(ANTLRGrammarComposite sc) {
		sc.add("private " + iTokenResolverFactoryClassName
				+ " tokenResolverFactory = new "
				+ tokenResolverFactoryClassName + "();");
		sc.addLineBreak();
		
		sc.addJavadoc("the index of the last token that was handled by collectHiddenTokens()");
		sc.add("private int lastPosition;");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A flag that indicates whether the parser should remember all expected elements. " +
			"This flag is set to true when using the parse for code completion. Otherwise it is " +
			"set to false."
		);
		sc.add("private boolean rememberExpectedElements = false;");
		sc.addLineBreak();
		
		sc.add("private Object parseToIndexTypeObject;");
		sc.add("private int lastTokenIndex = 0;");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A list of expected elements the were collected while parsing the input stream. " +
			"This list is only filled if <code>rememberExpectedElements</code> is set to true."
		);
		sc.add("private " + LIST(sc) + "<" + expectedTerminalClassName
				+ "> expectedElements = new " + ARRAY_LIST(sc) + "<"
				+ expectedTerminalClassName + ">();");
		sc.addLineBreak();

		sc.add("private int mismatchedTokenRecoveryTries = 0;");
		
		sc.addJavadoc("A helper list to allow a lexer to pass errors to its parser");
		sc.add("protected " + LIST(sc) + "<" + RECOGNITION_EXCEPTION(sc)
				+ "> lexerExceptions = " + COLLECTIONS(sc)
				+ ".synchronizedList(new " + ARRAY_LIST(sc) + "<"
				+ RECOGNITION_EXCEPTION(sc) + ">());");
		sc.addLineBreak();
		
		sc.addJavadoc("Another helper list to allow a lexer to pass positions of errors to its parser");
		sc.add("protected " + LIST(sc) + "<Integer> lexerExceptionPositions = " + COLLECTIONS(sc)
				+ ".synchronizedList(new " + ARRAY_LIST(sc) + "<Integer>());");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A stack for incomplete objects. This stack is used filled when the parser is used " +
			"for code completion. Whenever the parser starts to read an object it is pushed on " +
			"the stack. Once the element was parser completely it is popped from the stack."
		);
		/*sc.add("protected " + STACK + "<" + E_OBJECT
				+ "> incompleteObjects = new " + STACK + "<" + E_OBJECT
				+ ">();");*/
		sc.add(sc.declareArrayList("incompleteObjects",E_OBJECT(sc)));
		sc.addLineBreak();

		sc.add("private int stopIncludingHiddenTokens;");
		sc.add("private int stopExcludingHiddenTokens;");
		
		sc.add("private int tokenIndexOfLastCompleteElement;");
		sc.addLineBreak();
		
		sc.add("private int expectedElementsIndexOfLastCompleteElement;");
		sc.addLineBreak();

		sc.addJavadoc(
			"The offset indicating the cursor position when the parser is used for code " +
			"completion by calling parseToExpectedElements()."
		);
		sc.add("private int cursorOffset;");
		sc.addLineBreak();

		sc.addJavadoc(
			"The offset of the first hidden token of the last expected element. " +
			"This offset is used to discard expected elements, which are not needed " +
			"for code completion."
		);
		sc.add("private int lastStartIncludingHidden;");
		sc.addLineBreak();
		sc.add("private " + iLocationMapClassName + " locationMap;");
		sc.addLineBreak();
		sc.add("private " + syntaxErrorMessageConverterClassName + " syntaxErrorMessageConverter = new " + syntaxErrorMessageConverterClassName + "(tokenNames);");
		sc.addLineBreak();
	}

	private void addParseToExpectedElementsMethod(ANTLRGrammarComposite sc) {
		sc.add("public " + LIST(sc) + "<" + expectedTerminalClassName
				+ "> parseToExpectedElements(" + E_CLASS(sc) + " type, " + iTextResourceClassName + " dummyResource, int cursorOffset) {");
		sc.add("this.rememberExpectedElements = true;");
		sc.add("this.parseToIndexTypeObject = type;");
		sc.add("this.cursorOffset = cursorOffset;");
		sc.add("this.lastStartIncludingHidden = -1;");
		sc.add("final " + COMMON_TOKEN_STREAM(sc) + " tokenStream = (" + COMMON_TOKEN_STREAM(sc) + ") getTokenStream();");
		sc.add(iParseResultClassName + " result = parse();");
		sc.add("for (" + E_OBJECT(sc) + " incompleteObject : incompleteObjects) {");
		sc.add(LEXER(sc) + " lexer = (" + LEXER(sc) + ") tokenStream.getTokenSource();");
		sc.add("int endChar = lexer.getCharIndex();");
		sc.add("int endLine = lexer.getLine();");
		sc.add("setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);");
		sc.add("}");
		sc.add("if (result != null) {");
		sc.add(E_OBJECT(sc) + " root = result.getRoot();");
		sc.add("if (root != null) {");
		sc.add("dummyResource.getContentsInternal().add(root);");
		sc.add("}");
		sc.add("for (" + iCommandClassName + "<" + iTextResourceClassName + "> command : result.getPostParseCommands()) {");
		sc.add("command.execute(dummyResource);");
		sc.add("}");
		sc.add("}");
		sc.addComment("remove all expected elements that were added after the last complete element");
		sc.add("expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);");
		sc.add("int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();");
		sc.add(SET(sc) + "<" + expectedTerminalClassName + "> currentFollowSet = new " + LINKED_HASH_SET(sc) +"<" + expectedTerminalClassName + ">();");
		sc.add(LIST(sc) + "<" + expectedTerminalClassName + "> newFollowSet = new " + ARRAY_LIST(sc) +"<" + expectedTerminalClassName + ">();");
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
		sc.add(COMMON_TOKEN(sc) + " nextToken = (" + COMMON_TOKEN(sc) + ") tokenStream.get(i);");
		//sc.add("System.out.println(\"REMAINING TOKEN: \" + nextToken);");
		sc.add("if (nextToken.getType() < 0) {");
		sc.add("break;");
		sc.add("}");
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
		sc.add("if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {");
		sc.addComment("keep this one - it matches");
		//sc.add("System.out.println(\"MATCH! \" + nextFollow);");
		sc.add(COLLECTION(sc) + "<" + pairClassName + "<" + iExpectedElementClassName + ", " + containedFeatureClassName + "[]>> newFollowers = nextFollow.getTerminal().getFollowers();");
		sc.add("for (" + pairClassName + "<" + iExpectedElementClassName + ", " + containedFeatureClassName + "[]> newFollowerPair : newFollowers) {");
		sc.add(iExpectedElementClassName + " newFollower = newFollowerPair.getLeft();");
		sc.add(E_OBJECT(sc) + " container = getLastIncompleteElement();");
		// TODO mseifert: null is not the correct metaclass for the trace, but what is?
		sc.add(containmentTraceClassName + " containmentTrace = new " + containmentTraceClassName + "(null, newFollowerPair.getRight());");
		sc.add(expectedTerminalClassName + " newFollowTerminal = new " + expectedTerminalClassName + "(container, newFollower, followSetID, containmentTrace);");
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
		sc.add("protected void copyLocalizationInfos(final " + E_OBJECT(sc) + " source, final "
				+ E_OBJECT(sc) + " target) {");
		sc.add("if (disableLocationMap) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + iLocationMapClassName + " locationMap = this.locationMap;");
		sc.add("if (locationMap == null) {");
		sc.addComment("the locationMap can be null if the parser is used for code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("postParseCommands.add(new " + iCommandClassName + "<" + iTextResourceClassName + ">() {");
		sc.add("public boolean execute(" + iTextResourceClassName + " resource) {");
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
		sc.add("protected void setLocalizationEnd(" + COLLECTION(sc) + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> postParseCommands , final " + E_OBJECT(sc) + " object, final int endChar, final int endLine) {");
		sc.add("if (disableLocationMap) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + iLocationMapClassName + " locationMap = this.locationMap;");
		sc.add("if (locationMap == null) {");
		sc.addComment("the locationMap can be null if the parser is used for code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("postParseCommands.add(new " + iCommandClassName + "<" + iTextResourceClassName + ">() {");
		sc.add("public boolean execute(" + iTextResourceClassName + " resource) {");
		sc.add("locationMap.setCharEnd(object, endChar);");
		sc.add("locationMap.setLine(object, endLine);");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCopyLocalizationInfosMethod2(ANTLRGrammarComposite sc) {
		sc.add("protected void copyLocalizationInfos(final " + COMMON_TOKEN(sc)
				+ " source, final " + E_OBJECT(sc) + " target) {");
		sc.add("if (disableLocationMap) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + iLocationMapClassName + " locationMap = this.locationMap;");
		sc.add("if (locationMap == null) {");
		sc.addComment("the locationMap can be null if the parser is used for code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("postParseCommands.add(new " + iCommandClassName + "<" + iTextResourceClassName + ">() {");
		sc.add("public boolean execute(" + iTextResourceClassName + " resource) {");
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

	private void addAddExpectedElementMethod(ANTLRGrammarComposite sc) {
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
		sc.add("public void addExpectedElement(" + E_CLASS(sc) + " eClass, int[] ids) {");
		sc.add("if (!this.rememberExpectedElements) {");
		sc.add("return;");
		sc.add("}");
		sc.add("int terminalID = ids[0];");
		sc.add("int followSetID = ids[1];");
		sc.add(iExpectedElementClassName + " terminal = " + followSetProviderClassName + ".TERMINALS[terminalID];");
		sc.add(containedFeatureClassName + "[] containmentFeatures = new " + containedFeatureClassName + "[ids.length - 2];");
		sc.add("for (int i = 2; i < ids.length; i++) {");
		sc.add("containmentFeatures[i - 2] = " + followSetProviderClassName + ".LINKS[ids[i]];");
		sc.add("}");
		sc.add(containmentTraceClassName + " containmentTrace = new " + containmentTraceClassName + "(eClass, containmentFeatures);");
		
		sc.add(E_OBJECT(sc) + " container = getLastIncompleteElement();");
		sc.add(expectedTerminalClassName + " expectedElement = new " + expectedTerminalClassName + "(container, terminal, followSetID, containmentTrace);"); 
		sc.add("setPosition(expectedElement, input.index());");
		
		sc.add("int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();");
		// TODO explain why this is required
		sc.add("if (lastStartIncludingHidden >= 0 && " +
			"lastStartIncludingHidden < startIncludingHiddenTokens && " +
			"cursorOffset > startIncludingHiddenTokens) {");
		sc.addComment("clear list of expected elements");
		sc.add("this.expectedElements.clear();");
		sc.add("this.expectedElementsIndexOfLastCompleteElement = 0;");
		sc.add("}");
		sc.add("lastStartIncludingHidden = startIncludingHiddenTokens;");
		sc.add("this.expectedElements.add(expectedElement);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLastIncompleteElementMethod(ANTLRGrammarComposite sc) {
		sc.add("private " + E_OBJECT(sc) + " getLastIncompleteElement() {"); 
		sc.add("if (incompleteObjects.isEmpty()) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return incompleteObjects.get(incompleteObjects.size() - 1);"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetPositionMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void setPosition(" + expectedTerminalClassName
				+ " expectedElement, int tokenIndex) {");
		sc.add("int currentIndex = Math.max(0, tokenIndex);");
		sc.add("for (int index = lastTokenIndex; index < currentIndex; index++) {");
		sc.add("if (index >= input.size()) {");
		sc.add("break;");
		sc.add("}");
		sc.add(COMMON_TOKEN(sc) + " tokenAtIndex = (" + COMMON_TOKEN(sc) + ") input.get(index);");
		sc.add("stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;");
		sc.add("if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {");
		sc.add("stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;");
		sc.add("}");
		sc.add("}");
		sc.add("lastTokenIndex = Math.max(0, currentIndex);");
		sc.add("expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetParseToIndexTypeObjectMethod(StringComposite sc) {
		sc.add("public Object getParseToIndexTypeObject() {");
		sc.add("return parseToIndexTypeObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRecoverFromMismatchedTokenMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public Object recoverFromMismatchedToken(" + INT_STREAM(sc)
				+ " input, int ttype, " + BIT_SET(sc) + " follow) throws "
				+ RECOGNITION_EXCEPTION(sc) + " {");
		sc.add("if (!rememberExpectedElements) {");
		sc.add("return super.recoverFromMismatchedToken(input, ttype, follow);");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
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
		sc.add("returns [ " + E_OBJECT(sc) + " element = null]");
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
		sc.add("expectedElementsIndexOfLastCompleteElement = 0;");
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
		sc.add("{");
		sc.add("retrieveLayoutInformation(element, null, null, false);");
		sc.add("}");
		sc.addLineBreak();
		sc.add(";");
		sc.addLineBreak();
	}

	private void printRightRecursion(ANTLRGrammarComposite sc, Rule rule,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass,Collection<Terminal>> classesReferenced) {

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
			sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + nameUtil.getFieldName(rule) + ", null, true);");
			sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> dummyEObjects  = new "
					+ ARRAY_LIST(sc) + "<" + E_OBJECT(sc) + ">();");
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

			printChoice(ruleCopy.getDefinition(), ruleCopy, sc, new Counter(),
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
			sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + nameUtil.getFieldName(rule) + ", null, true);");
			sc.add("}");
			sc.add(":");

			printChoice(tailCopy.getDefinition(), tailCopy, sc, new Counter(),
					classesReferenced, "0");

			sc.add(";");
			sc.addLineBreak();
		}
		eClassesWithSyntax.add(rule.getMetaclass());

	}

	private void printGrammarRules(ANTLRGrammarComposite sc,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass,Collection<Terminal>> eClassesReferenced) {

		boolean autofix = OptionManager.INSTANCE.getBooleanOptionValue(
				concreteSyntax,
				OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);

		LeftRecursionDetector lrd = new LeftRecursionDetector(
				genClassNames2superClassNames, concreteSyntax);

		for (Rule rule : concreteSyntax.getAllRules()) {
			// operator rules must be handled separately
			if (concreteSyntax.getOperatorRules().contains(rule)) {
				continue;
			}
			Rule recursionRule = lrd.findLeftRecursion(rule);
			if (recursionRule != null) {
				if (lrd.isDirectLeftRecursive(rule)) {// direct left recursion
					if (autofix) {
						printRightRecursion(sc, rule, eClassesWithSyntax,
								eClassesReferenced);

						Collection<GenClass> subClasses = concreteSyntax
								.getSubClassesWithSyntax(rule.getMetaclass(),
										true);
						if (!subClasses.isEmpty()) {
							sc.add("|//derived choice rules for sub-classes: ");
	printSubClassOrPrimitiveOperatorChoices(sc, subClasses);
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
			List<GenClass> eClassesWithSyntax,
			Map<GenClass,Collection<Terminal>> eClassesReferenced) {
		
		GenClass genClass = rule.getMetaclass();
		String ruleName = getRuleName(genClass);

		printGrammarRulePrefix(genClass,ruleName,sc);
		
		printChoice(rule.getDefinition(), rule, sc, new Counter(), eClassesReferenced, "0");

		Collection<GenClass> subClasses = concreteSyntax
				.getSubClassesWithSyntax(genClass, true);
		if (!subClasses.isEmpty()) {
			sc.add("|//derived choice rules for sub-classes: ");
			sc.addLineBreak();
			printSubClassOrPrimitiveOperatorChoices(sc, subClasses);
			sc.addLineBreak();
		}
		printGrammarRuleSuffix(sc);

		eClassesWithSyntax.add(genClass);
	}

	// TODO mseifert: split this method into smaller ones	
	private void printGrammarExpressionSlice(
			ANTLRGrammarComposite sc,
			List<Rule> slice, 
			List<GenClass> eClassesWithSyntax,
			Map<GenClass,Collection<Terminal>> eClassesReferenced) {
		
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
			OperatorAnnotationType operatorType = csUtil.getOperatorAnnotationType(firstRule.getOperatorAnnotation());
			
			String ruleName = getExpressionSliceRuleName(firstRule);

			GenClass returnGenClass = firstRule.getMetaclass();
			for (GenClass metaClass : allGenClasses) {
				if (metaClass.getName().equals(firstRule.getOperatorAnnotation().getValue(OperatorAnnotationProperty.SUPERCLASS.toString()))) {
					returnGenClass = metaClass;
				}
			}
		
			printGrammarRulePrefix(returnGenClass, ruleName, sc);
			
			if (!isLast) { 
				// we assume all arguments to be typed by the same class
				final String nextRuleName = getExpressionSliceRuleName(sliceIterator.next());
				sliceIterator.previous();
				// we do unary operators first
				if (operatorType == OperatorAnnotationType.UNARY_PREFIX) {
					// 1st case: unary operator starts with keyword (prefix)
					printUnaryPrefixOperatorRule(sc, eClassesReferenced,
								firstRule, rulesWithEqualWeight, nextRuleName);	
				}
				// 2nd case: unary operator starts with argument (postfix, this means left recursion)
				else if (operatorType == OperatorAnnotationType.UNARY_POSTFIX) {
						printUnaryPostfixOperatorRule(sc, eClassesReferenced,
								rulesWithEqualWeight, firstSequence, nextRuleName);		
				}
				// now we do binary infix operators
				else if (operatorType == OperatorAnnotationType.BINARY_LEFT_ASSOCIATIVE) {
					printBinaryLeftAssociativeRule(sc, eClassesReferenced,
							rulesWithEqualWeight, nextRuleName);
				} else if (operatorType == OperatorAnnotationType.BINARY_RIGHT_ASSOCIATIVE) {
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
			List<GenClass> eClassesWithSyntax,
			Map<GenClass,Collection<Terminal>> eClassesReferenced,
			List<Rule> rulesWithEqualWeight) {
		
		List<GenClass> choiceClasses = new LinkedList<GenClass>();
		for (Rule rule : rulesWithEqualWeight) {
			choiceClasses.add(rule.getMetaclass());
		}
		printSubClassOrPrimitiveOperatorChoices(sc, choiceClasses);
		printGrammarRuleSuffix(sc);
		
		for (Rule rule : rulesWithEqualWeight) {
			printGrammarRule(rule, sc, eClassesWithSyntax, eClassesReferenced);	
		}
	}
	
	private void printUnaryPrefixOperatorRule(
			ANTLRGrammarComposite sc,
			Map<GenClass,Collection<Terminal>> eClassesReferenced,
			Rule firstRule, 
			List<Rule> equalWeightOPs, 
			String nextRuleName) {
		
		for (Rule rule : equalWeightOPs) {
			List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
			assert definitions.size() >= 2;
			// in general, we do not alter the syntax models during code 
			// generation, but we can remove the last definition here, since 
			// this list of definitions is just a copy
			Definition right = definitions.remove(definitions.size() - 1);
			
			assert right instanceof Containment;
			
			printDefinitions(definitions, rule, sc, new Counter(), eClassesReferenced, "0");
			
			sc.add("arg = " + nextRuleName);
			Containment containment = (Containment) right;
			printTerminalAction(containment, rule, sc, "arg", "", "arg", null, "null", true);
			
			sc.add("|");
			sc.addLineBreak();
		}
		sc.addLineBreak();
		sc.add("arg = " + nextRuleName + "{ element = arg; }");
	}

	private void printUnaryPostfixOperatorRule(
			ANTLRGrammarComposite sc,
			Map<GenClass,Collection<Terminal>> eClassesReferenced,
			List<Rule> equalWeightOPs, 
			Sequence firstSequence,
			String nextRuleName) {
		
		sc.add("arg = "+ nextRuleName);
		sc.add("(");
		
		for (Rule rule : equalWeightOPs) {
			List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
			assert definitions.size() > 2;
			
			Definition left = definitions.remove(0);
			assert left instanceof Containment;
						
			printDefinitions(definitions, rule, sc, new Counter(), eClassesReferenced, "0");
			
			Containment containment = (Containment) left;
			printTerminalAction(containment, rule, sc, "arg", "", "arg", null, "null", true);
			sc.add("|");
			sc.addLineBreak();
		}
		
		sc.add("/* epsilon */ { element = arg; } ");
		sc.addLineBreak();
		sc.add(")");
	}

	private void printBinaryLeftAssociativeRule(
			ANTLRGrammarComposite sc,
			Map<GenClass,Collection<Terminal>> eClassesReferenced,
			List<Rule> equalWeightOPs, 
			String nextRuleName) {
		
		sc.add("leftArg = " + nextRuleName);
		sc.add("((");
		Iterator<Rule> ruleIterator = equalWeightOPs.iterator();
		while (ruleIterator.hasNext()) {
			Rule rule = ruleIterator.next();
			List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
			assert definitions.size() >= 2;
			
			Definition left = definitions.get(0);
			definitions.remove(0);
			Definition right = definitions.get(definitions.size()- 1);
			definitions.remove(definitions.size()- 1);
		
			assert left instanceof Containment;
			assert right instanceof Containment;
			
			Containment leftContainment = (Containment) left;
			Containment rightContainment = (Containment) right;
			sc.add("()");//Workaround for bug 1374 (semantic actions in syn preds)
			sc.add("{ element = null; }");
			
			printDefinitions(definitions, rule, sc, new Counter(), eClassesReferenced, "0");
			
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

	private void printBinaryRightAssociativeRule(
			ANTLRGrammarComposite sc,
			Map<GenClass,Collection<Terminal>> eClassesReferenced,
			List<Rule> equalWeightOPs, 
			String ruleName,
			String nextRuleName) {
		
		sc.add("leftArg = " + nextRuleName);
		sc.add("((");

		Iterator<Rule> ruleIterator = equalWeightOPs.iterator();
		while (ruleIterator.hasNext()) {
			Rule rule = ruleIterator.next();
			List<Definition> definitions = rule.getDefinition().getOptions().get(0).getParts();
			assert definitions.size() >= 2;
			
			Definition left = definitions.get(0);
			definitions.remove(0);
			Definition right = definitions.get(definitions.size()- 1);
			definitions.remove(definitions.size()- 1);
			
			assert left instanceof Containment;
			assert right instanceof Containment;
			
			Containment leftContainment = (Containment) left;
			Containment rightContainment = (Containment) right;
			
			printDefinitions(definitions, rule, sc, new Counter(), eClassesReferenced, "0");		
			
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
		String ruleName = operatorAnnotation.getValue(OperatorAnnotationProperty.SUPERCLASS.toString()) + "_level_";
		String weight = operatorAnnotation.getValue(OperatorAnnotationProperty.WEIGHT.toString()).replace('-','_');
		ruleName += weight;
		return "parseop_" + ruleName;
	}

	private String getRuleName(GenClass genClass) {
		String ruleName = genClassCache.getEscapedTypeName(genClass);
		return "parse_" + ruleName;
	}

	private void printChoice(Choice choice, Rule rule,
			ANTLRGrammarComposite sc, Counter counter,
			Map<GenClass, Collection<Terminal>> eClassesReferenced,
			String scopeID) {
		
		Iterator<Sequence> it = choice.getOptions().iterator();
		while (it.hasNext()) {
			Sequence sequence = it.next();
			printSequence(sequence, rule, sc, counter, eClassesReferenced,
					scopeID);
			if (it.hasNext()) {
				sc.addLineBreak();
				sc.add("|");
			}
		}
	}

	private void printSequence(Sequence sequence, Rule rule,
			ANTLRGrammarComposite sc, Counter counter,
			Map<GenClass, Collection<Terminal>> eClassesReferenced,
			String scopeID) {
		
		printDefinitions(sequence.getParts(), rule, sc, counter,
				eClassesReferenced, scopeID);
	}
	
	private void printDefinitions(List<Definition> definitions, Rule rule,
			ANTLRGrammarComposite sc, Counter counter,
			Map<GenClass, Collection<Terminal>> eClassesReferenced,
			String scopeID) {
		
		int i = 0;
		for (Definition definition : definitions) {
			if (definition instanceof LineBreak) {
				continue;
			}
			if (definition instanceof WhiteSpaces) {
				continue;
			}
			
			ConcreteSyntax syntax = getContext().getConcreteSyntax();
			Set<Expectation> expectations = computer.computeFollowSet(syntax, definition);
			getContext().getConstantsPool().addToFollowSetMap(definition, expectations);
			
			String cardinality = definition.computeCardinalityString();
			if (!"".equals(cardinality)) {
				sc.add("(");
			}
			if (definition instanceof CompoundDefinition) {
				String subScopeID = scopeID + "." + i;

				CompoundDefinition compoundDef = (CompoundDefinition) definition;
				sc.add("(");
				printChoice(compoundDef.getDefinition(), rule, sc, counter,
						eClassesReferenced, subScopeID);
				sc.add(")");
				i++;
			} else if (definition instanceof CsString) {
				final CsString csString = (CsString) definition;
				printCsString(csString, rule, sc, counter, eClassesReferenced);
			} else {
				assert definition instanceof Terminal;
				final Terminal terminal = (Terminal) definition;
				printTerminal(terminal, rule, sc, counter, eClassesReferenced);
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
	}

	private void addExpectationsCode(ANTLRGrammarComposite sc, Set<Expectation> expectations) {
		GenerationContext context = getContext();
		ConstantsPool constantsPool = context.getConstantsPool();
		List<Integer[]> expectationCalls = constantsPool.getExpectationCalls();
		
		for (Expectation expectation : expectations) {
			EObject expectedElement = expectation.getExpectedElement();
			int terminalID = constantsPool.getTerminalID(expectedElement);
			List<ContainmentLink> containmentTrace = expectation.getContainmentTrace();

			Integer[] o = new Integer[2 +  containmentTrace.size()];
			o[0] = terminalID;
			o[1] = followSetID;

			int i = 2;
			for (ContainmentLink link : containmentTrace) {
				o[i] = constantsPool.getContainmentLinkID(link);
				i++;
			}
			String metaclassAccessor = "null";
			GenClass metaClass = expectation.getMetaClass();
			if (metaClass != null) {
				metaclassAccessor = genClassUtil.getAccessor(metaClass);
			}
			/*
			sc.addComment(expectation.getExpectedElement().toString() + ", " + StringUtil.explode(containmentTrace, ",", new ToStringConverter<ContainmentLink>() {

				public String toString(ContainmentLink link) {
					return link.toString();
				}
			}));
			*/
			sc.add("addExpectedElement(" + metaclassAccessor + ", " + expectationConstantsClassName + ".EXPECTATIONS["+ expectationCalls.size() + "]);");
			expectationCalls.add(o);
		}
		followSetID++;
	}
	
	private void printCsString(CsString csString, Rule rule,de.devboost.codecomposers.java.JavaComposite sc,
			Counter counter, Map<GenClass,Collection<Terminal>> eClassesReferenced) {
		String identifier = "a" + counter.getValue();
		String escapedCsString = StringUtil.escapeToANTLRKeyword(csString.getValue());
		sc.add(identifier + " = '" + escapedCsString + "' {");
		addCodeToCreateObject(sc, rule);
		sc.add("collectHiddenTokens(element);");
		sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + nameUtil.getFieldName(csString) + ", null, true);");
		sc.add("copyLocalizationInfos((" + COMMON_TOKEN(sc) + ")" + identifier
				+ ", element);");
		sc.add("}");
		counter.inc();
	}

	private void addCodeToCreateObject(StringComposite sc, Rule rule) {
		final GenClass metaclass = rule.getMetaclass();

		sc.add("if (element == null) {");
		sc.add("element = " + genClassUtil.getCreateObjectCall(metaclass, dummyEObjectClassName) + ";");
		sc.add("startIncompleteElement(element);");
		addCodeToInitializeBooleanAttributes(sc, rule, metaclass);
		addCodeToInitializeEnumerationAttributes(sc, rule, metaclass);
		sc.add("}");
	}

	private void addCodeToInitializeBooleanAttributes(StringComposite sc,
			Rule rule, GenClass metaclass) {
		Collection<BooleanTerminal> booleanTerminals = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal());
		for (BooleanTerminal booleanTerminal : booleanTerminals) {
			final GenFeature genFeature = booleanTerminal.getFeature();
			final EStructuralFeature eFeature = genFeature.getEcoreFeature();
			final String featureConstant = generatorUtil.getFeatureConstant(metaclass, genFeature);

			if ("".equals(booleanTerminal.getTrueLiteral())) {
				sc.add("// initialize boolean attribute");
				sc.add("{");
				generatorUtil.addCodeToSetFeature(sc, metaclass, featureConstant, eFeature, "true", false, false);
				sc.add("}");
			}
			if ("".equals(booleanTerminal.getFalseLiteral())) {
				sc.add("// initialize boolean attribute");
				sc.add("{");
				generatorUtil.addCodeToSetFeature(sc, metaclass, featureConstant, eFeature, "false", false, false);
				sc.add("}");
			}
		}
	}

	private void addCodeToInitializeEnumerationAttributes(StringComposite sc,
			Rule rule, GenClass metaclass) {
		Collection<EnumTerminal> enumerationTerminals = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getEnumTerminal());
		for (EnumTerminal enumerationTerminal : enumerationTerminals) {
			List<EnumLiteralTerminal> emptyLiterals = enumerationTerminal.getEmptyLiterals();
			// this should be detected by a post processor
			assert emptyLiterals.size() < 2;

			if (!emptyLiterals.isEmpty()) {

				GenFeature genFeature = enumerationTerminal.getFeature();
				GenEnum genEnum = genFeature.getTypeGenEnum();
				EStructuralFeature eFeature = genFeature.getEcoreFeature();
				EnumLiteralTerminal enumLiteralTerminal = emptyLiterals.get(0);
				String literal = enumLiteralTerminal.getLiteral().getLiteral();
				GenEnumLiteral genEnumLiteral = genEnum.getGenEnumLiteral(literal);
				String featureConstant = generatorUtil.getFeatureConstant(metaclass, genFeature);
				
				String accessorName = generatorUtil.getEnumLiteralInstanceAccessor(genEnum, genEnumLiteral);
				sc.add("// initialize enumeration attribute");
				generatorUtil.addCodeToSetFeature(sc, metaclass, featureConstant, eFeature, accessorName, false, false);
			}
		}
	}

	private void printTerminal(Terminal terminal, Rule rule, JavaComposite sc,
			Counter counter,
			Map<GenClass, Collection<Terminal>> eClassesReferenced) {
		
		final GenClass genClass = rule.getMetaclass();
		final GenFeature genFeature = terminal.getFeature();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
		final String ident = "a" + counter.getValue();
		final String proxyIdent = "proxy";
		boolean isAnonymousFeature = genFeature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE;

		StringComposite resolvements = new ANTLRGrammarComposite();

		sc.add("(");

		if (terminal instanceof Containment) {
			assert ((EReference) eFeature).isContainment();
			Containment containment = (Containment) terminal;

			List<GenClass> types = containment.getAllowedSubTypes();

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
		} else if (terminal instanceof BooleanTerminal) {
			BooleanTerminal booleanTerminal = (BooleanTerminal) terminal;
			addCodeForBooleanTerminal(sc, counter, booleanTerminal);
		} else if (terminal instanceof EnumTerminal) {
			EnumTerminal enumTerminal = (EnumTerminal) terminal;
			addCodeForEnumTerminal(sc, counter, enumTerminal);
		} else {
			assert terminal instanceof Placeholder;
			Placeholder placeholder = (Placeholder) terminal;
			ReferencableTokenDefinition token = placeholder.getToken();
			String tokenName = token.getName();

			sc.add(ident + " = " + tokenName);
			sc.addLineBreak();

			// ignore the anonymous features
			if (!isAnonymousFeature) {
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
				resolvements.add("Object " + preResolved
						+ " = result.getResolvedToken();");
				resolvements.add("if (" + preResolved + " == null) {");
				resolvements.add("addErrorToResource(result.getErrorMessage(), (("
						+ COMMON_TOKEN(sc) + ") " + ident + ").getLine(), (("
						+ COMMON_TOKEN(sc) + ") " + ident
						+ ").getCharPositionInLine(), ((" + COMMON_TOKEN(sc) + ") "
						+ ident + ").getStartIndex(), ((" + COMMON_TOKEN(sc) + ") "
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
						// a slightly more elegant version of this code can also 
						// be found in the ScannerlessParserGenerator
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
									+ "), element, (" + E_REFERENCE(sc) + ") element.eClass().getEStructuralFeature("
									+ generatorUtil.getFeatureConstant(genClass,
											genFeature) + "), " + resolvedIdent
									+ ", " + proxyIdent + ");");
				} else {
					// the feature is an EAttribute
					targetTypeName = genFeature.getQualifiedListItemType(null);
					resolvements.add(targetTypeName + " " + resolvedIdent + " = ("
							+ getObjectTypeName(targetTypeName) + ") " + preResolved
							+ ";");
					expressionToBeSet = "resolved";
				}

				printTerminalAction(placeholder, rule, sc, ident, proxyIdent, expressionToBeSet,
						resolvements, tokenName, false);
			}
		}

		sc.add(")");
		if (isAnonymousFeature) {
			sc.add("{");
			sc.add("anonymousTokens.add((" + COMMON_TOKEN(sc) + ") " + ident+ ");");
			sc.add("}");
		}
		counter.inc();
	}

	private void addCodeForBooleanTerminal(JavaComposite sc, Counter counter,
			BooleanTerminal booleanTerminal) {

		Rule rule = booleanTerminal.getContainingRule();
		final GenClass metaclass = rule.getMetaclass();
		final GenFeature genFeature = booleanTerminal.getFeature();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
		final String featureConstant = generatorUtil.getFeatureConstant(metaclass, genFeature);
		
		String trueLiteral = booleanTerminal.getTrueLiteral();
		String falseLiteral = booleanTerminal.getFalseLiteral();
		boolean trueIsSet = !"".equals(trueLiteral);
		boolean falseIsSet = !"".equals(falseLiteral);

		sc.add("(");
		if (trueIsSet) {
			String identifier = "a" + counter.getValue();
			addCodeForBooleanLiteral(sc, booleanTerminal,
					eFeature, featureConstant, identifier, trueLiteral, "true");
			counter.inc();
		}

		if (trueIsSet && falseIsSet) {
			// if both literals (for false and true) are set, they are alternatives
			sc.add("|");
		}
		
		if (falseIsSet) {
			String identifier = "a" + counter.getValue();
			addCodeForBooleanLiteral(sc, booleanTerminal, 
					eFeature, featureConstant, identifier, falseLiteral, "false");
		}
		
		if (!falseIsSet || !trueIsSet) {
			// if one of the literals is empty, the other one is optional except
			// if the boolean terminal in an compound which can be empty
			if (csUtil.isInEmptyCompound(booleanTerminal)) {
				sc.add(")");
			} else {
				sc.add(")?");
			}
		} else {
			sc.add(")");
		}
		counter.inc();
	}

	private void addCodeForEnumTerminal(
			JavaComposite sc, 
			Counter counter,
			EnumTerminal enumTerminal) {

		Rule rule = enumTerminal.getContainingRule();
		final GenClass metaclass = rule.getMetaclass();
		final GenFeature genFeature = enumTerminal.getFeature();
		final GenEnum genEnum = genFeature.getTypeGenEnum();
		
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
		final String featureConstant = generatorUtil.getFeatureConstant(metaclass, genFeature);
		
		boolean containsEmptyLiteral = enumTerminal.containsEmptyLiteral();

		List<EnumLiteralTerminal> literals = enumTerminal.getNonEmptyLiterals();

		sc.add("(");
		for (int i = 0; i < literals.size(); i++) {
			EnumLiteralTerminal enumLiteralTerminal = literals.get(i);
			String identifier = "a" + counter.getValue();
			String literal = enumLiteralTerminal.getLiteral().getLiteral();
			GenEnumLiteral genEnumLiteral = genEnum.getGenEnumLiteral(literal);
			String accessorName = generatorUtil.getEnumLiteralInstanceAccessor(genEnum, genEnumLiteral);
			addCodeForEnumLiteralTerminal(
					sc, 
					enumTerminal,
					enumLiteralTerminal,
					eFeature, 
					featureConstant, 
					accessorName,
					identifier);
			counter.inc();
			boolean isLast = i == (literals.size() - 1);
			if (!isLast) {
				// all literals are alternatives
				sc.add("|");
			}
		}
		
		if (containsEmptyLiteral) {
			// if one of the literals is empty, the others are optional except
			// if the enumeration terminal in an compound which can be empty
			if (csUtil.isInEmptyCompound(enumTerminal)) {
				sc.add(")");
			} else {
				sc.add(")?");
			}
		} else {
			sc.add(")");
		}
		counter.inc();
	}

	private void addCodeForBooleanLiteral(de.devboost.codecomposers.java.JavaComposite sc,
			BooleanTerminal booleanTerminal, 
			EStructuralFeature eFeature, String featureConstant,
			String identifier, String literal, String value) {
		Rule rule = booleanTerminal.getContainingRule();
		String escapedLiteral = StringUtil.escapeToANTLRKeyword(literal);
		sc.add(identifier + " = '" + escapedLiteral + "' {");
		addCodeToCreateObject(sc, rule);
		sc.add("collectHiddenTokens(element);");
		sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + nameUtil.getFieldName(booleanTerminal) + ", " + value + ", true);");
		sc.add("copyLocalizationInfos((" + COMMON_TOKEN(sc) + ")" + identifier + ", element);");
		sc.add("// set value of boolean attribute");
		generatorUtil.addCodeToSetFeature(sc, rule.getMetaclass(), featureConstant, eFeature, value, false, true);
		sc.add("}");
	}

	private void addCodeForEnumLiteralTerminal(de.devboost.codecomposers.java.JavaComposite sc,
			EnumTerminal enumTerminal, 
			EnumLiteralTerminal enumLiteralTerminal, 
			EStructuralFeature eFeature, 
			String featureConstant,
			String accessorName,
			String identifier) {
		Rule rule = enumLiteralTerminal.getContainingRule();
		String escapedLiteral = StringUtil.escapeToANTLRKeyword(enumLiteralTerminal.getText());
		sc.add(identifier + " = '" + escapedLiteral + "' {");
		addCodeToCreateObject(sc, rule);
		sc.add("collectHiddenTokens(element);");
		sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + nameUtil.getFieldName(enumTerminal) + ", null, true);");
		sc.add("copyLocalizationInfos((" + COMMON_TOKEN(sc) + ")" + identifier + ", element);");
		sc.add("// set value of enumeration attribute");
		generatorUtil.addCodeToSetFeature(sc, rule.getMetaclass(), featureConstant, eFeature, accessorName, false, true);
		sc.add("}");
	}

	private void printTerminalAction(Terminal terminal, Rule rule,de.devboost.codecomposers.java.JavaComposite sc,
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
		addCodeToCreateObject(sc, rule);
		sc.add(new StringComponent("String tokenName = \"" + StringUtil.escapeToJavaString(tokenName) + "\";", "tokenName"));
		sc.add("if (" + ident + " != null) {");
		if (resolvements != null) {
			sc.add(resolvements);
		}
		sc.add("if (" + expressionToBeSet + " != null) {");
		final String featureConstant = generatorUtil.getFeatureConstant(genClass, genFeature);
		generatorUtil.addCodeToSetFeature(sc, genClass, featureConstant, eFeature, expressionToBeSet, isContainment, true);
		sc.add("}");
		sc.add("collectHiddenTokens(element);");
		sc.add("retrieveLayoutInformation(element, " + grammarInformationProviderClassName + "." + nameUtil.getFieldName(terminal) + ", " + expressionToBeSet + ", true);");
		if (terminal instanceof Containment) {
			sc.add("copyLocalizationInfos(" + ident + ", element);");
		} else {
			sc.add("copyLocalizationInfos((" + COMMON_TOKEN(sc) + ") " + ident + ", element);");
			if (eFeature instanceof EReference) {
				// additionally set position information for the proxy instance
				sc.add("copyLocalizationInfos((" + COMMON_TOKEN(sc) + ") " + ident + ", " + proxyIdent + ");");
			}
		}

		sc.add("}");
		sc.add("}");
	}

	private void printImplicitChoiceRules(StringComposite sc,
			EList<GenClass> eClassesWithSyntax,
			Map<GenClass,Collection<Terminal>> eClassesReferenced) {
		
		for (GenClass referencedClass : eClassesReferenced.keySet()) {
			if (!genClassCache.containsEqualByName(eClassesWithSyntax, referencedClass)) {
				// rule not explicitly defined in CS: most likely a choice rule
				// in the AS
				//Expression slices are formed over a common abstract superclass
				//TODO handle genClass prefixes too
				boolean isCommonExpressionMetaClass = !concreteSyntax.getOperatorRuleSubset(referencedClass.getName()).isEmpty(); 
				if (printImplicitChoiceRule(sc, referencedClass, isCommonExpressionMetaClass)) {
					eClassesWithSyntax.add(referencedClass);
				}
			}
		}
		
		// We check if there are start symbols referencing an expression metaclass which has not 
		// a grammar rule yet
		for (GenClass referencedClass : concreteSyntax.getStartSymbols()){
			boolean isCommonExpressionMetaClass = !concreteSyntax.getOperatorRuleSubset(referencedClass.getName()).isEmpty(); 
			// TODO handle genClass prefixes too
			if (isCommonExpressionMetaClass && !genClassCache.containsEqualByName(eClassesWithSyntax, referencedClass)) {
				if (printImplicitChoiceRule(sc, referencedClass, isCommonExpressionMetaClass)) {
					eClassesWithSyntax.add(referencedClass);
				}
			}
		}
	}
	
	private boolean printImplicitChoiceRule(StringComposite sc,
			GenClass referencedClass, boolean isCommonExpressionMetaClass) {
		Collection<GenClass> subClasses = concreteSyntax
				.getSubClassesWithSyntax(referencedClass,
						true);

		if (!subClasses.isEmpty() || isCommonExpressionMetaClass) {
			sc.add(getRuleName(referencedClass));
			String metaclassName = genClassCache.getQualifiedInterfaceName(referencedClass);
			sc.add(" returns [" + metaclassName + " element = null]");
			sc.add(":");
			if (!isCommonExpressionMetaClass) {
	printSubClassOrPrimitiveOperatorChoices(sc, subClasses);
			} else {
				List<Rule> slice = concreteSyntax.getOperatorRuleSubset(referencedClass.getName());
				sc.add("c = " + getExpressionSliceRuleName(slice.get(0)) + "{ element = c; /* this rule is an expression root */ }");
			}
				
			sc.addLineBreak();
			sc.add(";");
			sc.addLineBreak();

			return true;
		}
		return false;
	}

	private void printSubClassOrPrimitiveOperatorChoices(StringComposite sc,
			Collection<GenClass> subClasses) {
		int count = 0;
		Iterator<GenClass> subClassIterator = subClasses.iterator();
		while (subClassIterator.hasNext()) {
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

		boolean isKeyword = isKeyword(definition);
		
		// We do need to add additional parenthesis explicitly, because otherwise
		// the channel instruction is applied only to the last alternative if the
		// regular expression has multiple alternatives.
		// But, we must not add the parenthesis if the token is used as in-line 
		// keyword, because then ANTLR does not recognize that the defined token
		// and the in-line keyword are actually the same.
		if (isKeyword) {
			sc.add(definition.getRegex());
		} else {
			sc.add("(" + definition.getRegex() + ")");
		}
		
		// Keyword tokens do never go to channel 99, because they
		// are contained in the grammar. if they are sent to channel
		// 99, rules containing the keywords will never be matched.
		if (definition.isHidden() && !isKeyword) {
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
}
