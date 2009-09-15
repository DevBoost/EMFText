package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PROPERTY_SHEET_PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_CHANGED_EVENT;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class PropertySheetPageGenerator extends BaseGenerator {

	public PropertySheetPageGenerator(GenerationContext context) {
		super(context, EArtifact.PROPERTY_SHEET_PAGE);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + PROPERTY_SHEET_PAGE + " implements " + I_SELECTION_CHANGED_LISTENER + " {");
		sc.addLineBreak();
		sc.add("public void selectionChanged(" + SELECTION_CHANGED_EVENT + " event) {");
		sc.add("selectionChanged(null, event.getSelection());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
