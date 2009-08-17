/**
 * 
 */
package org.emftext.runtime.atl;

import java.util.HashMap;
import java.util.Map;

final class TestTransformationPostProcessor extends
		ATLTransformationPostProcessor {
	@Override
	protected Map<String, String> getMetamodelURIs() {
		Map<String, String> metamodels = new HashMap<String, String>();
		metamodels.put("ConcreteSyntax",
				"http://www.emftext.org/sdk/concretesyntax");
		return metamodels;
	}

	@Override
	protected String getTransformationURI() {
		return "platform:/resource/org.emftext.runtime.atl/transformations/assimilator.asm";
	}

	@Override
	protected String getInMetamodelName() {
		return "ConcreteSyntax";
	}

	@Override
	protected String getOutMetamodelName() {
		return "ConcreteSyntax";
	}

	@Override
	protected String getOutputURI() {
		String fileExtension = currentResource.getURI().fileExtension();
		String currentUri = currentResource.getURI().toPlatformString(true);
		String newUri = currentUri.substring(0, currentUri.length() - fileExtension.length() - 1);
		newUri += ".out.cs";
		return newUri;
	}
}