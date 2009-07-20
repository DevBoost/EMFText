package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_EMF_TEXT_PARSER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DUMMY_E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_EXPECTED_ELEMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_LOCATION_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_REFERENCE_RESOLVER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_PARSER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN_RESOLVER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN_RESOLVER_FACTORY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN_RESOLVE_RESULT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MATCHER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PATTERN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STACK;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TOKEN_RESOLVE_RESULT;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.runtime.util.StringUtil;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
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
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * An experimental implementation of a Packrat parser. Currently a 
 * basic scannerless recursive descendant parser is created. The 
 * memoization of the Packrat parsing method is not yet implemented.
 * 
 * See: http://pdos.csail.mit.edu/~baford/packrat/thesis/thesis.pdf
 */
public class ScannerlessParserGenerator extends BaseGenerator {
	
	private final GenClassUtil genClassUtil = new GenClassUtil();
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final GenClassFinder genClassFinder = new GenClassFinder();
	
	private GenerationContext context;
	private String tokenResolverFactoryName;
	
	public ScannerlessParserGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getScannerlessParserClassName());
		this.context = context;
		this.tokenResolverFactoryName = context.getQualifiedTokenResolverFactoryClassName();
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_EMF_TEXT_PARSER + " {");
		sc.addLineBreak();
		addInnerClasses(sc);
		addFields(sc);
		addConstructors(sc);
		addMethods(sc);
		addMethodsForRules(sc);
		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

	private void addInnerClasses(StringComposite sc) {
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
	}

	private void addParseErrorClass(StringComposite sc) {
		sc.add("public static class ParseError {");
		sc.add("private " + STRING + " message;");
		sc.add("private int offset;");
		sc.addLineBreak();
		sc.add("public ParseError(" + STRING + " message, int offset) {");
		sc.add("this.message = message;");
		sc.add("this.offset = offset;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + STRING + " getMessage() {");
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

	private void addObjectCompletedCommandClass(StringComposite sc) {
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
		sc.add(I_TEXT_RESOURCE + " resource = getResource();");
		sc.add("if (resource != null) {");
		sc.add("// the resource can be null if the parser is used for");
		sc.add("// code completion");
		sc.add(E_OBJECT + " currentContainer = context.getCurrentContainer();");
		sc.add("setLocalizationInfo(currentContainer, start, end);");
		sc.add("}");
		sc.add("context.popCurrentContainer();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addSetLocalizationInfoMethod(StringComposite sc) {
		sc.add("public void setLocalizationInfo(" + E_OBJECT + " object, int start, int end) {");
		sc.add("// the resource may be null if the parse is used in standalone mode");
		sc.add("if (resource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(INTEGER + "[] lineAndPosition = " + STRING_UTIL + ".getLineAndCharPosition(content, start);");
		sc.add("int line = lineAndPosition[0];");
		sc.add("int column = lineAndPosition[1];");
		sc.add("final " + I_LOCATION_MAP + " locationMap = resource.getLocationMap();");
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

	private void addAddProxyCommandClass(StringComposite sc) {
		sc.add("public class AddProxyCommand<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> implements ICommand {");
		sc.addLineBreak();
		sc.add("private int featureID;");
		sc.add("private int start;");
		sc.add("private int end;");
		sc.add("private " + STRING + " tokenName;");
		sc.add("private " + E_CLASS + " proxyClass;");
		sc.add("private " + I_REFERENCE_RESOLVER + "<ContainerType, ReferenceType> referenceResolver;");
		sc.addLineBreak();

		sc.add("public AddProxyCommand(int start, int end, String tokenName, int featureID, " + E_CLASS + " proxyClass, " + I_REFERENCE_RESOLVER + "<ContainerType, ReferenceType> referenceResolver) {");
		sc.add("this.start = start;");
		sc.add("this.end = end;");
		sc.add("this.tokenName = tokenName;");
		sc.add("this.featureID = featureID;");
		sc.add("this.proxyClass = proxyClass;");
		sc.add("this.referenceResolver = referenceResolver;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void execute(ICommandContext context) {");
		sc.add(STRING + " match = content.substring(start, end);");
		sc.add(E_OBJECT + " currentObject = context.getCurrentObject();");
		sc.add("// call token resolver");
		sc.add(I_TOKEN_RESOLVER + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(I_TOKEN_RESOLVE_RESULT + " result = getFreshTokenResolveResult();");
		sc.add(E_STRUCTURAL_FEATURE + " feature = currentObject.eClass().getEStructuralFeature(featureID);");
		sc.add("tokenResolver.resolve(match, feature, result);");
		sc.add(OBJECT + " resolvedObject = result.getResolvedToken();");
		sc.add("if (resolvedObject == null) {");
		sc.add("// add error to resource");
		sc.add("addErrorToResource(result.getErrorMessage(), start, end);");
		sc.add("} else {");
		sc.add("// call reference resolver (feature is a non-containment reference)");
    	sc.add(STRING + " resolvedString = (" + STRING + ") resolvedObject;");
    	sc.add(E_OBJECT + " proxyObject = proxyClass.getEPackage().getEFactoryInstance().create(proxyClass);"); 
    	//sc.add("collectHiddenTokens(element);");
    	sc.add("registerContextDependentProxy(new " + 
    			ContextDependentURIFragmentFactory.class.getName() + 
    			"<ContainerType, ReferenceType>(referenceResolver), (ContainerType) currentObject, (" + E_REFERENCE + ") feature, resolvedString, proxyObject);");
		sc.add("// add proxy");
		sc.add("assert feature instanceof " + E_REFERENCE + ";");
		sc.add("addObjectToFeature(currentObject, proxyObject, featureID);");
		sc.add("setLocalizationInfo(proxyObject, start, end);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		generatorUtil.addRegisterContextDependentProxyMethod(sc, false);
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetAttributeValueCommandClass(StringComposite sc) {
		sc.add("public class SetAttributeValueCommand implements ICommand {");
		sc.addLineBreak();
		sc.add("private int featureID;");
		sc.add("private int start;");
		sc.add("private int end;");
		sc.add("private " + STRING + " tokenName;");
		sc.addLineBreak();

		sc.add("public SetAttributeValueCommand(int start, int end, String tokenName, int featureID) {");
		sc.add("this.start = start;");
		sc.add("this.end = end;");
		sc.add("this.tokenName = tokenName;");
		sc.add("this.featureID = featureID;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void execute(ICommandContext context) {");
		sc.add(STRING + " match = content.substring(start, end);");
		sc.add(E_OBJECT + " currentObject = context.getCurrentObject();");
		sc.add("// call token resolver");
		sc.add(I_TOKEN_RESOLVER + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(I_TOKEN_RESOLVE_RESULT + " result = getFreshTokenResolveResult();");
		sc.add(E_STRUCTURAL_FEATURE + " feature = currentObject.eClass().getEStructuralFeature(featureID);");
		sc.add("tokenResolver.resolve(match, feature, result);");
		sc.add(OBJECT + " resolvedObject = result.getResolvedToken();");
		sc.add("if (resolvedObject == null) {");
		sc.add("// add error to resource");
		sc.add("addErrorToResource(result.getErrorMessage(), start, end);");
		sc.add("} else {");
		sc.add("// add proxy (if feature is a non-containment reference)");
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

	private void addMethods(StringComposite sc) {
		addCreateInstanceMethod(sc);
		addGetResourceMethod(sc);
		addParseMethod(sc);
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
		generatorUtil.addAddMapEntryMethod(sc);
		generatorUtil.addAddObjectToListMethod(sc);
		generatorUtil.addGetFreshTokenResolveResultMethod(sc);
		generatorUtil.addGetReferenceResolverSwitchMethod(context, sc);
		// this is the two parameter version
		addAddErrorToResourceMethod(sc);
		// this is the four parameter version
		generatorUtil.addAddErrorToResourceMethod(sc);
		addAddParseErrorToResourceMethod(sc);
		addSetLocalizationInfoMethod(sc);
		addSetScanModeMethod(sc);
		addGetTokenNamesMethod(sc);
		addGetTokensMethod(sc);
		addAddCommandMethod(sc);
		addAddTokenMethod(sc);
	}

	private void addAddCommandMethod(StringComposite sc) {
		sc.add("public void addCommand(ICommand command) {");
		sc.add("// if the parser is in scan mode the command can be thrown away");
		sc.add("if (!scanMode) {");
		sc.add("commands.add(command);");
		sc.add("}");
		sc.add("}");
	}

	private void addAddTokenMethod(StringComposite sc) {
		sc.add("public void addToken(final " + STRING + " tokenName, final int offset, final int length) {");
		sc.add("// only if the parser is in scan mode the tokens are collected");
		sc.add("if (scanMode) {");
		sc.add("tokens.add(new " + I_TEXT_TOKEN + "() {");
		sc.add("public boolean canBeUsedForSyntaxHighlighting() {");
		sc.add("return true;");
		sc.add("}");

		sc.add("public int getLength() {");
		sc.add("return length;");
		sc.add("}");

		sc.add("public " + STRING + " getName() {");
		sc.add("return tokenName;");
		sc.add("}");

		sc.add("public int getOffset() {");
		sc.add("return offset;");
		sc.add("}");
		
		sc.add("});");
		sc.add("}");
		sc.add("}");
	}

	private void addGetTokenNamesMethod(StringComposite sc) {
		sc.add("public " + STRING + "[] getTokenNames() {");
		sc.add("return tokenNames;");
		sc.add("}");
	}

	private void addGetTokensMethod(StringComposite sc) {
		sc.add("public " + LIST + "<" + I_TEXT_TOKEN + "> getTokens() {");
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
		sc.add("public void addErrorToResource(" + STRING + " message, int start, int end) {");
		sc.add("int line = " + STRING_UTIL + ".getLine(content, start);");
		sc.add("int charPositionInLine  = " + STRING_UTIL + ".getCharPositionInLine(content, start);");
		sc.add("addErrorToResource(message, line, charPositionInLine, start, end);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDiscardCommandsMethod(StringComposite sc) {
		sc.add("public void discardCommands(int index) {");
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
		sc.add("public void addObjectToFeature(" + E_OBJECT + " container, " + OBJECT + " object, int featureConstant) {");
		sc.add(E_STRUCTURAL_FEATURE + " eFeature = container.eClass().getEStructuralFeature(featureConstant);");
		sc.add("if (eFeature.getUpperBound() == 1) {");
		sc.add("if (" + MAP + ".Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {");
		sc.add("addMapEntry(container, eFeature, (" + DUMMY_E_OBJECT +") object);");
		sc.add("} else {");
		sc.add("container.eSet(eFeature, object);");
		sc.add("}");
		sc.add("} else {");
		sc.add("if (" + MAP + ".Entry.class.getName().equals(eFeature.getEType().getInstanceClassName())) {");
		sc.add("addMapEntry(container, eFeature, (" + DUMMY_E_OBJECT +") object);");
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
		sc.add("public " + STRING + " matchesRegexp(" + PATTERN + " pattern, String name, boolean isUnusedToken) {");
		sc.add(STRING + " tail = content.substring(offset);");
		sc.add(MATCHER + " matcher = pattern.matcher(tail);");
		sc.add("boolean matches = matcher.find();");
		//sc.add("String found = null;");
		//sc.add("System.out.println(\"Remaining input : \\\"\" + tail + \"\\\"\");");
		//sc.add("System.out.print(\"Trying to match \" + name + \" at \" + offset + \" -> \" + matches);");
		sc.add("if (matches) {");
		sc.add("int start = matcher.start();");
		sc.add("int end = matcher.end();");
		sc.add(STRING + " match = tail.substring(start, end);");
		sc.add("addToken(name, offset, end - start);");
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

	private void addMatchUnusedTokensMethod(StringComposite sc) {
		sc.add("public boolean matchUnusedTokens() {");
		sc.add("while (true) {");
		sc.add("boolean found = false;");
		ConcreteSyntax syntax = context.getConcreteSyntax();
		for (TokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (tokenDefinition.isHidden()) {
				String field = getFieldName(tokenDefinition);
				sc.add("// TODO add tokens to collect-in features");
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
		sc.add("public " + STRING + " matchesUsedToken(" + PATTERN + " pattern, " + STRING + " name, " + STRING + " tokenName) {");
		sc.add(STRING + " match = matchesRegexp(pattern, name, false);");
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
		sc.add("public boolean matches(" + STRING + " keyword) {");
		sc.add("boolean matches = content.startsWith(keyword, offset);");
		sc.add("if (matches) {");
		sc.add("addToken(keyword, offset, keyword.length());");
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
		sc.add("public void setResource(" + I_TEXT_RESOURCE + " resource) {");
		sc.add("this.resource = resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseToExpectedElementsMethod(StringComposite sc) {
		sc.add("public " + LIST + "<" + I_EXPECTED_ELEMENT + "> parseToExpectedElements(" + E_CLASS + " type) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addParseMethod(StringComposite sc) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		boolean forceEOFToken = OptionManager.INSTANCE.getBooleanOptionValue(syntax, OptionTypes.FORCE_EOF);

		sc.add("public " + E_OBJECT + " parse() {");
		sc.add("parseError = null;");
		sc.add("boolean tryOtherStartSymbols = true;");
		for (GenClass startSymbol : syntax.getActiveStartSymbols()) {
			sc.add("// try start symbol: " + startSymbol.getName());
			sc.add("if (tryOtherStartSymbols) {");
			sc.add("offset = 0;");
			sc.add("offsetIgnoringUnusedTokens = 0;");
			sc.add("commands = new " + LINKED_LIST + "<ICommand>();");
			sc.add("tokens = new " + LINKED_LIST + "<" + I_TEXT_TOKEN + ">();");
			sc.add("boolean success = " + getRuleName(startSymbol) + "();");
			sc.add("if (success) {");
			if (forceEOFToken) {
				sc.add("if (offset == content.length()) {");
				sc.add("// the content was successfully parse up to the last character, we do not need to try something else");
				sc.add("tryOtherStartSymbols = false;");
				sc.add("} else {");
				sc.add("addParseError(new ParseError(\"EOF (end of file) expected.\", offset));");
				sc.add("}");
			}
			sc.add("} else {");
			sc.add("}");
			sc.add("}");
		}
		sc.add("// build content tree by executing commands");
		sc.add("ICommandContext context = new CommandContext();");
		sc.add("// do not execute the last pop container command to obtain");
		sc.add("// the root element");
		sc.add("for (int c = 0; c < commands.size() - 1; c++) {");
		sc.add("ICommand command = commands.get(c);");
		sc.add("command.execute(context);");
		sc.add("}");
		sc.add("commands = null;");
		sc.add("if (!tryOtherStartSymbols) {");
		sc.add("parseError = null;");
		sc.add("}");
		sc.add("addParseErrorToResource();");
		sc.add("// return root element");
		sc.add("return context.getCurrentContainer();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod(StringComposite sc) {
		sc.add("public " + I_TEXT_RESOURCE + " getResource() {");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor1(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super(null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateInstanceMethod(StringComposite sc) {
		sc.add("public " + I_TEXT_PARSER + " createInstance(" + INPUT_STREAM + " inputStream, " + STRING + " encoding) {");
		sc.add("return new " + getResourceClassName() + "(inputStream, encoding);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + INPUT_STREAM + " inputStream, " + STRING + " encoding) {");
		sc.add("super(null);");
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

	private void addFields(StringComposite sc) {
		sc.add("private " + INPUT_STREAM_READER + " inputStream;");
		sc.add("// the current position in the content");
		sc.add("private int offset;");
		sc.add("private boolean scanMode = false;");
		sc.add("// the current position in the content (ignoring trailing unused tokens (e.g., whitespaces)");
		sc.add("private int offsetIgnoringUnusedTokens;");
		sc.add("private " + STRING + " content = \"\";");
		sc.add("private " + LINKED_LIST + "<ICommand> commands;");
		sc.add("private " + I_TOKEN_RESOLVER_FACTORY + " tokenResolverFactory = new " + tokenResolverFactoryName + "();");
		sc.add("private " + TOKEN_RESOLVE_RESULT + " tokenResolveResult = new " + TOKEN_RESOLVE_RESULT + "();");
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private " + I_TEXT_RESOURCE + " resource;");
		sc.add("private ParseError parseError;");
		sc.add("private " + LIST + "<" + I_TEXT_TOKEN + "> tokens;");
		sc.addLineBreak();
		
		addTokensField(sc);
		sc.addLineBreak();
		addTokenPatterns(sc);
		sc.addLineBreak();
	}

	private void addTokenPatterns(StringComposite sc) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		List<String> tokenNames = new ArrayList<String>();
		List<TokenDefinition> tokens = syntax.getActiveTokens();
		for (TokenDefinition tokenDefinition : tokens) {
			String fieldName = getFieldName(tokenDefinition);
			String regex = tokenDefinition.getRegex();
			String tokenName = tokenDefinition.getName();
			tokenNames.add("\"" + tokenName + "\"");
			if ("TEXT".equals(tokenName)) {
				regex = "[a-zA-Z]+";
			} else if ("WHITESPACE".equals(tokenName)) {
				regex = "[ \\\\t]";
			} else if ("COMMENT".equals(tokenName)) {
				regex = "//.*[\\\\n\\\\r]";
			} else if ("LINEBREAK".equals(tokenName)) {
				regex = "[\\\\n\\\\r]";
			} else {
				continue;
			}
			// the \a is needed to indicate the the begin of the input must be matched
			regex = "\\\\A" + regex;
			sc.add("private final static " + PATTERN + " " + fieldName + " = " + PATTERN + ".compile(\"" + regex + "\");");
		}
	}
	
	private void addTokensField(StringComposite sc) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		Set<String> tokenNames = new LinkedHashSet<String>();
		List<TokenDefinition> tokens = syntax.getActiveTokens();
		for (TokenDefinition tokenDefinition : tokens) {
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
		sc.add("private final static " + STRING + "[] tokenNames = new " + STRING + "[] {" + StringUtil.explode(tokenNames, ",") + "};");
	}

	private String getFieldName(TokenDefinition tokenDefinition) {
		return "TOKEN_" + tokenDefinition.getName();
	}

	private void addMethodsForRules(StringComposite sc) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		List<Rule> rules = syntax.getAllRules();
		for (Rule rule : rules) {
			addMethodForRule(sc, syntax, rule);
		}
	}

	private void addMethodForRule(StringComposite sc, ConcreteSyntax syntax, Rule rule) {
		GenClass metaclass = rule.getMetaclass();

		sc.add("public boolean " + getRuleName(metaclass) + "() {");
		Choice choice = rule.getDefinition();
		sc.add(E_CLASS + " eClass = " + genClassUtil.getAccessor(metaclass) + ";");
		sc.add("int commandIndexBackup = commands.size();");
		sc.add("int tokenIndexBackup = tokens.size();");
		sc.add("int startOffset = offset;");
		sc.add("addCommand(new CreateObjectCommand(eClass));");
		sc.add("boolean success = " + getMethodName(choice) + "();");
		sc.add("if (success) {");
		sc.add("addCommand(new ObjectCompletedCommand(startOffset, offsetIgnoringUnusedTokens - 1));");
		sc.add("return true;");
		sc.add("} else {");
		sc.add("discardCommands(commandIndexBackup);");
		sc.add("discardTokens(tokenIndexBackup);");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		addMethodForChoice(sc, syntax, metaclass, choice);
	}

	private void addMethodForChoice(StringComposite sc, ConcreteSyntax syntax,
			GenClass ruleMetaClass, Choice choice) {

		sc.add("public boolean " + getMethodName(choice) + "() {");
		addCodeForChoice(sc, choice);
		sc.add("}");
		sc.addLineBreak();
		
		for (Sequence option : choice.getOptions()) {
			addMethodForSequence(sc, syntax, ruleMetaClass, option);
		}
	}

	private void addCodeForChoice(StringComposite sc, Choice choice) {
		List<Sequence> options = choice.getOptions();
		sc.add("// begin options");
		for (Sequence option : options) {
			sc.add("if (" + getMethodName(option) + "()) {");
			sc.add("return true;");
			sc.add("}");
		}
		sc.add("// end options");
		sc.add("return false;");
	}

	private void addMethodForSequence(StringComposite sc, ConcreteSyntax syntax,
			GenClass ruleMetaClass, Sequence sequence) {

		sc.add("public boolean " + getMethodName(sequence) + "() {");
		sc.add("boolean matchedAll = true;");
		sc.add("int offsetCopy = offset;");
		List<Definition> parts = sequence.getParts();
		for (Definition part : parts) {
			sc.add("// begin part");
			if (part instanceof CardinalityDefinition) {
				CardinalityDefinition cd = (CardinalityDefinition) part;
				addCardinalityCode(sc, syntax, cd);
			} else if (part instanceof CsString) {
				addCodeForCsString(sc, (CsString) part);
			} else if (part instanceof WhiteSpaces) {
				// do nothing
			} else if (part instanceof LineBreak) {
				// do nothing
			} else {
				throw new RuntimeException("Found unknown subclass " + part.getClass().getName());
			}
			sc.add("if (!matchedAll) {");
			sc.add("// stop matching the sequence");
			sc.add("offset = offsetCopy;");
			sc.add("return false;");
			sc.add("}");
		}
		sc.add("// this sequence is valid");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		
		for (Definition definition : parts) {
			if (definition instanceof CardinalityDefinition) {
				addMethodForCardinality(sc, syntax, ruleMetaClass, (CardinalityDefinition) definition);
			}
		}
	}

	private void addMethodForCardinality(StringComposite sc, ConcreteSyntax syntax,
			GenClass ruleMetaClass, CardinalityDefinition definition) {

		Cardinality cardinality = definition.getCardinality();

		sc.add("public boolean " +  getMethodName(definition) + "() {");
		sc.add("boolean matched = true;");
		if (cardinality == null) {
			// cardinality == 1
			addCodeForElementWithCardinality(sc, syntax, ruleMetaClass, definition);
			sc.add("return matched;");
		} else if (cardinality instanceof STAR) {
			// cardinality == 0..*
			sc.add("while (matched) {");
			addCodeForElementWithCardinality(sc, syntax, ruleMetaClass, definition);
			sc.add("}");
			sc.add("return true;");
		} else if (cardinality instanceof PLUS) {
			// cardinality == 1..*
			sc.add("boolean matchedAtLeastOnce = false;");
			sc.add("while (matched) {");
			addCodeForElementWithCardinality(sc, syntax, ruleMetaClass, definition);
			sc.add("matchedAtLeastOnce |= matched;");
			sc.add("}");
			sc.add("return matchedAtLeastOnce;");
		} else if (cardinality instanceof QUESTIONMARK) {
			// cardinality == 0..1
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

	private void addMethodForCompound(StringComposite sc,
			ConcreteSyntax syntax, GenClass ruleMetaClass, CompoundDefinition compound) {

		addMethodForChoice(sc, syntax, ruleMetaClass, compound.getDefinitions());
	}

	private void addCardinalityCode(StringComposite sc, ConcreteSyntax syntax, CardinalityDefinition cd) {
		sc.add("matchedAll = " + getMethodName(cd) + "();");
	}

	private void addCodeForElementWithCardinality(StringComposite sc, ConcreteSyntax syntax, GenClass ruleMetaClass, CardinalityDefinition cd) {
		if (cd instanceof Terminal) {
			addCodeForTerminal(sc, syntax, ruleMetaClass, (Terminal) cd);
		} else if (cd instanceof CompoundDefinition) {
			addCodeForCompoundDefinition(sc, syntax, (CompoundDefinition) cd);
		} else {
			throw new RuntimeException("Found unknown subclass " + cd.getClass().getName());
		}
	}

	private void addCodeForCompoundDefinition(StringComposite sc,
			ConcreteSyntax syntax, CompoundDefinition cd) {
		sc.add("// handle compound definition");
		Choice choice = cd.getDefinitions();
		sc.add("matched = " + getMethodName(choice) + "();");
	}

	private void addMethodForContainment(StringComposite sc, ConcreteSyntax syntax, GenClass ruleMetaClass, Containment containment) {
		final GenFeature genFeature = containment.getFeature();
		final GenClass featureType = genFeature.getTypeGenClass();

		sc.add("public boolean " + getMethodName(containment) + "() {");
		sc.add("int offsetCopy = this.offset;");
		
		// TODO I'm not quite sure whether this is the expected behavior.
		// Do we add all subclasses as alternative even if the type of the
		// reference is not abstract?
		Collection<GenClass> alternatives = generatorUtil.getSubClassesWithSyntax(featureType, syntax);
		if (genClassUtil.isConcrete(featureType) && 
			generatorUtil.hasSyntax(featureType, syntax)) {
			alternatives.add(featureType);
		}
		for (GenClass genClass : alternatives) {
			sc.add("// try subclass " + genClass.getName());
			sc.add("{");
			sc.add("// restore old offset");
			sc.add("this.offset = offsetCopy;");
			sc.add("boolean success = " + getRuleName(genClass) + "();");
			sc.add("if (success) {");
			sc.add("// add command to add element to the containment reference");
			sc.add("addCommand(new AddContainedObjectCommand(" + generatorUtil.getFeatureConstant(ruleMetaClass, genFeature) + "));");
			sc.add("return true;");
			sc.add("}");
			sc.add("}");
		}
		sc.add("// no subclass matched");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCodeForCsString(StringComposite sc, CsString csString) {
		String value = csString.getValue();
		sc.add("// match cs string \"" + value + "\"");
		sc.add("matchedAll &= matches(\"" + value + "\");");
	}

	private void addCodeForTerminal(StringComposite sc, ConcreteSyntax syntax, GenClass ruleMetaClass, Terminal terminal) {
		if (terminal instanceof Placeholder) {
			Placeholder defaultTokenTerminal = (Placeholder) terminal;
			TokenDefinition tokenDefinition = defaultTokenTerminal.getToken();
			String regexp = tokenDefinition.getRegex();
			sc.add("// match regexp \"" + regexp + "\"");
			String fieldName = getFieldName(tokenDefinition);
			String tokenName = tokenDefinition.getName();
			sc.add("int offsetBeforeMatch = offset;");
			sc.add("String match = matchesUsedToken(" + fieldName + ", \"" + fieldName+ "\", \"" + tokenName + "\");");
			sc.add("matched &= (match != null);");
			sc.add("if (matched) {");
			GenFeature genFeature = terminal.getFeature();
			final String featureConstant = generatorUtil.getFeatureConstant(ruleMetaClass, genFeature);
			if (genFeature.getEcoreFeature() instanceof EAttribute) {
				sc.add("addCommand(new SetAttributeValueCommand(offsetBeforeMatch, offsetBeforeMatch + match.length(), \"" + tokenDefinition.getName() + "\", " + featureConstant + "));");
			} else if (genFeature.getEcoreFeature() instanceof EReference) {
				// find a sub type that can be instantiated as a proxy
				GenClass instanceType = genFeature.getTypeGenClass();
		    	GenClass proxyType = null;
		    	
		    	if (genClassUtil.isNotConcrete(instanceType)) {
		    		Collection<GenClass> allSubclasses = genClassFinder.findAllSubclasses(syntax, instanceType);
		    		for (GenClass subClass : allSubclasses) {
		    			if (genClassUtil.isConcrete(subClass)) {
			            	proxyType = subClass;
			            	break;
						}
		    		}
		    	} else {
		    		proxyType = instanceType;
		    	}
				String proxyResolver = context.getReferenceResolverAccessor(genFeature);
				sc.add("addCommand(new AddProxyCommand<" + genClassFinder.getQualifiedInterfaceName(genFeature.getGenClass()) + ", " + genClassFinder.getQualifiedInterfaceName(instanceType) + ">(offsetBeforeMatch, offsetBeforeMatch + match.length(), \"" + tokenDefinition.getName() + "\", " + featureConstant + ", " + genClassUtil.getAccessor(proxyType) + ", " + proxyResolver + "));");
            	context.addNonContainmentReference(genFeature);
			} else {
				throw new RuntimeException("Found unknown feature type for terminal.");
			}
			sc.add("}");
		} else if (terminal instanceof Containment) {
			Containment containment = (Containment) terminal;
			addCodeForContainment(sc, syntax, containment);
		} else {
			throw new RuntimeException("Found unknown subclass " + terminal.getClass().getName());
		}
	}

	private void addCodeForContainment(StringComposite sc, ConcreteSyntax syntax, Containment containment) {
		sc.add("// handle containment reference '" + containment.getFeature().getName() + "'");
		sc.add("matched &= " + getMethodName(containment) + "();");
	}

	private String getMethodName(Containment containment) {
		Sequence parent = (Sequence) containment.eContainer();
		int index = getIndex(containment, parent);
		if (parent != null) {
			return getMethodName(parent) + "_containment" + index;
		}
		return null;
	}

	private String getRuleName(GenClass metaClass) {
		// TODO use fully qualified name
		return "parse_" + metaClass.getName();
	}

	private String getMethodName(CardinalityDefinition cd) {
		Sequence parent = (Sequence) cd.eContainer();
		int index = getIndex(cd, parent);
		if (parent != null) {
			Cardinality cardinality = cd.getCardinality();
			if (cd instanceof Terminal) {
				return getMethodName(parent) + "_terminal_" + getName(cardinality) + index;
			} else if (cd instanceof CompoundDefinition) {
				return getMethodName(parent) + "_compound_" + getName(cardinality) + index;
			} else {
				throw new RuntimeException("Found unknown subclass " + cd.getClass().getName());
			}
		} else {
			throw new RuntimeException("Parent is null.");
		}
	}

	private String getName(Cardinality cardinality) {
		if (cardinality == null) {
			return "ONE";
		} else if (cardinality instanceof PLUS) {
			return "PLUS";
		} else if (cardinality instanceof STAR) {
			return "STAR";
		} else if (cardinality instanceof QUESTIONMARK) {
			return "QUESTIONMARK";
		} else {
			throw new RuntimeException("Found unknown cardinality " + cardinality.getClass().getName());
		}
	}

	private String getMethodName(Sequence sequence) {
		Choice parent = (Choice) sequence.eContainer();
		int index = getIndex(sequence, parent);
		if (parent != null) {
			return getMethodName(parent) + "_sequence" + index;
		} else {
			throw new RuntimeException("Parent is null.");
		}
	}

	private String getMethodName(Choice choice) {
		EObject parent = (EObject) choice.eContainer();
		if (parent instanceof Rule) {
			Rule rule = (Rule) parent;
			return getRuleName(rule.getMetaclass()) + "_choice";
		} else if (parent instanceof Sequence) {
			int index = getIndex(choice, parent);
			return getMethodName((Sequence) parent) + "_choice" + index;
		} else if (parent instanceof CompoundDefinition) {
			return getMethodName((CompoundDefinition) parent) + "_compound";
		} else {
			throw new RuntimeException("Found unknown subclass " + parent.getClass().getName());
		}
	}

	private int getIndex(EObject object, EObject parent) {
		EStructuralFeature feature = object.eContainingFeature();
		return ((List<?>) parent.eGet(feature)).indexOf(object);
	}
}
