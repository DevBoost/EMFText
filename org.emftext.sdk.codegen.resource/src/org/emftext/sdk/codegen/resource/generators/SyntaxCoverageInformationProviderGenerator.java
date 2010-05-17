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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.util.GenClassUtil;

public class SyntaxCoverageInformationProviderGenerator extends JavaBaseGenerator<Object> {

	private final GenClassUtil genClassUtil = new GenClassUtil();

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new SyntaxCoverageInformationProviderGenerator());

	private SyntaxCoverageInformationProviderGenerator() {
		super();
	}

	private SyntaxCoverageInformationProviderGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.SYNTAX_COVERAGE_INFORMATION_PROVIDER);
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " {");
        sc.addLineBreak();
		addGetClassesWithSyntaxMethod(sc);
		addGetStartSymbolsMethod(sc);
		sc.add("}");
	}

	private void addGetClassesWithSyntaxMethod(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		
		Collection<GenClass> classesWithSyntax = syntax.getClassesWithSyntax(false);
		sc.add("public " + E_CLASS + "[] getClassesWithSyntax() {");
		sc.add("return new " + E_CLASS + "[] {");
		for (GenClass classWithSyntax : classesWithSyntax) {
			sc.add(genClassUtil.getAccessor(classWithSyntax) + ",");
		}
		sc.add("};");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetStartSymbolsMethod(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		
		Collection<GenClass> startSymbols = syntax.getActiveStartSymbols();
		sc.add("public " + E_CLASS + "[] getStartSymbols() {");
		sc.add("return new " + E_CLASS + "[] {");
		for (GenClass startSymbol : startSymbols) {
			sc.add(genClassUtil.getAccessor(startSymbol) + ",");
		}
		sc.add("};");
		sc.add("}");
        sc.addLineBreak();
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new SyntaxCoverageInformationProviderGenerator(parent, context);
	}
}
