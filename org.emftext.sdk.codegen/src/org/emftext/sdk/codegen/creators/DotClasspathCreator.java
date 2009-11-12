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
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.DotClasspathGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates a .classpath file, which is used by Eclipse to determine the
 * classes used by generated text resource plug-ins.
 */
public class DotClasspathCreator extends AbstractArtifactCreator {

	private EPlugins plugin;

	public DotClasspathCreator(EPlugins plugin) {
		super(".classpath file");
		this.plugin = plugin;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File dotClasspathFile = new File(context.getProjectFolder(plugin).getAbsolutePath() + File.separator + ".classpath");

		IGenerator dotClasspathGenerator = new DotClasspathGenerator(context, plugin);
		
	    return createArtifact(
	    		context,
	    		dotClasspathGenerator,
	    		dotClasspathFile,
	    		"Exception while generating .classpath file."
	    );
	}

	public OptionTypes getOverrideOption() {
		if (plugin == EPlugins.RESOURCE_PLUGIN) {
			return OptionTypes.OVERRIDE_DOT_CLASSPATH;
		} else {
			return OptionTypes.OVERRIDE_ANTLR_PLUGIN;
		}
	}
}
