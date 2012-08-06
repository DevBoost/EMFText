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

import java.util.List;
import java.util.Map;

import org.emftext.language.calc.Additive;
import org.emftext.language.calc.And;
import org.emftext.language.calc.Calculation;
import org.emftext.language.calc.Comp;
import org.emftext.language.calc.Compare;
import org.emftext.language.calc.Compound;
import org.emftext.language.calc.Expression;
import org.emftext.language.calc.FunctionCall;
import org.emftext.language.calc.MulDiv;
import org.emftext.language.calc.Multiplictive;
import org.emftext.language.calc.Negation;
import org.emftext.language.calc.NumberLiteral;
import org.emftext.language.calc.Or;
import org.emftext.language.calc.PlusMinus;
import org.emftext.language.calc.Rule;
import org.emftext.language.calc.StringLiteral;
import org.emftext.language.calc.Variable;
import org.emftext.language.calc.VariableReference;
import org.emftext.language.calc.interpreter.events.CheckConditionEvent;
import org.emftext.language.calc.interpreter.events.SetVariableValueEvent;
import org.emftext.language.calc.resource.calc.util.AbstractCalcInterpreter;

public class CalcInterpreter extends AbstractCalcInterpreter<Object, CalcContext> {

	public CalcContext interpret(
			Calculation calculation,
			Map<String, Object> input,
			ICalcFunction... functions) {
		CalcContext context = new CalcContext();
		for (ICalcFunction function : functions) {
			context.addFunction(function);
		}
		setInputValues(calculation, input, context);
		interprete(calculation, context);
		return context;
	}

	private void setInputValues(Calculation calculation,
			Map<String, Object> input, CalcContext context) {
		// set input
		for (String variableName : input.keySet()) {
			Variable variable = calculation.getVariable(variableName);
			context.setValue(variable , input.get(variableName));
		}
	}

	@Override
	public Object interprete_org_emftext_language_calc_Calculation(
			Calculation calculation, CalcContext context) {
		
		List<Rule> rules = calculation.getRules();
		// interpret all rules
		for (Rule rule : rules) {
			interprete_org_emftext_language_calc_Rule(rule, context);
		}
		return null;
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_Rule(Rule rule,
			CalcContext context) {
		
		Expression condition = rule.getCondition();
		Object conditionValue = Boolean.TRUE;
		if (condition != null) {
			conditionValue = interprete(condition, context);
		}
		if (conditionValue == null) {
			throw new InterpreterException("Can't evaluate condition");
		}
		
		if (!(conditionValue instanceof Boolean)) {
			throw new InterpreterException("Condition value is not boolean.");
		}
		
		Boolean booleanValue = (Boolean) conditionValue;
		if (condition != null) {
			context.addInterpretationEvent(new CheckConditionEvent(condition, booleanValue));
		}
		if (Boolean.TRUE.equals(conditionValue)) {
			Variable left = rule.getTarget();
			Expression right = rule.getRight();
			Object value = interprete(right, context);
			context.setValue(left, value);
			context.addInterpretationEvent(new SetVariableValueEvent(left, value));
		}
		return null;
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_Additive(
			Additive additive, CalcContext context) {
		
		Object leftValue = getValue(additive.getLeft(), context);
		Object rightValue = getValue(additive.getRight(), context);
		
		PlusMinus operator = additive.getOperator();
		if (operator == PlusMinus.PLUS) {
			if (leftValue instanceof String && rightValue instanceof String) {
				String leftString = (String) leftValue;
				String rightString = (String) rightValue;
				return leftString + rightString;
			} else if (leftValue instanceof Double && rightValue instanceof Double) {
				Double leftDouble = (Double) leftValue;
				Double rightDouble = (Double) rightValue;
				return leftDouble.doubleValue() + rightDouble.doubleValue();
			}
		} else if (operator == PlusMinus.MINUS) {
			if (leftValue instanceof Double && rightValue instanceof Double) {
				Double leftDouble = (Double) leftValue;
				Double rightDouble = (Double) rightValue;
				return leftDouble.doubleValue() - rightDouble.doubleValue();
			}
		} else {
			throw new InterpreterException("Unknown operator " + operator);
		}
		throw new InterpreterException("Cannot handle additive.");
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_Multiplictive(
			Multiplictive multiplictive, CalcContext context) {
		Object leftValue = getValue(multiplictive.getLeft(), context);
		Object rightValue = getValue(multiplictive.getRight(), context);
		
		MulDiv operator = multiplictive.getOperator();
		if (operator == MulDiv.MUL) {
			if (leftValue instanceof Double && rightValue instanceof Double) {
				Double leftDouble = (Double) leftValue;
				Double rightDouble = (Double) rightValue;
				return leftDouble.doubleValue() * rightDouble.doubleValue();
			}
		} else if (operator == MulDiv.DIV) {
			if (leftValue instanceof Double && rightValue instanceof Double) {
				Double leftDouble = (Double) leftValue;
				Double rightDouble = (Double) rightValue;
				return leftDouble.doubleValue() / rightDouble.doubleValue();
			}
		} else {
			throw new InterpreterException("Unknown operator " + operator);
		}
		throw new InterpreterException("Cannot handle multiplicative.");
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_Compare(Compare compare,
			CalcContext context) {
		Object leftValue = getValue(compare.getLeft(), context);
		Object rightValue = getValue(compare.getRight(), context);
		
		Comp operator = compare.getOperator();
		if (leftValue instanceof Double && rightValue instanceof Double) {
			Double leftDouble = (Double) leftValue;
			Double rightDouble = (Double) rightValue;
			if (operator == Comp.EQ) {
				return leftDouble.doubleValue() == rightDouble.doubleValue();
			} else if (operator == Comp.LT) {
				return leftDouble.doubleValue() < rightDouble.doubleValue();
			} else if (operator == Comp.LTE) {
				return leftDouble.doubleValue() <= rightDouble.doubleValue();
			} else if (operator == Comp.GT) {
				return leftDouble.doubleValue() > rightDouble.doubleValue();
			} else if (operator == Comp.GTE) {
				return leftDouble.doubleValue() >= rightDouble.doubleValue();
			} else {
				throw new InterpreterException("Unknown operator " + operator);
			}
		} else if (leftValue instanceof String && rightValue instanceof String) {
			String leftString = (String) leftValue;
			String rightString = (String) rightValue;
			return leftString.equals(rightString);
		}
		throw new InterpreterException("Cannot handle compare.");
	}

	private Object getValue(Expression expression, CalcContext context) {
		Object value = interprete(expression, context);
		if (value == null) {
			throw new InterpreterException("Cannot compare (value is null): " + expression);
		}
		return value;
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_And(And and,
			CalcContext context) {

		Object leftValue = getValue(and.getLeft(), context);
		Object rightValue = getValue(and.getRight(), context);
		
		if (leftValue instanceof Boolean && rightValue instanceof Boolean) {
			Boolean leftBoolean = (Boolean) leftValue;
			Boolean rightBoolean = (Boolean) rightValue;
			return leftBoolean && rightBoolean;
		}
		throw new InterpreterException("Cannot handle AND.");
	}

	@Override
	public Object interprete_org_emftext_language_calc_Or(Or or,
			CalcContext context) {

		Object leftValue = getValue(or.getLeft(), context);
		Object rightValue = getValue(or.getRight(), context);
		
		if (leftValue instanceof Boolean && rightValue instanceof Boolean) {
			Boolean leftBoolean = (Boolean) leftValue;
			Boolean rightBoolean = (Boolean) rightValue;
			return leftBoolean || rightBoolean;
		}
		throw new InterpreterException("Cannot handle OR.");
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_FunctionCall(
			FunctionCall functionCall, CalcContext context) {

		String name = functionCall.getName();
		ICalcFunction function = context.getFunction(name);
		if (function == null) {
			throw new InterpreterException("Cannot find function '" + name + "'.");
		}
		List<Expression> arguments = functionCall.getArguments();
		Object[] argumentValues = new Object[arguments.size()];
		for (int i = 0; i < argumentValues.length; i++) {
			Expression argument = arguments.get(i);
			argumentValues[i] = interprete(argument, context);
		}
		return function.evaluate(argumentValues);
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_Negation(
			Negation negation, CalcContext context) {
		Expression body = negation.getBody();
		Object bodyValue = interprete(body, context);
		if (!(bodyValue instanceof Double)) {
			throw new InterpreterException("Wrong type for negation.");
		}
		Double doubleValue = (Double) bodyValue;
		return -doubleValue.doubleValue();
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_Compound(
			Compound compound, CalcContext context) {
		return interprete(compound.getBody(), context);
	}

	@Override
	public Object interprete_org_emftext_language_calc_StringLiteral(
			StringLiteral stringLiteral, CalcContext context) {
		return stringLiteral.getValue();
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_NumberLiteral(
			NumberLiteral numberLiteral, CalcContext context) {
		return numberLiteral.getValue();
	}
	
	@Override
	public Object interprete_org_emftext_language_calc_VariableReference(
			VariableReference variableReference, CalcContext context) {
		Variable variable = variableReference.getVariable();
		Object value = context.getValue(variable);
		if (value == null) {
			throw new InterpreterException("Variable '" + variable.getName() + "' is undefined.");
		}
		return value;
	}
}
