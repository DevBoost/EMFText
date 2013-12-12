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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ABSTRACT_DECORATED_TEXT_EDITOR_PREFERENCE_CONSTANTS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ACTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CONTENT_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DEFAULT_ANNOTATION_HOVER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DEFAULT_DAMAGER_REPAIRER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.EDITORS_UI;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ANNOTATION_HOVER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_AUTO_EDIT_STRATEGY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONTENT_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_HYPERLINK_DETECTOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PRESENTATION_RECONCILER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_QUICK_ASSIST_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_RECONCILER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_RECONCILING_STRATEGY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SPELLING_PROBLEM_COLLECTOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_HOVER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TOKEN_SCANNER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MONO_RECONCILER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PRESENTATION_RECONCILER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SPELLING_PROBLEM;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SPELLING_RECONCILE_STRATEGY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SPELLING_SERVICE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.TEXT_SOURCE_VIEWER_CONFIGURATION;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class SourceViewerConfigurationGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"This class provides the configuration for the generated editor. " +
			"It registers content assistance and syntax highlighting."
		);
		sc.add("public class " + getResourceClassName() + " extends " + TEXT_SOURCE_VIEWER_CONFIGURATION(sc) + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + colorManagerClassName + " colorManager;");
		sc.add("private " + iResourceProviderClassName + " resourceProvider;");
		sc.add("private " + iAnnotationModelProviderClassName + " annotationModelProvider;");
		sc.add("private " + quickAssistAssistantClassName + " quickAssistAssistant;");
		sc.add("private " + iTokenScannerClassName + " tokenScanner;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a new editor configuration.",
			"@param resourceProvider the provider for the resource (usually this is the editor)",
			"@param colorManager the color manager to use"
		);
		sc.add("public " + getResourceClassName() + "(" + iResourceProviderClassName + " resourceProvider, " + iAnnotationModelProviderClassName + " annotationModelProvider, " + colorManagerClassName + " colorManager) {");
		sc.add("super(" + uiPluginActivatorClassName + ".getDefault().getPreferenceStore());");
		sc.add("this.fPreferenceStore.setDefault(" + SPELLING_SERVICE(sc) + ".PREFERENCE_SPELLING_ENABLED, true);");
		sc.add("this.fPreferenceStore.setDefault(" + ABSTRACT_DECORATED_TEXT_EDITOR_PREFERENCE_CONSTANTS(sc) + ".EDITOR_TAB_WIDTH, 4);");
		sc.add("this.fPreferenceStore.setDefault(" + ABSTRACT_DECORATED_TEXT_EDITOR_PREFERENCE_CONSTANTS(sc) + ".EDITOR_HYPERLINK_KEY_MODIFIER, " + ACTION(sc) + ".findModifierString(" + SWT(sc) + ".MOD1));");
		sc.add("this.resourceProvider = resourceProvider;");
		sc.add("this.annotationModelProvider = annotationModelProvider;");
		sc.add("this.colorManager = colorManager;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetAutoEditStrategies(sc);
		addGetContentAssistantMethod(sc);
		addGetConfiguredContentTypesMethod(sc);
		addGetScannerMethod(sc);
		addGetPresentationReconcilerMethod(sc);
		addGetAnnotationHoverMethod(sc);
		addGetTextHoverMethod(sc);
		addGetHyperlinkDetectorsMethod(sc);
		addGetQuickAssistAssistantMethod(sc);
		addGetReconcilerMethod(sc);
		addGetDefaultPrefixesMethod(sc);
	}

	private void addGetAutoEditStrategies(JavaComposite sc) {
		sc.addJavadoc("Returns an instance of class " + 
			autoEditStrategyClassName + ".");
		sc.add("public " + I_AUTO_EDIT_STRATEGY(sc) + "[] getAutoEditStrategies(" + I_SOURCE_VIEWER(sc) + " sourceViewer, String contentType) {");
		sc.add("return new " + I_AUTO_EDIT_STRATEGY(sc) + "[] {new " + autoEditStrategyClassName +"()};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetReconcilerMethod(JavaComposite sc) {
		sc.add("public " + I_RECONCILER(sc) + " getReconciler(final " + I_SOURCE_VIEWER(sc) + " sourceViewer) {");
		sc.add("if (fPreferenceStore == null || !fPreferenceStore.getBoolean(" + SPELLING_SERVICE(sc) + ".PREFERENCE_SPELLING_ENABLED)) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(SPELLING_SERVICE(sc) + " spellingService = " + EDITORS_UI(sc) + ".getSpellingService();");
		sc.add("if (spellingService.getActiveSpellingEngineDescriptor(fPreferenceStore) == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(I_RECONCILING_STRATEGY(sc) + " strategy = new " + SPELLING_RECONCILE_STRATEGY(sc) + "(sourceViewer, spellingService) {");
		sc.addLineBreak();
		sc.add("@Override");
		sc.add("protected " + I_SPELLING_PROBLEM_COLLECTOR(sc) + " createSpellingProblemCollector() {");
		sc.add("final " + I_SPELLING_PROBLEM_COLLECTOR(sc) + " collector = super.createSpellingProblemCollector();");
		sc.addLineBreak();
		sc.add("return new " + I_SPELLING_PROBLEM_COLLECTOR(sc) + "() {");
		sc.addLineBreak();
		sc.add("public void accept(" + SPELLING_PROBLEM(sc) + " problem) {");
		sc.add("int offset = problem.getOffset();");
		sc.add("int length = problem.getLength();");
		sc.add("if (sourceViewer == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(I_DOCUMENT(sc) + " document = sourceViewer.getDocument();");
		sc.add("if (document == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("String text;");
		sc.add("try {");
		sc.add("text = document.get(offset, length);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION(sc) + " e) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (new " + ignoredWordsFilterClassName + "().ignoreWord(text)) {");
		sc.add("return;");
		sc.add("}");
		sc.add("collector.accept(problem);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void beginCollecting() {");
		sc.add("collector.beginCollecting();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void endCollecting() {");
		sc.add("collector.endCollecting();");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.add("};");
		sc.addLineBreak();
		sc.add(MONO_RECONCILER(sc) + " reconciler = new " + MONO_RECONCILER(sc) + "(strategy, false);");
		sc.add("reconciler.setDelay(500);");
		sc.add("return reconciler;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetQuickAssistAssistantMethod(JavaComposite sc) {
		sc.add("public " + I_QUICK_ASSIST_ASSISTANT(sc) + " getQuickAssistAssistant(" + I_SOURCE_VIEWER(sc) + " sourceViewer) {");
		sc.add("if (quickAssistAssistant == null) {");
		sc.add("quickAssistAssistant = new " + quickAssistAssistantClassName + "(resourceProvider, annotationModelProvider);");
		sc.add("}");
		sc.add("return quickAssistAssistant;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHyperlinkDetectorsMethod(JavaComposite sc) {
		sc.add("public " + I_HYPERLINK_DETECTOR(sc) + "[] getHyperlinkDetectors(" + I_SOURCE_VIEWER(sc) + " sourceViewer) {");
		sc.add("if (sourceViewer == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return new " + I_HYPERLINK_DETECTOR(sc) + "[] { new " + hyperlinkDetectorClassName + "(resourceProvider.getResource()) };");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTextHoverMethod(JavaComposite sc) {
		sc.add("public " + I_TEXT_HOVER(sc) + " getTextHover(" + I_SOURCE_VIEWER(sc) + " sourceViewer, String contentType) {");
		sc.add("return new " + textHoverClassName + "(resourceProvider);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAnnotationHoverMethod(JavaComposite sc) {
		sc.add("public " + I_ANNOTATION_HOVER(sc) + " getAnnotationHover(" + I_SOURCE_VIEWER(sc) + " sourceViewer) {");
		sc.add("return new " + DEFAULT_ANNOTATION_HOVER(sc) + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPresentationReconcilerMethod(JavaComposite sc) {
		sc.add("public " + I_PRESENTATION_RECONCILER(sc) + " getPresentationReconciler(" + I_SOURCE_VIEWER(sc) + " sourceViewer) {");
		sc.addLineBreak();
		sc.add(PRESENTATION_RECONCILER(sc) + " reconciler = new " + PRESENTATION_RECONCILER(sc) + "();");
		sc.add(DEFAULT_DAMAGER_REPAIRER(sc) + " repairer = new " + DEFAULT_DAMAGER_REPAIRER(sc) + "(getScanner());");
		sc.add("reconciler.setDamager(repairer, " + I_DOCUMENT(sc) + ".DEFAULT_CONTENT_TYPE);");
		sc.add("reconciler.setRepairer(repairer, " + I_DOCUMENT(sc) + ".DEFAULT_CONTENT_TYPE);");
		sc.addLineBreak();
		sc.add("return reconciler;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetScannerMethod(JavaComposite sc) {
		sc.add("protected " + I_TOKEN_SCANNER(sc) + " getScanner() {");
		sc.add("if (tokenScanner == null) {");
		sc.add("tokenScanner = new " + uiMetaInformationClassName + "().createTokenScanner(resourceProvider.getResource(), colorManager);");
		sc.add("}");
		sc.add("return tokenScanner;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetConfiguredContentTypesMethod(JavaComposite sc) {
		sc.add("public String[] getConfiguredContentTypes(" + I_SOURCE_VIEWER(sc) + " sourceViewer) {");
		sc.add("return new String[] {");
		sc.add(I_DOCUMENT(sc) + ".DEFAULT_CONTENT_TYPE,");
		sc.add("};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContentAssistantMethod(JavaComposite sc) {
		sc.add("public " + I_CONTENT_ASSISTANT(sc) + " getContentAssistant(" + I_SOURCE_VIEWER(sc) + " sourceViewer) {");
		sc.addLineBreak();
		sc.add(CONTENT_ASSISTANT(sc) + " assistant = new " + CONTENT_ASSISTANT(sc) + "();");
		sc.add("assistant.setContentAssistProcessor(new " + completionProcessorClassName + "(resourceProvider), " + I_DOCUMENT(sc) + ".DEFAULT_CONTENT_TYPE);");
		sc.add("assistant.enableAutoActivation(true);");
		sc.add("assistant.setAutoActivationDelay(500);");
		sc.add("assistant.setProposalPopupOrientation(" + I_CONTENT_ASSISTANT(sc) + ".PROPOSAL_OVERLAY);");
		sc.add("assistant.setContextInformationPopupOrientation(" + I_CONTENT_ASSISTANT(sc) + ".CONTEXT_INFO_ABOVE);");
		sc.addLineBreak();
		sc.add("return assistant;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetDefaultPrefixesMethod(JavaComposite sc) {
		// TODO Use tokens from CS
		sc.add("@Override");
		sc.addLineBreak();
		sc.add("public String[] getDefaultPrefixes(" + I_SOURCE_VIEWER(sc) + " sourceViewer, String contentType) {");
		sc.add("return new String[] { \"//\" };");
		sc.add("}");
		sc.addLineBreak();
	}
}
