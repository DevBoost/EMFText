package org.emftext.sdk.codegen.resource;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.parameters.AbstractArtifactParameter;

public class ReferenceResolverParameters extends AbstractArtifactParameter<GenerationContext, ReferenceResolverParameters> {

	private GenFeature reference;

	public ReferenceResolverParameters(GenFeature reference) {
		super(TextResourceArtifacts.REFERENCE_RESOLVER);
		this.reference = reference;
	}

	public GenFeature getReference() {
		return reference;
	}
}
