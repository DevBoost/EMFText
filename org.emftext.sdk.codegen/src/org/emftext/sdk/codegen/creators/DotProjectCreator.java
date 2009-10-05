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
		// TODO this is wrong! if plugin==ANTRL_PLUGIN we must always override!
		return OptionTypes.OVERRIDE_DOT_PROJECT;
	}
}
