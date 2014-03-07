/*******************************************************************************
 * Copyright (c) 2006-2014
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static de.devboost.codecomposers.java.ClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.GEN_CLASS;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.GEN_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.GEN_PACKAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_PART;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROPERTY_SHEET_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_CHANGED_EVENT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class PropertySheetPageGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	public void generateJavaContents(JavaComposite jc) {
		
		jc.add("package " + getResourcePackageName() + ";");
		jc.addLineBreak();
		jc.addImportsPlaceholder();
		jc.addLineBreak();
		jc.add("public class " + getResourceClassName() + " extends " + PROPERTY_SHEET_PAGE(jc) + " implements " + I_SELECTION_CHANGED_LISTENER(jc) + " {");
		jc.addLineBreak();
		addMethods(jc);
		jc.add("}");
	}

	private void addMethods(JavaComposite jc) {
		addSelectionChangedMethod1(jc);
		addSelectionChangedMethod2(jc);
		addContainsGenProxyMethod(jc);
		addIsGenProxyMethod(jc);
		addIsInstanceOfMethod(jc);
	}

	private void addSelectionChangedMethod2(JavaComposite sc) {
		sc.add("public void selectionChanged(" + I_WORKBENCH_PART(sc) + " part, " + I_SELECTION(sc) + " iSelection) {");
		sc.addComment(
			"This is a workaround for a bug in EMF " +
			"(see https://bugs.eclipse.org/bugs/show_bug.cgi?id=291301)." +
			"Unfortunately Ed Merks refuses to fix it, so we need to solve it here."
		);
		sc.add("if (iSelection instanceof " + eObjectSelectionClassName + ") {");
		sc.add("final " + eObjectSelectionClassName + " selection = (" + eObjectSelectionClassName + ") iSelection;");
		sc.add("final " + E_OBJECT(sc) + " selectedObject = selection.getSelectedObject();");
		sc.addComment(
			"check whether the selected object or one of its children contains " +
			"a proxy which is a GenXYZClass (e.g., GenFeature, GenClass, GenPackage)"
		);
		sc.add("if (containsGenProxy(selectedObject)) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		
		sc.add("if (iSelection instanceof " + I_STRUCTURED_SELECTION(sc) + ") {");
		sc.add(I_STRUCTURED_SELECTION(sc) + " structuredSelection = (" + I_STRUCTURED_SELECTION(sc) + ") iSelection;");
		sc.add(ITERATOR(sc) + "<?> it = structuredSelection.iterator();");
		sc.add("while (it.hasNext()) {");
		sc.add("final Object next = it.next();");
		sc.add("if (next instanceof " + E_OBJECT(sc) + ") {");
		sc.add("if (containsGenProxy((" + E_OBJECT(sc) + ") next)) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		
		sc.addComment("end of workaround");
		sc.add("super.selectionChanged(part, iSelection);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSelectionChangedMethod1(JavaComposite sc) {
		sc.add("public void selectionChanged(" + SELECTION_CHANGED_EVENT(sc) + " event) {");
		sc.add("selectionChanged(null, event.getSelection());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContainsGenProxyMethod(JavaComposite sc) {
		sc.add("private boolean containsGenProxy(" + E_OBJECT(sc) + " selectedObject) {");
		sc.add("boolean isGenProxy = isGenProxy(selectedObject);");
		sc.add("if (isGenProxy) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("for (" + E_OBJECT(sc) + " child : selectedObject.eCrossReferences()) {");
		sc.add("if (isGenProxy(child)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + E_OBJECT(sc) + " child : selectedObject.eContents()) {");
		sc.add("if (containsGenProxy(child)) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsGenProxyMethod(JavaComposite sc) {
		sc.add("private boolean isGenProxy(" + E_OBJECT(sc) + " selectedObject) {");
		// We intentionally pass 'null' as argument here to get the fully
		// qualified names.
		sc.add("boolean isGenMetaclass = isInstanceOf(\"" + GEN_CLASS(null) + "\", selectedObject);");
		sc.add("isGenMetaclass |= isInstanceOf(\"" + GEN_FEATURE(null) + "\", selectedObject);");
		sc.add("isGenMetaclass |= isInstanceOf(\"" + GEN_PACKAGE(null) + "\", selectedObject);");
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
}
