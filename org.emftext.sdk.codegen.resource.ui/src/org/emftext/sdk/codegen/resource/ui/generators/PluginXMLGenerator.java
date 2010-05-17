/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.resource.ui.generators;

import java.io.PrintWriter;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.ResourceBaseGenerator;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A generator for the plugin.xml file.
 * 
 * TODO mseifert: make this generator reusable
 */
public class PluginXMLGenerator extends ResourceBaseGenerator<Object> {

	public static final GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new PluginXMLGenerator());

	private GenerationContext context;

	private PluginXMLGenerator() {
		super();
	}

	private PluginXMLGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super();
		this.context = context;
	}

	public void generate(PrintWriter out) {
		out.write(getContentOfPluginXML());
		out.flush();
	}

	/**
	 * Generate the XML file describing the plug-in.
	 * 
	 * @return Generated code.
	 */
	private String getContentOfPluginXML() {
		final ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		final String primaryConcreteSyntaxName = getPrimarySyntaxName(concreteSyntax);
		IPluginDescriptor resourceUIPlugin = context.getResourceUIPlugin();
		String uiPluginID = resourceUIPlugin.getName();

		StringComposite sc = new XMLComposite();
		sc.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sc.add("<?eclipse version=\"3.2\"?>");
		sc.add("<plugin>");

		String editorName = context.getQualifiedClassName(TextResourceUIArtifacts.EDITOR);

		// registers the editor itself
		sc.add("<extension point=\"org.eclipse.ui.editors\">");
		sc.add("<editor class=\"" + editorName + 
				"\" contributorClass=\"org.eclipse.ui.texteditor.BasicTextEditorActionContributor\" " +
				"extensions=\"" + primaryConcreteSyntaxName + "\" " + 
				"icon=\"icons/editor_icon.gif\" " +
				"id=\"" + editorName + "\" " + 
				"name=\"EMFText " + concreteSyntax.getName() + " Editor\">");
		sc.add("</editor>");
		sc.add("</extension>");
		sc.addLineBreak();
		
		sc.add("<extension id=\"" + uiPluginID + ".problem\" name=\"EMFText Problem\" point=\"org.eclipse.core.resources.markers\">");
		sc.add("<persistent value=\"true\">");
		sc.add("</persistent>");
		sc.add("<super type=\"org.eclipse.core.resources.problemmarker\">");
		sc.add("</super>");
		sc.add("<super type=\"org.eclipse.core.resources.textmarker\">");
		sc.add("</super>");
		sc.add("</extension>");
		sc.addLineBreak();
		
		sc.add("<extension point=\"org.eclipse.core.runtime.preferences\">");
		sc.add("<initializer class=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_INITIALIZER) + "\">");
		sc.add("</initializer>");
		sc.add("</extension>");
		sc.addLineBreak();
		
		sc.add("<extension point=\"org.eclipse.ui.preferencePages\">");
		//main page
		sc.add("<page name=\"" + context.getCapitalizedConcreteSyntaxName() + " Text Editor\" " + 
				"id=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_PAGE) + "\" " +
				"class=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_PAGE) + "\" " +
				"category=\"org.eclipse.ui.preferencePages.GeneralTextEditor\">");
		sc.add("</page>");
		//sub pages
		sc.add("<page name=\"Syntax Coloring\" " + 
				"id=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE)  + "\" " +
				"class=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE) + "\" " + 
				"category=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_PAGE) + "\">");
		sc.add("</page>");
		sc.add("<page name=\"Brackets\" " + 
				"id=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.BRACKET_PREFERENCE_PAGE) + "\" " +
				"class=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.BRACKET_PREFERENCE_PAGE) + "\" " + 
				"category=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_PAGE) + "\">");
		sc.add("</page>");
		sc.add("<page name=\"Occurrence\" " + 
				"id=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.OCCURRENCE_PREFERENCE_PAGE)  + "\" " +
				"class=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.OCCURRENCE_PREFERENCE_PAGE) + "\" " + 
				"category=\"" + context.getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_PAGE) + "\">");
		sc.add("</page>");
		sc.add("</extension>");
		sc.addLineBreak();

		sc.add("<extension point=\"org.eclipse.ui.newWizards\">");
		sc.add("<category id=\"org.emftext.runtime.ui.EMFTextFileCategory\" name=\"EMFText File\">");
		sc.add("</category>");
		String newFileWizard = context.getQualifiedClassName(TextResourceUIArtifacts.NEW_FILE_WIZARD);
		sc.add("<wizard category=\"org.emftext.runtime.ui.EMFTextFileCategory\" icon=\"" + getProjectRelativeNewIconPath() + "\" class=\"" + newFileWizard + "\" id=\"" + newFileWizard + "\" name=\"EMFText ." + context.getConcreteSyntax().getName() + " file\">");
		sc.add("</wizard>");
		sc.add("</extension>");
		sc.addLineBreak();
		
		if (context.isGenerateTestActionEnabled()) {
			sc.add(generateTestActionExtension());
		}

		sc.add("</plugin>");

		return sc.toString();
	}

	private String getPrimarySyntaxName(ConcreteSyntax concreteSyntax) {
		 String fullConcreteSyntaxName = concreteSyntax.getName();
		 int idx = fullConcreteSyntaxName.lastIndexOf(".");
		 if (idx != -1) {
			 return fullConcreteSyntaxName.substring(idx + 1);
		 }
		 return fullConcreteSyntaxName;
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

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new PluginXMLGenerator(parent, context);
	}

	private String getProjectRelativeNewIconPath() {
		// it is OK to use slashes here, because this path is put into
		// the plugin.xml
		return "/" + UIConstants.DEFAULT_ICON_DIR + "/" + UIConstants.DEFAULT_NEW_ICON_NAME;
	}
}
