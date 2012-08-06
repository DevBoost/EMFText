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
package org.emftext.sdk.codegen.antlr;

import static org.emftext.sdk.codegen.antlr.Constants.ANTLR_RUNTIME_DEBUG_PACKAGE;
import static org.emftext.sdk.codegen.antlr.Constants.ANTLR_RUNTIME_MISC_PACKAGE;
import static org.emftext.sdk.codegen.antlr.Constants.ANTLR_RUNTIME_PACKAGE;
import static org.emftext.sdk.codegen.antlr.Constants.ANTLR_RUNTIME_TREE_PACKAGE;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.ManifestCreator;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;
import org.emftext.sdk.codegen.parameters.ManifestParameters;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * This class holds constants for all artifacts that are created for the
 * org.emfext.commons.antlr_version plug-in.
 */
public class ANTLRPluginArtifacts {

	public final static ArtifactDescriptor<ANTLRGenerationContext, BuildPropertiesParameters<ANTLRGenerationContext>> BUILD_PROPERTIES = new ArtifactDescriptor<ANTLRGenerationContext, BuildPropertiesParameters<ANTLRGenerationContext>>(null, BuildPropertiesCreator.FILENAME, "", null, OptionTypes.OVERRIDE_BUILD_PROPERTIES); 
	public final static ArtifactDescriptor<ANTLRGenerationContext, ClassPathParameters<ANTLRGenerationContext>> DOT_CLASSPATH = new ArtifactDescriptor<ANTLRGenerationContext, ClassPathParameters<ANTLRGenerationContext>>(null, DotClasspathCreator.FILENAME, "", null, OptionTypes.OVERRIDE_DOT_CLASSPATH);
	public final static ArtifactDescriptor<ANTLRGenerationContext, DotProjectParameters<ANTLRGenerationContext>> DOT_PROJECT = new ArtifactDescriptor<ANTLRGenerationContext, DotProjectParameters<ANTLRGenerationContext>>(null, DotProjectCreator.FILENAME, "", null, OptionTypes.OVERRIDE_DOT_PROJECT);
	public final static ArtifactDescriptor<ANTLRGenerationContext, ManifestParameters<ANTLRGenerationContext>> MANIFEST = new ArtifactDescriptor<ANTLRGenerationContext, ManifestParameters<ANTLRGenerationContext>>(null, ManifestCreator.FILENAME, "", null, OptionTypes.OVERRIDE_MANIFEST);

	public final static ArtifactDescriptor<ANTLRGenerationContext, Object> PACKAGE_ANTLR_RUNTIME = new ArtifactDescriptor<ANTLRGenerationContext, Object>(ANTLR_RUNTIME_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<ANTLRGenerationContext, Object> PACKAGE_ANTLR_RUNTIME_DEBUG = new ArtifactDescriptor<ANTLRGenerationContext, Object>(ANTLR_RUNTIME_DEBUG_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<ANTLRGenerationContext, Object> PACKAGE_ANTLR_RUNTIME_MISC = new ArtifactDescriptor<ANTLRGenerationContext, Object>(ANTLR_RUNTIME_MISC_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<ANTLRGenerationContext, Object> PACKAGE_ANTLR_RUNTIME_TREE = new ArtifactDescriptor<ANTLRGenerationContext, Object>(ANTLR_RUNTIME_TREE_PACKAGE, "", "", null, null); 
}
