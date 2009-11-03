/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.DotProjectGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates a .project file, which is used by Eclipse to read meta data
 * about plug-ins.
 */
public class DotProjectCreator extends AbstractArtifactCreator {

	private EPlugins plugin;

	public DotProjectCreator(EPlugins plugin) {
		super(".project file");
		this.plugin = plugin;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		File dotProjectFile = new File(context.getProjectFolder(plugin).getAbsolutePath() + File.separator + ".project");
		
	    return createArtifact(
	    		context,
	    		new DotProjectGenerator(context, plugin),
	    		dotProjectFile,
	    		"Exception while generating .project file."
	    );
	}

	public OptionTypes getOverrideOption() {
		if (plugin == EPlugins.RESOURCE_PLUGIN) {
			return OptionTypes.OVERRIDE_DOT_PROJECT;
		} else {
			return OptionTypes.OVERRIDE_ANTLR_PLUGIN;
		}
	}
}
