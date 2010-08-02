package org.emftext.sdk.codegen.resource.ui.creators;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.FileCopier;
import org.emftext.sdk.codegen.creators.FoldersCreator;
import org.emftext.sdk.codegen.creators.ManifestCreator;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;
import org.emftext.sdk.codegen.parameters.ManifestParameters;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.creators.AbstractPluginCreator;
import org.emftext.sdk.codegen.resource.creators.SyntaxArtifactCreator;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

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
		final ConcreteSyntax syntax = context.getConcreteSyntax();
		
		List<IArtifactCreator<GenerationContext>> creators = new ArrayList<IArtifactCreator<GenerationContext>>();

	    creators.add(new FoldersCreator<GenerationContext>(new File[] {
	    		context.getSourceFolder(resourceUIPlugin, false),
	    		context.getSourceFolder(resourceUIPlugin, true),
	    		getCSSDir(resourceUIPlugin, context)
	    }));

	    ClassPathParameters<GenerationContext> cpp = new ClassPathParameters<GenerationContext>(TextResourceUIArtifacts.DOT_CLASSPATH, resourceUIPlugin);
		String sourceFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.UI_SOURCE_FOLDER);
		String sourceGenFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.UI_SOURCE_GEN_FOLDER);
		
		cpp.getSourceFolders().add(sourceFolderName);
		cpp.getSourceFolders().add(sourceGenFolderName);
	    creators.add(new DotClasspathCreator<GenerationContext>(cpp, doOverride(syntax, TextResourceUIArtifacts.DOT_CLASSPATH)));
	    
	    DotProjectParameters<GenerationContext> dpp = new DotProjectParameters<GenerationContext>(TextResourceUIArtifacts.DOT_PROJECT, resourceUIPlugin);
	    creators.add(new DotProjectCreator<GenerationContext>(dpp, doOverride(syntax, TextResourceUIArtifacts.DOT_PROJECT)));

		ArtifactDescriptor<GenerationContext, BuildPropertiesParameters<GenerationContext>> buildProperties = TextResourceUIArtifacts.BUILD_PROPERTIES;

		BuildPropertiesParameters<GenerationContext> bpp = new BuildPropertiesParameters<GenerationContext>(buildProperties, resourceUIPlugin);
	    bpp.getSourceFolders().add(sourceFolderName + "/");
		bpp.getSourceFolders().add(sourceGenFolderName + "/");
		bpp.getBinIncludes().add("META-INF/");
		bpp.getBinIncludes().add(".");
		bpp.getBinIncludes().add("icons/");
		bpp.getBinIncludes().add("css/");
		bpp.getBinIncludes().add("plugin.xml");
		creators.add(new BuildPropertiesCreator<GenerationContext>(bpp, doOverride(syntax, buildProperties)));

	    ManifestParameters<GenerationContext> manifestParameters = new ManifestParameters<GenerationContext>(TextResourceUIArtifacts.MANIFEST);
	    Collection<String> exports = manifestParameters.getExportedPackages();
		// export the generated packages
		exports.add(context.getPackageName(TextResourceUIArtifacts.PACKAGE_UI));
		exports.addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_UI_EXPORTS));
		manifestParameters.getRequiredBundles().addAll(getRequiredBundles(context));
		manifestParameters.setPlugin(resourceUIPlugin);
		manifestParameters.setActivatorClass(context.getQualifiedClassName(TextResourceUIArtifacts.UI_PLUGIN_ACTIVATOR));
		manifestParameters.setBundleName("EMFText UI Plugin: " + context.getConcreteSyntax().getName());
		creators.add(new ManifestCreator<GenerationContext>(manifestParameters, OptionManager.INSTANCE.doOverride(context.getConcreteSyntax(), OptionTypes.OVERRIDE_UI_MANIFEST)));
		
	    add(creators, TextResourceUIArtifacts.NEW_FILE_WIZARD);
	    add(creators, TextResourceUIArtifacts.NEW_FILE_WIZARD_PAGE);
	    creators.add(new FileCopier<GenerationContext>(FileCopier.class.getResourceAsStream("default_new_icon.gif"), getNewIconFile(resourceUIPlugin, context)));
	    creators.add(new FileCopier<GenerationContext>(FileCopier.class.getResourceAsStream("default_editor_icon.gif"), getEditorIconFile(resourceUIPlugin, context)));
	    creators.add(new FileCopier<GenerationContext>(FileCopier.class.getResourceAsStream("hover_style.css"), getHoverStyleFile(resourceUIPlugin, context)));

	    // add UI generators
		add(creators, TextResourceUIArtifacts.HOVER_TEXT_PROVIDER);
	    add(creators, TextResourceUIArtifacts.ANTLR_TOKEN_HELPER);
	    add(creators, TextResourceUIArtifacts.BRACKET_SET);
	    add(creators, TextResourceUIArtifacts.BROWSER_INFORMATION_CONTROL);
	    add(creators, TextResourceUIArtifacts.CODE_FOLDING_MANAGER);
	    add(creators, TextResourceUIArtifacts.COLOR_MANAGER);
	    add(creators, TextResourceUIArtifacts.COMPLETION_PROCESSOR);
	    add(creators, TextResourceUIArtifacts.BACKGROUND_PARSING_STRATEGY);
	    add(creators, TextResourceUIArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT);
	    add(creators, TextResourceUIArtifacts.EDITOR_CONFIGURATION);
	    add(creators, TextResourceUIArtifacts.EDITOR);
	    add(creators, TextResourceUIArtifacts.E_OBJECT_SELECTION);
	    add(creators, TextResourceUIArtifacts.HIGHLIGHTING);
	    add(creators, TextResourceUIArtifacts.HTML_PRINTER);
	    add(creators, TextResourceUIArtifacts.HYPERLINK);
	    add(creators, TextResourceUIArtifacts.HYPERLINK_DETECTOR);
	    add(creators, TextResourceUIArtifacts.MARKER_HELPER);
	    add(creators, TextResourceUIArtifacts.OCCURENCE);
	    add(creators, TextResourceUIArtifacts.OUTLINE_PAGE);
	    add(creators, TextResourceUIArtifacts.OUTLINE_PAGE_TREE_VIEWER);
	    add(creators, TextResourceUIArtifacts.POSITION_CATEGORY);
	    add(creators, TextResourceUIArtifacts.POSITION_HELPER);
	    add(creators, TextResourceUIArtifacts.PROPERTY_SHEET_PAGE);
	    add(creators, TextResourceUIArtifacts.TEXT_HOVER);
	    add(creators, TextResourceUIArtifacts.TOKEN_SCANNER);
	    add(creators, TextResourceUIArtifacts.DEFAULT_HOVER_TEXT_PROVIDER);
	    
	    add(creators, TextResourceUIArtifacts.PREFERENCE_PAGE);
	    add(creators, TextResourceUIArtifacts.BRACKET_PREFERENCE_PAGE);
	    add(creators, TextResourceUIArtifacts.PREFERENCE_CONSTANTS);
	    add(creators, TextResourceUIArtifacts.OCCURRENCE_PREFERENCE_PAGE);
	    add(creators, TextResourceUIArtifacts.PIXEL_CONVERTER);
	    add(creators, TextResourceUIArtifacts.PREFERENCE_INITIALIZER);
	    add(creators, TextResourceUIArtifacts.SYNTAX_COLORING_HELPER);
	    add(creators, TextResourceUIArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE);

	    add(creators, TextResourceUIArtifacts.CODE_COMPLETION_HELPER);
	    add(creators, TextResourceUIArtifacts.PROPOSAL_POST_PROCESSOR);
	    add(creators, TextResourceUIArtifacts.COMPLETION_PROPOSAL);
	    add(creators, TextResourceUIArtifacts.UI_META_INFORMATION);
	    add(creators, TextResourceUIArtifacts.UI_PLUGIN_ACTIVATOR);
	    add(creators, TextResourceUIArtifacts.I_BACKET_HANDLER);

	    add(creators, TextResourceUIArtifacts.ANNOTATION_MODEL);
	    add(creators, TextResourceUIArtifacts.ANNOTATION_MODEL_FACTORY);
	    add(creators, TextResourceUIArtifacts.MARKER_ANNOTATION);
	    add(creators, TextResourceUIArtifacts.MARKER_RESOLUTION_GENERATOR);
	    add(creators, TextResourceUIArtifacts.QUICK_ASSIST_ASSISTANT);
	    add(creators, TextResourceUIArtifacts.QUICK_ASSIST_PROCESSOR);
	    add(creators, TextResourceUIArtifacts.IMAGE_PROVIDER);
	    creators.add(new PluginXMLCreator());
	    return creators;
	}

	private void add(
			List<IArtifactCreator<GenerationContext>> creators,
			ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> hoverTextProvider) {
		creators.add(new SyntaxArtifactCreator<ArtifactParameter<GenerationContext>>(new ArtifactParameter<GenerationContext>(hoverTextProvider)));
	}

	private boolean doOverride(
			final ConcreteSyntax syntax,
			ArtifactDescriptor<GenerationContext, ?> artifact) {
		return OptionManager.INSTANCE.getBooleanOptionValue(syntax, artifact.getOverrideOption());
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
		
		imports.addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_UI_DEPENDENCIES));

		if (context.isGenerateTestActionEnabled()) {
			imports.add("org.emftext.sdk.ui");
		}

		genUtil.addImports(context, imports, syntax);
		
		// remove the current plug-in, because we do not
		// need to import it
		imports.remove(context.getResourceUIPlugin().getName());
		
		return imports;
	}

	private File getIconsDir(IPluginDescriptor plugin, GenerationContext context) {
		return new File(context.getFileSystemConnector().getProjectFolder(plugin).getAbsolutePath() + File.separator + UIConstants.DEFAULT_ICON_DIR);
	}

	private File getNewIconFile(IPluginDescriptor plugin, GenerationContext context) {
		return new File(getIconsDir(plugin, context).getAbsolutePath() + File.separator + UIConstants.DEFAULT_NEW_ICON_NAME);
	}

	private File getEditorIconFile(IPluginDescriptor plugin, GenerationContext context) {
		return new File(getIconsDir(plugin, context).getAbsolutePath() + File.separator + UIConstants.DEFAULT_EDITOR_ICON_NAME);
	}

	private File getCSSDir(IPluginDescriptor plugin, GenerationContext context) {
		return new File(context.getFileSystemConnector().getProjectFolder(plugin).getAbsolutePath() + File.separator + UIConstants.DEFAULT_CSS_DIR);
	}

	private File getHoverStyleFile(IPluginDescriptor plugin, GenerationContext context) {
		return new File(getCSSDir(plugin, context).getAbsolutePath() + File.separator + UIConstants.HOVER_STYLE_FILENAME);
	}
}
