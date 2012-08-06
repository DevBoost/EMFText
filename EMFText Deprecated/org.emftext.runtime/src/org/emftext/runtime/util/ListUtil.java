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
package org.emftext.runtime.util;

import java.util.List;

/**
 * A utility class that encapsulates some case operations that need to be performed
 * unchecked, because of Java's type erasure.
 */
@Deprecated public class ListUtil {

	@SuppressWarnings("unchecked")
	public <T> List<T> castListUnchecked(Object list) {
		return (List<T>) list;
	}
}
