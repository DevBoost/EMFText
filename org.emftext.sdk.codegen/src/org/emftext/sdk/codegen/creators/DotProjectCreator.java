/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.generators.DotProjectGenerator;

/**
 * Creates a .project file, which is used by Eclipse to read meta data
 * about plug-ins.
 */
public class DotProjectCreator<ContextType extends IContext> extends GenericArtifactCreator<ContextType, IPluginDescriptor> {

	public static final String FILENAME = ".project";
	
	private final boolean override;

	public DotProjectCreator(ArtifactDescriptor<ContextType, IPluginDescriptor> artifact, IPluginDescriptor plugin, boolean override) {
		super(artifact, plugin);
		this.override = override;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ContextType context, IPluginDescriptor parameters) {
		File dotProjectFile = new File(getFileSystemConnector().getProjectFolder(parameters).getAbsolutePath() + File.separator + FILENAME);
		
	    return createArtifact(
	    		context,
	    		new DotProjectGenerator<ContextType>(context, parameters),
	    		dotProjectFile,
	    		"Exception while generating " + FILENAME + " file."
	    );
	}

	@Override
	public boolean doOverride(ContextType context) {
		return override;
	}
}
