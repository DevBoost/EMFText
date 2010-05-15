/*******************************************************************************
 * Copyright (c) 2006-2010 
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
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TEXT_HOVER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TOKEN_SCANNER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PRESENTATION_RECONCILER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SOURCE_VIEWER_CONFIGURATION;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class EditorConfigurationGenerator extends UIJavaBaseGenerator {

	public static final GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new EditorConfigurationGenerator());

	private EditorConfigurationGenerator() {
		super();
	}

	private EditorConfigurationGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceUIArtifacts.EDITOR_CONFIGURATION);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
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
		return true;
	}

	private void addMethods(JavaComposite sc) {
		addGetContentAssistantMethod(sc);
		addGetConfiguredContentTypesMethod(sc);
		addGetScannerMethod(sc);
		addGetPresentationReconcilerMethod(sc);
		addGetAnnotationHoverMethod(sc);
		addGetTextHoverMethod(sc);
		addGetHyperlinkDetectorsMethod(sc);
	}

	private void addGetHyperlinkDetectorsMethod(StringComposite sc) {
		sc.add("public " + I_HYPERLINK_DETECTOR + "[] getHyperlinkDetectors(" + I_SOURCE_VIEWER + " sourceViewer) {");
		sc.add("if (sourceViewer == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return new " + I_HYPERLINK_DETECTOR + "[] { new " + hyperlinkDetectorClassName + "(theEditor.getResource()) };");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTextHoverMethod(StringComposite sc) {
		sc.add("public " + I_TEXT_HOVER + " getTextHover(" + I_SOURCE_VIEWER + " sourceViewer, String contentType) {");
		sc.add("return new " + textHoverClassName + "(theEditor);");
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
		sc.add("String fileName = theEditor.getEditorInput().getName();");
		sc.addLineBreak();
		sc.add(DEFAULT_DAMAGER_REPAIRER + " repairer = new " + DEFAULT_DAMAGER_REPAIRER + "(getScanner(fileName));");
		sc.add("reconciler.setDamager(repairer, " + I_DOCUMENT + ".DEFAULT_CONTENT_TYPE);");
		sc.add("reconciler.setRepairer(repairer, " + I_DOCUMENT + ".DEFAULT_CONTENT_TYPE);");
		sc.addLineBreak();
		sc.add("return reconciler;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetScannerMethod(JavaComposite sc) {
		sc.add("protected " + I_TOKEN_SCANNER + " getScanner(String fileName) {");
		sc.add("return new " + tokenScannerClassName + "(colorManager);");
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
		sc.add("assistant.setContentAssistProcessor(new " + completionProcessorClassName + "(theEditor), " + I_DOCUMENT + ".DEFAULT_CONTENT_TYPE);");
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
			"@param editor the editor to configure",
			"@param colorManager the color manager to use"
		);
		sc.add("public " + getResourceClassName() + "(" + editorClassName + " editor, " + colorManagerClassName + " colorManager) {");
		sc.add("this.theEditor = editor;");
		sc.add("this.colorManager = colorManager;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + colorManagerClassName + " colorManager;");
		sc.add("private " + editorClassName + " theEditor;");
		sc.addLineBreak();
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new EditorConfigurationGenerator(parent, context);
	}
}
