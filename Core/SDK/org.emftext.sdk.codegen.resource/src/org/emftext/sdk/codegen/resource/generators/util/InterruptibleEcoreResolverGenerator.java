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
package org.emftext.sdk.codegen.resource.generators.util;

import static de.devboost.codecomposers.java.ClassNameConstants.ITERATOR;
import static de.devboost.codecomposers.java.ClassNameConstants.LINKED_HASH_SET;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.SET;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.INTERNAL_E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE_SET;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class InterruptibleEcoreResolverGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
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
		addFindUnresolvedProxiesMethod1(sc);
		addFindUnresolvedProxiesMethod2(sc);
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
		sc.add("public void resolveAll(" + RESOURCE_SET(sc) + " resourceSet) {");
		sc.add(LIST(sc) + "<" + RESOURCE(sc) + "> resources = resourceSet.getResources();");
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
		sc.add("public void resolveAll(" + RESOURCE(sc) + " resource) {");
		sc.add("for (" + E_OBJECT(sc) + " eObject : resource.getContents()) {");
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
		sc.add("public void resolveAll(" + E_OBJECT(sc) + " eObject) {");
		sc.add("eObject.eContainer();");
		sc.add("resolveCrossReferences(eObject);");
		sc.add("for (" + ITERATOR(sc) + "<" + E_OBJECT(sc) + "> i = eObject.eAllContents(); i.hasNext();) {");
		sc.add("if (terminate) {");
		sc.add("return;");
		sc.add("}");
		sc.add(E_OBJECT(sc) + " childEObject = i.next();");
		sc.add("resolveCrossReferences(childEObject);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveCrossReferencesMethod(JavaComposite sc) {
		sc.add("protected void resolveCrossReferences(" + E_OBJECT(sc) + " eObject) {");
		sc.add("for (" + ITERATOR(sc) + "<" + E_OBJECT(sc) + "> i = eObject.eCrossReferences().iterator(); i.hasNext(); i.next()) {");
		sc.addComment("The loop resolves the cross references by visiting them.");
		sc.add("if (terminate) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindUnresolvedProxiesMethod1(JavaComposite sc) {
		sc.addJavadoc(
			"Searches for all unresolved proxy objects in the given resource.",
			"@param resource",
			"@return all proxy objects that are not resolvable"
		);
		sc.add("public " + SET(sc) + "<" + E_OBJECT(sc) + "> findUnresolvedProxies(" + RESOURCE(sc) + " resource) {");
		sc.add(SET(sc) + "<" + E_OBJECT(sc) + "> unresolvedProxies = new " + LINKED_HASH_SET(sc) + "<" + E_OBJECT(sc) + ">();");
		sc.addLineBreak();
		sc.add("for (" + ITERATOR(sc) + "<" + E_OBJECT(sc) + "> elementIt = " + ECORE_UTIL(sc) + ".getAllContents(resource, true); elementIt.hasNext(); ) {");
		sc.add(INTERNAL_E_OBJECT(sc) + " nextElement = (" + INTERNAL_E_OBJECT(sc) + ") elementIt.next();");
		sc.add("if (terminate) {");
		sc.add("return unresolvedProxies;");
		sc.add("}");
		sc.add("if (nextElement.eIsProxy()) {");
		sc.add("unresolvedProxies.add(nextElement);");
		sc.add("}");
		sc.add("for (" + E_OBJECT(sc) + " crElement : nextElement.eCrossReferences()) {");
		sc.add("if (terminate) {");
		sc.add("return unresolvedProxies;");
		sc.add("}");
		sc.add("crElement = " + ECORE_UTIL(sc) + ".resolve(crElement, resource);");
		sc.add("if (crElement.eIsProxy()) {");
		sc.add("unresolvedProxies.add(crElement);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return unresolvedProxies;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFindUnresolvedProxiesMethod2(JavaComposite sc) {
		sc.addJavadoc(
			"Searches for all unresolved proxy objects in the given resource set.",
			"@param resourceSet",
			"@return all proxy objects that are not resolvable"
		);
		sc.add("public " + SET(sc) + "<" + E_OBJECT(sc) + "> findUnresolvedProxies(" + RESOURCE_SET(sc) + " resourceSet) {");
		sc.add(SET(sc) + "<" + E_OBJECT(sc) + "> unresolvedProxies = new " + LINKED_HASH_SET(sc) + "<" + E_OBJECT(sc) + ">();");
		sc.addLineBreak();
		sc.add("for (" + RESOURCE(sc) + " resource : resourceSet.getResources()) {");
		sc.add("if (terminate) {");
		sc.add("return unresolvedProxies;");
		sc.add("}");
		sc.add("unresolvedProxies.addAll(findUnresolvedProxies(resource));");
		sc.add("}");
		sc.add("return unresolvedProxies;");
		sc.add("}");
		sc.addLineBreak();
	}
}
