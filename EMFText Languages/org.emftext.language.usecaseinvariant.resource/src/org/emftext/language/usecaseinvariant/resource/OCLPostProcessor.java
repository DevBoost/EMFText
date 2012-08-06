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
package org.emftext.language.usecaseinvariant.resource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.usecaseinvariant.resource.ucinv.IUcinvOptionProvider;
import org.emftext.language.usecaseinvariant.resource.ucinv.IUcinvOptions;
import org.emftext.language.usecaseinvariant.resource.ucinv.IUcinvResourcePostProcessor;
import org.emftext.language.usecaseinvariant.resource.ucinv.IUcinvResourcePostProcessorProvider;
import org.emftext.language.usecaseinvariant.resource.ucinv.UcinvEProblemType;
import org.emftext.language.usecaseinvariant.resource.ucinv.mopp.UcinvResource;
import org.emftext.language.usecaseinvariant.util.IProblemHandler;
import org.emftext.language.usecaseinvariant.util.OCLModelValidator;

public class OCLPostProcessor implements IUcinvResourcePostProcessor,
		IUcinvResourcePostProcessorProvider, IUcinvOptionProvider {

	OCLModelValidator oclValidator = new OCLModelValidator();
	
	public void process(final UcinvResource resource) {
		if (resource != null && !resource.getContents().isEmpty()) {
			oclValidator.analyse(resource.getContents().get(0), new IProblemHandler() {		
				public void addProblem(String message, EObject cause, boolean isError) {
					if (isError) {
						resource.addError(message, UcinvEProblemType.ANALYSIS_PROBLEM, cause);
					}
					else {
						resource.addWarning(message, UcinvEProblemType.ANALYSIS_PROBLEM, cause);
					}
				}
			});			
		}
	}

	public IUcinvResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put(IUcinvOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new OCLPostProcessor());
		return m;
	}

	public void terminate() {
		// do nothing
	}
}
