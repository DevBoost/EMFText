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
package org.emftext.language.pico.resource.pico.interpreter;

import java.util.List;

import org.emftext.language.pico.AdditiveExpression;
import org.emftext.language.pico.Assignment;
import org.emftext.language.pico.ComparatorExpression;
import org.emftext.language.pico.ComparatorType;
import org.emftext.language.pico.Expression;
import org.emftext.language.pico.IDType;
import org.emftext.language.pico.IfStatement;
import org.emftext.language.pico.MultiplicativeExpression;
import org.emftext.language.pico.Natural;
import org.emftext.language.pico.NilLiteral;
import org.emftext.language.pico.Program;
import org.emftext.language.pico.Statement;
import org.emftext.language.pico.String;
import org.emftext.language.pico.VariableReference;
import org.emftext.language.pico.WhileStatement;
import org.emftext.language.pico.resource.pico.util.AbstractPicoInterpreter;

public class PicoInterpreter extends AbstractPicoInterpreter<Boolean, PicoInterpretationContext>{

	@Override
	public Boolean interprete_org_emftext_language_pico_Program(
			Program program,
			PicoInterpretationContext context) {
		List<Statement> statements = program.getStatements();
		addObjectsToInterpreteInReverseOrder(statements);
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_pico_Natural(
			Natural natural,
			PicoInterpretationContext context) {
		int value = natural.getValue();
		context.push(value);
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_pico_String(
			String object,
			PicoInterpretationContext context) {
		context.push(object.getValue());
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_pico_Assignment(
			Assignment assignment, 
			PicoInterpretationContext context) {
		if (context.expressionStackSize() == 0) {
			Expression right = assignment.getRight();
			addObjectToInterprete(assignment);
			addObjectToInterprete(right);
		} else {
			IDType left = assignment.getLeft();
			Object expressionValue = context.pop();
			context.setValue(left.getPicoID(), expressionValue);
		}
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_pico_IfStatement(IfStatement ifStatement, PicoInterpretationContext context) {

		if (context.expressionStackSize() == 0) {
			Expression condition = ifStatement.getCondition();
			addObjectToInterprete(ifStatement);
			addObjectToInterprete(condition);
		} else {
			Object expressionValue = context.pop();
			if (Boolean.TRUE.equals(expressionValue)) {
				List<Statement> thenStatements = ifStatement.getThen();
				addObjectsToInterpreteInReverseOrder(thenStatements);
			} else if (Boolean.FALSE.equals(expressionValue)) {
				List<Statement> elseStatements = ifStatement.getElse();
				addObjectsToInterpreteInReverseOrder(elseStatements);
			} else {
				throw new RuntimeException("Unexpected type for condition of IF statement.");
			}
		}
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_pico_WhileStatement(WhileStatement whileStatement, PicoInterpretationContext context) {
		if (context.expressionStackSize() == 0) {
			Expression condition = whileStatement.getCondition();
			addObjectToInterprete(whileStatement);
			addObjectToInterprete(condition);
		} else {
			Object expressionValue = context.pop();
			if (Boolean.TRUE.equals(expressionValue)) {
				List<Statement> thenStatements = whileStatement.getBody();
				addObjectToInterprete(whileStatement);
				addObjectsToInterpreteInReverseOrder(thenStatements);
			} else if (Boolean.FALSE.equals(expressionValue)) {
				// do nothing, end of loop
			} else {
				throw new RuntimeException("Unexpected type for condition of WHILE statement.");
			}
		}
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_pico_VariableReference(VariableReference varRef, PicoInterpretationContext context) {
		java.lang.String name = varRef.getVariable().getPicoID();
		Object value = context.getValue(name);
		if (value == null) {
			throw new RuntimeException("Variable '" + name + "' is not initialized.");
		}
		context.push(value);
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_pico_NilLiteral(NilLiteral object, PicoInterpretationContext context) {
		context.push(null);
		return true;
	}
	
	@Override
	public Boolean interprete_org_emftext_language_pico_AdditiveExpression(AdditiveExpression additive, PicoInterpretationContext context) {
		if (context.expressionStackSize() == 0) {
			Expression left = additive.getLeft();
			Expression right = additive.getRight();
			addObjectToInterprete(additive);
			addObjectToInterprete(left);
			addObjectToInterprete(right);
		} else {
			boolean plus = additive.isPlus();
			Object rightValue = context.pop();
			Object leftValue = context.pop();
			Object compareValue = add(leftValue, rightValue, plus);
			context.push(compareValue);
		}
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_pico_MultiplicativeExpression(MultiplicativeExpression multiplicative, PicoInterpretationContext context) {
		if (context.expressionStackSize() == 0) {
			Expression left = multiplicative.getLeft();
			Expression right = multiplicative.getRight();
			addObjectToInterprete(multiplicative);
			addObjectToInterprete(left);
			addObjectToInterprete(right);
		} else {
			boolean times = multiplicative.isTimes();
			Object rightValue = context.pop();
			Object leftValue = context.pop();
			Object compareValue = mult(leftValue, rightValue, times);
			context.push(compareValue);
		}
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_pico_ComparatorExpression(ComparatorExpression comparatorExp, PicoInterpretationContext context) {
		if (context.expressionStackSize() == 0) {
			Expression left = comparatorExp.getLeft();
			Expression right = comparatorExp.getRight();
			addObjectToInterprete(comparatorExp);
			addObjectToInterprete(left);
			addObjectToInterprete(right);
		} else {
			ComparatorType comparator = comparatorExp.getComparator();
			Object rightValue = context.pop();
			Object leftValue = context.pop();
			Object compareValue = compare(leftValue, rightValue, comparator);
			context.push(compareValue);
		}
		return true;
	}

	private Object compare(Object left, Object right, ComparatorType comparator) {
		if (left instanceof Integer && right instanceof Integer) {
			Integer leftInt = (Integer) left;
			Integer rightInt = (Integer) right;
			if (comparator == ComparatorType.EQUALS) {
				return leftInt.equals(rightInt);
			} else if (comparator == ComparatorType.LOWER_THAN) {
				return leftInt.compareTo(rightInt) > 0;
			} else if (comparator == ComparatorType.GREATER_THAN) {
				return leftInt.compareTo(rightInt) < 0;
			}
		}
		throw new RuntimeException("Can't compare " + left + " and " + right);
	}

	private Object add(Object left, Object right, boolean plus) {
		if (left instanceof Integer && right instanceof Integer) {
			Integer leftInt = (Integer) left;
			Integer rightInt = (Integer) right;
			if (plus) {
				return leftInt + rightInt;
			} else {
				return leftInt - rightInt;
			}
		}
		throw new RuntimeException("Can't add " + left + " and " + right);
	}

	private Object mult(Object left, Object right, boolean times) {
		if (left instanceof Integer && right instanceof Integer) {
			Integer leftInt = (Integer) left;
			Integer rightInt = (Integer) right;
			if (times) {
				return leftInt * rightInt;
			} else {
				return leftInt / rightInt;
			}
		}
		throw new RuntimeException("Can't multiply " + left + " and " + right);
	}

	@Override
	public boolean continueInterpretation(PicoInterpretationContext context, Boolean result) {
		if (result == null || Boolean.FALSE.equals(result)) {
			throw new RuntimeException("Unsupported element for interpretation: " + getNextObjectToInterprete());
		}
		return true;
	}
}
