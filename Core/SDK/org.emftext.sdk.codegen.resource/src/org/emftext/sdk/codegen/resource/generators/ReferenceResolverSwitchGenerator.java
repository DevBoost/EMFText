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

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.MAP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.GeneratorUtil;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.interfaces.IOptionsGenerator;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.GenClassUtil;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;
import de.devboost.codecomposers.util.StringUtil;

/**
 * A generator that creates a multiplexing reference resolver.
 * Depending on the type of the reference that must be resolved,
 * the generated class delegates the resolve call to the appropriate
 * reference resolver.
 * 
 * The generated resolver switch is used while parsing resources and
 * during code completion.
 */
@SyntaxDependent
public class ReferenceResolverSwitchGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private final NameUtil nameUtil = new NameUtil();
	
	private GenClassCache genClassCache;
	private Collection<GenFeature> nonContainmentReferencesNeedingResolvers;

	@Override
	public void generateJavaContents(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		this.genClassCache = syntax.getGenClassCache();
		this.nonContainmentReferencesNeedingResolvers = csUtil.getNonContainmentFeaturesNeedingResolver(syntax);

		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
        sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iReferenceResolverSwitchClassName + " {");
        sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}
	
	private void addMethods(JavaComposite sc) {
		generateGetMethods(sc);
		generateSetOptionsMethod(sc);
		generateResolveFuzzyMethod(sc);
		addGetResolverMethod(sc);
		addGetResolverChainMethod(sc);
	}

	private void generateResolveFuzzyMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		String qualifiedFuzzyResolveResultClassName = getContext().getClassName(TextResourceArtifacts.FUZZY_RESOLVE_RESULT);
		
		sc.add("public void resolveFuzzy(String identifier, " + E_OBJECT(sc) + " container, " + E_REFERENCE(sc) + " reference, int position, " + iReferenceResolveResultClassName + "<" + E_OBJECT(sc) + "> result) {");
		// this was a temporary workaround to avoid NPEs when this switch is called
		// and no container was available during code completion. New code completion
		// helpers do create containers on demand, but still checking for null doesn't
		// hurt here.
		sc.add("if (container == null) {");
		sc.add("return;");
		sc.add("}");
		for (GenFeature proxyReference : nonContainmentReferencesNeedingResolvers) {
			GenClass genClass = proxyReference.getGenClass();
			String accessorName = genClass.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get"  + genClass.getName() + "()";
			String generatedClassName = nameUtil.getReferenceResolverClassName(proxyReference);
			GenFeature genFeature = generatorUtil.findGenFeature(genClass, proxyReference.getName());
			
			sc.add("if (" + accessorName + ".isInstance(container)) {");
			sc.add(qualifiedFuzzyResolveResultClassName + "<" + genClassCache.getQualifiedInterfaceName(genFeature.getTypeGenClass()) + "> frr = new " + qualifiedFuzzyResolveResultClassName + "<" + genClassCache.getQualifiedInterfaceName(genFeature.getTypeGenClass()) + ">(result);");
			sc.add("String referenceName = reference.getName();");
			sc.add(E_STRUCTURAL_FEATURE(sc) + " feature = container.eClass().getEStructuralFeature(referenceName);");
			sc.add("if (feature != null && feature instanceof " + E_REFERENCE(sc) + " && referenceName != null && referenceName.equals(\"" + StringUtil.escapeToJavaString(proxyReference.getName()) + "\")) {");
			sc.add(StringUtil.low(generatedClassName) + ".resolve(identifier, (" + genClassCache.getQualifiedInterfaceName(genClass) + ") container, (" + E_REFERENCE(sc) + ") feature, position, true, frr);");
			sc.add("}");
			sc.add("}");
		}
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateSetOptionsMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void setOptions(" + MAP(sc) + "<?, ?> options) {");
		sc.add("if (options != null) {");
		sc.add("this.options = new " + LINKED_HASH_MAP(sc) + "<Object, Object>();");
		sc.add("this.options.putAll(options);");
		sc.add("}");
		for (GenFeature proxyReference : nonContainmentReferencesNeedingResolvers) {
			String generatedClassName = nameUtil.getReferenceResolverClassName(proxyReference);
			sc.add(StringUtil.low(generatedClassName) + ".setOptions(options);");			
		}
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResolverMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + iReferenceResolverClassName + "<? extends " + E_OBJECT(sc) + ", ? extends " + E_OBJECT(sc) + "> getResolver(" + E_STRUCTURAL_FEATURE(sc) + " reference) {");
		for (GenFeature proxyReference : nonContainmentReferencesNeedingResolvers) {
			String generatedClassName = nameUtil.getReferenceResolverClassName(proxyReference);
			String featureAccessor = new GenClassUtil().getAccessor(proxyReference);
			sc.add("if (reference == " + featureAccessor + ") {");
			sc.add("return getResolverChain(reference, " + StringUtil.low(generatedClassName) + ");");			
			sc.add("}");
		}
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResolverChainMethod(JavaComposite sc) {
		sc.add("@SuppressWarnings({\"rawtypes\", \"unchecked\"})");
		sc.add("public <ContainerType extends " + E_OBJECT(sc) + ", ReferenceType extends " + E_OBJECT(sc) + "> " + iReferenceResolverClassName + "<ContainerType, ReferenceType> getResolverChain(" + E_STRUCTURAL_FEATURE(sc) + " reference, " + iReferenceResolverClassName + "<ContainerType, ReferenceType> originalResolver) {");
		sc.add("if (options == null) {");
		sc.add("return originalResolver;");
		sc.add("}");
		sc.add("Object value = options.get(" + iOptionsClassName + "." + IOptionsGenerator.ADDITIONAL_REFERENCE_RESOLVERS + ");");
		sc.add("if (value == null) {");
		sc.add("return originalResolver;");
		sc.add("}");
		sc.add("if (!(value instanceof " + MAP(sc) + ")) {");
		sc.addComment("send this to the error log");
		sc.add("new " + runtimeUtilClassName + "().logWarning(\"Found value with invalid type for option \" + " + iOptionsClassName + "." + IOptionsGenerator.ADDITIONAL_REFERENCE_RESOLVERS + " + \" (expected \" + " + MAP(sc) + ".class.getName() + \", but was \" + value.getClass().getName() + \")\", null);");
		sc.add("return originalResolver;");
		sc.add("}");
		sc.add(MAP(sc) + "<?,?> resolverMap = (" + MAP(sc) + "<?,?>) value;");
		sc.add("Object resolverValue = resolverMap.get(reference);");
		sc.add("if (resolverValue == null) {");
		sc.add("return originalResolver;");
		sc.add("}");
		sc.add("if (resolverValue instanceof " + iReferenceResolverClassName + ") {");
		sc.add(iReferenceResolverClassName + " replacingResolver = (" + iReferenceResolverClassName + ") resolverValue;");
		sc.add("if (replacingResolver instanceof " + iDelegatingReferenceResolverClassName + ") {");
		sc.addComment("pass original resolver to the replacing one");
		sc.add("((" + iDelegatingReferenceResolverClassName + ") replacingResolver).setDelegate(originalResolver);");
		sc.add("}");
		sc.add("return replacingResolver;");
		sc.add("} else if (resolverValue instanceof " + COLLECTION(sc) + ") {");
		sc.add(COLLECTION(sc) + " replacingResolvers = (" + COLLECTION(sc) + ") resolverValue;");
		sc.add(iReferenceResolverClassName + " replacingResolver = originalResolver;");
		sc.add("for (Object next : replacingResolvers) {");
		sc.add("if (next instanceof " + iReferenceCacheClassName + ") {");
		sc.add(iReferenceResolverClassName + " nextResolver = (" + iReferenceResolverClassName + ") next;");
		sc.add("if (nextResolver instanceof " + iDelegatingReferenceResolverClassName + ") {");
		sc.addComment("pass original resolver to the replacing one");
		sc.add("((" + iDelegatingReferenceResolverClassName + ") nextResolver).setDelegate(replacingResolver);");
		sc.add("}");
		sc.add("replacingResolver = nextResolver;");
		sc.add("} else {");
		sc.addComment("The collection contains a non-resolver. Send a warning to the error log.");
		sc.add("new " + runtimeUtilClassName + "().logWarning(\"Found value with invalid type in value map for option \" + " + iOptionsClassName + "." + IOptionsGenerator.ADDITIONAL_REFERENCE_RESOLVERS + " + \" (expected \" + " + iDelegatingReferenceResolverClassName + ".class.getName() + \", but was \" + next.getClass().getName() + \")\", null);");
		sc.add("}");
		sc.add("}");
		sc.add("return replacingResolver;");
		sc.add("} else {");
		sc.addComment(
				"The value for the option " + IOptionsGenerator.ADDITIONAL_REFERENCE_RESOLVERS + 
				" has an unknown type.");
		sc.add("new " + runtimeUtilClassName + "().logWarning(\"Found value with invalid type in value map for option \" + " + iOptionsClassName + "." + IOptionsGenerator.ADDITIONAL_REFERENCE_RESOLVERS + " + \" (expected \" + " + iDelegatingReferenceResolverClassName + ".class.getName() + \", but was \" + resolverValue.getClass().getName() + \")\", null);");
		sc.add("return originalResolver;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc("This map stores a copy of the options the were set for loading the resource.");
		sc.add("private " + MAP(sc) + "<Object, Object> options;");
		sc.addLineBreak();
		
    	List<String> generatedResolvers = new ArrayList<String>();

		for (GenFeature proxyReference : nonContainmentReferencesNeedingResolvers) {
			String generatedClassName = nameUtil.getReferenceResolverClassName(proxyReference);
			if (!generatedResolvers.contains(generatedClassName)) {
				generatedResolvers.add(generatedClassName);
				String fullClassName = getContext().getQualifiedReferenceResolverClassName(proxyReference, false);
				sc.add("protected " + fullClassName + " " + StringUtil.low(generatedClassName) + " = new " + fullClassName + "();");			
			}
		}
	    sc.addLineBreak();
	}

	private void generateGetMethods(StringComposite sc) {
    	List<String> generatedResolvers = new ArrayList<String>();

		for (GenFeature proxyReference : nonContainmentReferencesNeedingResolvers) {
			String generatedClassName = nameUtil.getReferenceResolverClassName(proxyReference);
			if (!generatedResolvers.contains(generatedClassName)) {
				generatedResolvers.add(generatedClassName);
				
				String containerClassName = genClassCache.getQualifiedInterfaceName(proxyReference
						.getGenClass());
				String referenceTypeClassName = genClassCache.getQualifiedInterfaceName(proxyReference
						.getTypeGenClass());
				String featureAccessor = new GenClassUtil().getAccessor(proxyReference);

				//String fullClassName = getContext().getQualifiedReferenceResolverClassName(proxyReference, false);
				sc.add("public " + iReferenceResolverClassName + "<" + containerClassName + ", " + referenceTypeClassName + "> get" + generatedClassName + "() {");
				sc.add("return getResolverChain(" + featureAccessor + ", " + StringUtil.low(generatedClassName) + ");");			
				sc.add("}");
			    sc.addLineBreak();
			}
		}
	}
}
