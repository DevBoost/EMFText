package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.ReferenceResolverGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ReferenceResolversCreator extends AbstractArtifactCreator {

	public ReferenceResolversCreator() {
		super("reference resolvers");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>();
		
		for (GenFeature proxyReference : context.getNonContainmentReferences()) {
			// do not generate resolvers for references in imported rules with 
			// a syntax defined elsewhere
			final boolean isImportedReference = context.isImportedWithSyntaxReference(proxyReference);
			if (isImportedReference) {
				continue;
			}
			File resolverFile = context.getResolverFile(proxyReference);
			IGenerator generator = new ReferenceResolverGenerator(context, proxyReference);
			Artifact artifact = new Artifact(resolverFile, invokeGeneration(generator, context.getProblemCollector()));
			artifacts.add(artifact);
		}
		
		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_REFERENCE_RESOLVERS;
	}
}
