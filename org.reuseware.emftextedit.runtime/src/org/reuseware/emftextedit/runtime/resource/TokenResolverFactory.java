package org.reuseware.emftextedit.runtime.resource;

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
