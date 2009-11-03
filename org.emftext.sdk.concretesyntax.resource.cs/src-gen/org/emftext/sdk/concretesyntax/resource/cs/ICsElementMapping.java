package org.emftext.sdk.concretesyntax.resource.cs;

// A mapping from an identifier to an EObject.
//
// @param <ReferenceType> the type of the reference this mapping points to.
public interface ICsElementMapping<ReferenceType> extends org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceMapping<ReferenceType> {
	
	// Returns the target object the identifier is mapped to.
	public ReferenceType getTargetElement();
}
