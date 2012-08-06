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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASSIFIER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_PACKAGE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class MinimalModelHelperGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A helper class that is able to create minimal model instances for Ecore " +
			"models."
		);
		
		// TODO mseifert: add cross references where possible
		//                Proxies are now added with a pointer to nowhere. This way we have
		//                at least something that can be printed even if it results in an error.
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("private final static " + eClassUtilClassName + " eClassUtil = new " + eClassUtilClassName + "();");
		sc.addLineBreak();
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetMinimalModel1Method(sc);
		addGetMinimalModel2Method(sc);
		addGetMinimalModel3Method(sc);
		addContainsMethod(sc);
		addGetArraySubsetMethod(sc);
	}

	private void addGetMinimalModel1Method(StringComposite sc) {
		sc.add("public " + E_OBJECT + " getMinimalModel(" + E_CLASS + " eClass, " + COLLECTION + "<" + E_CLASS + "> allAvailableClasses) {");
		sc.add("return getMinimalModel(eClass, allAvailableClasses.toArray(new " + E_CLASS + "[allAvailableClasses.size()]), null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMinimalModel2Method(StringComposite sc) {
		sc.add("public " + E_OBJECT + " getMinimalModel(" + E_CLASS + " eClass, " + E_CLASS + "[] allAvailableClasses) {");
		sc.add("return getMinimalModel(eClass, allAvailableClasses, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMinimalModel3Method(JavaComposite sc) {
		sc.add("public " + E_OBJECT + " getMinimalModel(" + E_CLASS + " eClass, " + E_CLASS + "[] allAvailableClasses, String name) {");
		sc.add("if (!contains(allAvailableClasses, eClass)) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_PACKAGE + " ePackage = eClass.getEPackage();");
		sc.add("if (ePackage == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_OBJECT + " root = ePackage.getEFactoryInstance().create(eClass);");
		sc.add(LIST + "<" + E_STRUCTURAL_FEATURE + "> features = eClass.getEAllStructuralFeatures();");
		sc.add("for (" + E_STRUCTURAL_FEATURE + " feature : features) {");
		sc.add("if (feature instanceof " + E_REFERENCE + ") {");
		sc.add("" + E_REFERENCE + " reference = (" + E_REFERENCE + ") feature;");
		sc.add("if (reference.isUnsettable()) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("if (!reference.isChangeable()) {");
		sc.add("continue;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(E_CLASSIFIER + " type = reference.getEType();");
		sc.add("if (type instanceof " + E_CLASS + ") {");
		sc.add(E_CLASS + " typeClass = (" + E_CLASS + ") type;");
		sc.add("if (eClassUtil.isNotConcrete(typeClass)) {");
		sc.addComment("find subclasses");
		sc.add(LIST + "<" + E_CLASS + "> subClasses = eClassUtil.getSubClasses(typeClass, allAvailableClasses);");
		sc.add("if (subClasses.size() == 0) {");
		sc.add("continue;");
		sc.add("} else {");
		sc.addComment("pick the first subclass");
		sc.add("typeClass = subClasses.get(0);");
		sc.add("}");
		sc.add("}");
		sc.add("int lowerBound = reference.getLowerBound();");
		sc.add("for (int i = 0; i < lowerBound; i++) {");
		sc.add(E_OBJECT + " subModel = null;");
		sc.add("if (reference.isContainment()) {");
		sc.add(E_CLASS + "[] unusedClasses = getArraySubset(allAvailableClasses, eClass);");
		sc.add("subModel = getMinimalModel(typeClass, unusedClasses);");
		sc.add("}");
		sc.add("else {");
		// TODO jjohannes: can we actually do this? proxies with
		// URIs that can not be resolved cause problem when printing
		// them. I think we should rather use objects that exists in
		// the model and fill non-containment references with them.
		//
		// the code below prevents the NewFileWizard for the CS language
		// to work
		sc.add("subModel = typeClass.getEPackage().getEFactoryInstance().create(typeClass);");
		sc.addComment("set some proxy URI to make this object a proxy");
		sc.add("String initialValue = \"#some\" + " + stringUtilClassName + ".capitalize(typeClass.getName());");
		sc.add(URI + " proxyURI = " + URI + ".createURI(initialValue);");
		sc.add("((" + INTERNAL_E_OBJECT + ") subModel).eSetProxyURI(proxyURI);");
		sc.add("}");
		sc.add("if (subModel == null) {");
		sc.add("continue;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("Object value = root.eGet(reference);");
		sc.add("if (value instanceof " + LIST + "<?>) {");
		sc.add(LIST + "<" + E_OBJECT + "> list = " + listUtilClassName + ".castListUnchecked(value);");
		sc.add("list.add(subModel);");
		sc.add("} else {");
		sc.add("root.eSet(reference, subModel);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("} else if (feature instanceof " + E_ATTRIBUTE + ") {");
		sc.add(E_ATTRIBUTE + " attribute = (" + E_ATTRIBUTE + ") feature;");
		sc.add("if (\"EString\".equals(attribute.getEType().getName())) {");
		sc.add("String initialValue;");
		sc.add("if (attribute.getName().equals(\"name\") && name != null) {");
		sc.add("initialValue = name;");
		sc.add("}");
		sc.add("else {");
		sc.add("initialValue = \"some\" + " + stringUtilClassName + ".capitalize(attribute.getName());");
		sc.add("}");
		sc.add("Object value = root.eGet(attribute);");
		sc.add("if (value instanceof " + LIST + "<?>) {");
		sc.add(LIST + "<String> list = " + listUtilClassName + ".castListUnchecked(value);");
		sc.add("list.add(initialValue);");
		sc.add("} else {");
		sc.add("root.eSet(attribute, initialValue);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return root;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainsMethod(StringComposite sc) {
		sc.add("private boolean contains(" + E_CLASS + "[] allAvailableClasses, " + E_CLASS + " eClass) {");
		sc.add("for (" + E_CLASS + " nextClass : allAvailableClasses) {");
		sc.add("if (eClass == nextClass) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetArraySubsetMethod(StringComposite sc) {
		sc.add("private " + E_CLASS + "[] getArraySubset(" + E_CLASS + "[] allClasses, " + E_CLASS + " eClassToRemove) {");
		sc.add(LIST + "<" + E_CLASS + "> subset = new " + ARRAY_LIST + "<" + E_CLASS + ">();");
		sc.add("for (" + E_CLASS + " eClass : allClasses) {");
		sc.add("if (eClass != eClassToRemove) {");
		sc.add("subset.add(eClass);");
		sc.add("}");
		sc.add("}");
		sc.add("return subset.toArray(new " + E_CLASS + "[subset.size()]);");
		sc.add("}");
		sc.addLineBreak();
	}
}
