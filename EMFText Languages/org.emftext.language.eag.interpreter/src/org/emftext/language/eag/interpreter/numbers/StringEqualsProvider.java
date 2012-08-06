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
package org.emftext.language.eag.interpreter.numbers;

import org.emftext.language.eag.BooleanOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;

public class StringEqualsProvider implements IOperationProvider<BooleanOperator> {

	public boolean canHandle(
			BooleanOperator operator, 
			Class<?> leftType,
			Class<?> rightType) {
		if (operator != BooleanOperator.EQUALS) {
			return false;
		}
		return leftType == String.class && rightType == String.class;
	}

	public Object interpret(BooleanOperator operator, Object left, Object right) {
		String leftString = (String) left;
		String rightString = (String) right;
		if (leftString == null && rightString == null) {
			return true;
		}
		return leftString.equals(rightString);
	}
}
