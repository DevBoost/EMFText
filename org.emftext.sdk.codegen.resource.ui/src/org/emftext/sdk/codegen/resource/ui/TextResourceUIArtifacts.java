package org.emftext.sdk.codegen.resource.ui;

import static org.emftext.sdk.Constants.UI_PACKAGE;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.ManifestCreator;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.ManifestParameters;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.creators.PluginXMLCreator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.AntlrTokenHelperGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.BackgroundParsingStrategyGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.BracketPreferencePageGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.BracketSetGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.BrowserInformationControlGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.CodeCompletionHelperGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.CodeFoldingManagerGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.ColorManagerGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.CompletionProcessorGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.CompletionProposalGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.DefaultHoverTextProviderGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.DocBrowserInformationControlInputGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.EObjectSelectionGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.EditorConfigurationGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.EditorGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HTMLPrinterGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HighlightingGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HoverTextProviderGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HyperlinkDetectorGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HyperlinkGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.MarkerHelperGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.NewFileWizardGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.NewFileWizardPageGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.OccurrenceGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.OccurrencePreferencePageGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.OutlinePageGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.OutlinePageTreeViewerGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.PixelConverterGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.PositionCategoryGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.PositionHelperGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.PreferenceConstantsGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.PreferenceInitializerGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.PreferencePageGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.PropertySheetPageGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.SyntaxColoringHelperGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.SyntaxColoringPreferencePageGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.TextHoverGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.TokenScannerGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.UIMetaInformationGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.UIPluginActivatorGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class TextResourceUIArtifacts {

	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_UI = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "", null, null);

	public final static ArtifactDescriptor<GenerationContext, BuildPropertiesParameters> BUILD_PROPERTIES = new ArtifactDescriptor<GenerationContext, BuildPropertiesParameters>(null, BuildPropertiesCreator.FILENAME, "", null, OptionTypes.OVERRIDE_BUILD_PROPERTIES); 
	public final static ArtifactDescriptor<GenerationContext, ClassPathParameters> DOT_CLASSPATH = new ArtifactDescriptor<GenerationContext, ClassPathParameters>(null, DotClasspathCreator.FILENAME, "", null, OptionTypes.OVERRIDE_DOT_CLASSPATH);
	public final static ArtifactDescriptor<GenerationContext, IPluginDescriptor> DOT_PROJECT = new ArtifactDescriptor<GenerationContext, IPluginDescriptor>(null, DotProjectCreator.FILENAME, "", null, OptionTypes.OVERRIDE_DOT_PROJECT);
	public static final ArtifactDescriptor<GenerationContext, ManifestParameters> MANIFEST = new ArtifactDescriptor<GenerationContext, ManifestParameters>(null, ManifestCreator.FILENAME, "", null, null);
	public static final ArtifactDescriptor<GenerationContext, Object> PLUGIN_XML = new ArtifactDescriptor<GenerationContext, Object>(null, PluginXMLCreator.FILENAME, "", null, null);

	public final static ArtifactDescriptor<GenerationContext, Object> CODE_COMPLETION_HELPER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "CodeCompletionHelper", new CodeCompletionHelperGenerator(), OptionTypes.OVERRIDE_CODE_COMPLETION_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> COMPLETION_PROPOSAL = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "CompletionProposal", new CompletionProposalGenerator(), OptionTypes.OVERRIDE_COMPLETION_PROPOSAL); 

	public final static ArtifactDescriptor<GenerationContext, Object> HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "HoverTextProvider", new HoverTextProviderGenerator(), OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> DEFAULT_HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "DefaultHoverTextProvider", new DefaultHoverTextProviderGenerator(), OptionTypes.OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER);

	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_TOKEN_HELPER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "AntlrTokenHelper", new AntlrTokenHelperGenerator(), OptionTypes.OVERRIDE_ANTLR_TOKEN_HELPER); 
	public final static ArtifactDescriptor<GenerationContext, Object> BRACKET_SET = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "BracketSet", new BracketSetGenerator(), OptionTypes.OVERRIDE_BRACKET_SET);
	public final static ArtifactDescriptor<GenerationContext, Object> POSITION_HELPER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "PositionHelper", new PositionHelperGenerator(), OptionTypes.OVERRIDE_POSITION_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> CODE_FOLDING_MANAGER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "CodeFoldingManager", new CodeFoldingManagerGenerator(), OptionTypes.OVERRIDE_CODE_FOLDING_MANAGER);
	public final static ArtifactDescriptor<GenerationContext, Object> EDITOR = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "Editor", new EditorGenerator(), OptionTypes.OVERRIDE_EDITOR);
	public final static ArtifactDescriptor<GenerationContext, Object> COLOR_MANAGER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "ColorManager", new ColorManagerGenerator(), OptionTypes.OVERRIDE_COLOR_MANAGER);
	public final static ArtifactDescriptor<GenerationContext, Object> BACKGROUND_PARSING_STRATEGY = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "BackgroundParsingStrategy", new BackgroundParsingStrategyGenerator(), OptionTypes.OVERRIDE_PARSING_STRATEGY);
	public final static ArtifactDescriptor<GenerationContext, Object> TEXT_HOVER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "TextHover", new TextHoverGenerator(), OptionTypes.OVERRIDE_TEXT_HOVER);
	public final static ArtifactDescriptor<GenerationContext, Object> HTML_PRINTER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "HTMLPrinter", new HTMLPrinterGenerator(), OptionTypes.OVERRIDE_HTML_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, Object> POSITION_CATEGORY = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "PositionCategory", new PositionCategoryGenerator(), OptionTypes.OVERRIDE_POSITION_CATEGORY);
	public final static ArtifactDescriptor<GenerationContext, Object> OCCURENCE = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "Occurrence", new OccurrenceGenerator(), OptionTypes.OVERRIDE_OCCURENCE);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "TokenScanner", new TokenScannerGenerator(), OptionTypes.OVERRIDE_TOKEN_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, Object> MARKER_HELPER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "MarkerHelper", new MarkerHelperGenerator(), OptionTypes.OVERRIDE_MARKER_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> HYPERLINK = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "Hyperlink", new HyperlinkGenerator(), OptionTypes.OVERRIDE_HYPERLINK);
	public final static ArtifactDescriptor<GenerationContext, Object> HYPERLINK_DETECTOR = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "HyperlinkDetector", new HyperlinkDetectorGenerator(), OptionTypes.OVERRIDE_HYPERLINK_DETECTOR); 
	public final static ArtifactDescriptor<GenerationContext, Object> E_OBJECT_SELECTION = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "EObjectSelection", new EObjectSelectionGenerator(), OptionTypes.OVERRIDE_EOBJECT_SELECTION);
	public final static ArtifactDescriptor<GenerationContext, Object> HIGHLIGHTING = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "Highlighting", new HighlightingGenerator(), OptionTypes.OVERRIDE_HIGHLIGHTING);
	public final static ArtifactDescriptor<GenerationContext, Object> PROPERTY_SHEET_PAGE = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "PropertySheetPage", new PropertySheetPageGenerator(), OptionTypes.OVERRIDE_PROPERTY_SHEET_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> OUTLINE_PAGE_TREE_VIEWER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "OutlinePageTreeViewer", new OutlinePageTreeViewerGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE_TREE_VIEWER); 
	public final static ArtifactDescriptor<GenerationContext, Object> OUTLINE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "OutlinePage", new OutlinePageGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> EDITOR_CONFIGURATION = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "EditorConfiguration", new EditorConfigurationGenerator(), OptionTypes.OVERRIDE_EDITOR_CONFIGURATION);
	public final static ArtifactDescriptor<GenerationContext, Object> DOC_BROWSER_INFORMATION_CONTROL_INPUT = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "DocBrowserInformationControlInput", new DocBrowserInformationControlInputGenerator(), OptionTypes.OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT);
	public final static ArtifactDescriptor<GenerationContext, Object> COMPLETION_PROCESSOR = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "CompletionProcessor", new CompletionProcessorGenerator(), OptionTypes.OVERRIDE_COMPLETION_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, Object> BROWSER_INFORMATION_CONTROL = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "BrowserInformationControl", new BrowserInformationControlGenerator(), OptionTypes.OVERRIDE_BROWSER_INFORMATION_CONTROL);
	// preference pages
	public final static ArtifactDescriptor<GenerationContext, Object> PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "PreferencePage", new PreferencePageGenerator(), OptionTypes.OVERRIDE_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> BRACKET_PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "BracketPreferencePage", new BracketPreferencePageGenerator(), OptionTypes.OVERRIDE_BRACKET_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> PREFERENCE_CONSTANTS = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "PreferenceConstants", new PreferenceConstantsGenerator(), OptionTypes.OVERRIDE_PREFERENCE_CONSTANTS);
	public final static ArtifactDescriptor<GenerationContext, Object> OCCURRENCE_PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "OccurrencePreferencePage", new OccurrencePreferencePageGenerator(), OptionTypes.OVERRIDE_OCCURENCE_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> PIXEL_CONVERTER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "PixelConverter", new PixelConverterGenerator(), OptionTypes.OVERRIDE_PIXEL_CONVERTER);
	public final static ArtifactDescriptor<GenerationContext, Object> PREFERENCE_INITIALIZER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "PreferenceInitializer", new PreferenceInitializerGenerator(), OptionTypes.OVERRIDE_PREFERENCE_INITIALIZER);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_COLORING_HELPER = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "SyntaxColoringHelper", new SyntaxColoringHelperGenerator(), OptionTypes.OVERRIDE_SYNTAX_COLORING_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_COLORING_PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "SyntaxColoringPreferencePage", new SyntaxColoringPreferencePageGenerator(), OptionTypes.OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> NEW_FILE_WIZARD = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "NewFileWizard", new NewFileWizardGenerator(), OptionTypes.OVERRIDE_NEW_FILE_WIZARD);
	public final static ArtifactDescriptor<GenerationContext, Object> NEW_FILE_WIZARD_PAGE = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "NewFileWizardPage", new NewFileWizardPageGenerator(), OptionTypes.OVERRIDE_NEW_FILE_WIZARD_PAGE);

	public final static ArtifactDescriptor<GenerationContext, Object> UI_META_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "UIMetaInformation", new UIMetaInformationGenerator(), OptionTypes.OVERRIDE_UI_META_INFORMATION);
	public final static ArtifactDescriptor<GenerationContext, Object> UI_PLUGIN_ACTIVATOR = new ArtifactDescriptor<GenerationContext, Object>(UI_PACKAGE, "", "UIPlugin", new UIPluginActivatorGenerator(), OptionTypes.OVERRIDE_UI_PLUGIN_ACTIVATOR);
}
