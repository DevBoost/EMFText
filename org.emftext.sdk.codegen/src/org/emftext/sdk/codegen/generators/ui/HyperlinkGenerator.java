package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.FILE_EDITOR_INPUT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_EDITOR_DESCRIPTOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_EDITOR_PART;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_HYPERLINK;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_REGION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKBENCH_PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKSPACE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKSPACE_ROOT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PART_INIT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PATH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PLATFORM_UI;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI_CONVERTER;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class HyperlinkGenerator extends BaseGenerator {

	private String editorClassName;

	public HyperlinkGenerator() {
		super();
	}

	private HyperlinkGenerator(GenerationContext context) {
		super(context, EArtifact.HYPERLINK);
		editorClassName = getContext().getQualifiedClassName(EArtifact.EDITOR);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A hyperlink for the proxy elements in source code.");
		sc.add("public class " + getResourceClassName() + " implements " + I_HYPERLINK + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addMethods(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		addGetHyperlinkTextMethod(sc);
		addLengthMethod(sc);
		addGetTypeLabelMethod(sc);
		addOpenMethod(sc);
		addIsSupportedMethod(sc);
		addGetIFileFromResourceMethod(sc);
		addGetHyperlinkRegionMethod(sc);
	}

	private void addGetHyperlinkRegionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + I_REGION + " getHyperlinkRegion() {");
		sc.add("return region;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetIFileFromResourceMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private " + I_FILE + " getIFileFromResource() {");
		sc.add(URI + " resourceURI = linkTarget.eResource().getURI();");
		sc.add("if (resourceURI.toString().startsWith(\"pathmap\")) {");
		sc.add("resourceURI = " + URI_CONVERTER + ".URI_MAP.get(resourceURI);");
		sc.add("}");
		sc.add("if (resourceURI.isPlatformResource()) {");
		sc.add("String platformString = resourceURI.toPlatformString(true);");
		sc.add("if (platformString != null) {");
		sc.add(I_WORKSPACE + " workspace = " + RESOURCES_PLUGIN + ".getWorkspace();");
		sc.add(I_WORKSPACE_ROOT + " root = workspace.getRoot();");
		sc.add("return root.getFile(new " + PATH + "(platformString));");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsSupportedMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private boolean isSupported(String fileExtension) {");
		sc.add(LIST + "<" + getClassNameHelper().getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() + "> extensions = " + getClassNameHelper().getEMFTEXT_RUNTIME_PLUGIN() + ".getConcreteSyntaxRegistry();");
		sc.add("for (" + getClassNameHelper().getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() + " extension : extensions) {");
		sc.add("if (extension.getSyntaxName().equals(fileExtension)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addOpenMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Opens the resource in <code>linkTarget</code> with");
		sc.add("// EMFText editor, if it supports the file extension of this");
		sc.add("// resource, and tries to jump to the definition. Else it tries to open with");
		sc.add("// a default editor.");
		sc.add("public void open() {");
		sc.add("if (linkTarget == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(I_FILE + " file = getIFileFromResource();");
		sc.add("if (file != null) {");
		sc.add(I_WORKBENCH + " workbench = " + PLATFORM_UI + ".getWorkbench();");
		sc.add(I_WORKBENCH_PAGE + " page = workbench.getActiveWorkbenchWindow().getActivePage();");
		sc.add("try {");
		//FIXME the EditorID has to be of EMFTextEditor
		sc.add(I_EDITOR_PART + " activeEditor = page.getActiveEditor();");
		sc.add("if (isSupported(file.getFileExtension())) {");
		sc.add("page.openEditor(new " + FILE_EDITOR_INPUT + "(file), activeEditor.getSite().getId());");
		sc.add("} else {");
		sc.add(I_EDITOR_DESCRIPTOR + " desc = workbench.getEditorRegistry().getDefaultEditor(file.getName());");
		sc.add("page.openEditor(new " + FILE_EDITOR_INPUT + "(file), desc.getId());");
		sc.add("}");
		sc.add(I_EDITOR_PART + " editorPart = activeEditor;");
		sc.add("if (editorPart instanceof " + editorClassName + ") {");
		sc.add(editorClassName + " emftEditor = (" + editorClassName + ") editorPart;");
		sc.add("emftEditor.setCaret(linkTarget, text);");
		sc.add("}");
		sc.add("} catch (" + PART_INIT_EXCEPTION + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTypeLabelMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public String getTypeLabel() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLengthMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// @return the length of the hyperlink text");
		sc.add("public int length() {");
		sc.add("return text.length();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHyperlinkTextMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public String getHyperlinkText() {");
		sc.add("return text;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Creates the hyperlink.");
		sc.add("//");
		sc.add("// @param region");
		sc.add("//            the region of the hyperlink to highlight");
		sc.add("// @param linkTarget the link target where this hyperlink should go to");
		sc.add("// @param targetText the text to specify the target position in the <code>linkTarget</code>");
		sc.add("public " + getResourceClassName() + "(" + I_REGION + " region, " + E_OBJECT + " linkTarget, String targetText) {");
		sc.add("this.region = region;");
		sc.add("this.linkTarget = linkTarget;");
		sc.add("this.text = targetText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private String text;");
		sc.add("private " + E_OBJECT + " linkTarget;");
		sc.add("private " + I_REGION + " region;");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new HyperlinkGenerator(context);
	}
}
