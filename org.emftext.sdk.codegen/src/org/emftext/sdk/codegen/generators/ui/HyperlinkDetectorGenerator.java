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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_HYPERLINK;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_HYPERLINK_DETECTOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_REGION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_VIEWER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.REGION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class HyperlinkDetectorGenerator extends JavaBaseGenerator {

	private String hyperlinkClassName;

	public HyperlinkDetectorGenerator() {
		super();
	}

	private HyperlinkDetectorGenerator(GenerationContext context) {
		super(context, EArtifact.HYPERLINK_DETECTOR);
		hyperlinkClassName = getContext().getQualifiedClassName(EArtifact.HYPERLINK);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A hyperlink detector returns hyperlink if the token, where the mouse cursor");
		sc.add("// hovers, is a proxy.");
		sc.add("public class " + getResourceClassName() + " implements " + I_HYPERLINK_DETECTOR + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addDetectHyperlinksMethod(sc);
		
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + getClassNameHelper().getI_TEXT_RESOURCE() + " textResource;");
		sc.addLineBreak();
	}

	private void addDetectHyperlinksMethod(StringComposite sc) {
		sc.add("public " + I_HYPERLINK + "[] detectHyperlinks(" + I_TEXT_VIEWER + " textViewer, " + I_REGION + " region, boolean canShowMultipleHyperlinks) {");
		sc.add(getClassNameHelper().getI_LOCATION_MAP() + " locationMap = textResource.getLocationMap();");
		sc.add(LIST + "<" + E_OBJECT + "> elementsAtOffset = locationMap.getElementsAt(region.getOffset());");
		sc.add(E_OBJECT + " resolvedEObject = null;");
		sc.add("for (" + E_OBJECT + " eObject : elementsAtOffset) {");
		sc.add("if (eObject.eIsProxy()) {");
		sc.add("resolvedEObject = " + ECORE_UTIL + ".resolve(eObject, textResource);");
		sc.add("if (resolvedEObject == eObject) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("int offset = locationMap.getCharStart(eObject);");
		sc.add("int length = locationMap.getCharEnd(eObject) - offset + 1;");
		sc.add("String text = null;");
		sc.add("try {");
		sc.add("text = textViewer.getDocument().get(offset, length);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.add("}");
		sc.add(I_HYPERLINK + " hyperlink = new " + hyperlinkClassName + "(new " + REGION + "(offset, length), resolvedEObject, text);");
		sc.add("return new " + I_HYPERLINK + "[] { hyperlink };");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
	}

	private void addConstructor(StringComposite sc) {
		sc.add("// Creates a hyperlink detector.");
		sc.add("// @param resource the resource for calculating the locations.");
		sc.add("public " + getResourceClassName() + "(" + RESOURCE + " resource) {");
		sc.add("textResource = (" + getClassNameHelper().getI_TEXT_RESOURCE() + ") resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new HyperlinkDetectorGenerator(context);
	}
}
