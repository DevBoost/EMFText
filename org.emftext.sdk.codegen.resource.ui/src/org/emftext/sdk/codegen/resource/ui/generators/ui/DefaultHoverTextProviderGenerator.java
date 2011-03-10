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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class DefaultHoverTextProviderGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iHoverTextProviderClassName + " {");
		sc.addLineBreak();
		addGetHoverTextMethod1(sc);
		addGetHoverTextMethod2(sc);
		sc.add("}");
	}

	private void addGetHoverTextMethod1(JavaComposite sc) {
		sc.add("public String getHoverText(" + E_OBJECT + " container, " + E_OBJECT + " referencedObject) {");
		sc.add("return getHoverText(referencedObject);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addGetHoverTextMethod2(JavaComposite sc) {
		sc.add("public String getHoverText(" + E_OBJECT + " object) {");
		sc.add("if (object == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_CLASS + " eClass = object.eClass();");
		sc.add("String label = \"<strong>\" + eClass.getName() + \"</strong>\";");
		sc.add("String documentation = " + ECORE_UTIL + ".getDocumentation(eClass);");
		sc.add("String documentationHTML = documentation == null ? \"\" : \" (\" + documentation +\")\";");
		sc.add("label += documentationHTML;");
		sc.add("for (" + E_ATTRIBUTE + " attribute : eClass.getEAllAttributes()) {");
		sc.add("Object value = null;");
		sc.add("try {");
		sc.add("value = object.eGet(attribute);");
		sc.add("} catch (Exception e) {");
		sc.addComment("Exception in eGet, do nothing");
		sc.add("}");
		sc.add("if (value != null && value.toString() != null && !value.toString().equals(\"[]\")) {");
		sc.add("label += \"<br />\" + attribute.getName() + \": \" + object.eGet(attribute).toString();");
		sc.add("}");
		sc.add("}");
		sc.add("return label;");
		sc.add("}");
		sc.addLineBreak();
	}
}
