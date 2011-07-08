/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.codegen.resource.ui;

import static org.emftext.sdk.codegen.Constants.UI_DEBUG_PACKAGE;
import static org.emftext.sdk.codegen.Constants.UI_LAUNCH_PACKAGE;
import static org.emftext.sdk.codegen.Constants.UI_PACKAGE;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.ManifestCreator;
import org.emftext.sdk.codegen.creators.PluginXMLCreator;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;
import org.emftext.sdk.codegen.parameters.ManifestParameters;
import org.emftext.sdk.codegen.parameters.XMLParameters;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.ui.AnnotationModelFactoryGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.AnnotationModelGenerator;
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
import org.emftext.sdk.codegen.resource.ui.generators.ui.ExampleProjectWizardGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HTMLPrinterGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HighlightingGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HoverTextProviderGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HyperlinkDetectorGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.HyperlinkGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.IAnnotationModelProviderGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.IBracketHandlerGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.IBracketHandlerProviderGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.ImageProviderGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.MarkerAnnotationGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.MarkerResolutionGeneratorGenerator;
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
import org.emftext.sdk.codegen.resource.ui.generators.ui.PropertyTesterGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.ProposalPostProcessorGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.QuickAssistAssistantGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.QuickAssistProcessorGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.SyntaxColoringHelperGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.SyntaxColoringPreferencePageGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.TextHoverGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.TokenScannerGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.UIMetaInformationGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.UIPluginActivatorGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.debug.AdapterFactoryGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.debug.DebugModelPresentationGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.debug.LineBreakpointAdapterGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.launch.LaunchConfigurationMainTabGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.launch.LaunchConfigurationTabGroupGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.ui.launch.LaunchShortcutGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class TextResourceUIArtifacts {

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PACKAGE_UI = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "", null, null);

	public final static ArtifactDescriptor<GenerationContext, BuildPropertiesParameters<GenerationContext>> BUILD_PROPERTIES = new ArtifactDescriptor<GenerationContext, BuildPropertiesParameters<GenerationContext>>(null, BuildPropertiesCreator.FILENAME, "", null, OptionTypes.OVERRIDE_UI_BUILD_PROPERTIES); 
	public final static ArtifactDescriptor<GenerationContext, ClassPathParameters<GenerationContext>> DOT_CLASSPATH = new ArtifactDescriptor<GenerationContext, ClassPathParameters<GenerationContext>>(null, DotClasspathCreator.FILENAME, "", null, OptionTypes.OVERRIDE_UI_DOT_CLASSPATH);
	public final static ArtifactDescriptor<GenerationContext, DotProjectParameters<GenerationContext>> DOT_PROJECT = new ArtifactDescriptor<GenerationContext, DotProjectParameters<GenerationContext>>(null, DotProjectCreator.FILENAME, "", null, OptionTypes.OVERRIDE_UI_DOT_PROJECT);
	public static final ArtifactDescriptor<GenerationContext, ManifestParameters<GenerationContext>> MANIFEST = new ArtifactDescriptor<GenerationContext, ManifestParameters<GenerationContext>>(null, ManifestCreator.FILENAME, "", null, null);
	public static final ArtifactDescriptor<GenerationContext, XMLParameters<GenerationContext>> PLUGIN_XML = new ArtifactDescriptor<GenerationContext, XMLParameters<GenerationContext>>(null, PluginXMLCreator.FILENAME, "", null, OptionTypes.OVERRIDE_UI_PLUGIN_XML);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> CODE_COMPLETION_HELPER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "CodeCompletionHelper", CodeCompletionHelperGenerator.class, OptionTypes.OVERRIDE_CODE_COMPLETION_HELPER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> COMPLETION_PROPOSAL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "CompletionProposal", CompletionProposalGenerator.class, OptionTypes.OVERRIDE_COMPLETION_PROPOSAL); 
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PROPOSAL_POST_PROCESSOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "ProposalPostProcessor", ProposalPostProcessorGenerator.class, OptionTypes.OVERRIDE_PROPOSAL_POST_PROCESSOR); 

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "HoverTextProvider", HoverTextProviderGenerator.class, OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> DEFAULT_HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "DefaultHoverTextProvider", DefaultHoverTextProviderGenerator.class, OptionTypes.OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ANTLR_TOKEN_HELPER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "AntlrTokenHelper", AntlrTokenHelperGenerator.class, OptionTypes.OVERRIDE_ANTLR_TOKEN_HELPER); 
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> BRACKET_SET = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "BracketSet", BracketSetGenerator.class, OptionTypes.OVERRIDE_BRACKET_SET);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> POSITION_HELPER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "PositionHelper", PositionHelperGenerator.class, OptionTypes.OVERRIDE_POSITION_HELPER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> CODE_FOLDING_MANAGER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "CodeFoldingManager", CodeFoldingManagerGenerator.class, OptionTypes.OVERRIDE_CODE_FOLDING_MANAGER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> EDITOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "Editor", EditorGenerator.class, OptionTypes.OVERRIDE_EDITOR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> COLOR_MANAGER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "ColorManager", ColorManagerGenerator.class, OptionTypes.OVERRIDE_COLOR_MANAGER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> BACKGROUND_PARSING_STRATEGY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "BackgroundParsingStrategy", BackgroundParsingStrategyGenerator.class, OptionTypes.OVERRIDE_PARSING_STRATEGY);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> TEXT_HOVER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "TextHover", TextHoverGenerator.class, OptionTypes.OVERRIDE_TEXT_HOVER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> HTML_PRINTER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "HTMLPrinter", HTMLPrinterGenerator.class, OptionTypes.OVERRIDE_HTML_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> POSITION_CATEGORY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "PositionCategory", PositionCategoryGenerator.class, OptionTypes.OVERRIDE_POSITION_CATEGORY);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> OCCURRENCE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "Occurrence", OccurrenceGenerator.class, OptionTypes.OVERRIDE_OCCURRENCE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> TOKEN_SCANNER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "TokenScanner", TokenScannerGenerator.class, OptionTypes.OVERRIDE_TOKEN_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> HYPERLINK = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "Hyperlink", HyperlinkGenerator.class, OptionTypes.OVERRIDE_HYPERLINK);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> HYPERLINK_DETECTOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "HyperlinkDetector", HyperlinkDetectorGenerator.class, OptionTypes.OVERRIDE_HYPERLINK_DETECTOR); 
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> E_OBJECT_SELECTION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "EObjectSelection", EObjectSelectionGenerator.class, OptionTypes.OVERRIDE_EOBJECT_SELECTION);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> HIGHLIGHTING = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "Highlighting", HighlightingGenerator.class, OptionTypes.OVERRIDE_HIGHLIGHTING);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PROPERTY_SHEET_PAGE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "PropertySheetPage", PropertySheetPageGenerator.class, OptionTypes.OVERRIDE_PROPERTY_SHEET_PAGE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> OUTLINE_PAGE_TREE_VIEWER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "OutlinePageTreeViewer", OutlinePageTreeViewerGenerator.class, OptionTypes.OVERRIDE_OUTLINE_PAGE_TREE_VIEWER); 
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> OUTLINE_PAGE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "OutlinePage", OutlinePageGenerator.class, OptionTypes.OVERRIDE_OUTLINE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> EDITOR_CONFIGURATION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "EditorConfiguration", EditorConfigurationGenerator.class, OptionTypes.OVERRIDE_EDITOR_CONFIGURATION);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> DOC_BROWSER_INFORMATION_CONTROL_INPUT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "DocBrowserInformationControlInput", DocBrowserInformationControlInputGenerator.class, OptionTypes.OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> COMPLETION_PROCESSOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "CompletionProcessor", CompletionProcessorGenerator.class, OptionTypes.OVERRIDE_COMPLETION_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> BROWSER_INFORMATION_CONTROL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "BrowserInformationControl", BrowserInformationControlGenerator.class, OptionTypes.OVERRIDE_BROWSER_INFORMATION_CONTROL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> EXAMPLE_PROJECT_WIZARD = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "ExampleProjectWizard", ExampleProjectWizardGenerator.class, OptionTypes.OVERRIDE_EXAMPLE_PROJECT_WIZARD);

	// preference pages
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "PreferencePage", PreferencePageGenerator.class, OptionTypes.OVERRIDE_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> BRACKET_PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "BracketPreferencePage", BracketPreferencePageGenerator.class, OptionTypes.OVERRIDE_BRACKET_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PREFERENCE_CONSTANTS = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "PreferenceConstants", PreferenceConstantsGenerator.class, OptionTypes.OVERRIDE_PREFERENCE_CONSTANTS);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> OCCURRENCE_PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "OccurrencePreferencePage", OccurrencePreferencePageGenerator.class, OptionTypes.OVERRIDE_OCCURRENCE_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PIXEL_CONVERTER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "PixelConverter", PixelConverterGenerator.class, OptionTypes.OVERRIDE_PIXEL_CONVERTER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PREFERENCE_INITIALIZER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "PreferenceInitializer", PreferenceInitializerGenerator.class, OptionTypes.OVERRIDE_PREFERENCE_INITIALIZER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> SYNTAX_COLORING_HELPER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "SyntaxColoringHelper", SyntaxColoringHelperGenerator.class, OptionTypes.OVERRIDE_SYNTAX_COLORING_HELPER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> SYNTAX_COLORING_PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "SyntaxColoringPreferencePage", SyntaxColoringPreferencePageGenerator.class, OptionTypes.OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> NEW_FILE_WIZARD = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "NewFileWizard", NewFileWizardGenerator.class, OptionTypes.OVERRIDE_NEW_FILE_WIZARD);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> NEW_FILE_WIZARD_PAGE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "NewFileWizardPage", NewFileWizardPageGenerator.class, OptionTypes.OVERRIDE_NEW_FILE_WIZARD_PAGE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_ANNOTATION_MODEL_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "I", "AnnotationModelProvider", IAnnotationModelProviderGenerator.class, OptionTypes.OVERRIDE_IANNOTATION_MODEL_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_BACKET_HANDLER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "I", "BracketHandler", IBracketHandlerGenerator.class, OptionTypes.OVERRIDE_IBRACKET_HANDLER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_BACKET_HANDLER_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "I", "BracketHandlerProvider", IBracketHandlerProviderGenerator.class, OptionTypes.OVERRIDE_IBRACKET_HANDLER_PROVIDER);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> UI_META_INFORMATION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "UIMetaInformation", UIMetaInformationGenerator.class, OptionTypes.OVERRIDE_UI_META_INFORMATION);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> UI_PLUGIN_ACTIVATOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "UIPlugin", UIPluginActivatorGenerator.class, OptionTypes.OVERRIDE_UI_PLUGIN_ACTIVATOR);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ANNOTATION_MODEL_FACTORY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "AnnotationModelFactory", AnnotationModelFactoryGenerator.class, OptionTypes.OVERRIDE_ANNOTATION_MODEL_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ANNOTATION_MODEL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "AnnotationModel", AnnotationModelGenerator.class, OptionTypes.OVERRIDE_ANNOTATION_MODEL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> MARKER_ANNOTATION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "MarkerAnnotation", MarkerAnnotationGenerator.class, OptionTypes.OVERRIDE_MARKER_ANNOTATION);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> MARKER_RESOLUTION_GENERATOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "MarkerResolutionGenerator", MarkerResolutionGeneratorGenerator.class, OptionTypes.OVERRIDE_MARKER_RESOLUTION_GENERATOR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> QUICK_ASSIST_ASSISTANT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "QuickAssistAssistant", QuickAssistAssistantGenerator.class, OptionTypes.OVERRIDE_QUICK_ASSIST_ASSISTANT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> QUICK_ASSIST_PROCESSOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "QuickAssistProcessor", QuickAssistProcessorGenerator.class, OptionTypes.OVERRIDE_QUICK_ASSIST_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> IMAGE_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "ImageProvider", ImageProviderGenerator.class, OptionTypes.OVERRIDE_IMAGE_PROVIDER);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> LAUNCH_CONFIGURATION_MAIN_TAB = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_LAUNCH_PACKAGE, "", "LaunchConfigurationMainTab", LaunchConfigurationMainTabGenerator.class, OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> LAUNCH_CONFIGURATION_TAB_GROUP = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_LAUNCH_PACKAGE, "", "LaunchConfigurationTabGroup", LaunchConfigurationTabGroupGenerator.class, OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> LAUNCH_SHORTCUT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_LAUNCH_PACKAGE, "", "LaunchShortcut", LaunchShortcutGenerator.class, OptionTypes.OVERRIDE_LAUNCH_SHORTCUT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PROPERTY_TESTER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_PACKAGE, "", "PropertyTester", PropertyTesterGenerator.class, OptionTypes.OVERRIDE_PROPERTY_TESTER);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> DEBUG_MODEL_PRESENTATION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_DEBUG_PACKAGE, "", "DebugModelPresentation", DebugModelPresentationGenerator.class, OptionTypes.OVERRIDE_DEBUG_MODEL_PRESENTATION);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> LINE_BREAKPOINT_ADAPTER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_DEBUG_PACKAGE, "", "LineBreakpointAdapter", LineBreakpointAdapterGenerator.class, OptionTypes.OVERRIDE_LINE_BREAKPOINT_ADAPTER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ADAPTER_FACTORY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UI_DEBUG_PACKAGE, "", "AdapterFactory", AdapterFactoryGenerator.class, OptionTypes.OVERRIDE_ADAPTER_FACTORY);
}
