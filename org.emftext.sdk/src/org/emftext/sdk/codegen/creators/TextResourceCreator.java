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

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.TextResourceGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the Java file for the text resource class using the content
 * provided by TextResourceGenerator.
 */
public class TextResourceCreator extends AbstractArtifactCreator {

	public TextResourceCreator() {
		super("text resource");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
	    File resourceFile = context.getTextResourceFile();
		IGenerator generator = new TextResourceGenerator(context);
		
		Artifact artifact = new Artifact(resourceFile, invokeGeneration(generator, context.getProblemCollector()));
		return toList(artifact);
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_TEXT_RESOURCE;
	}
}
