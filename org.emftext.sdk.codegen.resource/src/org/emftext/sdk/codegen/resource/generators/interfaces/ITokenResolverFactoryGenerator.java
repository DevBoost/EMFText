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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ITokenResolverFactoryGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ITokenResolverFactoryGenerator());

	private ITokenResolverFactoryGenerator() {
		super();
	}

	private ITokenResolverFactoryGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.I_TOKEN_RESOLVER_FACTORY);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new ITokenResolverFactoryGenerator(parent, context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
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
		return true;
	}
}
