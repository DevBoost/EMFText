package org.emftext.sdk.codegen.resource.ui.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.BuildPropertiesParameters;
import org.emftext.sdk.codegen.ClassPathParameters;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.ManifestParameters;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.FileCopier;
import org.emftext.sdk.codegen.creators.FoldersCreator;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.creators.AbstractPluginCreator;
import org.emftext.sdk.codegen.resource.creators.ResourcePluginManifestCreator;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ResourceUIPluginContentCreator extends AbstractPluginCreator<Object> {

	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private GeneratorUtil genUtil = new GeneratorUtil();
	
	@Override
	public String getPluginName() {
		return "resource.ui";
	}

	@Override
	public List<IArtifactCreator<GenerationContext>> getCreators(
			GenerationContext context) {
		IPluginDescriptor resourceUIPlugin = context.getResourceUIPlugin();
		List<IArtifactCreator<GenerationContext>> creators = new ArrayList<IArtifactCreator<GenerationContext>>();

	    creators.add(new FoldersCreator<GenerationContext>(new File[] {
	    		context.getSourceFolder(resourceUIPlugin, false),
	    		context.getSourceFolder(resourceUIPlugin, true),
	    		context.getCSSDir()
	    }));

	    ClassPathParameters<GenerationContext> cpp = new ClassPathParameters<GenerationContext>(resourceUIPlugin);
		String sourceFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.SOURCE_FOLDER);
		String sourceGenFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.SOURCE_GEN_FOLDER);
		
		cpp.getSourceFolders().add(sourceFolderName);
		// only the resource plug-in has a 'src-gen' folder
		cpp.getSourceFolders().add(sourceGenFolderName);
	    creators.add(new DotClasspathCreator<GenerationContext>(TextResourceUIArtifacts.DOT_CLASSPATH, cpp));
	    creators.add(new DotProjectCreator<GenerationContext>(TextResourceUIArtifacts.DOT_PROJECT, resourceUIPlugin));

	    BuildPropertiesParameters<GenerationContext> bpp = new BuildPropertiesParameters<GenerationContext>(resourceUIPlugin);
	    bpp.getSourceFolders().add(sourceFolderName + "/");
		bpp.getSourceFolders().add(sourceGenFolderName + "/");
		bpp.getBinIncludes().add("META-INF/");
		bpp.getBinIncludes().add(".");
		bpp.getBinIncludes().add("icons/");
		bpp.getBinIncludes().add("css/");
		bpp.getBinIncludes().add("plugin.xml");
		creators.add(new BuildPropertiesCreator<GenerationContext>(TextResourceArtifacts.BUILD_PROPERTIES, bpp));

		ConcreteSyntax syntax = context.getConcreteSyntax();
	    ManifestParameters<GenerationContext> manifestParameters = new ManifestParameters<GenerationContext>();
	    Collection<String> exports = manifestParameters.getExportedPackages();
		// export the generated packages
		exports.add(context.getPackageName(TextResourceUIArtifacts.PACKAGE_UI));
		// do not export the analysis package if the are no resolvers
		if (csUtil.getResolverFileNames(syntax).size() > 0) {
			exports.add(context.getPackageName(TextResourceArtifacts.PACKAGE_ANALYSIS));
		}
		exports.addAll(csUtil.getAdditionalPackages(syntax, OptionTypes.ADDITIONAL_EXPORTS));
		manifestParameters.getRequiredBundles().addAll(getRequiredBundles(context));
		manifestParameters.setPlugin(resourceUIPlugin);
		manifestParameters.setActivatorClass(context.getQualifiedClassName(TextResourceUIArtifacts.UI_PLUGIN_ACTIVATOR));
		manifestParameters.setBundleName("EMFText UI Plugin: " + context.getConcreteSyntax().getName());
		creators.add(new ResourcePluginManifestCreator(manifestParameters));
		
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.NEW_FILE_WIZARD));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.NEW_FILE_WIZARD_PAGE));
	    creators.add(new FileCopier<GenerationContext>(FileCopier.class.getResourceAsStream("default_new_icon.gif"), context.getNewIconFile()));
	    creators.add(new FileCopier<GenerationContext>(FileCopier.class.getResourceAsStream("default_editor_icon.gif"), context.getEditorIconFile()));
	    creators.add(new FileCopier<GenerationContext>(FileCopier.class.getResourceAsStream("hover_style.css"), context.getHoverStyleFile()));

	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.HOVER_TEXT_PROVIDER));
	    
	    // add UI generators
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.ANTLR_TOKEN_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.BRACKET_SET));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.BROWSER_INFORMATION_CONTROL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.CODE_FOLDING_MANAGER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.COLOR_MANAGER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.COMPLETION_PROCESSOR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.BACKGROUND_PARSING_STRATEGY));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.EDITOR_CONFIGURATION));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.EDITOR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.E_OBJECT_SELECTION));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.HIGHLIGHTING));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.HTML_PRINTER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.HYPERLINK));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.HYPERLINK_DETECTOR));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.MARKER_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.OCCURENCE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.OUTLINE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.OUTLINE_PAGE_TREE_VIEWER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.POSITION_CATEGORY));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.POSITION_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.PROPERTY_SHEET_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.TEXT_HOVER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.TOKEN_SCANNER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.DEFAULT_HOVER_TEXT_PROVIDER));
	    
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.BRACKET_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.PREFERENCE_CONSTANTS));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.OCCURRENCE_PREFERENCE_PAGE));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.PIXEL_CONVERTER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.PREFERENCE_INITIALIZER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.SYNTAX_COLORING_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE));

	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.CODE_COMPLETION_HELPER));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.COMPLETION_PROPOSAL));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.UI_META_INFORMATION));
	    creators.add(new GenericArtifactCreator<GenerationContext, Object>(TextResourceUIArtifacts.UI_PLUGIN_ACTIVATOR));
	    creators.add(new PluginXMLCreator());
	    return creators;
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
		imports.add(context.getResourcePlugin().getName());
		
		// TODO implement extension mechanism to allow code generation plug-ins to add
		// more imports here 

		String qualifiedBasePluginName = 
			OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.BASE_RESOURCE_PLUGIN);
		if (qualifiedBasePluginName != null) {
			imports.add(qualifiedBasePluginName);
		}
		
		imports.addAll(csUtil.getAdditionalPackages(syntax, OptionTypes.ADDITIONAL_DEPENDENCIES));

		if (context.isGenerateTestActionEnabled()) {
			imports.add("org.emftext.sdk.ui");
		}

		genUtil.addImports(context, imports, syntax);
		
		// remove the current plug-in, because we do not
		// need to import it
		imports.remove(context.getResourceUIPlugin().getName());
		
		return imports;
	}
}
