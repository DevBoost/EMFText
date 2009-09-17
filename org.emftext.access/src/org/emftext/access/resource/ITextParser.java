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
package org.emftext.access.resource;


/**
 * A text parser parses a text into a tree of <code>EObject</code>s.
 * It is associated with a <code>TextResource</code>.
 */
public interface ITextParser extends IConfigurable {

    /**
     * Parses the content given to the parser and create a tree 
     * of EObjects. The root of this tree is wrapped together 
     * with some commands that might be executed after parsing.
     * 
     * @return the result of the parse process
     */
	public IParseResult parse();

}
