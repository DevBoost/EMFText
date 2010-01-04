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
package org.emftext.sdk.codegen.generators.util;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BASIC_E_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST_ITERATOR;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class CopiedEListGenerator extends JavaBaseGenerator {

	public CopiedEListGenerator() {
		super();
	}

	private CopiedEListGenerator(GenerationContext context) {
		super(context, EArtifact.COPIED_E_LIST);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new CopiedEListGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		// TODO mseifert: override remove() method of iterators
		sc.add("public class " + getResourceClassName() + "<E> implements " + E_LIST + "<E> {");
		sc.addLineBreak();
		sc.add("private static final long serialVersionUID = 604726114003869602L;");
		sc.add("private " + E_LIST + "<E> original;");
		sc.add("private " + E_LIST + "<E> copy;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + E_LIST + "<E> original) {");
		sc.add("super();");
		sc.add("this.original = original;");
		sc.add("this.copy = new " + BASIC_E_LIST + "<E>();");
		sc.add("this.copy.addAll(this.original);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void move(int newPosition, E object) {");
		sc.add("original.move(newPosition, object);");
		sc.add("copy.move(newPosition, object);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public E move(int newPosition, int oldPosition) {");
		sc.add("copy.move(newPosition, oldPosition);");
		sc.add("return original.move(newPosition, oldPosition);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean add(E o) {");
		sc.add("copy.add(o);");
		sc.add("return original.add(o);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void add(int index, E element) {");
		sc.add("copy.add(index, element);");
		sc.add("original.add(index, element);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean addAll(" + COLLECTION + "<? extends E> c) {");
		sc.add("copy.addAll(c);");
		sc.add("return original.addAll(c);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean addAll(int index, " + COLLECTION + "<? extends E> c) {");
		sc.add("copy.addAll(index, c);");
		sc.add("return original.addAll(index, c);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void clear() {");
		sc.add("copy.clear();");
		sc.add("original.clear();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean contains(Object o) {");
		sc.add("return copy.contains(o);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean containsAll(" + COLLECTION + "<?> c) {");
		sc.add("return copy.containsAll(c);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public E get(int index) {");
		sc.add("return copy.get(index);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int indexOf(Object o) {");
		sc.add("return copy.indexOf(o);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean isEmpty() {");
		sc.add("return copy.isEmpty();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + ITERATOR + "<E> iterator() {");
		sc.add("return copy.iterator();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int lastIndexOf(Object o) {");
		sc.add("return copy.lastIndexOf(o);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LIST_ITERATOR + "<E> listIterator() {");
		sc.add("return copy.listIterator();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LIST_ITERATOR + "<E> listIterator(int index) {");
		sc.add("return copy.listIterator(index);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean remove(Object o) {");
		sc.add("copy.remove(o);");
		sc.add("return original.remove(o);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public E remove(int index) {");
		sc.add("copy.remove(index);");
		sc.add("return original.remove(index);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean removeAll(" + COLLECTION + "<?> c) {");
		sc.add("copy.removeAll(c);");
		sc.add("return original.removeAll(c);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean retainAll(" + COLLECTION + "<?> c) {");
		sc.add("copy.retainAll(c);");
		sc.add("return original.retainAll(c);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public E set(int index, E element) {");
		sc.add("copy.set(index, element);");
		sc.add("return original.set(index, element);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int size() {");
		sc.add("return copy.size();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + LIST + "<E> subList(int fromIndex, int toIndex) {");
		sc.add("return copy.subList(fromIndex, toIndex);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public Object[] toArray() {");
		sc.add("return copy.toArray();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public <T> T[] toArray(T[] a) {");
		sc.add("return copy.toArray(a);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		return true;
	}
}
