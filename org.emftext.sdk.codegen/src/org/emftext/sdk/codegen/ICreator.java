package org.emftext.sdk.codegen;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.emftext.sdk.IPluginDescriptor;

public interface ICreator<ContextType, ParameterType> {
	// TODO mseifert: rename to create()
	public void generate(IPluginDescriptor plugin, ContextType context, ParameterType parameters, IProgressMonitor monitor) throws IOException;
}
