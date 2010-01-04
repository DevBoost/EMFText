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
package org.emftext.sdk.codegen.generators.code_completion;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SET;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class AbstractExpectedElementGenerator extends JavaBaseGenerator {

	private String iExpectedElementClassName;

	public AbstractExpectedElementGenerator() {
		super();
	}

	private AbstractExpectedElementGenerator(GenerationContext context) {
		super(context, EArtifact.ABSTRACT_EXPECTED_ELEMENT);
		iExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.I_EXPECTED_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new AbstractExpectedElementGenerator(context);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Abstract super class for all expected elements. Provides methods to");
		sc.add("// add followers");
		sc.add("public abstract class " + getResourceClassName() + " implements " + iExpectedElementClassName + " {");
		sc.addLineBreak();
		sc.add("private " + SET + "<" + iExpectedElementClassName + "> followers = new " + LINKED_HASH_SET + "<" + iExpectedElementClassName + ">();");
		sc.addLineBreak();
		
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void addFollower(" + iExpectedElementClassName + " follower) {");
		sc.add("followers.add(follower);");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public " + COLLECTION + "<" + iExpectedElementClassName + "> getFollowers() {");
		sc.add("return followers;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("}");
		return true;
	}
}
