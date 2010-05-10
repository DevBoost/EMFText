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
import org.emftext.sdk.codegen.resource.generators.DefaultLoadOptionsExtensionPointSchemaGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DefaultLoadOptionsExtensionPointSchemaCreator extends TextResourceArtifactCreator<Object> {

	private static final String DEFAULT_LOAD_OPTIONS_EXSD = "default_load_options.exsd";

	public DefaultLoadOptionsExtensionPointSchemaCreator() {
		super(TextResourceArtifacts.DEFAULT_LOAD_OPTIONS_EXSD, null);
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(IPluginDescriptor plugin, GenerationContext context, Object parameter) {
		
		File schemaFolder = context.getSchemaFolder(context.getResourcePlugin());
		File pluginXMLFile = new File(schemaFolder.getAbsolutePath() + File.separator + DEFAULT_LOAD_OPTIONS_EXSD);
		IGenerator<GenerationContext, Object> generator = new DefaultLoadOptionsExtensionPointSchemaGenerator(context);

	    return createArtifact(
	    		context,
	    		generator,
	    		pluginXMLFile,
	    		"Exception while generating default_load_options.exsd file."
	    );
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA;
	}
}
