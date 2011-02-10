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

/**
 * A token that is returned by ITextLexer instances. Each token
 * has a name, a length and is found at a certain offset in a
 * document.
 */
public interface IToken {

	/**
	 * Returns the name of this token.
	 */
	public String getName();

	/**
	 * Returns the offset at which the token was found in the document.
	 */
	public int getOffset();

	/**
	 * Returns the length of this token.
	 */
	public int getLength();

	/**
	 * Returns false if the token is not usable for syntax highlighting.
	 */
	public boolean canBeUsedForSyntaxHighlighting();

	public String getText();
}
