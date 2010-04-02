/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.List;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * A post processor that checks whether the values for all code generation
 * options are valid.
 */
public class OptionsAnalyser extends AbstractPostProcessor {

	private final List<OptionTypes> BOOLEAN_OPTIONS;
	private final List<OptionTypes> STRING_OPTIONS;
	private final List<OptionTypes> NON_STANDARD_OPTIONS;
	
	public OptionsAnalyser() {
		BOOLEAN_OPTIONS = new ArrayList<OptionTypes>();
		BOOLEAN_OPTIONS.add(OptionTypes.USE_CLASSIC_PRINTER);
		BOOLEAN_OPTIONS.add(OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);
		BOOLEAN_OPTIONS.add(OptionTypes.FORCE_EOF);
		BOOLEAN_OPTIONS.add(OptionTypes.GENERATE_TEST_ACTION);
		BOOLEAN_OPTIONS.add(OptionTypes.GENERATE_CODE_FROM_GENERATOR_MODEL);
		BOOLEAN_OPTIONS.add(OptionTypes.RELOAD_GENERATOR_MODEL);
		BOOLEAN_OPTIONS.add(OptionTypes.USE_PREDEFINED_TOKENS);
		BOOLEAN_OPTIONS.add(OptionTypes.ANTLR_BACKTRACKING);
		BOOLEAN_OPTIONS.add(OptionTypes.ANTLR_MEMOIZE);
		BOOLEAN_OPTIONS.add(OptionTypes.SAVE_CHANGED_RESOURCES_ONLY);
		BOOLEAN_OPTIONS.add(OptionTypes.DISABLE_BUILDER);
		
		// all override options are boolean
		for (OptionTypes optionType : OptionTypes.VALUES) {
			if (optionType.name().startsWith("OVERRIDE_")) {
				BOOLEAN_OPTIONS.add(optionType);
			}
		}

		STRING_OPTIONS = new ArrayList<OptionTypes>();
		STRING_OPTIONS.add(OptionTypes.BASE_PACKAGE);
		STRING_OPTIONS.add(OptionTypes.RESOURCE_PLUGIN_ID);
		STRING_OPTIONS.add(OptionTypes.SOURCE_FOLDER);
		STRING_OPTIONS.add(OptionTypes.SOURCE_GEN_FOLDER);
		STRING_OPTIONS.add(OptionTypes.PARSER_GENERATOR);
		STRING_OPTIONS.add(OptionTypes.BASE_RESOURCE_PLUGIN);
		STRING_OPTIONS.add(OptionTypes.ANTLR_PLUGIN_ID);
		STRING_OPTIONS.add(OptionTypes.LICENCE_HEADER);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_DEPENDENCIES);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_EXPORTS);
		
		NON_STANDARD_OPTIONS = new ArrayList<OptionTypes>();
		NON_STANDARD_OPTIONS.add(OptionTypes.PARSER_GENERATOR);
		NON_STANDARD_OPTIONS.add(OptionTypes.GENERATE_TEST_ACTION);
		NON_STANDARD_OPTIONS.add(OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);
	}

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		List<Option> options = syntax.getOptions();
		for (Option option : options) {
			analyseOption(resource, option);
		}
	}

	private void analyseOption(CsResource resource, Option option) {
		OptionTypes type = option.getType();
		String value = option.getValue();
		checkValue(resource, option, type, value);
		checkForNonStandard(resource, option, type);
	}

	private void checkForNonStandard(CsResource resource, Option option,
			OptionTypes type) {
		if (NON_STANDARD_OPTIONS.contains(type)) {
			addProblem(resource, ECsProblemType.NON_STANDARD_OPTION, type.getLiteral() + " is a non-standard option, which might not be supported in future versions.", option);
		}
	}

	private void checkValue(CsResource resource, Option option, OptionTypes type, String value) {
		if (BOOLEAN_OPTIONS.contains(type)) {
			checkBooleanValue(resource, option, type, value);
		} else if (type == OptionTypes.PARSER_GENERATOR) {
			checkParserGeneratorValue(resource, option, value);
		} else if (STRING_OPTIONS.contains(type)) {
			// string values are accepted as they are
		} else if (type == OptionTypes.TOKENSPACE) {
			checkTokenspaceValue(resource, option, value);
		} else if (type == OptionTypes.DEFAULT_TOKEN_NAME) {
			checkDefaultTokenNameValue(resource, option, value);
		} else {
			addProblem(resource, ECsProblemType.UNKNOWN_OPTION, "Unknown option (" + type + ").", option);
		}
	}

	private void checkParserGeneratorValue(CsResource resource,
			Option option, String value) {
		if (!OptionManager.ANTLR.equals(value) && !OptionManager.SCALES.equals(value)) {
			addProblem(resource, ECsProblemType.INVALID_PARSER_GENERATOR, "Invalid parser generator (Valid generators are: " + OptionManager.ANTLR + ", " + OptionManager.SCALES + ").", option);
		}
	}

	private void checkDefaultTokenNameValue(CsResource resource,
			Option option, String value) {
		if (value == null || value.length() < 2) {
			addProblem(resource, ECsProblemType.INVALID_DEFAULT_TOKEN_NAME, "Please provide a String with at least two letters.", option);
		}
	}

	private void checkTokenspaceValue(CsResource resource, Option option,
			String value) {
		try {
			int v = Integer.parseInt(value);
			if (v < 0) {
				addProblem(resource, ECsProblemType.OPTION_VALUE_MUST_BE_POSITIVE_INTEGER, "Only positive integers are allowed.", option);
			}
		} catch (NumberFormatException e) {
			addProblem(resource, ECsProblemType.OPTION_VALUE_MUST_BE_INTEGER, "Only integers are allowed.", option);
		}
	}

	private void checkBooleanValue(CsResource resource, Option option,
			OptionTypes type, String value) {
		boolean isTrue = "true".equals(value);
		boolean isFalse = "false".equals(value);
		if (!isTrue && !isFalse) {
			addProblem(resource, ECsProblemType.OPTION_VALUE_MUST_BE_BOOLEAN, "Only boolean values: 'true' or 'false' are supported.", option);
		}
	}
}
