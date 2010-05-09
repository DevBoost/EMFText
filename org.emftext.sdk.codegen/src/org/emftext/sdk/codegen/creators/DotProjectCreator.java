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
import org.emftext.sdk.codegen.IGenerationContext;
import org.emftext.sdk.codegen.TextResourcePlugins;
import org.emftext.sdk.codegen.generators.DotProjectGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates a .project file, which is used by Eclipse to read meta data
 * about plug-ins.
 */
public class DotProjectCreator<ContextType extends IGenerationContext<ContextType>> extends GenericArtifactCreator<ContextType, IPluginDescriptor<ContextType>> {

	public DotProjectCreator(IPluginDescriptor<ContextType> plugin) {
		super(".project file", plugin);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(ContextType context, IPluginDescriptor<ContextType> parameters) {
		File dotProjectFile = new File(context.getProjectFolder(parameters).getAbsolutePath() + File.separator + ".project");
		
	    return createArtifact(
	    		context,
	    		new DotProjectGenerator<ContextType>(context, parameters),
	    		dotProjectFile,
	    		"Exception while generating .project file."
	    );
	}

	@Override
	public OptionTypes getOverrideOption() {
		if (parameters == TextResourcePlugins.RESOURCE_PLUGIN) {
			return OptionTypes.OVERRIDE_DOT_PROJECT;
		} else {
			return OptionTypes.OVERRIDE_ANTLR_PLUGIN;
		}
	}
}
