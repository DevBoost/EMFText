package org.emftext.sdk.concretesyntax.resource.cs;

import java.util.HashMap;
import java.util.Map;

import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class CsTokenResolverFactory extends org.emftext.runtime.resource.impl.AbstractTokenResolverFactory implements org.emftext.runtime.resource.ITokenResolverFactory {
	
	private Map<String,ITokenResolver> tokenName2TokenResolver;
	private Map<String,ITokenResolver> featureName2CollectInTokenResolver;
	private static ITokenResolver defaultResolver = new JavaBasedTokenResolver();
	
	public CsTokenResolverFactory() {
		tokenName2TokenResolver = new HashMap<String,ITokenResolver>();
		featureName2CollectInTokenResolver = new HashMap<String,ITokenResolver>();
		registerTokenResolver("QUALIFIED_NAME", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUALIFIED_NAMETokenResolver());
		registerTokenResolver("NUMBER", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsNUMBERTokenResolver());
		registerTokenResolver("HEXNUMBER", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsHEXNUMBERTokenResolver());
		registerTokenResolver("QUOTED_60_62", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_34_34TokenResolver());
		registerTokenResolver("QUOTED_39_39", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_39_39TokenResolver());
		registerTokenResolver("QUOTED_36_36", new org.emftext.sdk.concretesyntax.resource.cs.analysis.CsQUOTED_36_36TokenResolver());
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
