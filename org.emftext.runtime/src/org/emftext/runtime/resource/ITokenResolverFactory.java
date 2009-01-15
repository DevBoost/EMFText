package org.emftext.runtime.resource;

/**
 * A TokenResolverFactory create TokenResolvers for a given token name. 
 * They may be implemented like a registry.
 * 
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 *
 */

public interface ITokenResolverFactory {
	
	public ITokenResolver createTokenResolver(String tokenName);
	
}
