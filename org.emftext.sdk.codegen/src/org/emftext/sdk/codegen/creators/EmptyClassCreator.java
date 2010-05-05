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

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.EmptyClassGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class EmptyClassCreator extends AbstractArtifactCreator {

	private File file;
	private String className;
	private OptionTypes overrideOption;
	private ArtifactDescriptor targetPackage;

	public EmptyClassCreator(File file, ArtifactDescriptor targetPackage, String className, OptionTypes overrideOption) {
		super("empty " + className);
		this.file = file;
		this.className = className;
		this.targetPackage = targetPackage;
		this.overrideOption = overrideOption;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		EmptyClassGenerator generator = (EmptyClassGenerator) new EmptyClassGenerator().newInstance(context);
		generator.setClassName(className);
		generator.setTargetPackage(targetPackage);
		
	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating " + getArtifactDescription() + "."
	    );
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
