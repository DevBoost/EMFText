package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.util.StringUtil;

/**
 * A generator that creates a class that contains the syntax structure given
 * in the CS specification.
 */
public class GrammarInformationProviderGenerator extends JavaBaseGenerator {

	private final static GeneratorUtil generatorUtil = new GeneratorUtil();

	private ConcreteSyntax concreteSyntax;

	private int count;

	public GrammarInformationProviderGenerator() {
		super();
	}

	private GrammarInformationProviderGenerator(GenerationContext context) {
		super(context, EArtifact.GRAMMAR_INFORMATION_PROVIDER_INTERPRETER);
		concreteSyntax = context.getConcreteSyntax();
	}

	@Override
	public boolean generateJavaContents(StringComposite sc) {
		count = 0;
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addInnerClasses(sc);
		
		Map<EObject, String> objectToFieldNameMap = new LinkedHashMap<EObject, String>();
		List<Rule> allRules = concreteSyntax.getAllRules();
		for (Rule rule : allRules) {
			addConstants(sc, objectToFieldNameMap, rule);
		}
		sc.add("}");
		
		return true;
	}

	private void addInnerClasses(StringComposite sc) {
		addSyntaxElementClass(sc);
		addKeywordClass(sc);
		addPlaceholderClass(sc);
		addSequenceClass(sc);
		addChoiceClass(sc);
		addLineBreakClass(sc);
		addWhiteSpacesClass(sc);
		addContainmentClass(sc);
		addRuleClass(sc);
	}

	private void addSyntaxElementClass(StringComposite sc) {
		sc.add("public abstract static class SyntaxElement {");
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addKeywordClass(StringComposite sc) {
		sc.add("public static class Keyword extends SyntaxElement {");
		sc.addLineBreak();
		sc.add("private final String value;"); 
		sc.addLineBreak();
		sc.add("public Keyword(String value) {"); 
		sc.add("this.value = value;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public String getValue() {"); 
		sc.add("return value;"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addLineBreakClass(StringComposite sc) {
		sc.add("public static class LineBreak extends SyntaxElement {");
		sc.addLineBreak();
		sc.add("private final int tabs;"); 
		sc.addLineBreak();
		sc.add("public LineBreak(int tabs) {"); 
		sc.add("this.tabs = tabs;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public int getTabs() {"); 
		sc.add("return tabs;"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addWhiteSpacesClass(StringComposite sc) {
		sc.add("public static class WhiteSpaces extends SyntaxElement {");
		sc.addLineBreak();
		sc.add("private final int amount;"); 
		sc.addLineBreak();
		sc.add("public WhiteSpaces(int amount) {"); 
		sc.add("this.amount = amount;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public int getAmount() {"); 
		sc.add("return amount;"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addPlaceholderClass(StringComposite sc) {
		sc.add("public static class Placeholder extends SyntaxElement {");
		sc.addLineBreak();
		sc.add("private final " + E_STRUCTURAL_FEATURE + " feature;");
		sc.addLineBreak();
		sc.add("public Placeholder(" + E_STRUCTURAL_FEATURE + " feature) {"); 
		sc.add("this.feature = feature;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {");
		sc.add("return feature;");
		sc.add("}"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainmentClass(StringComposite sc) {
		sc.add("public static class Containment extends SyntaxElement {");
		sc.addLineBreak();
		sc.add("private final " + E_STRUCTURAL_FEATURE + " feature;");
		sc.addLineBreak();
		sc.add("public Containment(" + E_STRUCTURAL_FEATURE + " feature) {"); 
		sc.add("this.feature = feature;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {"); 
		sc.add("return feature;"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addChoiceClass(StringComposite sc) {
		sc.add("public static class Choice extends SyntaxElement {");
		sc.addLineBreak();
		sc.add("private final SyntaxElement[] choices;"); 
		sc.addLineBreak();
		sc.add("public Choice(SyntaxElement... choices) {"); 
		sc.add("this.choices = choices;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public SyntaxElement[] getChoices() {"); 
		sc.add("return choices;"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addSequenceClass(StringComposite sc) {
		sc.add("public static class Sequence extends SyntaxElement {");
		sc.addLineBreak();
		sc.add("private final SyntaxElement[] elements;"); 
		sc.addLineBreak();
		sc.add("public Sequence(SyntaxElement... elements) {");
		sc.add("this.elements = elements;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public SyntaxElement[] getElements() {"); 
		sc.add("return elements;"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addRuleClass(StringComposite sc) {
		sc.add("public static class Rule extends SyntaxElement {");
		sc.addLineBreak();
		sc.add("private final " + E_CLASS + " metaclass;"); 
		sc.add("private final Choice choice;"); 
		sc.addLineBreak();
		sc.add("public Rule(" + E_CLASS + " metaclass, Choice choice) {");
		sc.add("this.metaclass = metaclass;");
		sc.add("this.choice = choice;");
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public " + E_CLASS + " getMetaclass() {"); 
		sc.add("return metaclass;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public Choice getDefinition() {"); 
		sc.add("return choice;"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addConstants(StringComposite sc, Map<EObject, String> objectToFieldNameMap, Rule rule) {
		addConstant(sc, objectToFieldNameMap, rule, rule.getDefinition());
		addConstant(sc, objectToFieldNameMap, rule, rule);
	}

	private void addConstant(StringComposite sc, Map<EObject, String> objectToFieldNameMap, Rule rule, EObject next) {
		if (next instanceof CsString) {
			String value = ((CsString) next).getValue();
			String fieldName = getFieldName(objectToFieldNameMap, next);
			sc.add("public final static Keyword " + fieldName + " = new Keyword(\"" + StringUtil.escapeToJavaString(value) + "\");");
		} else if (next instanceof Placeholder) {
			GenFeature feature = ((Placeholder) next).getFeature();
			String featureAccessor = generatorUtil.getFeatureAccessor(rule.getMetaclass(), feature);
			String fieldName = getFieldName(objectToFieldNameMap, next);
			sc.add("public final static Placeholder " + fieldName + " = new Placeholder(" + featureAccessor + ");");
		} else if (next instanceof WhiteSpaces) {
			int amount = ((WhiteSpaces) next).getAmount();
			String fieldName = getFieldName(objectToFieldNameMap, next);
			sc.add("public final static WhiteSpaces " + fieldName + " = new WhiteSpaces(" + amount + ");");
		} else if (next instanceof LineBreak) {
			int amount = ((LineBreak) next).getTab();
			String fieldName = getFieldName(objectToFieldNameMap, next);
			sc.add("public final static LineBreak " + fieldName + " = new LineBreak(\"" + amount + ");");
		} else if (next instanceof Sequence) {
			Sequence sequence = (Sequence) next;
			List<String> elements = new ArrayList<String>();
			List<Definition> parts = sequence.getParts();
			for (Definition part : parts) {
				addConstant(sc, objectToFieldNameMap, rule, part);
				elements.add(getFieldName(objectToFieldNameMap, part));
			}
			String fieldName = getFieldName(objectToFieldNameMap, next);
			sc.add("public final static Sequence " + fieldName + " = new Sequence(" + StringUtil.explode(elements, ", ") + ");");
		} else if (next instanceof Choice) {
			Choice choice = (Choice) next;
			List<String> elements = new ArrayList<String>();
			List<Sequence> parts = choice.getOptions();
			for (Sequence part : parts) {
				addConstant(sc, objectToFieldNameMap, rule, part);
				elements.add(getFieldName(objectToFieldNameMap, part));
			}
			String fieldName = getFieldName(objectToFieldNameMap, next);
			sc.add("public final static Choice " + fieldName + " = new Choice(" + StringUtil.explode(elements, ", ") + ");");
		} else if (next instanceof Containment) {
			Containment containment = (Containment) next;
			GenFeature feature = containment.getFeature();
			String featureAccessor = generatorUtil.getFeatureAccessor(rule.getMetaclass(), feature);
			String fieldName = getFieldName(objectToFieldNameMap, next);
			sc.add("public final static Containment " + fieldName + " = new Containment(" + featureAccessor + ");");
		} else if (next instanceof Rule) {
			Rule nextAsRule = (Rule) next;
			String definitionFieldName = getFieldName(objectToFieldNameMap, nextAsRule.getDefinition());
			String metaClassAccessor = generatorUtil.getClassAccessor(nextAsRule.getMetaclass());
			String fieldName = getFieldName(objectToFieldNameMap, nextAsRule);
			sc.add("public final static Rule " + fieldName + " = new Rule(" + metaClassAccessor + ", "+ definitionFieldName + ");");
		} else {
			assert next instanceof Annotation;
		}
	}

	private String getFieldName(Map<EObject, String> objectToFieldNameMap,
			EObject object) {
		if (!objectToFieldNameMap.containsKey(object)) {
			objectToFieldNameMap.put(object, "ELEMENT_" + count);
			count++;
		}
		return objectToFieldNameMap.get(object);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new GrammarInformationProviderGenerator(context);
	}
}
