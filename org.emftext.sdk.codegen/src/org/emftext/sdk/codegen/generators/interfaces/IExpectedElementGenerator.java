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
package org.emftext.sdk.codegen.generators.interfaces;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IExpectedElementGenerator extends JavaBaseGenerator {

	public IExpectedElementGenerator() {
		super();
	}

	private IExpectedElementGenerator(GenerationContext context) {
		super(context, EArtifact.I_EXPECTED_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IExpectedElementGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// An element that is expected at a given position in a resource");
		sc.add("// stream.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		// TODO mseifert: remove this
		sc.add("public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens);");
		sc.add("public int getStartExcludingHiddenTokens();");
		sc.add("public int getStartIncludingHiddenTokens();");
		sc.add("public String getPrefix();");
		sc.add("public void setPrefix(String prefix);");
		sc.add("public String getScopeID();");
		//sc.add("public boolean discardFollowingExpectations();");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
