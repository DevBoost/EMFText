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
package org.emftext.language.eag.interpreter;

/**
 * An IOperationProvider can compute the value of expressions of a certain
 * operator type. Depending on the result of calls to canHandle(), the
 * provider will be asked to interpret binary expressions.
 *
 * @param <OperatorType> the type of operator that can be handled
 */
public interface IOperationProvider<OperatorType> {

	public boolean canHandle(OperatorType operator, Class<?> leftType, Class<?> rightType);

	public Object interpret(OperatorType operator, Object left, Object right);
}
