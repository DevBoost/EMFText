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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IDelegatingReferenceResolverGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A delegating reference resolver is an extension of a normal reference resolver that can be " +
			"configured with another resolver that it may delegate method calls to. This interface can be " +
			"implemented by additional resolvers to customize resolving using the load option " +
			IOptionsGenerator.ADDITIONAL_REFERENCE_RESOLVERS + ".",
			"@see " + iOptionsClassName
		);
		sc.add("public interface " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> extends " + iReferenceResolverClassName + "<ContainerType, ReferenceType> {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Sets the delegate for this resolver."
		);
		sc.add("public void setDelegate(" + iReferenceResolverClassName + "<ContainerType, ReferenceType> delegate);");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
