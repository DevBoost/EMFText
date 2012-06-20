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
package org.emftext.sdk.codegen.resource.generators.util;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class InterruptibleEcoreResolverGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A utility class to resolve proxy objects that allows to terminate resolving."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addTerminateMethod(sc);
		addResolveAllMethod1(sc);
		addResolveAllMethod2(sc);
		addResolveAllMethod3(sc);
		addResolveCrossReferencesMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private boolean terminate = false;");
		sc.addLineBreak();
	}

	private void addTerminateMethod(JavaComposite sc) {
		sc.add("public void terminate() {");
		sc.add("terminate = true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveAllMethod1(JavaComposite sc) {
		sc.addJavadoc(
			"Visits all proxies in the resource set and tries to resolve them.",
			"@param resourceSet the objects to visit."
		);
		sc.add("public void resolveAll(" + RESOURCE_SET + " resourceSet) {");
		sc.add(LIST + "<" + RESOURCE + "> resources = resourceSet.getResources();");
		sc.add("for (int i = 0; i < resources.size() && !terminate; i++) {");
		sc.add("resolveAll(resources.get(i));");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveAllMethod2(JavaComposite sc) {
		sc.addJavadoc(
			"Visits all proxies in the resource and tries to resolve them.",
			"@param resource the objects to visit."
		);
		sc.add("public void resolveAll(" + RESOURCE + " resource) {");
		sc.add("for (" + E_OBJECT + " eObject : resource.getContents()) {");
		sc.add("if (terminate) {");
		sc.add("return;");
		sc.add("}");
		sc.add("resolveAll(eObject);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveAllMethod3(JavaComposite sc) {
		sc.addJavadoc(
			"Visits all proxies referenced by the object and recursively any of its contained objects.",
			"@param eObject the object to visit."
		);
		sc.add("public void resolveAll(" + E_OBJECT + " eObject) {");
		sc.add("eObject.eContainer();");
		sc.add("resolveCrossReferences(eObject);");
		sc.add("for (" + ITERATOR + "<" + E_OBJECT + "> i = eObject.eAllContents(); i.hasNext();) {");
		sc.add("if (terminate) {");
		sc.add("return;");
		sc.add("}");
		sc.add(E_OBJECT + " childEObject = i.next();");
		sc.add("resolveCrossReferences(childEObject);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveCrossReferencesMethod(JavaComposite sc) {
		sc.add("protected void resolveCrossReferences(" + E_OBJECT + " eObject) {");
		sc.add("for (" + ITERATOR + "<" + E_OBJECT + "> i = eObject.eCrossReferences().iterator(); i.hasNext(); i.next()) {");
		sc.addComment("The loop resolves the cross references by visiting them.");
		sc.add("if (terminate) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
