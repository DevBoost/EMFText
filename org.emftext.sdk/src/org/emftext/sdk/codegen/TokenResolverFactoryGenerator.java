package org.emftext.sdk.codegen;

import java.io.PrintWriter;
import java.util.Map;

import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.runtime.resource.impl.BasicTokenResolverFactory;
import org.emftext.sdk.codegen.TextParserGenerator.InternalTokenDefinition;

/**
 * Generates a TokenResolverFactory which will contain a mapping from ANTLR token names to 
 * TokenResolver implementations. It will inherit from BasicTokenResolverFactory.
 * 
 * @see org.emftext.runtime.resource.impl.BasicTokenResolverFactory
 * 
 * @author skarol
 *
 */
public class TokenResolverFactoryGenerator extends BaseGenerator {
	
	private Map<InternalTokenDefinition,String> printedTokens;
	private String resolverPackageName;
	
	public TokenResolverFactoryGenerator(GenerationContext context, Map<InternalTokenDefinition,String> printedTokens){
		super(context.getPackageName(), context.getTokenResolverFactoryName());
		this.printedTokens = printedTokens;
		this.resolverPackageName = context.getResolverPackageName();
	}
	
	@Override
	public boolean generate(PrintWriter out) {
		out.println("package " + getResourcePackageName() + ";");
		out.println();
		out.println("public class " + getResourceClassName() + " extends " + BasicTokenResolverFactory.class.getName() + " implements " + ITokenResolverFactory.class.getName() + " {");
		out.println();
		out.println("\tpublic " + getResourceClassName() + "(){");
		for(InternalTokenDefinition def:printedTokens.keySet()){
			if(printedTokens.get(def)!=null){
				out.println("\t\tsuper.registerTokenResolver(\"" +def.getName()+ "\", new " + resolverPackageName + "." + printedTokens.get(def) + "());");
			}
		}
		out.println("\t}");
		out.println("}");
		return true;
	}

}
