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

import static org.emftext.sdk.OptionManager.TOKEN_SPACE_VALUE_AUTOMATIC;

import java.util.ArrayList;
import java.util.List;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.OptionManager;
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

	private static final String TOKEN_SPACE_VALUE_ERROR_MESSAGE = "Value must be positive integers or '" + TOKEN_SPACE_VALUE_AUTOMATIC + "'.";
	
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
		BOOLEAN_OPTIONS.add(OptionTypes.DISABLE_EVALIDATORS);
		BOOLEAN_OPTIONS.add(OptionTypes.DISABLE_EMF_VALIDATION_CONSTRAINTS);
		
		// all override options are boolean
		for (OptionTypes optionType : OptionTypes.VALUES) {
			if (optionType.name().startsWith("OVERRIDE_")) {
				BOOLEAN_OPTIONS.add(optionType);
			}
		}

		STRING_OPTIONS = new ArrayList<OptionTypes>();
		STRING_OPTIONS.add(OptionTypes.BASE_PACKAGE);
		STRING_OPTIONS.add(OptionTypes.UI_BASE_PACKAGE);
		STRING_OPTIONS.add(OptionTypes.RESOURCE_PLUGIN_ID);
		STRING_OPTIONS.add(OptionTypes.RESOURCE_UI_PLUGIN_ID);
		STRING_OPTIONS.add(OptionTypes.SOURCE_FOLDER);
		STRING_OPTIONS.add(OptionTypes.SOURCE_GEN_FOLDER);
		STRING_OPTIONS.add(OptionTypes.PARSER_GENERATOR);
		STRING_OPTIONS.add(OptionTypes.BASE_RESOURCE_PLUGIN);
		STRING_OPTIONS.add(OptionTypes.ANTLR_PLUGIN_ID);
		STRING_OPTIONS.add(OptionTypes.LICENCE_HEADER);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_DEPENDENCIES);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_EXPORTS);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_UI_DEPENDENCIES);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_UI_EXPORTS);
		
		NON_STANDARD_OPTIONS = new ArrayList<OptionTypes>();
		NON_STANDARD_OPTIONS.add(OptionTypes.PARSER_GENERATOR);
		NON_STANDARD_OPTIONS.add(OptionTypes.GENERATE_TEST_ACTION);
		NON_STANDARD_OPTIONS.add(OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);
	}

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		// first analyze options individually
		List<Option> options = syntax.getOptions();
		for (Option option : options) {
			analyseOption(resource, option);
		}
		// second, analyze option conflicts
		analyseOptionConflicts(resource, syntax, options);
	}

	/**
	 * Checks whether the grammar contains conflicting options.
	 */
	private void analyseOptionConflicts(CsResource resource, ConcreteSyntax syntax, List<Option> options) {
		checkForClassicPrinterAutomaticTokenSpaceConflict(resource, syntax, options);
	}

	private void checkForClassicPrinterAutomaticTokenSpaceConflict(
			CsResource resource, ConcreteSyntax syntax, List<Option> options) {
		OptionManager optionManager = OptionManager.INSTANCE;
		boolean useClassicPrinter = optionManager.getBooleanOptionValue(syntax, OptionTypes.USE_CLASSIC_PRINTER);
		if (useClassicPrinter) {
			String tokenSpace = optionManager.getStringOptionValue(syntax, OptionTypes.TOKENSPACE);
			if (TOKEN_SPACE_VALUE_AUTOMATIC.equals(tokenSpace)) {
				addProblem(
						resource, 
						ECsProblemType.AUTOMATIC_TOKEN_SPACE_CONFLICT_WITH_CLASSIC_PRINTER, 
						"Value '" + TOKEN_SPACE_VALUE_AUTOMATIC + "' is not compatible with the classic printer.", 
						optionManager.findOptionByType(options, OptionTypes.TOKENSPACE)
				);
			}
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
		if (TOKEN_SPACE_VALUE_AUTOMATIC.equals(value)) {
			return;
		}
		try {
			int v = Integer.parseInt(value);
			if (v < 0) {
				addProblem(resource, ECsProblemType.TOKEN_SPACE_VALUE_MUST_BE_POSITIVE_INTEGER, TOKEN_SPACE_VALUE_ERROR_MESSAGE, option);
			}
		} catch (NumberFormatException e) {
			addProblem(resource, ECsProblemType.TOKEN_SPACE_VALUE_MUST_BE_INTEGER, TOKEN_SPACE_VALUE_ERROR_MESSAGE, option);
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
