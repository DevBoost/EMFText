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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IReferenceResolverSwitchGenerator extends JavaBaseGenerator {

	public IReferenceResolverSwitchGenerator() {
		super();
	}

	private IReferenceResolverSwitchGenerator(GenerationContext context) {
		super(context, EArtifact.I_REFERENCE_RESOLVER_SWITCH);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IReferenceResolverSwitchGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A " + getResourceClassName() + " holds references to multiple " +
			"other reference resolvers and delegates requests to the appropriate resolver."
		);
		sc.add("public interface " + getResourceClassName() + " extends " + iConfigurableClassName + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Attempts to resolve a reference string fuzzy (returning objects that do not match exactly). " +
			"This is need during code completion.",
			"@param identifier The identifier for the reference.",
			"@param container The object that contains the reference.",
			"@param reference The reference that points to the target of the reference.",
			"@param result an object to store the result of the resolve operation."
		);
		sc.add("public void resolveFuzzy(String identifier, " + E_OBJECT + " container, " + E_REFERENCE + " reference, int position, " + iReferenceResolveResultClassName + "<" + E_OBJECT + "> result);");
		
		sc.add("}");
		return true;
	}
}
