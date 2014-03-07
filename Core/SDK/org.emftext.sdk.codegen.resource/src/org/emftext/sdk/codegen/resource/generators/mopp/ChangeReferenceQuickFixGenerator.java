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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.ClassNameConstants.ARRAYS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_REFERENCE;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class ChangeReferenceQuickFixGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"A quick fix that replaces the target of a reference with another EObject. " +
			"This class is used to implement default quick fixes for references that could not " +
			"be resolved, but can also be used by custom reference resolvers."
		);
		sc.add("public class " + getResourceClassName() + " extends " + quickFixClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + E_OBJECT(sc) + " container;");
		sc.add("private " + E_REFERENCE(sc) + " reference;");
		sc.add("private " + E_OBJECT(sc) + " oldTarget;");
		sc.add("private " + E_OBJECT(sc) + " newTarget;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String displayString, String imageKey, " + E_OBJECT(sc) + " container, " + E_REFERENCE(sc) + " reference, " + E_OBJECT(sc) + " oldTarget, " + E_OBJECT(sc) + " newTarget) {");
		sc.add("super(displayString, imageKey, " + ARRAYS(sc) + ".asList(container, reference, oldTarget));");
		sc.add("this.container = container;");
		sc.add("this.reference = reference;");
		sc.add("this.oldTarget = oldTarget;");
		sc.add("this.newTarget = newTarget;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addMethods(JavaComposite sc) {
		addApplyChangesMethod(sc);
	}

	private void addApplyChangesMethod(JavaComposite sc) {
		sc.add("@Override");
		sc.add("public void applyChanges() {");
		sc.add(ECORE_UTIL(sc) + ".replace(container, reference, oldTarget, newTarget);");
		sc.add("}");
		sc.addLineBreak();
	}
}
