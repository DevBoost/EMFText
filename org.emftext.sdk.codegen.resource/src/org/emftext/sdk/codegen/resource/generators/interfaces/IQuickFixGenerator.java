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
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IQuickFixGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.addJavadoc(
			"Returns a string that briefly describes the quick fix.",
			"@return brief description to display"
		);
		sc.add("public String getDisplayString();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns an image key that references an image for the quick fix. " +
			"This key will be passed to the ImageProvider class of the resource UI plug-in to obtain the image.",
			"@return key of the image to display"
		);
		sc.add("public String getImageKey();");
		sc.addLineBreak();

		sc.addJavadoc(
			"Applies the fix and returns the new text for the resource. " +
			"If the fix does not change the current resource, but others, " +
			"null must be returned."
		);
		sc.add("public String apply(String currentText);");
		sc.addLineBreak();

		sc.addJavadoc(
			"Returns a collection of objects the fix refers to. This " +
			"collection is used to check whether the fix is can still " + 
			"be applied even after a workbench restart."
		);
		sc.add("public " + COLLECTION + "<" + E_OBJECT + "> getContextObjects();");
		sc.addLineBreak();

		sc.addJavadoc(
			"Returns a string representation of the context in which this quick fix can be used. " +
			"Typically this is a list of the URIs of the EObjects the fix applies to concatenated " +
			"with the type of the quick fix. This context string is used to find quick fixes when " +
			"the quick fix wizard is invoked from the problems view. The context string must stay " +
			"the same when resources are (re)loaded from disc. This is required to find quick fixes " +
			"that have been created before (i.e., the last time the resource was loaded)."
		);
		sc.add("public String getContextAsString();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
