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
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.DotClasspathGenerator;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;

/**
 * Creates a .classpath file, which is used by Eclipse to determine the
 * classes used by generated text resource plug-ins.
 */
public class DotClasspathCreator<ContextType extends IContext> extends GenericArtifactCreator<ContextType, ClassPathParameters> {

	public static final String FILENAME = ".classpath";

	private final boolean override;

	public DotClasspathCreator(ArtifactDescriptor<ContextType, ClassPathParameters> artifact, ClassPathParameters parameters, boolean override) {
		super(artifact, parameters);
		this.override = override;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, ContextType context, ClassPathParameters parameters) {
		
		File dotClasspathFile = new File(getFileSystemConnector().getProjectFolder(parameters.getPlugin()).getAbsolutePath() + File.separator + FILENAME);

		IGenerator<ContextType, ClassPathParameters> dotClasspathGenerator = new DotClasspathGenerator<ContextType>(context, parameters);
		
	    return createArtifact(
	    		context,
	    		dotClasspathGenerator,
	    		dotClasspathFile,
	    		"Exception while generating " + FILENAME + " file."
	    );
	}

	@Override
	public boolean doOverride(ContextType context) {
		return override;
	}
}
