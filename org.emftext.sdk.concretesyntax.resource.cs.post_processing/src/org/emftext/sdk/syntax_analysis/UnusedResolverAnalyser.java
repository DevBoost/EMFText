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
package org.emftext.sdk.syntax_analysis;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.Constants;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that checks whether the analysis package in generated
 * text resource plug-ins contains unused resolver classes. This 
 * analyser us disabled if no OSGi platform is running, because it
 * depends on knowledge about the current workspace. 
 */
public class UnusedResolverAnalyser extends AbstractPostProcessor {
	
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private GeneratorUtil genUtil = new GeneratorUtil();

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		// this analyser does only work when the platform is running, because
		// it needs the workspace to determine the folder the text resource 
		// is generated to
		if (!Platform.isRunning()) {
			return;
		}
		Collection<String> resolverFileNames = csUtil.getResolverFileNames(syntax);
		String workspaceRootFolder = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		
		String pluginProjectFolder = workspaceRootFolder + File.separator + genUtil.getResourcePluginDescriptor(syntax).getName();
		
		OptionTypes overrideOption = OptionTypes.OVERRIDE_REFERENCE_RESOLVERS;
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(syntax, overrideOption);
		File resolverPackageFolder = genUtil.getResolverPackageFile(syntax, doOverride, pluginProjectFolder);
		if (!resolverPackageFolder.exists()) {
			return;
		}
		File[] contents = resolverPackageFolder.listFiles();
		for (File member : contents) {
			if (!member.isDirectory()) {
				String fileName = member.getName();
				boolean isDefaultResolver = (csUtil.getDefaultResolverDelegateName(syntax) + Constants.JAVA_FILE_EXTENSION).equals(fileName);
				if (!resolverFileNames.contains(fileName) &&!isDefaultResolver) {
					// issue warning about unused resolver
					final CsResource textResource = (CsResource) syntax.eResource();
					addProblem(textResource, ECsProblemType.UNUSED_RESOLVER_CLASS, "Found unused class '" + fileName + "' in analysis package.", null);
				}
			}
		}
	}
}
