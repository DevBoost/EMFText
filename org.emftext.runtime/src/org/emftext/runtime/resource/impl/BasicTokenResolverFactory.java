package org.emftext.runtime.resource.impl;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.ITokenResolverFactory;

public class BasicTokenResolverFactory implements ITokenResolverFactory {

	private Map<String,ITokenResolver> tokenName2TokenResolver;
	private static ITokenResolver defaultResolver = new JavaBasedTokenResolver();
	
	public BasicTokenResolverFactory(){
		tokenName2TokenResolver = new HashMap<String,ITokenResolver>();
	}
	
	public ITokenResolver createTokenResolver(String tokenName) {		
		if(tokenName2TokenResolver.containsKey(tokenName)){
			return tokenName2TokenResolver.get(tokenName);
		}
		else{
			return defaultResolver;
		}
	}
	
	protected boolean registerTokenResolver(String tokenName, ITokenResolver resolver){
		if(!tokenName2TokenResolver.containsKey(tokenName)){
			tokenName2TokenResolver.put(tokenName,resolver);
			return true;
		}
		return false;
	}
	
	protected ITokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}

}
