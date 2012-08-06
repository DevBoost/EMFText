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

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ITokenStyleGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A common interface for token styles. Text resources must " +
			"return style information using classes that implement this " +
			"interface."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the color of the token as array of length 3.");
		sc.add("public int[] getColorAsRGB();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns the background color of the token as array of length 3. " +
			"This method can return <code>null</code> if no background color is set."
		);
		sc.add("public int[] getBackgroundColorAsRGB();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns true if the token must be displayed in bold face.");
		sc.add("public boolean isBold();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns true if the token must be displayed in italic face.");
		sc.add("public boolean isItalic();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns true if the token must be displayed in strike through style.");
		sc.add("public boolean isStrikethrough();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns true if the token must be displayed underlined.");
		sc.add("public boolean isUnderline();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
