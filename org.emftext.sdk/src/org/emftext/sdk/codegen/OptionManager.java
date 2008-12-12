package org.emftext.sdk.codegen;

import static org.emftext.sdk.codegen.ICodeGenOptions.*;

import java.util.List;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;

public class OptionManager {

	public final static OptionManager INSTANCE = new OptionManager();
	
	private OptionManager() {
		super();
	}

	public boolean getBooleanOption(ConcreteSyntax concreteSyntax,
			String optionName) {
		List<Option> options = concreteSyntax.getOptions();
		if (options == null) {
			return getBooleanOptionsDefault(optionName);
		}
		Option option = findOptionByName(options, optionName);
		if (option == null) {
			return getBooleanOptionsDefault(optionName);
		}
		String value = option.getValue();
		if (value == null) {
			return getBooleanOptionsDefault(optionName);
		}
		if ("true".equals(value)) {
			return true;
		} else if ("false".equals(value)) {
			return false;
		} else {
			return getBooleanOptionsDefault(optionName);
		}
	}

	private boolean getBooleanOptionsDefault(String optionName) {
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
			return true;
		}
		if (optionName.equals(OVERRIDE_ANTLR_SPEC)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_TREE_ANALYSER)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_TOKEN_RESOLVER_FACTORY)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_PRINTER)) {
			return true;
		}
		return false;
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
