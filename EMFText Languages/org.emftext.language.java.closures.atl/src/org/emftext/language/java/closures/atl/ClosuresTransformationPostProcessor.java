/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.closures.atl;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.java.closures.resource.closure.IClosureOptionProvider;
import org.emftext.language.java.closures.resource.closure.IClosureOptions;
import org.emftext.language.java.closures.resource.closure.IClosureResourcePostProcessor;
import org.emftext.language.java.closures.resource.closure.IClosureResourcePostProcessorProvider;
import org.emftext.language.java.closures.resource.closure.mopp.ClosureResource;
import org.emftext.language.java.resource.util.JavaPostProcessor;
import org.emftext.util.atl.ATLTransformationPostProcessor;

public class ClosuresTransformationPostProcessor extends ATLTransformationPostProcessor implements IClosureOptionProvider,
IClosureResourcePostProcessor, IClosureResourcePostProcessorProvider {

	@Override
	protected Map<String, String> getMetamodelURIs() {
		Map<String, String> metamodels = new HashMap<String, String>();
//		metamodels.put("Closures",
//				"http://emftext.org/language/closures");
		metamodels.put("MMClosures",
		"http://emftext.org/language/closures");
		metamodels.put("MMJava",
		"http://www.emftext.org/java");
		return metamodels;
	}

	@Override
	protected String getTransformationURI() {

//		return "platform:/resource/org.emftext.language.java.closures.atl/transformations/assimilator.asm";
		return "platform:/resource/Closures/transformations/translator.asm";
}

	@Override
	protected String getInMetamodelName() {
//		return "Closures";
		return "MMClosures";
	}

	@Override
	protected String getOutMetamodelName() {
//		return "Java";
		return "MMJava";
	}

	@Override
	protected String getOutputURI() {
		String fileExtension = currentResource.getURI().fileExtension();
		String currentUri = currentResource.getURI().toPlatformString(true);
		String newUri = currentUri.substring(0, currentUri.length() - fileExtension.length() - 1);
		newUri += ".java";
			return newUri;
		}

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IClosureOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public IClosureResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(ClosureResource resource) {
		// do normal Java post processing
		JavaPostProcessor jpp = new JavaPostProcessor();
		jpp.processBasic(resource);
		// handle closures TODO this should be done by a builder
		super.processBasic(resource);
	}

}
