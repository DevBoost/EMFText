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
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.util.StringUtil;

/**
 * A generator that creates a multiplexing reference resolver.
 * Depending on the type of the reference that must be resolved,
 * the generated class delegates the resolve call to the appropriate
 * reference resolver.
 */
public class ReferenceResolverSwitchGenerator extends JavaBaseGenerator {
	
	private final GeneratorUtil generatorUtil = new GeneratorUtil();
	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	
	private GenClassCache genClassCache;
	private Collection<GenFeature> nonContainmentReferencesNeedingResolvers;

	public ReferenceResolverSwitchGenerator() {
		super();
	}

	private ReferenceResolverSwitchGenerator(GenerationContext context) {
		super(context, EArtifact.REFERENCE_RESOLVER_SWITCH);
		ConcreteSyntax syntax = context.getConcreteSyntax();
		this.genClassCache = syntax.getGenClassCache();
		this.nonContainmentReferencesNeedingResolvers = csUtil.getNonContainmentFeaturesNeedingResolver(syntax);
	}
	
	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		generateReferenceResolverSwitch(sc);
		return true;
	}
	
	 /**
     * Generates the reference resolver switch that calls the correct
     * reference resolvers generated by <code>generateReferenceResolver()</code>.
	 * @param sc 
     */
    private void generateReferenceResolverSwitch(StringComposite sc)  {  
    	
        sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iReferenceResolverSwitchClassName + " {");
        sc.addLineBreak();
		
		generateFields(sc);
		generateGetMethods(sc);
        generateSetOptionsMethod(sc);
		generateResolveFuzzyMethod(sc);
		addGetResolverMethod(sc);
		
		sc.add("}");
    }

	private void generateResolveFuzzyMethod(StringComposite sc) {
		String qualifiedFuzzyResolveResultClassName = getContext().getClassName(EArtifact.FUZZY_RESOLVE_RESULT);
		
		sc.add("public void resolveFuzzy(" + STRING + " identifier, " + E_OBJECT + " container, " + E_REFERENCE + " reference, int position, " + iReferenceResolveResultClassName + "<" + E_OBJECT + "> result) {");
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
			String generatedClassName = csUtil.getReferenceResolverClassName(proxyReference);
			GenFeature genFeature = generatorUtil.findGenFeature(genClass, proxyReference.getName());
			
			sc.add("if (" + accessorName + ".isInstance(container)) {");
			sc.add(qualifiedFuzzyResolveResultClassName + "<" + genClassCache.getQualifiedInterfaceName(genFeature.getTypeGenClass()) + "> frr = new " + qualifiedFuzzyResolveResultClassName + "<" + genClassCache.getQualifiedInterfaceName(genFeature.getTypeGenClass()) + ">(result);");
			sc.add(STRING + " referenceName = reference.getName();");
			sc.add(E_STRUCTURAL_FEATURE + " feature = container.eClass().getEStructuralFeature(referenceName);");
			sc.add("if (feature != null && feature instanceof " + E_REFERENCE + " && referenceName != null && referenceName.equals(\"" + StringUtil.escapeToJavaString(proxyReference.getName()) + "\")) {");
			sc.add(StringUtil.low(generatedClassName) + ".resolve(identifier, (" + genClassCache.getQualifiedInterfaceName(genClass) + ") container, (" + E_REFERENCE + ") feature, position, true, frr);");
			sc.add("}");
			sc.add("}");
		}
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateSetOptionsMethod(StringComposite sc) {
		sc.add("public void setOptions(" + MAP + "<?, ?> options) {");
		for (GenFeature proxyReference : nonContainmentReferencesNeedingResolvers) {
			String generatedClassName = csUtil.getReferenceResolverClassName(proxyReference);
			sc.add(StringUtil.low(generatedClassName) + ".setOptions(options);");			
		}
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResolverMethod(StringComposite sc) {
		sc.add("public " + iReferenceResolverClassName + " getResolver(" + E_STRUCTURAL_FEATURE + " reference) {");
		for (GenFeature proxyReference : nonContainmentReferencesNeedingResolvers) {
			String generatedClassName = csUtil.getReferenceResolverClassName(proxyReference);
			sc.add("if (reference == " + proxyReference.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + proxyReference.getFeatureAccessorName() + "()) {");
			sc.add("return " + StringUtil.low(generatedClassName) + ";");
			sc.add("}");
		}
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void generateFields(StringComposite sc) {
    	List<String> generatedResolvers = new ArrayList<String>();

		for (GenFeature proxyReference : nonContainmentReferencesNeedingResolvers) {
			String generatedClassName = csUtil.getReferenceResolverClassName(proxyReference);
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
			String generatedClassName = csUtil.getReferenceResolverClassName(proxyReference);
			if (!generatedResolvers.contains(generatedClassName)) {
				generatedResolvers.add(generatedClassName);
				String fullClassName = getContext().getQualifiedReferenceResolverClassName(proxyReference, false);
				sc.add("public " + fullClassName + " get" + generatedClassName + "() {");
				sc.add("return " + StringUtil.low(generatedClassName) + ";");			
				sc.add("}");
			    sc.addLineBreak();
			}
		}
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ReferenceResolverSwitchGenerator(context);
	}
}
