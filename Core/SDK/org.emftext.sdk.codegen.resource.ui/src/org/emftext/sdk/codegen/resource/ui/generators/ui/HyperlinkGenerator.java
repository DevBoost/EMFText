/*******************************************************************************
 * Copyright (c) 2006-2012
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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.EDITING_DOMAIN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FILE_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_EDITING_DOMAIN_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_EDITOR_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_EDITOR_PART;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_HYPERLINK;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_REGION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_VIEWER_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKBENCH_PAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKSPACE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKSPACE_ROOT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PART_INIT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PATH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PLATFORM_UI;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.URI;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.VIEWER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class HyperlinkGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();

		sc.addJavadoc("A hyperlink for the proxy elements in source code.");
		sc.add("public class " + getResourceClassName() + " implements " + I_HYPERLINK + " {");
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

	private void addGetHyperlinkRegionMethod(StringComposite sc) {
		sc.add("public " + I_REGION + " getHyperlinkRegion() {");
		sc.add("return region;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetIFileFromResourceMethod(StringComposite sc) {
		sc.add("private " + I_FILE + " getIFileFromResource() {");
		sc.add(RESOURCE + " linkTargetResource = linkTarget.eResource();");
		sc.add("if (linkTargetResource == null) {");
		sc.add("return null;");
		sc.add("}");
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
		sc.add(I_FILE + " file = getIFileFromResource();");
		sc.add("if (file != null) {");
		sc.add(I_WORKBENCH + " workbench = " + PLATFORM_UI + ".getWorkbench();");
		sc.add(I_WORKBENCH_PAGE + " page = workbench.getActiveWorkbenchWindow().getActivePage();");
		sc.add("try {");
		sc.add(I_EDITOR_DESCRIPTOR + " desc = workbench.getEditorRegistry().getDefaultEditor(file.getName());");
		sc.add("if (desc == null) {");
		sc.add("desc = workbench.getEditorRegistry().findEditor(\"org.eclipse.emf.ecore.presentation.ReflectiveEditorID\");");
		sc.add("}");
		sc.add(I_EDITOR_PART + " editorPart = page.openEditor(new " + FILE_EDITOR_INPUT + "(file), desc.getId());");
		sc.add("if (editorPart instanceof " + I_EDITING_DOMAIN_PROVIDER + ") {");
		sc.add(I_EDITING_DOMAIN_PROVIDER + " editingDomainProvider = (" + I_EDITING_DOMAIN_PROVIDER + ") editorPart;");
		sc.add(EDITING_DOMAIN + " editingDomain = editingDomainProvider.getEditingDomain();");
		sc.add(URI + " uri = " + ECORE_UTIL + ".getURI(linkTarget);");
		sc.add(E_OBJECT + " originalObject = editingDomain.getResourceSet().getEObject(uri, true);");
		sc.add("if (editingDomainProvider instanceof " + I_VIEWER_PROVIDER + ") {");
		sc.add(I_VIEWER_PROVIDER + " viewerProvider = (" + I_VIEWER_PROVIDER + ") editingDomainProvider;");
		sc.add(VIEWER + " viewer = viewerProvider.getViewer();");
		sc.add("viewer.setSelection(new " + STRUCTURED_SELECTION + "(originalObject), true);");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + PART_INIT_EXCEPTION + " e) {");
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
}
