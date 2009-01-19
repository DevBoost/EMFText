package org.emftext.sdk.codegen;

import java.io.PrintWriter;

import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.BasicTokenResolverFactory;
import org.emftext.sdk.codegen.TextParserGenerator.InternalTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * Generates a TokenResolverFactory which will contain a mapping from ANTLR token names to 
 * TokenResolver implementations. It will inherit from BasicTokenResolverFactory.
 * 
 * @see org.emftext.runtime.resource.impl.BasicTokenResolverFactory
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class TokenResolverFactoryGenerator extends BaseGenerator {
	
	private GenerationContext context;
	
	public TokenResolverFactoryGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getTokenResolverFactoryClassName());
		this.context = context;
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		out.println("package " + getResourcePackageName() + ";");
		out.println();
		out.println("public class " + getResourceClassName() + " extends " + BasicTokenResolverFactory.class.getName() + " implements " + ITokenResolverFactory.class.getName() + " {");
		out.println();
		out.println("\tpublic " + getResourceClassName() + "(){");
		for (InternalTokenDefinition def : context.getUsedTokens()) {
			// user defined tokens may stem from an imported syntax
			ConcreteSyntax containingSyntax = context.getContainingSyntax(def);
			String tokenResolverClassName = context.getTokenResolverClassName(def);
			if (tokenResolverClassName != null) {
				if (def.isCollect()) {
					String featureName = def.getBaseDefinition().getAttributeName();
					out.println("\t\tsuper.registerCollectInTokenResolver(\"" + featureName + "\", new " + context.getResolverPackageName(containingSyntax) + "." + tokenResolverClassName + "());");
				} else {
					out.println("\t\tsuper.registerTokenResolver(\"" +def.getName()+ "\", new " + context.getResolverPackageName(containingSyntax) + "." + tokenResolverClassName + "());");
				}
			}
		}
		out.println("\t}");
		out.println("}");
		return true;
	}
}
