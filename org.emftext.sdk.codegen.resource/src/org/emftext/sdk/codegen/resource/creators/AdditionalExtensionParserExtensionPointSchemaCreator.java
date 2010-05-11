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
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.AdditionalExtensionParserExtensionPointSchemaGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A creator for the schema of the additional_extension_parser extension point.
 */
public class AdditionalExtensionParserExtensionPointSchemaCreator extends TextResourceArtifactCreator<Object> {

	private static final String ADDITIONAL_EXTENSION_PARSER_EXSD = "additional_extension_parser.exsd";

	public AdditionalExtensionParserExtensionPointSchemaCreator() {
		super(TextResourceArtifacts.ADDITIONAL_EXTENSION_PARSER_EXSD, null);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, Object parameters) {
		
		File schemaFolder = context.getSchemaFolder(context.getResourcePlugin());
		File file = new File(schemaFolder.getAbsolutePath() + File.separator + ADDITIONAL_EXTENSION_PARSER_EXSD);
		IGenerator<GenerationContext, Object> generator = new AdditionalExtensionParserExtensionPointSchemaGenerator(context);

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
