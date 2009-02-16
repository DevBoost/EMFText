package org.emftext.runtime.ocl;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.IOptions;

/**
 * A provider for the OCL validator that is registered to an extension point
 * of EMFText.
 */
public class OCLValidationOptionProvider implements org.emftext.runtime.IOptionProvider {

	public OCLValidationOptionProvider() {
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new OCLModelValidator());
		return options;
	}

}
