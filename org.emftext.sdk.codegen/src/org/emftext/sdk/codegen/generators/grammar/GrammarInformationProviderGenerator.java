package org.emftext.sdk.codegen.generators.grammar;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ECORE_FACTORY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.Annotation;
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
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.util.StringUtil;

/**
 * A generator that creates a class that contains the syntax structure given
 * in the CS specification.
 */
public class GrammarInformationProviderGenerator extends JavaBaseGenerator {

	private static final String ANONYMOUS_FEATURE = "ANONYMOUS_FEATURE";

	private final static GeneratorUtil generatorUtil = new GeneratorUtil();

	private ConcreteSyntax concreteSyntax;

	private String syntaxElementClassName;
	private String keywordClassName;
	private String placeholderClassName;
	private String cardinalityClassName;

	private static ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	public GrammarInformationProviderGenerator() {
		super();
	}

	private GrammarInformationProviderGenerator(GenerationContext context) {
		super(context, EArtifact.GRAMMAR_INFORMATION_PROVIDER);
		concreteSyntax = context.getConcreteSyntax();
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		keywordClassName = context.getQualifiedClassName(EArtifact.KEYWORD);
		placeholderClassName = context.getQualifiedClassName(EArtifact.PLACEHOLDER);
		cardinalityClassName = context.getQualifiedClassName(EArtifact.CARDINALITY);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addStaticConstants(sc);
		addInnerClasses(sc);
		addConstantsForSyntaxElements(sc);
		
		sc.add("}");
		
		return true;
	}

	private void addConstantsForSyntaxElements(StringComposite sc) {
		Map<EObject, String> objectToFieldNameMap = new LinkedHashMap<EObject, String>();
		List<Rule> allRules = concreteSyntax.getAllRules();
		for (Rule rule : allRules) {
			addConstants(sc, objectToFieldNameMap, rule);
		}
	}

	private void addStaticConstants(StringComposite sc) {
		sc.add("public final static " + E_STRUCTURAL_FEATURE + " " + ANONYMOUS_FEATURE + " = " + ECORE_FACTORY + ".eINSTANCE.createEAttribute();");
		sc.add("static {");
		sc.add("ANONYMOUS_FEATURE.setName(\"_\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInnerClasses(StringComposite sc) {
		addSequenceClass(sc);
		addChoiceClass(sc);
		addLineBreakClass(sc);
		addWhiteSpacesClass(sc);
		addContainmentClass(sc);
		addCompoundClass(sc);
		addRuleClass(sc);
	}

	private void addLineBreakClass(StringComposite sc) {
		sc.add("public static class LineBreak extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("private final int tabs;"); 
		sc.addLineBreak();
		sc.add("public LineBreak(" + cardinalityClassName + " cardinality, int tabs) {"); 
		sc.add("super(cardinality, null);"); 
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
		sc.add("public static class WhiteSpaces extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("private final int amount;"); 
		sc.addLineBreak();
		sc.add("public WhiteSpaces(int amount, " + cardinalityClassName + " cardinality) {"); 
		sc.add("super(cardinality, null);"); 
		sc.add("this.amount = amount;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public int getAmount() {"); 
		sc.add("return amount;"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addContainmentClass(StringComposite sc) {
		sc.add("public static class Containment extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("private final " + E_STRUCTURAL_FEATURE + " feature;");
		sc.addLineBreak();
		sc.add("public Containment(" + E_STRUCTURAL_FEATURE + " feature, " + cardinalityClassName + " cardinality) {"); 
		sc.add("super(cardinality, null);"); 
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
		sc.add("public static class Choice extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("public Choice(" + cardinalityClassName + " cardinality, " + syntaxElementClassName + "... choices) {"); 
		sc.add("super(cardinality, choices);"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public " + syntaxElementClassName + "[] getChoices() {"); 
		sc.add("return getChildren();"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addSequenceClass(StringComposite sc) {
		sc.add("public static class Sequence extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("public Sequence(" + cardinalityClassName + " cardinality, " + syntaxElementClassName + "... elements) {");
		sc.add("super(cardinality, elements);"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public " + syntaxElementClassName + "[] getElements() {"); 
		sc.add("return getChildren();"); 
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRuleClass(StringComposite sc) {
		sc.add("public static class Rule extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("private final " + E_CLASS + " metaclass;"); 
		sc.addLineBreak();
		sc.add("public Rule(" + E_CLASS + " metaclass, Choice choice, " + cardinalityClassName + " cardinality) {");
		sc.add("super(cardinality, new " + syntaxElementClassName + "[] {choice});"); 
		sc.add("this.metaclass = metaclass;");
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public " + E_CLASS + " getMetaclass() {"); 
		sc.add("return metaclass;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public Choice getDefinition() {"); 
		sc.add("return (Choice) getChildren()[0];"); 
		sc.add("}"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addCompoundClass(StringComposite sc) {
		sc.add("public static class Compound extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("public Compound(Choice choice, " + cardinalityClassName + " cardinality) {");
		sc.add("super(cardinality, new " + syntaxElementClassName + "[] {choice});"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public Choice getDefinition() {"); 
		sc.add("return (Choice) getChildren()[0];"); 
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
			String fieldName = getFieldName(next);
			sc.add("public final static " + keywordClassName + " " + fieldName + " = new " + keywordClassName + "(\"" + StringUtil.escapeToJavaString(value) + "\", " + getCardinality(next) + ");");
		} else if (next instanceof Placeholder) {
			Placeholder placeholder = (Placeholder) next;
			GenFeature feature = placeholder.getFeature();
			String getFeatureAccessor = getFeatureAccessor(rule.getMetaclass(), feature);
			String featureAccessor = getFeatureAccessor;
			String fieldName = getFieldName(next);
			sc.add("public final static " + placeholderClassName + " " + fieldName + " = new " + placeholderClassName + "(" + featureAccessor + ", \"" + StringUtil.escapeToJavaString(placeholder.getToken().getName()) + "\", " + getCardinality(next) + ");");
		} else if (next instanceof WhiteSpaces) {
			int amount = ((WhiteSpaces) next).getAmount();
			String fieldName = getFieldName(next);
			sc.add("public final static WhiteSpaces " + fieldName + " = new WhiteSpaces(" + amount + ", " + getCardinality(next) + ");");
		} else if (next instanceof LineBreak) {
			int amount = ((LineBreak) next).getTab();
			String fieldName = getFieldName(next);
			sc.add("public final static LineBreak " + fieldName + " = new LineBreak(" + getCardinality(next) + ", " + amount + ");");
		} else if (next instanceof Sequence) {
			Sequence sequence = (Sequence) next;
			List<String> elements = new ArrayList<String>();
			List<Definition> parts = sequence.getParts();
			for (Definition part : parts) {
				addConstant(sc, objectToFieldNameMap, rule, part);
				elements.add(getFieldName(part));
			}
			String fieldName = getFieldName(next);
			sc.add("public final static Sequence " + fieldName + " = new Sequence(" + getCardinality(next) + ", " + StringUtil.explode(elements, ", ") + ");");
		} else if (next instanceof Choice) {
			Choice choice = (Choice) next;
			List<String> elements = new ArrayList<String>();
			List<Sequence> parts = choice.getOptions();
			for (Sequence part : parts) {
				addConstant(sc, objectToFieldNameMap, rule, part);
				elements.add(getFieldName(part));
			}
			String fieldName = getFieldName(next);
			sc.add("public final static Choice " + fieldName + " = new Choice(" + getCardinality(next) + ", " + StringUtil.explode(elements, ", ") + ");");
		} else if (next instanceof Containment) {
			Containment containment = (Containment) next;
			GenFeature feature = containment.getFeature();
			String featureAccessor = getFeatureAccessor(rule.getMetaclass(), feature);
			String fieldName = getFieldName(next);
			sc.add("public final static Containment " + fieldName + " = new Containment(" + featureAccessor + ", " + getCardinality(next) + ");");
		} else if (next instanceof CompoundDefinition) {
			CompoundDefinition compound = (CompoundDefinition) next;
			Choice choice = compound.getDefinitions();
			addConstant(sc, objectToFieldNameMap, rule, choice);
			String choiceFieldName = getFieldName(choice);
			String fieldName = getFieldName(next);
			sc.add("public final static Compound " + fieldName + " = new Compound(" + choiceFieldName + ", " + getCardinality(next) + ");");
		} else if (next instanceof Rule) {
			Rule nextAsRule = (Rule) next;
			String definitionFieldName = getFieldName(nextAsRule.getDefinition());
			String metaClassAccessor = generatorUtil.getClassAccessor(nextAsRule.getMetaclass());
			String fieldName = getFieldName(nextAsRule);
			sc.add("public final static Rule " + fieldName + " = new Rule(" + metaClassAccessor + ", " + definitionFieldName + ", " + getCardinality(next) + ");");
		} else {
			assert next instanceof Annotation;
		}
	}

	private String getCardinality(EObject next) {
		String literal = "ONE";
		if (next instanceof CardinalityDefinition) {
			CardinalityDefinition cd = (CardinalityDefinition) next;
			Cardinality cardinality = cd.getCardinality();
			if (cardinality != null) {
				if (cardinality instanceof STAR) {
					literal = "STAR";
				} else if (cardinality instanceof PLUS) {
					literal = "PLUS";
				} else if (cardinality instanceof QUESTIONMARK) {
					literal = "QUESTIONMARK";
				}
			}
		}
		return cardinalityClassName + "." + literal;
	}

	private String getFeatureAccessor(GenClass genClass, GenFeature genFeature) {
		if (genFeature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
			return ANONYMOUS_FEATURE;
		} else {
			return generatorUtil.getFeatureAccessor(genClass, genFeature);
		}
	}

	public static String getFieldName(EObject object) {
		ConcreteSyntax syntax = csUtil.findContainingRule(object).getSyntax();
		String escapedSyntaxName = syntax.getName().replace(".", "_").toUpperCase();
		return csUtil.getFieldName(escapedSyntaxName + "_", object);
	}
	
	public IGenerator newInstance(GenerationContext context) {
		return new GrammarInformationProviderGenerator(context);
	}
}
