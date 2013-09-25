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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;

import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.parameters.ManifestParameters;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.manifest.ManifestComposite;
import de.devboost.codecomposers.util.StringUtil;

/**
 * A generator that creates manifest files.
 */
public class ManifestGenerator<ContextType extends IContext<ContextType>> extends AbstractGenerator<ContextType, ManifestParameters<ContextType>> {

	public ManifestGenerator() {
		super();
	}

	@Override
	public void doGenerate(PrintWriter out) {
		out.write(getManifestContent());
		out.flush();
	}

	/**
	 * Generates the contents of the MANIFEST.MF file for the plug-in.
	 * 
	 * @return generated content
	 */
	private String getManifestContent() {
		StringComposite sc = new ManifestComposite();
		
		ManifestParameters<ContextType> parameters = getParameters();
		Collection<String> requiredBundles = parameters.getRequiredBundles();
		Collection<String> exportedPackages = parameters.getExportedPackages();

		sc.add("Manifest-Version: 1.0");
		sc.add("Bundle-ManifestVersion: 2");
		sc.add("Bundle-Name: " + parameters.getBundleName());
		sc.add("Bundle-SymbolicName: " + parameters.getPlugin().getName() + ";singleton:=true");
		sc.add("Bundle-Version: 1.0.0");
		sc.add("Bundle-Vendor: Software Technology Group - TU Dresden Germany");
		if (requiredBundles.size() > 0) {
			sc.add("Require-Bundle: " + StringUtil.explode(requiredBundles, ",\n  "));
		}
		sc.add("Bundle-ActivationPolicy: lazy");
		// TODO Consider CS option to configure JDK here
		sc.add("Bundle-RequiredExecutionEnvironment: JavaSE-1.6");
		if (exportedPackages.size() > 0) {
			sc.add("Export-Package: " + StringUtil.explode(exportedPackages, ",\n  "));
		}
		String activatorClass = parameters.getActivatorClass();
		if (activatorClass != null) {
			sc.add("Bundle-Activator: " + activatorClass);
		}

		Collection<String> importedPackages = parameters.getImportedPackages();
		if (importedPackages.size() > 0) {
			sc.add("Import-Package: " + StringUtil.explode(importedPackages, ",\n  "));
		}
		
		Collection<String> bundleClasspath = parameters.getBundleClasspath();
		if (bundleClasspath.size() > 0) {
			sc.add("Bundle-ClassPath: " + ".,\n  " + StringUtil.explode(bundleClasspath, ",\n  "));
		} 
		
		return sc.toString();
	}
}
