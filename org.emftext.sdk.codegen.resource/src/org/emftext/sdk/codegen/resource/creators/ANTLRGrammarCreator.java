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
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.mopp.ANTLRGrammarGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * Creates an ANTLR .g file using the ANTLRGrammarGenerator, which
 * creates the content for the file.
 */
public class ANTLRGrammarCreator extends TextResourceArtifactCreator<Object> {

	public ANTLRGrammarCreator(ICodeGenerationComponent parent) {
		super(parent, TextResourceArtifacts.ANTLR_GRAMMAR, null);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, Object paramters) {
		
	    File antlrFile = context.getANTLRGrammarFile(context.getResourcePlugin());
	    return createArtifact(
	    		context,
	    		ANTLRGrammarGenerator.PROVIDER.newInstance(this, context, paramters),
	    		antlrFile,
	    		"Exception while generating ANTLR grammar."
	    );
	}

	@Override
	public void notifyArtifactChanged(GenerationContext context) {
		super.notifyArtifactChanged(context);
		context.setANTLRGrammarHasChanged();
	}

	@Override
	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PARSER;
	}
}
