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
package org.emftext.runtime.resource;

import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;

/**
 * A text parser parses a text into a tree of <code>EObject</code>s.
 * It is associated with a <code>TextResource</code>.
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 *
 */
public interface ITextParser extends IConfigurable {

	/**
	 * Returns an instance of the parser. This factory method
	 * is needed, because we can not create ANTLR parsers using
	 * the default constructor without arguments, because they
	 * expect the input stream or rather a token stream.
	 * 
	 * @param inputStream
	 * @param encoding
	 * @return
	 */
	public ITextParser createInstance(InputStream inputStream,
			String encoding);
	
	/**
	 * Set the associate text resource.
	 * 
	 * @param resource The text resource.
	 */
    public void setResource(ITextResource resource);
    
    /**
     * Get the associated text resource.
     * 
     * @return The text resource.
     */
    public ITextResource getResource();
    
    /**
     * Return the root element of the <code>EObject</code>-Tree. 
     * Parse some content if this is necessary to obtain the tree.
     * 
     * @return The root object.
     */
	public EObject parse();
}
