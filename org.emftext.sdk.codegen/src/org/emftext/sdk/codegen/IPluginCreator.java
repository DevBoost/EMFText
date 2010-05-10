package org.emftext.sdk.codegen;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.emftext.sdk.IPluginDescriptor;

/**
 * A IPluginCreator creates a complete plug-in.
 *
 * @param <ContextType>
 * @param <ParameterType>
 */
public interface IPluginCreator<ContextType, ParameterType> {
	
	public void create(IPluginDescriptor plugin, ContextType context, ParameterType parameters, IProgressMonitor monitor) throws IOException;
}
