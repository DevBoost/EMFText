package org.emftext.runtime.resource.impl;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;

public class BasicTokenResolverFactory implements ITokenResolverFactory {

	private Map<String,ITokenResolver> tokenName2TokenResolver;
	private Map<String,ITokenResolver> featureName2CollectInTokenResolver;
	private static ITokenResolver defaultResolver = new JavaBasedTokenResolver();
	
	public BasicTokenResolverFactory(){
		tokenName2TokenResolver = new HashMap<String,ITokenResolver>();
		featureName2CollectInTokenResolver = new HashMap<String,ITokenResolver>();
	}
	
	public ITokenResolver createTokenResolver(String tokenName) {		
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}

	public ITokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, ITokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}

	protected boolean registerCollectInTokenResolver(String featureName, ITokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected ITokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}

	private ITokenResolver internalCreateResolver(Map<String,ITokenResolver> resolverMap, String key) {
		if(resolverMap.containsKey(key)){
			return resolverMap.get(key);
		}
		else{
			return defaultResolver;
		}
	}

	private boolean internalRegisterTokenResolver(Map<String,ITokenResolver> resolverMap, 
			String key,
			ITokenResolver resolver) {
		if(!resolverMap.containsKey(key)){
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
}
