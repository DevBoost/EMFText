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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ResourcePluginManifestGenerator extends ManifestGenerator {

	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	public ResourcePluginManifestGenerator(GenerationContext context) {
		super(context);
	}

	@Override
	protected Collection<String> getExportedPackages(GenerationContext context) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		
		Set<String> exports = new LinkedHashSet<String>();
		
		// export the generated packages
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ROOT));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_CC));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_MOPP));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_UI));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_UTIL));
		// do not export the analysis package if the are no resolvers
		if (csUtil.getResolverFileNames(syntax).size() > 0) {
			exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANALYSIS));
		}
		exports.addAll(getAdditionalPackages(syntax, OptionTypes.ADDITIONAL_EXPORTS));
		return exports;
	}

	@Override
	protected Collection<String> getRequiredBundles(GenerationContext context) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		
		Set<String> imports = new LinkedHashSet<String>();
		imports.add("org.eclipse.core.resources");
		imports.add("org.emftext.access;resolution:=optional");
		imports.add("org.eclipse.emf");
		imports.add("org.eclipse.emf.codegen.ecore");
		imports.add("org.eclipse.emf.ecore");
		imports.add("org.eclipse.emf.ecore.edit");
		imports.add("org.eclipse.emf.edit.ui");
		imports.add("org.eclipse.emf.workspace");
		imports.add("org.eclipse.jface");
		imports.add("org.eclipse.jface.text");
		imports.add("org.eclipse.ui");
		imports.add("org.eclipse.ui.editors");
		imports.add("org.eclipse.ui.ide");
		imports.add("org.eclipse.ui.views");
		// TODO implement extension mechanism to allow code generation plug-ins to add
		// more imports here 

		String qualifiedBasePluginName = 
			OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.BASE_RESOURCE_PLUGIN);
		if (qualifiedBasePluginName != null) {
			imports.add(qualifiedBasePluginName);
		}
		
		imports.addAll(getAdditionalPackages(syntax, OptionTypes.ADDITIONAL_DEPENDENCIES));

		if (context.isGenerateTestActionEnabled()) {
			imports.add("org.emftext.sdk.ui");
		}

		addImports(imports, syntax);
		
		// remove the current plug-in, because we do not
		// need to import it
		imports.remove(EPlugins.RESOURCE_PLUGIN.getName(syntax));
		
		return imports;
	}

	private Collection<String> getAdditionalPackages(ConcreteSyntax syntax, OptionTypes option) {
		String additionalPackagesString = 
			OptionManager.INSTANCE.getStringOptionValue(syntax, option);
		if (additionalPackagesString != null) {
			String[] additionalPackages = additionalPackagesString.split(",");
			return Arrays.asList(additionalPackages);
		} else {
			return Collections.emptySet();
		}
	}

	private void addImports(Collection<String> requiredBundles,
			ConcreteSyntax syntax) {

		// first add the syntax itself
		String syntaxPluginID = EPlugins.RESOURCE_PLUGIN.getName(syntax);
		requiredBundles.add(syntaxPluginID);
		String antlrPluginID = EPlugins.ANTLR_PLUGIN.getName(syntax);
		requiredBundles.add(antlrPluginID);
		
		// second add the main generator package
		GenPackage mainPackage = syntax.getPackage();
		addImports(requiredBundles, mainPackage);
		
		// third add imported generator packages and syntaxes recursively
		for (Import nextImport : syntax.getImports()) {
			GenPackage importedPackage = nextImport.getPackage();
			addImports(requiredBundles, importedPackage);

			ConcreteSyntax importedSyntax = nextImport.getConcreteSyntax();
			if (importedSyntax != null) {
				addImports(requiredBundles, importedSyntax);
			}
		}
	}

	/**
	 * Adds imports for the given generator package and all used
	 * generator packages.
	 * 
	 * @param requiredBundles
	 * @param genPackage
	 * @return
	 */
	private GenModel addImports(Collection<String> requiredBundles, GenPackage genPackage) {
		// add the package itself
		addImport(requiredBundles, genPackage);
		
		// add used generator packages
		GenModel genModel = genPackage.getGenModel();
		for (GenPackage usedGenPackage : genModel.getUsedGenPackages()) {
			addImport(requiredBundles, usedGenPackage);
		}
		return genModel;
	}

	/**
	 * Adds one import for the given generator package.
	 * 
	 * @param requiredBundles
	 * @param genPackage
	 * @return
	 */
	private void addImport(Collection<String> requiredBundles, GenPackage genPackage) {
		GenModel genModel = genPackage.getGenModel();
		String modelPluginID = genModel.getModelPluginID();
		requiredBundles.add(modelPluginID);
	}


	@Override
	protected EPlugins getPlugin() {
		return EPlugins.RESOURCE_PLUGIN;
	}

	@Override
	protected String getActivatorClass(GenerationContext context) {
		return context.getQualifiedClassName(TextResourceArtifacts.PLUGIN_ACTIVATOR);
	}

	@Override
	protected String getBundleName(GenerationContext context) {
		return "EMFText Parser Plugin: " + context.getConcreteSyntax().getName();
	}
}
