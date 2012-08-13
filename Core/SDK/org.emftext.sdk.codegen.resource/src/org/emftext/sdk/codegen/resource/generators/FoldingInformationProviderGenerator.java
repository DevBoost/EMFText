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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.util.GenClassUtil;

@SyntaxDependent
public class FoldingInformationProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final GenClassUtil genClassUtil = new GenClassUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " {");
        sc.addLineBreak();
        addGetFoldableClassesMethod(sc);
		sc.add("}");
	}

	private void addGetFoldableClassesMethod(StringComposite sc) {
		sc.add("public " + E_CLASS + "[] getFoldableClasses() {");
		
		List<GenClass> foldableClasses = new ArrayList<GenClass>();
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		for (Rule rule : syntax.getAllRules()) {
			for (Annotation annotation : rule.getAnnotations()) {
				if (AnnotationType.FOLDABLE == annotation.getType()) {
					// found rule for foldable class
					foldableClasses.add(rule.getMetaclass());
				}
			}
		}
		sc.add("return new " + E_CLASS + "[] {");
		for (GenClass foldableClass : foldableClasses) {
			sc.add(genClassUtil.getAccessor(foldableClass) + ",");
		}
		sc.add("};");
		sc.add("}");
		sc.addLineBreak();
	}
}
