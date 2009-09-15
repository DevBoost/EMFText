package org.emftext.sdk.codegen.creators.ui;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.creators.AbstractArtifactCreator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.generators.ui.BrowserInformationControlGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class BrowserInformationControlCreator extends AbstractArtifactCreator {

	private static final String NAME = "BrowserInformationControl";

	public BrowserInformationControlCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {

		File file = context.getFile(EArtifact.BROWER_INFORMATION_CONTROL);
		IGenerator generator = new BrowserInformationControlGenerator(context);

		return createArtifact(context, generator, file,
				"Exception while generating " + NAME + ".");
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_BROWSER_INFORMATION_CONTROL;
	}
}
