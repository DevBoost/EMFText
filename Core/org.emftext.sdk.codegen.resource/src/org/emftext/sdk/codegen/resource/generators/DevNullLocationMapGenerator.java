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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.interfaces.IOptionsGenerator;

public class DevNullLocationMapGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"An inactive implementation of the ILocationMap interface. That is used if the " + 
			iOptionsClassName + "." + IOptionsGenerator.DISABLE_LOCATION_MAP + " option is set."
		);
		sc.add("public class " + getResourceClassName() + " implements " + iLocationMapClassName + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addSetLineMethod(sc);
		addGetLineMethod(sc);
		addSetColumnMethod(sc);
		addGetColumnMethod(sc);
		addSetCharStartMethod(sc);
		addGetCharStartMethod(sc);
		addSetCharEndMethod(sc);
		addGetCharEndMethod(sc);
		addGetElementsAtMethod(sc);
		addGetElementsBetween(sc);
	}


	private void addGetElementsBetween(JavaComposite sc) {
		sc.add("public " + LIST + "<" + E_OBJECT + "> getElementsBetween(final int startOffset, final int endOffset) {");
		sc.add("return " + COLLECTIONS + ".<" + E_OBJECT + ">emptyList();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetElementsAtMethod(JavaComposite sc) {
		sc.add("public " + LIST + "<" + E_OBJECT + "> getElementsAt(final int documentOffset) {");
		sc.add("return " + COLLECTIONS + ".<" + E_OBJECT + ">emptyList();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCharEndMethod(JavaComposite sc) {
		sc.add("public int getCharEnd(" + E_OBJECT + " element) {");
		sc.add("return -1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetCharEndMethod(JavaComposite sc) {
		sc.add("public void setCharEnd(" + E_OBJECT + " element, int charEnd) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCharStartMethod(JavaComposite sc) {
		sc.add("public int getCharStart(" + E_OBJECT + " element) {");
		sc.add("return -1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetCharStartMethod(JavaComposite sc) {
		sc.add("public void setCharStart(" + E_OBJECT + " element, int charStart) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetColumnMethod(JavaComposite sc) {
		sc.add("public int getColumn(" + E_OBJECT + " element) {");
		sc.add("return -1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetColumnMethod(JavaComposite sc) {
		sc.add("public void setColumn(" + E_OBJECT + " element, int column) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLineMethod(JavaComposite sc) {
		sc.add("public int getLine(" + E_OBJECT + " element) {");
		sc.add("return -1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetLineMethod(JavaComposite sc) {
		sc.add("public void setLine(" + E_OBJECT + " element, int line) {");
		sc.add("}");
		sc.addLineBreak();
	}
}
