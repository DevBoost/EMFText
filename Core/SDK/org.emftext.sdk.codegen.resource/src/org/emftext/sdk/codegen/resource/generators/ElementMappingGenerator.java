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
package org.emftext.sdk.codegen.resource.generators;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class ElementMappingGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A basic implementation of the " + iElementMappingClassName + " interface.",
			"@param <ReferenceType> the type of the reference that can be mapped to"
		);
		sc.add("public class " + getResourceClassName() + "<ReferenceType> implements " + iElementMappingClassName + "<ReferenceType> {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetTargetElementMethod(sc);
		addGetIdentifierMethod(sc);
		addGetWarningMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final ReferenceType target;");
		sc.add("private String identifier;");
		sc.add("private String warning;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String identifier, ReferenceType target, String warning) {");
		sc.add("super();");
		sc.add("this.target = target;");
		sc.add("this.identifier = identifier;");
		sc.add("this.warning = warning;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTargetElementMethod(JavaComposite sc) {
		sc.add("public ReferenceType getTargetElement() {");
		sc.add("return target;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetIdentifierMethod(JavaComposite sc) {
		sc.add("public String getIdentifier() {");
		sc.add("return identifier;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetWarningMethod(JavaComposite sc) {
		sc.add("public String getWarning() {");
		sc.add("return warning;");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
