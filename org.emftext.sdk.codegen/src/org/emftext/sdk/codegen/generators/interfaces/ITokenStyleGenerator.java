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

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ITokenStyleGenerator extends JavaBaseGenerator {

	public ITokenStyleGenerator() {
		super();
	}

	private ITokenStyleGenerator(GenerationContext context) {
		super(context, EArtifact.I_TOKEN_STYLE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITokenStyleGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A common interface for token styles. Text resources must");
		sc.add("// return style information using object implementing this");
		sc.add("// interface.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Returns the color of the token as array of length 3.");
		sc.add("public int[] getColorAsRGB();");
		sc.addLineBreak();
		
		sc.add("// Returns true if the token must be displayed in bold face.");
		sc.add("public boolean isBold();");
		sc.addLineBreak();
		
		sc.add("// Returns true if the token must be displayed in italic face.");
		sc.add("public boolean isItalic();");
		sc.addLineBreak();
		
		sc.add("// Returns true if the token must be displayed in strike through style.");
		sc.add("public boolean isStrikethrough();");
		sc.addLineBreak();
		
		sc.add("// Returns true if the token must be displayed underline.");
		sc.add("public boolean isUnderline();");
		sc.add("}");
		return true;
	}
}
