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
package org.emftext.sdk.codegen.util;

import static org.emftext.runtime.util.StringUtil.capitalize;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * A utility class that can be used to derive names for different artifacts
 * created by EMFText.
 */
public class NameUtil {

	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	public String getPluginName(ConcreteSyntax syntax) {
		String resourcePluginID = OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.RESOURCE_PLUGIN_ID);
		if (resourcePluginID != null) {
			// use package plug-in from option
			return resourcePluginID;
		} else {
			// use default plug-in name
			return getPackageName(syntax, EArtifact.MAIN_PACKAGE);
		}
	}

	public String getPackageName(ConcreteSyntax syntax, EArtifact artifact) {
		String packageName = "";
		String basePackage = OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.BASE_PACKAGE);
		if (basePackage != null) {
			// use package name from option
			packageName = basePackage;
		} else {
			// use default package name
			GenPackage concreteSyntaxPackage = syntax.getPackage();
			boolean hasBasePackage = concreteSyntaxPackage.getBasePackage() != null;
			if (hasBasePackage) {
				packageName = concreteSyntaxPackage.getBasePackage() + ".";
			}
			packageName += concreteSyntaxPackage.getEcorePackage().getName();
			packageName += ".resource." + syntax.getName();
		}
		packageName += ("".equals(artifact.getPackage()) ? "" : "." + artifact.getPackage());
		return packageName;
	}

	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to depending on the given syntax.
	 */
	public String getResolverPackageName(ConcreteSyntax syntax) {
		String csPackageName = getPackageName(syntax, EArtifact.ANALYSIS_PACKAGE);
		return (csPackageName == null || csPackageName.equals("") ? "" : csPackageName);
	}

	public String getReferenceResolverClassName(GenFeature proxyReference) {
		return proxyReference.getGenClass().getName() + capitalize(proxyReference.getName()) + GenerationContext.CLASS_SUFFIX_REFERENCE_RESOLVER;
	}

	public String getCapitalizedConcreteSyntaxName(ConcreteSyntax syntax) {
		String csName = "";
		String[] csNameParts = syntax.getName().split("\\.");
		for(String part : csNameParts) {
			csName = csName + capitalize(part);
		}
		return csName;
	}
	
	public String getTokenResolverClassName(ConcreteSyntax syntax, TokenDefinition tokenDefinition) {

		String syntaxName = getCapitalizedConcreteSyntaxName(csUtil.getContainingSyntax(syntax, tokenDefinition));
		boolean isCollect = tokenDefinition.getAttributeName() != null;
		if (isCollect) {
			String attributeName = tokenDefinition.getAttributeName();
			return syntaxName +  "COLLECT_" + attributeName + GenerationContext.CLASS_SUFFIX_TOKEN_RESOLVER;
		} else {
			return syntaxName +  tokenDefinition.getName() + GenerationContext.CLASS_SUFFIX_TOKEN_RESOLVER;
		}
	}

	public String getQualifiedTokenResolverClassName(ConcreteSyntax syntax, TokenDefinition definition) {
		return getResolverPackageName(csUtil.getContainingSyntax(syntax, definition)) + "." + getTokenResolverClassName(syntax, definition);
	}

	public String getDefaultResolverDelegateName(ConcreteSyntax syntax) {
		return getCapitalizedConcreteSyntaxName(syntax) + GenerationContext.CLASS_SUFFIX_DEFAULT_RESOLVER_DELEFATE;
	}
}
