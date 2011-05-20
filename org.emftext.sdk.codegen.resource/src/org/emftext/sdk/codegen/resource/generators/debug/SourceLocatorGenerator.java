package org.emftext.sdk.codegen.resource.generators.debug;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ABSTRACT_SOURCE_LOOKUP_DIRECTOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_SOURCE_LOOKUP_PARTICIPANT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class SourceLocatorGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_SOURCE_LOOKUP_DIRECTOR + " {");
		sc.addLineBreak();
		addInitializeParticipantsMethod(sc);
		sc.add("}");
	}

	private void addInitializeParticipantsMethod(JavaComposite sc) {
		sc.add("public void initializeParticipants() {");
		sc.add("addParticipants(new " + I_SOURCE_LOOKUP_PARTICIPANT + "[]{new " + sourceLookupParticipantClassName + "()});");
		sc.add("}");
		sc.addLineBreak();
	}
}
