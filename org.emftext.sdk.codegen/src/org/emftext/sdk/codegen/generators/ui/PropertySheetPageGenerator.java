package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PROPERTY_SHEET_PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_CHANGED_EVENT;

import java.io.PrintWriter;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class PropertySheetPageGenerator extends BaseGenerator {
	
	private String eObjectSelectionName;

	public PropertySheetPageGenerator() {
		super();
	}

	private PropertySheetPageGenerator(GenerationContext context) {
		super(context, EArtifact.PROPERTY_SHEET_PAGE);
		eObjectSelectionName = context.getQualifiedClassName(EArtifact.E_OBJECT_SELECTION);
	}

	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + PROPERTY_SHEET_PAGE + " implements " + I_SELECTION_CHANGED_LISTENER + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addMethods(StringComposite sc) {
		addSelectionChangedMethod(sc);
		addContainsGenProxyMethod(sc);
		addIsGenProxyMethod(sc);
		addIsInstanceOfMethod(sc);
	}

	private void addSelectionChangedMethod(StringComposite sc) {
		sc.add("public void selectionChanged(" + SELECTION_CHANGED_EVENT + " event) {");
		sc.add("// this is a workaround for a bug in EMF");
		sc.add("// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=291301");
		sc.add("// unfortunately Ed Merks refuses to fix it, so we need to solve it here");
		sc.add("if (event.getSelection() instanceof " + eObjectSelectionName + ") {");
		sc.add("final " + eObjectSelectionName + " selection = (" + eObjectSelectionName + ") event.getSelection();");
		sc.add("final " + E_OBJECT + " selectedObject = selection.getSelectedObject();");
		sc.add("// check whether the selected object or one of its children contains");
		sc.add("// a proxy which is a GenXYZClass (e.g., GenFeature, GenClass, GenPackage)");
		sc.add("if (containsGenProxy(selectedObject)) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("// end of workaround");
		sc.add("selectionChanged(null, event.getSelection());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainsGenProxyMethod(StringComposite sc) {
		sc.add("private boolean containsGenProxy(" + E_OBJECT + " selectedObject) {");
		sc.add("boolean isGenProxy = isGenProxy(selectedObject);");
		sc.add("if (isGenProxy) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("for (" + E_OBJECT + " child : selectedObject.eCrossReferences()) {");
		sc.add("if (isGenProxy(child)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + E_OBJECT + " child : selectedObject.eContents()) {");
		sc.add("if (containsGenProxy(child)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsGenProxyMethod(StringComposite sc) {
		sc.add("private boolean isGenProxy(" + E_OBJECT + " selectedObject) {");
		sc.add("boolean isGenMetaclass = isInstanceOf(\"" + GenClass.class.getName() + "\", selectedObject);");
		sc.add("isGenMetaclass |= isInstanceOf(\"" + GenFeature.class.getName() + "\", selectedObject);");
		sc.add("isGenMetaclass |= isInstanceOf(\"" + GenPackage.class.getName() + "\", selectedObject);");
		sc.add("boolean isProxy = selectedObject.eIsProxy();");
		sc.add("return isGenMetaclass && isProxy;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsInstanceOfMethod(StringComposite sc) {
		sc.add("private boolean isInstanceOf(String className, Object object) {");
		sc.add("try {");
		sc.add("Class<?> clazz = Class.forName(className);");
		sc.add("return clazz.isInstance(object);");
		sc.add("} catch (ClassNotFoundException e) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
	}
	
	public IGenerator newInstance(GenerationContext context) {
		return new PropertySheetPageGenerator(context);
	}
}
