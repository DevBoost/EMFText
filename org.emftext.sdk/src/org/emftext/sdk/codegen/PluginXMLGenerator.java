package org.emftext.sdk.codegen;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class PluginXMLGenerator implements IGenerator {

	private final ConcreteSyntax cSyntax;
	private final String packageName;
	private final IFile file;
	private final boolean generateTestAction;

	public PluginXMLGenerator(ConcreteSyntax cSyntax, String packageName,
			IFile file, boolean generateTestAction) {
		super();
		this.cSyntax = cSyntax;
		this.packageName = packageName;
		this.file = file;
		this.generateTestAction = generateTestAction;
	}

	public boolean generate(PrintWriter out) {
		out.write(getContentOfPluginXML());
		out.flush();
		return true;
	}

	/**
	 * Generate the XML file describing the plug-in.
	 * 
	 * @param cSyntax
	 *            Concrete syntax model.
	 * @param packageName
	 *            Name of the Java package.
	 * @param file
	 *            File representation of the concrete syntax definition.
	 * @return Generated code.
	 */
	private String getContentOfPluginXML() {
		StringBuffer s = new StringBuffer();
		String factoryClassName = cSyntax.getName().substring(0, 1)
				.toUpperCase()
				+ cSyntax.getName().substring(1) + "ResourceFactoryImpl";

		s.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		s.append("<?eclipse version=\"3.2\"?>\n");
		s.append("<plugin>\n");

		// register the generated resource factory
		s.append("   <extension\n");
		s
				.append("         point=\"org.eclipse.emf.ecore.extension_parser\">\n");
		s.append("      <parser\n");
		s.append("            class=\"" + packageName + "." + factoryClassName
				+ "\"\n");
		s.append("            type=\"" + cSyntax.getName() + "\">\n");
		s.append("      </parser>\n");
		s.append("   </extension>\n\n");

		// register the cs file
		s.append("   <extension\n");
		s.append("         point=\"" + EMFTextPlugin.EP_CONCRETESYNTAX_ID
				+ "\">\n");
		s.append("      <concretesyntax\n");
		s.append("            uri=\"" + cSyntax.getPackage().getNSURI()
				+ "\"\n");
		s.append("            csName=\"" + cSyntax.getName() + "\"\n");
		s.append("            csDefinition=\"" + file.getProject().getName()
				+ "/" + file.getProjectRelativePath() + "\">\n");
		s.append("      </concretesyntax>\n");
		s.append("   </extension>\n\n");

		// registers the file extension for the EMF Text Editor
		s.append("   <extension\n");
		s
				.append("         point=\"org.eclipse.core.contenttype.contentTypes\">\n");
		s.append("      <file-association\n");
		s
				.append("            content-type=\"org.emftext.filetype\"\n");
		s
				.append("            file-extensions=\"" + cSyntax.getName()
						+ "\">\n");
		s.append("      </file-association>\n");
		s.append("   </extension>\n\n");

		if (generateTestAction) {
			String baseId = (cSyntax.getPackage().getBasePackage() == null ? ""
					: cSyntax.getPackage().getBasePackage() + ".")
					+ cSyntax.getName();

			s.append("\t<extension\n");
			s.append("\t\t\tpoint=\"org.eclipse.ui.popupMenus\">\n");
			s.append("\t\t<objectContribution\n");
			s.append("\t\t\t\tid=\"" + baseId + ".contributions\"\n");
			s
					.append("\t\t\t\tobjectClass=\"org.eclipse.core.resources.IFile\"\n");
			s.append("\t\t\t\tnameFilter=\"*." + cSyntax.getName() + "\">\n");
			s.append("\t\t\t<action\n");
			s
					.append("\t\t\t\t\tclass=\"org.emftext.sdk.ui.actions.ValidateParserPrinterAction\"\n");
			s.append("\t\t\t\t\tenablesFor=\"1\"\n");
			s.append("\t\t\t\t\tid=\"" + baseId + ".validate\"\n");
			s.append("\t\t\t\t\tlabel=\"Validate\"\n");
			s
					.append("\t\t\t\t\tmenubarPath=\"org.emftext.sdk.ui.menu1/group1\">\n");
			s.append("\t\t\t</action>\n");
			s.append("\t\t</objectContribution>\n");
			s.append("\t</extension>\n");
		}

		s.append("</plugin>\n");

		return s.toString();
	}

	public Collection<GenerationProblem> getOccuredErrors() {
		return Collections.emptyList();
	}

	public Collection<GenerationProblem> getOccuredWarningsAndErrors() {
		return Collections.emptyList();
	}

}
