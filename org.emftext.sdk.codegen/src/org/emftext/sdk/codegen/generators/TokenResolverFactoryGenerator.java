/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.NameUtil;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * Generates a TokenResolverFactory which will contain a mapping from 
 * ANTLR token names to TokenResolver implementations. It will inherit 
 * from AbstractTokenResolverFactory to allow adaptation to API changes.
 * 
 * @see org.emftext.runtime.resource.impl.AbstractTokenResolverFactory
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class TokenResolverFactoryGenerator extends BaseGenerator {
	
	private final NameUtil nameUtil = new NameUtil();
	
	public TokenResolverFactoryGenerator() {
		super();
	}

	private TokenResolverFactoryGenerator(GenerationContext context) {
		super(context, EArtifact.TOKEN_RESOLVER_FACTORY);
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + getClassNameHelper().getI_TOKEN_RESOLVER_FACTORY() + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addCreateTokenResolverMethod(sc);
		addCreateCollectInTokenResolverMethod(sc);
		addRegisterTokenResolverMethod(sc);
		addRegisterCollectInTokenResolverMethod(sc);
		addDeRegisterTokenResolverMethod(sc);
		addInternalCreateResolverMethod(sc);
		addInternalRegisterTokenResolverMethod(sc);
		
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}

	private void addInternalRegisterTokenResolverMethod(StringComposite sc) {
		sc.add("private boolean internalRegisterTokenResolver(" + MAP + "<" + STRING + ", " + getClassNameHelper().getI_TOKEN_RESOLVER() + "> resolverMap, " + STRING + " key, " + getClassNameHelper().getI_TOKEN_RESOLVER() + " resolver) {");
		sc.add("if (!resolverMap.containsKey(key)) {");
		sc.add("resolverMap.put(key,resolver);");
		sc.add("return true;");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInternalCreateResolverMethod(StringComposite sc) {
		sc.add("private " + getClassNameHelper().getI_TOKEN_RESOLVER() + " internalCreateResolver(" + MAP + "<" + STRING + ", " + getClassNameHelper().getI_TOKEN_RESOLVER() + "> resolverMap, String key) {");
		sc.add("if (resolverMap.containsKey(key)){");
		sc.add("return resolverMap.get(key);");
		sc.add("} else {");
		sc.add("return defaultResolver;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeRegisterTokenResolverMethod(StringComposite sc) {
		sc.add("protected " + getClassNameHelper().getI_TOKEN_RESOLVER() + " deRegisterTokenResolver(" + STRING + " tokenName){");
		sc.add("return tokenName2TokenResolver.remove(tokenName);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRegisterCollectInTokenResolverMethod(StringComposite sc) {
		sc.add("protected boolean registerCollectInTokenResolver(" + STRING + " featureName, " + getClassNameHelper().getI_TOKEN_RESOLVER() + " resolver){");
		sc.add("return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRegisterTokenResolverMethod(StringComposite sc) {
		sc.add("protected boolean registerTokenResolver(" + STRING + " tokenName, " + getClassNameHelper().getI_TOKEN_RESOLVER() + " resolver){");
		sc.add("return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateCollectInTokenResolverMethod(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_TOKEN_RESOLVER() + " createCollectInTokenResolver(" + STRING + " featureName) {");
		sc.add("return internalCreateResolver(featureName2CollectInTokenResolver, featureName);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateTokenResolverMethod(StringComposite sc) {
		sc.add("public " + getClassNameHelper().getI_TOKEN_RESOLVER() + " createTokenResolver(" + STRING + " tokenName) {");
		sc.add("return internalCreateResolver(tokenName2TokenResolver, tokenName);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + MAP + "<" + STRING + ", " + getClassNameHelper().getI_TOKEN_RESOLVER() + "> tokenName2TokenResolver;");
		sc.add("private " + MAP + "<" + STRING + ", " + getClassNameHelper().getI_TOKEN_RESOLVER() + "> featureName2CollectInTokenResolver;");
		String qualifiedDefaultTokenResolverClassName = getContext().getQualifiedClassName(EArtifact.DEFAULT_TOKEN_RESOLVER);
		sc.add("private static " + getClassNameHelper().getI_TOKEN_RESOLVER() + " defaultResolver = new " + qualifiedDefaultTokenResolverClassName + "();");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("tokenName2TokenResolver = new " + HASH_MAP + "<" + STRING + ", " + getClassNameHelper().getI_TOKEN_RESOLVER() + ">();");
		sc.add("featureName2CollectInTokenResolver = new " + HASH_MAP + "<" + STRING + ", " + getClassNameHelper().getI_TOKEN_RESOLVER() + ">();");
		ConcreteSyntax concreteSyntax = getContext().getConcreteSyntax();
		for (TokenDefinition definition : concreteSyntax.getActiveTokens()) {
			if (!definition.isUsed()) {
				continue;
			}
			// user defined tokens may stem from an imported syntax
			String tokenResolverClassName = nameUtil.getQualifiedTokenResolverClassName(concreteSyntax, definition);
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

	public IGenerator newInstance(GenerationContext context) {
		return new TokenResolverFactoryGenerator(context);
	}
}
