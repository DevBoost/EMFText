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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

import de.devboost.codecomposers.java.JavaComposite;

public class DelegatingResolveResultGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"An implementation of the ResolveResult interface that delegates " +
			"all method calls to another ResolveResult. Client may subclass " +
			"this class to easily create custom ResolveResults.",
			"@param <ReferenceType> the type of the references that can be contained in this result"
		);
		sc.add("public class " + getResourceClassName() + "<ReferenceType> implements " + iReferenceResolveResultClassName + "<ReferenceType> {");
		sc.addLineBreak();
		addFields(sc);
		addConstructur(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetErrorMessageMethod(sc);
		addGetMappingsMethod(sc);
		addWasResolvedMethod(sc);
		addWasResolvedMultipleMethod(sc);
		addWasResolvedUniquelyMethod(sc);
		addSetErrorMessageMethod(sc);
		addAddMappingMethod1(sc);
		addAddMappingMethod2(sc);
		addAddMappingMethod3(sc);
		addAddMappingMethod4(sc);
		addGetQuickFixesMethod(sc);
		addAddQuickFixMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + iReferenceResolveResultClassName + "<ReferenceType> delegate;");
		sc.addLineBreak();
	}

	private void addConstructur(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + iReferenceResolveResultClassName + "<ReferenceType> delegate) {");
		sc.add("this.delegate = delegate;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetErrorMessageMethod(JavaComposite sc) {
		sc.add("public String getErrorMessage() {");
		sc.add("return delegate.getErrorMessage();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMappingsMethod(JavaComposite sc) {
		sc.add("public " + COLLECTION + "<" + iReferenceMappingClassName + "<ReferenceType>> getMappings() {");
		sc.add("return delegate.getMappings();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addWasResolvedMethod(JavaComposite sc) {
		sc.add("public boolean wasResolved() {");
		sc.add("return delegate.wasResolved();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addWasResolvedMultipleMethod(JavaComposite sc) {
		sc.add("public boolean wasResolvedMultiple() {");
		sc.add("return delegate.wasResolvedMultiple();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addWasResolvedUniquelyMethod(JavaComposite sc) {
		sc.add("public boolean wasResolvedUniquely() {");
		sc.add("return delegate.wasResolvedUniquely();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetErrorMessageMethod(JavaComposite sc) {
		sc.add("public void setErrorMessage(String message) {");
		sc.add("delegate.setErrorMessage(message);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddMappingMethod1(JavaComposite sc) {
		sc.add("public void addMapping(String identifier, ReferenceType target) {");
		sc.add("delegate.addMapping(identifier, target);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddMappingMethod2(JavaComposite sc) {
		sc.add("public void addMapping(String identifier, " + URI + " uri) {");
		sc.add("delegate.addMapping(identifier, uri);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddMappingMethod3(JavaComposite sc) {
		sc.add("public void addMapping(String identifier, ReferenceType target, String warning) {");
		sc.add("delegate.addMapping(identifier, target, warning);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddMappingMethod4(JavaComposite sc) {
		sc.add("public void addMapping(String identifier, " + URI + " uri, String warning) {");
		sc.add("delegate.addMapping(identifier, uri, warning);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetQuickFixesMethod(JavaComposite sc) {
		sc.add("public " + COLLECTION + "<" + iQuickFixClassName + "> getQuickFixes() {");
		sc.add("return delegate.getQuickFixes();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddQuickFixMethod(JavaComposite sc) {
		sc.add("public void addQuickFix(" + iQuickFixClassName + " quickFix) {");
		sc.add("delegate.addQuickFix(quickFix);");
		sc.add("}");
		sc.addLineBreak();
	}
}
