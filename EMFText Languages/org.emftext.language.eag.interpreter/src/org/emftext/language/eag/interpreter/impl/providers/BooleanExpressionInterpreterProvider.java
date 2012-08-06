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
package org.emftext.language.eag.interpreter.impl.providers;

import java.util.ArrayList;
import java.util.Collection;

import org.emftext.language.eag.BooleanExpression;
import org.emftext.language.eag.BooleanOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;
import org.emftext.language.eag.interpreter.impl.references.IReference;
import org.emftext.language.eag.interpreter.numbers.IntegerEqualsProvider;
import org.emftext.language.eag.interpreter.numbers.StringEqualsProvider;

public class BooleanExpressionInterpreterProvider extends AbstractInterpreterProvider {

	public static final BooleanExpressionInterpreterProvider INSTANCE = new BooleanExpressionInterpreterProvider();
	
	public static Collection<IOperationProvider<BooleanOperator>> operationProviders;
	
	static {
		operationProviders = new ArrayList<IOperationProvider<BooleanOperator>>();
		operationProviders.add(new IntegerEqualsProvider());
		operationProviders.add(new StringEqualsProvider());
	};

	public IReference interpret(BooleanExpression expression, IReference leftRef, IReference rightRef) {
		Object left = leftRef.getTarget();
		Object right = rightRef.getTarget();
		log("BooleanExpressionInterpreterProvider.interpret(" + left + ", " + right + ")");
		BooleanOperator operator = expression.getOperator();
		return interpretWithConversion(operationProviders, operator, left, right);
	}
}
