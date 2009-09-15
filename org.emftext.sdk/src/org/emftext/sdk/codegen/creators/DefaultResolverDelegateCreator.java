package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.DefaultResolverDelegateGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DefaultResolverDelegateCreator extends AbstractArtifactCreator {

	private static final String DEFAULT_RESOLVER_DELEGATE = "default resolver delegate";

	public DefaultResolverDelegateCreator() {
		super(DEFAULT_RESOLVER_DELEGATE);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
	    File resourceFile = context.getFile(EArtifact.DEFAULT_RESOLVER_DELEGATE);
		IGenerator generator = new DefaultResolverDelegateGenerator(context);
		
		return createArtifact(
	    		context,
	    		generator,
	    		resourceFile,
	    		"Exception while generating " + DEFAULT_RESOLVER_DELEGATE + " class."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE;
	}
}
