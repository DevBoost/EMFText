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
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PART_INIT_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PATH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PLATFORM_UI;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class HyperlinkGenerator extends JavaBaseGenerator {

	private String editorClassName;

	public HyperlinkGenerator() {
		super();
	}

	private HyperlinkGenerator(GenerationContext context) {
		super(context, EArtifact.HYPERLINK);
		editorClassName = getContext().getQualifiedClassName(EArtifact.EDITOR);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A hyperlink for the proxy elements in source code.");
		sc.add("public class " + getResourceClassName() + " implements " + I_HYPERLINK + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
		addGetHyperlinkTextMethod(sc);
		addLengthMethod(sc);
		addGetTypeLabelMethod(sc);
		addOpenMethod(sc);
		addGetIFileFromResourceMethod(sc);
		addGetHyperlinkRegionMethod(sc);
	}

	private void addGetHyperlinkRegionMethod(StringComposite sc) {
		sc.add("public " + I_REGION + " getHyperlinkRegion() {");
		sc.add("return region;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetIFileFromResourceMethod(StringComposite sc) {
		sc.add("private " + I_FILE + " getIFileFromResource() {");
		sc.add(RESOURCE + " linkTargetResource = linkTarget.eResource();");
		sc.add(URI + " resourceURI = linkTargetResource.getURI();");
		sc.add("if (linkTargetResource.getResourceSet() != null && linkTargetResource.getResourceSet().getURIConverter() != null) {");
		sc.add("resourceURI = linkTargetResource.getResourceSet().getURIConverter().normalize(resourceURI);");
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

	private void addOpenMethod(StringComposite sc) {
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
		sc.add(I_EDITOR_DESCRIPTOR + " desc = workbench.getEditorRegistry().getDefaultEditor(file.getName());");
		sc.add(I_EDITOR_PART + " editorPart = page.openEditor(new " + FILE_EDITOR_INPUT + "(file), desc.getId());");
		//TODO Here we could use the access plugin to call setCaret() on other EMFText editors as well
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

	private void addGetTypeLabelMethod(StringComposite sc) {
		sc.add("public String getTypeLabel() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLengthMethod(StringComposite sc) {
		sc.add("// @return the length of the hyperlink text");
		sc.add("public int length() {");
		sc.add("return text.length();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHyperlinkTextMethod(
			StringComposite sc) {
		sc.add("public String getHyperlinkText() {");
		sc.add("return text;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
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

	private void addFields(StringComposite sc) {
		sc.add("private String text;");
		sc.add("private " + E_OBJECT + " linkTarget;");
		sc.add("private " + I_REGION + " region;");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new HyperlinkGenerator(context);
	}
}
