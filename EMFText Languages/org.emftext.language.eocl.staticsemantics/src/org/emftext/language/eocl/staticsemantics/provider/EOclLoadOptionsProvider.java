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
package org.emftext.language.eocl.staticsemantics.provider;

import java.util.HashMap;
import java.util.Map;

import org.emftext.language.eocl.resource.eocl.IEoclOptionProvider;
import org.emftext.language.eocl.resource.eocl.IEoclOptions;
import org.emftext.language.eocl.resource.eocl.IEoclResourcePostProcessorProvider;

import tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclReferenceResolveHelper;
import tudresden.ocl20.pivot.language.ocl.staticsemantics.postporcessor.OclReferenceResolveHelper;

public class EOclLoadOptionsProvider implements IEoclOptionProvider {

	private IEoclResourcePostProcessorProvider oclResourcePostProcessorProvider;
	private IOclReferenceResolveHelper oclReferenceResolveHelper;
	
	public EOclLoadOptionsProvider() {
		oclResourcePostProcessorProvider = new EOclResourcePostProcessorProvider();
		oclReferenceResolveHelper = new OclReferenceResolveHelper();
	}

	public Map<?, ?> getOptions() {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put(IEoclOptions.RESOURCE_POSTPROCESSOR_PROVIDER, oclResourcePostProcessorProvider);
		result.put("ReferenceResolveHelper", oclReferenceResolveHelper);
		return result;
	}

}

