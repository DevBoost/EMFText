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
package org.emftext.sdk.codegen.resource.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.EmptyClassGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class EmptyClassCreator extends GenericArtifactCreator<GenerationContext, Object> {

	private File file;
	private String className;
	private OptionTypes overrideOption;
	private ArtifactDescriptor<GenerationContext, Object> targetPackage;

	public EmptyClassCreator(File file, ArtifactDescriptor<GenerationContext, Object> targetPackage, String className, OptionTypes overrideOption) {
		super(new ArtifactDescriptor<GenerationContext, Object>(null, "empty " + className, "", null, null), null);
		this.file = file;
		this.className = className;
		this.targetPackage = targetPackage;
		this.overrideOption = overrideOption;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, Object parameters) {
		
		EmptyClassGenerator generator = (EmptyClassGenerator) new EmptyClassGenerator().newInstance(context, parameters);
		// TODO mseifert: put this into the parameter object
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

	@Override
	public boolean doOverride(GenerationContext context) {
		return true;
	}
}
