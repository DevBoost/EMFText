package org.emftext.runtime.resource;

/**
 * A TokenResolverFactory creates TokenResolvers for a given token name. 
 * They may be implemented like a registry.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public interface ITokenResolverFactory {

	/**
	 * Creates a token resolver for normal tokens of type 'tokenName'.
	 */
	public ITokenResolver createTokenResolver(String tokenName);

	/**
	 * Creates a token resolver for COLLECT-IN tokens that are stores in 
	 * feature 'featureName'.
	 */
	public ITokenResolver createCollectInTokenResolver(String featureName);
}
