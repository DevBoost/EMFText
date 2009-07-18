/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_PROBLEM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BIT_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMMON_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DUMMY_E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EARLY_EXIT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_PROBLEM_TYPE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.FAILED_PREDICATE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ILLEGAL_ARGUMENT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_EXPECTED_ELEMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_LOCATION_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_OPTIONS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_RESOURCE;
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
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING_UTIL;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
import org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory;
import org.emftext.runtime.resource.impl.TokenResolveResult;
import org.emftext.runtime.resource.impl.UnexpectedContentTypeException;
import org.emftext.runtime.resource.impl.code_completion.ExpectedCsString;
import org.emftext.runtime.resource.impl.code_completion.ExpectedStructuralFeature;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.GenerationProblem.Severity;
import org.emftext.sdk.codegen.composites.ANTLRGrammarComposite;
import org.emftext.sdk.codegen.composites.StringComponent;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.syntax_analysis.LeftRecursionDetector;

/**
 * The text parser generator maps from one or more concrete syntaxes (*.cs) and 
 * one or more Ecore generator models to an ANTLR parser specification. 
 * If the derived specification does not contain syntactical conflicts which 
 * could break the ANTLR generation algorithm or the ANTLR parsing algorithm 
 * (e.g. ambiguities in the configuration or in token definitions which are 
 * not checked by this generator) it can be used to generate a text parser 
 * which allows to create model instances from plain text files.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class ANTLRGrammarGenerator extends BaseGenerator {

	/**
	 * The name of the EOF token which can be printed to force end of file after a parse from the root. 
	 */
	public static final String EOF_TOKEN_NAME = "EOF";
	
	private static final GenClassUtil genClassUtil = new GenClassUtil();

	private ConcreteSyntax concreteSyntax;
	private String tokenResolverFactoryName;
	
	/**
	 * A map that projects the fully qualified name of generator classes to 
	 * the set of fully qualified names of all their super classes. 
	 */
	private Map<String, Collection<String>> genClassNames2superClassNames;
	private Collection<GenClass> allGenClasses;
	
	private boolean forceEOFToken;
	private GenClassFinder genClassFinder = new GenClassFinder();

	private GenerationContext context;

	private GeneratorUtil generatorUtil = new GeneratorUtil();

	public ANTLRGrammarGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getCapitalizedConcreteSyntaxName());
		this.context = context;
		concreteSyntax = context.getConcreteSyntax();
		tokenResolverFactoryName = context.getTokenResolverFactoryClassName();
	}
	
	private void initOptions() {
		forceEOFToken = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.FORCE_EOF);
	}
	
	private void initCaches(){
	    allGenClasses = genClassFinder.findAllGenClasses(concreteSyntax, true, true);
	    genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses);
	}
	
	public boolean generate(PrintWriter writer){
		initOptions();
		initCaches();
		
        String csName = getResourceClassName();
        String lexerName = getLexerName(csName);
        String parserName = getParserName(csName);
        boolean backtracking = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.ANTLR_BACKTRACKING);
        boolean memoize = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.ANTLR_MEMOIZE);
                
        StringComposite sc = new ANTLRGrammarComposite();

        sc.add("grammar " + csName + ";");
        sc.addLineBreak();
        
        sc.add("options {");
        sc.add("superClass = " + AbstractEMFTextParser.class.getSimpleName() + ";");
        sc.add("backtrack = " + backtracking + ";");
        sc.add("memoize = " + memoize + ";");
        sc.add("}");
        sc.addLineBreak();
        
        //the lexer: package definition and error handling
        sc.add("@lexer::header {");
        sc.add("package " + super.getResourcePackageName() + ";");
        sc.add("}");
        sc.addLineBreak();
        
        sc.add("@lexer::members {");
        sc.add("public " + LIST + "<" + RECOGNITION_EXCEPTION + "> lexerExceptions  = new " + ARRAY_LIST + "<" + RECOGNITION_EXCEPTION + ">();");
        sc.add("public " + LIST + "<" + INTEGER + "> lexerExceptionsPosition       = new " + ARRAY_LIST + "<" + INTEGER + ">();");
        sc.addLineBreak();
        sc.add("public void reportError(" + RECOGNITION_EXCEPTION + " e) {"); 
        sc.add("lexerExceptions.add(e);"); 
        sc.add("lexerExceptionsPosition.add(((" + ANTLRStringStream.class.getName() + ") input).index());");
        sc.add("}");
        sc.add("}");
        
        //the parser: package definition and entry (doParse) method 
        sc.add("@header{");
        sc.add("package " + super.getResourcePackageName() + ";");
        sc.addLineBreak();
        
        printDefaultImports(sc);
        
        sc.add("}");
        sc.addLineBreak();
        
        sc.add("@members{");  
        addFields(sc);
        sc.addLineBreak();
        addMethods(lexerName, parserName, sc);
        sc.add("}");
        sc.addLineBreak();
        
        addRules(sc);
	    addTokenDefinitions(sc);
	    
	    writer.print(sc.toString());
	    return getCollectedErrors().size() == 0;
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
		addAddErrorToResourceMethod(sc);
		addAddExpectedElementMethod(sc);
		generatorUtil.addAddMapEntryMethod(sc);
		generatorUtil.addAddObjectToListMethod(sc);
		addApplyMethod(sc);
		addCollectHiddenTokensMethod(lexerName, sc);
		addCopyLocalizationInfosMethod1(sc);
		addCopyLocalizationInfosMethod2(sc);
		addCreateInstanceMethod(lexerName, parserName, sc);
		addDefaultConstructor(parserName, sc);
		addDoParseMethod(lexerName, sc);
		generatorUtil.addGetFreshTokenResolveResultMethod(sc);
		addGetMismatchedTokenRecoveryTriesMethod(sc);
		addGetMissingSymbolMethod(sc);
		addGetOptionsMethod(sc);
		addGetParseToIndexTypeObjectMethod(sc);
		generatorUtil.addGetReferenceResolverSwitchMethod(context, sc);
		addGetTextResourceMethod(sc);
		addGetTypeObjectMethod(sc);
		addParseMethod(sc);
		addParseToExpectedElementsMethod(sc);
		addRecoverFromMismatchedTokenMethod(sc);
		generatorUtil.addRegisterContextDependentProxyMethod(sc);
		addReportErrorMethod(sc);
		addReportLexicalErrorsMethod(sc);
		addSetOptionsMethod(sc);
		addSetTextResourceMethod(sc);
	}

	private void addGetMissingSymbolMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " getMissingSymbol(" + INT_STREAM + " arg0, " + RECOGNITION_EXCEPTION + " arg1, int arg2, " + BIT_SET + " arg3) {");
		sc.add("mismatchedTokenRecoveryTries++;");
		/*
		sc.add("// redirect error stream to suppress 'BR.recoverFromMismatchedToken' message");
		sc.add("PrintStream originalErr = System.err;");
		sc.add("try{");
		sc.add("System.setErr(new PrintStream(new ByteArrayOutputStream()));");
		sc.add("return super.getMissingSymbol(arg0, arg1, arg2, arg3);			");
		sc.add("}");
		sc.add("finally{");
		sc.add("System.setErr(originalErr);			");
		sc.add("}");
		*/
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
		sc.add("public void reportLexicalError(" + RECOGNITION_EXCEPTION + " e)  {");
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
		sc.add("" + MISMATCHED_SET_EXCEPTION + " mse = (" + MISMATCHED_SET_EXCEPTION + ") e;");
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
		sc.add("final " + STRING + " finalMessage = message;");
		sc.add("resource.addProblem(");
		sc.add("new " + ABSTRACT_PROBLEM + "() {");
		sc.add("");
		sc.add("public " + E_PROBLEM_TYPE + " getType() {");
		sc.add("return " + E_PROBLEM_TYPE + ".ERROR;");
		sc.add("}");
		sc.add("");
		sc.add("public " + STRING + " getMessage() {");
		sc.add("return finalMessage;");
		sc.add("}");
		sc.add("}, e.index,e.line,lexerExceptionsPosition.get(lexerExceptions.indexOf(e)),lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReportErrorMethod(StringComposite sc) {
		sc.add("// Translates errors thrown by the parser into human readable messages.");
		sc.add("public void reportError(" + RECOGNITION_EXCEPTION + " e)  {");
		sc.add(STRING + " message = e.getMessage();");
		sc.add("if (e instanceof " + MISMATCHED_TOKEN_EXCEPTION + ") {");
		sc.add(MISMATCHED_TOKEN_EXCEPTION + " mte = (" + MISMATCHED_TOKEN_EXCEPTION + ") e;");
		sc.add(STRING + " tokenName = \"<unknown>\";");
		sc.add("if (mte.expecting == Token.EOF) {");
		sc.add("tokenName = \"EOF\";");
		sc.add("} else {");
		sc.add("tokenName = getTokenNames()[mte.expecting];");
		sc.add("tokenName = " + STRING_UTIL + ".formatTokenName(tokenName);");
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
		sc.add("" + MISMATCHED_NOT_SET_EXCEPTION + " mse = (" + MISMATCHED_NOT_SET_EXCEPTION + ") e;");
		sc.add("message = \"mismatched token: \" +  e.token + \"; expecting set \" + mse.expecting;");
		sc.add("} else if (e instanceof " + FAILED_PREDICATE_EXCEPTION + ") {");
		sc.add(FAILED_PREDICATE_EXCEPTION + " fpe = (" + FAILED_PREDICATE_EXCEPTION + ") e;");
		sc.add("message = \"rule \" + fpe.ruleName + \" failed predicate: {\" +  fpe.predicateText+\"}?\";");
		sc.add("}");
		sc.add("// the resource may be null if the parse is used for code completion");
		sc.add("final " + STRING + " finalMessage = message;");
		sc.add("if (resource != null) {");
		sc.add("if (e.token instanceof " + COMMON_TOKEN + ") {");
		sc.add(COMMON_TOKEN + " ct = (" + COMMON_TOKEN + ") e.token;");
		sc.add("resource.addProblem(");
		sc.add("new " + ABSTRACT_PROBLEM + "() {");
		sc.add("public " + E_PROBLEM_TYPE + " getType() {");
		sc.add("return " + E_PROBLEM_TYPE + ".ERROR;");
		sc.add("}");
		sc.add("public " + STRING + " getMessage() {");
		sc.add("return finalMessage;");
		sc.add("}");
		sc.add("}, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());");
		sc.add("} else {");
		sc.add("resource.addProblem(");
		sc.add("new " + ABSTRACT_PROBLEM + "() {");
		sc.add("public " + E_PROBLEM_TYPE + " getType() {");
		sc.add("return " + E_PROBLEM_TYPE + ".ERROR;");
		sc.add("}");
		sc.add("public " + STRING + " getMessage() {");
		sc.add("return finalMessage;");
		sc.add("}");
		sc.add("},");
		sc.add("e.token.getCharPositionInLine(), e.token.getLine(), 1, 5); // TODO what the heck is this 5?");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseMethod(StringComposite sc) {
		sc.add("// Implementation that calls {@link #doParse()}  and handles the thrown");
		sc.add("// RecognitionExceptions.");
		sc.add("public " + E_OBJECT + " parse() {");
		sc.add("try {");
		sc.add(E_OBJECT + " result =  doParse();");
		sc.add("if (lexerExceptions.isEmpty()) {");
		sc.add("return result;");
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
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTextResourceMethod(StringComposite sc) {
		sc.add("public " + I_TEXT_RESOURCE + " getResource() {");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetTextResourceMethod(StringComposite sc) {
		sc.add("public void setResource(" + I_TEXT_RESOURCE + " resource) {");
		sc.add("this.resource = resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addApplyMethod(StringComposite sc) {
		sc.add("protected " + E_OBJECT + " apply(" + E_OBJECT + " target, " + LIST + "<" + E_OBJECT + "> dummyEObjects) {");
		sc.add(E_OBJECT + " currentTarget = target;");
		sc.add("for (" + E_OBJECT + " object : dummyEObjects) {");
		sc.add("assert(object instanceof " + DUMMY_E_OBJECT + ");");
		sc.add(DUMMY_E_OBJECT + " dummy = (" + DUMMY_E_OBJECT + ") object;");
		sc.add(E_OBJECT + " newEObject = dummy.applyTo(currentTarget);");
		sc.add("currentTarget = newEObject;");
		sc.add("}");
		sc.add("return currentTarget;");
		sc.add("}");
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
		sc.add("protected java.lang.Object getTypeObject() {");
        sc.add("java.lang.Object typeObject = getParseToIndexTypeObject();");
        sc.add("if (typeObject != null) {");
        	sc.add("return typeObject;");
    	sc.add("}");
        sc.add(Map.class.getName() + "<?,?> options = getOptions();");
        sc.add("if (options != null) {");
        	sc.add("typeObject = options.get(" + I_OPTIONS + ".RESOURCE_CONTENT_TYPE);");
        sc.add("}");
        sc.add("return typeObject;");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addDoParseMethod(String lexerName, StringComposite sc) {
		sc.add("protected " + E_OBJECT + " doParse() throws " + RECOGNITION_EXCEPTION + " {");
        sc.add(new StringComponent("lastPosition = 0;", "lastPosition"));
		sc.add("((" + lexerName + ") getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;"); //required because the lexer class can not be subclassed
        sc.add("((" + lexerName + ") getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;"); //required because the lexer class can not be subclassed

   		sc.add("java.lang.Object typeObject = getTypeObject();");
   		sc.add("if (typeObject == null) {");
   			sc.add("return start();");
   		sc.add("} else if (typeObject instanceof " + E_CLASS + ") {");
   			sc.add(E_CLASS + " type = (" + E_CLASS + ") typeObject;");
   			for (Rule rule : concreteSyntax.getAllRules()) {
   				String qualifiedClassName = rule.getMetaclass().getQualifiedInterfaceName();
   				String ruleName = getRuleName(rule.getMetaclass());
   				sc.add("if (type.getInstanceClass() == " + qualifiedClassName +".class) {");
   				sc.add("return " + ruleName + "();");
   				sc.add("}");
   			}
		sc.add("}");
		sc.add("throw new " + UnexpectedContentTypeException.class.getName() + "(typeObject);");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCollectHiddenTokensMethod(String lexerName,
			StringComposite sc) {
		List<TokenDefinition> collectTokenDefinitions = collectCollectTokenDefinitions(concreteSyntax.getActiveTokens());
        sc.add("protected void collectHiddenTokens(" + E_OBJECT + " element) {");
        if (!collectTokenDefinitions.isEmpty()) {          
            //sc.add("System.out.println(\"collectHiddenTokens(\" + element.getClass().getSimpleName() + \", \" + o + \") \");");
            sc.add("int currentPos = getTokenStream().index();");
            sc.add("if (currentPos == 0) {");
            sc.add("return;");
            sc.add("}");
            sc.add("int endPos = currentPos - 1;");
            sc.add("for (; endPos >= lastPosition; endPos--) {");
            sc.add(org.antlr.runtime.Token.class.getName() + " token = getTokenStream().get(endPos);");
            sc.add("int _channel = token.getChannel();");
            sc.add("if (_channel != 99) {");
            sc.add("break;");
            sc.add("}");
            sc.add("}");
            sc.add("for (int pos = lastPosition; pos < endPos; pos++) {");
            sc.add(org.antlr.runtime.Token.class.getName() + " token = getTokenStream().get(pos);");
            sc.add("int _channel = token.getChannel();");
            sc.add("if (_channel == 99) {");
            //sc.add("System.out.println(\"\t\" + token);");

            for (TokenDefinition tokenDefinition : collectTokenDefinitions) {
        		String attributeName = tokenDefinition.getAttributeName();
    	        // figure out which feature the token belongs to
    			sc.add("if (token.getType() == " + lexerName + "." + tokenDefinition.getName() + ") {");
    			// Unfortunately, we must use the feature name instead of the constant here,
    			// because collect-in tokens can be stored in arbitrary classes. Therefore, 
    			// we do not know the EClass of the element at generation time.
    	        sc.add(EStructuralFeature.class.getName() + " feature = element.eClass().getEStructuralFeature(\"" + attributeName + "\");");
    	        sc.add("if (feature != null) {");
    	        sc.add("// call token resolver");
    	        
    			String identifierPrefix = "resolved";
    			String resolverIdentifier = identifierPrefix + "Resolver";
    			String resolvedObjectIdentifier = identifierPrefix + "Object";
    			String resolveResultIdentifier = identifierPrefix + "Result";
    			
    			sc.add(ITokenResolver.class.getName() + " " + resolverIdentifier +" = tokenResolverFactory.createCollectInTokenResolver(\"" + attributeName + "\");");
    			sc.add(resolverIdentifier +".setOptions(getOptions());");
    			sc.add(ITokenResolveResult.class.getName() + " " + resolveResultIdentifier + " = getFreshTokenResolveResult();"); 
    			sc.add(resolverIdentifier + ".resolve(token.getText(), feature, " + resolveResultIdentifier + ");");
    			sc.add(OBJECT + " " + resolvedObjectIdentifier + " = " + resolveResultIdentifier + ".getResolvedToken();");
    			sc.add("if (" + resolvedObjectIdentifier + " == null) {");
    			sc.add("addErrorToResource(" + resolveResultIdentifier + ".getErrorMessage(), ((" + COMMON_TOKEN + ") token).getLine(), ((" + COMMON_TOKEN + ") token).getCharPositionInLine(), ((" + COMMON_TOKEN + ") token).getStartIndex(), ((" + COMMON_TOKEN + ") token).getStopIndex());\n");
    			sc.add("}");
    			sc.add("if (java.lang.String.class.isInstance(" + resolvedObjectIdentifier + ")) {");
    	        sc.add("((" + LIST + ") element.eGet(feature)).add((java.lang.String) " + resolvedObjectIdentifier + ");");
    	        sc.add("} else {");
    	        sc.add("System.out.println(\"WARNING: Attribute " + attributeName + " for token \" + token + \" has wrong type in element \" + element + \" (expected java.lang.String).\");");
    	        sc.add("}");
    	        sc.add("} else {");
    	        sc.add("System.out.println(\"WARNING: Attribute " + attributeName + " for token \" + token + \" was not found in element \" + element + \".\");");
    	        sc.add("}");
    			sc.add("}");
            }

            sc.add("}");
            sc.add("}");
            sc.add("lastPosition = (endPos < 0 ? 0 : endPos);");
        }   
        sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateInstanceMethod(String lexerName, String parserName,
			StringComposite sc) {
		sc.add("public " + ITextParser.class.getName() + " createInstance(" + InputStream.class.getName() + " actualInputStream, " + String.class.getName() + " encoding) {");
		sc.add("try {");
		sc.add("if (encoding == null) {");
		sc.add("return new " + parserName + "(new " + CommonTokenStream.class.getName() + "(new " + lexerName + "(new " + ANTLRInputStream.class.getName() + "(actualInputStream))));");
		sc.add("} else {");
		sc.add("return new " + parserName + "(new " + CommonTokenStream.class.getName() + "(new " + lexerName + "(new " + ANTLRInputStream.class.getName() + "(actualInputStream, encoding))));");
		sc.add("}");
		sc.add("} catch (" + IOException.class.getName() + " e) {");
		sc.add(EMFTextRuntimePlugin.class.getName() + ".logError(\"Error while creating parser.\", e);");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + ITokenResolverFactory.class.getName() + " tokenResolverFactory = new " + tokenResolverFactoryName + "();");
		sc.add(new StringComponent("private int lastPosition;", "lastPosition"));
		sc.add("private " + TokenResolveResult.class.getName() + " tokenResolveResult = new " + TokenResolveResult.class.getName() + "();");
		sc.add("private boolean rememberExpectedElements = false;");
		sc.add("private " + OBJECT + " parseToIndexTypeObject;");
		sc.add("private int lastTokenIndex = 0;");
		sc.add("private boolean reachedIndex = false;");
		sc.add("private " + LIST + "<" + I_EXPECTED_ELEMENT + "> expectedElements = new " + ARRAY_LIST + "<" + I_EXPECTED_ELEMENT + ">();");
		sc.add("private int lastIndex = -1;");
		sc.add("private int mismatchedTokenRecoveryTries = 0;");
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private " + I_TEXT_RESOURCE + " resource;");
		sc.add("//helper lists to allow a lexer to pass errors to its parser");
		sc.add("protected " + LIST + "<" + RECOGNITION_EXCEPTION + "> lexerExceptions = " + COLLECTIONS + ".synchronizedList(new " + ARRAY_LIST + "<" + RECOGNITION_EXCEPTION + ">());");
		sc.add("protected " + LIST + "<" + INTEGER + "> lexerExceptionsPosition = " + COLLECTIONS + ".synchronizedList(new " + ARRAY_LIST + "<" + INTEGER + ">());");
	}

	private void addParseToExpectedElementsMethod(StringComposite sc) {
		sc.add("public " + LIST + "<" + I_EXPECTED_ELEMENT + "> parseToExpectedElements("
				+ E_CLASS + " type) {");
		sc.add("rememberExpectedElements = true;");
		sc.add("parseToIndexTypeObject = type;");
		sc.add("parse();");
		sc.add("return this.expectedElements;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddErrorToResourceMethod(StringComposite sc) {
		sc.add("protected void addErrorToResource(final " + STRING + " errorMessage, int line,");
		sc.add("int charPositionInLine, int startIndex, int stopIndex) {");
		sc.add(I_TEXT_RESOURCE + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("resource.addProblem(new " + ABSTRACT_PROBLEM + "() {");
		sc.add("public " + E_PROBLEM_TYPE + " getType() {");
		sc.add("return " + E_PROBLEM_TYPE + ".ERROR;");
		sc.add("}");
		sc.add("public " + STRING + " getMessage() {");
		sc.add("return errorMessage;");
		sc.add("}");
		sc.add("}, line, charPositionInLine, startIndex, stopIndex);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCopyLocalizationInfosMethod1(StringComposite sc) {
		sc.add("protected void copyLocalizationInfos(" + E_OBJECT + " source, " + E_OBJECT + " target) {");
		sc.add(I_TEXT_RESOURCE + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + I_LOCATION_MAP + " locationMap = resource.getLocationMap();");
		sc.add("locationMap.setCharStart(target, locationMap.getCharStart(source));");
		sc.add("locationMap.setCharEnd(target, locationMap.getCharEnd(source));");
		sc.add("locationMap.setColumn(target, locationMap.getColumn(source));");
		sc.add("locationMap.setLine(target, locationMap.getLine(source));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCopyLocalizationInfosMethod2(StringComposite sc) {
		sc.add("protected void copyLocalizationInfos(" + COMMON_TOKEN + " source, " + E_OBJECT + " target) {");
		sc.add(I_TEXT_RESOURCE + " resource = getResource();");
		sc.add("if (resource == null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + I_LOCATION_MAP + " locationMap = resource.getLocationMap();");
		sc.add("locationMap.setCharStart(target, source.getStartIndex());");
		sc.add("locationMap.setCharEnd(target, source.getStopIndex());");
		sc.add("locationMap.setColumn(target, source.getCharPositionInLine());");
		sc.add("locationMap.setLine(target, source.getLine());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddExpectedElementMethod(StringComposite sc) {
		sc.add("public void addExpectedElement(" + I_EXPECTED_ELEMENT + " expectedElement, " + OBJECT + " match) {");
		sc.add("if (!this.rememberExpectedElements) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (this.reachedIndex) {");
		sc.add("return;");
		sc.add("}");
		sc.add("int currentTokenIndex = " + MATH + ".max(0, input.index());");
		sc.add("int currentIndex = lastIndex == " + INTEGER + ".MAX_VALUE ? " + INTEGER + ".MAX_VALUE : (lastIndex + 1);");
		sc.add("int startIncludingHidden = -1;");
		sc.add("int startExcludingHidden = -1;");
		sc.add("int endIncludingHidden = " + INTEGER + ".MAX_VALUE;");
		sc.add("int endExcludingHidden = " + INTEGER + ".MAX_VALUE;");
		sc.add("for (int index = lastTokenIndex; index < currentTokenIndex; index++) {");
		sc.add(COMMON_TOKEN + " tokenAtIndex = (" + COMMON_TOKEN + ") input.get(index);");
		sc.add("if (tokenAtIndex.getChannel() == 99) {");
		sc.add("startIncludingHidden = tokenAtIndex.getStartIndex();");
		sc.add("endIncludingHidden = tokenAtIndex.getStopIndex();");
		sc.add("} else {");
		sc.add("startExcludingHidden = tokenAtIndex.getStartIndex();");
		sc.add("endExcludingHidden = tokenAtIndex.getStopIndex();");
		sc.add("}");
		sc.add("}");
		sc.add("startIncludingHidden = " + MATH + ".max(startIncludingHidden, currentIndex);");
		sc.add("startExcludingHidden = " + MATH + ".max(startExcludingHidden, currentIndex);");
		sc.add("lastTokenIndex = " + MATH + ".max(0, currentTokenIndex);");
		sc.add("expectedElement.setPosition(startIncludingHidden,  startExcludingHidden, endIncludingHidden, endExcludingHidden);");
		sc.add("this.lastIndex = endIncludingHidden;");
		sc.add("this.expectedElements.add(expectedElement);");
		sc.add("}");
		sc.add("");
	}

	private void addGetParseToIndexTypeObjectMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " getParseToIndexTypeObject() {");
		sc.add("return parseToIndexTypeObject;");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addRecoverFromMismatchedTokenMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " recoverFromMismatchedToken(" + INT_STREAM + " input, int ttype, " + BIT_SET + " follow) throws " + RECOGNITION_EXCEPTION + " {");
		sc.add("if (!rememberExpectedElements) {");
		sc.add("return super.recoverFromMismatchedToken(input, ttype, follow);");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
	}
	
	private List<TokenDefinition> collectCollectTokenDefinitions(List<TokenDefinition> tokenDefinitions){
		List<TokenDefinition> collectList = new LinkedList<TokenDefinition>();		
		for(TokenDefinition tokenDefinition:tokenDefinitions){
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
	
	private void printStartRule(StringComposite sc){
	       //do the start symbol rule
        sc.add("start ");
        sc.add("returns [ " + E_OBJECT + " element = null]");
        sc.add(":");
    	sc.add("(");
        int count = 0;
        for (Iterator<GenClass> i = concreteSyntax.getActiveStartSymbols().iterator(); i.hasNext(); ) {
            GenClass aStart = i.next();
            sc.add("c" + count + " = " + getRuleName(aStart) + "{ element = c" + count + "; }"); 
            if (i.hasNext()) { 
            	sc.add("|  ");
            }
            count++;
        }
    	sc.add(")");
        if (forceEOFToken) {
        	sc.add(EOF_TOKEN_NAME);
        }
        sc.addLineBreak();
        sc.add(";");
        sc.addLineBreak();
	}
	
	private void printRightRecursion(StringComposite sc, Rule rule, EList<GenClass> eClassesWithSyntax, Map<GenClass, Collection<Terminal>> classesReferenced) {
		
		String ruleName = getRuleName(rule.getMetaclass());
		GenClass recursiveType = rule.getMetaclass();
		
		{	
			Copier copier = new Copier(true, true);
			Rule ruleCopy = (Rule) copier.copy(rule);
			copier.copyReferences();	    
			
	 
	        
	        sc.add(ruleName);
	        sc.add(" returns [" + recursiveType.getQualifiedInterfaceName() + " element = null]");
	        sc.add("@init{");
			sc.add("element = " + genClassUtil.getCreateObjectCall(recursiveType) + ";");
	        sc.add("collectHiddenTokens(element);");
	        sc.add(LIST + "<" + E_OBJECT + "> dummyEObjects  = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
	        sc.add("}");
	        sc.add(":");
	       
	        Choice choice = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createChoice();
	        
	        Sequence newSequence = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createSequence();
	        Choice reducedChoice = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createChoice();
	        
	        CompoundDefinition compound = ConcretesyntaxPackage.eINSTANCE.getConcretesyntaxFactory().createCompoundDefinition();
	        compound.setDefinitions(reducedChoice);
	        newSequence.getParts().add(compound);
	        
	        choice.getOptions().add(newSequence);
	        List<Sequence> recursionFreeSequences = new ArrayList<Sequence>();
	        
	        LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, concreteSyntax);
	        
	        for (Sequence sequence : ruleCopy.getDefinition().getOptions()) {
	        	Rule leftProducingRule = lrd.findLeftProducingRule(rule.getMetaclass(), sequence, rule);
	        	if (leftProducingRule == null) {
	        		recursionFreeSequences.add(sequence);
	 			}	
			}
	        reducedChoice.getOptions().addAll(recursionFreeSequences);
	        
	        ruleCopy.setDefinition(choice);
	        
	        printChoice(ruleCopy.getDefinition(), ruleCopy, sc, 0, classesReferenced);
	        
	        sc.add(" ( dummyEObject = "+ ruleName +  "_tail { dummyEObjects.add(dummyEObject);} )*");
	        sc.add("{");
	        sc.add("element = (" + ruleName+ ") apply(element, dummyEObjects);");
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
						Containment c = (Containment) definition;
						GenClass featureType = c.getFeature().getTypeGenClass();
						if (recursiveType.equals(featureType) || 
								genClassNames2superClassNames.get(featureType.getQualifiedInterfaceName()).contains(recursiveType.getQualifiedInterfaceName()) ||
								genClassNames2superClassNames.get(recursiveType.getQualifiedInterfaceName()).contains(featureType.getQualifiedInterfaceName())) {
							indexRecurse = parts.indexOf(definition);	
							recurseName = c.getFeature().getName();
							break;	
						}
					}
				}
				if (parts.size()-1 == indexRecurse ) {
					sequencesToRemove.add(sequence);
				} else {
					
					for (int i = 0; i <= indexRecurse; i++)	{
						parts.remove(i);
					}
				}
				
	        }
	        for (Sequence sequence : sequencesToRemove) {
				tailCopy.getDefinition().getOptions().remove(sequence);
			}
	        
	    	sc.add(ruleName +  "_tail");
	        sc.add(" returns [" + DUMMY_E_OBJECT + " element = null]");
	        sc.add("@init{");
	        sc.add("element = new " + DUMMY_E_OBJECT + "(" + genClassUtil.getCreateObjectCall(rule.getMetaclass()) + "()" +", \""+recurseName+"\");");
	        sc.add("collectHiddenTokens(element);");
	        sc.add("}");
	        sc.add(":");
	        
	        printChoice(tailCopy.getDefinition(), tailCopy, sc, 0, classesReferenced);
	        
	        sc.add(";");
	        sc.addLineBreak();
		}
	    eClassesWithSyntax.add(rule.getMetaclass());
	        
	}

	private void printGrammarRules(StringComposite sc, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced) {
        
		for (Rule rule : concreteSyntax.getAllRules()) {
			
        	LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, concreteSyntax);
        	Rule recursionRule = lrd.findLeftRecursion(rule);
            if (recursionRule != null) {
                boolean autofix = OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);
            	if(lrd.isDirectLeftRecursive(rule)) {// direct left recursion
            		if (autofix) {
                    	printRightRecursion(sc, rule, eClassesWithSyntax, eClassesReferenced);	
    					
    					Collection<GenClass> subClasses = generatorUtil.getSubClassesWithSyntax(rule.getMetaclass(), concreteSyntax);
                        if(!subClasses.isEmpty()){
                        	sc.add("|//derived choice rules for sub-classes: ");
                        	printSubClassChoices(sc,subClasses);
                        	sc.addLineBreak();
                        }
                        
                        String message = "Applied experimental autofix: Rule \"" +  rule.getMetaclass().getName() + "\" is direct left recursive by rule \"" + recursionRule.getMetaclass().getName() + 
                    	"\".";
                    	GenerationProblem generationWarning = new GenerationProblem(message, rule, Severity.WARNING);
                		addProblem(generationWarning);
                		continue;
            		}
            		else {
            			String message = "Warning: Rule \"" +  rule.getMetaclass().getName() + "\" is direct left recursive by rule \"" + recursionRule.getMetaclass().getName() + "\".";
                  		GenerationProblem generationWarning = new GenerationProblem(message, rule, Severity.WARNING);
                  		addProblem(generationWarning);
                		printGrammarRule(rule, sc, eClassesWithSyntax, eClassesReferenced);
            		}
            	}
            	else {
            		String message = "Rule \"" +  rule.getMetaclass().getName() + "\" is mutual left recursive by rule \"" + recursionRule.getMetaclass().getName()+"\"! Please restructure the grammar.";
            		GenerationProblem generationWarning = new GenerationProblem(message, rule, Severity.WARNING);
              		addProblem(generationWarning);
            		printGrammarRule(rule, sc, eClassesWithSyntax, eClassesReferenced);
            	}
            
            }
            else {
            	printGrammarRule(rule, sc, eClassesWithSyntax, eClassesReferenced);
            }
        }
	}
	
   
	private void printGrammarRule(Rule rule, StringComposite sc, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced) {
		GenClass genClass = rule.getMetaclass();
		
	    String ruleName = getRuleName(genClass);
		String qualifiedClassName = genClass.getQualifiedInterfaceName();
        
        sc.add(ruleName);
		if (Map.Entry.class.getName().equals(genClass.getEcoreClass().getInstanceClassName())) {
			sc.add(" returns [" + DUMMY_E_OBJECT + " element = null]");
		} else {
			sc.add(" returns [" + qualifiedClassName + " element = null]");
		}
        
        sc.add("@init{");
        sc.add("}");
        sc.add(":");
        
        printChoice(rule.getDefinition(), rule, sc, 0, eClassesReferenced);
        
        Collection<GenClass> subClasses = generatorUtil.getSubClassesWithSyntax(genClass, concreteSyntax);
        if(!subClasses.isEmpty()){
        	sc.add("|//derived choice rules for sub-classes: ");
        	sc.addLineBreak();
        	printSubClassChoices(sc,subClasses);
        	sc.addLineBreak();
        }
    
        sc.add(";");
    	sc.addLineBreak();
        
        eClassesWithSyntax.add(genClass);
	}

	private String getRuleName(GenClass genClass) {
		String interfaceName = genClass.getQualifiedInterfaceName();
		String ruleName = interfaceName.replace("_", "_005F");
		ruleName = ruleName.replace(".", "_");
		return "parse_" + ruleName;
	}

	private int printChoice(Choice choice, Rule rule, StringComposite sc, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced) {
    	Iterator<Sequence> it = choice.getOptions().iterator();
    	while(it.hasNext()){
    		Sequence seq = it.next();
            count = printSequence(seq, rule, sc, count, eClassesReferenced);
            if(it.hasNext()){
            	sc.addLineBreak();
            	sc.add("|");
            }
    	}
        return count;
    }
	
    private int printSequence(Sequence sequence, Rule rule, StringComposite sc, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced) {
    	Iterator<Definition> it = sequence.getParts().iterator();
    	while(it.hasNext()){
    		Definition def = it.next();
    		if(def instanceof LineBreak || def instanceof WhiteSpaces)
    			continue;
    		String cardinality = computeCardinalityString(def);
    		if(cardinality!=null){
    			sc.add("(");
    		}
    		if(def instanceof CompoundDefinition){
            	CompoundDefinition compoundDef = (CompoundDefinition) def;
                sc.add("(");
                count = printChoice(compoundDef.getDefinitions(), rule,sc, count, eClassesReferenced);
                sc.add(")");
    		}
    		else if(def instanceof CsString){
    			count = printCsString((CsString) def, rule, sc, count, eClassesReferenced);
    		}
    		else{
    			assert def instanceof Terminal;
    			count = printTerminal((Terminal) def, rule, sc, count, eClassesReferenced);
    		}
    		if(cardinality!=null){
    			sc.addLineBreak();
    			sc.add(")" + cardinality);
    		}
    		
    		sc.addLineBreak();
    	}
    	return count;
    }
    
    private int printCsString(CsString csString, Rule rule, StringComposite sc, int count, Map<GenClass,Collection<Terminal>> eClassesReferenced){
    	final String identifier = "a" + count;
    	final String escapedCsString = csString.getValue().replaceAll("'", "\\\\'");
		sc.add(identifier + " = '" + escapedCsString + "' {");
		// we must use the unicode representation for the % character, because
		// StringTemplate does treat % special
		sc.add("addExpectedElement(new " + ExpectedCsString.class.getName() + "(\"" + escapedCsString.replace("%", "\\u0025") + "\"), " + identifier + ");");
    	sc.add("if (element == null) {");
    	sc.add("element = " + genClassUtil.getCreateObjectCall(rule.getMetaclass()) + ";");
    	sc.add("}");
    	sc.add("collectHiddenTokens(element);");
    	sc.add("copyLocalizationInfos((CommonToken)" + identifier + ", element);");
    	sc.add("}"); 
    	return ++count;
    }
    
    private int printTerminal(Terminal terminal, Rule rule, StringComposite sc, int count,Map<GenClass,Collection<Terminal>> eClassesReferenced){
    	final GenClass genClass = rule.getMetaclass();
    	final GenFeature genFeature = terminal.getFeature();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();
		final String ident = "a" + count;
    	final String proxyIdent = "proxy";
    	
    	StringComposite resolvements = new ANTLRGrammarComposite();
    	
		sc.add("(");
    	
    	if(terminal instanceof Containment){
    		assert ((EReference)eFeature).isContainment(); 
    		Containment containment = (Containment) terminal;
    		
    		EList<GenClass> types; 
    		//is there an explicit type defined?
    		if (!containment.getTypes().isEmpty()) {
    			types = containment.getTypes();
    		}
    		else {
    			types = new BasicEList<GenClass>();
    			types.add(genFeature.getTypeGenClass());
    		}

    		int internalCount = 0;
    		for(GenClass type : types) {
    			if (internalCount != 0) {
    				sc.add("|");
    			}
    			
                String internalIdent = ident + "_" + internalCount;
    	    	sc.add(internalIdent + " = " + getRuleName(type)); 
                
                if(!(genFeature.getEcoreFeature() instanceof EAttribute)){
                    //remember which classes are referenced to add choice rules for these classes later
                    if (!eClassesReferenced.keySet().contains(type)) {
                      	eClassesReferenced.put(type, new HashSet<Terminal>());
                    }
                   
                    eClassesReferenced.get(type).add(terminal);            	
                }
                
            	printTerminalAction(terminal, rule, sc, genClass, genFeature,
        				eFeature, internalIdent, proxyIdent, internalIdent, resolvements, null);
            	
            	internalCount++;
    		}
    	} else {
    		assert terminal instanceof Placeholder;
    		Placeholder placeholder = (Placeholder) terminal;
    		TokenDefinition token = placeholder.getToken();
    		String tokenName = token.getName();
        	
        	sc.add(ident + " = " + tokenName);
        	sc.addLineBreak();
        	
        	String targetTypeName = null;
        	String resolvedIdent = "resolved";
        	String preResolved = resolvedIdent + "Object";
        	String resolverIdent = "tokenResolver";
           	resolvements.add(ITokenResolver.class.getName() + " " +resolverIdent +" = tokenResolverFactory.createTokenResolver(\"" + tokenName + "\");");
           	resolvements.add(resolverIdent +".setOptions(getOptions());");
           	resolvements.add(ITokenResolveResult.class.getName() + " result = getFreshTokenResolveResult();");
           	resolvements.add(resolverIdent + ".resolve(" +ident+ ".getText(), element.eClass().getEStructuralFeature(" + generatorUtil.getFeatureConstant(genClass, genFeature) + "), result);");
           	resolvements.add(OBJECT + " " + preResolved + " = result.getResolvedToken();");
           	resolvements.add("if (" + preResolved + " == null) {");
           	resolvements.add("addErrorToResource(result.getErrorMessage(), ((" + COMMON_TOKEN + ") " + ident + ").getLine(), ((" + COMMON_TOKEN + ") " + ident + ").getCharPositionInLine(), ((" + COMMON_TOKEN + ") " + ident + ").getStartIndex(), ((" + COMMON_TOKEN + ") " + ident + ").getStopIndex());");
           	resolvements.add("}");
        	
           	String expressionToBeSet = null;
           	
        	if (eFeature instanceof EReference) {
        		targetTypeName = "String";
        		expressionToBeSet = proxyIdent;
   
        		//a sub type that can be instantiated as a proxy
            	GenClass instanceType = genFeature.getTypeGenClass();
            	GenClass proxyType = null;
            	
            	if (genClassUtil.isNotConcrete(instanceType)) {
            		// TODO mseifert: replace this code with a call to class GenClassFinder
            		for(GenClass instanceCand : allGenClasses) {
            			Collection<String> supertypes = genClassNames2superClassNames.get(instanceCand.getQualifiedInterfaceName());		
            			if (genClassUtil.isConcrete(instanceCand) &&
            				supertypes.contains(instanceType.getQualifiedInterfaceName())) {
        	            	proxyType = instanceCand;
        	            	break;
        				}
            		}
            	} else {
            		proxyType = instanceType;
            	}
            	resolvements.add(targetTypeName + " " + resolvedIdent + " = (" + targetTypeName + ") "+preResolved+";");
            	resolvements.add(proxyType.getQualifiedInterfaceName() + " " + expressionToBeSet + " = " + genClassUtil.getCreateObjectCall(proxyType) + ";"); 
            	resolvements.add("collectHiddenTokens(element);");
            	resolvements.add("registerContextDependentProxy(new "+ ContextDependentURIFragmentFactory.class.getName() + "<" + genFeature.getGenClass().getQualifiedInterfaceName() + ", " + genFeature.getTypeGenClass().getQualifiedInterfaceName() + ">(" + context.getReferenceResolverAccessor(genFeature) + "), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(" + generatorUtil.getFeatureConstant(genClass, genFeature) + "), " + resolvedIdent + ", "+ proxyIdent + ");");
	           	// remember that we must resolve proxy objects for this feature
            	context.addNonContainmentReference(genFeature);
        	}
        	else{
        		// the feature is an EAttribute
       			targetTypeName = genFeature.getQualifiedListItemType(null);
               	resolvements.add(targetTypeName + " " + resolvedIdent + " = (" + getObjectTypeName(targetTypeName) + ")" + preResolved + ";");
        		expressionToBeSet = "resolved";
        	}
        	
        	printTerminalAction(placeholder, rule, sc, genClass, genFeature,
    				eFeature, ident, proxyIdent, expressionToBeSet, resolvements, tokenName);
        }
    	
		sc.add(")");
    	return ++count;	
    }

	private void printTerminalAction(Terminal terminal, Rule rule,
			StringComposite sc, final GenClass genClass,
			final GenFeature genFeature, final EStructuralFeature eFeature,
			final String ident, final String proxyIdent,
			String expressionToBeSet, StringComposite resolvements, String tokenName) {
		sc.add("{");
    	sc.add("if (element == null) {");
    	sc.add("element = " + genClassUtil.getCreateObjectCall(rule.getMetaclass()) + ";");
    	sc.add("}");
    	// TODO mseifert: escape tokeName correctly
    	sc.add("String tokenName = \"" + tokenName + "\";");
		sc.add("addExpectedElement(new "
				+ ExpectedStructuralFeature.class.getName() + "("
				+ genClass.getGenPackage().getReflectionPackageName() + "."
				+ genClass.getGenPackage().getPackageInterfaceName()
				+ ".eINSTANCE.get" + genClass.getClassifierAccessorName()
				+ "()" + ".getEStructuralFeature("
				+ generatorUtil.getFeatureConstant(genClass, genFeature)
				+ "), element, tokenName), " + ident + ");");
		sc.add("if (" + ident + " != null) {");
    	sc.add(resolvements);
		sc.add("if (" + expressionToBeSet + " != null) {");
		final String featureConstant = generatorUtil.getFeatureConstant(genClass, genFeature);
		generatorUtil.addCodeToSetFeature(sc, genClass, featureConstant, eFeature,
				expressionToBeSet);
		sc.add("}");
        sc.add("collectHiddenTokens(element);");
        if (terminal instanceof Containment) {
            sc.add("copyLocalizationInfos(" + ident + ", element); "); 
        } else {
            sc.add("copyLocalizationInfos((CommonToken) " + ident + ", element);"); 
            if (eFeature instanceof EReference) {
            	//additionally set position information for the proxy instance	
                sc.add("copyLocalizationInfos((CommonToken) " + ident + ", " + proxyIdent + ");"); 
            }
        }
    	
    	sc.add("}");
        sc.add("}");
	}

	private void printImplicitChoiceRules(StringComposite sc, EList<GenClass> eClassesWithSyntax, Map<GenClass,Collection<Terminal>> eClassesReferenced){

		for(GenClass referencedClass : eClassesReferenced.keySet()) {
			if(!containsEqualByName(eClassesWithSyntax,referencedClass)) {
				//rule not explicitly defined in CS: most likely a choice rule in the AS
				Collection<GenClass> subClasses = generatorUtil.getSubClassesWithSyntax(referencedClass, concreteSyntax);

				if (!subClasses.isEmpty()) {
					sc.add(getRuleName(referencedClass));
					sc.add(" returns [" + referencedClass.getQualifiedInterfaceName() + " element = null]");
					sc.add(":");
					printSubClassChoices(sc, subClasses);
					sc.addLineBreak();
					sc.add(";");
					sc.addLineBreak();

					eClassesWithSyntax.add(referencedClass);
				}
			}
		}	
	}
    
    private void printSubClassChoices(StringComposite sc, Collection<GenClass> subClasses){
        int count = 0;
        for(Iterator<GenClass> i = subClasses.iterator(); i.hasNext(); ) {
            GenClass subRef = i.next();
            sc.add("c" + count + " = " + getRuleName(subRef) + "{ element = c" + count + "; }"); 
            if (i.hasNext()) {
         	   sc.add("|");
            }
            count++;
        }
    }
    
 
      
    private boolean containsEqualByName(EList<GenClass> list, GenClass o){
    	for(GenClass entry:list){
     		EClass entryClass = entry.getEcoreClass();
     		EClass oClass = o.getEcoreClass();
     		if(entryClass.getName().equals(oClass.getName())&&entryClass.getEPackage().getNsURI().equals(oClass.getEPackage().getNsURI())){
     			return true;
     		}
    	}
    	return false;
    }
    
	private void addTokenDefinitions(StringComposite sc) {
		for (TokenDefinition tokenDefinition : concreteSyntax.getActiveTokens()) {
			printToken(tokenDefinition, sc);
		}
	}
	
	private void printToken(TokenDefinition definition, StringComposite sc){
		sc.add(definition.getName());
		sc.add(":");
		
		sc.add(definition.getRegex());
		
		if (definition.isHidden()) {
			sc.add("{ _channel = 99; }");
		}
		sc.add(";");
	}
	
	private void printDefaultImports(StringComposite sc) {
		// do not add imports here
		// all classes used by the generated parser must be
		// fully qualified
        sc.add("import " + AbstractEMFTextParser.class.getName() + ";");
	}
	
    private String computeCardinalityString(Definition definition) {
    	Cardinality cardinality = null;
    	if (definition instanceof CardinalityDefinition) {
    		cardinality = ((CardinalityDefinition) definition).getCardinality();
    	}
    	if(cardinality==null)
    		return null;
    	else if(cardinality instanceof PLUS)
    		return "+";
    	else if(cardinality instanceof QUESTIONMARK)
    		return "?";
    	else
    		return "*";
    }
}
