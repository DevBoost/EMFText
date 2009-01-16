package org.emftext.runtime.ocl;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptions;

public class OptionProvider implements org.emftext.runtime.IOptionProvider {

	public OptionProvider() {
		
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new OCLModelValidator());
		return options;
	}

}
