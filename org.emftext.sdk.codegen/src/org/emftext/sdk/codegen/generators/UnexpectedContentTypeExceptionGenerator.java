package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RECOGNITION_EXCEPTION;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;

public class UnexpectedContentTypeExceptionGenerator extends BaseGenerator {

	public UnexpectedContentTypeExceptionGenerator() {
		super();
	}

	private UnexpectedContentTypeExceptionGenerator(GenerationContext context) {
		super(context, EArtifact.UNEXPECTED_CONTENT_TYPE_EXCEPTION);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new UnexpectedContentTypeExceptionGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// " + EXCEPTION + " class to represent invalid content types for parser instances.");
		sc.add("//");
		sc.add("// @see " + getClassNameHelper().getI_OPTIONS() + ".RESOURCE_CONTENT_TYPE");
		sc.add("public class " + getResourceClassName() + " extends " + RECOGNITION_EXCEPTION + "{");
		sc.addLineBreak();
		sc.add("private static final long serialVersionUID = 4791359811519433999L;");
		sc.addLineBreak();
		sc.add("private Object contentType = null;");
		sc.addLineBreak();
		sc.add("public  " + getResourceClassName() + "(Object contentType) {");
		sc.add("this.contentType = contentType;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public Object getContentType() {");
		sc.add("return contentType;");
		sc.add("}");
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}
}
