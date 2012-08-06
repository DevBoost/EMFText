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
package org.emftext.sdk.generatorconfig.resource.generatorconfig;

// A TokenResolverFactory creates TokenResolvers for a given token name.
// They may be implemented like a registry.
public interface IGeneratorconfigTokenResolverFactory {

	// Creates a token resolver for normal tokens of type 'tokenName'.
	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver createTokenResolver(String tokenName);

	// Creates a token resolver for COLLECT-IN tokens that are stores in
	// feature 'featureName'.
	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver createCollectInTokenResolver(String featureName);
}
