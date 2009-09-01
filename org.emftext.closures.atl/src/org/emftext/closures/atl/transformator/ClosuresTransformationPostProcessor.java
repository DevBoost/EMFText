package org.emftext.closures.atl.transformator;


import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.atl.ATLTransformationPostProcessor;

final class ClosuresTransformationPostProcessor  extends ATLTransformationPostProcessor {
	@Override
	protected Map<String, String> getMetamodelURIs() {
		Map<String, String> metamodels = new HashMap<String, String>();
		metamodels.put("Closures",
				"http://emftext.org/language/closures");
		return metamodels;
	}

	@Override
	protected String getTransformationURI() {
		return "platform:/resource/org.emftext.closures.atl/transformations/assimilator.asm";
	}

	@Override
	protected String getInMetamodelName() {
		return "Closures";
	}

	@Override
	protected String getOutMetamodelName() {
		return "Java";
	}

	@Override
	protected String getOutputURI() {
		String fileExtension = currentResource.getURI().fileExtension();
		String currentUri = currentResource.getURI().toPlatformString(true);
		String newUri = currentUri.substring(0, currentUri.length() - fileExtension.length() - 1);
		newUri += ".java";
			return newUri;
		}

}
