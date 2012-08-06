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

import org.emftext.language.eag.interpreter.ITypeConverter;

public class NumberConverter implements ITypeConverter {

	public Class<?>[] getAvailableConversions(Class<?> type) {
		if (type == Integer.class) {
			return new Class<?>[] {Float.class, Double.class};
		}
		if (type == Float.class) {
			return new Class<?>[] {Double.class};
		}
		return null;
	}

	public Object convertTo(Object type, Class<?> targetType) {
		if (type instanceof Integer) {
			if (targetType == Float.class) {
				return new Float((Integer) type);
			}
			if (targetType == Double.class) {
				return new Double((Integer) type);
			}
		}
		if (type instanceof Float) {
			if (targetType == Double.class) {
				return new Float((Float) type);
			}
		}
		return null;
	}

}
