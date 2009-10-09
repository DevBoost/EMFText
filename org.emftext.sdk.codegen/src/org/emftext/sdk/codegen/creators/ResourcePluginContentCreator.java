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
package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A creator that uses multiple other creators to create
 * a resource plug-in from a CS specification and a meta 
 * model.
 */
public class ResourcePluginContentCreator {
	
	public void generate(GenerationContext context, IProgressMonitor monitor) throws IOException {
		SubMonitor progress = SubMonitor.convert(monitor, "generating resource plug-in...", 100);
	    
		ConcreteSyntax syntax = context.getConcreteSyntax();
		Resource csResource = syntax.eResource();
		EcoreUtil.resolveAll(csResource);
	    
	    List<IArtifactCreator> creators = new ArrayList<IArtifactCreator>();
	    creators.add(new FoldersCreator(new File[] {
	    		context.getSourceFolder(EPlugins.RESOURCE_PLUGIN, false),
	    		context.getSourceFolder(EPlugins.RESOURCE_PLUGIN, true),
	    		context.getSchemaFolder(),
	    		context.getCSSDir()
	    }));
	    creators.add(new DotClasspathCreator(EPlugins.RESOURCE_PLUGIN));
	    creators.add(new DotProjectCreator(EPlugins.RESOURCE_PLUGIN));
	    creators.add(new BuildPropertiesCreator(EPlugins.RESOURCE_PLUGIN));
	    if (OptionManager.INSTANCE.useScalesParser(syntax)) {
	    	creators.add(new GenericArtifactCreator(EArtifact.SCANNERLESS_SCANNER));
	    	creators.add(new GenericArtifactCreator(EArtifact.SCANNERLESS_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.ANTLR_SCANNER), EArtifact.PACKAGE_MOPP, context.getClassName(EArtifact.ANTLR_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.ANTLR_LEXER), EArtifact.PACKAGE_MOPP, context.getClassName(EArtifact.ANTLR_LEXER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.ANTLR_PARSER), EArtifact.PACKAGE_MOPP, context.getClassName(EArtifact.ANTLR_PARSER), OptionTypes.OVERRIDE_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.ANTLR_PARSER_BASE), EArtifact.PACKAGE_MOPP, context.getClassName(EArtifact.ANTLR_PARSER_BASE), OptionTypes.OVERRIDE_PARSER));
	    } else {
	    	creators.add(new GenericArtifactCreator(EArtifact.ANTLR_SCANNER));
		    creators.add(new ANTLRGrammarCreator());
		    creators.add(new ANTLRParserCreator());
		    creators.add(new GenericArtifactCreator(EArtifact.ANTLR_PARSER_BASE));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.SCANNERLESS_SCANNER), EArtifact.PACKAGE_MOPP, context.getClassName(EArtifact.SCANNERLESS_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(EArtifact.SCANNERLESS_PARSER), EArtifact.PACKAGE_MOPP, context.getClassName(EArtifact.SCANNERLESS_PARSER), OptionTypes.OVERRIDE_PARSER));
	    }
	    creators.add(new PluginXMLCreator());
	    creators.add(new DefaultLoadOptionsExtensionPointSchemaCreator());
	    creators.add(new GenericArtifactCreator(EArtifact.RESOURCE));
	    creators.add(new GenericArtifactCreator(EArtifact.RESOURCE_FACTORY));
	    if (!syntax.getName().contains(".")) {
		    creators.add(new AdditionalExtensionParserExtensionPointSchemaCreator());
		    creators.add(new GenericArtifactCreator(EArtifact.RESOURCE_FACTORY_DELEGATOR));
	    }
	    creators.add(new PrinterCreator());
	    creators.add(new ReferenceResolversCreator());
	    creators.add(new GenericArtifactCreator(EArtifact.REFERENCE_RESOLVER_SWITCH));
	    creators.add(new GenericArtifactCreator(EArtifact.NEW_FILE_WIZARD));
	    creators.add(new GenericArtifactCreator(EArtifact.NEW_FILE_WIZARD_PAGE));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("default_new_icon.gif"), context.getNewIconFile()));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("default_editor_icon.gif"), context.getEditorIconFile()));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("hover_style.css"), context.getHoverStyleFile()));
	    creators.add(new TokenResolversCreator());
	    creators.add(new GenericArtifactCreator(EArtifact.TOKEN_RESOLVER_FACTORY));
	    creators.add(new MetaInfFolderCreator());
	    creators.add(new ResourcePluginManifestCreator());
	    creators.add(new GenericArtifactCreator(EArtifact.META_INFORMATION));
	    creators.add(new GenericArtifactCreator(EArtifact.TOKEN_STYLE_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.FOLDING_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.BRACKET_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.SYNTAX_COVERAGE_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.DEFAULT_RESOLVER_DELEGATE));
	    creators.add(new GenericArtifactCreator(EArtifact.PROBLEM));
	    creators.add(new GenericArtifactCreator(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT));
	    creators.add(new GenericArtifactCreator(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
	    creators.add(new GenericArtifactCreator(EArtifact.DELEGATING_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.DUMMY_E_OBJECT));
	    creators.add(new GenericArtifactCreator(EArtifact.ELEMENT_MAPPING));
	    creators.add(new GenericArtifactCreator(EArtifact.FUZZY_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.LOCATION_MAP));
	    creators.add(new GenericArtifactCreator(EArtifact.DEFAULT_TOKEN_RESOLVER));
	    creators.add(new GenericArtifactCreator(EArtifact.REFERENCE_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.TOKEN_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.URI_MAPPING));
	    creators.add(new GenericArtifactCreator(EArtifact.HOVER_TEXT_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.PARSE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.PLUGIN_ACTIVATOR));
	    creators.add(new GenericArtifactCreator(EArtifact.TERMINATE_PARSING_EXCEPTION));
	    creators.add(new GenericArtifactCreator(EArtifact.UNEXPECTED_CONTENT_TYPE_EXCEPTION));
	    
	    // add UI generators
	    creators.add(new GenericArtifactCreator(EArtifact.ANTLR_TOKEN_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.BRACKET_SET));
	    creators.add(new GenericArtifactCreator(EArtifact.BROWER_INFORMATION_CONTROL));
	    creators.add(new GenericArtifactCreator(EArtifact.CODE_FOLDING_MANAGER));
	    creators.add(new GenericArtifactCreator(EArtifact.COLOR_MANAGER));
	    creators.add(new GenericArtifactCreator(EArtifact.COMPLETION_PROCESSOR));
	    creators.add(new GenericArtifactCreator(EArtifact.BACKGROUND_PARSING_STRATEGY));
	    creators.add(new GenericArtifactCreator(EArtifact.DOC_BROWSER_INFORMATION_CONTROL_INPUT));
	    creators.add(new GenericArtifactCreator(EArtifact.EDITOR_CONFIGURATION));
	    creators.add(new GenericArtifactCreator(EArtifact.EDITOR));
	    creators.add(new GenericArtifactCreator(EArtifact.E_OBJECT_SELECTION));
	    creators.add(new GenericArtifactCreator(EArtifact.HIGHLIGHTING));
	    creators.add(new GenericArtifactCreator(EArtifact.HTML_PRINTER));
	    creators.add(new GenericArtifactCreator(EArtifact.HYPERLINK));
	    creators.add(new GenericArtifactCreator(EArtifact.HYPERLINK_DETECTOR));
	    creators.add(new GenericArtifactCreator(EArtifact.MARKER_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.OCCURENCE));
	    creators.add(new GenericArtifactCreator(EArtifact.OUTLINE_PAGE));
	    creators.add(new GenericArtifactCreator(EArtifact.OUTLINE_PAGE_TREE_VIEWER));
	    creators.add(new GenericArtifactCreator(EArtifact.POSITION_CATEGORY));
	    creators.add(new GenericArtifactCreator(EArtifact.POSITION_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.PROPERTY_SHEET_PAGE));
	    creators.add(new GenericArtifactCreator(EArtifact.TEXT_HOVER));
	    creators.add(new GenericArtifactCreator(EArtifact.TOKEN_SCANNER));
	    creators.add(new GenericArtifactCreator(EArtifact.TEXT_TOKEN));
	    
	    creators.add(new GenericArtifactCreator(EArtifact.PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator(EArtifact.BRACKET_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator(EArtifact.PREFERENCE_CONSTANTS));
	    creators.add(new GenericArtifactCreator(EArtifact.OCCURRENCE_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator(EArtifact.PIXEL_CONVERTER));
	    creators.add(new GenericArtifactCreator(EArtifact.PREFERENCE_INITIALIZER));
	    creators.add(new GenericArtifactCreator(EArtifact.SYNTAX_COLORING_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.SYNTAX_COLORING_PREFERENCE_PAGE));
	    
	    creators.add(new GenericArtifactCreator(EArtifact.I_INPUT_STREAM_PROCESSOR_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.INPUT_STREAM_PROCESSOR));
	    creators.add(new GenericArtifactCreator(EArtifact.I_OPTION_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.I_OPTIONS));
	    creators.add(new GenericArtifactCreator(EArtifact.I_RESOURCE_POST_PROCESSOR));
	    creators.add(new GenericArtifactCreator(EArtifact.I_RESOURCE_POST_PROCESSOR_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.I_BRACKET_PAIR));
	    creators.add(new GenericArtifactCreator(EArtifact.I_COMMAND));
	    creators.add(new GenericArtifactCreator(EArtifact.I_CONFIGURABLE));
	    creators.add(new GenericArtifactCreator(EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT));
	    creators.add(new GenericArtifactCreator(EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
	    creators.add(new GenericArtifactCreator(EArtifact.I_ELEMENT_MAPPING));
	    creators.add(new GenericArtifactCreator(EArtifact.I_EXPECTED_ELEMENT));
	    creators.add(new GenericArtifactCreator(EArtifact.I_HOVER_TEXT_PROVIDER));
	    creators.add(new GenericArtifactCreator(EArtifact.I_LOCATION_MAP));
	    creators.add(new GenericArtifactCreator(EArtifact.I_PARSE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.I_PROBLEM));
	    creators.add(new GenericArtifactCreator(EArtifact.I_REFERENCE_MAPPING));
	    creators.add(new GenericArtifactCreator(EArtifact.I_REFERENCE_RESOLVER));
	    creators.add(new GenericArtifactCreator(EArtifact.I_REFERENCE_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.I_REFERENCE_RESOLVER_SWITCH));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TEXT_DIAGNOSTIC));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TEXT_PARSER));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TEXT_PRINTER));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TEXT_RESOURCE));
	    creators.add(new GenericArtifactCreator(EArtifact.I_META_INFORMATION));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TEXT_RESOURCE_PLUGIN_PART));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TEXT_SCANNER));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TEXT_TOKEN));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TOKEN_RESOLVER));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TOKEN_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TOKEN_RESOLVER_FACTORY));
	    creators.add(new GenericArtifactCreator(EArtifact.I_TOKEN_STYLE));
	    creators.add(new GenericArtifactCreator(EArtifact.IURI_MAPPING));
	    creators.add(new GenericArtifactCreator(EArtifact.I_BACKGROUND_PARSING_LISTENER));
	    creators.add(new GenericArtifactCreator(EArtifact.E_PROBLEM_TYPE));

	    creators.add(new GenericArtifactCreator(EArtifact.CODE_COMPLETION_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.ABSTRACT_EXPECTED_ELEMENT));
	    creators.add(new GenericArtifactCreator(EArtifact.EXPECTED_CS_STRING));
	    creators.add(new GenericArtifactCreator(EArtifact.EXPECTED_STRUCTURAL_FEATURE));

	    creators.add(new GenericArtifactCreator(EArtifact.CAST_UTIL));
	    creators.add(new GenericArtifactCreator(EArtifact.COPIED_E_LIST));
	    creators.add(new GenericArtifactCreator(EArtifact.COPIED_E_OBJECT_INTERNAL_E_LIST));
	    creators.add(new GenericArtifactCreator(EArtifact.E_CLASS_UTIL));
	    creators.add(new GenericArtifactCreator(EArtifact.E_OBJECT_UTIL));
	    creators.add(new GenericArtifactCreator(EArtifact.LIST_UTIL));
	    creators.add(new GenericArtifactCreator(EArtifact.MAP_UTIL));
	    creators.add(new GenericArtifactCreator(EArtifact.MINIMAL_MODEL_HELPER));
	    creators.add(new GenericArtifactCreator(EArtifact.RESOURCE_UTIL));
	    creators.add(new GenericArtifactCreator(EArtifact.STREAM_UTIL));
	    creators.add(new GenericArtifactCreator(EArtifact.STRING_UTIL));
	    creators.add(new GenericArtifactCreator(EArtifact.TEXT_RESOURCE_UTIL));
	    creators.add(new GenericArtifactCreator(EArtifact.UNICODE_CONVERTER));

	    for (IArtifactCreator creator : creators) {
			progress.setTaskName("creating " + creator.getArtifactDescription() + "...");
			creator.createArtifacts(context);
		    progress.worked(100 / creators.size());
	    }
	}
}
