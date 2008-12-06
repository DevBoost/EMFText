package org.emftext.sdk.codegen;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
		s.append("Bundle-Name: EMFTextEdit Parser Plugin: " + cSyntax.getName()
				+ "\n");
		s.append("Bundle-SymbolicName: " + packageName + ";singleton:=true\n");
		s.append("Bundle-Version: 1.0.0\n");
		s
				.append("Bundle-Vendor: Software Engineering Group - TU Dresden Germany\n");
		// s.append("Bundle-Localization: plugin\n");
		s.append("Require-Bundle: org.eclipse.core.runtime,\n");
		s.append("  org.eclipse.emf.ecore,\n");
		s.append("  " + cSyntax.getPackage().getGenModel().getModelPluginID()
				+ ",\n");
		if (generateTestAction) {
			s.append("  org.reuseware.emftextedit.sdk.ui,\n");
		}
		EList<GenModel> importedPlugins = new BasicEList<GenModel>();
		for (Import aImport : cSyntax.getImports()) {
			GenModel m = aImport.getPackage().getGenModel();
			if (!importedPlugins.contains(m)) {
				s.append("  " + m.getModelPluginID() + ",\n");
				importedPlugins.add(m);
			}
		}
		s.append("  org.reuseware.emftextedit.runtime\n");
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
