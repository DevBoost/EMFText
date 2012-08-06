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
package org.emftext.language.threevaluedlogic;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlOptionProvider;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlOptions;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlResourcePostProcessor;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlResourcePostProcessorProvider;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlResource;

public class InterpreterProvider implements ITvlOptionProvider, ITvlResourcePostProcessorProvider, ITvlResourcePostProcessor {

	public Map<?, ?> getOptions() {
		Map<Object, Object> options = new LinkedHashMap<Object, Object>();
		options.put(ITvlOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}

	public ITvlResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(TvlResource resource) {
		TVLInterpreter interpreter = new TVLInterpreter();
		InterpreterContext context = new InterpreterContext();
		
		TreeIterator<EObject> contents = resource.getAllContents();
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof Formula) {
				interpreter.addObjectToInterprete(next);
			}
		}
		interpreter.interprete(context);
	}

	public void terminate() {
		// do nothing
	}
}
