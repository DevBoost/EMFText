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
		if (optionName.equals(GENERATE_TEST_ACTION_NAME)) {
			return false;
		}
		if (optionName.equals(GENERATE_PRINTER_STUB_ONLY_NAME)) {
			return false;
		}
		if (optionName.equals(OVERRIDE_PROXY_RESOLVERS_NAME)) {
			return false;
		}
		if (optionName.equals(OVERRIDE_TOKEN_RESOLVERS_NAME)) {
			return false;
		}
		if (optionName.equals(OVERRIDE_PLUGIN_XML_NAME)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_MANIFEST_NAME)) {
			return true;
		}
		if (optionName.equals(GENERATE_GEN_MODEL)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_ANTLR_SPEC_NAME)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_TREE_ANALYSER_NAME)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME)) {
			return true;
		}
		if (optionName.equals(OVERRIDE_PRINTER_NAME)) {
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
