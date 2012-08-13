/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.generators.DotProjectGenerator;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;

/**
 * Creates a .project file, which is used by Eclipse to read meta data
 * about plug-ins.
 */
public class DotProjectCreator<ContextType extends IContext<ContextType>> extends GenericArtifactCreator<ContextType, DotProjectParameters<ContextType>> {

	public static final String FILENAME = ".project";
	
	private final boolean override;

	public DotProjectCreator(DotProjectParameters<ContextType> parameters, boolean override) {
		super(parameters);
		this.override = override;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ContextType context, DotProjectParameters<ContextType> parameters) {
		File dotProjectFile = new File(context.getFileSystemConnector().getProjectFolder(parameters.getPlugin()).getAbsolutePath() + File.separator + FILENAME);
		
	    return createArtifact(
	    		context,
	    		parameters,
	    		new DotProjectGenerator<ContextType>(),
	    		dotProjectFile,
	    		"Exception while generating " + FILENAME + " file."
	    );
	}

	@Override
	public boolean doOverride(ContextType context) {
		return override;
	}
}
