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
package org.emftext.sdk.codegen.resource.generators.code_completion;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class AbstractExpectedElementGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("Abstract super class for all expected elements. Provides methods to add followers.");
		sc.add("public abstract class " + getResourceClassName() + " implements " + iExpectedElementClassName + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
	}

	private void addMethods(StringComposite sc) {
		addGetRuleMetaclassMethod(sc);
		addAddFollowerMethod(sc);
		addGetFollowersMethod(sc);
	}

	private void addGetFollowersMethod(StringComposite sc) {
		sc.add("public " + COLLECTION + "<" + pairClassName + "<" + iExpectedElementClassName + ", " + containedFeatureClassName + "[]>> getFollowers() {");
		sc.add("return followers;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddFollowerMethod(StringComposite sc) {
		sc.add("public void addFollower(" + iExpectedElementClassName + " follower, " + containedFeatureClassName + "[] path) {");
		sc.add("followers.add(new " + pairClassName + "<" + iExpectedElementClassName + ", " + containedFeatureClassName + "[]>(follower, path));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetRuleMetaclassMethod(StringComposite sc) {
		sc.add("public " + E_CLASS + " getRuleMetaclass() {");
		sc.add("return ruleMetaclass;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_CLASS + " ruleMetaclass) {");
		sc.add("super();");
		sc.add("this.ruleMetaclass = ruleMetaclass;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + E_CLASS + " ruleMetaclass;");
		sc.addLineBreak();
		sc.add("private " + SET + "<" + pairClassName + "<" + iExpectedElementClassName + ", " + containedFeatureClassName + "[]>> followers = new " + LINKED_HASH_SET + "<" + pairClassName + "<" + iExpectedElementClassName + ", " + containedFeatureClassName + "[]>>();");
		sc.addLineBreak();
	}
}
