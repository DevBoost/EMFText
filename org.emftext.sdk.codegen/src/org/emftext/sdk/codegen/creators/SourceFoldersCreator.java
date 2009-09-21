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

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the folders 'src' and 'src-gen' for generated text resource plug-ins.
 * The names of this folders may vary depending on the values set for
 * options OptionTypes.SOURCE_FOLDER and OptionTypes.SOURCE_GEN_FOLDER.
 * 
 * @see org.emftext.sdk.concretesyntax.OptionTypes
 */
public class SourceFoldersCreator implements IArtifactCreator {

	public void createArtifacts(GenerationContext context) {
		createIfNeeded(context.getSourceFolder(false));
		createIfNeeded(context.getSourceFolder(true));
	}

	private void createIfNeeded(File targetFolder) {
		if (!targetFolder.exists()) {
		   	targetFolder.mkdir();
		}
	}

	public OptionTypes getOverrideOption() {
		// there is not option to prevent the creation of the source folder
		return null;
	}

	public String getArtifactDescription() {
		return "source folder";
	}
}
