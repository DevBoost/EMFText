package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_PARSE_RESULT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_COMMAND;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_RESOURCE;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class ParseResultGenerator extends BaseGenerator {
	
	public ParseResultGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getClassName(EArtifact.PARSE_RESULT));
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " extends " + ABSTRACT_PARSE_RESULT + " {");
        sc.addLineBreak();

        sc.add("private " + E_OBJECT + " root;");
        sc.add("private " + COLLECTION + "<" + I_COMMAND + "<" + I_TEXT_RESOURCE + ">> commands;");
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
		
		sc.add("public void addPostParseCommand(" + I_COMMAND + "<" + I_TEXT_RESOURCE + "> command) {");
		sc.add("commands.add(command);");
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
}
