/*******************************************************************************
 * Copyright (c) 2006-2010 
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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

/**
 * The CsTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class CsTokenResolverFactory implements org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver defaultResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsDefaultTokenResolver();
	
	public CsTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver>();
		registerTokenResolver("QUALIFIED_NAME", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUALIFIED_NAMETokenResolver());
		registerTokenResolver("HEXNUMBER", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsHEXNUMBERTokenResolver());
		registerTokenResolver("TABNUMBER", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsTABNUMBERTokenResolver());
		registerTokenResolver("STRING", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsSTRINGTokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_39_39_92", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_39_39_92TokenResolver());
		registerTokenResolver("QUOTED_36_36", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_36_36TokenResolver());
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver> resolverMap, String key, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
