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
package org.emftext.access.resource;


/**
 * A text parser parses a text into a tree of <code>EObject</code>s.
 * It is associated with a <code>IResource</code>.
 */
public interface IParser extends IConfigurable {

    /**
     * Parses the content given to the parser and create a tree 
     * of EObjects. The root of this tree is wrapped together 
     * with some commands that might be executed after parsing.
     * 
     * @return the result of the parse process
     */
	public IParseResult parse();

}
