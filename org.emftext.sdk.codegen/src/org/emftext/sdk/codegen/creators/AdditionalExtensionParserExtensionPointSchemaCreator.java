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

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.AdditionalExtensionParserExtensionPointSchemaGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class AdditionalExtensionParserExtensionPointSchemaCreator extends AbstractArtifactCreator {

	public AdditionalExtensionParserExtensionPointSchemaCreator() {
		super("additional_extension_parser.exsd");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File file = new File(context.getSchemaFolder().getAbsolutePath() + File.separator + "additional_extension_parser.exsd");
		IGenerator<GenerationContext> generator = new AdditionalExtensionParserExtensionPointSchemaGenerator(context);

	    return createArtifact(
	    		context,
	    		generator,
	    		file,
	    		"Exception while generating default_load_options.exsd file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA;
	}
}
