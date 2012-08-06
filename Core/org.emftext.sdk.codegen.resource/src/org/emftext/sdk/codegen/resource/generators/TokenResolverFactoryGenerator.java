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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * Generates a TokenResolverFactory which will contain a mapping from 
 * token names to TokenResolver implementations.
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
@SyntaxDependent
public class TokenResolverFactoryGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	private final NameUtil nameUtil = new NameUtil();
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"The " + getResourceClassName() + " class provides access to all generated token resolvers. " +
			"By giving the name of a defined token, the corresponding resolve can be obtained. Despite the " +
			"fact that this class is called TokenResolverFactory is does NOT create new token resolvers " +
			"whenever a client calls methods to obtain a resolver. Rather, this class maintains a map " +
			"of all resolvers and creates each resolver at most once."
		);
		sc.add("public class " + getResourceClassName() + " implements " + iTokenResolverFactoryClassName + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(StringComposite sc) {
		addCreateTokenResolverMethod(sc);
		addCreateCollectInTokenResolverMethod(sc);
		addRegisterTokenResolverMethod(sc);
		addRegisterCollectInTokenResolverMethod(sc);
		addDeRegisterTokenResolverMethod(sc);
		addInternalCreateResolverMethod(sc);
		addInternalRegisterTokenResolverMethod(sc);
	}

	private void addInternalRegisterTokenResolverMethod(StringComposite sc) {
		sc.add("private boolean internalRegisterTokenResolver(" + MAP + "<String, " + iTokenResolverClassName + "> resolverMap, String key, " + iTokenResolverClassName + " resolver) {");
		sc.add("if (!resolverMap.containsKey(key)) {");
		sc.add("resolverMap.put(key,resolver);");
		sc.add("return true;");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInternalCreateResolverMethod(StringComposite sc) {
		sc.add("private " + iTokenResolverClassName + " internalCreateResolver(" + MAP + "<String, " + iTokenResolverClassName + "> resolverMap, String key) {");
		sc.add("if (resolverMap.containsKey(key)){");
		sc.add("return resolverMap.get(key);");
		sc.add("} else {");
		sc.add("return defaultResolver;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeRegisterTokenResolverMethod(StringComposite sc) {
		sc.add("protected " + iTokenResolverClassName + " deRegisterTokenResolver(String tokenName){");
		sc.add("return tokenName2TokenResolver.remove(tokenName);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRegisterCollectInTokenResolverMethod(StringComposite sc) {
		sc.add("protected boolean registerCollectInTokenResolver(String featureName, " + iTokenResolverClassName + " resolver){");
		sc.add("return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRegisterTokenResolverMethod(StringComposite sc) {
		sc.add("protected boolean registerTokenResolver(String tokenName, " + iTokenResolverClassName + " resolver){");
		sc.add("return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateCollectInTokenResolverMethod(StringComposite sc) {
		sc.add("public " + iTokenResolverClassName + " createCollectInTokenResolver(String featureName) {");
		sc.add("return internalCreateResolver(featureName2CollectInTokenResolver, featureName);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateTokenResolverMethod(StringComposite sc) {
		sc.add("public " + iTokenResolverClassName + " createTokenResolver(String tokenName) {");
		sc.add("return internalCreateResolver(tokenName2TokenResolver, tokenName);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + MAP + "<String, " + iTokenResolverClassName + "> tokenName2TokenResolver;");
		sc.add("private " + MAP + "<String, " + iTokenResolverClassName + "> featureName2CollectInTokenResolver;");
		sc.add("private static " + iTokenResolverClassName + " defaultResolver = new " + defaultTokenResolverClassName + "();");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("tokenName2TokenResolver = new " + LINKED_HASH_MAP + "<String, " + iTokenResolverClassName + ">();");
		sc.add("featureName2CollectInTokenResolver = new " + LINKED_HASH_MAP + "<String, " + iTokenResolverClassName + ">();");
		ConcreteSyntax concreteSyntax = getContext().getConcreteSyntax();
		for (CompleteTokenDefinition definition : concreteSyntax.getActiveTokens()) {
			if (!definition.isUsed()) {
				continue;
			}
			// user defined tokens may stem from an imported syntax
			String tokenResolverClassName = nameUtil.getQualifiedTokenResolverClassName(concreteSyntax, definition, false);
			if (definition.getAttributeName() != null) {
				String featureName = definition.getAttributeName();
				sc.add("registerCollectInTokenResolver(\"" + featureName + "\", new " + tokenResolverClassName + "());");
			} else {
				sc.add("registerTokenResolver(\"" +definition.getName()+ "\", new " + tokenResolverClassName + "());");
			}
		}
		sc.add("}");
		sc.addLineBreak();
	}
}
