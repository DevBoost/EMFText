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

import org.eclipse.core.runtime.Platform;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.CsResource;

/**
 * An analyser that checks whether the analysis package in generated
 * text resource plug-ins contains unused resolver classes. This 
 * analyser us disabled if no OSGi platform is running, because it
 * depends on knowledge about the current workspace. 
 */
public class UnusedResolverAnalyser extends AbstractPostProcessor {
	
	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		// this analyser does only work when the platform is running, because
		// it needs the workspace to determine the folder the text resource 
		// is generated to
		if (!Platform.isRunning()) {
			return;
		}
		// TODO mseifert: activate this code
		/*
		Collection<String> resolverFileNames = csUtil.getResolverFileNames(syntax);
		String workspaceRootFolder = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		
		String pluginProjectFolder = workspaceRootFolder + File.separator + nameUtil.getPluginName(syntax);
		
		File resolverPackageFolder = pathUtil.getResolverPackageFile(syntax, pluginProjectFolder);
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
		*/
	}
}
