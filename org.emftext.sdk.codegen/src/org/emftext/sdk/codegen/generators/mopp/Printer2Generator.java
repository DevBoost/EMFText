package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BUFFERED_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PRINTER_WRITER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.util.StringUtil;

/**
 * A generator for a new experimental printing algorithm that tries
 * to preserve layout information that was gathered during parsing.
 */
public class Printer2Generator extends AbstractPrinterGenerator {

	private static ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private GenClassFinder genClassFinder = new GenClassFinder();
	
	private ConcreteSyntax syntax;
	private String tokenResolverFactoryClassName;
	private String iConfigurableClassName;
	private String syntaxElementDecoratorClassName;
	private String syntaxElementClassName;
	private String grammarInformationProviderClassName;
	private GenClassCache genClassCache;
	
	public Printer2Generator() {
		super();
	}

	private Printer2Generator(GenerationContext context) {
		super(context, EArtifact.PRINTER2);
		syntax = context.getConcreteSyntax();
		genClassCache = syntax.getGenClassCache();
		tokenResolverFactoryClassName = context.getQualifiedClassName(EArtifact.TOKEN_RESOLVER_FACTORY);
		iConfigurableClassName = context.getQualifiedClassName(EArtifact.I_CONFIGURABLE);
		syntaxElementDecoratorClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT_DECORATOR);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		grammarInformationProviderClassName = context.getQualifiedClassName(EArtifact.GRAMMAR_INFORMATION_PROVIDER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new Printer2Generator(context);
	}


	@Override
	public boolean generateJavaContents(StringComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iConfigurableClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		
		return true;
	}

	private void addMethods(StringComposite sc) {
		addPrintRuleMethods(sc);
		addGetDecoratorTreeMethod(sc);
		addDecorateTreeMethod(sc);
		addPrintTreeMethod(sc);
		addInitializePrintCountingMapMethod(sc);
		addGetOptionsMethod(sc);
		addSetOptionsMethod(sc);
		addGetReferenceResolverSwitchMethod(sc);
	}

	private void addGetDecoratorTreeMethod(StringComposite sc) {
		// TODO this trees can be reused
		sc.add("// creates a tree of decorator objects which reflects the syntax tree that is");
		sc.add("// attached to the given syntax element");
		sc.add("public " + syntaxElementDecoratorClassName + " getDecoratorTree(" + syntaxElementClassName + " syntaxElement) {");
		sc.add(syntaxElementClassName + "[] children = syntaxElement.getChildren();");
		sc.add("int childCount = children.length;");
		sc.add(syntaxElementDecoratorClassName + "[] childDecorators = new " + syntaxElementDecoratorClassName + "[childCount];");
		sc.add("for (int i = 0; i < childCount; i++) {");
		sc.add("childDecorators[i] = getDecoratorTree(children[i]);");
		sc.add("}");
		sc.add(syntaxElementDecoratorClassName + " decorator = new " + syntaxElementDecoratorClassName + "(syntaxElement, childDecorators);");
		sc.add("return decorator;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + OUTPUT_STREAM + " outputStream) {");
		sc.add("super();");
		sc.add("this.writer = new " + PRINTER_WRITER + "(new " + BUFFERED_OUTPUT_STREAM + "(outputStream));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + PRINTER_WRITER + " writer;");
		sc.add("private " + MAP + "<?, ?> options;");
		sc.add("private " + getClassNameHelper().getI_TOKEN_RESOLVER_FACTORY() + " tokenResolverFactory = new " + tokenResolverFactoryClassName + "();");
		sc.addLineBreak();
	}

	private void addPrintRuleMethods(StringComposite sc) {
		List<Rule> allRules = syntax.getAllRules();
		for (Rule rule : allRules) {
			addPrintRuleMethod(sc, rule);
			addPrintSyntaxElementMethod(sc, rule.getDefinition());
		}
	}

	private void addPrintSyntaxElementMethod(StringComposite sc, Choice definition) {
		addPrintSyntaxElementMethodBasic(sc, definition);
		List<Sequence> options = definition.getOptions();
		for (Sequence sequence : options) {
			addPrintSyntaxElementMethod(sc, sequence);
		}
	}

	private void addPrintSyntaxElementMethod(StringComposite sc, Sequence sequence) {
		addPrintSyntaxElementMethodBasic(sc, sequence);
		List<Definition> parts = sequence.getParts();
		for (Definition part : parts) {
			addPrintSyntaxElementMethod(sc, part);
		}
	}

	private void addPrintSyntaxElementMethod(StringComposite sc, Definition definition) {
		addPrintSyntaxElementMethodBasic(sc, definition);
		if (definition instanceof CompoundDefinition) {
			CompoundDefinition cd = (CompoundDefinition) definition;
			addPrintRuleMethod(sc, cd);
		}
	}

	private void addPrintRuleMethod(StringComposite sc, CompoundDefinition cd) {
		addPrintSyntaxElementMethodBasic(sc, cd);
		Choice definitions = cd.getDefinitions();
		addPrintSyntaxElementMethod(sc, definitions);
	}

	private void addPrintSyntaxElementMethodBasic(StringComposite sc, EObject syntaxElement) {
		if (syntaxElement instanceof CsString) {
			sc.add("public void print_" + csUtil.getFieldName(syntaxElement) + "() {");
			CsString csString = (CsString) syntaxElement;
			String value = csString.getValue();
			sc.add("writer.write(\"" + StringUtil.escapeToJavaString(value) + "\");");
			sc.add("}");
			sc.addLineBreak();
		} else if (syntaxElement instanceof WhiteSpaces) {
			sc.add("public void print_" + csUtil.getFieldName(syntaxElement) + "() {");
			WhiteSpaces whiteSpace = (WhiteSpaces) syntaxElement;
			int count = whiteSpace.getAmount();
			if (count > 0) {
				String spaces = getWhiteSpaceString(count);
				sc.add("writer.write(\"" + spaces + "\");");
			}
			sc.add("}");
			sc.addLineBreak();
		} else if (syntaxElement instanceof Placeholder) {
			Placeholder placeholder = (Placeholder) syntaxElement;
			GenClassCache genClassCache = syntax.getGenClassCache();
			Rule rule = getContainingRule(placeholder);
			GenClass genClass = rule.getMetaclass();
			GenFeature genFeature = placeholder.getFeature();
			EStructuralFeature feature = genFeature.getEcoreFeature();
			String tokenName = placeholder.getToken().getName();

			String featureConstant = generatorUtil.getFeatureConstant(genClass, genFeature);
			if (feature instanceof EReference) {
				sc.add("// eObject is the container of the attribute or reference value to be printed");
				sc.add("// value is the attribute or reference value to be printed");
				sc.add("public void print_" + csUtil.getFieldName(syntaxElement) + "(" + genClassCache.getQualifiedInterfaceName(genClass) + " eObject, " + OBJECT + " value) {");
				sc.add(getClassNameHelper().getI_TOKEN_RESOLVER() + " resolver = tokenResolverFactory.createTokenResolver(\""
						+ tokenName
						+ "\");");
				sc.add("resolver.setOptions(getOptions());");
				sc.add(STRING + " deResolveResult = resolver.deResolve(" 
						+ getContext().getReferenceResolverAccessor(genFeature)
						+ ".deResolve((" + genClassCache.getQualifiedInterfaceName(genFeature.getTypeGenClass()) + ") value, eObject, (" + E_REFERENCE + ") eObject.eClass().getEStructuralFeature("
						+ featureConstant
						+ ")), eObject.eClass().getEStructuralFeature("
						+ featureConstant
						+ "), eObject);");
			} else {
				sc.add("// eObject is the container of the attribute or reference value to be printed");
				sc.add("// value is the attribute or reference value to be printed");
				sc.add("public void print_" + csUtil.getFieldName(syntaxElement) + "(" + E_OBJECT + " eObject, " + OBJECT + " value) {");
				sc.add(getClassNameHelper().getI_TOKEN_RESOLVER() + " resolver = tokenResolverFactory.createTokenResolver(\""
						+ tokenName
						+ "\");");
				sc.add("resolver.setOptions(getOptions());");
				sc.add(STRING + " deResolveResult = resolver.deResolve(value, eObject.eClass().getEStructuralFeature("
						+ featureConstant
						+ "), eObject);");
			}
			sc.add("writer.write(deResolveResult);");
			sc.add("}");
			sc.addLineBreak();
		}
	}

	private void addPrintRuleMethod(StringComposite sc, Rule rule) {
		GenClass metaclass = rule.getMetaclass();
		sc.add("public void " + getRuleMethodName(metaclass) + "(" + genClassCache.getQualifiedInterfaceName(metaclass) + " eObject) {");
		sc.add(syntaxElementDecoratorClassName + " decoratorTree = getDecoratorTree(" + grammarInformationProviderClassName + "." + csUtil.getFieldName(rule) + ");");
		sc.add("decorateTree(decoratorTree, eObject);");
		sc.add("printTree(decoratorTree, eObject);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDecorateTreeMethod(StringComposite sc) {
		sc.add("public void decorateTree(" + syntaxElementDecoratorClassName + " decoratorTree, " + E_OBJECT + " eObject) {");
		sc.add(MAP + "<" + STRING + ", " + INTEGER + "> printCountingMap = initializePrintCountingMap(eObject);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addInitializePrintCountingMapMethod(StringComposite sc) {
		sc.add("public " + MAP + "<" + STRING + ", " + INTEGER + "> initializePrintCountingMap(" + E_OBJECT + " eObject) {");
		sc.add("// the printCountingMap contains a mapping from feature names to");
		sc.add("// the number of remaining elements that still need to be printed.");
		sc.add("// the map is initialized with the number of elements stored in each structural");
		sc.add("// feature. for lists this is the list size. for non-multiple features it is either");
		sc.add("// 1 (if the feature is set) or 0 (if the feature is null).");
		sc.add(MAP + "<" + STRING + ", " + INTEGER + "> printCountingMap = new " + LINKED_HASH_MAP + "<" + STRING + ", " + INTEGER + ">();");
		sc.add(LIST + "<" + E_STRUCTURAL_FEATURE + "> features = eObject.eClass().getEAllStructuralFeatures();");
		sc.add("for (" + E_STRUCTURAL_FEATURE + " feature : features) {");
		sc.add("int count = 0;");
		sc.add(OBJECT + " featureValue = eObject.eGet(feature);");
		sc.add("if (featureValue != null) {");
		sc.add("if (featureValue instanceof " + LIST + "<?>) {");
		sc.add("count = ((" + LIST + "<?>) featureValue).size();");
		sc.add("} else {");
		sc.add("count = 1;");
		sc.add("}");
		sc.add("}");
		sc.add("printCountingMap.put(feature.getName(), count);");
		sc.add("}");
		sc.add("return printCountingMap;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPrintTreeMethod(StringComposite sc) {
		sc.add("public void printTree(" + syntaxElementDecoratorClassName + " decoratorTree, " + E_OBJECT + " eObject) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getRuleMethodName(GenClass genClass) {
		String ruleName = genClassFinder.getEscapedTypeName(genClass, syntax.getGenClassCache());
		return "print_" + ruleName;
	}

	// TODO mseifert: move this to SyntaxElement.ejava
	private Rule getContainingRule(EObject container) {
		Rule rule = null;
		EObject o = container;
		do {
			if (o instanceof Rule) {
				rule = (Rule) o;
			}
			else {
				o = o.eContainer();
			}
		} while (rule == null && o != null);
		return rule;
	}
}
