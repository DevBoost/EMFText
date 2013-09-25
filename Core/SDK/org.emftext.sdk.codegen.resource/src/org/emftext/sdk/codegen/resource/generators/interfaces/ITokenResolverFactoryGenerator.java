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

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class ITokenResolverFactoryGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A TokenResolverFactory creates TokenResolvers. The concrete resolver to be created " +
			"is determined by the given token name (i.e., the type of the token). " +
			"One may consider TokenResolverFactories as a registry, which maps token types to TokenResolvers."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Creates a token resolver for normal tokens of type <code>tokenName</code>.");
		sc.add("public " + iTokenResolverClassName + " createTokenResolver(String tokenName);");
		sc.addLineBreak();
		
		sc.addJavadoc("Creates a token resolver for COLLECT-IN tokens that are stored in feature <code>featureName</code>.");
		sc.add("public " + iTokenResolverClassName + " createCollectInTokenResolver(String featureName);");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
