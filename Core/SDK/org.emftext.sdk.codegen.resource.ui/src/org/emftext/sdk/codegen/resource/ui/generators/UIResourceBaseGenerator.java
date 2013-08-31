/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource.ui.generators;

import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.ResourceBaseGenerator;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;

public abstract class UIResourceBaseGenerator<ParameterType extends IArtifactParameter<GenerationContext, ParameterType>> extends ResourceBaseGenerator<ParameterType> {

	protected String ignoredWordsFilterClassName;

	protected String abstractOutlinePageActionClassName;
	protected String adapterFactoryProviderClassName;
	protected String annotationModelClassName;
	protected String annotationModelFactoryClassName;
	protected String autoEditStrategyClassName;
	protected String backgroundParsingStrategyClassName;
	protected String bracketPreferencePageClassName;
	protected String bracketSetClassName;
	protected String browserInformationControlClassName;
	protected String codeCompletionHelperClassName;
	protected String codeFoldingManagerClassName;
	protected String colorManagerClassName;
	protected String completionProcessorClassName;
	protected String completionProposalClassName;
	protected String defaultHoverTextProviderClassName;
	protected String docBrowserInformationControlInputClassName;
	protected String eObjectSelectionClassName;
	protected String editingDomainProviderClassName;
	protected String editorClassName;
	protected String editorConfigurationClassName;
	protected String highlightingClassName;
	protected String hoverTextProviderClassName;
	protected String htmlPrinterClassName;
	protected String hyperlinkClassName;
	protected String hyperlinkDetectorClassName;
	protected String iAnnotationModelProviderClassName;
	protected String iBracketHandlerClassName;
	protected String iBracketHandlerProviderClassName;
	protected String iTokenScannerClassName;
	protected String imageProviderClassName;
	protected String launchConfigurationMainTabClassName;
	protected String launchConfigurationTabGroupClassName;
	protected String markerAnnotationClassName;
	protected String markerResolutionGeneratorClassName;
	protected String newFileWizardClassName;
	protected String newProjectWizardLogicClassName;
	protected String newFileWizardPageClassName;
	protected String occurrenceClassName;
	protected String occurrencePreferencePageClassName;
	protected String outlinePageClassName;
	protected String outlinePageLinkWithEditorActionClassName;
	protected String outlinePageLexicalSortingActionClassName;
	protected String outlinePageTypeSortingActionClassName;
	protected String outlinePageCollapseAllActionClassName;
	protected String outlinePageExpandAllActionClassName;
	protected String outlinePageTreeViewerClassName;
	protected String outlinePageActionProviderClassName;
	protected String outlinePageTreeViewerComparatorClassName;
	protected String pixelConverterClassName;
	protected String positionCategoryClassName;
	protected String positionHelperClassName;
	protected String preferenceConstantsClassName;
	protected String preferenceInitializerClassName;
	protected String preferencePageClassName;
	protected String propertySheetPageClassName;
	protected String propertyTesterClassName;
	protected String proposalPostProcessorClassName;
	protected String quickAssistAssistantClassName;
	protected String quickAssistProcessorClassName;
	protected String syntaxColoringHelperClassName;
	protected String syntaxColoringPreferencePageClassName;
	protected String textHoverClassName;
	protected String toggleCommentHandlerClassName;
	protected String tokenScannerClassName;
	protected String uiMetaInformationClassName;
	protected String uiPluginActivatorClassName;
	
	protected String debugModelPresentationClassName;
	protected String lineBreakpointAdapterClassName;
	protected String adapterFactoryClassName;
	protected String outlinePageAutoExpandActionClassName;
	protected String sourceViewerConfigurationClassName;
	protected String uiAntlrTokenHelperClassName;

	@Override
	protected void initilizeClassNames() {
		super.initilizeClassNames();
		GenerationContext context = getContext();

		ignoredWordsFilterClassName = context.getQualifiedClassName(TextResourceUIArtifacts.IGNORED_WORDS_FILTER);

		abstractOutlinePageActionClassName = context.getQualifiedClassName(TextResourceUIArtifacts.ABSTRACT_OUTLINE_PAGE_ACTION);
		adapterFactoryProviderClassName = context.getQualifiedClassName(TextResourceUIArtifacts.ADAPTER_FACTORY_PROVIDER);
		annotationModelClassName = context.getQualifiedClassName(TextResourceUIArtifacts.ANNOTATION_MODEL);
		autoEditStrategyClassName = context.getQualifiedClassName(TextResourceUIArtifacts.AUTO_EDIT_STRATEGY);
		uiAntlrTokenHelperClassName = context.getQualifiedClassName(TextResourceUIArtifacts.ANTLR_TOKEN_HELPER);
		annotationModelFactoryClassName = context.getQualifiedClassName(TextResourceUIArtifacts.ANNOTATION_MODEL_FACTORY);
		backgroundParsingStrategyClassName = context.getQualifiedClassName(TextResourceUIArtifacts.BACKGROUND_PARSING_STRATEGY);
		bracketPreferencePageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.BRACKET_PREFERENCE_PAGE);
		bracketSetClassName = context.getQualifiedClassName(TextResourceUIArtifacts.BRACKET_SET);
		browserInformationControlClassName = context.getQualifiedClassName(TextResourceUIArtifacts.BROWSER_INFORMATION_CONTROL);
		codeCompletionHelperClassName = context.getQualifiedClassName(TextResourceUIArtifacts.CODE_COMPLETION_HELPER);
		codeFoldingManagerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.CODE_FOLDING_MANAGER);
		colorManagerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.COLOR_MANAGER);
		completionProcessorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.COMPLETION_PROCESSOR);
		completionProposalClassName = context.getQualifiedClassName(TextResourceUIArtifacts.COMPLETION_PROPOSAL);
		defaultHoverTextProviderClassName = context.getQualifiedClassName(TextResourceUIArtifacts.DEFAULT_HOVER_TEXT_PROVIDER);
		docBrowserInformationControlInputClassName = context.getQualifiedClassName(TextResourceUIArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT);
		eObjectSelectionClassName = context.getQualifiedClassName(TextResourceUIArtifacts.E_OBJECT_SELECTION);
		editingDomainProviderClassName = context.getQualifiedClassName(TextResourceUIArtifacts.EDITING_DOMAIN_PROVIDER);
		editorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.EDITOR);
		editorConfigurationClassName = context.getQualifiedClassName(TextResourceUIArtifacts.EDITOR_CONFIGURATION);
		highlightingClassName = context.getQualifiedClassName(TextResourceUIArtifacts.HIGHLIGHTING);
		hoverTextProviderClassName = context.getQualifiedClassName(TextResourceUIArtifacts.HOVER_TEXT_PROVIDER);
		htmlPrinterClassName = context.getQualifiedClassName(TextResourceUIArtifacts.HTML_PRINTER);
		hyperlinkClassName = context.getQualifiedClassName(TextResourceUIArtifacts.HYPERLINK);
		hyperlinkDetectorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.HYPERLINK_DETECTOR);
		iAnnotationModelProviderClassName = context.getQualifiedClassName(TextResourceUIArtifacts.I_ANNOTATION_MODEL_PROVIDER);
		iBracketHandlerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.I_BACKET_HANDLER);
		iBracketHandlerProviderClassName = context.getQualifiedClassName(TextResourceUIArtifacts.I_BACKET_HANDLER_PROVIDER);
		iTokenScannerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.I_TOKEN_SCANNER);
		imageProviderClassName = context.getQualifiedClassName(TextResourceUIArtifacts.IMAGE_PROVIDER);
		launchConfigurationMainTabClassName = context.getQualifiedClassName(TextResourceUIArtifacts.LAUNCH_CONFIGURATION_MAIN_TAB);
		launchConfigurationTabGroupClassName = context.getQualifiedClassName(TextResourceUIArtifacts.LAUNCH_CONFIGURATION_TAB_GROUP);
		markerAnnotationClassName = context.getQualifiedClassName(TextResourceUIArtifacts.MARKER_ANNOTATION);
		markerResolutionGeneratorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.MARKER_RESOLUTION_GENERATOR);
		newFileWizardClassName = context.getQualifiedClassName(TextResourceUIArtifacts.NEW_FILE_WIZARD);
		newFileWizardPageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.NEW_FILE_WIZARD_PAGE);
		newProjectWizardLogicClassName = context.getQualifiedClassName(TextResourceUIArtifacts.NEW_PROJECT_WIZARD_LOGIC);
		occurrenceClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OCCURRENCE);
		occurrencePreferencePageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OCCURRENCE_PREFERENCE_PAGE);
		outlinePageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE);
		outlinePageActionProviderClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_ACTION_PROVIDER);
		outlinePageLinkWithEditorActionClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_LINK_WITH_EDITOR_ACTION);
		outlinePageAutoExpandActionClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_AUTO_EXPAND_ACTION);
		outlinePageExpandAllActionClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_EXPAND_ALL_ACTION);
		outlinePageLexicalSortingActionClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_LEXICAL_SORTING_ACTION);
		outlinePageTypeSortingActionClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_GROUP_TYPES_ACTION);
		outlinePageCollapseAllActionClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_COLLAPSE_ALL_ACTION);
		outlinePageTreeViewerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_TREE_VIEWER);
		outlinePageTreeViewerComparatorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_TREE_VIEWER_COMPARATOR);
		pixelConverterClassName = context.getQualifiedClassName(TextResourceUIArtifacts.PIXEL_CONVERTER);
		positionCategoryClassName = context.getQualifiedClassName(TextResourceUIArtifacts.POSITION_CATEGORY);
		positionHelperClassName = context.getQualifiedClassName(TextResourceUIArtifacts.POSITION_HELPER);
		preferenceConstantsClassName = context.getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_CONSTANTS);
		preferenceInitializerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_INITIALIZER);
		preferencePageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.PREFERENCE_PAGE);
		propertySheetPageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.PROPERTY_SHEET_PAGE);
		propertyTesterClassName = context.getQualifiedClassName(TextResourceUIArtifacts.PROPERTY_TESTER);
		proposalPostProcessorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.PROPOSAL_POST_PROCESSOR);
		quickAssistAssistantClassName = context.getQualifiedClassName(TextResourceUIArtifacts.QUICK_ASSIST_ASSISTANT);
		quickAssistProcessorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.QUICK_ASSIST_PROCESSOR);
		syntaxColoringHelperClassName = context.getQualifiedClassName(TextResourceUIArtifacts.SYNTAX_COLORING_HELPER);
		syntaxColoringPreferencePageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE);
		textHoverClassName = context.getQualifiedClassName(TextResourceUIArtifacts.TEXT_HOVER);
		toggleCommentHandlerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.TOGGLE_COMMENT_HANDLER);
		tokenScannerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.TOKEN_SCANNER);
		uiMetaInformationClassName = context.getQualifiedClassName(TextResourceUIArtifacts.UI_META_INFORMATION);
		uiPluginActivatorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.UI_PLUGIN_ACTIVATOR);

		debugModelPresentationClassName = context.getQualifiedClassName(TextResourceUIArtifacts.DEBUG_MODEL_PRESENTATION);
		lineBreakpointAdapterClassName = context.getQualifiedClassName(TextResourceUIArtifacts.LINE_BREAKPOINT_ADAPTER);
		adapterFactoryClassName = context.getQualifiedClassName(TextResourceUIArtifacts.ADAPTER_FACTORY);
		
		sourceViewerConfigurationClassName = context.getQualifiedClassName(TextResourceUIArtifacts.SOURCE_VIEWER_CONFIGURATION);
	}
}
