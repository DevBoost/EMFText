package org.emftext.runtime.resource;

/**
 * A TokenResolverFactory create TokenResolvers for a given token name. 
 * They may be implemented like a registry.
 * 
 * 
 * @author skarol
 *
 */

public interface TokenResolverFactory {
	
	public TokenResolver createTokenResolver(String tokenName);
	
}
