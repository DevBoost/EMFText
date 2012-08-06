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
package org.emftext.language.threevaluedlogic;

import org.emftext.language.threevaluedlogic.resource.tvl.util.AbstractTvlInterpreter;

public class TVLInterpreter extends AbstractTvlInterpreter<Boolean, InterpreterContext> {

	private Constants and(Constants arg1, Constants arg2) {
		if (arg1 == Constants.TRUE && arg2 == Constants.TRUE) {
			return Constants.TRUE;
		} else if (arg1 == Constants.FALSE || arg2 == Constants.FALSE) {
			return Constants.FALSE;
		} else {
			return Constants.UNKNOWN;
		}
	}

	private Constants or(Constants arg1, Constants arg2) {
		if (arg1 == Constants.TRUE || arg2 == Constants.TRUE) {
			return Constants.TRUE;
		} else if (arg1 == Constants.UNKNOWN || arg2 == Constants.UNKNOWN) {
			return Constants.UNKNOWN;
		} else {
			return Constants.FALSE;
		}
	}

	private Constants negate(Constants arg) {
		if (arg == Constants.FALSE) {
			return Constants.TRUE;
		} else if (arg == Constants.TRUE) {
			return Constants.FALSE;
		} else {
			return Constants.UNKNOWN;
		}
	}

	@Override
	public Boolean interprete_org_emftext_language_threevaluedlogic_And(
			And object, InterpreterContext context) {
		Constants result = and(context.pop(), context.pop());
		context.push(result);
		object.setComputedValue(result);
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_threevaluedlogic_Negation(
			Negation object, InterpreterContext context) {
		Constants result = negate(context.pop());
		context.push(result);
		object.setComputedValue(result);
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_threevaluedlogic_Nested(
			Nested object, InterpreterContext context) {
		Constants result = context.pop();
		context.push(result);
		object.setComputedValue(result);
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_threevaluedlogic_Or(
			Or object, InterpreterContext context) {
		Constants result = or(context.pop(), context.pop());
		context.push(result);
		object.setComputedValue(result);
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_threevaluedlogic_Constant(
			Constant object, InterpreterContext context) {
		context.push(object.getValue());
		object.setComputedValue(object.getValue());
		return true;
	}
}
