package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_PARSE_RESULT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_COMMAND;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_RESOURCE;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class ParseResultGenerator extends BaseGenerator {
	
	public ParseResultGenerator() {
		super();
	}

	private ParseResultGenerator(GenerationContext context) {
		super(context, EArtifact.PARSE_RESULT);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " extends " + ABSTRACT_PARSE_RESULT + " {");
        sc.addLineBreak();

        sc.add("private " + E_OBJECT + " root;");
        sc.add("private " + COLLECTION + "<" + I_COMMAND + "<" + I_TEXT_RESOURCE + ">> commands = new " + ARRAY_LIST + "<" + I_COMMAND + "<" + I_TEXT_RESOURCE + ">>();");
        sc.addLineBreak();
        
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void setRoot(" + E_OBJECT + " root) {");
		sc.add("this.root = root;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + E_OBJECT + " getRoot() {");
		sc.add("return root;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public " + COLLECTION + "<" + I_COMMAND + "<" + I_TEXT_RESOURCE + ">> getPostParseCommands() {");
		sc.add("return commands;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("}");
    	
		out.print(sc.toString());
    	return true;	
    }

	public IGenerator newInstance(GenerationContext context) {
		return new ParseResultGenerator(context);
	}
}
