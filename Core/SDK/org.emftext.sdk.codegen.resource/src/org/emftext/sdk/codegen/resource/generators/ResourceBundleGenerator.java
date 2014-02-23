/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.generators;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

import de.devboost.codecomposers.java.JavaComposite;

public class ResourceBundleGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public final static String BUILDER_ADAPTER_TASK_NAME = "BUILDER_ADAPTER_TASK_NAME";
	
	public void generateJavaContents(JavaComposite jc) {
		jc.add("package " + getResourcePackageName() + ";");
		jc.addLineBreak();
		jc.addImportsPlaceholder();
		jc.addLineBreak();
		jc.addJavadoc("A class to hold all resources (e.g., text constants) for the resource plug-in.");
		jc.add("public class " + getResourceClassName() + " {");
		jc.addLineBreak();
		addConstants(jc);
		jc.add("}");
	}

	private void addConstants(JavaComposite jc) {
		jc.addJavadoc("The name of the main task that is shown in the progress view when the builders are running.");
		jc.add("public static String BUILDER_ADAPTER_TASK_NAME = \"Building " + getContext().getConcreteSyntax().getName() + " file\";");
	}
}
