package org.emftext.sdk.codegen;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;

public interface ICreator<GenerationContextType> {

	public void generate(GenerationContextType context, IProgressMonitor monitor) throws IOException;
}
