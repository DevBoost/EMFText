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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class MapUtilGenerator extends JavaBaseGenerator {

	public MapUtilGenerator() {
		super();
	}

	private MapUtilGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.MAP_UTIL);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addCastToMapMethod(sc);
		addCastToEMapMethod(sc);
		sc.add("}");
		return true;
	}

	private void addCastToEMapMethod(JavaComposite sc) {
		sc.addJavadoc(
			"This method encapsulate an unchecked cast from Object to " +
			E_MAP + "<Object, Object>. This case can not be performed type " +
			"safe, because type parameters are not available for " +
			"reflective access to Ecore models.",
			"@return the same object casted to a map"
		);
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.add("public static " + E_MAP + "<Object, Object> castToEMap(Object value) {");
		sc.add("return (" + E_MAP + "<Object,Object>) value;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static " + MAP + "<Object, Object> copySafelyToObjectToObjectMap(" + MAP + "<?, ?> map) {");
		sc.add(MAP + "<Object, Object> castedCopy = new " + LINKED_HASH_MAP + "<Object, Object>();");
		sc.addLineBreak();
		sc.add("if (map == null) {");
		sc.add("return castedCopy;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(ITERATOR + "<?> it = map.keySet().iterator();");
		sc.add("while (it.hasNext()) {");
		sc.add("Object nextKey = it.next();");
		sc.add("castedCopy.put(nextKey, map.get(nextKey));");
		sc.add("}");
		sc.add("return castedCopy;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCastToMapMethod(JavaComposite sc) {
		sc.addJavadoc(
			"This method encapsulate an unchecked cast from Object to " +
			MAP + "<Object, Object>. This case can not be performed type " +
			"safe, because type parameters are not available for " +
			"reflective access to Ecore models.",
			"@param value the object to cast",
			"@return the same object casted to a map"
		);
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public static " + MAP + "<Object, Object> castToMap(Object value) {");
		sc.add("return (" + MAP + "<Object,Object>) value;");
		sc.add("}");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new MapUtilGenerator(context);
	}
}
