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

import static de.devboost.codecomposers.java.IClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASSIFIER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OPERATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INVOCATION_TARGET_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.METHOD;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class EObjectUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A utility class that can be used to work with EObjects. " +
			"While many similar methods are provided by EMF's own " +
			"EcoreUtil class, the missing ones are collected here.",
			"@see org.eclipse.emf.ecore.util.EcoreUtil"
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetObjectsByTypeMethod(sc);
		addFindRootContainerMethod(sc);
		addFindAncestorByTypeMethod(sc);
		addFindClosestsAncestorByTypeMethod(sc);
		addInvokeOperationMethod(sc);
		addSetFeatureMethod(sc);
		addGetDepthMethod(sc);
		addGetFeatureValueMethod1(sc);
		addGetFeatureValueMethod2(sc);
		addGetEAdapterFromRootMethod(sc);
		addGetEAdapterMethod(sc);
	}

	private void addGetEAdapterFromRootMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Checks whether the root container of the given object has an EAdapter that is an instance of " +
			"the given class. If one is found, it is returned, otherwise the result is null."
		);
		sc.add("public static <T> T getEAdapterFromRoot(" + E_OBJECT + " object, Class<T> clazz) {");
		sc.add(E_OBJECT + " root = " + ECORE_UTIL + ".getRootContainer(object);");
		sc.add("return getEAdapter(root, clazz);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEAdapterMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Checks whether the given object has an EAdapter that is an instance of " +
			"the given class. If one is found, it is returned, otherwise the result is null."
		);
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.add("public static <T> T getEAdapter(" + E_OBJECT + " object, Class<T> clazz) {");
		sc.add(LIST + "<" + ADAPTER + "> eAdapters = object.eAdapters();");
		sc.add("for (" + ADAPTER + " adapter : eAdapters) {");
		sc.add("if (clazz.isInstance(adapter)) {");
		sc.add("return (T) adapter;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFeatureValueMethod1(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the value of the given feature. " +
			"If the feature is a list, the list item at the given index is returned. " +
			"Proxy objects are resolved."
		);
		sc.add("public static Object getFeatureValue(" + E_OBJECT + " eObject, " + E_STRUCTURAL_FEATURE + " feature, int index) {");
		sc.add("return getFeatureValue(eObject, feature, index, true);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFeatureValueMethod2(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the value of the given feature. " +
			"If the feature is a list, the list item at the given index is returned."
		);
		sc.add("public static Object getFeatureValue(" + E_OBJECT + " eObject, " + E_STRUCTURAL_FEATURE + " feature, int index, boolean resolve) {");
		sc.addComment("get value of feature");
		sc.add("Object o = eObject.eGet(feature, resolve);");
		sc.add("if (o instanceof " + LIST + "<?>) {");
		sc.add(LIST + "<?> list = (" + LIST + "<?>) o;");
		sc.add("o = list.get(index);");
		sc.add("}");
		sc.add("return o;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDepthMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the depth of the given element in the containment tree.");
		sc.add("public static int getDepth(" + E_OBJECT + " element) {");
		sc.add(E_OBJECT + " parent = element.eContainer();");
		sc.add("if (parent == null) {");
		sc.add("return 0;");
		sc.add("} else {");
		sc.add("return getDepth(parent) + 1;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetObjectsByTypeMethod(StringComposite sc) {
		sc.add("public static <T> " + COLLECTION + "<T> getObjectsByType(" + ITERATOR + "<?> iterator, " + E_CLASSIFIER + " type) {");
		sc.add(COLLECTION + "<T> result = new " + ARRAY_LIST + "<T>();");
		sc.add("while (iterator.hasNext()) {");
		sc.add("Object object = iterator.next();");
		sc.add("if (type.isInstance(object)) {");
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.add("T t = (T) object;");
		sc.add("result.add(t);");
		sc.add("}");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetFeatureMethod(StringComposite sc) {
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.add("public static void setFeature(" + E_OBJECT + " object, " + E_STRUCTURAL_FEATURE + " eFeature, Object value, boolean clearIfList) {");
		sc.add("int upperBound = eFeature.getUpperBound();");
		sc.add("if (upperBound > 1 || upperBound < 0) {");
		sc.add("Object oldValue = object.eGet(eFeature);");
		sc.add("if (oldValue instanceof " + LIST + "<?>) {");
		sc.add(LIST + "<Object> list = (" + LIST + "<Object>) oldValue;");
		sc.add("if (clearIfList) {");
		sc.add("list.clear();");
		sc.add("}");
		sc.add("list.add(value);");
		sc.add("} else {");
		sc.add("assert false;");
		sc.add("}");
		sc.add("} else {");
		sc.add("object.eSet(eFeature, value);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindRootContainerMethod(JavaComposite sc) {
		sc.addJavadoc("Use EcoreUtil.getRootContainer() instead.");
		sc.add("@Deprecated");
		sc.add("public static " + E_OBJECT + " findRootContainer(" + E_OBJECT + " object) {");
		sc.add(E_OBJECT + " container = object.eContainer();");
		sc.add("if (container != null) {");
		sc.add("return findRootContainer(container);");
		sc.add("} else {");
		sc.add("return object;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindAncestorByTypeMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the ancestor with the given type.");
		sc.add("public static " + E_OBJECT + " findAncestorByType(" + E_OBJECT + " object, " + E_CLASS + " type) {");
		sc.add(E_OBJECT + " ancestor = null;");
		sc.add(E_OBJECT + " container = object.eContainer();");
		sc.add("while (container != null) {");
		sc.add("if (type.isInstance(container)) {");
		sc.add("ancestor = container;");
		sc.add("}");
		sc.add("container = container.eContainer();");
		sc.add("}");
		sc.add("return ancestor;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindClosestsAncestorByTypeMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the closest ancestor with the given type.");
		sc.add("public static " + E_OBJECT + " findClosestAncestorByType(" + E_OBJECT + " object, " + E_CLASS + " type) {");
		sc.add(E_OBJECT + " container = object.eContainer();");
		sc.add("while (container != null) {");
		sc.add("if (type.isInstance(container)) {");
		sc.add("return container;");
		sc.add("}");
		sc.add("container = container.eContainer();");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInvokeOperationMethod(StringComposite sc) {
		sc.add("public static Object invokeOperation(" + E_OBJECT + " element, " + E_OPERATION + " o) {");
		sc.add(METHOD + " method;");
		sc.add("try {");
		sc.add("method = element.getClass().getMethod(o.getName(), new Class[]{});");
		sc.add("if (method != null) {");
		sc.add("Object result = method.invoke(element, new Object[]{});");
		sc.add("return result;");
		sc.add("}");
		sc.add("} catch (SecurityException e) {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Exception while matching proxy URI.\", e);");
		sc.add("} catch (NoSuchMethodException e) {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Exception while matching proxy URI.\", e);");
		sc.add("} catch (IllegalArgumentException e) {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Exception while matching proxy URI.\", e);");
		sc.add("} catch (IllegalAccessException e) {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Exception while matching proxy URI.\", e);");
		sc.add("} catch (" + INVOCATION_TARGET_EXCEPTION + " e) {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Exception while matching proxy URI.\", e);");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
}
