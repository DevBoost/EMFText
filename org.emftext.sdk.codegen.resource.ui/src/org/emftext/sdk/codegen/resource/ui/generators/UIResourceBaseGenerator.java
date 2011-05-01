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
package org.emftext.sdk.codegen.resource.ui.generators;

import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.ResourceBaseGenerator;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;

public abstract class UIResourceBaseGenerator<ParameterType extends IArtifactParameter<GenerationContext, ParameterType>> extends ResourceBaseGenerator<ParameterType> {

	protected String annotationModelClassName;
	protected String annotationModelFactoryClassName;
	protected String antlrTokenHelperClassName;
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
	protected String imageProviderClassName;
	protected String launchConfigurationDelegateClassName;
	protected String launchConfigurationMainTabClassName;
	protected String launchConfigurationTabGroupClassName;
	protected String markerAnnotationClassName;
	protected String markerResolutionGeneratorClassName;
	protected String newFileWizardClassName;
	protected String newFileWizardPageClassName;
	protected String occurrenceClassName;
	protected String occurrencePreferencePageClassName;
	protected String outlinePageClassName;
	protected String outlinePageTreeViewerClassName;
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
	protected String tokenScannerClassName;
	protected String uiMetaInformationClassName;
	protected String uiPluginActivatorClassName;

	@Override
	protected void initilizeClassNames() {
		super.initilizeClassNames();
		GenerationContext context = getContext();

		annotationModelClassName = context.getQualifiedClassName(TextResourceUIArtifacts.ANNOTATION_MODEL);
		annotationModelFactoryClassName = context.getQualifiedClassName(TextResourceUIArtifacts.ANNOTATION_MODEL_FACTORY);
		antlrTokenHelperClassName = context.getQualifiedClassName(TextResourceUIArtifacts.ANTLR_TOKEN_HELPER);
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
		imageProviderClassName = context.getQualifiedClassName(TextResourceUIArtifacts.IMAGE_PROVIDER);
		launchConfigurationDelegateClassName = context.getQualifiedClassName(TextResourceUIArtifacts.LAUNCH_CONFIGURATION_DELEGATE);
		launchConfigurationMainTabClassName = context.getQualifiedClassName(TextResourceUIArtifacts.LAUNCH_CONFIGURATION_MAIN_TAB);
		launchConfigurationTabGroupClassName = context.getQualifiedClassName(TextResourceUIArtifacts.LAUNCH_CONFIGURATION_TAB_GROUP);
		markerAnnotationClassName = context.getQualifiedClassName(TextResourceUIArtifacts.MARKER_ANNOTATION);
		markerResolutionGeneratorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.MARKER_RESOLUTION_GENERATOR);
		newFileWizardClassName = context.getQualifiedClassName(TextResourceUIArtifacts.NEW_FILE_WIZARD);
		newFileWizardPageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.NEW_FILE_WIZARD_PAGE);
		occurrenceClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OCCURRENCE);
		occurrencePreferencePageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OCCURRENCE_PREFERENCE_PAGE);
		outlinePageClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE);
		outlinePageTreeViewerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.OUTLINE_PAGE_TREE_VIEWER);
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
		tokenScannerClassName = context.getQualifiedClassName(TextResourceUIArtifacts.TOKEN_SCANNER);
		uiMetaInformationClassName = context.getQualifiedClassName(TextResourceUIArtifacts.UI_META_INFORMATION);
		uiPluginActivatorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.UI_PLUGIN_ACTIVATOR);
	}
}
