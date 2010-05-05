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
package org.emftext.sdk.codegen.generators;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;

public class AntlrPluginManifestGenerator extends ManifestGenerator {

	public AntlrPluginManifestGenerator(GenerationContext context) {
		super(context);
	}

	@Override
	protected Collection<String> getExportedPackages(GenerationContext context) {
		Set<String> exports = new LinkedHashSet<String>();
		
		// export the generated packages
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANTLR_RUNTIME));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANTLR_RUNTIME_DEBUG));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANTLR_RUNTIME_MISC));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANTLR_RUNTIME_TREE));
		return exports;
	}

	@Override
	protected Collection<String> getRequiredBundles(GenerationContext context) {
		return Collections.emptyList();
	}

	@Override
	protected EPlugins getPlugin() {
		return EPlugins.ANTLR_PLUGIN;
	}

	@Override
	protected String getActivatorClass(GenerationContext context) {
		return null;
	}

	@Override
	protected String getBundleName(GenerationContext context) {
		return "ANTLR 3.2.0 Runtime Classes";
	}
}
