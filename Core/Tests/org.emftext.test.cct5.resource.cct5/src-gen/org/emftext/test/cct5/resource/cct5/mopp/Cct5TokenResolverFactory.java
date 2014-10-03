/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Cct5TokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class Cct5TokenResolverFactory implements org.emftext.test.cct5.resource.cct5.ICct5TokenResolverFactory {
	
	private Map<String, org.emftext.test.cct5.resource.cct5.ICct5TokenResolver> tokenName2TokenResolver;
	private Map<String, org.emftext.test.cct5.resource.cct5.ICct5TokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.test.cct5.resource.cct5.ICct5TokenResolver defaultResolver = new org.emftext.test.cct5.resource.cct5.analysis.Cct5DefaultTokenResolver();
	
	public Cct5TokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, org.emftext.test.cct5.resource.cct5.ICct5TokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, org.emftext.test.cct5.resource.cct5.ICct5TokenResolver>();
		registerTokenResolver("TEXT", new org.emftext.test.cct5.resource.cct5.analysis.Cct5TEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.emftext.test.cct5.resource.cct5.analysis.Cct5QUOTED_34_34TokenResolver());
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.test.cct5.resource.cct5.ICct5TokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.test.cct5.resource.cct5.ICct5TokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.test.cct5.resource.cct5.ICct5TokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.test.cct5.resource.cct5.ICct5TokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.test.cct5.resource.cct5.ICct5TokenResolver internalCreateResolver(Map<String, org.emftext.test.cct5.resource.cct5.ICct5TokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, org.emftext.test.cct5.resource.cct5.ICct5TokenResolver> resolverMap, String key, org.emftext.test.cct5.resource.cct5.ICct5TokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
