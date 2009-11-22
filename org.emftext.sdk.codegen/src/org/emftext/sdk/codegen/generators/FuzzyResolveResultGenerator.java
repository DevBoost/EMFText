/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

public class FuzzyResolveResultGenerator extends JavaBaseGenerator {

	public FuzzyResolveResultGenerator() {
		super();
	}

	private FuzzyResolveResultGenerator(GenerationContext context) {
		super(context, EArtifact.FUZZY_RESOLVE_RESULT);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A FuzzyResolveResult is an implementation of the IReferenceResolveResult");
		sc.add("// interface that delegates all method calls to a given IReferenceResolveResult");
		sc.add("// with ReferenceType EObject. It is used by reference resolver switches to");
		sc.add("// collect results from different reference resolvers in a type safe manner.");
		sc.add("//");
		sc.add("// @param <ReferenceType> the type of the reference that is resolved");
		sc.add("//");
		sc.add("public class " + getResourceClassName() + "<ReferenceType extends " + E_OBJECT + "> implements " + getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<ReferenceType> {");
		sc.addLineBreak();
		sc.add("private " + getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<" + E_OBJECT + "> delegate;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + getClassNameHelper().getI_REFERENCE_RESOLVE_RESULT() + "<" + E_OBJECT + "> delegate) {");
		sc.add("this.delegate = delegate;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getErrorMessage() {");
		sc.add("return delegate.getErrorMessage();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + COLLECTION + "<" + getClassNameHelper().getI_REFERENCE_MAPPING() + "<ReferenceType>> getMappings() {");
		sc.add("return null;");
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
		sc.add("delegate.addMapping(identifier, (" + E_OBJECT + ") target);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, " + URI + " uri) {");
		sc.add("delegate.addMapping(identifier, uri);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, ReferenceType target, String warning) {");
		sc.add("delegate.addMapping(identifier, (" + E_OBJECT + ") target, warning);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void addMapping(String identifier, " + URI + " uri, String warning) {");
		sc.add("delegate.addMapping(identifier, uri, warning);");
		sc.add("}");
		sc.add("}");
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new FuzzyResolveResultGenerator(context);
	}
}
