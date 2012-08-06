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
package org.emftext.language.simplemath.interpreter;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.simplemath.Expression;
import org.emftext.language.simplemath.resource.sm.ISmOptionProvider;
import org.emftext.language.simplemath.resource.sm.ISmOptions;
import org.emftext.language.simplemath.resource.sm.ISmResourcePostProcessor;
import org.emftext.language.simplemath.resource.sm.ISmResourcePostProcessorProvider;
import org.emftext.language.simplemath.resource.sm.mopp.SmResource;

public class InterpretingPostProcessor implements ISmOptionProvider, ISmResourcePostProcessorProvider, ISmResourcePostProcessor {

	public Map<?, ?> getOptions() {
		Map<Object, Object> options = new LinkedHashMap<Object, Object>();
		options.put(ISmOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}

	public ISmResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(SmResource resource) {
		TreeIterator<EObject> allContents = resource.getAllContents();
		SimpleMathInterpreter interpreter = new SimpleMathInterpreter();
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			if (eObject instanceof Expression) {
				Expression expression = (Expression) eObject;
				interpreter.addObjectToInterprete(expression);
			}
		}
		SimpleMathContext context = new SimpleMathContext();
		interpreter.interprete(context);
	}

	public void terminate() {
		// do nothing
	}
}
