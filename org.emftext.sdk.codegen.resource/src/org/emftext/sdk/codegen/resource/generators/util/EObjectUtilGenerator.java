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
package org.emftext.sdk.codegen.resource.generators.util;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASSIFIER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OPERATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INVOCATION_TARGET_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.METHOD;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

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

	private void addMethods(StringComposite sc) {
		addGetObjectsByTypeMethod(sc);
		addFindRootContainerMethod(sc);
		addInvokeOperationMethod(sc);
		addSetFeatureMethod(sc);
	}

	private void addGetObjectsByTypeMethod(StringComposite sc) {
		sc.add("public static <T> " + COLLECTION + "<T> getObjectsByType(" + ITERATOR + "<?> iterator,");
		sc.add(E_CLASSIFIER + " type) {");
		sc.add(COLLECTION + "<T> result = new " + ARRAY_LIST + "<T>();");
		sc.add("while (iterator.hasNext()) {");
		sc.add("Object object = iterator.next();");
		sc.add("if (type.isInstance(object)) {");
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("T t = (T) object;");
		sc.add("result.add(t);");
		sc.add("}");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetFeatureMethod(StringComposite sc) {
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
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

	private void addFindRootContainerMethod(StringComposite sc) {
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
		sc.add(pluginActivatorClassName + ".logError(\"Exception while matching proxy URI.\", e);");
		sc.add("} catch (NoSuchMethodException e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Exception while matching proxy URI.\", e);");
		sc.add("} catch (IllegalArgumentException e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Exception while matching proxy URI.\", e);");
		sc.add("} catch (IllegalAccessException e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Exception while matching proxy URI.\", e);");
		sc.add("} catch (" + INVOCATION_TARGET_EXCEPTION + " e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Exception while matching proxy URI.\", e);");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
}
