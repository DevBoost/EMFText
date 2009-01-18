package org.emftext.sdk.codegen;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A generator for the plugin.xml file.
 */
public class PluginXMLGenerator implements IGenerator {

	private final GenerationContext context;
	private final boolean generateTestAction;

	public PluginXMLGenerator(GenerationContext context, boolean generateTestAction) {
		super();
		this.context = context;
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
		final ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		final String concreteSyntaxName = concreteSyntax.getName();
		final String factoryClassName = context.getResourceFactoryClassName();
		final String packageName = context.getPackageName();

		StringBuffer s = new StringBuffer();
		s.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		s.append("<?eclipse version=\"3.2\"?>\n");
		s.append("<plugin>\n");

		// register the generated resource factory
		s.append("   <extension\n");
		s.append("         point=\"org.eclipse.emf.ecore.extension_parser\">\n");
		s.append("      <parser\n");
		s.append("            class=\"" + packageName + "." + factoryClassName + "\"\n");
		s.append("            type=\"" + concreteSyntaxName + "\">\n");
		s.append("      </parser>\n");
		s.append("   </extension>\n\n");

		// register the cs file
		s.append("   <extension\n");
		s.append("         point=\"" + EMFTextPlugin.EP_CONCRETESYNTAX_ID + "\">\n");
		s.append("      <concretesyntax\n");
		s.append("            uri=\"" + concreteSyntax.getPackage().getNSURI() + "\"\n");
		s.append("            csName=\"" + concreteSyntaxName + "\"\n");
		s.append("            csDefinition=\"" + context.getConcreteSyntaxFile().getProject().getName() + "/" + context.getConcreteSyntaxFile().getProjectRelativePath() + "\">\n");
		s.append("      </concretesyntax>\n");
		s.append("   </extension>\n\n");

		// registers the file extension for the EMF Text Editor
		s.append("   <extension\n");
		s.append("         point=\"org.eclipse.core.contenttype.contentTypes\">\n");
		s.append("      <file-association\n");
		s.append("            content-type=\"org.emftext.filetype\"\n");
		s.append("            file-extensions=\"" + concreteSyntaxName + "\">\n");
		s.append("      </file-association>\n");
		s.append("   </extension>\n\n");

		if (generateTestAction) {
			s.append(generateTestActionExtension());
		}

		s.append("</plugin>\n");

		return s.toString();
	}

	private String generateTestActionExtension() {

		final ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		final String concreteSyntaxName = concreteSyntax.getName();
		final GenPackage concreteSyntaxPackage = concreteSyntax.getPackage();
		final String concreteSyntaxBasePackage = concreteSyntaxPackage.getBasePackage();
		final String baseId = (concreteSyntaxBasePackage == null ? ""
				: concreteSyntaxBasePackage + ".")
				+ concreteSyntaxName;

		StringBuffer s = new StringBuffer();
		s.append("\t<extension\n");
		s.append("\t\t\tpoint=\"org.eclipse.ui.popupMenus\">\n");
		s.append("\t\t<objectContribution\n");
		s.append("\t\t\t\tid=\"" + baseId + ".contributions\"\n");
		s.append("\t\t\t\tobjectClass=\"org.eclipse.core.resources.IFile\"\n");
		s.append("\t\t\t\tnameFilter=\"*." + concreteSyntaxName + "\">\n");
		s.append("\t\t\t<action\n");
		s.append("\t\t\t\t\tclass=\"org.emftext.sdk.ui.actions.ValidateParserPrinterAction\"\n");
		s.append("\t\t\t\t\tenablesFor=\"1\"\n");
		s.append("\t\t\t\t\tid=\"" + baseId + ".validate\"\n");
		s.append("\t\t\t\t\tlabel=\"Validate\"\n");
		s.append("\t\t\t\t\tmenubarPath=\"org.emftext.sdk.ui.menu1/group1\">\n");
		s.append("\t\t\t</action>\n");
		s.append("\t\t</objectContribution>\n");
		s.append("\t</extension>\n");
		return s.toString();
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptyList();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptyList();
	}
}
