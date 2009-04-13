package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.generators.ReferenceResolverSwitchGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ReferenceResolverSwitchCreator extends AbstractArtifactCreator {

	public ReferenceResolverSwitchCreator() {
		super("reference resolver switch");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
	    File referenceResolverSwitchFile = context.getReferenceResolverSwitchFile();

		BaseGenerator analyserGen = new ReferenceResolverSwitchGenerator(context);
		Artifact artifact = new Artifact(referenceResolverSwitchFile,invokeGeneration(analyserGen, context.getProblemCollector()));
	    return toList(artifact);
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH;
	}
}
