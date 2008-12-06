package org.emftext.sdk.codegen;

import java.io.PrintWriter;
import java.util.Map;

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
	
	
	public TokenResolverFactoryGenerator(Map<InternalTokenDefinition,String> printedTokens,String className, String packageName, String resolverPackageName){
		super(className,packageName);
		this.printedTokens = printedTokens;
		this.resolverPackageName = resolverPackageName;
	}
	
	
	
	@Override
	public boolean generate(PrintWriter out) {
		out.println("package " + super.getResourcePackageName() + ";");
		out.println();
		out.println("import org.emftext.runtime.resource.TokenResolverFactory;");
		out.println("import org.emftext.runtime.resource.impl.BasicTokenResolverFactory;");
		out.println();
		out.println("import " + resolverPackageName + ".*;");
		out.println();
		out.println("public class " + super.getResourceClassName() + " extends BasicTokenResolverFactory implements TokenResolverFactory{");
		out.println();
		out.println("\tpublic " + super.getResourceClassName() + "(){");
		for(InternalTokenDefinition def:printedTokens.keySet()){
			if(printedTokens.get(def)!=null){
				out.println("\t\tsuper.registerTokenResolver(\"" +def.getName()+ "\",new "+ printedTokens.get(def) + "());");
			}
		}
		out.println("\t}");
		out.println("}");
		return true;
	}

}
