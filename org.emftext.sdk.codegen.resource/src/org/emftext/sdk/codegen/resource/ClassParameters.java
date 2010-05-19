package org.emftext.sdk.codegen.resource;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.resource.generators.EmptyClassGenerator;

public class ClassParameters implements IArtifactParameter<GenerationContext, ClassParameters> {

	private String className;
	private ArtifactDescriptor<GenerationContext, ?> targetPackage;
	
	public ClassParameters(
			String className,
			ArtifactDescriptor<GenerationContext, ?> targetPackage) {
		super();
		this.className = className;
		this.targetPackage = targetPackage;
	}

	public String getClassName() {
		return className;
	}

	public ArtifactDescriptor<GenerationContext, ?> getTargetPackage() {
		return targetPackage;
	}

	public ArtifactDescriptor<GenerationContext, ClassParameters> getArtifact() {
		return new ArtifactDescriptor<GenerationContext, ClassParameters>(null, "empty", "", EmptyClassGenerator.class, null);
	}
}
