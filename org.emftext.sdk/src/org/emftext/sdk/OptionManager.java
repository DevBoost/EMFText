/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A manager for code generation options. The manager can be queried
 * for values of options of different types (integer, string and 
 * boolean options).
 */
public class OptionManager {

	public final static OptionManager INSTANCE = new OptionManager();

	public static final String ANTLR = "antlr";
	public static final String SCALES = "scales";
	public static final String TOKEN_SPACE_VALUE_AUTOMATIC = "automatic";

	private final List<OptionTypes> NON_STANDARD_OPTIONS = new ArrayList<OptionTypes>();
	private final List<OptionTypes> STRING_OPTIONS = new ArrayList<OptionTypes>();
	private final List<OptionTypes> BOOLEAN_OPTIONS = new ArrayList<OptionTypes>();

	private OptionManager() {
		super();
		initializeOptionLists();
	}

	/**
	 * Returns a list of options that might be removed in future releases.
	 */
	public List<OptionTypes> getNonStandardOptions() {
		return NON_STANDARD_OPTIONS;
	}

	/**
	 * Returns a list of all options that have type string.
	 */
	public List<OptionTypes> getStringOptions() {
		return STRING_OPTIONS;
	}

	/**
	 * Returns a list of all options that have type boolean.
	 */
	public List<OptionTypes> getBooleanOptions() {
		return BOOLEAN_OPTIONS;
	}

	private void initializeOptionLists() {
		NON_STANDARD_OPTIONS.add(OptionTypes.PARSER_GENERATOR);
		NON_STANDARD_OPTIONS.add(OptionTypes.GENERATE_TEST_ACTION);
		NON_STANDARD_OPTIONS.add(OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);

		STRING_OPTIONS.add(OptionTypes.BASE_PACKAGE);
		STRING_OPTIONS.add(OptionTypes.UI_BASE_PACKAGE);
		STRING_OPTIONS.add(OptionTypes.RESOURCE_PLUGIN_ID);
		STRING_OPTIONS.add(OptionTypes.RESOURCE_UI_PLUGIN_ID);
		STRING_OPTIONS.add(OptionTypes.SOURCE_FOLDER);
		STRING_OPTIONS.add(OptionTypes.SOURCE_GEN_FOLDER);
		STRING_OPTIONS.add(OptionTypes.UI_SOURCE_FOLDER);
		STRING_OPTIONS.add(OptionTypes.UI_SOURCE_GEN_FOLDER);
		STRING_OPTIONS.add(OptionTypes.PARSER_GENERATOR);
		STRING_OPTIONS.add(OptionTypes.BASE_RESOURCE_PLUGIN);
		STRING_OPTIONS.add(OptionTypes.ANTLR_PLUGIN_ID);
		STRING_OPTIONS.add(OptionTypes.LICENCE_HEADER);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_DEPENDENCIES);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_EXPORTS);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_UI_DEPENDENCIES);
		STRING_OPTIONS.add(OptionTypes.ADDITIONAL_UI_EXPORTS);

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
		BOOLEAN_OPTIONS.add(OptionTypes.DISABLE_LAUNCH_SUPPORT);
		BOOLEAN_OPTIONS.add(OptionTypes.DISABLE_DEBUG_SUPPORT);
		BOOLEAN_OPTIONS.add(OptionTypes.DISABLE_TOKEN_SORTING);
		BOOLEAN_OPTIONS.add(OptionTypes.GENERATE_UI_PLUGIN);
		BOOLEAN_OPTIONS.add(OptionTypes.RESOLVE_PROXY_ELEMENTS_AFTER_PARSING);
		BOOLEAN_OPTIONS.add(OptionTypes.DISABLE_NEW_PROJECT_WIZARD);
		BOOLEAN_OPTIONS.add(OptionTypes.IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING);

		// all override options are boolean
		for (OptionTypes optionType : OptionTypes.VALUES) {
			if (optionType.name().startsWith("OVERRIDE_")) {
				BOOLEAN_OPTIONS.add(optionType);
			}
		}
	}

	/**
	 * Return the value of the given option. If the option is not set, null is
	 * returned.
	 * 
	 * @param syntax the syntax that specifies the option.
	 * @param type the type of the option
	 * @return the value as string
	 */
	public String getStringOptionValue(ConcreteSyntax syntax, OptionTypes type) {
		List<Option> options = syntax.getOptions();
		if (options == null) {
			return null;
		}
		Option option = findOptionByType(options, type);
		if (option == null) {
			return null;
		}
		return option.getValue();
	}
	
	/**
	 * Returns the value of the given syntax option. If the option is not
	 * set, the default value is returned.
	 * 
	 * @param syntax the syntax that specifies the option.
	 * @param type the type of the option
	 * @param defaultValue the options default value
	 */
	public String getStringOptionValue(ConcreteSyntax syntax, OptionTypes type, String defaultValue) {
		String value;
		String optionValue = OptionManager.INSTANCE.getStringOptionValue(syntax, type);
		if (optionValue != null) {
			// use package plug-in from option
			value = optionValue;
		} else {
			// use default plug-in name
			value = defaultValue;
		}
		return value;
	}

	/**
	 * Returns the value of the given syntax option as collection. The value is split into
	 * parts denoted by commata.
	 * 
	 * @param syntax the syntax that specifies the option.
	 * @param type the type of the option
	 */
	public Collection<String> getStringOptionValueAsCollection(ConcreteSyntax syntax, OptionTypes type) {
		String optionValue = getStringOptionValue(syntax, type);
		if (optionValue != null) {
			String[] parts = optionValue.split(",");
			return Arrays.asList(parts);
		} else {
			return Collections.emptySet();
		}
	}
	
	/**
	 * Return the value of the given (boolean) option. If the option is not 
	 * set, the default value is returned.
	 * 
	 * @param syntax the syntax that specifies the option.
	 * @param type the type of the option
	 * @return the value as boolean
	 */
	public boolean getBooleanOptionValue(ConcreteSyntax syntax, OptionTypes type) {
		List<Option> options = syntax.getOptions();
		if (options == null) {
			return getBooleanOptionsDefaultValue(type);
		}
		Option option = findOptionByType(options, type);
		if (option == null) {
			return getBooleanOptionsDefaultValue(type);
		}
		String value = option.getValue();
		if (value == null) {
			return getBooleanOptionsDefaultValue(type);
		}
		if ("true".equals(value)) {
			return true;
		} else if ("false".equals(value)) {
			return false;
		} else {
			return getBooleanOptionsDefaultValue(type);
		}
	}

	/**
	 * Returns the default value for the given (boolean) option.
	 * 
	 * @param type the option type
	 * @return the boolean default value.
	 */
	public boolean getBooleanOptionsDefaultValue(OptionTypes type) {
		// Attention: Any changes made to this default values must be
		// documented in concretesyntax.ecoredoc!
		if (type == OptionTypes.RESOLVE_PROXY_ELEMENTS_AFTER_PARSING) {
			return true;
		}
		if (type == OptionTypes.GENERATE_UI_PLUGIN) {
			return true;
		}
		if (type == OptionTypes.DISABLE_EVALIDATORS) {
			return true;
		}
		if (type == OptionTypes.USE_CLASSIC_PRINTER) {
			return false;
		}
		if (type == OptionTypes.GENERATE_TEST_ACTION) {
			return false;
		}
		if (type == OptionTypes.OVERRIDE_REFERENCE_RESOLVERS) {
			return false;
		}
		if (type == OptionTypes.OVERRIDE_TOKEN_RESOLVERS) {
			return false;
		}
		if (type == OptionTypes.GENERATE_CODE_FROM_GENERATOR_MODEL) {
			return false;
		}
		if (type == OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION) {
			return false;
		}
		if (type == OptionTypes.RELOAD_GENERATOR_MODEL) {
			return false;
		}
		if (type == OptionTypes.SAVE_CHANGED_RESOURCES_ONLY) {
			return false;
		}
		if (type == OptionTypes.DISABLE_BUILDER) {
			return false;
		}
		if (type == OptionTypes.DISABLE_EVALIDATORS) {
			return false;
		}
		if (type == OptionTypes.DISABLE_EMF_VALIDATION_CONSTRAINTS) {
			return false;
		}
		if (type == OptionTypes.DISABLE_TOKEN_SORTING) {
			return false;
		}
		if (type == OptionTypes.DISABLE_LAUNCH_SUPPORT) {
			return false;
		}
		if (type == OptionTypes.DISABLE_DEBUG_SUPPORT) {
			return false;
		}
		if (type == OptionTypes.DISABLE_NEW_PROJECT_WIZARD) {
			return false;
		}
		if (type == OptionTypes.IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING) {
			return false;
		}
		return true;
	}

	/**
	 * Searches in 'options' for an option of type 'type'.
	 * If one is found, it is returned. If not, <code>null</code>
	 * is returned. 
	 * 
	 * @param options the list of options to search in
	 * @param type the type to search for
	 * @return the found option, or null if none was found
	 */
	public Option findOptionByType(List<Option> options, OptionTypes type) {
		for (Option option : options) {
			if (type == option.getType()) {
				return option;
			}
		}
		return null;
	}

	public boolean useScalesParser(ConcreteSyntax syntax) {
		String value = getStringOptionValue(syntax, OptionTypes.PARSER_GENERATOR);
		if (value == null) {
			return false;
		}
		if (SCALES.equals(value)) {
			return true;
		}
		return false;
	}

	public boolean handleTokenSpaceAutomatically(ConcreteSyntax syntax) {
		String tokenSpaceValue = OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.TOKENSPACE);
		if (tokenSpaceValue == null) {
			// options is not set, use default
			return true;
		} else {
			return OptionManager.TOKEN_SPACE_VALUE_AUTOMATIC.equals(tokenSpaceValue);
		}
	}

	public boolean doOverride(ConcreteSyntax syntax, OptionTypes overrideOption) {
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(syntax, overrideOption);
		return doOverride;
	}
}
