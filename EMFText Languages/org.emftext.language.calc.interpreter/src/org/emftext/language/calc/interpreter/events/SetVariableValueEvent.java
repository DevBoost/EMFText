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
package org.emftext.language.calc.interpreter.events;

import org.emftext.language.calc.Variable;

public class SetVariableValueEvent implements ICalcInterpreterEvent {

	private Variable variable;
	private Object value;

	public SetVariableValueEvent(Variable variable, Object value) {
		super();
		this.variable = variable;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Setting variable '" + variable.getName() + "' to " + value;
	}
}
