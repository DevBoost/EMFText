package org.emftext.sdk.codegen;

import java.io.PrintWriter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

/**
 * A TokenResolverGenerator generates a single TokenResolver for a given TokenDefinition.
 * 
 * For a definition with prefix and suffix it generates code which removes these 
 * strings from the beginning and the end of a lexem and then passes the manipulated 
 * lexem to the JavaBasedTokenResolver as its base class. In the deresolvement it 
 * delegates the conversion form object to string to the base implementation. 
 * Finally the deresolved String will be decorated by pre- and suffixes again. 
 * 
 * @see org.emftext.runtime.resource.impl.JavaBasedTokenResolver
 * 
 * @author skarol
 */
public class TokenResolverGenerator extends BaseGenerator {
	
	private TextParserGenerator.InternalTokenDefinition definition;
	
	public TokenResolverGenerator(GenerationContext context, String resolverClassName, TextParserGenerator.InternalTokenDefinition definition) {
		super(context.getResolverPackageName(), resolverClassName);
		this.definition = definition;
	}

	@Override
	public boolean generate(PrintWriter out) {
		out.println("package " + super.getResourcePackageName()+ ";");
		out.println();
		
		out.println("public class " + super.getResourceClassName() + " extends " + JavaBasedTokenResolver.class.getName() + " implements " + ITokenResolver.class.getName() + " {");
		out.println("\t@Override");
		out.println("\tpublic " + String.class.getName() + " deResolve(" + Object.class.getName() + " value, " + EStructuralFeature.class.getName() + " feature, " + EObject.class.getName() + " container) {");
		out.println("\t\t" + String.class.getName() + " result = super.deResolve(value, feature, container);");
		if(definition.getSuffix()!=null){
			String escapedSuffix = escapeChars(definition.getSuffix());
			if(definition.isDerived()){
				out.println("\t\tresult = result.replaceAll(" + java.util.regex.Pattern.class.getName() + ".quote(\""+escapedSuffix+"\"),\"\\\\\\\\"+escapeDollar(escapedSuffix)+"\");");
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
		out.println("\tpublic " + Object.class.getName() + " resolve(" + String.class.getName() + " lexem, " + EStructuralFeature.class.getName() + " feature, " + EObject.class.getName() + " container, " + ITextResource.class.getName() + " resource) {");
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
				out.println("\t\tlexem = lexem.replaceAll(\"\\\\\\\\\"+" + java.util.regex.Pattern.class.getName() + ".quote(\""+replacement+"\"),\""+escapeDollar(replacement)+"\");");
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
