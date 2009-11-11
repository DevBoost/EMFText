/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class HoverTextProviderGenerator extends JavaBaseGenerator {
	
	public HoverTextProviderGenerator() {
		super();
	}

	private HoverTextProviderGenerator(GenerationContext context) {
		super(context, EArtifact.HOVER_TEXT_PROVIDER);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + getClassNameHelper().getI_HOVER_TEXT_PROVIDER() + " {");
		sc.addLineBreak();
		sc.add("public " + STRING + " getHoverText(" + E_OBJECT + " object) {");
		sc.add("if (object == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_CLASS + " eClass = object.eClass();");
		sc.add("String label = \"<strong>\" + eClass.getName() + \"</strong>\";");
		sc.add("for (" + E_ATTRIBUTE + " attribute : eClass.getEAllAttributes()) {");
		sc.add("" + OBJECT + " value = null;");
		sc.add("try {");
		sc.add("value = object.eGet(attribute);");
		sc.add("} catch (" + EXCEPTION + " e) {");
		sc.add("// Exception in eGet, do nothing");
		sc.add("}");
		sc.add("if (value != null && value.toString() != null && !value.toString().equals(\"[]\")) {");
		sc.add("label += \"<br />\" + attribute.getName() + \": \" + object.eGet(attribute).toString();");
		sc.add("}");
		sc.add("}");
		sc.add("return label;");
		sc.add("}");
		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new HoverTextProviderGenerator(context);
	}

}
