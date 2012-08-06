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
package org.emftext.language.eag.interpreter.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.eag.AttributeGrammar;
import org.emftext.language.eag.Variable;

/**
 * A context that is passed on during the interpretation of attribute
 * grammars. It contains references to the grammar models, the result
 * of the current computation, the model element that is subject to
 * interpretation and a map of all active variables.
 */
public class ComputationContext {

	private EObject object;
	private AttributeGrammar grammar;
	private Object result;
	private Map<Variable, Object> variableMap = new LinkedHashMap<Variable, Object>();

	public ComputationContext(AttributeGrammar grammar, EObject object, EObject result) {
		super();
		this.grammar = grammar;
		this.object = object;
		this.result = result;
	}

	public EObject getObject() {
		return object;
	}

	public AttributeGrammar getGrammar() {
		return grammar;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object newValue) {
		result = newValue;
	}

	public void addVariable(Variable variable, Object next) {
		variableMap.put(variable, next);
	}

	public void removeVariable(Variable variable) {
		variableMap.remove(variable);
	}

	public Object getVariableValue(Variable variable) {
		return variableMap.get(variable);
	}
}
