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
package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IExpectedElementGenerator extends JavaBaseGenerator {

	public IExpectedElementGenerator() {
		super();
	}

	private IExpectedElementGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_EXPECTED_ELEMENT);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new IExpectedElementGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("An element that is expected at a given position in a resource stream.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public " + STRING +" getTokenName();");
		sc.add("public " + E_CLASS +" getRuleMetaclass();");
		sc.add("public void addFollower(" + iExpectedElementClassName + " follower, " + E_STRUCTURAL_FEATURE + "[] path);");
		sc.add("public " + COLLECTION + "<" + pairClassName + "<" + iExpectedElementClassName + ", " + E_STRUCTURAL_FEATURE + "[]>> getFollowers();");
		sc.add("}");
		return true;
	}
}
