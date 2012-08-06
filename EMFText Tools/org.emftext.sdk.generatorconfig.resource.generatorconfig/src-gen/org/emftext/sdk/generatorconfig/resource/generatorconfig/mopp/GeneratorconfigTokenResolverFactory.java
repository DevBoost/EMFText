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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

public class GeneratorconfigTokenResolverFactory implements org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolverFactory {

	private java.util.Map<java.lang.String, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver> tokenName2TokenResolver;
	private java.util.Map<java.lang.String, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver defaultResolver = new org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.GeneratorconfigDefaultTokenResolver();

	public GeneratorconfigTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.HashMap<java.lang.String, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.HashMap<java.lang.String, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver>();
		registerTokenResolver("QUALIFIED_NAME", new org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.GeneratorconfigQUALIFIED_NAMETokenResolver());
		registerTokenResolver("NUMBER", new org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.GeneratorconfigNUMBERTokenResolver());
		registerTokenResolver("HEXNUMBER", new org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.GeneratorconfigHEXNUMBERTokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.CsQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34_92", new org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.CsQUOTED_34_34_92TokenResolver());
		registerTokenResolver("QUOTED_39_39_92", new org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.CsQUOTED_39_39_92TokenResolver());
		registerTokenResolver("QUOTED_36_36", new org.emftext.sdk.generatorconfig.resource.generatorconfig.analysis.CsQUOTED_36_36TokenResolver());
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver createTokenResolver(java.lang.String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver createCollectInTokenResolver(java.lang.String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}

	protected boolean registerTokenResolver(java.lang.String tokenName, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}

	protected boolean registerCollectInTokenResolver(java.lang.String featureName, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}

	protected org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver deRegisterTokenResolver(java.lang.String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}

	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver internalCreateResolver(java.util.Map<java.lang.String, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}

	private boolean internalRegisterTokenResolver(java.util.Map<java.lang.String, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver> resolverMap, java.lang.String key, org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}

}
