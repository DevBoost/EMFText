/*******************************************************************************
 * Copyright (c) 2006-2013
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

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_CLASSIFIER;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_PACKAGE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.URI;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class MinimalModelHelperGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
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

	private void addGetMinimalModel1Method(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + E_OBJECT(sc) + " getMinimalModel(" + E_CLASS(sc) + " eClass, " + COLLECTION(sc) + "<" + E_CLASS(sc) + "> allAvailableClasses) {");
		sc.add("return getMinimalModel(eClass, allAvailableClasses.toArray(new " + E_CLASS(sc) + "[allAvailableClasses.size()]), null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMinimalModel2Method(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + E_OBJECT(sc) + " getMinimalModel(" + E_CLASS(sc) + " eClass, " + E_CLASS(sc) + "[] allAvailableClasses) {");
		sc.add("return getMinimalModel(eClass, allAvailableClasses, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMinimalModel3Method(JavaComposite sc) {
		sc.add("public " + E_OBJECT(sc) + " getMinimalModel(" + E_CLASS(sc) + " eClass, " + E_CLASS(sc) + "[] allAvailableClasses, String name) {");
		sc.add("if (!contains(allAvailableClasses, eClass)) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_PACKAGE(sc) + " ePackage = eClass.getEPackage();");
		sc.add("if (ePackage == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_OBJECT(sc) + " root = ePackage.getEFactoryInstance().create(eClass);");
		sc.add(LIST(sc) + "<" + E_STRUCTURAL_FEATURE(sc) + "> features = eClass.getEAllStructuralFeatures();");
		sc.add("for (" + E_STRUCTURAL_FEATURE(sc) + " feature : features) {");
		sc.add("if (feature instanceof " + E_REFERENCE(sc) + ") {");
		sc.add("" + E_REFERENCE(sc) + " reference = (" + E_REFERENCE(sc) + ") feature;");
		sc.add("if (reference.isUnsettable()) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("if (!reference.isChangeable()) {");
		sc.add("continue;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(E_CLASSIFIER(sc) + " type = reference.getEType();");
		sc.add("if (type instanceof " + E_CLASS(sc) + ") {");
		sc.add(E_CLASS(sc) + " typeClass = (" + E_CLASS(sc) + ") type;");
		sc.add("if (eClassUtil.isNotConcrete(typeClass)) {");
		sc.addComment("find subclasses");
		sc.add(LIST(sc) + "<" + E_CLASS(sc) + "> subClasses = eClassUtil.getSubClasses(typeClass, allAvailableClasses);");
		sc.add("if (subClasses.size() == 0) {");
		sc.add("continue;");
		sc.add("} else {");
		sc.addComment("pick the first subclass");
		sc.add("typeClass = subClasses.get(0);");
		sc.add("}");
		sc.add("}");
		sc.add("int lowerBound = reference.getLowerBound();");
		sc.add("for (int i = 0; i < lowerBound; i++) {");
		sc.add(E_OBJECT(sc) + " subModel = null;");
		sc.add("if (reference.isContainment()) {");
		sc.add(E_CLASS(sc) + "[] unusedClasses = getArraySubset(allAvailableClasses, eClass);");
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
		sc.add(URI(sc) + " proxyURI = " + URI(sc) + ".createURI(initialValue);");
		sc.add("((" + INTERNAL_E_OBJECT(sc) + ") subModel).eSetProxyURI(proxyURI);");
		sc.add("}");
		sc.add("if (subModel == null) {");
		sc.add("continue;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("Object value = root.eGet(reference);");
		sc.add("if (value instanceof " + LIST(sc) + "<?>) {");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> list = " + listUtilClassName + ".castListUnchecked(value);");
		sc.add("list.add(subModel);");
		sc.add("} else {");
		sc.add("root.eSet(reference, subModel);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("} else if (feature instanceof " + E_ATTRIBUTE(sc) + ") {");
		sc.add(E_ATTRIBUTE(sc) + " attribute = (" + E_ATTRIBUTE(sc) + ") feature;");
		sc.add("if (\"EString\".equals(attribute.getEType().getName())) {");
		sc.add("String initialValue;");
		sc.add("if (attribute.getName().equals(\"name\") && name != null) {");
		sc.add("initialValue = name;");
		sc.add("}");
		sc.add("else {");
		sc.add("initialValue = \"some\" + " + stringUtilClassName + ".capitalize(attribute.getName());");
		sc.add("}");
		sc.add("Object value = root.eGet(attribute);");
		sc.add("if (value instanceof " + LIST(sc) + "<?>) {");
		sc.add(LIST(sc) + "<String> list = " + listUtilClassName + ".castListUnchecked(value);");
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

	private void addContainsMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("private boolean contains(" + E_CLASS(sc) + "[] allAvailableClasses, " + E_CLASS(sc) + " eClass) {");
		sc.add("for (" + E_CLASS(sc) + " nextClass : allAvailableClasses) {");
		sc.add("if (eClass == nextClass) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetArraySubsetMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("private " + E_CLASS(sc) + "[] getArraySubset(" + E_CLASS(sc) + "[] allClasses, " + E_CLASS(sc) + " eClassToRemove) {");
		sc.add(LIST(sc) + "<" + E_CLASS(sc) + "> subset = new " + ARRAY_LIST(sc) + "<" + E_CLASS(sc) + ">();");
		sc.add("for (" + E_CLASS(sc) + " eClass : allClasses) {");
		sc.add("if (eClass != eClassToRemove) {");
		sc.add("subset.add(eClass);");
		sc.add("}");
		sc.add("}");
		sc.add("return subset.toArray(new " + E_CLASS(sc) + "[subset.size()]);");
		sc.add("}");
		sc.addLineBreak();
	}
}
