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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IOptionProviderGenerator extends JavaBaseGenerator {

	public IOptionProviderGenerator() {
		super();
	}

	private IOptionProviderGenerator(GenerationContext context) {
		super(context, EArtifact.I_OPTION_PROVIDER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IOptionProviderGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Implementors of this interface can provide options that " +
			"are used when resources are loaded."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		// TODO is this still needed? option providers are registered
		// to individual extension points since the Runtime is gone. 
		sc.addJavadoc(
			"The name of the attribute of the default_load_options " +
			"extension point that specifies to which resources an " +
			"option provider applies."
		);
		sc.add("public static final String CS_NAME = \"csName\";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns a map of options. The keys are the names of the " +
			"options, the values are arbitrary objects that provide " +
			"additional information or logic for the option."
		);
		sc.add("public " + MAP + "<?,?> getOptions();");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}
}
