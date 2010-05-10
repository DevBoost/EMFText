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

import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.mopp.BabylonSpecificationGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * An experimental (not yet implemented) creator for the Babylon compiler
 * framework.
 */
public class BabylonSpecificationCreator extends TextResourceArtifactCreator<Object> {

	public BabylonSpecificationCreator() {
		super(TextResourceArtifacts.BABYLON_SPECIFICATION, null);
	}

	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context, Object parameters) {
		
		String specificationName = context.getCapitalizedConcreteSyntaxName();
		String packagePath = context.getPackagePath(context.getResourcePlugin(), TextResourceArtifacts.BABYLON_SPECIFICATION);
  		File specificationFile = new File(packagePath + specificationName + ".babylon");
		
	    return createArtifact(
	    		context,
	    		new BabylonSpecificationGenerator().newInstance(context, parameters),
	    		specificationFile,
	    		"Exception while generating Babylon specification."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PARSER;
	}
}
