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
package org.emftext.sdk.codegen.resource.generators;

import java.util.Collection;
import java.util.Collections;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class EmptyClassGenerator extends JavaBaseGenerator<Object> {

	private String className;
	private ArtifactDescriptor<GenerationContext, ?> targetPackage;

	public EmptyClassGenerator() {
		super();
	}

	private EmptyClassGenerator(GenerationContext context, Object parameters) {
		super();
		this.context = context;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setTargetPackage(ArtifactDescriptor<GenerationContext, ?> targetPackage) {
		this.targetPackage = targetPackage;
	}

	public boolean generateJavaContents(JavaComposite sc) {

		sc.add("package " + context.getPackageName(targetPackage) + ";");
		sc.addLineBreak();

		sc.addJavadoc("This empty class was generated to overwrite exiting classes.");
		sc.add("public class " + className + " {");
		sc.add("}");

		return true;
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptySet();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptySet();
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new EmptyClassGenerator(context, parameters);
	}
}
