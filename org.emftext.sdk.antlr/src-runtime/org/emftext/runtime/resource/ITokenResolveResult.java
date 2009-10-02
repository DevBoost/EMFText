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

/**
 * Implementations of this interface are used store the result of
 * resolving a token.
 */
public interface ITokenResolveResult {
	
	/**
	 * Returns the error message that describes what went wrong while
	 * resolving a token.
	 */
	public String getErrorMessage();

	/**
	 * Sets the error message that describes what went wrong while
	 * resolving a token. If a mapping for the token was 
	 * already found (i.e., setResult() was called before), the 
	 * call to this method is ignored. If setResult() is called
	 * afterwards, the error message is also discarded.
	 * 
	 * @param message the error that prevented resolving the token
	 */
	public void setErrorMessage(String message);
	
	/**
	 * Sets the result of resolving a token.
	 * 
	 * @param resolvedToken
	 */
	public void setResolvedToken(Object resolvedToken);

	/**
	 * Returns the result of resolving a token or null if it
	 * could not be resolved correctly.
	 * 
	 * @param resolvedToken
	 */
	public Object getResolvedToken();
}
