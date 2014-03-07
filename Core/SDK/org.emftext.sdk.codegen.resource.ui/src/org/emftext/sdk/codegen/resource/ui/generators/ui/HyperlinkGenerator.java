/*******************************************************************************
 * Copyright (c) 2006-2014
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

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_WORKSPACE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_WORKSPACE_ROOT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.PATH;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.URI;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.EDITING_DOMAIN;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.FILE_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_EDITING_DOMAIN_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_EDITOR_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_EDITOR_PART;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_HYPERLINK;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_REGION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_VIEWER_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PART_INIT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PLATFORM_UI;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.VIEWER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class HyperlinkGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {

		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();

		sc.addJavadoc("A hyperlink for the proxy elements in source code.");
		sc.add("public class " + getResourceClassName() + " implements " + I_HYPERLINK(sc) + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetHyperlinkTextMethod(sc);
		addLengthMethod(sc);
		addGetTypeLabelMethod(sc);
		addOpenMethod(sc);
		addGetIFileFromResourceMethod(sc);
		addGetHyperlinkRegionMethod(sc);
	}

	private void addGetHyperlinkRegionMethod(JavaComposite sc) {
		sc.add("public " + I_REGION(sc) + " getHyperlinkRegion() {");
		sc.add("return region;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetIFileFromResourceMethod(JavaComposite sc) {
		sc.add("private " + I_FILE(sc) + " getIFileFromResource() {");
		sc.add(RESOURCE(sc) + " linkTargetResource = linkTarget.eResource();");
		sc.add("if (linkTargetResource == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(URI(sc) + " resourceURI = linkTargetResource.getURI();");
		sc.add("if (linkTargetResource.getResourceSet() != null && linkTargetResource.getResourceSet().getURIConverter() != null) {");
		sc.add("resourceURI = linkTargetResource.getResourceSet().getURIConverter().normalize(resourceURI);");
		sc.add("}");
		sc.add("if (resourceURI.isPlatformResource()) {");
		sc.add("String platformString = resourceURI.toPlatformString(true);");
		sc.add("if (platformString != null) {");
		sc.add(I_WORKSPACE(sc) + " workspace = " + RESOURCES_PLUGIN(sc) + ".getWorkspace();");
		sc.add(I_WORKSPACE_ROOT(sc) + " root = workspace.getRoot();");
		sc.add("return root.getFile(new " + PATH(sc) + "(platformString));");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addOpenMethod(JavaComposite sc) {
		sc.addJavadoc(
				"Opens the resource in <code>linkTarget</code> with the generated " +
				"editor, if it supports the file extension of this " +
				"resource, and tries to jump to the definition. Otherwise it tries to open the target with " +
				"the default editor."
		);
		sc.add("public void open() {");
		sc.add("if (linkTarget == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(I_FILE(sc) + " file = getIFileFromResource();");
		sc.add("if (file != null) {");
		sc.add(I_WORKBENCH(sc) + " workbench = " + PLATFORM_UI(sc) + ".getWorkbench();");
		sc.add(I_WORKBENCH_PAGE(sc) + " page = workbench.getActiveWorkbenchWindow().getActivePage();");
		sc.add("try {");
		sc.add(I_EDITOR_DESCRIPTOR(sc) + " desc = workbench.getEditorRegistry().getDefaultEditor(file.getName());");
		sc.add("if (desc == null) {");
		sc.add("desc = workbench.getEditorRegistry().findEditor(\"org.eclipse.emf.ecore.presentation.ReflectiveEditorID\");");
		sc.add("}");
		sc.add(I_EDITOR_PART(sc) + " editorPart = page.openEditor(new " + FILE_EDITOR_INPUT(sc) + "(file), desc.getId());");
		sc.add("if (editorPart instanceof " + I_EDITING_DOMAIN_PROVIDER(sc) + ") {");
		sc.add(I_EDITING_DOMAIN_PROVIDER(sc) + " editingDomainProvider = (" + I_EDITING_DOMAIN_PROVIDER(sc) + ") editorPart;");
		sc.add(EDITING_DOMAIN(sc) + " editingDomain = editingDomainProvider.getEditingDomain();");
		sc.add(URI(sc) + " uri = " + ECORE_UTIL(sc) + ".getURI(linkTarget);");
		sc.add(E_OBJECT(sc) + " originalObject = editingDomain.getResourceSet().getEObject(uri, true);");
		sc.add("if (editingDomainProvider instanceof " + I_VIEWER_PROVIDER(sc) + ") {");
		sc.add(I_VIEWER_PROVIDER(sc) + " viewerProvider = (" + I_VIEWER_PROVIDER(sc) + ") editingDomainProvider;");
		sc.add(VIEWER(sc) + " viewer = viewerProvider.getViewer();");
		sc.add("viewer.setSelection(new " + STRUCTURED_SELECTION(sc) + "(originalObject), true);");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + PART_INIT_EXCEPTION(sc) + " e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Exception while opening hyperlink target.\", e);");
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

	private void addLengthMethod(JavaComposite sc) {
		sc.addJavadoc("@return the length of the hyperlink text");
		sc.add("public int length() {");
		sc.add("return text.length();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHyperlinkTextMethod(StringComposite sc) {
		sc.add("public String getHyperlinkText() {");
		sc.add("return text;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
				"Creates the hyperlink.",
				"@param region the region of the hyperlink to highlight",
				"@param linkTarget the link target where this hyperlink should go to",
				"@param targetText the text to specify the target position in the <code>linkTarget</code>"
		);
		sc.add("public " + getResourceClassName() + "(" + I_REGION(sc) + " region, " + E_OBJECT(sc) + " linkTarget, String targetText) {");
		sc.add("this.region = region;");
		sc.add("this.linkTarget = linkTarget;");
		sc.add("this.text = targetText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private String text;");
		sc.add("private " + E_OBJECT(sc) + " linkTarget;");
		sc.add("private " + I_REGION(sc) + " region;");
		sc.addLineBreak();
	}
}
