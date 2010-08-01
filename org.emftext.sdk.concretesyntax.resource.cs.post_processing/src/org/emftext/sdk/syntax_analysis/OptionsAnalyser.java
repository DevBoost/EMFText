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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.quickfixes.RemoveElementQuickFix;

/**
 * A post processor that checks whether the values for all code generation
 * options are valid.
 */
public class OptionsAnalyser extends AbstractPostProcessor {

	private static final String TOKEN_SPACE_VALUE_ERROR_MESSAGE = "Value must be positive integers or '" + TOKEN_SPACE_VALUE_AUTOMATIC + "'.";

	private static final String DUPLICATE_OPTION_FOUND = "Found duplicate option '%s' with %s value.";
	
	private final List<OptionTypes> BOOLEAN_OPTIONS;
	private final List<OptionTypes> STRING_OPTIONS;
	private final List<OptionTypes> NON_STANDARD_OPTIONS;
	
	public OptionsAnalyser() {
		BOOLEAN_OPTIONS = OptionManager.INSTANCE.getBooleanOptions();
		STRING_OPTIONS = OptionManager.INSTANCE.getStringOptions();
		NON_STANDARD_OPTIONS = OptionManager.INSTANCE.getNonStandardOptions();
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
		// third, analyze that options are set at most once
		analyseDuplicateOption(resource, syntax, options);
	}

	private void analyseDuplicateOption(CsResource resource,
			ConcreteSyntax syntax, List<Option> options) {
		Map<OptionTypes, Option> setOptions = new LinkedHashMap<OptionTypes, Option>();
		for (Option option : options) {
			OptionTypes type = option.getType();
			if (setOptions.keySet().contains(type)) {
				// option was set before - compare values
				Option optionBefore = setOptions.get(type);
				String valueBefore = optionBefore.getValue();
				if (valueBefore.equals(option.getValue())) {
					// values are the same - issues a warning
					String message = String.format(DUPLICATE_OPTION_FOUND, option.getType().getLiteral(), "same");
					addProblem(resource, ECsProblemType.DUPLICATE_OPTION_WITH_SAME_VALUE, message, option, new RemoveElementQuickFix("Remove option", option));
				} else {
					// values are different - issues an error
					String message = String.format(DUPLICATE_OPTION_FOUND, option.getType().getLiteral(), "different");
					addProblem(resource, ECsProblemType.DUPLICATE_OPTION_WITH_DIFFERENT_VALUE, message, option, new RemoveElementQuickFix("Remove option", option));
				}
			}
			setOptions.put(type, option);
		}
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
