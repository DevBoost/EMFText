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
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
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
	    		getCSSDir(resourceUIPlugin)
	    }));

	    ClassPathParameters cpp = new ClassPathParameters(resourceUIPlugin);
		String sourceFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.SOURCE_FOLDER);
		String sourceGenFolderName = csUtil.getSourceFolderName(context.getConcreteSyntax(), OptionTypes.SOURCE_GEN_FOLDER);
		
		cpp.getSourceFolders().add(sourceFolderName);
		cpp.getSourceFolders().add(sourceGenFolderName);
	    creators.add(new DotClasspathCreator<GenerationContext>(TextResourceUIArtifacts.DOT_CLASSPATH, cpp, doOverride(syntax, TextResourceUIArtifacts.DOT_CLASSPATH)));
	    
	    creators.add(new DotProjectCreator<GenerationContext>(TextResourceUIArtifacts.DOT_PROJECT, resourceUIPlugin, doOverride(syntax, TextResourceUIArtifacts.DOT_PROJECT)));

		ArtifactDescriptor<GenerationContext, BuildPropertiesParameters> buildProperties = TextResourceUIArtifacts.BUILD_PROPERTIES;

		BuildPropertiesParameters bpp = new BuildPropertiesParameters(resourceUIPlugin);
	    bpp.getSourceFolders().add(sourceFolderName + "/");
		bpp.getSourceFolders().add(sourceGenFolderName + "/");
		bpp.getBinIncludes().add("META-INF/");
		bpp.getBinIncludes().add(".");
		bpp.getBinIncludes().add("icons/");
		bpp.getBinIncludes().add("css/");
		bpp.getBinIncludes().add("plugin.xml");
		creators.add(new BuildPropertiesCreator<GenerationContext>(buildProperties, bpp, doOverride(syntax, buildProperties)));

	    ManifestParameters manifestParameters = new ManifestParameters();
	    Collection<String> exports = manifestParameters.getExportedPackages();
		// export the generated packages
		exports.add(context.getPackageName(TextResourceUIArtifacts.PACKAGE_UI));
		exports.addAll(OptionManager.INSTANCE.getStringOptionValueAsCollection(syntax, OptionTypes.ADDITIONAL_UI_EXPORTS));
		manifestParameters.getRequiredBundles().addAll(getRequiredBundles(context));
		manifestParameters.setPlugin(resourceUIPlugin);
		manifestParameters.setActivatorClass(context.getQualifiedClassName(TextResourceUIArtifacts.UI_PLUGIN_ACTIVATOR));
		manifestParameters.setBundleName("EMFText UI Plugin: " + context.getConcreteSyntax().getName());
		creators.add(new ManifestCreator<GenerationContext>(TextResourceUIArtifacts.MANIFEST, manifestParameters, OptionManager.INSTANCE.doOverride(context.getConcreteSyntax(), OptionTypes.OVERRIDE_UI_MANIFEST)));
		
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.NEW_FILE_WIZARD));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.NEW_FILE_WIZARD_PAGE));
	    creators.add(new FileCopier<GenerationContext>(FileCopier.class.getResourceAsStream("default_new_icon.gif"), getNewIconFile(resourceUIPlugin)));
	    creators.add(new FileCopier<GenerationContext>(FileCopier.class.getResourceAsStream("default_editor_icon.gif"), getEditorIconFile(resourceUIPlugin)));
	    creators.add(new FileCopier<GenerationContext>(FileCopier.class.getResourceAsStream("hover_style.css"), getHoverStyleFile(resourceUIPlugin)));

	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.HOVER_TEXT_PROVIDER));
	    
	    // add UI generators
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.ANTLR_TOKEN_HELPER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.BRACKET_SET));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.BROWSER_INFORMATION_CONTROL));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.CODE_FOLDING_MANAGER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.COLOR_MANAGER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.COMPLETION_PROCESSOR));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.BACKGROUND_PARSING_STRATEGY));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.EDITOR_CONFIGURATION));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.EDITOR));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.E_OBJECT_SELECTION));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.HIGHLIGHTING));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.HTML_PRINTER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.HYPERLINK));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.HYPERLINK_DETECTOR));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.MARKER_HELPER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.OCCURENCE));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.OUTLINE_PAGE));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.OUTLINE_PAGE_TREE_VIEWER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.POSITION_CATEGORY));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.POSITION_HELPER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.PROPERTY_SHEET_PAGE));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.TEXT_HOVER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.TOKEN_SCANNER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.DEFAULT_HOVER_TEXT_PROVIDER));
	    
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.PREFERENCE_PAGE));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.BRACKET_PREFERENCE_PAGE));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.PREFERENCE_CONSTANTS));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.OCCURRENCE_PREFERENCE_PAGE));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.PIXEL_CONVERTER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.PREFERENCE_INITIALIZER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.SYNTAX_COLORING_HELPER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE));

	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.CODE_COMPLETION_HELPER));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.COMPLETION_PROPOSAL));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.UI_META_INFORMATION));
	    creators.add(new SyntaxArtifactCreator<Object>(TextResourceUIArtifacts.UI_PLUGIN_ACTIVATOR));
	    creators.add(new PluginXMLCreator());
	    return creators;
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

	private File getIconsDir(IPluginDescriptor plugin) {
		return new File(getFileSystemConnector().getProjectFolder(plugin).getAbsolutePath() + File.separator + UIConstants.DEFAULT_ICON_DIR);
	}

	private File getNewIconFile(IPluginDescriptor plugin) {
		return new File(getIconsDir(plugin).getAbsolutePath() + File.separator + UIConstants.DEFAULT_NEW_ICON_NAME);
	}

	private File getEditorIconFile(IPluginDescriptor plugin) {
		return new File(getIconsDir(plugin).getAbsolutePath() + File.separator + UIConstants.DEFAULT_EDITOR_ICON_NAME);
	}

	private File getCSSDir(IPluginDescriptor plugin) {
		return new File(getFileSystemConnector().getProjectFolder(plugin).getAbsolutePath() + File.separator + UIConstants.DEFAULT_CSS_DIR);
	}

	private File getHoverStyleFile(IPluginDescriptor plugin) {
		return new File(getCSSDir(plugin).getAbsolutePath() + File.separator + UIConstants.HOVER_STYLE_FILENAME);
	}
}
