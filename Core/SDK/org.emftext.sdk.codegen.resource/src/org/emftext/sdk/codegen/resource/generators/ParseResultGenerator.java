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
package org.emftext.sdk.codegen.resource.generators;

import static de.devboost.codecomposers.java.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

import de.devboost.codecomposers.java.JavaComposite;

public class ParseResultGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " implements " + iParseResultClassName + " {");
        sc.addLineBreak();
        addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
    }

	private void addFields(JavaComposite sc) {
		sc.addFieldGetSet("root", E_OBJECT);
		sc.addFieldGetSet("locationMap", iLocationMapClassName);
		sc.addFields();
        sc.add("private " + COLLECTION + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> commands = new " + ARRAY_LIST + "<" + iCommandClassName + "<" + iTextResourceClassName + ">>();");
        sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		sc.addGettersSetters();
		addGetPostParseCommands(sc);
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPostParseCommands(JavaComposite sc) {
		sc.add("public " + COLLECTION + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> getPostParseCommands() {");
		sc.add("return commands;");
		sc.add("}");
		sc.addLineBreak();
	}
}
