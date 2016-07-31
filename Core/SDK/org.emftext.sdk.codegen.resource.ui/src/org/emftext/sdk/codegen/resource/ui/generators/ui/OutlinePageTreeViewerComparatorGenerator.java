/*******************************************************************************
 * Copyright (c) 2006-2016
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

import static de.devboost.codecomposers.java.ClassNameConstants.LINKED_HASH_MAP;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COMPARATOR;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_PACKAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.VIEWER_COMPARATOR;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class OutlinePageTreeViewerComparatorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + VIEWER_COMPARATOR(sc) + " {");
		sc.addLineBreak();
		sc.add("private static " + MAP(sc) + "<" + E_PACKAGE(sc) + ", Integer> ePackageMap = new " + LINKED_HASH_MAP(sc) + "<" + E_PACKAGE(sc) + ", Integer>();");
		sc.add("private static int nextPackageID;");
		sc.addLineBreak();
		sc.add("private " + COMPARATOR(sc) + "<Object> comparator = new " + COMPARATOR(sc) + "<Object>() {");
		sc.addLineBreak();
		sc.add("public int compare(Object o1, Object o2) {");
		sc.add("if (!sortLexically) {");
		sc.add("return 0;");
		sc.add("}");
		sc.add("if (o1 instanceof String && o2 instanceof String) {");
		sc.add("String s1 = (String) o1;");
		sc.add("String s2 = (String) o2;");
		sc.add("return s1.compareTo(s2);");
		sc.add("}");
		sc.add("return 0;");
		sc.add("}");
		sc.add("};");
		sc.add("private boolean groupTypes;");
		sc.add("private boolean sortLexically;");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addSetCompareLexicallyMethod(sc);
		addCategoryMethod(sc);
		addGetEPackageIDMethod(sc);
		addGetComparatorMethod(sc);
		addCompareMethod(sc);
	}

	private void addSetCompareLexicallyMethod(JavaComposite sc) {
		sc.add("public void setGroupTypes(boolean on) {");
		sc.add("this.groupTypes = on;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public void setSortLexically(boolean on) {");
		sc.add("this.sortLexically = on;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCategoryMethod(JavaComposite sc) {
		sc.add("@Override");
		sc.add("public int category(Object element) {");
		sc.add("if (!groupTypes) {");
		sc.add("return 0;");
		sc.add("}");
		sc.add("if (element instanceof " + E_OBJECT(sc) + ") {");
		sc.add(E_OBJECT(sc) + " eObject = (" + E_OBJECT(sc) + ") element;");
		sc.add(E_CLASS(sc) + " eClass = eObject.eClass();");
		sc.add(E_PACKAGE(sc) + " ePackage = eClass.getEPackage();");
		sc.add("int packageID = getEPackageID(ePackage);");
		sc.add("int classifierID = eClass.getClassifierID();");
		sc.add("return packageID + classifierID;");
		sc.add("} else {");
		sc.add("return super.category(element);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEPackageIDMethod(JavaComposite sc) {
		sc.add("private int getEPackageID(" + E_PACKAGE(sc) + " ePackage) {");
		sc.add("Integer packageID = ePackageMap.get(ePackage);");
		sc.add("if (packageID == null) {");
		sc.add("packageID = nextPackageID;");
		sc.addComment("we assumed that packages do contain at most 1000 classifiers");
		sc.add("nextPackageID += 1000;");
		sc.add("ePackageMap.put(ePackage, nextPackageID);");
		sc.add("}");
		sc.add("return packageID;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetComparatorMethod(JavaComposite sc) {
		sc.add("public " + COMPARATOR(sc) + "<? super String> getComparator() {");
		sc.add("return this.comparator;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCompareMethod(JavaComposite sc) {
		sc.add("public int compare(" + VIEWER(sc) + " viewer, Object o1, Object o2) {");
		sc.addComment("first check categories");
		sc.add("int cat1 = category(o1);");
		sc.add("int cat2 = category(o2);");
		sc.add("if (cat1 != cat2) {");
		sc.add("return cat1 - cat2;");
		sc.add("}");
		sc.addComment("then try to compare the names");
		sc.add("if (sortLexically && o1 instanceof " + E_OBJECT(sc) + " && o2 instanceof " + E_OBJECT(sc) + ") {");
		sc.add(E_OBJECT(sc) + " e1 = (" + E_OBJECT(sc) + ") o1;");
		sc.add(E_OBJECT(sc) + " e2 = (" + E_OBJECT(sc) + ") o2;");
		sc.add(iNameProviderClassName + " nameProvider = new " + metaInformationClassName + "().createNameProvider();");
		sc.add(LIST(sc) + "<String> names1 = nameProvider.getNames(e1);");
		sc.add(LIST(sc) + "<String> names2 = nameProvider.getNames(e2);");
		sc.add("if (names1 != null && !names1.isEmpty() && names2 != null && !names2.isEmpty()) {");
		sc.add("String name1 = names1.get(0);");
		sc.add("String name2 = names2.get(0);");
		sc.add("return name1.compareTo(name2);");
		sc.add("}");
		sc.add("}");
		sc.add("return super.compare(viewer, o1, o2);");
		sc.add("}");
		sc.addLineBreak();
	}
}
