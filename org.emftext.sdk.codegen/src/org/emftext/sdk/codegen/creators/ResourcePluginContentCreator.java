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
import org.emftext.sdk.codegen.TextResourceArtifacts;
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
	    	creators.add(new GenericArtifactCreator(TextResourceArtifacts.SCANNERLESS_SCANNER));
	    	creators.add(new GenericArtifactCreator(TextResourceArtifacts.SCANNERLESS_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_SCANNER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_LEXER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_LEXER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_PARSER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_PARSER), OptionTypes.OVERRIDE_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_PARSER_BASE), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_PARSER_BASE), OptionTypes.OVERRIDE_PARSER));
	    } else {
	    	creators.add(new GenericArtifactCreator(TextResourceArtifacts.ANTLR_SCANNER));
		    creators.add(new ANTLRGrammarCreator());
		    creators.add(new ANTLRParserCreator());
		    creators.add(new GenericArtifactCreator(TextResourceArtifacts.ANTLR_PARSER_BASE));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.SCANNERLESS_SCANNER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.SCANNERLESS_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.SCANNERLESS_PARSER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.SCANNERLESS_PARSER), OptionTypes.OVERRIDE_PARSER));
	    }
	    creators.add(new PluginXMLCreator());
	    creators.add(new DefaultLoadOptionsExtensionPointSchemaCreator());
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.RESOURCE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.RESOURCE_FACTORY));
	    if (!syntax.getName().contains(".")) {
		    creators.add(new AdditionalExtensionParserExtensionPointSchemaCreator());
		    creators.add(new GenericArtifactCreator(TextResourceArtifacts.RESOURCE_FACTORY_DELEGATOR));
	    }
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PRINTER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PRINTER2));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.LAYOUT_INFORMATION));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.LAYOUT_INFORMATION_ADAPTER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.SYNTAX_ELEMENT_DECORATOR));
	    creators.add(new ReferenceResolversCreator());
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.REFERENCE_RESOLVER_SWITCH));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.NEW_FILE_WIZARD));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.NEW_FILE_WIZARD_PAGE));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("default_new_icon.gif"), context.getNewIconFile()));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("default_editor_icon.gif"), context.getEditorIconFile()));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("hover_style.css"), context.getHoverStyleFile()));
	    creators.add(new TokenResolversCreator());
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.TOKEN_RESOLVER_FACTORY));
	    creators.add(new MetaInfFolderCreator());
	    creators.add(new ResourcePluginManifestCreator());
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.META_INFORMATION));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.TOKEN_STYLE_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.FOLDING_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.BRACKET_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.SYNTAX_COVERAGE_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.DEFAULT_RESOLVER_DELEGATE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PROBLEM));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.DELEGATING_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.DUMMY_E_OBJECT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.ELEMENT_MAPPING));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.FUZZY_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.LOCATION_MAP));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.DEFAULT_TOKEN_RESOLVER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.REFERENCE_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.TOKEN_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.URI_MAPPING));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.HOVER_TEXT_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PARSE_RESULT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PLUGIN_ACTIVATOR));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.TERMINATE_PARSING_EXCEPTION));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.UNEXPECTED_CONTENT_TYPE_EXCEPTION));

	    // add grammar information generators
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.CARDINALITY));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.SYNTAX_ELEMENT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.KEYWORD));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.TERMINAL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PLACEHOLDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.CHOICE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.CONTAINMENT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.COMPOUND));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.SEQUENCE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.LINE_BREAK));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.WHITE_SPACE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.FORMATTING_ELEMENT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.GRAMMAR_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.FOLLOW_SET_PROVIDER));
	    
	    // add UI generators
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.ANTLR_TOKEN_HELPER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.BRACKET_SET));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.BROWSER_INFORMATION_CONTROL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.CODE_FOLDING_MANAGER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.COLOR_MANAGER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.COMPLETION_PROCESSOR));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.BACKGROUND_PARSING_STRATEGY));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.EDITOR_CONFIGURATION));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.EDITOR));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.E_OBJECT_SELECTION));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.HIGHLIGHTING));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.HTML_PRINTER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.HYPERLINK));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.HYPERLINK_DETECTOR));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.MARKER_HELPER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.OCCURENCE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.OUTLINE_PAGE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.OUTLINE_PAGE_TREE_VIEWER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.POSITION_CATEGORY));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.POSITION_HELPER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PROPERTY_SHEET_PAGE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.TEXT_HOVER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.TOKEN_SCANNER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.TEXT_TOKEN));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.DEFAULT_HOVER_TEXT_PROVIDER));
	    
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.BRACKET_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PREFERENCE_CONSTANTS));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.OCCURRENCE_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PIXEL_CONVERTER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PREFERENCE_INITIALIZER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.SYNTAX_COLORING_HELPER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE));
	    
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_INPUT_STREAM_PROCESSOR_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.INPUT_STREAM_PROCESSOR));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_OPTION_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_OPTIONS));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_BRACKET_PAIR));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_COMMAND));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_CONFIGURABLE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_ELEMENT_MAPPING));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_EXPECTED_ELEMENT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_HOVER_TEXT_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_LOCATION_MAP));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_PARSE_RESULT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_PROBLEM));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_REFERENCE_CACHE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_REFERENCE_MAPPING));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_REFERENCE_RESOLVER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_REFERENCE_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_REFERENCE_RESOLVER_SWITCH));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TEXT_DIAGNOSTIC));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TEXT_PARSER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TEXT_PRINTER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TEXT_RESOURCE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_META_INFORMATION));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TEXT_RESOURCE_PLUGIN_PART));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TEXT_SCANNER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TEXT_TOKEN));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TOKEN_RESOLVER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TOKEN_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TOKEN_RESOLVER_FACTORY));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_TOKEN_STYLE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_URI_MAPPING));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_BACKGROUND_PARSING_LISTENER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.E_PROBLEM_TYPE));

	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.CODE_COMPLETION_HELPER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.ABSTRACT_EXPECTED_ELEMENT));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.EXPECTED_CS_STRING));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.EXPECTED_STRUCTURAL_FEATURE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.EXPECTED_TERMINAL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.COMPLETION_PROPOSAL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.ATTRIBUTE_VALUE_PROVIDER));

	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.CAST_UTIL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.COPIED_E_LIST));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.COPIED_E_OBJECT_INTERNAL_E_LIST));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.E_CLASS_UTIL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.E_OBJECT_UTIL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.LIST_UTIL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.MAP_UTIL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.PAIR));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.MINIMAL_MODEL_HELPER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.RESOURCE_UTIL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.STREAM_UTIL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.STRING_UTIL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.TEXT_RESOURCE_UTIL));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.UNICODE_CONVERTER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.NEW_FILE_CONTENT_PROVIDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.BUILDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.BUILDER_ADAPTER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.I_BUILDER));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.NATURE));
	    creators.add(new GenericArtifactCreator(TextResourceArtifacts.ABSTRACT_INTERPRETER));
	    // TODO implement extension mechanism to allow code generator plug-ins
	    // to add more creators

	    for (IArtifactCreator creator : creators) {
			progress.setTaskName("creating " + creator.getArtifactDescription() + "...");
			creator.createArtifacts(context);
		    progress.worked(100 / creators.size());
	    }
	}
}
