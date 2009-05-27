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

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
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
			// do not generate resolvers for references in imported rules with 
			// a syntax defined elsewhere
			final boolean isImportedReference = context.isImportedWithSyntaxReference(proxyReference);
			if (isImportedReference) {
				continue;
			}
			File resolverFile = context.getResolverFile(proxyReference);
			IGenerator generator = new ReferenceResolverGenerator(context, proxyReference);
			Artifact artifact = new Artifact(resolverFile, invokeGeneration(generator, context.getProblemCollector()));
			artifacts.add(artifact);
		}
		
		return artifacts;
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_REFERENCE_RESOLVERS;
	}
}
