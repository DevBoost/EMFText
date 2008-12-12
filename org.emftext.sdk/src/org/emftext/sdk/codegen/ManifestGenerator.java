package org.emftext.sdk.codegen;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

public class ManifestGenerator implements IGenerator {

	private final ConcreteSyntax cSyntax;
	private final String packageName;
	private final ResourcePackage resourcePackage;
	private final boolean generateTestAction;

	public ManifestGenerator(ConcreteSyntax cSyntax, String packageName,
			ResourcePackage resourcePackage, boolean generateTestAction) {
		this.cSyntax = cSyntax;
		this.packageName = packageName;
		this.resourcePackage = resourcePackage;
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
		StringBuffer s = new StringBuffer();

		s.append("Manifest-Version: 1.0\n");
		s.append("Bundle-ManifestVersion: 2\n");
		s.append("Bundle-Name: EMFText Parser Plugin: " + cSyntax.getName()
				+ "\n");
		s.append("Bundle-SymbolicName: " + packageName + ";singleton:=true\n");
		s.append("Bundle-Version: 1.0.0\n");
		s
				.append("Bundle-Vendor: Software Engineering Group - TU Dresden Germany\n");
		// s.append("Bundle-Localization: plugin\n");
		s.append("Require-Bundle: org.eclipse.core.runtime,\n");
		s.append("  org.eclipse.emf.ecore,\n");
		List<String> importedPlugins = new ArrayList<String>();
		String modelPluginID = cSyntax.getPackage().getGenModel().getModelPluginID();
		importedPlugins.add(modelPluginID);
		s.append("  " + modelPluginID
				+ ",\n");
		if (generateTestAction) {
			s.append("  org.emftext.sdk.ui,\n");
		}
		for (Import aImport : cSyntax.getImports()) {
			GenModel genModel = aImport.getPackage().getGenModel();
			String pluginID = genModel.getModelPluginID();
			if (!importedPlugins.contains(pluginID)) {
				s.append("  " + pluginID + ",\n");
				importedPlugins.add(pluginID);
			}
		}
		s.append("  org.emftext.runtime\n");
		s.append("Bundle-ActivationPolicy: lazy\n");
		s.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5\n");
		// export the generated packages
		s.append("Export-Package: " + packageName + ",\n");
		s.append("  " + resourcePackage.getResolverPackageName() + "\n");

		return s.toString();
	}

	public Collection<GenerationProblem> getOccuredErrors() {
		return Collections.emptyList();
	}

	public Collection<GenerationProblem> getOccuredWarningsAndErrors() {
		return Collections.emptyList();
	}
}
