/*******************************************************************************
 * Copyright (c) 2006-2009 
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
/**
 * 
 */
package org.emftext.runtime;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.atl.ATLTransformationPostProcessor;

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
		return "platform:/resource/org.emftext.test.atl/transformations/assimilator.asm";
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
