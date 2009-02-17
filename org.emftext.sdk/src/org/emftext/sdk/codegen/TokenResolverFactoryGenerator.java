package org.emftext.sdk.codegen;

import java.io.PrintWriter;

import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.AbstractTokenResolverFactory;
import org.emftext.sdk.codegen.TextParserGenerator.InternalTokenDefinition;
import org.emftext.sdk.codegen.util.JavaStringComposite;
import org.emftext.sdk.codegen.util.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * Generates a TokenResolverFactory which will contain a mapping from ANTLR token names to 
 * TokenResolver implementations. It will inherit from BasicTokenResolverFactory.
 * 
 * @see org.emftext.runtime.resource.impl.AbstractTokenResolverFactory
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
		StringComposite sc = new JavaStringComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + AbstractTokenResolverFactory.class.getName() + " implements " + ITokenResolverFactory.class.getName() + " {");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "() {");
		for (InternalTokenDefinition def : context.getUsedTokens()) {
			// user defined tokens may stem from an imported syntax
			ConcreteSyntax containingSyntax = context.getContainingSyntax(def);
			String tokenResolverClassName = context.getTokenResolverClassName(def);
			if (tokenResolverClassName != null) {
				if (def.isCollect()) {
					String featureName = def.getBaseDefinition().getAttributeName();
					sc.add("super.registerCollectInTokenResolver(\"" + featureName + "\", new " + context.getResolverPackageName(containingSyntax) + "." + tokenResolverClassName + "());");
				} else {
					sc.add("super.registerTokenResolver(\"" +def.getName()+ "\", new " + context.getResolverPackageName(containingSyntax) + "." + tokenResolverClassName + "());");
				}
			}
		}
		sc.add("}");
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}
}
