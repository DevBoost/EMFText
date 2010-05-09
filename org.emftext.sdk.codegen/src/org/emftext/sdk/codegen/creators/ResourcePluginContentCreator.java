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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.codegen.ClassPathParameters;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.ManifestParameters;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.TextResourcePlugins;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A creator that uses multiple other creators to create
 * a resource plug-in from a CS specification and a meta 
 * model.
 */
public class ResourcePluginContentCreator extends AbstractPluginCreator<Object> {
	
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	
	public String getPluginName() {
		return "resource";
	}

	public List<IArtifactCreator<GenerationContext>> getCreators(GenerationContext context) {
		ConcreteSyntax syntax = context.getConcreteSyntax();

		List<IArtifactCreator<GenerationContext>> creators = new ArrayList<IArtifactCreator<GenerationContext>>();
	    creators.add(new FoldersCreator<GenerationContext>(new File[] {
	    		context.getSourceFolder(TextResourcePlugins.RESOURCE_PLUGIN, false),
	    		context.getSourceFolder(TextResourcePlugins.RESOURCE_PLUGIN, true),
	    		context.getSchemaFolder(),
	    		context.getCSSDir()
	    }));
	    ClassPathParameters<GenerationContext> cpp = new ClassPathParameters<GenerationContext>(TextResourcePlugins.RESOURCE_PLUGIN);
		String sourceFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.SOURCE_FOLDER);
		String sourceGenFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.SOURCE_GEN_FOLDER);
		
		cpp.getSourceFolders().add(sourceFolderName);
		// only the resource plug-in has a 'src-gen' folder
		cpp.getSourceFolders().add(sourceGenFolderName);
	    creators.add(new DotClasspathCreator<GenerationContext>(cpp));
	    creators.add(new DotProjectCreator<GenerationContext>(TextResourcePlugins.RESOURCE_PLUGIN));
	    creators.add(new BuildPropertiesCreator(TextResourcePlugins.RESOURCE_PLUGIN));
	    if (OptionManager.INSTANCE.useScalesParser(syntax)) {
	    	creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.SCANNERLESS_SCANNER));
	    	creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.SCANNERLESS_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_SCANNER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_LEXER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_LEXER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_PARSER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_PARSER), OptionTypes.OVERRIDE_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.ANTLR_PARSER_BASE), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_PARSER_BASE), OptionTypes.OVERRIDE_PARSER));
	    } else {
	    	creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.ANTLR_SCANNER));
		    creators.add(new ANTLRGrammarCreator());
		    creators.add(new ANTLRParserCreator());
		    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.ANTLR_PARSER_BASE));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.SCANNERLESS_SCANNER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.SCANNERLESS_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(TextResourceArtifacts.SCANNERLESS_PARSER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.SCANNERLESS_PARSER), OptionTypes.OVERRIDE_PARSER));
	    }
	    creators.add(new PluginXMLCreator());
	    creators.add(new DefaultLoadOptionsExtensionPointSchemaCreator());
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.RESOURCE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.RESOURCE_FACTORY));
	    if (!syntax.getName().contains(".")) {
		    creators.add(new AdditionalExtensionParserExtensionPointSchemaCreator());
		    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.RESOURCE_FACTORY_DELEGATOR));
	    }
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PRINTER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PRINTER2));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.LAYOUT_INFORMATION));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.LAYOUT_INFORMATION_ADAPTER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.SYNTAX_ELEMENT_DECORATOR));
	    creators.add(new ReferenceResolversCreator());
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.REFERENCE_RESOLVER_SWITCH));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.NEW_FILE_WIZARD));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.NEW_FILE_WIZARD_PAGE));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("default_new_icon.gif"), context.getNewIconFile()));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("default_editor_icon.gif"), context.getEditorIconFile()));
	    creators.add(new FileCopier(FileCopier.class.getResourceAsStream("hover_style.css"), context.getHoverStyleFile()));
	    
		for (CompleteTokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (tokenDefinition.isUsed()) {
			    creators.add(new TokenResolversCreator(tokenDefinition));
			}
		}
	    
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.TOKEN_RESOLVER_FACTORY));
	    creators.add(new MetaInfFolderCreator());

	    ManifestParameters<GenerationContext> manifestParameters = new ManifestParameters<GenerationContext>();
	    Collection<String> exports = manifestParameters.getExportedPackages();
		// export the generated packages
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ROOT));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_CC));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_MOPP));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_UI));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_UTIL));
		// do not export the analysis package if the are no resolvers
		if (csUtil.getResolverFileNames(syntax).size() > 0) {
			exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANALYSIS));
		}
		exports.addAll(getAdditionalPackages(syntax, OptionTypes.ADDITIONAL_EXPORTS));
		manifestParameters.getRequiredBundles().addAll(getRequiredBundles(context));
		manifestParameters.setPlugin(TextResourcePlugins.RESOURCE_PLUGIN);
		manifestParameters.setActivatorClass(context.getQualifiedClassName(TextResourceArtifacts.PLUGIN_ACTIVATOR));
		manifestParameters.setBundleName("EMFText Parser Plugin: " + context.getConcreteSyntax().getName());
		creators.add(new ResourcePluginManifestCreator(manifestParameters));
		
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.META_INFORMATION));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.TOKEN_STYLE_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.FOLDING_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.BRACKET_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.SYNTAX_COVERAGE_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.DEFAULT_RESOLVER_DELEGATE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PROBLEM));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.DELEGATING_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.DUMMY_E_OBJECT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.ELEMENT_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.FUZZY_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.LOCATION_MAP));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.DEFAULT_TOKEN_RESOLVER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.REFERENCE_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.TOKEN_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.URI_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.HOVER_TEXT_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PARSE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PLUGIN_ACTIVATOR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.TERMINATE_PARSING_EXCEPTION));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.UNEXPECTED_CONTENT_TYPE_EXCEPTION));

	    // add grammar information generators
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.CARDINALITY));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.SYNTAX_ELEMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.KEYWORD));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.TERMINAL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PLACEHOLDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.CHOICE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.CONTAINMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.COMPOUND));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.SEQUENCE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.LINE_BREAK));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.WHITE_SPACE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.FORMATTING_ELEMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.GRAMMAR_INFORMATION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.FOLLOW_SET_PROVIDER));
	    
	    // add UI generators
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.ANTLR_TOKEN_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.BRACKET_SET));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.BROWSER_INFORMATION_CONTROL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.CODE_FOLDING_MANAGER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.COLOR_MANAGER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.COMPLETION_PROCESSOR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.BACKGROUND_PARSING_STRATEGY));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.EDITOR_CONFIGURATION));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.EDITOR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.E_OBJECT_SELECTION));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.HIGHLIGHTING));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.HTML_PRINTER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.HYPERLINK));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.HYPERLINK_DETECTOR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.MARKER_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.OCCURENCE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.OUTLINE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.OUTLINE_PAGE_TREE_VIEWER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.POSITION_CATEGORY));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.POSITION_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PROPERTY_SHEET_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.TEXT_HOVER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.TOKEN_SCANNER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.TEXT_TOKEN));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.DEFAULT_HOVER_TEXT_PROVIDER));
	    
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.BRACKET_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PREFERENCE_CONSTANTS));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.OCCURRENCE_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PIXEL_CONVERTER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PREFERENCE_INITIALIZER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.SYNTAX_COLORING_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE));
	    
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_INPUT_STREAM_PROCESSOR_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.INPUT_STREAM_PROCESSOR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_OPTION_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_OPTIONS));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_BRACKET_PAIR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_COMMAND));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_CONFIGURABLE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_ELEMENT_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_EXPECTED_ELEMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_HOVER_TEXT_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_LOCATION_MAP));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_PARSE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_PROBLEM));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_REFERENCE_CACHE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_REFERENCE_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_REFERENCE_RESOLVER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_REFERENCE_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_REFERENCE_RESOLVER_SWITCH));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TEXT_DIAGNOSTIC));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TEXT_PARSER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TEXT_PRINTER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TEXT_RESOURCE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_META_INFORMATION));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TEXT_RESOURCE_PLUGIN_PART));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TEXT_SCANNER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TEXT_TOKEN));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TOKEN_RESOLVER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TOKEN_RESOLVE_RESULT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TOKEN_RESOLVER_FACTORY));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_TOKEN_STYLE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_URI_MAPPING));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_BACKGROUND_PARSING_LISTENER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.E_PROBLEM_TYPE));

	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.CODE_COMPLETION_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.ABSTRACT_EXPECTED_ELEMENT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.EXPECTED_CS_STRING));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.EXPECTED_STRUCTURAL_FEATURE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.EXPECTED_TERMINAL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.COMPLETION_PROPOSAL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.ATTRIBUTE_VALUE_PROVIDER));

	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.CAST_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.COPIED_E_LIST));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.COPIED_E_OBJECT_INTERNAL_E_LIST));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.E_CLASS_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.E_OBJECT_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.LIST_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.MAP_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.PAIR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.MINIMAL_MODEL_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.RESOURCE_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.STREAM_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.STRING_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.TEXT_RESOURCE_UTIL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.UNICODE_CONVERTER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.NEW_FILE_CONTENT_PROVIDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.BUILDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.BUILDER_ADAPTER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.I_BUILDER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.NATURE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceArtifacts.ABSTRACT_INTERPRETER));
		return creators;
	}

	private Collection<String> getAdditionalPackages(ConcreteSyntax syntax, OptionTypes option) {
		String additionalPackagesString = 
			OptionManager.INSTANCE.getStringOptionValue(syntax, option);
		if (additionalPackagesString != null) {
			String[] additionalPackages = additionalPackagesString.split(",");
			return Arrays.asList(additionalPackages);
		} else {
			return Collections.emptySet();
		}
	}

	private Collection<String> getRequiredBundles(GenerationContext context) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		
		Set<String> imports = new LinkedHashSet<String>();
		imports.add("org.eclipse.core.resources");
		imports.add("org.emftext.access;resolution:=optional");
		imports.add("org.eclipse.emf");
		imports.add("org.eclipse.emf.codegen.ecore");
		imports.add("org.eclipse.emf.ecore");
		imports.add("org.eclipse.emf.ecore.edit");
		imports.add("org.eclipse.emf.edit.ui");
		imports.add("org.eclipse.emf.workspace");
		imports.add("org.eclipse.jface");
		imports.add("org.eclipse.jface.text");
		imports.add("org.eclipse.ui");
		imports.add("org.eclipse.ui.editors");
		imports.add("org.eclipse.ui.ide");
		imports.add("org.eclipse.ui.views");
		// TODO implement extension mechanism to allow code generation plug-ins to add
		// more imports here 

		String qualifiedBasePluginName = 
			OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.BASE_RESOURCE_PLUGIN);
		if (qualifiedBasePluginName != null) {
			imports.add(qualifiedBasePluginName);
		}
		
		imports.addAll(getAdditionalPackages(syntax, OptionTypes.ADDITIONAL_DEPENDENCIES));

		if (context.isGenerateTestActionEnabled()) {
			imports.add("org.emftext.sdk.ui");
		}

		addImports(context, imports, syntax);
		
		// remove the current plug-in, because we do not
		// need to import it
		imports.remove(TextResourcePlugins.RESOURCE_PLUGIN.getName(context));
		
		return imports;
	}

	private void addImports(GenerationContext context, Collection<String> requiredBundles, ConcreteSyntax syntax) {
		// first add the syntax itself
		String syntaxPluginID = TextResourcePlugins.RESOURCE_PLUGIN.getName(context);
		requiredBundles.add(syntaxPluginID);
		String antlrPluginID = TextResourcePlugins.ANTLR_PLUGIN.getName(context);
		requiredBundles.add(antlrPluginID);
		
		// second add the main generator package
		GenPackage mainPackage = syntax.getPackage();
		addImports(requiredBundles, mainPackage);
		
		// third add imported generator packages and syntaxes recursively
		for (Import nextImport : syntax.getImports()) {
			GenPackage importedPackage = nextImport.getPackage();
			addImports(requiredBundles, importedPackage);

			ConcreteSyntax importedSyntax = nextImport.getConcreteSyntax();
			if (importedSyntax != null) {
				addImports(context, requiredBundles, importedSyntax);
			}
		}
	}

	/**
	 * Adds imports for the given generator package and all used
	 * generator packages.
	 * 
	 * @param requiredBundles
	 * @param genPackage
	 * @return
	 */
	private GenModel addImports(Collection<String> requiredBundles, GenPackage genPackage) {
		// add the package itself
		addImport(requiredBundles, genPackage);
		
		// add used generator packages
		GenModel genModel = genPackage.getGenModel();
		for (GenPackage usedGenPackage : genModel.getUsedGenPackages()) {
			addImport(requiredBundles, usedGenPackage);
		}
		return genModel;
	}

	/**
	 * Adds one import for the given generator package.
	 * 
	 * @param requiredBundles
	 * @param genPackage
	 * @return
	 */
	private void addImport(Collection<String> requiredBundles, GenPackage genPackage) {
		GenModel genModel = genPackage.getGenModel();
		String modelPluginID = genModel.getModelPluginID();
		requiredBundles.add(modelPluginID);
	}
}
