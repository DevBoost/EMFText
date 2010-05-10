package org.emftext.sdk.codegen.resource.ui.generators;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.ResourceBaseGenerator;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;

public abstract class UIResourceBaseGenerator<ParameterType> extends ResourceBaseGenerator<ParameterType> {

	protected String uiPluginActivatorClassName;
	protected String uiMetaInformationClassName;

	public UIResourceBaseGenerator() {
		super();
	}

	/**
	 * Creates a new BaseGenerator that can be used to generate an 
	 * artifact of the given type.
	 * 
	 * @param artifact the type of artifact to be generated
	 */
	public UIResourceBaseGenerator(GenerationContext context, ParameterType parameters, ArtifactDescriptor<GenerationContext, ParameterType> artifact) {
		super(context, parameters, artifact);
	}
	
	@Override
	protected void initilizeClassNames() {
		super.initilizeClassNames();
		antlrTokenHelperClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.ANTLR_TOKEN_HELPER);
		backgroundParsingStrategyClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.BACKGROUND_PARSING_STRATEGY);
		bracketPreferencePageClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.BRACKET_PREFERENCE_PAGE);
		bracketSetClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.BRACKET_SET);
		browserInformationControlClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.BROWSER_INFORMATION_CONTROL);
		codeFoldingManagerClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.CODE_FOLDING_MANAGER);
		colorManagerClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.COLOR_MANAGER);
		completionProcessorClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.COMPLETION_PROCESSOR);
		defaultHoverTextProviderClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.DEFAULT_HOVER_TEXT_PROVIDER);
		docBrowserInformationControlInputClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT);
		eObjectSelectionClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.E_OBJECT_SELECTION);
		editorClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.EDITOR);
		editorConfigurationClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.EDITOR_CONFIGURATION);
		highlightingClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.HIGHLIGHTING);
		hoverTextProviderClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.HOVER_TEXT_PROVIDER);
		htmlPrinterClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.HTML_PRINTER);
		hyperlinkClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.HYPERLINK);
		hyperlinkDetectorClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.HYPERLINK_DETECTOR);
		markerHelperClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.MARKER_HELPER);
		newFileWizardClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.NEW_FILE_WIZARD);
		newFileWizardPageClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.NEW_FILE_WIZARD_PAGE);
		occurenceClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.OCCURENCE);
		occurrencePreferencePageClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.OCCURRENCE_PREFERENCE_PAGE);
		outlinePageClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE);
		outlinePageTreeViewerClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_TREE_VIEWER);
		pixelConverterClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.PIXEL_CONVERTER);
		positionCategoryClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.POSITION_CATEGORY);
		positionHelperClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.POSITION_HELPER);
		preferenceConstantsClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_CONSTANTS);
		preferenceInitializerClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_INITIALIZER);
		preferencePageClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_PAGE);
		propertySheetPageClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.PROPERTY_SHEET_PAGE);
		syntaxColoringHelperClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.SYNTAX_COLORING_HELPER);
		syntaxColoringPreferencePageClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE);
		textHoverClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.TEXT_HOVER);
		tokenScannerClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.TOKEN_SCANNER);
		codeCompletionHelperClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.CODE_COMPLETION_HELPER);
		completionProposalClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.COMPLETION_PROPOSAL);
		uiPluginActivatorClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.UI_PLUGIN_ACTIVATOR);
		uiMetaInformationClassName = getContext().getQualifiedClassName(TextResourceUIArtifacts.UI_META_INFORMATION);
	}
}
