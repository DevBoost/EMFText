package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITokenResolveResult;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.util.JavaStringComposite;
import org.emftext.sdk.codegen.util.StringComposite;

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
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public class TokenResolverGenerator extends BaseGenerator {
	
	private TextParserGenerator.InternalTokenDefinition definition;
	
	public TokenResolverGenerator(GenerationContext context, String resolverClassName, TextParserGenerator.InternalTokenDefinition definition) {
		super(context.getResolverPackageName(), resolverClassName);
		this.definition = definition;
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaStringComposite();
		
		sc.add("package " + super.getResourcePackageName()+ ";");
		sc.addLineBreak();
		
		sc.add("public class " + super.getResourceClassName() + " extends " + JavaBasedTokenResolver.class.getName() + " implements " + ITokenResolver.class.getName() + " {");
		sc.addLineBreak();
		generateDeResolveMethod(sc);
		generateResolveMethod(sc);
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}

	private void generateDeResolveMethod(StringComposite sc) {
		sc.add("@Override");
		sc.addLineBreak();
		sc.add("public " + String.class.getName() + " deResolve(" + Object.class.getName() + " value, " + EStructuralFeature.class.getName() + " feature, " + EObject.class.getName() + " container) {");
		sc.add(String.class.getName() + " result = super.deResolve(value, feature, container);");
		if (definition.getSuffix() != null) {
			String escapedSuffix = escapeChars(definition.getSuffix());
			if (definition.isDerived()) {
				sc.add("result = result.replaceAll(" + java.util.regex.Pattern.class.getName() + ".quote(\""+escapedSuffix+"\"),\"\\\\\\\\"+escapeDollar(escapedSuffix)+"\");");
			}
			sc.add("result += \"" + escapedSuffix + "\";");
		}	
		
		if (definition.getPrefix() != null) {
			sc.add("result = \"" + escapeChars(definition.getPrefix()) + "\" + result;");
		}
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateResolveMethod(StringComposite sc) {
		sc.add("@Override");
		sc.addLineBreak();
		sc.add("public void resolve(" + String.class.getName() + " lexem, " + EStructuralFeature.class.getName() + " feature, " + ITokenResolveResult.class.getName() + " result) {");
		if (definition.getPrefix() != null) {
			int count = definition.getPrefix().length();
			sc.add("lexem = lexem.substring(" + count + ");");			
		}
		if (definition.getSuffix() != null) {
			int count = definition.getSuffix().length();
			sc.add("lexem = lexem.substring(0, lexem.length() - " + count + ");");
			if( definition.isDerived()) {
				String replacement = escapeChars(definition.getSuffix());
				sc.add("lexem = lexem.replaceAll(\"\\\\\\\\\"+" + java.util.regex.Pattern.class.getName() + ".quote(\""+replacement+"\"),\""+escapeDollar(replacement)+"\");");
			}
		}
		sc.add("super.resolve(lexem, feature, result);");
		sc.add("}");
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
