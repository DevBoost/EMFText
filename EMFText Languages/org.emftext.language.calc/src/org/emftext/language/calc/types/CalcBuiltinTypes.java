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
package org.emftext.language.calc.types;

import org.emftext.language.calc.CalcFactory;
import org.emftext.language.calc.Type;

public class CalcBuiltinTypes {

	public static final Type DOUBLE = CalcFactory.eINSTANCE.createType();
	public static final Type STRING = CalcFactory.eINSTANCE.createType();

	public final static Type[] ALL_BUILT_IN_TYPES = new Type[] {
		DOUBLE, STRING
	};

	static {
		DOUBLE.setName("double");
		STRING.setName("string");
	}
}
