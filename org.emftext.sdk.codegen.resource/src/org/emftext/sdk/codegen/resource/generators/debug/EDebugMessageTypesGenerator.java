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
package org.emftext.sdk.codegen.resource.generators.debug;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class EDebugMessageTypesGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public enum " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addComment(
			"An enumeration of all commands that can be sent to the debug server from " +
			"debug clients (i.e., interpreters or other processes)."
		);
		
		sc.add("STARTED,");
		sc.add("RESUMED,");
		sc.add("TERMINATED,");
		sc.add("SUSPENDED,");
		sc.addLineBreak();
		
		sc.addComment(
			"An enumeration of all commands that can be sent by the debug server to debug " +
			"clients (i.e., interpreters or other processes)."
		);
		
		sc.add("GET_FRAME_VARIABLES,");
		sc.add("GET_VARIABLES,");
		sc.add("GET_STACK,");
		sc.add("STEP_RETURN,");
		sc.add("STEP_INTO,");
		sc.add("STEP_OVER,");
		sc.add("RESUME,");
		sc.add("EXIT,");
		sc.addLineBreak();
		sc.add("ADD_LINE_BREAKPOINT,");
		sc.add("REMOVE_LINE_BREAKPOINT,");
		sc.addLineBreak();
		sc.add("GET_STACK_RESPONSE,");
		sc.add("GET_FRAME_VARIABLES_RESPONSE,");
		sc.add("GET_VARIABLES_RESPONSE,");
		sc.add("}");
	}
}
