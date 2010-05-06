package org.emftext.sdk.codegen;

import java.io.File;

public interface IGenerationContext<ContextType> {

	public IProblemCollector getProblemCollector();
	public File getFile(ArtifactDescriptor<ContextType> artifact);
}
