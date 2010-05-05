package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class LayoutInformationGenerator extends JavaBaseGenerator {

	public LayoutInformationGenerator() {
		super();
	}

	private LayoutInformationGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.LAYOUT_INFORMATION);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new LayoutInformationGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private final " + syntaxElementClassName + " syntaxElement;");
		sc.add("private final " + STRING + " hiddenTokenText;");
		sc.add("private final " + STRING + " visibleTokenText;");
		sc.add("private " + OBJECT + " object;");
		sc.add("private boolean wasResolved;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + syntaxElementClassName + " syntaxElement, " + OBJECT + " object, " + STRING + " hiddenTokenText, " + STRING + " visibleTokenText) {");
		sc.add("super();");
		sc.add("this.syntaxElement = syntaxElement;");
		sc.add("this.object = object;");
		sc.add("this.hiddenTokenText = hiddenTokenText;");
		sc.add("this.visibleTokenText = visibleTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetSyntaxElementMethod(sc);
		addGetObjectMethod(sc);
		addGetHiddenTokenTextMethod(sc);
		addGetVisibleTokenTextMethod(sc);
		addReplaceProxyMethod(sc);
	}

	private void addGetSyntaxElementMethod(StringComposite sc) {
		sc.add("public " + syntaxElementClassName + " getSyntaxElement() {");
		sc.add("return syntaxElement;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetObjectMethod(JavaComposite sc) {
		sc.add("public " + OBJECT + " getObject(" + E_OBJECT + " container) {");
		sc.add("if (wasResolved) {");
		sc.add("return object;");
		sc.add("}");
		sc.addComment(
			"we need to try to resolve proxy objects again, because the proxy " +
			"might have been resolved before this adapter existed, which means " +
			"we missed the replaceProxy() notification"
		);
		sc.add("if (object instanceof " + INTERNAL_E_OBJECT + ") {");
		sc.add(INTERNAL_E_OBJECT + " internalObject = (" + INTERNAL_E_OBJECT + ") object;");
		sc.add("if (internalObject.eIsProxy()) {");
		sc.add("if (container instanceof " + INTERNAL_E_OBJECT + ") {");
		sc.add(INTERNAL_E_OBJECT + " internalContainer = (" + INTERNAL_E_OBJECT + ") container;");
		sc.add(E_OBJECT + " resolvedObject = internalContainer.eResolveProxy(internalObject);");
		sc.add("if (resolvedObject != internalObject) {");
		sc.add("object = resolvedObject;");
		sc.add("wasResolved = true;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("} else {");
		sc.add("wasResolved = true;");
		sc.add("}");
		sc.add("return object;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHiddenTokenTextMethod(StringComposite sc) {
		sc.add("public " + STRING + " getHiddenTokenText() {");
		sc.add("return hiddenTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetVisibleTokenTextMethod(StringComposite sc) {
		sc.add("public " + STRING + " getVisibleTokenText() {");
		sc.add("return visibleTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReplaceProxyMethod(StringComposite sc) {
		sc.add("public void replaceProxy(" + E_OBJECT + " proxy, " + E_OBJECT + " target) {");
		sc.add("if (this.object == proxy) {");
		sc.add("this.object = target;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
