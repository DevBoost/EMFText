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
package org.emftext.sdk.codegen.resource.generators.analysis;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ADAPTER_IMPL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ReferenceCacheGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.addJavadoc(
			"A ReferenceCache can be used to improve the performance of the reference resolving. " +
			"This default implementation is initialized by traversing the content of the " +
			"current resource. During this traversal, two maps are created. One (the classToObject map) " +
			"can be used to retrieve all objects of a given type. The other one (the nameToObjects map) " +
			"can be used to retrieve all objects for a given name."
		);
		sc.add("public class " + getResourceClassName() + " extends " + ADAPTER_IMPL + " implements " + iReferenceCacheClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + iNameProviderClassName + " nameProvider) {");
		sc.add("super();");
		sc.add("this.nameProvider = nameProvider;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetObjectsMethod(sc);
		addInitializeMethod(sc);
		addGetNameToObjectMap(sc);
		addPutMethod1(sc);
		addPutMethod2(sc);
		addClearMethod(sc);
	}

	private void addClearMethod(StringComposite sc) {
		sc.add("public void clear() {");
		sc.add("classToObjectsMap.clear();");
		sc.add("nameToObjectsMap.clear();");
		sc.add("isInitialized = false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPutMethod1(StringComposite sc) {
		sc.add("private void put(" + E_OBJECT + " object) {");
		sc.add(E_CLASS + " eClass = object.eClass();");
		sc.add("put(classToObjectsMap, eClass, object);");
		sc.add(LIST + "<String> names = nameProvider.getNames(object);");
		sc.add("for (String name : names) {");
		sc.add("put(nameToObjectsMap, name, object);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPutMethod2(StringComposite sc) {
		sc.add("private <T> void put(" + MAP + "<T, " + SET + "<" + E_OBJECT + ">> map, T key, " + E_OBJECT + " object) {");
		sc.add("if (!map.containsKey(key)) {");
		sc.add("map.put(key, new " + LINKED_HASH_SET + "<" + E_OBJECT + ">());");
		sc.add("}");
		sc.add("map.get(key).add(object);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNameToObjectMap(StringComposite sc) {
		sc.add("public " + MAP + "<String, " + SET + "<" + E_OBJECT + ">> getNameToObjectsMap() {");
		sc.add("return nameToObjectsMap;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeMethod(StringComposite sc) {
		sc.add("public void initialize(" + E_OBJECT + " root) {");
		sc.add("if (isInitialized) {");
		sc.add("return;");
		sc.add("}");
		sc.add("put(root);");
		sc.add(ITERATOR + "<" + E_OBJECT + "> it = root.eAllContents();");
		sc.add("while (it.hasNext()) {");
		sc.add("put(it.next());");
		sc.add("}");
		sc.add("isInitialized = true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetObjectsMethod(StringComposite sc) {
		sc.add("public " + SET + "<" + E_OBJECT + "> getObjects(" + E_CLASS + " type) {");
		sc.add("return classToObjectsMap.get(type);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + MAP + "<" + E_CLASS + ", " + SET + "<" + E_OBJECT +">> classToObjectsMap = new " + LINKED_HASH_MAP + "<" + E_CLASS + ", " + SET + "<" + E_OBJECT +">>();");
		sc.add("private " + MAP + "<String, " + SET + "<" + E_OBJECT +">> nameToObjectsMap  = new " + LINKED_HASH_MAP + "<String, " + SET + "<" + E_OBJECT +">>();");
		sc.add("private boolean isInitialized;");
		sc.add("private " + iNameProviderClassName + " nameProvider;");
		sc.addLineBreak();
	}
}
