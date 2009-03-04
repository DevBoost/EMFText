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
 * A TokenResolverFactory creates TokenResolvers for a given token name. 
 * They may be implemented like a registry.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public interface ITokenResolverFactory {

	/**
	 * Creates a token resolver for normal tokens of type 'tokenName'.
	 */
	public ITokenResolver createTokenResolver(String tokenName);

	/**
	 * Creates a token resolver for COLLECT-IN tokens that are stores in 
	 * feature 'featureName'.
	 */
	public ITokenResolver createCollectInTokenResolver(String featureName);
}
