package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
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

		StringComposite s = new XMLComposite();
		s.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		s.add("<?eclipse version=\"3.2\"?>");
		s.add("<plugin>");

		// register the generated resource factory
		s.add("<extension point=\"org.eclipse.emf.ecore.extension_parser\">");
		s.add("<parser class=\"" + packageName + "." + factoryClassName + "\" type=\"" + concreteSyntaxName + "\">");
		s.add("</parser>");
		s.add("</extension>");
		s.addLineBreak();

		// register the cs file
		s.add("<extension point=\"" + EMFTextRuntimePlugin.EP_CONCRETESYNTAX_ID + "\">");
		s.add("<concretesyntax uri=\"" + concreteSyntax.getPackage().getNSURI() + "\" csName=\"" + concreteSyntaxName + "\" csDefinition=\"" + context.getConcreteSyntaxFile().getProject().getName() + "/" + context.getConcreteSyntaxFile().getProjectRelativePath() + "\">");
		s.add("</concretesyntax>");
		s.add("</extension>");
		s.addLineBreak();

		// registers the file extension for the EMF Text Editor
		s.add("<extension point=\"org.eclipse.core.contenttype.contentTypes\">");
		s.add("<file-association content-type=\"org.emftext.filetype\" file-extensions=\"" + concreteSyntaxName + "\">");
		s.add("</file-association>");
		s.add("</extension>");
		s.addLineBreak();

		if (generateTestAction) {
			s.add(generateTestActionExtension());
		}

		s.add("</plugin>");

		return s.toString();
	}

	private StringComposite generateTestActionExtension() {

		final ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		final String concreteSyntaxName = concreteSyntax.getName();
		final GenPackage concreteSyntaxPackage = concreteSyntax.getPackage();
		final String concreteSyntaxBasePackage = concreteSyntaxPackage.getBasePackage();
		final String baseId = (concreteSyntaxBasePackage == null ? ""
				: concreteSyntaxBasePackage + ".")
				+ concreteSyntaxName;

		StringComposite s = new XMLComposite();
		s.add("<extension point=\"org.eclipse.ui.popupMenus\">");
		s.add("<objectContribution id=\"" + baseId + ".contributions\" objectClass=\"org.eclipse.core.resources.IFile\" nameFilter=\"*." + concreteSyntaxName + "\">");
		s.add("<action class=\"org.emftext.sdk.ui.actions.ValidateParserPrinterAction\" enablesFor=\"1\" id=\"" + baseId + ".validate\" label=\"Validate\" menubarPath=\"org.emftext.sdk.ui.menu1/group1\">");
		s.add("</action>");
		s.add("</objectContribution>");
		s.add("</extension>");
		return s;
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptyList();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptyList();
	}
}
