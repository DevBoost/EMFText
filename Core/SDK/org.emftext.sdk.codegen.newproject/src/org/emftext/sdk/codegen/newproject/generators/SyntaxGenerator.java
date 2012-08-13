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
package org.emftext.sdk.codegen.newproject.generators;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.EnumTerminal;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;

/**
 * Generates a simple concrete syntax for the meta model generated before.
 */
public class SyntaxGenerator extends ModelGenerator {

	private static final ConcretesyntaxFactory CS_FACTORY = ConcretesyntaxFactory.eINSTANCE;

	public SyntaxGenerator() {
		super();
	}

	@Override
	public EObject generateModel(NewProjectParameters parameters) {
		String syntaxName = parameters.getSyntaxName();
		GenPackage genPackage = getContext().getGenPackage();

		return generateModel(syntaxName, genPackage);
	}

	public EObject generateModel(String syntaxName, GenPackage genPackage) {
		ConcreteSyntax syntax = CS_FACTORY.createConcreteSyntax();
		syntax.setName(syntaxName);
		syntax.setPackage(genPackage);
		
		// this sets the 'reloadGeneratorModel' option to true (fix for #1880)
		Option reloadGenModelOption = CS_FACTORY.createOption();
		reloadGenModelOption.setType(OptionTypes.RELOAD_GENERATOR_MODEL);
		reloadGenModelOption.setValue(Boolean.TRUE.toString());
		syntax.getOptions().add(reloadGenModelOption);
		
		syntax.getRules().add(getEntityModelRule(genPackage));
		syntax.getRules().add(getEntityRule(genPackage));
		syntax.getRules().add(getDataTypeRule(genPackage));
		syntax.getRules().add(getFeatureRule(genPackage));
		
		syntax.getStartSymbols().add(getGenClass(genPackage, MetaModelGenerator.ENTITY_MODEL));
		return syntax;
	}
	
	private Rule getEntityModelRule(GenPackage genPackage) {
		Rule rule = CS_FACTORY.createRule();
		GenClass entityModelClass = getGenClass(genPackage, MetaModelGenerator.ENTITY_MODEL);
		rule.setMetaclass(entityModelClass);
		CsString keyword = CS_FACTORY.createCsString();
		keyword.setValue("model");

		Containment shapesContainment = CS_FACTORY.createContainment();
		shapesContainment.setFeature(getGenFeature(genPackage, MetaModelGenerator.ENTITY_MODEL_TYPES_REF));
		shapesContainment.setCardinality(Cardinality.STAR);

		Sequence sequence = CS_FACTORY.createSequence();
		sequence.getChildren().add(keyword);
		sequence.getChildren().add(shapesContainment);

		Choice choice = CS_FACTORY.createChoice();
		choice.getChildren().add(sequence);
		
		rule.getChildren().add(choice);
		return rule;
	}

	private Rule getDataTypeRule(GenPackage genPackage) {
		Rule rule = CS_FACTORY.createRule();
		rule.setMetaclass(getGenClass(genPackage, MetaModelGenerator.DATA_TYPE));

		Placeholder namePlaceholder = CS_FACTORY.createPlaceholderUsingDefaultToken();
		namePlaceholder.setFeature(getGenFeature(genPackage, MetaModelGenerator.TYPE_NAME_ATT));
		
		Sequence sequence = CS_FACTORY.createSequence();
		sequence.getChildren().add(createKeyword("datatype"));
		sequence.getChildren().add(namePlaceholder);
		sequence.getChildren().add(createKeyword(";"));
		
		Choice choice = CS_FACTORY.createChoice();
		choice.getChildren().add(sequence);
		
		rule.getChildren().add(choice);
		return rule;
	}

	private CsString createKeyword(String value) {
		CsString keyword = CS_FACTORY.createCsString();
		keyword.setValue(value);
		return keyword;
	}

	private Rule getFeatureRule(GenPackage genPackage) {
		Rule rule = CS_FACTORY.createRule();
		rule.setMetaclass(getGenClass(genPackage, MetaModelGenerator.FEATURE));
		
		EnumTerminal kindTerminal = CS_FACTORY.createEnumTerminal();
		kindTerminal.setFeature(getGenFeature(genPackage, MetaModelGenerator.FEATURE_KIND_ATT));
		kindTerminal.getLiterals().add(createEnumLiteralTerminal(genPackage, MetaModelGenerator.FEATURE_KIND_ATTRIBUTE, "att"));
		kindTerminal.getLiterals().add(createEnumLiteralTerminal(genPackage, MetaModelGenerator.FEATURE_KIND_REFERENCE, "ref"));
		kindTerminal.getLiterals().add(createEnumLiteralTerminal(genPackage, MetaModelGenerator.FEATURE_KIND_CONTAINMENT, "cont"));

		Placeholder reference = CS_FACTORY.createPlaceholderUsingDefaultToken();
		reference.setFeature(getGenFeature(genPackage, MetaModelGenerator.FEATURE_TYPE_REF));

		Placeholder namePlaceholder = CS_FACTORY.createPlaceholderUsingDefaultToken();
		namePlaceholder.setFeature(getGenFeature(genPackage, MetaModelGenerator.TYPE_NAME_ATT));

		Sequence sequence = CS_FACTORY.createSequence();
		sequence.getChildren().add(kindTerminal);
		sequence.getChildren().add(reference);
		sequence.getChildren().add(namePlaceholder);
		sequence.getChildren().add(createKeyword(";"));
		
		Choice choice = CS_FACTORY.createChoice();
		choice.getChildren().add(sequence);
		
		rule.getChildren().add(choice);
		return rule;
	}

	private EnumLiteralTerminal createEnumLiteralTerminal(GenPackage genPackage, String name, String text) {
		EnumLiteralTerminal literal = CS_FACTORY.createEnumLiteralTerminal();
		literal.setLiteral(getEEnumLiteral(genPackage, name).getEcoreEnumLiteral());
		literal.setText(text);
		return literal;
	}

	private Rule getEntityRule(GenPackage genPackage) {
		Rule rule = CS_FACTORY.createRule();
		rule.setMetaclass(getGenClass(genPackage, MetaModelGenerator.ENTITY));
		
		BooleanTerminal visibleTerminal = CS_FACTORY.createBooleanTerminal();
		visibleTerminal.setFeature(getGenFeature(genPackage, MetaModelGenerator.ENTITY_ABSTRACT_ATT));
		visibleTerminal.setTrueLiteral("abstract");
		visibleTerminal.setFalseLiteral("");
		
		Placeholder namePlaceholder = CS_FACTORY.createPlaceholderUsingDefaultToken();
		namePlaceholder.setFeature(getGenFeature(genPackage, MetaModelGenerator.TYPE_NAME_ATT));
		
		Containment containment = CS_FACTORY.createContainment();
		containment.setFeature(getGenFeature(genPackage, MetaModelGenerator.ENTITY_FEATURES_REF));
		containment.setCardinality(Cardinality.STAR);

		Sequence sequence = CS_FACTORY.createSequence();
		sequence.getChildren().add(visibleTerminal);
		sequence.getChildren().add(createKeyword("entity"));
		sequence.getChildren().add(namePlaceholder);
		sequence.getChildren().add(createKeyword("{"));
		sequence.getChildren().add(containment);
		sequence.getChildren().add(createKeyword("}"));
		
		Choice choice = CS_FACTORY.createChoice();
		choice.getChildren().add(sequence);
		
		rule.getChildren().add(choice);
		return rule;
	}

	private GenClass getGenClass(GenPackage genPackage, String name) {
		for (GenClass genClass : genPackage.getGenClasses()) {
			if (name.equals(genClass.getName())) {
				return genClass;
			}
		}
		throw new RuntimeException("Can't find GenClass: " + name);
	}

	private GenFeature getGenFeature(GenPackage genPackage, String name) {
		for (GenClass genClass : genPackage.getGenClasses()) {
			for (GenFeature genFeature : genClass.getAllGenFeatures()) {
				if (name.equals(genFeature.getName())) {
					return genFeature;
				}
			}
		}
		throw new RuntimeException("Can't find GenFeature: " + name);
	}

	private GenEnumLiteral getEEnumLiteral(GenPackage genPackage, String name) {
		for (GenEnum genEnum : genPackage.getGenEnums()) {
			for (GenEnumLiteral genEnumLiteral : genEnum.getGenEnumLiterals()) {
				if (name.equals(genEnumLiteral.getName())) {
					return genEnumLiteral;
				}
			}
		}
		throw new RuntimeException("Can't find GenEnumLiteral: " + name);
	}

	@Override
	public String getModelPath() {
		return getFileInMetaModelFolder(getContext().getParameters().getSyntaxFile());
	}
}
