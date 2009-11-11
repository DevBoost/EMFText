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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;

import java.io.PrintWriter;
import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.util.ConcreteSyntaxUtil;
import org.emftext.sdk.codegen.util.GenClassUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class SyntaxCoverageInformationProviderGenerator extends JavaBaseGenerator {

	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private final GenClassUtil genClassUtil = new GenClassUtil();

	public SyntaxCoverageInformationProviderGenerator() {
		super();
	}

	public SyntaxCoverageInformationProviderGenerator(GenerationContext context) {
		super(context, EArtifact.SYNTAX_COVERAGE_INFORMATION_PROVIDER);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " {");
        sc.addLineBreak();
		addGetClassesWithSyntaxMethod(sc);
		addGetStartSymbolsMethod(sc);
		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

	private void addGetClassesWithSyntaxMethod(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		
		Collection<GenClass> classesWithSyntax = csUtil.getClassesWithSyntax(syntax);
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

	public IGenerator newInstance(GenerationContext context) {
		return new SyntaxCoverageInformationProviderGenerator(context);
	}
}
