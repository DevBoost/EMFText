package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.GenerationContext;
import java.io.PrintWriter;
import org.emftext.sdk.codegen.EArtifact;

public class EObjectSelectionGenerator extends BaseGenerator {

	public EObjectSelectionGenerator(GenerationContext context) {
		super(context, EArtifact.E_OBJECT_SELECTION);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_STRUCTURED_SELECTION + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addMethods(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		addGetSelectedObjectMethod(sc);
		addDoHighlightingMethod(sc);
		addIsEmptyMethod(sc);
		addGetFirstElementMethod(sc);
		addIteratorMethod(sc);
		addSizeMethod(sc);
		addToArrayMethod(sc);
		addToListMethod(sc);
	}

	private void addToListMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + LIST + "<?> toList() {");
		sc.add(ARRAY_LIST + "<" + E_OBJECT + "> list = new " + ARRAY_LIST + "<" + E_OBJECT + ">();");
		sc.add("list.add(selectedObject);");
		sc.add("return list;");
		sc.add("}");
	}

	private void addToArrayMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + OBJECT + "[] toArray() {");
		sc.add("return new " + OBJECT + "[] {selectedObject};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSizeMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public int size() {");
		sc.add("return 1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIteratorMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + ITERATOR + "<?> iterator() {");
		sc.add("return new " + ITERATOR + "<?>() {");
		sc.addLineBreak();
		sc.add("private boolean hasNext = true;");
		sc.addLineBreak();
		sc.add("public boolean hasNext() {");
		sc.add("return hasNext;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " next(){");
		sc.add("hasNext = false;");
		sc.add("return selectedObject;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void remove() {");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFirstElementMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + OBJECT + " getFirstElement() {");
		sc.add("return selectedObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsEmptyMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public boolean isEmpty() {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoHighlightingMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public boolean doHighlighting() {");
		sc.add("return highlighting;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSelectedObjectMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + E_OBJECT + " getSelectedObject() {");
		sc.add("return selectedObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_OBJECT + " selectedObject, boolean highlighting) {");
		sc.add("super();");
		sc.add("this.selectedObject = selectedObject;");
		sc.add("this.highlighting = highlighting;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private final " + E_OBJECT + " selectedObject;");
		sc.add("private final boolean highlighting;");
		sc.addLineBreak();
	}
}
