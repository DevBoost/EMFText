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
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_EXPECTED_ELEMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_REFERENCE_RESOLVER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_PARSER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_RESOURCE;
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
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TOKEN_RESOLVE_RESULT;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.impl.ContextDependentURIFragmentFactory;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
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
public class PackratParserGenerator extends BaseGenerator {
	
	private final GenClassUtil genClassUtil = new GenClassUtil();
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	
	private GenerationContext context;
	private String tokenResolverFactoryName;
	
	public PackratParserGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getPackratParserClassName());
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
	}

	private void addPopContainerCommandClass(StringComposite sc) {
		sc.add("public static class PopContainerCommand implements ICommand {");
		sc.add("public void execute(ICommandContext context) {");
		//sc.add("System.out.println(\"POP\");");
		sc.add("context.popCurrentContainer();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddProxyCommandClass(StringComposite sc) {
		sc.add("public class AddProxyCommand<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> implements ICommand {");
		sc.addLineBreak();
		sc.add("private int featureID;");
		sc.add("private " + STRING + " match;");
		sc.add("private " + STRING + " tokenName;");
		sc.add("private " + E_CLASS + " proxyClass;");
		sc.add("private " + I_REFERENCE_RESOLVER + "<ContainerType, ReferenceType> referenceResolver;");
		sc.addLineBreak();

		sc.add("public AddProxyCommand(String match, String tokenName, int featureID, " + E_CLASS + " proxyClass, " + I_REFERENCE_RESOLVER + "<ContainerType, ReferenceType> referenceResolver) {");
		sc.add("this.match = match;");
		sc.add("this.tokenName = tokenName;");
		sc.add("this.featureID = featureID;");
		sc.add("this.proxyClass = proxyClass;");
		sc.add("this.referenceResolver = referenceResolver;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void execute(ICommandContext context) {");
		//sc.add("System.out.println(\"ADD MATCH \" + featureID);");
		sc.add(E_OBJECT + " currentObject = context.getCurrentObject();");
		sc.add("// TODO call token resolver");
		sc.add(I_TOKEN_RESOLVER + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(I_TOKEN_RESOLVE_RESULT + " result = getFreshTokenResolveResult();");
		sc.add(E_STRUCTURAL_FEATURE + " feature = currentObject.eClass().getEStructuralFeature(featureID);");
		sc.add("tokenResolver.resolve(match, feature, result);");
		sc.add(OBJECT + " resolvedObject = result.getResolvedToken();");
		sc.add("if (resolvedObject == null) {");
		sc.add("// TODO add error to resource");
		//sc.add("addErrorToResource(result.getErrorMessage(), ((" + COMMON_TOKEN + ") " + ident + ").getLine(), ((" + COMMON_TOKEN + ") " + ident + ").getCharPositionInLine(), ((" + COMMON_TOKEN + ") " + ident + ").getStartIndex(), ((" + COMMON_TOKEN + ") " + ident + ").getStopIndex());");
		sc.add("} else {");
		sc.add("// TODO call reference resolver (feature is a non-containment reference)");
		//sc.add(STRING + "targetTypeName = " + STRING + ".class.getName()");
    	sc.add(STRING + " resolvedString = (" + STRING + ") resolvedObject;");
    	sc.add(E_OBJECT + " proxyObject = proxyClass.getEPackage().getEFactoryInstance().create(proxyClass);"); 
    	//sc.add("collectHiddenTokens(element);");
    	sc.add("registerContextDependentProxy(new " + 
    			ContextDependentURIFragmentFactory.class.getName() + 
    			"<ContainerType, ReferenceType>(referenceResolver), (ContainerType) currentObject, (" + E_REFERENCE + ") feature, resolvedString, proxyObject);");
		sc.add("// add proxy");
		sc.add("assert feature instanceof " + E_REFERENCE + ";");
		sc.add("System.out.println(\"ADD \" + proxyObject + \" TO \" + currentObject + \".\" + featureID);");
		sc.add("addObjectToFeature(currentObject, proxyObject, featureID);");
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
		sc.add("private " + STRING + " match;");
		sc.add("private " + STRING + " tokenName;");
		sc.addLineBreak();

		sc.add("public SetAttributeValueCommand(String match, String tokenName, int featureID) {");
		sc.add("this.match = match;");
		sc.add("this.tokenName = tokenName;");
		sc.add("this.featureID = featureID;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void execute(ICommandContext context) {");
		//sc.add("System.out.println(\"ADD MATCH \" + featureID);");
		sc.add(E_OBJECT + " currentObject = context.getCurrentObject();");
		sc.add("// TODO call token resolver");
		sc.add(I_TOKEN_RESOLVER + " tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);");
		sc.add("tokenResolver.setOptions(getOptions());");
		sc.add(I_TOKEN_RESOLVE_RESULT + " result = getFreshTokenResolveResult();");
		sc.add(E_STRUCTURAL_FEATURE + " feature = currentObject.eClass().getEStructuralFeature(featureID);");
		sc.add("tokenResolver.resolve(match, feature, result);");
		sc.add(OBJECT + " resolvedObject = result.getResolvedToken();");
		sc.add("if (resolvedObject == null) {");
		sc.add("// TODO add error to resource");
		//sc.add("addErrorToResource(result.getErrorMessage(), ((" + COMMON_TOKEN + ") " + ident + ").getLine(), ((" + COMMON_TOKEN + ") " + ident + ").getCharPositionInLine(), ((" + COMMON_TOKEN + ") " + ident + ").getStartIndex(), ((" + COMMON_TOKEN + ") " + ident + ").getStopIndex());");
		sc.add("} else {");
		sc.add("// TODO call reference resolver (if feature is a non-containment reference)");
		sc.add("// set feature value");
		sc.add("assert feature instanceof " + E_ATTRIBUTE + ";");
		sc.add("System.out.println(\"ADD \" + resolvedObject + \" TO \" + currentObject + \".\" + featureID);");
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
		sc.add("System.out.println(\"ADD \" + object + \" TO \" + container);");
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
		//sc.add("System.out.println(\"CREATING \" + eClass.getName() + \" : \" + object);");
		//sc.add("System.out.println(\"CREATE \" + object);");
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
		//sc.add("System.out.println(\"current object is now \" + newContainer);");
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
		sc.add("public " + E_OBJECT + " getCurrentContainer();");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " getCurrentObject();");
		sc.addLineBreak();
		sc.add("public void pushCurrentContainer(" + E_OBJECT + " newContainer);");
		sc.addLineBreak();
		sc.add("public void popCurrentContainer();");
		sc.addLineBreak();
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
		addAddObjectToFeatureMethod(sc);
		generatorUtil.addAddMapEntryMethod(sc);
		generatorUtil.addAddObjectToListMethod(sc);
		generatorUtil.addGetFreshTokenResolveResultMethod(sc);
		generatorUtil.addGetReferenceResolverSwitchMethod(context, sc);
	}

	private void addDiscardCommandsMethod(StringComposite sc) {
		sc.add("public void discardCommands(int index) {");
		sc.add("commands.subList(index, commands.size()).clear();");
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
		sc.add("public " + STRING + " matchesRegexp(" + PATTERN + " pattern, String name) {");
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
		sc.add("offset = offset + end;");
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
				sc.add("found |= null != matchesRegexp(" + field + ", \"unused " + field + "\");");
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
		sc.add("public " + STRING + " matchesUsedToken(" + PATTERN + " pattern, String name) {");
		sc.add(STRING + " match = matchesRegexp(pattern, name);");
		sc.add("if (match != null) {");
		sc.add("matchUnusedTokens();");
		sc.add("return match;");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMatchesMethod(StringComposite sc) {
		sc.add("public boolean matches(" + STRING + " keyword) {");
		sc.add("boolean matches = content.startsWith(keyword, offset);");
		//sc.add("System.out.println(\"Trying to match \" + keyword + \" at \" + offset + \" -> \" + matches + \"\");");
		sc.add("if (matches) {");
		sc.add("offset += keyword.length();");
		sc.add("matchUnusedTokens();");
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
		sc.add("public " + E_OBJECT + " parse() {");
		for (GenClass startSymbol : context.getConcreteSyntax().getActiveStartSymbols()) {
			sc.add("offset = 0;");
			sc.add("commands = new " + LINKED_LIST + "<ICommand>();");
			sc.add("boolean success = " + getRuleName(startSymbol) + "();");
			sc.add("if (success) {");
			sc.add("ICommandContext context = new CommandContext();");
			sc.add("// do not execute the last pop container command to obtain");
			sc.add("// the root element");
			sc.add("for (int c = 0; c < commands.size() - 1; c++) {");
			sc.add("ICommand command = commands.get(c);");
			sc.add("command.execute(context);");
			sc.add("}");
			sc.add("commands = null;");
			sc.add("// TODO perform this check only only if FORCE_EOF is set");
			sc.add("if (offset == content.length()) {");
			sc.add("// return root element");
			sc.add("return context.getCurrentContainer();");
			sc.add("} else {");
			sc.add("return null;");
			sc.add("}");
			sc.add("}");
		}
		sc.add("return null;");
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
		sc.add("private int offset;");
		sc.add("private " + STRING + " content = \"\";");
		sc.add("private " + LINKED_LIST + "<ICommand> commands;");
		sc.add("private " + I_TOKEN_RESOLVER_FACTORY + " tokenResolverFactory = new " + tokenResolverFactoryName + "();");
		sc.add("private " + TOKEN_RESOLVE_RESULT + " tokenResolveResult = new " + TOKEN_RESOLVE_RESULT + "();");
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private " + I_TEXT_RESOURCE + " resource;");
		sc.addLineBreak();
		
		addTokenPatterns(sc);
		sc.addLineBreak();
	}

	private void addTokenPatterns(StringComposite sc) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		List<TokenDefinition> tokens = syntax.getActiveTokens();
		for (TokenDefinition tokenDefinition : tokens) {
			String fieldName = getFieldName(tokenDefinition);
			String regex = tokenDefinition.getRegex();
			if ("TEXT".equals(tokenDefinition.getName())) {
				regex = "[a-zA-Z]+";
			} else if ("WHITESPACE".equals(tokenDefinition.getName())) {
				regex = "[ ]";
			} else if ("COMMENT".equals(tokenDefinition.getName())) {
				regex = "//.*[\\\\n\\\\r]";
			} else if ("LINEBREAK".equals(tokenDefinition.getName())) {
				regex = "[\\\\n\\\\r]";
			} else {
				continue;
			}
			// the \a is needed to indicate the the begin of the input must be matched
			regex = "\\\\A" + regex;
			sc.add("private final static " + PATTERN + " " + fieldName + " = " + PATTERN + ".compile(\"" + regex + "\");");
		}
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
		sc.add("commands.add(new CreateObjectCommand(eClass));");
		sc.add("boolean success = " + getMethodName(choice) + "();");
		sc.add("if (success) {");
		sc.add("commands.add(new PopContainerCommand());");
		sc.add("return true;");
		sc.add("} else {");
		sc.add("discardCommands(commandIndexBackup);");
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
			sc.add("// TODO backtrack");
			sc.add("return true;");
		} else if (cardinality instanceof PLUS) {
			// cardinality == 1..*
			sc.add("boolean matchedAtLeastOnce = false;");
			sc.add("while (matched) {");
			addCodeForElementWithCardinality(sc, syntax, ruleMetaClass, definition);
			sc.add("matchedAtLeastOnce |= matched;");
			sc.add("}");
			sc.add("// TODO backtrack");
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
			addMethodForContainment(sc, syntax, (Containment) definition);
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

	private void addMethodForContainment(StringComposite sc, ConcreteSyntax syntax, Containment containment) {
		final GenFeature genFeature = containment.getFeature();
		final GenClass featureType = genFeature.getTypeGenClass();
		final EStructuralFeature eFeature = genFeature.getEcoreFeature();

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
			sc.add("// TODO backtrack");
			sc.add("boolean success = " + getRuleName(genClass) + "();");
			sc.add("if (success) {");
			sc.add("// TODO add command to add element to the containment reference");
			sc.add("commands.add(new AddContainedObjectCommand(" + eFeature.getFeatureID() + "));");
			sc.add("return true;");
			sc.add("} else {");
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
			sc.add("String match = matchesUsedToken(" + fieldName + ", \"" + fieldName+ "\");");
			sc.add("matched &= (match != null);");
			sc.add("if (matched) {");
			GenFeature genFeature = terminal.getFeature();
			final String featureConstant = generatorUtil.getFeatureConstant(ruleMetaClass, genFeature);
			if (genFeature.getEcoreFeature() instanceof EAttribute) {
				sc.add("commands.add(new SetAttributeValueCommand(match, \"" + tokenDefinition.getName() + "\", " + featureConstant + "));");
			} else if (genFeature.getEcoreFeature() instanceof EReference) {
				// find a sub type that can be instantiated as a proxy
				GenClass instanceType = genFeature.getTypeGenClass();
		    	GenClass proxyType = null;
		    	
		    	if (genClassUtil.isNotConcrete(instanceType)) {
		    		Collection<GenClass> allSubclasses = new GenClassFinder().findAllSubclasses(syntax, instanceType);
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
				sc.add("commands.add(new AddProxyCommand<" + genFeature.getGenClass().getQualifiedInterfaceName() + ", " + instanceType.getQualifiedInterfaceName() + ">(match, \"" + tokenDefinition.getName() + "\", " + featureConstant + ", " + genClassUtil.getAccessor(proxyType) + ", " + proxyResolver + "));");
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
