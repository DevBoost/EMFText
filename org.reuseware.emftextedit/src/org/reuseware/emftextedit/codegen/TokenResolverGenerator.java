package org.reuseware.emftextedit.codegen;

import java.io.PrintWriter;

/**
 * A TokenResolverGenerator generates TokenResolvers for the given TokenDefinitions.
 * 
 * For definitions with prefixes and suffixes it generates code which removes those 
 * strings from the beginning and the end of a lexem and then passes the manipulated 
 * lexem to the javaBasedTokenResolver as its base class. In the deresolvement it 
 * delegates the conversion form object to string to the base implementation. 
 * Finally the deresolved String will be decorated by pre- and suffixes again. 
 * 
 * @see org.reuseware.emftextedit.resource.impl.JavaBasedTokenResolver
 * 
 * 
 * @author skarol
 *
 */

public class TokenResolverGenerator extends BaseGenerator {
	
	private TextParserGenerator.InternalTokenDefinition definition;
	
	public TokenResolverGenerator(String resolverClassName, String packageName, TextParserGenerator.InternalTokenDefinition definition) {
		super(resolverClassName, packageName);
		this.definition = definition;
	}

	@Override
	public boolean generate(PrintWriter out) {
		out.println("package " + super.getResourcePackageName()+ ";");
		out.println();
		
		out.println("import org.eclipse.emf.ecore.EStructuralFeature;");
		out.println("import org.eclipse.emf.ecore.EObject;");
		out.println("import org.reuseware.emftextedit.resource.TokenResolver;");
		out.println("import org.reuseware.emftextedit.resource.TextResource;");
		out.println("import org.reuseware.emftextedit.resource.impl.JavaBasedTokenResolver;");
		out.println();
		
		out.println("public class " + super.getResourceClassName() + " extends JavaBasedTokenResolver implements TokenResolver{ ");
		out.println("\t@Override");
		out.println("\tpublic String deResolve(Object value, EStructuralFeature feature, EObject container) {");
		out.println("\t\tString result = super.deResolve(value,feature,container);");
		if(definition.getSuffix()!=null){
			String escapedSuffix = escapeChars(definition.getSuffix());
			if(definition.isDerived()){
				out.println("\t\tresult = result.replaceAll(java.util.regex.Pattern.quote(\""+escapedSuffix+"\"),\"\\\\\\\\"+escapeDollar(escapedSuffix)+"\");");
			}
			out.println("\t\tresult += \"" + escapedSuffix + "\";");
		}	
		
		if(definition.getPrefix()!=null){
			out.println("\t\tresult = \"" + escapeChars(definition.getPrefix()) + "\" + result;");
		}

		out.println("\t\treturn result;");
		out.println("\t}");
		out.println();
		out.println("\t@Override");
		out.println("\tpublic Object resolve(String lexem, EStructuralFeature feature, EObject container, TextResource resource) {");
		if(definition.getPrefix()!=null){
			int count = definition.getPrefix().length();
			out.println("\t\tlexem = lexem.substring(" + count + ");");			
		}
		if(definition.getSuffix()!=null){
			int count = definition.getSuffix().length();
			out.println("\t\tlexem = lexem.substring(0,lexem.length()-" + count + ");");
			if(definition.isDerived()){
				String replacement = escapeChars(definition.getSuffix());
				//String replacement = (definition.getSuffix().charAt(0)=='"'||definition.getSuffix().charAt(0)=='\\'?"\\"+definition.getSuffix():definition.getSuffix());
				out.println("\t\tlexem = lexem.replaceAll(\"\\\\\\\\\"+java.util.regex.Pattern.quote(\""+replacement+"\"),\""+escapeDollar(replacement)+"\");");
			}
		}
		out.println("\t\treturn super.resolve(lexem,feature,container,resource);");
		out.println("\t}");
		
		out.println("}");
		
		return true;
	}
	
	private String escapeChars(String candidate){
		//for javac: replace one backslash by two and escape double quotes
		return candidate.replaceAll("\\\\","\\\\\\\\").replaceAll("\"","\\\\\"");
	}
	
	private String escapeDollar(String candidate){
		//for java regex: $ is meta char in java regex patterns and has semantics in replacement (back references)
		return candidate.replaceAll(java.util.regex.Pattern.quote("$"),"\\\\\\\\\\$");
	}

}
