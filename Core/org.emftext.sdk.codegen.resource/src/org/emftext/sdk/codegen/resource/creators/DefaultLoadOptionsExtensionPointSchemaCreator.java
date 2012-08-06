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
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.creators.IArtifact;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.DefaultLoadOptionsExtensionPointSchemaGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A creator for the schema of the default_load_options extension point.
 */
public class DefaultLoadOptionsExtensionPointSchemaCreator extends TextResourceArtifactCreator<ArtifactParameter<GenerationContext>> {

	public static final String FILENAME = "default_load_options.exsd";

	public DefaultLoadOptionsExtensionPointSchemaCreator() {
		super(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.DEFAULT_LOAD_OPTIONS_EXSD));
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, ArtifactParameter<GenerationContext> parameters) {
		
		File schemaFolder = context.getSchemaFolder(context.getResourcePlugin());
		File pluginXMLFile = new File(schemaFolder.getAbsolutePath() + File.separator + FILENAME);
		IGenerator<GenerationContext, ArtifactParameter<GenerationContext>> generator = new DefaultLoadOptionsExtensionPointSchemaGenerator();

	    return createArtifact(
	    		context,
	    		parameters,
	    		generator,
	    		pluginXMLFile,
	    		"Exception while generating default_load_options.exsd file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA;
	}
}
