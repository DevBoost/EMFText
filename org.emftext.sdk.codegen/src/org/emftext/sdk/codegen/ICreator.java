package org.emftext.sdk.codegen;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;

public interface ICreator<ContextType, ParameterType> {
	// TODO mseifert: rename to create()
	public void generate(ContextType context, ParameterType parameters, IProgressMonitor monitor) throws IOException;
}
