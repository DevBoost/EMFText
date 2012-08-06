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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import static org.emftext.sdk.OptionManager.TOKEN_SPACE_VALUE_AUTOMATIC;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.quickfixes.RemoveElementQuickFix;

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
	public void analyse(ConcreteSyntax syntax) {
		// first analyze options individually
		List<Option> options = syntax.getOptions();
		for (Option option : options) {
			analyseOption(option);
		}
		// second, analyze option conflicts
		analyseOptionConflicts(syntax, options);
		// third, analyze that options are set at most once
		analyseDuplicateOption(syntax, options);
	}

	private void analyseDuplicateOption(ConcreteSyntax syntax, List<Option> options) {
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
					addProblem(CsAnalysisProblemType.DUPLICATE_OPTION_WITH_SAME_VALUE, message, option, new RemoveElementQuickFix("Remove option", option));
				} else {
					// values are different - issues an error
					String message = String.format(DUPLICATE_OPTION_FOUND, option.getType().getLiteral(), "different");
					addProblem(CsAnalysisProblemType.DUPLICATE_OPTION_WITH_DIFFERENT_VALUE, message, option, new RemoveElementQuickFix("Remove option", option));
				}
			}
			setOptions.put(type, option);
		}
	}

	/**
	 * Checks whether the grammar contains conflicting options.
	 */
	private void analyseOptionConflicts(ConcreteSyntax syntax, List<Option> options) {
		checkForClassicPrinterAutomaticTokenSpaceConflict(syntax, options);
		checkPluginIdConflict(syntax, options);
		checkEclipseDependencyConflict(syntax, options);
	}

	private void checkEclipseDependencyConflict(
			ConcreteSyntax syntax, 
			List<Option> options) {
		
		OptionManager optionManager = OptionManager.INSTANCE;
		boolean removeEclipseCode = optionManager.getBooleanOptionValue(syntax, OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);
		boolean generateUIPlugin = optionManager.getBooleanOptionValue(syntax, OptionTypes.GENERATE_UI_PLUGIN);
		
		if (removeEclipseCode && generateUIPlugin) {
			String message = "The resource UI plug-in cannot be generated without using Eclipse dependencies. Please set '" + OptionTypes.GENERATE_UI_PLUGIN.getLiteral() + "' to false.";
			addProblem(
					CsAnalysisProblemType.ECLIPSE_DEPENDENCY_CONFLICT, 
					message, 
					optionManager.findOptionByType(options, OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE)
			);
		}
	}

	private void checkPluginIdConflict(
			ConcreteSyntax syntax, 
			List<Option> options) {
		
		OptionManager optionManager = OptionManager.INSTANCE;
		String antlrPluginID = optionManager.getStringOptionValue(syntax, OptionTypes.ANTLR_PLUGIN_ID);
		String resourcePluginID = optionManager.getStringOptionValue(syntax, OptionTypes.RESOURCE_PLUGIN_ID);
		String resourceUIPluginID = optionManager.getStringOptionValue(syntax, OptionTypes.RESOURCE_UI_PLUGIN_ID);
		
		int setPluginIDs = 0;
		Set<String> pluginIDs = new LinkedHashSet<String>();
		if (antlrPluginID != null) {
			pluginIDs.add(antlrPluginID);
			setPluginIDs++;
		}
		if (resourcePluginID != null) {
			pluginIDs.add(resourcePluginID);
			setPluginIDs++;
		}
		if (pluginIDs.size() > 0 && pluginIDs.size() < setPluginIDs) {
			// antlrPluginID == resourcePluginID
			String message = "The ID for the resource plug-ins must be different from the ANTLR commons plug-in.";
			addProblem(
					CsAnalysisProblemType.PLUGIN_ID_CONFLICT, 
					message, 
					optionManager.findOptionByType(options, OptionTypes.RESOURCE_PLUGIN_ID)
			);
			if (resourceUIPluginID != null) {
				pluginIDs.add(resourceUIPluginID);
			}
			if (pluginIDs.size() == 1) {
				// antlrPluginID == resourcePluginID == resourceUIPluginID
				addProblem(
						CsAnalysisProblemType.PLUGIN_ID_CONFLICT, 
						message, 
						optionManager.findOptionByType(options, OptionTypes.RESOURCE_UI_PLUGIN_ID)
				);
			}
		} else {
			if (resourceUIPluginID != null) {
				pluginIDs.add(resourceUIPluginID);
				setPluginIDs++;
			}
			if (pluginIDs.size() > 0 && pluginIDs.size() < setPluginIDs) {
				// (antlrPluginID || resourcePluginID) == resourceUIPluginID
				addProblem(
						CsAnalysisProblemType.PLUGIN_ID_CONFLICT, 
						"The ID for the resource UI plug-in must be different from the ANTLR commons plug-in and the resource plug-in.", 
						optionManager.findOptionByType(options, OptionTypes.RESOURCE_UI_PLUGIN_ID)
				);
			} else {
				// all IDs are different or null, which is perfectly fine
			}
		}
	}

	private void checkForClassicPrinterAutomaticTokenSpaceConflict(
			ConcreteSyntax syntax, List<Option> options) {
		OptionManager optionManager = OptionManager.INSTANCE;
		boolean useClassicPrinter = optionManager.getBooleanOptionValue(syntax, OptionTypes.USE_CLASSIC_PRINTER);
		if (useClassicPrinter) {
			String tokenSpace = optionManager.getStringOptionValue(syntax, OptionTypes.TOKENSPACE);
			if (TOKEN_SPACE_VALUE_AUTOMATIC.equals(tokenSpace)) {
				addProblem(
						CsAnalysisProblemType.AUTOMATIC_TOKEN_SPACE_CONFLICT_WITH_CLASSIC_PRINTER, 
						"Value '" + TOKEN_SPACE_VALUE_AUTOMATIC + "' is not compatible with the classic printer.", 
						optionManager.findOptionByType(options, OptionTypes.TOKENSPACE)
				);
			}
		}
	}

	private void analyseOption(Option option) {
		OptionTypes type = option.getType();
		String value = option.getValue();
		checkValue(option, type, value);
		checkForNonStandard(option, type);
	}

	private void checkForNonStandard(Option option,
			OptionTypes type) {
		if (NON_STANDARD_OPTIONS.contains(type)) {
			addProblem(CsAnalysisProblemType.NON_STANDARD_OPTION, type.getLiteral() + " is a non-standard option, which might not be supported in future versions.", option);
		}
	}

	private void checkValue(Option option, OptionTypes type, String value) {
		if (BOOLEAN_OPTIONS.contains(type)) {
			checkBooleanValue(option, type, value);
		} else if (type == OptionTypes.PARSER_GENERATOR) {
			checkParserGeneratorValue(option, value);
		} else if (STRING_OPTIONS.contains(type)) {
			// string values are accepted as they are
		} else if (type == OptionTypes.TOKENSPACE) {
			checkTokenspaceValue(option, value);
		} else if (type == OptionTypes.DEFAULT_TOKEN_NAME) {
			checkDefaultTokenNameValue(option, value);
		} else {
			addProblem(CsAnalysisProblemType.UNKNOWN_OPTION, "Unknown option (" + type + ").", option);
		}
	}

	private void checkParserGeneratorValue(Option option, String value) {
		if (!OptionManager.ANTLR.equals(value) && !OptionManager.SCALES.equals(value)) {
			addProblem(CsAnalysisProblemType.INVALID_PARSER_GENERATOR, "Invalid parser generator (Valid generators are: " + OptionManager.ANTLR + ", " + OptionManager.SCALES + ").", option);
		}
	}

	private void checkDefaultTokenNameValue(Option option, String value) {
		if (value == null || value.length() < 2) {
			addProblem(CsAnalysisProblemType.INVALID_DEFAULT_TOKEN_NAME, "Please provide a String with at least two letters.", option);
		}
	}

	private void checkTokenspaceValue(Option option, String value) {
		if (TOKEN_SPACE_VALUE_AUTOMATIC.equals(value)) {
			return;
		}
		try {
			int v = Integer.parseInt(value);
			if (v < 0) {
				addProblem(CsAnalysisProblemType.TOKEN_SPACE_VALUE_MUST_BE_POSITIVE_INTEGER, TOKEN_SPACE_VALUE_ERROR_MESSAGE, option);
			}
		} catch (NumberFormatException e) {
			addProblem(CsAnalysisProblemType.TOKEN_SPACE_VALUE_MUST_BE_INTEGER, TOKEN_SPACE_VALUE_ERROR_MESSAGE, option);
		}
	}

	private void checkBooleanValue(Option option, OptionTypes type, String value) {
		boolean isTrue = "true".equals(value);
		boolean isFalse = "false".equals(value);
		if (!isTrue && !isFalse) {
			addProblem(CsAnalysisProblemType.OPTION_VALUE_MUST_BE_BOOLEAN, "Only boolean values: 'true' or 'false' are supported.", option);
		}
	}
}
