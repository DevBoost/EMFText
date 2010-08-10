package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_OBJECT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class LayoutInformationGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private final " + syntaxElementClassName + " syntaxElement;");
		sc.add("private final int startOffset;");
		sc.add("private final String hiddenTokenText;");
		sc.add("private final String visibleTokenText;");
		sc.add("private Object object;");
		sc.add("private boolean wasResolved;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + syntaxElementClassName + " syntaxElement, Object object, int startOffset, String hiddenTokenText, String visibleTokenText) {");
		sc.add("super();");
		sc.add("this.syntaxElement = syntaxElement;");
		sc.add("this.object = object;");
		sc.add("this.startOffset = startOffset;");
		sc.add("this.hiddenTokenText = hiddenTokenText;");
		sc.add("this.visibleTokenText = visibleTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetSyntaxElementMethod(sc);
		addGetStartOffsetMethod(sc);
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

	private void addGetStartOffsetMethod(StringComposite sc) {
		sc.add("public int getStartOffset() {");
		sc.add("return startOffset;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetObjectMethod(JavaComposite sc) {
		sc.add("public Object getObject(" + E_OBJECT + " container) {");
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
		sc.add("public String getHiddenTokenText() {");
		sc.add("return hiddenTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetVisibleTokenTextMethod(StringComposite sc) {
		sc.add("public String getVisibleTokenText() {");
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
