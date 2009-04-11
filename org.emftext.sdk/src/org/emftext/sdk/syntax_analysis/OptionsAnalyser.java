package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.List;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class OptionsAnalyser extends AbstractPostProcessor {

	private final List<OptionTypes> BOOLEAN_OPTIONS;
	private final List<OptionTypes> STRING_OPTIONS;
	
	public OptionsAnalyser() {
		BOOLEAN_OPTIONS = new ArrayList<OptionTypes>();
		BOOLEAN_OPTIONS.add(OptionTypes.AUTOFIX_SIMPLE_LEFTRECURSION);
		BOOLEAN_OPTIONS.add(OptionTypes.FORCE_EOF);
		BOOLEAN_OPTIONS.add(OptionTypes.GENERATE_TEST_ACTION);
		BOOLEAN_OPTIONS.add(OptionTypes.GENERATE_CODE_FROM_GENERATOR_MODEL);
		BOOLEAN_OPTIONS.add(OptionTypes.GENERATE_PRINTER_STUB_ONLY);
		BOOLEAN_OPTIONS.add(OptionTypes.RELOAD_GENERATOR_MODEL);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_PLUGIN_XML);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_MANIFEST);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_PARSER_SPEC);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_TOKEN_RESOLVERS);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_REFERENCE_RESOLVERS);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_PRINTER);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_PRINTER_BASE);
		BOOLEAN_OPTIONS.add(OptionTypes.USE_PREDEFINED_TOKENS);
		BOOLEAN_OPTIONS.add(OptionTypes.ANTLR_BACKTRACKING);
		BOOLEAN_OPTIONS.add(OptionTypes.ANTLR_MEMOIZE);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_DOT_CLASSPATH);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_DOT_PROJECT);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_TEXT_RESOURCE);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_RESOURCE_FACTORY);
		BOOLEAN_OPTIONS.add(OptionTypes.OVERRIDE_NEW_FILE_WIZARD);

		STRING_OPTIONS = new ArrayList<OptionTypes>();
		STRING_OPTIONS.add(OptionTypes.BASE_PACKAGE);
		STRING_OPTIONS.add(OptionTypes.RESOURCE_PLUGIN_ID);
		STRING_OPTIONS.add(OptionTypes.SOURCE_FOLDER);
	}

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<Option> options = syntax.getOptions();
		for (Option option : options) {
			analyseOption(resource, option);
		}
	}

	private void analyseOption(ITextResource resource, Option option) {
		OptionTypes type = option.getType();
		String value = option.getValue();
		checkValue(resource, option, type, value);
	}

	private void checkValue(ITextResource resource, Option option, OptionTypes type, String value) {
		if (BOOLEAN_OPTIONS.contains(type)) {
			checkBooleanValue(resource, option, type, value);
		} else if (STRING_OPTIONS.contains(type)) {
			// string values are accepted as they are
		} else if (type == OptionTypes.TOKENSPACE) {
			checkTokenspaceValue(resource, option, value);
		} else if (type == OptionTypes.DEFAULT_TOKEN_NAME) {
			checkDefaultTokenNameValue(resource, option, value);
		} else {
			resource.addError("Unknown option (" + type + ").", option);
		}
	}

	private void checkDefaultTokenNameValue(ITextResource resource,
			Option option, String value) {
		if (value == null || value.length() < 2) {
			resource.addError("Please provide a String with at least two letters.", option);
		}
	}

	private void checkTokenspaceValue(ITextResource resource, Option option,
			String value) {
		try {
			int v = Integer.parseInt(value);
			if (v < 0) {
				resource.addError("Only positive integers are allowed.", option);
			}
		} catch (NumberFormatException e) {
			resource.addError("Only integers are allowed.", option);
		}
	}

	private void checkBooleanValue(ITextResource resource, Option option,
			OptionTypes type, String value) {
		boolean isTrue = "true".equals(value);
		boolean isFalse = "false".equals(value);
		if (!isTrue && !isFalse) {
			resource.addError("Only boolean values: 'true' or 'false' are supported.", option);
		}
	}
}
