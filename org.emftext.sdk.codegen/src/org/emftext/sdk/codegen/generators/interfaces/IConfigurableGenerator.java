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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IConfigurableGenerator extends JavaBaseGenerator {

	public IConfigurableGenerator() {
		super();
	}

	private IConfigurableGenerator(GenerationContext context) {
		super(context, EArtifact.I_CONFIGURABLE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IConfigurableGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Implementors of this interface can be configured by a");
		sc.add("// map of options (or parameters).");
		
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Passed the options given by the map to the configurable");
		sc.add("// object.");
		
		sc.add("public void setOptions(" + MAP + "<?,?> options);");
		sc.add("}");
		return true;
	}
}
