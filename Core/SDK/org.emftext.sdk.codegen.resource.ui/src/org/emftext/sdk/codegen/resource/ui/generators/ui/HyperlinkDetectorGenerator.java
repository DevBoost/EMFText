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

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_HYPERLINK;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_HYPERLINK_DETECTOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_REGION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.REGION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class HyperlinkDetectorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A hyperlink detector returns hyperlink if the token, where the mouse cursor " +
			"hovers, is a proxy."
		);
		sc.add("public class " + getResourceClassName() + " implements " + I_HYPERLINK_DETECTOR(sc) + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addDetectHyperlinksMethod(sc);
		
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + iTextResourceClassName + " textResource;");
		sc.addLineBreak();
	}

	private void addDetectHyperlinksMethod(JavaComposite sc) {
		sc.add("public " + I_HYPERLINK(sc) + "[] detectHyperlinks(" + I_TEXT_VIEWER(sc) + " textViewer, " + I_REGION(sc) + " region, boolean canShowMultipleHyperlinks) {");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> elementsAtOffset = locationMap.getElementsAt(region.getOffset());");
		sc.add(E_OBJECT(sc) + " resolvedEObject = null;");
		sc.add("for (" + E_OBJECT(sc) + " eObject : elementsAtOffset) {");
		sc.add("if (eObject.eIsProxy()) {");
		sc.add("resolvedEObject = " + ECORE_UTIL(sc) + ".resolve(eObject, textResource);");
		sc.add("if (resolvedEObject == eObject) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("int offset = locationMap.getCharStart(eObject);");
		sc.add("int length = locationMap.getCharEnd(eObject) - offset + 1;");
		sc.add("String text = null;");
		sc.add("try {");
		sc.add("text = textViewer.getDocument().get(offset, length);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION(sc) + " e) {");
		sc.add("}");
		sc.addComment("we skip elements that are not contained in a resource, because we cannot jump to them anyway");
		sc.add("if (resolvedEObject.eResource() != null) {");
		sc.add(I_HYPERLINK(sc) + " hyperlink = new " + hyperlinkClassName + "(new " + REGION(sc) + "(offset, length), resolvedEObject, text);");
		sc.add("return new " + I_HYPERLINK(sc) + "[] {hyperlink};");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a hyperlink detector.",
			"@param resource the resource to use for calculating the locations."
		);
		sc.add("public " + getResourceClassName() + "(" + RESOURCE(sc) + " resource) {");
		sc.add("textResource = (" + iTextResourceClassName + ") resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
