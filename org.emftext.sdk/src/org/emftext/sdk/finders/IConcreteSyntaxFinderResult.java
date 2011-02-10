/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.finders;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * Implementations of this interface are used to return
 * the result of searching for a concrete syntax definition.
 */
public interface IConcreteSyntaxFinderResult {
	
	/**
	 * Returns the found concrete syntax definition of
	 * null if none was found.
	 */
	public ConcreteSyntax getConcreteSyntax();
}
