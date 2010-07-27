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
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;
import org.emftext.sdk.codegen.parameters.ManifestParameters;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.ReferenceResolverParameters;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.TokenResolverParameters;
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
	    creators.add(new PluginXMLCreator());
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
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_GRAMMAR));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_MOPP));
		exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_UTIL));
		// do not export the analysis package if the are no resolvers
		if (nameUtil.getResolverFileNames(syntax).size() > 0) {
			exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANALYSIS));
		}
		exports.addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_EXPORTS));
		manifestParameters.getRequiredBundles().addAll(getRequiredBundles(context));
		manifestParameters.setPlugin(resourcePlugin);
		manifestParameters.setActivatorClass(context.getQualifiedClassName(TextResourceArtifacts.PLUGIN_ACTIVATOR));
		manifestParameters.setBundleName("EMFText Parser Plugin: " + context.getConcreteSyntax().getName());
		creators.add(new ManifestCreator<GenerationContext>(manifestParameters, OptionManager.INSTANCE.doOverride(context.getConcreteSyntax(), OptionTypes.OVERRIDE_MANIFEST)));
		
		add(creators, TextResourceArtifacts.META_INFORMATION);
	    add(creators, TextResourceArtifacts.TOKEN_STYLE_INFORMATION_PROVIDER);
	    add(creators, TextResourceArtifacts.FOLDING_INFORMATION_PROVIDER);
	    add(creators, TextResourceArtifacts.BRACKET_INFORMATION_PROVIDER);
	    add(creators, TextResourceArtifacts.SYNTAX_COVERAGE_INFORMATION_PROVIDER);
	    add(creators, TextResourceArtifacts.DEFAULT_RESOLVER_DELEGATE);
	    add(creators, TextResourceArtifacts.PROBLEM);
	    add(creators, TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT);
	    add(creators, TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	    add(creators, TextResourceArtifacts.DELEGATING_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.DUMMY_E_OBJECT);
	    add(creators, TextResourceArtifacts.ELEMENT_MAPPING);
	    add(creators, TextResourceArtifacts.FUZZY_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.LOCATION_MAP);
	    add(creators, TextResourceArtifacts.DEFAULT_TOKEN_RESOLVER);
	    add(creators, TextResourceArtifacts.REFERENCE_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.TOKEN_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.URI_MAPPING);
	    add(creators, TextResourceArtifacts.PARSE_RESULT);
	    add(creators, TextResourceArtifacts.PLUGIN_ACTIVATOR);
	    add(creators, TextResourceArtifacts.TERMINATE_PARSING_EXCEPTION);
	    add(creators, TextResourceArtifacts.UNEXPECTED_CONTENT_TYPE_EXCEPTION);
	    add(creators, TextResourceArtifacts.QUICK_FIX);

	    // add grammar information generators
	    add(creators, TextResourceArtifacts.CARDINALITY);
	    add(creators, TextResourceArtifacts.SYNTAX_ELEMENT);
	    add(creators, TextResourceArtifacts.KEYWORD);
	    add(creators, TextResourceArtifacts.TERMINAL);
	    add(creators, TextResourceArtifacts.PLACEHOLDER);
	    add(creators, TextResourceArtifacts.CHOICE);
	    add(creators, TextResourceArtifacts.CONTAINMENT);
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
	    add(creators, TextResourceArtifacts.I_CONFIGURABLE);
	    add(creators, TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT);
	    add(creators, TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	    add(creators, TextResourceArtifacts.I_ELEMENT_MAPPING);
	    add(creators, TextResourceArtifacts.I_EXPECTED_ELEMENT);
	    add(creators, TextResourceArtifacts.I_HOVER_TEXT_PROVIDER);
	    add(creators, TextResourceArtifacts.I_LOCATION_MAP);
	    add(creators, TextResourceArtifacts.I_PARSE_RESULT);
	    add(creators, TextResourceArtifacts.I_PROBLEM);
	    add(creators, TextResourceArtifacts.I_REFERENCE_CACHE);
	    add(creators, TextResourceArtifacts.I_REFERENCE_MAPPING);
	    add(creators, TextResourceArtifacts.I_REFERENCE_RESOLVER);
	    add(creators, TextResourceArtifacts.I_REFERENCE_RESOLVE_RESULT);
	    add(creators, TextResourceArtifacts.I_REFERENCE_RESOLVER_SWITCH);
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
	    add(creators, TextResourceArtifacts.E_PROBLEM_TYPE);

	    add(creators, TextResourceArtifacts.ABSTRACT_EXPECTED_ELEMENT);
	    add(creators, TextResourceArtifacts.EXPECTED_CS_STRING);
	    add(creators, TextResourceArtifacts.EXPECTED_STRUCTURAL_FEATURE);
	    add(creators, TextResourceArtifacts.EXPECTED_TERMINAL);
	    add(creators, TextResourceArtifacts.ATTRIBUTE_VALUE_PROVIDER);

	    add(creators, TextResourceArtifacts.CAST_UTIL);
	    add(creators, TextResourceArtifacts.COPIED_E_LIST);
	    add(creators, TextResourceArtifacts.COPIED_E_OBJECT_INTERNAL_E_LIST);
	    add(creators, TextResourceArtifacts.E_CLASS_UTIL);
	    add(creators, TextResourceArtifacts.E_OBJECT_UTIL);
	    add(creators, TextResourceArtifacts.LIST_UTIL);
	    add(creators, TextResourceArtifacts.MAP_UTIL);
	    add(creators, TextResourceArtifacts.PAIR);
	    add(creators, TextResourceArtifacts.MINIMAL_MODEL_HELPER);
	    add(creators, TextResourceArtifacts.RESOURCE_UTIL);
	    add(creators, TextResourceArtifacts.STREAM_UTIL);
	    add(creators, TextResourceArtifacts.STRING_UTIL);
	    add(creators, TextResourceArtifacts.TEXT_RESOURCE_UTIL);
	    add(creators, TextResourceArtifacts.UNICODE_CONVERTER);
	    add(creators, TextResourceArtifacts.NEW_FILE_CONTENT_PROVIDER);
	    add(creators, TextResourceArtifacts.BUILDER);
	    add(creators, TextResourceArtifacts.BUILDER_ADAPTER);
	    add(creators, TextResourceArtifacts.I_BUILDER);
	    add(creators, TextResourceArtifacts.NATURE);
	    add(creators, TextResourceArtifacts.ABSTRACT_INTERPRETER);
	    
	    add(creators, TextResourceArtifacts.TEXT_TOKEN);
		return creators;
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
		
		Set<String> imports = new LinkedHashSet<String>();
		imports.add("org.eclipse.core.resources");
		imports.add("org.eclipse.emf");
		imports.add("org.eclipse.emf.codegen.ecore");
		imports.add("org.eclipse.emf.ecore");
		imports.add("org.eclipse.emf.ecore.edit");
		imports.add("org.eclipse.emf.validation");
		imports.add("org.eclipse.emf.workspace");
		imports.add("org.emftext.access;resolution:=optional");
		
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
