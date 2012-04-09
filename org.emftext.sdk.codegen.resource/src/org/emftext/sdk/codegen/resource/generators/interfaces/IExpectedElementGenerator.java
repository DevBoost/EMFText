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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IExpectedElementGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("An element that is expected at a given position in a resource stream.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the names of all tokens that are expected at the given position.");
		sc.add("public " + SET + "<String> getTokenNames();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the metaclass of the rule that contains the expected element.");
		sc.add("public " + E_CLASS +" getRuleMetaclass();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the syntax element that is expected.");
		sc.add("public " + syntaxElementClassName +" getSymtaxElement();");
		sc.addLineBreak();
		
		sc.addJavadoc("Adds an element that is a valid follower for this element.");
		sc.add("public void addFollower(" + iExpectedElementClassName + " follower, " + containedFeatureClassName + "[] path);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns all valid followers for this element. " +
			"Each follower is represented by a pair of an expected elements and the " +
			"containment trace that leads from the current element to the follower."
		);
		sc.add("public " + COLLECTION + "<" + pairClassName + "<" + iExpectedElementClassName + ", " + containedFeatureClassName + "[]>> getFollowers();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
