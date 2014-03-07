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
package org.emftext.sdk.codegen.resource.generators.util;

import static de.devboost.codecomposers.java.ClassNameConstants.ITERATOR;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.BASIC_INTERNAL_E_LIST;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.INTERNAL_E_LIST;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.LIST_ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.NOTIFICATION_CHAIN;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class CopiedEObjectInternalEListGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		//TODO mseifert: override remove() method of iterators
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + copiedEListClassName + "<" + E_OBJECT(sc) + "> implements " + INTERNAL_E_LIST(sc) + "<" + E_OBJECT(sc) + "> {");
		sc.addLineBreak();
		sc.add("private " + INTERNAL_E_LIST(sc) + "<" + E_OBJECT(sc) + "> original;");
		sc.add("private " + INTERNAL_E_LIST(sc) + "<" + E_OBJECT(sc) + "> copy;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + INTERNAL_E_LIST(sc) + "<" + E_OBJECT(sc) + "> original) {");
		sc.add("super(original);");
		sc.add("this.original = original;");
		sc.add("this.copy = new " + BASIC_INTERNAL_E_LIST(sc) + "<" + E_OBJECT(sc) + ">(" + E_OBJECT(sc) + ".class);");
		sc.add("this.copy.addAll(this.original);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean basicContains(Object object) {");
		sc.add("return copy.basicContains(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean basicContainsAll(" + COLLECTION(sc) + "<?> collection) {");
		sc.add("return copy.basicContainsAll(collection);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT(sc) + " basicGet(int index) {");
		sc.add("return copy.basicGet(index);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int basicIndexOf(Object object) {");
		sc.add("return copy.basicIndexOf(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + ITERATOR(sc) + "<" + E_OBJECT(sc) + "> basicIterator() {");
		sc.add("return copy.basicIterator();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int basicLastIndexOf(Object object) {");
		sc.add("return copy.basicLastIndexOf(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LIST(sc) + "<" + E_OBJECT(sc) + "> basicList() {");
		sc.add("return copy.basicList();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LIST_ITERATOR(sc) + "<" + E_OBJECT(sc) + "> basicListIterator() {");
		sc.add("return copy.basicListIterator();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LIST_ITERATOR(sc) + "<" + E_OBJECT(sc) + "> basicListIterator(int index) {");
		sc.add("return copy.basicListIterator(index);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public Object[] basicToArray() {");
		sc.add("return copy.basicToArray();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public <T> T[] basicToArray(T[] array) {");
		sc.add("return copy.basicToArray(array);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean equals(Object o) {");
		sc.add("return copy.equals(o);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int hashCode() {");
		sc.add("return copy.hashCode();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean addAllUnique(" + COLLECTION(sc) + "<? extends " + E_OBJECT(sc) + "> collection) {");
		sc.add("copy.addAllUnique(collection);");
		sc.add("return original.addAllUnique(collection);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean addAllUnique(int index, " + COLLECTION(sc) + "<? extends " + E_OBJECT(sc) + "> collection) {");
		sc.add("copy.addAllUnique(index, collection);");
		sc.add("return original.addAllUnique(index, collection);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addUnique(" + E_OBJECT(sc) + " object) {");
		sc.add("copy.addUnique(object);");
		sc.add("original.addUnique(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addUnique(int index, " + E_OBJECT(sc) + " object) {");
		sc.add("copy.addUnique(index, object);");
		sc.add("original.addUnique(index, object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + NOTIFICATION_CHAIN(sc) + " basicAdd(" + E_OBJECT(sc) + " object, " + NOTIFICATION_CHAIN(sc) + " notifications) {");
		sc.add("copy.basicAdd(object, notifications);");
		sc.add("return original.basicAdd(object, notifications);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + NOTIFICATION_CHAIN(sc) + " basicRemove(Object object,");
		sc.add(NOTIFICATION_CHAIN(sc) + " notifications) {");
		sc.add("copy.basicRemove(object, notifications);");
		sc.add("return original.basicRemove(object, notifications);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT(sc) + " setUnique(int index, " + E_OBJECT(sc) + " object) {");
		sc.add("copy.setUnique(index, object);");
		sc.add("return original.setUnique(index, object);");
		sc.add("}");
		sc.add("}");
	}
}
