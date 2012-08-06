/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.resource.impl;

/**
 * Utility class that provides a method to cast objects to
 * type parameterized classes without a warning.
 */
@Deprecated public class Util {

	@SuppressWarnings("unchecked")
	public static <T > T cast(Object temp) {
		return (T) temp;
	}
}
