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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASSIFIER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OPERATION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INVOCATION_TARGET_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.METHOD;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class EObjectUtilGenerator extends JavaBaseGenerator {

	public EObjectUtilGenerator() {
		super();
	}

	private EObjectUtilGenerator(GenerationContext context) {
		super(context, EArtifact.E_OBJECT_UTIL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new EObjectUtilGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A utility class that can be used to work with EObjects.");
		sc.add("// While many similar methods are provided by EMF's own");
		sc.add("// EcoreUtil class, the missing ones are collected here.");
		sc.add("//");
		sc.add("// @see org.eclipse.emf.ecore.util.EcoreUtil");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
		return true;
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
		sc.add(OBJECT + " object = iterator.next();");
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
		sc.add("public static void setFeature(" + E_OBJECT + " object, " + E_STRUCTURAL_FEATURE + " eFeature, " + OBJECT + " value, boolean clearIfList) {");
		sc.add("int upperBound = eFeature.getUpperBound();");
		sc.add("if (upperBound > 1 || upperBound < 0) {");
		sc.add("Object oldValue = object.eGet(eFeature);");
		sc.add("if (oldValue instanceof " + LIST + "<?>) {");
		sc.add(LIST + "<" + OBJECT + "> list = (" + LIST + "<" + OBJECT + ">) oldValue;");
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
		sc.add("public static " + OBJECT + " invokeOperation(" + E_OBJECT + " element, " + E_OPERATION + " o) {");
		sc.add(METHOD + " method;");
		sc.add("try {");
		sc.add("method = element.getClass().getMethod(o.getName(), new Class[]{});");
		sc.add("if (method != null) {");
		sc.add(OBJECT + " result = method.invoke(element, new " + OBJECT + "[]{});");
		sc.add("return result;");
		sc.add("}");
		sc.add("} catch (SecurityException e) {");
		sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"" + EXCEPTION + " while matching proxy URI.\", e);");
		sc.add("} catch (NoSuchMethodException e) {");
		sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"" + EXCEPTION + " while matching proxy URI.\", e);");
		sc.add("} catch (IllegalArgumentException e) {");
		sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"" + EXCEPTION + " while matching proxy URI.\", e);");
		sc.add("} catch (IllegalAccessException e) {");
		sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"" + EXCEPTION + " while matching proxy URI.\", e);");
		sc.add("} catch (" + INVOCATION_TARGET_EXCEPTION + " e) {");
		sc.add(getClassNameHelper().getPLUGIN_ACTIVATOR() + ".logError(\"" + EXCEPTION + " while matching proxy URI.\", e);");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
}
