package org.emftext.sdk.codegen.creators.ui;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.creators.AbstractArtifactCreator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.generators.ui.DocBrowserInformationControlInputGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DocBrowserInformationControlInputCreator extends
		AbstractArtifactCreator {

	private static final String NAME = "DocBrowserInformationControlInput";

	public DocBrowserInformationControlInputCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {

		File file = context
				.getFile(EArtifact.DOC_BROWSER_INFORMATION_CONTROL_INPUT);
		IGenerator generator = new DocBrowserInformationControlInputGenerator(
				context);

		return createArtifact(context, generator, file,
				"Exception while generating " + NAME + ".");
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT;
	}
}
