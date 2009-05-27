/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.DotClasspathGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates a .classpath file, which is used by Eclipse to determine the
 * classes used by generated text resource plug-ins.
 */
public class DotClasspathCreator extends AbstractArtifactCreator {

	public DotClasspathCreator() {
		super(".classpath file");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File dotClasspathFile = new File(context.getPluginProjectFolder().getAbsolutePath() + File.separator + ".classpath");

		DotClasspathGenerator dotClasspathGenerator = new DotClasspathGenerator(context);
		
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>(1);
		artifacts.add(new Artifact(dotClasspathFile, invokeGeneration(dotClasspathGenerator, context.getProblemCollector())));
		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DOT_CLASSPATH;
	}
}
