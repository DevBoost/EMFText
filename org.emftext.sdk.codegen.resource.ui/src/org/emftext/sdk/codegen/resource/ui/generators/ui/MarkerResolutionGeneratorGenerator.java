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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER_RESOLUTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER_RESOLUTION2;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER_RESOLUTION_GENERATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE_SET_IMPL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.interfaces.IOptionsGenerator;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class MarkerResolutionGeneratorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_MARKER_RESOLUTION_GENERATOR + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetResolutionsMethod(sc);
		addGetQuickFixesMethod(sc);
		addGetQuickFixContextStringMethod(sc);
		addHasQuickFixesMethod(sc);
	}

	private void addGetResolutionsMethod(JavaComposite sc) {
		sc.add("public " + I_MARKER_RESOLUTION + "[] getResolutions(" + I_MARKER + " marker) {");
		sc.add("try {");
		sc.add("if (!hasQuickFixes(marker)) {");
		sc.add("return new " + I_MARKER_RESOLUTION + "[] {};");
		sc.add("}");
		sc.add(I_RESOURCE + " resource = marker.getResource();");
		sc.add("if (resource instanceof " + I_FILE + ") {");
		sc.add("// load model");
		sc.add("final " + I_FILE + " file = (" + I_FILE + ") resource;");
		sc.add(URI + " uri = " + URI + ".createPlatformResourceURI(file.getFullPath().toString(), true);");
		sc.add(RESOURCE_SET + " rs = new " + RESOURCE_SET_IMPL + "();");
		sc.add("rs.getLoadOptions().put(" + iOptionsClassName + "." + IOptionsGenerator.DISABLE_CREATING_MARKERS_FOR_PROBLEMS + ", \"true\");");
		sc.add(RESOURCE + " emfResource = rs.getResource(uri, true);");
		sc.add("if (emfResource instanceof " + textResourceClassName + ") {");
		sc.add(textResourceClassName + " customResource = (" + textResourceClassName + ") emfResource;");
		sc.add(ECORE_UTIL + ".resolveAll(customResource);");
		sc.add(COLLECTION + "<" + iQuickFixClassName + "> quickFixes = getQuickFixes(customResource, marker);");
		sc.add(LIST + "<" + I_MARKER_RESOLUTION2 + "> resolutions = new " + ARRAY_LIST + "<" + I_MARKER_RESOLUTION2 + ">();");
		sc.add("for (final " + iQuickFixClassName + " quickFix : quickFixes) {");
		sc.add("resolutions.add(new " + I_MARKER_RESOLUTION2 + "() {");
		sc.addLineBreak();
		sc.add("public void run(" + I_MARKER + " marker) {");
		// TODO do we need to pass the old text here?
		sc.add("String newText = quickFix.apply(null);");
		sc.addComment("set new text as content for resource");
		sc.add("try {");
		sc.add("file.setContents(new " + BYTE_ARRAY_INPUT_STREAM + "(newText.getBytes()), true, true, null);");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while applying quick fix\", e);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getLabel() {");
		sc.add("return quickFix.getDisplayString();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + IMAGE + " getImage() {");
		sc.add("return new " + uiMetaInformationClassName + "().getImageProvider().getImage(quickFix.getImageKey());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getDescription() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("});");
		sc.add("}");
		sc.add("return resolutions.toArray(new " + I_MARKER_RESOLUTION + "[resolutions.size()]);");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (Exception e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while computing quick fix resolutions\", e);");
		sc.add("}");
		sc.add("return new " + I_MARKER_RESOLUTION + "[] {};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetQuickFixesMethod(JavaComposite sc) {
		sc.add("public " + COLLECTION + "<" + iQuickFixClassName + "> getQuickFixes(" + iTextResourceClassName + " resource, " + I_MARKER + " marker) {");
		sc.add(COLLECTION + "<" + iQuickFixClassName + "> foundQuickFixes = new " + ARRAY_LIST + "<" + iQuickFixClassName + ">();");
		sc.add("try {");
		sc.add("String quickFixContexts = getQuickFixContextString(marker);");
		sc.add("if (quickFixContexts != null) {");
		sc.add("String[] quickFixContextParts = quickFixContexts.split(\"\\\\|\");");
		sc.add("for (String quickFixContext : quickFixContextParts) {");
		sc.add(iQuickFixClassName + " quickFix = resource.getQuickFix(quickFixContext);");
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
		sc.add("return foundQuickFixes;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetQuickFixContextStringMethod(JavaComposite sc) {
		sc.add("private String getQuickFixContextString(" + I_MARKER + " marker) throws " + CORE_EXCEPTION + " {");
		sc.add("Object quickFixValue = marker.getAttribute(" + I_MARKER + ".SOURCE_ID);");
		sc.add("if (quickFixValue != null && quickFixValue instanceof String) {");
		sc.add("return (String) quickFixValue;");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
	}

	private void addHasQuickFixesMethod(JavaComposite sc) {
		sc.add("private boolean hasQuickFixes(" + I_MARKER + " marker) throws " + CORE_EXCEPTION + " {");
		sc.add("return getQuickFixContextString(marker) != null;");
		sc.add("}");
	}
}
