/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.codegen.sdf.creators;

import java.io.File;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.creators.AbstractArtifactCreator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * An experimental (not yet complete) creator for the SGLR compiler
 * framework.
 */
public class SGLRGrammarCreator extends AbstractArtifactCreator {

	public SGLRGrammarCreator() {
		super("SGLR grammar");
		// TODO extend ManifestGenerator with import below
		// imports.add("org.emftext.commons.jsglr");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		File sglrFile = context.getSGLRGrammarFile();
	    return createArtifact(
	    		context,
	    		null,//new org.emftext.sdk.codegen.sdf.SGLRGrammarGenerator(context),
	    		sglrFile,
	    		"Exception while generating SGLR grammar."
	    );
	}

	@Override
	public OptionTypes getOverrideOption() {
		return null;
	}
}
