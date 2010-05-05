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
import org.emftext.sdk.codegen.generators.DefaultLoadOptionsExtensionPointSchemaGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class DefaultLoadOptionsExtensionPointSchemaCreator extends AbstractArtifactCreator {

	public DefaultLoadOptionsExtensionPointSchemaCreator() {
		super("default_load_options.exsd");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		File pluginXMLFile = new File(context.getSchemaFolder().getAbsolutePath() + File.separator + "default_load_options.exsd");
		IGenerator<GenerationContext> generator = new DefaultLoadOptionsExtensionPointSchemaGenerator(context);

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
