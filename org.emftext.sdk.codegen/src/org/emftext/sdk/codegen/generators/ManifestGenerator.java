/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.ManifestComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.util.StringUtil;

/**
 * A generator that creates the manifest file for the resource
 * plug-in.
 */
public abstract class ManifestGenerator implements IGenerator {

	private GenerationContext context;

	public ManifestGenerator(GenerationContext context) {
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
		
		Collection<String> requiredBundles = getRequiredBundles(context);
		Collection<String> exportedPackages = getExportedPackages(context);

		sc.add("Manifest-Version: 1.0");
		sc.add("Bundle-ManifestVersion: 2");
		sc.add("Bundle-Name: " + getBundleName(context));
		sc.add("Bundle-SymbolicName: " + getBundleID(context) + ";singleton:=true");
		sc.add("Bundle-Version: 1.0.0");
		sc.add("Bundle-Vendor: Software Technology Group - TU Dresden Germany");
		if (requiredBundles.size() > 0) {
			sc.add("Require-Bundle: " + StringUtil.explode(requiredBundles, ",\n  "));
		}
		sc.add("Bundle-ActivationPolicy: lazy");
		sc.add("Bundle-RequiredExecutionEnvironment: J2SE-1.5");
		if (exportedPackages.size() > 0) {
			sc.add("Export-Package: " + StringUtil.explode(exportedPackages, ",\n  "));
		}
		String activatorClass = getActivatorClass(context);
		if (activatorClass != null) {
			sc.add("Bundle-Activator: " + activatorClass);
		}

		return sc.toString();
	}


	protected String getBundleID(GenerationContext context) {
		return getPlugin().getName(context.getConcreteSyntax());
	}

	protected abstract String getBundleName(GenerationContext context);

	protected abstract String getActivatorClass(GenerationContext context);

	protected abstract EPlugins getPlugin();

	protected abstract Collection<String> getRequiredBundles(GenerationContext context);

	protected abstract Collection<String> getExportedPackages(GenerationContext context);

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptyList();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptyList();
	}

	public IGenerator newInstance(GenerationContext context) {
		throw new UnsupportedOperationException();
	}
}
