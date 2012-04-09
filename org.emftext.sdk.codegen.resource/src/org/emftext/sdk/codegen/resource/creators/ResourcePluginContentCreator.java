/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.FoldersCreator;
import org.emftext.sdk.codegen.creators.ManifestCreator;
import org.emftext.sdk.codegen.creators.PluginXMLCreator;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;
import org.emftext.sdk.codegen.parameters.ManifestParameters;
import org.emftext.sdk.codegen.parameters.XMLParameters;
import org.emftext.sdk.codegen.parameters.xml.XMLElement;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.ReferenceResolverParameters;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.TokenResolverParameters;
import org.emftext.sdk.codegen.resource.generators.EProblemTypeGenerator.PROBLEM_TYPES;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * A creator that uses multiple other creators to create
 * a resource plug-in from a CS specification and a meta 
 * model.
 */
public class ResourcePluginContentCreator extends AbstractPluginCreator<Object> {

	private final NameUtil nameUtil = new NameUtil();
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private GeneratorUtil genUtil = new GeneratorUtil();
	
	public String getPluginName() {
		return "resource";
	}

	public List<IArtifactCreator<GenerationContext>> getCreators(GenerationContext context) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		IPluginDescriptor resourcePlugin = context.getResourcePlugin();

		List<IArtifactCreator<GenerationContext>> creators = new ArrayList<IArtifactCreator<GenerationContext>>();
	    creators.add(new FoldersCreator<GenerationContext>(new File[] {
	    		context.getSourceFolder(resourcePlugin, false),
	    		context.getSourceFolder(resourcePlugin, true),
	    		context.getSchemaFolder(resourcePlugin)
	    }));
	    ClassPathParameters<GenerationContext> cpp = new ClassPathParameters<GenerationContext>(TextResourceArtifacts.DOT_CLASSPATH, resourcePlugin);
		String sourceFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.SOURCE_FOLDER);
		String sourceGenFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.SOURCE_GEN_FOLDER);
		
		cpp.getSourceFolders().add(sourceFolderName);
		cpp.getSourceFolders().add(sourceGenFolderName);
		cpp.getAdditionalLibraries().addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_LIBRARIES));
	    creators.add(new DotClasspathCreator<GenerationContext>(cpp, doOverride(syntax, TextResourceArtifacts.DOT_CLASSPATH)));
	    
	    DotProjectParameters<GenerationContext> dpp = new DotProjectParameters<GenerationContext>(TextResourceArtifacts.DOT_PROJECT, resourcePlugin);
	    creators.add(new DotProjectCreator<GenerationContext>(dpp, doOverride(syntax, TextResourceArtifacts.DOT_PROJECT)));
	    
		ArtifactDescriptor<GenerationContext, BuildPropertiesParameters<GenerationContext>> buildProperties = TextResourceArtifacts.BUILD_PROPERTIES;

		BuildPropertiesParameters<GenerationContext> bpp = new BuildPropertiesParameters<GenerationContext>(buildProperties, resourcePlugin);
	    bpp.getSourceFolders().add(sourceFolderName + "/");
		bpp.getSourceFolders().add(sourceGenFolderName + "/");
		bpp.getBinIncludes().add("META-INF/");
		bpp.getBinIncludes().add(".");
		bpp.getBinIncludes().add("plugin.xml");
		bpp.getBinIncludes().addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_LIBRARIES));
		creators.add(new BuildPropertiesCreator<GenerationContext>(bpp, doOverride(syntax, buildProperties)));
		
	    if (OptionManager.INSTANCE.useScalesParser(syntax)) {
	    	creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.SCANNERLESS_SCANNER)));
	    	creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.SCANNERLESS_PARSER)));
	    	creators.add(new EmptyClassCreator(context.getFile(resourcePlugin, TextResourceArtifacts.ANTLR_SCANNER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(resourcePlugin, TextResourceArtifacts.ANTLR_LEXER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_LEXER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(resourcePlugin, TextResourceArtifacts.ANTLR_PARSER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_PARSER), OptionTypes.OVERRIDE_PARSER));
	    	creators.add(new EmptyClassCreator(context.getFile(resourcePlugin, TextResourceArtifacts.ANTLR_PARSER_BASE), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.ANTLR_PARSER_BASE), OptionTypes.OVERRIDE_PARSER));
	    } else {
	    	creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.ANTLR_SCANNER)));
		    creators.add(new ANTLRGrammarCreator());
		    creators.add(new ANTLRParserCreator());
		    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.ANTLR_PARSER_BASE)));
	    	creators.add(new EmptyClassCreator(context.getFile(resourcePlugin, TextResourceArtifacts.SCANNERLESS_SCANNER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.SCANNERLESS_SCANNER), OptionTypes.OVERRIDE_SCANNER));
	    	creators.add(new EmptyClassCreator(context.getFile(resourcePlugin, TextResourceArtifacts.SCANNERLESS_PARSER), TextResourceArtifacts.PACKAGE_MOPP, context.getClassName(TextResourceArtifacts.SCANNERLESS_PARSER), OptionTypes.OVERRIDE_PARSER));
	    }
		ArtifactDescriptor<GenerationContext, XMLParameters<GenerationContext>> pluginXML = TextResourceArtifacts.PLUGIN_XML;
	    creators.add(new PluginXMLCreator<GenerationContext>(getResourcePluginXMLParameters(context), doOverride(syntax, pluginXML)));
	    creators.add(new DefaultLoadOptionsExtensionPointSchemaCreator());
	    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.RESOURCE)));
	    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.RESOURCE_FACTORY)));
	    if (!syntax.getName().contains(".")) {
		    creators.add(new AdditionalExtensionParserExtensionPointSchemaCreator());
		    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.RESOURCE_FACTORY_DELEGATOR)));
	    }
	    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.PRINTER)));
	    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.PRINTER2)));
	    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.LAYOUT_INFORMATION)));
	    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.LAYOUT_INFORMATION_ADAPTER)));
	    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.SYNTAX_ELEMENT_DECORATOR)));

	    for (GenFeature proxyReference : csUtil.getNonContainmentFeaturesNeedingResolver(syntax)) {
			ReferenceResolverParameters rpp = new ReferenceResolverParameters(proxyReference);
		    creators.add(new ReferenceResolverCreator(rpp));
		}

	    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.REFERENCE_RESOLVER_SWITCH)));
	    
		for (CompleteTokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (tokenDefinition.isUsed()) {
			    creators.add(new TokenResolverCreator(new TokenResolverParameters(tokenDefinition)));
			}
		}
	    
	    creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(TextResourceArtifacts.TOKEN_RESOLVER_FACTORY)));

		File project = context.getFileSystemConnector().getProjectFolder(resourcePlugin);
		File metaFolder = new File(project.getAbsolutePath() + File.separator +  "META-INF");
	    creators.add(new FoldersCreator<GenerationContext>(metaFolder));

	    ManifestParameters<GenerationContext> manifestParameters = new ManifestParameters<GenerationContext>(TextResourceArtifacts.MANIFEST);
	    Collection<String> exports = manifestParameters.getExportedPackages();
		// export the generated packages
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ROOT));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANALYSIS));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_CC));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_DEBUG));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_LAUNCH));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_GRAMMAR));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_MOPP));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_UTIL));
		// do not export the analysis package if the are no resolvers
		if (nameUtil.getResolverFileNames(syntax).size() > 0) {
			exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANALYSIS));
		}
		exports.addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_EXPORTS));
		manifestParameters.getRequiredBundles().addAll(getRequiredBundles(context));
		manifestParameters.getImportedPackages().addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_IMPORTED_PACKAGES));
		manifestParameters.getBundleClasspath().addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_LIBRARIES));
		manifestParameters.setPlugin(resourcePlugin);
		manifestParameters.setActivatorClass(context.getQualifiedClassName(TextResourceArtifacts.PLUGIN_ACTIVATOR));
		manifestParameters.setBundleName("EMFText Parser Plugin: " + context.getConcreteSyntax().getName());
		creators.add(new ManifestCreator<GenerationContext>(manifestParameters, OptionManager.INSTANCE.doOverride(context.getConcreteSyntax(), OptionTypes.OVERRIDE_MANIFEST)));
		
		add(creators, TextResourceArtifacts.META_INFORMATION);
	    add(creators, TextResourceArtifacts.TOKEN_STYLE);
	    add(creators, TextResourceArtifacts.TASK_ITEM);
	    add(creators, TextResourceArtifacts.TASK_ITEM_DETECTOR);
	    add(creators, TextResourceArtifacts.TASK_ITEM_BUILDER);
	    add(creators, TextResourceArtifacts.TOKEN_STYLE_INFORMATION_PROVIDER);
	    add(creators, TextResourceArtifacts.DYNAMIC_TOKEN_STYLER);
	    add(creators, TextResourceArtifacts.FOLDING_INFORMATION_PROVIDER);
	    add(creators, TextResourceArtifacts.BRACKET_INFORMATION_PROVIDER);
	    add(creators, TextResourceArtifacts.SYNTAX_COVERAGE_INFORMATION_PROVIDER);
	    add(creators, TextResourceArtifacts.DEFAULT_RESOLVER_DELEGATE);
	    add(creators, TextResourceArtifacts.PROBLEM);
	    add(creators, TextResourceArtifacts.MARKER_HELPER);
	    add(creators, TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT);
	    add(creators, TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	    add(creators, TextResourceArtifacts.DELEGATING_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.DUMMY_E_OBJECT);
	    add(creators, TextResourceArtifacts.ELEMENT_MAPPING);
	    add(creators, TextResourceArtifacts.EXPECTATION_CONSTANTS);
	    add(creators, TextResourceArtifacts.FUZZY_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.LOCATION_MAP);
	    add(creators, TextResourceArtifacts.DEV_NULL_LOCATION_MAP);
	    add(creators, TextResourceArtifacts.DEFAULT_TOKEN_RESOLVER);
	    add(creators, TextResourceArtifacts.REFERENCE_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.DEFAULT_NAME_PROVIDER);
	    add(creators, TextResourceArtifacts.REFERENCE_CACHE);
	    add(creators, TextResourceArtifacts.TOKEN_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.URI_MAPPING);
	    add(creators, TextResourceArtifacts.PARSE_RESULT);
	    add(creators, TextResourceArtifacts.PLUGIN_ACTIVATOR);
	    add(creators, TextResourceArtifacts.TERMINATE_PARSING_EXCEPTION);
	    add(creators, TextResourceArtifacts.UNEXPECTED_CONTENT_TYPE_EXCEPTION);
	    add(creators, TextResourceArtifacts.QUICK_FIX);
	    add(creators, TextResourceArtifacts.CHANGE_REFERENCE_QUICK_FIX);
	    add(creators, TextResourceArtifacts.OPTION_PROVIDER);
	    add(creators, TextResourceArtifacts.CONTAINED_FEATURE);

	    // add grammar information generators
	    add(creators, TextResourceArtifacts.CARDINALITY);
	    add(creators, TextResourceArtifacts.SYNTAX_ELEMENT);
	    add(creators, TextResourceArtifacts.RULE);
	    add(creators, TextResourceArtifacts.KEYWORD);
	    add(creators, TextResourceArtifacts.TERMINAL);
	    add(creators, TextResourceArtifacts.PLACEHOLDER);
	    add(creators, TextResourceArtifacts.BOOLEAN_TERMINAL);
	    add(creators, TextResourceArtifacts.ENUMERATION_TERMINAL);
	    add(creators, TextResourceArtifacts.CHOICE);
	    add(creators, TextResourceArtifacts.CONTAINMENT);
	    add(creators, TextResourceArtifacts.CONTAINMENT_TRACE);
	    add(creators, TextResourceArtifacts.COMPOUND);
	    add(creators, TextResourceArtifacts.SEQUENCE);
	    add(creators, TextResourceArtifacts.LINE_BREAK);
	    add(creators, TextResourceArtifacts.WHITE_SPACE);
	    add(creators, TextResourceArtifacts.FORMATTING_ELEMENT);
	    add(creators, TextResourceArtifacts.GRAMMAR_INFORMATION_PROVIDER);
	    add(creators, TextResourceArtifacts.FOLLOW_SET_PROVIDER);
	    
	    add(creators, TextResourceArtifacts.I_INPUT_STREAM_PROCESSOR_PROVIDER);
	    add(creators, TextResourceArtifacts.INPUT_STREAM_PROCESSOR);
	    add(creators, TextResourceArtifacts.I_OPTION_PROVIDER);
	    add(creators, TextResourceArtifacts.I_OPTIONS);
	    add(creators, TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR);
	    add(creators, TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR_PROVIDER);
	    add(creators, TextResourceArtifacts.I_BRACKET_PAIR);
	    add(creators, TextResourceArtifacts.I_COMMAND);
	    add(creators, TextResourceArtifacts.I_FUNCTION1);
	    add(creators, TextResourceArtifacts.I_CONFIGURABLE);
	    add(creators, TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT);
	    add(creators, TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	    add(creators, TextResourceArtifacts.I_ELEMENT_MAPPING);
	    add(creators, TextResourceArtifacts.I_EXPECTED_ELEMENT);
	    add(creators, TextResourceArtifacts.I_HOVER_TEXT_PROVIDER);
	    add(creators, TextResourceArtifacts.I_LOCATION_MAP);
	    add(creators, TextResourceArtifacts.I_NAME_PROVIDER);
	    add(creators, TextResourceArtifacts.I_PARSE_RESULT);
	    add(creators, TextResourceArtifacts.I_PROBLEM);
	    add(creators, TextResourceArtifacts.I_REFERENCE_CACHE);
	    add(creators, TextResourceArtifacts.I_REFERENCE_MAPPING);
	    add(creators, TextResourceArtifacts.I_REFERENCE_RESOLVER);
	    add(creators, TextResourceArtifacts.I_DELEGATING_REFERENCE_RESOLVER);
	    add(creators, TextResourceArtifacts.I_REFERENCE_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.I_REFERENCE_RESOLVER_SWITCH);
	    add(creators, TextResourceArtifacts.I_RESOURCE_PROVIDER);
	    add(creators, TextResourceArtifacts.I_TEXT_DIAGNOSTIC);
	    add(creators, TextResourceArtifacts.I_TEXT_PARSER);
	    add(creators, TextResourceArtifacts.I_TEXT_PRINTER);
	    add(creators, TextResourceArtifacts.I_TEXT_RESOURCE);
	    add(creators, TextResourceArtifacts.I_META_INFORMATION);
	    add(creators, TextResourceArtifacts.I_TEXT_RESOURCE_PLUGIN_PART);
	    add(creators, TextResourceArtifacts.I_TEXT_SCANNER);
	    add(creators, TextResourceArtifacts.I_TEXT_TOKEN);
	    add(creators, TextResourceArtifacts.I_TOKEN_RESOLVER);
	    add(creators, TextResourceArtifacts.I_TOKEN_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.I_TOKEN_RESOLVER_FACTORY);
	    add(creators, TextResourceArtifacts.I_TOKEN_STYLE);
	    add(creators, TextResourceArtifacts.I_URI_MAPPING);
	    add(creators, TextResourceArtifacts.I_BACKGROUND_PARSING_LISTENER);
	    add(creators, TextResourceArtifacts.I_QUICK_FIX);
	    add(creators, TextResourceArtifacts.E_PROBLEM_SEVERITY);
	    add(creators, TextResourceArtifacts.E_PROBLEM_TYPE);

	    add(creators, TextResourceArtifacts.ABSTRACT_EXPECTED_ELEMENT);
	    add(creators, TextResourceArtifacts.EXPECTED_CS_STRING);
	    add(creators, TextResourceArtifacts.EXPECTED_STRUCTURAL_FEATURE);
	    add(creators, TextResourceArtifacts.EXPECTED_TERMINAL);
	    add(creators, TextResourceArtifacts.EXPECTED_BOOLEAN_TERMINAL);
	    add(creators, TextResourceArtifacts.EXPECTED_ENUMERATION_TERMINAL);
	    add(creators, TextResourceArtifacts.ATTRIBUTE_VALUE_PROVIDER);

	    add(creators, TextResourceArtifacts.CAST_UTIL);
	    add(creators, TextResourceArtifacts.COPIED_E_LIST);
	    add(creators, TextResourceArtifacts.COPIED_E_OBJECT_INTERNAL_E_LIST);
	    add(creators, TextResourceArtifacts.ECLIPSE_PROXY);
	    add(creators, TextResourceArtifacts.E_CLASS_UTIL);
	    add(creators, TextResourceArtifacts.E_OBJECT_UTIL);
	    add(creators, TextResourceArtifacts.LAYOUT_UTIL);
	    add(creators, TextResourceArtifacts.LIST_UTIL);
	    add(creators, TextResourceArtifacts.MAP_UTIL);
	    add(creators, TextResourceArtifacts.PAIR);
	    add(creators, TextResourceArtifacts.MINIMAL_MODEL_HELPER);
	    add(creators, TextResourceArtifacts.RESOURCE_UTIL);
	    add(creators, TextResourceArtifacts.RUNTIME_UTIL);
	    add(creators, TextResourceArtifacts.STREAM_UTIL);
	    add(creators, TextResourceArtifacts.STRING_UTIL);
	    add(creators, TextResourceArtifacts.TEXT_RESOURCE_UTIL);
	    add(creators, TextResourceArtifacts.UNICODE_CONVERTER);
	    add(creators, TextResourceArtifacts.URI_UTIL);
	    add(creators, TextResourceArtifacts.NEW_FILE_CONTENT_PROVIDER);
		add(creators, TextResourceArtifacts.BUILDER);
    	add(creators, TextResourceArtifacts.BUILDER_ADAPTER);
    	add(creators, TextResourceArtifacts.I_BUILDER);
	    add(creators, TextResourceArtifacts.NATURE);
	    add(creators, TextResourceArtifacts.ABSTRACT_INTERPRETER);
	    add(creators, TextResourceArtifacts.RESOURCE_POST_PROCESSOR);
	    
	    add(creators, TextResourceArtifacts.TEXT_TOKEN);
	    add(creators, TextResourceArtifacts.ANTLR_TEXT_TOKEN);
	    add(creators, TextResourceArtifacts.ANTLR_TOKEN_HELPER);

	    add(creators, TextResourceArtifacts.ABSTRACT_DEBUGGABLE);
	    add(creators, TextResourceArtifacts.E_DEBUG_MESSAGE_TYPES);
	    add(creators, TextResourceArtifacts.I_DEBUG_EVENT_LISTENER);
	    add(creators, TextResourceArtifacts.I_INTERPRETER_LISTENER);
	    add(creators, TextResourceArtifacts.DEBUG_COMMUNICATION_HELPER);
	    add(creators, TextResourceArtifacts.DEBUG_ELEMENT);
	    add(creators, TextResourceArtifacts.DEBUGGABLE_INTERPRETER);
	    add(creators, TextResourceArtifacts.DEBUGGER_LISTENER);
	    add(creators, TextResourceArtifacts.DEBUG_MESSAGE);
	    add(creators, TextResourceArtifacts.DEBUG_PROCESS);
	    add(creators, TextResourceArtifacts.DEBUG_PROXY);
	    add(creators, TextResourceArtifacts.DEBUG_TARGET);
	    add(creators, TextResourceArtifacts.DEBUG_THREAD);
	    add(creators, TextResourceArtifacts.DEBUG_VALUE);
	    add(creators, TextResourceArtifacts.DEBUG_VARIABLE);
	    add(creators, TextResourceArtifacts.LINEBREAK_POINT);
	    add(creators, TextResourceArtifacts.SOURCE_LOCATOR);
	    add(creators, TextResourceArtifacts.SOURCE_LOOKUP_PARTICIPANT);
	    add(creators, TextResourceArtifacts.SOURCE_PATH_COMPUTER_DELEGATE);
	    add(creators, TextResourceArtifacts.STACK_FRAME);
	    
	    add(creators, TextResourceArtifacts.LAUNCH_CONFIGURATION_DELEGATE);
	    add(creators, TextResourceArtifacts.LAUNCH_CONFIGURATION_HELPER);
		return creators;
	}

	private XMLParameters<GenerationContext> getResourcePluginXMLParameters(GenerationContext context) {
		final IPluginDescriptor resourcePlugin = context.getResourcePlugin();
		final String pluginID = resourcePlugin.getName();
		final ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		final String builderID = nameUtil.getBuilderID(concreteSyntax);

		final String primaryConcreteSyntaxName = csUtil.getPrimarySyntaxName(concreteSyntax);
		final String secondaryConcreteSyntaxName = csUtil.getSecondarySyntaxName(concreteSyntax);
		final String qualifiedResourceFactoryClassName;
		if (secondaryConcreteSyntaxName == null) {
			qualifiedResourceFactoryClassName = context.getQualifiedClassName(TextResourceArtifacts.RESOURCE_FACTORY_DELEGATOR);
		} else {
			qualifiedResourceFactoryClassName = context.getQualifiedClassName(TextResourceArtifacts.RESOURCE_FACTORY);
		}

		// register the syntax meta information
		final String metaInformationClassName = context.getQualifiedClassName(TextResourceArtifacts.META_INFORMATION);
		final String lineBreakPointClassName = context.getQualifiedClassName(TextResourceArtifacts.LINEBREAK_POINT);
		
		XMLElement root = new XMLElement("plugin");
		
		XMLElement accessExtension = root.createChild("extension");
		accessExtension.setAttribute("point", "org.emftext.access.syntax");
		XMLElement informationProvider = accessExtension.createChild("metaInformationProvider");
		informationProvider.setAttribute("class", metaInformationClassName);
		informationProvider.setAttribute("id", metaInformationClassName);
		
		String problemID = pluginID + ".problem";

		XMLElement problemExtension = root.createChild("extension");
		problemExtension.setAttribute("id", problemID);
		problemExtension.setAttribute("name", "EMFText Problem");
		problemExtension.setAttribute("point", "org.eclipse.core.resources.markers");
		
		XMLElement persistent = problemExtension.createChild("persistent");
		persistent.setAttribute("value", "true");
		XMLElement superType1 = problemExtension.createChild("super");
		superType1.setAttribute("type", "org.eclipse.core.resources.problemmarker");
		XMLElement superType2 = problemExtension.createChild("super");
		superType2.setAttribute("type", "org.eclipse.core.resources.textmarker");
		XMLElement superType3 = problemExtension.createChild("super");
		superType3.setAttribute("type", "org.eclipse.emf.ecore.diagnostic");
		
		for (PROBLEM_TYPES nextType : PROBLEM_TYPES.values()) {
			if (nextType == PROBLEM_TYPES.UNKNOWN) {
				continue;
			}
			String nextProblemTypeID = problemID + "." + nextType.name().toLowerCase();
			XMLElement nextProblemExtension = root.createChild("extension");
			nextProblemExtension.setAttribute("id", nextProblemTypeID);
			nextProblemExtension.setAttribute("name", "EMFText Problem");
			nextProblemExtension.setAttribute("point", "org.eclipse.core.resources.markers");
			XMLElement nextPersistent = nextProblemExtension.createChild("persistent");
			nextPersistent.setAttribute("value", "true");
			XMLElement nextSuperType = nextProblemExtension.createChild("super");
			nextSuperType.setAttribute("type", problemID);
		}
		
		XMLElement natureExtension = root.createChild("extension");
		natureExtension.setAttribute("id", nameUtil.getNatureID(concreteSyntax));
		String syntaxName = concreteSyntax.getName();
		natureExtension.setAttribute("name", syntaxName + " nature");
		natureExtension.setAttribute("point", "org.eclipse.core.resources.natures");
		XMLElement runtime = natureExtension.createChild("runtime");
		XMLElement run = runtime.createChild("run");
		run.setAttribute("class", context.getQualifiedClassName(TextResourceArtifacts.NATURE)); 

		XMLElement builder = natureExtension.createChild("builder");
		builder.setAttribute("id", builderID);

		String builderAdapterClassName = context.getQualifiedClassName(TextResourceArtifacts.BUILDER_ADAPTER);
		String builderName = syntaxName + " Builder";
		addBuilder(root, builderID, builderAdapterClassName, builderName);

		XMLElement loadOptionsPoint = root.createChild("extension-point");
		loadOptionsPoint.setAttribute("id", pluginID + ".default_load_options");
		loadOptionsPoint.setAttribute("name", "Default Load Options");
		loadOptionsPoint.setAttribute("schema", "schema/default_load_options.exsd");
		
		String qualifiedBasePluginName = OptionManager.INSTANCE.getStringOptionValue(concreteSyntax, OptionTypes.BASE_RESOURCE_PLUGIN);
		if (secondaryConcreteSyntaxName == null) {
			// register the generated resource factory
			XMLElement parserExtension = root.createChild("extension");
			parserExtension.setAttribute("point", "org.eclipse.emf.ecore.extension_parser");
			XMLElement parser = parserExtension.createChild("parser");
			parser.setAttribute("class", qualifiedResourceFactoryClassName);
			parser.setAttribute("type", primaryConcreteSyntaxName);
			
			XMLElement additionalParserPoint = root.createChild("extension-point");
			additionalParserPoint.setAttribute("id", pluginID + ".additional_extension_parser");
			additionalParserPoint.setAttribute("name", "Additional Extension Parser");
			additionalParserPoint.setAttribute("schema", "schema/additional_extension_parser.exsd");
		}
		else if (qualifiedBasePluginName != null) {
			XMLElement additionalParserExtension = root.createChild("extension");
			additionalParserExtension.setAttribute("point", qualifiedBasePluginName + ".additional_extension_parser");
			XMLElement parser = additionalParserExtension.createChild("parser");
			parser.setAttribute("class", qualifiedResourceFactoryClassName);
			parser.setAttribute("type", secondaryConcreteSyntaxName);
		}
		
		if (context.isDebugSupportEnabled()) {
			String lineBreakPointMarkerID = context.getLineBreakpointMarkerID();
	
			XMLElement breakPointsExtension = root.createChild("extension");
			breakPointsExtension.setAttribute("point", "org.eclipse.debug.core.breakpoints");
			XMLElement breakpoint = breakPointsExtension.createChild("breakpoint");
			breakpoint.setAttribute("class", lineBreakPointClassName);
			breakpoint.setAttribute("id", pluginID + ".debug.breakpoint");
			breakpoint.setAttribute("markerType", lineBreakPointMarkerID);
			breakpoint.setAttribute("name", syntaxName + " Breakpoint");
	
			XMLElement breakPointMarkerExtension = root.createChild("extension");
			breakPointMarkerExtension.setAttribute("id", lineBreakPointMarkerID);
			breakPointMarkerExtension.setAttribute("point", "org.eclipse.core.resources.markers");
			XMLElement super1 = breakPointMarkerExtension.createChild("super");
			super1.setAttribute("type", "org.eclipse.debug.core.lineBreakpointMarker");
			XMLElement super2 = breakPointMarkerExtension.createChild("super");
			super2.setAttribute("type", "org.eclipse.core.resources.textmarker");
			XMLElement persistentMarker = breakPointMarkerExtension.createChild("persistent");
			persistentMarker.setAttribute("value", "true");
		}

		if (context.isLaunchSupportEnabled()) {
			root.addChild(generateLaunchConfigurationTypeExtension(context));
			if (context.isDebugSupportEnabled()) {
				root.addChild(generateSourcePathComputersExtension(context));
				root.addChild(generateSourceLocatorsExtension(context));
			}
		}
		XMLParameters<GenerationContext> parameters = new XMLParameters<GenerationContext>(TextResourceArtifacts.PLUGIN_XML, resourcePlugin, root);
		return parameters;
	}

	private void addBuilder(XMLElement root, String builderID,
			String builderClassName, String builderName) {
		XMLElement builderExtension = root.createChild("extension");
		builderExtension.setAttribute("point", "org.eclipse.core.resources.builders");
		builderExtension.setAttribute("id" , builderID);
		builderExtension.setAttribute("name" , builderName);
		XMLElement builder = builderExtension.createChild("builder");
		builder.setAttribute("hasNature", "true");
		XMLElement builderRun = builder.createChild("run");
		builderRun.setAttribute("class", builderClassName);
	}

	private XMLElement generateLaunchConfigurationTypeExtension(GenerationContext context) {
		final ConcreteSyntax concreteSyntax = context.getConcreteSyntax();
		final String concreteSyntaxName = concreteSyntax.getName();
		final String launchConfigurationDelegateClassName = context.getQualifiedClassName(TextResourceArtifacts.LAUNCH_CONFIGURATION_DELEGATE);
		final String launchConfigurationID = context.getLaunchConfigurationTypeID();
		final String sourceLocatorID = context.getSourceLocatorID();
		final String sourcePathComputerId = context.getSourcePathComputerID();

		XMLElement launchTypeExtension = new XMLElement("extension");
		launchTypeExtension.setAttribute("point", "org.eclipse.debug.core.launchConfigurationTypes");
		
		XMLElement launchConfigurationTypeExtension = launchTypeExtension.createChild("launchConfigurationType");
		launchConfigurationTypeExtension.setAttribute("id", launchConfigurationID);
		launchConfigurationTypeExtension.setAttribute("delegate", launchConfigurationDelegateClassName);
		if (context.isDebugSupportEnabled()) {
			launchConfigurationTypeExtension.setAttribute("modes", "run,debug");
		} else {
			launchConfigurationTypeExtension.setAttribute("modes", "run");
		}
		launchConfigurationTypeExtension.setAttribute("name", concreteSyntaxName + " Application");
		//launchConfigurationTypeExtension.setAttribute("migrationDelegate", "com.example.migrationDelegate");
		if (context.isDebugSupportEnabled()) {
			launchConfigurationTypeExtension.setAttribute("sourceLocatorId", sourceLocatorID);
			launchConfigurationTypeExtension.setAttribute("sourcePathComputerId", sourcePathComputerId);
		}
		launchConfigurationTypeExtension.setAttribute("delegateName", concreteSyntaxName + " Launch Tooling");
		launchConfigurationTypeExtension.setAttribute("delegateDescription", "This will run or debug ." + concreteSyntaxName + " files.");
	
		return launchTypeExtension;
	}

	private XMLElement generateSourcePathComputersExtension(GenerationContext context) {
		final String sourcePathComputerDelegateClassName = context.getQualifiedClassName(TextResourceArtifacts.SOURCE_PATH_COMPUTER_DELEGATE);

		XMLElement extension = new XMLElement("extension");
		extension.setAttribute("point", "org.eclipse.debug.core.sourcePathComputers");
		XMLElement sourcePathComputer = extension.createChild("sourcePathComputer");
		sourcePathComputer.setAttribute("class", sourcePathComputerDelegateClassName);
		sourcePathComputer.setAttribute("id", context.getSourcePathComputerID());
		return extension;
	}

	private XMLElement generateSourceLocatorsExtension(GenerationContext context) {
		final String sourceLocatorClassName = context.getQualifiedClassName(TextResourceArtifacts.SOURCE_LOCATOR);
		
		XMLElement extension = new XMLElement("extension");
		extension.setAttribute("point", "org.eclipse.debug.core.sourceLocators");
		XMLElement sourceLocator = extension.createChild("sourceLocator");
		sourceLocator.setAttribute("id", context.getSourceLocatorID());
		sourceLocator.setAttribute("class", sourceLocatorClassName);
		sourceLocator.setAttribute("name", context.getConcreteSyntax().getName() + " Source Locator");
		return extension;
	}

	private void add(
			List<IArtifactCreator<GenerationContext>> creators,
			ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> artifact) {
		creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(artifact)));
	}

	private boolean doOverride(
			ConcreteSyntax syntax,
			ArtifactDescriptor<GenerationContext, ?> artifact) {
		return OptionManager.INSTANCE.getBooleanOptionValue(syntax, artifact.getOverrideOption());
	}

	private Collection<String> getRequiredBundles(GenerationContext context) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		boolean removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(syntax, OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);
		
		Set<String> imports = new LinkedHashSet<String>();
		if (!removeEclipseDependentCode) {
			//imports.add("org.eclipse.core.resources");
			imports.add("org.eclipse.core.runtime");
		}
		imports.add("org.eclipse.emf");
		imports.add("org.eclipse.emf.ecore");
		imports.add("org.eclipse.emf.ecore.change");
		imports.add("org.eclipse.emf.validation");
		//imports.add("org.eclipse.emf.workspace");
		imports.add("org.emftext.access;resolution:=optional");
		
		if (context.isDebugSupportEnabled()) {
			imports.add("org.eclipse.debug.core");
		}
		// TODO implement extension mechanism to allow code generation plug-ins to add
		// more imports here 

		String qualifiedBasePluginName = 
			OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.BASE_RESOURCE_PLUGIN);
		if (qualifiedBasePluginName != null) {
			imports.add(qualifiedBasePluginName);
		}
		
		imports.addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_DEPENDENCIES));

		genUtil.addImports(context, imports, syntax);
		
		// remove the current plug-in, because we do not
		// need to import it
		imports.remove(context.getResourcePlugin().getName());
		
		return imports;
	}
}
