/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen;

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
		if (option == OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE) {
			return false;
		}
		if (option == OptionTypes.OVERRIDE_PROBLEM_CLASS) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_PLUGIN_META_INFORMATION_CLASS) {
			return true;
		}
		if (option == OptionTypes.GENERATE_TEST_ACTION) {
			return false;
		}
		if (option == OptionTypes.GENERATE_PRINTER_STUB_ONLY) {
			return false;
		}
		if (option == OptionTypes.OVERRIDE_REFERENCE_RESOLVERS) {
			return false;
		}
		if (option == OptionTypes.OVERRIDE_TOKEN_RESOLVERS) {
			return false;
		}
		if (option == OptionTypes.OVERRIDE_PLUGIN_XML) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_MANIFEST) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_BUILD_PROPERTIES) {
			return true;
		}
		if (option == OptionTypes.GENERATE_CODE_FROM_GENERATOR_MODEL) {
			return false;
		}
		if (option == OptionTypes.OVERRIDE_SCANNER) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_PARSER) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_PRINTER) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_PRINTER_BASE) {
			return true;
		}
		if (option == OptionTypes.FORCE_EOF) {
			return true;
		}
		if (option == OptionTypes.USE_PREDEFINED_TOKENS) {
			return true;
		}
		if (option == OptionTypes.ANTLR_BACKTRACKING) {
			return true;
		}
		if (option == OptionTypes.ANTLR_MEMOIZE) {
			return true;
		}
		if (option == OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION) {
			return false;
		}
		if (option == OptionTypes.RELOAD_GENERATOR_MODEL) {
			return false;
		}
		if (option == OptionTypes.OVERRIDE_DOT_CLASSPATH) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_DOT_PROJECT) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_TEXT_RESOURCE) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_RESOURCE_FACTORY) {
			return true;
		}
		if (option == OptionTypes.OVERRIDE_NEW_FILE_WIZARD) {
			return true;
		}
		return false;
	}

	public int getIntegerOptionValue(ConcreteSyntax syntax,
			OptionTypes type, boolean expectPositiveValue, IProblemCollector problemCollector) {
		
		Option option = findOptionByType(syntax.getOptions(), type);
		if (option == null) {
			return -1;
		}
		try {
			int tempSpace = Integer.parseInt(option.getValue());
			if (expectPositiveValue && tempSpace < 0) {
				problemCollector.addProblem(new GenerationProblem(
								"Only positive values are allowed for this option.",
								option));
			}
			return tempSpace;
		} catch (NumberFormatException e) {
			problemCollector.addProblem(new GenerationProblem("No valid integer in option.", option));
		}
		return -1;
	}

	private Option findOptionByType(List<Option> options,
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
}
