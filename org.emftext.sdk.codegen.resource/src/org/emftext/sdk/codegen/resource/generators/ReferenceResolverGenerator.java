/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * A generator that can create basic stub for a single reference resolver.
 */
public class ReferenceResolverGenerator extends JavaBaseGenerator<GenFeature> {

	private final NameUtil nameUtil = new NameUtil();
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final GenClassFinder genClassFinder = new GenClassFinder();

	private GenFeature proxyReference;
	private String defaultResolverDelegateName;

	private GenClassCache genClassCache;

	public ReferenceResolverGenerator() {
		super();
	}

	private ReferenceResolverGenerator(GenerationContext context) {
		super(context, null);
		this.genClassCache = context.getConcreteSyntax().getGenClassCache();
		this.defaultResolverDelegateName = context
				.getQualifiedDefaultResolverDelegateName();
	}

	public void setProxyReference(GenFeature proxyReference) {
		this.proxyReference = proxyReference;
	}

	public boolean generateJavaContents(JavaComposite sc) {

		sc.add("package " + context.getResolverPackageName() + ";");
		sc.addLineBreak();

		sc.add("public class "
				+ nameUtil.getReferenceResolverClassName(proxyReference)
				+ " implements "
				+ iReferenceResolverClassName
				+ "<"
				+ genClassCache.getQualifiedInterfaceName(proxyReference
						.getGenClass())
				+ ", "
				+ genClassCache.getQualifiedInterfaceName(proxyReference
						.getTypeGenClass()) + "> {");
		sc.addLineBreak();

		addFields(sc);
		addResolveMethod(sc);
		addDeResolveMethod(sc);
		generatorUtil
				.addSetOptionsMethod(
						sc,
						"// save options in a field or leave method empty if this resolver does not depend on any option");
		sc.add("}");

		return true;
	}

	private void addFields(StringComposite sc) {
		final boolean isImportedReference = context
				.isImportedWithSyntaxReference(proxyReference);
		if (isImportedReference) {
			// for references in imported rules with a syntax defined elsewhere
			// we
			// delegate the reference resolving to the original resolver
			String resolverName = context
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
		sc.add("public "
				+ STRING
				+ " deResolve("
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
		sc.add("public void resolve("
				+ STRING
				+ " identifier, "
				+ genClassCache.getQualifiedInterfaceName(proxyReference
						.getGenClass()) + " container, "
				+ E_REFERENCE
				+ " reference, int position, boolean resolveFuzzy, final "
				+ iReferenceResolveResultClassName + "<"
				+ typeClassName + "> result) {");

		final boolean isImportedReference = context
				.isImportedWithSyntaxReference(proxyReference);
		if (isImportedReference) {
			ConcreteSyntax containingSyntax = genClassFinder
					.getContainingSyntax(context.getConcreteSyntax(),
							proxyReference.getGenClass());
			String iReferenceResolveResultClassName = context
					.getQualifiedClassName(
							TextResourceArtifacts.I_REFERENCE_RESOLVE_RESULT,
							containingSyntax);
			String iReferenceMappingClassName = context.getQualifiedClassName(
					TextResourceArtifacts.I_REFERENCE_MAPPING, containingSyntax);
			sc
					.add("delegate.resolve(identifier, container, reference, position, resolveFuzzy, new "
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
			sc.add("});");
			sc.addLineBreak();
		} else {
			sc
					.add("delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);");
		}

		sc.add("}");
		sc.addLineBreak();
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return Collections.emptySet();
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return Collections.emptySet();
	}

	public IGenerator<GenerationContext, GenFeature> newInstance(GenerationContext context, GenFeature parameters) {
		ReferenceResolverGenerator instance = new ReferenceResolverGenerator(context);
		instance.setProxyReference(parameters);
		return instance;
	}
}
