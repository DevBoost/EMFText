/*******************************************************************************
 * Copyright (c) 2006-2014
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
import static de.devboost.codecomposers.java.ClassNameConstants.ITERATOR;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class ListUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A utility class that encapsulates some case operations that need to be performed " +
			"unchecked, because of Java's type erasure."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.add("public static <T> " + LIST(sc) + "<T> castListUnchecked(Object list) {");
		sc.add("return (" + LIST(sc) + "<T>) list;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static " + LIST(sc) + "<Object> copySafelyToObjectList(" + LIST(sc) + "<?> list) {");
		sc.add(ITERATOR(sc) + "<?> it = list.iterator();");
		sc.add(LIST(sc) + "<Object> castedCopy = new " + ARRAY_LIST(sc) + "<Object>();");
		sc.add("while (it.hasNext()) {");
		sc.add("castedCopy.add(it.next());");
		sc.add("}");
		sc.add("return castedCopy;");
		sc.add("}");
		sc.add("}");
	}
}
