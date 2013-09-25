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
package org.emftext.sdk.codegen.util;

import static org.emftext.sdk.codegen.Constants.ANALYSIS_PACKAGE;
import static org.emftext.sdk.codegen.Constants.RESOURCE_UI_PLUGIN_SUFFIX;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.Constants;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.ISyntaxContext;
import org.emftext.sdk.codegen.PluginDescriptor;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.EObjectUtil;

import de.devboost.codecomposers.util.StringUtil;
import de.devboost.codecomposers.util.ToStringConverter;

/**
 * A utility class that can be used to derive names for different artifacts
 * created by EMFText.
 */
public class NameUtil {

	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	public String getQualifiedTokenResolverClassName(ConcreteSyntax syntax, CompleteTokenDefinition definition, boolean inImportedSyntax) {
		if (inImportedSyntax) {
			syntax = definition.getContainingSyntax(syntax);
		}
		return getResolverPackageName(syntax) + "." + getTokenResolverClassName(syntax, definition);
	}

	/**
	 * Returns the name of the package where token and reference resolvers 
	 * must go to depending on the given syntax.
	 */
	public String getResolverPackageName(final ConcreteSyntax syntax) {
		String csPackageName = ANALYSIS_PACKAGE.getName(new ISyntaxContext() {
			public ConcreteSyntax getConcreteSyntax() {
				return syntax;
			}
		});
		return (csPackageName == null || csPackageName.equals("") ? "" : csPackageName);
	}

	public String getBasePackage(ConcreteSyntax syntax, String suffix, String prefix, OptionTypes basePackageOption) {
		String basePackage = OptionManager.INSTANCE.getStringOptionValue(syntax, basePackageOption);
		if (basePackage != null) {
			// use package name from option
			return basePackage;
		} else {
			String packageName = "";
			// use default package name
			GenPackage concreteSyntaxPackage = syntax.getPackage();
			boolean hasBasePackage = concreteSyntaxPackage.getBasePackage() != null;
			if (hasBasePackage) {
				packageName = concreteSyntaxPackage.getBasePackage() + ".";
			}
			packageName += concreteSyntaxPackage.getEcorePackage().getName();
			packageName += suffix + syntax.getName() + prefix;
			return packageName;
		}
	}

	public String getPluginName(ConcreteSyntax syntax, OptionTypes pluginIDOption, String suffix, String prefix, OptionTypes basePackageOption) {
		String pluginID = OptionManager.INSTANCE.getStringOptionValue(syntax, pluginIDOption);
		if (pluginID != null) {
			// use package plug-in from option
			return pluginID;
		} else {
			// use default plug-in name
			return getBasePackage(syntax, suffix, prefix, basePackageOption);
		}
	}

	public IPluginDescriptor getResourcePluginDescriptor(ConcreteSyntax syntax) {
		String pluginName = getPluginName(syntax, OptionTypes.RESOURCE_PLUGIN_ID, Constants.RESOURCE_PLUGIN_SUFFIX, "", OptionTypes.BASE_PACKAGE);
		IPluginDescriptor resourcePlugin = new PluginDescriptor(pluginName);
		return resourcePlugin;
	}

	public IPluginDescriptor getResourceUIPluginDescriptor(ConcreteSyntax syntax) {
		String pluginName = getPluginName(syntax, OptionTypes.RESOURCE_UI_PLUGIN_ID, Constants.RESOURCE_PLUGIN_SUFFIX, RESOURCE_UI_PLUGIN_SUFFIX, OptionTypes.UI_BASE_PACKAGE);
		IPluginDescriptor resourcePlugin = new PluginDescriptor(pluginName);
		return resourcePlugin;
	}

	public String getBuilderID(ConcreteSyntax syntax) {
		String pluginID = getResourcePluginDescriptor(syntax).getName();
		return pluginID + ".builder";
	}

	public String getNatureID(ConcreteSyntax syntax) {
		String pluginID = getResourcePluginDescriptor(syntax).getName();
		return pluginID + ".nature";
	}

	/**
	 * Returns the unqualified name of the reference resolver class for the given
	 * non-containment reference.
	 * 
	 * @param proxyReference
	 * @return
	 */
	public String getReferenceResolverClassName(GenFeature proxyReference) {
		return proxyReference.getGenClass().getName() + StringUtil.capitalize(proxyReference.getName()) + Constants.CLASS_SUFFIX_REFERENCE_RESOLVER;
	}

	/**
	 * Returns a collection that contains the names of all resolver
	 * classes (both token and reference resolvers) that are needed.
	 * Each resolver that is not part of an imported plug-in should 
	 * be added to this list. 
	 * 
	 * @return the collection of already generated resolver classes
	 */
	public Collection<String> getResolverFileNames(ConcreteSyntax syntax) {
		Collection<String> resolverFileNames = getReferenceResolverFileNames(syntax);
		resolverFileNames.addAll(getTokenResolverFileNames(syntax));
		return resolverFileNames;
	}

	/**
	 * Returns a list that contains the names of all reference resolver classes 
	 * that are needed. Some of them might be generated during the generation 
	 * process, others may already exist. This list does not contain resolver 
	 * classes that are contained in imported syntaxes and that are reused.
	 */
	public Collection<String> getReferenceResolverFileNames(ConcreteSyntax syntax) {
		Collection<GenFeature> features = csUtil.getNonContainmentFeaturesNeedingResolver(syntax);
		Collection<String> resolverFileNames = new LinkedHashSet<String>(features.size());
		for (GenFeature feature : features) {
			resolverFileNames.add(getReferenceResolverClassName(feature) + Constants.JAVA_FILE_EXTENSION);
		}
		return resolverFileNames;
	}

	/**
	 * Converts the first letter of the syntax name to upper case.
	 * Composite syntax names (containing dot characters) are replaced
	 * by a camel-case version (e.g., <code>text.ecore</code> is
	 * converted to <code>TextEcore</code>.
	 * 
	 * @param syntax the syntax to obtain the name from
	 * @return a capitalized camel-case version of the syntax name
	 */
	public String getCapitalizedConcreteSyntaxName(ConcreteSyntax syntax) {
		String csName = "";
		String[] csNameParts = syntax.getName().split("\\.");
		for(String part : csNameParts) {
			csName = csName + StringUtil.capitalize(part);
		}
		return csName;
	}

	/**
	 * Return the name of the default reference resolver class.
	 * 
	 * @param syntax
	 * @return
	 */
	public String getDefaultResolverDelegateName(ConcreteSyntax syntax) {
		return getCapitalizedConcreteSyntaxName(syntax) + Constants.CLASS_SUFFIX_DEFAULT_RESOLVER_DELEFATE;
	}

	/**
	 * Returns the unqualified name of the token resolver class for the given
	 * token definition.
	 * 
	 * @param syntax the main syntax
	 * @param tokenDefinition the token to derive the resolver class name for
	 * @return
	 */
	public String getTokenResolverClassName(ConcreteSyntax syntax, CompleteTokenDefinition tokenDefinition) {

		String syntaxName = getCapitalizedConcreteSyntaxName(tokenDefinition.getContainingSyntax(syntax));
		boolean isCollect = tokenDefinition.getAttributeName() != null;
		if (isCollect) {
			String attributeName = tokenDefinition.getAttributeName();
			return syntaxName +  "COLLECT_" + attributeName + Constants.CLASS_SUFFIX_TOKEN_RESOLVER;
		} else {
			return syntaxName +  tokenDefinition.getName() + Constants.CLASS_SUFFIX_TOKEN_RESOLVER;
		}
	}

	/**
	 * Returns a collection of all token resolver classes that need to be generated
	 * for a given syntax. This includes tokens from imported syntax definitions, 
	 * since EMFText does generate delegating classes for these tokens.
	 * 
	 * @param syntax the syntax containing the token definition
	 * @return a collection of token resolver classes
	 */
	public Collection<String> getTokenResolverFileNames(ConcreteSyntax syntax) {
		Collection<String> resolverFileNames = new LinkedHashSet<String>();
		
		for (CompleteTokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (tokenDefinition.isUsed()) {
				resolverFileNames.add(getTokenResolverClassName(syntax, tokenDefinition) + Constants.JAVA_FILE_EXTENSION);
			}
		}
		return resolverFileNames;
	}

	public String getFieldName(String prefix, EObject object) {
		List<Integer> path = EObjectUtil.getPath(object);
		return prefix + StringUtil.explode(path, "_", new ToStringConverter<Integer>() {

			public String toString(Integer sourceObject) {
				return sourceObject.toString();
			}
		});
	}

	public String getFieldName(SyntaxElement syntaxElement) {
		ConcreteSyntax syntax = syntaxElement.getContainingRule().getSyntax();
		String escapedSyntaxName = syntax.getName().replace(".", "_").toUpperCase();
		return getFieldName(escapedSyntaxName + "_", syntaxElement);
	}
}
