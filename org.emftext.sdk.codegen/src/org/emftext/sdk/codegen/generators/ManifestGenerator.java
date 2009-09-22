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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.util.StringUtil;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.ManifestComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

/**
 * A generator that creates the manifest file for the resource
 * plug-in.
 */
public class ManifestGenerator implements IGenerator {

	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private GenerationContext context;

	public ManifestGenerator() {
		super();
	}

	private ManifestGenerator(GenerationContext context) {
		this.context = context;
	}

	public boolean generate(PrintWriter out) {
		out.write(getManifestContent());
		out.flush();
		return true;
	}

	/**
	 * Generates the contents of the MANIFEST.MF file for the plug-in.
	 * 
	 * @param cSyntax
	 *            Concrete syntax model.
	 * @param packageName
	 *            Name of the Java package.
	 * @param resourcePackage
	 * 
	 * @return generated content
	 */
	private String getManifestContent() {
		StringComposite sc = new ManifestComposite();
		ConcreteSyntax syntax = context.getConcreteSyntax();
		String projectName = context.getPluginName();
		
		Set<String> requiredBundles = getRequiredBundles(syntax);
		
		sc.add("Manifest-Version: 1.0");
		sc.add("Bundle-ManifestVersion: 2");
		sc.add("Bundle-Name: EMFText Parser Plugin: " + syntax.getName());
		sc.add("Bundle-SymbolicName: " + projectName + ";singleton:=true");
		sc.add("Bundle-Version: 1.0.0");
		sc.add("Bundle-Vendor: Software Technology Group - TU Dresden Germany");
		sc.add("Require-Bundle: " + StringUtil.explode(requiredBundles, ",\n  "));
		sc.add("Bundle-ActivationPolicy: lazy");
		sc.add("Bundle-RequiredExecutionEnvironment: J2SE-1.5");
		// export the generated packages
		// TODO refactor
		if (csUtil.getResolverFileNames(syntax).size() > 0) {
			sc.add("Export-Package: " + context.getPackageName(EArtifact.PACKAGE_ROOT) + ",");
			sc.add("  " + context.getPackageName(EArtifact.PACKAGE_ANALYSIS) + ",");
			sc.add("  " + context.getPackageName(EArtifact.PACKAGE_CC) + ",");
			sc.add("  " + context.getPackageName(EArtifact.PACKAGE_MOPP) + ",");
			sc.add("  " + context.getPackageName(EArtifact.PACKAGE_UI) + ",");
			sc.add("  " + context.getPackageName(EArtifact.PACKAGE_UTIL));
		} else {
			sc.add("Export-Package: " + context.getPackageName(EArtifact.PACKAGE_ROOT) + ",");
			sc.add("  " + context.getPackageName(EArtifact.PACKAGE_CC) + ",");
			sc.add("  " + context.getPackageName(EArtifact.PACKAGE_MOPP) + ",");
			sc.add("  " + context.getPackageName(EArtifact.PACKAGE_UI) + ",");
			sc.add("  " + context.getPackageName(EArtifact.PACKAGE_UTIL));
		}

		return sc.toString();
	}

	private Set<String> getRequiredBundles(ConcreteSyntax syntax) {
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
		imports.add("org.emftext.runtime.antlr");
		
		if (context.isGenerateTestActionEnabled()) {
			imports.add("org.emftext.sdk.ui");
		}

		addImports(imports, syntax);
		
		// remove the current plug-in, because we do not
		// need to import it
		imports.remove(context.getPluginName());
		
		return imports;
	}

	private void addImports(Collection<String> requiredBundles,
			ConcreteSyntax concreteSyntax) {

		// first add the syntax itself
		String syntaxPluginID = csUtil.getPluginName(concreteSyntax);
		requiredBundles.add(syntaxPluginID);
		
		// second add the main generator package
		GenPackage mainPackage = concreteSyntax.getPackage();
		addImports(requiredBundles, mainPackage);
		
		// third add imported generator packages and syntaxes recursively
		for (Import nextImport : concreteSyntax.getImports()) {
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

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptyList();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptyList();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ManifestGenerator(context);
	}
}
