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
package org.emftext.language.calc.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.emftext.language.calc.Calculation;
import org.emftext.language.calc.Variable;
import org.emftext.language.calc.interpreter.CalcContext;
import org.emftext.language.calc.interpreter.CalcInterpreter;
import org.emftext.language.calc.interpreter.ICalcFunction;
import org.emftext.language.calc.interpreter.InterpreterException;

public class InterpreterTest extends AbstractCalcTestCase {

	private Map<String, Object> input;
	private Map<String, Object> output;
	
	private CalcInterpreter interpreter;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		input = new LinkedHashMap<String, Object>();
		output = new LinkedHashMap<String, Object>();
		
		interpreter = new CalcInterpreter();
	}
	
	public void testNoRules() {
		input.put("x", 1);
		output.put("x", 1);
		interpret("input double x output", input, output);
	}

	public void testSimpleAssignment() {
		input.put("x", 2.0);
		output.put("y", 2.0);
		interpret("input double x output double y y = x", input, output);
	}

	public void testSimpleAddition() {
		input.put("x", 2.0);
		output.put("y", 5.0);
		interpret("input double x output double y y = x + 3", input, output);
	}

	public void testSimpleSubtraction() {
		input.put("x", 2.0);
		output.put("y", -1.0);
		// no rules
		interpret("input double x output double y y = x - 3", input, output);
	}

	public void testSimpleMultiplication() {
		input.put("x", 2.0);
		output.put("y", 6.0);
		// no rules
		interpret("input double x output double y y = x * 3", input, output);
	}

	public void testSimpleAddAndMultiply() {
		input.put("x", 2.0);
		output.put("y", 8.0);
		// no rules
		interpret("input double x output double y y = x + 2 * 3", input, output);
	}

	public void testSimpleMultiplyAndDiv() {
		input.put("x", 6.0);
		output.put("y", 4.0);
		// no rules
		interpret("input double x output double y y = 2 * x / 3", input, output);
	}

	public void testSimpleConditionFalse() {
		input.put("x", 2.0);
		output.put("y", 1.0);
		interpret("input double x output double y  y = 1  wenn x > 2 y = 3", input, output);
	}

	public void testSimpleConditionTrue() {
		input.put("x", 2.0);
		output.put("y", 3.0);
		interpret("input double x output double y  y = 1  wenn x == 2 y = 3", input, output);
	}

	public void testSimpleStringConditionFalse() {
		input.put("x", 2.0);
		output.put("y", 1.0);
		interpret("input double x output double y  y = 1  wenn \"a\" == \"b\" y = 3", input, output);
	}

	public void testSimpleStringConditionTrue() {
		input.put("x", 2.0);
		output.put("y", 3.0);
		interpret("input double x output double y  y = 1  wenn \"a\" == \"a\" y = 3", input, output);
	}

	public void testComplexConditionFalse() {
		input.put("x", 2.0);
		input.put("y", 4.0);
		output.put("z", 1.0);
		interpret(
			"input double x double y " +
			"output double z " +
			"z = 1 " +
			"wenn x > 2 und y > 3 " +
			"z = 4", 
			input, output);
	}

	public void testComplexConditionTrue() {
		input.put("x", 3.0);
		input.put("y", 4.0);
		output.put("z", 4.0);
		interpret(
			"input double x double y " +
			"output double z " +
			"z = 1 " +
			"wenn x > 2 und y > 3 " +
			"z = 4", 
			input, output);
	}

	public void testFunction() {
		input.put("x", 3.0);
		output.put("y", 4.0);
		
		ICalcFunction succFunction = new ICalcFunction() {
			
			public Object evaluate(Object... arguments) {
				if (arguments.length != 1) {
					throw new InterpreterException("Invalid number of arguments.");
				}
				Object argument = arguments[0];
				if (argument == null) {
					throw new InterpreterException("Invalid argument 'null'");
				} else if (argument instanceof Double) {
					Double doubleArgument = (Double) argument;
					return doubleArgument + 1.0;
				}
				throw new InterpreterException("Invalid argument type: " + argument.getClass().getName());
			}

			public String getName() {
				return "succ";
			}
		};
		interpret(
			"input double x " +
			"output double y " +
			"y = succ(x)", 
			input, output, succFunction);
	}

	public void testNegation() {
		input.put("x", 3.0);
		output.put("y", -3.0);
		interpret("input double x output double y y = -x", input, output);
	}

	private void interpret(String text, Map<String, Object> input, Map<String, Object> expectedOutput, ICalcFunction... functions) {
		Calculation calculation = assertParseable(text);
		CalcContext context = interpreter.interpret(calculation, input, functions);
		for (String variableName : expectedOutput.keySet()) {
			Variable variable = calculation.getVariable(variableName);
			Object expectedValue = expectedOutput.get(variableName);
			Object actualValue = context.getValue(variable);
			assertEquals("Value differs for variable " + variableName, expectedValue, actualValue);
		}
	}
}
