/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_analysis;

import java.io.File;
import java.util.Collection;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.Constants;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.OptionManager;
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
		
		String pluginProjectFolder = workspaceRootFolder + File.separator + EPlugins.RESOURCE_PLUGIN.getName(syntax);
		
		OptionTypes overrideOption = OptionTypes.OVERRIDE_REFERENCE_RESOLVERS;
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(syntax, overrideOption);
		File resolverPackageFolder = csUtil.getResolverPackageFile(syntax, doOverride, pluginProjectFolder);
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
