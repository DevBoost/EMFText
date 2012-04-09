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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ContainedFeatureGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A " + getResourceClassName() + " represents a path element of a " +
			containmentTraceClassName
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructors(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc("The class to which the feature points.");
		sc.add("private " + E_CLASS + " containerClass;");
		sc.addLineBreak();
		sc.addJavadoc("The feature that points to the container class.");
		sc.add("private " + E_STRUCTURAL_FEATURE + " feature;");
		sc.addLineBreak();
	}

	private void addConstructors(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_CLASS + " containerClass, " + E_STRUCTURAL_FEATURE + " feature) {");
		sc.add("super();");
		sc.add("this.containerClass = containerClass;");
		sc.add("this.feature = feature;");
		sc.add("}");
		sc.addLineBreak();
	}
	private void addMethods(JavaComposite sc) {
		addGetContainerClassMethod(sc);
		addGetFeatureMethod(sc);
		addToStringMethod(sc);
	}

	private void addGetContainerClassMethod(JavaComposite sc) {
		sc.add("public " + E_CLASS + " getContainerClass() {");
		sc.add("return containerClass;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFeatureMethod(JavaComposite sc) {
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {");
		sc.add("return feature;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {");
		sc.add("return (feature == null ? \"null\" : feature.getName()) + \"->\" + (containerClass == null ? \"null\" : containerClass.getName());");
		sc.add("}");
		sc.addLineBreak();
	}
}
