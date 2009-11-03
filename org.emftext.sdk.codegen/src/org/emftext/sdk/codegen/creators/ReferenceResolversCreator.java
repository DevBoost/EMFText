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
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.ReferenceResolverGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates the Java files for all reference resolvers using the content
 * provided by ReferenceResolverGenerator. A reference resolver is generated
 * for each non-containment reference in the CS specification that is not
 * imported.
 */
public class ReferenceResolversCreator extends AbstractArtifactCreator {

	public ReferenceResolversCreator() {
		super("reference resolvers");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		Collection<IArtifact> artifacts = new ArrayList<IArtifact>();
		
		for (GenFeature proxyReference : context.getNonContainmentReferences()) {
			File resolverFile = context.getResolverFile(proxyReference);
			ReferenceResolverGenerator generator = (ReferenceResolverGenerator) new ReferenceResolverGenerator().newInstance(context);
			generator.setProxyReference(proxyReference);
			
			artifacts.addAll(createArtifact(
		    		context,
		    		generator,
		    		resolverFile,
		    		"Exception while generating reference resolver."
		    ));
		}
		
		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_REFERENCE_RESOLVERS;
	}
}
