/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.sdk.codegen.resource.generators.analysis;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OPERATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class DefaultNameProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + " implements " + iNameProviderClassName + " {");
		sc.addLineBreak();
		addConstants(sc);
		addGetNamesMethod(sc);
		sc.add("}");
	}

	private void addConstants(JavaComposite sc) {
		sc.add("public final static String NAME_FEATURE = \"name\";");
		sc.addLineBreak();
	}

	private void addGetNamesMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns a list of potential identifiers that may be used to reference the " +
			"given element. This method can be overridden to customize the identification " +
			"of elements.");
		// TODO it would be better if this method returned an iterator instead of a
		//      list to avoid the creation of names that will never used, because one
		//      of the previous names matched the identifier we are searching for
		sc.add("public " + LIST + "<String> getNames(" + E_OBJECT + " element) {");
		sc.add(LIST + "<String> names = new " + ARRAY_LIST + "<String>();");
		sc.addLineBreak();
		
		sc.addComment("first check for attributes that have set the ID flag to true");
		sc.add(LIST + "<" + E_ATTRIBUTE + "> attributes = element.eClass().getEAllAttributes();");
		sc.add("for (" + E_ATTRIBUTE + " attribute : attributes) {");
		sc.add("if (attribute.isID()) {");
		sc.add("Object attributeValue = element.eGet(attribute);");
		sc.add("if (attributeValue != null) {");
		sc.add("names.add(attributeValue.toString());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addComment("then check for an attribute that is called 'name'");
		sc.add(E_STRUCTURAL_FEATURE + " nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);");
		sc.add("if (nameAttr instanceof " + E_ATTRIBUTE + ") {");
		sc.add("Object attributeValue = element.eGet(nameAttr);");
		sc.add("if (attributeValue != null) {");
		sc.add("names.add(attributeValue.toString());");
		sc.add("}");
		sc.add("} else {");

		sc.addComment("try any other string attribute found");
		sc.add("for (" + E_ATTRIBUTE + " attribute : attributes) {");
		sc.add("if (\"java.lang.String\".equals(attribute.getEType().getInstanceClassName())) {");
		sc.add("Object attributeValue = element.eGet(attribute);");
		sc.add("if (attributeValue != null) {");
		sc.add("names.add(attributeValue.toString());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();

		sc.addComment("try operations without arguments that return strings and which have a name that ends with 'name'");
		sc.add("for (" + E_OPERATION + " operation : element.eClass().getEAllOperations()) {");
		sc.add("if (operation.getName().toLowerCase().endsWith(NAME_FEATURE) && operation.getEParameters().size() == 0) {");
		sc.add("Object result = " + eObjectUtilClassName + ".invokeOperation(element, operation);");
		sc.add("if (result != null) {");
		sc.add("names.add(result.toString());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");

		sc.add("return names;");
		sc.add("}");
		sc.addLineBreak();
	}

}
