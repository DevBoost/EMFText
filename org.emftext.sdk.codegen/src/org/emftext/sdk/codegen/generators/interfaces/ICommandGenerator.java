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
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ICommandGenerator extends JavaBaseGenerator {

	public ICommandGenerator() {
		super();
	}

	private ICommandGenerator(GenerationContext context) {
		super(context, EArtifact.I_COMMAND);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ICommandGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A simple interface for commands that can be executed");
		sc.add("// and that return information about the success of their");
		sc.add("// execution.");
		
		sc.add("public interface " + getResourceClassName() + "<ContextType> {");
		sc.addLineBreak();
		sc.add("public boolean execute(ContextType context);");
		sc.add("}");
		return true;
	}
}
