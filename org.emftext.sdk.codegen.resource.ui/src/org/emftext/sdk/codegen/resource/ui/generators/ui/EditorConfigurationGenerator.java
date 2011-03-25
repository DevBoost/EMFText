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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CONTENT_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.DEFAULT_ANNOTATION_HOVER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.DEFAULT_DAMAGER_REPAIRER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ANNOTATION_HOVER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTENT_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_HYPERLINK_DETECTOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PRESENTATION_RECONCILER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_QUICK_ASSIST_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TEXT_HOVER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TOKEN_SCANNER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PRESENTATION_RECONCILER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SOURCE_VIEWER_CONFIGURATION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class EditorConfigurationGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"This class provides the configuration for the generated editor. " +
			"It registers content assistance and syntax highlighting."
		);
		sc.add("public class " + getResourceClassName() + " extends " + SOURCE_VIEWER_CONFIGURATION + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetContentAssistantMethod(sc);
		addGetConfiguredContentTypesMethod(sc);
		addGetScannerMethod(sc);
		addGetPresentationReconcilerMethod(sc);
		addGetAnnotationHoverMethod(sc);
		addGetTextHoverMethod(sc);
		addGetHyperlinkDetectorsMethod(sc);
		addGetQuickAssistAssistantMethod(sc);
	}

	private void addGetQuickAssistAssistantMethod(JavaComposite sc) {
		sc.add("public " + I_QUICK_ASSIST_ASSISTANT + " getQuickAssistAssistant(" + I_SOURCE_VIEWER + " sourceViewer) {");
		sc.add("if (quickAssistAssistant == null) {");
		sc.add("quickAssistAssistant = new " + quickAssistAssistantClassName + "(resourceProvider, annotationModelProvider);");
		sc.add("}");
		sc.add("return quickAssistAssistant;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHyperlinkDetectorsMethod(StringComposite sc) {
		sc.add("public " + I_HYPERLINK_DETECTOR + "[] getHyperlinkDetectors(" + I_SOURCE_VIEWER + " sourceViewer) {");
		sc.add("if (sourceViewer == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return new " + I_HYPERLINK_DETECTOR + "[] { new " + hyperlinkDetectorClassName + "(resourceProvider.getResource()) };");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTextHoverMethod(StringComposite sc) {
		sc.add("public " + I_TEXT_HOVER + " getTextHover(" + I_SOURCE_VIEWER + " sourceViewer, String contentType) {");
		sc.add("return new " + textHoverClassName + "(resourceProvider);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAnnotationHoverMethod(StringComposite sc) {
		sc.add("public " + I_ANNOTATION_HOVER + " getAnnotationHover(" + I_SOURCE_VIEWER + " sourceViewer) {");
		sc.add("return new " + DEFAULT_ANNOTATION_HOVER + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPresentationReconcilerMethod(StringComposite sc) {
		sc.add("public " + I_PRESENTATION_RECONCILER + " getPresentationReconciler(" + I_SOURCE_VIEWER + " sourceViewer) {");
		sc.addLineBreak();
		sc.add(PRESENTATION_RECONCILER + " reconciler = new " + PRESENTATION_RECONCILER + "();");
		sc.add(DEFAULT_DAMAGER_REPAIRER + " repairer = new " + DEFAULT_DAMAGER_REPAIRER + "(getScanner());");
		sc.add("reconciler.setDamager(repairer, " + I_DOCUMENT + ".DEFAULT_CONTENT_TYPE);");
		sc.add("reconciler.setRepairer(repairer, " + I_DOCUMENT + ".DEFAULT_CONTENT_TYPE);");
		sc.addLineBreak();
		sc.add("return reconciler;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetScannerMethod(JavaComposite sc) {
		sc.add("protected " + I_TOKEN_SCANNER + " getScanner() {");
		sc.add("return new " + tokenScannerClassName + "(resourceProvider.getResource(), colorManager);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetConfiguredContentTypesMethod(StringComposite sc) {
		sc.add("public String[] getConfiguredContentTypes(" + I_SOURCE_VIEWER + " sourceViewer) {");
		sc.add("return new String[] {");
		sc.add(I_DOCUMENT + ".DEFAULT_CONTENT_TYPE,");
		sc.add("};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContentAssistantMethod(StringComposite sc) {
		sc.add("public " + I_CONTENT_ASSISTANT + " getContentAssistant(" + I_SOURCE_VIEWER + " sourceViewer) {");
		sc.addLineBreak();
		sc.add(CONTENT_ASSISTANT + " assistant = new " + CONTENT_ASSISTANT + "();");
		sc.add("assistant.setContentAssistProcessor(new " + completionProcessorClassName + "(resourceProvider, bracketHandlerProvider), " + I_DOCUMENT + ".DEFAULT_CONTENT_TYPE);");
		sc.add("assistant.enableAutoActivation(true);");
		sc.add("assistant.setAutoActivationDelay(500);");
		sc.add("assistant.setProposalPopupOrientation(" + I_CONTENT_ASSISTANT + ".PROPOSAL_OVERLAY);");
		sc.add("assistant.setContextInformationPopupOrientation(" + I_CONTENT_ASSISTANT + ".CONTEXT_INFO_ABOVE);");
		sc.addLineBreak();
		sc.add("return assistant;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a new editor configuration.",
			"@param resourceProvider the provider for the resource (usually this is the editor)",
			"@param colorManager the color manager to use"
		);
		sc.add("public " + getResourceClassName() + "(" + iResourceProviderClassName + " resourceProvider, " + iAnnotationModelProviderClassName + " annotationModelProvider, " + iBracketHandlerProviderClassName + " bracketHandlerProvider, " + colorManagerClassName + " colorManager) {");
		sc.add("this.resourceProvider = resourceProvider;");
		sc.add("this.annotationModelProvider = annotationModelProvider;");
		sc.add("this.bracketHandlerProvider = bracketHandlerProvider;");
		sc.add("this.colorManager = colorManager;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + colorManagerClassName + " colorManager;");
		sc.add("private " + iResourceProviderClassName + " resourceProvider;");
		sc.add("private " + iAnnotationModelProviderClassName + " annotationModelProvider;");
		sc.add("private " + iBracketHandlerProviderClassName + " bracketHandlerProvider;");
		sc.add("private " + quickAssistAssistantClassName + " quickAssistAssistant;");
		sc.addLineBreak();
	}

	
}
