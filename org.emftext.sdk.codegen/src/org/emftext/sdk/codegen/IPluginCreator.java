/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
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
