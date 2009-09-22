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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.codegen.EArtifact;
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

	private GenerationContext context;

	public PluginXMLGenerator() {
		super();
	}

	private PluginXMLGenerator(GenerationContext context) {
		super();
		this.context = context;
	}

	public boolean generate(PrintWriter out) {
		out.write(getContentOfPluginXML());
		out.flush();
		return true;
	}

	/**
	 * Generate the XML file describing the plug-in.
	 * 
	 * @return Generated code.
	 */
	private String getContentOfPluginXML() {
		final ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		final String concreteSyntaxName = concreteSyntax.getName();
		final String qualifiedResourceFactoryClassName = context.getQualifiedClassName(EArtifact.RESOURCE_FACTORY);

		StringComposite sc = new XMLComposite();
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<?eclipse version=\"3.2\"?>");
		sc.add("<plugin>");

		// register the generated resource factory
		sc.add("<extension point=\"org.eclipse.emf.ecore.extension_parser\">");
		sc.add("<parser class=\"" + qualifiedResourceFactoryClassName + "\" type=\"" + concreteSyntaxName + "\">");
		sc.add("</parser>");
		sc.add("</extension>");
		sc.addLineBreak();

		// register the syntax meta information
		String metaInformationClass = context.getQualifiedClassName(EArtifact.META_INFORMATION);
		sc.add("<extension point=\"org.emftext.access.syntax\">");
		sc.add("<metaInformationProvider class=\"" + metaInformationClass + "\" id=\"" + metaInformationClass + "\">");
		sc.add("</metaInformationProvider>");
		sc.add("</extension>");
		sc.addLineBreak();

		// registers the file extension for the EMF Text Editor
		sc.add("<extension point=\"org.eclipse.core.contenttype.contentTypes\">");
		sc.add("<file-association content-type=\"org.emftext.filetype\" file-extensions=\"" + concreteSyntaxName + "\">");
		sc.add("</file-association>");
		sc.add("</extension>");
		sc.addLineBreak();
		
		sc.add("<extension point=\"org.eclipse.ui.newWizards\">");
		sc.add("<category id=\"org.emftext.runtime.ui.EMFTextFileCategory\" name=\"EMFText File\">");
		sc.add("</category>");
		String newFileWizard = context.getQualifiedClassName(EArtifact.NEW_FILE_WIZARD);
		sc.add("<wizard category=\"org.emftext.runtime.ui.EMFTextFileCategory\" icon=\"" + context.getProjectRelativeNewIconPath() + "\" class=\"" + newFileWizard + "\" id=\"" + newFileWizard + "\" name=\"EMFText ." + context.getConcreteSyntax().getName() + " file\">");
		sc.add("</wizard>");
		sc.add("</extension>");
		sc.addLineBreak();

		if (context.isGenerateTestActionEnabled()) {
			sc.add(generateTestActionExtension());
		}

		sc.add("</plugin>");

		return sc.toString();
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

	public IGenerator newInstance(GenerationContext context) {
		return new PluginXMLGenerator(context);
	}
}
