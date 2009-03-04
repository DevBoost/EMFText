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

import static org.emftext.sdk.codegen.ICodeGenOptions.*;

import java.util.List;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;

/**
 * A manager for code generation options. The manager can be queried
 * for values of options of different types (integer, string and 
 * boolean options).
 */
public class OptionManager {

	public final static OptionManager INSTANCE = new OptionManager();
	
	private OptionManager() {
		super();
	}

	public String getStringOptionValue(ConcreteSyntax concreteSyntax,
			String optionName) {
		List<Option> options = concreteSyntax.getOptions();
		if (options == null) {
			return null;
		}
		Option option = findOptionByName(options, optionName);
		if (option == null) {
			return null;
		}
		return option.getValue();
	}
	
	public boolean getBooleanOptionValue(ConcreteSyntax concreteSyntax,
			String optionName) {
		List<Option> options = concreteSyntax.getOptions();
		if (options == null) {
			return getBooleanOptionsDefaultValue(optionName);
		}
		Option option = findOptionByName(options, optionName);
		if (option == null) {
			return getBooleanOptionsDefaultValue(optionName);
		}
		String value = option.getValue();
		if (value == null) {
			return getBooleanOptionsDefaultValue(optionName);
		}
		if ("true".equals(value)) {
			return true;
		} else if ("false".equals(value)) {
			return false;
		} else {
			return getBooleanOptionsDefaultValue(optionName);
		}
	}

	private boolean getBooleanOptionsDefaultValue(String optionName) {
		// Attention: Any changes made to this default values must be
		// documented in ICodeGenOptions!
		if (optionName.equals(GENERATE_TEST_ACTION)) {
			return false;
		}
		if (optionName.equals(GENERATE_PRINTER_STUB_ONLY)) {
			return false;
		}
		if (optionName.equals(OVERRIDE_REFERENCE_RESOLVERS)) {
			return false;
		}
		if (optionName.equals(OVERRIDE_TOKEN_RESOLVERS)) {
			return false;
		}
		if (optionName.equals(OVERRIDE_PLUGIN_XML)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_MANIFEST)) {
			return true;
		}
		if (optionName.equals(GENERATE_CODE_FROM_GENERATOR_MODEL)) {
			return false;
		}
		if (optionName.equals(OVERRIDE_ANTLR_SPEC)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_REFERENCE_RESOLVER_SWITCH)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_TOKEN_RESOLVER_FACTORY)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_PRINTER)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_PRINTER_BASE)) {
			return true;
		}
		if (optionName.equals(CS_OPTION_FORCE_EOF)) {
			return true;
		}
		if (optionName.equals(CS_OPTION_USE_PREDEFINED_TOKENS)) {
			return true;
		}
		if (optionName.equals(ANTLR_BACKTRACKING)) {
			return true;
		}
		if (optionName.equals(ANTLR_MEMOIZE)) {
			return true;
		}
		if (optionName.equals(CS_OPTION_AUTOFIX_SIMPLE_LEFTRECURSION)) {
			return false;
		}
		if (optionName.equals(RELOAD_GENERATOR_MODEL)) {
			return false;
		}
		return false;
	}

	public int getIntegerOptionValue(ConcreteSyntax syntax,
			String optionName, boolean expectPositiveValue, IProblemCollector problemCollector) {
		
		Option option = findOptionByName(syntax.getOptions(), optionName);
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

	private Option findOptionByName(List<Option> options,
			String optionName) {
		for (Option option : options) {
			if (optionName.equals(option.getName())) {
				return option;
			}
		}
		return null;
	}
}
