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
package org.emftext.language.hedl.types;

import org.emftext.language.hedl.HedlFactory;
import org.emftext.language.hedl.JavaType;

public class HedlBuiltinTypes {

	public final static JavaType STRING = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType LONGSTRING = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType INT = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType DATE = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType DOUBLE = HedlFactory.eINSTANCE.createJavaType();
	public final static JavaType BOOL = HedlFactory.eINSTANCE.createJavaType();

	public final static JavaType[] TYPES = new JavaType[] {
		STRING, INT, DATE, DOUBLE, LONGSTRING, BOOL
	};

	static {
		STRING.setName("String");
		STRING.setJavaClass(String.class);
		LONGSTRING.setName("LongString");
		LONGSTRING.setJavaClass(String.class);
		INT.setName("Int");
		INT.setJavaClass(int.class);
		BOOL.setName("Bool");
		BOOL.setJavaClass(boolean.class);
		DATE.setName("Date");
		DATE.setJavaClass(java.util.Date.class);
		DOUBLE.setName("Double");
		DOUBLE.setJavaClass(double.class);
	}
}
