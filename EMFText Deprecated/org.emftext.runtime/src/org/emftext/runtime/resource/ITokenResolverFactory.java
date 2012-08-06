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
