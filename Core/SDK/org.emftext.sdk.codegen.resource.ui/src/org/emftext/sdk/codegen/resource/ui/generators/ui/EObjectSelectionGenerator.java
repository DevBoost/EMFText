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

import static de.devboost.codecomposers.java.ClassNameConstants.ITERATOR;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STRUCTURED_SELECTION;

import java.util.Collections;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class EObjectSelectionGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_STRUCTURED_SELECTION(sc) + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetSelectedObjectMethod(sc);
		addIsEmptyMethod(sc);
		addGetFirstElementMethod(sc);
		addIteratorMethod(sc);
		addSizeMethod(sc);
		addToArrayMethod(sc);
		addToListMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final " + E_OBJECT(sc) + " selectedObject;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_OBJECT(sc) + " selectedObject) {");
		sc.add("super();");
		sc.add("this.selectedObject = selectedObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToListMethod(JavaComposite sc) {
		sc.add("public " + LIST(sc) + "<?> toList() {");
		sc.add("return " + sc.getClassName(Collections.class) + ".singletonList(selectedObject);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToArrayMethod(StringComposite sc) {
		sc.add("public Object[] toArray() {");
		sc.add("return new Object[] {selectedObject};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSizeMethod(StringComposite sc) {
		sc.add("public int size() {");
		sc.add("return 1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIteratorMethod(JavaComposite sc) {
		sc.add("public " + ITERATOR(sc) + "<?> iterator() {");
		sc.add("return new " + ITERATOR(sc) + "<" + E_OBJECT(sc) + ">() {");
		sc.addLineBreak();
		sc.add("private boolean hasNext = true;");
		sc.addLineBreak();
		sc.add("public boolean hasNext() {");
		sc.add("return hasNext;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT(sc) + " next(){");
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
		sc.add("public Object getFirstElement() {");
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

	private void addGetSelectedObjectMethod(JavaComposite sc) {
		sc.add("public " + E_OBJECT(sc) + " getSelectedObject() {");
		sc.add("return selectedObject;");
		sc.add("}");
		sc.addLineBreak();
	}
}
