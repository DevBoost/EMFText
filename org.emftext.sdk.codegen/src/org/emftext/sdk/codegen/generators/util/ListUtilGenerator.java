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
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ListUtilGenerator extends JavaBaseGenerator {

	public ListUtilGenerator() {
		super();
	}

	private ListUtilGenerator(GenerationContext context) {
		super(context, EArtifact.LIST_UTIL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ListUtilGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A utility class that encapsulates some case operations that need to be performed " +
			"unchecked, because of Java's type erasure."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public static <T> " + LIST + "<T> castListUnchecked(Object list) {");
		sc.add("return (" + LIST + "<T>) list;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static " + LIST + "<Object> copySafelyToObjectList(" + LIST + "<?> list) {");
		sc.add(ITERATOR + "<?> it = list.iterator();");
		sc.add(LIST + "<Object> castedCopy = new " + ARRAY_LIST + "<Object>();");
		sc.add("while (it.hasNext()) {");
		sc.add("castedCopy.add(it.next());");
		sc.add("}");
		sc.add("return castedCopy;");
		sc.add("}");
		sc.add("}");
		return true;
	}
}
