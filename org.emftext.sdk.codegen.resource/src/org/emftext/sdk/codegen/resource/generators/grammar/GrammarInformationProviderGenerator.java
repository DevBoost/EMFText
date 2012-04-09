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
package org.emftext.sdk.codegen.resource.generators.grammar;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.resource.generators.helpers.OccurrenceCountHelper;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.StringUtil;

/**
 * A generator that creates a class that contains the syntax structure given
 * in the CS specification.
 */
@SyntaxDependent
public class GrammarInformationProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private static final String ANONYMOUS_FEATURE = "ANONYMOUS_FEATURE";

	private final static GeneratorUtil generatorUtil = new GeneratorUtil();
	private final static NameUtil nameUtil = new NameUtil();
	private final static OccurrenceCountHelper occurrenceHelper = new OccurrenceCountHelper();

	private ConcreteSyntax concreteSyntax;

	@Override
	public void generateJavaContents(JavaComposite sc) {
		concreteSyntax = getContext().getConcreteSyntax();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addStaticConstants(sc);
		addFields(sc);
		addConstantsForSyntaxElements(sc);
		addStaticMethods(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addStaticMethods(JavaComposite sc) {
		addGetSyntaxElementID(sc);
		addGetSyntaxElementByID(sc);
	}

	private void addMethods(JavaComposite sc) {
		addGetRulesMethod(sc);
		addGetKeywordsMethod(sc);
		addFindKeywordsMethod(sc);
	}

	private void addConstantsForSyntaxElements(StringComposite sc) {
		List<Rule> allRules = concreteSyntax.getAllRules();
		for (Rule rule : allRules) {
			addConstants(sc, rule);
		}
		sc.addLineBreak();
	}
	
	private void addGetSyntaxElementID(JavaComposite sc) {
		sc.add("public static String getSyntaxElementID(" + syntaxElementClassName + " syntaxElement) {");
		sc.add("if (syntaxElement == null) {");
		sc.addComment("null indicates EOF");
		sc.add("return \"<EOF>\";");
		sc.add("}");
		sc.add("for (" + FIELD + " field : " + grammarInformationProviderClassName + ".class.getFields()) {");
		sc.add("Object fieldValue;");
		sc.add("try {");
		sc.add("fieldValue = field.get(null);");
		sc.add("if (fieldValue == syntaxElement) {");
		sc.add("String id = field.getName();");
		sc.add("return id;");
		sc.add("}");
		sc.add("} catch (Exception e) { }"); 
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSyntaxElementByID(JavaComposite sc) {
		sc.add("public static " + syntaxElementClassName + " getSyntaxElementByID(String syntaxElementID) {");
		sc.add("try {");
		sc.add("return (" + syntaxElementClassName + ") " + grammarInformationProviderClassName + ".class.getField(syntaxElementID).get(null);");
		sc.add("} catch (Exception e) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}


	private void addStaticConstants(StringComposite sc) {
		sc.add("public final static " + E_STRUCTURAL_FEATURE + " " + ANONYMOUS_FEATURE + " = " + ECORE_FACTORY + ".eINSTANCE.createEAttribute();");
		sc.add("static {");
		sc.add("ANONYMOUS_FEATURE.setName(\"_\");");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public final static " + getResourceClassName() + " INSTANCE = new " + getResourceClassName() + "();");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + SET + "<String> keywords;");
		sc.addLineBreak();
	}

	private void addConstants(StringComposite sc, Rule rule) {
		addConstant(sc, rule, rule.getDefinition());
		addConstant(sc, rule, rule);
	}

	private void addConstant(StringComposite sc, Rule rule, EObject next) {
		if (next instanceof CsString) {
			CsString csString = (CsString) next;
			String value = csString.getValue();
			String fieldName = nameUtil.getFieldName(csString);
			sc.add("public final static " + keywordClassName + " " + fieldName + " = new " + keywordClassName + "(\"" + StringUtil.escapeToJavaString(value) + "\", " + getCardinality(next) + ");");
		} else if (next instanceof Placeholder) {
			Placeholder placeholder = (Placeholder) next;
			GenFeature genFeature = placeholder.getFeature();
			String getFeatureAccessor = getFeatureAccessor(rule.getMetaclass(), genFeature);
			String featureAccessor = getFeatureAccessor;
			String fieldName = nameUtil.getFieldName(placeholder);
			int mandatoryOccurencesAfter = occurrenceHelper.getMandatoryOccurencesAfter(placeholder, genFeature);
			sc.add("public final static " + placeholderClassName + " " + fieldName + " = new " + placeholderClassName + "(" + featureAccessor + ", \"" + StringUtil.escapeToJavaString(placeholder.getToken().getName()) + "\", " + getCardinality(next) + ", " + mandatoryOccurencesAfter + ");");
		} else if (next instanceof WhiteSpaces) {
			WhiteSpaces whiteSpaces = (WhiteSpaces) next;
			int amount = whiteSpaces.getAmount();
			String fieldName = nameUtil.getFieldName(whiteSpaces);
			sc.add("public final static " + whiteSpaceClassName + " " + fieldName + " = new " + whiteSpaceClassName + "(" + amount + ", " + getCardinality(next) + ");");
		} else if (next instanceof LineBreak) {
			LineBreak lineBreak = (LineBreak) next;
			int amount = lineBreak.getTab();
			String fieldName = nameUtil.getFieldName(lineBreak);
			sc.add("public final static " + lineBreakClassName + " " + fieldName + " = new " + lineBreakClassName + "(" + getCardinality(next) + ", " + amount + ");");
		} else if (next instanceof Sequence) {
			Sequence sequence = (Sequence) next;
			List<String> elements = new ArrayList<String>();
			List<Definition> parts = sequence.getParts();
			for (Definition part : parts) {
				addConstant(sc, rule, part);
				elements.add(nameUtil.getFieldName(part));
			}
			String fieldName = nameUtil.getFieldName(sequence);
			sc.add("public final static " + sequenceClassName + " " + fieldName + " = new " + sequenceClassName + "(" + getCardinality(next) + ", " + StringUtil.explode(elements, ", ") + ");");
		} else if (next instanceof Choice) {
			Choice choice = (Choice) next;
			List<String> elements = new ArrayList<String>();
			List<Sequence> parts = choice.getOptions();
			for (Sequence part : parts) {
				addConstant(sc, rule, part);
				elements.add(nameUtil.getFieldName(part));
			}
			String fieldName = nameUtil.getFieldName(choice);
			sc.add("public final static " + choiceClassName + " " + fieldName + " = new " + choiceClassName + "(" + getCardinality(next) + ", " + StringUtil.explode(elements, ", ") + ");");
		} else if (next instanceof Containment) {
			Containment containment = (Containment) next;
			GenFeature genFeature = containment.getFeature();
			String featureAccessor = getFeatureAccessor(rule.getMetaclass(), genFeature);
			String fieldName = nameUtil.getFieldName(containment);
			int mandatoryOccurencesAfter = occurrenceHelper.getMandatoryOccurencesAfter(containment, genFeature);
			
			StringBuffer allowedSubTypeString = new StringBuffer();
			EList<GenClass> allowedSubTypes = containment.getAllowedSubTypes();
			if (allowedSubTypes.isEmpty()) {
				allowedSubTypeString.append("null");
			} else {
				allowedSubTypeString.append("new " + E_CLASS + "[] {");
				for (GenClass genClass : allowedSubTypes) {
					String metaClassAccessor = generatorUtil.getClassifierAccessor(genClass);
					allowedSubTypeString.append(metaClassAccessor + ", ");
				}
				allowedSubTypeString.append("}");
			}
			
			sc.add("public final static " + containmentClassName + " " + fieldName + " = new " + containmentClassName + "(" + featureAccessor + ", " + getCardinality(next) + ", " + allowedSubTypeString.toString() + ", " + mandatoryOccurencesAfter + ");");
		} else if (next instanceof CompoundDefinition) {
			CompoundDefinition compound = (CompoundDefinition) next;
			Choice choice = compound.getDefinition();
			addConstant(sc, rule, choice);
			String choiceFieldName = nameUtil.getFieldName(choice);
			String fieldName = nameUtil.getFieldName(compound);
			sc.add("public final static " + compoundClassName + " " + fieldName + " = new " + compoundClassName + "(" + choiceFieldName + ", " + getCardinality(next) + ");");
		} else if (next instanceof Rule) {
			Rule nextAsRule = (Rule) next;
			String definitionFieldName = nameUtil.getFieldName(nextAsRule.getDefinition());
			String metaClassAccessor = generatorUtil.getClassifierAccessor(nextAsRule.getMetaclass());
			String fieldName = nameUtil.getFieldName(nextAsRule);
			sc.add("public final static " + ruleClassName + " " + fieldName + " = new " + ruleClassName + "(" + metaClassAccessor + ", " + definitionFieldName + ", " + getCardinality(next) + ");");
		} else if (next instanceof BooleanTerminal) {
			BooleanTerminal booleanTerminal = (BooleanTerminal) next;
			GenFeature genFeature = booleanTerminal.getFeature();
			String getFeatureAccessor = getFeatureAccessor(rule.getMetaclass(), genFeature);
			String featureAccessor = getFeatureAccessor;
			String fieldName = nameUtil.getFieldName(booleanTerminal);
			int mandatoryOccurencesAfter = occurrenceHelper.getMandatoryOccurencesAfter(booleanTerminal, genFeature);
			String escapedTrueLiteral = StringUtil.escapeToJavaString(booleanTerminal.getTrueLiteral());
			String escapedFalseLiteral = StringUtil.escapeToJavaString(booleanTerminal.getFalseLiteral());
			sc.add("public final static " + booleanTerminalClassName + " " + fieldName + " = new " + booleanTerminalClassName + "(" + featureAccessor + ", \"" + escapedTrueLiteral + "\", \"" + escapedFalseLiteral + "\", " + getCardinality(next) + ", " + mandatoryOccurencesAfter + ");");
		} else if (next instanceof EnumTerminal) {
			EnumTerminal enumTerminal = (EnumTerminal) next;
			GenFeature genFeature = enumTerminal.getFeature();
			String getFeatureAccessor = getFeatureAccessor(rule.getMetaclass(), genFeature);
			String featureAccessor = getFeatureAccessor;
			String fieldName = nameUtil.getFieldName(enumTerminal);
			int mandatoryOccurencesAfter = occurrenceHelper.getMandatoryOccurencesAfter(enumTerminal, genFeature);
			String literalMappingArray = "new String[] {";
			// add mappings between enumeration literals and their textual representation
			for (EnumLiteralTerminal enumLiteralTerminal : enumTerminal.getLiterals()) {
				String literalName = StringUtil.escapeToJavaString(enumLiteralTerminal.getLiteral().getName());
				String value = StringUtil.escapeToJavaString(enumLiteralTerminal.getText());
				literalMappingArray += "\"" + literalName + "\", \"" + value + "\", ";
			}
			literalMappingArray += "}";
			sc.add("public final static " + enumerationTerminalClassName + " " + fieldName + " = new " + enumerationTerminalClassName + "(" + featureAccessor + ", " + literalMappingArray + ", " + getCardinality(next) + ", " + mandatoryOccurencesAfter + ");");
		} else {
			assert next instanceof Annotation;
		}
	}

	private String getCardinality(EObject next) {
		String literal = "ONE";
		if (next instanceof CardinalityDefinition) {
			CardinalityDefinition cd = (CardinalityDefinition) next;
			Cardinality cardinality = cd.getCardinality();
			if (cardinality == Cardinality.STAR) {
				literal = "STAR";
			} else if (cardinality == Cardinality.PLUS) {
				literal = "PLUS";
			} else if (cardinality == Cardinality.QUESTIONMARK) {
				literal = "QUESTIONMARK";
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

	private void addGetRulesMethod(JavaComposite sc) {
		sc.add("public final static " + ruleClassName + "[] RULES = new " + ruleClassName + "[] {");
		for (Rule rule : concreteSyntax.getAllRules()) {
			String fieldName = nameUtil.getFieldName(rule);
			sc.add(fieldName + ",");
		}
		sc.add("};");
		sc.addLineBreak();
	}

	
	private void addGetKeywordsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns all keywords of the grammar. This includes all literals for boolean and enumeration terminals."
		);
		sc.add("public " + SET + "<String> getKeywords() {");
		sc.add("if (this.keywords == null) {");
		sc.add("this.keywords = new " + LINKED_HASH_SET + "<String>();");
		
		sc.add("for (" + ruleClassName + " rule : RULES) {");
		sc.add("findKeywords(rule, this.keywords);");
		sc.add("}");
		sc.add("}");
		sc.add("return keywords;");
		sc.add("}");
		sc.addLineBreak();
	}

	
	private void addFindKeywordsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Finds all keywords in the given element and its children and adds them to the set. This includes all literals for boolean and enumeration terminals."
		);
		sc.add("private void findKeywords(" + syntaxElementClassName + " element, " + SET + "<String> keywords) {");
		sc.add("if (element instanceof " + keywordClassName + ") {");
		sc.add("keywords.add(((" + keywordClassName + ") element).getValue());");
		sc.add("} else if (element instanceof " + booleanTerminalClassName + ") {");
		sc.add("keywords.add(((" + booleanTerminalClassName + ") element).getTrueLiteral());");
		sc.add("keywords.add(((" + booleanTerminalClassName + ") element).getFalseLiteral());");
		sc.add("} else if (element instanceof " + enumerationTerminalClassName + ") {");
		sc.add(enumerationTerminalClassName + " terminal = (" + enumerationTerminalClassName + ") element;");
		sc.add("for (String key : terminal.getLiteralMapping().keySet()) {");
		sc.add("keywords.add(key);");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + syntaxElementClassName + " child : element.getChildren()) {");
		sc.add("findKeywords(child, this.keywords);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
