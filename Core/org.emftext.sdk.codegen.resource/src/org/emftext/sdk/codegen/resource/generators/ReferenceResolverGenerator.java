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
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.ReferenceResolverParameters;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * A generator that can create a basic stub for a single reference resolver.
 */
@SyntaxDependent
public class ReferenceResolverGenerator extends JavaBaseGenerator<ReferenceResolverParameters> {

	private final NameUtil nameUtil = new NameUtil();
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final GenClassFinder genClassFinder = new GenClassFinder();

	private GenFeature proxyReference;
	private String defaultResolverDelegateName;

	private GenClassCache genClassCache;

	private void setProxyReference(GenFeature proxyReference) {
		this.proxyReference = proxyReference;
	}

	public void generateJavaContents(JavaComposite sc) {
		GenerationContext context = getContext();
		
		this.genClassCache = context.getConcreteSyntax().getGenClassCache();
		this.defaultResolverDelegateName = context.getQualifiedDefaultResolverDelegateName();
		setProxyReference(getParameters().getReference());

		sc.add("package " + context.getResolverPackageName() + ";");
		sc.addLineBreak();

		String containerClassName = genClassCache.getQualifiedInterfaceName(proxyReference
				.getGenClass());
		String referenceTypeClassName = genClassCache.getQualifiedInterfaceName(proxyReference
				.getTypeGenClass());
		
		sc.add("public class "
				+ nameUtil.getReferenceResolverClassName(proxyReference)
				+ " implements "
				+ iReferenceResolverClassName
				+ "<"
				+ containerClassName
				+ ", "
				+ referenceTypeClassName + "> {");
		sc.addLineBreak();

		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addResolveMethod(sc);
		addDeResolveMethod(sc);
		generatorUtil
				.addSetOptionsMethod(
						sc,
						null,
						"save options in a field or leave method empty if this resolver does not depend on any option");
	}

	private void addFields(StringComposite sc) {
		final boolean isImportedReference = getContext()
				.isImportedWithSyntaxReference(proxyReference);
		if (isImportedReference) {
			// for references in imported rules with a syntax defined elsewhere
			// we
			// delegate the reference resolving to the original resolver
			String resolverName = getContext()
					.getQualifiedReferenceResolverClassName(proxyReference,
							true);
			sc.add("private " + resolverName + " delegate = new "
					+ resolverName + "();");
		} else {
			// for references in rules in the current syntax we
			// delegate the reference resolving to default resolver delegate
			String typeParameters = "<"
					+ genClassCache.getQualifiedInterfaceName(proxyReference
							.getGenClass())
					+ ", "
					+ genClassCache.getQualifiedInterfaceName(proxyReference
							.getTypeGenClass()) + ">";
			sc.add("private " + defaultResolverDelegateName + typeParameters
					+ " delegate = new " + defaultResolverDelegateName
					+ typeParameters + "();");
		}
		sc.addLineBreak();
	}

	private void addDeResolveMethod(StringComposite sc) {
		sc.add("public String deResolve("
				+ genClassCache.getQualifiedInterfaceName(proxyReference
						.getTypeGenClass())
				+ " element, "
				+ genClassCache.getQualifiedInterfaceName(proxyReference
						.getGenClass()) + " container, "
				+ E_REFERENCE + " reference) {");
		sc.add("return delegate.deResolve(element, container, reference);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResolveMethod(StringComposite sc) {
		String typeClassName = genClassCache
				.getQualifiedInterfaceName(proxyReference.getTypeGenClass());
		sc.add("public void resolve(String identifier, "
				+ genClassCache.getQualifiedInterfaceName(proxyReference
						.getGenClass()) + " container, "
				+ E_REFERENCE
				+ " reference, int position, boolean resolveFuzzy, final "
				+ iReferenceResolveResultClassName + "<"
				+ typeClassName + "> result) {");

		final boolean isImportedReference = getContext()
				.isImportedWithSyntaxReference(proxyReference);
		if (isImportedReference) {
			ConcreteSyntax containingSyntax = genClassFinder
					.getContainingSyntax(getContext().getConcreteSyntax(),
							proxyReference.getGenClass());
			String iReferenceResolveResultClassName = getContext().getQualifiedClassName(
					TextResourceArtifacts.I_REFERENCE_RESOLVE_RESULT,
					containingSyntax);
			String iQuickFixClassName = getContext().getQualifiedClassName(
					TextResourceArtifacts.I_QUICK_FIX,
					containingSyntax);
			String iReferenceMappingClassName = getContext().getQualifiedClassName(
					TextResourceArtifacts.I_REFERENCE_MAPPING, containingSyntax);
			sc.add("delegate.resolve(identifier, container, reference, position, resolveFuzzy, new "
							+ iReferenceResolveResultClassName
							+ "<"
							+ typeClassName + ">() {");
			sc.addLineBreak();
			sc.add("public boolean wasResolvedUniquely() {");
			sc.add("return result.wasResolvedUniquely();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public boolean wasResolvedMultiple() {");
			sc.add("return result.wasResolvedMultiple();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public boolean wasResolved() {");
			sc.add("return result.wasResolved();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public void setErrorMessage(String message) {");
			sc.add("result.setErrorMessage(message);");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public " + COLLECTION + "<" + iReferenceMappingClassName
					+ "<" + typeClassName + ">> getMappings() {");
			sc.add("throw new UnsupportedOperationException();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public String getErrorMessage() {");
			sc.add("return result.getErrorMessage();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public void addMapping(String identifier, " + URI
					+ " newIdentifier) {");
			sc.add("result.addMapping(identifier, newIdentifier);");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public void addMapping(String identifier, " + URI
					+ " newIdentifier, String warning) {");
			sc.add("result.addMapping(identifier, newIdentifier, warning);");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public void addMapping(String identifier, " + typeClassName
					+ " target) {");
			sc.add("result.addMapping(identifier, target);");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public void addMapping(String identifier, " + typeClassName
					+ " target, String warning) {");
			sc.add("result.addMapping(identifier, target, warning);");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public " + COLLECTION + "<" + iQuickFixClassName + "> getQuickFixes() {");
			// TODO all quick fixes that are added by the delegate resolver will be lost
			sc.add("return " + COLLECTIONS + ".emptySet();");
			sc.add("}");
			sc.addLineBreak();
			
			sc.add("public void addQuickFix(final " + iQuickFixClassName + " quickFix) {");
			sc.add("result.addQuickFix(new " + super.iQuickFixClassName + "() {");
			sc.addLineBreak();
			sc.add("public String getImageKey() {");
			sc.add("return quickFix.getImageKey();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public String getDisplayString() {");
			sc.add("return quickFix.getDisplayString();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public " + COLLECTION + "<" + E_OBJECT + "> getContextObjects() {");
			sc.add("return quickFix.getContextObjects();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public String getContextAsString() {");
			sc.add("return quickFix.getContextAsString();");
			sc.add("}");
			sc.addLineBreak();
			sc.add("public String apply(String currentText) {");
			sc.add("return quickFix.apply(currentText);");
			sc.add("}");
			sc.add("});");
			sc.add("}");
			
			sc.add("});");
			sc.addLineBreak();
		} else {
			sc.add("delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);");
		}

		sc.add("}");
		sc.addLineBreak();
	}
}
