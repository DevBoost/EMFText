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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsTokenResolverFactory implements org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolverFactory {
	
	private java.util.Map<java.lang.String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver> tokenName2TokenResolver;
	private java.util.Map<java.lang.String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver defaultResolver = new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsDefaultTokenResolver();
	
	public CsTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.HashMap<java.lang.String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.HashMap<java.lang.String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver>();
		registerTokenResolver("QUALIFIED_NAME", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUALIFIED_NAMETokenResolver());
		registerTokenResolver("NUMBER", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsNUMBERTokenResolver());
		registerTokenResolver("HEXNUMBER", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsHEXNUMBERTokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34_92", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_34_34_92TokenResolver());
		registerTokenResolver("QUOTED_39_39_92", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_39_39_92TokenResolver());
		registerTokenResolver("QUOTED_36_36", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_36_36TokenResolver());
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver createTokenResolver(java.lang.String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver createCollectInTokenResolver(java.lang.String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(java.lang.String tokenName, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(java.lang.String featureName, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver deRegisterTokenResolver(java.lang.String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver internalCreateResolver(java.util.Map<java.lang.String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<java.lang.String, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver> resolverMap, java.lang.String key, org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
