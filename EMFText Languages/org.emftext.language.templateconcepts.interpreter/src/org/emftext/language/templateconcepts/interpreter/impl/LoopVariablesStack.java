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
package org.emftext.language.templateconcepts.interpreter.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;

public class LoopVariablesStack {

	private class LoopVariable {
		private String name;
		private EObject value;

		public LoopVariable(String name, EObject value) {
			super();
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public EObject getValue() {
			return value;
		}
	}

	private Stack<LoopVariable> variableStack = new Stack<LoopVariable>();

	public void push(String name, EObject value) {
		variableStack.push(new LoopVariable(name, value));
	}

	public void pop() {
		variableStack.pop();
	}

	/**
	 * Returns unmodifiable map of uppermost variables on stack.
	 * Key is variable name and value the respective value. <br>
	 * The returned map is unmodifiable as the developer must not change this map externally
	 * @return Returns unmodifiable map of uppermost variables on stack.
	 */
	public Map<String, EObject> getTopMostVariables() {
		Map<String, EObject> result = new HashMap<String, EObject>();
		for (LoopVariable variable : variableStack) {
			//mboehme: stack is a LIFO queue. So uppermost values are first ones
			if(result.get(variable.getName())==null){
				result.put(variable.getName(), variable.getValue());
			}
		}
		return Collections.unmodifiableMap(result);
	}
}
