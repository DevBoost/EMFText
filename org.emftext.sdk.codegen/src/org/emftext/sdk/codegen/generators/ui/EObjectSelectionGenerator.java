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
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class EObjectSelectionGenerator extends JavaBaseGenerator {

	public EObjectSelectionGenerator() {
		super();
	}

	private EObjectSelectionGenerator(GenerationContext context) {
		super(context, EArtifact.E_OBJECT_SELECTION);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_STRUCTURED_SELECTION + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
		addGetSelectedObjectMethod(sc);
		addDoHighlightingMethod(sc);
		addIsEmptyMethod(sc);
		addGetFirstElementMethod(sc);
		addIteratorMethod(sc);
		addSizeMethod(sc);
		addToArrayMethod(sc);
		addToListMethod(sc);
	}

	private void addToListMethod(StringComposite sc) {
		sc.add("public " + LIST + "<?> toList() {");
		sc.add(ARRAY_LIST + "<" + E_OBJECT + "> list = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
		sc.add("list.add(selectedObject);");
		sc.add("return list;");
		sc.add("}");
	}

	private void addToArrayMethod(StringComposite sc) {
		sc.add("public " + OBJECT + "[] toArray() {");
		sc.add("return new " + OBJECT + "[] {selectedObject};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSizeMethod(StringComposite sc) {
		sc.add("public int size() {");
		sc.add("return 1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIteratorMethod(StringComposite sc) {
		sc.add("public " + ITERATOR + "<?> iterator() {");
		sc.add("return new " + ITERATOR + "<" + E_OBJECT + ">() {");
		sc.addLineBreak();
		sc.add("private boolean hasNext = true;");
		sc.addLineBreak();
		sc.add("public boolean hasNext() {");
		sc.add("return hasNext;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " next(){");
		sc.add("hasNext = false;");
		sc.add("return selectedObject;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void remove() {");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFirstElementMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " getFirstElement() {");
		sc.add("return selectedObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsEmptyMethod(StringComposite sc) {
		sc.add("public boolean isEmpty() {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoHighlightingMethod(StringComposite sc) {
		sc.add("public boolean doHighlighting() {");
		sc.add("return highlighting;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSelectedObjectMethod(StringComposite sc) {
		sc.add("public " + E_OBJECT + " getSelectedObject() {");
		sc.add("return selectedObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_OBJECT + " selectedObject, boolean highlighting) {");
		sc.add("super();");
		sc.add("this.selectedObject = selectedObject;");
		sc.add("this.highlighting = highlighting;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private final " + E_OBJECT + " selectedObject;");
		sc.add("private final boolean highlighting;");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new EObjectSelectionGenerator(context);
	}
}
