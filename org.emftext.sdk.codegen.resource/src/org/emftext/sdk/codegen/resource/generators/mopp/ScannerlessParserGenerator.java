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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP_ENTRY;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MATCHER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PATTERN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STACK;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.antlr.runtime3_4_0.ANTLRInputStream;
import org.antlr.runtime3_4_0.CommonTokenStream;
import org.antlr.runtime3_4_0.RecognitionException;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
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
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.regex.ANTLRexpLexer;
import org.emftext.sdk.regex.ANTLRexpParser;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.EObjectUtil;
import org.emftext.sdk.util.GenClassUtil;
import org.emftext.sdk.util.StringUtil;

/**
 * An experimental implementation of a Packrat parser. Currently a 
 * basic scannerless recursive descendant parser is created. The 
 * memoization of the Packrat parsing method is not yet implemented.
 * 
 * See: http://pdos.csail.mit.edu/~baford/packrat/thesis/thesis.pdf
 */
// TODO mseifert: enable backtracking for the postParseCommands lists
@SyntaxDependent
public class ScannerlessParserGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final GenClassUtil genClassUtil = new GenClassUtil();
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final GenClassFinder genClassFinder = new GenClassFinder();
	
	private Set<String> parseMethods = new LinkedHashSet<String>();
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private GenClassCache genClassCache;
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		this.genClassCache = getContext().getConcreteSyntax().getGenClassCache();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " implements " + iTextParserClassName + " {");
		sc.addLineBreak();
		addInnerClasses(sc);
		addFields(sc);
		addConstructors(sc);
		addMethods(sc);
		addMethodsForRules(sc);
		sc.add("}");
	}

	private void addInnerClasses(JavaComposite sc) {
		// add context interface and implementation
		addICommandContextClass(sc);
		addCommandContextClass(sc);
		// add command interface and implementations
		addICommandClass(sc);
		addCreateObjectCommandClass(sc);
		addContainedObjectCommandClass(sc);
		addSetAttributeValueCommandClass(sc);
		addAddProxyCommandClass(sc);
		addPopContainerCommandClass(sc);
		addObjectCompletedCommandClass(sc);
		addParseErrorClass(sc);
		addParsePositionClass(sc);
	}

	private void addParseErrorClass(StringComposite sc) {
		sc.add("public static class ParseError {");
		sc.add("private String message;");
		sc.add("private int offset;");
		sc.addLineBreak();
		sc.add("public ParseError(String message, int offset) {");
		sc.add("this.message = message;");
		sc.add("this.offset = offset;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getMessage() {");
		sc.add("return message;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getOffset() {");
		sc.add("return offset;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addObjectCompletedCommandClass(JavaComposite sc) {
		sc.add("public class ObjectCompletedCommand implements ICommand {");
		sc.add("public int start;");
		sc.add("public int end;");
		sc.addLineBreak();
		sc.add("public ObjectCompletedCommand(int start, int end) {");
		sc.add("this.start = start;");
		sc.add("this.end = end;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void execute(ICommandContext context) {");
		sc.add(iTextResourceClassName + " resource = getResource();");
		sc.add("if (resource != null) {");
		sc.addComment("the resource can be null if the parser is used for code completion");
		sc.add(E_OBJECT + " currentContainer = context.getCurrentContainer();");
		sc.add("setLocalizationInfo(currentContainer, start, end);");
		sc.add("}");
		sc.add("context.popCurrentContainer();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String toString() {");
		sc.add("return \"END\";");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addSetLocalizationInfoMethod(JavaComposite sc) {
		sc.add("public void setLocalizationInfo(" + E_OBJECT + " object, int start, int end) {");
		sc.addComment("the resource may be null if the parse is used in standalone mode");
		sc.add("if (resource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("Integer[] lineAndPosition = " + stringUtilClassName + ".getLineAndCharPosition(content, start);");
		sc.add("int line = lineAndPosition[0];");
		sc.add("int column = lineAndPosition[1];");
		sc.add("final " + iLocationMapClassName + " locationMap = resource.getLocationMap();");
		sc.add("locationMap.setCharStart(object, start);");
		sc.add("locationMap.setCharEnd(object, end);");
		sc.add("locationMap.setLine(object, line);");
		sc.add("locationMap.setColumn(object, column);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPopContainerCommandClass(StringComposite sc) {
		sc.add("public static class PopContainerCommand implements ICommand {");
		sc.add("public void execute(ICommandContext context) {");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddProxyCommandClass(JavaComposite sc) {
		sc.add("public class AddProxyCommand<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> implements ICommand {");
		sc.addLineBreak();
		sc.add("private int featureID;");
		sc.add("private int start;");
		sc.add("private int end;");
		sc.add("private String tokenName;");
		sc.add("private " + E_CLASS + " proxyClass;");
		sc.add("private " + iReferenceResolverClassName + "<ContainerType, ReferenceType> referenceResolver;");
		sc.addLineBreak();

		sc.add("public AddProxyCommand(int start, int end, String tokenName, int featureID, " + E_CLASS + " proxyClass, " + iReferenceResolverClassName + "<ContainerType, ReferenceType> referenceResolver) {");
		sc.add("this.start = start;");
		sc.add("this.end = end;");
		sc.add("this.tokenName = tokenName;");
		sc.add("this.featureID = featureID;");
		sc.add("this.proxyClass = proxyClass;");
		sc.add("this.referenceResolver = referenceResolver;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void execute(ICommandContext context) {");
		sc.add("String match = content.substring(start, end);");
		sc.add(E_OBJECT + " currentObject = context.getCurrentObject();");
		sc.addComment("call token resolver");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(iTokenResolveResultClassName + " result = getFreshTokenResolveResult();");
		sc.add(E_STRUCTURAL_FEATURE + " feature = currentObject.eClass().getEStructuralFeature(featureID);");
		sc.add("tokenResolver.resolve(match, feature, result);");
		sc.add("Object resolvedObject = result.getResolvedToken();");
		sc.add("if (resolvedObject == null) {");
		sc.addComment("add error to resource");
		sc.add("addErrorToResource(result.getErrorMessage(), start, end);");
		sc.add("} else {");
		sc.addComment("call reference resolver (feature is a non-containment reference)");
    	sc.add("String resolvedString = (String) resolvedObject;");
    	sc.add(E_OBJECT + " proxyObject = proxyClass.getEPackage().getEFactoryInstance().create(proxyClass);"); 
    	//sc.add("collectHiddenTokens(element);");
    	sc.add("registerContextDependentProxy(new " + 
    			contextDependentUriFragmentFactoryClassName + 
    			"<ContainerType, ReferenceType>(referenceResolver), (ContainerType) currentObject, (" + E_REFERENCE + ") feature, resolvedString, proxyObject);");
		sc.addComment("add proxy object");
		sc.add("assert feature instanceof " + E_REFERENCE + ";");
		sc.add("addObjectToFeature(currentObject, proxyObject, featureID);");
		sc.add("setLocalizationInfo(proxyObject, start, end);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		generatorUtil.addRegisterContextDependentProxyMethod(sc, false, getContext());
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetAttributeValueCommandClass(JavaComposite sc) {
		sc.add("public class SetAttributeValueCommand implements ICommand {");
		sc.addLineBreak();
		sc.add("private int featureID;");
		sc.add("private int start;");
		sc.add("private int end;");
		sc.add("private String tokenName;");
		sc.addLineBreak();

		sc.add("public SetAttributeValueCommand(int start, int end, String tokenName, int featureID) {");
		sc.add("this.start = start;");
		sc.add("this.end = end;");
		sc.add("this.tokenName = tokenName;");
		sc.add("this.featureID = featureID;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void execute(ICommandContext context) {");
		sc.add("String match = content.substring(start, end);");
		sc.add(E_OBJECT + " currentObject = context.getCurrentObject();");
		sc.addComment("call token resolver");
		sc.add(iTokenResolverClassName + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(iTokenResolveResultClassName + " result = getFreshTokenResolveResult();");
		sc.add(E_STRUCTURAL_FEATURE + " feature = currentObject.eClass().getEStructuralFeature(featureID);");
		sc.add("tokenResolver.resolve(match, feature, result);");
		sc.add("Object resolvedObject = result.getResolvedToken();");
		sc.add("if (resolvedObject == null) {");
		sc.addComment("add error to resource");
		sc.add("addErrorToResource(result.getErrorMessage(), start, end);");
		sc.add("} else {");
		sc.addComment("add proxy object (if feature is a non-containment reference)");
		sc.add("assert feature instanceof " + E_ATTRIBUTE + ";");
		sc.add("addObjectToFeature(currentObject, resolvedObject, featureID);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainedObjectCommandClass(StringComposite sc) {
		sc.add("public class AddContainedObjectCommand implements ICommand {");
		sc.addLineBreak();
		sc.add("private int featureID;");
		sc.addLineBreak();
		sc.add("public AddContainedObjectCommand(int featureID) {");
		sc.add("this.featureID = featureID;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void execute(ICommandContext context) {");
		sc.add(E_OBJECT + " container = context.getCurrentContainer();");
		sc.add(E_OBJECT + " object = context.getCurrentObject();");
		sc.add("addObjectToFeature(container, object, featureID);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String toString() {");
		sc.add("return \"ADD TO PARENT\";");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateObjectCommandClass(StringComposite sc) {
		sc.add("public static class CreateObjectCommand implements ICommand {");
		sc.addLineBreak();
		sc.add("private " + E_CLASS + " eClass;");
		sc.addLineBreak();
		sc.add("public CreateObjectCommand(" + E_CLASS + " eClass) {");
		sc.add("this.eClass = eClass;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void execute(ICommandContext context) {");
		sc.add(E_OBJECT + " object = eClass.getEPackage().getEFactoryInstance().create(eClass);");
		sc.add("context.pushCurrentContainer(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String toString() {");
		sc.add("return \"CREATE \" + eClass.getName();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParsePositionClass(StringComposite sc) {
		sc.add("public static class ParsePosition {");
		sc.addLineBreak();
		sc.add("private final int offset;");
		sc.add("private final " + LINKED_LIST + "<ICommand> commands;");
		sc.add("private final " + LINKED_LIST + "<" + iTextTokenClassName + "> tokens;");
		sc.add("private final String methodName;");
		sc.addLineBreak();
		sc.add("public ParsePosition(int offset, " + LINKED_LIST + "<ICommand> commands, " + LINKED_LIST + "<" + iTextTokenClassName + "> tokens, String methodName) {");
		sc.add("this.offset = offset;");
		sc.add("this.commands = commands;");
		sc.add("this.tokens = tokens;");
		sc.add("this.methodName = methodName;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getOffset() {");
		sc.add("return offset;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LINKED_LIST + "<ICommand> getCommands() {");
		sc.add("return commands;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LINKED_LIST + "<" + iTextTokenClassName + ">  getTokens() {");
		sc.add("return tokens;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getMethodName() {");
		sc.add("return methodName;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addICommandClass(StringComposite sc) {
		sc.add("public interface ICommand {");
		sc.add("public void execute(ICommandContext context);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCommandContextClass(StringComposite sc) {
		sc.add("public static class CommandContext implements ICommandContext {");
		sc.addLineBreak();
		sc.add("private " + STACK + "<" + E_OBJECT +"> containerStack = new " + STACK + "<" + E_OBJECT +">();");
		sc.add("private " + E_OBJECT + " currentObject;");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " getCurrentContainer() {");
		sc.add("if (containerStack.isEmpty()) {");
		sc.add("return null;");
		sc.add("} else {");
		sc.add("return containerStack.peek();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " getCurrentObject() {");
		sc.add("return currentObject;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void pushCurrentContainer(" + E_OBJECT + " newContainer) {");
		sc.add("containerStack.push(newContainer);");
		sc.add("currentObject = newContainer;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void popCurrentContainer() {");
		sc.add("currentObject = containerStack.pop();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addICommandContextClass(StringComposite sc) {
		sc.add("public interface ICommandContext {");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " getCurrentContainer();");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " getCurrentObject();");
		sc.addLineBreak();
		sc.add("public void pushCurrentContainer(" + E_OBJECT + " newContainer);");
		sc.addLineBreak();
		sc.add("public void popCurrentContainer();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		GenerationContext context = getContext();

		addCreateInstanceMethod(sc);
		addGetResourceMethod(sc);
		addParseMethod(sc);
		addParseStartSymbolsMethod(sc);
		addIsStackReadyMethod(sc);
		addParseToExpectedElementsMethod(sc);
		addSetResourceMethod(sc);
		addGetOptionsMethod(sc);
		addSetOptionsMethod(sc);

		addMatchesMethod(sc);
		addMatchesUsedTokenMethod(sc);
		addMatchUnusedTokensMethod(sc);
		addMatchesRegexpMethod(sc);
		addDiscardCommandsMethod(sc);
		addDiscardTokensMethod(sc);
		addAddParseErrorMethod(sc);
		addAddObjectToFeatureMethod(sc);

		generatorUtil.addAddMapEntryMethod(sc, context);
		generatorUtil.addAddObjectToListMethod1(sc);
		generatorUtil.addGetFreshTokenResolveResultMethod(sc, tokenResolveResultClassName);
		generatorUtil.addGetReferenceResolverSwitchMethod(sc, context);
		// this is the two parameter version
		addAddErrorToResourceMethod(sc);
		// this is the four parameter version
		generatorUtil.addAddErrorToResourceMethod(sc, context);
		addAddParseErrorToResourceMethod(sc);
		addSetLocalizationInfoMethod(sc);
		addSetScanModeMethod(sc);
		addGetTokenNamesMethod(sc);
		addGetTokensMethod(sc);
		addAddCommandMethod(sc);
		addAddTokenMethod(sc);
		addProcessParseTrialStackMethod(sc);
		addTerminateMethod(sc);
	}

	private void addTerminateMethod(JavaComposite sc) {
		sc.add("public void terminate() {");
		sc.addComment("TODO implement this");
		sc.add("}");
	}

	private void addAddCommandMethod(JavaComposite sc) {
		sc.add("public void addCommand(ICommand command) {");
		sc.add("if (restoreStackMode) {");
		sc.add("throw new RuntimeException(\"Can't add commands in restoreStackMode.\");");
		sc.add("}");
		sc.addComment("if the parser is in scan mode the command can be thrown away");
		sc.add("if (!scanMode) {");
		sc.add("commands.add(command);");
		sc.add("}");
		sc.add("}");
	}

	private void addAddTokenMethod(JavaComposite sc) {
		sc.add("public void addToken(final String tokenName, final String text, final int offset, final int length) {");
		sc.addComment("only if the parser is in scan mode the tokens are collected");
		sc.add("if (scanMode) {");
		sc.add("tokens.add(new " + iTextTokenClassName + "() {");
		sc.add("public boolean canBeUsedForSyntaxHighlighting() {");
		sc.add("return true;");
		sc.add("}");

		sc.add("public int getLine() {");
		sc.add("return 0;"); // TODO
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public int getColumn() {");
		sc.add("return 0;"); // TODO
		sc.add("}");
		sc.addLineBreak();

		sc.add("public int getLength() {");
		sc.add("return length;");
		sc.add("}");

		sc.add("public String getName() {");
		sc.add("return tokenName;");
		sc.add("}");

		sc.add("public int getOffset() {");
		sc.add("return offset;");
		sc.add("}");
		
		sc.add("public String getText() {");
		sc.add("return text;");
		sc.add("}");

		sc.add("});");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNamesMethod(StringComposite sc) {
		sc.add("public String[] getTokenNames() {");
		sc.add("return tokenNames;");
		sc.add("}");
	}

	private void addGetTokensMethod(StringComposite sc) {
		sc.add("public " + LIST + "<" + iTextTokenClassName + "> getTokens() {");
		sc.add("return tokens;");
		sc.add("}");
	}

	private void addSetScanModeMethod(StringComposite sc) {
		sc.add("public void setScanMode() {");
		sc.add("scanMode = true;");
		sc.add("}");
	}

	private void addAddParseErrorToResourceMethod(StringComposite sc) {
		sc.add("public void addParseErrorToResource() {");
		sc.add("if (parseError == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("int offset = parseError.getOffset();");
		sc.add("addErrorToResource(parseError.getMessage(), offset, offset);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddErrorToResourceMethod(StringComposite sc) {
		sc.add("public void addErrorToResource(String message, int start, int end) {");
		sc.add("int line = " + stringUtilClassName + ".getLine(content, start);");
		sc.add("int charPositionInLine  = " + stringUtilClassName + ".getCharPositionInLine(content, start);");
		sc.add("addErrorToResource(message, line, charPositionInLine, start, end);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDiscardCommandsMethod(StringComposite sc) {
		sc.add("public void discardCommands(int index) {");
		sc.add("if (restoreStackMode) {");
		sc.add("throw new RuntimeException(\"Can't discard commands in restoreStackMode.\");");
		sc.add("}");
		sc.add("commands.subList(index, commands.size()).clear();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDiscardTokensMethod(StringComposite sc) {
		sc.add("public void discardTokens(int index) {");
		sc.add("tokens.subList(index, tokens.size()).clear();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddParseErrorMethod(StringComposite sc) {
		sc.add("public void addParseError(ParseError pe) {");
		sc.add("if (parseError == null || pe.getOffset() >= parseError.getOffset()) {");
		sc.add("parseError = pe;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddObjectToFeatureMethod(StringComposite sc) {
		sc.add("public void addObjectToFeature(" + E_OBJECT + " container, Object object, int featureConstant) {");
		sc.add(E_STRUCTURAL_FEATURE + " eFeature = container.eClass().getEStructuralFeature(featureConstant);");
		sc.add("if (eFeature.getUpperBound() == 1) {");
		sc.add("if (" + MAP_ENTRY + ".class.getName().equals(eFeature.getEType().getInstanceClassName())) {");
		sc.add("addMapEntry(container, eFeature, (" + dummyEObjectClassName +") object);");
		sc.add("} else {");
		sc.add("container.eSet(eFeature, object);");
		sc.add("}");
		sc.add("} else {");
		sc.add("if (" + MAP_ENTRY + ".class.getName().equals(eFeature.getEType().getInstanceClassName())) {");
		sc.add("addMapEntry(container, eFeature, (" + dummyEObjectClassName +") object);");
		sc.add("} else {");
		sc.add("addObjectToList(container, featureConstant, object);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructors(StringComposite sc) {
		addConstructor1(sc);
		addConstructor2(sc);
	}

	private void addMatchesRegexpMethod(StringComposite sc) {
		sc.add("public String matchesRegexp(" + PATTERN + " pattern, String name, boolean isUnusedToken) {");
		sc.add("String tail = content.substring(offset);");
		sc.add(MATCHER + " matcher = pattern.matcher(tail);");
		sc.add("boolean matches = matcher.find();");
		//sc.add("String found = null;");
		//sc.add("System.out.println(\"Remaining input : \\\"\" + tail + \"\\\"\");");
		//sc.add("System.out.print(\"Trying to match \" + name + \" at \" + offset + \" -> \" + matches);");
		sc.add("if (matches) {");
		sc.add("int start = matcher.start();");
		sc.add("int end = matcher.end();");
		sc.add("String match = tail.substring(start, end);");
		sc.add("addToken(name, match, offset, end - start);");
		sc.add("offset = offset + end;");
		sc.add("if (!isUnusedToken) {");
		sc.add("offsetIgnoringUnusedTokens = offset;");
		sc.add("}");
		//sc.add("System.out.println(matches ? (\" : \\\"\" + found + \"\\\"\") : \"\");");
		sc.add("return match;");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchUnusedTokensMethod(JavaComposite sc) {
		sc.add("public boolean matchUnusedTokens() {");
		sc.add("while (true) {");
		sc.add("boolean found = false;");
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		for (CompleteTokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (tokenDefinition.isHidden()) {
				String field = getFieldName(tokenDefinition);
				sc.addComment("TODO add tokens to collect-in features");
				sc.add("found |= null != matchesRegexp(" + field + ", \"unused " + field + "\", true);");
			}
		}
		sc.add("if (!found) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesUsedTokenMethod(StringComposite sc) {
		sc.add("public String matchesUsedToken(" + PATTERN + " pattern, String name, String tokenName) {");
		sc.add("if (restoreStackMode) {");
		sc.add("throw new RuntimeException(\"Can't match used token in restoreStackMode.\");");
		sc.add("}");
		sc.add("String match = matchesRegexp(pattern, name, false);");
		sc.add("if (match != null) {");
		sc.add("matchUnusedTokens();");
		sc.add("return match;");
		sc.add("} else {");
		sc.add("addParseError(new ParseError(\"Parse error: Expected token \" + tokenName + \".\", offset));");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod(StringComposite sc) {
		sc.add("public boolean matches(String keyword) {");
		sc.add("if (restoreStackMode) {");
		sc.add("throw new RuntimeException(\"Can't match in restoreStackMode.\");");
		sc.add("}");
		sc.add("boolean matches = content.startsWith(keyword, offset);");
		sc.add("if (matches) {");
		sc.add("addToken(keyword, keyword, offset, keyword.length());");
		sc.add("offset += keyword.length();");
		sc.add("matchUnusedTokens();");
		sc.add("} else {");
		sc.add("addParseError(new ParseError(\"Parse error: Keyword \" + keyword + \" expected.\", offset));");
		sc.add("}");
		sc.add("return matches;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetOptionsMethod(StringComposite sc) {
		sc.add("public " + MAP + "<?, ?> getOptions() {");
		sc.add("return options;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + MAP + "<?, ?> options) {");
		sc.add("this.options = options;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetResourceMethod(StringComposite sc) {
		sc.add("public void setResource(" + iTextResourceClassName + " resource) {");
		sc.add("this.resource = resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseToExpectedElementsMethod(StringComposite sc) {
		sc.add("public " + LIST + "<" + expectedTerminalClassName + "> parseToExpectedElements(" + E_CLASS + " type, " + iTextResourceClassName + " resource, int cursorOffset) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseStartSymbolsMethod(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		sc.add("public boolean parseStartSymbols() {");
		sc.add("boolean matches;");
		for (GenClass startSymbol : syntax.getActiveStartSymbols()) {
			sc.addComment("try start symbol: " + startSymbol.getName());
			sc.add("restoreStackMode = true;");
			sc.add("matches = " + getMethodName(syntax.getGenClassCache(), startSymbol) + "();");
			sc.add("if (isStackReady(\"" + getMethodName(syntax.getGenClassCache(), startSymbol) + "\")) {");
			sc.add("if (matches) {");
			sc.add("return true;");
			sc.add("}");
			sc.add("} else {");
			sc.addComment("continue searching for stack ID");
			sc.add("}");
		}
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addIsStackReadyMethod(JavaComposite sc) {
		sc.add("public boolean isStackReady(String stackID) {");
		sc.add("if (!restoreStackMode) {");
		sc.addComment("ready (stack was restored before");
		sc.add("return true;");
		sc.add("} else if (stackID.equals(restoreStackID)) {");
		sc.add("restoreStackMode = false;");
		sc.add("restoreStackID = null;");
		sc.addComment("ready (stack is now restored)");
		sc.add("return true;");
		sc.add("} else {");
		sc.addComment("not ready (stack has not reached stackID)");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addParseMethod(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();

		sc.add("public " + iParseResultClassName + " parse() {");
		sc.add("restoreStackMode = false;");
		sc.add("parseError = null;");
		sc.add("parseTrials = new " + STACK + "<ParsePosition>();");
		sc.add("offsetIgnoringUnusedTokens = 0;");
		sc.add("postParseCommands = new " + ARRAY_LIST + "<" + iCommandClassName + "<" + iTextResourceClassName + ">>();");
		//sc.add("commands = new " + LINKED_LIST + "<ICommand>();");
		//sc.add("tokens = new " + LINKED_LIST + "<" + I_TEXT_TOKEN + ">();");
		//sc.add("boolean tryOtherStartSymbols = true;");
		List<GenClass> activeStartSymbols = syntax.getActiveStartSymbols();
		for (int i = activeStartSymbols.size() - 1; i >= 0; i--) {
			GenClass startSymbol = activeStartSymbols.get(i);
			sc.addComment("try start symbol: " + startSymbol.getName());
			//sc.add("if (tryOtherStartSymbols) {");
			//sc.add("offset = 0;");
			sc.add("parseTrials.push(new ParsePosition(0, new " + LINKED_LIST + "<ICommand>(), new " + LINKED_LIST + "<" + iTextTokenClassName + ">(), \"" + getMethodName(syntax.getGenClassCache(), startSymbol) + "\"));");
			//sc.add("}");
		}
		sc.add("boolean success = processParseTrialStack();");
		sc.add("if (success) {");
		//sc.add("tryOtherStartSymbols = false;");
		sc.add("} else {");
		sc.add("addParseError(new ParseError(\"EOF (end of file) expected.\", offset));");
		sc.add("}");
		
		sc.add("ICommandContext context = new CommandContext();");
		sc.add("if (success) {");
		sc.addComment(
			"Build content tree by executing commands. " +
			"Do not execute the last pop container command to obtain " +
			"the root element."
		);
		//sc.add("for (int c = 0; c < commands.size() - 1; c++) {");
		//sc.add("ICommand command = commands.get(c);");
		//sc.add("System.out.println(c + \": \" + command);");
		//sc.add("}");
		sc.add("for (int c = 0; c < commands.size() - 1; c++) {");
		sc.add("ICommand command = commands.get(c);");
		sc.add("command.execute(context);");
		sc.add("}");
		sc.add("commands = null;");
		sc.add("}");
		
		sc.add("if (success) {");
		sc.add("parseError = null;");
		sc.add("}");
		sc.add("addParseErrorToResource();");
		sc.addComment("return root element");
		sc.add(parseResultClassName + " result = new " + parseResultClassName + "();");
		sc.add("result.setRoot(context.getCurrentContainer());");
		sc.add("result.getPostParseCommands().addAll(postParseCommands);");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getMethodName(GenClassCache genClassCache, GenClass genClass) {
		String name = getMethodName_(genClassCache, genClass);
		parseMethods.add(name);
		return name;
	}

	private String getMethodName(Choice choice) {
		String name = getMethodName_(choice);
		parseMethods.add(name);
		return name;
	}

	private String getMethodName(Definition part) {
		String name = getMethodName_(part);
		parseMethods.add(name);
		return name;
	}

	private String getMethodName(CardinalityDefinition definition) {
		String name = getMethodName_(definition);
		parseMethods.add(name);
		return name;
	}

	private String getMethodName(Containment containment) {
		String name = getMethodName_(containment);
		parseMethods.add(name);
		return name;
	}

	private String getMethodName(Sequence sequence) {
		String name = getMethodName_(sequence);
		parseMethods.add(name);
		return name;
	}

	private void addProcessParseTrialStackMethod(JavaComposite sc) {
		boolean forceEOFToken = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.FORCE_EOF);

		sc.add("public boolean processParseTrialStack() {");
		sc.add("while (!parseTrials.empty()) {");
		sc.add("ParsePosition nextTrial = parseTrials.pop();");
		sc.addComment("restore parse position");
		sc.add("restoreStackMode = false;");
		sc.add("offset = nextTrial.getOffset();");
		sc.add("commands = nextTrial.getCommands();");
		sc.add("tokens = nextTrial.getTokens();");
		sc.addComment("restore parse stack");
		sc.add("restoreStackMode = true;");
		sc.add("restoreStackID = nextTrial.getMethodName();");
		sc.add("boolean success = parseStartSymbols();");
		sc.add("if (success) {");
		if (forceEOFToken) {
			sc.add("if (offset == content.length()) {");
			sc.addComment("the content was successfully parsed up to the last character, we do not need to try something else");
			sc.add("return true;");
			sc.add("}");
		} else {
			sc.add("return true;");
		}
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod(StringComposite sc) {
		sc.add("public " + iTextResourceClassName + " getResource() {");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor1(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateInstanceMethod(StringComposite sc) {
		sc.add("public " + iTextParserClassName + " createInstance(" + INPUT_STREAM + " inputStream, String encoding) {");
		sc.add("return new " + getResourceClassName() + "(inputStream, encoding);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + INPUT_STREAM + " inputStream, String encoding) {");
		sc.add("super();");
		sc.add("this.inputStream = new " + INPUT_STREAM_READER + "(inputStream);");
		// TODO generate more efficient code
		sc.add("try {");
		sc.add("int next;");
		sc.add("while ((next = this.inputStream.read()) >= 0) {");
		sc.add("this.content += (char) next;");
		sc.add("}");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + INPUT_STREAM_READER + " inputStream;");
		sc.addJavadoc("the current position in the content");
		sc.add("private int offset;");
		sc.add("private " + STACK + "<ParsePosition> parseTrials;");
		
		sc.add("private boolean scanMode = false;");
		sc.add("private boolean restoreStackMode = false;");
		sc.add("private String restoreStackID;");
		sc.addJavadoc("the current position in the content (ignoring trailing unused tokens (e.g., whitespaces)");
		sc.add("private int offsetIgnoringUnusedTokens;");
		sc.add("private String content = \"\";");
		sc.add("private " + LINKED_LIST + "<ICommand> commands;");
		sc.add("private " + iTokenResolverFactoryClassName + " tokenResolverFactory = new " + tokenResolverFactoryClassName + "();");
		sc.add("private " + tokenResolveResultClassName + " tokenResolveResult = new " + tokenResolveResultClassName + "();");
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.add("private ParseError parseError;");
		sc.add("private " + LIST + "<" + iTextTokenClassName + "> tokens;");
		sc.add("private " + COLLECTION + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> postParseCommands;");
		sc.addLineBreak();

		generatorUtil.addMetaInformationField(sc, getContext());

		addTokensField(sc);
		sc.addLineBreak();
		addTokenPatterns(sc);
		sc.addLineBreak();
	}

	private void addTokenPatterns(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		List<String> tokenNames = new ArrayList<String>();
		List<CompleteTokenDefinition> tokens = syntax.getActiveTokens();
		for (CompleteTokenDefinition tokenDefinition : tokens) {
			String fieldName = getFieldName(tokenDefinition);
			String regex = tokenDefinition.getRegex();
			String tokenName = tokenDefinition.getName();
			tokenNames.add("\"" + tokenName + "\"");
			
			InputStream input = new ByteArrayInputStream(regex.getBytes());
			ANTLRInputStream inputStream;
			try {
				inputStream = new ANTLRInputStream(input);
			
			
				ANTLRexpLexer lexer = new ANTLRexpLexer(inputStream);
				CommonTokenStream tokenStream = new CommonTokenStream(lexer);
				
				ANTLRexpParser parser = new ANTLRexpParser(tokenStream);
				regex = parser.root().toString();
				regex = StringUtil.escapeQuotes(regex);
			} catch (IOException e) {
				// TODO handle exception
				e.printStackTrace();
			} catch (RecognitionException e) {
				// TODO handle exception
				e.printStackTrace();
			}
			// the \A is needed to indicate the the begin of the input must be matched
			regex = "\\\\A" + regex;
			sc.add("public final static " + PATTERN + " " + fieldName + " = " + PATTERN + ".compile(\"" + regex + "\");");
		}
	}
	
	private void addTokensField(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		Set<String> tokenNames = new LinkedHashSet<String>();
		List<CompleteTokenDefinition> tokens = syntax.getActiveTokens();
		for (CompleteTokenDefinition tokenDefinition : tokens) {
			String tokenName = tokenDefinition.getName();
			tokenNames.add("\"" + tokenName + "\"");
		}
		List<Rule> allRules = syntax.getAllRules();
		for (Rule rule : allRules) {
			Collection<CsString> csStrings = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
			for (CsString csString : csStrings) {
				tokenNames.add("\"" + csString.getValue() + "\"");
			}
		}
		sc.add("private final static String[] tokenNames = new String[] {" + StringUtil.explode(tokenNames, ",") + "};");
	}

	private String getFieldName(ReferencableTokenDefinition tokenDefinition) {
		return "TOKEN_" + tokenDefinition.getName();
	}

	private void addMethodsForRules(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		List<Rule> rules = syntax.getAllRules();
		for (Rule rule : rules) {
			addMethodForRule(sc, syntax, rule);
		}
	}

	private void addMethodForRule(JavaComposite sc, ConcreteSyntax syntax, Rule rule) {
		GenClass metaclass = rule.getMetaclass();

		sc.add("public boolean " + getMethodName(syntax.getGenClassCache(), metaclass) + "() {");
		Choice choice = rule.getDefinition();
		sc.add("int commandIndexBackup = commands.size();");
		sc.add("int tokenIndexBackup = tokens.size();");
		sc.add("int startOffset = offset;");

		sc.add("if (isStackReady(\"" + getMethodName(syntax.getGenClassCache(), metaclass) + "\")) {");
		sc.add(E_CLASS + " eClass = " + genClassUtil.getAccessor(metaclass) + ";");
		sc.add("addCommand(new CreateObjectCommand(eClass));");
		sc.add("}");
		
		sc.add("boolean success = " + getMethodName(choice) + "();");
		
		sc.add("if (isStackReady(\"" + getMethodName(syntax.getGenClassCache(), metaclass) + "\")) {");
		sc.add("if (success) {");
		sc.add("addCommand(new ObjectCompletedCommand(startOffset, offsetIgnoringUnusedTokens - 1));");
		sc.add("return true;");
		sc.add("} else {");
		sc.add("discardCommands(commandIndexBackup);");
		sc.add("discardTokens(tokenIndexBackup);");
		sc.add("return false;");
		sc.add("}");
		sc.add("} else {");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		addMethodForChoice(sc, syntax, metaclass, choice);
	}

	private void addMethodForChoice(JavaComposite sc, ConcreteSyntax syntax,
			GenClass ruleMetaClass, Choice choice) {

		sc.add("public boolean " + getMethodName(choice) + "() {");
		addCodeForChoice(sc, choice);
		sc.add("}");
		sc.addLineBreak();
		
		for (Sequence option : choice.getOptions()) {
			addMethodForSequence(sc, syntax, ruleMetaClass, option);
		}
	}

	private void addCodeForChoice(JavaComposite sc, Choice choice) {
		List<Sequence> options = choice.getOptions();
		sc.addComment("begin options");
		for (Sequence option : options) {
			sc.add("{");
			sc.add("boolean success = " + getMethodName(option) + "();");
			sc.add("if (isStackReady(\"" + getMethodName(option) + "\")) {");
			sc.add("if (success) {");
			sc.add("return true;");
			sc.add("}");
			sc.add("}");
			sc.add("}");
		}
		sc.addComment("end options");
		sc.add("return false;");
	}

	private void addMethodForDefinition(JavaComposite sc, ConcreteSyntax syntax,
			GenClass ruleMetaClass, Definition part) {
		sc.add("public boolean " + getMethodName(part) + "() {");
		sc.add("boolean matchedAll = true;");
		if (part instanceof CardinalityDefinition) {
			CardinalityDefinition cd = (CardinalityDefinition) part;
			addCardinalityCode(sc, syntax, cd);
		} else if (part instanceof CsString) {
			sc.add("if (isStackReady(\"" + getMethodName(part) + "\")) {");
			addCodeForCsString(sc, (CsString) part);
			sc.add("}");
		} else {
			throw new RuntimeException("Found unknown subclass " + part.getClass().getName());
		}
		sc.add("return matchedAll;");
		sc.add("}");
		sc.addLineBreak();
		if (part instanceof CardinalityDefinition) {
			addMethodForCardinality(sc, syntax, ruleMetaClass, (CardinalityDefinition) part);
		}
	}
	
	private void addMethodForSequence(JavaComposite sc, ConcreteSyntax syntax,
			GenClass ruleMetaClass, Sequence sequence) {

		sc.add("public boolean " + getMethodName(sequence) + "() {");
		sc.add("boolean matchedAll = true;");
		sc.add("boolean matchedPart;");
		sc.add("boolean isStackReady;");
		sc.add("int offsetCopy = offset;");
		List<Definition> parts = sequence.getParts();
		for (Definition part : parts) {
			if (part instanceof WhiteSpaces) {
				// do nothing
				sc.addComment("whitespace");
				continue;
			} else if (part instanceof LineBreak) {
				// do nothing
				sc.addComment("linebreak");
				continue;
			}

			sc.add("matchedPart = " + getMethodName(part) + "();");
			sc.add("isStackReady = isStackReady(\"" + getMethodName(part) + "\");");
			sc.add("if (isStackReady) {");
			sc.add("matchedAll &= matchedPart;");
			sc.add("if (!matchedAll) {");
			sc.addComment("stop matching the sequence");
			sc.add("offset = offsetCopy;");
			sc.add("return false;");
			sc.add("}");
			sc.add("}");
		}
		sc.add("if (isStackReady(\"" + getMethodName(sequence) + "\")) {");
		sc.addComment("this sequence is valid");
		sc.add("return true;");
		sc.add("} else {");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		for (Definition definition : parts) {
			if (definition instanceof WhiteSpaces) {
				// do nothing
				continue;
			} else if (definition instanceof LineBreak) {
				// do nothing
				continue;
			} else {
				addMethodForDefinition(sc, syntax, ruleMetaClass, definition);
			}
		}
	}

	/*
	private void addCodeForDefinition(StringComposite sc,
			ConcreteSyntax syntax, GenClass ruleMetaClass, Definition part) {
		sc.add("matchedAll &= " + getMethodName(part) + "();");
	}
	*/

	private void addMethodForCardinality(JavaComposite sc, ConcreteSyntax syntax,
			GenClass ruleMetaClass, CardinalityDefinition definition) {

		Cardinality cardinality = definition.getCardinality();

		sc.add("public boolean " +  getMethodName(definition) + "() {");
		sc.add("boolean matched = true;");
		if (cardinality == Cardinality.NONE) {
			// cardinality == 1
			addCodeForElementWithCardinality(sc, syntax, ruleMetaClass, definition);
			sc.add("return matched;");
		} else if (cardinality == Cardinality.STAR) {
			// cardinality == 0..*
			sc.add("while (matched) {");
			sc.addComment("put trial on stack (try parsing without matching THING*)");
			String methodName = getNext(definition);
			if (methodName != null) {
				sc.add("if (isStackReady(\"" + getMethodName(definition) + "\")) {");
				sc.add("parseTrials.push(new ParsePosition(offset, new " + LINKED_LIST + "<ICommand>(commands), new " + LINKED_LIST + "<" + iTextTokenClassName + ">(tokens), \"" + methodName + "\"));");
				sc.add("}");
			}
			addCodeForElementWithCardinality(sc, syntax, ruleMetaClass, definition);
			sc.add("}");
			sc.add("return true;");
		} else if (cardinality == Cardinality.PLUS) {
			// cardinality == 1..*
			sc.add("boolean matchedAtLeastOnce = false;");
			sc.add("while (matched) {");
			sc.addComment("TODO put trial on stack (try parsing without matching THING+)");
			addCodeForElementWithCardinality(sc, syntax, ruleMetaClass, definition);
			sc.add("matchedAtLeastOnce |= matched;");
			sc.add("if (matchedAtLeastOnce) {");
			String methodName = getNext(definition);
			if (methodName != null) {
				sc.add("if (isStackReady(\"" + getMethodName(definition) + "\")) {");
				sc.add("parseTrials.push(new ParsePosition(offset, new " + LINKED_LIST + "<ICommand>(commands), new " + LINKED_LIST + "<" + iTextTokenClassName + ">(tokens), \"" + methodName + "\"));");
				sc.add("}");
			}
			sc.add("}");
			sc.add("}");
			sc.add("return matchedAtLeastOnce;");
		} else if (cardinality == Cardinality.QUESTIONMARK) {
			// cardinality == 0..1
			sc.addComment("put trial on stack (try parsing without matching THING)");
			String methodName = getNext(definition);
			if (methodName != null) {
				sc.add("if (isStackReady(\"" + getMethodName(definition) + "\")) {");
				sc.add("parseTrials.push(new ParsePosition(offset, new " + LINKED_LIST + "<ICommand>(commands), new " + LINKED_LIST + "<" + iTextTokenClassName + ">(tokens), \"" + methodName + "\"));");
				sc.add("}");
			}
			addCodeForElementWithCardinality(sc, syntax, ruleMetaClass, definition);
			sc.add("return true;");
		} else {
			throw new RuntimeException("Found unknown cardinality " + cardinality.getClass().getName());
		}
		sc.add("}");
		sc.addLineBreak();

		if (definition instanceof Containment) {
			addMethodForContainment(sc, syntax, ruleMetaClass, (Containment) definition);
		} else if (definition instanceof CompoundDefinition) {
			addMethodForCompound(sc, syntax, ruleMetaClass, (CompoundDefinition) definition);
		} else if (definition instanceof Terminal) {
			// do nothing - we handle terminals in-line instead of generating
			// a method for each terminal
		} else {
			throw new RuntimeException("Found unknown subclass " + definition.getClass().getName());
		}
	}

	private String getNext(CardinalityDefinition definition) {
		Sequence sequence = (Sequence) definition.eContainer();
		int index = getIndex(definition, sequence);
		System.out.println("getNext() index = " + index);
		System.out.println("getNext() sequence = " + sequence);
		System.out.println("getNext() sequence parts = " + sequence.getParts());
		if (sequence.getParts().size() > index + 1) {
			return getMethodName(sequence.getParts().get(index + 1));
		}
		return getNext(sequence);
	}

	private String getNext(Sequence sequence) {
		Choice choice = (Choice) sequence.eContainer();
		int index = getIndex(sequence, choice);
		if (choice.getOptions().size() > index + 1) {
			return getMethodName(choice.getOptions().get(index + 1));
		}
		return getNext(choice);
	}

	private String getNext(Choice choice) {
		EObject parent = choice.eContainer();
		if (parent instanceof Rule) {
			return null;
		} else if (parent instanceof CompoundDefinition) {
			CompoundDefinition compound = (CompoundDefinition) parent;
			return getNext(compound);
		} else {
			throw new RuntimeException("Unknown parent class: " + parent.eClass().getName());
		}
	}

	private void addMethodForCompound(JavaComposite sc,
			ConcreteSyntax syntax, GenClass ruleMetaClass, CompoundDefinition compound) {

		addMethodForChoice(sc, syntax, ruleMetaClass, compound.getDefinition());
	}

	private void addCardinalityCode(StringComposite sc, ConcreteSyntax syntax, CardinalityDefinition cd) {
		sc.add("matchedAll = " + getMethodName(cd) + "();");
	}

	private void addCodeForElementWithCardinality(JavaComposite sc, ConcreteSyntax syntax, GenClass ruleMetaClass, CardinalityDefinition cd) {
		if (cd instanceof Terminal) {
			addCodeForTerminal(sc, syntax, ruleMetaClass, (Terminal) cd);
		} else if (cd instanceof CompoundDefinition) {
			addCodeForCompoundDefinition(sc, syntax, (CompoundDefinition) cd);
		} else {
			throw new RuntimeException("Found unknown subclass " + cd.getClass().getName());
		}
	}

	private void addCodeForCompoundDefinition(JavaComposite sc,
			ConcreteSyntax syntax, CompoundDefinition cd) {
		sc.addComment("handle compound definition");
		Choice choice = cd.getDefinition();
		sc.add("matched = " + getMethodName(choice) + "();");
	}

	private void addMethodForContainment(JavaComposite sc, ConcreteSyntax syntax, GenClass ruleMetaClass, Containment containment) {
		final GenFeature genFeature = containment.getFeature();
		final GenClass featureType = genFeature.getTypeGenClass();

		sc.add("public boolean " + getMethodName(containment) + "() {");
		sc.add("int offsetCopy = this.offset;");
		
		// TODO mseifert: I'm not quite sure whether this is the expected behavior.
		// Do we add all subclasses as alternative even if the type of the
		// reference is not abstract?
		Collection<GenClass> alternatives = syntax.getSubClassesWithSyntax(featureType, false);
		if (genClassUtil.isConcrete(featureType) && 
				csUtil.hasSyntax(featureType, syntax,false)) {
			alternatives.add(featureType);
		}
		for (GenClass genClass : alternatives) {
			sc.addComment("try subclass " + genClass.getName());
			sc.add("{");
			sc.addComment("restore old offset");
			sc.add("this.offset = offsetCopy;");
			sc.add("boolean success = " + getMethodName(syntax.getGenClassCache(), genClass) + "();");
			sc.add("if (success) {");
			sc.addComment("add command to add element to the containment reference");
			sc.add("addCommand(new AddContainedObjectCommand(" + generatorUtil.getFeatureConstant(ruleMetaClass, genFeature) + "));");
			sc.add("return true;");
			sc.add("}");
			sc.add("}");
		}
		sc.addComment("no subclass matched");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCodeForCsString(JavaComposite sc, CsString csString) {
		String value = csString.getValue();
		sc.addComment("match cs string \"" + value + "\"");
		sc.add("matchedAll &= matches(\"" + value + "\");");
	}

	private void addCodeForTerminal(JavaComposite sc, ConcreteSyntax syntax, GenClass ruleMetaClass, Terminal terminal) {
		if (terminal instanceof Placeholder) {
			Placeholder defaultTokenTerminal = (Placeholder) terminal;
			ReferencableTokenDefinition tokenDefinition = defaultTokenTerminal.getToken();
			String regexp = tokenDefinition.getRegex();
			sc.addComment("match regexp \"" + regexp.replaceAll("\n", "").replace("\r", "") + "\"");
			String fieldName = getFieldName(tokenDefinition);
			String tokenName = tokenDefinition.getName();
			sc.add("int offsetBeforeMatch = offset;");
			sc.add("if (isStackReady(\"" + getMethodName(terminal) + "\")) {");
			sc.add("String match = matchesUsedToken(" + fieldName + ", \"" + fieldName+ "\", \"" + tokenName + "\");");
			sc.add("matched &= (match != null);");
			sc.add("if (matched) {");
			GenFeature genFeature = terminal.getFeature();
			if (genFeature != ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
				final String featureConstant = generatorUtil.getFeatureConstant(ruleMetaClass, genFeature);
				if (genFeature.getEcoreFeature() instanceof EAttribute) {
					sc.add("addCommand(new SetAttributeValueCommand(offsetBeforeMatch, offsetBeforeMatch + match.length(), \"" + tokenDefinition.getName() + "\", " + featureConstant + "));");
				} else if (genFeature.getEcoreFeature() instanceof EReference) {
					// find a sub type that can be instantiated as a proxy
					GenClass instanceType = genFeature.getTypeGenClass();
			    	GenClass proxyType = null;
			    	
			    	if (genClassUtil.isNotConcrete(instanceType)) {
			    		Collection<GenClass> allSubclasses = genClassFinder.findAllSubclasses(syntax, instanceType, genClassCache);
			    		for (GenClass subClass : allSubclasses) {
			    			if (genClassUtil.isConcrete(subClass)) {
				            	proxyType = subClass;
				            	break;
							}
			    		}
			    	} else {
			    		proxyType = instanceType;
			    	}
					String proxyResolver = getContext().getReferenceResolverAccessor(genFeature);
					sc.add("addCommand(new AddProxyCommand<" + genClassCache.getQualifiedInterfaceName(genFeature.getGenClass()) + ", " + genClassCache.getQualifiedInterfaceName(instanceType) + ">(offsetBeforeMatch, offsetBeforeMatch + match.length(), \"" + tokenDefinition.getName() + "\", " + featureConstant + ", " + genClassUtil.getAccessor(proxyType) + ", " + proxyResolver + "));");
				} else {
					throw new RuntimeException("Found unknown feature type for terminal.");
				}
			}
			sc.add("}");
			sc.add("} else {");
			sc.add("return false;");
			sc.add("}");
		} else if (terminal instanceof Containment) {
			Containment containment = (Containment) terminal;
			addCodeForContainment(sc, syntax, containment);
		} else {
			throw new RuntimeException("Found unknown subclass " + terminal.getClass().getName());
		}
	}

	private void addCodeForContainment(JavaComposite sc, ConcreteSyntax syntax, Containment containment) {
		sc.addComment("handle containment reference '" + containment.getFeature().getName() + "'");
		sc.add("matched &= " + getMethodName(containment) + "();");
	}

	private String getMethodName_(Containment containment) {
		Sequence parent = (Sequence) containment.eContainer();
		int index = getIndex(containment, parent);
		if (parent != null) {
			return getMethodName_(parent) + "_containment" + index;
		}
		return null;
	}

	private String getMethodName_(GenClassCache genClassCache, GenClass genClass) {
		return "parse_" + genClassCache.getEscapedTypeName(genClass);
	}

	private String getMethodName_(CardinalityDefinition cd) {
		Sequence parent = (Sequence) cd.eContainer();
		int index = getIndex(cd, parent);
		if (parent != null) {
			Cardinality cardinality = cd.getCardinality();
			if (cd instanceof Terminal) {
				return getMethodName_(parent) + "_terminal_" + getName(cardinality) + index;
			} else if (cd instanceof CompoundDefinition) {
				return getMethodName_(parent) + "_compound_" + getName(cardinality) + index;
			} else {
				throw new RuntimeException("Found unknown subclass " + cd.getClass().getName());
			}
		} else {
			throw new RuntimeException("Parent is null.");
		}
	}

	private String getName(Cardinality cardinality) {
		if (cardinality == Cardinality.NONE) {
			return "ONE";
		} else if (cardinality == Cardinality.PLUS) {
			return "PLUS";
		} else if (cardinality == Cardinality.STAR) {
			return "STAR";
		} else if (cardinality == Cardinality.QUESTIONMARK) {
			return "QUESTIONMARK";
		} else {
			throw new RuntimeException("Found unknown cardinality " + cardinality.getName());
		}
	}

	private String getMethodName_(Sequence sequence) {
		Choice parent = (Choice) sequence.eContainer();
		int index = getIndex(sequence, parent);
		if (parent != null) {
			return getMethodName_(parent) + "_sequence" + index;
		} else {
			throw new RuntimeException("Parent is null.");
		}
	}

	private String getMethodName_(Definition definition) {
		Sequence parent = (Sequence) definition.eContainer();
		int index = getIndex(definition, parent);
		if (parent != null) {
			return getMethodName_(parent) + "_part" + index;
		} else {
			throw new RuntimeException("Parent is null.");
		}
	}

	private String getMethodName_(Choice choice) {
		EObject parent = (EObject) choice.eContainer();
		if (parent instanceof Rule) {
			Rule rule = (Rule) parent;
			return getMethodName_(rule.getSyntax().getGenClassCache(), rule.getMetaclass()) + "_choice";
		} else if (parent instanceof Sequence) {
			int index = getIndex(choice, parent);
			return getMethodName_((Sequence) parent) + "_choice" + index;
		} else if (parent instanceof CompoundDefinition) {
			return getMethodName_((CompoundDefinition) parent) + "_compound";
		} else {
			throw new RuntimeException("Found unknown subclass " + parent.getClass().getName());
		}
	}

	private int getIndex(EObject object, EObject parent) {
		EStructuralFeature feature = object.eContainingFeature();
		return ((List<?>) parent.eGet(feature)).indexOf(object);
	}

	
}
