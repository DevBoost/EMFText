/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.codegen.generators;

import java.util.Collection;
import java.util.Collections;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

public class EmptyClassGenerator extends JavaBaseGenerator {

	private String className;
	private EArtifact targetPackage;

	public EmptyClassGenerator() {
		super();
	}

	private EmptyClassGenerator(GenerationContext context) {
		super();
		this.context = context;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setTargetPackage(EArtifact targetPackage) {
		this.targetPackage = targetPackage;
	}

	public boolean generateJavaContents(StringComposite sc) {

		sc.add("package " + context.getPackageName(targetPackage) + ";");
		sc.addLineBreak();

		sc.add("// this empty class was generated to overwrite exiting");
		sc.add("// classes");
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

	public IGenerator newInstance(GenerationContext context) {
		return new EmptyClassGenerator(context);
	}
}
