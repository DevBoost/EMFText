/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.resource.ClassParameters;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.EmptyClassGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A creator that produces empty Java classes. This is sometimes used to override
 * existing classes which depend on other generated classes.
 */
public class EmptyClassCreator extends GenericArtifactCreator<GenerationContext, ClassParameters> {

	private File file;
	private OptionTypes overrideOption;

	public EmptyClassCreator(File file, ArtifactDescriptor<GenerationContext, ?> targetPackage, String className, OptionTypes overrideOption) {
		super(new ClassParameters(className, targetPackage));
		this.file = file;
		this.overrideOption = overrideOption;
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, ClassParameters parameters) {
		
		EmptyClassGenerator generator = new EmptyClassGenerator();
	    return createArtifact(
	    		context,
	    		parameters,
	    		generator,
	    		file,
	    		"Exception while generating " + getArtifactTypeDescription() + "."
	    );
	}

	@Override
	public boolean doOverride(GenerationContext context) {
		return OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), overrideOption);
	}
}
