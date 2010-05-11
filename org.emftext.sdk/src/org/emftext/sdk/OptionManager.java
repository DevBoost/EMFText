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
package org.emftext.sdk;

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
	
	private OptionManager() {
		super();
	}

	public String getStringOptionValue(ConcreteSyntax concreteSyntax,
			OptionTypes type) {
		List<Option> options = concreteSyntax.getOptions();
		if (options == null) {
			return null;
		}
		Option option = findOptionByType(options, type);
		if (option == null) {
			return null;
		}
		return option.getValue();
	}
	
	public boolean getBooleanOptionValue(ConcreteSyntax concreteSyntax,
			OptionTypes type) {
		List<Option> options = concreteSyntax.getOptions();
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

	private boolean getBooleanOptionsDefaultValue(OptionTypes option) {
		// Attention: Any changes made to this default values must be
		// documented in class OptionTypes!
		if (option == OptionTypes.USE_CLASSIC_PRINTER) {
			return true;
		}
		if (option == OptionTypes.GENERATE_TEST_ACTION) {
			return false;
		}
		if (option == OptionTypes.OVERRIDE_REFERENCE_RESOLVERS) {
			return false;
		}
		if (option == OptionTypes.OVERRIDE_TOKEN_RESOLVERS) {
			return false;
		}
		if (option == OptionTypes.GENERATE_CODE_FROM_GENERATOR_MODEL) {
			return false;
		}
		if (option == OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION) {
			return false;
		}
		if (option == OptionTypes.RELOAD_GENERATOR_MODEL) {
			return false;
		}
		if (option == OptionTypes.SAVE_CHANGED_RESOURCES_ONLY) {
			return false;
		}
		if (option == OptionTypes.DISABLE_BUILDER) {
			return false;
		}
		if (option == OptionTypes.DISABLE_EVALIDATORS) {
			return false;
		}
		if (option == OptionTypes.DISABLE_EMF_VALIDATION_CONSTRAINTS) {
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
	public Option findOptionByType(List<Option> options,
			OptionTypes type) {
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

	public boolean doOverride(ConcreteSyntax concreteSyntax,
			OptionTypes overrideOption) {
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(concreteSyntax, overrideOption);
		return doOverride;
	}
}
