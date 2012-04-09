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
package org.emftext.sdk.codegen.resource.generators.util;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BASIC_INTERNAL_E_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST_ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.NOTIFICATION_CHAIN;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class CopiedEObjectInternalEListGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		//TODO mseifert: override remove() method of iterators
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + copiedEListClassName + "<" + E_OBJECT + "> implements " + INTERNAL_E_LIST + "<" + E_OBJECT + "> {");
		sc.addLineBreak();
		sc.add("private " + INTERNAL_E_LIST + "<" + E_OBJECT + "> original;");
		sc.add("private " + INTERNAL_E_LIST + "<" + E_OBJECT + "> copy;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + INTERNAL_E_LIST + "<" + E_OBJECT + "> original) {");
		sc.add("super(original);");
		sc.add("this.original = original;");
		sc.add("this.copy = new " + BASIC_INTERNAL_E_LIST + "<" + E_OBJECT + ">(" + E_OBJECT + ".class);");
		sc.add("this.copy.addAll(this.original);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean basicContains(Object object) {");
		sc.add("return copy.basicContains(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean basicContainsAll(" + COLLECTION + "<?> collection) {");
		sc.add("return copy.basicContainsAll(collection);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " basicGet(int index) {");
		sc.add("return copy.basicGet(index);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int basicIndexOf(Object object) {");
		sc.add("return copy.basicIndexOf(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + ITERATOR + "<" + E_OBJECT + "> basicIterator() {");
		sc.add("return copy.basicIterator();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int basicLastIndexOf(Object object) {");
		sc.add("return copy.basicLastIndexOf(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LIST + "<" + E_OBJECT + "> basicList() {");
		sc.add("return copy.basicList();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LIST_ITERATOR + "<" + E_OBJECT + "> basicListIterator() {");
		sc.add("return copy.basicListIterator();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LIST_ITERATOR + "<" + E_OBJECT + "> basicListIterator(int index) {");
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
		sc.add("public boolean addAllUnique(" + COLLECTION + "<? extends " + E_OBJECT + "> collection) {");
		sc.add("copy.addAllUnique(collection);");
		sc.add("return original.addAllUnique(collection);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean addAllUnique(int index, " + COLLECTION + "<? extends " + E_OBJECT + "> collection) {");
		sc.add("copy.addAllUnique(index, collection);");
		sc.add("return original.addAllUnique(index, collection);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addUnique(" + E_OBJECT + " object) {");
		sc.add("copy.addUnique(object);");
		sc.add("original.addUnique(object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addUnique(int index, " + E_OBJECT + " object) {");
		sc.add("copy.addUnique(index, object);");
		sc.add("original.addUnique(index, object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + NOTIFICATION_CHAIN + " basicAdd(" + E_OBJECT + " object, " + NOTIFICATION_CHAIN + " notifications) {");
		sc.add("copy.basicAdd(object, notifications);");
		sc.add("return original.basicAdd(object, notifications);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + NOTIFICATION_CHAIN + " basicRemove(Object object,");
		sc.add(NOTIFICATION_CHAIN + " notifications) {");
		sc.add("copy.basicRemove(object, notifications);");
		sc.add("return original.basicRemove(object, notifications);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " setUnique(int index, " + E_OBJECT + " object) {");
		sc.add("copy.setUnique(index, object);");
		sc.add("return original.setUnique(index, object);");
		sc.add("}");
		sc.add("}");
	}
}
