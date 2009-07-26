package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import java.io.PrintWriter;

public class DelegatingResolveResultGenerator extends BaseGenerator {

	public DelegatingResolveResultGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getClassName(EArtifact.DELEGATING_RESOLVE_RESULT));
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// An implementation of the ResolveResult interface that delegates");
		sc.add("// all method calls to another ResolveResult. Client may subclass");
		sc.add("// this class to easily create custom ResolveResults.");
		sc.add("//");
		sc.add("// @param <ReferenceType> the type of the references that can be contained in this result");
		sc.add("//");
		sc.add("public class " + getResourceClassName() + "<ReferenceType> implements " + I_REFERENCE_RESOLVE_RESULT + "<ReferenceType> {");
		sc.addLineBreak();
		sc.add("private " + I_REFERENCE_RESOLVE_RESULT + "<ReferenceType> delegate;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + I_REFERENCE_RESOLVE_RESULT + "<ReferenceType> delegate) {");
		sc.add("this.delegate = delegate;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getErrorMessage() {");
		sc.add("return delegate.getErrorMessage();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + COLLECTION + "<" + I_REFERENCE_MAPPING + "<ReferenceType>> getMappings() {");
		sc.add("return delegate.getMappings();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean wasResolved() {");
		sc.add("return delegate.wasResolved();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean wasResolvedMultiple() {");
		sc.add("return delegate.wasResolvedMultiple();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean wasResolvedUniquely() {");
		sc.add("return delegate.wasResolvedUniquely();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setErrorMessage(String message) {");
		sc.add("delegate.setErrorMessage(message);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, ReferenceType target) {");
		sc.add("delegate.addMapping(identifier, target);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, " + URI + " uri) {");
		sc.add("delegate.addMapping(identifier, uri);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, ReferenceType target, String warning) {");
		sc.add("delegate.addMapping(identifier, target, warning);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, " + URI + " uri, String warning) {");
		sc.add("delegate.addMapping(identifier, uri, warning);");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
