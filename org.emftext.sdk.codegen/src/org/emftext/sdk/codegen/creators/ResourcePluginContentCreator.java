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
import java.util.ArrayList;
import java.util.List;

import org.emftext.sdk.TextResourcePlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A creator that uses multiple other creators to create
 * a resource plug-in from a CS specification and a meta 
 * model.
 */
public class ResourcePluginContentCreator extends AbstractPluginCreator {
	
	public String getPluginName() {
		return "resource";
	}

	public List<IArtifactCreator<GenerationContext>> getCreators(GenerationContext context) {
		ConcreteSyntax syntax = context.getConcreteSyntax();

		List<IArtifactCreator<GenerationContext>> creators = new ArrayList<IArtifactCreator<GenerationContext>>();
	    creators.add(new FoldersCreator(new File[] {
	    		context.getSourceFolder(TextResourcePlugins.RESOURCE_PLUGIN, false),
	    		context.getSourceFolder(TextResourcePlugins.RESOURCE_PLUGIN, true),
	    		context.getSchemaFolder(),
	    		context.getCSSDir()
	    }));
	    creators.add(new DotClasspathCreator(TextResourcePlugins.RESOURCE_PLUGIN));
	    creators.add(new DotProjectCreator(TextResourcePlugins.RESOURCE_PLUGIN));
	    creators.add(new BuildPropertiesCreator(TextResourcePlugins.RESOURCE_PLUGIN));
	    if (OptionManager.INSTANCE.useScalesParser(syntax)) {
	    	creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.SCANNERLESS_SCANNER));
	    	creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.SCANNERLESS_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_SCANNER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_LEXER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_LEXER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_PARSER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_PARSER), OptionTypes.OVERRIDE_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_PARSER_BASE), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_PARSER_BASE), OptionTypes.OVERRIDE_PARSER));
	    } else {
	    	creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.ANTLR_SCANNER));
		    creators.add(new ANTLRGrammarCreator());
		    creators.add(new ANTLRParserCreator());
		    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.ANTLR_PARSER_BASE));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.SCANNERLESS_SCANNER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.SCANNERLESS_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.SCANNERLESS_PARSER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.SCANNERLESS_PARSER), OptionTypes.OVERRIDE_PARSER));
	    }
	    creators.add(new PluginXMLCreator());
	    creators.add(new DefaultLoadOptionsExtensionPointSchemaCreator());
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.RESOURCE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.RESOURCE_FACTORY));
	    if (!syntax.getName().contains(".")) {
		    creators.add(new AdditionalExtensionParserExtensionPointSchemaCreator());
		    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.RESOURCE_FACTORY_DELEGATOR));
	    }
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PRINTER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PRINTER2));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.LAYOUT_INFORMATION));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.LAYOUT_INFORMATION_ADAPTER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.SYNTAX_ELEMENT_DECORATOR));
	    creators.add(new ReferenceResolversCreator());
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.REFERENCE_RESOLVER_SWITCH));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.NEW_FILE_WIZARD));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.NEW_FILE_WIZARD_PAGE));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("default_new_icon.gif"), context.getNewIconFile()));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("default_editor_icon.gif"), context.getEditorIconFile()));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("hover_style.css"), context.getHoverStyleFile()));
	    creators.add(new TokenResolversCreator());
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.TOKEN_RESOLVER_FACTORY));
	    creators.add(new MetaInfFolderCreator());
	    creators.add(new ResourcePluginManifestCreator());
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.META_INFORMATION));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.TOKEN_STYLE_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.FOLDING_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.BRACKET_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.SYNTAX_COVERAGE_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.DEFAULT_RESOLVER_DELEGATE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PROBLEM));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.DELEGATING_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.DUMMY_E_OBJECT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.ELEMENT_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.FUZZY_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.LOCATION_MAP));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.DEFAULT_TOKEN_RESOLVER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.REFERENCE_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.TOKEN_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.URI_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.HOVER_TEXT_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PARSE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PLUGIN_ACTIVATOR));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.TERMINATE_PARSING_EXCEPTION));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.UNEXPECTED_CONTENT_TYPE_EXCEPTION));

	    // add grammar information generators
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.CARDINALITY));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.SYNTAX_ELEMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.KEYWORD));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.TERMINAL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PLACEHOLDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.CHOICE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.CONTAINMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.COMPOUND));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.SEQUENCE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.LINE_BREAK));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.WHITE_SPACE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.FORMATTING_ELEMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.GRAMMAR_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.FOLLOW_SET_PROVIDER));
	    
	    // add UI generators
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.ANTLR_TOKEN_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.BRACKET_SET));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.BROWSER_INFORMATION_CONTROL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.CODE_FOLDING_MANAGER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.COLOR_MANAGER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.COMPLETION_PROCESSOR));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.BACKGROUND_PARSING_STRATEGY));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.EDITOR_CONFIGURATION));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.EDITOR));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.E_OBJECT_SELECTION));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.HIGHLIGHTING));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.HTML_PRINTER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.HYPERLINK));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.HYPERLINK_DETECTOR));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.MARKER_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.OCCURENCE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.OUTLINE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.OUTLINE_PAGE_TREE_VIEWER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.POSITION_CATEGORY));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.POSITION_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PROPERTY_SHEET_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.TEXT_HOVER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.TOKEN_SCANNER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.TEXT_TOKEN));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.DEFAULT_HOVER_TEXT_PROVIDER));
	    
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.BRACKET_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PREFERENCE_CONSTANTS));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.OCCURRENCE_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PIXEL_CONVERTER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PREFERENCE_INITIALIZER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.SYNTAX_COLORING_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE));
	    
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_INPUT_STREAM_PROCESSOR_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.INPUT_STREAM_PROCESSOR));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_OPTION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_OPTIONS));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_BRACKET_PAIR));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_COMMAND));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_CONFIGURABLE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_ELEMENT_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_EXPECTED_ELEMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_HOVER_TEXT_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_LOCATION_MAP));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_PARSE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_PROBLEM));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_REFERENCE_CACHE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_REFERENCE_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_REFERENCE_RESOLVER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_REFERENCE_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_REFERENCE_RESOLVER_SWITCH));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TEXT_DIAGNOSTIC));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TEXT_PARSER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TEXT_PRINTER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TEXT_RESOURCE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_META_INFORMATION));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TEXT_RESOURCE_PLUGIN_PART));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TEXT_SCANNER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TEXT_TOKEN));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TOKEN_RESOLVER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TOKEN_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TOKEN_RESOLVER_FACTORY));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_TOKEN_STYLE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_URI_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_BACKGROUND_PARSING_LISTENER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.E_PROBLEM_TYPE));

	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.CODE_COMPLETION_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.ABSTRACT_EXPECTED_ELEMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.EXPECTED_CS_STRING));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.EXPECTED_STRUCTURAL_FEATURE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.EXPECTED_TERMINAL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.COMPLETION_PROPOSAL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.ATTRIBUTE_VALUE_PROVIDER));

	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.CAST_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.COPIED_E_LIST));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.COPIED_E_OBJECT_INTERNAL_E_LIST));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.E_CLASS_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.E_OBJECT_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.LIST_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.MAP_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.PAIR));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.MINIMAL_MODEL_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.RESOURCE_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.STREAM_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.STRING_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.TEXT_RESOURCE_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.UNICODE_CONVERTER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.NEW_FILE_CONTENT_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.BUILDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.BUILDER_ADAPTER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.I_BUILDER));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.NATURE));
	    creators.add(new GenericArtifactCreator<GenerationContext>(TextResourceArtifacts.ABSTRACT_INTERPRETER));
		return creators;
	}
}
