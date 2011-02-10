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
package org.emftext.access.resource;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;

/**
 * Converts a tree of <code>EObject</code>s into a plain text.
 */
public interface IPrinter extends IConfigurable {

	/**
	 * Prints the given <code>EObject</code> and its content to some 
	 * underlying output stream.
	 * 
	 * @param element The element to print.
	 * @throws IOException if printing to an underlying stream or device fails. 
	 */
    public void print(EObject element) throws IOException;
}
