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
package org.emftext.language.calc.interpreter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.emftext.language.calc.Variable;
import org.emftext.language.calc.interpreter.events.ICalcInterpreterEvent;

public class CalcContext {

	private Map<Variable, Object> variableMap = new LinkedHashMap<Variable, Object>();
	private Map<String, ICalcFunction> functionMap = new LinkedHashMap<String, ICalcFunction>();

	private List<ICalcInterpreterEvent> events = new ArrayList<ICalcInterpreterEvent>();

	public Object getValue(Variable variable) {
		return variableMap.get(variable);
	}

	public void setValue(Variable variable, Object newValue) {
		variableMap.put(variable, newValue);
	}

	public void addInterpretationEvent(ICalcInterpreterEvent event) {
		events.add(event);
	}

	public void addFunction(ICalcFunction function) {
		functionMap.put(function.getName(), function);
	}

	public ICalcFunction getFunction(String name) {
		return functionMap.get(name);
	}

	public List<ICalcInterpreterEvent> getEvents() {
		return events;
	}
}
