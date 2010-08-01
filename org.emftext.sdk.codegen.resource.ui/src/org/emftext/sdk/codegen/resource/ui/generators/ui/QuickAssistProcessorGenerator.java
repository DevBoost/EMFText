package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ANNOTATION_MODEL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_COMPLETION_PROPOSAL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTEXT_INFORMATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_QUICK_ASSIST_INVOCATION_CONTEXT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_QUICK_ASSIST_PROCESSOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.POINT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.POSITION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TEXT_INVOCATION_CONTEXT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.*;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class QuickAssistProcessorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_QUICK_ASSIST_PROCESSOR + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addCanAssistMethod(sc);
		addCanFixMethod(sc);
		addComputeQuickAssistProposalsMethod(sc);
		addCreateCompletionProposalMethod(sc);
		addGetQuickFixesMethod(sc);
		addGetAnnotationModelMethod(sc);
		addGetQuickFixMethod(sc);
		addGetErrorMessageMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + editorClassName + " editor;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + editorClassName + " editor) {");
		sc.add("super();");
		sc.add("this.editor = editor;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanAssistMethod(JavaComposite sc) {
		sc.add("public boolean canAssist(" + I_QUICK_ASSIST_INVOCATION_CONTEXT + " invocationContext) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanFixMethod(JavaComposite sc) {
		sc.add("public boolean canFix(" + ANNOTATION + " annotation) {");
		sc.add(COLLECTION + "<" + iQuickFixClassName + "> quickFixes = getQuickFixes(annotation);");
		sc.add("return quickFixes.size() > 0;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addComputeQuickAssistProposalsMethod(JavaComposite sc) {
		sc.add("public " + I_COMPLETION_PROPOSAL + "[] computeQuickAssistProposals(");
		sc.add(I_QUICK_ASSIST_INVOCATION_CONTEXT + " invocationContext) {");
		sc.add(I_SOURCE_VIEWER + " sourceViewer = invocationContext.getSourceViewer();");
		sc.add("int offset = -1;");
		sc.add("int length = 0;");
		sc.add("if (invocationContext instanceof " + TEXT_INVOCATION_CONTEXT + ") {");
		sc.add(TEXT_INVOCATION_CONTEXT + " textContext = (" + TEXT_INVOCATION_CONTEXT + ") invocationContext;");
		sc.add("offset = textContext.getOffset();");
		sc.add("length = textContext.getLength();");
		sc.add("}");
		sc.add(LIST + "<" + iQuickFixClassName + "> quickFixes = getQuickFixes(sourceViewer, offset, length);");
		sc.add(I_COMPLETION_PROPOSAL + "[] proposals = new " + I_COMPLETION_PROPOSAL + "[quickFixes.size()];");
		sc.add("for (int i = 0; i < proposals.length; i++) {");
		sc.add("proposals[i] = createCompletionProposal(sourceViewer, quickFixes.get(i));");
		sc.add("}");
		sc.add("return proposals;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateCompletionProposalMethod(JavaComposite sc) {
		sc.add("private " + I_COMPLETION_PROPOSAL + " createCompletionProposal(final " + I_SOURCE_VIEWER + " sourceViewer, final " + iQuickFixClassName + " quickFix) {");
		sc.add("return new " + I_COMPLETION_PROPOSAL + "() {");
		sc.addLineBreak();
		sc.add("public " + POINT + " getSelection(" + I_DOCUMENT + " document) {");
		sc.add("// TODO Auto-generated method stub");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + IMAGE + " getImage() {");
		sc.add("// TODO Auto-generated method stub");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getDisplayString() {");
		sc.add("return quickFix.getDisplayString();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + I_CONTEXT_INFORMATION + " getContextInformation() {");
		sc.add("// TODO Auto-generated method stub");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getAdditionalProposalInfo() {");
		sc.add("// TODO Auto-generated method stub");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void apply(" + I_DOCUMENT + " document) {");
		sc.add("String currentContent = sourceViewer.getDocument().get();");
		sc.add("String newContent = quickFix.apply(currentContent);");
		sc.add("if (newContent != null) {");
		sc.add("// TODO maybe it is better to replace only the changed");
		sc.add("// part of the document");
		sc.add("sourceViewer.getDocument().set(newContent);");
		sc.add("}");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetQuickFixesMethod(JavaComposite sc) {
		sc.add("private " + LIST + "<" + iQuickFixClassName + "> getQuickFixes(" + I_SOURCE_VIEWER + " sourceViewer, int offset, int length) {");
		sc.add(LIST + "<" + iQuickFixClassName + "> foundFixes = new " + ARRAY_LIST + "<" + iQuickFixClassName + ">();");
		sc.add(I_ANNOTATION_MODEL + " model = getAnnotationModel();");
		sc.addLineBreak();
		sc.add("if (model == null) {");
		sc.add("return foundFixes;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(ITERATOR + "<?> iter = model.getAnnotationIterator();");
		sc.add("while (iter.hasNext()) {");
		sc.add(ANNOTATION + " annotation = (" + ANNOTATION + ") iter.next();");
		sc.add(POSITION + " position = model.getPosition(annotation);");
		sc.add("if (offset >= 0) {");
		sc.add("if (!position.overlapsWith(offset, length)) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("}");
		sc.add(COLLECTION + "<" + iQuickFixClassName + "> quickFixes = getQuickFixes(annotation);");
		sc.add("if (quickFixes != null) {");
		sc.add("foundFixes.addAll(quickFixes);");
		sc.add("}");
		sc.add("}");
		sc.add("return foundFixes;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAnnotationModelMethod(JavaComposite sc) {
		sc.add("private " + I_ANNOTATION_MODEL + " getAnnotationModel() {");
		sc.add("return editor.getDocumentProvider().getAnnotationModel(editor.getEditorInput());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetQuickFixMethod(JavaComposite sc) {
		sc.add("private " + COLLECTION + "<" + iQuickFixClassName + "> getQuickFixes(" + ANNOTATION + " annotation) {");
		sc.addLineBreak();
		sc.add(COLLECTION + "<" + iQuickFixClassName + "> foundQuickFixes = new " + ARRAY_LIST + "<" + iQuickFixClassName + ">();");
		sc.add("if (annotation.isMarkedDeleted()) {");
		sc.add("return foundQuickFixes;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (annotation instanceof " + markerAnnotationClassName + ") {");
		sc.add(markerAnnotationClassName + " markerAnnotation = (" + markerAnnotationClassName + ") annotation;");
		sc.add(I_MARKER + " marker = markerAnnotation.getMarker();");
		sc.add("try {");
		sc.add("Object quickFixValue = marker.getAttribute(" + I_MARKER + ".SOURCE_ID);");
		sc.add("if (quickFixValue != null && quickFixValue instanceof String) {");
		sc.add("String quickFixContexts = (String) quickFixValue;");
		sc.add("String[] quickFixContextParts = quickFixContexts.split(\"\\\\|\");");
		sc.add("for (String quickFixContext : quickFixContextParts) {");
		sc.add(iQuickFixClassName + " quickFix = editor.getResource().getQuickFix(quickFixContext);");
		sc.add("if (quickFix != null) {");
		//sc.add("System.out.println(\"getQuickFixes() found \" + quickFix);");
		sc.add("foundQuickFixes.add(quickFix);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + CORE_EXCEPTION + " ce) {");
		sc.add("if (ce.getMessage().matches(\"Marker.*not found.\")) {");
		sc.add("// ignore");
		sc.add("System.out.println(\"getQuickFixes() marker not found: \" + ce.getMessage());");
		sc.add("} else {");
		sc.add("ce.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return foundQuickFixes;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetErrorMessageMethod(JavaComposite sc) {
		sc.add("public String getErrorMessage() {");
		sc.add("// TODO Auto-generated method stub");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
}
