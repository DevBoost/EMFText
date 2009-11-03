package org.emftext.sdk.concretesyntax.resource.cs;

// A TokenResolverFactory creates TokenResolvers for a given token name.
// They may be implemented like a registry.
public interface ICsTokenResolverFactory {
	
	// Creates a token resolver for normal tokens of type 'tokenName'.
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver createTokenResolver(String tokenName);
	
	// Creates a token resolver for COLLECT-IN tokens that are stores in
	// feature 'featureName'.
	public org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver createCollectInTokenResolver(String featureName);
}
