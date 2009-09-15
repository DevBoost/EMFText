package org.emftext.sdk.codegen.creators.ui;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.creators.AbstractArtifactCreator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.generators.ui.OutlinePageTreeViewerGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class OutlinePageTreeViewerCreator extends
		AbstractArtifactCreator {

	private static final String NAME = "EMFTextOutlinePageTreeViewer";

	public OutlinePageTreeViewerCreator() {
		super(NAME);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {

		File file = context.getFile(EArtifact.OUTLINE_PAGE_TREE_VIEWER);
		IGenerator generator = new OutlinePageTreeViewerGenerator(
				context);

		return createArtifact(context, generator, file,
				"Exception while generating " + NAME + ".");
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_OUTLINE_PAGE_TREE_VIEWER;
	}
}
