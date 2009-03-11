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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.ManifestComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

/**
 * A generator that creates the manifest file for the resource
 * plug-in.
 */
public class ManifestGenerator implements IGenerator {

	private final GenerationContext context;
	private final boolean generateTestAction;

	public ManifestGenerator(GenerationContext context, boolean generateTestAction) {
		this.context = context;
		this.generateTestAction = generateTestAction;
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
		ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		String projectName = context.getPluginName();
		
		sc.add("Manifest-Version: 1.0");
		sc.add("Bundle-ManifestVersion: 2");
		sc.add("Bundle-Name: EMFText Parser Plugin: " + concreteSyntax.getName());
		sc.add("Bundle-SymbolicName: " + projectName + ";singleton:=true");
		sc.add("Bundle-Version: 1.0.0");
		sc.add("Bundle-Vendor: Software Engineering Group - TU Dresden Germany");
		sc.add("Require-Bundle: org.eclipse.core.runtime,");
		sc.add("  org.eclipse.emf.ecore,");
		List<String> importedPlugins = new ArrayList<String>();
		String modelPluginID = concreteSyntax.getPackage().getGenModel().getModelPluginID();
		importedPlugins.add(modelPluginID);
		sc.add("  " + modelPluginID + ",");
		if (generateTestAction) {
			sc.add("  org.emftext.sdk.ui,");
		}
		for (Import aImport : concreteSyntax.getImports()) {
			GenModel genModel = aImport.getPackage().getGenModel();
			String pluginID = genModel.getModelPluginID();
			if (!importedPlugins.contains(pluginID)) {
				sc.add("  " + pluginID + ",");
				sc.add("  " + context.getPluginName(aImport.getConcreteSyntax()) + ",");
				importedPlugins.add(pluginID);
			}
		}
		sc.add("  org.eclipse.jface,");
		sc.add("  org.eclipse.ui,");
		sc.add("  org.emftext.runtime,");
		sc.add("  org.emftext.runtime.ui");

		sc.add("Bundle-ActivationPolicy: lazy");
		sc.add("Bundle-RequiredExecutionEnvironment: J2SE-1.5");
		// export the generated packages
		if (context.getResolverClasses().size() > 0) {
			sc.add("Export-Package: " + projectName + ",");
			sc.add("  " + context.getResolverPackageName());
		} else {
			sc.add("Export-Package: " + projectName);
		}

		return sc.toString();
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptyList();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptyList();
	}
}
