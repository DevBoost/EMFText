/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.resource;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
	
	/**
	 * Parses the document and returns a list of expected elements.
	 * Each expected element covers a range in the input stream.
	 * 
	 * If the parser implementation can not determine expected 
	 * elements null can be returned.
	 * This method is used by the code completion to figure out
	 * which proposals can be shown to users for a given cursor
	 * position.
	 * 
	 * The class 'type' is used as start symbol.
	 */
	public List<IExpectedElement> parseToExpectedElements(EClass type);
}
